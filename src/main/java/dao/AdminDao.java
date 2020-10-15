package dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import model.Admin;

/**
 * 管理员Dao
 */
@Repository("adminDao")
@Mapper
public interface AdminDao {

	/**
	 * 获取管理员所有信息
	 * @param adminId
	 * @return 查询到的管理员信息
	 */
	@Select("select * from admin where adminId=#{adminId}")
	public Admin getAdmin(String adminId);
}
