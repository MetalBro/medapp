package ru.hostapp.web;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.annotation.VariableResolver;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class RootController extends UpRootController {
//public class RootController extends SelectorComposer<Component>{

    private static final long serialVersionUID = 1L;

//    @Wire
//    private Listbox procedureListBox;

//    @WireVariable("procedureServiceImpl")
//    private ProcedureService procedureService;

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
//        List<Procedure> procedureList = procedureService.setAll();
//        procedureListBox.setModel(new ListModelList<>(procedureList));
        setAll();
    }



}
