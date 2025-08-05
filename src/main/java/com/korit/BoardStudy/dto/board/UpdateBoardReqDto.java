package com.korit.BoardStudy.dto.board;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateBoardReqDto {
    private Integer boardId;
    private String title;
    private String content;
}
