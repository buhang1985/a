package iih.bd.bs.holiday.s;

import iih.bd.bs.holiday.bp.HolidayBp;
import iih.bd.bs.holiday.d.HolidayDO;
import iih.bd.bs.holiday.i.IHolidayService;
import xap.mw.core.data.BizException;

public class HolidayServiceImpl implements IHolidayService {

	@Override
	public void copyToSave(HolidayDO[] holidayDOs) throws BizException {
		HolidayBp holidayBp = new HolidayBp();
		holidayBp.copyToSave(holidayDOs);
	}
}
