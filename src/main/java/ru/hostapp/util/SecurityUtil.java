package ru.hostapp.util;

import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import ru.hostapp.model.UserCredential;

public class SecurityUtil {

    public static boolean isAllGranted(){
        Session sess = Sessions.getCurrent();
        UserCredential cre = (UserCredential)sess.getAttribute("userCredential");
        if(cre==null){
            cre = new UserCredential();//new a anonymous user and set to session
            sess.setAttribute("userCredential",cre);
        }
        return cre.hasRole("ROLE_ADMIN");
    }

    public static boolean isAuthorized(){
        Session sess = Sessions.getCurrent();
        UserCredential cre = (UserCredential)sess.getAttribute("userCredential");
        if(cre==null){
            cre = new UserCredential();//new a anonymous user and set to session
            sess.setAttribute("userCredential",cre);
        }
        return !cre.isAnonymous();
    }
}
