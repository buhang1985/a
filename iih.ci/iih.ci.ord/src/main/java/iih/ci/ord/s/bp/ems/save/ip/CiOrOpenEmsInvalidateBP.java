package iih.ci.ord.s.bp.ems.save.ip;

import java.util.List;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.cfg.cirulecfg.d.RuleCheckPoint;
import iih.ci.ord.cfg.cirulecfg.d.RuleType;
import iih.ci.ord.cfg.cirulecfg.d.RuleUseScope;
import iih.ci.ord.cfg.dto.msg.d.RuleMsgDTO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.i.ICiOrdNSysParamConst;
import iih.ci.ord.i.cfg.rulecfg.meta.RuleCfgParamDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.JudgeOrderStatusBP;
import iih.ci.ord.s.bp.cfg.RuleCfgConstant;
import iih.ci.ord.s.bp.cfg.rulecfg.AbstractRuleValidator;
import iih.ci.ord.s.bp.cfg.rulecfg.RuleCfgChainFacory;
import iih.ci.ord.s.bp.ems.save.ip.qry.CiIpTimeQry;
import iih.ci.ord.s.utils.GetOrdValidateInfoBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.BizRuntimeException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;
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
		// 药品开单量校验
		checkExcessiveReason(ems);
		//sv校验
		orSvValidate(ems);
		//人员就诊状态校验
		//orSrvEntStatusValidate(ems);
		//医嘱开立,服务互斥有效性校验
		orSrvReactValidate(ems);
		//住院时间校验
		checkIpTimeValicate(ems);
		
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
	private void checkIpTimeValicate(CiEmsDTO ems) throws BizException {
		if(!getTimeValParam().booleanValue()){
			return;
		}
		String id_en = ems.getId_en();
		FDateTime dt_begin = ems.getDt_begin();
		if(ems.getSd_srvtp()!=null &&IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_LEAVEHOS.equals(ems.getSd_srvtp())){
		CiIpTimeQry qry = new CiIpTimeQry(id_en);
		DAFacade facade = new DAFacade();
		SqlParam param = new SqlParam();
		param.addParam(id_en);
			String times = (String)facade.execQuery(qry.getQrySQLStr(),param,new ColumnHandler());
			int compareTo = new FDateTime(times).compareTo(dt_begin);
		if(compareTo==1){
			String errorInfo = "今日出院医嘱签署必须是在所有医嘱开立或者停止时间以后";
		    throw new BizException(errorInfo);
		}
			
		}
	}
	/**
	 * 是否校验今日出院医嘱签署必须是在所有医嘱开立或者停止时间以后 ，参数
	 * @return
	 */
	private FBoolean getTimeValParam(){
		try {
			return ParamsetQryUtil.getParaBoolean(Context.get().getOrgId(),
					ICiOrdNSysParamConst.SYS_PARAM_OUTORDERVALIDATETIME);
		} catch (BizException e) {
			return FBoolean.FALSE;
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
		
		// 获取病执行校验规则
		RuleCfgChainFacory<CiEmsDTO> ruleCfgChain = new RuleCfgChainFacory<CiEmsDTO>();
		
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
		
		AbstractRuleValidator<CiEmsDTO> validator = ruleCfgChain.getRuleValidatorChain(ruleCfgParam);
		List<RuleMsgDTO> ruleMsgList = validator.startValidate(null, ciEms);
		
		// 构造提示异常信息
		if (ruleMsgList != null && ruleMsgList.size() > 0) {
			msgBuffer = new StringBuffer();
			for (RuleMsgDTO ruleMsg : ruleMsgList) {
				Object maxUseDaysObj =  ruleMsg.getExt_content().get(RuleCfgConstant.MAX_USE_DAYS);
				if(maxUseDaysObj != null){
					int tempMaxUseDays = Integer.parseInt(maxUseDaysObj.toString());
					if(tempMaxUseDays > maxUseDays){
						maxUseDays = tempMaxUseDays;
					}
				}
				msgBuffer.append("," + ruleMsg.getContent());
			}
			String msg = msgBuffer.substring(1) + "用药超过%s天,请填写超量开单原因。";
			msg = String.format(msg, String.valueOf(maxUseDays));
			throw new BizRuntimeException(msg);
		}
	}
}
