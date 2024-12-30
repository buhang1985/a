package iih.sc.scp.s.bp;

import iih.sc.scp.scplweek.d.ScplweekAggDO;
import iih.sc.scp.scplweek.i.IScplweekRService;

import org.apache.commons.lang3.ArrayUtils;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 根据条件查询周计划
 * @author zhouliming
 *
 */
public class GetScPlWeekDOBp {

	/**
	 * 根据条件查询周计划
	 * @param id_scpl 计划id
	 * @param weekNo   星期数
	 * @param idx_week  周数
	 * @param id_dayslot 午别
	 * @param currentWeekScplId  当前选中的周计划排除
	 * @throws BizException 
	 */
	public ScplweekAggDO[] exec(String id_scpl,String value_no, Integer idx_week,String id_dayslot,String currentWeekScplId) throws BizException{
		String[] value_num = value_no.split(",");
		StringBuffer week = new StringBuffer();
		week.append("(");
		for(String str:value_num){
			week.append("'"+str+"',");
		}
		String weekNew = week.substring(0,week.length()-1);
		weekNew = weekNew+")";
		
		IScplweekRService service = ServiceFinder.find(IScplweekRService.class);
		ScplweekAggDO[] weekAggDOs = service.find("id_scpl = '"+id_scpl+"' and weekno in "+weekNew+" and idx_week = '"+idx_week+"' and id_dayslot = '"+id_dayslot+"' and id_scplweek != '"+currentWeekScplId+"'  ", "", FBoolean.TRUE);
		if(ArrayUtils.isEmpty(weekAggDOs)) return null;
		return weekAggDOs;
	}
}
