package iih.bd.pp.service.s;

import iih.bd.pp.anhuisrvorca.d.SrvCompDTO;
import iih.bd.pp.hpdivshisdto.d.HpDiVsHisDTO;
import iih.bd.pp.service.bp.GetHpDiVsHisDiBp;
import iih.bd.pp.service.i.IPpHpQryService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

/**
 * 获取诊断对照
 * @author yangyang
 */
/**
 * @author yangyang
 *
 */
@Service(serviceInterfaces={IPpHpQryService.class}, binding=Binding.JSONRPC)
public class PpHpQryServiceImpl implements IPpHpQryService {

	
	/* 
	 * 获取医保诊断对照信息
	 */
	@Override
	public HpDiVsHisDTO[] getHpDiVsHisDi(String strIdHp,String[] strHisIdDiArr) throws BizException{
		GetHpDiVsHisDiBp handlerBp=new GetHpDiVsHisDiBp();
		return handlerBp.getHpDiVsHisDi(strIdHp, strHisIdDiArr);
	}

	@Override
	public SrvCompDTO[] getSrvCompDtoLst(String strIdHp, String[] strIdSrv)
			throws BizException {
		
		return null;
	}

}
