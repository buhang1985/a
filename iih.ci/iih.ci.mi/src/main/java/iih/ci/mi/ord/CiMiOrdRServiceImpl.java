package iih.ci.mi.ord;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hp.i.IHpMDORService;
import iih.ci.mi.ord.bp.GetOrdIndicVerifyBP;
import iih.ci.mi.ord.bp.GetOrdRuleVerifyBP;
import iih.ci.mi.ord.bp.GetOrdSpecillVerifyRstBP;
import iih.ci.mi.ord.i.ICiMiOrdRService;
import iih.ci.mi.ord.i.meta.OrdIndicParamDTO;
import iih.ci.mi.ord.i.meta.OrdIndicRstDTO;
import iih.ci.mi.ord.i.meta.OrdRuleParamDTO;
import iih.ci.mi.ord.i.meta.OrdRuleRstDTO;
import iih.ci.mi.ord.i.meta.OrdSpecillParamDTO;
import iih.ci.mi.ord.i.meta.OrdSpecillRstDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.ICiOrdNSysParamConst;
import iih.mi.itf2.util.MiParamUtil;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

public class CiMiOrdRServiceImpl implements ICiMiOrdRService {

	@Override
	public String getParentIdHp(String id_hp) throws BizException{
		
		IHpMDORService iHpRService = (IHpMDORService)ServiceFinder.find(IHpMDORService.class);
		HPDO hpDO = iHpRService.findById(id_hp);
		
		return hpDO.getId_par();
	}
	
	@Override
	public boolean isEnabledMedicalShareVerify(CiEnContextDTO ctx) throws BizException {
		
		if (StringUtils.isEmpty(ctx.getId_hp())) {
			return false;
		}
		
		return MiParamUtil.MI3012(ctx.getId_hp()).booleanValue();
	}
	
	@Override
	public boolean isEnabledIndicVerify(CiEnContextDTO ctx) throws BizException {
		
		String indicationVerifyEnType = ParamsetQryUtil.getParaString(ctx.getId_org(), ICiOrdNSysParamConst.SYS_PARAM_indicationVerifyEnType);
		if(StringUtils.isEmpty(indicationVerifyEnType)){
			return false;
		}
		
		return Arrays.asList(indicationVerifyEnType.split(",")).contains(ctx.getCode_entp());
	}
	
	@Override
	public List<OrdRuleRstDTO> checkWholeRule(CiEnContextDTO ctx, List<OrdRuleParamDTO> orderList) throws BizException {

		GetOrdRuleVerifyBP bp = new GetOrdRuleVerifyBP();
		return bp.exec(ctx, orderList);
	}

	@Override
	public List<OrdIndicRstDTO> checkIndicationRule(CiEnContextDTO ctx, List<OrdIndicParamDTO> orderList)
			throws BizException {

		GetOrdIndicVerifyBP bp = new GetOrdIndicVerifyBP();
		return bp.exec(ctx, orderList);
	}

	@Override
	public List<OrdSpecillRstDTO> getPatSpecillVerify(CiEnContextDTO ctx, List<OrdSpecillParamDTO> orderParamList)
			throws BizException {

		GetOrdSpecillVerifyRstBP bp = new GetOrdSpecillVerifyRstBP();
		return bp.exec(ctx, orderParamList);
	}
	
	

}
