package com.sparta.sparta_personalproject.BlogDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

public class SignupRequestDto {
    private String username;

    private String password;

    private boolean admin = false;

    private String adminToKen = "";


}
