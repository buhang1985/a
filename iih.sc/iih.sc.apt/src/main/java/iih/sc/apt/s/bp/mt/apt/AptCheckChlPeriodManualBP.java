package iih.sc.apt.s.bp.mt.apt;

import iih.sc.apt.s.ep.OralAptEP;
import iih.sc.comm.CalculateMaxAptDaysUtils;
import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScValidator;
import iih.sc.scbd.schedulechl.d.EuEndtimeUnit;
import iih.sc.scbd.schedulechl.d.ScChlPeriodDO;
import iih.sc.scbd.schedulechl.i.IScChlPeriodDORService;
import iih.sc.sch.scsch.d.ScSchDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 检查当前排班在渠道期间内是否可预约BP
 * 
 * @author zhengcm
 * @date 2017-08-29 09:19:03
 *
 */
public class AptCheckChlPeriodManualBP {

	/**
	 * 检查当前排班在渠道期间内是否可预约
	 *
	 * @author zhengcm
	 * 
	 * @param id_scchl 排班渠道ID
	 * @param id_sch 排班ID
	 * @param sd_sctp 排班类型编码
	 * @throws BizException
	 */
	public void exec(String id_scchl, String id_sch, String sd_sctp) throws BizException {
		// 参数检查
		ScValidator.validateParam("id_scchl", id_scchl);
		ScValidator.validateParam("id_sch", id_sch);
		ScValidator.validateParam("sd_sctp", sd_sctp);

		// 当前排班类型的渠道期间
		ScChlPeriodDO periodDO = this.getChlPeriod(id_scchl, sd_sctp);

		// 当前排班
		ScSchDO schDO = new OralAptEP().getSch(id_sch);

		// 检查
		this.check(periodDO, schDO);
	}

	/**
	 * 检查
	 *
	 * @author zhengcm
	 * 
	 * @param periodDO 渠道期间DO
	 * @param schDO 排班DO
	 * @throws BizException
	 */
	private void check(ScChlPeriodDO periodDO, ScSchDO schDO) throws BizException {
		if (null == periodDO || null == schDO) {
			return;
		}
		// 提前关闭时间或提前关闭时间单位为空时不检查
		if (null == periodDO.getEnd_time_val() || null == periodDO.getEu_end_time_unit()) {
			return;
		}
		int closeVal = periodDO.getEnd_time_val();// 提前关闭时间
		int closeUnit = periodDO.getEu_end_time_unit();// 提前关闭时间单位
		// 提前关闭时间为0天时不检查
		if (closeVal == 0 && closeUnit == EuEndtimeUnit.DAY) {
			return;
		}
		FDateTime nowDateTime = ScAppUtils.getServerDateTime();// 可预约的开始日期
		FTime t_b_acpt = schDO.getT_b_acpt();// 排班开始就诊时间
		FTime t_e_acpt = schDO.getT_e_acpt();// 排班结束就诊时间
		FDate endDate = CalculateMaxAptDaysUtils.calculate(periodDO);// 可预约的结束日期
		// 计算当前可预约开始时间点:当前时间+提前关闭时间
		FDateTime dt_begin = this.calculateDateTime(nowDateTime, closeVal, closeUnit);
		FDate beginDate = dt_begin.getBeginDate();// 开始预约日期
		FTime beginTime = new FTime(dt_begin.getTime());// 开始预约时间点
		FDate d_sch = schDO.getD_sch();// 排班日期
		boolean isCanApt = true;// 是否可预约标识
		if (!(nowDateTime.getBeginDate().toString().compareTo(beginDate.toString()) <= 0 && endDate.toString()
				.compareTo(beginDate.toString()) >= 0)) {// 判断开始可预约日期时间点是否在渠道最大可预约范围内
			isCanApt = false;
		} else if (d_sch.toString().compareTo(beginDate.toString()) < 0) {// 预约日期比开始可预约的开始日期小
			isCanApt = false;
		} else if (d_sch.toString().compareTo(beginDate.toString()) == 0) {// 预约日期与可预约的开始日期相同，比较排班时间与开始预约时间点
			if (!((t_b_acpt.compareTo(beginTime) <= 0 && t_e_acpt.compareTo(beginTime) >= 0) || (t_b_acpt
					.compareTo(beginTime) >= 0 && t_e_acpt.compareTo(beginTime) >= 0))) {
				isCanApt = false;
			}
		}
		if (!isCanApt) {
			throw new BizException(IScMsgConst.SC_APT_PERIOD_CANNOT);
		}
	}

	/**
	 * 获取当前渠道期间
	 *
	 * @author zhengcm
	 * 
	 * @param id_scchl 排班渠道ID
	 * @param sd_sctp 排班类型编码
	 * @return 渠道期间DO
	 * @throws BizException
	 */
	private ScChlPeriodDO getChlPeriod(String id_scchl, String sd_sctp) throws BizException {
		String cond = String.format("id_scchl = '%s' and sd_sctp = '%s'", id_scchl, sd_sctp);
		IScChlPeriodDORService qryService = ServiceFinder.find(IScChlPeriodDORService.class);
		ScChlPeriodDO[] periodDOs = qryService.find(cond, null, FBoolean.FALSE);
		if (ArrayUtil.isEmpty(periodDOs)) {
			return null;
		}
		return periodDOs[0];
	}

	/**
	 * 根据提前关闭时间计算开始预约的时间点
	 *
	 * @author zhengcm
	 * 
	 * @param nowDateTime 当前日期时间
	 * @param closeVal 提前关闭时间
	 * @param closeUnit 提前关闭时间单位
	 * @return 可预约的日期时间点
	 * @throws BizException
	 */
	private FDateTime calculateDateTime(FDateTime nowDateTime, int closeVal, int closeUnit) throws BizException {
		FDateTime newDateTime = nowDateTime;
		if (closeUnit == EuEndtimeUnit.HOUR) {
			newDateTime = newDateTime.addSeconds(3600 * closeVal);
		} else if (closeUnit == EuEndtimeUnit.DAY) {
			if (closeVal > 0) {
				newDateTime = newDateTime.getDateTimeAfter(closeVal);
			} else if (closeVal < 0) {
				newDateTime = newDateTime.getDateTimeBefore(closeVal);
			}
		}
		return newDateTime;
	}

}
