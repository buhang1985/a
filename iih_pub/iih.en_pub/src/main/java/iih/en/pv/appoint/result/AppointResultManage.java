package iih.en.pv.appoint.result;

import iih.en.pv.appoint.bean.AptNewParam;
import iih.en.pv.appoint.bean.MakeAptAndPayParam;
import iih.en.pv.appoint.bean.PayForAptParam;
import iih.en.pv.outpatient.dto.d.ArriveResultBean;
import iih.en.pv.outpatient.dto.d.BrokenAptDTO;
import iih.en.pv.outpatient.dto.d.ChlSchStatsDTO;
import iih.en.pv.outpatient.dto.d.EnPatCaInfoDTO;
import iih.en.pv.outpatient.dto.d.EntInfoDTO;
import iih.en.pv.outpatient.dto.d.EntRegInfoDTO;
import iih.en.pv.outpatient.dto.d.OpAptDTO;
import iih.en.pv.outpatient.dto.d.OpEntListDTO;
import iih.en.pv.outpatient.dto.d.OpPatAptDTO;
import iih.en.pv.outpatient.dto.d.OpVisitTimesStatDTO;
import iih.en.pv.outpatient.dto.d.OpWaitQueDTO;
import iih.en.pv.outpatient.dto.d.PatEntInfoDTO;
import iih.en.pv.outpatient.dto.d.PayForAptDTO;
import iih.en.pv.outpatient.dto.d.ResultBean;
import iih.en.pv.outpatient.dto.d.SchInfoDTO;
import iih.en.pv.outpatient.dto.d.SchTickInfoDTO;
import iih.sc.apt.dto.d.MakeAptDTO;
import iih.sc.apt.dto.d.RegResultDTO;
import iih.sc.sch.dto.d.DeptWithSchDTO;
import iih.sc.sch.dto.d.OpEmpDepDTO;

import java.util.ArrayList;

import xap.mw.core.utils.StringUtil;

public class AppointResultManage {

	/**
	 * 获取排班信息-出参
	 * @param schInfoDTOs
	 * @return
	 */
	public static SchListResult[] getSchListResult(SchInfoDTO[] schInfoDTOs){
		if(schInfoDTOs == null || schInfoDTOs.length <= 0){
			return new SchListResult[]{};
		}
		ArrayList<SchListResult> lists = new ArrayList<SchListResult>();
		for (SchInfoDTO schInfoDTO : schInfoDTOs) {
			SchListResult schList = new SchListResult();
			schList.setId_sch(schInfoDTO.getId_sch());
			schList.setResCode(schInfoDTO.getResCode());
			schList.setResName(schInfoDTO.getResName());
			schList.setDeptCode(schInfoDTO.getDeptCode());
			schList.setDoctorTitle(schInfoDTO.getDoctorTitle());
			schList.setDeptName(schInfoDTO.getDeptName());
			schList.setSchDate(schInfoDTO.getSchDate());
			schList.setDayslottp(schInfoDTO.getDayslottp());
			schList.setAmpm(schInfoDTO.getAmpm());
			schList.setSrvCode(schInfoDTO.getSrvCode());
			schList.setSrvName(schInfoDTO.getSrvName());
			schList.setPrice(schInfoDTO.getPrice());
			schList.setTotal(schInfoDTO.getTotal());
			schList.setRemain(schInfoDTO.getRemain());
			schList.setSrvType(schInfoDTO.getSrvType());
			schList.setSpeciality(schInfoDTO.getSpeciality());
			schList.setTicktp(schInfoDTO.getTicktp());
			lists.add(schList);
		}
		return lists != null && lists.size() > 0 ? lists.toArray(new SchListResult[0]) : new SchListResult[]{};
	}
	/**
	 * 获取渠道统计信息-出参
	 * @param chlSchStatsDTOs
	 * @return
	 */
	public static ChlSchStatsResult[] getChlSchStatsResult(ChlSchStatsDTO[] chlSchStatsDTOs){
		if(chlSchStatsDTOs == null || chlSchStatsDTOs.length <= 0){
			return new ChlSchStatsResult[]{};
		}
		ArrayList<ChlSchStatsResult> lists = new ArrayList<ChlSchStatsResult>();
		for (ChlSchStatsDTO chlSchStatsDTO : chlSchStatsDTOs) {
			ChlSchStatsResult chlSchStats = new ChlSchStatsResult();
			chlSchStats.setTotal(chlSchStatsDTO.getTotal());
			chlSchStats.setUsed(chlSchStatsDTO.getUsed());
			chlSchStats.setAvailable(chlSchStatsDTO.getAvailable());
			chlSchStats.setCancNum(chlSchStatsDTO.getCancNum());
			chlSchStats.setChlType(chlSchStatsDTO.getChlType());
		//	chlSchStats.setNum_aptNoFe("");
		//	chlSchStats.setNum_aptWithFee("");
		//	chlSchStats.setNum_aptCfm("");
		//	chlSchStats.setNum_aptCanc("");
		//	chlSchStats.setNum_aptCfmCanc("");
		//	chlSchStats.setNum_aptCfmAbsent("");
			lists.add(chlSchStats);
		}
		return lists != null && lists.size() > 0 ? lists.toArray(new ChlSchStatsResult[0]) : new ChlSchStatsResult[]{};
	}
	/**
	 * 获取门诊停诊列表-出参
	 * @param schInfoDTOs
	 * @return
	 */
	public static OpStopSchListResult[] getOpStopSchListResult(SchInfoDTO[] schInfoDTOs){
		if(schInfoDTOs == null || schInfoDTOs.length <= 0){
			return new OpStopSchListResult[]{};
		}
		ArrayList<OpStopSchListResult> lists = new ArrayList<OpStopSchListResult>();
		for (SchInfoDTO schInfoDTO : schInfoDTOs) {
			OpStopSchListResult opStopSchList = new OpStopSchListResult();
			opStopSchList.setId_sch(schInfoDTO.getId_sch());
			opStopSchList.setSchDate(schInfoDTO.getSchDate());
			opStopSchList.setDeptCode(schInfoDTO.getDeptCode());
			opStopSchList.setDeptName(schInfoDTO.getDeptName());
			opStopSchList.setResName(schInfoDTO.getResName());
			opStopSchList.setResCode(schInfoDTO.getResCode());
			opStopSchList.setDayslottp(schInfoDTO.getDayslottp());
			opStopSchList.setAmpm(schInfoDTO.getAmpm());
			opStopSchList.setPrice(schInfoDTO.getPrice());
			opStopSchList.setRemain(schInfoDTO.getRemain());
			opStopSchList.setSpeciality(schInfoDTO.getSpeciality());
			opStopSchList.setIsOpen(schInfoDTO.getIsOpen().toString());
			opStopSchList.setSrvName(schInfoDTO.getSrvName());
			opStopSchList.setSrvCode(schInfoDTO.getSrvCode());
			lists.add(opStopSchList);
		}
		return lists != null && lists.size() > 0 ? lists.toArray(new OpStopSchListResult[0]) :  new OpStopSchListResult[]{};
	}
	/**
	 * 获取患者预约明细-出参
	 * @param opAptDTOs
	 * @return
	 */
	public static OpAptListResult[] getOpAptListResult(OpAptDTO[] opAptDTOs){
		if(opAptDTOs == null || opAptDTOs.length <= 0){
			return new OpAptListResult[]{};
		}
		ArrayList<OpAptListResult> lists = new ArrayList<OpAptListResult>();
		for (OpAptDTO opAptDTO : opAptDTOs) {
			OpAptListResult opAptList = new OpAptListResult();
			opAptList.setId_apt(opAptDTO.getId_apt());
			opAptList.setPatName(opAptDTO.getPatName());
			opAptList.setPatCode(opAptDTO.getPatCode());
			opAptList.setDeptCode(opAptDTO.getDeptCode());
			opAptList.setDeptName(opAptDTO.getDeptName());
			opAptList.setAptCode(opAptDTO.getAptCode());
			opAptList.setEntTime(opAptDTO.getEntTime());
			opAptList.setOprTime(opAptDTO.getOprTime());
			opAptList.setMobile(opAptDTO.getMobile());
			opAptList.setDayslottp(opAptDTO.getDayslottp());
			opAptList.setAmpm(opAptDTO.getAmpm());
			opAptList.setExpectedWaitTime(opAptDTO.getExpectedWaitTime());
			opAptList.setResName(opAptDTO.getResName());
			opAptList.setResCode(opAptDTO.getResCode());
			opAptList.setTicketno(opAptDTO.getTicketno());
			opAptList.setSrvCode(opAptDTO.getResCode());
			opAptList.setSrvName(opAptDTO.getSrvName());
			opAptList.setSrvType(opAptDTO.getSrvType());
			opAptList.setSrvTpName(opAptDTO.getSrvTpName());
			opAptList.setChlType(opAptDTO.getChlType());
			opAptList.setChlTypeName(opAptDTO.getChlTypeName());
			opAptList.setStatus(opAptDTO.getStatus());
			opAptList.setFgPayment(opAptDTO.getFgPayment());
			opAptList.setStatusCode(opAptDTO.getStatusCode());
			opAptList.setExCodeApt(opAptDTO.getEx_code_apt());
			lists.add(opAptList);
		}
		return lists != null && lists.size() > 0 ? lists.toArray(new OpAptListResult[0]) : new OpAptListResult[]{};
	}
	/**
	 * 获取门诊患者爽约记录-出参
	 * @param brokenAptDTOs
	 * @return
	 */
	public static BrokenAptListResult[] getBrokenAptListResult(BrokenAptDTO[] brokenAptDTOs){
		if(brokenAptDTOs == null || brokenAptDTOs.length <= 0){
			return new BrokenAptListResult[]{};
		}
		ArrayList<BrokenAptListResult> lists = new ArrayList<BrokenAptListResult>();
		for (BrokenAptDTO brokenAptDTO : brokenAptDTOs) {
			BrokenAptListResult brokenAptList = new BrokenAptListResult();
			brokenAptList.setId_apt(brokenAptDTO.getId_apt());
			brokenAptList.setPatCode(brokenAptDTO.getPatCode());
			brokenAptList.setPatName(brokenAptDTO.getPatName());
			brokenAptList.setSex(brokenAptDTO.getSex());
			brokenAptList.setScsrv_code(brokenAptDTO.getScsrv_code());
			brokenAptList.setScsrv_name(brokenAptDTO.getScsrv_name());
			brokenAptList.setMobile(brokenAptDTO.getMobile());
			brokenAptList.setDt_act(brokenAptDTO.getDt_entry());
			lists.add(brokenAptList);
		}
		return lists != null && lists.size() > 0 ? lists.toArray(new BrokenAptListResult[0]) : new BrokenAptListResult[]{};
	}
	/**
	 * 获取患者候诊列表-出参
	 * @param opWaitQueDTOs
	 * @return
	 */
	public static WaitQueResult[] getWaitQueResult(OpWaitQueDTO[] opWaitQueDTOs){
		if(opWaitQueDTOs == null || opWaitQueDTOs.length <= 0){
			return new WaitQueResult[]{};
		}
		ArrayList<WaitQueResult> lists = new ArrayList<WaitQueResult>();
		for (OpWaitQueDTO opWaitQueDTO : opWaitQueDTOs) {
			WaitQueResult waitQue = new WaitQueResult();
			waitQue.setRowNumber(opWaitQueDTO.getRowNumber());
			waitQue.setTicketno(opWaitQueDTO.getTicketno());
			waitQue.setIdenFlag(opWaitQueDTO.getIdenFlag());
			waitQue.setVisitFlag(opWaitQueDTO.getVisitFlag());
			waitQue.setPatCode(opWaitQueDTO.getPatCode());
			waitQue.setOpTimes(opWaitQueDTO.getOpTimes());
			waitQue.setEntCode(opWaitQueDTO.getEntCode());
			waitQue.setRoom(opWaitQueDTO.getRoom());
			waitQue.setId_ent(opWaitQueDTO.getId_ent());
			waitQue.setId_ent_que(opWaitQueDTO.getId_ent_que());
			waitQue.setFg_wait(opWaitQueDTO.getFg_wait());
			waitQue.setFg_rtn(opWaitQueDTO.getFg_rtn());
			waitQue.setName_pat(opWaitQueDTO.getName_pat());
			lists.add(waitQue);
		}
		return lists != null && lists.size() > 0 ? lists.toArray(new WaitQueResult[0]) : new WaitQueResult[]{};
	}
	/**
	 * 获取患者预约记录-出参
	 * @param opPatAptDTOs
	 * @return
	 */
	public static PatOpAptListResult[] getPatOpAptListResult(OpPatAptDTO[] opPatAptDTOs){
		if(opPatAptDTOs == null || opPatAptDTOs.length <= 0){
			return new PatOpAptListResult[]{};
		}
		ArrayList<PatOpAptListResult> lists = new ArrayList<PatOpAptListResult>();
		for (OpPatAptDTO opPatAptDTO : opPatAptDTOs) {
			PatOpAptListResult patOpAptList = new PatOpAptListResult();
			patOpAptList.setId_apt(opPatAptDTO.getId_apt());
			patOpAptList.setPatName(opPatAptDTO.getPatName());
			patOpAptList.setPatCode(opPatAptDTO.getPatCode());
			patOpAptList.setEntpCode(opPatAptDTO.getEntpCode());
			patOpAptList.setPatCa(opPatAptDTO.getPatCa());
			patOpAptList.setDeptCode(opPatAptDTO.getDeptCode());
			patOpAptList.setDeptName(opPatAptDTO.getDeptName());
			patOpAptList.setSrvCode(opPatAptDTO.getSrvCode());
			patOpAptList.setSrvName(opPatAptDTO.getSrvName());
			patOpAptList.setResCode(opPatAptDTO.getResCode());
			patOpAptList.setResName(opPatAptDTO.getResName());
			patOpAptList.setEntTime(opPatAptDTO.getEntTime());
			patOpAptList.setOprTime(opPatAptDTO.getOprTime());
			patOpAptList.setDayslottp(opPatAptDTO.getDayslottp());
			patOpAptList.setAmpm(opPatAptDTO.getAmpm());
			patOpAptList.setSeqNo(opPatAptDTO.getSeqNo());
			patOpAptList.setPaymodeno(opPatAptDTO.getPaymodeno());
			patOpAptList.setBankno(opPatAptDTO.getBankno());
			patOpAptList.setPmCode(opPatAptDTO.getPmCode());
			patOpAptList.setAptno(opPatAptDTO.getAptno());
			patOpAptList.setFeeStatus(opPatAptDTO.getFeeStatus());
			patOpAptList.setStatus(opPatAptDTO.getStatus());
			patOpAptList.setAmtPat(opPatAptDTO.getAmtPat());
			patOpAptList.setAptCode(opPatAptDTO.getAptCode());
			patOpAptList.setAddress(opPatAptDTO.getAddress());
			patOpAptList.setAmt(opPatAptDTO.getAmt());
			patOpAptList.setTimesOp(opPatAptDTO.getTimesOp());
			patOpAptList.setMobile(opPatAptDTO.getMobile());
			patOpAptList.setChlTypeName(opPatAptDTO.getChlTypeName());
			patOpAptList.setT_b_tick(opPatAptDTO.getT_b_tick());
			patOpAptList.setT_e_tick(opPatAptDTO.getT_e_tick());
			lists.add(patOpAptList);
		}
		return lists != null && lists.size() > 0 ? lists.toArray(new PatOpAptListResult[0]) : new PatOpAptListResult[]{};
	}
	/**
	 * 获取患者挂号记录列表-出参
	 * 
	 * @param opEntListDTOs
	 * @return
	 */
	public static PatOpEntListResult[] getPatOpEntListResult(OpEntListDTO[] opEntListDTOs){
		if(opEntListDTOs == null || opEntListDTOs.length <= 0){
			return new PatOpEntListResult[]{};
		}
		ArrayList<PatOpEntListResult> lists = new ArrayList<PatOpEntListResult>();
		for (OpEntListDTO opEntListDTO : opEntListDTOs) {
			PatOpEntListResult patOpEntList = new PatOpEntListResult();
			patOpEntList.setId_apt(opEntListDTO.getId_apt());
			patOpEntList.setId_ent(opEntListDTO.getId_ent());
			patOpEntList.setDeptCode(opEntListDTO.getDeptCode());
			patOpEntList.setPatName(opEntListDTO.getPatName());
			patOpEntList.setPatCode(opEntListDTO.getPatCode());
			patOpEntList.setPatCa(opEntListDTO.getPatCa());
			patOpEntList.setDeptCode(opEntListDTO.getDeptCode());
			patOpEntList.setDeptName(opEntListDTO.getDeptName());
			patOpEntList.setSrvCode(opEntListDTO.getSrvCode());
			patOpEntList.setSrvName(opEntListDTO.getSrvName());
			patOpEntList.setResCode(opEntListDTO.getResCode());
			patOpEntList.setResName(opEntListDTO.getResName());
			patOpEntList.setEntTime(opEntListDTO.getEntTime());
			patOpEntList.setOprTime(opEntListDTO.getOprTime());
			patOpEntList.setDayslottp(opEntListDTO.getDayslottp());
			patOpEntList.setAmpm(opEntListDTO.getDayslotname());
			patOpEntList.setSeqNo(opEntListDTO.getSeqNo());
			patOpEntList.setPaymodeno(opEntListDTO.getPaymodeno());
			patOpEntList.setBankno(opEntListDTO.getBankno());
			patOpEntList.setPmCode(opEntListDTO.getPmCode());
			patOpEntList.setAptno(opEntListDTO.getAptno());
			patOpEntList.setFeeStatus(opEntListDTO.getFeeStatus());
			patOpEntList.setStatus(opEntListDTO.getStatus());
			patOpEntList.setAmtPat(opEntListDTO.getAmtPat());
			patOpEntList.setAptCode(opEntListDTO.getAptCode());
			patOpEntList.setAddress(opEntListDTO.getAddress());
			patOpEntList.setAmt(opEntListDTO.getAmt());
			patOpEntList.setTimesOp(opEntListDTO.getTimesOp());
			patOpEntList.setMobile(opEntListDTO.getMobile());
			patOpEntList.setAptChl(opEntListDTO.getAptChl());
			patOpEntList.setT_b_tick(opEntListDTO.getT_b_tick());
			patOpEntList.setT_e_tick(opEntListDTO.getT_e_tick());
			lists.add(patOpEntList);
		}
		return lists != null && lists.size() > 0 ? lists.toArray(new PatOpEntListResult[0]) : new PatOpEntListResult[]{};
	}
	/**
	 * 获取患者挂号和记录(预约未取消，挂号包含取消)-出参
	 * @param opPatAptDTOs
	 * @return
	 */
	public static PatOpAptAndEntListResult[] getPatOpAptAndEntListResult(OpPatAptDTO[] opPatAptDTOs){
		if(opPatAptDTOs == null || opPatAptDTOs.length <= 0){
			return new PatOpAptAndEntListResult[]{};
		}
		ArrayList<PatOpAptAndEntListResult> lists = new ArrayList<PatOpAptAndEntListResult>();
		for (OpPatAptDTO opPatAptDTO : opPatAptDTOs) {
			PatOpAptAndEntListResult patOpAptAndEntList = new PatOpAptAndEntListResult();
			patOpAptAndEntList.setId_apt(opPatAptDTO.getId_apt());
			patOpAptAndEntList.setPatName(opPatAptDTO.getPatName());
			patOpAptAndEntList.setPatCode(opPatAptDTO.getPatCode());
			patOpAptAndEntList.setEntpCode(opPatAptDTO.getEntpCode());
			patOpAptAndEntList.setPatCa(opPatAptDTO.getPatCa());
			patOpAptAndEntList.setDeptCode(opPatAptDTO.getDeptCode());
			patOpAptAndEntList.setDeptName(opPatAptDTO.getDeptName());
			patOpAptAndEntList.setSrvCode(opPatAptDTO.getSrvCode());
			patOpAptAndEntList.setSrvName(opPatAptDTO.getSrvName());
			patOpAptAndEntList.setResCode(opPatAptDTO.getResCode());
			patOpAptAndEntList.setResName(opPatAptDTO.getResName());
			patOpAptAndEntList.setEntTime(opPatAptDTO.getEntTime());
			patOpAptAndEntList.setOprTime(opPatAptDTO.getOprTime());
			patOpAptAndEntList.setDayslottp(opPatAptDTO.getDayslottp());
			patOpAptAndEntList.setAmpm(opPatAptDTO.getDayslotName());
			patOpAptAndEntList.setSeqNo(opPatAptDTO.getSeqNo());
			patOpAptAndEntList.setPaymodeno(opPatAptDTO.getPaymodeno());
			patOpAptAndEntList.setBankno(opPatAptDTO.getBankno());
			patOpAptAndEntList.setPmCode(opPatAptDTO.getPmCode());
			patOpAptAndEntList.setAptno(opPatAptDTO.getAptno());
			patOpAptAndEntList.setFeeStatus(opPatAptDTO.getFeeStatus());
			patOpAptAndEntList.setStatus(opPatAptDTO.getStatus());
			patOpAptAndEntList.setAmtPat(opPatAptDTO.getAmtPat());
			patOpAptAndEntList.setAptCode(opPatAptDTO.getAptCode());
			patOpAptAndEntList.setAddress(opPatAptDTO.getAddress());
			patOpAptAndEntList.setAmt(opPatAptDTO.getAmt());
			patOpAptAndEntList.setTimesOp(opPatAptDTO.getTimesOp());
			patOpAptAndEntList.setMobile(opPatAptDTO.getMobile());
			patOpAptAndEntList.setChlTypeName(opPatAptDTO.getChlTypeName());
			patOpAptAndEntList.setT_b_tick(opPatAptDTO.getT_b_tick());
			patOpAptAndEntList.setT_e_tick(opPatAptDTO.getT_e_tick());
			lists.add(patOpAptAndEntList);
		}
		return lists != null && lists.size() > 0 ? lists.toArray(new PatOpAptAndEntListResult[0]) :new PatOpAptAndEntListResult[]{};
	}
	/**
	 * 获取代办人预约记录-出参
	 * @param opPatAptDTOs
	 * @return
	 */
	public static OpAptListByAgentPatCodeResult[] getOpAptListByAgentPatCodeResult(OpPatAptDTO[] opPatAptDTOs){
		if(opPatAptDTOs == null || opPatAptDTOs.length <= 0){
			return new OpAptListByAgentPatCodeResult[]{};
		}
		ArrayList<OpAptListByAgentPatCodeResult> lists = new ArrayList<OpAptListByAgentPatCodeResult>();
		for (OpPatAptDTO opPatAptDTO : opPatAptDTOs) {
			OpAptListByAgentPatCodeResult opAptListByAgentPatCode = new OpAptListByAgentPatCodeResult();
			opAptListByAgentPatCode.setId_apt(opPatAptDTO.getId_apt());
			opAptListByAgentPatCode.setPatName(opPatAptDTO.getPatName());
			opAptListByAgentPatCode.setPatCode(opPatAptDTO.getPatCode());
			opAptListByAgentPatCode.setEntpCode(opPatAptDTO.getEntpCode());
			opAptListByAgentPatCode.setPatCa(opPatAptDTO.getPatCa());
			opAptListByAgentPatCode.setDeptCode(opPatAptDTO.getDeptCode());
			opAptListByAgentPatCode.setDeptName(opPatAptDTO.getDeptName());
			opAptListByAgentPatCode.setSrvCode(opPatAptDTO.getSrvCode());
			opAptListByAgentPatCode.setSrvName(opPatAptDTO.getSrvName());
			opAptListByAgentPatCode.setResCode(opPatAptDTO.getResCode());
			opAptListByAgentPatCode.setResName(opPatAptDTO.getResName());
			opAptListByAgentPatCode.setEntTime(opPatAptDTO.getEntTime());
			opAptListByAgentPatCode.setOprTime(opPatAptDTO.getOprTime());
			opAptListByAgentPatCode.setDayslottp(opPatAptDTO.getDayslottp());
			opAptListByAgentPatCode.setAmpm(opPatAptDTO.getAmpm());
			opAptListByAgentPatCode.setSeqNo(opPatAptDTO.getSeqNo());
			opAptListByAgentPatCode.setPaymodeno(opPatAptDTO.getPaymodeno());
			opAptListByAgentPatCode.setBankno(opPatAptDTO.getBankno());
			opAptListByAgentPatCode.setPmCode(opPatAptDTO.getPmCode());
			opAptListByAgentPatCode.setAptno(opPatAptDTO.getAptno());
			opAptListByAgentPatCode.setFeeStatus(opPatAptDTO.getFeeStatus());
			opAptListByAgentPatCode.setStatus(opPatAptDTO.getStatus());
			opAptListByAgentPatCode.setAmtPat(opPatAptDTO.getAmtPat());
			opAptListByAgentPatCode.setAptCode(opPatAptDTO.getAptCode());
			opAptListByAgentPatCode.setAddress(opPatAptDTO.getAddress());
			opAptListByAgentPatCode.setAmt(opPatAptDTO.getAmt());
			opAptListByAgentPatCode.setTimesOp(opPatAptDTO.getTimesOp());
			opAptListByAgentPatCode.setMobile(opPatAptDTO.getMobile());
			opAptListByAgentPatCode.setChlTypeName(opPatAptDTO.getChlTypeName());
			opAptListByAgentPatCode.setT_b_tick(opPatAptDTO.getT_b_tick());
			opAptListByAgentPatCode.setT_e_tick(opPatAptDTO.getT_e_tick());
			lists.add(opAptListByAgentPatCode);
		}
		return lists != null && lists.size() > 0 ? lists.toArray(new OpAptListByAgentPatCodeResult[0]) : new OpAptListByAgentPatCodeResult[]{};
	}
	/**
	 * 获取预约详细信息-出参
	 * @param opPatAptDTO
	 * @return
	 */
	public static PaidAptDetailResult getPaidAptDetailResult(OpPatAptDTO opPatAptDTO){
		if(opPatAptDTO == null){
			return new PaidAptDetailResult();
		}
		PaidAptDetailResult paidAptDetail = new PaidAptDetailResult();
		paidAptDetail.setId_apt(opPatAptDTO.getId_apt());
		paidAptDetail.setId_ent(opPatAptDTO.getId_ent());
		paidAptDetail.setPatCa(opPatAptDTO.getPatCa());
		paidAptDetail.setPatCaName(opPatAptDTO.getPatCaName());
		paidAptDetail.setPatCode(opPatAptDTO.getPatCode());
		paidAptDetail.setPatName(opPatAptDTO.getPatName());
		paidAptDetail.setTimesOp(opPatAptDTO.getTimesOp());
		paidAptDetail.setSex(opPatAptDTO.getSex());
		paidAptDetail.setBirthday(opPatAptDTO.getBirthday());
		paidAptDetail.setAge(opPatAptDTO.getAge());
		paidAptDetail.setResCode(opPatAptDTO.getResCode());
		paidAptDetail.setResName(opPatAptDTO.getResName());
		paidAptDetail.setSrvName(opPatAptDTO.getSrvName());
		paidAptDetail.setTicketNo(opPatAptDTO.getTicketNo());
		paidAptDetail.setDeptCode(opPatAptDTO.getDeptCode());
		paidAptDetail.setDeptName(opPatAptDTO.getDeptName());
		paidAptDetail.setHospitalCode(opPatAptDTO.getHospitalCode());
		paidAptDetail.setHospitalName(opPatAptDTO.getHospitalName());
		paidAptDetail.setDt_b(opPatAptDTO.getDt_b());
		paidAptDetail.setDt_e(opPatAptDTO.getDt_e());
		paidAptDetail.setSugest_time(opPatAptDTO.getSugest_time());
		paidAptDetail.setHpName(opPatAptDTO.getHpName());
		paidAptDetail.setEntAddr(opPatAptDTO.getEntAddr());
		paidAptDetail.setAmt(opPatAptDTO.getAmt());
		paidAptDetail.setAmt_Pat(opPatAptDTO.getAmtPat());
		paidAptDetail.setBalance(opPatAptDTO.getBalance());
		paidAptDetail.setAptOpera(opPatAptDTO.getAptOpr());
		paidAptDetail.setAddFg(opPatAptDTO.getAddFg());
		paidAptDetail.setAptChl(opPatAptDTO.getAptChl());
		paidAptDetail.setDayslottp(opPatAptDTO.getDayslottp());
		paidAptDetail.setId_stoep(opPatAptDTO.getId_stoep());
		paidAptDetail.setCode_st(opPatAptDTO.getCode_st());
		paidAptDetail.setDt_st(opPatAptDTO.getDt_st());
		return paidAptDetail;
	}
	/**
	 * 通过预约code获取预约Id-出参
	 * @param str
	 * @return
	 */
	public static AptIdByAptCodeResult getAptIdByAptCodeResult(String str){
		AptIdByAptCodeResult aptIdByAptCode = new AptIdByAptCodeResult();
		aptIdByAptCode.setId_apt(str);
		return aptIdByAptCode;
	}
	/**
	 * 获取本次就诊患者分类-出参
	 * @param enPatCaInfoDTO
	 * @return
	 */
	public static EnPatCaInfoResult getEnPatCaInfoResult(EnPatCaInfoDTO enPatCaInfoDTO){
		if(enPatCaInfoDTO == null){
			return new EnPatCaInfoResult();
		}
		EnPatCaInfoResult enPatCaInfo = new EnPatCaInfoResult();
		enPatCaInfo.setPatCaCode(enPatCaInfoDTO.getPatCaCode());
		enPatCaInfo.setPatCaName(enPatCaInfoDTO.getPatCaName());
		enPatCaInfo.setPatCode(enPatCaInfoDTO.getPatCode());
		enPatCaInfo.setTimesOp(enPatCaInfoDTO.getTimesOp());
		enPatCaInfo.setPatName(enPatCaInfoDTO.getPatName());
		enPatCaInfo.setEntCode(enPatCaInfoDTO.getEntCode());
		return enPatCaInfo;
	}
	/**
	 * 获取排班对应的号位-出参
	 * @param schTickInfoDTOs
	 * @return
	 */
	public static SchTickInfoResult[] getSchTickInfoResult(SchTickInfoDTO[] schTickInfoDTOs){
		if(schTickInfoDTOs == null || schTickInfoDTOs.length <= 0){
			return new SchTickInfoResult[]{};
		}
		ArrayList<SchTickInfoResult> lists = new ArrayList<SchTickInfoResult>();
		for (SchTickInfoDTO schTickInfoDTO : schTickInfoDTOs) {
			SchTickInfoResult schTickInfo = new SchTickInfoResult();
			schTickInfo.setTickId(schTickInfoDTO.getId_tick());
			schTickInfo.setSchId(schTickInfoDTO.getSchId());
			schTickInfo.setT_b(schTickInfoDTO.getT_b());
			schTickInfo.setT_e(schTickInfoDTO.getT_e());
			schTickInfo.setCode(schTickInfoDTO.getCode());
			schTickInfo.setFg_apptable(schTickInfoDTO.getFg_apptable());
			schTickInfo.setTicksId(schTickInfoDTO.getId_ticks());
			lists.add(schTickInfo);
		}
		return lists != null && lists.size() > 0 ? lists.toArray(new SchTickInfoResult[0]) : new SchTickInfoResult[]{};
	}
	/**
	 * 获取患者就诊记录-出参
	 * @param patEntInfoDTOs
	 * @return
	 */
	public static EntListByPatcodeResult[] getEntListByPatcodeResult(PatEntInfoDTO[] patEntInfoDTOs){
		if(patEntInfoDTOs == null || patEntInfoDTOs.length <= 0){
			return new EntListByPatcodeResult[]{};
		}
		ArrayList<EntListByPatcodeResult> lists = new ArrayList<EntListByPatcodeResult>();
		for (PatEntInfoDTO patEntInfoDTO : patEntInfoDTOs) {
			EntListByPatcodeResult entListByPatcode = new EntListByPatcodeResult();
			entListByPatcode.setPatCode(patEntInfoDTO.getPatcode());
			entListByPatcode.setOpTimes(patEntInfoDTO.getOptimes());
			entListByPatcode.setIpTimes(patEntInfoDTO.getIptimes());
			entListByPatcode.setDtAcpt(patEntInfoDTO.getDtacpt());
			entListByPatcode.setEntId(patEntInfoDTO.getEntid());
			entListByPatcode.setEntpCode(patEntInfoDTO.getEntpcode());
			entListByPatcode.setPatName(patEntInfoDTO.getPatname());
			entListByPatcode.setPhyDepId(patEntInfoDTO.getPhydepid());
			entListByPatcode.setPhyDepCode(patEntInfoDTO.getPhydepcode());
			entListByPatcode.setStatusCode(patEntInfoDTO.getStatuscode());
			lists.add(entListByPatcode);
		}
		return lists != null && lists.size() > 0 ? lists.toArray(new EntListByPatcodeResult[0]) : new EntListByPatcodeResult[]{};
	}
	/**
	 * 统计门急诊就诊人次-出参
	 * @param opVisitTimesStatDTOs
	 * @return
	 */
	public static VisitTimesStatResult[] getVisitTimesStatResult(OpVisitTimesStatDTO[] opVisitTimesStatDTOs){
		if(opVisitTimesStatDTOs == null || opVisitTimesStatDTOs.length <= 0){
			return new VisitTimesStatResult[]{};
		}
		ArrayList<VisitTimesStatResult> lists = new ArrayList<VisitTimesStatResult>();
		for (OpVisitTimesStatDTO opVisitTimesStatDTO : opVisitTimesStatDTOs) {
			VisitTimesStatResult entListByPatcode = new VisitTimesStatResult();
			entListByPatcode.setDate(opVisitTimesStatDTO.getDate());
			entListByPatcode.setEnt_times_emg(opVisitTimesStatDTO.getEntTimesEmg());
			entListByPatcode.setCode_dept(opVisitTimesStatDTO.getCodeDept());
			entListByPatcode.setName_dept(opVisitTimesStatDTO.getNameDept());
			entListByPatcode.setEnt_times_op(opVisitTimesStatDTO.getEntTimesOp());
			entListByPatcode.setEnt_times_comm(opVisitTimesStatDTO.getEntTimesComm());
			entListByPatcode.setPhy_days_comm(opVisitTimesStatDTO.getPhyDaysComm());
			entListByPatcode.setEnt_times_prof(opVisitTimesStatDTO.getEntTimesProf());
			entListByPatcode.setPhy_days_prof(opVisitTimesStatDTO.getPhyDaysProf());
			lists.add(entListByPatcode);
		}
		return lists != null && lists.size() > 0 ? lists.toArray(new VisitTimesStatResult[0]) : new VisitTimesStatResult[]{};
	}
	/**
	 * 门急诊出诊科室列表-出参
	 * @param deptWithSchDTOs
	 * @return
	 */
	public static OEPDepListResult[] getOEPDepListResult(DeptWithSchDTO[] deptWithSchDTOs){
		if(deptWithSchDTOs == null || deptWithSchDTOs.length <= 0){
			return new OEPDepListResult[]{};
		}
		ArrayList<OEPDepListResult> lists = new ArrayList<OEPDepListResult>();
		for (DeptWithSchDTO deptWithSchDTO : deptWithSchDTOs) {
			OEPDepListResult oEPDepList = new OEPDepListResult();
			oEPDepList.setCode_dep(deptWithSchDTO.getCode_dep());
			oEPDepList.setName_dep(deptWithSchDTO.getName_dep());
			lists.add(oEPDepList);
		}
		return lists != null && lists.size() > 0 ? lists.toArray(new OEPDepListResult[0]) : new OEPDepListResult[]{};
	}
	/**
	 * 门急诊医生出诊科室列表-出参
	 * @param opEmpDepDTOs
	 * @return
	 */
	public static OEPEmpDepMatchResult[] getOEPEmpDepMatchResult(OpEmpDepDTO[] opEmpDepDTOs){
		if(opEmpDepDTOs == null || opEmpDepDTOs.length <= 0){
			return new OEPEmpDepMatchResult[]{};
		}
		ArrayList<OEPEmpDepMatchResult> lists = new ArrayList<OEPEmpDepMatchResult>();
		for (OpEmpDepDTO opEmpDepDTO : opEmpDepDTOs) {
			OEPEmpDepMatchResult oEPEmpDepMatch = new OEPEmpDepMatchResult();
			oEPEmpDepMatch.setCode_emp(opEmpDepDTO.getCode_emp());
			oEPEmpDepMatch.setName_emp(opEmpDepDTO.getName_emp());
			oEPEmpDepMatch.setCode_dep(opEmpDepDTO.getCode_dep());
			oEPEmpDepMatch.setName_dep(opEmpDepDTO.getName_dep());
			oEPEmpDepMatch.setDoc_special(opEmpDepDTO.getDoc_special());
			lists.add(oEPEmpDepMatch);
		}
		return lists != null && lists.size() > 0 ? lists.toArray(new OEPEmpDepMatchResult[0]) : new OEPEmpDepMatchResult[]{};
	}
	/**
	 * 签到分诊-出参
	 * @param arriveResult
	 * @return
	 */
	public static EntArriveResult getEntArriveResult(ArriveResultBean arriveResult){
		if(arriveResult == null){
			return new EntArriveResult();
		}
		EntArriveResult entArrive = new EntArriveResult();
		entArrive.setErrMsg(arriveResult.getErrMsg());
		entArrive.setCode(arriveResult.getCode());
		entArrive.setSitename(arriveResult.getSiteName());
		return entArrive;
	}
	/**
	 * 取分诊台可分诊挂号记录-出参
	 * @param entRegInfoDTOs
	 * @return
	 */
	public static EntLisByQuebencodeResult[] getEntLisByQuebencodeResult(EntRegInfoDTO[] entRegInfoDTOs){
		if(entRegInfoDTOs == null || entRegInfoDTOs.length <= 0){
			return new EntLisByQuebencodeResult[]{};
		}
		ArrayList<EntLisByQuebencodeResult> lists = new ArrayList<EntLisByQuebencodeResult>();
		for (EntRegInfoDTO entRegInfoDTO : entRegInfoDTOs) {
			EntLisByQuebencodeResult entLisByQuebencode = new EntLisByQuebencodeResult();
			entLisByQuebencode.setPatCode(entRegInfoDTO.getPatCode());
			entLisByQuebencode.setPatName(entRegInfoDTO.getPatName());
			entLisByQuebencode.setDtEntry(entRegInfoDTO.getDtEntry());
			entLisByQuebencode.setDayslottp(entRegInfoDTO.getDayslottp());
			entLisByQuebencode.setResName(entRegInfoDTO.getResName());
			entLisByQuebencode.setResCode(entRegInfoDTO.getResCode());
			entLisByQuebencode.setSrvName(entRegInfoDTO.getSrvName());
			entLisByQuebencode.setSrvCode(entRegInfoDTO.getSrvCode());
			entLisByQuebencode.setChlType(entRegInfoDTO.getChlType());
			entLisByQuebencode.setDeptCode(entRegInfoDTO.getDeptCode());
			entLisByQuebencode.setDeptName(entRegInfoDTO.getDeptName());
			entLisByQuebencode.setTimesOp(entRegInfoDTO.getTimesOp());
			entLisByQuebencode.setTicketno(entRegInfoDTO.getTicketno());
			entLisByQuebencode.setOprDate(entRegInfoDTO.getOprDate());
			entLisByQuebencode.setIdCode(entRegInfoDTO.getIdCode());
			entLisByQuebencode.setIdTp(entRegInfoDTO.getIdTp());
			entLisByQuebencode.setBarcode(entRegInfoDTO.getBarcode());
			entLisByQuebencode.setAge(entRegInfoDTO.getAge());
			entLisByQuebencode.setSex(entRegInfoDTO.getSex());
			entLisByQuebencode.setVisitFlag(entRegInfoDTO.getVisitFlag());
			lists.add(entLisByQuebencode);
		}
		return lists != null && lists.size() > 0 ? lists.toArray(new EntLisByQuebencodeResult[0]) : new EntLisByQuebencodeResult[]{};
	}
	/**
	 * 预约-入参转换为MakeAptDTO
	 * @param aptNew
	 * @return
	 */
	public static MakeAptDTO getMakeAptDTO(AptNewParam aptNew){
		if(aptNew == null){
			return new MakeAptDTO();
		}
		MakeAptDTO makeAptDTO = new MakeAptDTO();
		makeAptDTO.setPatCode(aptNew.getPatCode());
		makeAptDTO.setAptCode(aptNew.getAptCode());
		makeAptDTO.setChlType(aptNew.getChlType());
		makeAptDTO.setAgentCode(aptNew.getAgentPatCode());
		makeAptDTO.setSchId(aptNew.getId_sch());
		makeAptDTO.setOprCode(aptNew.getOprCode());
		makeAptDTO.setOrgName_apply(aptNew.getOrgName_apply());
		makeAptDTO.setTransFlag(aptNew.getTransFlag());
		makeAptDTO.setTickCode(aptNew.getTickNo());
		makeAptDTO.setCtrl1(aptNew.getTickNo());
		return makeAptDTO;
	}
	/**
	 * 预约-出参
	 * @param regResultDTO
	 * @return
	 */
	public static AptNewResult getAptNewResult(RegResultDTO regResultDTO){
		if(regResultDTO == null){
			return new AptNewResult();
		}
		AptNewResult aptNew = new AptNewResult();
		aptNew.setRegMsg(regResultDTO.getRegMsg());
		aptNew.setId_apt(regResultDTO.getId_apt());
		aptNew.setSequenceNumber(regResultDTO.getSequenceNumber());
		aptNew.setTimes(regResultDTO.getTimes());
		aptNew.setVisitingtime(regResultDTO.getVisitingTime());
		aptNew.setSugestExmint(regResultDTO.getSuggestExmint());
		aptNew.setPlaceOfVisit(regResultDTO.getPlaceOfVisit());
		aptNew.setEntDate(regResultDTO.getEntDate());
		aptNew.setId_stoep(regResultDTO.getId_stoep());
		aptNew.setCode_st(regResultDTO.getCode_st());
		aptNew.setDt_st(regResultDTO.getDt_st());
		if(regResultDTO.getIncoicList() != null && regResultDTO.getIncoicList().get(0) != null){
			InvoiceBean invoice = (InvoiceBean)regResultDTO.getIncoicList().get(0);
			aptNew.setInvoice(invoice);
		}
		return aptNew;
	}
	/**
	 * 付费-入参转换为PayForAptDTO
	 * @param payForApt
	 * @return
	 */
	public static PayForAptDTO getPayForAptDTO(PayForAptParam payForApt){
		if(payForApt == null){
			return new PayForAptDTO();
		}
		PayForAptDTO payForAptDTO = new PayForAptDTO();
		payForAptDTO.setFg_printInvoice(payForApt.getFg_printInvoice());
		payForAptDTO.setDt_st(payForApt.getDt_st());
		payForAptDTO.setBusiness_code(payForApt.getBusiness_code());
		payForAptDTO.setAptId(payForApt.getId_apt());
		payForAptDTO.setPatCode(payForApt.getPatCode());
		payForAptDTO.setChlType(payForApt.getChlType());
		payForAptDTO.setOrderNo(payForApt.getOrderNo());
		payForAptDTO.setAccNo(payForApt.getAccNo());
		payForAptDTO.setPayType(payForApt.getPayType());
		payForAptDTO.setPatCardNo(payForApt.getPatCardNo());
		payForAptDTO.setParCardPwd(payForApt.getPatCardPwd());
		payForAptDTO.setMoney(payForApt.getMoney());
		payForAptDTO.setOprCode(payForApt.getOprCode());
		payForAptDTO.setPatHpTp(payForApt.getPatHpTp());
		payForAptDTO.setHpPriceData(payForApt.getHpPriceData());
		payForAptDTO.setPatHpNO(payForApt.getPatHpNo());
		payForAptDTO.setHpPatInfXml(payForApt.getHpPatInfXml());
		return payForAptDTO;
	}
	/**
	 * 信息msg和code-出参
	 * @param resultBean
	 * @return
	 */
	public static MessageResult getMessageResult(ResultBean resultBean){
		if(resultBean == null){
			return new MessageResult();
		}
		MessageResult message = new MessageResult();
		message.setCode(resultBean.getFlag());
		message.setMsg(resultBean.getMsg());
		message.setInvoice(resultBean.getInvoice());
		message.setId_stoep(resultBean.getId_stoep());
		message.setCode_st(resultBean.getCode_st());
		message.setDt_st(resultBean.getDt_st());
		return message;
	}
	/**
	 * string转换MessageResult-出参
	 * @param str
	 * @return
	 */
	public static MessageResult getStrToMessageResult(String str){
		MessageResult message = new MessageResult();
		if (StringUtil.isEmpty(str)) {
			message.setCode("0");
		}else {
			message.setCode("1");
			message.setMsg(str);
		}
		return message;
	}
	/**
	 * 获取就诊记录-出参
	 * @param entInfoDTOs
	 * @return
	 */
	public static EntListByDeptCodeResult[] getEntListByDeptCodeResult(EntInfoDTO[] entInfoDTOs){
		if(entInfoDTOs == null || entInfoDTOs.length <= 0){
			return new EntListByDeptCodeResult[]{};
		}
		ArrayList<EntListByDeptCodeResult> lists = new ArrayList<EntListByDeptCodeResult>();
		for (EntInfoDTO entInfoDTO : entInfoDTOs) {
			EntListByDeptCodeResult entListByDeptCode = new EntListByDeptCodeResult();
			entListByDeptCode.setPatCode(entInfoDTO.getPatCode());
			entListByDeptCode.setOpTimes(entInfoDTO.getOpTimes());
			entListByDeptCode.setIpTimes(entInfoDTO.getIpTimes());
			entListByDeptCode.setEntpCode(entInfoDTO.getEntpCode());
			entListByDeptCode.setDtAcpt(entInfoDTO.getDtAcpt());
			entListByDeptCode.setPatCaCode(entInfoDTO.getPatCaCode());
			entListByDeptCode.setPatPriCode(entInfoDTO.getPatPriCode());
			entListByDeptCode.setHpNo(entInfoDTO.getHpNo());
			entListByDeptCode.setFgFirst(entInfoDTO.getFgFirst());
			entListByDeptCode.setSrvCode(entInfoDTO.getSrvCode());
			entListByDeptCode.setSrvName(entInfoDTO.getSrvName());
			entListByDeptCode.setDeptCode(entInfoDTO.getDeptCode());
			entListByDeptCode.setEmpPhyCode(entInfoDTO.getEmpPhyCode());
			entListByDeptCode.setIsApt(entInfoDTO.getIsApt());
			entListByDeptCode.setDtEntry(entInfoDTO.getDtEntry());
			entListByDeptCode.setAmpm(entInfoDTO.getAmpm());
			entListByDeptCode.setTickNo(entInfoDTO.getTickNo());
			entListByDeptCode.setStatusCode(entInfoDTO.getStatusCode());
			entListByDeptCode.setEntCode(entInfoDTO.getEntCode());
			entListByDeptCode.setFgCanc(entInfoDTO.getFg_canc());
			lists.add(entListByDeptCode);
		}
		return lists != null && lists.size() > 0 ? lists.toArray(new EntListByDeptCodeResult[0]) : new EntListByDeptCodeResult[]{};
	}
	/**
	 * 预约且付费-入参转换为MakeAptDTO
	 * @param aptNew
	 * @return
	 */
	public static MakeAptDTO getMakeAptAndPay(MakeAptAndPayParam aptNew){
		if(aptNew == null){
			return new MakeAptDTO();
		}
		MakeAptDTO makeAptDTO = new MakeAptDTO();
		makeAptDTO.setPatCode(aptNew.getPatCode());
		makeAptDTO.setAptCode(aptNew.getAptCode());
		makeAptDTO.setChlType(aptNew.getChlType());
		makeAptDTO.setAgentCode(aptNew.getAgentPatCode());
		makeAptDTO.setSchId(aptNew.getId_sch());
		makeAptDTO.setOprCode(aptNew.getOprCode());
		makeAptDTO.setOrgName_apply(aptNew.getOrgName_apply());
		makeAptDTO.setTransFlag(aptNew.getTransFlag());
		makeAptDTO.setTickCode(aptNew.getTickNo());
		makeAptDTO.setCtrl1(aptNew.getTickNo());
		makeAptDTO.setId_ticks(aptNew.getId_ticks());
		return makeAptDTO;
	}
	/**
	 * 预约且付费-入参转换为PayForAptDTO
	 * @param aptNew
	 * @return
	 */
	public static PayForAptDTO getMakeAptPayDTO(MakeAptAndPayParam payForApt){
		if(payForApt == null){
			return new PayForAptDTO();
		}
		PayForAptDTO payForAptDTO = new PayForAptDTO();
		payForAptDTO.setPatCode(payForApt.getPatCode());
		payForAptDTO.setChlType(payForApt.getChlType());
		payForAptDTO.setOrderNo(payForApt.getOrderNo());
		payForAptDTO.setAccNo(payForApt.getAccNo());
		payForAptDTO.setPayType(payForApt.getPayType());
		payForAptDTO.setPatCardNo(payForApt.getPatCardNo());
		payForAptDTO.setParCardPwd(payForApt.getPatCardPwd());
		payForAptDTO.setMoney(payForApt.getMoney());
		payForAptDTO.setOprCode(payForApt.getOprCode());
		payForAptDTO.setPatHpTp(payForApt.getPatHpTp());
		payForAptDTO.setHpPriceData(payForApt.getHpPriceData());
		payForAptDTO.setPatHpNO(payForApt.getPatHpNo());
		payForAptDTO.setHpPatInfXml(payForApt.getHpPatInfXml());
		payForAptDTO.setDt_st(payForApt.getDt_st());
		payForAptDTO.setBusiness_code(payForApt.getBusiness_code());
		payForAptDTO.setFg_printInvoice(payForApt.getFg_printInvoice());
		return payForAptDTO;
	}
}
