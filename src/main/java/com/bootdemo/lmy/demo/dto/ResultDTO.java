package com.bootdemo.lmy.demo.dto;

import com.bootdemo.lmy.demo.exception.CustomizeErrorCode;
import com.bootdemo.lmy.demo.exception.CustomizeException;
import lombok.Data;

import java.util.List;

/**
 * @author 李
 * @create 2019/10/23 21:11
 */
@Data
public class ResultDTO<T> {
    private Integer code;
    private String message;
    private T data;

    public static ResultDTO errorof(Integer code,String message){
        ResultDTO resultDTO=new ResultDTO();
        resultDTO.setCode(code);
        resultDTO.setMessage(message);
        return resultDTO;
    }

    public static ResultDTO errorof(CustomizeErrorCode customizeErrorCode) {
        ResultDTO resultDTO=new ResultDTO();
        resultDTO.setCode(customizeErrorCode.getCode());
        resultDTO.setMessage(customizeErrorCode.getMessage());
        return resultDTO;
    }

    public static ResultDTO errorof(CustomizeException customizeException) {
        ResultDTO resultDTO=new ResultDTO();
        resultDTO.setCode(customizeException.getCode());
        resultDTO.setMessage(customizeException.getMessage());
        return resultDTO;
    }

    public static ResultDTO okOf(){
        ResultDTO resultDTO=new ResultDTO();
        resultDTO.setCode(200);
        resultDTO.setMessage("登陆成功");
        return resultDTO;
    }

    public static <T> ResultDTO okOf(T t){
        ResultDTO resultDTO=new ResultDTO();
        resultDTO.setCode(200);
        resultDTO.setMessage("登陆成功");
        resultDTO.setData(t);
        return resultDTO;
    }
}
