package ru.xsrv.PhotoHouse.server.v1.requests;

import ru.xsrv.PhotoHouse.server.v1.Acts;
import ru.xsrv.PhotoHouse.server.v1.FeedBackType;

/**
 *
 * Created by Calc on 29.10.2014.
 */
public class FeedBackRequest extends Request {
    private FeedBackType type;
    private String email;
    private String title;
    private String message;

    public FeedBackRequest(FeedBackType type, String email, String title, String message) {
        super(Acts.FEEDBACK);
        this.type = type;
        this.email = email;
        this.title = title;
        this.message = message;
    }

    @Override
    public void build() {
        root.addProperty(FIELD_ACT, act.toString());

        root.addProperty(FIELD_TYPE, type.getCode());
        root.addProperty(FIELD_EMAIL, email);
        root.addProperty(FIELD_TITLE, title);
        root.addProperty(FIELD_MESSAGE, message);

        root.addProperty(FIELD_TIME, Long.toString(time));
    }

}
