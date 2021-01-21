package com.huilong.model.vo;

/**
 * 返回结果集
 *
 * @author daocr
 * @date 2021/1/21
 */
public class R<T> {

    private final T data;

    private final Integer code;

    private final String msg;


    private static final int SUCCESS_CODE = 200;

    private static final int FAILURE_CODE = 500;

    private static final String SUCCESS_MSG = "操作成功";

    private static final String FAILURE_MSG = "操作失败";

    private R(T data, Integer code, String msg) {
        this.data = data;
        this.code = code;
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }


    public static <OUT> R<OUT> success() {
        return new R<>(null, SUCCESS_CODE, SUCCESS_MSG);
    }

    public static <OUT> R<OUT> success(OUT data) {
        return new R<>(data, SUCCESS_CODE, SUCCESS_MSG);
    }


    public static <OUT> R<OUT> success(OUT data, Integer code) {
        return new R<>(data, code, SUCCESS_MSG);
    }

    public static <OUT> R<OUT> success(OUT data, Integer code, String msg) {
        return new R<>(data, code, msg);
    }

    public static <OUT> R<OUT> failure() {
        return new R<>(null, FAILURE_CODE, FAILURE_MSG);
    }

    public static <OUT> R<OUT> failure(OUT data) {
        return new R<>(data, FAILURE_CODE, FAILURE_MSG);
    }

    public static <OUT> R<OUT> failure(String msg) {
        return new R<>(null, FAILURE_CODE, msg);
    }

    public static <OUT> R<OUT> failure(OUT data, Integer code) {
        return new R<>(data, code, FAILURE_MSG);
    }

    public static <OUT> R<OUT> failure(OUT data, String msg) {
        return new R<>(data, FAILURE_CODE, msg);
    }

    public static <OUT> R<OUT> failure(OUT data, Integer code, String msg) {
        return new R<>(data, code, msg);
    }


}
