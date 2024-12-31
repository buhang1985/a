package iih.bd.res.dayslot.s.bp;

import java.util.Arrays;
import java.util.Comparator;

import iih.bd.res.dayslot.d.DaysLotDO;
import xap.mw.core.data.BizException;
import xap.mw.core.service.time.TimeService;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取午别
 * @author liubin
 *
 */
public class DaysLotBP {
	
	/**
	 * 得到当前时间分组
	 * 
	 * @param scTp 排班类型编码
	 * <ul>
	 * <li>IScDictCodeConst.SD_SCTP_OP【01--门诊】</li>
	 * <li>IScDictCodeConst.SD_SCTP_IP【02--住院】</li>
	 * <li>IScDictCodeConst.SD_SCTP_MT【03--医技】</li>
	 * <li>IScDictCodeConst.SD_SCTP_OT【04--手术】</li>
	 * <li>IScDictCodeConst.SD_SCTP_JZ【05--急诊】</li>
	 * </ul> 
	 * @return
	 * @throws BizException
	 */
	public DaysLotDO getNowDaysLot(String scTp) throws BizException {
		DaysLotDO daysLotDO = null;
		DaysLotDO[] daysLotDOs = getAvlDayslotList(scTp);
		if (!ArrayUtil.isEmptyNoNull(daysLotDOs)) {
			daysLotDO = daysLotDOs[0];
		}
		return daysLotDO;
	}
	/**
	 * 获取当前和之后的时间分组集合
	 * 
	 * @param scTp 排班类型编码
	 * <ul>
	 * <li>IScDictCodeConst.SD_SCTP_OP【01--门诊】</li>
	 * <li>IScDictCodeConst.SD_SCTP_IP【02--住院】</li>
	 * <li>IScDictCodeConst.SD_SCTP_MT【03--医技】</li>
	 * <li>IScDictCodeConst.SD_SCTP_OT【04--手术】</li>
	 * <li>IScDictCodeConst.SD_SCTP_JZ【05--急诊】</li>
	 * </ul> 
	 * @return
	 * @throws BizException
	 */
	public DaysLotDO[] getAvlDayslotList(String scTp) throws BizException {
		TimeService ts = ServiceFinder.find(TimeService.class);
		FDateTime currentTime = ts.getUFDateTime();
		// 得到当前时间
		FTime nowTime = currentTime.getUFTime();
		GetDaysLotsByScTpBP bp = new GetDaysLotsByScTpBP();
		// 得到所有的时间分组
		DaysLotDO[] daysLotDOs = bp.getDaysLotsByScTp(scTp);
		
		if (!ArrayUtil.isEmptyNoNull(daysLotDOs)) {
			// 时间分组排序
			daysLotDOSort(daysLotDOs);
			// 得到当前时间之后的时间
			return getCanUsedDL(daysLotDOs, nowTime);
		}
		return null;
	}
	
	/**
	 * 时间分组排序
	 * 
	 * @param daysLotDOs
	 */
	private void daysLotDOSort(DaysLotDO[] daysLotDOs) {
		Arrays.sort(daysLotDOs, new Comparator<DaysLotDO>() {
			@Override
			public int compare(DaysLotDO dayslot1, DaysLotDO dayslot2) {
				return dayslot1.getTime_begin().compareTo(
						dayslot2.getTime_begin());
			}
		});
	}
	
	/**
	 * 得到可用的日期分组工作时间
	 * 
	 * @param daysLotDOs
	 * @param nowTime
	 * @return
	 */
	private DaysLotDO[] getCanUsedDL(DaysLotDO[] daysLotDOs, FTime nowTime) {
		if (!ArrayUtil.isEmptyNoNull(daysLotDOs)) {
			int k = 0;
			int len = daysLotDOs.length;
			for (int i = 0; i < len - 1; i++) {
				DaysLotDO time = daysLotDOs[i];
				int comres = compareDLTimeWithNow(time, nowTime);
				if (comres == -1) { // 当前时间 < 开始时间
					if (i == 0) {
						k = i;
						break;
					}
				} else if (comres == 0) {// 当前时间 在 日期分组工作时间中
					k = i;
					break;
				} else {// 当前时间 > 开始时间
					DaysLotDO time2 = daysLotDOs[i + 1];
					int comres2 = compareDLTimeWithNow(time2, nowTime);
					if (comres2 == -1) {// 当前时间 < 开始时间
						int recent = getRecentlyDT(time, time2, nowTime);
						if (recent == 0) {// 当前时间离较小的日期分组工作时间较近
							k = i;
							break;
						} else {// 当前时间离较大的日期分组工作时间较近
							k = i + 1;
							break;
						}
					} else if (comres2 == 0) {// 当前时间 在 日期分组工作时间中
						k = i + 1;
						break;
					} else {
						if (i + 1 == len - 1) {
							k = i + 1;
							break;
						}
					}
				}
			}
			DaysLotDO[] days = new DaysLotDO[len - k];
			System.arraycopy(daysLotDOs, k, days, 0, len - k);
			return days;
		}
		return null;
	}
	
	/**
	 * 日期分组工作时间与当前时间比较
	 * 
	 * @param DLTime 日期分组
	 * @param now 当前时间
	 * @return
	 * <ul>
	 * 	<li>当前时间 < 开始时间,返回 -1</li>
	 * 	<li>当前时间 在 日期分组工作时间中,返回 0</li>
	 * 	<li>当前时间 > 结束,返回 1</li>
	 * </ul>
	 */
	private int compareDLTimeWithNow(DaysLotDO DLTime , FTime now){
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
	 * @param minDL 较小的日期分组
	 * @param maxDL 较大的日期分组
	 * @param now  当前时间
	 * @return
	 * <ul>
	 * 	<li>当前时间离较小的日期分组工作时间较近，返回0;</li>
	 * 	<li>当前时间离较大的日期分组工作时间较近，返回1;</li>
	 * </ul> 		
	 */
	private int getRecentlyDT(DaysLotDO minDL,DaysLotDO maxDL,FTime now){
		long minDL2Now = now.getMillis() - minDL.getTime_end().getMillis();
		long now2MaxDL = maxDL.getTime_begin().getMillis() - now.getMillis();
		return minDL2Now < now2MaxDL ? 0 : 1;
	}
}
