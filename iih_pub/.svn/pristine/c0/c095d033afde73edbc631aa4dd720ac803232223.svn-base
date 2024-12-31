package iih.mp.dg.i;

/**
 * EBS同步服务
 * @author Huan He 2017/5/19
 *
 */
public interface IMpDgEbsService {
	
	/**
	 * 合并老HIS数据并发送至ERP
	 */
	public abstract void CombinOldHisDataToErp(String selectDate);
	
	/**
	 * 抓取某一天的数据并存至中间表
	 * @param selectDate
	 */
	public abstract void CreateMedAppliData(String selectDate);

	/**
	 * 按照类型抓取某一天的收入数据并存至中间表
	 * @param selectDate
	 */
	public abstract void STOutPatientAppDataBP(String bath_type,String selectDate);
	/**
	 * 抓取某一天的门诊收入数据数据并存至中间表
	 * @param selectDate
	 */
	public abstract void STCombinHisIncomeToErpBP(String selectDate);
}
