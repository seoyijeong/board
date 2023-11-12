package com.some.boardproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {
    @NotNull(message = "제목을 입력하세요.") // null 체크
    @NotBlank(message = "제목을 입력하세요") // 빈문자열 확인
    @Size(min=2, max=100, message = "제목은 2~100자 내외로 입력 가능합니다.")
    private String boardTitle;

    @NotNull(message = "내용을 입력하세요") // null 체크
    @NotBlank(message = "내용을 입력하세요") // 빈문자열 확인
    @Size(min=2, max=2000, message = "내용은 2000자까지 입력 가능합니다.")
    private String boardContent;

}
