package iih.bl.cg.s.bp.ip.backcg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import iih.bd.base.utils.DateTimeUtils;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;

/**
 * 按日计费排斥选择器 一天只收选择一个
 * 
 * @author yankan
 * @since 2017-09-28
 *
 */
public class DayFeeExclChooser implements IChooser {
	/**
	 * 抉择
	 * 
	 * @param paramList
	 * @param cgEndTime
	 * @param comparator
	 * @return 结果map,[key:日期,value:计费对象]
	 */
	@Override
	public Map<String, DayFeeParam> choose(List<DayFeeParam> paramList, FDateTime cgEndTime, Comparator comparator) {
		if (ListUtil.isEmpty(paramList) || cgEndTime == null) {
			return null;
		}
		Map<String, DayFeeParam> dateFeeRstMap = new LinkedHashMap<String, DayFeeParam>();
		Comparator timeComp = ComparatorFactory.createEarlierComp();
		Collections.sort(paramList, timeComp);// 按时间先后排序
		Map<String, List<DayFeeParam>> dateFeeMap = this.groupByDate(paramList, cgEndTime);// 按日期进行分组
		Comparator chgComp = ComparatorFactory.createChargedComp(cgEndTime);
		for (Entry<String, List<DayFeeParam>> entry : dateFeeMap.entrySet()) {
			List<DayFeeParam> feeParamList = entry.getValue();
			if (feeParamList.size() > 1) {
				Collections.sort(feeParamList, comparator);// 如果大于1，按优先级别进行选择
				Collections.sort(feeParamList, chgComp);// 已记账的优先
			}
			DayFeeParam feeParam = feeParamList.get(0);
			dateFeeRstMap.put(entry.getKey(), feeParam);
		}

		return dateFeeRstMap;
	}

	/**
	 * 根据日期进行分组
	 * 
	 * @param paramList
	 * @return
	 */
	private Map<String, List<DayFeeParam>> groupByDate(List<DayFeeParam> paramList, FDateTime cgEndTime) {
		Map<String, List<DayFeeParam>> dateFeeMap = new HashMap<String, List<DayFeeParam>>();
		for (DayFeeParam feeParam : paramList) {
			FDateTime endTime = null;
			if (feeParam.getDt_e() == null) {
				endTime = cgEndTime;// 未结束取记账时间，否则取较小者
			} else {
				endTime = DateTimeUtils.getSmaller(feeParam.getDt_e(), cgEndTime);
			}
			FDate beginDate = (FDate) feeParam.getDt_b().getBeginDate().clone();
			while (beginDate.before(endTime.getEndDate())) {
				String dateKey = beginDate.toLocalString();
				List<DayFeeParam> feeList = dateFeeMap.get(dateKey);
				if (feeList == null) {
					feeList = new ArrayList<DayFeeParam>();
					dateFeeMap.put(dateKey, feeList);
				}
				feeList.add(feeParam);
				beginDate = beginDate.getDateAfter(1);// +1
			}
		}
		return dateFeeMap;
	}
}
