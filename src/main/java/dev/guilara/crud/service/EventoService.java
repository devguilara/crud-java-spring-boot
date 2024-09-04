package dev.guilara.crud.service;

import dev.guilara.crud.model.Evento;
import dev.guilara.crud.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    public List<Evento> listarEventos(){
        return eventoRepository.findAll();
    }

    public Optional<Evento> buscarEventoPorId(Long id){
        return eventoRepository.findById(id);
    }

    public Evento salvarEvento(Evento evento){
        return eventoRepository.save(evento);
    }
    
    public void deletarEvento(Long id){
        eventoRepository.deleteById(id);
    }
}
