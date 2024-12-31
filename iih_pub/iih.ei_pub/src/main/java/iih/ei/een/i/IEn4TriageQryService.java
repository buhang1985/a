package iih.ei.een.i;

/**
 * EN对外分诊查询服务
 * 
 * 
 * @author liubin
 * 
 * 上午9:42:29
 */
public interface IEn4TriageQryService {
	/**
	 * 取科室列表
	 * 
	 * @author liubin
	 * 
	 * @param requestXML
	 * @return
	 */
	public String getDepList(String requestXML);
	/**
	 * 获取员工用户列表
	 * 
	 * @author liubin
	 * 
	 * @param requestXML
	 * @return
	 */
	public String getEmpList(String requestXML);
	/**
	 * 取门诊有效的医生排班队列
	 * 
	 * @author liubin
	 * 
	 * @param requestXML
	 * @return
	 */
	public String getOpQueList(String requestXML);
	/**
	 * 根据患者刷卡取患者信息
	 * 
	 * @author liubin
	 * 
	 * @param requestXML
	 * @return
	 */
	public String getPatInfo(String requestXML);
}
