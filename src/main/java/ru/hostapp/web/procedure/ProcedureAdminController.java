package ru.hostapp.web.procedure;


import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Window;
import ru.hostapp.service.ProcedureService;

import java.util.List;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class ProcedureAdminController extends SelectorComposer<Component>{

    private static final long serialVersionUID = 1L;

    @WireVariable
    private ProcedureService procedureService;

    @Listen("onClick = #addButton")
    public void showAddModalForm(Event e) {
        //create a window programmatically and use it as a modal dialog.
        Window window = (Window) Executions.createComponents(
                "WEB-INF/fragments/form.zul", null, null);
        window.doModal();
    }
}
