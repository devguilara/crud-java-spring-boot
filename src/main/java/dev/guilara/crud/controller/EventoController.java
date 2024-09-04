package dev.guilara.crud.controller;

import dev.guilara.crud.model.Evento;
import dev.guilara.crud.service.EventoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Slf4j
@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @GetMapping
    public List<Evento> listarEventos(){
        return eventoService.listarEventos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evento> buscarEventosPorId(@PathVariable long id){
        Optional<Evento> evento = eventoService.buscarEventoPorId(id);
        return evento.isPresent() ? ResponseEntity.ok(evento.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping("/{id}")
    public Evento salvarEvento(@RequestBody Evento evento){
        return eventoService.salvarEvento(evento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evento> atualizarEvento(@PathVariable Long id, @RequestBody Evento evento) {
        if (!eventoService.buscarEventoPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        evento.setId(id);
        Evento eventoAtualizado = eventoService.salvarEvento(evento);
        return ResponseEntity.ok(eventoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEvento(@PathVariable Long id) {
        if (!eventoService.buscarEventoPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        eventoService.deletarEvento(id);
        return ResponseEntity.noContent().build();
    }
}
