package org.kevin.demo0212.controller;

import org.kevin.demo0212.common.MyException;
import org.kevin.demo0212.model.dto.ResultData;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * @author Kevin.Z
 * @version 2020-03-19
 */
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(IOException.class)
    public String ioException(){
        System.out.println("in IOException");
        return "error";
    }

    @ExceptionHandler(IndexOutOfBoundsException.class)
    public String indexOutOfBoundsException(){
        System.out.println("Index Out Of Bounds Exception");
        return "error";
    }

    @ExceptionHandler(MyException.class)
    @ResponseBody
    public ResultData handleMyException(MyException e){
        e.printStackTrace();
        ResultData rd = new ResultData();
        rd.setMsg(e.getMessage());
        rd.setCode(e.getCode());
        return rd;
    }

//    @ExceptionHandler(Exception.class)
//    public String handleException(){
//        System.err.println("Exception Error");
//        return "error";
//    }
}
