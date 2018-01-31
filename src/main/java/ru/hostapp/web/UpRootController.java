package ru.hostapp.web;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Button;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import ru.hostapp.model.Procedure;
import ru.hostapp.service.ProcedureService;

import java.util.Comparator;
import java.util.List;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class UpRootController extends SelectorComposer<Component> {

    private static final long serialVersionUID = 1L;

    @Wire
    public Listbox procedureListBox;

    @Wire
    public Button refreshButton;

    @WireVariable("procedureServiceImpl")
    private ProcedureService procedureService;

    @Listen("onClick = #refreshButton")
    public void setAll(){
        List<Procedure> procedureList = procedureService.getAll();
        procedureList.sort(Comparator.comparing(item -> item.getName().toLowerCase()));
        procedureListBox.setModel(new ListModelList<>(procedureList));
    }
}
