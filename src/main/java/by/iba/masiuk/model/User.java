package by.iba.masiuk.model;

public class User {
    private int id;
    private String login;
    private byte[] passw;
    public User(int id, String login, byte[] passw) {
        this.id = id;
        this.login = login;
        this.passw = passw;
    }
    public User(String login, byte[] passw) {
        this.login = login;
        this.passw = passw;
    }
    public User() {
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public void setPassw(byte[] passw) {
        this.passw = passw;
    }
    public int getId() {
        return id;
    }
    public String getLogin() {
        return login;
    }
    public byte[] getPassw() {
        return passw;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", passw='" + passw + '\'' +
                '}';
    }
}
