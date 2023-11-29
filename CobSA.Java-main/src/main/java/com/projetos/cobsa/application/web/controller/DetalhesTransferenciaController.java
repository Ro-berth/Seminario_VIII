package com.projetos.cobsa.application.web.controller;

import com.projetos.cobsa.domain.service.DetalhesTransferenciaService;
import com.projetos.cobsa.domain.entity.DetalhesTransferencia;
import com.projetos.cobsa.application.dto.DetalhesTransferenciaDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfer-details")
public class DetalhesTransferenciaController {

    private final DetalhesTransferenciaService detalhesTransferenciaService;

    @Autowired
    public DetalhesTransferenciaController(DetalhesTransferenciaService detalhesTransferenciaService) {
        this.detalhesTransferenciaService = detalhesTransferenciaService;
    }

    private DetalhesTransferencia convertToEntity(DetalhesTransferenciaDTO detalhesTransferenciaDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(detalhesTransferenciaDTO, DetalhesTransferencia.class);
    }

    private DetalhesTransferenciaDTO convertToDto(DetalhesTransferencia detalhesTransferencia) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(detalhesTransferencia, DetalhesTransferenciaDTO.class);
    }

    @PostMapping
    public ResponseEntity<DetalhesTransferenciaDTO> saveTransferDetails(@RequestBody DetalhesTransferenciaDTO detalhesTransferenciaDTO) {
        DetalhesTransferencia detalhesTransferencia = convertToEntity(detalhesTransferenciaDTO);
        DetalhesTransferencia savedDetails = detalhesTransferenciaService.saveDetails(detalhesTransferencia);
        DetalhesTransferenciaDTO savedDetailsDTO = convertToDto(savedDetails);
        return new ResponseEntity<>(savedDetailsDTO, HttpStatus.CREATED);
    }

}
