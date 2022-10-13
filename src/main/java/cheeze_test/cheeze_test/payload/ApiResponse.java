package cheeze_test.cheeze_test.payload;

public class ApiResponse {
    private Boolean success;
    private String message;

    //생성자 생성
    public ApiResponse(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    //Getter, Setter 추가
    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
