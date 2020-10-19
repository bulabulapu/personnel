package service;

import model.Dismiss;

import java.util.List;

/**
 * 离职管理服务接口
 */
public interface DismissService {

    /**
     * 添加离职记录
     * @param dismiss 离职记录信息
     * @return 状态
     */
    public boolean insetDismiss(Dismiss dismiss);

    /**
     * 查询所有离职记录
     * @return 记录list
     */
    public List<Dismiss> queryDismiss();
}
