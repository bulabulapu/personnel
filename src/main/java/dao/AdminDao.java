package dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import model.Admin;

@Repository("adminDao")
@Mapper
public interface AdminDao {

	@Select("select * from admin where adminId=#{adminId}")
	public Admin getAdmin(String adminId);
}
