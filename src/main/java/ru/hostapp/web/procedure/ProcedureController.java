package ru.hostapp.web.procedure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.hostapp.model.Procedure;
import ru.hostapp.service.ProcedureService;

import java.util.List;

//@RequestMapping(value = ProcedureController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class ProcedureController {

    static final String REST_URL = "/rest/procedures";

    @Autowired
    private ProcedureService procedureService;

//    @Autowired
//    public ProcedureController(ProcedureService procedureService) {
//        this.procedureService = procedureService;
//    }

    @GetMapping
    public List<Procedure> getProcedures(){
        return procedureService.getAll();
    }

    @GetMapping(value = "/{id}")
    public Procedure getProcedure(@PathVariable("id") int id){
        return procedureService.get(id);
    }

}
