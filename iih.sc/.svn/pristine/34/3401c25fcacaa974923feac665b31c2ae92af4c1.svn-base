package iih.sc.scbd.s.bp.dayslot;

import iih.bd.res.dayslot.d.DaysLotDO;
import iih.sc.comm.ScAppUtils;

import java.util.LinkedList;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
/**
 * 获取可使用的日期分组
 * 
 * @author liubin
 *
 */
public class GetAllowedDaysLotsCrossBP {
	
	/**
	 * 当前时间
	 */
	private FDateTime curDataTime;
	
	public GetAllowedDaysLotsCrossBP(){
		curDataTime = ScAppUtils.getServerDateTime();
	}
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
		return getAllowedDaysLots(dayslots, isIncExpired);
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
		DaysLotDO[] dayslots = bp.exec(sctp);
		if (ArrayUtil.isEmpty(dayslots))
			return null;
		LinkedList<DaysLotDO> list = new LinkedList<DaysLotDO>();
		FDate date = this.curDataTime.getDate().asBegin();
		//判断最后一个午别是否跨天
		if (isCrossDays(dayslots[dayslots.length-1])){
			DaysLotDO daysLot =  (DaysLotDO) dayslots[dayslots.length-1].clone();
			daysLot.setDef1(date.getDateBefore(1).toString());
			list.addLast(daysLot);
		}
		for(DaysLotDO daysLot : dayslots){
			daysLot.setDef1(date.toString());
			list.addLast(daysLot);
		}
		return list.toArray(new DaysLotDO[0]);
	}

	/**
	 * 获取急诊可用日期分组
	 * 
	 * @param dayslots
	 * @param isIncExpired
	 * @return
	 */
	private DaysLotDO[] getAllowedDaysLots(DaysLotDO[] dayslots, FBoolean isIncExpired) {
		if (ArrayUtil.isEmpty(dayslots))
			return null;
		int len = dayslots.length;
		LinkedList<DaysLotDO> list = new LinkedList<DaysLotDO>();
		DaysLotDO preDayslot = null;
		for (int i = len - 1; i >= 0; i--) {
			DaysLotDO tempDayslot = dayslots[i];
			int compare = compareDLWithNow(tempDayslot, curDataTime);
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
					DaysLotDO recentDayslot = getRecentlyDT(tempDayslot, preDayslot, curDataTime);
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
	 * 日期分组工作时间与当前时间比较
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
	private int compareDLWithNow(DaysLotDO DLTime, FDateTime now) {
		FDateTime begin = new FDateTime(new FDate(DLTime.getDef1()), DLTime.getTime_begin());
		FDateTime end = null;
		if(isCrossDays(DLTime)){
			end = new FDateTime(new FDate(DLTime.getDef1()).getDateAfter(1), DLTime.getTime_end());
		}else
			end = new FDateTime(new FDate(DLTime.getDef1()), DLTime.getTime_end());
		if (now.compareTo(begin) == -1) {
			return -1;
		} else if (now.compareTo(end) == 1) {
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
	private DaysLotDO getRecentlyDT(DaysLotDO minDL, DaysLotDO maxDL, FDateTime now) {
		FDateTime begin = new FDateTime(new FDate(maxDL.getDef1()), maxDL.getTime_begin());
		FDateTime end = null;
		if(isCrossDays(minDL)){
			end = new FDateTime(new FDate(minDL.getDef1()).getDateAfter(1), minDL.getTime_end());
		}else
			end = new FDateTime(new FDate(minDL.getDef1()), minDL.getTime_end());
		long minDL2Now = now.getMillis() - end.getMillis();
		long now2MaxDL = begin.getMillis() - now.getMillis();
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
