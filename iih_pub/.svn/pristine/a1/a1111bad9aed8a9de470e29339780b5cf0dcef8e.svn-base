package iih.ei.sc.i;

/**
 * SC对外查询服务
 * @author yzh
 * @date 2018年10月25日 16:27:11
 */
public interface ISc4OutQryService {
	/**
	 * 取医技项目分类字典
	 * @param requestXML
	 * @return
	 */
	public String getMtScCa(String requestXML); 
	/**
	 * 取医技诊疗项目字典
	 * @param requestXML
	 * @return
	 */
	public String getMtScDbSrv(String requestXML); 
	
	/**
	 * 取患者医技预约记录
	 * @param requestXML
	 * @return
	 */
	public String getPatAptList(String requestXML);
	/**
	 * 根据预约ID获取患者医技预约记录
	 * @param requestXML
	 * @return
	 * @auther yaohl
	 * @date 2018年10月30日
	 */
	public String getPatAptByIdApt(String requestXML);
	/**
	 * 获取医技排班列表
	 * @param requestXML
	 * @return
	 */
	public String getSchList(String requestXML);
	/**
	 * 获取患者爽约记录
	 * @param requestXML
	 * @return
	 */
	public String getBrokenAptList(String requestXML);
	/**
	 * 获取医技停诊列表
	 * @param requestXML
	 * @return
	 */
	public String getStopSchList(String requestXML);
	/**
	 * 获取医技预约告知单
	 * @param requestXML
	 * @return
	 */
	public String getAptNoteRpt(String requestXML);
	
	/**
	 * 根据申请单号查询该申请单预约记录的照片url
	 * @param requestXML
	 * @return
	 */
	public String getAptPhotoUrl(String requestXML);
}
