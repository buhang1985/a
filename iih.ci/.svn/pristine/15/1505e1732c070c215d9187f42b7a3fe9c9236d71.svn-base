package iih.ci.mr.cmis.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import iih.ci.mr.cmis.s.CMISSendServiceImpl;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDate;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.orgfw.dept.d.DeptDO;

/**
 * 今创病案定时发送任务-门诊、住院工作量发送
 * @author YanSu
 */
public class WorkloadDelayedSendingTask implements IBackgroundWorkPlugin {

	public PreAlertObject executeTask(BgWorkingContext bgContext) throws BizException {
		Map<String, Object> map = bgContext.getKeyMap();
		String bizStr = (String)map.get("day");
		// 
		getWorkloadFromEnService(bizStr);
		return null;
	}
	/**
	 * 查询科室，并发送工作量
	 * @throws BizException
	 */
	private void getWorkloadFromEnService(String bizStr) throws BizException {
		CMISSendServiceImpl _service = new CMISSendServiceImpl();
		//List<DeptDO> depList = getDepDataList();
		// 获取当前日期的毫秒值
		FDate nowTime = new FDate();
		long nowMillis = nowTime.getMillis();
		int day = 1;
		
		if (bizStr != null && !"".equals(bizStr)) {
			day = Integer.parseInt(bizStr);
		}
		// 计算一天的毫秒值
		long dayMillils = day*24*60*60*1000;
		FDate date = FDate.getDate(nowMillis - dayMillils);
		// 发送工作量
		_service.sendWorkload(date, date);
		
		/*for (DeptDO deptDO : depList) {
			String id_dep = deptDO.getId_dep();
			String sd_depttp = deptDO.getSd_depttp();
			// 发送工作量
			_service.sendWorkload(sd_depttp, id_dep, date, date);
		}*/
	}
	/**
	 * @return 临床类别科室集合
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private List<DeptDO> getDepDataList() throws BizException {
		StringBuilder sb = new StringBuilder();
		sb.append(" select bd_dep.id_dep as id_dep, ");
		sb.append(" bd_dep.code as code, ");
		sb.append(" bd_dep.name as name, ");
		sb.append(" bd_dep.id_depttp as id_depttp, ");
		sb.append(" bd_dep.sd_depttp as sd_depttp ");
		sb.append(" from bd_dep bd_dep ");
		sb.append(" where bd_dep.sd_depttp = '01' ");
		
		DAFacade da = new DAFacade();
		ArrayList<DeptDO> result = (ArrayList<DeptDO>) da.execQuery(sb.toString(),
				new BeanListHandler(DeptDO.class));
		return result;
	}
	
}
