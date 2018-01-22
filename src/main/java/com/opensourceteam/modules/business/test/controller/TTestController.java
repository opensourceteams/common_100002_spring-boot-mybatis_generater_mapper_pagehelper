package com.opensourceteam.modules.business.test.controller;

import com.opensourceteam.modules.business.test.dao.TTestMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 开发人:刘文
 * 日期:  2017/11/25.
 * 功能描述:
 */
@Controller
@RequestMapping("/test")
public class TTestController {

    Logger logger = LoggerFactory.getLogger(TTestController.class);

    @Autowired
    TTestMapper tTestMapper ;


    @RequestMapping("/hello")
    String hello(String message) {
        logger.info("[/jsp/hello]测试/jsp/hello 信息  == 4");
        return "test/hello";
    }



    @RequestMapping("/count")
    String count(String message) {

        Integer count = tTestMapper.selectCount(null);
        logger.info("[/jsp/hello]测试/jsp/hello 信息  == 4 count:{}",count);

        return "test/count";
    }

    @RequestMapping("/countMessage")
    ModelAndView countMessage() {

        ModelAndView modelAndView = new ModelAndView("test/countMessage");

        Integer count = tTestMapper.selectCount(null);
        logger.info("[/jsp/hello]测试/jsp/hello 信息  == 4 count:{}",count);
        modelAndView.addObject("count",count);
        return modelAndView;
    }




}
