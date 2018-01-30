package ru.hostapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.hostapp.model.Procedure;
import ru.hostapp.repository.ProcedureRepository;

import java.util.List;

@Service
public class ProcedureServiceImpl implements ProcedureService{

    private ProcedureRepository procedureRepository;

    @Autowired
    public ProcedureServiceImpl(ProcedureRepository procedureRepository) {
        this.procedureRepository = procedureRepository;
    }

    @Override
    @CacheEvict(value = "procedures", allEntries = true)
    public Procedure create(Procedure procedure) {
        Assert.notNull(procedure, "procedure must not be null");
        return procedureRepository.save(procedure);
    }

    @Override
    @CacheEvict(value = "procedures", allEntries = true)
    public Procedure update(Procedure procedure) {
        Assert.notNull(procedure, "procedure must not be null");
        return procedureRepository.save(procedure);
    }

    @Override
    @CacheEvict(value = "procedures", allEntries = true)
    public void delete(int id) {
        procedureRepository.deleteById(id);
    }

    @Override
    @Cacheable("procedures")
    public List<Procedure> getAll() {
        return procedureRepository.findAll();
    }

    @Override
    public Procedure get(int id) {
        return procedureRepository.findById(id).orElse(null);
    }
}