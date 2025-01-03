package iih.en.pv.i;

import iih.en.pv.dto.d.EntStateDTO;
import iih.en.pv.dto.d.SysPatDTO;
import iih.en.pv.entplan.d.EntHpDO;
import iih.en.pv.outpatient.dto.d.ArriveResultBean;
import iih.en.pv.outpatient.dto.d.OpRegPatDTO;
import iih.en.pv.outpatient.dto.d.PayInfoDTO;
import iih.en.pv.outpatient.dto.d.RegInfoDTO;
import iih.en.pv.outpatient.dto.d.ResultBean;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.que.dto.d.MedTechAppDTO;
import iih.pi.reg.pat.d.PatDO;
import iih.sc.apt.dto.d.MakeAptDTO;
import iih.sc.apt.dto.d.OpAptDTO;
import iih.sc.apt.dto.d.RegResultDTO;

import java.util.Map;

import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;

/**
 * 就诊对外命令服务
 * 
 * @author yank
 *
 */
public interface IEnOutCmdService {
	/**
	 * 住院医保取消登记
	 * 
	 * @param codeEnt
	 * @throws BizException
	 */
	void ipRegHpCancel(String codeEnt) throws BizException;
	/**
	 * 预约创建就诊信息 包含：就诊信息，门诊信息，就诊医保信息,就诊队列信息
	 * 
	 * @param patDO
	 *            患者DO
	 * @param aptDTO
	 *            门诊预约信息
	 * @param isTakeAptNo
	 *            是否是预约取号
	 * @return 就诊id
	 * @throws BizException
	 * @author yank
	 */
	String aptCreateEnt(PatDO patDO, OpAptDTO aptDTO, FBoolean isTakeAptNo) throws BizException;

	/**
	 * 预约取消就转
	 * 
	 * @param entId
	 *            就诊id
	 * @throws BizException
	 * @author yank
	 */
	void aptCancelEnt(String entId) throws BizException;

	/**
	 * 取消就诊，退号
	 * 
	 * @param aptDTO
	 * @throws BizException
	 * @author yank
	 */
	void cancEnt(OpAptDTO aptDTO) throws BizException;

	/**
	 * 门诊排班停诊：改约和替诊时，取消就诊，退号
	 * 
	 * @author zhengcm
	 * @date 2017-11-20 13:38:26
	 *
	 * @param oldAptId
	 * @param aptDTO
	 * @param regInfo
	 * @throws BizException
	 */
	public String cancEnt4CancSch(String oldAptId, OpAptDTO aptDTO, RegInfoDTO regInfo) throws BizException;

	/**
	 * 预约确认
	 * 
	 * @param aptDTO
	 *            预约DTO
	 * @return
	 * @throws BizException
	 * @author yank
	 */
	RegInfoDTO cfmApt(OpAptDTO aptDTO) throws BizException;

	/**
	 * 门诊预约结算
	 * 
	 * @param aptDTO
	 *            门诊预约
	 * @param payInfo
	 *            支付信息
	 * @return 结算id
	 * @throws BizException
	 * @author yank
	 */
	BaseDTO[] settleApt(OpAptDTO aptDTO, PayInfoDTO payInfo) throws BizException;

	/**
	 * 修改就诊的患者信息
	 * 
	 * @param aptDTO
	 *            预约信息
	 * @param patDO
	 *            患者信息
	 * @throws BizException
	 * @author yank
	 */
	String changeAptEnPat(OpAptDTO aptDTO, PatDO patDO) throws BizException;

	/**
	 * 划价
	 * 
	 * @param aptDTO
	 *            预约信息
	 * @param fgAcc
	 *            只记账标志
	 * @param fgPrint
	 *            是否打印发票
	 * @return
	 * @throws BizException
	 * @author yank
	 */
	OpAptDTO pricing(OpAptDTO aptDTO, FBoolean fgAcc, FBoolean fgPrint) throws BizException;

	/**
	 * 结算就诊
	 * 
	 * @param entId
	 *            就诊id
	 * @param cgId
	 *            结算id
	 * @param fgCg
	 *            是否已结算，否则只是记账
	 * @throws BizException
	 * @author yank
	 */
	void settleEnt(String entId, String cgId, FBoolean fgCg) throws BizException;

	/**
	 * 退费
	 * 
	 * @param entId
	 *            就诊ID
	 * @throws BizException
	 * @author yank
	 */
	void refund(String entId, String sd_pttp, FBoolean fgRealpay) throws BizException;

	/**
	 * 退号 为费用提供
	 * 
	 * @param entId
	 *            就诊ID
	 * @throws BizException
	 * @author yank
	 */
	void cancOpReg4Bl(String entId) throws BizException;
	
	/**
	 * 挂号
	 * 
	 * @param patId
	 *            患者id
	 * @param regInfos
	 *            挂号信息
	 * @param payInfoDTO
	 *            支付信息
	 * @return
	 * @throws BizException
	 * @author yank
	 */
	RegInfoDTO[] regOp(String patId, RegInfoDTO[] regInfos, PayInfoDTO payInfoDTO) throws BizException;

	/**
	 * 挂号+有效开始时间
	 * 
	 * @param patId
	 *            患者id
	 * @param regInfos
	 *            挂号信息
	 * @param payInfoDTO
	 *            支付信息
	 * @return
	 * @throws BizException
	 * @author yank
	 */
	RegInfoDTO[] regOp2(String patId, RegInfoDTO[] regInfos, PayInfoDTO payInfoDTO,FDateTime dt_b) throws BizException;

	/**
	 * 就诊消费
	 * 
	 * @param entId
	 *            就诊id
	 * @param money
	 *            金额
	 * @throws BizException
	 * @author yank
	 */
	void consume(String entId, FDouble money) throws BizException;

	/**
	 * 批处理就诊消费
	 * 
	 * @param consumeMap
	 *            消费map，KEY: 就诊id， VALUE: 合计消费金额
	 * @throws BizException
	 * @author yank
	 */
	void batchConsume(Map<String, FDouble> consumeMap) throws BizException;

	/**
	 * 充值
	 * 
	 * @param entId
	 *            就诊id
	 * @param money
	 *            金额
	 * @throws BizException
	 * @author yank
	 */
	void recharge(String entId, FDouble money) throws BizException;

	/**
	 * 更新就诊账户最后时间
	 * 
	 * @param enAccId
	 *            就诊账户id
	 * @param endTime
	 * @throws BizException
	 * @author yank
	 */
	void updateEnAccDtEnd(String enAccId, FDateTime endTime) throws BizException;

	/**
	 * 更新门诊病情等级
	 * 
	 * @param entId
	 *            就诊id
	 * @param levelId
	 *            病情等级
	 * @param levelCode
	 *            病情等级编码
	 * @throws BizException
	 * @author yank
	 */
	void updateOpDiseLevel(String entId, String levelId, String levelCode) throws BizException;

	/**
	 * 设置就诊状况
	 * 
	 * @param entStateDTO
	 *            就诊状况DTO
	 * @throws BizException
	 * @author yank
	 */
	void setEntState(EntStateDTO entStateDTO) throws BizException;

	/**
	 * 同步就诊的患者信息
	 * 
	 * @param sysPatDTO
	 *            患者dto
	 * @throws BizException
	 * @author yank
	 */
	void syncEnPatInfo(SysPatDTO sysPatDTO) throws BizException;

	/**
	 * 更新就诊价格分类 为bl提供，那边也有日志记录
	 * 
	 * @param entId
	 *            就诊id
	 * @param priPatId
	 *            价格分类id
	 * @throws BizException
	 * @author yank
	 * @since 2016-07-19
	 */
	void updateEntPriPat(String entId, String priPatId) throws BizException;

	/**
	 * 更新初诊标志
	 * 
	 * @param entId
	 *            就诊ID
	 * @param fgFirst
	 *            是否初诊
	 * @throws BizException
	 * @author yank
	 */
	void updateOpFirstFlag(String entId, FBoolean fgFirst) throws BizException;

	/**
	 * 诊毕
	 * 
	 * @param entId
	 *            就诊id
	 * @throws BizException
	 */
	void diagnoseFinish(String entId) throws BizException;

	/**
	 * 发送短信
	 * 
	 * @param mobiles
	 *            手机号码，多个逗号隔开
	 * @param message
	 *            消息
	 * @param sysId
	 *            系统ID
	 * @throws BizException
	 */
	void sendSmsMessage(String mobiles, String message, String sysId) throws BizException;

	/**
	 * 更新在径标志
	 * 
	 * @param entId
	 *            就诊ID
	 * @param fgIncp
	 *            是否在径
	 * @throws BizException
	 * @author yank
	 */
	void updateIncpFlag(String entId, String status) throws BizException;

	/**
	 * 更新归档标志
	 * 
	 * @param entId
	 *            就诊ID
	 * @param fgArchive
	 *            已归档标志
	 * @throws BizException
	 * @author yank
	 */
	void updateArchiveFlag(String entId, FBoolean fgArchive) throws BizException;

	/**
	 * 患者注册加挂号
	 * 
	 * @param opRegPatDTO
	 *            患者信息
	 * @return
	 */
	PatiVisitDO regPatAndOp(OpRegPatDTO opRegPatDTO) throws BizException;

	/**
	 * 门诊换号（BL结算时自费换医保调用）
	 * 
	 * @param entId
	 *            就诊id
	 * @param patCaIdOld
	 *            原患者分类
	 * @param priPatIdOld
	 *            原价格分类
	 * @param hpIdOld
	 *            原医保计划
	 * @param patCaIdNew
	 *            新患者分类
	 * @param priPatIdNew
	 *            新价格分类
	 * @param entHp
	 *            就诊医保计划
	 * @throws BizException
	 */
	void entChangePatCa(String entId, String patCaIdOld, String priPatIdOld, String hpIdOld, String patCaIdNew,
			String priPatIdNew, EntHpDO entHp) throws BizException;

	/**
	 * 创建队列DO
	 * 
	 * @throws BizException
	 */
	void creatEntQueDO(PatiVisitDO pvDO, RegInfoDTO regInfo) throws BizException;

	/**
	 * 更新outPatientDO 的状态
	 * 
	 * @param entId
	 * @param sdStatus
	 * @throws BizException
	 */
	void updateOutPatientDOStatus(String entId, String sdStatus) throws BizException;

	/**
	 * 更新ent结算标志
	 * 
	 * @author fanlq 2017年11月15日 下午2:52:57
	 * @param entId
	 *            -就诊id
	 * @throws BizException
	 */
	void ubpdateFgst(String entId) throws BizException;

	/**
	 * 更新ent结算标志
	 * 
	 * @author renying 2017年11月17日 下午16:16
	 * @param entId
	 *            -就诊id
	 * @throws BizException
	 */
	void ubpdateFgstAfterSt(String id_st) throws BizException;

	/**
	 * 预约取号换患者之后更新ent表
	 * 
	 * @author fanlq 2017年11月17日
	 * @param patId
	 *            - 换患者之后的患者id
	 * @param entId
	 *            - 就诊id
	 * @throws BizException
	 */
	void updateEntAfterChangePat(String patId, String entId) throws BizException;
	/**
	 * 团检账户充值
	 * 
	 * @param pecmpyId 团检记录id
	 * @param money 金额
	 * @throws BizException
	 * @author ly 2018/03/26
	 */
	void cmpyRecharge(String pecmpyId, FDouble money) throws BizException;
	
	/**
	 * 团检消费
	 * 
	 * @param pecmpyId 团检记录id
	 * @param money 金额
	 * @throws BizException
	 * @author ly 2018/03/26
	 */
	void cmpyConsume(String pecmpyId, FDouble money) throws BizException;
	/**
	 * 门诊预约去取号
	 * 
	 * @param aptId
	 * @param oprCode
	 * @return
	 * @throws BizException
	 */
	String cfmPaidApt(String aptId, String oprCode) throws BizException;

	/**
	 * 门诊预约取消预约
	 * 
	 * @param aptId
	 * @param money
	 * @param opTimes
	 * @param settleTimes
	 * @param flag
	 * @param oprCode
	 * @return
	 * @throws BizException
	 */
	ResultBean cancAptAndRefund(String aptId, String money, Integer opTimes, Integer settleTimes, String flag,
			String oprCode) throws BizException;

	/**
	 * 预约门诊号
	 * 
	 * @param makeAptDTO
	 * @return
	 * @throws BizException
	 */
	RegResultDTO makeAptNew(MakeAptDTO makeAptDTO) throws BizException;

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
	public ResultBean payForApt(String aptId, String patCode, String chlType, String orderNo, String accNo,
			String payType, String patCardNo, String parCardPwd, String money, String oprCode, String patHpTp,
			String hpPriceData, String patHpNO, String hpPatInfXml) throws BizException;
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
	String cancApt(String aptId, String oprCode) throws BizException;
	/**
	 * 签到分诊
	 * @param patCode 患者编码
	 * @param opTimes 就诊次数
	 * @param queBenCode 分诊台编码
	 * @param dayslottp 午别
	 * @param oprCode 操作员
	 * @throws BizException
	 */
	ArriveResultBean makeEntArrive(String patCode,Integer opTimes,String queBenCode,String oprCode) 
			throws BizException;
	
	/**
	 * 取消分诊
	 * 
	 * @param entQueId 就诊队列ID
	 * @param manual 自动分诊下设为true
	 * @author liubin
	 */
	public void cancelTriage(String entQueId, FBoolean manual) throws BizException;
	

	/**
	 * 医技签到
	 * @param appDTO 申请单DTO
	 */
	public MedTechAppDTO signInMt(MedTechAppDTO appDTO) throws BizException;	
}
