package dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import model.Department;

@Repository("departmentDao")
@Mapper
public interface DepartmentDao {
    
    @Select("select * from department")
    public List<Department> getAllDepartment();
    
}
