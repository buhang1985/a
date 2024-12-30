package iih.sc.sch.s.bp;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.res.dayslot.d.DaysLotDO;
import iih.sc.scbd.i.IScDaysLotService;
import iih.sc.scbd.schedulechl.d.SchedulechlDO;
import iih.sc.scbd.schedulechl.i.ISchedulechlMDORService;
import iih.sc.sch.reg.dto.d.RegResDTO;
import iih.sc.sch.reg.dto.d.ResStatsDTO;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.service.time.TimeService;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取科室可预约资源汇总信息
 * @author liubin
 *
 */
public class GetDepsResStatsBP {
	
	/**
	 * 获取科室可预约的资源汇总信息
	 * @param depId 科室id
	 * @param beginDate 开始日期，默认为当天
	 * @param depId
	 * @param beginDate
	 * @return
	 * @throws BizException
	 */
	public ResStatsDTO[] exec(String depId,FDate beginDate) throws BizException{
		//1.获取渠道
		SchedulechlDO schedulechlDO = getSchedulechlDO(IScDictCodeConst.SD_SCCHLTP_HOSPITAL_SELF);
		if(schedulechlDO!=null){
			FDate endDate = beginDate.getDateAfter(schedulechlDO.getDays());
			//2.获取排班信息
			RegResDTO[] regResDTOs = getRegResDTOList(depId, schedulechlDO.getId_scchl(), beginDate, endDate);
			if(!ArrayUtil.isEmptyNoNull(regResDTOs)){
				//3.排班资源信息汇总
				return getResStatsDTOs(regResDTOs);
			}
		}
		return null;
	}
	
	/**
	 * 根据渠道类型得到渠道DO
	 * 
	 * @param sd_scchltp
	 * @return
	 * @throws BizException
	 */
	private SchedulechlDO getSchedulechlDO(String sd_scchltp) throws BizException{
		ISchedulechlMDORService schlRService = ServiceFinder.find(ISchedulechlMDORService.class);
		SchedulechlDO[] schedulechlDOs = schlRService.findByAttrValString(SchedulechlDO.SD_SCCHLTP, sd_scchltp);
		if(!ArrayUtil.isEmptyNoNull(schedulechlDOs)){
			return schedulechlDOs[0];
		}
		return null;
	}
	
	/**
	 * 得到排班信息
	 * 
	 * @param depId 科室ID
	 * @param schchlId 渠道ID
	 * @param beginDate 排班开始时间
	 * @param endData 排班结束时间
	 * @return
	 * @throws BizException 
	 */
	private RegResDTO[] getRegResDTOList(String depId, String schchlId, FDate beginDate, FDate endDate) throws BizException{
		SqlParam param = new SqlParam();
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT SCH.ID_SCH,");
		sb.append("CHL.SCPOLCN POLCN,");
		sb.append("SCH.D_SCH,");
		sb.append("SPL.ID_DEP,");
		sb.append("SCH.ID_DAYSLOT,");
		sb.append("DL.NAME AS NAME_DAYSLOT,");
		sb.append("SRV.SD_SRVTP,");
		sb.append("CASE CHL.SCPOLCN WHEN 0 THEN NVL(SCH.QUAN0_APPT,0) WHEN 1 THEN NVL(SCH.QUAN1_APPT,0) WHEN 2 THEN NVL(SCH.QUAN2_APPT,0) WHEN 3 THEN NVL(SCH.QUAN3_APPT,0) WHEN 4 THEN NVL(SCH.QUAN4_APPT,0) WHEN 5 THEN NVL(SCH.QUAN5_APPT,0) WHEN 6 THEN NVL(SCH.QUAN6_APPT,0) WHEN 7 THEN NVL(SCH.QUAN7_APPT,0) WHEN 8 THEN NVL(SCH.QUAN8_APPT,0) WHEN 9 THEN NVL(SCH.QUAN9_APPT,0) ELSE NVL(SCH.QUAN0_APPT，0)  END AS TOTAL,");
		sb.append("CASE CHL.SCPOLCN WHEN 0 THEN NVL(SCH.QUAN0_USED,0) WHEN 1 THEN NVL(SCH.QUAN1_USED,0) WHEN 2 THEN NVL(SCH.QUAN2_USED,0) WHEN 3 THEN NVL(SCH.QUAN3_USED,0) WHEN 4 THEN NVL(SCH.QUAN4_USED,0) WHEN 5 THEN NVL(SCH.QUAN5_USED,0) WHEN 6 THEN NVL(SCH.QUAN6_USED,0) WHEN 7 THEN NVL(SCH.QUAN7_USED,0) WHEN 8 THEN NVL(SCH.QUAN8_USED,0) WHEN 9 THEN NVL(SCH.QUAN9_USED,0) ELSE NVL(SCH.QUAN0_USED，0)  END AS USED ");
		sb.append("FROM SC_SCH SCH ");
		sb.append("INNER JOIN SC_PL SPL ON SCH.ID_SCPL = SPL.ID_SCPL ");
		sb.append("INNER JOIN SC_SCH_CHL CHL ON SCH.ID_SCH = CHL.ID_SCH ");
		sb.append("INNER JOIN SC_SRV SRV ON SPL.ID_SCSRV=SRV.ID_SCSRV ");
		sb.append("INNER JOIN BD_DAYSLOT DL ON DL.ID_DAYSLOT = SCH.ID_DAYSLOT ");
		sb.append("WHERE SPL.ID_DEP = ? ");
		sb.append("AND CHL.ID_SCCHL = ? ");
		param.addParam(depId);
		param.addParam(schchlId);
		
		FDateTime curTime = ServiceFinder.find(TimeService.class).getUFDateTime();
		if(beginDate!=null){
			FDate nowDate = curTime.getDate();
			if(beginDate.compareTo(nowDate)>0){
				sb.append("AND SCH.D_SCH >=? ");
				param.addParam(beginDate);
			}else{
				DaysLotDO[] dayslots = ServiceFinder.find(IScDaysLotService.class).getAllowedDaysLots(IScDictCodeConst.SD_SCTP_OP, FBoolean.FALSE);
				String dayslotIds = null;
				if(!ArrayUtil.isEmpty(dayslots) && !StringUtil.isEmpty(dayslotIds = getDayslotIds(dayslots))){
					sb.append("AND ((SCH.D_SCH = ? AND SCH.ID_DAYSLOT IN("+dayslotIds+")) OR SCH.D_SCH > ?) ");
					param.addParam(nowDate);
					param.addParam(nowDate);
				}else{
					sb.append("AND SCH.D_SCH >? ");
					param.addParam(nowDate);
				}
			}
		}
		sb.append("AND SCH.D_SCH >=? ");
		
		
		sb.append("AND SCH.D_SCH <=? ");
		sb.append("ORDER BY SCH.D_SCH, DL.TIME_BEGIN ");
		param.addParam(beginDate);
		param.addParam(endDate);
		String sql = sb.toString();
		List<RegResDTO> list = (List<RegResDTO>) new DAFacade().execQuery(sql, param, new BeanListHandler(RegResDTO.class));
		if(!ListUtil.isEmpty(list)){
			return list.toArray(new RegResDTO[0]);
		}
		return null;
	}
	
	/**
	 * 排班资源信息汇总
	 * 
	 * @param regResDTOs
	 * @return
	 */
	private ResStatsDTO[] getResStatsDTOs(RegResDTO[] regResDTOs) {
		if (!ArrayUtil.isEmptyNoNull(regResDTOs)) {
			Map<String, ResStatsDTO> map = new LinkedHashMap<String, ResStatsDTO>();
			for (RegResDTO reg : regResDTOs) {
				FDate d_sch = reg.getD_sch();
				String dayslotId = reg.getId_dayslot();
				String key = d_sch + dayslotId;
				if(map.containsKey(key)){
					ResStatsDTO resStats = map.get(key);
					resStats = assemble(resStats, reg);
					map.put(key, resStats);
				}else{
					ResStatsDTO resStats = new ResStatsDTO();
					resStats.setId_dep(reg.getId_dep());
					resStats.setD_sc(reg.getD_sch());
					resStats.setId_dayslot(reg.getId_dayslot());
					resStats.setName_dayslot(reg.getName_dayslot());
					resStats.setQuan_ord(0);
					resStats.setQuan_expert(0);
					resStats.setQuan_vip(0);
					resStats.setFg_usedup(FBoolean.TRUE);
					resStats = assemble(resStats, reg);
					map.put(key, resStats);
				}
			}
			return map.values().toArray(new ResStatsDTO[0]);
		}
		return null;
	}
	
	/**
	 * 对各个号别的号进行汇总
	 * 
	 * @param resStatsDTO
	 * @param regResDTO
	 * @return
	 */
	private ResStatsDTO assemble(ResStatsDTO resStatsDTO, RegResDTO regResDTO){
		int number = regResDTO.getTotal() - regResDTO.getUsed();
		if(number > 0){
			switch(regResDTO.getSd_srvtp()){
			case IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_NORM:
				//普通
				resStatsDTO.setQuan_ord(resStatsDTO.getQuan_ord() + number);
				resStatsDTO.setFg_usedup(FBoolean.FALSE);
				break;
			case IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_EXP:
				//专家
				resStatsDTO.setQuan_expert(resStatsDTO.getQuan_expert() + number);
				resStatsDTO.setFg_usedup(FBoolean.FALSE);
				break;
			case IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_URG:
				//急诊
				resStatsDTO.setQuan_vip(resStatsDTO.getQuan_vip() + number);
				resStatsDTO.setFg_usedup(FBoolean.FALSE);
				break;
			}
		}
		return resStatsDTO;
	}
	
	private String getDayslotIds(DaysLotDO[] dayslots){
		if(ArrayUtil.isEmpty(dayslots))
			return null;
		StringBuilder sb = new StringBuilder();
		boolean isFirst = true;
		for (DaysLotDO dayslot : dayslots) {
			if(isFirst){
				sb.append("'").append(dayslot.getId_dayslot()).append("'");
				isFirst = false;
			}else{
				sb.append(",'").append(dayslot.getId_dayslot()).append("'");
			}
		}
		return sb.toString();
	}
}
