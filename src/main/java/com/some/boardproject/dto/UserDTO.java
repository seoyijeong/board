package com.some.boardproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    @NotNull(message = "id 파라미터가 전달되지 않았습니다.") // null 체크
    @NotBlank(message = "id는 필수 입력사항입니다.") // 빈문자열 확인
    @Size(min=4,max=15, message = "id는 4글자 이상 15미만으로 입력하세요")
    private String userId;

    @NotNull(message = "username 파라미터가 전달되지 않았습니다.") // null 체크
    @NotBlank(message = "username은 필수 입력사항입니다.") // 빈문자열 확인
    @Size(min=4,max=15, message = "username은 4글자 이상 15미만으로 입력하세요")
    private String userName;

    @NotNull(message = "password 파라미터가 전달되지 않았습니다.") // null 체크
    @NotBlank(message = "password은 필수 입력사항입니다.") // 빈문자열 확인
    @Size(min=4,max=15,message = "패스워드는 4~15자까지 가능합니다.")
    private String userPw;


    @NotNull(message = "email 파라미터가 전달되지 않았습니다.") // null 체크
    @NotBlank(message = "email은 필수 입력사항입니다.") // 빈문자열 확인
    @Email(message = "이메일 형식이 아닙니다.")
    private String userEmail;

    private String userTel;
    
    private String userGender;
}
