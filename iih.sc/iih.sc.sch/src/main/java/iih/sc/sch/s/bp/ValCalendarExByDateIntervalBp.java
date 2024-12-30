package iih.sc.sch.s.bp;

import org.apache.commons.lang.ArrayUtils;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.utils.ContextUtils;
import iih.sc.comm.IScMsgConst;
import iih.sc.scbd.scheduleca.d.ScheduleCADO;
import iih.sc.scbd.scheduleca.i.ISchedulecaRService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.workcalendar.d.WorkCalendarDO;
import xap.sys.xbd.workcalendar.d.desc.WorkCalendarDODesc;
import xap.sys.xbd.workcalendar.i.IWorkcalendarMDORService;


/**
 * 判断日历在对应的排班区间内是否存在
 * @author ccj
 *
 */
public class ValCalendarExByDateIntervalBp {
		
	/**判断日历在对应的排班区间内是否存在
	 * @param begin_date
	 * @param end_date
	 * @throws BizException
	 */
	public void exec(String begin_date,String end_date,String sd_sctp) throws BizException{
		ISchedulecaRService iSchedulecaRService = ServiceFinder.find(ISchedulecaRService.class);
		StringBuffer sqlQry = new StringBuffer();
		sqlQry.append(ScheduleCADO.SD_SCTP).append(" ='").append(sd_sctp).append("' and id_org='").append(ContextUtils.getOrgId()).append("'");
		ScheduleCADO[] cados = iSchedulecaRService.find(sqlQry.toString(), null, FBoolean.FALSE);
		if(ArrayUtil.isEmpty(cados)){
			throw new BizException("未获取到类型为"+sd_sctp+"的排班分类信息");
		}
		IWorkcalendarMDORService workcalendarMDORService = ServiceFinder.find(IWorkcalendarMDORService.class);
		StringBuffer sb = new StringBuffer(WorkCalendarDODesc.TABLE_ALIAS_NAME);
		sb.append(".id_workcalendar = '");
		sb.append(cados[0].getId_cal());
		sb.append("' and ");
		sb.append(WorkCalendarDODesc.TABLE_ALIAS_NAME);
		sb.append(".begindate <= '");
		sb.append(begin_date);
		sb.append("' and ");
		sb.append(WorkCalendarDODesc.TABLE_ALIAS_NAME);
		sb.append(".enddate >= '");
		sb.append(end_date);
		sb.append("'");
		WorkCalendarDO[] calendarDOs =  workcalendarMDORService.find(sb.toString(), "", FBoolean.TRUE);
		if(ArrayUtils.isEmpty(calendarDOs)) throw new BizException(IScMsgConst.SC_MT_SCH_NOT_CALENDAR); 
	}
}
