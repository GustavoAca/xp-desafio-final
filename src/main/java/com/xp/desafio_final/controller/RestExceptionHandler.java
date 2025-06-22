package com.xp.desafio_final.controller;

import com.xp.desafio_final.core.exception.XpException;
import org.hibernate.PersistentObjectException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class RestExceptionHandler {
    protected RestExceptionHandler() {
    }

    @ExceptionHandler({XpException.class})
    public ProblemDetail handleListaException(XpException e) {
        return e.toProblemDetail();
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ProblemDetail handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<InvalidParam> fieldErros = e.getFieldErrors().stream().map((f) -> new InvalidParam(f.getField(), f.getDefaultMessage())).toList();
        ProblemDetail pb = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        pb.setTitle("Parametros da requisição não estão validados");
        pb.setProperty("invalid-params", fieldErros);
        return pb;
    }

    @ExceptionHandler({PersistentObjectException.class})
    public ProblemDetail handlePersistentObjectException(PersistentObjectException e) {
        ProblemDetail pb = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        pb.setTitle("Erro ao persistir dados");
        return pb;
    }

    @ExceptionHandler({HttpMessageNotReadableException.class})
    public ProblemDetail handlerCannotDeserialize(HttpMessageNotReadableException e) {
        ProblemDetail pb = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
        pb.setTitle("Erro ao deserializar UUID");
        pb.setDetail(e.getMessage());
        return pb;
    }

    @ExceptionHandler({ClassCastException.class})
    public ProblemDetail castCannotParse(ClassCastException e) {
        ProblemDetail pb = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        pb.setTitle("Erro ao trasformar objeto");
        pb.setDetail(e.getMessage());
        return pb;
    }

    @ExceptionHandler({Throwable.class})
    public ProblemDetail sqlException(Throwable e) {
        ProblemDetail pb = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        pb.setTitle("Erro");
        pb.setDetail(e.getMessage());
        return pb;
    }

    private static record InvalidParam(String fieldName, String reason) {
        private InvalidParam(String fieldName, String reason) {
            this.fieldName = fieldName;
            this.reason = reason;
        }

        public String fieldName() {
            return this.fieldName;
        }

        public String reason() {
            return this.reason;
        }
    }
}
