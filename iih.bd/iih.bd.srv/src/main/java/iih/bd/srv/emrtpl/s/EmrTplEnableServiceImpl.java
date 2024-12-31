package iih.bd.srv.emrtpl.s;

import iih.bd.srv.emrtpl.d.EmrTplDO;
import iih.bd.srv.emrtpl.i.IEmrTplEnableService;
import iih.bd.srv.emrtpl.s.bp.DisableEmrTplBp;
import iih.bd.srv.emrtpl.s.bp.EnableEmrTplBp;
import xap.mw.core.data.BizException;

/**
 * 医疗记录模板启用服务
 * 
 * @author hao_wu
 *
 */
public class EmrTplEnableServiceImpl implements IEmrTplEnableService {

	@Override
	public EmrTplDO[] Enable(EmrTplDO[] emrTplDOs) throws BizException {
		EnableEmrTplBp bp = new EnableEmrTplBp();
		EmrTplDO[] result = bp.exec(emrTplDOs);
		return result;
	}

	@Override
	public EmrTplDO[] Disable(EmrTplDO[] emrTplDOs) throws BizException {
		DisableEmrTplBp bp = new DisableEmrTplBp();
		EmrTplDO[] result = bp.exec(emrTplDOs);
		return result;
	}

}
