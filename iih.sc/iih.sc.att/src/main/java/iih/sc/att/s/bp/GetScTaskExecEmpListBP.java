package iih.sc.att.s.bp;

import iih.sc.att.sctaskexecemp.d.ScTaskExecEmpDO;
import iih.sc.att.sctaskplweek.d.ScTaskPlWeekDO;
import iih.sc.comm.ScContextUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FDate;

/**
 * 获取个人考勤执行明细list
 * 
 * @author ccj
 * 
 */
public class GetScTaskExecEmpListBP {

	/**
	 * 获取个人考勤执行明细list
	 * 
	 * @param plWeekDOs
	 *            周计划arrays
	 * @param xdaysStrs
	 *            相隔天数
	 * @param id_emp
	 *            人员id
	 * @param id_taskplemp
	 *            计划人员id
	 * @param id_taskexec
	 *            考勤执行id
	 * @return
	 * @throws BizException
	 */
	public List<ScTaskExecEmpDO> exec(ScTaskPlWeekDO[] plWeekDOs, String[] xdaysStrs, String id_emp, String id_taskplemp, String id_taskexec) throws BizException {
		// 主数据，以午别、计划考勤为key值,得到该计划的所有计划排班信息
		GetPlWeekMapBp getPlWeekMapBp = new GetPlWeekMapBp();
		Map<String, Map> mainMap = getPlWeekMapBp.exec(plWeekDOs);
		List<ScTaskExecEmpDO> execEmpDOList = new ArrayList<ScTaskExecEmpDO>();
		for (String dateStr : xdaysStrs) {
			for (String key : mainMap.keySet()) {
				Map<String, String> weekMainMap = mainMap.get(key);
				Integer monthToWeek = new FDate(dateStr).getDayOfWeek();
				if(monthToWeek == 1)
					monthToWeek =7;
				else{
					monthToWeek = --monthToWeek;
				}
				if (weekMainMap.containsKey(monthToWeek.toString())) {
					ScTaskExecEmpDO execEmpDo = new ScTaskExecEmpDO();
					execEmpDo.setId_emp(id_emp); // 考勤人员ID
					execEmpDo.setId_group(ScContextUtils.getGrpId());//当前集团
					execEmpDo.setId_org(ScContextUtils.getOrgId());//当前组织
					
					// 个人新增排班没有计划人员
					execEmpDo.setId_taskplemp(id_taskplemp); // 考勤计划人员ID
					execEmpDo.setId_taskexec(id_taskexec); // 考勤执行ID
					execEmpDo.setD_task(new FDate(dateStr)); // 考勤日期
					execEmpDo.setId_dateslot(key); // 日期分组（午别）
					execEmpDo.setStatus(DOStatus.NEW);
					// 考勤分类,周计划编号
					String[] str = weekMainMap.get(monthToWeek.toString()).split(",");
					execEmpDo.setEu_tasktp_pl(Integer.parseInt(str[0]));// 考勤分类
					execEmpDo.setId_taskplweek(str[1]);//周计划编号
					execEmpDOList.add(execEmpDo);
				}
			}
		}
		return execEmpDOList;
	}
}
