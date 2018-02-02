package ru.hostapp.web.procedure;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.*;
import ru.hostapp.model.Day;
import ru.hostapp.service.ProcedureService;
import ru.hostapp.web.UpRootController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class FormController extends SelectorComposer<Component> {

    private static final long serialVersionUID = 1L;

    @WireVariable("procedureServiceImpl")
    private ProcedureService procedureService;

    @Wire
    private Window modalForm;

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

    @Override
    public void doAfterCompose(Component comp) throws Exception{
        super.doAfterCompose(comp);
        List<String> dayList = Stream.of(Day.values())
                .map(Day::name)
                .collect(Collectors.toList());
        ListModelList<String> dayModel = new ListModelList<String>(dayList);
        dayModel.addToSelection(String.valueOf(Day.Monday));
        dayListBox.setModel(dayModel);
    }
}
