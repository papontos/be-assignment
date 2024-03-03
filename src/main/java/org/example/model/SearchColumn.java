package org.example.model;

public enum SearchColumn {
    JOB_TITLE("job_title", "jobTitle"), SALARY("salary", "salary"), GENDER("gender", "gender");

    private final String value;
    private final String column;

    SearchColumn(String value, String column) {
        this.value = value;
        this.column = column;
    }

    public String getColumn(){
        return this.column;
    }

    public static SearchColumn fromString(String value) {
        for(var searchColumn: SearchColumn.values()){
            if (searchColumn.value.equalsIgnoreCase(value)) {
                return searchColumn;
            }
        }
        throw new RuntimeException("fail to parse searchColumn");
    }
}
