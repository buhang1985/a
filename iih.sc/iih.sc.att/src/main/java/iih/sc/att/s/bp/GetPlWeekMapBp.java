package iih.sc.att.s.bp;

import iih.sc.att.sctaskplweek.d.ScTaskPlWeekDO;

import java.util.HashMap;
import java.util.Map;

import xap.mw.core.data.BizException;

/**
 * 考勤周计划转化为Map
 * 
 * @author ccj
 * 
 */
public class GetPlWeekMapBp {
	/**
	 * 考勤周计划转化为Map
	 * 
	 * @param plWeekDOs
	 *            周计划arrays
	 * @return
	 * @throws BizException
	 */
	public Map<String, Map> exec(ScTaskPlWeekDO[] plWeekDOs) throws BizException {
		Map<String, Map> mainMap = new HashMap<String, Map>();
		for (ScTaskPlWeekDO plWeekDO : plWeekDOs) {
			String id_datelot = plWeekDO.getId_dateslot(); // 日期分组id
			Integer weekNo = plWeekDO.getWeekno(); // 星期数
			String eu_tasktp = Integer.toString(plWeekDO.getEu_tasktp()) + "," + plWeekDO.getId_taskplweek(); // 考勤分类,周计划编号
			
			if (mainMap.containsKey(id_datelot)) {
				Map map = mainMap.get(id_datelot);
				map.put(weekNo.toString(), eu_tasktp);
			} else {
				Map map = new HashMap();
				map.put(weekNo.toString(), eu_tasktp);
				mainMap.put(id_datelot, map);
			}
		}
		return mainMap;
	}
}
