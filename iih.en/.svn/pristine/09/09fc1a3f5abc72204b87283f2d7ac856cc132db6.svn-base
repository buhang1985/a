package iih.en.pv.s.bp.op;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.OpRegDTO;
import iih.en.pv.outpatient.d.EuRegTp;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.sc.pub.ScGroupControlUtils;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取患者挂号信息
 * @author liubin
 *
 */
public class GetOpRegListByPatBP {
	/**
	 * 根据就诊ID得到挂号信息
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public OpRegDTO getOpRegByEntId(String entId) throws BizException{
		if(EnValidator.isEmpty(entId)){
			return null;
		}
		OpRegDTO[] opRegs = this.getOpRegByEntIds(new String[]{ entId }, FBoolean.TRUE);
		if(!EnValidator.isEmpty(opRegs)){
			return opRegs[0];
		}
		return null;
	}
	/**
	 * 根据就诊ID得到挂号信息
	 * 
	 * @param entIds
	 * @return
	 * @throws BizException
	 */
	public OpRegDTO[] getOpRegByEntIds(String[] entIds, FBoolean containFreeNoTickRegTp) throws BizException{
		if(EnValidator.isEmpty(entIds)){
			return null;
		}
		SqlParam param = new SqlParam();
		StringBuilder builder = this.getBaseSqlBuilder();
		builder.append("WHERE EN.FG_CANC = ? ");
		param.addParam(FBoolean.FALSE);
		builder.append("AND EQ.SD_ENTQUE_TP = ? ");
		param.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
		if(!FBoolean.TRUE.equals(containFreeNoTickRegTp)){
			builder.append(" AND OP.EU_REGTP <> ? ");
			param.addParam(EuRegTp.FREENOSCH);
		}
		builder.append(" AND " + ScGroupControlUtils.getGroupControlFitler(new PatiVisitDO(), "EN") + " ");
		builder.append(" AND " + EnSqlUtils.getInSqlByIds("EN.ID_ENT", entIds));
		return this.execQuery(builder.toString(), param);
	}
	
	/**
	 * 根据就诊ID得到挂号信息
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public OpRegDTO getOpRegByEntId(String entId, FDateTime dateTime) throws BizException{
		if(EnValidator.isEmpty(entId)){
			return null;
		}
		OpRegDTO[] opRegs = this.exec(entId, null, null, null, null, dateTime,null);
		if(!EnValidator.isEmpty(opRegs)){
			return opRegs[0];
		}
		return null;
	}
	
	/**
	 * 根据患者ID得到挂号信息
	 * 
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	public OpRegDTO[] getOpRegListByPatId(String patId, FDateTime dateTime) throws BizException{
		if(EnValidator.isEmpty(patId)){
			return null;
		}
		return this.exec(null, patId, null, null, null, dateTime,null);
	}
	/**
	 * 获取分诊台管理的患者挂号信息
	 * 
	 * @param patId 患者id
	 * @param benId 分诊台Id
	 * @return
	 * @throws BizException
	 */
	public OpRegDTO[] getOpRegByBenId(String patId, String benId, FDateTime dateTime)throws BizException{
		if(EnValidator.isEmpty(patId)){
			return null;
		}
		return this.exec(null, patId, null, benId, null, dateTime,null);
	}
	/**
	 * 获取分诊台管理的患者挂号信息
	 * 
	 * @param entIds
	 * @param benId
	 * @return
	 * @throws BizException
	 */
	public OpRegDTO[] getOpRegByEntIds(String[] entIds, String benId, FDateTime dateTime)throws BizException{
		if(!EnValidator.isEmpty(benId))
			return this.exec(entIds, null, null, new String[]{ benId }, null, dateTime,null);
		else
			return this.exec(entIds, null, null, null, null, dateTime,null);
	}
	
	/**
	 * 根据患者ID和当前时间分组得到挂号信息
	 * 
	 * @param patId
	 * @param dayslotId
	 * @return
	 * @throws BizException
	 */
	public OpRegDTO[] getOpRegListByPatId(String patId,String dayslotId, FDate date, FDateTime dateTime) throws BizException{
		if(EnValidator.isEmpty(patId)){
			return null;
		}
		return this.exec(null, patId, dayslotId, null, date, dateTime,null);
	}
	
	public OpRegDTO[] getOpRegList(List<String> entList, List<String> patList,
			List<String> dayslotList, List<String> benList, FDateTime dateTime,String opTimes) throws BizException {
		return getOpRegList(
				EnValidator.isEmpty(entList) ? null : entList.toArray(new String[0]),
				EnValidator.isEmpty(patList) ? null : patList .toArray(new String[0]),
				EnValidator.isEmpty(dayslotList) ? null : dayslotList.toArray(new String[0]),
				EnValidator.isEmpty(benList) ? null : benList.toArray(new String[0])
						, dateTime,opTimes);
	}
	
	public OpRegDTO[] getOpRegList(String[] entIds, String[] patIds, String[] dayslotIds, String[] benIds, FDateTime dateTime,String oPTimes) throws BizException{
		return exec(entIds, patIds, dayslotIds, benIds, null, dateTime,oPTimes);
	}
	
	/**
	 * 获取的挂号信息
	 * 
	 * @param entId 就诊ID
	 * @param patId 患者ID
	 * @param dayslotId 时间分组ID
	 * @param benId 分诊台ID
	 * @param date 日期
	 * @return
	 * @throws BizException
	 */
	private OpRegDTO[] exec(String entId, String patId, String dayslotId, String benId, FDate date, FDateTime dateTime,String opTimes) throws BizException{
		if(date ==null && dateTime == null)
			dateTime = EnAppUtils.getAcptQryDateTime(null, dayslotId);
		return exec(
				EnValidator.isEmpty(entId) ? null : new String[]{entId},
				EnValidator.isEmpty(patId) ? null : new String[]{patId},
				EnValidator.isEmpty(dayslotId) ? null : new String[]{dayslotId},
				EnValidator.isEmpty(benId) ? null : new String[]{benId},
						date, dateTime,opTimes);
	}
	
	private OpRegDTO[] exec(String[] entIds, String[] patIds, String[] dayslotIds,String[] benIds, FDate date, FDateTime dateTime,String opTimes) throws BizException{
		if(dateTime==null)
			dateTime = EnAppUtils.getServerDateTime();
		SqlParam param = new SqlParam();
		StringBuilder builder = this.getBaseSqlBuilder();
		builder.append("WHERE EN.FG_CANC = ? ");
		param.addParam(FBoolean.FALSE);
		builder.append("AND EQ.SD_ENTQUE_TP = ? ");
		param.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
		builder.append(" AND " + ScGroupControlUtils.getGroupControlFitler(new PatiVisitDO(), "EN") + " ");
		if(!EnValidator.isEmpty(entIds)){
			builder.append("AND ").append(EnSqlUtils.getInSqlByIds("EN.ID_ENT", entIds));
		}
		if(!EnValidator.isEmpty(patIds)){
			builder.append("AND ").append(EnSqlUtils.getInSqlByIds("EN.ID_PAT", patIds));
		}
		if(!EnValidator.isEmpty(dayslotIds)){
			builder.append("AND (").append(EnSqlUtils.getInSqlByIds("OP.ID_DATESLOT", dayslotIds));
			builder.append(EnSqlUtils.getInSqlByIds("EQ.ID_DATESLOT", dayslotIds)).append(" ) ");
		}
		if(!EnValidator.isEmpty(benIds)){
			builder.append("AND ").append(EnSqlUtils.getInSqlByIds("BQ.ID_QUEBEN", benIds));
		}
		if(date != null) {
			builder.append("AND EQ.DT_REGIST = ? ");
			param.addParam(date);
		}else {
			builder.append("AND OP.DT_VALID_B <= ? ");
			builder.append("AND OP.DT_VALID_E >= ? ");
			param.addParam(EnAppUtils.getAdvanceAcptTime(dateTime));
			param.addParam(dateTime);
		}
		if(!EnValidator.isEmpty(opTimes)){
			builder.append("AND OP.TIMES_OP = ? ");
			param.addParam(opTimes);
		}
		Boolean aptNeedCfm = EnParamUtils.getAptNeedCfm();
		if(!aptNeedCfm){
			builder.append("AND OP.SD_STATUS IN (?,?,?,?) ");
			param.addParam(IEnDictCodeConst.SD_ENSTATUS_OP_ORDER);
			param.addParam(IEnDictCodeConst.SD_ENSTATUS_OP_REGISTER);
			param.addParam(IEnDictCodeConst.SD_ENSTATUS_OP_ENCOUNTER);
			param.addParam(IEnDictCodeConst.SD_ENSTATUS_OP_FINISH);
		}else{
			builder.append("AND OP.SD_STATUS IN (?,?,?) ");
			param.addParam(IEnDictCodeConst.SD_ENSTATUS_OP_REGISTER);
			param.addParam(IEnDictCodeConst.SD_ENSTATUS_OP_ENCOUNTER);
			param.addParam(IEnDictCodeConst.SD_ENSTATUS_OP_FINISH);
		}
	   String sql = builder.toString();
	   return this.execQuery(sql, param);
	}
	/**
	 * 查询数据
	 * 
	 * @param sql
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private OpRegDTO[] execQuery(String sql, SqlParam param) throws BizException{
		List<OpRegDTO> list = (List<OpRegDTO>) new DAFacade().execQuery(sql, param, new BeanListHandler(OpRegDTO.class));
		if(!EnValidator.isEmpty(list)){
			return list.toArray(new OpRegDTO[0]);
		}
		return null;
	}
	
	/**
	 * 获取基础查询SQL
	 * 
	 * @return
	 */
	private StringBuilder getBaseSqlBuilder(){
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT EN.ID_ENT AS ID_ENT,");
		builder.append("EN.ID_PAT AS ID_PAT,");
		builder.append("SUBSTR(EN.DT_ENTRY, 0, 10) AS DT_ENTRY,");
		builder.append("EN.DT_INSERT AS DT_INSERT,");
		builder.append("EN.CODE_ENTP AS CODE_ENTP,");
		builder.append("EN.ID_HP AS ID_HP,");
		builder.append("EQ.ID_DATESLOT AS ID_DATESLOT,");
		builder.append("OP.ID_SCRES AS ID_SCRES,");
		builder.append("OP.ID_SCSRV AS ID_SCSRV,");
		builder.append("OP.ID_DEP_REG AS ID_DEP_REG,");
		builder.append("OP.SD_STATUS AS SD_STATUS,");
		builder.append("OP.ID_LEVEL_DISE AS ID_LEVEL_DISE,");
		builder.append("OP.SD_LEVEL_DISE AS SD_LEVEL_DISE,");
		builder.append("OP.FG_NEEDRTN AS FG_NEEDRTN,");
		builder.append("EQ.SORTNO AS SORTNO,");
		builder.append("EQ.ID_QUE_SITE, ");
		builder.append("EQ.ID_ENT_QUE AS ID_ENT_QUE, ");
		builder.append("EQ.SORTNO_CALLED, ");
		builder.append("EQ.SD_STATUS_ACPT AS SD_STATUS_ACPT,");
		builder.append("EQ.ID_QUE AS ID_QUE,");
		builder.append("PI_PAT.FG_REALNAME AS FG_REALNAME, ");
		builder.append("LOT.NAME AS NAME_DATESLOT,");
		builder.append("RES.NAME AS NAME_SCRES,");
		builder.append("SRV.NAME AS NAME_SCSRV,");
		builder.append("DEP.NAME AS NAME_DEP_REG, ");
		builder.append("ENTQUE.DT_IN AS DT_ARRV ");
		builder.append("FROM EN_ENT EN ");
		builder.append("INNER JOIN EN_ENT_OP OP ON OP.ID_ENT = EN.ID_ENT ");
		builder.append("INNER JOIN EN_ENT_QUE EQ ON EQ.ID_ENT = EN.ID_ENT ");
		builder.append("INNER JOIN PI_PAT PI_PAT ON EN.ID_PAT = PI_PAT.ID_PAT ");
		builder.append("LEFT  JOIN EN_ENT_QUE  ENTQUE  ON  EN.ID_ENT = ENTQUE.ID_ENT AND  ENTQUE.SD_ENTQUE_TP = '0' ");
		builder.append("LEFT JOIN BD_QUE BQ ON EQ.ID_QUE = BQ.ID_QUE ");
		builder.append("LEFT JOIN SC_RES RES ON OP.ID_SCRES = RES.ID_SCRES ");
		builder.append("LEFT JOIN SC_SRV SRV ON OP.ID_SCSRV = SRV.ID_SCSRV ");
		builder.append("LEFT JOIN BD_DAYSLOT LOT ON EQ.ID_DATESLOT = LOT.ID_DAYSLOT ");
		builder.append("LEFT JOIN BD_DEP DEP ON OP.ID_DEP_REG = DEP.ID_DEP ");
		return builder;
	}
}
