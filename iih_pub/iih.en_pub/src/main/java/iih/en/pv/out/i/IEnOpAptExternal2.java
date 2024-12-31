package iih.en.pv.out.i;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import iih.en.pv.outpatient.dto.d.ArriveResultBean;
import iih.en.pv.outpatient.dto.d.BrokenAptDTO;
import iih.en.pv.outpatient.dto.d.ChlSchStatsDTO;
import iih.en.pv.outpatient.dto.d.EnPatCaInfoDTO;
import iih.en.pv.outpatient.dto.d.EntInfoDTO;
import iih.en.pv.outpatient.dto.d.OpAptDTO;
import iih.en.pv.outpatient.dto.d.OpEntListDTO;
import iih.en.pv.outpatient.dto.d.OpPatAptDTO;
import iih.en.pv.outpatient.dto.d.OpVisitTimesStatDTO;
import iih.en.pv.outpatient.dto.d.OpWaitQueDTO;
import iih.en.pv.outpatient.dto.d.PatEntInfoDTO;
import iih.en.pv.outpatient.dto.d.PayForAptDTO;
import iih.en.pv.outpatient.dto.d.ResultBean;
import iih.en.pv.outpatient.dto.d.SchInfoDTO;
import iih.en.pv.outpatient.dto.d.EntRegInfoDTO;
import iih.en.pv.outpatient.dto.d.SchTickInfoDTO;
import iih.sc.apt.dto.d.MakeAptDTO;
import iih.sc.apt.dto.d.RegResultDTO;
import iih.sc.sch.dto.d.DeptWithSchDTO;
import iih.sc.sch.dto.d.OpEmpDepDTO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAException;

/**
 * 为APP预约提供对外服务(含注解)
 * 
 * @author yankan
 *
 */
@WebService
public interface IEnOpAptExternal2 {
	/**
	 * 获取排班信息
	 * 
	 * @param deptCode  科室编码
	 * @param resName  资源名称(模糊匹配)
	 * @param beginDate
	 *            开始日期,格式：yyyy-MM-dd，如：2016-08-09
	 * @param endDate
	 *            结束日期,格式：yyyy-MM-dd，如：2016-08-09
	 * @param srvType
	 *            号别,01：普通号 02：专家号
	 * @param chlType
	 *            渠道类型,取值如：手机APP:15,微信:16,桌建APP:17,支付窗:18,官网:19
	 * @return
	 * @throws BizException
	 */
	@WebMethod
	SchInfoDTO[] getSchList(@WebParam(name="deptCode") String deptCode, @WebParam(name="resName") String resName, @WebParam(name="beginDate") String beginDate, @WebParam(name="endDate") String endDate, @WebParam(name="srvType") String srvType,
			@WebParam(name="chlType") String chlType) throws BizException;

	/**
	 * 获取渠道统计信息
	 * 
	 * @param deptCode
	 *            科室编码
	 * @param deptName
	 *            科室姓名（可模糊匹配）
	 * @param beginDate
	 *            开始日期,格式：yyyy-MM-dd，如：2016-08-09
	 * @param endDate
	 *            结束日期,格式：yyyy-MM-dd，如：2016-08-09
	 * @param srvType
	 *            号别,01：普通号 02：专家号
	 * @param chlType
	 *            渠道类型,取值如：手机APP:15,微信:16,桌建APP:17,支付窗:18,官网:19
	 * @return
	 * @throws BizException
	 */
	ChlSchStatsDTO[] getChlSchStats(@WebParam(name="deptCode") String deptCode, @WebParam(name="deptName") String deptName,@WebParam(name="beginDate")  String beginDate,@WebParam(name="endDate")  String endDate,@WebParam(name="srvType")  String srvType,
			@WebParam(name="chlType") String chlType) throws BizException;

	/**
	 * 获取门诊停诊排班信息
	 * 
	 * @param beginDate
	 *            开始日期,格式：yyyy-MM-dd，如：2016-08-09
	 * @param endDate
	 *            结束日期,格式：yyyy-MM-dd，如：2016-08-09
	 * @return
	 * @throws BizException
	 */
	SchInfoDTO[] getOpStopSchList(@WebParam(name="beginDate") String beginDate,@WebParam(name="endDate")  String endDate) throws BizException;

	/**
	 * 获取预约信息
	 * 
	 * @param beginDate
	 *            开始日期(非空),格式：yyyy-MM-dd，如：2016-08-09
	 * @param endDate
	 *            结束日期(非空),格式：yyyy-MM-dd，如：2016-08-09
	 * @param srvType
	 *            号别,01：普通号 02：专家号
	 * @param chlType
	 *            渠道类型,取值如：手机APP:15,微信:16,桌建APP:17,支付窗:18,官网:19
	 * @param status
	 *            状态,取值如： 预约:0，取号:1,退号:7,全部状态：空
	 * @param deptName
	 *            科室名称(模糊匹配)
	 * @param patName
	 *            患者名称(模糊匹配)
	 * @param patCode
	 *            患者编码(模糊匹配)
	 * @return
	 * @throws BizException
	 */
	OpAptDTO[] getOpAptList(@WebParam(name="beginDate") String beginDate,@WebParam(name="endDate") String endDate, @WebParam(name="srvType") String srvType, @WebParam(name="chlType") String chlType,@WebParam(name="status") String status,
			@WebParam(name="deptName") String deptName,@WebParam(name="patName") String patName,@WebParam(name="patCode")  String patCode) throws BizException;

	/**
	 * 获取患者爽约记录
	 * 
	 * @param patCode
	 *            患者编码
	 * @return
	 * @throws BizException
	 */
	BrokenAptDTO[] getBrokenAptList(@WebParam(name="patCode") String patCode) throws BizException;

	/**
	 * 获取候诊队列
	 * 
	 * @param patCode
	 *            患者编码
	 * @param opTimes
	 *            就诊次数
	 * @param deptCode
	 *            科室编码
	 * @return
	 * @throws BizException
	 */
	OpWaitQueDTO[] getWaitQue(@WebParam(name="patCode") String patCode,@WebParam(name="opTimes") Integer opTimes,@WebParam(name="deptCode") String deptCode) throws BizException;

	/**
	 * 获取患者挂号记录
	 * 
	 * @param patCode
	 *            患者编码
	 * @param beginDate
	 *            开始日期,格式：yyyy-MM-dd，如：2016-08-09
	 * @param endDate
	 *            结束日期,格式：yyyy-MM-dd，如：2016-08-09
	 * @return
	 * @throws BizException
	 */
	OpPatAptDTO[] getPatOpAptList(@WebParam(name="patCode") String patCode,@WebParam(name="beginDate") String beginDate,@WebParam(name="endDate") String endDate) throws BizException;

	/**
	 * 获取患者挂号记录列表
	 *
	 * @author zhengcm
	 * 
	 * @param patCode
	 *            患者编码
	 * @param beginDate
	 *            开始时间
	 * @param endDate
	 *            结束时间
	 * @return
	 * @throws BizException
	 */
	OpEntListDTO[] getPatOpEntList(@WebParam(name="patCode") String patCode,@WebParam(name="beginDate") String beginDate,@WebParam(name="endDate") String endDate) throws BizException;
	/**
	 * 获取患者预约和挂号记录列表(预约未取消，挂号包含取消)
	 *
	 * @author renying
	 * 
	 * @param patCode
	 *            患者编码
	 * @param beginDate
	 *            开始时间
	 * @param endDate
	 *            结束时间
	 * @return
	 * @throws BizException
	 */
	 OpPatAptDTO[] getPatOpAptAndEntList(@WebParam(name="patCode") String patCode,@WebParam(name="beginDate") String beginDate,@WebParam(name="endDate") String endDate,@WebParam(name="agentPatCode") String agentPatCode) throws BizException;
	/**
	 * 
	 * 获取代办人预约记录
	 * 
	 * @param agentPatCode
	 *            挂号操作人PID(代办人（非空）
	 * @param beginDate
	 *            开始日期(非空),格式：yyyy-MM-dd，如：2016-09-09
	 * @param endDate
	 *            结束日期(非空),格式：yyyy-MM-dd，如：2016-09-09
	 * @return
	 * @throws BizException
	 */
	OpPatAptDTO[] getOpAptListByAgentPatCode(@WebParam(name="agentPatCode") String agentPatCode,@WebParam(name="beginDate") String beginDate,@WebParam(name="endDate") String endDate) throws BizException;

	/**
	 * 获取预约详细信息
	 * 
	 * @param aptId
	 *            预约ID
	 * @return
	 * @throws BizException
	 */
	OpPatAptDTO getPaidAptDetail(@WebParam(name="aptId") String aptId) throws BizException;

	/**
	 * 预约
	 * 
	 * @param patCode
	 *            患者编码
	 * @param aptCode
	 *            预约号
	 * @param chlType
	 *            渠道类型,取值如：手机APP:15,微信:16,桌建APP:17,支付窗:18,官网:19
	 * @param agentCode
	 *            代办人编码
	 * @param schId
	 *            排班ID
	 * @return
	 * @throws BizException
	 */
	public RegResultDTO makeApt(@WebParam(name="patCode") String patCode,@WebParam(name="aptCode") String aptCode,@WebParam(name="chlType") String chlType,@WebParam(name="agentCode") String agentCode,@WebParam(name="schId") String schId)
			throws BizException ;

	/**
	 * 付费
	 * 
	 * @param aptId
	 *            预约ID
	 * @param patCode
	 *            患者编码
	 * @param chlType
	 *            渠道类型
	 * @param orderNo
	 *            订单号
	 * @param payType
	 *            1支付宝，2微信, 3预付费, 4银行卡 6-医保账户
	 * @param accNo
	 *            账号
	 * @param patCardNo
	 *            患者卡号(预付费时有值)
	 * @param parCardPwd
	 *            患者卡密码(预付费时有值)
	 * @param money
	 *            金额
	 * @param oprCode
	 *            操作员编码
	 * @param patHpTp
	 *            患者医保类型，(0普通， 1-医保持卡,2-医保不持卡)
	 * @return
	 * @throws BizException
	 */
	ResultBean payForApt(@WebParam(name="aptId") String aptId,@WebParam(name="patCode") String patCode,@WebParam(name="chlType") String chlType,@WebParam(name="orderNo") String orderNo,@WebParam(name="accNo") String accNo,@WebParam(name="payType") String payType,
			@WebParam(name="patCardNo") String patCardNo,@WebParam(name="parCardPwd") String parCardPwd,@WebParam(name="money") String money,@WebParam(name="oprCode") String oprCode,@WebParam(name="patHpTp") String patHpTp,@WebParam(name="hpPriceData") String hpPriceData,@WebParam(name="patHpNO") String patHpNO,@WebParam(name="hpPatInfXml") String hpPatInfXml) throws BizException;

	/**
	 * 取消预约并退费
	 * 
	 * @param aptId
	 *            预约编码
	 * @param money
	 *            金额
	 * @param opTimes
	 *            就诊次数
	 * @param settleTimes
	 *            结算次数
	 * @param flag
	 *            标志
	 * @param oprCode
	 *            操作员编码
	 * @return
	 * @throws BizException
	 */
	ResultBean cancAptAndRefund(@WebParam(name="aptId") String aptId,@WebParam(name="money") String money,@WebParam(name="opTimes") Integer opTimes,@WebParam(name="settleTimes") Integer settleTimes,@WebParam(name="flag") String flag,
			@WebParam(name="oprCode") String oprCode) throws BizException;

	/**
	 * 取消预约
	 * 
	 * @param aptId
	 *            预约ID
	 * @param oprCode
	 *            操作员编码
	 * @return
	 * @throws BizException
	 */
	String cancApt(@WebParam(name="aptId") String aptId,@WebParam(name="oprCode") String oprCode) throws BizException;

	/**
	 * 对已收费预约取号
	 * 
	 * @param aptId
	 * @param oprCode
	 * @return
	 * @throws BizException
	 */
	String cfmPaidApt(@WebParam(name="aptId") String aptId,@WebParam(name="oprCode") String oprCode) throws BizException;

	/**
	 * 获取排班id
	 * 
	 * @param deptCode
	 * @param resCode
	 * @param date
	 * @param ampm
	 * @param srvCode
	 * @return
	 * @throws BizException
	 */
	String getSchId(@WebParam(name="deptCode") String deptCode,@WebParam(name="resCode") String resCode,@WebParam(name="date") String date,@WebParam(name="ampm") String ampm,@WebParam(name="srvCode") String srvCode) throws BizException;

	/**
	 * 根据排班ID获取号位信息
	 * @param schIds  排班id 数组
	 * @param chlType 排班渠道,当为空时为所有渠道
	 * @param Ctrl1          预留1
	 * @param Ctrl2          预留2
	 * @param Ctrl3          预留3
	 * @param Ctrl4          预留4
	 * @param Ctrl5          预留5
	 * @return
	 * @throws BizException
	 */
    SchTickInfoDTO[] getSchTickInfo(@WebParam(name="schIds") String[] schIds,@WebParam(name="chlType") String chlType,@WebParam(name="Ctrl1") String Ctrl1,@WebParam(name="Ctrl2") String Ctrl2,@WebParam(name="Ctrl3") String Ctrl3,@WebParam(name="Ctrl4") String Ctrl4,@WebParam(name="Ctrl5") String Ctrl5) throws BizException;
    /**
     * 查询 时间段内 就诊记录
     * 根据开始时间 结束时间 查询 时间段内的记录
     * 也可以根据科室编码或就诊编码或就诊类型
     * 再精确查询
     * @param dtBegin  开始时间
     * @param dtEnd    结束时间
     * @param deptCode 科室编码  可空
     * @param encode   就诊编码  可空
     * @param entpCode 就诊类型  可空
     * @return
     * @throws DAException 
     */
    EntInfoDTO[] getEntListByDeptCode(@WebParam(name="dtBegin") String dtBegin,@WebParam(name="dtEnd") String dtEnd,@WebParam(name="deptCode") String deptCode,@WebParam(name="encode") String encode,@WebParam(name="entpCode") String entpCode) throws DAException;
    
    /**
	 * 通过预约码获取预约Id
	 * 
	 * @param aptCode
	 *            预约编码
	 * @return
	 * @throws BizException
	 */
	String getAptIdByAptCode(@WebParam(name="aptCode") String aptCode) throws BizException;

	/**
	 * 门急诊出诊科室列表
	 * 
	 * @return
	 */
	DeptWithSchDTO[] getOEPDepList() throws BizException;

	/**
	 * 门急诊医生出诊科室列表
	 * 
	 * @return
	 */
	OpEmpDepDTO[] getOPEmpDepMatch() throws BizException;

	/**
	 * 获取患者就诊记录
	 * 
	 * @param patCode
	 *            患者编码
	 * @param dtBegin
	 *            开始时间
	 * @param dtEnd
	 *            结束时间
	 * @param entpCode
	 *            就诊类型
	 * @return
	 * @throws BizException
	 */
	PatEntInfoDTO[] getEntListByPatcode(@WebParam(name="patCode") String patCode,@WebParam(name="dtBegin") String dtBegin,@WebParam(name="dtEnd") String dtEnd, @WebParam(name="entpCode") String entpCode)
			throws BizException;
	
	/**
	 * 签到分诊
	 * @param patCode 患者编码
	 * @param opTimes 就诊次数
	 * @param queBenCode 分诊台编码
	 * @param dayslottp 午别
	 * @param oprCode 操作员
	 * @throws BizException
	 */
	ArriveResultBean makeEntArrive(@WebParam(name="patCode") String patCode,@WebParam(name="opTimes") Integer opTimes,@WebParam(name="queBenCode") String queBenCode,@WebParam(name="oprCode") String oprCode) 
			throws BizException;
	/**
	 * 预约DTO
	 * @param makeAptDTO
	 * @return
	 * @throws BizException
	 */
	public RegResultDTO makeAptNew(MakeAptDTO makeAptDTO)throws BizException;
	/**
	 * 取患者分诊台可分诊挂号记录
	 * @param patCode
	 * @param queBenCode
	 * @param oprCode
	 * @return
	 */
	 EntRegInfoDTO[] getEntLisByQuebencode(@WebParam(name="patCode") String patCode,@WebParam(name="queBenCode") String queBenCode,@WebParam(name="oprCode") String oprCode) throws BizException ;
     /**
      * 收费 参数为DTO
      * @param payForAptDTO
      * @return
      * @throws BizException
      */
	 ResultBean payForAptNew(PayForAptDTO payForAptDTO) throws BizException;
	 /**
	  * 统计门急诊就诊人次
	  * 
	  * @param date
	 *         统计日期(非空),格式：yyyy-MM-dd，如：2016-09-09
	  * @return
	  * @throws BizException
	  */
	 OpVisitTimesStatDTO[] getVisitTimesStat(@WebParam(name="date") String date) throws BizException;
	 /**
	  * 获取本次就诊患者分类
	  * @param patCode
	  * @param opTimes
	  * @return
	  * @throws BizException
	  */
	 EnPatCaInfoDTO getEnPatCaInfo(@WebParam(name="patCode") String patCode,@WebParam(name="opTimes") Integer opTimes)throws BizException;
	 /**
	  * 根据站点信息获取医生候诊队列
	  * 
	  * @param siteCode 站点编码
	  * @param oprCode 操作员
	  * @return
	  * @throws BizException
	  */
	 OpWaitQueDTO[] getWaitQueBySite(@WebParam(name="siteCode") String siteCode, @WebParam(name="oprCode") String oprCode) throws BizException;

}
