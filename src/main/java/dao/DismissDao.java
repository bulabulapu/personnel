package dao;

import model.Dismiss;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 离职表Dao
 */
@Repository("dismissDao")
@Mapper
public interface DismissDao {

	/**
	 * 查询所有离职记录
	 * 
	 * @return 记录list
	 */
	@Select("select * from dimission")
	public List<Dismiss> queryAll();

	/**
	 * 添加离职记录
	 * 
	 * @param dismiss 记录信息
	 */
	@Insert("insert into dimission values (#{dimId},#{staffId},#{dimDate},#{dimType},#{dimDirection},#{dimRemark})")
	public void addRecord(Dismiss dismiss);

	/**
	 * 查询记录数量
	 * 
	 * @return
	 */
	@Select("select count(*) from dimission")
	public int countTransfer();

	/**
	 * 查询某段时间内的离职记录
	 * 
	 * @param start 开始时间
	 * @param end   结束时间
	 * @return 记录list
	 */
	@Select("select * from dimission where dimDate >= #{start} and dimDate < #{end}")
	public List<Dismiss> getDismissByTime(@Param("start") String start, @Param("end") String end);

	/**
	 * 查询某段时间内某部门的离职员工人数
	 * 
	 * @param start 起时间
	 * @param end   止时间
	 * @param deId  部门id
	 * @return 人数
	 */
	@Select("select count(*) from dimission where dimDate < #{end} and dimDate >= #{start} and staffId in (select staffId from staff where poId in (select poId from post where deId = #{deId}))")
	public int countDismissStaffByDepartAndTime(@Param("start") String start, @Param("end") String end,
			@Param("deId") int deId);

}
