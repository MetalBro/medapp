package ru.hostapp.web.procedure;

import org.springframework.web.bind.annotation.*;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import ru.hostapp.model.Procedure;
import ru.hostapp.service.ProcedureService;

import java.util.List;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class ProcedureController extends SelectorComposer<Component> {

    @WireVariable
    private ProcedureService procedureService;

//    @GetMapping(value = "/{id}")
    public Procedure getProcedure(@PathVariable("id") int id){
        return procedureService.get(id);
    }

}
