package iih.sc.sch.s.task.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.res.dayslot.d.DaysLotDO;
import iih.sc.comm.ScAppUtils;
import iih.sc.scbd.i.IScDaysLotService;
import iih.sc.scbd.s.bp.dayslot.GetDaysLotDOBP;
import iih.sc.sch.s.ep.SchEP;
import iih.sc.sch.s.ep.TickEP;
import iih.sc.sch.s.ep.TicksEP;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.sctick.d.EuUseScope;
import iih.sc.sch.sctick.d.EuUseState;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.sch.scticks.d.ScSchTicksDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.service.time.TimeService;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 门诊_门诊排班过期号源处理
 * 
 * @author yaohl
 * @date 2019-08-16
 */
public class TickTimeChkPastBP {

	/**
	 * 任务执行
	 * 
	 * @param map
	 */
	public void exec(Map<String, Object> map) throws BizException {

		// 设置上下文组织
		Context.get().setOrgId((String) map.get("id_org"));
		Context.get().setGroupId((String) map.get("id_grp"));
		// 需要处理的过期号位集合
		List<ScSchTickDO> handleTickList = new ArrayList<ScSchTickDO>();
		// 排班-号位集合
		Map<String,List<ScSchTickDO>> tickMap  = new HashMap<String,List<ScSchTickDO>>();
		// 获取当前午别的排班
		List<ScSchDO> timeChkSch = new ArrayList<ScSchDO>();
		//如果有跨天午别需要获取前一天跨天的排班数据
		List<ScSchDO> timeCrossChkSch = new ArrayList<ScSchDO>();
		FDateTime now = ScAppUtils.getServerDateTime();//当前时间
		FDate d_today = now.getBeginDate();//当前日期
		
		// 1、获取当前午别
		IScDaysLotService daysLotService = ServiceFinder.find(IScDaysLotService.class);
		DaysLotDO nowDaysLot = daysLotService.getNowDaysLot(IScDictCodeConst.SD_SCTP_OP, FBoolean.FALSE);
		GetDaysLotDOBP bp = new GetDaysLotDOBP();
		DaysLotDO[] dayslots = bp.exec(IScDictCodeConst.SD_SCTP_OP);
		if(ArrayUtil.isEmpty(dayslots)) return;
		DaysLotDO corssDaysLot = null;
		boolean isContainCross = false;
		for (DaysLotDO daysLotDO : dayslots) {
			if(daysLotDO.getTime_begin().compareTo(daysLotDO.getTime_end()) > 0){
				corssDaysLot = daysLotDO;
				isContainCross = true;
			}
		}
		// 2、获取当前需要设置过期的排班
		if(nowDaysLot == null || StringUtil.isEmptyWithTrim(nowDaysLot.getId_dayslot())) return;
		timeChkSch = this.getTimeChkSch(nowDaysLot.getId_dayslot(),now,d_today,false,null);
		if(isContainCross){
			timeCrossChkSch = this.getTimeChkSch(null,now,d_today,true,corssDaysLot.getId_dayslot());
		}
		timeChkSch.addAll(timeCrossChkSch);
		// 3、顺序对每个排班的号源进行处理
		SchEP schEP = new SchEP();
		TickEP tickEP = new TickEP();
		TicksEP ticksEP = new TicksEP();
		if(ListUtil.isEmpty(timeChkSch))return;
		
		// 4.获取排班和号位分组集合
		tickMap = this.getTick(timeChkSch, tickEP);
		for (ScSchDO scSchDO : timeChkSch) {
			// 4.1 解析号位
			Map<Integer,Integer> polnoMap = new HashMap<Integer,Integer>();// 未使号位   key:号源池polon  value:号位中设置该号源池渠道数量(开放、未用)
			if(tickMap.containsKey(scSchDO.getId_sch())){
				handleTickList.clear();
				for (ScSchTickDO tickDO : tickMap.get(scSchDO.getId_sch())) {
					if(isContainCross){
						if(nowDaysLot.getId_dayslot().equals(corssDaysLot.getId_dayslot())){
							if(scSchDO.getD_sch().asBegin().compareTo(d_today) == 0){
								if(tickDO.getT_e().compareTo(new FTime("23:59:59")) <=0 && tickDO.getT_e().compareTo(corssDaysLot.getTime_begin()) >= 0){
									if(tickDO.getT_e().compareTo(now.getUFTime()) < 0 && tickDO.getEu_used() == EuUseState.WY && tickDO.getEu_usescope() == EuUseScope.APT && tickDO.getFg_active().booleanValue()){
										handleTickList.add(tickDO);
									}
								}
							}else if(scSchDO.getD_sch().asBegin().compareTo(d_today) < 0){
								if(tickDO.getT_e().compareTo(new FTime("00:00:00")) >=0 && tickDO.getT_e().compareTo(corssDaysLot.getTime_end()) <= 0){
									FDateTime temp = new FDateTime(scSchDO.getD_sch().getDateAfter(1), tickDO.getT_e());
									if(temp.compareTo(now) < 0 && tickDO.getEu_used() == EuUseState.WY && tickDO.getEu_usescope() == EuUseScope.APT && tickDO.getFg_active().booleanValue()){
										handleTickList.add(tickDO);
									}
								}
							}
						}else{
							if(scSchDO.getD_sch().asBegin().compareTo(d_today) < 0){
								if(tickDO.getT_e().compareTo(new FTime("00:00:00")) >=0 && tickDO.getT_e().compareTo(corssDaysLot.getTime_end()) <= 0){
									FDateTime temp = new FDateTime(scSchDO.getD_sch().getDateAfter(1), tickDO.getT_e());
									if(temp.compareTo(now) < 0 && tickDO.getEu_used() == EuUseState.WY && tickDO.getEu_usescope() == EuUseScope.APT && tickDO.getFg_active().booleanValue()){
										handleTickList.add(tickDO);
									}
								}
							}else if(scSchDO.getD_sch().asBegin().compareTo(d_today) == 0){
								if(tickDO.getT_e().compareTo(now.getUFTime()) < 0 && tickDO.getEu_used() == EuUseState.WY && tickDO.getEu_usescope() == EuUseScope.APT && tickDO.getFg_active().booleanValue()){
									handleTickList.add(tickDO);
								}
							}
						}
						
					}else{
						if(tickDO.getT_e().compareTo(now.getUFTime()) < 0 && tickDO.getEu_used() == EuUseState.WY && tickDO.getEu_usescope() == EuUseScope.APT && tickDO.getFg_active().booleanValue()){
							handleTickList.add(tickDO);
						}
					}
					
					if(tickDO.getPolno() != null && tickDO.getEu_used() == EuUseState.WY && tickDO.getEu_usescope() == EuUseScope.APT && tickDO.getFg_active().booleanValue()){//设置渠道、开放 、 未用 
						if(polnoMap.containsKey(tickDO.getPolno())){
							polnoMap.put(tickDO.getPolno(), polnoMap.get(tickDO.getPolno())+1);
						}else{
							polnoMap.put(tickDO.getPolno(), 1);
						}
					}
				}
				if(ListUtil.isEmpty(handleTickList)) continue;
				
				// 4.2 跟新号位、号段、渠道使用数
				if (IScDictCodeConst.SD_TICKMD_TICK.equals(scSchDO.getSd_tickmd())) {// 号位模式
					// 号位模式数据更新
					this.handleTickAndSch(scSchDO,handleTickList,polnoMap,schEP);
				} else if (IScDictCodeConst.SD_TICKMD_TICKS.equals(scSchDO.getSd_tickmd())) {// 号段模式
					// 更新号位 和 排班
					this.handleTickAndSch(scSchDO, handleTickList, polnoMap, schEP);
					// 号段模式处理更新
					this.handleTicksAndTickAndSch(scSchDO, handleTickList, ticksEP);
				}
			}
		}
	}
	/**
	 * 获取排班和号位分组集合
	 * @param schDOs
	 * @param tickEP
	 * @return  
	 * @throws BizException
	 */
	private Map<String,List<ScSchTickDO>> getTick(List<ScSchDO> schDOs,TickEP tickEP) throws BizException{
		Map<String,List<ScSchTickDO>> tickMap = new HashMap<String,List<ScSchTickDO>>();//key:id_sch values:ScSchTickDO集合
		List<String> id_schs  = new ArrayList<String>();
		for (ScSchDO scSchDO : schDOs) {
			id_schs.add(scSchDO.getId_sch());
		}
		String where  = SqlUtils.getInSqlByIds(" id_sch", id_schs);
		ScSchTickDO[] tickDOs = tickEP.getTickByCond(where, "");
		for (ScSchTickDO scTickDO : tickDOs) {
			if(tickMap.containsKey(scTickDO.getId_sch())){
				List<ScSchTickDO> scTick = tickMap.get(scTickDO.getId_sch());
				scTick.add(scTickDO);
				tickMap.put(scTickDO.getId_sch(), scTick);
			}else{
				List<ScSchTickDO> scTick = new ArrayList<ScSchTickDO>();
				scTick.add(scTickDO);
				tickMap.put(scTickDO.getId_sch(), scTick);
			}
		}
		return tickMap;
	}
	/**
	 * 处理号位模式
	 * @param schDO ：排班DO
	 * @param handleTickList ：需处理号位集合
	 * @param polnoMap key:号源池号    value：剩余  可用的  设置了号源池的号位个数
	 * @param schEP
	 * @throws BizException
	 */
	public void handleTickAndSch(ScSchDO schDO, List<ScSchTickDO> handleTickList, Map<Integer, Integer> polnoMap, SchEP schEP)
			throws BizException {
		// 更新排班开放数、号源池
		List<ScSchTickDO> newTickList = new ArrayList<ScSchTickDO>();// 新号位集合
		ScSchDO newSchDO = (ScSchDO)schDO.clone();//复制新的排班
		for (ScSchTickDO tickDO : handleTickList) {
			newSchDO.setQuan_total_used(newSchDO.getQuan_total_used() + 1);// 排班使用数+1
			if (tickDO.getPolno() != null) {// 号位渠道不为空
				String usedName = "Quan" + tickDO.getPolno() + "_used";// 号源池i_已用
				int used = newSchDO.getAttrVal(usedName) == null ? 0 : (Integer) newSchDO.getAttrVal(usedName) + 1;
				newSchDO.setAttrVal(usedName, used);//更新排班号源池使用数
				if(polnoMap.containsKey(tickDO.getPolno())){
					Integer remainNum =  polnoMap.get(tickDO.getPolno()) >= 1 ? polnoMap.get(tickDO.getPolno()) - 1 : 0;
					polnoMap.put(tickDO.getPolno(), remainNum);
				}
			} else {// 号位渠道为null
				
				for (int i = 0; i <= 9; i++) {
					if (polnoMap.containsKey(i)) {
						String apptName = "Quan" + i + "_appt";
						String apptUsed = "Quan" + i + "_used";
						Integer remain  = (Integer) newSchDO.getAttrVal(apptName) - (Integer) newSchDO.getAttrVal(apptUsed) - polnoMap.get(i) ;//号源池剩余可减数
						if (remain > 0) {
							newSchDO.setAttrVal(apptUsed, (Integer) newSchDO.getAttrVal(apptUsed) + 1);
							tickDO.setPolno_used(i);
							break;
						}
					}else{
						String apptName = "Quan"+i+"_appt";
						String usedName =  "Quan"+i+"_used";
						if((Integer)newSchDO.getAttrVal(apptName) - (Integer)newSchDO.getAttrVal(usedName) >= 1){
							tickDO.setPolno_used(i);
							newSchDO.setAttrVal(usedName, (Integer) newSchDO.getAttrVal(usedName) + 1);
							break;
						}
					}
				}
			}
			tickDO.setStatus(DOStatus.UPDATED);
			tickDO.setEu_used(EuUseState.GQ);
			newTickList.add(tickDO);
		}
		// 更新排班
		newSchDO.setStatus(DOStatus.UPDATED);
		schEP.save(new ScSchDO[] { newSchDO });
		// 更新号位
		schEP.SaveSchTick(newTickList.toArray(new ScSchTickDO[0]));
	}
	/**
	 * 处理号段模式
	 * @throws BizException 
	 */
	public void handleTicksAndTickAndSch(ScSchDO schDO, List<ScSchTickDO> handleTickList, TicksEP ticksEP) throws BizException{
		
		// 处理号段 更新号段信息
		Map<String,Integer> tickMap = new HashMap<String,Integer>();// key:号段id value ：过期号位数
		List<ScSchTicksDO> newTicksList = new ArrayList<ScSchTicksDO>();
		for (ScSchTickDO tickDO : handleTickList) {
			if(tickMap.containsKey(tickDO.getId_ticks())){
				tickMap.put(tickDO.getId_ticks(), tickMap.get(tickDO.getId_ticks()) + 1);
			}else{
				tickMap.put(tickDO.getId_ticks(), 1);
			}
		}
		//IScticksRService tksRService = ServiceFinder.find(IScticksRService.class);
		//ScSchTicksDO[] ticksDOs = tksRService.findByIds(idTicks.toArray(new String[0]), FBoolean.FALSE);
		ScSchTicksDO[] ticksDOs = ticksEP.getTicksByCond("id_sch = '"+schDO.getId_sch()+"'", "");
		//ScSchTicksDO[] ticksDOs = tksRService.findByAttrValString(ScSchTicksDO.ID_SCH, schDO.getId_sch());
		if(!ArrayUtil.isEmpty(ticksDOs)){
			for (ScSchTicksDO ticksDO : ticksDOs) {
				if(tickMap.containsKey(ticksDO.getId_ticks())){
					ticksDO.setStatus(DOStatus.UPDATED);
					ticksDO.setQuecn_used(ticksDO.getQuecn_used() + tickMap.get(ticksDO.getId_ticks()));
					newTicksList.add(ticksDO);
				}
			}
			// 更新号段
			//schEP.SaveSchTicks(newTicksList.toArray(new ScSchTicksDO[0]));
			ticksEP.save(newTicksList.toArray(new ScSchTicksDO[0]));
		}
	}
	/**
	 * 获取当前需要设置过期的排班id
	 * @return
	 * @throws DAException 
	 */
	@SuppressWarnings("unchecked")
	public List<ScSchDO> getTimeChkSch(String id_dayslot,FDateTime now,FDate d_today,boolean isContainCross,String id_crossdayslot) throws DAException{
		DAFacade dafacade = new DAFacade();
		StringBuilder sql = new StringBuilder();
		SqlParam param = new SqlParam();
		sql.append(" select distinct sch.* from sc_sch sch");
		sql.append(" inner join sc_pl pl on pl.id_scpl  = sch.id_scpl ");
		sql.append(" inner join sc_tick tk on tk.id_sch = sch.id_sch");
		sql.append(" where sch.d_sch = ?");
		if(isContainCross){
			param.addParam(d_today.getDateBefore(1));
		}else{
			param.addParam(d_today);
		}
		sql.append(" and id_dayslot = ?");
		if(isContainCross){
			param.addParam(id_crossdayslot);
		}else{
			param.addParam(id_dayslot);
		}
		sql.append(" and pl.fg_timechk = 'Y' and pl.fg_active = 'Y'");
		sql.append(" and tk.eu_used = 0");
		sql.append(" and tk.eu_usescope = 1");
		sql.append(" and tk.fg_active = 'Y'");
		if(!isContainCross){
			sql.append(" and tk.t_e <= ?");
			param.addParam(now.getUFTime());
		}
		List<ScSchDO> scSchDOList = (List<ScSchDO>)dafacade.execQuery(sql.toString(), param, new  BeanListHandler(ScSchDO.class));
		return scSchDOList;
	}
	

	/**
	 * 获取急诊可用日期分组
	 * 
	 * @param dayslots
	 * @param isIncExpired
	 * @return
	 * @throws BizException 
	 */
	private DaysLotDO[] getAllowedDaysLots(String sctp,
			FBoolean isIncExpired) throws BizException {
		GetDaysLotDOBP bp = new GetDaysLotDOBP();
		DaysLotDO[] dayslots = bp.exec(sctp);
		if (ArrayUtil.isEmpty(dayslots))
			return null;
		int len = dayslots.length;
		LinkedList<DaysLotDO> list = new LinkedList<DaysLotDO>();
		FTime nowTime = ServiceFinder.find(TimeService.class).getUFDateTime().getUFTime();// 获取当前时间
		DaysLotDO preDayslot = null;
		for (int i = len - 1; i >= 0; i--) {
			DaysLotDO tempDayslot = dayslots[i];
			if (IScDictCodeConst.SD_SCTP_JZ.equals(sctp) || IScDictCodeConst.SD_SCTP_OP.equals(sctp)) {
				if (isCrossDays(tempDayslot)) {
					// 跨天日期分组
					if (nowTime.compareTo(tempDayslot.getTime_end()) <= 0) {
						list.clear();
						list.addFirst(tempDayslot);
						break;
					}
					list.addFirst(tempDayslot);
					preDayslot = tempDayslot;
					int compare = nowTime.compareTo(tempDayslot.getTime_begin());
					if (compare > 0)
						break;
					continue;
				}
			}
			int compare = compareDLWithNow(tempDayslot, nowTime);
			if (compare == 0 || compare == -1) {
				// 当前时间 在 日期分组工作时间中
				// 当前时间 在 日期分组工作时间之前
				list.addFirst(tempDayslot);
				preDayslot = tempDayslot;
				if (compare == 0)
					break;
				continue;
			}
			// 当前时间 在 日期分组工作时间之后，判断该日期分组是否可用
			if (FBoolean.TRUE.equals(isIncExpired)) {
				if (preDayslot != null) {
					DaysLotDO recentDayslot = getRecentlyDT(tempDayslot,
							preDayslot, nowTime);
					if (recentDayslot.equals(tempDayslot))
						list.addFirst(tempDayslot);
				} else
					list.addFirst(tempDayslot);
			}
			break;
		}
		return ListUtil.isEmpty(list) ? null : list.toArray(new DaysLotDO[0]);
	}
	/**
	 * 日期分组工作时间与当前时间比较 (不考虑跨天)
	 * 
	 * @param DLTime
	 *            日期分组
	 * @param now
	 *            当前时间
	 * @return <ul>
	 *         <li>当前时间 < 开始时间,返回 -1</li>
	 *         <li>当前时间 在 日期分组工作时间中,返回 0</li>
	 *         <li>当前时间 > 结束,返回 1</li>
	 *         </ul>
	 */
	private int compareDLWithNow(DaysLotDO DLTime, FTime now) {
		if (now.compareTo(DLTime.getTime_begin()) == -1) {
			return -1;
		} else if (now.compareTo(DLTime.getTime_end()) == 1) {
			return 1;
		} else {
			return 0;
		}
	}
	/**
	 * 是否是跨天日期分组
	 * 
	 * @param dayslot
	 * @return
	 */
	private boolean isCrossDays(DaysLotDO dayslot) {
		return dayslot.getTime_end().before(dayslot.getTime_begin());
	}
	/**
	 * 当时间处于两个时间分组之间时，取距离当前时间叫近的日期分组
	 * 
	 * @param minDL
	 *            较小的日期分组
	 * @param maxDL
	 *            较大的日期分组
	 * @param now
	 *            当前时间
	 * @return
	 * 
	 */
	private DaysLotDO getRecentlyDT(DaysLotDO minDL, DaysLotDO maxDL, FTime now) {
		long minDL2Now = now.getMillis() - minDL.getTime_end().getMillis();
		long now2MaxDL = maxDL.getTime_begin().getMillis() - now.getMillis();
		return minDL2Now < now2MaxDL ? minDL : maxDL;
	}
}
