package com.xy.videosback.enums;

import lombok.Data;

public enum ResponseStatus {
    STATUS_200(200,"成功"),
    STATUS_401(401,"未登录"),
    STATUS_500(500,"错误");
//    STATUS_200(200,"成功");
//    STATUS_200(200,"成功");
    /**
     * response code
     */
     final Integer code;

    /**
     * description.
     */
     final String message;

    ResponseStatus(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    public Integer code() {
        return this.code;
    }
    public String message() {
        return this.message;
    }
}
