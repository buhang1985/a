package iih.mm.mc.monthacc.i;

import iih.mm.mc.monthacc.d.MonthAccFlagDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDate;
import xap.sys.bdfw.bbd.d.AccPeriodMonthDO;

/**
 * 仓库月结功能节点的自定义服务接口。
 * @author wu.junhui
 *
 */
public interface IMonthAccService {
	
	/**
	 * 获取指定日期对应的会计期间年月信息
	 * @param curDt 日期（默认为当前系统日期）
	 */
	public AccPeriodMonthDO getAccPeriodMonth(FDate curDt) throws BizException;

	/**
	 * 查询仓库月结列表
	 * @param id_accperiodmonth 会计期间月份ID
	 * @return 仓库月结列表
	 * @throws BizException
	 */
	public MonthAccFlagDO[] getMonthAccFlagList(String id_accperiodmonth) throws BizException;
	
	/**
	 * 月结账
	 * @param mcstIds 仓库月结标志对象ID
	 * @return 仓库月结标志对象列表
	 * @throws BizException
	 */
	public void dealMonthAccount(String[] mcstIds) throws BizException;
	
	/**
	 * 取消月结账
	 * @param mcstIds 仓库月结标志对象ID
	 * @return 仓库月结标志对象列表
	 * @throws BizException
	 */
	public void cancelMonthAccount(String[] mcstIds) throws BizException;
	
	/**
	 * 获取仓库指定财务月的仓库月结信息。
	 * @param whId 仓库ID
	 * @param yearMonth 财务月
	 * @return 仓库月结信息
	 * @throws BizException
	 */
	public MonthAccFlagDO getMonthAccFlag(String whId, String yearMonth) throws BizException;
}
