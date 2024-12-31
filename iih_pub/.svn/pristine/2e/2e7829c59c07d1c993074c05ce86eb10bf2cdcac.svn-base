package iih.bd.bs.workcalendar.i;

import iih.bd.bs.workcalendar.d.WorkCalendarDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.xbd.dto.d.WorkCalendarDataDTO;
import java.text.ParseException;

/**
 * 工作日历日期信息扩展服务
 * @author guoyang wangyuchun
 *
 */
public interface IWorkcalendarExtService {

	/**
	 * 获取工作日历的开始日期+工作日小时数后结束结束日期时间
	 * @param begin 开始时间
	 * @param workdayhours 小时数
	 * @param workCalendarid 工作日历主键
	 * @return
	 * @throws BizException 
	 */
	public FDateTime getEndDateTime(FDateTime begin, int workdayhours, String workCalendarid) throws BizException;

	/**
	 * 组装日历数据
	 * @param calDO
	 * @param pageNumber
	 * @return
	 * @throws BizException
	 * @throws ParseException 
	 */
    public abstract WorkCalendarDataDTO getetWorkCalendarData(WorkCalendarDO calDO,int pageNumber) throws BizException,ParseException;
    
    /**
     * 生成工作日历明细
     * @param calendarDo
     * @return
     * @throws BizException
     */
    public abstract WorkCalendarDO detailSave(WorkCalendarDO calendarDo) throws BizException;
    
    /**
     * 新增工作日历保存
     * @param calendarDo
     * @return
     * @throws BizException
     */
    public abstract WorkCalendarDO addSave(WorkCalendarDO calendarDo) throws BizException;

}
