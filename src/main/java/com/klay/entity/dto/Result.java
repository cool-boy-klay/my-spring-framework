package com.klay.entity.dto;

public class Result<T> {
    //请求结果状态码
    private int code;

    //本次请求结果
    private String msg;

    //本次请求返回结果集
    private T data;
}
