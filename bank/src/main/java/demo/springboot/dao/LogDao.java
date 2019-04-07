package demo.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import demo.springboot.domain.Log;


@Mapper
public interface LogDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Log record);

    int insertSelective(Log record);

    Log selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Log record);

    int updateByPrimaryKey(Log record);

	// List<Log> selectList(Log log);

	List<Log> selectList(@Param("log") Log log, @Param("page") int page,
			@Param("limit") int limit);

	int selectListCount(@Param("log") Log log);
}