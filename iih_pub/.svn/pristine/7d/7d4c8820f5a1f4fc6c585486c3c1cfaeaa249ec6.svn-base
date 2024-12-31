package iih.en.pv.out.i;

import javax.jws.WebMethod;
import javax.jws.WebParam;

import xap.mw.core.data.BizException;

/**
 * 为第三方提供住院接口
 * @author renying
 *
 */
public interface IEnIpExternal {
    /**
     * 查询病区或者科室的住院患者信息
     * 
     * 
     * @param requestXML
     * @return
     */
	@WebMethod
    public String GetIpInfoByDep(@WebParam(name = "requestXML")String requestXML);
    /**
     * 根据患者住院号 获取患者住院信息
     * 
     * @param requestXML
     * @return
     */
	@WebMethod
    public String GetIpInfoByIpCode(@WebParam(name = "requestXML")String requestXML);
    
    /**
     * 根据患者code 和住院次数 获取患者住院信息
     * @param requestXML
     * @return
     */
	@WebMethod
    public String GetIpInfoByPat(@WebParam(name = "requestXML")String requestXML);
	/**
	 * 查询病区或者科室的住院患者信息
	 * 
	 * @param requestXML
	 * @return
	 */
	public String GetIpInfoAllByDep(@WebParam(name = "requestXML")String requestXML);
	/**
	 * 根据患者编码和住院次数查询患者住院信息
	 * 
	 * @param requestXML
	 * @return
	 */
	public String GetIpInfoAllByPat(@WebParam(name = "requestXML")String requestXML);
	/**
	 * 根据住院号查询患者住院信息
	 * 
	 * @param requestXML
	 * @return
	 */
	public String GetIpInfoAllByIpCode(@WebParam(name = "requestXML")String requestXML);
	/**
	 * 根据就诊编码查询患者住院最新诊断信息
	 * 
	 * @param requestXML
	 * @return
	 */
	public String GetEntDi(@WebParam(name = "requestXML")String requestXML);
	/**
	 * 查询患者住院医保信息
	 * 
	 * @param requestXML
	 * @return
	 */
	public String GetEntHp(@WebParam(name = "requestXML")String requestXML);
	/**
	 * 查询住院患者状况信息信息
	 * 
	 * @param requestXML
	 * @return
	 */
	public String GetEntState(@WebParam(name = "requestXML")String requestXML);
	/**
	 * 查询患者住院转科记录
	 * 
	 * @param requestXML
	 * @return
	 */
	public String GetEntDepTrans(@WebParam(name = "requestXML")String requestXML);
	/**
	 * 查询患者住院床位过程记录信息
	 * 
	 * @param requestXML
	 * @return
	 */
	public String GetEntBed(@WebParam(name = "requestXML")String requestXML);
	/**
	 * 查询住院患者联系人
	 * 
	 * @param requestXML
	 * @return
	 */
	public String GetEntCont(@WebParam(name = "requestXML")String requestXML);
	/**
	 * 查询患者住院其他信息
	 * 
	 * @param requestXML
	 * @return
	 */
	public String GetEntMisc(@WebParam(name = "requestXML")String requestXML);
    /**
     * 获取床位列表
     * @param inputParam
     * @return
     */
	@WebMethod
    public String GetBedInfo(@WebParam(name = "requestXML")String requestXML);
    /**
     * 获取一段时间内的退院患者列表
     * @param inputParam
     * @return
     */
	@WebMethod
    public String GetCancIpInfos(@WebParam(name = "requestXML")String requestXML);
    /**
     * 获取入院许可证 zhangpp 2019.09.23
     * @param requestXML
     * @return
     */
    String getScAptByPat(@WebParam(name = "requestXML")String requestXML);
	/**
     * 查询患者能够(打印病案信息)的历次住院基本信息 - zhangpp
     * @param param
     * @return
     */
    String GetInpatientInfo(String param);
    /**
     * 修改打印次数并返回修改后的次数
     * @param inputParam
     * @return 
     */
	@WebMethod
    public String PrintIpWrist(@WebParam(name = "requestXML")String requestXML);
	/**
	 * 记录移动护理入科时间
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 * @author jizb
	 */
	@WebMethod
	public String recordIpAcptDt(@WebParam(name = "requestXML")String requestXML);
	/**
	 * 保存住院登记 zhangpp 2019.09.23
	 * @param requestXML
	 * @return
	 */
	String saveRegEntIp (@WebParam(name = "requestXML")String requestXML);
}
