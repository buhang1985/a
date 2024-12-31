package iih.bd.srv.srvrtctl.i;

import iih.bd.srv.srvrtctl.d.SrvRtCtlDO;
import iih.bd.srv.srvrtctl.d.SrvrtctlAggDO;
import xap.mw.core.data.BizException;

/**
 * 服务开立权限服务接口
 * 
 * @author hao_wu
 *
 */
public interface ISrvrtctlService {

	/**
	 * 根据id值查找服务开立权限数据
	 */
	public SrvrtctlAggDO findById(String id) throws BizException;

	/**
	 * 服务开立权限授权
	 * 
	 * @param srvRtCtlDo
	 *            服务开立权限信息
	 * @param psnIdArr
	 *            授权人员id数组
	 */
	void authorize(SrvRtCtlDO srvRtCtlDo, String[] psnIdArr) throws BizException;

}
