package iih.ci.mi.ord.bp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import iih.ci.mi.external.obtain.mi.ICiMiMcRService;
import iih.ci.mi.external.obtain.mi.bp.BasicMiVerifyBP;
import iih.ci.mi.ord.i.meta.OrdRuleParamDTO;
import iih.ci.mi.ord.i.meta.OrdRuleRstDTO;
import iih.ci.mi.ord.i.meta.OrdSrvRuleParamDTO;
import iih.ci.mi.ord.i.meta.OrdSrvRuleRstDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * 医保规则校验
 * 
 * @author HUMS
 *
 */
public class GetOrdRuleVerifyBP extends BasicOrdMiVerifyBP{

	private ICiMiMcRService ciMiMcRService;

	public GetOrdRuleVerifyBP() {
		ciMiMcRService = ServiceFinder.find(ICiMiMcRService.class);
	}

	public List<OrdRuleRstDTO> exec(CiEnContextDTO ctx, List<OrdRuleParamDTO> orderList) throws BizException {

		// 未启用医保适应症校验
		if(!isMiVerifyEnabled(ctx)){
			return getDisabledOrdRuleRst(ctx,orderList);
		}
		
		if(!isHpPat(ctx)){
			return getDisabledOrdRuleRst(ctx,orderList);
		}
				
		List<OrdRuleRstDTO> orderRstList = ciMiMcRService.checkWholeRule(ctx, orderList);

		return orderRstList;
	}
	
	@Override
	public boolean isEnabledVerify(CiEnContextDTO ctx) throws BizException {
		
		String codeEntpStr = ParamsetQryUtil.getParaString(ctx.getId_org(),"CIOR0530");
		if(StringUtils.isEmpty(codeEntpStr)){
			return false;
		}
		
		return Arrays.asList(codeEntpStr.split(",")).contains(ctx.getCode_entp());
	}

	
	/**
	 * 未启用医保校验时反回结果
	 * @param ctx
	 * @param orderList
	 * @return
	 */
	private List<OrdRuleRstDTO> getDisabledOrdRuleRst(CiEnContextDTO ctx, List<OrdRuleParamDTO> orderList){
		
		List<OrdRuleRstDTO> ordRuleRstList = new ArrayList<OrdRuleRstDTO>();
		for(OrdRuleParamDTO order :  orderList){
			OrdRuleRstDTO ordRuleRst = getDefaultOrdRuleRst(ctx,order);
			ordRuleRstList.add(ordRuleRst);
		}
		return ordRuleRstList;
	}

	
	private OrdRuleRstDTO getDefaultOrdRuleRst(CiEnContextDTO ctx, OrdRuleParamDTO order){
		
		OrdRuleRstDTO ordRuleRst = new OrdRuleRstDTO();
		ordRuleRst.setId_or(order.getId_or());
		ordRuleRst.setCode_or(order.getCode_or());
		ordRuleRst.setName_or(order.getName_or());

		ordRuleRst.setSd_srvtp(order.getSd_srvtp());
		ordRuleRst.setId_srv(order.getId_srv());
		ordRuleRst.setCode_srv(order.getCode_srv());
		ordRuleRst.setName_srv(order.getName_srv());

		for (OrdSrvRuleParamDTO ordSrv : order.getOrdSrvRuleParamList()) {

			OrdSrvRuleRstDTO ordSrvRst = new OrdSrvRuleRstDTO();

			ordSrvRst.setId_dsdef(ordSrv.getId_dsdef());
			ordSrvRst.setCode_dsdef(ordSrv.getCode_dsdef());
			ordSrvRst.setName_dsdef(ordSrv.getName_dsdef());

			ordSrvRst.setSd_srvtp(ordSrv.getSd_srvtp());
			ordSrvRst.setId_srv(ordSrv.getId_srv());
			ordSrvRst.setCode_srv(ordSrv.getCode_srv());
			ordSrvRst.setName_srv(ordSrv.getName_srv());

			ordSrvRst.setId_mm(ordSrv.getId_mm());
			ordSrvRst.setCode_mm(ordSrv.getCode_mm());
			ordSrvRst.setName_mm(ordSrv.getName_mm());
			
			ordRuleRst.addChild(ordSrvRst);
		}
		
		return ordRuleRst;
	}
}
