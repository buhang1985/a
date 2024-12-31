package iih.bl.cc.i;

/**
 * EBS同步服务
 * @author LIM 2017/7/4
 *
 */
public interface IBlCcDgEbsService {
	
	/**
	 * 合并老HIS数据并发送至ERP
	 */
	public abstract void combinOldHisDataToErp(String selectDate);
	
	/**
	 * 抓取某一天的数据并存至中间表
	 * @param selectDate
	 */
	public abstract void createMedAppliData(String selectDate);

	/**
	 * 按照类型抓取某一天的收入数据并存至中间表
	 * @param selectDate
	 */
	public abstract void stOutPatientAppDataBP(String bath_type,String selectDate);
	/**
	 * 抓取某一天的门诊收入数据数据并存至中间表
	 * @param selectDate
	 */
	public abstract void stCombinHisIncomeToErpBP(String selectDate);
}
