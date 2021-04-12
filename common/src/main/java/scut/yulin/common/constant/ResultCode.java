package scut.yulin.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResultCode {
    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    VALIDATE_FAILED(404, "参数检验失败"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    FORBIDDEN(403, "没有相关权限"),
    PARAM_ERROR(21000, "参数错误"),
    INSERT_FAILED(405,"MySQL插入数据失败"),
    UPDATE_FAILED(406,"MySQL更新数据失败")
    ;

    private int code;
    private String message;
}
