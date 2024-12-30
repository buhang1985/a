package iih.sc.sch.s.bp;

import iih.sc.comm.ScValidator;
import iih.sc.scbd.scheduleca.d.ScheduleCADO;
import iih.sc.scbd.scheduleca.i.ISchedulecaRService;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.workcalendar.d.DateTypeForWorkEnum;
import xap.sys.xbd.workcalendar.d.WorkCalendarDO;
import xap.sys.xbd.workcalendar.i.IWorkcalendarMDORService;

/**
 * 根据类型求对应日历的节点日在对应的日期区间内
 * @author renying
 *
 */
public class GetHolidayArrayByScTpBp {
	
	/**
	 * 根据类型求对应日历的节点日在对应的日期区间内
	 * @param sctp  排班类型
	 * @param begin_date	开始日期
	 * @param end_date	结束日期
	 * @return	节假日arrays
	 * @throws BizException
	 */
	public String[] exec(String sctp,String begin_date,String end_date) throws BizException{
		ScValidator.validateParam("排班分类", sctp);
		ScValidator.validateParam("开始日期", begin_date);
		ScValidator.validateParam("结束日期", end_date);
		
		ScheduleCADO cado = this.getScca(sctp);			
		WorkCalendarDO calendarDO = this.getCalendar(cado,begin_date, end_date);	
		List<String> list =this.getCalendarDate(begin_date, end_date,cado.getId_cal());
		return list.toArray(new String[list.size()]);
	}
	/**
	 * 根据排班分类获取日历
	 * @param cado
	 * @param begin_date
	 * @param end_date
	 * @return
	 * @throws BizException
	 */
	private WorkCalendarDO getCalendar(ScheduleCADO cado,String begin_date,String end_date) throws BizException{
		IWorkcalendarMDORService service  = ServiceFinder.find(IWorkcalendarMDORService.class);
		WorkCalendarDO calendarDO = service.findById(cado.getId_cal()) ;
		if(calendarDO == null){
			throw new BizException("未查到"+cado.getId_cal_name()+"对应的日历,请先维护日历");
		}

		if(new FDate(begin_date).beforeDate(calendarDO.getBegindate())|| new  FDate(end_date).afterDate(calendarDO.getEnddate())){
			throw new BizException("请先维护"+begin_date +"到"+end_date+"时间段内的"+cado.getId_cal_name()+"日历");
		}
		if(calendarDO.getActivestate() != 2){
			throw new BizException("该日历已被停用");
		}
		return calendarDO;
	}
	/**
	 * 获取排班分类
	 * @param sctp
	 * @return
	 * @throws BizException
	 */
	private  ScheduleCADO getScca(String sctp) throws BizException{
		ISchedulecaRService service = ServiceFinder.find(ISchedulecaRService.class);
		ScheduleCADO[] cados =	service.find("sd_sctp ='"+sctp+"'", "", FBoolean.FALSE);
		if(ArrayUtil.isEmpty(cados)){
			throw new BizException("请先维护排班分类！");			
		}
		if(StringUtil.isEmpty(cados[0].getId_cal())){
			throw new BizException(" 请先维护排班分类的日历分类 ");
		}
		return cados[0];
	}
	
	/**
	 * 获取日历对应的假期日历
	 * @param begin_date
	 * @param end_date
	 * @param caId
	 * @return
	 * @throws DAException
	 */
	public List<String>  getCalendarDate(String begin_date,String end_date,String caId) throws DAException{
		StringBuffer buffer = new StringBuffer();
		SqlParam param = new SqlParam();
		buffer.append(" select dardate.calendardate");
		buffer.append(" from bd_workcalenddate dardate");
		buffer.append("    where  dardate.id_workcalendar =?");
		buffer.append("  and dardate.dateworktype = ?");
		buffer.append("   and dardate.calendardate >= ?");
		buffer.append("   and dardate.calendardate <= ?");		
		
		param.addParam(caId);
	    param.addParam(DateTypeForWorkEnum.HOLIDAY);
		param.addParam(begin_date);
		param.addParam(end_date);
		@SuppressWarnings("unchecked")
		List<String> list = (List<String>) new DAFacade().execQuery(buffer.toString(), param, new ColumnListHandler());
		return list;
	}
	
	
}
