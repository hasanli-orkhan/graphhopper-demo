package info.md7.graphhopperdemo.handler;

import com.graphhopper.util.exceptions.PointDistanceExceededException;
import com.graphhopper.util.exceptions.PointNotFoundException;
import com.graphhopper.util.exceptions.PointOutOfBoundsException;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.UNPROCESSABLE_ENTITY.value(),
                "Validatiion problem");
        if (CollectionUtils.isNotEmpty(ex.getBindingResult().getAllErrors())) {
            ex.getBindingResult().getAllErrors().forEach(
                    error -> {
                        String fieldName = error.getObjectName();
                        String errorText = error.getDefaultMessage();
                        errorMessage.addValidationError(fieldName, errorText);
                    });
        }
        return ResponseEntity.unprocessableEntity().body(errorMessage);
    }

    @ExceptionHandler(PointNotFoundException.class)
    public ResponseEntity<ErrorMessage> handlePointNotFoundException(PointNotFoundException ex) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST.value(),
                ex.getMessage());
        return ResponseEntity.badRequest().body(errorMessage);
    }

    @ExceptionHandler(PointOutOfBoundsException.class)
    public ResponseEntity<ErrorMessage> handlePointOutOfBoundsException(PointOutOfBoundsException ex) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST.value(),
                ex.getMessage());
        return ResponseEntity.badRequest().body(errorMessage);
    }

    @ExceptionHandler(PointDistanceExceededException.class)
    public ResponseEntity<ErrorMessage> handlePointDistanceExceededException(PointDistanceExceededException ex) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST.value(),
                ex.getMessage());
        return ResponseEntity.badRequest().body(errorMessage);
    }


    @ExceptionHandler(UnsupportedOperationException.class)
    public ResponseEntity<ErrorMessage> handleUnsupportedOperationExceptions(UnsupportedOperationException ex) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return ResponseEntity.badRequest().body(errorMessage);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorMessage>
    handleRuntimeExceptions(RuntimeException ex) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                ex.getMessage());
        return ResponseEntity.internalServerError().body(errorMessage);
    }

}
