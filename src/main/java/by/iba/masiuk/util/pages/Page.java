package by.iba.masiuk.util.pages;

public enum Page {
    LOGIN_PAGE("/views/login.jsp"),
    REGISTER_PAGE("/views/register.jsp"),
    WELCOME_PAGE ("/views/welcome.jsp"),
    ERROR_PAGE ("/views/errorPage.jsp");
    private final String value;
    Page(String value) {
        this.value = value;
    }
    public String getPage() {
        return value;
    }
}