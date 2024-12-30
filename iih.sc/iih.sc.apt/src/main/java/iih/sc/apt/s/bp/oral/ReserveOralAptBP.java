package iih.sc.apt.s.bp.oral;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.apt.s.ep.OralAptEP;
import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScSqlUtils;
import iih.sc.comm.ScValidator;
import iih.sc.pub.ScGroupControlUtils;
import iih.sc.scbd.schedulechl.d.SchedulechlDO;
import iih.sc.sch.scsch.d.ScSchChlDO;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.scsch.d.ScschAggDO;
import iih.sc.sch.sctick.d.EuUseState;
import iih.sc.sch.sctick.d.ScSchTickDO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;

/**
 * 口腔科预约占用BP(新需求：支持多个同时占用)
 * 
 * @author zhengcm
 * @date 2018-01-16 15:01:03
 *
 */
public class ReserveOralAptBP {

	/**
	 * 口腔科预约占用
	 *
	 * @param reserve_rsn 占用原因
	 * @param id_tick_arr 号位id数组
	 * @param note_reserve 备注
	 * @throws BizException
	 * @author zhengcm
	 */
	public void exec(String[] id_tick_arr, String reserve_rsn, String note_reserve) throws BizException {
		// 1、参数校验
		ScValidator.validateParam("id_tick_arr", id_tick_arr);

		// 2、占用号位
		this.batchReserveTick(id_tick_arr, reserve_rsn, note_reserve);
	}

	/**
	 * 占用排班号位
	 *
	 * @param id_tick_arr 排班号位id数组
	 * @param sd_reserve_rsn 占用原因
	 * @param note_reserve 备注
	 * @throws BizException
	 * @author zhengcm
	 */
	private void batchReserveTick(String[] id_tick_arr, String sd_reserve_rsn, String note_reserve) throws BizException {
		List<String> idList = Arrays.asList(id_tick_arr);
		OralAptEP oralAptEP = new OralAptEP();
		// 获取号位
		ScSchTickDO[] tickDOs = oralAptEP.getSchTickByWhereStr(ScSqlUtils.getInSqlByIds("id_tick", idList));
		if (ArrayUtil.isEmpty(tickDOs)) {
			return;
		}

		// 排班
		List<String> schIdList = new ArrayList<String>();
		for (ScSchTickDO tickDO : tickDOs) {
			if (!schIdList.contains(tickDO.getId_sch())) {
				schIdList.add(tickDO.getId_sch());
			}
		}
		if (ListUtil.isEmpty(schIdList)) {
			return;
		}
		ScschAggDO[] schAggDOs = oralAptEP.getSchAggDOs(ScSqlUtils.getInSqlByIds("id_sch", schIdList));
		if (ArrayUtil.isEmpty(schAggDOs)) {
			return;
		}
		Map<String, ScschAggDO> schMap = new HashMap<String, ScschAggDO>();
		for (ScschAggDO schAggDO : schAggDOs) {
			schMap.put(schAggDO.getParentDO().getId_sch(), schAggDO);
		}

		// 排班医院诊间(本科)渠道
		Map<String, ScSchChlDO> chlMap = this.getChlDO(schIdList);

		for (ScSchTickDO tickDO : tickDOs) {
			// 检查号位
			this.checkTick(tickDO);

			// 号位是否已经被占用
			boolean isReserved = false;
			if (tickDO.getEu_used() == EuUseState.HOLD) {
				isReserved = true;
			}
			// 获取排班
			ScschAggDO schAggDO = schMap.get(tickDO.getId_sch());

			// 校验排班
			if (null != schAggDO) {
				new CheckOralAptSchBP().check(schAggDO.getParentDO().getId_sch());
			}

			// 排班医院诊间（本科）渠道
			ScSchChlDO chlDO = chlMap.get(tickDO.getId_sch());

			tickDO.setStatus(DOStatus.UPDATED);
			if (StringUtil.isEmptyWithTrim(sd_reserve_rsn)) {// 不占用
				tickDO.setEu_used(EuUseState.WY);
				tickDO.setPolno_used(null);
				tickDO.setSd_reserve_rsn(null);
				tickDO.setNote_reserve(null);
				if (isReserved) {
					this.setSchInfo(schAggDO, chlDO, false);
				}
			} else {// 占用
				tickDO.setSd_reserve_rsn(sd_reserve_rsn);
				tickDO.setNote_reserve(note_reserve);
				tickDO.setEu_used(EuUseState.HOLD);
				tickDO.setPolno_used(chlDO.getScpolcn());
				if (!isReserved) {
					this.setSchInfo(schAggDO, chlDO, true);
				}
			}
		}
		// 更新号位
		new OralAptEP().batchSaveSchTick(tickDOs);
		// 更新排班
		List<ScSchDO> schDOList = new ArrayList<ScSchDO>();
		for (Map.Entry<String, ScschAggDO> entry : schMap.entrySet()) {
			schDOList.add(entry.getValue().getParentDO());
		}
		new OralAptEP().batchSaveSch(schDOList.toArray(new ScSchDO[0]));
	}

	/**
	 * 检查号位
	 * 
	 * @author zhengcm
	 * @date 2018-01-22 16:17:56
	 *
	 * @param tickDO
	 * @throws BizException
	 */
	private void checkTick(ScSchTickDO tickDO) throws BizException {
		// 校验号位是否可用
		if (null != tickDO.getFg_active() && !tickDO.getFg_active().booleanValue()) {
			throw new BizException("号位(" + tickDO.getT_b() + " - " + tickDO.getT_e() + ")不可用，请检查！");
		}
		// 校验号位是否已使用或占用者非空
		if (tickDO.getEu_used() == EuUseState.SY || !StringUtil.isEmptyWithTrim(tickDO.getId_tick_occupier())) {
			throw new BizException("号位(" + tickDO.getT_b() + " - " + tickDO.getT_e() + ")已使用，请检查！");
		}
	}

	/**
	 * 设置排班
	 *
	 * @param aggDO 排班AggDO
	 * @param chlDO 渠道DO
	 * @param isHold 是否已保留
	 * @throws BizException
	 * @author zhengcm
	 */
	private void setSchInfo(ScschAggDO aggDO, ScSchChlDO chlDO, boolean isHold) throws BizException {
		if (null == aggDO || null == chlDO) {
			return;
		}
		ScSchDO schDO = aggDO.getParentDO();
		schDO.setStatus(DOStatus.UPDATED);
		String quan_used = "Quan" + chlDO.getScpolcn() + "_used";
		if (isHold) {// 占用
			// 检查号源池剩余数量
			this.checkSchQuanCanUse(aggDO, chlDO.getId_scchl());
			schDO.setAttrVal(quan_used, (Integer) schDO.getAttrVal(quan_used) + 1);
			schDO.setQuan_total_used(schDO.getQuan_total_used() + 1);
		} else {// 不占用
			schDO.setAttrVal(quan_used, (Integer) schDO.getAttrVal(quan_used) - 1);
			schDO.setQuan_total_used(schDO.getQuan_total_used() - 1);
		}
	}

	/**
	 * 获取医院诊间（本科）渠道
	 *
	 * @param schIdList
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private Map<String, ScSchChlDO> getChlDO(List<String> schIdList) throws BizException {
		if (ListUtil.isEmpty(schIdList)) {
			return null;
		}
		// ※本处差异只存在于标准版
		String cond = ScSqlUtils.getInSqlByIds("id_sch", schIdList)
				+ String.format(" and id_scchl = (select id_scchl from sc_chl where code = '%s' and "
						+ ScGroupControlUtils.getGroupControlFitler(new SchedulechlDO(), "") + ")",
						IScDictCodeConst.SD_SCCHLTP_HOSPITAL_ROOM_DEPT);
		ScSchChlDO[] chlDOs = new OralAptEP().getSchChlByCond(cond, null);
		if (ArrayUtil.isEmpty(chlDOs)) {
			throw new BizException(IScMsgConst.SC_APT_ORAL_NOT_CHL);
		}
		Map<String, ScSchChlDO> chlMap = new HashMap<String, ScSchChlDO>();
		for (ScSchChlDO chlDO : chlDOs) {
			String key = chlDO.getId_sch();
			if (!chlMap.containsKey(key)) {
				chlMap.put(key, chlDO);
			}
		}
		return chlMap;
	}

	/**
	 * 检查号源池剩余数量
	 *
	 * @param aggDO
	 * @param id_scchl
	 * @throws BizException
	 * @author zhengcm
	 */
	private void checkSchQuanCanUse(ScschAggDO aggDO, String id_scchl) throws BizException {
		if (null == aggDO || StringUtil.isEmptyWithTrim(id_scchl)) {
			return;
		}
		OralAptEP oralAptEP = new OralAptEP();
		int quanCanUse = oralAptEP.calSchQuanCanUse(aggDO, id_scchl);
		if (quanCanUse <= 0) {
			throw new BizException(String.format(IScMsgConst.SC_APT_ORAL_QUAN_NUM, quanCanUse));
		}
	}

}
