package iih.ei.sc.i;

/**
 * SC对外查询服务
 *
 *
 * @author yzh
 *
 * @date 2018年10月25日 15:14:34
 */
public interface ISc4OutOperService {
	/**
	 * 医技预约(无申请单)
	 * @param requestXML
	 * @return
	 */
	public String makeAptNonOrd(String requestXML);

	/**
	 * 取消预约
	 * @param requestXML
	 * @return
	 */
	public String cancApt(String requestXML);

	/**
	 * 选号预约
	 * @param requestXML
	 * @return
	 */
	public String makeAptByApply(String requestXML);
	/**
	 * 改约
	 * @param requestXML
	 * @return
	 */
	public String changeApt(String requestXML);
}
