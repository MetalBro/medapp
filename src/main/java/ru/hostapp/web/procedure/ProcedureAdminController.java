package ru.hostapp.web.procedure;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hostapp.service.ProcedureService;

@RestController
@RequestMapping(value = ProcedureAdminController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class ProcedureAdminController {

    static final String REST_URL = "/rest/admin/procedures";

    private ProcedureService procedureService;

    @Autowired
    public ProcedureAdminController(ProcedureService procedureService) {
        this.procedureService = procedureService;
    }


}
