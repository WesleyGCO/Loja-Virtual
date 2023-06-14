package com.castilho.backend.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.castilho.backend.exception.model.ErroValidacaoResposta;
import com.castilho.backend.exception.model.ErroValidacaoObjeto;

@RestControllerAdvice
public class RestValidationException extends ResponseEntityExceptionHandler{
    
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode statusCode, WebRequest request){
        //List<ErrorObject> erros = getErrors(ex);
        HttpStatus status = HttpStatus.valueOf(statusCode.value());

        ErroValidacaoResposta errorResponse = getErrorResponse(ex, status);
        
        return new ResponseEntity<>(errorResponse, status);
    }

    private ErroValidacaoResposta getErrorResponse(MethodArgumentNotValidException ex, HttpStatus status){
        return new ErroValidacaoResposta("A requisicao possui campos inválidos", status.value(), status.getReasonPhrase(), ex.getBindingResult().getObjectName(), getErrors(ex));
    }

    private List<ErroValidacaoObjeto> getErrors(MethodArgumentNotValidException ex){
        return ex.getBindingResult().getFieldErrors().stream().map(error -> new ErroValidacaoObjeto(error.getDefaultMessage(), error.getField(), error.getRejectedValue())).collect(Collectors.toList());
    }
}
