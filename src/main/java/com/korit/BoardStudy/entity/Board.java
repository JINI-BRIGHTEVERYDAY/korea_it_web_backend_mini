package com.korit.BoardStudy.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Board {
    private Integer boardId;
    private String title;
    private String content;
    @JsonIgnore
    private Integer userId;
    private LocalDateTime createDt;
    private LocalDateTime updateDt;
}
