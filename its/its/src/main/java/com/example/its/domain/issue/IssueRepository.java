package com.example.its.domain.issue;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository MyBatisがある場合、@MapperだけでH2DBに接続できる
@Mapper
public interface IssueRepository {

    @Select("select * from issues")
    List<IssueEntity> findAll();

    @Insert("insert into issues (summary, description) values (#{summary}, #{description})")
    void insert(String summary, String description);

    @Select("select * from issues where id = #{issueId}")
    IssueEntity findById(long issueId);
}
