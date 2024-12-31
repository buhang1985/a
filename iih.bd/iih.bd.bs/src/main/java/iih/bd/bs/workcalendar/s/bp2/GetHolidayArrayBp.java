package iih.bd.bs.workcalendar.s.bp2;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bs.holiday.d.HolidayDO;
import xap.mw.coreitf.d.FDate;

/**
 * 获取假日列表
 * 
 * @author hao_wu 2020-2-3
 *
 */
public class GetHolidayArrayBp {

	public FDate[] exec(HolidayDO[] holidays) {

		if (!validation(holidays)) {
			return null;
		}

		FDate[] rtn = getHoliday(holidays);

		return rtn;
	}

	/**
	 * 校验
	 * 
	 * @param holidays
	 * @return
	 */
	private boolean validation(HolidayDO[] holidays) {

		if (holidays == null || holidays.length < 1) {
			return false;
		}

		return true;
	}

	/**
	 * 获取定义中的全部假日
	 * 
	 * @param holidays
	 * @return
	 */
	private FDate[] getHoliday(HolidayDO[] holidays) {

		List<FDate> reList = new ArrayList<FDate>();

		for (HolidayDO holiday : holidays) {

			List<FDate> list = getArrayByRange(holiday);

			reList.addAll(list);
		}

		return reList.toArray(new FDate[reList.size()]);
	}

	/**
	 * 获取区间集合
	 * 
	 * @param holiday
	 * @return
	 */
	private List<FDate> getArrayByRange(HolidayDO holiday) {

		List<FDate> reList = new ArrayList<FDate>();

		for (int i = 0; i <= holiday.getEndtime().getDaysAfter(holiday.getStarttime()); i++) {

			FDate date = holiday.getStarttime().getDateAfter(i);

			FDate changeDate = getChangeData(holiday, date);

			if (changeDate == null) {

				reList.add(date);

			} else {

				reList.add(changeDate);
			}
		}

		return reList;
	}

	/**
	 * 获取指定日期的对调日期
	 * 
	 * @param holiday
	 * @param date
	 * @return
	 */
	private FDate getChangeData(HolidayDO holiday, FDate date) {

		for (int i = 1; i <= 8; i++) {

			Object obj = holiday.getAttrVal("Switch" + i);
			Object objTo = holiday.getAttrVal("Switch" + i + "to");

			if (obj != null && objTo != null) {

				FDate chengeDate = (FDate) obj;
				if (chengeDate.compareTo(date) == 0) {

					return (FDate) objTo;
				}
			}
		}
		return null;
	}
}
