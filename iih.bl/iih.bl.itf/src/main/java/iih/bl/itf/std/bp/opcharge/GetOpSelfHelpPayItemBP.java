package iih.bl.itf.std.bp.opcharge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.incca.i.IBdInccaCodeConst;
import iih.bd.pp.pripm.d.PriPmDO;
import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.bd.res.workstation.d.WorkStationPcDO;
import iih.bd.res.workstation.i.IWorkstationRService;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.i.IBlCgItmOepDORService;
import iih.bl.comm.util.BlFlowContextUtil;
import iih.bl.hp.hpentcodeoep.d.HpEntCodeOepDO;
import iih.bl.hp.hpentcodeoep.i.IHpentcodeoepCudService;
import iih.bl.hp.hptranactoep.d.HpTransactOepDO;
import iih.bl.hp.hptranactoep.i.IHptranactoepCudService;
import iih.bl.hp.hptransactah.d.EuTransStatus;
import iih.bl.inc.blincoep.d.BlIncOepDO;
import iih.bl.inc.blincoep.i.IBlincoepMDORService;
import iih.bl.inc.i.IBlIncUtilService;
import iih.bl.itf.bltranscall.d.BlTransCalledRcdDO;
import iih.bl.itf.bltranscall.d.ItfTypeEnum;
import iih.bl.itf.std.bean.constant.IBlWsConst;
import iih.bl.itf.std.bean.input.charge.WsParamSelfHelpPayItem;
import iih.bl.itf.std.bean.input.charge.sub.WsParamSelfHelpPayInfo;
import iih.bl.itf.std.bean.output.WsResultMsg;
import iih.bl.itf.std.bean.output.charge.WsResultInfoOpGetSelfHelpPayInfo;
import iih.bl.itf.std.bean.output.charge.WsResultOpGetSelfHelpPayItem;
import iih.bl.itf.std.bean.output.charge.sub.WsResultOpIncNoItm;
import iih.bl.itf.std.bean.output.charge.sub.WsResultOpWindowNo;
import iih.bl.itf.std.bean.output.charge.sub.WsResultOpitemDetail;
import iih.bl.itf.std.bp.BlItfBaseBP;
import iih.bl.itf.std.bp.validator.WsParamSelfHelpPayValidator;
import iih.bl.itf.std.util.BlAmtConverUtil;
import iih.bl.params.BlParams;
import iih.bl.st.blpaypatoep.d.BlPayItmPatOepDO;
import iih.bl.st.blpaypatoep.i.IBlPayItmPatOepDORService;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.blstoep.i.IBlstoepRService;
import iih.bl.st.dto.blpayoep.d.BlPayOepDTO;
import iih.bl.st.dto.blpayoep.d.BlPayOepPmDTO;
import iih.bl.st.dto.blpayoep.d.BlPayOepRltDTO;
import iih.bl.st.i.IBlOepChargeCmdService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.mi.biz.dto.d.CommonPropDataDTO;
import iih.mi.biz.dto.d.OepSettleRtnValDTO;
import iih.mi.biz.flow.oepchargeflow.d.MiOepChargePaySelfInParamDTO;
import iih.mi.biz.flow.oepchargeflow.d.MiOepChargePaySelfOutParamDTO;
import iih.mi.itf.bizgrpitf.param.ResultOutParamDTO;
import iih.mi.itf.context.InsureContext;
import iih.mi.itf.facade.InsureFacade;
import iih.mp.dg.i.IMpDgOutService;
import iih.pi.dic.patientcategory.d.PiPatCaDO;
import iih.pi.dic.patientcategory.i.IPatientcategoryRService;
import iih.pi.reg.dto.d.PiPatFuzyyQueryCondDTO;
import iih.pi.reg.i.IPiRegQryService;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAggDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 门诊自助收付款
 * 
 * @author shaokx 2019/1/9
 * @version ly 2019/07/10 添加医保处理
 *
 */
public class GetOpSelfHelpPayItemBP extends BlItfBaseBP<WsParamSelfHelpPayItem,WsResultOpGetSelfHelpPayItem> {

	
	private Map<String, PriPmDO> pmMap;
	
	private BlStOepDO stOepDO;
	
	@Override
	protected String getBusiness() {
		return "门诊自助收付款";
	}

	@Override
	protected void checkParam(WsParamSelfHelpPayItem param) throws BizException {
		WsParamSelfHelpPayValidator validator = new WsParamSelfHelpPayValidator();
		validator.validate(param);
		
		WsParamSelfHelpPayInfo prepayInfo = param.getPrepay();
		
		if(!BlParams.BLSTOEP0067().booleanValue() && new FDouble(prepayInfo.getPayMoney()).compareTo(FDouble.ZERO_DBL) == 0){
			throw new BizException("门诊自助收付款:不允许0元收付款");
		}
		
		// 设置人员上下文
		PsnDocDO psndocDO = super.getPsnInfo(prepayInfo.getOperaCode());
		if (psndocDO == null) {
			throw new BizException("门诊自助收付款:未查询到人员信息");
		}
		Context.get().setStuffId(psndocDO.getId_psndoc());
		
		//设置计算机上下文
		if(!StringUtil.isEmpty(prepayInfo.getPcId())){
			IWorkstationRService pcRService = ServiceFinder.find(IWorkstationRService.class);
			WorkStationPcDO[] pcDOs = pcRService.findByAttrValString(WorkStationPcDO.PCID, prepayInfo.getPcId());
			if(ArrayUtil.isEmpty(pcDOs)){
				throw new BizException("该计算机标识没有维护");
			}
			Context.get().setClientHost(prepayInfo.getPcId());
		}
	}

	/**
	 * 创建交易记录 在dowork前调用，可将部分数据初始化挪至该处理
	 * 
	 * @param xml
	 * @param tData
	 * @return
	 * @throws BizException
	 */
	@Override
	protected BlTransCalledRcdDO createTransRcd(String xml, WsParamSelfHelpPayItem param) throws BizException {
		WsParamSelfHelpPayInfo prepayInfo = param.getPrepay();

		BlTransCalledRcdDO rcdDO = new BlTransCalledRcdDO();
		rcdDO.setId_org(Context.get().getOrgId());
		rcdDO.setId_grp(Context.get().getGroupId());
		rcdDO.setEu_itftp(ItfTypeEnum.OPPAY);
		rcdDO.setId_pat(null);
		rcdDO.setId_ent(null);
		rcdDO.setCode_enttp(IBdFcDictCodeConst.SD_CODE_ENTP_OP);
		rcdDO.setId_pm(prepayInfo.getPaymentMethod());// 临时保存入参原始值
		rcdDO.setVoucher_no(prepayInfo.getDocumentNumber());
		rcdDO.setOrder_no(prepayInfo.getOrderNumber());
		rcdDO.setFg_success(FBoolean.FALSE);
		rcdDO.setId_emp_oper(Context.get().getStuffId());
		rcdDO.setDt_oper(BlFlowContextUtil.getNowTime());
		rcdDO.setInput(xml);
		rcdDO.setStatus(DOStatus.NEW);

		return rcdDO;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected WsResultOpGetSelfHelpPayItem doWork(WsParamSelfHelpPayItem param) throws BizException {
		WsParamSelfHelpPayInfo prepayInfo = param.getPrepay();
		
		if(IBlWsConst.ENTP_PE.equals(prepayInfo.getEntpCode())){
			WsResultOpGetSelfHelpPayItem outparam = this.pePayment(prepayInfo);
			return outparam;
		}

		// 查询患者信息
		PatDO patDO = this.findPat(prepayInfo);
		
		this.loadPm();
		
		List<BlPayOepPmDTO> pmList = new ArrayList<BlPayOepPmDTO>();
		// 组织门诊收付款接口入参
		BlPayOepDTO payoepDto = this.getPaymentInput(prepayInfo, patDO);
		
		BlPayOepPmDTO selfPayOepPmDto = null;
		if(!StringUtil.isEmpty(prepayInfo.getPaymentMethod())){
			selfPayOepPmDto = this.getPaymentDto(prepayInfo.getPaymentMethod(), 
					BlAmtConverUtil.toFDouble(prepayInfo.getPayMoney()), 
					prepayInfo.getDocumentNumber(), 
					prepayInfo.getOrderNumber(),
					prepayInfo.getBankCardNo());
			pmList.add(selfPayOepPmDto);
		}
		
		// 设置收付款医保相关数据
		if(!StringUtil.isEmpty(param.getPrepay().getCodeHp())){
			
			// 查询医保关联患者分类数据
			HPDO hpDO = super.queryHpDO(param.getPrepay().getCodeHp());
			
			InsureContext insContext = new InsureContext();
			insContext.setIdHp(hpDO.getId_hp());
			InsureFacade insFacade = new InsureFacade(insContext);
			
			OepSettleRtnValDTO hpstData = this.dealHp(patDO.getId_pat(), hpDO.getId_hp(), param, insFacade);
			if(hpstData != null){
				//添加医保账户和医保基金支付方式
				CommonPropDataDTO propDto = insFacade.hpFormulaCalculateOep(hpstData);
				
				if(propDto.getAmt_hpact() != null && propDto.getAmt_hpact().compareTo(FDouble.ZERO_DBL) > 0){
					BlPayOepPmDTO payOepPmDto = this.getPaymentDto(IBdPripmCodeConst.CODE_PRI_PM_INSUR, propDto.getAmt_hpact(), null, null, null);
					pmList.add(payOepPmDto);
				}
				
				if(propDto.getAmt_psn() != null && propDto.getAmt_psn().compareTo(FDouble.ZERO_DBL) > 0){
					BlPayOepPmDTO payOepPmDto = this.getPaymentDto(IBdPripmCodeConst.CODE_PRI_PM_INSURPERSONALACCOUNT, propDto.getAmt_psn(), null, null, null);
					pmList.add(payOepPmDto);
				}
				
				if(propDto.getAmt_hosbear() != null && propDto.getAmt_hosbear().compareTo(FDouble.ZERO_DBL) > 0){
					BlPayOepPmDTO payOepPmDto = this.getPaymentDto(IBdPripmCodeConst.CODE_PRI_PM_HPPROFITLOSS, propDto.getAmt_hosbear(), null, null, null);
					pmList.add(payOepPmDto);
				}
				
				payoepDto.setId_hp(hpDO.getId_hp());
				payoepDto.setAmt_all(this.stOepDO.getAmt_ratio());
				payoepDto.setAmt_hpall(propDto.getAmt_all());
				payoepDto.setAmt_hp(propDto.getAmt_hpact());
				payoepDto.setAmt_psnacc(propDto.getAmt_psn());
				payoepDto.setAmt_cash(propDto.getAmt_cash());
				payoepDto.setAmt_hosbear(propDto.getAmt_hosbear());
				
				FArrayList stRtnList = new FArrayList();
				stRtnList.add(hpstData);
				payoepDto.setOldpropdata(stRtnList);
			}
		}
		
		payoepDto.setAmt_pay(FDouble.ZERO_DBL);
		for (BlPayOepPmDTO blPayOepPmDTO : pmList) {
			payoepDto.setAmt_pay(payoepDto.getAmt_pay().add(blPayOepPmDTO.getAmt()));
		}
		
		// 门诊收付款接口
		IBlOepChargeCmdService oepPaymentservice = ServiceFinder.find(IBlOepChargeCmdService.class);
		BlPayOepRltDTO blPayOepRltDTO = oepPaymentservice.oepPayment(payoepDto, pmList.toArray(new BlPayOepPmDTO[0]), null);

		//处理药品窗口号
		List<WsResultOpWindowNo> windowNoList = this.handleMmWindow(blPayOepRltDTO.getId_st());
	
		// 出参
		WsResultOpGetSelfHelpPayItem outPut = new WsResultOpGetSelfHelpPayItem();
		WsResultInfoOpGetSelfHelpPayInfo outPutInfo = new WsResultInfoOpGetSelfHelpPayInfo();

		// 出参赋值
		this.getOutParam(prepayInfo, outPutInfo, blPayOepRltDTO);
		outPutInfo.setWindowNoItm(windowNoList);

		WsResultMsg rltMsg = new WsResultMsg();

		outPut.setRltInfo(outPutInfo);
		rltMsg.setCode(IBlWsConst.RLT_SUCCESS);
		rltMsg.setMessage("成功");
		outPut.setRltMsg(rltMsg);

		String outParam = outPut.serialize();
		
		String idPm = selfPayOepPmDto != null ? selfPayOepPmDto.getId_pm() : null;
		this.writebackTransSuccess(blPayOepRltDTO, outParam, idPm);
		return outPut;
	}
	
	/**
	 * 体检收费
	 * @throws BizException 
	 */
	private WsResultOpGetSelfHelpPayItem pePayment(WsParamSelfHelpPayInfo prepayInfo) throws BizException{
		
		//获取患者信息
		PatDO patDO = this.findPat(prepayInfo);
		
		this.loadPm();
		
		//组装收费入参
		List<BlPayOepPmDTO> pmList = new ArrayList<BlPayOepPmDTO>();
		BlPayOepPmDTO selfPayPePmDto = new BlPayOepPmDTO();
		
		// 查询付款方式
		PriPmDO pmDO = this.pmMap.get(prepayInfo.getPaymentMethod());
		if(pmDO == null){
			throw new BizException("未查询到支付方式信息");
		}
				
		selfPayPePmDto.setId_pm(pmDO.getId_pm());
		selfPayPePmDto.setSd_pm(prepayInfo.getPaymentMethod());
		selfPayPePmDto.setAmt(BlAmtConverUtil.toFDouble(prepayInfo.getPayMoney()));
		selfPayPePmDto.setBankno(prepayInfo.getDocumentNumber());
		selfPayPePmDto.setPaymodenode(prepayInfo.getOrderNumber());
		selfPayPePmDto.setEu_direct(1);
		selfPayPePmDto.setFg_charge(FBoolean.FALSE);
		selfPayPePmDto.setBankcardno(prepayInfo.getBankCardNo());
		pmList.add(selfPayPePmDto);
		
		BlPayOepDTO payPeDto = new BlPayOepDTO();
		
		IBlIncUtilService incUtilService = ServiceFinder.find(IBlIncUtilService.class);
		payPeDto.setId_pat(patDO.getId_pat());
		payPeDto.setId_st(prepayInfo.getPayNO());
		//payPeDto.setAmt_pay(BlAmtConverUtil.toFDouble(prepayInfo.getPayMoney()));
		payPeDto.setSd_pttp(prepayInfo.getTerminalType());// 终端类型
		if ("02".equals(prepayInfo.getInctype()) || "03".equals(prepayInfo.getInctype())) {
			payPeDto.setFg_print(FBoolean.TRUE);
			payPeDto.setIncno(incUtilService.getCurInvoiceNo(Context.get().getStuffId(), Context.get().getClientHost(),
					IBdInccaCodeConst.ID_OUTPATIENT_INVOICE));// 发票号
		} else {
			payPeDto.setFg_print(FBoolean.FALSE);
		}
		
		// 设置收付款医保相关数据
		if (!StringUtil.isEmpty(prepayInfo.getCodeHp())) {

			// 查询医保关联患者分类数据
			HPDO hpDO = super.queryHpDO(prepayInfo.getCodeHp());

			InsureContext insContext = new InsureContext();
			insContext.setIdHp(hpDO.getId_hp());
			InsureFacade insFacade = new InsureFacade(insContext);

			OepSettleRtnValDTO hpstData = this.peDealHp(patDO.getId_pat(), hpDO.getId_hp(), prepayInfo, insFacade);
			if (hpstData != null) {
				// 添加医保账户和医保基金支付方式
				CommonPropDataDTO propDto = insFacade.hpFormulaCalculateOep(hpstData);

				if (propDto.getAmt_hpact() != null && propDto.getAmt_hpact().compareTo(FDouble.ZERO_DBL) > 0) {
					BlPayOepPmDTO payOepPmDto = this.getPaymentDto(IBdPripmCodeConst.CODE_PRI_PM_INSUR,
							propDto.getAmt_hpact(), null, null, null);
					pmList.add(payOepPmDto);
				}

				if (propDto.getAmt_psn() != null && propDto.getAmt_psn().compareTo(FDouble.ZERO_DBL) > 0) {
					BlPayOepPmDTO payOepPmDto = this.getPaymentDto(IBdPripmCodeConst.CODE_PRI_PM_INSURPERSONALACCOUNT,
							propDto.getAmt_psn(), null, null, null);
					pmList.add(payOepPmDto);
				}

				if (propDto.getAmt_hosbear() != null && propDto.getAmt_hosbear().compareTo(FDouble.ZERO_DBL) > 0) {
					BlPayOepPmDTO payOepPmDto = this.getPaymentDto(IBdPripmCodeConst.CODE_PRI_PM_HPPROFITLOSS,
							propDto.getAmt_hosbear(), null, null, null);
					pmList.add(payOepPmDto);
				}

				payPeDto.setId_hp(hpDO.getId_hp());
				payPeDto.setAmt_all(this.stOepDO.getAmt_ratio());
				payPeDto.setAmt_hpall(propDto.getAmt_all());
				payPeDto.setAmt_hp(propDto.getAmt_hpact());
				payPeDto.setAmt_psnacc(propDto.getAmt_psn());
				payPeDto.setAmt_cash(propDto.getAmt_cash());
				payPeDto.setAmt_hosbear(propDto.getAmt_hosbear());

				FArrayList stRtnList = new FArrayList();
				stRtnList.add(hpstData);
				payPeDto.setOldpropdata(stRtnList);
			}
		}
		
		payPeDto.setAmt_pay(FDouble.ZERO_DBL);
		for (BlPayOepPmDTO blPayOepPmDTO : pmList) {
			payPeDto.setAmt_pay(payPeDto.getAmt_pay().add(blPayOepPmDTO.getAmt()));
		}
		
		//调用收付款接口
		IBlOepChargeCmdService oepPaymentservice = ServiceFinder.find(IBlOepChargeCmdService.class);
		BlPayOepRltDTO blPayOepRltDTO = oepPaymentservice.oepPayment(payPeDto, pmList.toArray(new BlPayOepPmDTO[0]), null);

		
		//出参赋值
		WsResultOpGetSelfHelpPayItem outparam = new WsResultOpGetSelfHelpPayItem();
		
		WsResultMsg rltMsg = new WsResultMsg();
		rltMsg.setCode(IBlWsConst.RLT_SUCCESS);
		rltMsg.setMessage("成功");
		
		WsResultInfoOpGetSelfHelpPayInfo rltInfo = new WsResultInfoOpGetSelfHelpPayInfo();
		// 收付款明细DO,该DO数组只有一个
		IBlPayItmPatOepDORService payItmPatOepService = ServiceFinder.find(IBlPayItmPatOepDORService.class);
		BlPayItmPatOepDO[] PayItmPatOepDOs = payItmPatOepService.findByAttrValString("Id_paypatoep",blPayOepRltDTO.getId_paypatoep());
		rltInfo.setOrderNumber(PayItmPatOepDOs[0].getPaymodenode());// 收单机构订单流水号
		rltInfo.setOperaCode(prepayInfo.getOperaCode());// 操作员编码
		rltInfo.setTerminalType(prepayInfo.getTerminalType());// 缴费来源01：IIH收费窗口；02：自助机；03：微信平台；04：手机APP
		rltInfo.setTerminalNO(prepayInfo.getTerminalNO());// 终端编码
		rltInfo.setPayNO(blPayOepRltDTO.getId_st());// 结算id
		rltInfo.setInctype(prepayInfo.getInctype());// 票据类型 01：小票凭证 02：发票凭证
		
		// 获得发票号
		FArrayList incIdList = blPayOepRltDTO.getId_inc();
		BlIncOepDO[] incOepDOs = new BlIncOepDO[] {};
		if (!ListUtil.isEmpty(incIdList)) {
			IBlincoepMDORService incOepRService = ServiceFinder.find(IBlincoepMDORService.class);
			incOepDOs = incOepRService.findByIds((String[]) incIdList.toArray(new String[] {}), FBoolean.TRUE);
		}
		
		if ("01".equals(prepayInfo.getInctype())) {
			rltInfo.setIncNoItm(new ArrayList<WsResultOpIncNoItm>());
		} else {
			List<WsResultOpIncNoItm> incNoList = new ArrayList<WsResultOpIncNoItm>();
			if (!ArrayUtil.isEmpty(incOepDOs)) {
				for (BlIncOepDO itm : incOepDOs) {
					WsResultOpIncNoItm incNo = new WsResultOpIncNoItm();
					incNo.setIncNo(itm.getIncno());
					incNo.setItemDetail(this.getItemDetail(itm));
					incNoList.add(incNo);
				}
			}

			rltInfo.setIncNoItm(incNoList);
		}
		
		outparam.setRltMsg(rltMsg);
		outparam.setRltInfo(rltInfo);
		return outparam;
	}

	/**
	 * 处理药品窗口号
	 * @throws BizException 
	 */
	private List<WsResultOpWindowNo> handleMmWindow(String idSt) throws BizException{
		// 根据结算id查出记账表里的药品处方信息
		List<BlCgItmOepDO> presList = this.getCgPresList(idSt);
		List<WsResultOpWindowNo> windowNoItm = new ArrayList<WsResultOpWindowNo>();
		
		if(!ListUtil.isEmpty(presList)){
			List<String> presIds = new ArrayList<String>();
			for (BlCgItmOepDO itm : presList) {
				presIds.add(itm.getId_pres());
			}
			
			//调用接口获取处方对应的窗口号
			IMpDgOutService mpDgoutService = ServiceFinder.find(IMpDgOutService.class);
			FMap mapWindow = mpDgoutService.getQueSiteNameOfPres(presIds.toArray(new String[0]));// key:处方id,value:窗口名称（多个时用逗号分隔）
			
			for (BlCgItmOepDO itm  : presList) {
				if(mapWindow.containsKey(itm.getId_pres())){
					WsResultOpWindowNo windowNo = new WsResultOpWindowNo();
					windowNo.setApplyCode(itm.getCode_apply());
					windowNo.setWindowNo(mapWindow.get(itm.getId_pres()) == null ? "" : mapWindow.get(itm.getId_pres()).toString());
					windowNoItm.add(windowNo);
				}
			}

		}
		
		return windowNoItm;
	}
	
	/**
	 * 根据结算id查出记账表里的药品处方集合
	 * @param stId
	 * @return
	 * @throws BizException 
	 */
	private List<BlCgItmOepDO> getCgPresList(String stId) throws BizException{
		StringBuilder sql = new StringBuilder();
		sql.append(" select distinct cgitm.id_pres,ent.code||'-'||pres.code code_apply ");
		sql.append(" from bl_cg_itm_oep cgitm ");
		sql.append(" inner join en_ent ent on cgitm.id_ent = ent.id_ent ");
		sql.append(" inner join ci_pres pres on cgitm.id_pres = pres.id_pres ");
		sql.append(" where cgitm.id_stoep = ? ");
		sql.append(" and cgitm.fg_mm = 'Y' ");
		sql.append(" and cgitm.fg_refund = 'N' ");
		sql.append(" and cgitm.id_pres <> '~' ");

		SqlParam param = new SqlParam();
		param.addParam(stId);
		
		List<BlCgItmOepDO> presList = (List<BlCgItmOepDO>)new DAFacade().execQuery(sql.toString(), param,new BeanListHandler(BlCgItmOepDO.class));
		
		return presList;
	}
	
	/**
	 * 成功后回写交易记录
	 * 
	 * @param prepayDO
	 * @throws BizException
	 */
	private void writebackTransSuccess(BlPayOepRltDTO blPayOepRltDTO, String outParam, String idPm)
			throws BizException {

		if (this.transRcdDO == null)
			return;

		this.transRcdDO.setFg_success(FBoolean.TRUE);
		this.transRcdDO.setId_pat(blPayOepRltDTO.getId_pat());
		this.transRcdDO.setId_pay(blPayOepRltDTO.getId_paypatoep());
		this.transRcdDO.setId_pm(idPm);
		this.transRcdDO.setOutput(outParam);
	}

	/**
	 * 出参赋值
	 * 
	 * @param outPutInfo
	 * @param blPayOepRltDTO
	 * @throws BizException
	 */
	private void getOutParam(WsParamSelfHelpPayInfo prepayInfo, WsResultInfoOpGetSelfHelpPayInfo outPutInfo,
			BlPayOepRltDTO blPayOepRltDTO) throws BizException {
		// 获得发票号
		FArrayList incIdList = blPayOepRltDTO.getId_inc();
		BlIncOepDO[] incOepDOs = new BlIncOepDO[] {};
		if (!ListUtil.isEmpty(incIdList)) {
			IBlincoepMDORService incOepRService = ServiceFinder.find(IBlincoepMDORService.class);
			incOepDOs = incOepRService.findByIds((String[]) incIdList.toArray(new String[] {}), FBoolean.TRUE);
		}

		// 收付款明细DO,该DO数组只有一个
		IBlPayItmPatOepDORService payItmPatOepService = ServiceFinder.find(IBlPayItmPatOepDORService.class);
		BlPayItmPatOepDO[] PayItmPatOepDOs = payItmPatOepService.findByAttrValString("Id_paypatoep",
				blPayOepRltDTO.getId_paypatoep());

		// 获得指引单提示执行科室位置
		String guideSheetInfo = this.getGuideSheetInfo(blPayOepRltDTO);

		// 出参赋值
		outPutInfo.setGuideInfo(guideSheetInfo == null ? "" : guideSheetInfo);// 指引单提示执行科室位置
		outPutInfo.setOrderNumber(PayItmPatOepDOs[0].getPaymodenode());// 收单机构订单流水号
		outPutInfo.setOperaCode(prepayInfo.getOperaCode());// 操作员编码
		outPutInfo.setTerminalType(prepayInfo.getTerminalType());// 缴费来源01：IIH收费窗口；02：自助机；03：微信平台；04：手机APP
		outPutInfo.setTerminalNO(prepayInfo.getTerminalNO());// 终端编码
		outPutInfo.setPayNO(blPayOepRltDTO.getId_st());// 结算id
		outPutInfo.setInctype(prepayInfo.getInctype());// 票据类型 01：小票凭证 02：发票凭证
		if ("01".equals(prepayInfo.getInctype())) {
			outPutInfo.setIncNoItm(new ArrayList<WsResultOpIncNoItm>());
		} else {
			List<WsResultOpIncNoItm> incNoList = new ArrayList<WsResultOpIncNoItm>();
			if (!ArrayUtil.isEmpty(incOepDOs)) {
				for (BlIncOepDO itm : incOepDOs) {
					WsResultOpIncNoItm incNo = new WsResultOpIncNoItm();
					incNo.setIncNo(itm.getIncno());
					incNo.setItemDetail(this.getItemDetail(itm));
					incNoList.add(incNo);
				}
			}

			outPutInfo.setIncNoItm(incNoList);
		}
		outPutInfo.setNote("");// 提示信息
	}

	/**
	 * 获得指引单提示执行科室位置
	 * 
	 * @return
	 * @throws BizException
	 */
	private String getGuideSheetInfo(BlPayOepRltDTO blPayOepRltDTO) throws BizException {

		StringBuffer sb = new StringBuffer();
		sb.append(" select dep.id_plc ");
		sb.append(" from bl_cg_itm_oep cgitmoep ");
		sb.append(" left join bd_dep dep on dep.id_dep = cgitmoep.id_dep_mp ");
		sb.append(" where 1=1 ");
		sb.append(" and cgitmoep.id_stoep = ? ");

		// 对占位符的赋值
		SqlParam sp = new SqlParam();
		if (StringUtil.isEmpty(blPayOepRltDTO.getId_st())) {
			throw new BizException("未获取到结算号");
		}
		sp.addParam(blPayOepRltDTO.getId_st());

		// 执行sql语句
		@SuppressWarnings("unchecked")
		List<String> guideSheetList = (List<String>) new DAFacade().execQuery(sb.toString(), sp,
				new ColumnListHandler());

		String guideSheet = "";
		if (guideSheetList.size() > 0) {
			for (int i = 0; i < guideSheetList.size(); i++) {
				if (i == guideSheetList.size() - 1) {
					guideSheet = guideSheet + (guideSheetList.get(i) == null ? "" : guideSheetList.get(i));
				} else {
					guideSheet = guideSheet + (guideSheetList.get(i) == null ? "" : guideSheetList.get(i)) + "|";
				}
			}
		}

		return guideSheet;
	}

	/**
	 * 获得一张发票上的明细信息
	 */
	private List<WsResultOpitemDetail> getItemDetail(BlIncOepDO itm) throws BizException {
		StringBuffer sb = new StringBuffer();
		sb.append(" select ");
		sb.append(" cgitmoep.name_srv itemName, ");
		sb.append(" cgitmoep.spec itemSpec, ");
		sb.append(" cgitmoep.quan itemNum, ");
		sb.append(" cgitmoep.price_ratio itemPrice, ");
		sb.append(" cgitmoep.amt_ratio*cgoep.eu_direct itemAmt ");
		sb.append(" from bl_inc_oep incoep ");
		sb.append(" left join bl_inc_cg_itm_oep incitmoep on incoep.id_incoep = incitmoep.id_incoep ");
		sb.append(" left join bl_cg_itm_oep cgitmoep on cgitmoep.id_cgitmoep = incitmoep.id_cgitmoep ");
		sb.append(" left join bl_cg_oep cgoep on cgoep.id_cgoep = cgitmoep.id_cgoep ");
		sb.append(" where 1=1 ");
		sb.append(" and incoep.incno = ? ");

		// 对占位符的赋值
		SqlParam sp = new SqlParam();
		if (StringUtil.isEmpty(itm.getIncno())) {
			throw new BizException("未获取到发票号");
		}
		sp.addParam(itm.getIncno());

		// 执行sql语句
		@SuppressWarnings("unchecked")
		List<WsResultOpitemDetail> list = (List<WsResultOpitemDetail>) new DAFacade().execQuery(sb.toString(), sp,
				new BeanListHandler(WsResultOpitemDetail.class));

		// 价格由元转为分
		for (WsResultOpitemDetail itmChild : list) {
			itmChild.setItemPrice(BlAmtConverUtil.toXmlString(new FDouble(itmChild.getItemPrice())));
			itmChild.setItemAmt(BlAmtConverUtil.toXmlString(new FDouble(itmChild.getItemAmt())));
		}
		return list;
	}

	// /**
	// * 获得根据入参就诊信息和医疗单编码而过滤后的明细集合
	// *
	// * @param oepChargeInputDTOs
	// * @param prepayInfo
	// * @return
	// */
	// private List<BlOepChargeInputDTO> getFilterList(BlOepChargeInputDTO[]
	// oepChargeInputDTOs,
	// WsParamSelfHelpPayInfo prepayInfo) {
	// // 按照就诊分组
	// Map<String, List<BlOepChargeInputDTO>> map = new HashMap<String,
	// List<BlOepChargeInputDTO>>();// key为就诊id,value为该就诊下的明细集合
	// for (BlOepChargeInputDTO itm : oepChargeInputDTOs) {
	// if (map.containsKey(itm.getId_ent())) {
	// map.get(itm.getId_ent()).add(itm);
	// } else {
	// List<BlOepChargeInputDTO> itmList = new ArrayList<BlOepChargeInputDTO>();
	// itmList.add(itm);
	// map.put(itm.getId_ent(), itmList);
	// }
	// }
	// // 根据入参就诊信息和医疗单(药品为处方，其他为医嘱)过滤数据获得本次明细信息
	// List<WsResultSingleEntInfo> entInputInfo = prepayInfo.getOepEntList();//
	// 入参就诊信息
	// IPativisitRService entService =
	// ServiceFinder.find(IPativisitRService.class);
	// List<BlOepChargeInputDTO> inputAllEntItm = new
	// ArrayList<BlOepChargeInputDTO>();// 入参就诊信息下的所有明细
	// List<String> inputAllApplyCode = new ArrayList<String>();//
	// 所有医疗单编码（其中药品的医疗单只获取去掉就诊编码的处方单号）
	// List<BlOepChargeInputDTO> inputFilterItm = new
	// ArrayList<BlOepChargeInputDTO>();// 根据入参最终过滤出明细
	// // 获得入参就诊信息下的所有明细
	// for (WsResultSingleEntInfo itm : entInputInfo) {
	// // 就诊编码转就诊id
	// String entId = (entService.findByAttrValString("Code",
	// itm.getEntCode()))[0].getId_ent();
	// if (map.containsKey(entId)) {
	// inputAllEntItm.addAll(map.get(entId));
	// }
	// }
	// // 获得所有医疗单编码（其中药品的医疗单只获取去掉就诊编码的处方单号）
	// for (WsResultSingleEntInfo itm : entInputInfo) {
	// List<WsResultSinglePresInfo> applyItm = itm.getEntPresList();
	// for (WsResultSinglePresInfo itmChild : applyItm) {
	// if (itmChild.getApplyCode().contains("-")) {
	// String presCode = (itmChild.getApplyCode().split("-"))[1];
	// if (!inputAllApplyCode.contains(presCode)) {
	// inputAllApplyCode.add(presCode);
	// }
	// } else {
	// inputAllApplyCode.add(itmChild.getApplyCode());
	// }
	// }
	// }
	// // 根据所有医疗单编码过滤明细
	// for (String itm : inputAllApplyCode) {
	// for (BlOepChargeInputDTO itmChild : inputAllEntItm) {
	// if (itm.equals(itmChild.医疗单编码)) {
	// inputFilterItm.add(itmChild);
	// }
	// }
	// }
	// return inputFilterItm;
	// }
	
	/**
	 * 设置支付方式
	 * @param codePm
	 * @param amt
	 * @return
	 */
	private BlPayOepPmDTO getPaymentDto(String codePm, FDouble amt,String bankno,String paymodenode,String bankCardNo) throws BizException {
		
		// 查询付款方式
		PriPmDO pmDO = this.pmMap.get(codePm);
		if(pmDO == null){
			throw new BizException("未查询到支付方式信息");
		}
		
		BlPayOepPmDTO payOepPmDto = new BlPayOepPmDTO();
		payOepPmDto.setId_pm(pmDO.getId_pm());
		payOepPmDto.setSd_pm(codePm);
		payOepPmDto.setAmt(amt);
		payOepPmDto.setBankno(bankno);
		payOepPmDto.setPaymodenode(paymodenode);
		payOepPmDto.setEu_direct(1);
		payOepPmDto.setFg_charge(FBoolean.FALSE);
		payOepPmDto.setBankcardno(bankCardNo);
		
		return payOepPmDto;
	}

	/**
	 * 门诊收付款接口入参
	 * 
	 * @param prepayInfo
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	private BlPayOepDTO getPaymentInput(WsParamSelfHelpPayInfo prepayInfo, PatDO patDO) throws BizException {
		IBlIncUtilService incUtilService = ServiceFinder.find(IBlIncUtilService.class);
		BlPayOepDTO payoepDto = new BlPayOepDTO();
		payoepDto.setId_pat(patDO.getId_pat());
		payoepDto.setId_st(prepayInfo.getPayNO());
		//payoepDto.setAmt_pay(BlAmtConverUtil.toFDouble(prepayInfo.getPayMoney()));
		payoepDto.setSd_pttp(prepayInfo.getTerminalType());// 终端类型
		if ("02".equals(prepayInfo.getInctype()) || "03".equals(prepayInfo.getInctype())) {
			payoepDto.setFg_print(FBoolean.TRUE);
			payoepDto.setIncno(incUtilService.getCurInvoiceNo(Context.get().getStuffId(), Context.get().getClientHost(),
					IBdInccaCodeConst.ID_OUTPATIENT_INVOICE));// 发票号
		} else {
			payoepDto.setFg_print(FBoolean.FALSE);
		}
		
		IPatientcategoryRService patcaService = ServiceFinder.find(IPatientcategoryRService.class);
		if(StringUtil.isEmpty(prepayInfo.getPatCaCode())){
			//入参患者分类编码为空时，首先取患者分类表中默认标志为Y的数据，如果取不到，则取患者表中的患者分类
			PiPatCaDO[] patCaDOs = patcaService.find(" fg_def = 'Y' ", "", FBoolean.FALSE);
			if(!ArrayUtil.isEmpty(patCaDOs)){
				payoepDto.setId_patca(patCaDOs[0].getId_patca());
			}else{
				payoepDto.setId_patca(patDO.getId_paticate());
			}
		}else{
			PiPatCaDO[] patCaDOs = patcaService.findByAttrValString(PiPatCaDO.CODE, prepayInfo.getPatCaCode());
			if(ArrayUtil.isEmpty(patCaDOs)){
				throw new BizException("根据患者分类编码没有查到对应数据");
			}
			payoepDto.setId_patca(patCaDOs[0].getId_patca());
		}
		
		return payoepDto;
	}

	/**
	 * 查询患者
	 * 
	 * @param prepayInfo
	 * @return
	 * @throws BizException
	 */
	private PatDO findPat(WsParamSelfHelpPayInfo prepayInfo) throws BizException {

		IPiRegQryService regQryService = ServiceFinder.find(IPiRegQryService.class);
		PiPatFuzyyQueryCondDTO condDto = new PiPatFuzyyQueryCondDTO();
		condDto.setPat_code(prepayInfo.getPatCode());
		condDto.setId_code(prepayInfo.getSdCode());
		condDto.setCard_code(prepayInfo.getCardCode());

		PatiAggDO[] patiAggs = regQryService.fuzzyQueryPati(condDto);
		if (ArrayUtil.isEmpty(patiAggs)) {
			throw new BizException("未查询到患者信息");
		}

		return patiAggs[0].getParentDO();
	}

	/**
	 * 处理体检医保
	 * @param patId
	 * @param stId
	 * @param hpId
	 * @param insFacade
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private OepSettleRtnValDTO peDealHp(String patId, String hpId, WsParamSelfHelpPayInfo prepayInfo, InsureFacade insFacade) throws BizException {
		
		MiOepChargePaySelfInParamDTO inParam = new MiOepChargePaySelfInParamDTO();
		inParam.setId_pat(patId);
		
		String stId = prepayInfo.getPayNO();
		
		IBlstoepRService stService = ServiceFinder.find(IBlstoepRService.class);
		this.stOepDO = stService.findById(stId);
		
		IBlCgItmOepDORService cgService = ServiceFinder.find(IBlCgItmOepDORService.class);
		BlCgItmOepDO[] cgItms = cgService.findByAttrValString(BlCgItmOepDO.ID_STOEP, stId);
		
		FArrayList stFList = new FArrayList();
		FArrayList cgFList = new FArrayList();
		
		stFList.add(this.stOepDO);
		cgFList.addAll(Arrays.asList(cgItms));
		inParam.setStinfo(stFList);
		inParam.setCgtiminfo(cgFList);
		
		inParam.setStr_hpcard(prepayInfo.getHpInfo().getHpCardInfo());
		inParam.setStr_hpregisterrtn(prepayInfo.getHpInfo().getHpRegisterRtnInfo());
		inParam.setStr_detailuploadrtn(prepayInfo.getHpInfo().getHpDetailUploadRtnInfo());
		inParam.setStr_hpstrtn(prepayInfo.getHpInfo().getHpStRtnInfo());
		
		ResultOutParamDTO<MiOepChargePaySelfOutParamDTO> rlt = insFacade.oepPaySelf(inParam);
		
		if(FBoolean.FALSE.equals(rlt.getFg_deal())){
			return null;
		}
		
		if(FBoolean.FALSE.equals(rlt.getFg_HpSuccess())){
			throw new BizException("医保付款处理失败："+ rlt.getErrorMsg());
		}
		
		if(ListUtil.isEmpty(rlt.getData().getOldpropdata())){
			throw new BizException("医保付款处理返回值设值为空");
		}
		OepSettleRtnValDTO rltData = (OepSettleRtnValDTO)rlt.getData().getOldpropdata().get(0);
		
		String entId = null;
		for (BlCgItmOepDO cgItm : cgItms) {
			if(!StringUtil.isEmpty(cgItm.getId_ent())){
				entId = cgItm.getId_ent();
				break;
			}
		}
		
		//保存医保登记信息
		IHpentcodeoepCudService entCodeService = ServiceFinder.find(IHpentcodeoepCudService.class);
		HpEntCodeOepDO entCodeDO = new HpEntCodeOepDO();
		entCodeDO.setId_pat(patId);
		PatiVisitDO entDO  = null;
		if(!StringUtil.isEmpty(entId)){
			DAFacade daf = new DAFacade();
			entDO  = (PatiVisitDO)daf.findByPK(PatiVisitDO.class, entId);
			entCodeDO.setId_ent(entId);
			entCodeDO.setCode_ent(entDO.getCode());
		}
		entCodeDO.setHp_ent_serialno(this.stOepDO.getCode_st());
		entCodeDO.setFg_active(FBoolean.TRUE);
		entCodeDO.setCode_his(null);
		entCodeDO.setFg_lock(FBoolean.FALSE);
		entCodeDO.setDt_reg(new FDateTime());
		//entCodeDO.setNo_hp(No_hp); TODO
		entCodeDO.setId_org(Context.get().getOrgId());
		entCodeDO.setId_grp(Context.get().getGroupId());
		entCodeDO.setId_hp(hpId);
		entCodeDO.setEu_direct(1);
		entCodeDO.setEu_exstatus("01");
		entCodeDO.setRead_card_info(inParam.getStr_hpcard());
		entCodeDO.setRegist_info(inParam.getStr_hpregisterrtn());
		entCodeDO.setId_patca(this.stOepDO.getId_patca());
		entCodeDO.setCode_st(this.stOepDO.getCode_st());
		entCodeService.insert(new HpEntCodeOepDO[] { entCodeDO });
		
		//保存医保交易信息
		IHptranactoepCudService hpTransService = ServiceFinder.find(IHptranactoepCudService.class);
		HpTransactOepDO transDO = new HpTransactOepDO();
		transDO.setId_grp(Context.get().getGroupId());
		transDO.setId_org(Context.get().getOrgId());
		transDO.setBusiness_code(prepayInfo.getHpInfo().getBusiCode());
		if(entDO != null){
			transDO.setCode_entp(entDO.getCode_entp());
			transDO.setEnt_code(entDO.getCode());
			transDO.setId_ent(entDO.getId_ent());
		}
		transDO.setHp_ent_serial_no(this.stOepDO.getCode_st());
		transDO.setDt_transact(new FDateTime());
		transDO.setId_emp_opr(Context.get().getStuffId());
		transDO.setCode_his(null);
		transDO.setCode_hp(rlt.getCenterTradeNo());
		transDO.setFg_cancel(FBoolean.FALSE);
		transDO.setEu_direct(1);
		transDO.setId_pat(patId);
		transDO.setStatus_trans(EuTransStatus.SETTLED);
		transDO.setSrcfunc_des("selfpay");
		transDO.setInputinfo(prepayInfo.getHpInfo().getHpStInfo());
		transDO.setCode_medkind(rltData.getCode_medkind());
		transDO.setOutputinfo(inParam.getStr_hpstrtn());
		hpTransService.insert(new HpTransactOepDO[] { transDO });
		
		return rltData;
	}
	
	/**
	 * 处理医保
	 * @param patId
	 * @param stId
	 * @param hpId
	 * @param insFacade
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private OepSettleRtnValDTO dealHp(String patId, String hpId, WsParamSelfHelpPayItem param, InsureFacade insFacade) throws BizException {
		
		MiOepChargePaySelfInParamDTO inParam = new MiOepChargePaySelfInParamDTO();
		inParam.setId_pat(patId);
		
		String stId = param.getPrepay().getPayNO();
		
		IBlstoepRService stService = ServiceFinder.find(IBlstoepRService.class);
		this.stOepDO = stService.findById(stId);
		
		IBlCgItmOepDORService cgService = ServiceFinder.find(IBlCgItmOepDORService.class);
		BlCgItmOepDO[] cgItms = cgService.findByAttrValString(BlCgItmOepDO.ID_STOEP, stId);
		
		FArrayList stFList = new FArrayList();
		FArrayList cgFList = new FArrayList();
		
		stFList.add(this.stOepDO);
		cgFList.addAll(Arrays.asList(cgItms));
		inParam.setStinfo(stFList);
		inParam.setCgtiminfo(cgFList);
		
		inParam.setStr_hpcard(param.getPrepay().getHpInfo().getHpCardInfo());
		inParam.setStr_hpregisterrtn(param.getPrepay().getHpInfo().getHpRegisterRtnInfo());
		inParam.setStr_detailuploadrtn(param.getPrepay().getHpInfo().getHpDetailUploadRtnInfo());
		inParam.setStr_hpstrtn(param.getPrepay().getHpInfo().getHpStRtnInfo());
		
		ResultOutParamDTO<MiOepChargePaySelfOutParamDTO> rlt = insFacade.oepPaySelf(inParam);
		
		if(FBoolean.FALSE.equals(rlt.getFg_deal())){
			return null;
		}
		
		if(FBoolean.FALSE.equals(rlt.getFg_HpSuccess())){
			throw new BizException("医保付款处理失败："+ rlt.getErrorMsg());
		}
		
		if(ListUtil.isEmpty(rlt.getData().getOldpropdata())){
			throw new BizException("医保付款处理返回值设值为空");
		}
		OepSettleRtnValDTO rltData = (OepSettleRtnValDTO)rlt.getData().getOldpropdata().get(0);
		
		String entId = null;
		for (BlCgItmOepDO cgItm : cgItms) {
			if(!StringUtil.isEmpty(cgItm.getId_ent())){
				entId = cgItm.getId_ent();
				break;
			}
		}
		
		//保存医保登记信息
		IHpentcodeoepCudService entCodeService = ServiceFinder.find(IHpentcodeoepCudService.class);
		HpEntCodeOepDO entCodeDO = new HpEntCodeOepDO();
		entCodeDO.setId_pat(patId);
		PatiVisitDO entDO  = null;
		if(!StringUtil.isEmpty(entId)){
			DAFacade daf = new DAFacade();
			entDO  = (PatiVisitDO)daf.findByPK(PatiVisitDO.class, entId);
			entCodeDO.setId_ent(entId);
			entCodeDO.setCode_ent(entDO.getCode());
		}
		entCodeDO.setHp_ent_serialno(this.stOepDO.getCode_st());
		entCodeDO.setFg_active(FBoolean.TRUE);
		entCodeDO.setCode_his(null);
		entCodeDO.setFg_lock(FBoolean.FALSE);
		entCodeDO.setDt_reg(new FDateTime());
		//entCodeDO.setNo_hp(No_hp); TODO
		entCodeDO.setId_org(Context.get().getOrgId());
		entCodeDO.setId_grp(Context.get().getGroupId());
		entCodeDO.setId_hp(hpId);
		entCodeDO.setEu_direct(1);
		entCodeDO.setEu_exstatus("01");
		entCodeDO.setRead_card_info(inParam.getStr_hpcard());
		entCodeDO.setRegist_info(inParam.getStr_hpregisterrtn());
		entCodeDO.setId_patca(this.stOepDO.getId_patca());
		entCodeDO.setCode_st(this.stOepDO.getCode_st());
		entCodeService.insert(new HpEntCodeOepDO[] { entCodeDO });
		
		//保存医保交易信息
		IHptranactoepCudService hpTransService = ServiceFinder.find(IHptranactoepCudService.class);
		HpTransactOepDO transDO = new HpTransactOepDO();
		transDO.setId_grp(Context.get().getGroupId());
		transDO.setId_org(Context.get().getOrgId());
		transDO.setBusiness_code(param.getPrepay().getHpInfo().getBusiCode());
		if(entDO != null){
			transDO.setCode_entp(entDO.getCode_entp());
			transDO.setEnt_code(entDO.getCode());
			transDO.setId_ent(entDO.getId_ent());
		}
		transDO.setHp_ent_serial_no(this.stOepDO.getCode_st());
		transDO.setDt_transact(new FDateTime());
		transDO.setId_emp_opr(Context.get().getStuffId());
		transDO.setCode_his(null);
		transDO.setCode_hp(rlt.getCenterTradeNo());
		transDO.setFg_cancel(FBoolean.FALSE);
		transDO.setEu_direct(1);
		transDO.setId_pat(patId);
		transDO.setStatus_trans(EuTransStatus.SETTLED);
		transDO.setSrcfunc_des("selfpay");
		transDO.setInputinfo(param.getPrepay().getHpInfo().getHpStInfo());
		transDO.setCode_medkind(rltData.getCode_medkind());
		transDO.setOutputinfo(inParam.getStr_hpstrtn());
		hpTransService.insert(new HpTransactOepDO[] { transDO });
		
		return rltData;
	}
	
	/**
	 * 加载支付方式
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void loadPm() throws BizException {
		this.pmMap = new HashMap<String, PriPmDO>();
		DAFacade daf = new DAFacade();

		List<PriPmDO> pmList = (List<PriPmDO>) daf.findByCond(PriPmDO.class, "ds = 0");
		if(ListUtil.isEmpty(pmList))
			return;
		
		for (PriPmDO priPmDO : pmList) {
			this.pmMap.put(priPmDO.getCode(), priPmDO);
		}
	}
}
