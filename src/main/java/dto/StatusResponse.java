package dto;

public enum StatusResponse {

    SUCCESS ("Success"),
    ERROR ("Error");

    private String status;

    StatusResponse(String error) {
    }
}
