package iih.en.pv.s.bp.op.ws;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.en.comm.util.EnCodeUtils;
import iih.en.comm.util.EnLogUtil;
import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.dto.d.OpAptDTO;
import iih.en.pv.s.bp.GetPatIdForAp;
import iih.en.pv.s.bp.op.ws.ep.WsEp;
import iih.sc.scbd.i.IScBdOutQryService;
import iih.sc.scbd.schedulechl.d.SchedulechlDO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取预约信息
 * @author 
 *
 */
public class GetOpAptListBP  {
	/**
	 * 获取预约信息
	 * 
	 * @param beginDate 开始日期(非空),格式：yyyy-MM-dd，如：2016-08-09
	 * @param endDate 结束日期(非空),格式：yyyy-MM-dd，如：2016-08-09
	 * @param srvType 号别,01：普通号 02：专家号
	 * @param chlType 渠道类型,取值如：手机APP:15,微信:16,桌建APP:17,支付窗:18,官网:19
	 * @param status 状态,取值如： 预约:0，取号:1,退号:7,全部状态：空
	 * @param deptName 科室名称(模糊匹配)
	 * @param patName 患者名称(模糊匹配)
	 * @param patCode 患者编码(模糊匹配)
	 * @return
	 * @throws BizException
	 */
	public OpAptDTO[] exec(String beginDate, String endDate, String srvType, String chlType, String status,
			String deptName, String patName, String patCode) throws BizException{
		//记录输入参数日志，fanlq-add
		EnLogUtil.getInstance().logInfo("方法：GetOpAptListBP参数为:beginDate:"+beginDate+";endDate:"+endDate
				+";srvType:"+srvType+";chlType:"+chlType+";status:"+status+";deptName:"+deptName+";patName:"+patName+";patCode:"+patCode);
		//日期格式转换,fanlq-add
		beginDate = beginDate+" 00:00:00";
		endDate = endDate + " 23:59:59";
		//1. 验证必输项
		if(!this.validParam(beginDate, endDate)) return null;
		
		GetPatIdForAp patap = new GetPatIdForAp();
		String patId = patap.exec(patCode);
		//2. 获取渠道信息
		SchedulechlDO schedulechlDo = this.getScChlByTp(chlType);
		String scchlId = schedulechlDo == null?null:schedulechlDo.getId_scchl();
		
		//3. 获取已预约信息
		List<OpAptDTO> opAtpList = this.getSchInfos(scchlId, beginDate, endDate, srvType, chlType, status, deptName, patName, patId);
		if(opAtpList == null) 
			return null;
		for(OpAptDTO opApt : opAtpList){
			opApt.setAmpm(EnCodeUtils.dayslotTpTOHisCode(opApt.getDayslottp()));
			opApt.setSrvType(EnCodeUtils.srvTpTOHisSrvCode(opApt.getSrvType()));
			opApt.setSrvTpName(EnCodeUtils.srvTpTOHisSrvName(opApt.getSrvTpName()));
		}
		
		OpAptDTO[] opAptDTOs = opAtpList.toArray(new OpAptDTO[0]);
		this.setStatusCode(opAptDTOs);
		return opAptDTOs;
	}
	
	/**
	 * 验证必输项参数
	 * @param beginDate
	 * @param endDate
	 * @param srvType
	 * @param chlType
	 * @author WJY
	 * @return
	 */
	private Boolean validParam(String beginDate, String endDate){
		if(EnValidator.isEmpty(beginDate)){
			Logger.error("开始日期不能为空！");
			return false;
		}
		if(EnValidator.isEmpty(endDate)){
			Logger.error("结束日期不能为空！");
			return false;
		}
		return true;
	}
	
	/**
	 * 根据渠道类型获取渠道信息
	 * @param chlType 渠道类型
	 * @return
	 * @throws BizException 
	 * @author WJY
	 */
	private SchedulechlDO getScChlByTp(String chlType) throws BizException{
		if(chlType == null || "".equals(chlType)){
			return null;
		}
		IScBdOutQryService bdQryService = ServiceFinder.find(IScBdOutQryService.class);
		SchedulechlDO[] chlDOs = bdQryService.getChlByTp(chlType);
		if(!EnValidator.isEmpty(chlDOs)){
			return chlDOs[0];
		}else {
			throw new BizException("获取渠道信息失败！");
		}	
	}
	
	/**
	 * 获取排班信息
	 * @param chlId 渠道ID
	 * @param srvTp 号别
	 * @param beginDate 查询开始日期
	 * @param endDate 查询结束日期
	 * @param depCode 科室编号
	 * @return
	 * @throws BizException 
	 */
	private List<OpAptDTO> getSchInfos(String chlId, String beginDate, String endDate, String srvType, String chlType, String status, String deptName, String patName, String patId) throws BizException{
		StringBuilder builder =new StringBuilder();
		SqlParam param = new SqlParam();
		builder.append("SELECT APT.ID_APT AS ID_APT, ");
		builder.append("exchl.code_apt as ex_code_apt,");
		builder.append("PAT.CODE AS PATCODE, ");
		builder.append("PAT.NAME AS PATNAME, ");
		builder.append("DEP.CODE AS DEPTCODE, ");
		builder.append("DEP.NAME AS DEPTNAME, ");
		builder.append("APT.CODE AS APTCODE, ");
		builder.append("DECODE(APT.FG_PAYMENT,'N','0','Y','1')  fgPayment, ");
		builder.append("APT.DT_B AS ENTTIME, ");
		builder.append("APT.DT_APPT AS OPRTIME, ");
		builder.append("NVL(PAT.MOB, PAT.TEL) AS MOBILE, ");
		builder.append("DLT.SD_DAYSLOTTP AS DAYSLOTTP, ");
		builder.append("DLT.NAME AS DAYSLOTTYPE, ");
		builder.append("DP.SUGEST_EXMINT AS EXPECTEDWAITTIME, ");
		builder.append("RES.NAME AS DOCTORNAME, ");
		builder.append("RES.CODE AS DOCTORCODE, ");
		builder.append("RES.NAME AS RESNAME, ");
		builder.append("RES.CODE AS RESCODE, ");
		builder.append("APT.QUENO AS QUENO, ");
		builder.append("APT.QUENO AS TICKETNO, ");
		builder.append("SRV.NAME AS SRVNAME, ");
		builder.append("SRV.CODE AS SRVCODE, ");
		builder.append("SRV.SD_SRVTP AS SRVTYPE,");
		builder.append("SRV.SD_SRVTP AS SRVTPNAME,");
		builder.append("CHL.SD_SCCHLTP AS CHLTYPE, ");
		builder.append("CHL.NAME AS CHLTYPENAME, ");
		builder.append("CASE APT.SD_STATUS WHEN '1' THEN '预约' WHEN '2' THEN '付费'  WHEN '3' THEN '取号' WHEN '4' THEN '退号' ELSE '' END AS STATUS, ");
		builder.append("nvl(entop.sd_status,APT.SD_STATUS) as statusCode ");//fanlq
		builder.append("FROM SC_APT APT ");
		builder.append("INNER JOIN SC_SCH SCH ON APT.ID_SCH = SCH.ID_SCH ");
		builder.append("INNER JOIN SC_PL CPL ON SCH.ID_SCPL = CPL.ID_SCPL ");
		builder.append("INNER JOIN SC_SRV SRV ON APT.ID_SCSRV = SRV.ID_SCSRV ");
		builder.append("INNER JOIN SC_RES RES ON CPL.ID_SCRES = RES.ID_SCRES ");
		builder.append("INNER JOIN BD_DEP DEP ON CPL.ID_DEP = DEP.ID_DEP ");
		builder.append("INNER JOIN PI_PAT PAT ON APT.ID_PAT = PAT.ID_PAT ");
		builder.append("INNER JOIN SC_CHL CHL ON APT.ID_SCCHL = CHL.ID_SCCHL ");
		builder.append("INNER JOIN BD_DAYSLOT DLT ON APT.ID_DATESLOT = DLT.ID_DAYSLOT ");
		builder.append("LEFT JOIN SC_DEP_PARAM DP ON CPL.ID_DEP = DP.ID_DEP ");
		builder.append("AND (CPL.ID_DEPPARAM IS NULL OR CPL.ID_DEPPARAM = DP.ID_DEPTPARAM) ");
		builder.append(" left join en_ent_op entop on entop.id_schapt = apt.id_apt ");
		builder.append("left join sc_apt_exchl exchl on exchl.id_apt = apt.id_apt ");
		builder.append("WHERE DEP.ACTIVESTATE = '2' ");
		
		builder.append("AND APT.DT_B >= ? ");
		param.addParam(beginDate);
		builder.append("AND APT.DT_B <= ? ");
		param.addParam(endDate);
		
		if(!EnValidator.isEmpty(chlId)){
			builder.append(" AND APT.ID_SCCHL = ? ");
			param.addParam(chlId);
		}
		
		if(!EnValidator.isEmpty(srvType)){
			String[] srvTps = EnCodeUtils.srvTypeTOIIHSrvTp(srvType);
			if(!EnValidator.isEmpty(srvTps)){
				builder.append("AND " + EnSqlUtils.getInSqlByIds("SRV.SD_SRVTP", srvTps));
			}
		}
		
		if(!EnValidator.isEmpty(status)){
			String sd_status = "";
			if("0".equals(status)){
				//预约
				sd_status = "'" + IScDictCodeConst.SD_APTSTATUS_ORDER + "'";
			}else if("1".equals(status)){
				//取号
				sd_status = "'" + IScDictCodeConst.SD_APTSTATUS_PAY + "','" + IScDictCodeConst.SD_APTSTATUS_FINISH + "'";
			}else if("7".equals(status)){
				//退号
				sd_status = "'" + IScDictCodeConst.SD_APTSTATUS_CANCEL + "'";
			}
			builder.append(" AND APT.SD_STATUS IN (").append(sd_status).append(") ");
		}
		
		if(!EnValidator.isEmpty(deptName)){
			builder.append(" AND DEP.NAME LIKE '%").append(deptName).append("%' ");
		}

		//患者ID不为空
		if(!EnValidator.isEmpty(patId)){
			builder.append(" AND PAT.ID_PAT = ? ");
			param.addParam(patId);
		}
		//患者姓名不为空
		if(!EnValidator.isEmpty(patName)){
			builder.append(" AND PAT.NAME LIKE '%").append(patName).append("%' ");
		}
		
		
		List<OpAptDTO> schInfoList =(List<OpAptDTO>) new DAFacade().execQuery(builder.toString(), 
				param,new BeanListHandler(OpAptDTO.class));	
		if (EnValidator.isEmpty(schInfoList)) return null;
		return schInfoList;
	}
	/**
	 * 设置状态,fanlq
	 * @param opAptDTOs
	 */
	private void setStatusCode(OpAptDTO[] opAptDTOs) {
		if (EnValidator.isEmpty(opAptDTOs))
			return;
		for (OpAptDTO opAptDTO : opAptDTOs) {
			if (IScDictCodeConst.SD_APTSTATUS_CANCEL.equals(opAptDTO.getStatusCode())) {
				opAptDTO.setStatusCode(WsEp.STATUS_OP_CANCEL);
			}
			if (IScDictCodeConst.SD_APTSTATUS_ORDER.equals(opAptDTO.getStatusCode())|| 
					IScDictCodeConst.SD_APTSTATUS_PAY.equals(opAptDTO.getStatusCode())||
					IEnDictCodeConst.SD_ENSTATUS_OP_ORDER.equals(opAptDTO.getStatusCode())) {					
				opAptDTO.setStatusCode(WsEp.STATUS_OP_APT);
			}
			if (IScDictCodeConst.SD_APTSTATUS_FINISH.equals(opAptDTO.getStatusCode())|| IEnDictCodeConst.SD_ENSTATUS_OP_REGISTER.equals(opAptDTO.getStatusCode())) {
				opAptDTO.setStatusCode(WsEp.STATUS_OP_REGIST);					
			}

			if (IEnDictCodeConst.SD_ENSTATUS_OP_ENCOUNTER.equals(opAptDTO.getStatusCode())) {
				opAptDTO.setStatusCode(WsEp.STATUS_OP_ACPT);
			}
			if (IEnDictCodeConst.SD_ENSTATUS_OP_FINISH.equals(opAptDTO.getStatusCode())) {
				opAptDTO.setStatusCode(WsEp.STATUS_OP_END);
			}
		}
	}
}
