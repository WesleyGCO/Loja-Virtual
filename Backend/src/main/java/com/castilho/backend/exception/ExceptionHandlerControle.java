package com.castilho.backend.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.castilho.backend.exception.model.ErroValidacaoObjeto;
import com.castilho.backend.exception.model.ErroValidacaoResposta;

@ControllerAdvice
public class ExceptionHandlerControle {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDataIntegrityViolation(DataIntegrityViolationException ex) {

        System.out.println(ex.getMostSpecificCause());
        if (ex.getMostSpecificCause().toString().contains("FOREIGN KEY")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Não foi possível excluir, houve uma violação de chave estrangeira.");
        } else if (ex.getMostSpecificCause().toString().contains("PRIMARY KEY")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Não foi possível excluir, houve uma violação de chave primária detectada.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Não foi possível excluir, houve uma violação de integridade detectada.");
        }
    }

    /*@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroValidacaoResposta> handleValidationException(MethodArgumentNotValidException ex){
        
        // Extrair os erros de validacao
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();

        // Montar a lista de erros personalizados
        List<ErroValidacaoObjeto> erros = new ArrayList<>();
        for(FieldError fieldError : fieldErrors){
            ErroValidacaoObjeto erroValidacao = new ErroValidacaoObjeto(
                fieldError.getDefaultMessage(), fieldError.getField(), fieldError.getRejectedValue());
            erros.add(erroValidacao);
        }

        ErroValidacaoResposta errorResponse = new ErroValidacaoResposta(
            "Erro de validação", 400, "Bad Request", ex.getObjectName(), erros);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }*/
}
