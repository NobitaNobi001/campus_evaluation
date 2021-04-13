package com.design.cloud.common.result;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ezuy
 * @date 21/4/8 12:48
 */
@Data
public class Result {

    /**
     * 0为成功 -1为失败
     */
    private Integer code;

    private String message;

    private Map<String, Object> data = new HashMap<>();

    /**
     * 构造函数私有化
     */
    private Result() {
    }

    /**
     * 返回成功结果
     *
     * @return
     */
    public static Result success() {
        Result result = new Result();
        result.setCode(ResponseEnum.SUCCESS.getCode());
        result.setMessage(ResponseEnum.SUCCESS.getMessage());
        return result;
    }

    /**
     * 返回失败结果
     *
     * @return
     */
    public static Result fail() {
        Result result = new Result();
        result.setCode(ResponseEnum.ERROR.getCode());
        result.setMessage(ResponseEnum.ERROR.getMessage());
        return result;
    }

    /**
     * 设置特定的结果
     *
     * @param responseEnum
     * @return
     */
    public static Result setResult(ResponseEnum responseEnum) {
        Result result = new Result();
        result.setCode(responseEnum.getCode());
        result.setMessage(responseEnum.getMessage());
        return result;
    }

    /**
     * 设置返回的数据
     *
     * @param key
     * @param value
     * @return
     */
    public Result data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    public Result data(Map<String, Object> map) {
        this.setData(map);
        return this;
    }

    /**
     * 设置特定消息
     *
     * @param message
     * @return
     */
    public Result message(String message) {
        this.setMessage(message);
        return this;
    }

    /**
     * 设置特定响应码
     *
     * @param code
     * @return
     */
    public Result code(Integer code) {
        this.setCode(code);
        return this;
    }
}
