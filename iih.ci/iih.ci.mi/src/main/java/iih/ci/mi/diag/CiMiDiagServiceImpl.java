package iih.ci.mi.diag;

import iih.ci.mi.common.utils.MiEnContextUtil;
import iih.ci.mi.diag.i.ICiMiDiagService;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.mi.itf2.util.MiParamUtil;
import iih.mi.mc.i.IMiMcRuleService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.sf.core.util.ServiceFinder;

public class CiMiDiagServiceImpl implements ICiMiDiagService {

	@Override
	public int getSpecillDsdefModel() {
		return MiParamUtil.MHIR0001();// 0：采用病种模式；1:诊断模式;
	}

	@Override
	public FMap checkDiScopeRule(CiEnContextDTO ctx, String[] idDidefs) throws BizException {
		
		if(idDidefs == null || idDidefs.length ==0){
			return new FMap();
		}
		// 医保患者 判断自费诊断
		if(!MiEnContextUtil.isHpPat(ctx)){
			return new FMap();
		}
		
		IMiMcRuleService miMcRuleService = ServiceFinder.find(IMiMcRuleService.class);
		return miMcRuleService.checkDiScopeRule(ctx.getId_hp(), ctx.getCode_entp(), idDidefs);		
	}

}
