package iih.bd.srv.srvrtctl.s;

import iih.bd.srv.srvrtctl.d.SrvRtCtlDO;
import iih.bd.srv.srvrtctl.i.ISrvRtCtlExtCudService;
import iih.bd.srv.srvrtctl.i.ISrvRtCtlExtRService;
import iih.bd.srv.srvrtctl.s.bp.FindSrvRtCtlByEmpIdBp;
import xap.mw.core.data.BizException;

/**
 * 服务开立权限扩展服务
 * 
 * @author hao_wu
 *
 */
public class SrvRtCtlExtCrudServiceImpl implements ISrvRtCtlExtCudService, ISrvRtCtlExtRService {

	@Override
	public SrvRtCtlDO[] findSrvRtCtlByEmpId(String empId) throws BizException {
		FindSrvRtCtlByEmpIdBp bp = new FindSrvRtCtlByEmpIdBp();
		SrvRtCtlDO[] result = bp.exec(empId);
		return result;
	}
}
