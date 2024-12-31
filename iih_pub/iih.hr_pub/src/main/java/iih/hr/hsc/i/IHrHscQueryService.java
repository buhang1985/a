package iih.hr.hsc.i;

import iih.hr.hsc.dto.scheddto.d.SchedTableDTO;
import iih.hr.hsc.hscpsnlv.d.HscPsnLvDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDate;

/**
 * 排班考勤查询服务
 * 
 * @author lijm
 *
 */
public interface IHrHscQueryService {

	/**
	 * 获取排班信息
	 * @param id_dep 科室
	 * @param dt_monday 周一日期
	 * @return
	 * @throws BizException
	 */
	public abstract SchedTableDTO findWeekSched(String id_dep,FDate dt_monday) throws BizException;

	/**
	 * 人员请假管理
	 * @return
	 * @throws BizException
	 */
	public abstract HscPsnLvDO[] findYearMonthGroup() throws BizException;
}
