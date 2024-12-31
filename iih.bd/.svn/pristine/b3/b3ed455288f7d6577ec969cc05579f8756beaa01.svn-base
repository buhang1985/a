package iih.bd.res.dayslot.s.bp;

import java.util.ArrayList;

import iih.bd.base.utils.AppUtils;
import iih.bd.res.dayslot.d.DaysLotDO;
import iih.bd.res.dayslot.i.IDayslotMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.bizrule.validation.ValidationFailure;

/**
 * 日期分组时间交叉校验业务逻辑
 * 
 * @author hao_wu
 *
 */
public class TimeCrossValidateBp {

	public ValidationFailure exec(Object[] arg0) throws BizException {
		ArrayList<DaysLotDO> daysLotDOList = convertToDaysLotDOList(arg0);
		ValidationFailure vFailure = timeCrossValidate(daysLotDOList);
		return vFailure;
	}

	/**
	 * 时间交叉校验
	 * 
	 * @param daysLotDOList
	 * @return
	 * @throws BizException
	 */
	private ValidationFailure timeCrossValidate(ArrayList<DaysLotDO> daysLotDOList) throws BizException {

		while (daysLotDOList != null && daysLotDOList.size() > 0) {
			ArrayList<DaysLotDO> caDaysLotDOList = getDaysLotDOListByCa(daysLotDOList);
			getDaysLotDOFromDb(caDaysLotDOList);
			ValidationFailure vFailure = listTimeCrossValidate(caDaysLotDOList);
			if (vFailure != null) {
				return vFailure;
			}
		}
		return null;
	}

	/**
	 * 获取同一分类下日期分组
	 * 
	 * @param daysLotDOList
	 * @return
	 * @throws BizException
	 */
	private ArrayList<DaysLotDO> getDaysLotDOListByCa(ArrayList<DaysLotDO> daysLotDOList) throws BizException {
		if (daysLotDOList == null || daysLotDOList.size() <= 0) {
			return null;
		}
		ArrayList<DaysLotDO> caDaysLotDOList = new ArrayList<DaysLotDO>();
		DaysLotDO firstDaysLotDO = daysLotDOList.get(0);
		String idDaysLotCa = firstDaysLotDO.getId_dayslotca();
		for (DaysLotDO daysLotDO : daysLotDOList) {
			if (StringUtil.isEmptyWithTrim(daysLotDO.getId_dayslotca())) {
				String msg = String.format("日期分组\"%s\"分类id为空。", daysLotDO.getName());
				throw new BizException(msg);
			}
			if (daysLotDO.getId_dayslotca().equals(idDaysLotCa)) {
				caDaysLotDOList.add(daysLotDO);
			}
		}
		for (DaysLotDO daysLotDO : caDaysLotDOList) {
			daysLotDOList.remove(daysLotDO);
		}
		return caDaysLotDOList;
	}

	/**
	 * 获取数据库同一分组分类下日期分组
	 * 
	 * @param caDaysLotDOList
	 * @throws BizException
	 */
	private void getDaysLotDOFromDb(ArrayList<DaysLotDO> caDaysLotDOList) throws BizException {
		DaysLotDO firstDaysLotDO = caDaysLotDOList.get(0);
		String idDaysLotCa = firstDaysLotDO.getId_dayslotca();

		IDayslotMDORService dayslotMDORService = ServiceFinder.find(IDayslotMDORService.class);
		String wherePart = String.format("Id_dayslotca = '%s' and fg_active = 'Y'", idDaysLotCa);
		DaysLotDO[] result = dayslotMDORService.find(wherePart, "", FBoolean.FALSE);
		if (result == null) {
			return;
		}
		for (DaysLotDO daysLotDO : result) {
			boolean fgIn = false;
			for (DaysLotDO caDaysLotDO : caDaysLotDOList) {
				if (caDaysLotDO.getId_dayslot() != null
						&& caDaysLotDO.getId_dayslot().equals(daysLotDO.getId_dayslot())) {
					fgIn = true;
				}
			}
			if (!fgIn) {
				caDaysLotDOList.add(daysLotDO);
			}
		}
	}

	/**
	 * 列表交叉校验
	 * 
	 * @param daysLotDOList
	 * @return
	 */
	private ValidationFailure listTimeCrossValidate(ArrayList<DaysLotDO> daysLotDOList) {
		for (int i = 0; i < daysLotDOList.size(); i++) {
			DaysLotDO daysLotDO = daysLotDOList.get(i);
			for (int j = 0; j < daysLotDOList.size(); j++) {
				DaysLotDO temp = daysLotDOList.get(j);
				if (i == j) {
					continue;
				}
				ValidationFailure vFailure = timeCrossValidat(daysLotDO, temp);
				if (vFailure != null) {
					return vFailure;
				}
			}
		}
		return null;
	}

	/**
	 * 两日期分组时间交叉检查
	 * 
	 * @param daysLotDO
	 * @param temp
	 * @return
	 */
	private ValidationFailure timeCrossValidat(DaysLotDO daysLotDO, DaysLotDO temp) {
		FDate serverDate = AppUtils.getServerDate();

		FDateTime beginTime1 = AppUtils.getFDateTime(serverDate, daysLotDO.getTime_begin());
		FDateTime endTime1 = AppUtils.getFDateTime(serverDate, daysLotDO.getTime_end());
		FDateTime beginTime2 = AppUtils.getFDateTime(serverDate, temp.getTime_begin());
		FDateTime endTime2 = AppUtils.getFDateTime(serverDate, temp.getTime_end());

		if (beginTime1.after(endTime1) && beginTime2.before(endTime2)) {
			beginTime1 = beginTime1.getDateTimeBefore(1);
		} else if (beginTime2.after(endTime2) && beginTime1.before(endTime1)) {
			beginTime2 = beginTime2.getDateTimeBefore(1);
		} else if (beginTime1.after(endTime1) && beginTime2.after(endTime2)) {
			beginTime1 = beginTime1.getDateTimeBefore(1);
			beginTime2 = beginTime2.getDateTimeBefore(1);
		}

		if (endTime1.after(beginTime2) && endTime1.before(endTime2)) {
			String msg = String.format("日期分组时间区间不允许交叉。\n日期分组\"%s\"结束时间介于日期分组\"%s\"开始时间与结束时间之间。", daysLotDO.getName(),
					temp.getName());
			return new ValidationFailure(msg);
		}
		if (beginTime1.after(beginTime2) && beginTime1.before(endTime2)) {
			String msg = String.format("日期分组时间区间不允许交叉。\n日期分组\"%s\"开始时间介于日期分组\"%s\"开始时间与结束时间之间。", daysLotDO.getName(),
					temp.getName());
			return new ValidationFailure(msg);
		}
		if (beginTime1.before(beginTime2) && endTime1.after(endTime2)) {
			String msg = String.format("日期分组时间区间不允许交叉。\n日期分组\"%s\"包含日期分组\"%s\"。", daysLotDO.getName(), temp.getName());
			return new ValidationFailure(msg);
		}
		if (beginTime1.after(beginTime2) && endTime1.before(endTime2)) {
			String msg = String.format("日期分组时间区间不允许交叉。\n日期分组\"%s\"被日期分组\"%s\"包含。", daysLotDO.getName(), temp.getName());
			return new ValidationFailure(msg);
		}
		if (beginTime1.equals(beginTime2) && endTime1.equals(endTime2)) {
			String msg = String.format("日期分组时间区间不允许交叉。\n日期分组\"%s\"与日期分组\"%s\"时间区间相同。", daysLotDO.getName(),
					temp.getName());
			return new ValidationFailure(msg);
		}
		return null;
	}

	/**
	 * 转换日期分组列表</br>
	 * 去除未启用的数据
	 * 
	 * @param arg0
	 * @return
	 */
	private ArrayList<DaysLotDO> convertToDaysLotDOList(Object[] arg0) {
		ArrayList<DaysLotDO> arrayList = new ArrayList<DaysLotDO>();
		for (Object obj : arg0) {
			if (obj instanceof DaysLotDO && FBoolean.TRUE.equals(((DaysLotDO) obj).getFg_active())) {
				arrayList.add((DaysLotDO) obj);
			}
		}
		return arrayList;
	}
}
