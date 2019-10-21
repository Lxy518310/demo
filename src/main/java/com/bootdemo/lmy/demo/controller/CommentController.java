package com.bootdemo.lmy.demo.controller;

import com.bootdemo.lmy.demo.dto.CommentDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 李
 * @create 2019/10/21 23:04
 */
@Controller
public class CommentController {

    @RequestMapping("/comment")
    public Object post(@RequestBody CommentDTO commentDTO){

        return null;
    }
}
