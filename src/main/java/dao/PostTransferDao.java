package dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import model.PostTransfer;

/**
 * 岗位调动表
 */
public interface PostTransferDao {

    /**
     * 查询所有岗位变更记录
     *
     * @return 记录list
     */
    @Select("select * from postTransfer")
    public List<PostTransfer> queryAll();

    /**
     * 查询某员工岗位变动信息
     *
     * @param id 员工id
     * @return 记录list
     */
    @Select("select * from postTransfer where staffId=#{id}")
    public List<PostTransfer> queryPostTransferStaff(int id);

    /**
     * 添加岗位调动记录
     *
     * @param postTransfer 记录信息a
     */
    @Insert("insert into posttransfer values (#{poTrId},#{staffId},#{newPost},#{oldPost},#{poType},#{poReson},#{poRemark},#{poDate})")
    public void addPostTransfer(PostTransfer postTransfer);

    /**
     * 查询记录数量
     *
     * @return
     */
    @Select("select count(*) from posttransfer")
    public int countTransfer();
    
    /**
     * 查询某段时间内的岗位调动记录
     * @param start 开始时间
     * @param end 结束时间
     * @return 记录list
     */
    @Select("select * from posttransfer where poDate >= #{start} and poDate < #{end}")
    public List<PostTransfer> getPostTransferByTime(@Param("start")String start,@Param("end") String end);
}
