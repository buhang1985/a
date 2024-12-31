package iih.bd.bs.holiday.bp;

import iih.bd.bs.holiday.d.HolidayDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;

public class HolidayBp {

	/**
	 * 将复制来的数据存入数据库
	 * @param holidayDOs
	 * @throws DAException
	 */
	public void copyToSave(HolidayDO[] holidayDOs) throws BizException {
		for (HolidayDO holidayDO : holidayDOs) {
			holidayDO.setStarttime(new FDate(holidayDO.getStarttime().toString()
					.replaceFirst(holidayDO.getStarttime().getYear() + "", holidayDO.getHolidayyear())));
			holidayDO.setEndtime(new FDate(holidayDO.getEndtime().toString()
					.replaceFirst(holidayDO.getEndtime().getYear() + "", holidayDO.getHolidayyear())));
			holidayDO.setSwitch1(null);
			holidayDO.setSwitch2(null);
			holidayDO.setSwitch3(null);
			holidayDO.setSwitch4(null);
			holidayDO.setSwitch5(null);
			holidayDO.setSwitch6(null);
			holidayDO.setSwitch7(null);
			holidayDO.setSwitch8(null);
			holidayDO.setSwitch1to(null);
			holidayDO.setSwitch2to(null);
			holidayDO.setSwitch3to(null);
			holidayDO.setSwitch4to(null);
			holidayDO.setSwitch5to(null);
			holidayDO.setSwitch6to(null);
			holidayDO.setSwitch7to(null);
			holidayDO.setSwitch8to(null);
			holidayDO.setCreatedby(Context.get().getUserId());
			holidayDO.setCreatedtime(new FDateTime());
			holidayDO.setModifiedby(null);
			holidayDO.setModifiedtime(null);
			holidayDO.setSv(new FDateTime());
		}
		new DAFacade().insertDOs(holidayDOs);
		
	}
	

}
