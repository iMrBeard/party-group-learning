package com.learning.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
