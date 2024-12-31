package iih.ci.mi.external.obtain.mi;

import java.util.List;

import iih.ci.mi.diag.i.meta.CiMiDiagDTO;
import iih.ci.mi.external.obtain.mi.bp.GetMiIndicVerifyBP;
import iih.ci.mi.external.obtain.mi.bp.GetMiRuleVerifyBP;
import iih.ci.mi.external.obtain.mi.bp.GetMiSpecillVerifyBP;
import iih.ci.mi.ord.i.meta.OrdIndicParamDTO;
import iih.ci.mi.ord.i.meta.OrdIndicRstDTO;
import iih.ci.mi.ord.i.meta.OrdRuleParamDTO;
import iih.ci.mi.ord.i.meta.OrdRuleRstDTO;
import iih.ci.mi.ord.i.meta.OrdSrvSpecillParamDTO;
import iih.ci.mi.ord.i.meta.OrdSrvSpecillRstDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import xap.mw.core.data.BizException;

/**
 * 获取医保规则校验
 * @author HUMS
 *
 */
public class CiMiMcRServiceImpl implements ICiMiMcRService{

	@Override
	public List<OrdRuleRstDTO> checkWholeRule(CiEnContextDTO ctx , List<OrdRuleParamDTO> orderRuleList) throws BizException {

		GetMiRuleVerifyBP bp = new GetMiRuleVerifyBP();
		return bp.exec(ctx, orderRuleList);
	}

	@Override
	public List<OrdIndicRstDTO> checkIndicationRule(CiEnContextDTO ctx, List<OrdIndicParamDTO> orderIndicList)
			throws BizException {
		GetMiIndicVerifyBP bp = new GetMiIndicVerifyBP();
		return bp.exec(ctx, orderIndicList);
	}

	@Override
	public List<OrdSrvSpecillRstDTO> checkPatSpecillDrug(CiEnContextDTO ctx, List<CiMiDiagDTO> diagList,
			List<OrdSrvSpecillParamDTO> ordSrvParamList) throws BizException{
		GetMiSpecillVerifyBP bp= new GetMiSpecillVerifyBP();
		return bp.exec(ctx, diagList, ordSrvParamList);
	}
}
