package iih.ci.ord.s.bp.ems.save.op;

import java.util.List;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.cfg.cirulecfg.d.RuleCheckPoint;
import iih.ci.ord.cfg.cirulecfg.d.RuleType;
import iih.ci.ord.cfg.cirulecfg.d.RuleUseScope;
import iih.ci.ord.cfg.dto.msg.d.RuleMsgDTO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.i.ICiOrdNSysParamConst;
import iih.ci.ord.i.cfg.rulecfg.meta.RuleCfgParamDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.JudgeOrderStatusBP;
import iih.ci.ord.s.bp.cfg.RuleCfgConstant;
import iih.ci.ord.s.bp.cfg.rulecfg.AbstractRuleValidator;
import iih.ci.ord.s.bp.cfg.rulecfg.AbstractValidator;
import iih.ci.ord.s.bp.cfg.rulecfg.RuleCfgChainFacory;
import iih.ci.ord.s.bp.validate.CiOrOpenEntStatusValidateBP;
import iih.ci.ord.s.ems.op.order.LimitOnesOrderDaysBP;
import iih.ci.ord.s.utils.GetOrdValidateInfoBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.BizRuntimeException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * 医嘱开立时，医嘱有效性校验操作BP
 */
public class CiOrOpenEmsInvalidateBP {
	/**
	 * 医嘱开立时，医嘱有效性校验
	 * @param ems
	 * @throws BizException
	 */
	public void exec(CiEmsDTO ems) throws BizException{
		//科室排斥校验
		ordWhDeptValidate(ems);
		//添加临床开单控制校验
		//是否开启临床控制
		FBoolean isCiOpenControl = new FBoolean(false);
		isCiOpenControl = ParamsetQryUtil.getParaBoolean(CiOrdAppUtils.getEnvContext().getOrgId(), ICiOrdNSysParamConst.SYS_PARAM_IsCiOpenControl);
		
		if(FBoolean.TRUE.equals(isCiOpenControl)){
			// 药品开单量校验 
			checkExcessiveReason(ems);
			new CheckExcessiveReasonBp().exe(ems);
		}
		
		//0132838: 限制同一人同一个药品的处方，不能超30天的数量，比如某人某药品开了30天，此后24天内此人不能再开此药
		//如果是慢性病
		FBoolean isCiQuanControl = new FBoolean(true);
		isCiQuanControl = ParamsetQryUtil.getParaBoolean(CiOrdAppUtils.getEnvContext().getOrgId(), ICiOrdNSysParamConst.SYS_PARAM_ORDERQUANLIMIT);
		if(FBoolean.TRUE.equals(isCiQuanControl)&&ems.getId_excessive_reason()!=null && ems.getId_excessive_reason().equals(ICiDictCodeConst.ID_EXCESSIVE_REASON_CHRONIC)){
			int srvlength = ems.getEmssrvs().size();
			String[] idsrv = new String[srvlength];
			for(int i=0;i<srvlength;i++){
				idsrv[i] = ((CiEmsSrvDTO)ems.getEmssrvs().get(i)).getId_srv();
			}
			LimitOnesOrderDaysBP limitDayBP = new LimitOnesOrderDaysBP();
			String rst = limitDayBP.exec(idsrv, ems.getId_pat());
			if(rst!=""){
				throw new BizException(rst);
			}
		}
		
		//sv校验
		orSvValidate(ems);
		//人员就诊状态校验
		//orSrvEntStatusValidate(ems);
		//医嘱开立,服务互斥有效性校验
		orSrvReactValidate(ems);
		
		//....
	}
	/**
	 * 科室排斥校验
	 * @param ems
	 * @throws BizException
	 */
	private void ordWhDeptValidate(CiEmsDTO ems) throws BizException{
		GetOrdValidateInfoBP bp=new GetOrdValidateInfoBP();
		String error=bp.getOrdWhDeptValidateInfo(ems);
		if(!CiOrdUtils.isEmpty(error)) {
			throw new BizException(error);
		}
	}
	private void orSvValidate(CiEmsDTO ems) throws BizException{
		//只处理住院的情况
		if(!IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(ems.getCode_entp())) return;
		if(ems.getStatus()==DOStatus.NEW) return;//值判断编辑的情况
		CiOrderDO ordo = new CiOrderDO();
		ordo.setName_or(ems.getName());
		ordo.setSv(ems.getSv());
		ordo.setId_or(ems.getId_or());
		JudgeOrderStatusBP bp = new JudgeOrderStatusBP();
		String errorInfo = bp.exe(new CiOrderDO[]{ordo});
		if(!CiOrdUtils.isEmpty(errorInfo)) throw new BizException(errorInfo);
	}
	private void orSrvEntStatusValidate(CiEmsDTO ems) throws BizException{
		CiOrOpenEntStatusValidateBP bp = new CiOrOpenEntStatusValidateBP();
		bp.exec(ems.getCode_entp(), ems.getId_en(), ems.getId_dep_phy(),ems.getId_dept_ns());
	}
	/**
	 * 医嘱开立服务互斥有效性校验
	 * @param ems
	 * @throws BizException
	 */
	private void orSrvReactValidate(CiEmsDTO ems) throws BizException{
		CiOrOpenOrSrvReactValidateBP bp = new CiOrOpenOrSrvReactValidateBP();
		bp.exec(ems);
		
	}
	/**
	 * 校验是否超量开单
	 * 
	 * @param ctx 当前就诊环境
	 * @param drugItem 医嘱对象
	 */
	private void checkExcessiveReason(CiEmsDTO ciEms) {
		
		// 只判断西成药
		if(!ciEms.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG)){
			return ;
		}

		int maxUseDays = 0;
		StringBuffer msgBuffer = null;
		
		RuleCfgParamDTO ruleCfgParam = new RuleCfgParamDTO();
		
		ruleCfgParam.setCode_entp(ciEms.getCode_entp());
		ruleCfgParam.setCheck_point(RuleCheckPoint.SIGN);
		ruleCfgParam.setRule_type(RuleType.VALIDATOR_EXCESSIVE);
		
		if(IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(ciEms.getCode_entp())
				||IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW.equals(ciEms.getCode_entp())
				||IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID.equals(ciEms.getCode_entp())){
			ruleCfgParam.setUse_scope(RuleUseScope.RULE_USE_OP);
		}else if(IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(ciEms.getCode_entp())
				||IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS.equals(ciEms.getCode_entp())){
			ruleCfgParam.setUse_scope(RuleUseScope.RULE_USE_IP);
		}
		// 获取病执行校验规则
		RuleCfgChainFacory<CiEmsDTO> ruleCfgChain = new RuleCfgChainFacory<CiEmsDTO>();
		AbstractRuleValidator<CiEmsDTO> validator = ruleCfgChain.getRuleValidatorChain(ruleCfgParam);
		List<RuleMsgDTO> ruleMsgList = validator.startValidate(null, ciEms); //CIOR0020
		
		// 构造提示异常信息
		if (ruleMsgList != null && ruleMsgList.size() > 0) {
			msgBuffer = new StringBuffer();
			for (RuleMsgDTO ruleMsg : ruleMsgList) {
				if(ruleMsg.getExt_content().containsKey(RuleCfgConstant.MAX_USE_DAYS)){
					Object maxUseDaysObj =  ruleMsg.getExt_content().get(RuleCfgConstant.MAX_USE_DAYS);
					int tempMaxUseDays = Integer.parseInt(maxUseDaysObj.toString());
					if(tempMaxUseDays > maxUseDays){
						maxUseDays = tempMaxUseDays;
					}
					msgBuffer.append("," + ruleMsg.getContent());
					String msg = msgBuffer.substring(1) + "用药超过%s天,请填写超量开单原因。";
					msg = String.format(msg, String.valueOf(maxUseDays));
					throw new BizRuntimeException(msg);
				}else if(ruleMsg.getExt_content().containsKey(RuleCfgConstant.MAX_MONEY)){
					throw new BizRuntimeException(ruleMsg.getContent());
				}
				
			}
			
		}
	}
}
