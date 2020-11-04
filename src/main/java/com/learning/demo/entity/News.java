package com.learning.demo.entity;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDateTime;
import java.util.HashMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("新闻")
public class News {
    @Column
    private String newsName;
    @Column
    private String contains;
    @Column
    private LocalDateTime newsDate;
    @Column
    private Integer newsId;

}
