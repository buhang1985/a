package iih.sc.scbd.s.bp;

import iih.sc.comm.CalculateAptTimeIntervalDaysUtils;
import iih.sc.comm.IScMsgConst;
import iih.sc.scbd.schedulechl.d.ScChlPeriodDO;
import iih.sc.scbd.schedulechl.d.desc.ScChlPeriodDODesc;
import iih.sc.scbd.schedulechl.i.IScChlPeriodDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取渠道期间可预约日期段
 * 
 * @author yzh
 * @date 2019-10-23 10:56:30
 */
public class GetChlAptTimeIntervalDateBP {
	/**
	 * 获取渠道期间可预约日期段
	 * 
	 * @param chlId 渠道ID
	 * @param sctp 排班类型
	 * @return 预约日期集合 begin:开始日期 end:结束日期
	 * @throws BizException
	 */
	public FMap exec(String chlId, String sctp) throws BizException {
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
		FMap date = CalculateAptTimeIntervalDaysUtils.calculate(periodDO);
		return date;
	}

}
