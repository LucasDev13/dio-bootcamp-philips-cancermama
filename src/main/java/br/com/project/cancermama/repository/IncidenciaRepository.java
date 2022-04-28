package br.com.project.cancermama.repository;

import br.com.project.cancermama.dataproviders.entities.IncidenciaExame;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncidenciaRepository extends JpaRepository<IncidenciaExame, Long> {
}
