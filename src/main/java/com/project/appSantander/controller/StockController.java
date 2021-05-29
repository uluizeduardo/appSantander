package com.project.appSantander.controller;

import com.project.appSantander.model.dto.StockDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/stock")
public class StockController {

    //Inserir/salvar dados (Save)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> save(@Valid @RequestBody StockDTO dto){
        return ResponseEntity.ok(dto);
    }

    //Alteração dos dados (update)
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> update(@Valid @RequestBody StockDTO dto){
        return ResponseEntity.ok(dto);
    }

    //Pegar todos os dados da lista
    @GetMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StockDTO>> findAll(){
        List<StockDTO> list = new ArrayList<>();
        StockDTO dto = new StockDTO();
        dto.setId(1L);
        dto.setName("Submarino");
        dto.setPrice(100D);
        dto.setVariation(10D);
        dto.setDate(LocalDate.now());
        list.add(dto);
        return ResponseEntity.ok(list);
    }
    //Pesquisar pelo id
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> findById(@PathVariable Long id){
        //Criando lista
        List<StockDTO> list = new ArrayList<>();
        StockDTO stock1 = new StockDTO();
        //adicionando o primeiro item na lista
        stock1.setId(2L);
        stock1.setName("Magazine Luiza");
        stock1.setPrice(100D);
        stock1.setVariation(10D);
        stock1.setDate(LocalDate.now());
        //adicionando o segundo item na lista
        StockDTO stock2 = new StockDTO();
        stock2.setId(3L);
        stock2.setName("Ponto Frio");
        stock2.setPrice(200D);
        stock2.setVariation(5D);
        stock2.setDate(LocalDate.now());

        list.add(stock1);
        list.add(stock2);

        //Expressão lambda para Percorrer lista para validar pesquisa
        StockDTO dtoSelect = list.stream().filter(x -> x.getId().compareTo(id) == 0).findFirst().get();
        return ResponseEntity.ok(dtoSelect);
    }
}
