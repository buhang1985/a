package iih.bd.fc.quesite.i;

import iih.bd.fc.quesite.d.QueSiteDO;
import xap.mw.core.data.BizException;

/**
 * 就诊队列扩展查询服务
 * 
 * @author liubin
 *
 */
public interface IQueSiteQryService {
	/**
	 * 根据部门ID获取门诊诊间集合
	 * 
	 * @param depId 部门ID
	 * @return
	 * @throws BizException
	 */
	String[] getRooms(String depId) throws BizException;

	/**
	 * 根据诊间获取诊椅（即站点）集合
	 * 
	 * @param depId 部门ID
	 * @param room  诊间(%-全部)
	 * @return
	 * @throws BizException
	 */
	QueSiteDO[] getQueSiteByRoom(String depId, String room) throws BizException;

	/**
	 * 根据药房科室主键获取当前计算机对应的药房窗口信息
	 * 
	 * @param depId 药房科室主键
	 * @return 当前计算机对应的药房窗口信息
	 * @throws BizException
	 */
	public abstract QueSiteDO findCurrWinByDepId(String depId) throws BizException;
}
