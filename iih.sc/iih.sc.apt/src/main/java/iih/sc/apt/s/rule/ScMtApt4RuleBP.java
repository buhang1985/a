package iih.sc.apt.s.rule;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.en.pv.dto.d.SupplyTicketRuleDTO;
import iih.sc.apt.dto.d.ScMtApt4RuleDTO;
import iih.sc.apt.i.IScAptQryService;
import iih.sc.comm.IScRuleConst;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScLogUtil;
import iih.sc.comm.ScValidator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import xap.lui.core.scriptrule.XapScriptAPI;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 医技自助预约规则引擎
 * 
 * @author yzh
 *
 */
public class ScMtApt4RuleBP {
	
	/**
	 * 申请单是否可以医技预约
	 * 
	 * @param id_aptappl 预约申请单id
	 * @return
	 */
	public FBoolean exec(String id_aptappl,String id_apt,String rule_type,String chlType){
		try{
			if(ScValidator.isEmptyIgnoreBlank(rule_type)){
				return FBoolean.FALSE;
			}
			if(ScValidator.isEmptyIgnoreBlank(id_aptappl) && IScDictCodeConst.RULE_SC_MT_APT.equals(rule_type)){
				return FBoolean.FALSE;
			}
			if(ScValidator.isEmptyIgnoreBlank(id_apt) && (IScDictCodeConst.RULE_SC_MT_CANC_APT.equals(rule_type) || IScDictCodeConst.RULE_SC_MT_CHANGE_APT.equals(rule_type))){
				return FBoolean.FALSE;
			}
			//组装规则DTO
			ScMtApt4RuleDTO ruleDTO = this.getRuleDtoById(id_aptappl,id_apt,rule_type);
			//设置规则类型:0-预约;1-退约
			if(ruleDTO == null){
				return FBoolean.FALSE;
			}
			ruleDTO.setRule_type(rule_type);
			ruleDTO.setChl_type(chlType);
			ruleDTO.setTimes_canc_emg(ruleDTO.getTimes_canc_emg() == null?0:ruleDTO.getTimes_canc_emg());
			ruleDTO.setTimes_canc_fails(ruleDTO.getTimes_canc_fails() == null?0:ruleDTO.getTimes_canc_fails());
			ruleDTO.setTimes_canc_norm(ruleDTO.getTimes_canc_norm() == null?0:ruleDTO.getTimes_canc_norm());
			ruleDTO.setTimes_selfapt(ruleDTO.getTimes_selfapt() == null?0:ruleDTO.getTimes_selfapt());
			Map<String, Object> map = new HashMap<>();
			map.put(ScMtApt4RuleDTO.class.getSimpleName(), ruleDTO);
			boolean result = XapScriptAPI.Rule(IScRuleConst.SC_MT_APT_RULE, map, XapScriptAPI.operType_AND);
			return new FBoolean(result);
		}catch(Exception ex){
			ScLogUtil.getInstance().logError("医技预约规则引擎出错:"+ex.getMessage());
		}
		return FBoolean.FALSE;
	}
	/**
	 * 组装医技预约规则DTO
	 * 
	 * @param id_aptappl
	 * @return
	 * @throws BizException
	 */
	private ScMtApt4RuleDTO getRuleDtoById(String id_aptappl,String id_apt,String rule_type) throws BizException {
		ScMtApt4RuleDTO result = null;
		StringBuilder sql = new StringBuilder();
		sql.append(" select appl.times_canc_fails,")
       .append(" appl.times_canc_norm,")
       .append(" appl.times_canc_emg,")
       .append(" appl.times_selfapt,")
       .append(" appl.id_dep_mp,")
       .append(" apt.dt_b,")
       .append(" sch.d_sch,")
       .append(" apt.id_scchl,")
       .append(" apt.id_scca,")
       .append(" apt.id_apt")
       .append(" from sc_apt_appl appl")
       .append(" left join sc_apt apt on appl.id_scapt = apt.id_apt")
       .append(" left join sc_sch sch on sch.id_sch = apt.id_sch")
       .append(" where 1=2");
		SqlParam param = new SqlParam();
       if(IScDictCodeConst.RULE_SC_MT_APT.equals(rule_type)){
    	   sql.append(" or appl.id_aptappl = ?");
    	   param.addParam(id_aptappl);
       }
       if(IScDictCodeConst.RULE_SC_MT_CANC_APT.equals(rule_type) || IScDictCodeConst.RULE_SC_MT_CHANGE_APT.equals(rule_type)){
    	   sql.append(" or apt.id_apt = ?");
    	   param.addParam(id_apt);
       }
		@SuppressWarnings("unchecked")
		List<ScMtApt4RuleDTO> list = (List<ScMtApt4RuleDTO>) new DAFacade().execQuery(sql.toString(), param, new BeanListHandler(ScMtApt4RuleDTO.class));
		if(!ListUtil.isEmpty(list)){
			list.get(0).setNow(ScAppUtils.getServerDateTime());
			result= list.get(0);
			if(IScDictCodeConst.RULE_SC_MT_CANC_APT.equals(rule_type) || IScDictCodeConst.RULE_SC_MT_CHANGE_APT.equals(rule_type)){
				IScAptQryService iscaptqryservice = ServiceFinder.find(IScAptQryService.class);
				String canc_apt_type = iscaptqryservice.getCancMtAptType(result.getId_scca(), result.getId_dep_mp(), id_apt);
				result.setCanc_apt_type(canc_apt_type);
			}
		}
		return result;
	}
}
