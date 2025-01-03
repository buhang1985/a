package iih.sc.apt.s.bp.ws;

import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.pp.pripm.d.PriPmDO;
import iih.bd.pp.pripm.i.IPripmRService;
import iih.bl.cg.api.d.InsurPriceInfo;
import iih.bl.cg.api.d.OpPayParam;
import iih.bl.cg.api.d.OpPayReturn;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.i.IBlOpCgSelfExternalService;
import iih.bl.cg.i.IBlOutQryService;
import iih.bl.hp.divideresult.d.DivideResultDTO;
import iih.bl.hp.i.IBlHpOutQryService;
import iih.bl.hp.insurecard.d.CardPersonInfoDTO;
import iih.en.pv.i.IEnOutCmdService;
import iih.en.pv.i.IEnOutQryService;
import iih.en.pv.out.i.IEn4ScQryService;
import iih.en.pv.outpatient.dto.d.PayInfoDTO;
import iih.pi.dic.patcatehp.d.PiPatCaHpDO;
import iih.pi.dic.patcatehp.i.IPatcatehpRService;
import iih.pi.dic.patientcategory.d.PiPatCaDO;
import iih.pi.reg.pat.d.PatDO;
import iih.sc.apt.dto.d.AptPayDTO;
import iih.sc.apt.dto.d.OpAptDTO;
import iih.sc.apt.s.bp.PricingOpAptBP;
import iih.sc.apt.s.bp.SettleOpAptBP;
import iih.sc.apt.s.ep.AptEP;
import iih.sc.apt.s.ep.AptOpEP;
import iih.sc.apt.s.ep.PatEP;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.apt.scapt.i.IScaptMDORService;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScLogUtil;
import iih.sc.comm.ScValidator;
import iih.sc.scbd.schedulechl.d.SchedulechlDO;
import iih.sc.scbd.schedulechl.i.ISchedulechlMDORService;
import iih.sc.sch.i.IScSchOutQryService;
import iih.sc.sch.reg.dto.d.RegResDTO;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

import com.mysql.jdbc.StringUtils;

/**
 * 1支付宝，2微信, 3预付费, 4银行卡 6-医保账户 付费
 * 
 * @author liuibin
 *
 */
public class PayForAptForWechatNewBP {
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
	 * @param patHpNO
	 *            医保卡号
	 * @param hpPriceData
	 *            医保xml
	 * @return
	 * @throws BizException
	 */
	public String exec(String aptId, String patCode, String chlType, String orderNo, String payType, String accNo, String patCardNo, String parCardPwd, String money, String oprCode, String patHpTp, String hpPriceData, String patHpNO, String hpPatInfXml) throws BizException {
		// 记录输入参数日志，fanlq-add
		ScLogUtil.getInstance().logInfo(
				"方法：PayForAptNewBP参数为:aptId:" + aptId + ";patCode:" + patCode + ";chlType:" + chlType + ";orderNo:" + orderNo + ";payType:" + payType + ";accNo:" + accNo + ";patCardNo:" + patCardNo + ";parCardPwd:" + parCardPwd + ";money:" + money + ";oprCode:" + oprCode + ";patHpTp:" + patHpTp + ";hpPriceData:" + hpPriceData + ";patHpNO:" + patHpNO + ";hpPatInfXml:" + hpPatInfXml);
		// 1.验证必输项
		this.validParam(aptId, chlType, payType, money, oprCode);
		// 3.获取预约信息
		ScAptDO scAptDo = this.getAptInfo(aptId);
		if (scAptDo == null)
			throw new BizException("没找到对应预约记录！");
		// 4.是否可操作验证
		this.checkExec(scAptDo);
		// 5.加载资源及价格信息
		RegResDTO RegResDto = this.getRegRes(scAptDo);
		if (RegResDto == null)
			throw new BizException("加载资源价格信息异常！");
		// 6.组装预约DTO
		OpAptDTO aptDTO = this.scAptToOpApt(scAptDo);
		aptDTO.setRegresarray(ScAppUtils.doArray2List(RegResDto));

		if (StringUtil.isEmpty(hpPriceData)) {
			// 非医保
			// 2.获取患者的默认医保分类
			IEn4ScQryService rService = ServiceFinder.find(IEn4ScQryService.class);
			PiPatCaDO patCaDO = rService.getAptSelfPayPatCa(scAptDo.getId_pat());
			if (patCaDO == null)
				throw new BizException("自费结算获取患者分类失败！");
			aptDTO.setId_patca(patCaDO.getId_patca());
			aptDTO.setId_pripat(patCaDO.getId_patpritp());
			aptDTO.setId_patcret(patCaDO.getId_patcrettp());
			// 7.划价
			PricingOpAptBP pricingBP = new PricingOpAptBP();
			aptDTO = pricingBP.exec(aptDTO, FBoolean.FALSE, FBoolean.FALSE);
			// 8.设置支付信息
			AptPayDTO payDTO = this.setPayInfo(RegResDto, payType, money, accNo, orderNo, chlType,null,null,null);
			// 9. 结算付费
			SettleOpAptBP settleOpAptBp = new SettleOpAptBP();
			settleOpAptBp.exec(aptDTO, payDTO, FBoolean.FALSE);
		} else {
			PatDO pat = (PatDO) new DAFacade().findByPK(PatDO.class, scAptDo.getId_pat());
			if(pat == null)
				throw new BizException("未找到预约对应的患者信息！");
			// 医保
			this.setHpEnData(aptDTO, scAptDo, pat.getCode(), chlType, orderNo, payType, accNo, patCardNo, parCardPwd, money, oprCode, patHpTp, hpPriceData, patHpNO, hpPatInfXml);
		}
		return null;
	}
	public String exec2(String aptId, String patCode, String chlType, String orderNo, String payType, String accNo, String patCardNo, String parCardPwd, String money, String oprCode, String patHpTp, String hpPriceData, String patHpNO, String hpPatInfXml,String dt_st,String business_code,String fg_printInvoice) throws BizException {
		// 记录输入参数日志，fanlq-add
		ScLogUtil.getInstance().logInfo(
				"方法：PayForAptNewBP参数为:aptId:" + aptId + ";patCode:" + patCode + ";chlType:" + chlType + ";orderNo:" + orderNo + ";payType:" + payType + ";accNo:" + accNo + ";patCardNo:" + patCardNo + ";parCardPwd:" + parCardPwd + ";money:" + money + ";oprCode:" + oprCode + ";patHpTp:" + patHpTp 
				+ ";hpPriceData:" + hpPriceData + ";patHpNO:" + patHpNO + ";hpPatInfXml:" + hpPatInfXml+";dt_st:"+dt_st+";business_code:"+business_code+";fg_printInvoice:"+fg_printInvoice);
		// 1.验证必输项
		this.validParam(aptId, chlType, payType, money, oprCode);
		// 3.获取预约信息
		ScAptDO scAptDo = this.getAptInfo(aptId);
		if (scAptDo == null)
			throw new BizException("没找到对应预约记录！");
		// 4.是否可操作验证
		this.checkExec(scAptDo);
		// 5.加载资源及价格信息
		RegResDTO RegResDto = this.getRegRes(scAptDo);
		if (RegResDto == null)
			throw new BizException("加载资源价格信息异常！");
		// 6.组装预约DTO
		OpAptDTO aptDTO = this.scAptToOpApt(scAptDo);
		aptDTO.setRegresarray(ScAppUtils.doArray2List(RegResDto));
		
		if (StringUtil.isEmpty(hpPriceData)) {
			// 非医保
			// 2.获取患者的默认医保分类
			IEn4ScQryService rService = ServiceFinder.find(IEn4ScQryService.class);
			PiPatCaDO patCaDO = rService.getAptSelfPayPatCa(scAptDo.getId_pat());
			if (patCaDO == null)
				throw new BizException("自费结算获取患者分类失败！");
			aptDTO.setId_patca(patCaDO.getId_patca());
			aptDTO.setId_pripat(patCaDO.getId_patpritp());
			aptDTO.setId_patcret(patCaDO.getId_patcrettp());
			// 7.划价
			PricingOpAptBP pricingBP = new PricingOpAptBP();
			aptDTO = pricingBP.exec(aptDTO, FBoolean.FALSE, FBoolean.FALSE);
			// 8.设置支付信息
			AptPayDTO payDTO = this.setPayInfo(RegResDto, payType, money, accNo, orderNo, chlType,dt_st,business_code,fg_printInvoice);
			// 9. 结算付费
			SettleOpAptBP settleOpAptBp = new SettleOpAptBP();
			settleOpAptBp.exec(aptDTO, payDTO, FBoolean.FALSE);
		} else {
			PatDO pat = (PatDO) new DAFacade().findByPK(PatDO.class, scAptDo.getId_pat());
			if(pat == null)
				throw new BizException("未找到预约对应的患者信息！");
			// 医保
			this.setHpEnData(aptDTO, scAptDo, pat.getCode(), chlType, orderNo, payType, accNo, patCardNo, parCardPwd, money, oprCode, patHpTp, hpPriceData, patHpNO, hpPatInfXml);
		}
		return null;
	}
	/**
	 * 医保挂号
	 * 
	 * @param aptDTO
	 * @param scAptDo
	 * @param patCode
	 * @param chlType
	 * @param orderNo
	 * @param payType
	 * @param accNo
	 * @param patCardNo
	 * @param parCardPwd
	 * @param money
	 * @param oprCode
	 * @param patHpTp
	 * @param hpPriceData
	 * @param patHpNO
	 * @throws BizException
	 */
	private void setHpEnData(OpAptDTO aptDTO, ScAptDO scAptDo, String patCode, String chlType, String orderNo, String payType, String accNo, String patCardNo, String parCardPwd, String money, String oprCode, String patHpTp, String hpPriceData, String patHpNO, String hpPatInfXml) throws BizException {
		// 5.1 获取患者信息
		PatEP patEP = new PatEP();
		PatDO patDO = patEP.getPatById(scAptDo.getId_pat());
		// 2.组装医保数据
		this.setHpValue(hpPatInfXml, patHpNO, aptDTO, hpPriceData);
		// 5.2创建就诊数据
		IEnOutCmdService ent4AptService = ServiceFinder.find(IEnOutCmdService.class);
		String entId = ent4AptService.aptCreateEnt(patDO, aptDTO, FBoolean.FALSE);
		aptDTO.setId_ent(entId);

		InsurPriceInfo priceInfo = this.getInsurPriceInfo(patCode, oprCode, patHpNO, hpPriceData, entId);
		OpPayParam payParam = this.getOpPayParam(patCode, orderNo, payType, accNo, parCardPwd, money, oprCode, scAptDo);
		IBlOpCgSelfExternalService blService = ServiceFinder.find(IBlOpCgSelfExternalService.class);
		OpPayReturn res = blService.payByEnt(payParam, priceInfo, this.getBlOrders(aptDTO, patDO.getId_pat()));
		if (res.getResultCode().equals("1")) {
			throw new BizException(res.getResultMsg());
		}
		if (ArrayUtil.isEmpty(res.getIdCgOepArray())) {
			throw new BizException("未取到费用的返回值");
		}
		String cgId = res.getIdCgOepArray()[0];
		aptDTO.setId_cg(cgId);
		// 5.3已结算，更新OP
		ent4AptService.settleEnt(entId, cgId, FBoolean.TRUE);

		// 5.4 修改预约门诊--就诊信息
		AptOpEP aptOpEP = new AptOpEP();
		aptOpEP.setAptToEn(aptDTO.getId_apt(), entId);

		// 5.5、 修改预约为已结算
		AptEP aptEP = new AptEP();
		aptEP.settle(scAptDo);
	}

	/**
	 * 通过预约DTO 获取记账数据转成 DTO 格式 传入费用接口
	 * 
	 * @param aptDTO
	 * @param patId
	 *            yang.lu
	 * @return
	 */
	private BlOrderAppendBillParamDTO[] getBlOrders(OpAptDTO aptDTO, String patId) {
		FArrayList pricedArray = aptDTO.getPricedinfo();
		BlcgoepAggDO aggdo = (BlcgoepAggDO) pricedArray.get(0);
		if (aggdo != null) {
			List<BlOrderAppendBillParamDTO> list = new ArrayList<BlOrderAppendBillParamDTO>();
			for (BlCgItmOepDO itmDo : aggdo.getBlCgItmOepDO()) {
				BlOrderAppendBillParamDTO blOrder = new BlOrderAppendBillParamDTO();
				blOrder.setId_cg(itmDo.getId_cgoep());
				blOrder.setId_stoep(itmDo.getId_stoep());
				blOrder.setId_org_mp(itmDo.getId_org_mp());
				blOrder.setId_emp_or(itmDo.getId_emp_or());
				blOrder.setId_srv(itmDo.getId_srv());
				blOrder.setId_grp(itmDo.getId_grp());
				blOrder.setDt_srv(ScAppUtils.getServerDateTime());
				blOrder.setId_srvtp(itmDo.getId_srvtp());
				blOrder.setCode_st(itmDo.getCode_st());
				blOrder.setName_srv(itmDo.getName_srv());
				blOrder.setSd_srvtp(itmDo.getSd_srvtp());
				blOrder.setCode_srv(itmDo.getCode_srv());
				blOrder.setSrvu(itmDo.getSrvu());
				blOrder.setId_srvca(itmDo.getId_srvca());
				blOrder.setFg_mm(FBoolean.FALSE);
				blOrder.setId_dep_mp(itmDo.getId_dep_mp());
				blOrder.setRatio_pripat(itmDo.getRatio_pripat());
				blOrder.setFg_hp(FBoolean.TRUE);
				blOrder.setId_pat(itmDo.getId_pat());
				blOrder.setQuan(itmDo.getQuan());
				blOrder.setDt_or(ScAppUtils.getServerDateTime());
				blOrder.setId_org_or(itmDo.getId_org_or());
				blOrder.setId_enttp(itmDo.getId_enttp());
				blOrder.setFg_susp(FBoolean.TRUE);
				blOrder.setEu_srctp(itmDo.getEu_srctp());
				blOrder.setEu_direct(itmDo.getEu_direct());
				blOrder.setSrcfunc_des(itmDo.getSrcfunc_des());
				blOrder.setName_inccaitm(itmDo.getName_inccaitm());
				blOrder.setId_dep_or(itmDo.getId_dep_or());
				blOrder.setId_pripat(itmDo.getId_pripat());
				blOrder.setCode_inccaitm(itmDo.getCode_inccaitm());
				blOrder.setCode_enttp(itmDo.getCode_enttp());
				blOrder.setId_ent(aptDTO.getId_ent());
				blOrder.setId_pat(patId);
				blOrder.setDt_or(ScAppUtils.getServerDateTime());
				blOrder.setId_hp(aptDTO.getId_hp());
				blOrder.setId_grp(Context.get().getGroupId());
				blOrder.setId_org(Context.get().getOrgId());
				blOrder.setId_stoep(itmDo.getId_stoep());
				blOrder.setId_cg(itmDo.getId_cgoep());
				blOrder.setFg_pricinginsertcg(FBoolean.TRUE);
				list.add(blOrder);
			}
			return list.toArray(new BlOrderAppendBillParamDTO[list.size()]);
		}
		return null;
	}

	/**
	 * 获取挂号资源
	 * 
	 * @param scAptDo
	 * @return
	 * @throws BizException
	 */
	private RegResDTO getRegRes(ScAptDO scAptDo) throws BizException {
		IScSchOutQryService scSchOutQryService = ServiceFinder.find(IScSchOutQryService.class);
		return scSchOutQryService.getRegRes4Apt(scAptDo.getId_apt(), FBoolean.TRUE);
	}

	/**
	 * 验证必输项参数
	 * 
	 * @param beginDate
	 * @param endDate
	 * @param srvType
	 * @param chlType
	 * @return
	 */
	private void validParam(String aptId, String chlType, String payType, String money, String oprCode) throws BizException {
		if (StringUtil.isEmpty(aptId)) {
			throw new BizException("支付预约不能为空！");
		}
		if (StringUtil.isEmpty(chlType)) {
			throw new BizException("缴费途径不能为空！");
		}
		if (StringUtil.isEmpty(money)) {
			throw new BizException("金额不能为空！");
		}
		if (StringUtil.isEmpty(oprCode)) {
			throw new BizException("操作员编码不能为空！");
		}
	}

	/**
	 * 获取预约信息
	 * 
	 * @param patCode
	 *            患者编码
	 * @param dSch
	 *            日期
	 * @param dayslotType
	 *            午别类型
	 * @param deptCode
	 *            科室编码
	 * @param doctorCode
	 *            医生编码
	 * @param seqNo
	 *            顺序号
	 * @return
	 * @throws BizException
	 */
	private ScAptDO getAptInfo(String aptId) throws BizException {
		IScaptMDORService serv = ServiceFinder.find(IScaptMDORService.class);
		return serv.findById(aptId);
	}

	/**
	 * DTO转换
	 * 
	 * @param scAptDo
	 * @return
	 */
	private OpAptDTO scAptToOpApt(ScAptDO scAptDo) {
		OpAptDTO aptDTO = new OpAptDTO();
		aptDTO.setId_apt(scAptDo.getId_apt());
		aptDTO.setId_dayslot(scAptDo.getId_dateslot());// 日期分组
		aptDTO.setId_pat(scAptDo.getId_pat());// 患者id
		aptDTO.setDt_b(scAptDo.getDt_b());// 预约日期

		aptDTO.setId_sch(scAptDo.getId_sch());// 排班
		aptDTO.setId_ticks(scAptDo.getId_ticks());// 号段
		aptDTO.setId_tick(scAptDo.getId_tick());// 号位
		aptDTO.setQueno(scAptDo.getQueno());// 票号

		aptDTO.setFg_payment(scAptDo.getFg_payment());
		return aptDTO;
	}

	/**
	 * 设置支付信息
	 * 
	 * @param regRes
	 *            资源信息
	 * @param payType
	 *            支付方式
	 * @param money
	 *            支付金额
	 * @return
	 * @throws BizException
	 */
	private AptPayDTO setPayInfo(RegResDTO regRes, String payType, String money, String accNo, String orderNo, String chltype,String dt_st,String business_code,String fg_printInvoice) throws BizException {
		// 验证支付金额是否足够
		FDouble relPay = new FDouble(money);
		if (relPay.compareTo(regRes.getAmt()) < 0)
			throw new BizException(String.format("支付金额不足，应支付%.2f,实际支付%.2f", regRes.getAmt().toDouble(), relPay.toDouble()));
		// 设置支付信息PayInfoDTO
		PayInfoDTO payInfo = new PayInfoDTO();
		payInfo.setFg_newprice(FBoolean.FALSE);
		payInfo.setFg_print(FBoolean.FALSE);
		payInfo.setFg_acc(FBoolean.FALSE);
		payInfo.setAmt(regRes.getAmt());
		payInfo.setAmt_st(regRes.getAmt_st());
		payInfo.setAmt_hp(regRes.getAmt_hp());
		payInfo.setAmt_ct(regRes.getAmt_insuracc());
		payInfo.setNo_bank(accNo);
		payInfo.setPaycred(orderNo);
		payInfo.setRelpay(relPay);
		payInfo.setChange(relPay.sub(payInfo.getAmt()));
		PriPmDO pmDO = getPriPm(payType);
		payInfo.setPaystyle(pmDO.getCode());
		payInfo.setId_patstyle(pmDO.getId_pm());
		payInfo.setSd_pttp(this.setPttp(chltype));
		payInfo.setDt_st(dt_st);
		payInfo.setBusiness_code(business_code);
		if(!StringUtils.isNullOrEmpty(fg_printInvoice)){
			payInfo.setFg_print(FBoolean.valueOf(fg_printInvoice));
		}
		AptPayDTO payDTO = new AptPayDTO();
		payDTO.setPayinfo(ScAppUtils.doArray2List(payInfo));
		return payDTO;
	}

	/**
	 * 检查预约是否可以支付
	 * 
	 * @param scAptDo
	 * @throws BizException
	 */
	private void checkExec(ScAptDO scAptDo) throws BizException {
		// 是否已回收
		if (FBoolean.TRUE.equals(scAptDo.getFg_canc())) {
			throw new BizException("该预约已经取消,不允许付费");
		}
		// 是否已支付
		if (IScDictCodeConst.SD_APTSTATUS_PAY.equals(scAptDo.getSd_status())) {
			throw new BizException("预约已经支付, 不能重复收费");
		}
		if (IScDictCodeConst.SD_APTSTATUS_FINISH.equals(scAptDo.getSd_status()))
			throw new BizException("预约已经支付, 不能重复收费");
	}

	/**
	 * 设置医保支付参数
	 * 
	 * @param patCode
	 * @param oprCode
	 * @param hpPriceData
	 */
	private InsurPriceInfo getInsurPriceInfo(String patCode, String oprCode, String patHpNO, String hpPriceData, String entId) {
		InsurPriceInfo pinfo = new InsurPriceInfo();
		pinfo.setPatCode(patCode);
		pinfo.setInsurCardNo(patHpNO);// 医保卡号
		pinfo.setEntpCode(IEnDictCodeConst.SD_ENTP_OUTPATIENT);
		pinfo.setOperatorCode(oprCode);
		// pinfo.setPresNoArray();
		pinfo.setInsurPriceResult(hpPriceData);
		pinfo.setId_ent(entId);
		return pinfo;
	}

	/**
	 * 医保支付参数
	 * 
	 * @param patCode
	 * @param orderNo
	 * @param payType
	 * @param accNo
	 * @param parCardPwd
	 * @param money
	 * @param oprCode
	 * @param scAptDo
	 * @throws BizException
	 */
	private OpPayParam getOpPayParam(String patCode, String orderNo, String payType, String accNo, String parCardPwd, String money, String oprCode, ScAptDO scAptDo) throws BizException {
		OpPayParam payParam = new OpPayParam();
		payParam.setPatCode(patCode);// 患者编码
		payParam.setPatType("02");// 患者类型 01 自费 02 医保
		payParam.setPayOrder(orderNo);// 第三方支付订单号
		payParam.setAccount(accNo);// 第三方支付账号
		// payParam.setPmCode(ServiceFinder.find(IBlOutQryService.class).getPayCodeToIn(payType).getSd_pmtp());
		payParam.setPmCode(payType);
		FDouble relPay = new FDouble(money);
		payParam.setAmt(relPay.doubleValue());// 金额 (amt = price* quan*
												// quanOrders)
		payParam.setOperaCode(oprCode);// 操作员
		payParam.setPrepayCardPwd(parCardPwd);// 患者预付费卡密码
		payParam.setPtTpCode(this.setPttp(scAptDo.getCode_scchl()));
		return payParam;
	}

	/**
	 * 设置医保数据
	 * 
	 * @param hpPatInfXml
	 * @throws BizException
	 */
	private void setHpValue(String hpPatInfXml, String NOHp, OpAptDTO aptDTO, String hpPriceData) throws BizException {
		// 1.取默认的患者分类
		IEnOutQryService qryService = ServiceFinder.find(IEnOutQryService.class);
		String patCardId = qryService.getDefaultHpCard();
		if (StringUtil.isEmpty(patCardId))
			throw new BizException("未取到患者默认的患者分类");
		// 2.根据默认的患者分类取医保计划
		IPatcatehpRService rService = ServiceFinder.find(IPatcatehpRService.class);
		PiPatCaHpDO[] patCaHpDOs = rService.find("id_patca ='" + patCardId + "'", "", FBoolean.FALSE);
		if (ArrayUtil.isEmpty(patCaHpDOs))
			throw new BizException("未取到患者分类对应的医保计划");
		aptDTO.setId_hp(patCaHpDOs[0].getId_hp());

		// 3。取医保分摊xml的解析结果
		IBlOpCgSelfExternalService cgService = ServiceFinder.find(IBlOpCgSelfExternalService.class);
		DivideResultDTO resDTO = cgService.getResultByXml(hpPriceData);
		if (resDTO.getFund().toDouble() > 0) {
			aptDTO.setFg_hpsettle(FBoolean.TRUE);// 医保基金支付标识 TODO
		}
		aptDTO.setFg_hp_card(FBoolean.TRUE);
		// 4.取医保卡片信息的xml的解析结果
		IBlOpCgSelfExternalService blService = ServiceFinder.find(IBlOpCgSelfExternalService.class);
		CardPersonInfoDTO carPersonInfo = blService.getPersonByXml(hpPatInfXml);
		aptDTO.setCode_hpkind(carPersonInfo.getFundtype());
		aptDTO.setId_hpkind(carPersonInfo.getId_fundtype());//
		aptDTO.setCode_hppatca(carPersonInfo.getPersontype());// 患者医保身份
		aptDTO.setId_patca(patCardId);
		aptDTO.setNo_hp(carPersonInfo.getCard_code());// 获取医保卡卡号
		IBlHpOutQryService service = ServiceFinder.find(IBlHpOutQryService.class);
		FBoolean res = service.ifFundpay(carPersonInfo, IEnDictCodeConst.SD_ENTP_OUTPATIENT);
		aptDTO.setFg_hpsettle(res);
	}

	/**
	 * 设置终端类型
	 * 
	 * @param chlTp
	 * @param payDTO
	 * @throws BizException 
	 */
	private String setPttp(String chlTp) throws BizException {
		ISchedulechlMDORService rservice = ServiceFinder.find(ISchedulechlMDORService.class);
		SchedulechlDO[] schedulechlDOs = rservice.find("code = '"+chlTp+"'", null, FBoolean.FALSE);
		if(schedulechlDOs != null && schedulechlDOs.length == 1){
			SchedulechlDO SchedulechlDO = schedulechlDOs[0];
			String sd_pttp = SchedulechlDO.getSd_pttp();
			if(!StringUtils.isNullOrEmpty(sd_pttp)){
				return sd_pttp;
			}else{
				switch (chlTp) {
				case IScDictCodeConst.SD_SCCHLTP_HOSPITAL_SELF:
					return IBlDictCodeConst.SD_PTTP_SELF_TERMINAL;
				case IScDictCodeConst.SD_SCCHLTP_PATIENT_MOBILE:
					return IBlDictCodeConst.SD_PTTP_PHONE_APP;
				case IScDictCodeConst.SD_SCCHLTP_PATIENT_WEIXIN:
					return IBlDictCodeConst.SD_PTTP_WEIXIN;
				default:
					return null;
				}
			}
		}else{
			throw new BizException("未取到该编码对应的渠道类型！");
		}
	}
	/**
	 * 获取支付方式
	 * 
	 * @param payType
	 * @return
	 * @throws BizException 
	 */
	private PriPmDO getPriPm(String payType) throws BizException{
		PriPmDO pmDo = ServiceFinder.find(IBlOutQryService.class).getPayCodeToIn(payType);
		if(pmDo == null || ScValidator.isEmptyIgnoreBlank(pmDo.getId_pm())){
			PriPmDO[] pmDos = ServiceFinder.find(IPripmRService.class).findByAttrValString(PriPmDO.CODE, payType);
			if(!ArrayUtil.isEmpty(pmDos))
				pmDo = pmDos[0];
		}
		if(pmDo == null)
			throw new BizException("支付方式错误！");
		return pmDo;
	}
}
