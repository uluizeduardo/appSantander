package com.project.appSantander.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

//Objeto de transferência de dados (Data transfer object)
public class StockDTO {

    private Long id;

    @NotNull //Não aceita null
    private String name;

    @NotNull //Não aceita null
    @DecimalMin(value = "0.00") //Não aceita número nenor que zero
    @Digits(integer = 6, fraction = 2) //Número inteiro no máximo 6 digitos e com 2 frações (999999,99)
    private Double price;

    @NotNull //Não aceita null
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy") //Formatar o date em padrão brasileiro
    private LocalDate date;

    @NotNull //Não aceita null
    @Digits(integer = 3, fraction = 2) //Número inteiro no máximo 3 digitos e com 2 frações (999,99)
    private Double variation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getVariation() {
        return variation;
    }

    public void setVariation(Double variation) {
        this.variation = variation;
    }
}
