package ru.hostapp.service;

import ru.hostapp.model.Procedure;

import java.util.List;

public interface ProcedureService {

    Procedure create(Procedure procedure);

    Procedure update(Procedure procedure);

    void delete(int id);

    List<Procedure> getAll();

    Procedure get(int id);

}
