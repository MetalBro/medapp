package ru.hostapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import ru.hostapp.model.User;
import ru.hostapp.model.UserCredential;

import java.io.Serializable;

@Service("authService")
public class AuthenticationServiceImpl implements AuthenticationService, Serializable {

    private UserService userService;

    @Autowired
    public AuthenticationServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean login(String name, String password) {
        User user = userService.findUser(name);
        //a simple plan text password verification
        if(user==null || !user.getPassword().equals(password)){
            return false;
        }

        Session sess = Sessions.getCurrent();
//        UserCredential cre = new UserCredential(user.getAccount(),user.getFullName());
        UserCredential cre = new UserCredential(user.getEmail(),user.getName());
        cre.addRole(user.getRole());
        sess.setAttribute("userCredential",cre);

        return true;
    }

    @Override
    public void logout() {
        Session sess = Sessions.getCurrent();
        sess.removeAttribute("userCredential");
    }

    @Override
    public UserCredential getUserCredential(){
        Session sess = Sessions.getCurrent();
        UserCredential cre = (UserCredential)sess.getAttribute("userCredential");
        if(cre==null){
            cre = new UserCredential();//new a anonymous user and set to session
            sess.setAttribute("userCredential",cre);
        }
        return cre;
    }

    public boolean isAllGranted(){
        return getUserCredential().hasRole("ROLE_ADMIN");
    }
}
