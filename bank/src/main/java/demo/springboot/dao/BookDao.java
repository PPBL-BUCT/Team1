package demo.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import demo.springboot.domain.Book;

/**
 * 城市 DAO 接口类
 *
 * Created by bysocket on 07/02/2017.
 */

public interface BookDao {

	/**
	 * 获取城市信息列表
	 *
	 * @return
	 */
	List<Book> findAllCity();

	/**
	 * 根据城市 ID，获取城市信息
	 *
	 * @param id
	 * @return
	 */
	Book findById(@Param("id") Long id);

	Long saveCity(Book city);

	Long updateCity(Book city);

	Long deleteCity(Long id);
}
