package scut.yulin.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.yaml.snakeyaml.constructor.DuplicateKeyException;
import scut.yulin.common.vo.ResponseVO;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * 全局异常处理
 */
@Slf4j
@RestControllerAdvice(basePackages = "scut.yulin.admin.controller")
public class GlobalExcepitonHandler {
    private static Logger logger = LoggerFactory.getLogger(GlobalExcepitonHandler.class);
    /**
     * 处理Assert的异常
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseVO handler(IllegalArgumentException e) throws IOException {
        log.error("Assert异常:-------------->{}",e.getMessage());
        return ResponseVO.failed(e.getMessage());
    }
    /**
     * @Validated 校验错误异常处理
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseVO handler(MethodArgumentNotValidException e) throws IOException {
        log.error("运行时异常|校验错误异常处理:-------------->",e);
        BindingResult bindingResponseVO = e.getBindingResult();
        ObjectError objectError = bindingResponseVO.getAllErrors().stream().findFirst().get();
        return ResponseVO.failed(objectError.getDefaultMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseVO handler(RuntimeException e) throws IOException {
        log.error("运行时异常:-------------->",e);
        return ResponseVO.failed(e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = SQLIntegrityConstraintViolationException.class)
    public ResponseVO handler(SQLIntegrityConstraintViolationException e) throws IOException{
        log.error("运行时异常|数据库插入重复name数据:-------------->",e);
        return ResponseVO.failed(e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = DuplicateKeyException.class)
    public ResponseVO handler(DuplicateKeyException e) throws IOException{
        logger.error("运行时异常|数据库插入重复name数据:-------------->",e);
        return ResponseVO.failed(e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseVO handle(MethodArgumentNotValidException e) {
        FieldError fieldError = e.getBindingResult().getFieldError();
        logger.error("运行时异常|校验失败:-------------->",e);
        assert fieldError != null;
        return ResponseVO.failed(fieldError.getDefaultMessage());
    }

}
