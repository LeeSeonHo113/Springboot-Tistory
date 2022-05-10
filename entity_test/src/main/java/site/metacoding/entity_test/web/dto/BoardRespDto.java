package site.metacoding.entity_test.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BoardRespDto {
    private Integer id;
    private String title;
    private String content;
}