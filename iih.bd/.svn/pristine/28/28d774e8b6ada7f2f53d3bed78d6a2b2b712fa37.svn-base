package iih.bd.res.dayslot.s.bp;

import iih.bd.res.dayslot.d.DaysLotDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FTime;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 获取午别开始时间BP
 * @author yank
 *
 */
public class GetDayslotStartTimeBP {
	/**
	 * 获取午别开始时间
	 * @param dayslotId 日期分组ID
	 * @return
	 * @throws BizException
	 */
	public FTime exec(String dayslotId) throws BizException{
		DaysLotDO dayslotDO = (DaysLotDO) new DAFacade().findByPK(DaysLotDO.class, 
				dayslotId, new String[]{DaysLotDO.ID_DAYSLOT, DaysLotDO.TIME_BEGIN});
		if(dayslotDO==null){
			throw new BizException("日期分组不存在！");
		}
		return dayslotDO.getTime_begin();
	}
}
