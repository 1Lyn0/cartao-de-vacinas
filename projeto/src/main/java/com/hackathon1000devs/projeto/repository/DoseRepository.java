package com.hackathon1000devs.projeto.repository;


import com.hackathon1000devs.projeto.model.DoseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DoseRepository extends JpaRepository<DoseModel, Long> {

    @Query("SELECT d FROM DoseModel d WHERE d.idade_recomendada_aplicacao = :idade")
    List<DoseModel> findByIdadeRecomendada(Integer idade);
}
