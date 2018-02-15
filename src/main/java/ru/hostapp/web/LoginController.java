package ru.hostapp.web;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Label;
import org.zkoss.zul.Textbox;
import ru.hostapp.model.UserCredential;
import ru.hostapp.service.AuthenticationService;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class LoginController extends SelectorComposer<Component> {

    @Wire
    private Textbox account;
    @Wire
    private Textbox password;
    @Wire
    private Label message;

    @WireVariable
    private AuthenticationService authService;


    @Listen("onClick=#login; onOK=#loginWin")
    public void doLoginAsUser(){
        String name = account.getValue();
        String password = this.password.getValue();
        doLogin(name, password);
    }

    @Listen("onClick=#setGuest; onOK=#loginWin")
    public void doLoginAsGuest(){
        doLogin("guest@gmail.com", "guest");
    }

    @Listen("onClick=#setAdmin; onOK=#loginWin")
    public void doLoginAsAdmin(){
        doLogin("admin@gmail.com", "admin");
    }

    @Listen("onClick=#authorize")
    public void doAuthorize(){
        UserCredential cre = authService.getUserCredential();
        if(cre==null || cre.isAnonymous()){
            Executions.sendRedirect("login.zul");
        }
    }

    private void doLogin(String name, String password){
        if(!authService.login(name,password)){
            message.setValue("account or password are not correct.");
            return;
        }
        UserCredential cre= authService.getUserCredential();
        message.setValue("Welcome, "+cre.getName());
        message.setSclass("");

        Executions.sendRedirect("/");
    }
}
