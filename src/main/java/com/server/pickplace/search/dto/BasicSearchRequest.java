package com.server.pickplace.search.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BasicSearchRequest {

    private Integer distance = 5;
    private Integer countPerPage = 10;


    @NotBlank  // Null, 빈 문자열, 스페이스만 있는 문자열 불가
    @Size(max = 255)
    private String address;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd")
    private LocalDate startDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd")
    private LocalDate endDate;

    @NotBlank
    private String searchType;

    @Positive
    private Integer pageNum;


}
