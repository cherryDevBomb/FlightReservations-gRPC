package model;

import java.util.Objects;

public class Agency {

    private String username;
    private String password;

    public Agency(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agency agency = (Agency) o;
        return  Objects.equals(username, agency.username) &&
                Objects.equals(password, agency.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }
}
