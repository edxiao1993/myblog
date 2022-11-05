package org.kevin.demo0212.common;

import lombok.Data;

/**
 * RuntimeException 是不用显式捕捉的异常～
 *
 * @author Kevin.Z
 * @version 2020-03-20
 */
@Data
public class MyException extends RuntimeException {
    private int code;

    public MyException(int code, String message){
        super(message);
        this.code = code;
    }

    public MyException(String message){
        super(message);
        this.code = 999;
    }
}
