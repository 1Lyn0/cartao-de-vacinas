package com.hackathon1000devs.projeto.repository;

import com.hackathon1000devs.projeto.model.VacinaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacinaRepository extends JpaRepository<VacinaModel, Long> {

    @Query("SELECT v FROM VacinaModel v WHERE v.publico_alvo = :faixa")
    List<VacinaModel> findByPublicoAlvo(String faixa);

    @Query("SELECT v FROM VacinaModel v WHERE v.limite_aplicacao > :meses OR v.limite_aplicacao IS NULL")
    List<VacinaModel> findVacinasRecomendadasAcima(Integer meses);

    @Query("SELECT COUNT(v) FROM VacinaModel v WHERE v.limite_aplicacao > :meses")
    long countVacinasAcimaIdade(Integer meses);
}

