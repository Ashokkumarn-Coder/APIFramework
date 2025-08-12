package org.com.ftsrestapi.data;

public class PageDetails {
    private int pageNumber;
    private int lotSize;

    // Default constructor
    public PageDetails() {}

    // Parameterized constructor
    public PageDetails(int pageNumber, int lotSize) {
        this.pageNumber = pageNumber;
        this.lotSize = lotSize;
    }

    // Getters and Setters
    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getLotSize() {
        return lotSize;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }
}