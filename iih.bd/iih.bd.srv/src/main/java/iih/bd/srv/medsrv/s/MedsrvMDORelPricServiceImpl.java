package iih.bd.srv.medsrv.s;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORelPricService;
import iih.bd.srv.medsrv.s.bp.SetRealPriBp;
import xap.mw.core.data.BizException;

public class MedsrvMDORelPricServiceImpl implements IMedsrvMDORelPricService {

	@Override
	public MedSrvDO updateRelPric(MedSrvDO[] medSrvDO) throws BizException {
		MedSrvDO medSrvDOForRn = new MedSrvDO();
		SetRealPriBp bp = new SetRealPriBp();
		bp.exec(medSrvDO);
		medSrvDOForRn = medSrvDO[0];
		return medSrvDOForRn;
	}
}
