package iih.sc.apt.s.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.res.dayslot.d.DaysLotDO;
import iih.bd.res.dayslot.i.IDayslotMDORService;
import iih.sc.apt.dto.d.MtAppDTO;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.apt.scapt.i.IScaptMDOCudService;
import iih.sc.apt.scapt.i.IScaptMDORService;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.scsch.i.IScschMDORService;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.sch.sctick.i.ISctickCudService;
import iih.sc.sch.sctick.i.ISctickRService;
import iih.sc.scp.scplan.d.ScPlanDO;
import iih.sc.scp.scplan.i.IScplanRService;
import iih.sc.scp.scplweek.d.ScPlanWeekDO;
import iih.sc.scp.scplweek.i.IScplweekMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.SqlParamDTO;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class SaveApplTimeBP {

	/**
	 * 修改手术计划时间
	 * 
	 * @param dtos
	 * @param id_apt
	 * @throws BizException
	 */
	public String exec(MtAppDTO mtAppDTO, String type) throws BizException {

		this.ValidSch(mtAppDTO);
		ISctickRService tickRService = ServiceFinder.find(ISctickRService.class);
		String ftime = this.FDateTimeToFTime(mtAppDTO.getDt_plan());
		FTime time = new FTime(ftime);
		List<ScSchTickDO> tickList = new ArrayList<ScSchTickDO>();
		List<ScAptDO> aptList = new ArrayList<ScAptDO>();
		// 查询排班下所有号位
		String whereStr = " id_sch = ? ";
		SqlParamDTO param = new SqlParamDTO();
		param.addParam(mtAppDTO.getId_sch());
		ScSchTickDO[] tickDOs = tickRService.find2(whereStr, param, ScSchTickDO.QUENO, FBoolean.FALSE);
		IScaptMDORService aptRService = ServiceFinder.find(IScaptMDORService.class);
		ScAptDO[] aptDOs = aptRService.find(String.format(" id_sch = '%s' and fg_canc = 'N' ", mtAppDTO.getId_sch()), "queno",
				FBoolean.FALSE);
		// 查询排班下的所有预约信息
		Map<String, ScAptDO> map = new HashMap<String, ScAptDO>();
		if ("single".equals(type)) // 单个预约调整
		{
			String id_tick = "";
			// 修改的预约赋值
			for (ScSchTickDO tickDO : tickDOs) {
				if (tickDO.getQueno().equals(mtAppDTO.getQueno())) {
					tickDO.setT_b(time);
					id_tick = tickDO.getId_tick();
				}
				for (ScAptDO aptDO : aptDOs) {
					if (aptDO.getQueno().equals(tickDO.getQueno())) {
						map.put(tickDO.getId_tick(), aptDO);
						break;
					}
				}
			}
		} 
		else if ("all".equals(type))// 全部预约调整
		{
			int timeComapre = 0;//时间差
			// 修改的排班 的开始时间 存储预约信息key=id_tick
			for (ScSchTickDO tickDO : tickDOs) 
			{
				for (ScAptDO aptDO : aptDOs) 
				{
					if (aptDO.getQueno().equals(tickDO.getQueno())) 
					{
						//当前票号之后的预约时间按时间差顺延
						if (aptDO.getQueno() >= mtAppDTO.getQueno()) 
						{
							if (mtAppDTO.getId_apt().equals(aptDO.getId_apt())) 
							{
								// 计算时间差    永远是第一个进来
								FDateTime oldDateTime = aptDO.getDt_b();
								FDateTime newDateTime = new FDateTime(oldDateTime.getBeginDate(), time);
								timeComapre = FDateTime.getSecondsBetween(oldDateTime,newDateTime);
								tickDO.setT_b(time);
								map.put(tickDO.getId_tick(), aptDO);
							} 
							else 
							{
								FDateTime newDateTime = aptDO.getDt_b().addSeconds(timeComapre);
								if(newDateTime.getBeginDate().compareTo(mtAppDTO.getDt_plan().getBeginDate()) > 0)
								{
									throw new BizException("预约时间已到第二天!,请重新输入");
								}
								tickDO.setT_b(new FTime(newDateTime.getTime()));
								map.put(tickDO.getId_tick(), aptDO);
							}
						}
						else 
						{
							map.put(tickDO.getId_tick(), aptDO);
							
						}
						break;
					}
				}
			}
		} 
		else 
		{
			throw new BizException("预约时间修改类型不正确!!!!!");
		}
		ScSchDO sch = ServiceFinder.find(IScschMDORService.class).findById(mtAppDTO.getId_sch());
		// 冒泡排序
		tickDOs = this.OrderByDt_b(tickDOs,sch);
		// 重新排序
		for (int i = 0; i < tickDOs.length; i++) {
			ScSchTickDO tickDO = tickDOs[i];
			tickDO.setStatus(DOStatus.UPDATED);
			tickDO.setEu_used(0);// 可用
			if (map.containsKey(tickDO.getId_tick())) {
				ScAptDO aptDO = map.get(tickDO.getId_tick());
				aptDO.setQueno(i + 1);
				aptDO.setDt_b(new FDateTime(mtAppDTO.getDt_plan().getBeginDate(), tickDO.getT_b()));
				aptList.add(aptDO);
				tickDO.setEu_used(1);// 不可用
			}
			tickDO.setQueno(i + 1);
			tickList.add(tickDO);
		}
		
		// 保存预约信息 更新queno dt_B
		IScaptMDOCudService aptCmdService = ServiceFinder.find(IScaptMDOCudService.class);
		aptCmdService.update(aptList.toArray(new ScAptDO[0]));
		
		// 保存号位信息 更新queno d_b
		ISctickCudService tickCudService = ServiceFinder.find(ISctickCudService.class);
		tickCudService.save(tickList.toArray(new ScSchTickDO[0]));
		
		//预约 修改后为发事件拼接预约id串
		return new SendChangeOptApt4OrBP().buildIdStr(aptList);
	}

	/**
	 * 冒泡算法
	 * 
	 * @param tickDOs
	 * @return
	 */
	public ScSchTickDO[] OrderByDt_b(ScSchTickDO[] tickDOs,ScSchDO sch) {
		FTime time_begin = sch.getT_b_acpt();
		time_begin.getHour();
		List<ScSchTickDO> outSort = new ArrayList<ScSchTickDO>();
		List<ScSchTickDO> sort = new ArrayList<ScSchTickDO>();
		for (int i = 0; i < tickDOs.length - 1; i++) {
			if (tickDOs[i].getT_b().compareTo(time_begin)<0) {
				outSort.add(tickDOs[i]);
			}else{
				sort.add(tickDOs[i]);
			}
		}
		ScSchTickDO[] sortArr = sort.toArray(new ScSchTickDO[0]);
		ScSchTickDO[] outSortArr = outSort.toArray(new ScSchTickDO[0]);
		
		// 标记最后一次交换的位置
		for (int i = 0; i < sortArr.length - 1; i++) {
			int flag = 0;
			ScSchTickDO temp;
			for (int j = 0; j < sortArr.length - i - 1; j++) {
				if (sortArr[j].getT_b().compareTo(sortArr[j + 1].getT_b()) > 0) {
					temp = sortArr[j];
					sortArr[j] = sortArr[j + 1];
					sortArr[j + 1] = temp;
					// 当位置发生改变，flag的值就发生变化
					flag = 1;
				}
			}
			// 判断标志位flag有没有发生变化，没有就直接结束内层循环
			if (flag == 0) {
				break;
			}
		}
		// 标记最后一次交换的位置
		for (int i = 0; i < outSortArr.length - 1; i++) {
			int flag = 0;
			ScSchTickDO temp;
			for (int j = 0; j < outSortArr.length - i - 1; j++) {
				if (outSortArr[j].getT_b().compareTo(outSortArr[j + 1].getT_b()) > 0) {
					temp = outSortArr[j];
					outSortArr[j] = outSortArr[j + 1];
					outSortArr[j + 1] = temp;
					// 当位置发生改变，flag的值就发生变化
					flag = 1;
				}
			}
			// 判断标志位flag有没有发生变化，没有就直接结束内层循环
			if (flag == 0) {
				break;
			}
		}
		List<ScSchTickDO> result = new ArrayList<ScSchTickDO>();
		for (int i = 0; i < sortArr.length; i++) {
			result.add(sortArr[i]);
		}
		for (int i = 0; i < outSortArr.length; i++) {
			result.add(outSortArr[i]);
		}
		return result.toArray(new ScSchTickDO[0]);
	}

	/**
	 * 数据有效性校验 是否能修改
	 * 
	 * @param mtAppDTO
	 * @throws BizException
	 */
	private void ValidSch(MtAppDTO mtAppDTO) throws BizException {
		StringBuilder sql = new StringBuilder();
		sql.append("select count(1) from sc_apt apt where apt.id_sch = ? and apt.sd_status = '3' and apt.dt_b > ? ");
		SqlParam params = new SqlParam();
		params.addParam(mtAppDTO.getId_sch());
		params.addParam(mtAppDTO.getDt_plan());
		int count = (int) new DAFacade().execQuery(sql.toString(), params, new ColumnHandler());
		if (count > 0) {
			throw new BizException(mtAppDTO.getDt_plan() + "之后存在已完成预约,请重新修改时间!");
		}
	}

	private String FDateTimeToFDate(FDateTime dateTime) {
		int year = dateTime.getYear();
		int month = dateTime.getMonth();
		int day = dateTime.getDay();
		String date = year + "-";
		if (month < 10) {
			date += "0" + month + "-";
		} else {
			date += month + "-";
		}
		if (day < 10) {
			date += "0" + day;
		} else {
			date += day;
		}
		return date;
	}

	private String FDateTimeToFTime(FDateTime dateTime) {
		int hour = dateTime.getHour();
		int min = dateTime.getMinute();
		int sen = dateTime.getSecond();
		String ftime = "";
		if (hour < 10) {
			ftime = "0" + hour + ":";
		} else {
			ftime = hour + ":";
		}
		if (min < 10) {
			ftime += "0" + min + ":";
		} else {
			ftime += min + ":";
		}
		if (sen < 10) {
			ftime += "0" + sen;
		} else {
			ftime += sen;
		}
		return ftime;
	}

}
