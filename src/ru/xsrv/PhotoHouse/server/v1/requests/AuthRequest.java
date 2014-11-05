package ru.xsrv.PhotoHouse.server.v1.requests;

import ru.xsrv.PhotoHouse.server.v1.Acts;

/**
 *
 * Created by Calc on 29.10.2014.
 */
public class AuthRequest extends Request{
    private String email;
    private String password;

    public AuthRequest(String email, String password) {
        super(Acts.AUTH);
        this.email = email;
        this.password = password;
    }

    @Override
    public void build() {
        root.addProperty(FIELD_ACT, act.toString());

        root.addProperty(FIELD_EMAIL, email);
        root.addProperty(FIELD_PASSWORD, md5(password));

        root.addProperty(FIELD_TIME, Long.toString(time));
    }

}
