package com.microservicos.estoquepreco.controller;


import com.microservicos.estoquepreco.service.RabbitmqService;
import constantes.RabbitMQConstantes;
import dto.EstoqueDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "estoque")
public class EstoqueController {
    @Autowired
    private RabbitmqService rabbitmqService;
   @PutMapping
    private ResponseEntity alteraEstoque(@RequestBody EstoqueDto estoqueDto){
       this.rabbitmqService.enviaMesagem(RabbitMQConstantes.FILA_ESTOQUE, estoqueDto);
       return new ResponseEntity(HttpStatus.OK);
  }
}
