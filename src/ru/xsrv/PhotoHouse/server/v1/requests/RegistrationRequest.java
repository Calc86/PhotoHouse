package ru.xsrv.PhotoHouse.server.v1.requests;

import ru.xsrv.PhotoHouse.server.v1.Acts;

/**
 *
 * Created by Calc on 29.10.2014.
 */
public class RegistrationRequest extends Request {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public RegistrationRequest(String firstName, String lastName, String email, String password) {
        super(Acts.REGISTRATION);

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    @Override
    public void build() {
        root.addProperty(FIELD_ACT, act.toString());

        root.addProperty(FIELD_FIRST_NAME, firstName);
        root.addProperty(FIELD_LAST_NAME, lastName);
        root.addProperty(FIELD_EMAIL, email);
        root.addProperty(FIELD_PASSWORD, md5(password));


        root.addProperty(FIELD_TIME, Long.toString(time));
    }

}
