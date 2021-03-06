package com.xxy.entity.model;

import com.alibaba.fastjson.JSONObject;


import java.io.Serializable;
import java.util.Map;

/**
 * @author: <a href="mailto:lingxiao@2dfire.com">凌霄</a>
 * @time: Created in 下午10:37 2018/5/6
 * @desc http请求返回结果
 */


public class JsonResponse implements Serializable {

    private String  message;
    private boolean success;
    private Object  data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public JsonResponse(boolean success, String message) {
        this.message = message;
        this.success = success;
    }

    public JsonResponse(boolean success, Object data) {
        this.data = data;
        this.success = success;
    }

    public JsonResponse(String message, boolean success, Object data) {
        this.message = message;
        this.success = success;
        this.data = data;
    }
    public JsonResponse(boolean success, String message, Object data) {
        this.message = message;
        this.success = success;
        this.data = data;
    }

    public Map<String, Object> toMap() {
        return (Map<String, Object>) JSONObject.toJSON(this);
    }

}
