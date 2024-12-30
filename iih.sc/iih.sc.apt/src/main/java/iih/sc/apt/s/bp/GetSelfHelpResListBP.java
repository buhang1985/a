package iih.sc.apt.s.bp;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.comm.ProcResBP;
import iih.sc.sch.i.IScSchOutQryService;
import iih.sc.sch.reg.dto.d.RegResDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取自助机可挂号资源
 * @author liubin
 *
 */
public class GetSelfHelpResListBP {
	/**
	 * 获取自助机可挂号资源 //TODO:暂时方案
	 * 
	 * @param deptId 科室ID
	 * @param date 日期
	 * @param dayslotId 时间分组
	 * @param srvTp 资源服务类型
	 * @return
	 * @throws BizException
	 * @author liubin
	 */
	public RegResDTO[] exec(String deptId, FDate date, String dayslotId, String srvTp) throws BizException {
		RegResDTO[] regResDTOs = this.getSelfHelpResList(deptId, date, dayslotId, srvTp);
		if(!ArrayUtil.isEmpty(regResDTOs)){
			IScSchOutQryService schService = ServiceFinder.find(IScSchOutQryService.class);
			schService.loadResPri(regResDTOs);
		}
		return regResDTOs;
	}
	/**
	 * 获取自助机可挂号资源 //TODO:暂时方案
	 * 
	 * @param deptId 科室ID
	 * @param date 日期
	 * @param dayslotId 时间分组
	 * @param srvTp 资源服务类型
	 * @return
	 * @throws BizException
	 * @author liubin
	 */
	public RegResDTO[] getSelfHelpResList(String deptId, FDate date, String dayslotId, String srvTp) throws BizException {
		SqlParam param = new SqlParam();
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT SCH.ID_SCH,CHL.SCPOLCN POLCN,SCH.D_SCH,SCH.T_E_REG,");
		sqlBuilder.append("PL.ID_SCPL,PL.NAME AS NAME_SCPL,PL.SD_TICKMD,PL.ID_DEP,DEP.NAME AS NAME_DEP,PL.PYCODE,");
		sqlBuilder.append("SCH.ID_DAYSLOT,LOT.NAME AS NAME_DAYSLOT,");
		sqlBuilder.append("SRV.ID_SCSRV,SRV.NAME AS NAME_SCSRV,SRV.SD_SRVTP,");
		sqlBuilder.append("RES.ID_SCRES,RES.NAME AS NAME_SCRES,RES.ID_EMP,");
		sqlBuilder.append("CASE CHL.SCPOLCN WHEN 0 THEN NVL(SCH.QUAN0_APPT,0) WHEN 1 THEN NVL(SCH.QUAN1_APPT,0) WHEN 2 THEN NVL(SCH.QUAN2_APPT,0) WHEN 3 THEN NVL(SCH.QUAN3_APPT,0) WHEN 4 THEN NVL(SCH.QUAN4_APPT,0) WHEN 5 THEN NVL(SCH.QUAN5_APPT,0) WHEN 6 THEN NVL(SCH.QUAN6_APPT,0) WHEN 7 THEN NVL(SCH.QUAN7_APPT,0) WHEN 8 THEN NVL(SCH.QUAN8_APPT,0) WHEN 9 THEN NVL(SCH.QUAN9_APPT,0) ELSE NVL(QUAN0_APPT，0)  END AS TOTAL,");
		sqlBuilder.append("CASE CHL.SCPOLCN WHEN 0 THEN NVL(SCH.QUAN0_USED,0) WHEN 1 THEN NVL(SCH.QUAN1_USED,0) WHEN 2 THEN NVL(SCH.QUAN2_USED,0) WHEN 3 THEN NVL(SCH.QUAN3_USED,0) WHEN 4 THEN NVL(SCH.QUAN4_USED,0) WHEN 5 THEN NVL(SCH.QUAN5_USED,0) WHEN 6 THEN NVL(SCH.QUAN6_USED,0) WHEN 7 THEN NVL(SCH.QUAN7_USED,0) WHEN 8 THEN NVL(SCH.QUAN8_USED,0) WHEN 9 THEN NVL(SCH.QUAN9_USED,0) ELSE NVL(QUAN0_USED，0)  END AS USED,");
		sqlBuilder.append("SCH.FG_ACTIVE AS FG_ACTIVE  ");
		sqlBuilder.append("FROM SC_SCH SCH ");
		sqlBuilder.append("INNER JOIN SC_PL PL ON SCH.ID_SCPL=PL.ID_SCPL ");
		sqlBuilder.append("INNER JOIN SC_SCH_CHL CHL ON SCH.ID_SCH = CHL.ID_SCH ");
		sqlBuilder.append("INNER JOIN SC_CHL SCHL ON CHL.ID_SCCHL = SCHL.ID_SCCHL ");
		sqlBuilder.append("INNER JOIN SC_SRV SRV ON PL.ID_SCSRV=SRV.ID_SCSRV ");
		sqlBuilder.append("INNER JOIN SC_RES RES  ON PL.ID_SCRES=RES.ID_SCRES ");
		sqlBuilder.append("LEFT JOIN BD_DEP DEP ON PL.ID_DEP=DEP.ID_DEP ");
		sqlBuilder.append("LEFT JOIN  BD_DAYSLOT LOT ON LOT.ID_DAYSLOT=SCH.ID_DAYSLOT ");
		sqlBuilder.append("WHERE SCHL.SD_SCCHLTP =? ");	
		param.addParam(IScDictCodeConst.SD_SCCHLTP_HOSPITAL_SELF);
		sqlBuilder.append(" AND SCH.SD_SCTP=? ");
		param.addParam(IScDictCodeConst.SD_SCTP_OP);
		if(!StringUtil.isEmptyWithTrim(deptId)){
			sqlBuilder.append(" AND  PL.ID_DEP =? ");
			param.addParam(deptId);
		}
		if(date!=null){
			sqlBuilder.append(" AND  SCH.D_SCH =? ");
			param.addParam(date);
		}
		if(!StringUtil.isEmptyWithTrim(dayslotId)){
			sqlBuilder.append(" AND  SCH.ID_DAYSLOT = ? ");
			param.addParam(dayslotId);
		}
		if(!StringUtil.isEmptyWithTrim(srvTp)){
			sqlBuilder.append(" AND  SRV.SD_SRVTP = ? ");
			param.addParam(srvTp);
		}
		DAFacade daf = new DAFacade();
		List<RegResDTO> resList = (List<RegResDTO>)daf.execQuery(sqlBuilder.toString(),param,new BeanListHandler(RegResDTO.class));
		ProcResBP procBP = new ProcResBP();
		return procBP.exec(resList, true);
	}
}
