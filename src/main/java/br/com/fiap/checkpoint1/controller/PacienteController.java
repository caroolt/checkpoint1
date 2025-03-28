package br.com.fiap.checkpoint1.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.checkpoint1.dto.PacienteRequestCreateDTO;
import br.com.fiap.checkpoint1.dto.PacienteRequestUpdateDTO;
import br.com.fiap.checkpoint1.dto.PacienteResponseDTO;
import br.com.fiap.checkpoint1.service.PacienteService;

@RestController
@RequestMapping("pacientes")
public class PacienteController {
  
  @Autowired
  private PacienteService pacienteService;

  @PostMapping
  public ResponseEntity<PacienteResponseDTO> create (
    @RequestBody PacienteRequestCreateDTO dto) {
      
      return ResponseEntity.status(201).body(
      new PacienteResponseDTO().toDto(
        pacienteService.createPaciente(dto)
      )
    );
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    boolean result = pacienteService.deletePaciente(id);

    if(result) {
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<PacienteResponseDTO> 
    update(@PathVariable Long id, @RequestBody PacienteRequestUpdateDTO dto) {
    return pacienteService.updatePaciente(id, dto)
      .map(p -> new PacienteResponseDTO().toDto(p))
      .map(ResponseEntity::ok)
      .orElse(ResponseEntity.notFound().build());
  }

  @GetMapping("/{id}")
  public ResponseEntity<PacienteResponseDTO> findbyId(@PathVariable Long id) {
    return pacienteService.getPacienteById(id)
      .map(p -> new PacienteResponseDTO().toDto(p))
      .map(ResponseEntity::ok)
      .orElse(ResponseEntity.notFound().build());
    }
  
  @GetMapping
  public ResponseEntity<List<PacienteResponseDTO>> findAll() {
    List<PacienteResponseDTO> response = pacienteService.getAll().stream()
      .map(p -> new PacienteResponseDTO().toDto(p))
      .collect(Collectors.toList());

      return ResponseEntity.ok(response);
  }
}
