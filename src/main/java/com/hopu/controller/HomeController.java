package com.hopu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {


    /***
     * 系统首页模块
     * @return
     */
    @RequestMapping("/home.action")
    public String login() {

        return "login";
    }

    /***
     * 登录到后台
     * @return
     */
    @RequestMapping(value = "/fmain.action")
    public String fmain() {
        return "/home/fmain";
    }

    @RequestMapping(value = "/title.action")
    public String title() {
        return "/home/title";
    }

    @RequestMapping(value = "/left.action")
    public String left() {
        return "/home/left";
    }

    /***
     * 首页转向留言板
     * @return
     */
    @RequestMapping(value = "/main.action")
    public String main() {
        return "/home/olmsgList";
    }

    /***
     * 系统管理模块
     * @return
     */
    @RequestMapping("/sysadminMain.action")
    public String sysadminMain() {
        return "/sysadmin/main";
    }

    @RequestMapping("/sysadminLeft.action")
    public String sysadminLeft() {
        return "/sysadmin/left";
    }

    /***
     * 基础信息模块
     * @return
     */
    @RequestMapping("/baseinfoMain.action")
    public String baseinfoMain() {
        return "/baseinfo/main";
    }

    @RequestMapping("/baseinfoLeft.action")
    public String baseinfoLeft() {
        return "/baseinfo/left";
    }

    /***
     * 货运管理模块
     * @return
     */
    @RequestMapping("/cargoMain.action")
    public String cargoMain() {
        return "/cargo/main";
    }

    @RequestMapping("/cargoLeft.action")
    public String cargoLeft() {
        return "/cargo/left";
    }

    @RequestMapping("/jFactoryCreate.action")
    public String jFactoryCreate() {
        return "basicinfo/factory/jFactoryCreate";
    }
}
