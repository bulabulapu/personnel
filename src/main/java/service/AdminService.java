package service;

import model.Admin;

/**
 * 管理员服务接口
 */
public interface AdminService {

    /**
     * 验证管理员信息
     *
     * @param admin 管理员信息
     * @return 匹配结果, 成功返回全部信息, 失败返回null
     */
    public Admin identifyAdmin(Admin admin);

    /**
     * 检查id是否合法
     *
     * @param id
     * @return 状态
     */
    public boolean checkId(String id);
}
