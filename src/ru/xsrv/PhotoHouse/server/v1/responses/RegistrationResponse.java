package ru.xsrv.PhotoHouse.server.v1.responses;

import ru.xsrv.PhotoHouse.model.Controller;
import ru.xsrv.PhotoHouse.model.User;

/**
 *
 * Created by calc on 03.11.14.
 */
public class RegistrationResponse extends Response {
    private String user_reg;

    private User user;

    @Override
    protected String getStatus() {
        return user_reg;
    }

    public User getUser() {
        return user;
    }

    @Override
    public void process() {
        if(getUser() == null) return;

        Controller.getInstance().setUser(getUser());
    }
}
