package iih.bl.pay.s.bp.util;

import iih.bd.base.utils.FDoubleUtils;
import iih.bd.base.utils.StringUtils;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.pp.incca.i.IBdInccaCodeConst;
import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.bl.comm.IBlConst;
import iih.bl.comm.util.BlFlowContextUtil;
import iih.bl.comm.util.BlUdidocIdSdConvertUtil;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.blpaypat.d.BookRtnDirectEnum;
import iih.bl.pay.blreservepat.d.BlReservePatDO;
import iih.bl.pay.dto.prepay.d.BlPrepayCDTO;
import iih.bl.pay.dto.prepay.d.BlPrepayRDTO;
import iih.bl.pay.dto.prepay.d.BlPrepaySTDTO;
import iih.bl.pay.dto.prepay.d.BlPrepayTDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.service.time.TimeService;
import xap.mw.core.service.time.impl.TimeServiceImpl;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 预交金数据组装类
 * @author ly 2018/07/23
 *
 */
public class PrepayAssembleUtil {

	/**
	 * 组装充值预交金数据
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	public static BlPrePayPatDO assembleChargeData(BlPrepayRDTO dto,String accType) throws BizException{
		
		BlPrePayPatDO prepayDO = new BlPrePayPatDO();
		prepayDO.setId_paypat(dto.getId_prepay_new());
		prepayDO.setId_grp(Context.get().getGroupId());
		prepayDO.setId_org(Context.get().getOrgId());
		prepayDO.setId_pat(dto.getId_pat());
		prepayDO.setId_ent(dto.getId_ent());
		//prepayDO.setId_pecmpy(dto.getId_pecmpy());
		//prepayDO.setId_cust(dto.getId_cust());
		
		if(IBlConst.PREPAY_OPACC.equals(accType)){
			prepayDO.setId_paytp(IBlDictCodeConst.ID_PAYTP_OPPREPAY);
			prepayDO.setSd_paytp(IBlDictCodeConst.SD_PAYTP_OPPREPAY);
			prepayDO.setId_enttp(IBdFcDictCodeConst.ID_CODE_ENTP_OP);
			prepayDO.setCode_enttp(IBdFcDictCodeConst.SD_CODE_ENTP_OP);
			prepayDO.setId_incca(IBdInccaCodeConst.ID_OUTPATIENT_DEPOSIT);
			prepayDO.setCode_incca(IBdInccaCodeConst.CODE_OUTPATIENT_DEPOSIT);
		}else if(IBlConst.PREPAY_ETACC.equals(accType)){
			prepayDO.setId_paytp(IBlDictCodeConst.ID_PAYTP_ETPREPAY);
			prepayDO.setSd_paytp(IBlDictCodeConst.SD_PAYTP_ETPREPAY);
			prepayDO.setId_enttp(IBdFcDictCodeConst.ID_CODE_ENTP_ET_OBS);
			prepayDO.setCode_enttp(IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS);
			prepayDO.setId_incca(IBdInccaCodeConst.ID_ET_INVOICE);
			prepayDO.setCode_incca(IBdInccaCodeConst.CODE_ET_INVOICE);
		}
		else if (IBlConst.PREPAY_IPACC.equals(accType)) {
			// 要区分住院账户中的住院预交金预预住院预交金
			IPativisitRService service = ServiceFinder.find(IPativisitRService.class);
			PatiVisitDO patiVisitDo = service.findById(dto.getId_ent());
			if (patiVisitDo != null) {
				if (IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(patiVisitDo.getCode_entp())) {
					prepayDO.setId_paytp(IBlDictCodeConst.ID_PAYTP_IPPREPAY);
					prepayDO.setSd_paytp(IBlDictCodeConst.SD_PAYTP_IPPREPAY);
					prepayDO.setId_enttp(IBdFcDictCodeConst.ID_CODE_ENTP_IP);
					prepayDO.setCode_enttp(IBdFcDictCodeConst.SD_CODE_ENTP_IP);
					prepayDO.setId_incca(IBdInccaCodeConst.ID_INHOS_DEPOSIT);
					prepayDO.setCode_incca(IBdInccaCodeConst.CODE_INHOS_DEPOSIT);
				} else if (IBdFcDictCodeConst.SD_CODE_ENTP_IP_PRE.equals(patiVisitDo.getCode_entp())) {
					prepayDO.setId_paytp(IBlDictCodeConst.ID_PAYTP_IPPREPAY);
					prepayDO.setSd_paytp(IBlDictCodeConst.SD_PAYTP_IPPREPAY);
					prepayDO.setId_enttp(IBdFcDictCodeConst.ID_CODE_ENTP_IP_PRE);
					prepayDO.setCode_enttp(IBdFcDictCodeConst.SD_CODE_ENTP_IP_PRE);
//					prepayDO.setId_incca(IBdInccaCodeConst.ID_PREINHOS_PREPAY);
//					prepayDO.setCode_incca(IBdInccaCodeConst.CODE_PREINHOS_PREPAY);
					//预住院押金用住院押金条
					prepayDO.setId_incca(IBdInccaCodeConst.ID_INHOS_DEPOSIT);
					prepayDO.setCode_incca(IBdInccaCodeConst.CODE_INHOS_DEPOSIT);
				}
			} else {
				throw new BizException("未查询到就诊数据，id_ent:" + dto.getId_ent());
			}
		}else{
			//团检
			prepayDO.setId_paytp(IBlDictCodeConst.ID_PAYTP_PECMPYPREPAY);
			prepayDO.setSd_paytp(IBlDictCodeConst.SD_PAYTP_PECMPYPREPAY);
			prepayDO.setId_enttp(IBdFcDictCodeConst.ID_CODE_ENTP_IP);
			prepayDO.setCode_enttp(IBdFcDictCodeConst.SD_CODE_ENTP_IP);
			prepayDO.setId_incca(IBdInccaCodeConst.ID_INHOS_DEPOSIT);
			prepayDO.setCode_incca(IBdInccaCodeConst.CODE_INHOS_DEPOSIT);
		}
		prepayDO.setTradeno(dto.getTradeno());
		prepayDO.setEu_direct(dto.getEu_direct());
		prepayDO.setAmt(dto.getAmt());
		prepayDO.setSd_pttp(dto.getSd_pttp());
		prepayDO.setId_pm(dto.getId_pm());
		prepayDO.setSd_pm(dto.getSd_pm());
		prepayDO.setId_bank(dto.getId_bank());
		prepayDO.setBankno(dto.getBankno());
		prepayDO.setPaymodenode(dto.getPaymodenode());
		prepayDO.setBankcardno(dto.getBankcardno());
		prepayDO.setDt_pay(BlFlowContextUtil.getNowTime());
		prepayDO.setId_org_pay(Context.get().getOrgId());
		prepayDO.setId_dep_pay(Context.get().getDeptId());
		//床旁结算模式要采用前台传入的id_emp_pay值		zhanghw
		prepayDO.setId_emp_pay(StringUtils.isNotEmpty(dto.getId_emp_pay())?dto.getId_emp_pay():Context.get().getStuffId());
		prepayDO.setFg_cc(FBoolean.FALSE);
		prepayDO.setFg_rep_return(FBoolean.FALSE);
		prepayDO.setFg_canc(FBoolean.FALSE);
		prepayDO.setNote(dto.getNote());
		prepayDO.setStatus(DOStatus.NEW);
		//zx 添加账户名称 2019年12月9日  0176464
		prepayDO.setAcc_name(dto.getAcc_name());
		//zx 2019年12月12日 增加手工退账标志 0178968
		prepayDO.setFg_refund_manual(FBoolean.FALSE);
		return prepayDO;
	}

	/**
	 * 组装准备金转入数据
	 * @param prepayTDto
	 * @param rpPrepayDO
	 * @param accType
	 * @return
	 * @throws BizException
	 */
	public static BlPrePayPatDO assembleByPrePrepay(BlPrepayTDTO prepayTDto,
			BlReservePatDO rpPrepayDO, String accType, String note) throws BizException {
		
		BlPrePayPatDO prepayDO = new BlPrePayPatDO();
		prepayDO.setId_grp(Context.get().getGroupId());
		prepayDO.setId_org(Context.get().getOrgId());
		prepayDO.setId_pat(prepayTDto.getId_pat());
		prepayDO.setId_ent(prepayTDto.getId_ent());
		//prepayDO.setId_pecmpy(dto.getId_pecmpy());转入暂无团检业务
		if(IBlConst.PREPAY_OPACC.equals(accType)){
			prepayDO.setId_paytp(IBlDictCodeConst.ID_PAYTP_OPPREPAYTRANSFERFROMIP);
			prepayDO.setSd_paytp(IBlDictCodeConst.SD_PAYTP_OPPREPAYTRANSFERFROMIP);
			prepayDO.setId_enttp(IBdFcDictCodeConst.ID_CODE_ENTP_OP);
			prepayDO.setCode_enttp(IBdFcDictCodeConst.SD_CODE_ENTP_OP);
			prepayDO.setId_incca(IBdInccaCodeConst.ID_OUTPATIENT_DEPOSIT);
			prepayDO.setCode_incca(IBdInccaCodeConst.CODE_OUTPATIENT_DEPOSIT);
		}else if(IBlConst.PREPAY_IPACC.equals(accType)){
			prepayDO.setId_paytp(IBlDictCodeConst.ID_PAYTP_IPPREPAYTRANSFER);
			prepayDO.setSd_paytp(IBlDictCodeConst.SD_PAYTP_IPPREPAYTRANSFER);
			prepayDO.setId_enttp(IBdFcDictCodeConst.ID_CODE_ENTP_IP);
			prepayDO.setCode_enttp(IBdFcDictCodeConst.SD_CODE_ENTP_IP);
			prepayDO.setId_incca(IBdInccaCodeConst.ID_INHOS_DEPOSIT);
			prepayDO.setCode_incca(IBdInccaCodeConst.CODE_INHOS_DEPOSIT);
		}
		prepayDO.setEu_direct(BookRtnDirectEnum.CHARGE);
		prepayDO.setAmt(rpPrepayDO.getAmt());
		prepayDO.setSd_pttp(prepayTDto.getSd_pttp());
		prepayDO.setId_pm(rpPrepayDO.getId_pm());
		prepayDO.setSd_pm(rpPrepayDO.getSd_pm());
		prepayDO.setId_bank(rpPrepayDO.getId_bank());
		prepayDO.setBankno(rpPrepayDO.getBankno());
		prepayDO.setPaymodenode(rpPrepayDO.getPaymodenode());
		prepayDO.setDt_pay(BlFlowContextUtil.getNowTime());
		prepayDO.setId_org_pay(Context.get().getOrgId());
		prepayDO.setId_dep_pay(Context.get().getDeptId());
		prepayDO.setId_emp_pay(Context.get().getStuffId());
		prepayDO.setFg_cc(FBoolean.TRUE);
		prepayDO.setFg_rep_return(FBoolean.FALSE);
		prepayDO.setFg_canc(FBoolean.FALSE);
		prepayDO.setNote(note);
		
		prepayDO.setStatus(DOStatus.NEW);
		return prepayDO;
	}
	
	/**
	 * 组装预交金转入数据
	 * @param prepayTDto
	 * @param accType
	 * @param amt
	 * @param note
	 * @return
	 * @throws BizException
	 */
	public static BlPrePayPatDO assembleWhenTransfer(BlPrepayTDTO prepayTDto,
			BlPrePayPatDO oldPrepayDO, String accType, FDouble amt, String note) throws BizException {
		
		BlPrePayPatDO prepayDO = new BlPrePayPatDO();
		prepayDO.setId_grp(Context.get().getGroupId());
		prepayDO.setId_org(Context.get().getOrgId());
		prepayDO.setId_pat(prepayTDto.getId_pat());
		prepayDO.setId_ent(prepayTDto.getId_ent());
		//prepayDO.setId_pecmpy(dto.getId_pecmpy());
		
		if(IBlConst.PREPAY_OPACC.equals(accType)){
			prepayDO.setId_paytp(IBlDictCodeConst.ID_PAYTP_OPPREPAYTRANSFERFROMIP);
			prepayDO.setSd_paytp(IBlDictCodeConst.SD_PAYTP_OPPREPAYTRANSFERFROMIP);
			prepayDO.setId_enttp(IBdFcDictCodeConst.ID_CODE_ENTP_OP);
			prepayDO.setCode_enttp(IBdFcDictCodeConst.SD_CODE_ENTP_OP);
			prepayDO.setId_incca(IBdInccaCodeConst.ID_OUTPATIENT_DEPOSIT);
			prepayDO.setCode_incca(IBdInccaCodeConst.CODE_OUTPATIENT_DEPOSIT);
		}else if(IBlConst.PREPAY_IPACC.equals(accType)){
			
			if(IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(oldPrepayDO.getCode_enttp())){
				prepayDO.setId_paytp(IBlDictCodeConst.ID_PAYTP_IPPREPAYTRANSFER);
				prepayDO.setSd_paytp(IBlDictCodeConst.SD_PAYTP_IPPREPAYTRANSFER);
			}else{
				prepayDO.setId_paytp(IBlDictCodeConst.ID_PAYTP_IPPREPAYTRANSFERFROMOP);
				prepayDO.setSd_paytp(IBlDictCodeConst.SD_PAYTP_IPPREPAYTRANSFERFROMOP);
			}
			prepayDO.setId_enttp(IBdFcDictCodeConst.ID_CODE_ENTP_IP);
			prepayDO.setCode_enttp(IBdFcDictCodeConst.SD_CODE_ENTP_IP);
			prepayDO.setId_incca(IBdInccaCodeConst.ID_INHOS_DEPOSIT);
			prepayDO.setCode_incca(IBdInccaCodeConst.CODE_INHOS_DEPOSIT);
		}
		
		prepayDO.setEu_direct(BookRtnDirectEnum.CHARGE);
		prepayDO.setAmt(amt);
		prepayDO.setSd_pttp(prepayTDto.getSd_pttp());
		prepayDO.setId_pm(oldPrepayDO.getId_pm());
		prepayDO.setSd_pm(oldPrepayDO.getSd_pm());
		prepayDO.setId_bank(oldPrepayDO.getId_bank());
		prepayDO.setBankno(oldPrepayDO.getBankno());
		prepayDO.setPaymodenode(oldPrepayDO.getPaymodenode());
		prepayDO.setDt_pay(BlFlowContextUtil.getNowTime());
		prepayDO.setId_org_pay(Context.get().getOrgId());
		prepayDO.setId_dep_pay(Context.get().getDeptId());
		prepayDO.setId_emp_pay(Context.get().getStuffId());
		prepayDO.setFg_cc(FBoolean.FALSE);
		prepayDO.setFg_rep_return(FBoolean.FALSE);
		prepayDO.setFg_canc(FBoolean.FALSE);
		prepayDO.setNote(note);
		prepayDO.setStatus(DOStatus.NEW);
		
		return prepayDO;
	}
	
	/**
	 * 取消出纳还原预交金数据
	 * @param oldPrepayDO
	 * @param accType
	 * @return
	 * @throws BizException
	 */
	public static BlPrePayPatDO restoreOldDataWhenCancelTrade(BlPrePayPatDO oldPrepayDO,String accType) throws BizException{
		BlPrePayPatDO prepayDO = (BlPrePayPatDO)oldPrepayDO.clone();
		prepayDO.setId_paypat(null);
		prepayDO.setId_paytp(IBlDictCodeConst.ID_PAYTP_IPCANCELTRADERESTORE);
		prepayDO.setSd_paytp(IBlDictCodeConst.SD_PAYTP_IPCANCELTRADERESTORE);
		prepayDO.setId_rep_lost(null);
		prepayDO.setSd_rep_lost(null);
		prepayDO.setDt_return(null);
		prepayDO.setId_emp_return(null);
		prepayDO.setId_cc(null);
		prepayDO.setFg_cc(FBoolean.FALSE);
		prepayDO.setFg_rep_return(FBoolean.FALSE);
		prepayDO.setNote(IBlConst.NOTE_CANCELTRADERESTORE);
		prepayDO.setStatus(DOStatus.NEW);
		return prepayDO;
	}
	
	/**
	 * 红冲预交金数据
	 * @param oldPrepayDO
	 * @param accType
	 * @param amt 红冲金额,为空时默认全部冲红
	 * @param note 
	 * @return
	 * @throws BizException
	 */
	public static BlPrePayPatDO reserveWhenVoid(BlPrePayPatDO oldPrepayDO,String accType, FDouble amt, String note,String sd_pttp,String id_pm,String sd_pm,FBoolean fg_refund_manual ) throws BizException {
		BlPrePayPatDO prepayDO = (BlPrePayPatDO)oldPrepayDO.clone();
		prepayDO.setId_paypat(null);
		prepayDO.setEu_direct(BookRtnDirectEnum.RETURNS);
		prepayDO.setDt_pay(BlFlowContextUtil.getNowTime());
		if(amt != null){
			prepayDO.setAmt(amt);
		}
		prepayDO.setId_rep_lost(null);
		prepayDO.setSd_rep_lost(null);
		prepayDO.setDt_return(null);
		prepayDO.setId_emp_return(null);
		prepayDO.setId_emp_pay(Context.get().getStuffId());
		prepayDO.setId_dep_pay(Context.get().getDeptId());
		prepayDO.setId_par(oldPrepayDO.getId_paypat());
		prepayDO.setFg_rep_return(FBoolean.FALSE);
		prepayDO.setId_cc(null);
		prepayDO.setFg_cc(FBoolean.FALSE);
		prepayDO.setNote(note);
		prepayDO.setStatus(DOStatus.NEW);
		//如果sd_pttp==null则不修改原终端类型
		if(!StringUtil.isEmpty(sd_pttp)){
			prepayDO.setSd_pttp(sd_pttp);
		}
		if(!StringUtil.isEmpty(id_pm)){
			prepayDO.setId_pm(id_pm);
		}
		if(!StringUtil.isEmpty(sd_pm)){
			prepayDO.setSd_pm(sd_pm);
		}
		//zx 2019年12月12日 增加手工退账标志 0178968
		if(fg_refund_manual==null){
			prepayDO.setFg_refund_manual(FBoolean.FALSE);
		}else {
			prepayDO.setFg_refund_manual(fg_refund_manual);
		}
		
		return prepayDO;
	}
	
	/**
	 * 消费红冲
	 * @param oldPrepayDO
	 * @param accType
	 * @param amt
	 * @param note
	 * @return
	 * @throws BizException
	 */
	public static BlPrePayPatDO reserveWhenConsume(BlPrePayPatDO oldPrepayDO,String accType, FDouble amt, String note) throws BizException {
		
		BlPrePayPatDO prepayDO = new BlPrePayPatDO();
		prepayDO.setId_grp(Context.get().getGroupId());
		prepayDO.setId_org(Context.get().getOrgId());
		prepayDO.setId_pat(oldPrepayDO.getId_pat());
		prepayDO.setId_ent(oldPrepayDO.getId_ent());
		//prepayDO.setId_pecmpy(oldPrepayDO.getId_pecmpy());
		prepayDO.setId_enttp(oldPrepayDO.getId_enttp());
		prepayDO.setCode_enttp(oldPrepayDO.getCode_enttp());
		
		prepayDO.setEu_direct(BookRtnDirectEnum.RETURNS);
		
		if(amt != null){
			prepayDO.setAmt(amt);
		}else{
			prepayDO.setAmt(oldPrepayDO.getAmt());
		}
		if(IBlConst.PREPAY_OPACC.equals(accType)){
			prepayDO.setId_paytp(IBlDictCodeConst.ID_PAYTP_OPPREPAYCONSUME);
			prepayDO.setSd_paytp(IBlDictCodeConst.SD_PAYTP_OPPREPAYCONSUME);
			
		}else if(IBlConst.PREPAY_IPACC.equals(accType)){
			prepayDO.setId_paytp(IBlDictCodeConst.ID_PAYTP_IPPREPAYCONSUME);
			prepayDO.setSd_paytp(IBlDictCodeConst.SD_PAYTP_IPPREPAYCONSUME);
		}else{
			prepayDO.setId_paytp(IBlDictCodeConst.ID_PAYTP_PECMPYPREPAYCONSUME);
			prepayDO.setSd_paytp(IBlDictCodeConst.SD_PAYTP_PECMPYPREPAYCONSUME);
		}
		prepayDO.setId_pm(IBdPripmCodeConst.ID_PRI_PM_PAY);
		prepayDO.setSd_pm(IBdPripmCodeConst.CODE_PRI_PM_PAY);
		prepayDO.setDt_pay(BlFlowContextUtil.getNowTime());
		prepayDO.setId_org_pay(Context.get().getOrgId());
		prepayDO.setId_dep_pay(Context.get().getDeptId());
		prepayDO.setId_emp_pay(Context.get().getStuffId());
		prepayDO.setFg_canc(FBoolean.FALSE);
		prepayDO.setFg_rep_return(FBoolean.FALSE);
		prepayDO.setFg_cc(FBoolean.FALSE);
		prepayDO.setNote(note);
		prepayDO.setStatus(DOStatus.NEW);
		//添加 红冲数据中 id_par值记录 原充值预交金
		prepayDO.setId_par(oldPrepayDO.getId_paypat());
		return prepayDO;
	}
	
	/**
	 * 出院退费--修改预交金信息
	 * @param blPrepaySTDTO
	 * @param note
	 * @return
	 * @throws BizException
	 */
	public static BlPrePayPatDO assembleBlPrePayByRefund(BlPrepaySTDTO blPrepaySTDTO, String note) throws BizException {
		if (FDoubleUtils.isNullOrZero(blPrepaySTDTO.getAmt())) {
			throw new BizException("金额为空！");
		}
		BlPrePayPatDO blPayPatDO = new BlPrePayPatDO();
		if(StringUtils.isNotEmpty(blPrepaySTDTO.getId_prepay_new())){
			blPayPatDO.setId_paypat(blPrepaySTDTO.getId_prepay_new());
		}
		blPayPatDO.setId_org(Context.get().getOrgId());
		blPayPatDO.setId_grp(Context.get().getGroupId());
		blPayPatDO.setId_dep_pay(Context.get().getDeptId());
		blPayPatDO.setId_org_pay(Context.get().getOrgId());
		blPayPatDO.setId_emp_pay(Context.get().getStuffId());
		blPayPatDO.setId_paytp(IBlDictCodeConst.ID_PAYTP_IPPREPAYSTTRANSFER);
		blPayPatDO.setSd_paytp(IBlDictCodeConst.SD_PAYTP_IPPREPAYSTTRANSFER);
		blPayPatDO.setId_pat(blPrepaySTDTO.getId_pat());
		blPayPatDO.setId_ent(blPrepaySTDTO.getId_ent());
		blPayPatDO.setId_enttp(IBdFcDictCodeConst.ID_CODE_ENTP_IP);
		blPayPatDO.setCode_enttp(IBdFcDictCodeConst.SD_CODE_ENTP_IP);
		blPayPatDO.setId_incca(IBdInccaCodeConst.ID_INHOS_DEPOSIT);
		blPayPatDO.setCode_incca(IBdInccaCodeConst.CODE_INHOS_DEPOSIT);
		blPayPatDO.setEu_direct(BookRtnDirectEnum.CHARGE);
		blPayPatDO.setAmt(blPrepaySTDTO.getAmt());
		blPayPatDO.setId_pm(blPrepaySTDTO.getId_pm());
		blPayPatDO.setSd_pm(blPrepaySTDTO.getSd_pm());
		TimeService timeService = new TimeServiceImpl();// 获取当前服务器时间
		FDateTime dateTime = timeService.getUFDateTime();
		blPayPatDO.setDt_pay(dateTime);
		blPayPatDO.setSd_pttp(blPrepaySTDTO.getSd_pttp());
		blPayPatDO.setNote(note);
		blPayPatDO.setStatus(DOStatus.NEW);

		return blPayPatDO;
	}

	/**
	 * 组装金额消费数据
	 * @param dto
	 * @param accType
	 * @param direct
	 * @return
	 * @throws BizException
	 */
	public static BlPrePayPatDO assembleAmtConsume(BlPrepayCDTO dto,String accType,Integer direct) throws BizException {
		
		BlPrePayPatDO prepayDO = new BlPrePayPatDO();
		prepayDO.setId_grp(Context.get().getGroupId());
		prepayDO.setId_org(Context.get().getOrgId());
		prepayDO.setId_pat(dto.getId_pat());
		prepayDO.setId_ent(dto.getId_ent());
		if(IBlConst.PREPAY_OPACC.equals(accType)){
			prepayDO.setId_paytp(IBlDictCodeConst.ID_PAYTP_OPPREPAYCONSUME);
			prepayDO.setSd_paytp(IBlDictCodeConst.SD_PAYTP_OPPREPAYCONSUME);
			prepayDO.setId_enttp(IBdFcDictCodeConst.ID_CODE_ENTP_OP);
			prepayDO.setCode_enttp(IBdFcDictCodeConst.SD_CODE_ENTP_OP);
			prepayDO.setId_incca(IBdInccaCodeConst.ID_OUTPATIENT_DEPOSIT);
			prepayDO.setCode_incca(IBdInccaCodeConst.CODE_OUTPATIENT_DEPOSIT);
		}else if(IBlConst.PREPAY_IPACC.equals(accType)){
			prepayDO.setId_paytp(IBlDictCodeConst.ID_PAYTP_IPPREPAYCONSUME);
			prepayDO.setSd_paytp(IBlDictCodeConst.SD_PAYTP_IPPREPAYCONSUME);
			prepayDO.setId_enttp(IBdFcDictCodeConst.ID_CODE_ENTP_IP);
			prepayDO.setCode_enttp(IBdFcDictCodeConst.SD_CODE_ENTP_IP);
			prepayDO.setId_incca(IBdInccaCodeConst.ID_INHOS_DEPOSIT);
			prepayDO.setCode_incca(IBdInccaCodeConst.CODE_INHOS_DEPOSIT);
		}else{
			//团检
			prepayDO.setId_paytp(IBlDictCodeConst.ID_PAYTP_PECMPYPREPAYCONSUME);
			prepayDO.setSd_paytp(IBlDictCodeConst.SD_PAYTP_PECMPYPREPAYCONSUME);
			prepayDO.setId_enttp(IBdFcDictCodeConst.ID_CODE_ENTP_IP);
			prepayDO.setCode_enttp(IBdFcDictCodeConst.SD_CODE_ENTP_IP);
			prepayDO.setId_incca(IBdInccaCodeConst.ID_INHOS_DEPOSIT);
			prepayDO.setCode_incca(IBdInccaCodeConst.CODE_INHOS_DEPOSIT);
		}
		prepayDO.setTradeno(null);
		prepayDO.setEu_direct(direct);
		prepayDO.setAmt(dto.getAmt());
		prepayDO.setId_pttp(BlUdidocIdSdConvertUtil.pttpSdTOId(dto.getSd_pttp()));
		prepayDO.setSd_pttp(dto.getSd_pttp());
		prepayDO.setId_pm(IBdPripmCodeConst.ID_PRI_PM_PAY);
		prepayDO.setSd_pm(IBdPripmCodeConst.CODE_PRI_PM_PAY);
		prepayDO.setId_bank(null);
		prepayDO.setBankno(null);
		prepayDO.setPaymodenode(null);
		prepayDO.setDt_pay(BlFlowContextUtil.getNowTime());
		prepayDO.setId_org_pay(Context.get().getOrgId());
		prepayDO.setId_dep_pay(Context.get().getDeptId());
		prepayDO.setId_emp_pay(Context.get().getStuffId());
		prepayDO.setFg_cc(FBoolean.FALSE);
		prepayDO.setFg_rep_return(FBoolean.FALSE);
		prepayDO.setFg_canc(FBoolean.FALSE);
		prepayDO.setNote(dto.getNote());
		prepayDO.setStatus(DOStatus.NEW);
		return prepayDO;
	}
}
