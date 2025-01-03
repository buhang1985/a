package iih.ei.std.s.v1.bp.bl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.incca.i.IBdInccaCodeConst;
import iih.bd.pp.pripm.d.PriPmDO;
import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.bd.res.workstation.d.WorkStationPcDO;
import iih.bd.res.workstation.i.IWorkstationRService;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.i.IBlCgItmOepDORService;
import iih.bl.hp.hpentcodeoep.d.HpEntCodeOepDO;
import iih.bl.hp.hpentcodeoep.i.IHpentcodeoepCudService;
import iih.bl.hp.hptranactoep.d.HpTransactOepDO;
import iih.bl.hp.hptranactoep.i.IHptranactoepCudService;
import iih.bl.hp.hptransactah.d.EuTransStatus;
import iih.bl.inc.blincoep.d.BlIncOepDO;
import iih.bl.inc.blincoep.i.IBlincoepMDORService;
import iih.bl.inc.i.IBlIncUtilService;
import iih.bl.itf.std.bean.constant.IBlWsConst;
import iih.bl.params.BlParams;
import iih.bl.st.blpaypatoep.d.BlPayItmPatOepDO;
import iih.bl.st.blpaypatoep.i.IBlPayItmPatOepDORService;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.blstoep.i.IBlstoepRService;
import iih.bl.st.dto.blpayoep.d.BlPayOepDTO;
import iih.bl.st.dto.blpayoep.d.BlPayOepPmDTO;
import iih.bl.st.dto.blpayoep.d.BlPayOepRltDTO;
import iih.bl.st.i.IBlOepChargeCmdService;
import iih.ei.std.d.v1.bl.oppaydto.d.HpInfo;
import iih.ei.std.d.v1.bl.oppaydto.d.IncInfo;
import iih.ei.std.d.v1.bl.oppaydto.d.IncItmInfo;
import iih.ei.std.d.v1.bl.oppaydto.d.OpPayParamDTO;
import iih.ei.std.d.v1.bl.oppaydto.d.OpPayResultDTO;
import iih.ei.std.d.v1.bl.oppaydto.d.WindowNoInfo;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.ei.std.s.v1.bp.bl.utils.BlAmtConverUtil;
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

/***
 * 门诊收款
 * 
 * @author shaokx
 * @date: 2019.10.15
 */
public class OpPayBP extends IIHServiceBaseBP<OpPayParamDTO, OpPayResultDTO> {

    private Map<String, PriPmDO> pmMap;
	
	private BlStOepDO stOepDO;
	
	@Override
	protected void checkParam(OpPayParamDTO param) throws BizException {
		if (param == null) {
			throw new BizException("入参为空");
		}

		if (StringUtil.isEmpty(param.getCode_hospital())) {
			throw new BizException("入参医院编码为空");
		}

		if (StringUtil.isEmpty(param.getCode_enttp())) {
			throw new BizException("入参就诊类型为空");
		}

		if (!IBlWsConst.ENTP_OP.equals(param.getCode_enttp())) {
			throw new BizException("就诊类型值不正确");
		}

		if (StringUtil.isEmpty(param.getCode_pat()) && StringUtil.isEmpty(param.getCode_card())
				&& StringUtil.isEmpty(param.getCode_idnum())) {
			throw new BizException("入参关键信息全为空:患者编码,就诊卡号,身份证号");
		}
		
		if(StringUtil.isEmpty(param.getCode_pm())){
			throw new BizException("入参支付方式为空");
		}
		
		if(StringUtil.isEmpty(param.getAmt())){
			throw new BizException("入参支付金额为空");
		}
		
		if(!BlAmtConverUtil.isNumeric(param.getAmt())){
			throw new BizException("入参支付金额值不正确");
		}
		
		if(StringUtil.isEmpty(param.getCode_opera())){
			throw new BizException("入参操作员编码为空");
		}
		
		if(StringUtil.isEmpty(param.getSd_pttp())){
			throw new BizException("入参终端类型为空");
		}
		
		if(!BlAmtConverUtil.checkTerminalType(param.getSd_pttp())){
			throw new BizException("入参终端类型值不正确");
		}
		
		if(StringUtil.isEmpty(param.getInc_type())){
			throw new BizException("入参票据类型为空");
		}
		
		if(!"01".equals(param.getInc_type()) && !"02".equals(param.getInc_type()) && !"03".equals(param.getInc_type())){
			throw new BizException("入参票据类型值不正确");
		}
		
		if(StringUtil.isEmpty(param.getPayno())){
			throw new BizException("入参结算id为空");
		}
		
		if(!BlParams.BLSTOEP0067().booleanValue() && new FDouble(param.getAmt()).compareTo(FDouble.ZERO_DBL) == 0){
			throw new BizException("门诊自助收付款:不允许0元收付款");
		}
		
		// 设置人员上下文
		PsnDocDO psndocDO = BlAmtConverUtil.getPsnInfo(param.getCode_opera());
		if (psndocDO == null) {
			throw new BizException("门诊自助收付款:未查询到人员信息");
		}
		Context.get().setStuffId(psndocDO.getId_psndoc());
		
		//设置计算机上下文
		if(!StringUtil.isEmpty(param.getPcid())){
			IWorkstationRService pcRService = ServiceFinder.find(IWorkstationRService.class);
			WorkStationPcDO[] pcDOs = pcRService.findByAttrValString(WorkStationPcDO.PCID, param.getPcid());
			if(ArrayUtil.isEmpty(pcDOs)){
				throw new BizException("该计算机标识没有维护");
			}
			Context.get().setClientHost(param.getPcid());
		}

	}

	@Override
	protected OpPayResultDTO process(OpPayParamDTO param) throws BizException {

		// 查询患者信息
		PatDO patDo = this.findPat(param);
		
		this.loadPm();
		
		List<BlPayOepPmDTO> pmList = new ArrayList<BlPayOepPmDTO>();
		// 组织门诊收付款接口入参
		BlPayOepDTO payoepDto = this.getPaymentInput(param, patDo);
		
		BlPayOepPmDTO selfPayOepPmDto = null;
		if(!StringUtil.isEmpty(param.getCode_pm())){
			selfPayOepPmDto = this.getPaymentDto(param.getCode_pm(), 
					BlAmtConverUtil.toFDouble(param.getAmt()), 
					param.getBankno(), 
					param.getPaymodenode());
			pmList.add(selfPayOepPmDto);
		}
		
		// 设置收付款医保相关数据
		if(!StringUtil.isEmpty(param.getCode_hp())){
			
			// 查询医保关联患者分类数据
			HPDO hpDO = BlAmtConverUtil.queryHpDO(param.getCode_hp());
			
			InsureContext insContext = new InsureContext();
			insContext.setIdHp(hpDO.getId_hp());
			InsureFacade insFacade = new InsureFacade(insContext);
			
			OepSettleRtnValDTO hpstData = this.dealHp(patDo.getId_pat(), hpDO.getId_hp(), param, insFacade);
			if(hpstData != null){
				//添加医保账户和医保基金支付方式
				CommonPropDataDTO propDto = insFacade.hpFormulaCalculateOep(hpstData);
				
				if(propDto.getAmt_hpact() != null && propDto.getAmt_hpact().compareTo(FDouble.ZERO_DBL) > 0){
					BlPayOepPmDTO payOepPmDto = this.getPaymentDto(IBdPripmCodeConst.CODE_PRI_PM_INSUR, propDto.getAmt_hpact(), null, null);
					pmList.add(payOepPmDto);
				}
				
				if(propDto.getAmt_psn() != null && propDto.getAmt_psn().compareTo(FDouble.ZERO_DBL) > 0){
					BlPayOepPmDTO payOepPmDto = this.getPaymentDto(IBdPripmCodeConst.CODE_PRI_PM_INSURPERSONALACCOUNT, propDto.getAmt_psn(), null, null);
					pmList.add(payOepPmDto);
				}
				
				if(propDto.getAmt_hosbear() != null && propDto.getAmt_hosbear().compareTo(FDouble.ZERO_DBL) > 0){
					BlPayOepPmDTO payOepPmDto = this.getPaymentDto(IBdPripmCodeConst.CODE_PRI_PM_HPPROFITLOSS, propDto.getAmt_hosbear(), null, null);
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
		FArrayList windowNoList = this.handleMmWindow(blPayOepRltDTO.getId_st());
		
		// 出参赋值
		OpPayResultDTO outPut1 = new OpPayResultDTO();
		this.getOutParam(param, outPut1, blPayOepRltDTO);
		outPut1.setWindownoinfo(windowNoList);

		//String idPm = selfPayOepPmDto != null ? selfPayOepPmDto.getId_pm() : null;
		//this.writebackTransSuccess(blPayOepRltDTO, outParam, idPm);
		return outPut1;
	}
	
	
	/**
	 * 处理药品窗口号
	 * @throws BizException 
	 */
	private FArrayList handleMmWindow(String idSt) throws BizException{
		// 根据结算id查出记账表里的药品处方信息
		List<BlCgItmOepDO> presList = this.getCgPresList(idSt);
		FArrayList windowNoItm = new FArrayList();
		
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
					WindowNoInfo windowNo = new WindowNoInfo();
					windowNo.setCode_apply(itm.getCode_apply());
					windowNo.setWindowno(mapWindow.get(itm.getId_pres()) == null ? "" : mapWindow.get(itm.getId_pres()).toString());
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
	
//	/**
//	 * 成功后回写交易记录
//	 * 
//	 * @param prepayDO
//	 * @throws BizException
//	 */
//	private void writebackTransSuccess(BlPayOepRltDTO blPayOepRltDTO, String outParam, String idPm)
//			throws BizException {
//
//		if (this.transRcdDO == null)
//			return;
//
//		this.transRcdDO.setFg_success(FBoolean.TRUE);
//		this.transRcdDO.setId_pat(blPayOepRltDTO.getId_pat());
//		this.transRcdDO.setId_pay(blPayOepRltDTO.getId_paypatoep());
//		this.transRcdDO.setId_pm(idPm);
//		this.transRcdDO.setOutput(outParam);
//	}

	/**
	 * 出参赋值
	 * 
	 * @param outPutInfo
	 * @param blPayOepRltDTO
	 * @throws BizException
	 */
	private void getOutParam(OpPayParamDTO param, OpPayResultDTO outPutInfo,
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
		outPutInfo.setGuideinfo(guideSheetInfo == null ? "" : guideSheetInfo);// 指引单提示执行科室位置
		outPutInfo.setPaymodenode(PayItmPatOepDOs[0].getPaymodenode());// 收单机构订单流水号
		outPutInfo.setCode_opera(param.getCode_opera());// 操作员编码
		outPutInfo.setSd_pttp(param.getSd_pttp());// 缴费来源01：IIH收费窗口；02：自助机；03：微信平台；04：手机APP
		//outPutInfo.setTerminalNO(param.getTerminalNO());// 终端编码,感觉没用，先去掉
		outPutInfo.setPayno(blPayOepRltDTO.getId_st());// 结算id
		outPutInfo.setInc_type(param.getInc_type());// 票据类型 01：小票凭证 02：发票凭证
		if ("01".equals(param.getInc_type())) {
			outPutInfo.setIncinfo(new FArrayList());
		} else {
			FArrayList incNoList = new FArrayList();
			if (!ArrayUtil.isEmpty(incOepDOs)) {
				for (BlIncOepDO itm : incOepDOs) {
					IncInfo incNo = new IncInfo();
					incNo.setIncno(itm.getIncno());
					incNo.setIncitminfo(this.getItemDetail(itm));
					incNoList.add(incNo);
				}
			}

			outPutInfo.setIncinfo(incNoList);
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
	private FArrayList getItemDetail(BlIncOepDO itm) throws BizException {
		StringBuffer sb = new StringBuffer();
		sb.append(" select ");
		sb.append(" cgitmoep.name_srv, ");
		sb.append(" cgitmoep.spec, ");
		sb.append(" cgitmoep.quan, ");
		sb.append(" cgitmoep.price_ratio price, ");
		sb.append(" cgitmoep.amt_ratio*cgoep.eu_direct amt ");
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
		List<IncItmInfo> list = (List<IncItmInfo>) new DAFacade().execQuery(sb.toString(), sp,
				new BeanListHandler(IncItmInfo.class));

		// 价格由元转为分
		for (IncItmInfo itmChild : list) {
			itmChild.setPrice(BlAmtConverUtil.toXmlString(new FDouble(itmChild.getPrice())));
			itmChild.setAmt(BlAmtConverUtil.toXmlString(new FDouble(itmChild.getAmt())));
		}
		FArrayList arr = new FArrayList();
		arr.addAll(list);
		return arr;
	}

	
	/**
	 * 设置支付方式
	 * @param codePm
	 * @param amt
	 * @return
	 */
	private BlPayOepPmDTO getPaymentDto(String codePm, FDouble amt,String bankno,String paymodenode) throws BizException {
		
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
	private BlPayOepDTO getPaymentInput(OpPayParamDTO param, PatDO patDo) throws BizException {
		IBlIncUtilService incUtilService = ServiceFinder.find(IBlIncUtilService.class);
		BlPayOepDTO payoepDto = new BlPayOepDTO();
		payoepDto.setId_pat(patDo.getId_pat());
		payoepDto.setId_st(param.getPayno());
		//payoepDto.setAmt_pay(BlAmtConverUtil.toFDouble(prepayInfo.getPayMoney()));
		payoepDto.setSd_pttp(param.getSd_pttp());// 终端类型
		if ("02".equals(param.getInc_type()) || "03".equals(param.getInc_type())) {
			payoepDto.setFg_print(FBoolean.TRUE);
			payoepDto.setIncno(incUtilService.getCurInvoiceNo(Context.get().getStuffId(), Context.get().getClientHost(),
					IBdInccaCodeConst.ID_OUTPATIENT_INVOICE));// 发票号
		} else {
			payoepDto.setFg_print(FBoolean.FALSE);
		}
		
		IPatientcategoryRService patcaService = ServiceFinder.find(IPatientcategoryRService.class);
		if(StringUtil.isEmpty(param.getCode_patca())){
			//入参患者分类编码为空时，首先取患者分类表中默认标志为Y的数据，如果取不到，则取患者表中的患者分类
			PiPatCaDO[] patCaDOs = patcaService.find(" fg_def = 'Y' ", "", FBoolean.FALSE);
			if(!ArrayUtil.isEmpty(patCaDOs)){
				payoepDto.setId_patca(patCaDOs[0].getId_patca());
			}else{
				payoepDto.setId_patca(patDo.getId_paticate());
			}
		}else{
			PiPatCaDO[] patCaDOs = patcaService.findByAttrValString(PiPatCaDO.CODE, param.getCode_patca());
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
	private PatDO findPat(OpPayParamDTO param) throws BizException {

		IPiRegQryService regQryService = ServiceFinder.find(IPiRegQryService.class);
		PiPatFuzyyQueryCondDTO condDto = new PiPatFuzyyQueryCondDTO();
		condDto.setPat_code(param.getCode_pat());
		condDto.setId_code(param.getCode_idnum());
		condDto.setCard_code(param.getCode_card());

		PatiAggDO[] patiAggs = regQryService.fuzzyQueryPati(condDto);
		if (ArrayUtil.isEmpty(patiAggs)) {
			throw new BizException("未查询到患者信息");
		}

		return patiAggs[0].getParentDO();
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
	private OepSettleRtnValDTO dealHp(String patId, String hpId, OpPayParamDTO param, InsureFacade insFacade) throws BizException {
		
		MiOepChargePaySelfInParamDTO inParam = new MiOepChargePaySelfInParamDTO();
		inParam.setId_pat(patId);
		
		String stId = param.getPayno();
		
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
		
		inParam.setStr_hpcard(((HpInfo)param.getHpinfo().get(0)).getHpcardinfo());
		inParam.setStr_hpregisterrtn(((HpInfo)param.getHpinfo().get(0)).getHpregisterrtninfo());
		inParam.setStr_detailuploadrtn(((HpInfo)param.getHpinfo().get(0)).getHpdetailuploadrtninfo());
		inParam.setStr_hpstrtn(((HpInfo)param.getHpinfo().get(0)).getHpstrtninfo());
		
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
		transDO.setBusiness_code(((HpInfo)param.getHpinfo().get(0)).getBusicode());//TODO
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
		transDO.setInputinfo(((HpInfo)param.getHpinfo().get(0)).getHpstinfo()); //TODO
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
