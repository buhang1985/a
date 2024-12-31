package iih.ci.ord.s.bp.oporsplit;

import iih.bd.srv.freqdef.d.FreqDefDO;
import iih.bd.srv.freqdef.d.FreqTimeDO;
import iih.ci.ord.dto.oporsplit.d.OpOrderSplitDTO;
import iih.ci.ord.s.bp.orsrvsplit.GetApartFreqTimeDOsBP;
import iih.ci.ord.s.bp.orsrvsplit.GetFreqTimeDOsBP;
import iih.ci.ord.s.bp.orsrvsplit.OrSrvSplitUtil;

import java.util.Hashtable;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;

/**
 * 拆分计算
 * 
 * @author xuxing 2016-09-27
 * @version 2017年11月7日20:22:37_xuxing_门诊支持间隔频次
 *
 */
public class OrSplitBp {

	/**
	 * 拆分计算主入口
	 * 
	 * @param splitDTO即将拆分的医嘱
	 * @param validSE有效区间
	 * @param mapFreq频率
	 * @param reList最终返回集合
	 * @throws BizException
	 */
	@SuppressWarnings("rawtypes")
	public void exec(OpOrderSplitDTO splitDTO, FDateTime[] validSE, Hashtable mapFreq, List<OpOrderSplitDTO> reList) throws BizException {

		String sd_frequnit = splitDTO.getSd_frequnit();

		// 临时频次医嘱的处理逻辑
		if (OrSrvSplitUtil.isTemporaryFreq(sd_frequnit)) {

			// 医嘱生效和截止时间必须在有效时间之内
			if (splitDTO.getDt_effe().compareTo(validSE[0]) >= 0 && splitDTO.getDt_end().compareTo(validSE[1]) <= 0) 
				cloneAndAddToList(reList, splitDTO, splitDTO.getDt_effe());

		} else if (OrSrvSplitUtil.isPeriodMinFreq(sd_frequnit)) {
			
			//分钟频次拆分
			FreqDefDO freqDO = OrSrvSplitUtil.getFreqDefDO(splitDTO.getId_freq());
			FDateTime[] dts = null;
			if (OrSrvSplitUtil.isApartFreq(freqDO)) 
				dts = getApartTimeDOs(splitDTO.getDt_effe(), freqDO, validSE);// 分钟间隔频次医嘱
			 else
				dts = OrSrvSplitUtil.getDateArrayByMin(validSE[0], validSE[1], splitDTO.getFrequnitct());// 普通分钟频次
			cloneAndAddToList(reList, splitDTO, dts);
			
		}
		else if (OrSrvSplitUtil.isPeriodHourFreq(sd_frequnit)) {

			// 小时频次拆分
			FreqDefDO freqDO = OrSrvSplitUtil.getFreqDefDO(splitDTO.getId_freq());
			FDateTime[] dts = null;
			if (OrSrvSplitUtil.isApartFreq(freqDO))
				dts = getApartTimeDOs(splitDTO.getDt_effe(), freqDO, validSE);// 小时间隔频次医嘱
			else
				dts = OrSrvSplitUtil.getDateArrayByHour(splitDTO.getDt_effe(), validSE[0], validSE[1], splitDTO.getFrequnitct());// 普通小时频次
			cloneAndAddToList(reList, splitDTO, dts);

		} else if (OrSrvSplitUtil.isPeriodFreq(sd_frequnit)) {

			// 周期性频次医嘱处理逻辑 天 周
			FreqDefDO freqDO = OrSrvSplitUtil.getFreqDefDO(splitDTO.getId_freq());
			FDateTime[] dts = null;
			if (OrSrvSplitUtil.isApartFreq(freqDO)) {
				dts = getApartTimeDOs(splitDTO.getDt_effe(), freqDO, validSE);// 隔日拆分逻辑
			} else {
				FreqTimeDO[] freqTimeDOS = getFreqTimeDOs(splitDTO.getId_freq(), mapFreq);// 普通一天几次逻辑
				dts = getPeriodFreqTimes(validSE, freqTimeDOS, sd_frequnit);
			}
			cloneAndAddToList(reList, splitDTO, dts);

		} else if (OrSrvSplitUtil.isPlanFreq(sd_frequnit)) {

			// 计划频次医嘱的处理逻辑
			FDateTime[] dts = OrSrvSplitUtil.getOrdFreqTimeDateTimes(splitDTO.getId_or());
			cloneAndAddToList(reList, splitDTO, dts);
		}
	}

	/***
	 * 克隆并添加到拆分列表中
	 * 
	 * @param list
	 * @param orsplitorder
	 * @param dt_plan
	 * @throws BizException
	 */
	private void cloneAndAddToList(List<OpOrderSplitDTO> list, OpOrderSplitDTO splitorder, FDateTime dt_plan) throws BizException {
		OpOrderSplitDTO norsplitorder = (OpOrderSplitDTO) splitorder.clone();
		norsplitorder.setDt_mp_plan(dt_plan);
		list.add(norsplitorder);
	}

	/***
	 * 克隆并添加到拆分列表中
	 * 
	 * @param list
	 * @param orsplitorder
	 * @param dt_plan
	 * @throws BizException
	 */
	private void cloneAndAddToList(List<OpOrderSplitDTO> list, OpOrderSplitDTO splitorder, FDateTime[] dt_plans) throws BizException {
		if (dt_plans == null)
			return;
		for (int i = 0; i < dt_plans.length; i++) {
			cloneAndAddToList(list, splitorder, dt_plans[i]);
		}
	}

	/***
	 * 获得医嘱频次时刻DO集合数据
	 * 
	 * @param id_freq
	 * @param freqHt
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("rawtypes")
	private FreqTimeDO[] getFreqTimeDOs(String id_freq, Hashtable mapFreq) throws BizException {
		GetFreqTimeDOsBP bp = new GetFreqTimeDOsBP();
		return bp.exec(id_freq, mapFreq);
	}

	/**
	 * 计算隔日执行逻辑
	 * 
	 * @param dt_effe
	 * @param freqDO
	 * @param validSE
	 * @param freqtimedos
	 * @return
	 * @throws BizException
	 */
	private FDateTime[] getApartTimeDOs(FDateTime dt_effe, FreqDefDO freqDO, FDateTime[] validSE) throws BizException {
		GetApartFreqTimeDOsBP bp = new GetApartFreqTimeDOsBP();
		return bp.exec(dt_effe, freqDO, validSE);
	}

	/***
	 * 获得周期频次类型时间序列数组数据
	 * 
	 * @param validSE
	 * @param freqtimedos
	 * @param sd_frequnit
	 * @return
	 * @throws BizException
	 */
	private FDateTime[] getPeriodFreqTimes(FDateTime[] validSE, FreqTimeDO[] freqtimedos, String sd_frequnit) throws BizException {
		FDateTime[] dts = null;
		if (OrSrvSplitUtil.isPeriodDayFreq(sd_frequnit)) {// 天处理逻辑 只支持1天N次
			dts = OrSrvSplitUtil.getDateArrayByDay(validSE[0], validSE[1], freqtimedos);
		} else if (OrSrvSplitUtil.isPeriodWeekFreq(sd_frequnit)) { // 周处理逻辑，业务上只支持1周N次的数据
			dts = OrSrvSplitUtil.getDateArrayByWeek(validSE[0], validSE[1], freqtimedos);
		} else if (OrSrvSplitUtil.isPeriodMonthFreq(sd_frequnit)) { // 月的处理逻辑，业务上只支持1月N次的数据，月末倒数第一天，1、2、3、4.。。。、-3-2、-1
			dts = OrSrvSplitUtil.getDateArrayByMonth(validSE[0], validSE[1], freqtimedos);
		}
		return dts;
	}
}
