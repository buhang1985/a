package iih.hr.hsc.i;

import iih.hr.hsc.dto.scheddto.d.SchedTableDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDate;

/**
 * 排班考勤保存服务
 * 
 * @author lijm
 *
 */
public interface IHrHscMaintainService {

	/**
	 * 保存排班表数据
	 * 
	 * @param schedTableDTO排班表
	 * @return
	 * @throws BizException
	 * @author lijm
	 */
	public SchedTableDTO saveWeekSched(SchedTableDTO schedTableDTO) throws BizException;

	/**
	 * 复制上一周排班
	 * 
	 * @param id_dep
	 * @param dt_monday
	 * @return
	 * @throws BizException
	 */
	public SchedTableDTO copyLastWeekSched(String id_dep, FDate dt_monday) throws BizException;
}
