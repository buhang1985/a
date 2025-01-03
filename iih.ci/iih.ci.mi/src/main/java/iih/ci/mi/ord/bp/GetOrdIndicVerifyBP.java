package iih.ci.mi.ord.bp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import iih.ci.mi.external.obtain.mi.ICiMiMcRService;
import iih.ci.mi.ord.i.meta.OrdIndicParamDTO;
import iih.ci.mi.ord.i.meta.OrdIndicRstDTO;
import iih.ci.mi.ord.i.meta.OrdSrvIndicParamDTO;
import iih.ci.mi.ord.i.meta.OrdSrvIndicRstDTO;
import iih.ci.ord.ciorder.d.HpBeyondEnum;
import iih.ci.ord.ciorder.d.OrSourceFromEnum;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.ordext.d.HpJudgeEnum;
import iih.ci.ord.ordext.d.HpJudgeRstEnum;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * 适应症校验
 * 
 * @author HUMS
 *
 */
public class GetOrdIndicVerifyBP extends BasicOrdMiVerifyBP {

	private ICiMiMcRService ciMiMcRService;

	public GetOrdIndicVerifyBP() {
		ciMiMcRService = ServiceFinder.find(ICiMiMcRService.class);
	}

	public List<OrdIndicRstDTO> exec(CiEnContextDTO ctx, List<OrdIndicParamDTO> ordIndicList) throws BizException {

		// 未启用医保适应症校验
		if (!isMiVerifyEnabled(ctx)) {
			return getDisabledOrdIndicRst(ctx, ordIndicList);
		}

		// 非医保就诊
		if (!isHpPat(ctx)) {
			return getOrdListEnSelfpay(ctx, ordIndicList);
		}
		
		// 存在自费诊断
		if (HpBeyondEnum.HPEXTERNALDIAG.equals(ctx.getEu_hpbeyond())) {
			return getOrdListDiagSelfpay(ctx, ordIndicList);
		}

		// 医生自费开立
		if (!ordIndicList.get(0).getSd_srvtp().startsWith("01") && HpJudgeRstEnum.SELFPAY.equals(ordIndicList.get(0).getEu_orhp()) && HpJudgeEnum.DOCTOR_JUDGE.equals(ordIndicList.get(0).getEu_hpjudge())) {
			return getOrdSelfpay(ctx, ordIndicList);
		}
		// 非医疗单开立的设置为待判断
//		if(!OrSourceFromEnum.IIHSRVREF.equals(ordIndicList.get(0).getEu_orsrcmdtp())){
//			return this.getOrdWaitJudge(ctx, ordIndicList);
//		}
		if(OrSourceFromEnum.IIHSRVCAHELPER.equals(ordIndicList.get(0).getEu_orsrcmdtp()) 
				|| OrSourceFromEnum.IIHORTMPLHELPER.equals(ordIndicList.get(0).getEu_orsrcmdtp())
				|| OrSourceFromEnum.IIHPATIPASTHELPER.equals(ordIndicList.get(0).getEu_orsrcmdtp())){
			return this.getOrdWaitJudge(ctx, ordIndicList);
		}
		List<OrdIndicRstDTO> ordIndicRstLst = ciMiMcRService.checkIndicationRule(ctx, ordIndicList);

		return ordIndicRstLst;
	}

	@Override
	public boolean isEnabledVerify(CiEnContextDTO ctx) throws BizException {

		String indicationVerifyEnType = ParamsetQryUtil.getParaString(ctx.getId_org(), "CIOR0529");
		if (StringUtils.isEmpty(indicationVerifyEnType)) {
			return false;
		}

		return Arrays.asList(indicationVerifyEnType.split(",")).contains(ctx.getCode_entp());
	}
	
	/**
	 * 获取未启用医保校验返回结果
	 * 
	 * @param ctx
	 * @param order
	 * @return
	 */
	private List<OrdIndicRstDTO> getDisabledOrdIndicRst(CiEnContextDTO ctx, List<OrdIndicParamDTO> orderList) {

		List<OrdIndicRstDTO> ordIndecRstList = new ArrayList<OrdIndicRstDTO>();
		for (OrdIndicParamDTO order : orderList) {
			OrdIndicRstDTO ordIndicRst = this.getDefaultOrdIndicRst(ctx, order);
			for (OrdSrvIndicRstDTO ordSrvRst : ordIndicRst.getOrdSrvIndicRstList()) {
				
				ordSrvRst.setEu_hpjudge(HpJudgeEnum.DISABLED);
				ordSrvRst.setEu_orsrvhp(HpJudgeRstEnum.DISABLED);
				ordSrvRst.setDes_limit("未启用医保校验！");
			}
			ordIndecRstList.add(ordIndicRst);
		}

		return ordIndecRstList;
	}
	
	/**
	 * 获取非医保就诊的医保信息
	 * 
	 * @param ctx
	 * @param orderList
	 * @return
	 */
	public List<OrdIndicRstDTO> getOrdListEnSelfpay(CiEnContextDTO ctx, List<OrdIndicParamDTO> orderList) {

		List<OrdIndicRstDTO> ordIndecRstList = new ArrayList<OrdIndicRstDTO>();
		for (OrdIndicParamDTO order : orderList) {
			OrdIndicRstDTO ordIndicRst = this.getDefaultOrdIndicRst(ctx, order);
			for (OrdSrvIndicRstDTO ordSrvRst : ordIndicRst.getOrdSrvIndicRstList()) {
				ordSrvRst.setEu_hpjudge(HpJudgeEnum.NON_MEDICAL);
				ordSrvRst.setDes_limit("非医保就诊！");
				
				if(FBoolean.TRUE.equals(ordSrvRst.getFg_indicverify())){
					ordSrvRst.setEu_orsrvhp(HpJudgeRstEnum.SELFPAY);	
				}
			}
			ordIndecRstList.add(ordIndicRst);
		}

		return ordIndecRstList;
	}
	
	/**
	 * 存在自费诊断的医保信息
	 * 
	 * @param ctx
	 * @param orderList
	 * @return
	 */
	public List<OrdIndicRstDTO> getOrdListDiagSelfpay(CiEnContextDTO ctx, List<OrdIndicParamDTO> orderList) {

		List<OrdIndicRstDTO> ordIndecRstList = new ArrayList<OrdIndicRstDTO>();
		for (OrdIndicParamDTO order : orderList) {
			OrdIndicRstDTO ordIndicRst = this.getDefaultOrdIndicRst(ctx, order);
			for (OrdSrvIndicRstDTO ordSrvRst : ordIndicRst.getOrdSrvIndicRstList()) {
				
				if(FBoolean.TRUE.equals(ordSrvRst.getFg_indicverify())){
					ordSrvRst.setEu_hpjudge(HpJudgeEnum.SYSTEM_JUDGE);
					ordSrvRst.setDes_limit("存自费诊断！");
					ordSrvRst.setEu_orsrvhp(HpJudgeRstEnum.SELFPAY);
				}				
			}
			ordIndecRstList.add(ordIndicRst);
		}

		return ordIndecRstList;
	}
	
	/**
	 * 获取自费开立信息
	 * 
	 * @param ctx
	 * @param orderList
	 * @return
	 */
	public List<OrdIndicRstDTO> getOrdSelfpay(CiEnContextDTO ctx, List<OrdIndicParamDTO> orderList) {

		List<OrdIndicRstDTO> ordIndecRstList = new ArrayList<OrdIndicRstDTO>();
		for (OrdIndicParamDTO order : orderList) {
			OrdIndicRstDTO ordIndicRst = this.getDefaultOrdIndicRst(ctx, order);
			for (OrdSrvIndicRstDTO ordSrvRst : ordIndicRst.getOrdSrvIndicRstList()) {
				
				if(FBoolean.TRUE.equals(ordSrvRst.getFg_indicverify())){
					ordSrvRst.setEu_hpjudge(HpJudgeEnum.DOCTOR_JUDGE);
					ordSrvRst.setDes_limit("医生自费开立！");
					ordSrvRst.setEu_orsrvhp(HpJudgeRstEnum.SELFPAY);	
				}
			}
			ordIndecRstList.add(ordIndicRst);
		}

		return ordIndecRstList;
	}	

	/**
	 * 获取自费开立信息
	 * 
	 * @param ctx
	 * @param orderList
	 * @return
	 */
	public List<OrdIndicRstDTO> getOrdWaitJudge(CiEnContextDTO ctx, List<OrdIndicParamDTO> orderList) {

		List<OrdIndicRstDTO> ordIndecRstList = new ArrayList<OrdIndicRstDTO>();
		for (OrdIndicParamDTO order : orderList) {
			OrdIndicRstDTO ordIndicRst = this.getDefaultOrdIndicRst(ctx, order);
			for (OrdSrvIndicRstDTO ordSrvRst : ordIndicRst.getOrdSrvIndicRstList()) {
				if(!FBoolean.TRUE.equals(ordSrvRst.getFg_indicverify())){
					continue;
				}
				
				if(StringUtils.isEmpty(ordSrvRst.getEu_hpjudge())){
					ordSrvRst.setEu_hpjudge(HpJudgeEnum.WAITING_JUDGE);
					ordSrvRst.setDes_limit("待进行医保判断！");
					ordSrvRst.setEu_orsrvhp(HpJudgeRstEnum.WAITING_JUDGE);	
				}
			}
			ordIndecRstList.add(ordIndicRst);
		}

		return ordIndecRstList;
	}
	
	/**
	 * 获取医保适应症默认返回对象
	 * 
	 * @param ctx
	 * @param order
	 * @return
	 */
	private OrdIndicRstDTO getDefaultOrdIndicRst(CiEnContextDTO ctx, OrdIndicParamDTO order) {

		OrdIndicRstDTO ordIndicRst = new OrdIndicRstDTO();

		ordIndicRst.setId_en(ctx.getId_en());
		ordIndicRst.setId_hp(ctx.getId_hp());
		ordIndicRst.setCode_entp(ctx.getCode_entp());

		ordIndicRst.setId_or(order.getId_or());
		ordIndicRst.setCode_or(order.getCode_or());
		ordIndicRst.setName_or(order.getName_or());

		for (OrdSrvIndicParamDTO ordSrv : order.getOrdSrvIndicParamList()) {

			OrdSrvIndicRstDTO ordSrvRst = new OrdSrvIndicRstDTO();

			ordSrvRst.setId_orsrv(ordSrv.getId_orsrv());

			ordSrvRst.setSd_srvtp(ordSrv.getSd_srvtp());

			ordSrvRst.setId_srv(ordSrv.getId_srv());
			ordSrvRst.setCode_srv(ordSrv.getCode_srv());
			ordSrvRst.setName_srv(ordSrv.getName_srv());

			ordSrvRst.setId_mm(ordSrv.getId_mm());
			ordSrvRst.setCode_mm(ordSrv.getCode_mm());
			ordSrvRst.setName_mm(ordSrv.getName_mm());
			
			ordSrvRst.setPrice(ordSrv.getPrice());

			ordSrvRst.setId_dsdef(ordSrv.getId_dsdef());
			ordSrvRst.setCode_dsdef(ordSrv.getCode_dsdef());
			ordSrvRst.setName_dsdef(ordSrv.getName_dsdef());
			
			ordSrvRst.setFg_self(ordSrv.getFg_self());
			ordSrvRst.setFg_selfsrv(ordSrv.getFg_selfsrv());
			ordSrvRst.setFg_bl(ordSrv.getFg_bl());
			
			// 不需要进行医保判断的设置为不判断
			if(!FBoolean.TRUE.equals(ordSrv.getFg_indicverify())){
				
				ordSrvRst.setEu_hpjudge(HpJudgeEnum.NOT_JUDGE);
				ordSrvRst.setEu_orsrvhp(HpJudgeRstEnum.NOT_JUDGE);
				
				if(!FBoolean.TRUE.equals(ordSrv.getFg_bl())){					
					ordSrvRst.setEu_hpjudge(HpJudgeEnum.NON_BLITEM);	
				}
			}
			if(StringUtils.isNotEmpty(ordSrv.getEu_orsrvhp())){
				ordSrvRst.setEu_hpjudge(ordSrv.getEu_hpjudge());
				ordSrvRst.setEu_orsrvhp(ordSrv.getEu_orsrvhp());
			}
			ordIndicRst.addChild(ordSrvRst);
		}

		return ordIndicRst;
	}
}
