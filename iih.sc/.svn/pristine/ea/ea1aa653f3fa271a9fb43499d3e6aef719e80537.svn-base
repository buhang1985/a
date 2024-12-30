package iih.sc.sch.s.bp;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.comm.ScParamUtils;

import java.util.LinkedList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取医生可加号排班和医生可接诊挂号排班
 * 
 * @author liubin
 *
 */
public class GetEmpOrDepSchBP {	
	/**
	 * 获取排班id集合
	 * 
	 * @param deptId
	 * @param empId
	 * @param date
	 * @param daysLotIds
	 * @return
	 * @throws BizException 
	 */
	public List<String> getSchIds(String deptId,String empId ,FDate date, String[] daysLotIds) throws BizException{
		if(ArrayUtil.isEmpty(daysLotIds)){
			return null;
		}
		String daysLotIdsStr = arrayToStr(daysLotIds);
		List<String> schList = new LinkedList<>();
		//1.找指定医生对应的出诊排班
		List<String> empOrWgSchlist = getEmpOrWgSchIds(deptId, empId, date, daysLotIdsStr);
		if(!ListUtil.isEmpty(empOrWgSchlist)){
			//有排班医生是否可以使用科室普通号
			if(!ScParamUtils.isUseDeptSch(deptId))
				return empOrWgSchlist;
			schList.addAll(empOrWgSchlist);
		}
		//1.找出诊科室对应的排班
		List<String> depSchlist = getDepSchIds(deptId, empId, date, daysLotIdsStr);
		if(!ListUtil.isEmpty(depSchlist)){
			schList.addAll(depSchlist);
		}
		return schList;
	}
	
	/**
	 * 找指定医生对应的出诊排班
	 * 
	 * @param deptId
	 * @param empId
	 * @param date
	 * @param daysLotIdsStr
	 * @return
	 * @throws BizException 
	 */
	private List<String> getEmpOrWgSchIds(String deptId,String empId, FDate date,String daysLotIdsStr) throws BizException{
		SqlParam param = new SqlParam();
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT DISTINCT SCH.ID_SCH ");
		sb.append("FROM SC_SCH SCH ");
		sb.append("INNER JOIN SC_PL SPL ON SCH.ID_SCPL = SPL.ID_SCPL ");
		sb.append("INNER JOIN SC_RES RES ON SPL.ID_SCRES = RES.ID_SCRES ");
		sb.append("WHERE RES.ID_EMP = ? ");
		sb.append("AND RES.SD_SCRESTP = ? ");
		sb.append("AND SPL.ID_DEP = ? ");
		sb.append("AND SCH.D_SCH = ? ");
		sb.append("AND SCH.FG_ACTIVE = ? ");
		sb.append("AND SCH.ID_DAYSLOT IN (").append(daysLotIdsStr).append(") ");
		param.addParam(empId);
		param.addParam(IScDictCodeConst.SD_SCRESTP_EMP);
		param.addParam(deptId);
		param.addParam(date);
		param.addParam(FBoolean.TRUE);
		sb.append("UNION ");
		sb.append("SELECT DISTINCT SCH.ID_SCH ");
		sb.append("FROM SC_SCH SCH ");
		sb.append("INNER JOIN SC_PL SPL ON SCH.ID_SCPL = SPL.ID_SCPL ");
		sb.append("INNER JOIN SC_RES RES ON SPL.ID_SCRES = RES.ID_SCRES ");
		sb.append("INNER JOIN BD_EMP_WG WG ON RES.ID_WG = WG.ID_WG ");
		sb.append("WHERE WG.ID_EMP = ? ");
		sb.append("AND RES.SD_SCRESTP = ? ");
		sb.append("AND SPL.ID_DEP = ? ");
		sb.append("AND SCH.D_SCH = ? ");
		sb.append("AND SCH.FG_ACTIVE = ? ");
		sb.append("AND SCH.ID_DAYSLOT IN (").append(daysLotIdsStr).append(") ");
		param.addParam(empId);
		param.addParam(IScDictCodeConst.SD_SCRESTP_WG);
		param.addParam(deptId);
		param.addParam(date);
		param.addParam(FBoolean.TRUE);
		String sql = sb.toString();
		List<String> list = (List<String>) new DAFacade().execQuery(sql, param, new ColumnListHandler());
		return list;
	}
	
	/**
	 * 找出诊科室对应的排班
	 * 
	 * @param deptId
	 * @param empId
	 * @param date
	 * @param daysLotIdsStr
	 * @return
	 * @throws BizException 
	 */
	private List<String> getDepSchIds(String deptId,String empId, FDate date,String daysLotIdsStr) throws BizException{
		SqlParam param = new SqlParam();
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT DISTINCT SCH.ID_SCH ");
		sb.append("FROM SC_SCH SCH ");
		sb.append("INNER JOIN SC_PL SPL ON SCH.ID_SCPL = SPL.ID_SCPL ");
		sb.append("INNER JOIN SC_RES RES ON SPL.ID_SCRES = RES.ID_SCRES ");
		sb.append("WHERE RES.SD_SCRESTP = ? ");
		sb.append("AND SPL.ID_DEP = ? ");
		sb.append("AND SCH.D_SCH = ? ");
		sb.append("AND SCH.FG_ACTIVE = ? ");
		sb.append("AND SCH.ID_DAYSLOT IN (").append(daysLotIdsStr).append(") ");
		String sql = sb.toString();
		param.addParam(IScDictCodeConst.SD_SCRESTP_DEP);
		param.addParam(deptId);
		param.addParam(date);
		param.addParam(FBoolean.TRUE);
		List<String> list = (List<String>) new DAFacade().execQuery(sql, param, new ColumnListHandler());
		return list;
	}

	/**
	 * 数组变为值字符串
	 * @param items 某项多个值
	 * @return
	 */
	private String arrayToStr(String[] items){
		if(ArrayUtil.isEmpty(items)){
			return null;
		}
		StringBuilder builder = new StringBuilder();
		boolean first = true;
		for(String item : items){
			if(StringUtil.isEmpty(item)){
				continue;
			}
			if(first){
				first=false;
			}else{
				builder.append(",");
			}
			builder.append(String.format("'%s'",item));
		}
		return builder.toString();		
	}	
}
