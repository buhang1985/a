package iih.sc.scp.s.bp;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.res.dayslot.d.DaysLotDO;
import iih.bd.res.dayslot.d.DayslotAggDO;
import iih.bd.res.dayslot.d.DayslotSecDO;
import iih.bd.res.dayslot.i.IDayslotMDORService;
import iih.bd.res.dayslot.i.IDayslotRService;
import iih.bd.res.dayslot.i.IDayslotSecDORService;
import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScAppUtils;
import iih.sc.scbd.scapptrule.d.ScapptruleDO;
import iih.sc.scbd.scapptrule.i.IScapptruleRService;
import iih.sc.scp.scplan.d.ScPlanDO;
import iih.sc.scp.scplan.i.IScplanRService;
import iih.sc.scp.scpltick.d.ScPlanWeekTickDO;
import iih.sc.scp.scpltick.i.IScpltickCudService;
import iih.sc.scp.scplticks.d.ScPlanWeekTicksDO;
import iih.sc.scp.scplticks.i.IScplticksCudService;
import iih.sc.scp.scplweek.d.ScPlanWeekDO;
import iih.sc.scp.scplweek.i.IScplweekMDOCudService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 保存或修改周计划
 * @author zhouliming
 *
 */
public class SavePlanWeekBP {
	/**
	 * 保存或修改周计划
	 * @param weekDO
	 * @param Sd_tickmd
	 * @throws BizException
	 * @throws ParseException 
	 */
	public void exec(ScPlanWeekDO[] weekDO, String Sd_tickmd)
			throws BizException{
		if(ArrayUtils.isEmpty(weekDO) || StringUtils.isBlank(Sd_tickmd)) return;
		//1、保存周计划
		IScplweekMDOCudService weekSrv = ServiceFinder.find(IScplweekMDOCudService.class);
		weekSrv.save(weekDO);
		//2、生成号位或号段
		List<ScPlanWeekTickDO> scPlTickList = new ArrayList<ScPlanWeekTickDO>();// 号位
		List<ScPlanWeekTicksDO> scPlTicksList = new ArrayList<ScPlanWeekTicksDO>();// 号段
		if(Sd_tickmd.equals(IScDictCodeConst.SD_TICKMD_TICK)) {//号位模式
			planToTick(weekDO[0], scPlTickList);
		}else if(Sd_tickmd.equals(IScDictCodeConst.SD_TICKMD_TICKS)){//号段模式
			planToTicks(weekDO[0], scPlTicksList);
		}
		
		String id_scplweek = weekDO[0].getId_scplweek();
		//3、保存号位
		IScpltickCudService ticksrv = ServiceFinder.find(IScpltickCudService.class);
		DelScPlWeekTickBP tickBP = new DelScPlWeekTickBP();
		ScPlanWeekTickDO[] tickDOs = scPlTickList.toArray(new ScPlanWeekTickDO[0]);
		if (scPlTickList.size() > 0) {
			tickBP.exec(id_scplweek);
			ticksrv.save(tickDOs);
		}
		//4、保存号段
		IScplticksCudService tickssrv = ServiceFinder.find(IScplticksCudService.class);
		DelScPlWeekTicksBP ticksBP = new DelScPlWeekTicksBP();
		ScPlanWeekTicksDO[] ticksDOs = scPlTicksList.toArray(new ScPlanWeekTicksDO[0]);
		if (scPlTicksList.size() > 0) {
			ticksBP.exec(id_scplweek);
			tickssrv.save(ticksDOs);
		}
	}
	/**
	 * 计算需要生成的号位数据
	 * @param spw
	 * @param tickList
	 * @throws BizException
	 * @throws ParseException 
	 */
	public void planToTick(ScPlanWeekDO spw, List tickList)
			throws BizException{
		if(spw == null) return;
		// 取出日期分组
		IDayslotRService daysloatSrv = ServiceFinder.find(IDayslotRService.class);
		DayslotAggDO dlotAgg = daysloatSrv.findById(spw.getId_dayslot());
		if(dlotAgg == null) return;
		DaysLotDO daysLotDO = dlotAgg.getParentDO();
		Calendar c = Calendar.getInstance();
		FTime b = daysLotDO.getTime_begin();
		FTime e = daysLotDO.getTime_end();
		SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
		Date start = null;
		Date end = null;
		try {
			start = df.parse(b.toStdString());
			end = df.parse(e.toStdString());
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		//如果结束时间小于开始时间，结束时间+24h
		if(end.toString().compareTo(start.toString()) < 0){
			end = ScAppUtils.addMinis(c, end, (int) 1440);
		}
		long between = (end.getTime() - start.getTime()) / 1000;// 除以1000是为了转换成秒
//		long minute1 = between / 60;
		// 平均一个多少秒
		long num = between / spw.getQuan_total();
		//获取预约计划的预约规则
		String id_scpl = spw.getId_scpl();//计划id
		IScplanRService scplanRService = ServiceFinder.find(IScplanRService.class);
		ScPlanDO ScPlanDO = scplanRService.findById(id_scpl);
		if(ScPlanDO == null){
			throw new  BizException(IScMsgConst.SC_SCP_SCPLAN_SCPLANNULL);//排班计划不存在！
		}
		String Id_apptru = ScPlanDO.getId_apptru();//预约id
		IScapptruleRService scapptruleRService = ServiceFinder.find(IScapptruleRService.class);//预约规则服务
		ScapptruleDO ScapptruleDO = scapptruleRService.findById(Id_apptru);
		if(ScapptruleDO == null){
			throw new  BizException(IScMsgConst.SC_SCP_SCPLAN_SCRULENULL);//预约规则不存在！
		}
		String sd_schrule = ScapptruleDO.getSd_schrule();//预约规则类型编码
		if (StringUtils.isBlank(sd_schrule)) {
			throw new  BizException(IScMsgConst.SC_SCP_SCPLAN_SCRULE_CODENULL);//未获取到预约规则编码，请检查数据数据是否完整！
		}
		if(ScPlanDO != null){
			Id_apptru = ScPlanDO.getId_apptru();
		}
		Integer quan_appt = spw.getQuan_total_appt();//可预约数
		int sumAppt = 0;
 		for (int i = 0; i < spw.getQuan_total(); i++) {
			ScPlanWeekTickDO tickDO = new ScPlanWeekTickDO();
			tickDO.setId_dayslotsec(daysLotDO.getId_dayslot());//日期分组id
			tickDO.setId_scplweek(spw.getId_scplweek());//周计划id
			tickDO.setName((i + 1) + "号");//名称
			tickDO.setQueno((i + 1));//票号
			tickDO.setT_b(new FTime(start));//开始时间
			
			//如果是最后一个号，结束时间设置为日期分组的结束时间
			if(i == spw.getQuan_total() - 1){
				tickDO.setT_e(e);//结束时间
			}else{
				start = ScAppUtils.addSecond(c, start, (int) num);
				tickDO.setT_e(new FTime(start));//结束时间
			}
			Integer code = i+1;//编号
			tickDO.setCode(code.toString());
			if(IScDictCodeConst.SCSCH_RULE_EVEN.equals(sd_schrule)){//偶数可预约
				if((i+1)%2 == 0 && sumAppt < quan_appt){
					tickDO.setEu_usescope(1);
					sumAppt++;
				}else{
					tickDO.setEu_usescope(2);
				}
			}else if(IScDictCodeConst.SCSCH_RULE_ODD.equals(sd_schrule)){//奇数可预约
				if((i+1)%2 != 0 && sumAppt < quan_appt){
					tickDO.setEu_usescope(1);
					sumAppt++;
				}else{
					tickDO.setEu_usescope(2);
				}
			}else{//全部可预约
				tickDO.setEu_usescope(0);
			}
			tickDO.setStatus(DOStatus.NEW);
			tickList.add(tickDO);
		}
 		
	}
	/**
	 * 计算需要生成的号段数据
	 * @param spw
	 * @param ticksList
	 * @throws BizException
	 * @throws ParseException 
	 */
	public void planToTicks(ScPlanWeekDO spw, List ticksList)
			throws BizException{ 
		
		if(spw == null) return;
		// 取出日期分组
		IDayslotMDORService lotService = ServiceFinder.find(IDayslotMDORService.class);
		IDayslotSecDORService secService = ServiceFinder.find(IDayslotSecDORService.class);
		DayslotSecDO[] secDO = secService.find("id_dayslot = '"+spw.getId_dayslot()+"'", "sortno", FBoolean.FALSE);
		DaysLotDO daysLotDO = lotService.findById(spw.getId_dayslot());
		
		if (secDO == null || secDO.length == 0 || daysLotDO == null) {
			throw new  BizException(IScMsgConst.SC_SCP_SCPLAN_DAYSLOTNULL);//"未获取到午别数据，请重新操作！"
		}
		
		SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
		Calendar c = Calendar.getInstance();//获取今天是星期几
		int total = spw.getQuan_total();// 总号数
		int totalAppt = spw.getQuan_total_appt();//总数可预约数
		int quecn = (int) Math.ceil((double)total/secDO.length);//平均每个号段票号张数(向上取整)
		int queAppt = (int) Math.ceil((double)totalAppt/secDO.length);//平均每个号段可预约数(向上取整)
		int num = 0;// 初始号位
		int sumAppt = 0; //已分配可预约数
		FTime startTime = daysLotDO.getTime_begin();
		//TODO 逻辑复杂，需优化
		for (int i = 0; i < secDO.length; i++) {
			ScPlanWeekTicksDO ticks = new ScPlanWeekTicksDO();
			ticks.setId_dayslotsec(secDO[i].getId_dayslotsec());//时段id
			ticks.setId_scplweek(spw.getId_scplweek());//周计划id
			ticks.setT_b(startTime);//开始时间
			try {
				startTime = new FTime(
						ScAppUtils.addMinis(c, df.parse(startTime.toStdString()), secDO[i].getPeriod()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			ticks.setT_e(startTime);//结束时间
			if(i != secDO.length){
				//票号总数==num
				if(num == total){
					ticks.setQueno_b(0);//开始票号
					ticks.setQueno_e(0);//结束票号
					ticks.setQuecn(0);//票号张数
				}else if(num + quecn > total){
					ticks.setQueno_b(num + 1);//开始票号
					ticks.setQueno_e(total);//结束票号
					ticks.setQuecn(total - num);//票号张数
					quecn = total - num;
					num = total;
				}else{
					ticks.setQueno_b(num + 1);//开始票号
					num = num + quecn;
					ticks.setQueno_e(num);//结束票号
					ticks.setQuecn(quecn);//票号张数
				}
				// 预约总数 == 可预约数
				if(ticks.getQuecn() == 0){
					ticks.setQuecn_appt(0);
				}else if(ticks.getQuecn() < queAppt && totalAppt >= sumAppt + queAppt){
					ticks.setQuecn_appt(ticks.getQuecn());//可预约数
					sumAppt += ticks.getQuecn();
				}else if(totalAppt < sumAppt + queAppt){
					ticks.setQuecn_appt(totalAppt - sumAppt);//可预约数
					sumAppt += totalAppt - sumAppt;
				}else{
					sumAppt += queAppt;
					ticks.setQuecn_appt(queAppt);//可预约数
				}
			}
			Integer code = i+1;//编号
			ticks.setCode(code.toString());
			ticks.setStatus(DOStatus.NEW);
			ticksList.add(ticks);
		}
		//若已分配可预约数<总数可预约数则循环分配到各个号段
		int i = 0;
		while(sumAppt < totalAppt){
			ScPlanWeekTicksDO ticksDO = (ScPlanWeekTicksDO) ticksList.get(i++);
			ticksDO.setQuecn_appt(ticksDO.getQuecn_appt() + 1);//设置可预约数
			sumAppt += 1;
		}
	}
	
}
