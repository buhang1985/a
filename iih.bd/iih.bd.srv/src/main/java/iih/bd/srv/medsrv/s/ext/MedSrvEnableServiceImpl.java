package iih.bd.srv.medsrv.s.ext;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.ext.IMedSrvEnableService;
import iih.bd.srv.medsrv.s.bp.DisableMedSrvBp;
import iih.bd.srv.medsrv.s.bp.EnableMedSrvBp;
import xap.mw.core.data.BizException;

/**
 * 医疗服务启用服务
 * 
 * @author hao_wu
 *
 */
public class MedSrvEnableServiceImpl implements IMedSrvEnableService {

	@Override
	public MedSrvDO[] Enable(MedSrvDO[] medSrvDOs) throws BizException {
		EnableMedSrvBp bp = new EnableMedSrvBp();
		MedSrvDO[] result = bp.exec(medSrvDOs);
		return result;
	}

	@Override
	public MedSrvDO[] Disable(MedSrvDO[] medSrvDOs) throws BizException {
		DisableMedSrvBp bp = new DisableMedSrvBp();
		MedSrvDO[] result = bp.exec(medSrvDOs);
		return result;
	}

}
