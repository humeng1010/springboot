package com.red.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("tbl_book")
public class Book {
    private Integer id;
    private String type;
    private String name;
    private String description;
}
