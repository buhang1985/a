package iih.sc.sch.s.bp;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.res.dayslot.d.DaysLotDO;
import iih.sc.comm.ScCollectionUtils;
import iih.sc.comm.ScParamUtils;
import iih.sc.comm.ScSqlUtils;
import iih.sc.comm.ScValidator;
import iih.sc.scbd.i.IScDaysLotService;
import iih.sc.scbd.schedulechl.d.SchedulechlDO;
import iih.sc.scbd.schedulechl.i.ISchedulechlMDORService;
import iih.sc.sch.reg.dto.d.RegResDTO;
import iih.sc.sch.reg.dto.d.ResQrySchemeDTO;

import java.util.LinkedList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 接诊挂号获取医生历史排班
 * 
 * @author liubin
 *
 */
public class GetSchHis4RegAndAcptBP {
	/**
	 * 接诊挂号获取医生历史排班
	 * 
	 * @param depId 科室id
	 * @param empId 医生id
	 * @param date 日期
	 * @param dayslotId 当前时间分组
	 * @return
	 * @throws BizException
	 */
	public RegResDTO[] exec(String depId, String empId, FDate date, String dayslotId) throws BizException {
		//1.查找医院诊间（本科）渠道
		String chlId = getchlId();
		if(ScValidator.isEmptyIgnoreBlank(chlId))
			return null;
		//2.查找医生历史排班
		String[] schIds = this.getSchId(depId, empId, date, dayslotId, chlId);
		if(ArrayUtil.isEmpty(schIds))
			return null;
		//3.查找号源
		RegResDTO[] regResArray = this.getRegRes(schIds, chlId);
		if(ArrayUtil.isEmpty(regResArray))
			return null;
		return regResArray;
	}
	
	/**
	 * 查找医院诊间（本科）渠道ID
	 * 
	 * @return
	 * @throws BizException 
	 */
	private String getchlId() throws BizException{
		ISchedulechlMDORService serv = ServiceFinder.find(ISchedulechlMDORService.class);
		SchedulechlDO[] chls = serv.findByAttrValString(SchedulechlDO.SD_SCCHLTP, IScDictCodeConst.SD_SCCHLTP_HOSPITAL_ROOM_DEPT); 
		if(!ScValidator.isNullOrEmpty(chls))
			return chls[0].getId_scchl();
		return null;
	}
	/**
	 * 查找医生历史排班
	 * 
	 * @param depId
	 * @param empId
	 * @param date
	 * @param dayslot
	 * @param chlId
	 * @return
	 * @throws BizException
	 */
	private String[] getSchId(String depId, String empId, FDate date, String dayslot, String chlId) throws BizException{
		String[] dayslots = this.getAllowedDaysLots();
		List<String> schList = new LinkedList<>();
		//1.找指定医生对应的出诊历史排班
		List<String> empOrWgSchlist = this.getEmpOrWgHisSchIds(depId, empId, date, dayslots, chlId);
		if(!ListUtil.isEmpty(empOrWgSchlist)){
			//有排班医生是否可以使用科室普通号
			if(!ScParamUtils.isUseDeptSch(depId))
				return empOrWgSchlist.toArray(new String[0]);
			schList.addAll(empOrWgSchlist);
		}
		//2.找出诊科室对应的出诊历史排班
		List<String> depSchlist = this.getDepHisSchIds(depId, date, dayslots, chlId);
		if(ListUtil.isEmpty(depSchlist)){
			schList.addAll(depSchlist);
		}
		return schList.toArray(new String[0]);
	}
	/**
	 * 获取排班号源
	 * 
	 * @param schIds
	 * @param chlId
	 * @return
	 * @throws BizException
	 */
	private RegResDTO[] getRegRes(String[] schIds, String chlId) throws BizException{
		ResQrySchemeDTO qryScheme = new ResQrySchemeDTO();
		qryScheme.setIds_sch(ScCollectionUtils.arrayToList(schIds));
		qryScheme.setFg_reg(FBoolean.FALSE);
		qryScheme.setId_scchl(chlId);
		qryScheme.setFg_quan(FBoolean.TRUE);//加载号源
		GetResBySchmBP getBySchmBP = new GetResBySchmBP();
		return getBySchmBP.exec(qryScheme);
	}
	/**
	 * 找指定医生对应的出诊历史排班
	 * 
	 * @param depId
	 * @param empId
	 * @param date
	 * @param dayslots
	 * @param chlId
	 * @return
	 * @throws BizException
	 */
	private List<String> getEmpOrWgHisSchIds(String depId, String empId, FDate date, String[] dayslots, String chlId) throws BizException{
		StringBuilder sqlBuilder = new StringBuilder();
		SqlParam param = new SqlParam();
		sqlBuilder.append("SELECT ID_SCH ");
		sqlBuilder.append("FROM ");
		sqlBuilder.append(" ( ");
		sqlBuilder.append("SELECT SCH.ID_SCH, SCH.D_SCH,SLOT.TIME_BEGIN ");
		sqlBuilder.append("FROM SC_SCH SCH ");
		sqlBuilder.append("INNER JOIN SC_PL SPL ON SCH.ID_SCPL = SPL.ID_SCPL ");
		sqlBuilder.append("INNER JOIN SC_RES RES ON SPL.ID_SCRES = RES.ID_SCRES ");
		sqlBuilder.append("INNER JOIN BD_DAYSLOT SLOT ON SCH.ID_DAYSLOT = SLOT.ID_DAYSLOT ");
		sqlBuilder.append("INNER JOIN SC_SCH_CHL SCHCHL ON SCH.ID_SCH = SCHCHL.ID_SCH ");
		sqlBuilder.append("WHERE SCH.FG_ACTIVE = ? ");
		param.addParam(FBoolean.TRUE);
		sqlBuilder.append("AND SPL.FG_ACTIVE = ? ");
		param.addParam(FBoolean.TRUE);
		sqlBuilder.append("AND SCHCHL.ID_SCCHL = ? ");
		param.addParam(chlId);
		sqlBuilder.append("AND SPL.ID_DEP = ? ");
		param.addParam(depId);
		sqlBuilder.append("AND RES.SD_SCRESTP = ? ");
		param.addParam(IScDictCodeConst.SD_SCRESTP_EMP);
		sqlBuilder.append("AND RES.ID_EMP = ? ");
		param.addParam(empId);
		if(ArrayUtil.isEmpty(dayslots)){
			sqlBuilder.append("AND SCH.D_SCH <= ? ");
			param.addParam(date);
		}else{
			sqlBuilder.append("AND (SCH.D_SCH < ? OR (SCH.D_SCH = ? AND SCH.ID_DAYSLOT NOT IN (" + ScSqlUtils.arrayToStr(dayslots)+"))) ");
			param.addParam(date);
			param.addParam(date);
		}
		sqlBuilder.append("ORDER BY SCH.D_SCH DESC, SLOT.TIME_BEGIN DESC ");
		sqlBuilder.append(" ) WHERE ROWNUM < 2 ");
		sqlBuilder.append("UNION ");
		sqlBuilder.append("SELECT ID_SCH ");
		sqlBuilder.append("FROM ");
		sqlBuilder.append(" ( ");
		sqlBuilder.append("SELECT SCH.ID_SCH, SCH.D_SCH,SLOT.TIME_BEGIN ");
		sqlBuilder.append("FROM SC_SCH SCH ");
		sqlBuilder.append("INNER JOIN SC_PL SPL ON SCH.ID_SCPL = SPL.ID_SCPL ");
		sqlBuilder.append("INNER JOIN SC_RES RES ON SPL.ID_SCRES = RES.ID_SCRES ");
		sqlBuilder.append("INNER JOIN BD_EMP_WG WG ON RES.ID_WG = WG.ID_WG ");
		sqlBuilder.append("INNER JOIN BD_DAYSLOT SLOT ON SCH.ID_DAYSLOT = SLOT.ID_DAYSLOT ");
		sqlBuilder.append("INNER JOIN SC_SCH_CHL SCHCHL ON SCH.ID_SCH = SCHCHL.ID_SCH ");
		sqlBuilder.append("WHERE SCH.FG_ACTIVE = ? ");
		param.addParam(FBoolean.TRUE);
		sqlBuilder.append("AND SPL.FG_ACTIVE = ? ");
		param.addParam(FBoolean.TRUE);
		sqlBuilder.append("AND SCHCHL.ID_SCCHL = ? ");
		param.addParam(chlId);
		sqlBuilder.append("AND SPL.ID_DEP = ? ");
		param.addParam(depId);
		sqlBuilder.append("AND RES.SD_SCRESTP = ? ");
		param.addParam(IScDictCodeConst.SD_SCRESTP_WG);
		sqlBuilder.append("AND WG.ID_EMP = ? ");
		param.addParam(empId);
		if(ArrayUtil.isEmpty(dayslots)){
			sqlBuilder.append("AND SCH.D_SCH <= ? ");
			param.addParam(date);
		}else{
			sqlBuilder.append("AND (SCH.D_SCH < ? OR (SCH.D_SCH = ? AND SCH.ID_DAYSLOT NOT IN (" + ScSqlUtils.arrayToStr(dayslots)+"))) ");
			param.addParam(date);
			param.addParam(date);
		}
		sqlBuilder.append("ORDER BY SCH.D_SCH DESC, SLOT.TIME_BEGIN DESC ");
		sqlBuilder.append(" ) WHERE ROWNUM < 2 ");
		String sql = sqlBuilder.toString();
		@SuppressWarnings("unchecked")
		List<String> list = (List<String>) new DAFacade().execQuery(sql, param, new ColumnListHandler());
		return list;
	}
	/**
	 * 找科室对应的出诊历史排班
	 * 
	 * @param depId
	 * @param empId
	 * @param date
	 * @param dayslots
	 * @param chlId
	 * @return
	 * @throws BizException
	 */
	private List<String> getDepHisSchIds(String depId, FDate date, String[] dayslots, String chlId) throws BizException{
		StringBuilder sqlBuilder = new StringBuilder();
		SqlParam param = new SqlParam();
		sqlBuilder.append("SELECT TOP 1 ID_SCH ");
		sqlBuilder.append("FROM ");
		sqlBuilder.append(" ( ");
		sqlBuilder.append("SELECT SCH.ID_SCH, SCH.D_SCH,SLOT.TIME_BEGIN ");
		sqlBuilder.append("FROM SC_SCH SCH ");
		sqlBuilder.append("INNER JOIN SC_PL SPL ON SCH.ID_SCPL = SPL.ID_SCPL ");
		sqlBuilder.append("INNER JOIN SC_RES RES ON SPL.ID_SCRES = RES.ID_SCRES ");
		sqlBuilder.append("INNER JOIN BD_DAYSLOT SLOT ON SCH.ID_DAYSLOT = SLOT.ID_DAYSLOT ");
		sqlBuilder.append("INNER JOIN SC_SCH_CHL SCHCHL ON SCH.ID_SCH = SCHCHL.ID_SCH ");
		sqlBuilder.append("WHERE SCH.FG_ACTIVE = ? ");
		param.addParam(FBoolean.TRUE);
		sqlBuilder.append("AND SPL.FG_ACTIVE = ? ");
		param.addParam(FBoolean.TRUE);
		sqlBuilder.append("AND SCHCHL.ID_SCCHL = ? ");
		param.addParam(chlId);
		sqlBuilder.append("AND SPL.ID_DEP = ? ");
		param.addParam(depId);
		sqlBuilder.append("AND RES.SD_SCRESTP = ? ");
		param.addParam(IScDictCodeConst.SD_SCRESTP_DEP);
		if(ArrayUtil.isEmpty(dayslots)){
			sqlBuilder.append("AND SCH.D_SCH <= ? ");
			param.addParam(date);
		}else{
			sqlBuilder.append("AND (SCH.D_SCH < ? OR (SCH.D_SCH = ? AND SCH.ID_DAYSLOT NOT IN (" + ScSqlUtils.arrayToStr(dayslots)+"))) ");
			param.addParam(date);
			param.addParam(date);
		}
		sqlBuilder.append("ORDER BY SCH.D_SCH DESC, SLOT.TIME_BEGIN DESC ");
		sqlBuilder.append(" ) ");
		String sql = sqlBuilder.toString();
		@SuppressWarnings("unchecked")
		List<String> list = (List<String>) new DAFacade().execQuery(sql, param, new ColumnListHandler());
		return list;
	}
	/**
	 * 获取可用的日期分组
	 * 
	 * @return
	 * @throws BizException
	 */
	private String[] getAllowedDaysLots() throws BizException {
		IScDaysLotService serv = ServiceFinder.find(IScDaysLotService.class);
		DaysLotDO[] dayslotDOArray = serv.getAllowedDaysLots(IScDictCodeConst.SD_SCTP_OP, FBoolean.TRUE);
		if(ArrayUtil.isEmpty(dayslotDOArray))
			return null;
		String[] dayslots = new String[dayslotDOArray.length];
		for(int i=0;i<dayslotDOArray.length;i++)
			dayslots[i] = dayslotDOArray[i].getId_dayslot();
		return dayslots;
	}
}
