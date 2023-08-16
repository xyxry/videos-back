package com.xy.videosback.util;

import com.xy.videosback.enums.ResponseStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseResult<T> {
    /**
     * 消息码, 200 -> OK.
     */
    private Integer code;

    /**
     * 消息.
     */
    private String message;

    /**
     * 返回数据.
     */
    private T data;
    public ResponseResult() {
    }
    public ResponseResult( T data) {
        this.data = data;
    }
    public ResponseResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    public ResponseResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    //成功返回
    public static <T>ResponseResult<T> success(){
        ResponseResult<T> tResponseResult = new ResponseResult<T>();
        return ResponseResult.<T>builder()
                .message(ResponseStatus.STATUS_200.message())
                .code(ResponseStatus.STATUS_200.code())
                .build();
    }
    //成功 数据
    public static <T>ResponseResult<T> success(T data){
        ResponseResult<T> tResponseResult = new ResponseResult<T>();
        return ResponseResult.<T>builder()
                .message(ResponseStatus.STATUS_200.message())
                .code(ResponseStatus.STATUS_200.code())
                .data(data)
                .build();
    }
    //成功 数据
    public static <T>ResponseResult<T> success(String message){
        ResponseResult<T> tResponseResult = new ResponseResult<T>();
        return ResponseResult.<T>builder()
                .message(message)
                .code(ResponseStatus.STATUS_200.code())
                .build();
    }
    //成功 数据
    public static <T>ResponseResult<T> success(T data,String message){
        ResponseResult<T> tResponseResult = new ResponseResult<T>();
        return ResponseResult.<T>builder()
                .message(message)
                .code(ResponseStatus.STATUS_200.code())
                .data(data)
                .build();
    }
    //错误
    public static <T>ResponseResult<T> fail(Integer code, String message){
        ResponseResult<T> tResponseResult = new ResponseResult<T>();
        return ResponseResult.<T>builder()
                .message(message)
                .code(code)
                .build();
    }
    //错误
    public static <T>ResponseResult<T> fail(String message){
        ResponseResult<T> tResponseResult = new ResponseResult<T>();
        return ResponseResult.<T>builder()
                .message(message)
                .code(ResponseStatus.STATUS_500.code())
                .build();
    }
}
