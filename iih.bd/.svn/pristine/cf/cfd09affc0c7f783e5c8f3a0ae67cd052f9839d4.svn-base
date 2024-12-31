package iih.bd.srv.srvrtctl.s;

import iih.bd.srv.srvrtctl.d.SrvRtCtlDO;
import iih.bd.srv.srvrtctl.d.SrvrtctlAggDO;
import iih.bd.srv.srvrtctl.i.ISrvrtctlRService;
import iih.bd.srv.srvrtctl.i.ISrvrtctlService;
import iih.bd.srv.srvrtctl.s.bp.SrvRtCtlAuthorizeBp;
import iih.bd.srv.srvrtctl.s.bp.SrvrtctlUpdateSrvTpBp;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 服务开立权限服务
 * 
 * @author hao_wu
 *
 */
public class SrvrtctlServiceImpl implements ISrvrtctlService {

	/**
	 * 根据id值查找服务开立权限数据
	 */
	@Override
	public SrvrtctlAggDO findById(String id) throws BizException {
		ISrvrtctlRService srvRtCtlRService = ServiceFinder.find(ISrvrtctlRService.class);
		SrvrtctlAggDO srvrtctlAggDO = srvRtCtlRService.findById(id);
		SrvrtctlUpdateSrvTpBp bp = new SrvrtctlUpdateSrvTpBp();
		bp.exec(srvrtctlAggDO);
		return srvrtctlAggDO;
	}

	/**
	 * 服务开立权限授权
	 * 
	 * @param srvRtCtlDo
	 *            服务开立权限信息
	 * @param psnIdArr
	 *            授权人员id数组
	 * @throws BizException
	 */
	@Override
	public void authorize(SrvRtCtlDO srvRtCtlDo, String[] psnIdArr) throws BizException {
		SrvRtCtlAuthorizeBp bp = new SrvRtCtlAuthorizeBp();
		bp.exec(srvRtCtlDo, psnIdArr);
	}

}
