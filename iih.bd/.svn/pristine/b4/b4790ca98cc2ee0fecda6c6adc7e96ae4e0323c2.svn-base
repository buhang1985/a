package iih.bd.pp.hp.s;

import iih.bd.pp.hp.d.HpAggDO;
import iih.bd.pp.hp.i.IHpExtService;
import iih.bd.pp.hp.i.IHpRService;
import iih.bd.pp.hp.s.bp.SetupHpOrSrvCaBp;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.sf.core.util.ServiceFinder;

@Service(serviceInterfaces = { IHpExtService.class }, binding = Binding.JSONRPC)
public class HpExtServiceImpl implements IHpExtService {

	@Override
	public HpAggDO FindById(String id_hp) throws BizException {
		IHpRService hpRService = ServiceFinder.find(IHpRService.class);
		HpAggDO result = hpRService.findById(id_hp);
		SetupHpOrSrvCaBp bp = new SetupHpOrSrvCaBp();
		bp.exec(result);
		return result;
	}

	// @Override
	// public HpSrvOrCaDO getHpSrvTpByCode(String hpCode, String idSrv)
	// throws BizException {
	// return new GetHpSrvTpBp().getHpSrvTpByCode(hpCode, idSrv);
	// }
	//
	// @Override
	// public HpSrvOrCaDO getHpSrvTpById(String hpId, String idSrv)
	// throws BizException {
	// return new GetHpSrvTpBp().getHpSrvTpById(hpId, idSrv);
	// }
	//
	// @Override
	// public Map<String, HpSrvOrCaDO> getHpSrvOrCaDOMap(String hpId,
	// String[] arrIdSrv) throws BizException {
	// return new GetHpSrvTpBp().getHpSrvOrCaDOMap(hpId, arrIdSrv);
	// }

}
