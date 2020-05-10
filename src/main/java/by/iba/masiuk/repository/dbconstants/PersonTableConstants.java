package by.iba.masiuk.repository.dbconstants;

public enum PersonTableConstants {
    ID("id"),
    NAME("namel"),
    PHONE("phone"),
    EMAIL ("email");
    private String fieldName;
    private PersonTableConstants(String fieldName) {
        this.fieldName = fieldName;
    }
    public String getFieldName(){
        return fieldName;
    }
}