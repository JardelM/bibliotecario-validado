package com.compass.biblioteca.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErroValidacaoDto {

    private String campo;
    private String erro;
}