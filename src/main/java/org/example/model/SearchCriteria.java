package org.example.model;

public class SearchCriteria {
    private SearchColumn searchColumn;
    private Comparator comparator;
    private Object value;

    public SearchColumn getSearchColumn() {
        return searchColumn;
    }

    public void setSearchColumn(SearchColumn searchColumn) {
        this.searchColumn = searchColumn;
    }

    public Comparator getComparator() {
        return comparator;
    }

    public void setComparator(Comparator comparator) {
        this.comparator = comparator;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
