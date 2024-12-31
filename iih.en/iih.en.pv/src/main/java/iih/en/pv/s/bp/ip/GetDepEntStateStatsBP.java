package iih.en.pv.s.bp.ip;

import iih.bd.fc.enstate.d.desc.BdEnStateDepDODesc;
import iih.bd.fc.enstatetpext.d.desc.BdEnStateTpExtDODesc;
import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.inpatient.dto.d.DepEntStateDTO;
import iih.en.pv.pativisit.d.desc.PatiVisitDODesc;
import iih.sc.pub.ScGroupControlUtils;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取科室就诊状况统计信息
 * 
 * @author renying
 *
 */
public class GetDepEntStateStatsBP {
	/**
	 * 获取科室就诊状况统计信息
	 * 
	 * @param depId
	 * @param entIds
	 * @return
	 * @throws BizException
	 */
	public DepEntStateDTO[] exec(String depId, String[] entIds) throws BizException {
		if(EnValidator.isEmpty(depId))
			return null;
		//1. 获取科室就诊状况
		DepEntStateDTO[] states = getDepEntStates(depId);
		if(EnValidator.isEmpty(states))
			return null;
		if(EnValidator.isEmpty(entIds))
			return states;
		//2.查询科室就诊状况数量
		DepEntStateDTO[] statesnum = getDepStateNum(entIds);
		//3.就诊状况设置数量
		SetSumPro(states, statesnum);
		return states;
	}
	/**
	 * 获取科室就诊状况统计信息
	 * 
	 * @param depId
	 * @param entIds
	 * @return
	 * @throws BizException
	 */
	public DepEntStateDTO[] exec(String depId) throws BizException {
		if(EnValidator.isEmpty(depId))
			return null;
		String[] entIds = getInHosEntIds(depId);
		return exec(depId, entIds);
	}
	/**
	 * 获取科室就诊状况
	 * 
	 * @param depId
	 * @return
	 * @throws BizException
	 */
	private DepEntStateDTO[] getDepEntStates(String depId) throws BizException{
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" SELECT DEPSTATE.SD_ENSTATETP AS SD_ENSTATETP, ");
		sqlBuilder.append(" DEPSTATE.ID_ENSTATETP AS ID_ENSTATETP, ");
		sqlBuilder.append(" DEPSTATE.Id_Enstate AS Id_entstate, ");
		sqlBuilder.append(" UDISTATE.NAME AS NAME_ENSTATETP, ");
		sqlBuilder.append(" DEPSTATE.LABEL AS LABEL, ");
		sqlBuilder.append(" DEPSTATE.SORTNO AS SORTNO, ");
		sqlBuilder.append(" DEPSTATE.VAL AS VAL, ");
		sqlBuilder.append(" DEPSTATE.LABEL AS NAME,");
		sqlBuilder.append(" EXTSTATE.FG_ENT AS FG_ENT,");
		sqlBuilder.append(" 0 as QUAN_PAT ");
		sqlBuilder.append(" FROM BD_EN_STATE_DEP DEPSTATE");
		sqlBuilder.append(" INNER JOIN BD_EN_STATETP_EXT EXTSTATE ON DEPSTATE.ID_ENSTATETP = EXTSTATE.ID_ENSTATETP ");
		sqlBuilder.append(" INNER JOIN BD_UDIDOC UDISTATE ON DEPSTATE.ID_ENSTATETP = UDISTATE.ID_UDIDOC ");
		sqlBuilder.append(" WHERE DEPSTATE.ID_DEP = ? ");
		String depStateOrgWhere = ScGroupControlUtils.getGroupControlFitler(new BdEnStateDepDODesc(), "DEPSTATE");//集团管控
		if(!EnValidator.isEmpty(depStateOrgWhere)){
			sqlBuilder.append(" AND ").append(depStateOrgWhere);
		}
		String stateExtOrgWhere = ScGroupControlUtils.getGroupControlFitler(new BdEnStateTpExtDODesc(), "EXTSTATE");//集团管控
		if(!EnValidator.isEmpty(stateExtOrgWhere)){
			sqlBuilder.append(" AND ").append(stateExtOrgWhere);
		}
		sqlBuilder.append(" ORDER BY DEPSTATE.SORTNO ");
		String sql = sqlBuilder.toString();
		SqlParam param = new SqlParam();
		param.addParam(depId);
		@SuppressWarnings("unchecked")
		List<DepEntStateDTO> list = (List<DepEntStateDTO>) new DAFacade().execQuery(sql, param, new BeanListHandler(DepEntStateDTO.class));
		return EnValidator.isEmpty(list) ? null : list.toArray(new DepEntStateDTO[0]);
	}
	
	/**
	 * 获取在院患者id_ent
	 * 
	 * @param nurId
	 * @return
	 * @throws BizException
	 */
	private String[] getInHosEntIds(String nurId) throws BizException{
		String sql = "SELECT ID_ENT FROM EN_ENT EN WHERE EN.FG_IP = 'Y' AND (EN.ID_DEP_NUR= ? OR EN.ID_DEP_PHY = ?) ";
		String entOrgWhere = ScGroupControlUtils.getGroupControlFitler(new PatiVisitDODesc(), "EN");//集团管控
		if(!EnValidator.isEmpty(entOrgWhere)){
			sql = sql + " AND " + entOrgWhere;
		}
		SqlParam param = new SqlParam();
		param.addParam(nurId);
		param.addParam(nurId);
		List<String> list = (List<String>) new DAFacade().execQuery(sql, param, new ColumnListHandler());
		return EnValidator.isEmpty(list) ? null : list.toArray(new String[0]);
	}
	/**
	 * 查找并统计数量
	 * 
	 * @param bdEnStateDTO
	 * @param entIds
	 * @throws DAException
	 */
	private DepEntStateDTO[] getDepStateNum(String[] entIds) throws DAException {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" SELECT ENTSTATE.SD_ENSTATETP AS SD_ENSTATETP, ENTSTATE.VAL AS VAL, COUNT(1) AS QUAN_PAT ");
		sqlBuilder.append(" FROM EN_ENT_STATE ENTSTATE ");
		sqlBuilder.append(" INNER JOIN BD_EN_STATETP_EXT EXTSTATE ON ENTSTATE.ID_ENSTATETP = EXTSTATE.ID_ENSTATETP ");
		sqlBuilder.append(" INNER JOIN (SELECT EN.ID_ENT,EN.ID_PAT FROM EN_ENT EN WHERE " + EnSqlUtils.getInSqlByIds("EN.ID_ENT", entIds) + " ) ENT ");
		sqlBuilder.append(" ON (EXTSTATE.FG_ENT = ? AND ENTSTATE.ID_ENT= ENT.ID_ENT) OR (EXTSTATE.FG_ENT = ? AND ENTSTATE.ID_PAT= ENT.ID_PAT) ");
		String stateExtOrgWhere = ScGroupControlUtils.getGroupControlFitler(new BdEnStateTpExtDODesc(), "EXTSTATE");//集团管控
		if(!EnValidator.isEmpty(stateExtOrgWhere)){
			sqlBuilder.append(" WHERE ").append(stateExtOrgWhere);
		}
		sqlBuilder.append(" GROUP BY ENTSTATE.SD_ENSTATETP, ENTSTATE.VAL ");
		String sql = sqlBuilder.toString();
		SqlParam param = new SqlParam();
		param.addParam(FBoolean.TRUE);
		param.addParam(FBoolean.FALSE);
		@SuppressWarnings("unchecked")
		List<DepEntStateDTO> list = (List<DepEntStateDTO>) new DAFacade().execQuery(sql, param, new BeanListHandler(DepEntStateDTO.class));
		return EnValidator.isEmpty(list) ? null : list.toArray(new DepEntStateDTO[0]);
	}
	/**
	 * 就诊状况设置数量
	 * 
	 * @param states
	 * @param statesnum
	 */
	private void SetSumPro(DepEntStateDTO[] states, DepEntStateDTO[] statesnum){
		if(EnValidator.isEmpty(states) || EnValidator.isEmpty(statesnum))
			return;
		for(DepEntStateDTO state : states){
			if(!EnValidator.isEmpty(state.getSd_enstatetp()) && !EnValidator.isEmpty(state.getVal())){
				for(DepEntStateDTO statenum : statesnum){
					if(state.getSd_enstatetp().equals(statenum.getSd_enstatetp()) && state.getVal().equals(statenum.getVal())){
						state.setQuan_pat(statenum.getQuan_pat());
						break;
					}
				}
			}
		}
	}

}
