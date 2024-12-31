package iih.sc.apt.i;

import iih.sc.apt.dto.d.AptIpDTO;
import iih.sc.apt.dto.d.AptPayDTO;
import iih.sc.apt.dto.d.MakeAptDTO;
import iih.sc.apt.dto.d.MtResDTO;
import iih.sc.apt.dto.d.OpApt4SmsDTO;
import iih.sc.apt.dto.d.OpAptDTO;
import iih.sc.apt.dto.d.RegResultDTO;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.pub.ResultBean;
import iih.sc.scbd.log.d.ScLogRecDO;
import iih.sc.sch.reg.dto.d.RegResDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 预约对外服务
 * 
 * @author yank
 *
 */
public interface IScAptOutCmdService {
	/**
	 * 划价
	 * 
	 * @param aptDTO 预约信息
	 * @param fgAcc 只记账标志
	 * @param fgPrint 是否打印发票
	 * @return
	 * @throws BizException
	 */
	OpAptDTO pricing(OpAptDTO aptDTO, FBoolean fgAcc, FBoolean fgPrint) throws BizException;

	/**
	 * 诊间预约
	 * 
	 * @param aptDTO 预约DTO
	 * @param isAuth 授权预约
	 * @param isPrePay 是否预付费
	 * @param payDTO 支付DTO
	 * @throws BizException
	 */
	String aptInRoom(OpAptDTO aptDTO, FBoolean isAuth, FBoolean isPrePay, AptPayDTO payDTO) throws BizException;

	/**
	 * 预约结算
	 * 
	 * @param aptDTO 预约信息
	 * @param payDTO 支付信息
	 * @throws BizException
	 * @author yank
	 */
	void settleOpApt(OpAptDTO aptDTO, AptPayDTO payDTO) throws BizException;

	/**
	 * 预约挂号（对微信接口）
	 * 
	 * @param scsrvCode 号别编码
	 * @param doctorCode 医生编码
	 * @param requestDate 日期
	 * @param deptCode 科室编码
	 * @param dayslotType 午别编码，a或p
	 * @param chlType 渠道类型编码
	 * @param seqNo 渠道顺序号
	 * @param aptCode 预约码
	 * @param patCode 患者编码
	 * @param agentCode 挂号操作人编码
	 * @return true:预约成功;false:预约失败
	 * @author WJY
	 */
	public RegResultDTO aptForWechat(String scsrvCode, String doctorCode, String requestDate, String deptCode,
			String dayslotType, String chlType, Integer seqNo, String aptCode, String patCode, String agentCode)
			throws BizException;

	/**
	 * 取消预约
	 * 
	 * @param aptDTO 预约dto
	 * @throws BizException
	 */
	void cancOpApt(OpAptDTO aptDTO) throws BizException;

	/**
	 * 取消门诊预约
	 * 
	 * @param aptDTO 预约dto
	 * @throws BizException
	 */
	void cancOpAptInRoom(OpAptDTO aptDTO) throws BizException;

	/**
	 * 预约取号
	 * 
	 * @param patId 取号患者id
	 * @param aptDTO 预约信息
	 * @param payDTO 支付信息
	 * @throws BizException
	 */
	OpAptDTO takeApptNo(String patId, OpAptDTO aptDTO, AptPayDTO payDTO) throws BizException;

	/**
	 * 手机挂号付费（对微信）
	 * 
	 * @param patCode 患者编码
	 * @param patType 患者类型
	 * @param deptCode 科室编码
	 * @param doctorCode 医生编码
	 * @param regDate 挂号日期
	 * @param dayslotType 午别类型
	 * @param seqNo 顺序号
	 * @param orderNo 第三方订单号
	 * @param payType 支付方式（微信，支付宝等）
	 * @param accNo 账号
	 * @param money 金额
	 * @param oprCode 操作员编码
	 * @return
	 * @throws BizException
	 */
	public String payForApt(String patCode, String patType, String deptCode, String doctorCode, String regDate,
			String dayslotType, String seqNo, String orderNo, String payType, String accNo, String money, String oprCode)
			throws BizException;

	/**
	 * 为患者加号
	 * 
	 * @param patId 患者id
	 * @param regRes 排班资源
	 * @param fgPrePay 是否预付费
	 * @throws BizException
	 */
	String addTickAndApt(String patId, RegResDTO regRes, FBoolean fgPrePay) throws BizException;

	/**
	 * 保存住院预约申请单
	 * 
	 * @param aptIpDTO 住院预约DTO
	 * @return
	 * @throws BizException
	 */
	void saveAptIp(AptIpDTO aptIpDTO) throws BizException;

	/**
	 * 取消医技预约
	 * 
	 * @param id_apt 预约id
	 * @throws BizException
	 */
	void cancApptMt(String id_apt) throws BizException;

	/**
	 * 将预约设置为取消
	 * 
	 * @param aptId 预约id
	 * @throws BizException
	 */
	void setAptToCancle(String aptId) throws BizException;

	/**
	 * 短信通知
	 * 
	 * @param mobiles 手机号码，多个逗号隔开
	 * @param msgCode 消息编码，消息唯一标识
	 * @param apt4EmsDTO 门诊预约短信通知DTO
	 * @throws BizException
	 * @author yank
	 */
	String sendOpSmsMsg(String mobiles, String msgCode, OpApt4SmsDTO apt4EmsDTO) throws BizException;

	/**
	 * 向一组手机号发送短信
	 * 
	 * @param mobiles 一个或者多个手机号，用逗号分开
	 * @param msgCode 消息编码，消息唯一标识
	 * @param msg 消息内容
	 * @throws BizException
	 * @author yank
	 */
	ResultBean sendSmsMsg(String mobiles, String msgCode, String msg) throws BizException;

	/**
	 * 预约
	 * 
	 * @param patCode 患者编码
	 * @param aptCode 预约号
	 * @param chlType 渠道类型,取值如：手机APP:15,微信:16,桌建APP:17,支付窗:18,官网:19
	 * @param agentCode 代办人编码
	 * @param schId 排班ID
	 * @return
	 * @throws BizException
	 */
	public RegResultDTO aptForWechatNew(MakeAptDTO  makeAptDTO )throws BizException;

	/**
	 * 付费
	 * 
	 * @param aptId 预约ID
	 * @param patCode 患者编码
	 * @param chlType 渠道类型
	 * @param orderNo 订单号
	 * @param payType 1支付宝，2微信, 3预付费, 4银行卡 6-医保账户
	 * @param accNo 账号
	 * @param patCardNo 患者卡号(预付费时有值)
	 * @param parCardPwd 患者卡密码(预付费时有值)
	 * @param money 金额
	 * @param oprCode 操作员编码
	 * @param patHpTp 患者医保类型，(0普通， 1-医保持卡,2-医保不持卡)
	 * @return
	 * @throws BizException
	 */
	public String payForAptNew(String aptId, String patCode, String chlType, String orderNo, String payType,
			String accNo, String patCardNo, String parCardPwd, String money, String oprCode, String patHpTp,
			String hpPriceData, String patHpNO, String hpPatInfXml, String insurPriceDivideXml) throws BizException;
	
	public String payForAptNew2(String aptId, String patCode, String chlType, String orderNo, String payType,
			String accNo, String patCardNo, String parCardPwd, String money, String oprCode, String patHpTp,
			String hpPriceData, String patHpNO, String hpPatInfXml, String insurPriceDivideXml,String dt_st,String business_code,String fg_printInvoice) throws BizException;

	/**
	 * 对已收费预约取号
	 * 
	 * @param aptId
	 * @param oprCode
	 * @return
	 * @throws BizException
	 */
	public String takeApptNoForAptNew(String aptId, String oprCode) throws BizException;

	/**
	 * 更换预约患者
	 *
	 * @author zhengcm
	 * 
	 * @param id_apt 预约ID
	 * @param id_pat 患者ID
	 * @throws BizException
	 */
	public void changeAptPat(String id_apt, String id_pat) throws BizException;

	/**
	 * 设置预约状态
	 *
	 * @author zhengcm
	 * 
	 * @param id_apt 预约ID
	 * @param sd_status 预约状态编码
	 * @throws BizException
	 */
	public void setAptStatus(String id_apt, String sd_status) throws BizException;

	/**
	 * 预约取号换患者
	 * 
	 * @author fanlq 2017年11月3日 下午4:21:41
	 * @param oldPatId 更换患者之前的患者id
	 * @param newPatId 更换患者之后的患者id
	 * @param aptDTO 预约DTO
	 * @param payDTO 支付DTO
	 * @return
	 * @throws BizException
	 */
	OpAptDTO takeApptNo4ChangePat(OpAptDTO aptDTO, OpAptDTO oldOpAptDTO, AptPayDTO payDTO) throws BizException;

	/**
	 * 门诊停诊：改约时取消预约
	 * 
	 * @author zhengcm
	 * @date 2017-11-20 11:39:31
	 *
	 * @param oldAptId
	 * @param aptDTO
	 * @param operate_source 操作来源
	 * @throws BizException
	 */
	public void cancOpApt4CancSch(String oldAptId, OpAptDTO aptDTO, String operate_source) throws BizException;

	/**
	 * 门诊预约
	 * 
	 * @author zhengcm
	 * @date 2017-11-20 14:59:34
	 *
	 * @param mtResDTO
	 * @param patId
	 * @param operate_source 操作来源
	 * @return
	 * @throws BizException
	 */
	public MtResDTO saveOpApt(MtResDTO mtResDTO, String patId, String operate_source) throws BizException;

	/**
	 * 保存预约
	 * 
	 * @author zhengcm
	 * @date 2017-11-20 15:45:00
	 *
	 * @param aptDO
	 * @return
	 * @throws BizException
	 */
	public ScAptDO saveApt(ScAptDO aptDO) throws BizException;

	/***
	 * 就诊换号后保存日志
	 * 
	 * @author fanlq 2017年11月30日
	 * @param entId - 就诊id
	 * @param id_patca_old - 原患者分类
	 * @param id_patca_new - 新患者分类
	 * @param id_pripat_old - 原价格分类
	 * @param id_pripat_new - 新价格分类
	 * @param id_hp_old - 原医保id
	 * @param id_hp_new -新医保id
	 * @param id_emp_change - 修改人
	 * @return
	 * @throws BizException
	 */
	public ScLogRecDO saveLog4ChangeOp(String entId, String id_patca_old, String id_patca_new, String id_pripat_old,
			String id_pripat_new, String id_hp_old, String id_hp_new, String id_emp_change) throws BizException;
}
