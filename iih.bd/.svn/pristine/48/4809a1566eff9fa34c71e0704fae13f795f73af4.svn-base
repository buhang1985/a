package iih.bd.bs.workcalendar.s.bp2;

import iih.bd.base.utils.ArrayListUtil;
import iih.bd.bs.workcalendar.d.WorkCalendDateDO;
import iih.bd.bs.workcalendar.d.WorkCalendarDO;
import iih.bd.bs.workcalendar.i.IWorkCalendDateDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.SqlParamDTO;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;

public class FindWorkCalendarDatePagingDataBp {

	public PagingRtnData<WorkCalendDateDO> exec(PaginationInfo pageInfo, WorkCalendarDO workCalendarDo)
			throws BizException {

		int monthCount = getMonthBetween(workCalendarDo.getBegindate(), workCalendarDo.getEnddate());
		int pageCount = (monthCount / pageInfo.getPageSize()) + ((monthCount % pageInfo.getPageSize()) > 0 ? 1 : 0);

		if (pageInfo.getPageIndex() < 0) {
			pageInfo.setPageIndex(0);
		}
		if (pageInfo.getPageIndex() >= pageCount) {
			pageInfo.setPageIndex(pageCount - 1);
		}
		FDate firstDate = (FDate) workCalendarDo.getBegindate().clone();
		firstDate = firstDate.getDateBefore(firstDate.getDay() - 1);

		FDate beginDate = this.getDateAfterMonth(firstDate, pageInfo.getPageIndex() * pageInfo.getPageSize());
		FDate endDate = this.getDateAfterMonth(firstDate, (pageInfo.getPageIndex() + 1) * pageInfo.getPageSize())
				.getDateBefore(1);

		PagingRtnData<WorkCalendDateDO> pagingRtnData = new PagingRtnData<>();
		pagingRtnData.setPagingInfo(pageInfo);
		pageInfo.setPageCount(pageCount);

		String whereStr = "Id_workcalendar = ? and Calendardate between ? and ?";
		SqlParamDTO sqlParamDTO = new SqlParamDTO();
		sqlParamDTO.addParam(workCalendarDo.getId_workcalendar());
		sqlParamDTO.addParam(beginDate);
		sqlParamDTO.addParam(endDate);

		IWorkCalendDateDORService workCalendDateDORService = ServiceFinder.find(IWorkCalendDateDORService.class);
		WorkCalendDateDO[] dataList = workCalendDateDORService.find2(whereStr, sqlParamDTO, "Calendardate",
				FBoolean.FALSE);
		FArrayList fDataList = ArrayListUtil.ConvertToFArrayList(dataList);
		pagingRtnData.setPageData(fDataList);
		return pagingRtnData;
	}

	private FDate getDateAfterMonth(FDate date, int monthCount) {
		int year = date.getYear() + (date.getMonth() + monthCount) / 12;
		int month = (date.getMonth() - 1 + monthCount) % 12 + 1;
		String dateStr = String.format("%d-%d-%d", year, month, date.getDay());
		return new FDate(dateStr);
	}

	/**
	 * 获取两个日期中的间隔月数
	 * 
	 * @param begindate
	 * @param enddate
	 * @return
	 */
	private int getMonthBetween(FDate begindate, FDate enddate) {
		return (12 - begindate.getMonth() + 1) + ((enddate.getYear() - 1 - begindate.getYear()) * 12)
				+ (enddate.getMonth());
	}

}
