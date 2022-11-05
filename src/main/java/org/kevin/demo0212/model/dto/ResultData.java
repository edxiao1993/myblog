package org.kevin.demo0212.model.dto;

import lombok.Data;

/**
 * @author Kevin.Z
 * @version 2020-03-31
 */
@Data
public class ResultData<T> {
    private int code;
    private String msg;
    private T data;

    public ResultData(){}

    public ResultData(int code){
        this.code = code;
    }

    public ResultData(String msg){
        this.msg = msg;
    }

    public ResultData(int code, String msg){
        this.code = code;
        this.msg = msg;
    }
}
