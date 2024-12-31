package iih.ci.ord.s.bp.orsrvsplit.help;

import iih.bd.base.utils.DateTimeUtils;
import iih.bd.srv.freqdef.d.FreqDefDO;
import iih.bd.srv.freqdef.d.FreqTimeDO;
import iih.ci.ord.dto.blexorder.d.SrvSplitOrderDTO;
import iih.ci.ord.ordsrvdose.d.OrdSrvDoseDO;
import iih.ci.ord.s.bp.orsrvsplit.GetApartFreqTimeDOsBP;
import iih.ci.ord.s.bp.orsrvsplit.GetFreqTimeDOsBP;
import iih.ci.ord.s.bp.orsrvsplit.OrSrvSplitUtil;
import iih.ci.ord.s.bp.orsrvsplit.SrvSplitOrderCloneBP;

import java.util.ArrayList;
import java.util.Hashtable;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FDateTime;

/**
 * 按频次进行服务拆分处理逻辑
 * 
 * @author ly
 * @version xuxing_2018年7月23日11:21:12_首日拆分，默认首日必须拆完
 *
 */
public class OrSrvSplitHandleByFrepBP {

	/**
	 * 按频次进行服务拆分处理逻辑
	 * 
	 * @param list
	 * @param srvsplitorder
	 * @param validSE
	 * @param freqHt
	 * @throws BizException
	 */
	public void exec(ArrayList<SrvSplitOrderDTO> list, SrvSplitOrderDTO srvsplitorder, FDateTime[] validSE, Hashtable freqHt) throws BizException {
		String sd_frequnit = srvsplitorder.getSd_frequnit();
		String id_freq = srvsplitorder.getId_freq();

		// 按频次单位类型进行分类处理
		if (OrSrvSplitUtil.isTemporaryFreq(sd_frequnit)) {// 临时频次医嘱的处理逻辑
			// 2016-06-13 xuxing 临时频次处理（临时频次为首次拆分），避免重复拆分
			if (srvsplitorder.getDt_effe().compareTo(validSE[0]) >= 0 && srvsplitorder.getDt_effe().compareTo(validSE[1]) <= 0) {
				cloneAndAddToList(list, srvsplitorder, srvsplitorder.getDt_effe());
			}
		} else if (OrSrvSplitUtil.isPeriodHourFreq(sd_frequnit)) {// 周期性小时频次医嘱处理逻辑,不会出现3小时2次的概念只能是N小时1次

			// 2017年11月6日13:49:31小时间隔频次
			FreqDefDO freqDO = OrSrvSplitUtil.getFreqDefDO(id_freq);
			FDateTime[] dts = null;
			if (OrSrvSplitUtil.isApartFreq(freqDO)) {
				dts = getApartTimeDOs(srvsplitorder.getDt_effe(), freqDO, validSE);
			} else {
				dts = OrSrvSplitUtil.getDateArrayByHour(srvsplitorder.getDt_effe(), validSE[0], validSE[1], srvsplitorder.getFrequnitcnt());
			}
			cloneAndAddToList(list, srvsplitorder, dts);

		} else if (OrSrvSplitUtil.isPeriodFreq(sd_frequnit)) { // 周期性频次医嘱处理逻辑天,周,月

			// xuxing_2018年7月23日11:21:12_首日拆分，默认首日必须拆完
			FDateTime dt_effictive_end = validSE[1];
			
			if (DateTimeUtils.isSameDay(srvsplitorder.getDt_effe(), srvsplitorder.getDt_last_bl())) {
				FDateTime ent = new FDateTime(srvsplitorder.getDt_last_bl().getDate().toLocalString() + " 00:00:00").addSeconds(24 * 3600);
				if (ent.compareTo(dt_effictive_end) > 0) {
					// 计算的首日拆分截止时间,与医嘱有效截止时间，取较小的一个
					// 确保首日在第一次全部拆分完
					if (srvsplitorder.getDt_end().compareTo(ent) >= 0) {
						dt_effictive_end = ent;
					} else {
						dt_effictive_end = srvsplitorder.getDt_end();
					}
				}
			}
			
			// 2017-09-15 增加隔日执行拆分逻辑
			FreqDefDO freqDO = OrSrvSplitUtil.getFreqDefDO(id_freq);
			FreqTimeDO[] freqtimedos = getFreqTimeDOs(id_freq, freqHt);
			FDateTime[] dts = null;
			if (OrSrvSplitUtil.isApartFreq(freqDO)) {
				// 隔日执行频次
				dts = getApartTimeDOs(srvsplitorder.getDt_effe(), freqDO, new FDateTime[] { validSE[0], dt_effictive_end });
			} else {
				// 普通一天几次
				dts = getPeriodFreqTimes(new FDateTime[] { validSE[0], dt_effictive_end }, freqtimedos, sd_frequnit);
			}

			if (OrSrvSplitUtil.isTrue(srvsplitorder.getFg_dose_anoma())) {
				cloneAndAddToList(list, srvsplitorder, dts, OrSrvSplitUtil.getOrdSrvDoseDOs(srvsplitorder.getId_orsrv()));
			} else {
				cloneAndAddToList(list, srvsplitorder, dts);
			}
		} else if (OrSrvSplitUtil.isPlanFreq(sd_frequnit)) {// 计划频次医嘱的处理逻辑
			planFreqHandle(list, srvsplitorder, validSE);
		} else {
			// 暂不支持
		}
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
	 * 克隆并添加到拆分列表中
	 * 
	 * @param list
	 * @param srvsplitorder
	 * @param dt_plan
	 * @throws BizException
	 */
	private void cloneAndAddToList(ArrayList<SrvSplitOrderDTO> list, SrvSplitOrderDTO srvsplitorder, FDateTime dt_plan) throws BizException {
		SrvSplitOrderDTO nsrvsplitorder = clone(srvsplitorder);
		nsrvsplitorder.setDt_mp_plan(dt_plan);
		list.add(nsrvsplitorder);
	}

	/***
	 * 克隆并添加到拆分列表中
	 * 
	 * @param list
	 * @param srvsplitorder
	 * @param dt_plan
	 * @throws BizException
	 */
	private void cloneAndAddToList(ArrayList<SrvSplitOrderDTO> list, SrvSplitOrderDTO srvsplitorder, FDateTime[] dt_plans) throws BizException {
		if (dt_plans == null)
			return;
		for (int i = 0; i < dt_plans.length; i++) {
			cloneAndAddToList(list, srvsplitorder, dt_plans[i]);
		}
	}

	/***
	 * 克隆并添加到拆分列表中
	 * 
	 * @param list
	 * @param srvsplitorder
	 * @param dt_plan
	 * @throws BizException
	 */
	private void cloneAndAddToList(ArrayList<SrvSplitOrderDTO> list, SrvSplitOrderDTO srvsplitorder, FDateTime[] dt_plans, OrdSrvDoseDO[] dosedos) throws BizException {
		if (dt_plans == null)
			return;

		// 针对变动用药，但是没有录入不规则用量的数据 ly 2016/07/29
		if (ArrayUtil.isEmpty(dosedos) || dosedos.length != dt_plans.length) {
			for (int i = 0; i < dt_plans.length; i++) {
				cloneAndAddToList(list, srvsplitorder, dt_plans[i]);
			}
			return;
		}

		for (int i = 0; i < dt_plans.length; i++) {
			cloneAndAddToList(list, srvsplitorder, dt_plans[i], dosedos[i]);
		}
	}

	/****
	 * 克隆并增加到拆分列表中
	 * 
	 * @param list
	 * @param srvsplitorder
	 * @param dt_mp_plan
	 * @param dosedo
	 * @throws BizException
	 */
	private void cloneAndAddToList(ArrayList<SrvSplitOrderDTO> list, SrvSplitOrderDTO srvsplitorder, FDateTime dt_mp_plan, OrdSrvDoseDO dosedo) throws BizException {
		SrvSplitOrderDTO nsrvsplitorder = clone(srvsplitorder);
		nsrvsplitorder.setId_medu(dosedo.getId_unit_dose());
		nsrvsplitorder.setQuan_medu(dosedo.getQuan_dose());
		nsrvsplitorder.setDt_mp_plan(dt_mp_plan);
		if (OrSrvSplitUtil.isTrue(nsrvsplitorder.getFg_mm())) {
			int[] numden = OrSrvSplitUtil.getNumDen(dosedo.getQuan_dose(), nsrvsplitorder.getFactor_mb());
			nsrvsplitorder.setQuan_num_base(numden[0]);
			nsrvsplitorder.setQuan_den_base(numden[1]);
		}
		list.add(nsrvsplitorder);
	}

	/***
	 * 客隆算法
	 * 
	 * @param orsplitorder
	 * @return
	 * @throws BizException
	 */
	private SrvSplitOrderDTO clone(SrvSplitOrderDTO srvsplitorder) throws BizException {
		SrvSplitOrderCloneBP bp = new SrvSplitOrderCloneBP();
		return bp.exec(srvsplitorder);
	}

	/***
	 * 获得医嘱频次时刻DO集合数据
	 * 
	 * @param id_freq
	 * @param freqHt
	 * @return
	 * @throws BizException
	 */
	private FreqTimeDO[] getFreqTimeDOs(String id_freq, Hashtable freqHt) throws BizException {
		GetFreqTimeDOsBP bp = new GetFreqTimeDOsBP();
		return bp.exec(id_freq, freqHt);
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
		} else if (OrSrvSplitUtil.isPeriodWeekFreq(sd_frequnit)) { // 周处理逻辑
																	// 业务上只支持1周N次的数据
			dts = OrSrvSplitUtil.getDateArrayByWeek(validSE[0], validSE[1], freqtimedos);
		} else if (OrSrvSplitUtil.isPeriodMonthFreq(sd_frequnit)) { // 月的处理逻辑
																	// 业务上只支持1月N次的数据
																	// 月末倒数第一天
																	// 1、2、3、4.。。。、-3-2、-1
			dts = OrSrvSplitUtil.getDateArrayByMonth(validSE[0], validSE[1], freqtimedos);
		}
		return dts;
	}

	/***
	 * 计划频次的处理
	 * 
	 * @param list
	 * @param srvsplitorder
	 * @param dtSE
	 * @throws BizException
	 */
	private void planFreqHandle(ArrayList<SrvSplitOrderDTO> list, SrvSplitOrderDTO srvsplitorder, FDateTime[] dtSE) throws BizException {
		// 获得变动剂量信息数组
		OrdSrvDoseDO[] plandos = OrSrvSplitUtil.getOrdSrvDoseDOs(srvsplitorder.getId_orsrv());
		if (plandos == null || plandos.length == 0)
			return;
		FDateTime[] dt = null;
		for (int i = 0; i < plandos.length; i++) {
			dt = OrSrvSplitUtil.getValidDateArray(dtSE, new FDateTime[] { plandos[i].getDt_freq() });
			if (dt == null || dt.length == 0)
				continue;
			cloneAndAddToList(list, srvsplitorder, dt[0], plandos[i]);
		}
	}
}
