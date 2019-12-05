package com.pyg.manager.dao.pojo;

public class Users {
    private String username;

    private String password;

    private Boolean enabled;

    private String usernamealias;

    private String info1;

    private String info2;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getUsernamealias() {
        return usernamealias;
    }

    public void setUsernamealias(String usernamealias) {
        this.usernamealias = usernamealias == null ? null : usernamealias.trim();
    }

    public String getInfo1() {
        return info1;
    }

    public void setInfo1(String info1) {
        this.info1 = info1 == null ? null : info1.trim();
    }

    public String getInfo2() {
        return info2;
    }

    public void setInfo2(String info2) {
        this.info2 = info2 == null ? null : info2.trim();
    }
}