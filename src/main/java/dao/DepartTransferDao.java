package dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import model.DepartTransfer;

/**
 * 部门调动表Dao
 */
@Repository("departTransferDao")
@Mapper
public interface DepartTransferDao {

	/**
	 * 查询所有部门调动记录
	 * 
	 * @return 记录list
	 */
	@Select("select * from departtransfer")
	public List<DepartTransfer> queryAll();

	/**
	 * 查询某员工的部门调动记录
	 * 
	 * @param id 员工id
	 * @return 记录list
	 */
	@Select("select * from departtransfer where staffId = #{id}")
	public List<DepartTransfer> queryTransferByStaffId(int id);

	/**
	 * 添加部门调动记录
	 * 
	 * @param departTransfer 记录信息
	 */
	@Insert("insert into departtransfer values (#{deTrId},#{staffId},#{newDepart},#{oldDepart},#{deType},#{deReson},#{deRemark},#{deDate})")
	public void addTransfer(DepartTransfer departTransfer);

	/**
	 * 查询记录数量
	 * 
	 * @return
	 */
	@Select("select count(*) from departtransfer")
	public int countTransfer();

	/**
	 * 查询某段时间内的部门调动记录
	 * 
	 * @param start 开始时间
	 * @param end   结束时间
	 * @return 记录list
	 */
	@Select("select * from departtransfer where deDate >= #{start} and deDate < #{end}")
	public List<DepartTransfer> getDepartTransferByTime(@Param("start") String start, @Param("end") String end);

	/**
	 * 查询某段时间内某部门调入人数
	 * 
	 * @param start 起时间
	 * @param end   止时间
	 * @param deId  部门id
	 * @return 人数
	 */
	@Select("select count(*) from departtransfer where deDate < #{end} and deDate >= #{start} and newDepart = (select deName from department where deId = #{deId})")
	public int countInByDepartAndTime(@Param("start") String start, @Param("end") String end, @Param("deId") int deId);

	/**
	 * 查询某段时间内某部门调出人数
	 * 
	 * @param start 起时间
	 * @param end   止时间
	 * @param deId  部门id
	 * @return 人数
	 */
	@Select("select count(*) from departtransfer where deDate < #{end} and deDate >= #{start} and oldDepart = (select deName from department where deId = #{deId})")
	public int countOutByDepartAndTime(@Param("start") String start, @Param("end") String end, @Param("deId") int deId);

}
