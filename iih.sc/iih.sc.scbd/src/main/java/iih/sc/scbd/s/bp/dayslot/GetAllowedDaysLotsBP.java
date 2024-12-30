package iih.sc.scbd.s.bp.dayslot;

import java.util.LinkedList;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.res.dayslot.d.DaysLotDO;
import xap.mw.core.data.BizException;
import xap.mw.core.service.time.TimeService;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取可使用的日期分组
 * 
 * @author liubin
 *
 */
public class GetAllowedDaysLotsBP {
	/**
	 * 获取可使用的日期分组 （时间在午别外，按最近时间原则选择午别）
	 *  <blockquote>
	 * <pre>
	 * 如：当前时间【12:10】，上午【08：00-12：00】，下午【12：00-18：00】
	 * </pre>
	 * <pre>
	 * 1）isIncExpired = true, return 上午，下午
	 * </pre>
	 * <pre>
	 * 2）isIncExpired = false, return 下午
	 * </pre>
	 * </blockquote>
	 * 
	 * @param sctp
	 *            排班类型
	 * @param isIncExpired
	 *            已过期日期分组是否包含在内
	 * @return
	 * @throws BizException
	 */
	public DaysLotDO[] exec(String sctp, FBoolean isIncExpired)
			throws BizException {
		// 1.获取所有日期分组
		DaysLotDO[] dayslots = getAllDaysLots(sctp);
		return getAllowedDaysLots(dayslots, sctp, isIncExpired);
	}

	/**
	 * 获取所有日期分组
	 * 
	 * @param sctp
	 * @return
	 * @throws BizException
	 */
	private DaysLotDO[] getAllDaysLots(String sctp) throws BizException {
		GetDaysLotDOBP bp = new GetDaysLotDOBP();
		return bp.exec(sctp);
	}

	/**
	 * 获取急诊可用日期分组
	 * 
	 * @param dayslots
	 * @param isIncExpired
	 * @return
	 */
	private DaysLotDO[] getAllowedDaysLots(DaysLotDO[] dayslots, String sctp,
			FBoolean isIncExpired) {
		if (ArrayUtil.isEmpty(dayslots))
			return null;
		int len = dayslots.length;
		LinkedList<DaysLotDO> list = new LinkedList<DaysLotDO>();
		FTime nowTime = ServiceFinder.find(TimeService.class).getUFDateTime().getUFTime();// 获取当前时间
		DaysLotDO preDayslot = null;
		for (int i = len - 1; i >= 0; i--) {
			DaysLotDO tempDayslot = dayslots[i];
			if (IScDictCodeConst.SD_SCTP_JZ.equals(sctp) || IScDictCodeConst.SD_SCTP_OP.equals(sctp)) {
				if (isCrossDays(tempDayslot)) {
					// 跨天日期分组
					if (nowTime.compareTo(tempDayslot.getTime_end()) <= 0) {
						list.clear();
						list.addFirst(tempDayslot);
						break;
					}
					list.addFirst(tempDayslot);
					preDayslot = tempDayslot;
					int compare = nowTime.compareTo(tempDayslot.getTime_begin());
					if (compare > 0)
						break;
					continue;
				}
			}
			int compare = compareDLWithNow(tempDayslot, nowTime);
			if (compare == 0 || compare == -1) {
				// 当前时间 在 日期分组工作时间中
				// 当前时间 在 日期分组工作时间之前
				list.addFirst(tempDayslot);
				preDayslot = tempDayslot;
				if (compare == 0)
					break;
				continue;
			}
			// 当前时间 在 日期分组工作时间之后，判断该日期分组是否可用
			if (FBoolean.TRUE.equals(isIncExpired)) {
				if (preDayslot != null) {
					DaysLotDO recentDayslot = getRecentlyDT(tempDayslot,
							preDayslot, nowTime);
					if (recentDayslot.equals(tempDayslot))
						list.addFirst(tempDayslot);
				} else
					list.addFirst(tempDayslot);
			}
			break;
		}
		return ListUtil.isEmpty(list) ? null : list.toArray(new DaysLotDO[0]);
	}

	/**
	 * 日期分组工作时间与当前时间比较 (不考虑跨天)
	 * 
	 * @param DLTime
	 *            日期分组
	 * @param now
	 *            当前时间
	 * @return <ul>
	 *         <li>当前时间 < 开始时间,返回 -1</li>
	 *         <li>当前时间 在 日期分组工作时间中,返回 0</li>
	 *         <li>当前时间 > 结束,返回 1</li>
	 *         </ul>
	 */
	private int compareDLWithNow(DaysLotDO DLTime, FTime now) {
		if (now.compareTo(DLTime.getTime_begin()) == -1) {
			return -1;
		} else if (now.compareTo(DLTime.getTime_end()) == 1) {
			return 1;
		} else {
			return 0;
		}
	}

	/**
	 * 当时间处于两个时间分组之间时，取距离当前时间叫近的日期分组
	 * 
	 * @param minDL
	 *            较小的日期分组
	 * @param maxDL
	 *            较大的日期分组
	 * @param now
	 *            当前时间
	 * @return
	 * 
	 */
	private DaysLotDO getRecentlyDT(DaysLotDO minDL, DaysLotDO maxDL, FTime now) {
		long minDL2Now = now.getMillis() - minDL.getTime_end().getMillis();
		long now2MaxDL = maxDL.getTime_begin().getMillis() - now.getMillis();
		return minDL2Now < now2MaxDL ? minDL : maxDL;
	}

	/**
	 * 是否是跨天日期分组
	 * 
	 * @param dayslot
	 * @return
	 */
	private boolean isCrossDays(DaysLotDO dayslot) {
		return dayslot.getTime_end().before(dayslot.getTime_begin());
	}
}
