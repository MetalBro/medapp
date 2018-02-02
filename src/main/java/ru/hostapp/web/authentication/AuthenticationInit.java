package ru.hostapp.web.authentication;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.Initiator;
import ru.hostapp.model.UserCredential;
import ru.hostapp.service.AuthenticationService;
import ru.hostapp.service.AuthenticationServiceImpl;

import java.util.Map;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class AuthenticationInit implements Initiator {

    //services
    @WireVariable
    AuthenticationService authService;

    public void doInit(Page page, Map<String, Object> args) throws Exception {

        Selectors.wireVariables(page, this, Selectors.newVariableResolvers(getClass(), null));

        UserCredential cre = authService.getUserCredential();
        if(cre==null || cre.isAnonymous()){
//            Executions.sendRedirect("/chapter8/login.zul");
            Executions.sendRedirect("login.zul");
            return;
        }
    }
}
