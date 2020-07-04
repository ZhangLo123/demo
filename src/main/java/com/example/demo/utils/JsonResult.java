package com.example.demo.utils;


public class JsonResult<T> {
    private T data;
    private String msg;
    private Integer status;

    public JsonResult(T data) {
        this.data = data;
    }

    public JsonResult( String msg,Integer status) {
        this.msg = msg;
        this.status = status;
    }

    public JsonResult(T data,String msg,Integer status) {
        this.data = data;
        this.msg = msg;
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "JsonResult{" +
                "data=" + data +
                ", msg='" + msg + '\'' +
                ", status=" + status +
                '}';
    }
}
