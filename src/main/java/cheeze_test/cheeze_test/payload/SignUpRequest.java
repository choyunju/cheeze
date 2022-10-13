package cheeze_test.cheeze_test.payload;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SignUpRequest {
    @NotBlank
    @Size(max=100)
    @Email
    private String Email;

    @NotBlank
    @Size(min=3, max=10)
    private String Nickname;

    @NotBlank
    @Size(min=6, max=100)
    private String Password;

    @NotBlank
    @Size(max=100)
    private String Intro;

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getNickname() {
        return Nickname;
    }

    public void setNickname(String nickname) {
        Nickname = nickname;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getIntro() {
        return Intro;
    }

    public void setIntro(String intro) {
        Intro = intro;
    }
}
