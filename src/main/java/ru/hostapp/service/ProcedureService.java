package ru.hostapp.service;

import ru.hostapp.model.Procedure;

import java.util.List;

public interface ProcedureService {

    Procedure createOrUpdate(Procedure procedure);

    void delete(int id);

    List<Procedure> getAll();

    Procedure get(int id);

}
