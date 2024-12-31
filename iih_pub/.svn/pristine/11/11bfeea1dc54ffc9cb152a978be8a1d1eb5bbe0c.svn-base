package iih.bd.fc.quesite.i;

import iih.bd.fc.quesite.d.QueSiteDO;
import xap.mw.core.data.BizException;

/**
 * 就诊队列工作点扩展接口服务
 * @author liu bin
 */
public interface IQueSiteExtService {

	/**
	 * 暂停工作站点
	 * @param queSite
	 * @throws BizException
	 */
	void stopQueSite(QueSiteDO queSite) throws BizException;
	
	/**
	 * 启动工作站点
	 * @param queSite
	 * @throws BizException
	 */
	void startQueSite(QueSiteDO queSite) throws BizException;
	/**
	 * 登陆工作站点
	 * @param quesiteId 工作站点id
	 * @param empId 人员id
	 * @throws BizException
	 */
	void login(String quesiteId,String empId) throws BizException;
	/**
	 * 退出工作点
	 * @param quesiteId 工作点
	 * @param empId 人员
	 * @throws BizException
	 */
	void logout(String quesiteId) throws BizException;
}
