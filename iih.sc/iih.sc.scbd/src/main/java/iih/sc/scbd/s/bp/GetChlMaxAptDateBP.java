package iih.sc.scbd.s.bp;

import iih.sc.comm.CalculateMaxAptDaysUtils;
import iih.sc.comm.IScMsgConst;
import iih.sc.scbd.schedulechl.d.ScChlPeriodDO;
import iih.sc.scbd.schedulechl.d.desc.ScChlPeriodDODesc;
import iih.sc.scbd.schedulechl.i.IScChlPeriodDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取渠道最大可预约日期
 * 
 * @author yank
 * @modifier zhengcm 补充计算节假日的逻辑
 */
public class GetChlMaxAptDateBP {
	/**
	 * 获取渠道最大可预约日期
	 * 
	 * @param chlId 渠道ID
	 * @param sctp 排班类型
	 * @return 预约日期
	 * @throws BizException
	 */
	public FDate exec(String chlId, String sctp) throws BizException {
		// 1、根据渠道和排班类型，获取渠道期间
		StringBuilder whereBuilder = new StringBuilder();
		whereBuilder.append(String.format("%s.ID_SCCHL='%s'", ScChlPeriodDODesc.TABLE_ALIAS_NAME, chlId));
		whereBuilder.append(String.format(" AND %s.SD_SCTP='%s'", ScChlPeriodDODesc.TABLE_ALIAS_NAME, sctp));
		IScChlPeriodDORService chlPeriodQryService = ServiceFinder.find(IScChlPeriodDORService.class);
		ScChlPeriodDO[] periodDOs = chlPeriodQryService.find(whereBuilder.toString(), null, FBoolean.TRUE);
		if (ArrayUtil.isEmpty(periodDOs)) {
			throw new BizException(IScMsgConst.SC_CHL_PERIOD_NOT_DEFINED);
		}
		ScChlPeriodDO periodDO = periodDOs[0];
		// 3、计算节假日，需根据工作日历，暂时那边未提供
		// periodDO.getFg_holiday_excl();
		// FDateTime avlApptTime = currentTime.getDateTimeAfter(days);
		// return avlApptTime.getDate();
		FDate date = CalculateMaxAptDaysUtils.calculate(periodDO);
		return date;
	}

}
