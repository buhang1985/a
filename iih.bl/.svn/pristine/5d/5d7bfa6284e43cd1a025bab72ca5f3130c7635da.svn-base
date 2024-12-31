package iih.bl.pay.s.bp.op;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import iih.bd.base.exception.ArgumentNullException;
import iih.bd.base.utils.AppUtils;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.bl.cg.blcgoep.d.FeeOriginEnum;
import iih.bl.cg.blcgquery.d.BookRtnDirectEnum;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.dto.cglogic.d.BlCgAccountDTO;
import iih.bl.cg.dto.cglogic.d.BlCgOpAccountSetDTO;
import iih.bl.cg.dto.cglogic.d.OepCgModeEnum;
import iih.bl.cg.i.IBlCgAccountService;
import iih.bl.cg.service.i.IBLOrderAppendBillService;
import iih.bl.comm.IBlCgFuncConst;
import iih.bl.comm.IBlConst;
import iih.bl.comm.constant.IBlBizDataConst;
import iih.bl.inc.i.IBlIncUtilService;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.blpaypat.i.IBlpaypatCudService;
import iih.bl.pay.blpayspcl.d.BlPayItmSpclDO;
import iih.bl.pay.blpayspcl.d.BlPaySpclDO;
import iih.bl.pay.blpayspcl.d.BlpayspclAggDO;
import iih.bl.pay.blspclpat.d.BlSpclPatDO;
import iih.bl.pay.blspclpat.d.BlspclpatAggDO;
import iih.bl.pay.blspclpat.d.SpcltpEnum;
import iih.bl.pay.dto.blprepaydto.d.BlPrepayDTO;
import iih.bl.pay.dto.prepay.d.BlPrepayRDTO;
import iih.bl.pay.dto.prepay.d.BlPrepaySetDTO;
import iih.bl.pay.i.IBlPrepayCmdService;
import iih.bl.pay.prepaypatrcpt.d.BlPrepayPatRcptDO;
import iih.bl.pay.s.bp.prepay.BlPrepayRechargeBP;
import iih.bl.pay.s.ep.PatSpclEP;
import iih.bl.pay.s.ep.PatSpclPayEP;
import iih.bl.pay.s.ep.PrepayPatRcptEP;
import iih.pi.acc.account.i.IPatAccServiceExt;
import iih.pi.dic.cardtype.d.CardCgMdEnum;
import iih.pi.dic.cardtype.d.PiPatCardTpDO;
import iih.pi.reg.i.external.provide.IPiRegBlRService;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.i.IPatiMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.dataaccess.DBUtil;

/**
 * 门诊收取预交金 (含卡费处理)
 * 
 * @author ly 2018/05/19
 *
 */
public class OpCollectPrepayBP {

	/**
	 * 门诊收取预交金
	 * 
	 * @param dto
	 * @throws BizException
	 */
	public BlPrePayPatDO exec(BlPrepayDTO dto) throws BizException {

		// 入参校验
		this.validate(dto);

		if (StringUtil.isEmpty(dto.getId_patcard())) {
			return this.chargePrepayNoCard(dto);
		}

		switch (dto.getEu_cardcgmd()) {
		case CardCgMdEnum.FREE:
			return this.chargePrepayNoCard(dto);
		case CardCgMdEnum.COST:
			return this.chargeCardCost(dto);
		case CardCgMdEnum.DEPOSIT:
			return this.chargeDeposit(dto);
		default:
			return this.chargePrepayNoCard(dto);
		}
	}

	/**
	 * 入参校验
	 * 
	 * @param dto
	 * @throws BizException
	 */
	private void validate(BlPrepayDTO dto) throws BizException {

		if (dto == null) {
			throw new ArgumentNullException("门诊收取预交金", "患者预交金dto");
		}

		if (StringUtil.isEmpty(dto.getId_pat())) {
			throw new ArgumentNullException("门诊收取预交金", "患者id");
		}
	}

	/**
	 * 收取押金
	 * 
	 * @param dto
	 * @throws BizException
	 */
	private BlPrePayPatDO chargeDeposit(BlPrepayDTO dto) throws BizException {
		// 1.组装数据
		// 生成患者专用款收付款数据
		BlpayspclAggDO paySpclAggDO = this.assemblePaySpcl(dto);
		// 生成患者专用款数据
		BlspclpatAggDO spclPatAggDO = this.assembleSpclPat(dto);
		
		if (FBoolean.TRUE.isValue()) {//调用新预交金接口
			//调用新预交金接口
			BlPrePayPatDO prepayDo = this.blPrepayRechargeBP(dto);
			BlPrePayPatDO consumePrepayDO = this.assembleConsumePrepayPat(dto);

			// 2.生成主键
			String[] keys = new DBUtil().getOIDs(4);
			paySpclAggDO.getParentDO().setId_payspcl(keys[0]);
			BlPayItmSpclDO payItm = paySpclAggDO.getBlPayItmSpclDO()[0];
			payItm.setId_payspcl(keys[0]);
			payItm.setId_payitmspcl(keys[1]);
			spclPatAggDO.getParentDO().setId_spclpat(keys[2]);
			consumePrepayDO.setId_paypat(keys[3]);

			// 建立数据关系
			// 患者专用款表--> 专用款收款id
			spclPatAggDO.getParentDO().setId_payspcl_in(paySpclAggDO.getParentDO().getId_payspcl());
			// 专用款收款明细 --> 预交金收付款id
			payItm.setId_paypat(consumePrepayDO.getId_paypat());
			// 预交金收付款 --> 备注：患者专用款id
			consumePrepayDO.setNote(
					String.format(IBlConst.NOTE_CHARGECARDDEPOSIT_VSSPCLPAT, spclPatAggDO.getParentDO().getId_spclpat()));
			
			if(prepayDo != null){
				prepayDo.setId_pttp(IBlDictCodeConst.ID_PTTP_WINDOW);
			}
			
			// 3.保存数据
			// 患者专用款收付款
			new PatSpclPayEP().save(new BlpayspclAggDO[] { paySpclAggDO });
			// 患者专用款
			new PatSpclEP().save(new BlspclpatAggDO[] { spclPatAggDO });
			//更新预交金备注
			IBlpaypatCudService cudService = ServiceFinder.find(IBlpaypatCudService.class);
			
			BlPrePayPatDO[] prepayDos = null;
			if(prepayDo != null){
				prepayDos = cudService.save(new BlPrePayPatDO[] { prepayDo, consumePrepayDO });
			}else{
				prepayDos = cudService.save(new BlPrePayPatDO[] { consumePrepayDO });
			}
			
			
			// 4.更新患者账户 之后规划新接口 
			IPatAccServiceExt accService = ServiceFinder.find(IPatAccServiceExt.class);
			// 锁定额度
			accService.PatiAccPreAuthor(dto.getId_pat(), dto.getCard_amt());
			
			//收取病历费
			if (FBoolean.TRUE.equals(dto.getFg_medrecord())) {
				IPatiMDORService patiService = ServiceFinder.find(IPatiMDORService.class);
				PatDO patDO = patiService.findById(dto.getId_pat());
				
				//List<BlOrderAppendBillParamDTO> paramList = new ArrayList<BlOrderAppendBillParamDTO>();
				OpCollectPatRegisterBP prBp = new OpCollectPatRegisterBP(patDO);
				BlOrderAppendBillParamDTO[] prParams = prBp.assembleCgData();
				if (!ArrayUtil.isEmpty(prParams)) {
					//paramList.addAll(Arrays.asList(prParams));
					IBLOrderAppendBillService billService = ServiceFinder.find(IBLOrderAppendBillService.class);
					billService.SetOrderAppendBill_ByItms(prParams, IBdFcDictCodeConst.SD_CODE_ENTP_OP);
				}
			}

			return prepayDos[0];
			
			
		}else{//原预交金处理方法，如果新接口行不通更改第二种
			// 票据过号
			IBlIncUtilService incService = ServiceFinder.find(IBlIncUtilService.class);
			String invoice = incService.nextInvoiceNoPre(Context.get().getStuffId(), Context.get().getClientHost(),
					IBdPpCodeTypeConst.ID_OUTPATIENT_DEPOSIT);

			
			// 生成预交金收付款数据
			BlPrePayPatDO chargePrepayDO = this.assembleCharePrepayPat(dto, invoice);
			BlPrePayPatDO consumePrepayDO = this.assembleConsumePrepayPat(dto);

			// 2.生成主键
			String[] keys = new DBUtil().getOIDs(5);
			paySpclAggDO.getParentDO().setId_payspcl(keys[0]);
			BlPayItmSpclDO payItm = paySpclAggDO.getBlPayItmSpclDO()[0];
			payItm.setId_payspcl(keys[0]);
			payItm.setId_payitmspcl(keys[1]);
			spclPatAggDO.getParentDO().setId_spclpat(keys[2]);
			chargePrepayDO.setId_paypat(keys[3]);
			consumePrepayDO.setId_paypat(keys[4]);

			// 建立数据关系
			// 患者专用款表--> 专用款收款id
			spclPatAggDO.getParentDO().setId_payspcl_in(paySpclAggDO.getParentDO().getId_payspcl());
			// 专用款收款明细 --> 预交金收付款id
			payItm.setId_paypat(consumePrepayDO.getId_paypat());
			// 预交金收付款 --> 备注：患者专用款id
			consumePrepayDO.setNote(
					String.format(IBlConst.NOTE_CHARGECARDDEPOSIT_VSSPCLPAT, spclPatAggDO.getParentDO().getId_spclpat()));

			// 3.保存数据
			//保存预交金打印记录
			PrepayPatRcptEP prepayEp = new PrepayPatRcptEP();
			BlPrepayPatRcptDO rcptDO = prepayEp.saveRcptPrint(chargePrepayDO,null);
			chargePrepayDO.setCode_rep(rcptDO.getCode_rep());
			// 患者专用款收付款
			new PatSpclPayEP().save(new BlpayspclAggDO[] { paySpclAggDO });
			// 患者专用款
			new PatSpclEP().save(new BlspclpatAggDO[] { spclPatAggDO });
			// 预交金收付款
			IBlpaypatCudService cudService = ServiceFinder.find(IBlpaypatCudService.class);
			BlPrePayPatDO[] prepayDos = cudService.save(new BlPrePayPatDO[] { chargePrepayDO, consumePrepayDO });

			// 4.更新患者账户 之后规划新接口 
			IPatAccServiceExt accService = ServiceFinder.find(IPatAccServiceExt.class);
			// 预交金
			accService.updatePatPrepay(dto.getId_pat(), dto.getPrepay());
			// 锁定额度
			accService.PatiAccPreAuthor(dto.getId_pat(), dto.getCard_amt());

			//收取病历费
			if (FBoolean.TRUE.equals(dto.getFg_medrecord())) {
				IPatiMDORService patiService = ServiceFinder.find(IPatiMDORService.class);
				PatDO patDO = patiService.findById(dto.getId_pat());
				
				List<BlOrderAppendBillParamDTO> paramList = new ArrayList<BlOrderAppendBillParamDTO>();
				OpCollectPatRegisterBP prBp = new OpCollectPatRegisterBP(patDO);
				BlOrderAppendBillParamDTO[] prParams = prBp.assembleCgData();
				if (!ArrayUtil.isEmpty(prParams)) {
					paramList.addAll(Arrays.asList(prParams));
				}
				
				IBLOrderAppendBillService billService = ServiceFinder.find(IBLOrderAppendBillService.class);
				billService.SetOrderAppendBill_ByItms(paramList.toArray(new BlOrderAppendBillParamDTO[0]),
						IBdFcDictCodeConst.SD_CODE_ENTP_OP);
			}
			
			return prepayDos[0];
		}
	}

	/**
	 * 调用预交金新接口
	 * @author zhang.hw
	 * @date 2019年9月2日
	 * @param dto
	 * @return
	 * @throws BizException 
	 */
	private BlPrePayPatDO blPrepayRechargeBP(BlPrepayDTO dto) throws BizException {
		
		//押金模式下，如果预交金余额大于卡工本费和病历本费并且预交金充值金额为0的话，则不调用该接口
		if(dto.getPrepay().add(dto.getAccamt() == null ? FDouble.ZERO_DBL : dto.getAccamt()).compareTo(dto.getCard_amt().add(dto.getMedrecord_amt() == null ? FDouble.ZERO_DBL : dto.getMedrecord_amt())) >= 0 && dto.getPrepay().compareTo(FDouble.ZERO_DBL) == 0){
			return null;
		}
		
		BlPrepayRDTO rdto = new BlPrepayRDTO();
		rdto.setId_pat(dto.getId_pat());
		rdto.setCode_req(dto.getCode_rep());
		rdto.setId_pm(dto.getId_paymod());
		rdto.setSd_pm(dto.getCode_paymod());
		rdto.setName_pm(dto.getName_paymod());
		rdto.setId_emp_pay(Context.get().getStuffId());
		rdto.setEu_direct(1);
		if (StringUtil.isEmpty(dto.getSd_pttp())) {
			rdto.setSd_pttp(IBlDictCodeConst.SD_PTTP_WINDOW);
		} else {
			rdto.setSd_pttp(dto.getSd_pttp());
		}
		rdto.setPaymodenode(dto.getPaymodeno());
		rdto.setBankno(dto.getNum_bank());
		rdto.setAmt(dto.getPrepay());
		if (dto.getTradeno()!=null) {
			rdto.setTradeno(dto.getTradeno());
		}else{
			rdto.setId_bank(dto.getId_bank());
		}
		BlPrepaySetDTO setDTO = new BlPrepaySetDTO();
		setDTO.setFg_accupdate(FBoolean.TRUE);
		setDTO.setFg_print(FBoolean.TRUE);
		setDTO.setFg_useinc(FBoolean.TRUE);
		BlPrepayRechargeBP bp = new BlPrepayRechargeBP(setDTO);
		return bp.exec(rdto);
	}

	/**
	 * 收取卡费
	 * 
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	private BlPrePayPatDO chargeCardCost(BlPrepayDTO dto) throws BizException {

		/*
		 * if(StringUtil.isEmpty(dto.getId_srv())){ throw new
		 * BizException("卡费用模式,卡对应的服务id不能为空"); }
		 */

		// 收取预交金
		BlPrePayPatDO prepayDO = this.chargePrepay(dto);

		// 预交金记账
		// 查询患者信息
		IPiRegBlRService piblSercie = ServiceFinder.find(IPiRegBlRService.class);
		IPatiMDORService patiService = ServiceFinder.find(IPatiMDORService.class);
		IMedsrvMDORService srvService = ServiceFinder.find(IMedsrvMDORService.class);

		PiPatCardTpDO cardTpDO = piblSercie.findCardTpByPatCardId(dto.getId_patcard());
		if (cardTpDO == null || StringUtil.isEmpty(cardTpDO.getId_srv())) {
			throw new BizException("卡费用模式,未查询到对应卡费用服务");
		}
		PatDO patDO = patiService.findById(dto.getId_pat());
		MedSrvDO srvDO = srvService.findById(cardTpDO.getId_srv());

		// 使用新记账接口 2019/10/24 ly
		List<BlCgAccountDTO> cgAccList = new ArrayList<BlCgAccountDTO>();
		//卡费
		BlCgAccountDTO cardAccDto = new BlCgAccountDTO();
		cardAccDto.setId_pat(dto.getId_pat());
		cardAccDto.setId_srv(cardTpDO.getId_srv());
		cardAccDto.setQuan(FDouble.ONE_DBL);
		cardAccDto.setFg_mm(FBoolean.FALSE);
		cardAccDto.setId_unit_srv(srvDO.getId_unit_med());
		cardAccDto.setEu_direct(BookRtnDirectEnum.CHARGES);
		cardAccDto.setId_dep_or(Context.get().getDeptId());
		cardAccDto.setId_emp_or(Context.get().getStuffId());
		cardAccDto.setId_dep_mp(Context.get().getDeptId());
		cardAccDto.setFg_addfee(FBoolean.FALSE);
		cardAccDto.setNote(dto.getId_patcard());
		
		cgAccList.add(cardAccDto);
		
		if (FBoolean.TRUE.equals(dto.getFg_medrecord())) {
			
			OpCollectPatRegisterBP prBp = new OpCollectPatRegisterBP(patDO);
			BlCgAccountDTO[] prDatas = prBp.assembleCgDataNew();
			if(!ArrayUtil.isEmpty(prDatas)){
				cgAccList.addAll(Arrays.asList(prDatas));
			}
		}
		
		BlCgOpAccountSetDTO accSet = new BlCgOpAccountSetDTO();
		accSet.setSrcfunc_des(IBlCgFuncConst.FUNC_PI_PATREGISTER);
		accSet.setEu_srctp(FeeOriginEnum.PATREGISTER_FEE);
		accSet.setEu_oepcgmode(OepCgModeEnum.PREPAY_CG);
		
		IBlCgAccountService accService = ServiceFinder.find(IBlCgAccountService.class);
		accService.keepAccountForOp(cgAccList.toArray(new BlCgAccountDTO[0]), accSet);
		
		/*IBLOrderAppendBillService billService = ServiceFinder.find(IBLOrderAppendBillService.class);
		List<BlOrderAppendBillParamDTO> paramList = new ArrayList<BlOrderAppendBillParamDTO>();

		BlOrderAppendBillParamDTO param = new BlOrderAppendBillParamDTO();
		param.setId_pat(dto.getId_pat());
		param.setId_pripat(patDO.getId_patpritp());
		param.setId_enttp(IBdFcDictCodeConst.ID_CODE_ENTP_OP);
		param.setCode_enttp(IBdFcDictCodeConst.SD_CODE_ENTP_OP);
		param.setId_srv(cardTpDO.getId_srv());
		param.setId_srvtp(srvDO.getId_srvtp());
		param.setSd_srvtp(srvDO.getSd_srvtp());
		param.setId_srvca(srvDO.getId_srvca());
		param.setCode_srv(srvDO.getCode());
		param.setName_srv(srvDO.getName());
		param.setSrvu(srvDO.getId_unit_med());
		param.setFg_mm(FBoolean.FALSE);
		param.setEu_srctp(FeeOriginEnum.PATREGISTER_FEE);
		param.setId_dep_or(Context.get().getDeptId());
		param.setId_org_or(Context.get().getOrgId());
		param.setId_emp_or(Context.get().getStuffId());
		// 记账日期
		param.setDt_or(BlFlowContextUtil.getNowTime());
		param.setId_dep_mp(Context.get().getDeptId());
		param.setId_org_mp(Context.get().getOrgId());
		param.setId_grp(Context.get().getGroupId());
		param.setId_org(Context.get().getOrgId());
		param.setId_org_cg(Context.get().getOrgId());
		param.setId_dep_cg(Context.get().getDeptId());
		param.setId_emp_cg(Context.get().getStuffId());
		param.setDt_cg(AppUtils.getServerDateTime());
		param.setEu_direct(BookRtnDirectEnum.CHARGES);
		param.setNote(dto.getId_patcard());

		param.setQuan(FDouble.ONE_DBL);
		param.setSupportAppendBill(FBoolean.FALSE);

		BlOrderAppendOutpBillParamDTO outParam = new BlOrderAppendOutpBillParamDTO();
		outParam.setFg_acc(FBoolean.TRUE);

		param.setOutpBillDTO(outParam);

		paramList.add(param);

		if (FBoolean.TRUE.equals(dto.getFg_medrecord())) {
			OpCollectPatRegisterBP prBp = new OpCollectPatRegisterBP(patDO);
			BlOrderAppendBillParamDTO[] prParams = prBp.assembleCgData();
			if (!ArrayUtil.isEmpty(prParams)) {
				paramList.addAll(Arrays.asList(prParams));
			}
		}

		billService.SetOrderAppendBill_ByItms(paramList.toArray(new BlOrderAppendBillParamDTO[0]),
				IBdFcDictCodeConst.SD_CODE_ENTP_OP);*/

		return prepayDO;
	}

	/**
	 * 收取预交金
	 * 
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	private BlPrePayPatDO chargePrepayNoCard(BlPrepayDTO dto) throws BizException {

		BlPrePayPatDO prepayDO = this.chargePrepay(dto);

		if (FBoolean.TRUE.equals(dto.getFg_medrecord())) {
			
			IPatiMDORService patiService = ServiceFinder.find(IPatiMDORService.class);
			PatDO patDO = patiService.findById(dto.getId_pat());
			
			OpCollectPatRegisterBP prBp = new OpCollectPatRegisterBP(patDO);
			BlCgAccountDTO[] prDatas = prBp.assembleCgDataNew();
			if(!ArrayUtil.isEmpty(prDatas)){
				
				List<BlCgAccountDTO> cgAccList = new ArrayList<BlCgAccountDTO>();
				cgAccList.addAll(Arrays.asList(prDatas));
				
				BlCgOpAccountSetDTO accSet = new BlCgOpAccountSetDTO();
				accSet.setSrcfunc_des(IBlCgFuncConst.FUNC_PI_PATREGISTER);
				accSet.setEu_srctp(FeeOriginEnum.PATREGISTER_FEE);
				accSet.setEu_oepcgmode(OepCgModeEnum.PREPAY_CG);
				
				IBlCgAccountService accService = ServiceFinder.find(IBlCgAccountService.class);
				accService.keepAccountForOp(cgAccList.toArray(new BlCgAccountDTO[0]), accSet);
			}
		}
		
		return prepayDO;
	}
	
	/**
	 * 收预交金
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	private BlPrePayPatDO chargePrepay(BlPrepayDTO dto) throws BizException {
		
		if (dto.getPrepay() == null || FDouble.ZERO_DBL.compareTo(dto.getPrepay()) == 0)
			return null;
		
		// 调用新充值逻辑
		IBlPrepayCmdService prepayService = ServiceFinder.find(IBlPrepayCmdService.class);
		BlPrepayRDTO prepayDto = new BlPrepayRDTO();
		prepayDto.setId_pat(dto.getId_pat());
		prepayDto.setCode_req(dto.getCode_rep());
		prepayDto.setAmt(dto.getPrepay());
		if (StringUtil.isEmpty(dto.getSd_pttp())) {
			prepayDto.setSd_pttp(IBlDictCodeConst.SD_PTTP_WINDOW);
		} else {
			prepayDto.setSd_pttp(dto.getSd_pttp());
		}
		prepayDto.setId_pm(dto.getId_paymod());
		prepayDto.setSd_pm(dto.getCode_paymod());
		prepayDto.setId_bank(dto.getId_bank());
		prepayDto.setBankno(dto.getNum_bank());
		prepayDto.setPaymodenode(dto.getPaymodeno());
		prepayDto.setEu_direct(BookRtnDirectEnum.CHARGES);
		// prepayDto.setId_cust(dto.getid);
		if (!StringUtil.isEmpty(dto.getTradeno())) {
			prepayDto.setTradeno(dto.getTradeno());
		}
		BlPrepaySetDTO prepaySetDto = new BlPrepaySetDTO();
		prepaySetDto.setFg_print(FBoolean.TRUE);
		prepaySetDto.setFg_accupdate(FBoolean.TRUE);
		prepaySetDto.setFg_checkacc(FBoolean.TRUE);

		BlPrePayPatDO prepayDO = prepayService.recharge(prepayDto, prepaySetDto);
				
		return prepayDO;
	}

	/**
	 * 专用款收付款数据组装
	 * 
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	private BlpayspclAggDO assemblePaySpcl(BlPrepayDTO dto) throws BizException {

		BlpayspclAggDO aggDO = new BlpayspclAggDO();
		BlPaySpclDO paySpcl = new BlPaySpclDO();
		paySpcl.setId_grp(Context.get().getGroupId());
		paySpcl.setId_org(Context.get().getOrgId());
		paySpcl.setId_pat(dto.getId_pat());
		paySpcl.setId_pttp(IBlDictCodeConst.ID_PTTP_WINDOW);
		paySpcl.setSd_pttp(IBlDictCodeConst.SD_PTTP_WINDOW);
		paySpcl.setEu_direct(BookRtnDirectEnum.CHARGES);
		paySpcl.setAmt(dto.getCard_amt());
		paySpcl.setDt_pay(AppUtils.getServerDateTime());
		paySpcl.setId_org_pay(Context.get().getOrgId());
		paySpcl.setId_dep_pay(Context.get().getDeptId());
		paySpcl.setId_emp_pay(Context.get().getStuffId());
		paySpcl.setFg_cc(FBoolean.FALSE);
		paySpcl.setNote(IBlConst.NOTE_CHARGECARDDEPOSIT);
		paySpcl.setStatus(DOStatus.NEW);

		BlPayItmSpclDO payItm = new BlPayItmSpclDO();
		payItm.setId_grp(Context.get().getGroupId());
		payItm.setId_org(Context.get().getOrgId());
		payItm.setEu_direct(BookRtnDirectEnum.CHARGES);
		payItm.setId_pm(dto.getId_paymod());
		payItm.setSd_pm(dto.getCode_paymod());
		payItm.setAmt(dto.getCard_amt());
		payItm.setId_bank(dto.getId_bank());
		payItm.setBankno(dto.getNum_bank());
		payItm.setPaymodenode(dto.getPaymodeno());
		payItm.setStatus(DOStatus.NEW);

		aggDO.setParentDO(paySpcl);
		aggDO.setBlPayItmSpclDO(new BlPayItmSpclDO[] { payItm });

		return aggDO;
	}

	/**
	 * 患者专用款数据组装
	 * 
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	private BlspclpatAggDO assembleSpclPat(BlPrepayDTO dto) throws BizException {

		BlspclpatAggDO aggDO = new BlspclpatAggDO();
		BlSpclPatDO spclPat = new BlSpclPatDO();
		spclPat.setId_grp(Context.get().getGroupId());
		spclPat.setId_org(Context.get().getOrgId());
		spclPat.setId_pat(dto.getId_pat());
		spclPat.setEu_spcltp(SpcltpEnum.CARD_DEPOSIT);
		spclPat.setId_src(dto.getId_patcard());
		spclPat.setDes_src(IBlConst.NOTE_CHARGECARDDEPOSIT);
		spclPat.setAmt(dto.getCard_amt());
		spclPat.setFg_close(FBoolean.FALSE);
		spclPat.setFg_cc_in(FBoolean.FALSE);
		spclPat.setFg_cc_out(FBoolean.FALSE);
		spclPat.setStatus(DOStatus.NEW);

		aggDO.setParentDO(spclPat);
		return aggDO;
	}

	/**
	 * 预交金充值数据组装
	 * 
	 * @param dto
	 * @param invoice
	 * @return
	 * @throws BizException
	 */
	private BlPrePayPatDO assembleCharePrepayPat(BlPrepayDTO dto, String invoice) throws BizException {
		BlPrePayPatDO prepay = new BlPrePayPatDO();
		prepay.setId_grp(Context.get().getGroupId());
		prepay.setId_org(Context.get().getOrgId());
		prepay.setId_paytp(IBlDictCodeConst.ID_PAYTP_OPPREPAY);
		prepay.setSd_paytp(IBlDictCodeConst.SD_PAYTP_OPPREPAY);
		prepay.setId_pat(dto.getId_pat());
		prepay.setEu_direct(BookRtnDirectEnum.CHARGES);
		prepay.setAmt(dto.getPrepay());
		if (StringUtil.isEmpty(dto.getSd_pttp())) {
			prepay.setId_pttp(IBlDictCodeConst.ID_PTTP_WINDOW);
			prepay.setSd_pttp(IBlDictCodeConst.SD_PTTP_WINDOW);
		} else {
			prepay.setSd_pttp(dto.getSd_pttp());
		}
		//增加 赋值 zx  2019年8月26日
		prepay.setId_enttp(IBdFcDictCodeConst.ID_CODE_ENTP_OP);
		prepay.setCode_enttp(IBdFcDictCodeConst.SD_CODE_ENTP_OP);
		prepay.setId_pm(dto.getId_paymod());
		prepay.setSd_pm(dto.getCode_paymod());
		prepay.setId_bank(dto.getId_bank());
		prepay.setBankno(dto.getNum_bank());// 银行卡号
		prepay.setPaymodenode(dto.getPaymodeno());
		prepay.setDt_pay(AppUtils.getServerDateTime());
		prepay.setId_org_pay(Context.get().getOrgId());
		prepay.setId_dep_pay(Context.get().getDeptId());
		prepay.setId_emp_pay(Context.get().getStuffId());
		prepay.setId_incca(IBdPpCodeTypeConst.ID_OUTPATIENT_DEPOSIT);
		prepay.setCode_incca(IBdPpCodeTypeConst.SD_OUTPATIENT_DEPOSIT);
		prepay.setTradeno(dto.getTradeno());// 第三方交易的交易流水号
		prepay.setCode_rep(invoice);
		prepay.setFg_cc(FBoolean.FALSE);
		prepay.setFg_rep_return(FBoolean.FALSE);
		prepay.setFg_canc(FBoolean.FALSE);
		prepay.setStatus(DOStatus.NEW);
		return prepay;
	}

	/**
	 * 预交金消费数据组装
	 * 
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	private BlPrePayPatDO assembleConsumePrepayPat(BlPrepayDTO dto) throws BizException {
		BlPrePayPatDO prepay = new BlPrePayPatDO();
		prepay.setId_grp(Context.get().getGroupId());
		prepay.setId_org(Context.get().getOrgId());
		prepay.setId_enttp(IBdFcDictCodeConst.ID_CODE_ENTP_OP);
		prepay.setCode_enttp(IBdFcDictCodeConst.SD_CODE_ENTP_OP);
		prepay.setId_paytp(IBlDictCodeConst.ID_PAYTP_OPPREPAYCONSUME);
		prepay.setSd_paytp(IBlDictCodeConst.SD_PAYTP_OPPREPAYCONSUME);
		prepay.setId_pat(dto.getId_pat());
		prepay.setEu_direct(BookRtnDirectEnum.REFUND);
		prepay.setAmt(dto.getCard_amt());
		prepay.setId_pttp(IBlDictCodeConst.ID_PTTP_WINDOW);
		prepay.setSd_pttp(IBlDictCodeConst.SD_PTTP_WINDOW);
		prepay.setId_pm(IBlBizDataConst.ID_PRI_PM_PREPAY);
		prepay.setSd_pm(IBlBizDataConst.SD_PRI_PM_PREPAY);
		prepay.setDt_pay(AppUtils.getServerDateTime());
		prepay.setId_org_pay(Context.get().getOrgId());
		prepay.setId_dep_pay(Context.get().getDeptId());
		prepay.setId_emp_pay(Context.get().getStuffId());
		prepay.setFg_cc(FBoolean.FALSE);
		prepay.setFg_rep_return(FBoolean.FALSE);
		prepay.setFg_canc(FBoolean.FALSE);
		prepay.setStatus(DOStatus.NEW);
		return prepay;
	}
}
