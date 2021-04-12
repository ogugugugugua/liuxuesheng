package scut.yulin.common.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import scut.yulin.common.constant.ResultCode;

@Data
@Builder
@AllArgsConstructor
public class ResponseVO<T> {
    /**
     * 状态码
     */
    private long code;
    /**
     * 提示信息
     */
    private String message;
    /**
     * 数据封装
     */
    private T data;
    
    /**
     * 成功返回结果
     * @param data 获取的数据
     * @param <T>
     * @return
     */
    public static <T> ResponseVO<T> success(T data) {
        return new ResponseVO<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    /**
     * 成功返回结果
     * @param data 获取的数据
     * @param message 消息
     * @param <T>
     * @return
     */
    public static <T> ResponseVO<T> success(T data, String message) {
        return new ResponseVO<T>(ResultCode.SUCCESS.getCode(), message, data);
    }

    /**
     * 成功返回结果
     * @param message 消息
     * @param <T>
     * @return
     */
    public static <T> ResponseVO<T> success(String message) {
        return new ResponseVO<T>(ResultCode.SUCCESS.getCode(), message, null);
    }

    /**
     * 失败返回结果
     * @param errorCode 错误码
     */
    public static <T> ResponseVO<T> failed(ResultCode errorCode, T data) {
        return new ResponseVO<T>(errorCode.getCode(), errorCode.getMessage(), data);
    }

    /**
     * 失败返回结果
     * @param errorCode 错误码
     */
    public static <T> ResponseVO<T> failed(ResultCode errorCode) {
        return new ResponseVO<T>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    /**
     * 失败返回结果
     * @param errorCode 错误码
     * @param message 错误信息
     */
    public static <T> ResponseVO<T> failed(ResultCode errorCode, String message) {
        return new ResponseVO<T>(errorCode.getCode(), message, null);
    }

    /**
     * 失败返回结果
     * @param message 提示信息
     */
    public static <T> ResponseVO<T> failed(String message) {
        return new ResponseVO<T>(ResultCode.FAILED.getCode(), message, null);
    }

    /**
     * 失败返回结果
     */
    public static <T> ResponseVO<T> failed() {
        return failed(ResultCode.FAILED);
    }

}
