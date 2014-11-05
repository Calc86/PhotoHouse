package ru.xsrv.PhotoHouse.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by calc on 03.11.14.
 */
public class User {
    private long id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String regdate;
    private List<String> props = new ArrayList<String>();
    private long group_id;
    private String group_name;
    private int access;

    public long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRegdate() {
        return regdate;
    }

    public List<String> getProps() {
        return props;
    }

    public long getGroup_id() {
        return group_id;
    }

    public String getGroup_name() {
        return group_name;
    }

    public int getAccess() {
        return access;
    }

    public void copyFrom(User user){
        id = user.getId();
        firstname = user.getFirstname();
        lastname = user.getLastname();
        email = user.getEmail();
        password = user.getPassword();
        regdate = user.getRegdate();
        props = user.getProps();
        group_id = user.getGroup_id();
        group_name = user.getGroup_name();
        access = user.getAccess();
    }
}
