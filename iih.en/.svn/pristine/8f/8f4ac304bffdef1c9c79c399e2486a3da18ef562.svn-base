package iih.en.pv.s.bp.op.ws;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bl.cg.i.IBlOutQryService;
import iih.en.comm.util.EnCodeUtils;
import iih.en.comm.util.EnLogUtil;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.dto.d.OpPatAptDTO;
import iih.sc.scbd.i.IScBdOutQryService;
import iih.sc.sch.i.IScSchOutQryService;
import iih.sc.sch.reg.dto.d.RegResDTO;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDouble;
import xap.mw.coreitf.d.FType;
import xap.mw.coreitf.d.FTypeManager;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.MapHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 *获取代办人预约记录
 * 
 * @author libaoliang
 *
 */
public class GetOpAptListByAgentPatCodeBP {
	/**
	 * 
	 * 获取代办人预约记录
	 * 
	 * @param agentPatCode
	 * 			挂号操作人PID(代办人（非空）
	 * @param beginDate
	 *  		开始日期(非空),格式：yyyy-MM-dd，如：2016-09-09
	 * @param endDate
	 * 			结束日期(非空),格式：yyyy-MM-dd，如：2016-09-09
	 * @return
	 * @throws BizException
	 */
	public OpPatAptDTO[] exec(String agentPatCode, String beginDate, String endDate) throws BizException {
		//记录输入参数日志，fanlq-add
		EnLogUtil.getInstance().logInfo("方法：GetOpAptListByAgentPatCodeBP参数为:agentPatCode:"+agentPatCode
				+";beginDate:"+beginDate+";endDate:"+endDate);
		
		if (EnValidator.isEmpty(agentPatCode)) {
			Logger.error("挂号操作人PID(代办人)为空！");
			return null;
		}
		FDate bDate = this.string2FDate(beginDate);
		FDate eDate = this.string2FDate(endDate);
		if (bDate == null || eDate == null)
			return null;
		OpPatAptDTO[] opPatApts = this.getOpPatApts(agentPatCode, bDate, eDate);
		opPatApts = this.filterBySrvId(opPatApts);
		this.process(opPatApts);
		this.setFg_bill(opPatApts);
		this.setEntpCode(opPatApts);
		this.loadAddr(opPatApts);
		return opPatApts;
	}

	/**
	 * 获取患者挂号记录
	 * 
	 * @param patCode
	 * @param bDate
	 * @param eDate
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private OpPatAptDTO[] getOpPatApts(String agentPatCode, FDate bDate, FDate eDate) throws BizException {
		SqlParam param = new SqlParam();
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT DISTINCT SC_APT.ID_APT AS ID_APT,");
		sb.append("PI_PAT.CODE AS PATCODE,");
		sb.append("PI_PAT.NAME AS PATNAME,");
		sb.append("PI_PAT_CA.CODE AS PATCA,");
		sb.append("BD_DEP.CODE AS DEPTCODE,");
		sb.append("BD_DEP.NAME AS DEPTNAME,");
		sb.append("SC_SRV.ID_SCSRV AS SRVID,");
		sb.append("SC_SRV.CODE AS SRVCODE,");
		sb.append("SC_SRV.NAME AS SRVNAME,");
		sb.append("SC_RES.CODE AS DOCTORCODE,");
		sb.append("SC_RES.NAME AS DOCTORNAME,");
		sb.append("SC_RES.CODE AS RESCODE,");
		sb.append("SC_RES.NAME AS RESNAME,");
		sb.append("SUBSTR(SC_APT.DT_B,0,10) AS ENTTIME,");
		sb.append("SC_APT.DT_APPT AS OPRTIME,");
		sb.append("BD_DAYSLOT.SD_DAYSLOTTP AS DAYSLOTTYPE,");
		sb.append("BD_DAYSLOT.SD_DAYSLOTTP AS DAYSLOTTP,");
		sb.append("SC_APT.QUENO AS SEQNO,");
		sb.append("BL_PAY_ITM_PAT_OEP.PAYMODENODE AS PAYMODENO,");
		sb.append("BL_PAY_ITM_PAT_OEP.BANKNO AS BANKNO,");
		sb.append("BL_PAY_ITM_PAT_OEP.SD_PM AS PMCODE,");
		sb.append("SC_APT_EXCHL.CODE_APT AS APTNO,");
		//sb.append("DECODE(SC_APT.SD_STATUS,'1','0','2',DECODE(SC_APT.FG_BILL,'N','0','Y','1'),'3',DECODE(SC_APT.FG_BILL,'N','0','Y','1'),'4','1') AS FEESTATUS,");
		sb.append("DECODE(SC_APT.SD_STATUS,'1','0','2','0','3','1','4','7') AS STATUS,");
		sb.append("BL_ST_OEP.AMT_PAT AS AMTPAT,");
		sb.append("BL_ST_OEP.AMT_RATIO AS AMT,");
		sb.append("BL_ST_OEP.AMT_RATIO AS AMTRATIO,");
		sb.append("SC_APT.CODE AS APTCODE,");
		//sb.append("(SELECT BD_QUE_BEN.DES FROM BD_QUE BD_QUE INNER JOIN BD_QUE_BEN BD_QUE_BEN ON BD_QUE.ID_QUEBEN = BD_QUE_BEN.ID_QUEBEN  WHERE BD_QUE.ID_DEP = SC_PL.ID_DEP "
		//		+ "AND BD_QUE.ID_SCRES = SC_PL.ID_SCRES  and BD_QUE.ID_QUEBEN = SC_PL.ID_QUEBEN ) AS ADDRESS,");
		sb.append("EN_ENT_OP.TIMES_OP AS TIMES,");
		sb.append("EN_ENT_OP.ID_CG,");
		sb.append("EN_ENT_OP.TIMES_OP AS TIMESOP,");
		sb.append("NVL(PI_PAT.MOB, PI_PAT.TEL) AS MOBILE,");
		sb.append("SC_APT.DT_B ,");
		sb.append("TICK.T_B AS T_B_TICK ,");
		sb.append("TICK.T_E AS T_E_TICK ,");
		sb.append(" CHL.CODE APTCHL ");
		sb.append("FROM SC_APT SC_APT ");
		sb.append("INNER JOIN SC_APT_OP SC_APT_OP ON SC_APT.ID_APT = SC_APT_OP.ID_APT ");
		sb.append("LEFT JOIN SC_APT_EXCHL SC_APT_EXCHL ON SC_APT.ID_APT = SC_APT_EXCHL.ID_APT ");
		sb.append("INNER JOIN PI_PAT PI_PAT ON SC_APT.ID_PAT = PI_PAT.ID_PAT ");
		sb.append("INNER JOIN SC_RES SC_RES ON SC_APT.ID_SCRES = SC_RES.ID_SCRES ");
		sb.append("INNER JOIN SC_SRV SC_SRV ON SC_APT.ID_SCSRV = SC_SRV.ID_SCSRV ");
		sb.append("INNER JOIN SC_SCH SC_SCH ON SC_APT.ID_SCH = SC_SCH.ID_SCH ");
		sb.append("INNER JOIN SC_PL SC_PL ON SC_SCH.ID_SCPL = SC_PL.ID_SCPL ");
		sb.append("INNER JOIN BD_DEP BD_DEP ON SC_PL.ID_DEP = BD_DEP.ID_DEP ");
		sb.append("INNER JOIN BD_DAYSLOT BD_DAYSLOT ON SC_APT.ID_DATESLOT = BD_DAYSLOT.ID_DAYSLOT ");		
		sb.append("LEFT  JOIN SC_CHL CHL ON SC_APT.ID_SCCHL = CHL.ID_SCCHL ");
		sb.append("LEFT JOIN SC_TICK TICK ON SC_APT.ID_TICK = TICK.ID_TICK ");
		sb.append("LEFT JOIN EN_ENT_OP EN_ENT_OP ON SC_APT.ID_APT = EN_ENT_OP.ID_SCHAPT ");
		sb.append("LEFT JOIN PI_PAT_CA PI_PAT_CA ON PI_PAT.ID_PATICATE = PI_PAT_CA.ID_PATCA ");
		sb.append("LEFT JOIN BL_CG_ITM_OEP BL_CG_ITM_OEP ON EN_ENT_OP.ID_CG = BL_CG_ITM_OEP.ID_CGOEP ");
		sb.append("LEFT JOIN BL_ST_OEP BL_ST_OEP ON BL_CG_ITM_OEP.ID_STOEP = BL_ST_OEP.ID_STOEP ");
		sb.append("LEFT JOIN BL_PAY_ITM_PAT_OEP BL_PAY_ITM_PAT_OEP ON BL_ST_OEP.ID_PAYPATOEP = BL_PAY_ITM_PAT_OEP.ID_PAYPATOEP ");
		sb.append("WHERE (SC_APT_EXCHL.CODE_PAT_PROXY = ?   or PI_PAT.CODE=?) ");
		param.addParam(agentPatCode);
		param.addParam(agentPatCode);
		sb.append(" AND (SC_APT.SD_STATUS IN ('1','2','3') OR SC_APT.FG_CANC = 'N') ");
		sb.append("AND SC_APT.DT_B >= ? ");
		param.addParam(bDate);
		sb.append("AND SC_APT.DT_B < ? ");
		param.addParam(eDate.asLocalBegin().getDateAfter(1));
		sb.append("ORDER BY SC_APT.DT_B ");
		String sql = sb.toString();
		Logger.info(sql);
		List<OpPatAptDTO> list = (List<OpPatAptDTO>) new DAFacade().execQuery(sql, param, new BeanListHandler(OpPatAptDTO.class));
		if (!EnValidator.isEmpty(list)) {
			for (OpPatAptDTO data : list) {
				if (data.getAddress() == null) {
					data.setAddress("");
				}
			}
			return list.toArray(new OpPatAptDTO[0]);
		}
		return null;
	}
	/**
	 * 过滤非门诊排班服务
	 * 
	 * @param opPatApts
	 * @return
	 * @throws BizException 
	 */
	private OpPatAptDTO[] filterBySrvId(OpPatAptDTO[] opPatApts) throws BizException {
		if (EnValidator.isEmpty(opPatApts))
			return null;
		IScBdOutQryService serv = ServiceFinder.find(IScBdOutQryService.class);
		String scsrvIds = serv.getScsrvIdsNoOpSch();
		if(EnValidator.isEmpty(scsrvIds))
			return opPatApts;
		List<OpPatAptDTO> list = new LinkedList<>();
		for(OpPatAptDTO opPatApt : opPatApts){
			if(scsrvIds.contains(opPatApt.getSrvId()))
				continue;
			list.add(opPatApt);
		}
		return EnValidator.isEmpty(list) ? null : list.toArray(new OpPatAptDTO[0]);
	}
	/**
	 * 做处理
	 * 
	 * @param opPatApts
	 * @throws BizException
	 */
	private void process(OpPatAptDTO[] opPatApts) throws BizException {
		if (EnValidator.isEmpty(opPatApts))
			return;
		Set<String> srvIdSets = new HashSet<String>();
		for (OpPatAptDTO opPatApt : opPatApts) {
			opPatApt.setAmpm(EnCodeUtils.dayslotTpTOHisCode(opPatApt.getDayslottp()));
			// 日期分组
			if (!EnValidator.isEmpty(opPatApt.getDayslotType())) {
				opPatApt.setDayslotType(EnCodeUtils.dayslotTpTOHisCode(opPatApt.getDayslottp()));
			}
			if (!EnValidator.isEmpty(opPatApt.getPmCode())) {
				if ("05".equals(opPatApt.getPmCode())) {
					opPatApt.setPmCode("3");
				} else if ("11".equals(opPatApt.getPmCode())) {
					opPatApt.setPmCode("1");
				} else if ("12".equals(opPatApt.getPmCode())) {
					opPatApt.setPmCode("2");
				} else {
					opPatApt.setPmCode(null);
				}
			}
			if (opPatApt.getAmtRatio() == null || opPatApt.getAmtRatio().floatValue() == 0) {
				srvIdSets.add(opPatApt.getSrvId());
			}
		}
		if (srvIdSets.size() <= 0)
			return;
		RegResDTO[] regResDTOs = new RegResDTO[srvIdSets.size()];
		int i = 0;
		for (String srvId : srvIdSets) {
			RegResDTO regRes = new RegResDTO();
			regRes.setId_scsrv(srvId);
			regResDTOs[i] = regRes;
			i++;
		}
		IScSchOutQryService scSchOutQryService = ServiceFinder.find(IScSchOutQryService.class);
		RegResDTO[] resResult = scSchOutQryService.loadResPri(regResDTOs);

		Map<String, FDouble> regResMap = new LinkedHashMap<String, FDouble>();
		for (RegResDTO regResDTO : resResult) {
			regResMap.put(regResDTO.getId_scsrv(), regResDTO.getAmt_st());
		}
		for (OpPatAptDTO opPatApt : opPatApts) {
			if (opPatApt.getAmtRatio() == null || opPatApt.getAmtRatio().floatValue() == 0) {
				float money = regResMap.get(opPatApt.getSrvId()).floatValue();
				opPatApt.setAmt(money);
				opPatApt.setAmtRatio(money);
			}
		}
	}
	/**
	 * 设置支付标识
	 * @param opPatApts
	 * @throws BizException 
	 */
	private void setFg_bill(OpPatAptDTO[] opPatApts) throws BizException{
		if(EnValidator.isEmpty(opPatApts))
			return;
		for(OpPatAptDTO aptDTO :opPatApts){
			if(EnValidator.isEmpty(aptDTO.getId_cg()))
				aptDTO.setFeeStatus("0");
			else{
				FBoolean res =ServiceFinder.find(IBlOutQryService.class).hasSettled(aptDTO.getId_cg());
				aptDTO.setFeeStatus(res ==null?"0":res.booleanValue()?"1":"0");
			}
		}
	}
	
	/**
	 * 日期转换
	 * 
	 * @param str
	 * @return
	 */
	private FDate string2FDate(String str) {
		try {
			return new FDate(str);
		} catch (Throwable t) {
			Logger.error("日期转换出错", t);
		}
		return null;
	}
	
	/**
	 * 设置就诊类型
	 * @param opPatApts
	 */
	private void setEntpCode(OpPatAptDTO[] opPatApts){
		if(EnValidator.isEmpty(opPatApts))
			return;
		for(OpPatAptDTO aptDTO :opPatApts){
			if( IScDictCodeConst.SD_SCTP_JZ.equals(aptDTO.getSd_sctp())|| IScDictCodeConst.SD_SRVTP_EM.equals(aptDTO.getSd_srvTp()))
			{
				aptDTO.setEntpCode("01");
				aptDTO.setEntpName("急诊");
			}else{
				aptDTO.setEntpCode("00");
				aptDTO.setEntpName("门诊");
			}
		}
	}
	/***
	 * 加载分诊台地址
	 * @author fanlq 2018.03.27
	 * @param list
	 * @return
	 * @throws BizException
	 */
	private void loadAddr(OpPatAptDTO[] opPatAptDTOs) throws BizException{
		String addrStr = "";
		if(opPatAptDTOs != null && opPatAptDTOs.length > 0){
			for(OpPatAptDTO data : opPatAptDTOs){
				StringBuilder sb = new StringBuilder();
				SqlParam param = new SqlParam();
				sb.append("SELECT distinct BD_QUE_BEN.DES FROM BD_QUE BD_QUE ");
				sb.append("INNER JOIN BD_QUE_BEN BD_QUE_BEN ON BD_QUE.ID_QUEBEN = BD_QUE_BEN.ID_QUEBEN ");
				sb.append("left join sc_pl sc_pl on  BD_QUE.ID_DEP = SC_PL.ID_DEP  ");
				sb.append(" AND BD_QUE.ID_SCRES = SC_PL.ID_SCRES  AND BD_QUE.ID_QUEBEN = SC_PL.ID_QUEBEN ");
				sb.append("left join sc_sch sch on sch.id_scpl = sc_pl.id_scpl  ");
				sb.append("left join sc_apt SC_APT on SC_APT.id_sch = sch.id_sch  ");
				sb.append("WHERE 1 = 1 ");
				if(!EnValidator.isEmpty(data.getId_apt())){
					sb.append(" and SC_APT.ID_APT = ?");
					param.addParam(data.getId_apt());
				}
				@SuppressWarnings("unchecked")
				Map<String, Object> addrSql = (Map<String, Object>) new DAFacade().execQuery(sb.toString(), param, new MapHandler());
				if (null != addrSql && !addrSql.isEmpty()) {
					addrStr = (String)FTypeManager.convert2FType(FType.String, addrSql.get("des"));
				}
				data.setAddress(addrStr);
			}
		}else 
			return;
	}
}
