package iih.ci.ord.s.bp.ems.save.ip;

import iih.bd.srv.freqdef.d.FreqDefDO;
import iih.bd.srv.freqdef.d.FreqTimeDO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.orsrvsplit.OrSrvSplitUtil;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FTime;

/**
 * 获得最近生成日期操作BP MM
 */
public class CiOrDtLastBlCal4OpenBP {
	/**
	 * 根据首日次数获得开立医嘱最近生成日期操作（仅对住院有效）
	 * 
	 * @param id_freq
	 * @param dt_effe
	 * @param firstdaytimes
	 * @return
	 * @throws BizException
	 */
	public FDateTime exec(String id_freq, FDateTime dt_effe, Integer firstdaytimes, FBoolean fg_long) throws BizException {
		// 有效性校验
		if (!validateCheck(id_freq, dt_effe, firstdaytimes, fg_long))
			return dt_effe;

		// 校验间隔频次
		if (validationInterval(id_freq)) {
			return dt_effe;
		}

		// 频次时刻
		FreqTimeDO[] freqtimedos = OrSrvSplitUtil.getFreqTimeDOs(id_freq);
		return getFDateTimeByTimes2(freqtimedos, dt_effe, firstdaytimes);
		// 原来的方法保留
		// return getFDateTimeByTimes(freqtimedos, dt_effe, firstdaytimes);
	}

	/**
	 * 有效性校验
	 * 
	 * @param id_freq
	 * @param dt_effe
	 * @param firstdaytimes
	 * @return
	 * @throws BizException
	 */
	private boolean validateCheck(String id_freq, FDateTime dt_effe, Integer firstdaytimes, FBoolean fg_long) throws BizException {
		if (!CiOrdUtils.isTrue(fg_long))
			return false; //

		if (OrSrvSplitUtil.isEmpty(id_freq) || firstdaytimes == null)
			return false;

		if (!OrSrvSplitUtil.isPeriodDayFreqByID(id_freq))
			return false;

		return true;
	}

	/**
	 * 校验间隔频次
	 * 
	 * @param id_freq
	 * @return
	 * @throws BizException 
	 */
	private boolean validationInterval(String id_freq) throws BizException {
		FreqDefDO freqDO = OrSrvSplitUtil.getFreqDefDO(id_freq);
		if (freqDO != null && FBoolean.TRUE.equals(freqDO.getFg_interval())) {
			return true;
		}
		return false;
	}

	/**
	 * 获得调整的有效时间
	 * 
	 * @param freqtimedos
	 * @param dt_effe
	 * @param firstdaytime
	 * @return
	 */
	private FDateTime getFDateTimeByTimes(FreqTimeDO[] freqtimedos, FDateTime dt_effe, Integer firstdaytime) {
		if (freqtimedos == null || freqtimedos.length == 0)
			return null;
		Integer iN = 0;
		for (int i = freqtimedos.length - 1; i >= 0; i--) {
			iN += 1;
			if (iN == firstdaytime) {
				return new FDateTime(dt_effe.getBeginDate(), freqtimedos[i].getTime_mp());
			}
		}

		return dt_effe;
	}

	/**
	 * 添加 首日执行次是 0 时 最后一次执行次的时间 加一秒 获得调整的有效时间
	 * 
	 * @param freqtimedos
	 *            频次执行时刻
	 * @param dt_effe
	 *            医嘱生效时间
	 * @param firstdaytime
	 *            首日执行次数
	 * @return FDateTime 最近执行时间
	 */
	private FDateTime getFDateTimeByTimes2(FreqTimeDO[] freqtimedos, FDateTime dt_effe, Integer firstdaytimes) {
		if (freqtimedos == null)
			return null;
		if (firstdaytimes == 0) {
			// 需求 首日执行次 为 0 时 ， 取频次的最后一次执行时刻(错误，应该获取第一次执行时刻，天取第二天)
			// FTime time= freqtimedos[freqtimedos.length-1].getTime_mp();
			// return new FDateTime(dt_effe.getBeginDate(),getFTime(time));
			// 获取频次的第一次对执行时刻
			FTime time = freqtimedos[0].getTime_mp();
			return new FDateTime(dt_effe.getBeginDate().getDateAfter(1), getFTime(time));
		}

		// 取最近执行时间，当执行时刻在生效时间之后，取执行时刻的时间，当执行时刻在有效时间之前，去有效时间
		// 改的原因是首日执行次数最大值可以是当前计算结果加1
		int freqTimeIndex = freqtimedos.length - firstdaytimes;
		FreqTimeDO freqTime = freqtimedos[freqTimeIndex];

		FTime lastMpTime = freqTime.getTime_mp();
		FTime effeTime = dt_effe.getUFTime();
		//加顿时，返回开始时间
		if (effeTime.after(lastMpTime)) {
			return dt_effe;
		}
		//非加顿时，返回执行次数的对应时刻，医嘱拆分采用左闭区间
		return new FDateTime(dt_effe.getBeginDate(), lastMpTime);
		// 有效时间早于第一次执行时间，返回第一次执行时间
//		if (freqTimeIndex == 0 && lastMpTime.after(effeTime)) {
//			return new FDateTime(dt_effe.getBeginDate(), lastMpTime);
//		}
//
//		if (effeTime.after(lastMpTime)) {
//			return dt_effe;
//		}
//		return new FDateTime(dt_effe.getBeginDate(), lastMpTime);
	}

	// 毫秒数
	private FTime getFTime(FTime time) {
		if (time == null)
			return time;
		long lg = time.getMillis();// time.getMillis()+1000;
									// 具体拆分时，临时医嘱拆分后，Dt_last_bl增加1秒 2016-08-05
		return new FTime(lg);
	}
}
