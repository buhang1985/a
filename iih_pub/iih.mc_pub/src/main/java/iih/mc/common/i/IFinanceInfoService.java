package iih.mc.common.i;

import iih.mm.comm.finance.d.FinancePeriodDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDate;
import xap.sys.bdfw.bbd.d.AccPeriodMonthDO;

public interface IFinanceInfoService {
	
	//财务年
	public static final String PERIOD_YEAR = "1";
	//财务月
	public static final String PERIOD_MONTH = "2";
	
	/**
	 * 获取财务年或者财务月期间信息。
	 * @param periodType 财务期间类型。 PERIOD_YEAR:财务年  PERIOD_MONTH:财务月 
	 * @param date  指定日期(如果为空，默认使用系统当前日期) 
	 * @return
	 * @throws BizException
	 */
	public FinancePeriodDTO getFinancePeriod(String periodType, FDate date) throws BizException;
	
	/**
	 * 获取仓库状态为[已开账]的财务月期间信息(仓库当前会计年月)。
	 * @param whId 仓库ID
	 * @return 财务月期间信息
	 * @throws BizException
	 */
	public FinancePeriodDTO getWhCurrentFinancePeriod(String whId) throws BizException;
	
	/**
	 * 检查仓库在指定财务月份是否允许进行单据处理。
	 * @param whId 仓库ID
	 * @param yearMonth 财务月份
	 * @throws BizException
	 */
	public void checkAccStatus(String whId, String yearMonth) throws BizException;
	
	/**
	 * 获取指定会计期间月份的下一会计期间月份(当前月份是本年度的最后一个月份、可能会跨年度)。
	 * @param id_accperiodmonth 会计期间月份ID
	 * @throws BizException
	 */
	public AccPeriodMonthDO[] getNextAccperMonth(String id_accperiodmonth) throws BizException;
	
	/**
	 * 获取指定会计期间月份的上一会计期间月份(当前月份是本年度的第一个月份、可能会跨年度)。
	 * @param id_accperiodmonth 会计期间月份ID
	 * @throws BizException
	 */
	public AccPeriodMonthDO getPreAccperMonth(String id_accperiodmonth) throws BizException;
}
