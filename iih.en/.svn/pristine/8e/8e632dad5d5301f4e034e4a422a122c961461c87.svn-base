package iih.en.pv.s.bp.ip;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.ep.DeptEP;
import iih.en.comm.util.EnAgeCalcUtil;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.shiftturnover.d.EnumDayslot;
import iih.en.pv.shiftturnover.d.ShiftTurnOverDO;
import iih.en.pv.shiftturnover.d.ShiftTurnOverItemDO;
import iih.en.pv.shiftturnover.d.ShiftturnoverAggDO;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FTime;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.dept.d.DeptDO;

/**
 * 创建新的交班记录
 * 
 * @author liubin
 *
 */
public class CreateNewTurnOverInfoBP {
	private static final FTime DAY_BEGIN_TIME = new FTime("08:00:00");
	private static final FTime DAY_END_TIME = new FTime("20:00:00");

	/**
	 * 创建新的交班记录
	 * 
	 * @param depId
	 *            科室id
	 * @param date
	 *            日期
	 * @param enumdayslot
	 *            白班/夜班
	 * @return
	 * @throws BizException
	 */
	public ShiftturnoverAggDO exec(String depId, FDate date, String enumdayslot)
			throws BizException {
		FDateTime beginTime = this.getBeginTime(date, enumdayslot);
		FDateTime endTime = this.getEndTime(date, enumdayslot);
		//生成主DO数据
		ShiftTurnOverDO shiftTurnOver = this.createShiftTurnOverDO(depId, beginTime, endTime);
		this.setShiftTurnOverDOInfo(shiftTurnOver, depId, date, enumdayslot);
		//生成明细
		ShiftTurnOverItemDO[] shiftTurnOverItemDOs = this.createShiftTurnItemDos(depId, beginTime, endTime);
		ShiftturnoverAggDO agg = new ShiftturnoverAggDO();
		agg.setParentDO(shiftTurnOver);
		agg.setShiftTurnOverItemDO(shiftTurnOverItemDOs);
		return agg;
	}
	/**
	 * 生成主DO数据
	 * 
	 * @param depId
	 * @param beginTime
	 * @param endTime
	 * @return
	 * @throws BizException
	 */
	private ShiftTurnOverDO createShiftTurnOverDO(String depId, 
			FDateTime beginTime, FDateTime endTime) throws BizException {
		SqlParam param = new SqlParam();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM");
		sql.append("(" );
		sql.append("SELECT COUNT(DISTINCT EN.ID_ENT) AS NUM_ORIGINAL" );
		sql.append("  FROM EN_ENT EN" );
		sql.append(" WHERE EN.CODE_ENTP = '10'" );
		sql.append("   AND EN.FG_IP = 'Y'" );
		sql.append("   AND EN.ID_DEP_PHY = ? " );
		sql.append("   AND EN.DT_ACPT <= ? " );
		sql.append(") A1," );//原有人数
		param.addParam(depId);
		param.addParam(beginTime);
		sql.append("(" );
		sql.append("SELECT COUNT(DISTINCT EN.ID_ENT) AS NUM_NOW" );
		sql.append("  FROM EN_ENT EN" );
		sql.append(" WHERE EN.CODE_ENTP = '10'" );
		sql.append("   AND EN.FG_IP = 'Y'" );
		sql.append("   AND EN.ID_DEP_PHY = ? " );
		sql.append("   AND EN.DT_ACPT <= ? " );
		sql.append(") A2," );//现有人数
		param.addParam(depId);
		param.addParam(endTime);
		sql.append("(" );
		sql.append("SELECT COUNT(DISTINCT EN.ID_ENT) AS NUM_INHOS" );
		sql.append("  FROM EN_ENT EN" );
		sql.append(" INNER JOIN EN_ENT_IP IP ON EN.ID_ENT = IP.ID_ENT ");
		sql.append(" WHERE EN.CODE_ENTP = '10'" );
		sql.append("   AND EN.FG_IP = 'Y'" );
		sql.append("   AND IP.FG_NEWBORN = 'N'" );
		sql.append("   AND EN.ID_DEP_PHY = ?" );
		sql.append("   AND EN.DT_ACPT >= ?" );
		sql.append("   AND EN.DT_ACPT <= ?" );
		sql.append(") A3," );//新入院
		param.addParam(depId);
		param.addParam(beginTime);
		param.addParam(endTime);
		sql.append("(" );
		sql.append("SELECT COUNT(DISTINCT EN.ID_ENT) AS NUM_OUTHOS" );
		sql.append("  FROM EN_ENT EN" );
		sql.append(" INNER JOIN EN_ENT_IP IP" );
		sql.append("    ON EN.ID_ENT = IP.ID_ENT" );
		sql.append(" WHERE EN.CODE_ENTP = '10'" );
		sql.append("   AND EN.SD_STATUS = ?" );
		sql.append("   AND EN.ID_DEP_PHY = ?" );
		sql.append("   AND EN.DT_END >= ?" );
		sql.append("   AND EN.DT_END <= ?" );
		sql.append(") A4," );//出院
		param.addParam(IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALOUT);
		param.addParam(depId);
		param.addParam(beginTime);
		param.addParam(endTime);
		sql.append("(" );
		sql.append("SELECT COUNT(DISTINCT EN.ID_ENT) AS NUM_OPERATION" );
		sql.append("  FROM EN_ENT EN" );
		sql.append(" INNER JOIN EN_ENT_IP IP" );
		sql.append("    ON EN.ID_ENT = IP.ID_ENT" );
		sql.append(" INNER JOIN EN_ENT_STATE STATE" );
		sql.append("    ON EN.ID_ENT = STATE.ID_ENT" );
		sql.append(" WHERE EN.CODE_ENTP = '10'" );
		sql.append("   AND EN.FG_IP = 'Y'" );
		sql.append("   AND EN.ID_DEP_PHY = ?" );
		sql.append("   AND STATE.SD_ENSTATETP = ?" );
		sql.append("   AND STATE.VAL = ?" );
		sql.append("   AND STATE.DT_OCC >= ?" );
		sql.append("   AND STATE.DT_OCC <= ?" );
		sql.append(") A5," );//手术
		param.addParam(depId);
		param.addParam(IBdFcDictCodeConst.SD_ENSTATE_OPDRATE);
		param.addParam(IBdFcDictCodeConst.VAL_ENSTATE_OPDRATE);
		param.addParam(beginTime);
		param.addParam(endTime);
		sql.append("(" );
		sql.append("SELECT COUNT(DISTINCT EN.ID_ENT) AS NUM_BLOOD" );
		sql.append("  FROM EN_ENT EN" );
		sql.append(" INNER JOIN EN_ENT_IP IP" );
		sql.append("    ON EN.ID_ENT = IP.ID_ENT" );
		sql.append(" INNER JOIN EN_ENT_STATE STATE" );
		sql.append("    ON EN.ID_ENT = STATE.ID_ENT" );
		sql.append(" WHERE EN.CODE_ENTP = '10'" );
		sql.append("   AND EN.FG_IP = 'Y'" );
		sql.append("   AND EN.ID_DEP_PHY = ?" );
		sql.append("   AND STATE.SD_ENSTATETP = ?" );
		sql.append("   AND STATE.VAL = ?" );
		sql.append("   AND STATE.DT_OCC >= ?" );
		sql.append("   AND STATE.DT_OCC <= ?" );
		sql.append(") A6，" );//用血
		param.addParam(depId);
		param.addParam(IBdFcDictCodeConst.SD_ENSTATE_USEBLOOD);
		param.addParam(IBdFcDictCodeConst.VAL_ENSTATE_OPDRATE);
		param.addParam(beginTime);
		param.addParam(endTime);
		sql.append("(" );
		sql.append("SELECT COUNT(DISTINCT EN.ID_ENT) AS NUM_TRANIN" );
		sql.append("  FROM EN_ENT EN" );
		sql.append(" INNER JOIN EN_ENT_DEP DEP" );
		sql.append("    ON EN.ID_ENT = DEP.ID_ENT" );
		sql.append(" WHERE EN.CODE_ENTP = '10'" );
		sql.append("   AND EN.FG_IP = 'Y'" );
		sql.append("   AND DEP.ID_DEP_TO = ?" );
		sql.append("   AND DEP.SD_ENTDEPROLE = ?" );
		sql.append("   AND DEP.DT_B >= ?" );
		sql.append("   AND DEP.DT_B <= ?" );
		sql.append(") A7," );//转入
		param.addParam(depId);
		param.addParam(IEnDictCodeConst.SD_ENTDEPROLE_DEP);
		param.addParam(beginTime);
		param.addParam(endTime);
		sql.append("(" );
		sql.append("SELECT COUNT(DISTINCT EN.ID_ENT) AS NUM_TRANOUT" );
		sql.append("  FROM EN_ENT EN" );
		sql.append(" INNER JOIN EN_ENT_DEP DEP" );
		sql.append("    ON EN.ID_ENT = DEP.ID_ENT" );
		sql.append(" WHERE EN.CODE_ENTP = '10'" );
		sql.append("   AND EN.FG_IP = 'Y'" );
		sql.append("   AND DEP.ID_DEP_FROM = ?" );
		sql.append("   AND DEP.SD_ENTDEPROLE = ?" );
		sql.append("   AND DEP.DT_B >= ?" );
		sql.append("   AND DEP.DT_B <= ?" );
		sql.append(") A8," );//转出
		param.addParam(depId);
		param.addParam(IEnDictCodeConst.SD_ENTDEPROLE_DEP);
		param.addParam(beginTime);
		param.addParam(endTime);
		sql.append("(" );
		sql.append("SELECT COUNT(DISTINCT EN.ID_ENT) AS NUM_DELIVER" );
		sql.append("   FROM EN_ENT EN" );
		sql.append("   INNER JOIN EN_ENT_NB NB ON EN.ID_ENT = NB.ID_ENT_MOM" );
		sql.append("   WHERE EN.CODE_ENTP = '10'" );
		sql.append("   AND EN.FG_IP = 'Y'" );
		sql.append("   AND EN.ID_DEP_PHY = ?" );
		sql.append("   AND NB.DT_REG >= ?" );
		sql.append("   AND NB.DT_REG <= ?" );
		sql.append(") A9," );//分娩
		param.addParam(depId);
		param.addParam(beginTime);
		param.addParam(endTime);
		sql.append("(" );
		sql.append("SELECT COUNT(DISTINCT EN.ID_ENT) AS NUM_NEWBABY" );
		sql.append("  FROM EN_ENT EN" );
		sql.append(" INNER JOIN EN_ENT_IP IP" );
		sql.append("    ON EN.ID_ENT = IP.ID_ENT" );
		sql.append(" WHERE EN.CODE_ENTP = '10'" );
		sql.append("   AND IP.FG_NEWBORN = 'Y'" );
		sql.append("   AND EN.ID_DEP_PHY = ?" );
		sql.append("   AND EN.DT_ACPT >= ?" );
		sql.append("   AND EN.DT_ACPT <= ?" );
		sql.append(") A10," );//出生
		param.addParam(depId);
		param.addParam(beginTime);
		param.addParam(endTime);
		sql.append("(" );
		sql.append("SELECT COUNT(DISTINCT EN.ID_ENT) AS NUM_CRITICAL" );
		sql.append("  FROM EN_ENT EN" );
		sql.append(" INNER JOIN EN_ENT_IP IP" );
		sql.append("    ON EN.ID_ENT = IP.ID_ENT" );
		sql.append(" INNER JOIN EN_ENT_STATE STATE" );
		sql.append("    ON EN.ID_ENT = STATE.ID_ENT" );
		sql.append(" WHERE EN.CODE_ENTP = '10'" );
		sql.append("   AND EN.FG_IP = 'Y'" );
		sql.append("   AND EN.ID_DEP_PHY = ?" );
		sql.append("   AND IP.SD_LEVEL_DISE = ?" );
		sql.append(") A11," );//病危
		param.addParam(depId);
		param.addParam(IBdFcDictCodeConst.CONDITION_GRADE_DYING);
		sql.append("(" );
		sql.append("SELECT COUNT(DISTINCT EN.ID_ENT) AS NUM_SEVERITY" );
		sql.append("  FROM EN_ENT EN" );
		sql.append(" INNER JOIN EN_ENT_IP IP" );
		sql.append("    ON EN.ID_ENT = IP.ID_ENT" );
		sql.append(" INNER JOIN EN_ENT_STATE STATE" );
		sql.append("    ON EN.ID_ENT = STATE.ID_ENT" );
		sql.append(" WHERE EN.CODE_ENTP = '10'" );
		sql.append("   AND EN.FG_IP = 'Y'" );
		sql.append("   AND EN.ID_DEP_PHY = ?" );
		sql.append("   AND IP.SD_LEVEL_DISE = ?" );
		sql.append(") A12," );//病重
		param.addParam(depId);
		param.addParam(IBdFcDictCodeConst.CONDITION_GRADE_SEVERITY);
		sql.append("(" );
		sql.append("SELECT COUNT(DISTINCT EN.ID_ENT) AS NUM_DEATH" );
		sql.append("   FROM EN_ENT EN" );
		sql.append("   INNER JOIN EN_ENT_IP IP ON EN.ID_ENT = IP.ID_ENT" );
		sql.append("   WHERE EN.CODE_ENTP = '10'" );
		sql.append("   AND EN.FG_IP = 'Y'" );
		sql.append("   AND EN.ID_DEP_PHY = ?" );
		sql.append("   AND IP.SD_OUTCOMES = ?" );
		sql.append("   AND IP.DT_DEATH >= ?" );
		sql.append("   AND IP.DT_DEATH <= ?" );
		sql.append(") A13");//死亡
		param.addParam(depId);
		param.addParam(IEnDictCodeConst.SD_GOWHERE_INPATIENT);
		param.addParam(beginTime);
		param.addParam(endTime);
		@SuppressWarnings("unchecked")
		List<ShiftTurnOverDO> list = (List<ShiftTurnOverDO>) new DAFacade().execQuery(sql.toString(), param, new BeanListHandler(ShiftTurnOverDO.class));
		if(!EnValidator.isEmpty(list))
			return list.get(0);
		return new ShiftTurnOverDO();
	}
	/**
	 * 设置交接班信息
	 * 
	 * @param shiftTurnOver
	 * @param depId
	 * @param date
	 * @param enumdayslot
	 * @throws BizException
	 */
	private void setShiftTurnOverDOInfo(ShiftTurnOverDO shiftTurnOver, String depId, FDate date, String enumdayslot) throws BizException{
		shiftTurnOver.setStatus(DOStatus.NEW);
		//设置日期
		shiftTurnOver.setDt_report(date);
		//设置交接班时间段
		shiftTurnOver.setEu_dayslot(enumdayslot);
		//设置科室
		DeptEP deptEp = new DeptEP();
		List<String> depIdList = new ArrayList<String>();
		depIdList.add(depId);
		Map<String, DeptDO> deptMap = deptEp.getDeptMap(depIdList);
		shiftTurnOver.setId_dep(depId);
		if(deptMap != null){
			DeptDO dept = deptMap.get(depId);
			shiftTurnOver.setCode_dep(dept.getCode());
			shiftTurnOver.setName_dep(dept.getName());
		}
		shiftTurnOver.setId_grp(Context.get().getGroupId());
		shiftTurnOver.setId_org(Context.get().getOrgId());
		shiftTurnOver.setId_emp_report(Context.get().getStuffId());
		PsnDocDO psn = EnContextUtils.getPsnDoc();
		if(psn != null){
			shiftTurnOver.setCode_emp_report(psn.getCode());
			shiftTurnOver.setName_emp_report(psn.getName());
		}
	}
	/**
	 * 生成交接班明细
	 * 
	 * @param depId
	 * @param beginTime
	 * @param endTime
	 * @return
	 * @throws BizException
	 */
	private ShiftTurnOverItemDO[] createShiftTurnItemDos(String depId, 
			FDateTime beginTime, FDateTime endTime) throws BizException {
		ShiftTurnOverItemDO[] shiftItemDOs = null;
		LinkedHashMap<String, ShiftTurnOverItemDO> map = new LinkedHashMap<String, ShiftTurnOverItemDO>();
		//查询新入院患者
		shiftItemDOs = this.getNewInHosEnt(depId, beginTime, endTime);
		this.assemblyMap(map, shiftItemDOs, "入院");
		//查询手术患者
		shiftItemDOs = this.getOperationEnt(depId, beginTime, endTime);
		this.assemblyMap(map, shiftItemDOs, "手术");
		//查询输血患者
		shiftItemDOs = this.getBloodEnt(depId, beginTime, endTime);
		this.assemblyMap(map, shiftItemDOs, "用血");
		//查询转入患者
		shiftItemDOs = this.getTranInEnt(depId, beginTime, endTime);
		this.assemblyMap(map, shiftItemDOs, "转入");
		//查询分娩患者
		shiftItemDOs = this.getDeliverEnt(depId, beginTime, endTime);
		this.assemblyMap(map, shiftItemDOs, "分娩");;
		//查询出生患者
		shiftItemDOs = this.getNewBabyEnt(depId, beginTime, endTime);
		this.assemblyMap(map, shiftItemDOs, "出生");
		//查询病危患者
		shiftItemDOs = this.getCriticalEnt(depId, beginTime, endTime);
		this.assemblyMap(map, shiftItemDOs, "病危");
		//查询病重患者
		shiftItemDOs = this.getSeverityEnt(depId, beginTime, endTime);
		this.assemblyMap(map, shiftItemDOs, "病重");
		//查询死亡患者
		shiftItemDOs = this.getDeathEnt(depId, beginTime, endTime);
		this.assemblyMap(map, shiftItemDOs, "死亡");
		//查询出院患者
		shiftItemDOs = this.getOutHosEnt(depId, beginTime, endTime);
		this.assemblyMap(map, shiftItemDOs, "出院");
		return map==null?null:map.values().toArray(new ShiftTurnOverItemDO[0]);
	}
	/**
	 * 查询新入院患者
	 * 
	 * @param depId
	 * @param beginTime
	 * @param endTime
	 * @return
	 * @throws BizException
	 */
	private ShiftTurnOverItemDO[] getNewInHosEnt(String depId, 
			FDateTime beginTime, FDateTime endTime) throws BizException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT DISTINCT EN.ID_ENT " );
		sql.append("  FROM EN_ENT EN" );
		sql.append(" INNER JOIN EN_ENT_IP IP ON EN.ID_ENT = IP.ID_ENT ");
		sql.append(" WHERE EN.CODE_ENTP = '10'" );
		sql.append("   AND EN.FG_IP = 'Y'" );
		sql.append("   AND IP.FG_NEWBORN = 'N'" );
		sql.append("   AND EN.ID_DEP_PHY = ?" );
		sql.append("   AND EN.DT_ACPT >= ?" );
		sql.append("   AND EN.DT_ACPT <= ?" );
		SqlParam param = new SqlParam();
		param.addParam(depId);
		param.addParam(beginTime);
		param.addParam(endTime);
		return this.getShiftTurnOverItem(sql.toString(), param);
	}
	/**
	 * 查询手术患者
	 * 
	 * @param depId
	 * @param beginTime
	 * @param endTime
	 * @return
	 * @throws BizException
	 */
	private ShiftTurnOverItemDO[] getOperationEnt(String depId, 
			FDateTime beginTime, FDateTime endTime) throws BizException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT DISTINCT EN.ID_ENT " );
		sql.append("  FROM EN_ENT EN" );
		sql.append(" INNER JOIN EN_ENT_IP IP" );
		sql.append("    ON EN.ID_ENT = IP.ID_ENT" );
		sql.append(" INNER JOIN EN_ENT_STATE STATE" );
		sql.append("    ON EN.ID_ENT = STATE.ID_ENT" );
		sql.append(" WHERE EN.CODE_ENTP = '10'" );
		sql.append("   AND EN.FG_IP = 'Y'" );
		sql.append("   AND EN.ID_DEP_PHY = ?" );
		sql.append("   AND STATE.SD_ENSTATETP = ?" );
		sql.append("   AND STATE.VAL = ?" );
		sql.append("   AND STATE.DT_OCC >= ?" );
		sql.append("   AND STATE.DT_OCC <= ?" );
		SqlParam param = new SqlParam();
		param.addParam(depId);
		param.addParam(IBdFcDictCodeConst.SD_ENSTATE_OPDRATE);
		param.addParam(IBdFcDictCodeConst.VAL_ENSTATE_OPDRATE);
		param.addParam(beginTime);
		param.addParam(endTime);
		return this.getShiftTurnOverItem(sql.toString(), param);
	}
	/**
	 * 查询输血患者
	 * 
	 * @param depId
	 * @param beginTime
	 * @param endTime
	 * @return
	 * @throws BizException
	 */
	private ShiftTurnOverItemDO[] getBloodEnt(String depId, 
			FDateTime beginTime, FDateTime endTime) throws BizException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT DISTINCT EN.ID_ENT " );
		sql.append("  FROM EN_ENT EN" );
		sql.append(" INNER JOIN EN_ENT_IP IP" );
		sql.append("    ON EN.ID_ENT = IP.ID_ENT" );
		sql.append(" INNER JOIN EN_ENT_STATE STATE" );
		sql.append("    ON EN.ID_ENT = STATE.ID_ENT" );
		sql.append(" WHERE EN.CODE_ENTP = '10'" );
		sql.append("   AND EN.FG_IP = 'Y'" );
		sql.append("   AND EN.ID_DEP_PHY = ?" );
		sql.append("   AND STATE.SD_ENSTATETP = ?" );
		sql.append("   AND STATE.VAL = ?" );
		sql.append("   AND STATE.DT_OCC >= ?" );
		sql.append("   AND STATE.DT_OCC <= ?" );
		SqlParam param = new SqlParam();
		param.addParam(depId);
		param.addParam(IBdFcDictCodeConst.SD_ENSTATE_USEBLOOD);
		param.addParam(IBdFcDictCodeConst.VAL_ENSTATE_OPDRATE);
		param.addParam(beginTime);
		param.addParam(endTime);
		return this.getShiftTurnOverItem(sql.toString(), param);
	}
	/**
	 * 查询转入患者
	 * 
	 * @param depId
	 * @param beginTime
	 * @param endTime
	 * @return
	 * @throws BizException
	 */
	private ShiftTurnOverItemDO[] getTranInEnt(String depId, 
			FDateTime beginTime, FDateTime endTime) throws BizException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT DISTINCT EN.ID_ENT " );
		sql.append("  FROM EN_ENT EN" );
		sql.append(" INNER JOIN EN_ENT_DEP DEP" );
		sql.append("    ON EN.ID_ENT = DEP.ID_ENT" );
		sql.append(" WHERE EN.CODE_ENTP = '10'" );
		sql.append("   AND EN.FG_IP = 'Y'" );
		sql.append("   AND DEP.ID_DEP_TO = ?" );
		sql.append("   AND DEP.SD_ENTDEPROLE = ?" );
		sql.append("   AND DEP.DT_B >= ?" );
		sql.append("   AND DEP.DT_B <= ?" );
		SqlParam param = new SqlParam();
		param.addParam(depId);
		param.addParam(IEnDictCodeConst.SD_ENTDEPROLE_DEP);
		param.addParam(beginTime);
		param.addParam(endTime);
		return this.getShiftTurnOverItem(sql.toString(), param);
	}
	/**
	 * 查询分娩患者
	 * 
	 * @param depId
	 * @param beginTime
	 * @param endTime
	 * @return
	 * @throws BizException
	 */
	private ShiftTurnOverItemDO[] getDeliverEnt(String depId, 
			FDateTime beginTime, FDateTime endTime) throws BizException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT DISTINCT EN.ID_ENT " );
		sql.append("   FROM EN_ENT EN" );
		sql.append("   INNER JOIN EN_ENT_NB NB ON EN.ID_ENT = NB.ID_ENT_MOM" );
		sql.append("   WHERE EN.CODE_ENTP = '10'" );
		sql.append("   AND EN.FG_IP = 'Y'" );
		sql.append("   AND EN.ID_DEP_PHY = ?" );
		sql.append("   AND NB.DT_REG >= ?" );
		sql.append("   AND NB.DT_REG <= ?" );
		SqlParam param = new SqlParam();
		param.addParam(depId);
		param.addParam(beginTime);
		param.addParam(endTime);
		return this.getShiftTurnOverItem(sql.toString(), param);
	}
	/**
	 * 查询出生患者
	 * 
	 * @param depId
	 * @param beginTime
	 * @param endTime
	 * @return
	 * @throws BizException
	 */
	private ShiftTurnOverItemDO[] getNewBabyEnt(String depId, 
			FDateTime beginTime, FDateTime endTime) throws BizException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT DISTINCT EN.ID_ENT" );
		sql.append("  FROM EN_ENT EN" );
		sql.append(" INNER JOIN EN_ENT_IP IP" );
		sql.append("    ON EN.ID_ENT = IP.ID_ENT" );
		sql.append(" WHERE EN.CODE_ENTP = '10'" );
		sql.append("   AND IP.FG_NEWBORN = 'Y'" );
		sql.append("   AND EN.ID_DEP_PHY = ?" );
		sql.append("   AND EN.DT_ACPT >= ?" );
		sql.append("   AND EN.DT_ACPT <= ?" );
		SqlParam param = new SqlParam();
		param.addParam(depId);
		param.addParam(beginTime);
		param.addParam(endTime);
		return this.getShiftTurnOverItem(sql.toString(), param);
	}
	/**
	 * 查询病危患者
	 * 
	 * @param depId
	 * @param beginTime
	 * @param endTime
	 * @return
	 * @throws BizException
	 */
	private ShiftTurnOverItemDO[] getCriticalEnt(String depId, 
			FDateTime beginTime, FDateTime endTime) throws BizException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT DISTINCT EN.ID_ENT" );
		sql.append("  FROM EN_ENT EN" );
		sql.append(" INNER JOIN EN_ENT_IP IP" );
		sql.append("    ON EN.ID_ENT = IP.ID_ENT" );
		sql.append(" INNER JOIN EN_ENT_STATE STATE" );
		sql.append("    ON EN.ID_ENT = STATE.ID_ENT" );
		sql.append(" WHERE EN.CODE_ENTP = '10'" );
		sql.append("   AND EN.FG_IP = 'Y'" );
		sql.append("   AND EN.ID_DEP_PHY = ?" );
		sql.append("   AND IP.SD_LEVEL_DISE = ?" );
		SqlParam param = new SqlParam();
		param.addParam(depId);
		param.addParam(IBdFcDictCodeConst.CONDITION_GRADE_DYING);
		return this.getShiftTurnOverItem(sql.toString(), param);
	}
	/**
	 * 查询病重患者
	 * 
	 * @param depId
	 * @param beginTime
	 * @param endTime
	 * @return
	 * @throws BizException
	 */
	private ShiftTurnOverItemDO[] getSeverityEnt(String depId, 
			FDateTime beginTime, FDateTime endTime) throws BizException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT DISTINCT EN.ID_ENT" );
		sql.append("  FROM EN_ENT EN" );
		sql.append(" INNER JOIN EN_ENT_IP IP" );
		sql.append("    ON EN.ID_ENT = IP.ID_ENT" );
		sql.append(" INNER JOIN EN_ENT_STATE STATE" );
		sql.append("    ON EN.ID_ENT = STATE.ID_ENT" );
		sql.append(" WHERE EN.CODE_ENTP = '10'" );
		sql.append("   AND EN.FG_IP = 'Y'" );
		sql.append("   AND EN.ID_DEP_PHY = ?" );
		sql.append("   AND IP.SD_LEVEL_DISE = ?" );
		SqlParam param = new SqlParam();
		param.addParam(depId);
		param.addParam(IBdFcDictCodeConst.CONDITION_GRADE_SEVERITY);
		return this.getShiftTurnOverItem(sql.toString(), param);
	}
	/**
	 * 查询死亡患者
	 * 
	 * @param depId
	 * @param beginTime
	 * @param endTime
	 * @return
	 * @throws BizException
	 */
	private ShiftTurnOverItemDO[] getDeathEnt(String depId, 
			FDateTime beginTime, FDateTime endTime) throws BizException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT DISTINCT EN.ID_ENT" );
		sql.append("   FROM EN_ENT EN" );
		sql.append("   INNER JOIN EN_ENT_IP IP ON EN.ID_ENT = IP.ID_ENT" );
		sql.append("   WHERE EN.CODE_ENTP = '10'" );
		sql.append("   AND EN.FG_IP = 'Y'" );
		sql.append("   AND EN.ID_DEP_PHY = ?" );
		sql.append("   AND IP.SD_OUTCOMES = ?" );
		sql.append("   AND IP.DT_DEATH >= ?" );
		sql.append("   AND IP.DT_DEATH <= ?" );
		SqlParam param = new SqlParam();
		param.addParam(depId);
		param.addParam(IEnDictCodeConst.SD_GOWHERE_INPATIENT);
		param.addParam(beginTime);
		param.addParam(endTime);
		return this.getShiftTurnOverItem(sql.toString(), param);
	}
	/**
	 * 查询出院患者
	 * 
	 * @param depId
	 * @param beginTime
	 * @param endTime
	 * @return
	 * @throws BizException
	 */
	private ShiftTurnOverItemDO[] getOutHosEnt(String depId, 
			FDateTime beginTime, FDateTime endTime) throws BizException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT DISTINCT EN.ID_ENT " );
		sql.append("  FROM EN_ENT EN" );
		sql.append(" INNER JOIN EN_ENT_IP IP" );
		sql.append("    ON EN.ID_ENT = IP.ID_ENT" );
		sql.append(" WHERE EN.CODE_ENTP = '10'" );
		sql.append("   AND EN.SD_STATUS = ?" );
		sql.append("   AND EN.ID_DEP_PHY = ?" );
		sql.append("   AND EN.DT_END >= ?" );
		sql.append("   AND EN.DT_END <= ?" );
		SqlParam param = new SqlParam();
		param.addParam(IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALOUT);
		param.addParam(depId);
		param.addParam(beginTime);
		param.addParam(endTime);
		return this.getShiftTurnOverItem(sql.toString(), param);
	}
	/**
	 * 查询交接明细
	 * 
	 * @param entIds
	 * @return
	 * @throws BizException
	 */
	private ShiftTurnOverItemDO[] getShiftTurnOverItem(String sqlstr, SqlParam param)throws BizException{
		List<String> entList = (List<String>) new DAFacade().execQuery(sqlstr, param, new ColumnListHandler());
		if(EnValidator.isEmpty(entList))
			return null;
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT EN.ID_ENT,");
		sql.append("       EN.NAME_PAT," );
		sql.append("       EN.DT_BIRTH_PAT," );
		sql.append("       IP.CODE_AMR_IP," );
		sql.append("       EN.ID_SEX_PAT," );
		sql.append("       IP.ID_BED," );
		sql.append("       IP.NAME_BED," );
		sql.append("       DI.ID_DIDEF_DIS," );
		sql.append("       DI.NAME_DIDEF_DIS," );
		sql.append("       IP.SD_LEVEL_DISE," );
		sql.append("       SEX.CODE          AS CODE_SEX," );
		sql.append("       SEX.NAME          AS NAME_SEX" );
		sql.append("  FROM EN_ENT EN" );
		sql.append(" INNER JOIN EN_ENT_IP IP" );
		sql.append("    ON EN.ID_ENT = IP.ID_ENT" );
		sql.append("  LEFT JOIN EN_ENT_DI DI" );
		sql.append("    ON EN.ID_ENT = DI.ID_ENT" );
		sql.append("   AND DI.FG_MAJ = 'Y'" );
		sql.append("  LEFT JOIN BD_UDIDOC SEX" );
		sql.append("    ON EN.ID_SEX_PAT = SEX.ID_UDIDOC");
		sql.append(" WHERE " + EnSqlUtils.getInSqlByIds("EN.ID_ENT", entList));
		List<ShiftTurnOverItemDO> list = (List<ShiftTurnOverItemDO>) new DAFacade().execQuery(sql.toString(), new BeanListHandler(ShiftTurnOverItemDO.class));
		if(!EnValidator.isEmpty(list))
			return list.toArray(new ShiftTurnOverItemDO[0]);
		return null;
	}
	/**
	 * 组装数据
	 * 
	 * @param map
	 * @param shiftItemDOs
	 * @param msg
	 * @throws BizException 
	 */
	private void assemblyMap(LinkedHashMap<String, ShiftTurnOverItemDO> map, ShiftTurnOverItemDO[] shiftItemDOs, String msg) throws BizException{
		if(EnValidator.isEmpty(shiftItemDOs))
			return;
		EnAgeCalcUtil.setDoAges(shiftItemDOs, "Id_ent", "Age");
		for(ShiftTurnOverItemDO shiftItemDO : shiftItemDOs){
			if(map.containsKey(shiftItemDO.getId_ent())){
				ShiftTurnOverItemDO value = map.get(shiftItemDO.getId_ent());
				value.setEntstatus(value.getEntstatus() + "," + msg);
			}else{
				int size = map.size();
				shiftItemDO.setSortno(size++);
				shiftItemDO.setEntstatus(msg);
				//shiftItemDO.setAge(AgeCalcUtil.getAge(shiftItemDO.getDt_birth_pat()));
				map.put(shiftItemDO.getId_ent(), shiftItemDO);
			}
		}
	}
	/**
	 * 获取开始时间
	 * 
	 * @param date
	 * @param enumdayslot
	 * @return
	 * @throws BizException
	 */
	private FDateTime getBeginTime(FDate date, String enumdayslot)
			throws BizException {
		if (EnumDayslot.DAYSHIFT.equals(enumdayslot))
			return EnAppUtils.getFDateTime(date, DAY_BEGIN_TIME);
		if (EnumDayslot.NIGHTSHIFT.equals(enumdayslot))
			return EnAppUtils.getFDateTime(date, DAY_END_TIME);
		throw new BizException("交接班时段不能为空！");
	}

	/**
	 * 获取结束时间
	 * 
	 * @param date
	 * @param enumdayslot
	 * @return
	 * @throws BizException
	 */
	private FDateTime getEndTime(FDate date, String enumdayslot)
			throws BizException {
		if (EnumDayslot.DAYSHIFT.equals(enumdayslot))
			return EnAppUtils.getFDateTime(date, DAY_END_TIME);
		if (EnumDayslot.NIGHTSHIFT.equals(enumdayslot))
			return EnAppUtils
					.getFDateTime(date.getDateAfter(1), DAY_BEGIN_TIME);
		throw new BizException("交接班时段不能为空！");
	}
}
