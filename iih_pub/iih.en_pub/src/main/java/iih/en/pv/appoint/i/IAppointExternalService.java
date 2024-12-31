package iih.en.pv.appoint.i;

import javax.jws.WebParam;

import xap.mw.core.data.BizException;

/***
 * 
 * 对外接口-APP预约
 * @author zhangpp
 *
 */
public interface IAppointExternalService {

	/**
	 * 获取排班信息
	 * @param params
	 * @return
	 * @throws BizException
	 */
	String getSchList(String params) throws BizException;
	/**
	 * 获取渠道统计信息
	 * @param params
	 * @return
	 * @throws BizException
	 */
	String getChlSchStats(String params) throws BizException;
	/**
	 * 获取门诊停诊列表
	 * @param params
	 * @return
	 * @throws BizException
	 */
	String getOpStopSchList(String params) throws BizException;
	/**
	 * 获取患者预约明细
	 * @param params
	 * @return
	 * @throws BizException
	 */
	String getOpAptList(String params) throws BizException;
	/**
	 * 获取门诊患者爽约记录
	 * @param params
	 * @return
	 * @throws BizException
	 */
	String getBrokenAptList(String params) throws BizException;
	/**
	 * 获取患者候诊列表
	 * @param params
	 * @return
	 * @throws BizException
	 */
	String getWaitQue(String params) throws BizException;
	/**
	 * 获取患者挂号记录
	 * @param params
	 * @return
	 * @throws BizException
	 */
	String getPatOpAptList(String params) throws BizException;
	/**
	 * 获取患者挂号记录列表
	 * @param params
	 * @return
	 * @throws BizException
	 */
	String getPatOpEntList(String params) throws BizException;
	/**
	 * 获取患者挂号和记录(预约未取消，挂号包含取消)
	 * @param params
	 * @return
	 * @throws BizException
	 */
	String getPatOpAptAndEntList(String params) throws BizException;
	/**
	 * 获取代办人预约记录
	 * @param params
	 * @return
	 * @throws BizException
	 */
	String getOpAptListByAgentPatCode(String params) throws BizException;
	/**
	 * 获取预约详细信息
	 * @param params
	 * @return
	 * @throws BizException
	 */
	String getPaidAptDetail(String params) throws BizException;
	/**
	 * 通过预约code获取预约Id
	 * @param params
	 * @return
	 * @throws BizException
	 */
	String getAptIdByAptCode(String params) throws BizException;
	/**
	 * 获取本次就诊患者分类
	 * @param params
	 * @return
	 * @throws BizException
	 */
	String getEnPatCaInfo(String params) throws BizException;
	/**
	 * 获取排班对应的号位
	 * @param params
	 * @return
	 * @throws BizException
	 */
	String getSchTickInfo(String params) throws BizException;
	/**
	 * 获取患者就诊记录
	 * @param params
	 * @return
	 * @throws BizException
	 */
	String getEntListByPatcode(String params) throws BizException;
	/**
	 * 统计门急诊就诊人次
	 * @param params
	 * @return
	 * @throws BizException
	 */
	String getVisitTimesStat(String params) throws BizException;
	/**
	 * 门急诊出诊科室列表
	 * @return
	 * @throws BizException
	 */
	String getOEPDepList()throws BizException; 
	/**
	 * 门急诊医生出诊科室列表
	 * @return
	 * @throws BizException
	 */
	String getOEPEmpDepMatch() throws BizException; 
	/**
	 * 签到分诊
	 * @param params
	 * @return
	 * @throws BizException
	 */
	String makeEntArrive(String params) throws BizException;
	/**
	 * 取分诊台可分诊挂号记录
	 * @param params
	 * @return
	 * @throws BizException
	 */
	String getEntLisByQuebencode(String params) throws BizException;
	/**
	 * 预约
	 * @param params
	 * @return
	 * @throws BizException
	 */
	String makeApt(String params) throws BizException;
	/**
	 * 挂号划价
	 * @param params
	 * @return
	 * @throws BizException
	 */
	String regPricing(String params) throws BizException;
	/**
	 * 付费
	 * @param params
	 * @return
	 * @throws BizException
	 */
	String payForApt(String params) throws BizException;
	/**
	 * 预约并付费
	 * @param params
	 * @return
	 * @throws BizException
	 */
	String makeAptAndPay(String params) throws BizException;
	/**
	 * 取消预约并退费
	 * @param params
	 * @return
	 * @throws BizException
	 */
	String cancAptAndRefund(String params) throws BizException;
	/**
	 * 取消预约
	 * @param params
	 * @return
	 * @throws BizException
	 */
	String cancApt(String params) throws BizException;
	/**
	 * 已收费预约取号
	 * @param params
	 * @return
	 * @throws BizException
	 */
	String cfmPaidApt(String params) throws BizException;
	/**
	 * 获取就诊记录
	 * @param params
	 * @return
	 * @throws BizException
	 */
	String getEntListByDeptCode(String params) throws BizException;
	/**
	 * 根据站点信息获取医生候诊队列
	 * 
	 * @param requestXML
	 * @return
	 * @throws BizException
	 */
	String getWaitQueBySite(@WebParam(name = "requestXML") String requestXML) throws BizException;
}
