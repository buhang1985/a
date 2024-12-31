package iih.bd.srv.mrbasetpl.s;

import iih.bd.srv.mrbasetpl.d.EmrBaseTplDO;
import iih.bd.srv.mrbasetpl.i.IMrBaseTplEnableService;
import iih.bd.srv.mrbasetpl.s.bp.DisableEmrBaseTplBp;
import iih.bd.srv.mrbasetpl.s.bp.EnableEmrBaseTplBp;
import xap.mw.core.data.BizException;

/**
 * 医疗记录基础模板启用服务
 * 
 * @author hao_wu
 *
 */
public class MrBaseTplEnableServiceImpl implements IMrBaseTplEnableService {

	@Override
	public EmrBaseTplDO[] Enable(EmrBaseTplDO[] emrBaseTplDOs) throws BizException {
		EnableEmrBaseTplBp bp = new EnableEmrBaseTplBp();
		EmrBaseTplDO[] result = bp.exec(emrBaseTplDOs);
		return result;
	}

	@Override
	public EmrBaseTplDO[] Disable(EmrBaseTplDO[] emrBaseTplDOs) throws BizException {
		DisableEmrBaseTplBp bp = new DisableEmrBaseTplBp();
		EmrBaseTplDO[] result = bp.exec(emrBaseTplDOs);
		return result;
	}

}
