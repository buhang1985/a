package iih.en.pv.s.rule;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.en.comm.IEnRuleConst;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnLogUtil;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.SupplyTicketRuleDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.lui.system.rulemgr.XapRuleAPI;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 补号规则引擎
 * 
 * @author liubin
 *
 */
public class SupplyTicketRuleBP {
	
	
	
	/**
	 * 根据规则，处理排班号源
	 * 
	 * @param entId 就诊id
	 * @param aptId 预约id
	 * @return
	 * 
	 * 	IScDictCodeConst.SC_CANC_RULE_RELEASE = "01";//退号后，释放原号，可以再次使用
	 *  IScDictCodeConst.SC_CANC_RULE_SUPPLY = "02";//退号后，作废原号位，并补充一个号，可使用补充号
	 *  IScDictCodeConst.SC_CANC_RULE_USED = "03";//退号后，不释放原号位，原号不可再次被使用
	 *  IScDictCodeConst.SC_CANC_RULE_PAST = "04";//退号后，不释放原号位，原号位设置成过期状态 
	 */
	public String exec(String entId, String aptId){
		try{
			if(EnValidator.isEmpty(entId)
					&& EnValidator.isEmpty(aptId))
				return IScDictCodeConst.SC_CANC_RULE_RELEASE;
			//组装补号规则DTO
			SupplyTicketRuleDTO ruleDto = !EnValidator.isEmpty(entId) ?
					this.getRuleDtoByEntId(entId) : this.getRuleDtoByAptId(aptId);
			if(ruleDto == null)
				return IScDictCodeConst.SC_CANC_RULE_RELEASE;
			FDateTime nowTime = EnAppUtils.getServerDateTime();
			ruleDto.setD_canc(nowTime.getBeginDate());
			ruleDto.setDt_canc(nowTime);
			Map<String, Object> map = new HashMap<>();
			map.put(SupplyTicketRuleDTO.class.getSimpleName(), ruleDto);
			Map<String, Object> rstMap = XapRuleAPI.exeRule(IEnRuleConst.EN_CANC_SUPPLYTICKET_CODE, map);
			return ruleResultPro(rstMap);			
		}catch(Exception ex){
			EnLogUtil.getInstance().logError("补号规则引擎出错！", ex);
		}
		return IScDictCodeConst.SC_CANC_RULE_RELEASE;
	}
	/**
	 * 规则结果处理
	 * 
	 * @param map
	 * @return
	 */
	private String ruleResultPro(Map<String, Object> map){
		String res = IScDictCodeConst.SC_CANC_RULE_RELEASE;
		if(map == null || map.isEmpty())
			return res;
		
		for(String code : map.keySet()){
			Object resultObj = map.get(code);
			if(resultObj == null || !(resultObj instanceof String))
				continue;
			String result = (String)resultObj;
			if (IScDictCodeConst.SC_CANC_RULE_RELEASE.equals(result)
					|| IScDictCodeConst.SC_CANC_RULE_SUPPLY.equals(result)
					|| IScDictCodeConst.SC_CANC_RULE_USED.equals(result)
					|| IScDictCodeConst.SC_CANC_RULE_PAST.equals(result)) {
				res = StringUtil.compare(res, result) < 0 ? result : res;
			}
		}
		return res;
	}
	/**
	 * 组装补号规则DTO
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	private SupplyTicketRuleDTO getRuleDtoByEntId(String entId) throws BizException {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT EN.ID_ENT,");
		sql.append("       EN.ID_PAT," );
		sql.append("       EN.DT_INSERT AS DT_REGIST," );
		sql.append("       OP.ID_SCHAPT," );
		sql.append("       OP.SD_STATUS AS SD_STATUS_OP," );
		sql.append("       OP.EU_REGTP," );
		sql.append("       OP.ID_SCH," );
		sql.append("       SCH.D_SCH," );
		sql.append("       APT.DT_APPT," );
		sql.append("       APT.SD_STATUS AS SD_STATUS_APT," );
		sql.append("       (SELECT MAX(TICK.T_E) FROM SC_TICK TICK WHERE (TICK.ID_TICK = OP.ID_TICK OR TICK.ID_TICK_OCCUPIER = APT.ID_TICK) AND TICK.ID_SCH = SCH.ID_SCH) AS T_E," );
		sql.append("       CHL.SD_SCCHLTP AS SD_SCCHL," );
		sql.append("       DEP.ID_DEP," );
		sql.append("       DEP.CODE AS CODE_DEP " );
		sql.append(" FROM EN_ENT EN " );
		sql.append(" INNER JOIN EN_ENT_OP OP ON EN.ID_ENT = OP.ID_ENT " );
		sql.append(" INNER JOIN SC_SCH SCH ON OP.ID_SCH = SCH.ID_SCH " );
		sql.append(" LEFT JOIN SC_APT APT ON OP.ID_SCHAPT = APT.ID_APT " );
		sql.append(" LEFT JOIN SC_CHL CHL ON APT.ID_SCCHL = CHL.ID_SCCHL " );
		sql.append(" LEFT JOIN BD_DEP DEP ON OP.ID_DEP_REG = DEP.ID_DEP " );
		sql.append(" WHERE EN.ID_ENT = ? ");
		SqlParam param = new SqlParam();
		param.addParam(entId);
		@SuppressWarnings("unchecked")
		List<SupplyTicketRuleDTO> list = (List<SupplyTicketRuleDTO>) new DAFacade().execQuery(sql.toString(), param, new BeanListHandler(SupplyTicketRuleDTO.class));
		if(!EnValidator.isEmpty(list))
			return list.get(0);
		return null;
	}
	
	/**
	 * 组装补号规则DTO
	 * 
	 * @param aptId
	 * @return
	 * @throws BizException
	 */
	private SupplyTicketRuleDTO getRuleDtoByAptId(String aptId) throws BizException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT APT.ID_APT,");
		sql.append("       APT.ID_PAT," );
		sql.append("       APT.ID_SCH," );
		sql.append("       SCH.D_SCH," );
		sql.append("       APT.DT_APPT," );
		sql.append("       APT.SD_STATUS AS SD_STATUS_APT," );
		sql.append("       (SELECT MAX(TICK.T_E) FROM SC_TICK TICK WHERE (TICK.ID_TICK = APT.ID_TICK OR TICK.ID_TICK_OCCUPIER = APT.ID_TICK) AND TICK.ID_SCH = SCH.ID_SCH) AS T_E," );
		sql.append("       CHL.SD_SCCHLTP AS SD_SCCHL," );
		sql.append("       DEP.ID_DEP," );
		sql.append("       DEP.CODE AS CODE_DEP " );
		sql.append(" FROM SC_APT APT " );
		sql.append(" INNER JOIN SC_APT_OP APTOP ON APT.ID_APT = APTOP.ID_APT " );
		sql.append(" INNER JOIN SC_SCH SCH ON APT.ID_SCH = SCH.ID_SCH " );
		sql.append(" LEFT JOIN SC_CHL CHL ON APT.ID_SCCHL = CHL.ID_SCCHL " );
		sql.append(" LEFT JOIN BD_DEP DEP ON APTOP.ID_DEP = DEP.ID_DEP " );
		sql.append(" WHERE APT.ID_APT = ? ");
		SqlParam param = new SqlParam();
		param.addParam(aptId);
		@SuppressWarnings("unchecked")
		List<SupplyTicketRuleDTO> list = (List<SupplyTicketRuleDTO>) new DAFacade().execQuery(sql.toString(), param, new BeanListHandler(SupplyTicketRuleDTO.class));
		if(!EnValidator.isEmpty(list))
			return list.get(0);
		return null;
	}
}
