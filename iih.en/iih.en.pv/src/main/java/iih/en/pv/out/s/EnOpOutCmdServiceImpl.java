package iih.en.pv.out.s;


import iih.en.comm.ep.EnAccEP;
import iih.en.comm.ep.EnPeCmpyAccEP;
import iih.en.comm.ep.IpEP;
import iih.en.comm.ep.OpEP;
import iih.en.comm.ep.PvEP;
import iih.en.pv.dto.d.EntStateDTO;
import iih.en.pv.dto.d.SysPatDTO;
import iih.en.pv.entplan.d.EntHpDO;
import iih.en.pv.i.IEnOutCmdService;
import iih.en.pv.outpatient.dto.d.ArriveResultBean;
import iih.en.pv.outpatient.dto.d.EuDrawTickMod;
import iih.en.pv.outpatient.dto.d.OpRegPatDTO;
import iih.en.pv.outpatient.dto.d.PayInfoDTO;
import iih.en.pv.outpatient.dto.d.RegInfoDTO;
import iih.en.pv.outpatient.dto.d.ResultBean;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.s.bp.SetEntStateBP;
import iih.en.pv.s.bp.SyncEnPatInfoBP;
import iih.en.pv.s.bp.UpdateEntPriPatBP;
import iih.en.pv.s.bp.ip.BatchConsumeBP;
import iih.en.pv.s.bp.ip.IpRegHpCancelBP;
import iih.en.pv.s.bp.ip.UpdateEnAccDtEndBP;
import iih.en.pv.s.bp.op.AptCreateEntBP;
import iih.en.pv.s.bp.op.AptPricingBP;
import iih.en.pv.s.bp.op.AptSettleBP;
import iih.en.pv.s.bp.op.CancEntBP;
import iih.en.pv.s.bp.op.CancOpReg4CancSchBP;
import iih.en.pv.s.bp.op.CancOpRegBP;
import iih.en.pv.s.bp.op.CancOpRegByEntIdBP;
import iih.en.pv.s.bp.op.ChgAptEnPatBP;
import iih.en.pv.s.bp.op.DiagEndBP;
import iih.en.pv.s.bp.op.EnOpChgFgstBP;
import iih.en.pv.s.bp.op.EntChangePatCaBP;
import iih.en.pv.s.bp.op.JoinOpQueBP;
import iih.en.pv.s.bp.op.OpRegMutiBP;
import iih.en.pv.s.bp.op.RegPatAndOp4TLBP;
import iih.en.pv.s.bp.op.st.RefundByEntBP;
import iih.en.pv.s.bp.op.ws.CancApt4AppNewBP;
import iih.en.pv.s.bp.op.ws.CfmPaidAptNewBP;
import iih.en.pv.s.bp.op.ws.MakeAptNewBp;
import iih.en.pv.s.bp.op.ws.MakeEntArriveBP;
import iih.en.pv.s.bp.op.ws.PayForAptNewBP;
import iih.en.pv.s.bp.op.ws.Refund4AppNewBP;
import iih.en.pv.s.bp.op.ws.SendSmsMessageBP;
import iih.en.que.dto.d.MedTechAppDTO;
import iih.en.que.i.IEnQueCmdService;
import iih.en.que.i.IMtTriageService;
import iih.pi.reg.pat.d.PatDO;
import iih.sc.apt.dto.d.MakeAptDTO;
import iih.sc.apt.dto.d.OpAptDTO;
import iih.sc.apt.dto.d.RegResultDTO;

import java.util.Map;

import xap.mw.core.annotation.Service;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;


/**
 * 门诊对外命令服务
 * 
 * @author yank
 *
 */
@Service(serviceInterfaces = { IEnOutCmdService.class }, binding = Binding.JSONRPC)
public class EnOpOutCmdServiceImpl implements IEnOutCmdService {
	/**
	 * 住院医保取消登记
	 * 
	 * @param codeEnt
	 * @throws BizException
	 */
	@Override
	public void ipRegHpCancel(String codeEnt) throws BizException {
		IpRegHpCancelBP bp  = new IpRegHpCancelBP();
		bp.exec(codeEnt);
	}
	/**
	 * 预约创建就诊信息 包含：就诊信息，门诊信息，就诊医保信息,就诊队列信息
	 * 
	 * @param patDO 患者DO
	 * @param aptDTO 门诊预约信息
	 * @param isTakeAptNo 是否是预约取号
	 * @return 就诊id
	 * @throws BizException
	 */
	@Override
	public String aptCreateEnt(PatDO patDO, OpAptDTO aptDTO, FBoolean isTakeAptNo) throws BizException {
		AptCreateEntBP createEntBP = new AptCreateEntBP();
		return createEntBP.exec(patDO, aptDTO, isTakeAptNo);
	}

	/**
	 * 预约取消就转
	 * 
	 * @param entId 就诊id
	 * @throws BizException
	 */
	@Override
	public void aptCancelEnt(String entId) throws BizException {
		CancEntBP cancBP = new CancEntBP();
		cancBP.cancEnt(entId);
	}

	/**
	 * 取消就诊，退号
	 * 
	 * @param aptDTO
	 * @throws BizException
	 */
	@Override
	public void cancEnt(OpAptDTO aptDTO) throws BizException {
		CancOpRegBP cancRegBP = new CancOpRegBP();
		cancRegBP.exec(aptDTO.getId_ent(), aptDTO.getId_apt(), EuDrawTickMod.DRAWBACK, aptDTO.getSd_pttp());
	}

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
	@Override
	public String cancEnt4CancSch(String oldAptId, OpAptDTO aptDTO, RegInfoDTO regInfo) throws BizException {
		return new CancOpReg4CancSchBP().exec(oldAptId, aptDTO, regInfo);
	}

	/**
	 * 预约确认
	 * 
	 * @param aptDTO 预约DTO
	 * @return
	 * @throws BizException
	 */
	@Override
	public RegInfoDTO cfmApt(OpAptDTO aptDTO) throws BizException {
		return null;
	}

	/**
	 * 门诊预约结算
	 * 
	 * @param aptDTO 门诊预约
	 * @param payInfo 支付信息
	 * @return 结算id
	 * @throws BizException
	 */
	@Override
	public BaseDTO[] settleApt(OpAptDTO aptDTO, PayInfoDTO payInfo) throws BizException {
		AptSettleBP settleBP = new AptSettleBP();
		return settleBP.settleOpApt(aptDTO, payInfo);
	}

	/**
	 * 修改就诊的患者信息
	 * 
	 * @param aptDTO 预约信息
	 * @param patDO 患者信息
	 * @throws BizException
	 */
	@Override
	public String changeAptEnPat(OpAptDTO aptDTO, PatDO patDO) throws BizException {
		ChgAptEnPatBP chgBP = new ChgAptEnPatBP();
		return chgBP.changeAptEnPat(aptDTO, patDO);
	}

	/**
	 * 划价
	 * 
	 * @param aptDTO 预约信息
	 * @param fgAcc 只记账标志
	 * @param fgPrint 是否打印发票
	 * @return
	 * @throws BizException
	 * @author yank
	 */
	@Override
	public OpAptDTO pricing(OpAptDTO aptDTO, FBoolean fgAcc, FBoolean fgPrint) throws BizException {
		AptPricingBP pricingBP = new AptPricingBP();
		return pricingBP.exec(aptDTO, fgAcc, fgPrint);
	}

	/**
	 * 结算就诊
	 * 
	 * @param entId 就诊id
	 * @param cgId 结算id
	 * @param fgCg 是否已结算，否则只是记账
	 * @throws BizException
	 */
	@Override
	public void settleEnt(String entId, String cgId, FBoolean fgCg) throws BizException {
		OpEP opEP = new OpEP();
		opEP.updateToSettled(entId, cgId, fgCg);
	}

	/**
	 * 退费
	 * 
	 * @param entId 就诊ID
	 * @throws BizException
	 * @author yank
	 */
	@Override
	public void refund(String entId, String sd_pttp, FBoolean fgRealpay) throws BizException {
		RefundByEntBP refundBP = new RefundByEntBP();
		refundBP.exec(entId, sd_pttp, fgRealpay);
	}

	/**
	 * 退号
	 * 
	 * @param entId 就诊ID
	 * @throws BizException
	 * @author yank
	 */
	@Override
	public void cancOpReg4Bl(String entId) throws BizException {
		CancOpRegByEntIdBP cancOpReg = new CancOpRegByEntIdBP();
		cancOpReg.exec(entId);
	}
	
	/**
	 * 挂号
	 * 
	 * @param patId 患者信息id
	 * @param regInfos 挂号信息
	 * @param payInfoDTO 支付信息
	 * @return
	 * @throws BizException
	 */
	@Override
	public RegInfoDTO[] regOp(String patId, RegInfoDTO[] regInfos, PayInfoDTO payInfoDTO) throws BizException {
		OpRegMutiBP opRegBP = new OpRegMutiBP();
		return opRegBP.exec(patId, regInfos, payInfoDTO);
	}
	
	/**
	 * 挂号+有效开始时间
	 * 
	 * @param patId 患者信息id
	 * @param regInfos 挂号信息
	 * @param payInfoDTO 支付信息
	 * @return
	 * @throws BizException
	 */
	@Override
	public RegInfoDTO[] regOp2(String patId, RegInfoDTO[] regInfos, PayInfoDTO payInfoDTO,FDateTime dt_b) throws BizException {
		OpRegMutiBP opRegBP = new OpRegMutiBP();
		return opRegBP.exec2(patId, regInfos, payInfoDTO,dt_b);
	}

	/**
	 * 就诊消费
	 * 
	 * @param entId 就诊id
	 * @param money 金额
	 * @throws BizException
	 */
	@Override
	public void consume(String entId, FDouble money) throws BizException {
		EnAccEP enAccEP = new EnAccEP();
		enAccEP.consume(entId, money);
	}

	/**
	 * 批处理就诊消费就诊消费
	 * 
	 * @param consumeMap 消费map，KEY:就诊id， VALUE: 合计消费金额
	 * @throws BizException
	 * @author yank
	 */
	@Override
	public void batchConsume(Map<String, FDouble> consumeMap) throws BizException {
		BatchConsumeBP batchConsumeBP = new BatchConsumeBP();
		batchConsumeBP.exec(consumeMap);
	}

	/**
	 * 充值
	 * 
	 * @param entId 就诊id
	 * @param money 金额
	 * @throws BizException
	 */
	@Override
	public void recharge(String entId, FDouble money) throws BizException {
		EnAccEP enaccBP = new EnAccEP();
		enaccBP.recharge(entId, money);
	}

	/**
	 * 更新就诊账户最后时间
	 * 
	 * @param enAccId 就诊账户id
	 * @param endTime 记账结束时间
	 * @throws BizException
	 */
	@Override
	public void updateEnAccDtEnd(String enAccId, FDateTime endTime) throws BizException {
		UpdateEnAccDtEndBP updateAccBP = new UpdateEnAccDtEndBP();
		updateAccBP.exec(enAccId, endTime);
	}

	/**
	 * 更新门诊病情等级
	 * 
	 * @param entId 就诊id
	 * @param levelId 病情等级
	 * @param levelCode 病情等级编码
	 * @throws BizException
	 */
	@Override
	public void updateOpDiseLevel(String entId, String levelId, String levelCode) throws BizException {
		OpEP opEP = new OpEP();
		opEP.updateOpDiseLevel(entId, levelId, levelCode);
	}

	/**
	 * 设置就诊状况
	 * 
	 * @param entStateDTO 就诊状况DTO
	 * @throws BizException
	 */
	@Override
	public void setEntState(EntStateDTO entStateDTO) throws BizException {
		SetEntStateBP setBP = new SetEntStateBP();
		setBP.exec(entStateDTO);
	}

	/**
	 * 同步就诊的患者信息
	 * 
	 * @param sysPatDTO 患者dto
	 * @throws BizException
	 * @author renying
	 */
	@Override
	public void syncEnPatInfo(SysPatDTO sysPatDTO) throws BizException {
		SyncEnPatInfoBP sysBP = new SyncEnPatInfoBP();
		sysBP.exec(sysPatDTO);
	}

	/**
	 * 更新就诊价格分类
	 * 
	 * @param entId 就诊id
	 * @param priPatId 价格分类id
	 * @throws BizException
	 * @author yank
	 * @since 2016-07-19
	 */
	@Override
	public void updateEntPriPat(String entId, String priPatId) throws BizException {
		UpdateEntPriPatBP updatePriPatBP = new UpdateEntPriPatBP();
		updatePriPatBP.exec(entId, priPatId);
	}

	/**
	 * 更新初诊标志
	 * 
	 * @param entId 就诊ID
	 * @param fgFirst 是否初诊
	 * @throws BizException
	 * @author yank
	 */
	@Override
	public void updateOpFirstFlag(String entId, FBoolean fgFirst) throws BizException {
		OpEP opEP = new OpEP();
		opEP.updateOpFirstFlag(entId, fgFirst);
	}

	/**
	 * 诊毕
	 * 
	 * @param entId 就诊id
	 * @throws BizException
	 */
	@Override
	public void diagnoseFinish(String entId) throws BizException {
		DiagEndBP diagEndBP = new DiagEndBP();
		diagEndBP.exec(entId, null, null, FBoolean.FALSE);
	}

	/**
	 * 发送短信
	 * 
	 * @param mobiles 手机号码，多个逗号隔开
	 * @param message 消息
	 * @param sysId 系统ID
	 * @throws BizException
	 */
	@Override
	public void sendSmsMessage(String mobiles, String message, String sysId) throws BizException {
		SendSmsMessageBP sendMsgBP = new SendSmsMessageBP();
		sendMsgBP.exec(mobiles, message, sysId);
	}

	/**
	 * 更新在径标志
	 * 
	 * @param entId 就诊ID
	 * @param fgIncp 是否在径
	 * @throws BizException
	 * @author yank
	 */
	@Override
	public void updateIncpFlag(String entId, String status) throws BizException {
		IpEP ipEP = new IpEP();
		ipEP.updateIncpFlag(entId, status);
	}

	/**
	 * 更新归档标志
	 * 
	 * @param entId 就诊ID
	 * @param fgArchive 已归档标志
	 * @throws BizException
	 * @author yank
	 */
	@Override
	public void updateArchiveFlag(String entId, FBoolean fgArchive) throws BizException {
		PvEP pvEP = new PvEP();
		pvEP.updateArchiveFlag(entId, fgArchive);
	}
/**
	 * 患者注册加挂号
	 * 
	 * @param opRegPatDTO 患者信息
	 * @return
	 * @throws BizException 
	 */
	@Override
	public PatiVisitDO regPatAndOp(OpRegPatDTO opRegPatDTO) throws BizException {
		RegPatAndOp4TLBP bp = new RegPatAndOp4TLBP();
		return bp.exec(opRegPatDTO);
	}
	/**
	 * 门诊换号（BL结算时自费换医保调用）
	 * 
	 * @param entId 就诊id
	 * @param patCaIdOld 原患者分类
	 * @param priPatIdOld 原价格分类
	 * @param hpIdOld 原医保计划
	 * @param patCaIdNew 新患者分类
	 * @param priPatIdNew 新价格分类
	 * @param entHp 就诊医保计划
	 * @throws BizException
	 */
	@Override
	public void entChangePatCa(String entId, String patCaIdOld, String priPatIdOld, String hpIdOld, String patCaIdNew,
			String priPatIdNew, EntHpDO entHp) throws BizException {
		EntChangePatCaBP bp = new EntChangePatCaBP();
		bp.exec(entId, patCaIdOld, priPatIdOld, hpIdOld, patCaIdNew, priPatIdNew, entHp);
	}

	/**
	 * 创建队列DO
	 * 
	 * @throws BizException
	 */
	@Override
	public void creatEntQueDO(PatiVisitDO pvDO, RegInfoDTO regInfo) throws BizException {
		JoinOpQueBP enqueBP = new JoinOpQueBP();
		enqueBP.exec(pvDO, regInfo);
		return;
	}

	/**
	 * 更新outPatientDO
	 * 
	 * @param entId
	 * @param sdStatus
	 * @throws BizException
	 */
	@Override
	public void updateOutPatientDOStatus(String entId, String sdStatus) throws BizException {
		OpEP opep = new OpEP();
		opep.updateStatus(entId, sdStatus);
	}

	/**
	 * 更新ent结算标志
	 * 
	 * @author fanlq 2017年11月15日 下午2:52:57
	 * @param entId -就诊id
	 * @throws BizException
	 */
	@Override
	public void ubpdateFgst(String entId) throws BizException {
		PvEP pvep = new PvEP();
		pvep.ubpdateFgst(entId);
	}

	/**
	 * 更新ent结算标志
	 * 
	 * @author renying 2017年11月17日 下午16:16
	 * @param entId -就诊id
	 * @throws BizException
	 */
	@Override
	public void ubpdateFgstAfterSt(String id_st) throws BizException {
		EnOpChgFgstBP bp = new EnOpChgFgstBP();
		bp.exec(id_st);
	}

	/**
	 * 预约取号换患者之后更新ent表
	 * 
	 * @author fanlq 2017年11月17日
	 * @param patId - 换患者之后的患者id
	 * @param entId - 就诊id
	 * @throws BizException
	 */
	@Override
	public void updateEntAfterChangePat(String patId, String entId) throws BizException {
		PvEP pvep = new PvEP();
		pvep.updateAfterChangePat(patId, entId);
	}
		/**
	 * 团检账户充值
	 * 
	 * @param pecmpyId 团检记录id
	 * @param money 金额
	 * @throws BizException
	 * @author ly 2018/03/26
	 */
	@Override
	public void cmpyRecharge(String pecmpyId, FDouble money) throws BizException {
		EnPeCmpyAccEP ep = new EnPeCmpyAccEP();
		ep.recharge(pecmpyId, money);
	}
	
	/**
	 * 团检消费
	 * 
	 * @param pecmpyId 团检记录id
	 * @param money 金额
	 * @throws BizException
	 * @author ly 2018/03/26
	 */
	@Override
	public void cmpyConsume(String pecmpyId, FDouble money) throws BizException {
		EnPeCmpyAccEP ep = new EnPeCmpyAccEP();
		ep.consume(pecmpyId, money);
	}
	/**
	 * 门诊预约去取号
	 * @param aptId
	 * @param oprCode
	 * @return
	 * @throws BizException
	 */
	@Override
	public String cfmPaidApt(String aptId, String oprCode) throws BizException {
		CfmPaidAptNewBP bp = new CfmPaidAptNewBP();
		return bp.exec(aptId, oprCode);
	}
	/**
     * 门诊预约中心预约
     * @param aptId
     * @param money
     * @param opTimes
     * @param settleTimes
     * @param flag
     * @param oprCode
     * @return
     * @throws BizException
     */
	@Override
	public ResultBean cancAptAndRefund(String aptId, String money, Integer opTimes, Integer settleTimes, String flag,
			String oprCode) throws BizException {
		Refund4AppNewBP bp = new Refund4AppNewBP();
		return bp.exec(aptId, money, opTimes, settleTimes, flag, oprCode);
	}
	@Override
	public RegResultDTO makeAptNew(MakeAptDTO makeAptDTO)throws BizException {
		MakeAptNewBp bp = new MakeAptNewBp();
		return bp.exec(makeAptDTO);
	}
	
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
	@Override
	public ResultBean payForApt(String aptId, String patCode, String chlType, String orderNo, String accNo,
			String payType, String patCardNo, String parCardPwd, String money, String oprCode, String patHpTp,
			String hpPriceData,String patHpNO,String hpPatInfXml)
			throws BizException {
		PayForAptNewBP bp = new PayForAptNewBP();
		return bp.exec(aptId, patCode, chlType, orderNo, payType, accNo, patCardNo, parCardPwd, money, oprCode, patHpTp,hpPriceData,patHpNO,hpPatInfXml,"");
	}

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
	@Override
	public String cancApt(String aptId, String oprCode) throws BizException {
		CancApt4AppNewBP bp = new CancApt4AppNewBP();
		return bp.exec(aptId, oprCode);
	}
	/**
	 * 签到分诊
	 * @param patCode 患者编码
	 * @param opTimes 就诊次数
	 * @param queBenCode 分诊台编码
	 * @param dayslottp 午别
	 * @param oprCode 操作员
	 * @throws BizException
	 */
	@Override
	public ArriveResultBean makeEntArrive(String patCode,Integer opTimes,String queBenCode,String oprCode) 
			throws BizException{
		MakeEntArriveBP bp = new MakeEntArriveBP();
		return bp.exec(patCode, opTimes, queBenCode, oprCode);		
	}
	
	
	/**
	 * 取消分诊
	 * 
	 * @param entQueId 就诊队列ID
	 * @param manual 自动分诊下设为true
	 * @author liubin
	 */
	@Override
	public void cancelTriage(String entQueId, FBoolean manual) throws BizException {
		IEnQueCmdService cmdService =  ServiceFinder.find(IEnQueCmdService.class);
		cmdService.cancelTriage(entQueId, manual); 
	}
	
	
	/**
	 * 医技签到
	 * @param appDTO 申请单DTO
	 */
	@Override
	public MedTechAppDTO signInMt(MedTechAppDTO appDTO) throws BizException{		
		IMtTriageService service = ServiceFinder.find(IMtTriageService.class);
		return service.signIn(appDTO);
	}
}
