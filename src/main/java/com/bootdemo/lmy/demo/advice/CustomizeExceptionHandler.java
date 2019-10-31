package com.bootdemo.lmy.demo.advice;

import com.alibaba.fastjson.JSON;
import com.bootdemo.lmy.demo.dto.ResultDTO;
import com.bootdemo.lmy.demo.exception.CustomizeErrorCode;
import com.bootdemo.lmy.demo.exception.CustomizeException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 李
 * @create 2019/10/14 22:31
 */
@ControllerAdvice
public class CustomizeExceptionHandler {
    @ExceptionHandler(Exception.class)
    ModelAndView handle(Throwable ex, Model model,
                        HttpServletRequest request,HttpServletResponse response) {
        String contentType=request.getContentType();
        if("application/json".equals(contentType)){
            ResultDTO resultDTO=null;
            if(ex instanceof CustomizeException){
                resultDTO=ResultDTO.errorof((CustomizeException) ex);
            }else{
                resultDTO=ResultDTO.errorof(CustomizeErrorCode.SYS_ERROR);
            }
            try{
                response.setContentType("application/json");
                response.setStatus(200);
                response.setCharacterEncoding("UTF-8");
                PrintWriter printWriter=response.getWriter();
                printWriter.write(JSON.toJSONString(resultDTO));
                printWriter.close();
            }catch (IOException es){

            }
            return null;
        }else{
            if(ex instanceof CustomizeException){
                model.addAttribute("message",ex.getMessage());
            }else{
                model.addAttribute("message","服务太热了,要不然稍等下再来试试");
            }
        }
        return new ModelAndView();
    }
}
