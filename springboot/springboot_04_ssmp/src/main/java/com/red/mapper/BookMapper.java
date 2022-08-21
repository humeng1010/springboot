package com.red.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.red.pojo.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper extends BaseMapper<Book> {

}
