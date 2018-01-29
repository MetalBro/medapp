package ru.hostapp.web;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.SpringUtil;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Window;
import ru.hostapp.model.Procedure;
import ru.hostapp.service.ProcedureService;

import java.util.List;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class RootController extends SelectorComposer<Component>{

    private static final long serialVersionUID = 1L;

    @Wire
    private Listbox procedureListBox;

    @WireVariable("procedureServiceImpl")
    private ProcedureService procedureService;

    @Listen("onClick = #showAllButton")
    public void getAll(){
        List<Procedure> procedureList = procedureService.getAll();
        procedureListBox.setModel(new ListModelList<>(procedureList));
    }
}
