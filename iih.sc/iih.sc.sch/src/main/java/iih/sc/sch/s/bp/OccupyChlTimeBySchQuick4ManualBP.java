package iih.sc.sch.s.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.apt.dto.d.MtAppDTO;
import iih.sc.apt.dto.d.MtResDTO;
import iih.sc.apt.i.IScAptQryService;
import iih.sc.comm.DateTimeUtils;
import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScParamUtils;
import iih.sc.comm.ScValidator;
import iih.sc.scbd.bdsrv.d.ScBdsrvDO;
import iih.sc.scbd.bdsrv.i.IScbdsrvMDORService;
import iih.sc.scbd.schedulesrv.d.ScheduleSrvDO;
import iih.sc.scbd.schedulesrv.i.ISchedulesrvMDORService;
import iih.sc.sch.dto.d.SchTickMdTimeDTO;
import iih.sc.sch.s.bp.mt.apt.bp.OccupyTicks4TimeMd4ManualBP;
import iih.sc.sch.s.ep.SchEP;
import iih.sc.sch.s.ep.TickChlEP;
import iih.sc.sch.s.ep.TickEP;
import iih.sc.sch.scsch.d.ScSchChlDO;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.sch.scticks.d.ScSchTicksDO;
import iih.sc.scp.scplan.d.EuTimeslotTP;
import iih.sc.scp.scplan.d.ScPlanDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FTime;
import xap.mw.sf.core.util.ServiceFinder;

public class OccupyChlTimeBySchQuick4ManualBP {

	public ScSchTickDO exec(ScPlanDO planDO, MtAppDTO appDTO, String id_scchl, ScSchChlDO[] chlDOs, ScSchDO schDO,
			MtResDTO resDTO) throws BizException {
		// 排班id
		String id_sch = schDO.getId_sch();
		// 时长
		int srvlot = this.getSrvlot(planDO, appDTO);
		// 0.排班加锁
		lockSch(id_scchl);
		// 1.验证号源池剩余时间是否足够使用
		ScSchChlDO schChlDo = validateSch(schDO, srvlot, chlDOs);
		if (schChlDo == null)
			return null;
		// 2.进行互斥校验
		SchTickMdTimeDTO schTickMdTime = this.check(schDO, resDTO, planDO, appDTO, id_scchl, srvlot);
		
		if (schTickMdTime == null){
			return null;
		}else{
			FTime t_b = schTickMdTime.getT_b();
			FTime t_e = schTickMdTime.getT_e();
			resDTO.setSpend_time((t_e.getHour()*60+t_e.getMinute())-(t_b.getHour()*60+t_b.getMinute()));
		}
		// 3.占用号段
		ScSchTicksDO schTicks = occupyTicks(planDO.getId_scsrv(), id_sch, schTickMdTime);
		if (schTicks == null)
			return null;
		// 4.占用号位
		ScSchTickDO schTickDO = occupyTick(planDO.getId_scsrv(), schTicks, schChlDo.getScpolcn());
		if (schTickDO == null)
			return null;
		// 5.占用班资源
		this.occupySch(id_sch, schTickMdTime, schChlDo.getScpolcn());
		return schTickDO;
	}

	/**
	 * 占用排班号源
	 * 
	 * @author yaohl
	 * 
	 * @param id_sch
	 * @param schTickMdTime
	 * @param polcn
	 * @throws BizException
	 */
	private void occupySch(String id_sch, SchTickMdTimeDTO schTickMdTime, Integer polcn) throws BizException {
		int mins = DateTimeUtils.getMins(schTickMdTime.getT_b(), schTickMdTime.getT_e());
		SchEP schBP = new SchEP();
		schBP.occupyTick4Auto(id_sch, polcn, mins);
	}

	/**
	 * 时间片模式占用号位处理
	 * 
	 * @author
	 * 
	 * @param id_sch
	 * @param schTickMdTime
	 * @return
	 * @throws BizException
	 */
	private ScSchTickDO occupyTick(String id_scsrv, ScSchTicksDO schTicks, Integer polcn) throws BizException {
		TickEP ep = new TickEP();
		ScSchTickDO[] schTickDOs = ep.insert4TimeMd(schTicks, polcn, id_scsrv);
		if (ArrayUtil.isEmpty(schTickDOs)) {
			return null;
			// throw new BizException("时间片模式新增号位出错!");
		}
		return schTickDOs[0];
	}

	/**
	 * 时间片模式占用号段处理
	 * 
	 * @author yaohl
	 * @param id_sch
	 * @param schTickMdTime
	 * @return
	 * @throws BizException
	 */
	private ScSchTicksDO occupyTicks(String id_scsrv, String id_sch, SchTickMdTimeDTO schTickMdTime)
			throws BizException {
		OccupyTicks4TimeMd4ManualBP bp = new OccupyTicks4TimeMd4ManualBP();
		ScSchTicksDO schTicks = bp.exec(id_scsrv, id_sch, schTickMdTime);
		if (schTicks == null) {
			return null;
		}
		return schTicks;
	}

	/**
	 * 验证排班剩余时间是否足够使用
	 * 
	 * @author yaohl
	 * @param id_sch
	 * @param schTickMdTime
	 * @throws BizException
	 */
	private ScSchChlDO validateSch(ScSchDO schDO, int srvlot, ScSchChlDO[] schChlDos) throws BizException {
		Map<Integer, ScSchChlDO> canUseSchChlMap = new HashMap<Integer, ScSchChlDO>();
		for (ScSchChlDO scSchChlDO : schChlDos) {
			Integer canUse = (Integer) schDO.getAttrVal(String.format("Quan%s_appt", scSchChlDO.getScpolcn()))
					- (Integer) schDO.getAttrVal(String.format("Quan%s_used", scSchChlDO.getScpolcn()));
			if (canUse.intValue() >= srvlot) {
				canUseSchChlMap.put(scSchChlDO.getScpolcn(), scSchChlDO);
			}
		}
		if (canUseSchChlMap.size() == 0) {
			throw new BizException(IScMsgConst.ERROR_SC_APT_RES_NOT_ENOUGH);
		} else {
			// 只有一个的情况下直接返回该号源池, 多个的情况下返回号源池号中可用时间比较少的那个号源池
			return this.getMinCanUseTimePolcn(canUseSchChlMap, schChlDos[0]);
		}
	}

	/**
	 * @author yaohl 获取号源池中 可用分钟数 最小的号源池渠道
	 * @param polcnMap
	 * @return
	 */
	private ScSchChlDO getMinCanUseTimePolcn(Map<Integer, ScSchChlDO> polcnMap, ScSchChlDO schChlDo) {
		Integer canUse_a = (Integer) schChlDo.getQuan_appt() - (Integer) schChlDo.getQuan_used();
		ScSchChlDO chlDO = schChlDo;
		for (ScSchChlDO scSchChlDO : polcnMap.values()) {
			Integer canUse_b = (Integer) scSchChlDO.getQuan_appt() - (Integer) scSchChlDO.getQuan_used();
			if (canUse_a <= canUse_b) {
				chlDO = scSchChlDO;
			}
		}
		return chlDO;
	}

	/**
	 * 校验是否与已用时间冲突
	 * 
	 * @param startTime
	 * @param endTime
	 * @param usedDatas
	 * @return
	 */
	private boolean checkScChlParam(FTime startTime, FTime endTime, FArrayList usedDatas) {
			for (Object usedData : usedDatas) {
			ScSchTicksDO ticksDO = (ScSchTicksDO) usedData;
				FTime usedStartTime = ticksDO.getT_b();
				FTime usedEndTime = ticksDO.getT_e();
			// int mins1_4 = 60*60*startTime.getHour()+ 60*startTime.getMinute()
			// - 60*60*usedEndTime.getHour()+ 60*usedEndTime.getMinute();
			// int mins3_2 = 60*60*usedStartTime.getHour()+
			// 60*usedStartTime.getMinute() - 60*60*endTime.getHour()+
			// 60*endTime.getMinute();
				boolean isConflict = ScAppUtils.isMixedFTime(startTime, endTime, usedStartTime, usedEndTime);
			if (isConflict) {// true 判断两个时间段是否有交集
					return false;
				}
			}
			return true;
		}

		/**
		 * 得到时长
	 * 
		 * @param planDO
		 * @param appDTO
		 * @return
		 * @throws BizException
		 */
	private int getSrvlot(ScPlanDO planDO, MtAppDTO appDTO) throws BizException {

		if (planDO.getEu_timeslottp() == EuTimeslotTP.SINGLE) {// 计划时长
			if (planDO.getSrvslot() < 1) {
				return planDO.getSrvslot_min();// 如果计划时长小于1 则取最小刻度
			} else {
					return planDO.getSrvslot();
				}
		} else if (planDO.getEu_timeslottp() == EuTimeslotTP.DIC) {// 服务时长
			ScheduleSrvDO srvDO = ServiceFinder.find(ISchedulesrvMDORService.class).findById(planDO.getId_scsrv());
				return srvDO.getSrvslot();
		} else if (planDO.getEu_timeslottp() == EuTimeslotTP.SPE) {// 诊疗项目时长
			String whereStr = " id_scca = '" + planDO.getId_scca() + "' and id_srv  = '" + appDTO.getId_srv() + "' ";
			IScbdsrvMDORService scbdsrvMDORService = ServiceFinder.find(IScbdsrvMDORService.class);
				ScBdsrvDO[] bdsrvDOs = 	scbdsrvMDORService.find(whereStr, null, FBoolean.FALSE);
				//FIXME  应该判空 为空提示该诊疗项目未再医技排班医疗项目维护中配置
			if(ArrayUtil.isEmpty(bdsrvDOs)){
				throw new BizException(String.format(IScMsgConst.ERROR_SCBDSRV_NOT_CONFIG,appDTO.getName_or()));
			}
			if (bdsrvDOs[0].getSrvslot() != null && bdsrvDOs[0].getSrvslot() != 0) {
					return bdsrvDOs[0].getSrvslot();
			} else if (planDO.getSrvslot() < 1) {
				// 如果计划时长小于1 则取最小刻度
				return planDO.getSrvslot_min();
			} else {
						return planDO.getSrvslot();
				}
		} else {// 自定义时长
			if (planDO.getSrvslot() < 1) {
					return planDO.getSrvslot_min();
			} else {
					return planDO.getSrvslot();
				}
			}
		}

		/**
		 * 排班加锁
		 * 
		 * @author liubin
		 * 
		 * @param id_sch
		 * @throws BizException
		 */
	private void lockSch(String id_sch) throws BizException {
			TickChlEP tickEP = new TickChlEP();
			tickEP.lockSch(id_sch);
		}

		/**
		 * 校验参数
		 * 
		 * @author zhengcm
		 * 
	 * @param schId
	 *            排班ID
	 * @param polcn
	 *            号源池
	 * @param chlId
	 *            渠道ID
		 * @throws BizException
		 */
	private void validateParam(String schId, Map<Integer, Integer> polcnMap, String chlId) throws BizException {
			// 参数校验
			ScValidator.validateParam("schId", schId);
			ScValidator.validateParam("chlId", chlId);
			for (Integer polcn : polcnMap.keySet()) {
				if ((polcn == null || polcn < 0 || polcn > 10) && polcn != IScDictCodeConst.SC_CHL_REMAIN) {
					throw new BizException(IScMsgConst.ERROR_SC_SCH_POLCN_OUT_OF_RANGE);
				}
			}
		}

	/**
	 * @exception 获取号段剩余时间
	 * @param planDO
	 * @param schDO
	 * @param appDTO
	 * @param id_scchl
	 * @return 号段集合
	 * @throws BizException
	 * @auther yaohl
	 * @date 2018年12月11日
	 */
	private List<ScSchTicksDO> getTicksTime(ScPlanDO planDO, ScSchDO schDO, MtAppDTO appDTO, String id_scchl,
			int srvlot,MtResDTO resDTO) throws BizException {
		// 得出此时间段已用和未用的号段信息
		FArrayList datas = ServiceFinder.find(IScAptQryService.class).getMtAptSchTicks(schDO.getId_sch(),
				appDTO.getId_srv(), id_scchl);
		List<ScSchTicksDO> unusedDatas = new ArrayList<ScSchTicksDO>();// 未使用的号段
		//是否校验实际时间点
		FBoolean isCheckNowTime = FBoolean.FALSE;
		if(!IScDictCodeConst.SC_CHOICE_APT.equals(resDTO.getSc_oper_src())){
			isCheckNowTime = ScParamUtils.getscMtAptChkNowTime();
		}
		FDateTime now = ScAppUtils.getServerDateTime();
		// TODO 校验号源池渠道
		if (datas.size() == 0) {// 没有预约信息 并且时间大于时长
			FTime startTime = schDO.getT_b_acpt();
			FTime endTime = schDO.getT_e_acpt();
			//校验实际时间点
			if (isCheckNowTime.booleanValue() && now.getBeginDate().compareTo(schDO.getD_sch().asBegin()) == 0) {
				//如果实际时间在号段开始和结束时间之间的
				if(now.getUFTime().compareTo(startTime) >= 0 && now.getUFTime().compareTo(endTime) < 0 ){
					startTime = now.getUFTime();
				}
				//如果实际时间在大于等于号段结束时间则不可用
				if(now.getUFTime().compareTo(endTime) >= 0){
					return null;
				}
			}
			if (DateTimeUtils.getMins(startTime, schDO.getT_e_acpt()) >= srvlot) {
				ScSchTicksDO ticks = new ScSchTicksDO();
				ticks.setT_b(startTime);
				ticks.setT_e(schDO.getT_e_acpt());
				unusedDatas.add(ticks);
			}
		} else {
			// 将大于时长的 未用号段时间 放入list集合
			for (Object data : datas) {
				ScSchTicksDO ticksDO = (ScSchTicksDO) data;
				FTime startTime = ticksDO.getT_b();
				FTime endTime = ticksDO.getT_e();
				if (isCheckNowTime.booleanValue() && now.getBeginDate().compareTo(schDO.getD_sch().asBegin()) == 0) {
					//校验实际时间点
					if(now.getUFTime().compareTo(ticksDO.getT_b()) >= 0 && now.getUFTime().compareTo(endTime) < 0){//如果实际时间在号段开始时间和结束时间之间的
						startTime = now.getUFTime();
					}else if(now.getUFTime().compareTo(endTime)>=0){//如果实际时间大于等于号段结束时间不可用
						continue;
					}
					if (!ticksDO.getFg_used().booleanValue()
							&& DateTimeUtils.getMins(startTime, ticksDO.getT_e()) >= srvlot) {
						ticksDO.setT_b(startTime);
						unusedDatas.add(ticksDO);
					}
				}else{
				if (!ticksDO.getFg_used().booleanValue()
						&& DateTimeUtils.getMins(ticksDO.getT_b(), ticksDO.getT_e()) >= srvlot) {
					unusedDatas.add(ticksDO);
				}
			}
		}
		}
		return unusedDatas;
	}

		/**
	 * @exception :进行互斥规则校验
	 * @return 第一个可用的时间
	 * @param schDO
		 * @param resDTO
	 * @param planDO
	 * @param appDTO
	 * @param id_scchl
		 * @throws BizException
	 * @auther yaohl
	 * @date 2018年12月11日
		 */
	// FIXME 校验互斥规则，返回结果是得到互斥规则下的第一个可用时间 没有找到合适的时间，进行异常
	private SchTickMdTimeDTO check(ScSchDO schDO, MtResDTO resDTO, ScPlanDO planDO, MtAppDTO appDTO, String id_scchl,
			int srvlot) throws BizException {
		FDateTime f_b = null; // 号段开始时间
		FDateTime f_e = null; // 号段结束时间
		FTime startTime = null;// 满足条件的开始时间
		FTime endTime = null;// 结束时间
		FDate d_sch = schDO.getD_sch().asBegin();// 排班日期
		List<Map<String, FDateTime>> timeList = new ArrayList<Map<String, FDateTime>>();// 创建可用时间段集合
		List<Map<String, FDateTime>> timeHintList = new ArrayList<Map<String, FDateTime>>();// 可用的需要提示的时间段集合
		boolean isCheckExcl = false;// 是否通过排斥禁止
		
		// 获取排班中剩余的号段时间
		List<ScSchTicksDO> ticksTimes = this.getTicksTime(planDO, schDO, appDTO, id_scchl, srvlot,resDTO);
		if (!ListUtil.isEmpty(ticksTimes)) {
			// 没有互斥信息
			if (ListUtil.isEmpty(resDTO.getDays_excl_must()) && ListUtil.isEmpty(resDTO.getDays_excl_times())
					&& ListUtil.isEmpty(resDTO.getDays_together_must()) && ListUtil.isEmpty(resDTO.getDays_together_hint()) && ListUtil.isEmpty(resDTO.getDays_excl_hint())) {
				for (ScSchTicksDO ticks : ticksTimes) {
					SchTickMdTimeDTO schTickMdtime = new SchTickMdTimeDTO();
					startTime = ticks.getT_b();
					endTime = ScAppUtils.addMinutesByFTime(startTime, srvlot);// 结束时间=开始时间+时长
					schTickMdtime.setT_b(startTime);
					schTickMdtime.setT_e(endTime);
					return schTickMdtime;
				}
			}
			// 存在服务互斥规则
			for (ScSchTicksDO ticks : ticksTimes) {
				f_b = new FDateTime(d_sch, ticks.getT_b());
				f_e = new FDateTime(d_sch, ticks.getT_e());
				if (!ListUtil.isEmpty(resDTO.getDays_excl_times())) {// 次数限制
					for (Object object : resDTO.getDays_excl_times()) {
						FMap timesMap = (FMap) object;
						FDate dt_b = new FDate(timesMap.get("dt_b").toString()).asBegin();
						FDate dt_e = new FDate(timesMap.get("dt_e").toString()).asBegin();
						// 是否在互斥日期内
						if (dt_b.compareTo(d_sch) <= 0 && dt_e.compareTo(d_sch) >= 0) {
							timesMap.put("is_show", FBoolean.TRUE.toString());
							return null;// 在次数限制日期内 返回空
						}
					}
				}
				// 校验 排斥禁止
				if (!ListUtil.isEmpty(resDTO.getDays_excl_must())) {// 禁止
				for (Object object : resDTO.getDays_excl_must()) {
						FMap exclMap = (FMap) object;
						FDateTime dt_b = new FDateTime(exclMap.get("dt_b").toString());
						FDateTime dt_e = new FDateTime(exclMap.get("dt_e").toString());
						// 判断是否和号段中时间交叉
						if (DateTimeUtils.isMixedFDateTime(dt_b, dt_e, f_b, f_e)) {
							exclMap.put("is_show", FBoolean.TRUE.toString());
							// 可用号段集合
							timeList = this.getCanUsedExcelMust(dt_b, dt_e, f_b, f_e, resDTO.getDays_excl_must());
							if (timeList.isEmpty()) {
								break;
							} else {
								isCheckExcl = true;
							}
						} else {
							Map<String,FDateTime> map = new HashMap<String,FDateTime>();
							map.put("dt_b", f_b);
							map.put("dt_e", f_e);
							timeList.add(map);
							isCheckExcl = true;
					}
				}
				}else{
					Map<String,FDateTime> map = new HashMap<String,FDateTime>();
					map.put("dt_b", f_b);
					map.put("dt_e", f_e);
					timeList.add(map);
			}
				
				if (!ListUtil.isEmpty(resDTO.getDays_together_must())) {// 并行
				for (Object object : resDTO.getDays_together_must()) {
						List<Map<String,FDateTime>> listTemp = new ArrayList<Map<String,FDateTime>>();
						List<Map<String,FDateTime>> listRemoveTemp = new ArrayList<Map<String,FDateTime>>();
						FMap togetherMap = (FMap) object;
						FDateTime dt_b = new FDateTime(togetherMap.get("dt_b").toString());
						FDateTime dt_e = new FDateTime(togetherMap.get("dt_e").toString());
						if (isCheckExcl) {
							// 是否在互斥日期内
							if (dt_b.getDate().asBegin().compareTo(d_sch.asBegin()) >= 0
									&& dt_e.getDate().asBegin().compareTo(d_sch.asBegin()) >= 0) {
								if(!timeList.isEmpty()){
									List<Map<String,FDateTime>> timesListTemp = new ArrayList<Map<String,FDateTime>>();
									for (Map<String,FDateTime> timeMap : timeList) {
										FDateTime d_b = timeMap.get("dt_b");
										FDateTime d_e = timeMap.get("dt_e");
										if (DateTimeUtils.isMixedFDateTime(dt_b, dt_e, d_b, d_e)) {
											List<Map<String,FDateTime>> list = this.getCanUsedTogetherMust(dt_b, dt_e, d_b, d_e, resDTO.getDays_together_must());
											listTemp.addAll(list);
									}
								}
									timeList.clear();
									timeList.addAll(listTemp);
								}else{
									togetherMap.put("is_show", FBoolean.TRUE.toString());
									break;
								}
							}
						} else {// 没有禁止
							// 判断是否和号段中时间交叉
							if (DateTimeUtils.isMixedFDateTime(dt_b, dt_e, f_b, f_e)) {
								timeList = this.getCanUsedTogetherMust(dt_b, dt_e, f_b, f_e, resDTO.getDays_together_must());
								if (timeList.isEmpty()) {
									isCheckExcl = false;
									togetherMap.put("is_show", FBoolean.TRUE.toString());
								}else{
									isCheckExcl = true;
								}
							} else {
								togetherMap.put("is_show", FBoolean.TRUE.toString());
								isCheckExcl = false;
								break;
							}
						}
					}
				}else{
					isCheckExcl = true;
				}
				//通过排斥禁止强制并行次数限制后才进行排斥提示和并行提示的校验  优先级:排斥提示>并行提示
				if (isCheckExcl) {
					boolean isCheckExclHint = true;//是否通过排斥提示
					//暂时存放可用的时间段
					List<Map<String,FDateTime>> dataListTemp = new ArrayList<Map<String,FDateTime>>();
					dataListTemp.addAll(timeList);
					// 校验 排斥提示
					if (!ListUtil.isEmpty(resDTO.getDays_excl_hint())) {// 排斥提示
						for (Object object : resDTO.getDays_excl_hint()) {
							FMap exclMap = (FMap) object;
							FDateTime dt_b = new FDateTime(exclMap.get("dt_b").toString());
							FDateTime dt_e = new FDateTime(exclMap.get("dt_e").toString());
							List<Map<String,FDateTime>> listTemp = new ArrayList<Map<String,FDateTime>>();
							if(!dataListTemp.isEmpty()){
								for (Map<String, FDateTime> map2 : dataListTemp) {
									FDateTime d_b = map2.get("dt_b");
									FDateTime d_e = map2.get("dt_e");
									// 判断是否和号段中时间交叉
									if (DateTimeUtils.isMixedFDateTime(dt_b, dt_e, d_b, d_e)) {
										List<Map<String,FDateTime>> useList = this.getCanUsedExcelMust(dt_b, dt_e, d_b, d_e, resDTO.getDays_excl_hint());
										if(!useList.isEmpty()){
											listTemp.addAll(useList);
										}
									}else{
										listTemp.add(map2);
									}
								}
								if(listTemp.isEmpty()){
									exclMap.put("is_show", FBoolean.TRUE.toString());
								}else{
									listTemp.addAll(listTemp);
								}
								dataListTemp.clear();
								dataListTemp.addAll(listTemp);
							}else{
								isCheckExclHint = false;
								break;
							}
						}
					}
					
					
					//通过了排斥提示后代表排斥提示还有可用的时间段 否则代表时间段全部排斥
					if (isCheckExclHint) {
						if (!dataListTemp.isEmpty()) {
							//暂时存放可用的时间段
							List<Map<String,FDateTime>> dataListTemp2 = new ArrayList<Map<String,FDateTime>>();
							dataListTemp2.addAll(dataListTemp);
							if (!ListUtil.isEmpty(resDTO.getDays_together_hint())) {//并行提示
								for (Object object : resDTO.getDays_together_hint()) {
									FMap togetherMap = (FMap) object;
									FDateTime dt_b = new FDateTime(togetherMap.get("dt_b").toString());
									FDateTime dt_e = new FDateTime(togetherMap.get("dt_e").toString());
									List<Map<String,FDateTime>> listTemp = new ArrayList<Map<String,FDateTime>>();
									for (Map<String, FDateTime> map2 : dataListTemp2) {
										FDateTime d_b = map2.get("dt_b");
										FDateTime d_e = map2.get("dt_e");
										if (DateTimeUtils.isMixedFDateTime(dt_b, dt_e, d_b, d_e)) {
											listTemp.addAll(this.getCanUsedTogetherMust(dt_b, dt_e,
												d_b,d_e, resDTO.getDays_together_hint()));
										}
									}
									if (listTemp.isEmpty()) {
										togetherMap.put("is_show", FBoolean.TRUE.toString());
									}
									dataListTemp2.clear();
									dataListTemp2.addAll(listTemp);
								}
								if (!dataListTemp2.isEmpty()) {
									dataListTemp.clear();
									dataListTemp.addAll(dataListTemp2);
								}
							}
						}
				}
				// 得到最终截取到的时间
					if (!dataListTemp.isEmpty()) {
						for (Map<String, FDateTime> map2 : dataListTemp) {
							FDateTime d_b = map2.get("dt_b");
							FDateTime d_e = map2.get("dt_e");
						// 如果这段时间满足时长
							if (d_b.addSeconds(srvlot * 60).compareTo(d_e) <= 0) {
							SchTickMdTimeDTO schTickMdtime = new SchTickMdTimeDTO();
								startTime = d_b.getUFTime();
							endTime = ScAppUtils.addMinutesByFTime(startTime, srvlot);// 结束时间=开始时间+时长
							schTickMdtime.setT_b(startTime);
							schTickMdtime.setT_e(endTime);
							return schTickMdtime;
						}
					}
					}else{
						//如果没有符合排斥提示
						timeHintList.addAll(timeList);
					}
				}
			}
			if (!timeHintList.isEmpty()) {
				for (Map<String, FDateTime> map2 : timeHintList) {
					FDateTime d_b = map2.get("dt_b");
					FDateTime d_e = map2.get("dt_e");
					// 如果这段时间满足时长
					if (d_b.addSeconds(srvlot * 60).compareTo(d_e) <= 0) {
						SchTickMdTimeDTO schTickMdtime = new SchTickMdTimeDTO();
						startTime = d_b.getUFTime();
						endTime = ScAppUtils.addMinutesByFTime(startTime, srvlot);// 结束时间=开始时间+时长
						schTickMdtime.setT_b(startTime);
						schTickMdtime.setT_e(endTime);
						return schTickMdtime;
					}
				}
			}
		}
		throw new BizException(IScMsgConst.ERROR_SC_SCH_RES_NOT_ENOUGH);
	}
	/**
	 * 与禁止时间交叉
	 *                时间处理 得出可用时间
	 * @param rt_b
	 *            禁止开始时间
	 * @param rt_e
	 *            禁止结束时间
	 * @param st_b
	 *            号段开始时间
	 * @param st_e
	 *            号段结束时间
	 * @param et
	 *            resDTO.getDays_excl_must()禁止集合
	 * @auther yaohl
	 * @date 2018年12月10日
	 */
	private List<Map<String,FDateTime>> getCanUsedExcelMust(FDateTime rt_b, FDateTime rt_e, FDateTime st_b,
			FDateTime st_e, FArrayList et) {
		List<Map<String,FDateTime>> result = new ArrayList<Map<String,FDateTime>>();
		
		// first r > s 禁止时间大于号段时间
		if (rt_b.compareTo(st_b) <= 0 && rt_e.compareTo(st_e) >= 0) {
			return result;
		}
		// second r<s 号段时间大于禁止时间
		if (rt_b.compareTo(st_b) >= 0 && rt_e.compareTo(st_e) <= 0) {
			if (st_b.compareTo(rt_b) < 0) {
				Map<String, FDateTime> map = new HashMap<String, FDateTime>();
				map.put("dt_b", st_b);
				map.put("dt_e", rt_b);
				result.add(map);
				//map.put(st_b, rt_b);
			}
			if (rt_e.compareTo(st_e) < 0) {
				Map<String, FDateTime> map = new HashMap<String, FDateTime>();
				map.put("dt_b", rt_e);
				map.put("dt_e", st_e);
				result.add(map);
				//map.put(rt_e, st_e);
					}
				}
		// third r X s L禁止时间 与号段时间左交叉
		if (rt_b.compareTo(st_b) < 0 && rt_e.compareTo(st_b) > 0 && rt_e.compareTo(st_e) < 0) {
			Map<String, FDateTime> map = new HashMap<String, FDateTime>();
			map.put("dt_b", rt_e);
			map.put("dt_e", st_e);
			result.add(map);
			//map.put(rt_e, st_e);
		}
		// fourth r X s R 禁止时间与号段时间右交叉
		if (st_b.compareTo(rt_b) < 0 && rt_b.compareTo(st_e) < 0 && st_e.compareTo(rt_e) < 0) {
			Map<String, FDateTime> map = new HashMap<String, FDateTime>();
			map.put("dt_b", st_b);
			map.put("dt_e", rt_b);
			result.add(map);
			//map.put(st_b, rt_b);

			}
		return result;
	}

	/**
	 * 与并行交叉时间处理 得出可用时间
	 * 
	 * @param rt_b
	 *            禁止开始时间
	 * @param rt_e
	 *            禁止结束时间
	 * @param st_b
	 *            号段开始时间
	 * @param st_e
	 *            号段结束时间
	 * @param tt
	 *            resDTO.getDays_together_must() 并行集合
	 * @return
	 * @auther yaohl
	 * @date 2018年12月26日
	 */
	private List<Map<String, FDateTime>> getCanUsedTogetherMust(FDateTime rt_b, FDateTime rt_e, FDateTime st_b,
			FDateTime st_e, FArrayList tt) {
		List<Map<String, FDateTime>> result = new ArrayList<Map<String, FDateTime>>();
		
		// FArrayList et = resDTO.getDays_excl_must();// 禁止
		// FArrayList tt = resDTO.getDays_together_must();// 并行
		// first r > s 并行时间大于号段时间
		if (rt_b.compareTo(st_b) <= 0 && rt_e.compareTo(st_e) >= 0) {
			Map<String, FDateTime> map = new HashMap<String, FDateTime>();
			map.put("dt_b", st_b);
			map.put("dt_e", st_e);
			result.add(map); 
			//map.put(st_b, st_e);
			}
		// second r<s 号段时间大于并行时间
		if (rt_b.compareTo(st_b) >= 0 && rt_e.compareTo(st_e) <= 0) {
			Map<String, FDateTime> map = new HashMap<String, FDateTime>();
			map.put("dt_b", rt_b);
			map.put("dt_e", rt_e);
			result.add(map); 
			//map.put(rt_b, st_e);
					}
		// third r X s L并行时间 与号段时间左交叉
		if (rt_b.compareTo(st_b) < 0 && rt_e.compareTo(st_b) > 0 && rt_e.compareTo(st_e) < 0) {
			Map<String, FDateTime> map = new HashMap<String, FDateTime>();
			map.put("dt_b", st_b);
			map.put("dt_e", st_e);
			result.add(map); 
			//map.put(st_b, st_e);
				}
		// fourth r X s R 并行时间与号段时间右交叉
		if (st_b.compareTo(rt_b) < 0 && rt_b.compareTo(st_e) < 0 && st_e.compareTo(rt_e) < 0) {
			Map<String, FDateTime> map = new HashMap<String, FDateTime>();
			map.put("dt_b", rt_b);
			map.put("dt_e", st_e);
			result.add(map);
			//map.put(rt_b, st_b);
			}
		return result;
		}
}
