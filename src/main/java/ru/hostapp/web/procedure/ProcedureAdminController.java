package ru.hostapp.web.procedure;


import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.ForwardEvent;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.*;
import ru.hostapp.model.Procedure;
import ru.hostapp.service.ProcedureService;
import ru.hostapp.web.UpRootController;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class ProcedureAdminController extends UpRootController {

    private static final long serialVersionUID = 1L;

    @WireVariable("procedureServiceImpl")
    private ProcedureService procedureService;

    @Wire
    private Window modalForm;

    @Wire
    private Intbox intboxProcedureId;

    @Wire
    private Textbox name;

    @Wire
    private Textbox specialist;

    @Wire
    private Decimalbox price;

    @Wire
    private Selectbox dayListBox;

    @Wire
    private Timebox daytimeBox;

    @Wire
    private Intbox room;

    @Listen("onClick = #addButton")
    public void showAddModalForm(Event e) {
        //createOrUpdate a window programmatically and use it as a modal dialog.
        Procedure procedure = new Procedure(null, " ", " ", new BigDecimal(0),null, 0);
        Window window = (Window) Executions.createComponents(
                "WEB-INF/fragments/form.zul", null, getParamsMap(procedure));
        window.doModal();
    }

    @Listen("onDelete = #procedureListBox")
    public void doDeleteProcedure(ForwardEvent evt){
        Button btn = (Button)evt.getOrigin().getTarget();
        Listitem litem = (Listitem)btn.getParent().getParent().getParent();
        Procedure procedure = litem.getValue();
        procedureService.delete(procedure.getId());
        Events.postEvent("onClick", refreshButton, null);
    }

    @Listen("onUpdate = #procedureListBox")
    public void doUpdateProcedure(ForwardEvent evt){
        Button btn = (Button)evt.getOrigin().getTarget();
        Listitem litem = (Listitem)btn.getParent().getParent().getParent();
        Procedure procedure = litem.getValue();
        Window window = (Window) Executions.createComponents(
                "WEB-INF/fragments/form.zul", null, getParamsMap(procedure));
        window.doModal();
    }

    @Listen("onClick=#saveProcedure")
    public void doSaveProcedure(){
        Procedure procedure = null;

        if (intboxProcedureId.getValue() == null) procedure = new Procedure();
        else procedure = procedureService.get(intboxProcedureId.getValue());

        procedure.setName(name.getValue().trim());
        procedure.setSpecialist(specialist.getValue().trim());
        procedure.setPrice(price.getValue());
        StringBuilder stringBuilder = new StringBuilder();
        Set<String> selection = ((ListModelList)dayListBox.getModel()).getSelection();
        if(!selection.isEmpty()){
            stringBuilder.append(selection.iterator().next());
        }else{
            stringBuilder.append("");
        }
        stringBuilder.append(", ");
        stringBuilder.append(new SimpleDateFormat("HH:mm").format(daytimeBox.getValue()));
        procedure.setDate(stringBuilder.toString());
        procedure.setRoom(room.getValue());

        procedureService.createOrUpdate(procedure);

        modalForm.onClose();
        Clients.showNotification("Procedure Saved, please click \"Refresh\" button");
    }

    private Map getParamsMap(Procedure procedure){
        Map<String, Object> params = new HashMap<>();
        params.put("procedureId", procedure.getId());
        params.put("name", procedure.getName());
        params.put("specialist", procedure.getSpecialist());
        params.put("price", procedure.getPrice());
        params.put("room", procedure.getRoom());
        return params;
    }
}
