package airtribe.smartParking.Exception;

import airtribe.smartParking.Bean.ResponseBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResponseBean> handleResourceNotFoundException(ResourceNotFoundException ex) {
        LOGGER.error("Resource not found: {}", ex.getMessage(), ex);
        ResponseBean responseBean = new ResponseBean("ERROR", ex.getMessage(), null);
        return new ResponseEntity<>(responseBean, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ResponseBean> handleRuntimeException(RuntimeException ex) {
        LOGGER.error("Exception: {}", ex.getMessage(), ex);
        ResponseBean responseBean = new ResponseBean("ERROR", ex.getMessage(), null);
        return new ResponseEntity<>(responseBean, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseBean> handleException(Exception ex) {
        LOGGER.error("Exception: {}", ex.getMessage(), ex);
        ResponseBean responseBean = new ResponseBean("ERROR", ex.getMessage(), null);
        return new ResponseEntity<>(responseBean, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
