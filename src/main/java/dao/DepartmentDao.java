package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import model.Department;
import model.Staff;

/**
 * 部门Dao
 */
@Repository("departmentDao")
@Mapper
public interface DepartmentDao {

	/**
	 * 获取所有部门信息
	 * 
	 * @return 部门信息List
	 */
	@Select("select * from department")
	public List<Department> queryAllDepartment();

	/**
	 * 获取部门员工信息
	 * 
	 * @param id 部门id
	 * @return 员工信息List
	 */
	@Select("select * from staff  where poId in ( select poId from post where deId = #{id} );")
	public List<Staff> queryDepartmentStaff(int id);

	/**
	 * 新建部门
	 * 
	 * @param department 部门信息
	 */
	@Insert("insert into department values(#{deId},#{deName})")
	public void addDepartment(Department department);

	/**
	 * 更改部门信息
	 * 
	 * @param department 部门信息
	 */
	@Update("update department set deName = #{deName} where deId = #{deId}")
	public void alterDepartment(Department department);

	/**
	 * 删除部门
	 * 
	 * @param id 被删除的部门id
	 */
	@Delete("delete from department where deId = #{deId}")
	public void deleteDepartment(int deId);

	/**
	 * 获取部门数量
	 * 
	 * @return 数量
	 */
	@Select("select count(*) from department")
	public int countDepartment();

	/**
	 * 获取某个部门
	 * 
	 * @param id 部门id
	 * @return 部门
	 */
	@Select("select * from department where deId = #{id}")
	public Department getDepartmentById(int id);
}
