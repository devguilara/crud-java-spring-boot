package dev.guilara.crud.repository;

import dev.guilara.crud.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

//Criação de repositorio de busca para o Evento
public interface EventoRepository extends JpaRepository<Evento, Long> {
}
