package scut.yulin.common.exception;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.ParseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.yaml.snakeyaml.constructor.DuplicateKeyException;
import scut.yulin.common.vo.ResponseVO;

/**
 * 全局异常处理
 */
@Slf4j
@RestControllerAdvice
public class GlobalExcepitonHandler {

  /**
   * 处理Assert的异常
   */
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(value = IllegalArgumentException.class)
  public ResponseVO handler(IllegalArgumentException e) throws IOException {
    log.error("Assert异常:-------------->{}", e.getMessage());
    return ResponseVO.failed(e.getMessage());
  }

  /**
   * @Validated 校验错误异常处理
   */
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(value = MethodArgumentNotValidException.class)
  public ResponseVO handler(MethodArgumentNotValidException e) throws IOException {
    log.error("运行时异常|校验错误异常处理:-------------->", e);
    BindingResult bindingResponseVO = e.getBindingResult();
    ObjectError objectError = bindingResponseVO.getAllErrors().stream().findFirst().get();
    return ResponseVO.failed(objectError.getDefaultMessage());
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(value = SQLIntegrityConstraintViolationException.class)
  public ResponseVO handler(SQLIntegrityConstraintViolationException e) throws IOException {
    log.error("运行时异常|数据库插入重复数据:-------------->", e);
    return ResponseVO.failed("运行时异常|数据库插入重复数据===>" + e.getMessage());
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(RuntimeException.class)
  public ResponseVO handler(RuntimeException e) throws IOException {
    log.error("运行时异常:-------------->", e);
//        StackTraceElement stackTraceElement = Arrays.stream(e.getStackTrace()).findFirst().get();
    return ResponseVO.failed("运行时异常:-------------->" + e.getCause().getMessage());
  }


  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(value = DuplicateKeyException.class)
  public ResponseVO handler(DuplicateKeyException e) throws IOException {
    log.error("运行时异常|数据库插入重复数据:-------------->", e);
    return ResponseVO.failed("运行时异常|数据库插入重复数据===>" + e.getMessage());
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(value =NullPointerException.class)
  public ResponseVO handler(NullPointerException e){
    log.error("发生空指针异常！原因是======>"+e.getMessage()+"\t"+e.getCause());
    return ResponseVO.failed(e.getMessage());
  }

  //ParseException
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(value = ParseException.class)
  public ResponseVO handler(ParseException e) throws IOException {
    log.error("数据解析出错:-------------->", e);
    return ResponseVO.failed("数据解析出错===>" + e.getMessage());
  }
}
