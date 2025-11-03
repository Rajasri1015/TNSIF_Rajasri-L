package com.bookbrooke.entities;

public class BookRequest {
    private String requestedTitle;
    private String requesterName;

    public BookRequest(String requestedTitle, String requesterName) {
        this.requestedTitle = requestedTitle;
        this.requesterName = requesterName;
    }

    public String getRequestedTitle() { return requestedTitle; }
    public String getRequesterName() { return requesterName; }

    @Override
    public String toString() {
        return "📖 '" + requestedTitle + "' requested by " + requesterName;
    }
}