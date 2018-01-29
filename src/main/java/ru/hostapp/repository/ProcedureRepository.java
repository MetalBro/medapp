package ru.hostapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.hostapp.model.Procedure;

@Repository
public interface ProcedureRepository extends JpaRepository<Procedure, Integer> {

    @Transactional
    @Override
    Procedure save(Procedure procedure);
}
