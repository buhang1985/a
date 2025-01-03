package iih.ci.mi.ord.bp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import iih.ci.mi.common.utils.MiEnContextUtil;
import iih.ci.mi.diag.i.meta.CiMiDiagDTO;
import iih.ci.mi.external.obtain.mi.ICiMiMcRService;
import iih.ci.mi.ord.i.meta.OrdSpecillParamDTO;
import iih.ci.mi.ord.i.meta.OrdSpecillRstDTO;
import iih.ci.mi.ord.i.meta.OrdSrvSpecillParamDTO;
import iih.ci.mi.ord.i.meta.OrdSrvSpecillRstDTO;
import iih.ci.mi.sysparam.CiMiParamUtil;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.ordext.d.HpJudgeRstEnum;
import iih.mi.mc.i.IMiMcRuleService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * 获取医保特殊病判断结果
 * @author HUMS
 *
 */
public class GetOrdSpecillVerifyRstBP extends BasicOrdMiVerifyBP{

	private ICiMiMcRService ciMiMcRService;
	private IMiMcRuleService miMcRuleService;

	public GetOrdSpecillVerifyRstBP() {
		ciMiMcRService = ServiceFinder.find(ICiMiMcRService.class);
		miMcRuleService = ServiceFinder.find(IMiMcRuleService.class);
	}
	
	@Override
	public boolean isEnabledVerify(CiEnContextDTO ctx) throws BizException {
		
		String indicationVerifyEnType = ParamsetQryUtil.getParaString(ctx.getId_org(), "CIOR0529");
		if (StringUtils.isEmpty(indicationVerifyEnType)) {
			return false;
		}
		
		return MiEnContextUtil.IsHpSpecillPat(ctx) && Arrays.asList(indicationVerifyEnType.split(",")).contains(ctx.getCode_entp());
	}
	
	/**
	 * 获取特殊病判断结果
	 * @param ctx
	 * @param orderParam
	 * @return
	 * @throws BizException 
	 */
	public List<OrdSpecillRstDTO> exec(CiEnContextDTO ctx, List<OrdSpecillParamDTO> orderParamList) throws BizException{
		
		 List<OrdSpecillRstDTO> ordRstList = new ArrayList<OrdSpecillRstDTO>();
		 
		 List<OrdSrvSpecillParamDTO> ordSrvMmList = new ArrayList<OrdSrvSpecillParamDTO>();
		 //  未启用医保
		 if(!this.isEnabledVerify(ctx)){
			 
			 List<OrdSpecillRstDTO> defaultOrdRstList = this.getDefaultSpecillVerifyRst(ctx, orderParamList);
			 for(OrdSpecillRstDTO ordRst : defaultOrdRstList){
				 List<OrdSrvSpecillRstDTO> ordSrvRstList = ordRst.getOrdSrvSpecillRstList();
				 for(OrdSrvSpecillRstDTO ordSrvRst : ordSrvRstList){
					 ordSrvRst.setFg_specdrug(FBoolean.FALSE);
					 ordSrvRst.setFg_specill(FBoolean.FALSE);
					 ordSrvRst.setMsg("不满足特殊病校验条件，未启用新医保！");
				 }
			 }
			 return defaultOrdRstList;
		 }
		 
		 // 不是特殊病患者
		 if(!MiEnContextUtil.IsHpSpecillPat(ctx)){
			 
			 List<OrdSpecillRstDTO> defaultOrdRstList = this.getDefaultSpecillVerifyRst(ctx, orderParamList);
			 for(OrdSpecillRstDTO ordRst : defaultOrdRstList){
				 List<OrdSrvSpecillRstDTO> ordSrvRstList = ordRst.getOrdSrvSpecillRstList();
				 for(OrdSrvSpecillRstDTO ordSrvRst : ordSrvRstList){
					 ordSrvRst.setFg_specdrug(FBoolean.FALSE);
					 ordSrvRst.setFg_specill(FBoolean.FALSE);
					 ordSrvRst.setMsg("不满足特殊病校验条件，患者【" + ctx.getName_pat() + "】不是特殊病患者！");
				 }
			 }
			 return defaultOrdRstList;
		 }
		 
		 // 获取当前诊断
		 List<CiMiDiagDTO> diagList = this.getMiDiagLsit(ctx.getId_en());
		 
		 // 是否存在特殊病诊断，非药品当存在特殊病诊断时，返回特殊病
		 FBoolean fg_specill = this.isContainsPatSpecillDiag(ctx.getId_hp(), ctx.getId_pat(), diagList);
		 
		 for(OrdSpecillParamDTO ordParam :  orderParamList){
			
			 List<OrdSrvSpecillParamDTO> ordSrvParamList = ordParam.getOrdSrvSpecillParamList();
			 
			 for(OrdSrvSpecillParamDTO ordSrv : ordSrvParamList){
				 // 检查、检验关联的物品，不进行特病药品判断，关联的物品fg_or = TRUE
				 if(ordSrv.getFg_mm() && FBoolean.TRUE.equals(ordSrv.getFg_or()) && HpJudgeRstEnum.HP.equals(ordSrv.getEu_orsrvhp())){
					 ordSrvMmList.add(ordSrv);
				 }
			 }
		 }
		 
		 Map<String, OrdSrvSpecillRstDTO> ordSrvMap = new HashMap<String, OrdSrvSpecillRstDTO>(); 
		 if(ordSrvMmList.size() > 0){
			 // 调用校验接口，返回校验结果；
			 List<OrdSrvSpecillRstDTO> ordSrvSpec = ciMiMcRService.checkPatSpecillDrug(ctx, diagList, ordSrvMmList);
			 for(OrdSrvSpecillRstDTO ordSrv : ordSrvSpec){
				 ordSrvMap.put(ordSrv.getKey(),ordSrv);
			 }
		 }
		 
		 for(OrdSpecillParamDTO ordParam :  orderParamList){			 
			 
			 OrdSpecillRstDTO ordRst = new OrdSpecillRstDTO();
			 ordRst.setId_pat(ctx.getId_pat());
			 ordRst.setId_hp(ctx.getId_hp());
			 ordRst.setSd_hptp(ctx.getSd_hptp());
			 ordRst.setFg_hpfundpay(ctx.getFg_hpfundpay());
			 ordRst.setId_en(ctx.getId_en());
			 ordRst.setCode_entp(ctx.getCode_entp());
			 
			 List<OrdSrvSpecillParamDTO> ordSrvParamList = ordParam.getOrdSrvSpecillParamList();
			 
			 for(OrdSrvSpecillParamDTO ordSrv : ordSrvParamList){
				 
				 OrdSrvSpecillRstDTO ordSrvRst = new OrdSrvSpecillRstDTO();
				 
				 ordSrvRst.setId_or(ordSrv.getId_or());
				 ordSrvRst.setId_orsrv(ordSrv.getId_orsrv());
				 ordSrvRst.setSd_srvtp(ordSrv.getSd_srvtp());
				 
				 ordSrvRst.setId_srv(ordSrv.getId_srv());
				 ordSrvRst.setCode_srv(ordSrv.getCode_srv());
				 ordSrvRst.setName_srv(ordSrv.getName_srv());
				 
				 ordSrvRst.setId_mm(ordSrv.getId_mm());
				 ordSrvRst.setCode_mm(ordSrv.getCode_mm());
				 ordSrvRst.setName_mm(ordSrv.getName_mm());
				 
				 ordSrvRst.setId_dsdef(ordSrv.getId_dsdef());
				 ordSrvRst.setCode_dsdef(ordSrv.getCode_dsdef());
				 ordSrvRst.setName_dsdef(ordSrv.getName_dsdef());
				 
				 ordSrvRst.setFg_bl(ordSrv.getFg_bl());
				 ordSrvRst.setFg_or(ordSrv.getFg_or());
				 ordSrvRst.setFg_self(ordSrv.getFg_self());
				 ordSrvRst.setEu_orsrvhp(ordSrv.getEu_orsrvhp());
				 
				 // 特殊标识，费用项目、符合医保、 有特殊病诊断（非药品）、特殊病药品判断结果
				 if(FBoolean.TRUE.equals(ordSrv.getFg_bl())){
					 
					 ordSrvRst.setFg_specdrug(fg_specill);
					 ordSrvRst.setFg_specill(fg_specill);
					 
					 if(HpJudgeRstEnum.HP.equals(ordSrv.getEu_orsrvhp())){
						 
						// 检查、检验关联的物品，不进行特病药品判断，关联的物品fg_or = TRUE
						 if(ordSrv.getFg_mm() && FBoolean.TRUE.equals(ordSrv.getFg_or())){
							 
							 OrdSrvSpecillRstDTO srv = ordSrvMap.get(ordSrvRst.getKey());
							 ordSrvRst.setFg_specdrug(srv.getFg_specdrug());
							 ordSrvRst.setFg_specill(srv.getFg_specill());
							 ordSrvRst.setMsg(srv.getMsg());
						 }
					 }else{
						 ordSrvRst.setFg_specdrug(FBoolean.FALSE);
						 ordSrvRst.setFg_specill(FBoolean.FALSE);
					 }
				 }
				 
				 ordRst.addChild(ordSrvRst);
			 }
			 
			 ordRstList.add(ordRst);
		 }
		 
		return ordRstList;
	}
	
	/**
	 * 获取特殊病判断结果
	 * @param ctx
	 * @param orderParam
	 * @return
	 * @throws BizException 
	 */
	public List<OrdSpecillRstDTO> getDefaultSpecillVerifyRst(CiEnContextDTO ctx, List<OrdSpecillParamDTO> orderParamList) throws BizException{
		
		List<OrdSpecillRstDTO> ordRstList = new ArrayList<OrdSpecillRstDTO>();
		 
		 for(OrdSpecillParamDTO ordParam :  orderParamList){			 
			 
			 OrdSpecillRstDTO ordRst = new OrdSpecillRstDTO();
			 ordRst.setId_pat(ctx.getId_pat());
			 ordRst.setId_hp(ctx.getId_hp());
			 ordRst.setSd_hptp(ctx.getSd_hptp());
			 ordRst.setFg_hpfundpay(ctx.getFg_hpfundpay());
			 ordRst.setId_en(ctx.getId_en());
			 ordRst.setCode_entp(ctx.getCode_entp());
			 
			 List<OrdSrvSpecillParamDTO> ordSrvParamList = ordParam.getOrdSrvSpecillParamList();
			 
			 for(OrdSrvSpecillParamDTO ordSrv : ordSrvParamList){
				 
				 OrdSrvSpecillRstDTO ordSrvRst = new OrdSrvSpecillRstDTO();
				 
				 ordSrvRst.setId_or(ordSrv.getId_or());
				 ordSrvRst.setId_orsrv(ordSrv.getId_orsrv());
				 ordSrvRst.setSd_srvtp(ordSrv.getSd_srvtp());
				 
				 ordSrvRst.setId_srv(ordSrv.getId_srv());
				 ordSrvRst.setCode_srv(ordSrv.getCode_srv());
				 ordSrvRst.setName_srv(ordSrv.getName_srv());
				 
				 ordSrvRst.setId_mm(ordSrv.getId_mm());
				 ordSrvRst.setCode_mm(ordSrv.getCode_mm());
				 ordSrvRst.setName_mm(ordSrv.getName_mm());
				 
				 ordSrvRst.setId_dsdef(ordSrv.getId_dsdef());
				 ordSrvRst.setCode_dsdef(ordSrv.getCode_dsdef());
				 ordSrvRst.setName_dsdef(ordSrv.getName_dsdef());
				 
				 ordRst.addChild(ordSrvRst);
			 }
			 
			 ordRstList.add(ordRst);
		 }
		 
		return ordRstList;
	}
	
	/**
	 * 特殊病患者是否存在特殊病诊断
	 * @param id_hp 医保计划id
	 * @param id_pat 患者id
	 * @param idDidefList 诊断定义id集合
	 * @return
	 * @throws BizException 
	 */
	protected FBoolean isContainsPatSpecillDiag(String id_hp, String id_pat ,List<CiMiDiagDTO> diagList) throws BizException{
		
		if (CiMiParamUtil.MHIR0001() != 1){
			return FBoolean.FALSE;
		}
		
		List<String> idDidefList = new ArrayList<String>();
		for(CiMiDiagDTO diag : diagList){
			idDidefList.add(diag.getId_didef());
		}
		
		FMap map = miMcRuleService.isPatSpecDi(id_hp, id_pat, idDidefList.toArray(new String[idDidefList.size()]));
		if(map ==null || map.size() ==0){
			return FBoolean.FALSE;
		}
		
		for(String key : map.keySet()){
			if(FBoolean.TRUE.equals(map.get(key))){
				return FBoolean.TRUE;
			}
		}
		
		return FBoolean.FALSE;
	}
}
