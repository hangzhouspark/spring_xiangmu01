package com.hopu.controller;


import com.hopu.util.FileUtil;
import com.hopu.util.SqlDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.util.List;

@Controller
public class JfreechartController {

    @Resource
    private SqlDao sqlDao;

    /**
     * 饼状图
     *
     * @param request
     * @param model
     * @return
     * @throws FileNotFoundException
     */
    @RequestMapping("/factorySale.action")
    public String factorySale(HttpServletRequest request, Model model) throws FileNotFoundException {
        //真实路径
        String path = request.getSession().getServletContext().getRealPath("/");

        //1、组织数据源
        String sql = "SELECT f.factory_name,cp.countnum FROM (SELECT factory_id,factory_name FROM factory_c) f RIGHT JOIN (SELECT factory_id,COUNT(*) AS countnum FROM contract_product_c GROUP BY factory_id ) cp ON f.factory_id=cp.factory_id";
        List<String> dataList = sqlDao.executeSQL(sql);
        StringBuffer sBuf = new StringBuffer();
        sBuf.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        sBuf.append("<pie>");
        for (int i = 0; i < dataList.size(); ) {
            sBuf.append("  <slice title=\"").append(dataList.get(i++)).append("\">").append(dataList.get(i++)).append("</slice>");
        }
        sBuf.append("</pie>");
        FileUtil fu = new FileUtil();
        fu.createTxt(path + "/stat/chart/factorysale", "data.xml", sBuf.toString(), "utf-8");
        model.addAttribute("forward", "factorysale");
        return "basicinfo/stat/chart/jStat";
    }


    /**
     * 柱状图
     *
     * @param request
     * @param model
     * @return
     * @throws FileNotFoundException
     */
    @RequestMapping("/productSale.action")
    public String productSale(HttpServletRequest request, Model model) throws FileNotFoundException {
        String path = request.getSession().getServletContext().getRealPath("/");
        String sql = "select t.* from(select product_no,sum(cnumber) as sumnum from contract_product_c group by product_no order by sum(cnumber) desc) t where rownum<=15";
        List<String> dataList = sqlDao.executeSQL(sql);
        System.out.println(dataList.size());
        StringBuffer sBuf = new StringBuffer();
        sBuf.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        sBuf.append("<chart>");
        sBuf.append("<series>");
        int xid = 0;
        for (int i = 0; i < dataList.size(); ) {
            sBuf.append("<value xid=\"").append(xid++).append("\">").append(dataList.get(i++)).append("</value>");
            i++;        //skip
        }
        sBuf.append("</series>");
        sBuf.append("<graphs>");
        sBuf.append("<graph gid=\"30\" color=\"#FFCC00\" gradient_fill_colors=\"#111111, #1A897C\">");
        xid = 0;
        for (int i = 0; i < dataList.size(); ) {
            i++;        //skip
            sBuf.append("<value xid=\"").append(xid++).append("\">").append(dataList.get(i++)).append("</value>");
        }
        sBuf.append("</graph>");
        sBuf.append("</graphs>");
        sBuf.append("</chart>");
        FileUtil fu = new FileUtil();
        fu.createTxt(path + "/stat/chart/productsale", "data.xml", sBuf.toString(), "utf-8");
        model.addAttribute("forward", "productsale");
        return "basicinfo/stat/chart/jStat";

    }


}
