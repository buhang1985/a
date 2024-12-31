package iih.ei.sc.i;

/**
 * SC对微信查询服务
 * @author yzh
 * @date 2019年09月25日 16:27:11
 */
public interface ISc4WeChatQryService {
	
	
	/**
	 * 根据渠道可预约时长和诊疗项目可以预约时间 获取申请单可以预约的时间范围
	 * @param requestXML
	 * @return
	 */
	public String getValidPeriod(String requestXML);
	/**
	 * 获取打印须知说明
	 * @param requestXML
	 * @return
	 */
	public String getAptRptNote(String requestXML);
	/**
	 * 微信患者是否可自助预约查询
	 * @param requestXML
	 * @return
	 */
	public String isSelfAptable(String requestXML);
	/**
	 * 微信患者是否可自助取消预约查询
	 * @param requestXML
	 * @return
	 */
	public String isSelfCancable(String requestXML);
	/**
	 * 获取患者全部未预约医技申请单
	 * @param requestXML
	 * @return
	 */
	public String getUnaptApply(String requestXML);
	/**
	 * 取检查申请可以预约的号位集合
	 * @param requestXML
	 * @return
	 */
	public String getScTicks4Apply(String requestXML);
	/**
	 * 获取患者的医技预约申请记录包括当天和当天之后的
	 * @param resuqetXML
	 * @return
	 */
	public String getAptApply(String requestXML); 
	/**
	 * 取患者已完成(可以传其他状态值查询特定状态数据)医技预约记录
	 * @param requestXML
	 * @return
	 */
	public String getPatAptListByStatus(String requestXML);
}
