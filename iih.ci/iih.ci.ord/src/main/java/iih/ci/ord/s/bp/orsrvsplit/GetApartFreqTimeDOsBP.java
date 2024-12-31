package iih.ci.ord.s.bp.orsrvsplit;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.freqdef.d.FreqDefDO;
import iih.bd.srv.freqdef.d.FreqTimeDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;

/**
 * 隔日执行拆分处理
 * 
 * @author xuxing_2017年9月15日16:44:53
 *
 */
public class GetApartFreqTimeDOsBP {

	/**
	 * 主入口
	 * 
	 * @param dt_effe
	 * @param freqDO
	 * @param validSE
	 * @param freqtimedos
	 * @return
	 * @throws BizException
	 */
	public FDateTime[] exec(FDateTime dt_effe, FreqDefDO freqDO, FDateTime[] validSE) throws BizException {

		// 1、基础校验
		validation(dt_effe, freqDO, validSE);

		// 2、克隆区间
		FDateTime[] newValidSE = cloneDate(validSE);

		// 3、计算间隔分钟
		int intervalMin = getIntervalMin(dt_effe, freqDO, newValidSE);

		// 4、计算执行时刻
		FDateTime[] rtns = getEffectiveInterval(dt_effe, newValidSE, intervalMin);

		return rtns;
	}

	/**
	 * 有效性校验
	 * 
	 * @param dt_effe
	 * @param freqDO
	 * @param validSE
	 * @throws BizException
	 */
	private void validation(FDateTime dt_effe, FreqDefDO freqDO, FDateTime[] validSE) throws BizException {
		if (dt_effe == null) {
			throw new BizException("间隔类频次拆分，医嘱生效时间信息空异常！");
		}
		if (freqDO == null) {
			throw new BizException("间隔类频次拆分，频次信息空异常！");
		}
		if (validSE == null || validSE.length < 0) {
			throw new BizException("间隔类频次拆分，有效时间区间空异常！");
		}
		if (validSE[0] == null) {
			throw new BizException("间隔类频次拆分，有效开始时间信息空异常！");
		}
		if (validSE[1] == null) {
			throw new BizException("间隔类频次拆分，有效截止时间信息空异常！");
		}
	}

	/**
	 * 克隆区间
	 * 
	 * @param validSE
	 * @return
	 */
	private FDateTime[] cloneDate(FDateTime[] validSE) {
		List<FDateTime> reList = new ArrayList<FDateTime>();
		for (FDateTime date : validSE) {
			reList.add((FDateTime) date.clone());
		}
		return reList.toArray(new FDateTime[reList.size()]);
	}

	/**
	 * 转换周期为分钟
	 * 
	 * @param freqDO
	 * @return
	 * @throws BizException
	 */
	private int getIntervalMin(FDateTime dt_effe, FreqDefDO freqDO, FDateTime[] validSE) throws BizException {

		switch (freqDO.getSd_frequnitct()) {
		case IBdSrvDictCodeConst.SD_FREQNUNITCT_MINUTE://分钟
			return freqDO.getFrequnitct();
		case IBdSrvDictCodeConst.SD_FREQNUNITCT_HOUR:// 小时
			return freqDO.getFrequnitct() * 60;
		case IBdSrvDictCodeConst.SD_FREQNUNITCT_DAY:// 天 特殊处理，天频次记头同时记尾
//			if (validSE[1].getTime().equals(dt_effe.getTime())) 
//				// 天间隔，当请求拆分的截止时间的时间点等于医嘱生效时间时，本次拆分记尾
//				validSE[1] = ((FDateTime) validSE[1].clone()).addSeconds(1);
			return freqDO.getFrequnitct() * 24 * 60;
		default:
			throw new BizException("间隔类频次拆分，目前仅支持小时和天！");
		}
	}

	/**
	 * 间隔频次计算执行点
	 * 
	 * @param dt_effe
	 * @param validSE
	 * @param intervalHour
	 * @return
	 * @throws BizException
	 */
	private FDateTime[] getEffectiveInterval(FDateTime dt_effe, FDateTime[] validSE, int intervalMin) throws BizException {
		List<FDateTime> reList = new ArrayList<FDateTime>();
		FDateTime dt_plan = (FDateTime) dt_effe.clone();// 获取有效执行点
		while (true) {
			// 计算超出了指定拆分时间区间内
			if (dt_plan.compareTo(validSE[1]) >= 0) {
				break;
			}
			// 当前有效时间段内是否有执行计划点
			if (isInBetween(dt_plan, validSE[0], validSE[1])) {
				reList.add(dt_plan);
			}
			dt_plan = dt_plan.addSeconds(60 * intervalMin);
		}
		return reList.toArray(new FDateTime[reList.size()]);
	}

	/**
	 * 判断时间是否在有效间隔之内
	 * 
	 * @param dt_effe
	 * @param dt_begin
	 * @param dt_end
	 * @return
	 */
	private boolean isInBetween(FDateTime dt_effe, FDateTime dt_begin, FDateTime dt_end) {
		if (dt_effe == null || dt_begin == null || dt_end == null) {
			return false;
		}
		// 2017年11月6日15:21:44 王琪要求，间隔类频次计头不计尾
		if (dt_effe.compareTo(dt_begin) >= 0 && dt_end.compareTo(dt_effe) > 0) {
			return true;
		}
		return false;
	}

	/**
	 * 取拆分有效开始频次
	 * 
	 * @param dt_effe
	 * @param validSE
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unused")
	private FDateTime getEffictiveBegin(FDateTime dt_effe, FDateTime[] validSE) throws BizException {
		if (validSE[0].compareTo(dt_effe) >= 0) {
			return (FDateTime) dt_effe.clone();
		}
		if (validSE[1].compareTo(dt_effe) < 0) {
			throw new BizException("隔日频次拆分，有效起始区间异常！");
		}
		return (FDateTime) validSE[0].clone();
	}

	/**
	 * 获取拆分之间区间内，有执行计划的天集合
	 * 
	 * @param dt_effe
	 * @param freqDO
	 * @param validSE
	 * @return
	 */
	@SuppressWarnings("unused")
	private FDate[] getEffectiveInterval(FDateTime dt_effe, FreqDefDO freqDO, FDateTime[] validSE) {
		List<FDate> reList = new ArrayList<FDate>();
		FDateTime dt = (FDateTime) dt_effe.clone();

		FDate dt_date_b = new FDate(validSE[0].getDate().toLocalString());
		FDate dt_date_e = new FDate(validSE[1].getDate().toLocalString());

		while (true) {
			// 计算超出了指定拆分时间区间内
			if (dt.compareTo(validSE[1]) > 0) {
				break;
			}
			// 当前有效时间段内是否有执行计划点
			FDate dt_effe_date = new FDate(dt.getDate().toLocalString());
			if (dt_effe_date.compareTo(dt_date_b) >= 0 && dt_date_e.compareTo(dt_effe_date) >= 0) {
				reList.add((FDate) dt_effe_date.clone());
			}
			dt = dt.addSeconds(86400 * freqDO.getFrequnitct());
		}
		return reList.toArray(new FDate[reList.size()]);
	}

	/**
	 * 计算有效区间内的执行点
	 * 
	 * @param dateList
	 * @param freqtimedos
	 * @return
	 */
	@SuppressWarnings("unused")
	private FDateTime[] getExePoint(FDate[] dateList, FreqTimeDO[] freqtimedos, FDateTime[] validSE) {
		if (dateList == null || dateList.length < 1) {
			return null;
		}
		List<FDateTime> reList = new ArrayList<FDateTime>();
		for (FDate date : dateList) {
			for (FreqTimeDO time : freqtimedos) {
				FDateTime dt_plan = new FDateTime(date.toLocalString() + " " + time.getTime_mp().toLocalString());
				if (dt_plan.compareTo(validSE[0]) >= 0 && validSE[1].compareTo(dt_plan) >= 0) {
					reList.add(dt_plan);
				}
			}
		}
		return reList.toArray(new FDateTime[reList.size()]);
	}
}
