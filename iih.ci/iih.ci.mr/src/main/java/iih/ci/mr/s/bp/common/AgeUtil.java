package iih.ci.mr.s.bp.common;

import java.util.Calendar;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;

public class AgeUtil {
	
	public static String getAge(FDate birth,FDateTime dt_acpt) {
		if (birth == null)
			return "不详";
		birth = birth.asBegin();

		FDate curDate = getAcptDate(dt_acpt);
		if ((curDate == null) || (birth.after(curDate))) {
			return "不详";
		}
	
		int months = curDate.getLocalMonth() - birth.getLocalMonth() + 12 * (curDate.getLocalYear() - birth.getLocalYear());
		FDate changeDate = getAfterMonths(birth, months);

		int totalMonth = (changeDate.after(curDate)) ? months - 1 : months;

		if ((changeDate.equals(curDate)) && (birth.getLocalDay() != curDate.getLocalDay())) {
			if (((birth.getLocalYear() % 4 == 0) && (birth.getLocalYear() % 100 != 0))
					|| ((birth.getLocalYear() % 400 == 0) && (birth.getLocalMonth() == 2)
							&& (birth.getLocalMonth() == birth.getLocalMonth()))) {
				totalMonth -= 1;
			}

			if (((curDate.getLocalYear() % 4 == 0) && (curDate.getLocalYear() % 100 != 0))
					|| ((curDate.getLocalYear() % 400 == 0) && (curDate.getLocalMonth() == 2)
							&& (curDate.getLocalMonth() > birth.getLocalMonth()))) {
				totalMonth -= 1;
			}

		}

		int fullYear = totalMonth / 12;

		int fullMonth = totalMonth % 12;

		changeDate = getAfterMonths(birth, totalMonth);
		int days = FDate.getDaysBetween(changeDate, curDate);

		if (fullYear >= 107)
			return "不祥";
		if ((fullYear >= 1) && (fullYear < 107))
			return String.format("%d岁", new Object[]{Integer.valueOf(fullYear)});
		if ((fullMonth >= 1) && (fullYear <= 1)) {
			if (days <= 0) {
				return String.format("%d月", new Object[]{Integer.valueOf(fullMonth)});
			}
			return String.format("%d月零%d天", new Object[]{Integer.valueOf(fullMonth), Integer.valueOf(days)});
		}
		if (days <= 0)
			return String.format("%d天", new Object[]{Integer.valueOf(1)});
		return String.format("%d天", new Object[]{Integer.valueOf(days)});
	}

	private static FDate getAfterMonths(FDate date, int months) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date.toDate());
		cal.add(2, months);
		return new FDate(cal.getTime());
	}

	private static FDate getAcptDate(FDateTime dt_acpt) {
		return dt_acpt.getDate().asBegin();
	}
}
