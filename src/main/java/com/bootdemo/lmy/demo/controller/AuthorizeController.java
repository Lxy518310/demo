package com.bootdemo.lmy.demo.controller;

import com.bootdemo.lmy.demo.dto.AccessTokenDTO;
import com.bootdemo.lmy.demo.provider.GitHubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 李
 * @create 2019/9/25 23:18
 */

@Controller
public class AuthorizeController {

    @Autowired
    private GitHubProvider gitHubProvider;

    @GetMapping("callback")
    public String callback(@RequestParam(name="code")String code,
                           @RequestParam(name="state") String state){
        AccessTokenDTO accessTokenDTO=new AccessTokenDTO();
        accessTokenDTO.setClient_id("c3dee334071c1ff8bc12");
        accessTokenDTO.setClient_secret("4cb39b5f6b28e0154071f5743e829f91bd005a10");
        accessTokenDTO.setCode(code);
        accessTokenDTO.setState(state);
        accessTokenDTO.setRedirect_uri("http://localhost:8888/callback");

        gitHubProvider.getAccessToken(accessTokenDTO);
        return "index";
    }
}
