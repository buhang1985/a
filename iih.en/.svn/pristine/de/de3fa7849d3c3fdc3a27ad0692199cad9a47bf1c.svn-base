package iih.en.itf.bp.opapt;

import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.pripm.d.PriPmDO;
import iih.bd.pp.pripm.i.IPripmRService;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.i.IBlOutQryService;
import iih.bl.itf.std.inner.en.IBlOpChargeForEnInnerService;
import iih.bl.itf.std.inner.en.opregcharge.d.BlOpRegPayDTO;
import iih.bl.itf.std.inner.en.opregcharge.d.BlOpRegPayRltDTO;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.en.comm.ep.HpEP;
import iih.en.comm.ep.OpEP;
import iih.en.comm.ep.PatEP;
import iih.en.comm.ep.PiPatEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.itf.bean.input.opapt.WsEnParamCfmPaidApt;
import iih.en.itf.bean.input.opapt.WsEnParamPayForApt;
import iih.en.itf.bean.input.opapt.WsEnParamPayForAptHpItem;
import iih.en.itf.bean.output.WsEnResult;
import iih.en.itf.bean.output.opapt.WsEnResultCfmPaidApt;
import iih.en.itf.bean.output.opapt.WsEnResultPayForApt;
import iih.en.itf.i.IEnOpAptInnerService;
import iih.en.pv.appoint.result.InvoiceBean;
import iih.en.pv.appoint.s.bp.GetStOepInfoBP;
import iih.en.pv.outpatient.dto.d.PayInfoDTO;
import iih.en.pv.outpatient.dto.d.RegInfoDTO;
import iih.en.pv.s.bp.ip.ws.GetInvoiceInfoBP;
import iih.en.pv.s.bp.op.AptCreateEntBP;
import iih.en.pv.s.bp.op.AptParser;
import iih.en.pv.s.bp.op.AptPricingBP;
import iih.en.pv.s.bp.op.ws.SetPsnDocContextBP;
import iih.pi.dic.patientcategory.d.PiPatCaDO;
import iih.pi.reg.pat.d.PatDO;
import iih.sc.apt.dto.d.AptPayDTO;
import iih.sc.apt.dto.d.OpAptDTO;
import iih.sc.apt.i.IScAptOutCmdService;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.apt.scapt.d.ScAptOpDO;
import iih.sc.apt.scapt.i.IScAptOpDOCudService;
import iih.sc.apt.scapt.i.IScAptOpDORService;
import iih.sc.apt.scapt.i.IScaptMDOCudService;
import iih.sc.apt.scapt.i.IScaptMDORService;
import iih.sc.scbd.schedulechl.d.SchedulechlDO;
import iih.sc.scbd.schedulechl.i.ISchedulechlMDORService;
import iih.sc.sch.i.IScSchOutQryService;
import iih.sc.sch.reg.dto.d.RegResDTO;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;


/**
 * 收取预约费
 * 
 * @author liubin
 *
 */
public class WsEnPayForAptBP {
	/**
	 * 收取预约费
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public WsEnResult<WsEnResultPayForApt> exec(WsEnParamPayForApt param) throws BizException {
		//校验参数
		this.validate(param);
		//设置上下文
		this.setContext(param);
		//获取患者信息
		PatDO pat = this.getPatByCode(param);
		//获取预约信息
		ScAptDO aptDo = this.getAptDo(param.getId_apt());
		//组装预约dto信息
		OpAptDTO opAptDTO = this.assemly(param, aptDo);
		if(!EnValidator.isEmpty(param.getId_stoep())){
			//使用划价接口的方式
			if(!EnValidator.isEmpty(param.getCode_hp())){
				//医保
				//医保结算校验
				this.validateHpPay(param);
				//获取医保信息
				HPDO hp = this.getHpByCode(param);
				//医保设置患者分类
				this.hpPaySetPatCa(opAptDTO, hp);
				//设置医保信息
				this.setHpInfo(param, opAptDTO, hp);
			}else{
				//自费
				//自费设置患者分类
				this.selfPaySetPatCa(opAptDTO, pat);
			}
			//生成就诊记录
			String entId = aptCreateEnt(param, opAptDTO, pat);
			//结算
			String cgId = this.hpPaySettle(param, opAptDTO, pat, entId);
			//回写预约就诊数据
			this.updateCgStatus(param.getId_apt(), entId, cgId);
		}else{
			//未使用划价接口的方式
			if(!EnValidator.isEmpty(param.getCode_hp()))
				throw new BizException("医保支付请先调用划价接口!");
			//自费
			//自费设置患者分类
			this.selfPaySetPatCa(opAptDTO, pat);
			//自费划价
			this.selfPayPricing(opAptDTO);
			//自费设置支付信息
			AptPayDTO payDTO = this.selfPaySetPayInfo(param, opAptDTO);
			//自费结算
			this.selfPaySettle(opAptDTO, payDTO);
		}
		//取号
		WsEnResultCfmPaidApt cfmRtn = this.takeTickNo(param);
		//组装返回值
		WsEnResultPayForApt resultPayForApt = new WsEnResultPayForApt();
		//5.设置结算信息
		this.setStInfo(resultPayForApt, param, cfmRtn);
		//6.设置发票信息
		this.setInvoice(resultPayForApt, param);
		return this.wrap(resultPayForApt);
	}
	/**
	 * 校验参数
	 * 
	 * @param param
	 * @throws BizException
	 */
	private void validate(WsEnParamPayForApt param) throws BizException {
		if(param == null)
			throw new BizException("入参为空或者xml转换失败!");
		if (EnValidator.isEmpty(param.getId_apt()))
			throw new BizException("预约Id不能为空！");
		if (EnValidator.isEmpty(param.getChlType()))
			throw new BizException("缴费途径不能为空！");
		if (EnValidator.isEmpty(param.getMoney()))
			throw new BizException("金额不能为空！");
		if (EnValidator.isEmpty(param.getOprCode()))
			throw new BizException("操作员编码不能为空！");
	}
	/**
	 * 校验参数
	 * 
	 * @param param
	 * @throws BizException
	 */
	private void validateHpPay(WsEnParamPayForApt param) throws BizException {
		if (EnValidator.isEmpty(param.getCode_hp()))
			throw new BizException("医保产品编码不能为空！");
		WsEnParamPayForAptHpItem hpInfo = param.getHpInfo();
		if(hpInfo == null)
			throw new BizException("医保结算信息不能为空！");
	}
	/**
	 * 获取患者信息
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private PatDO getPatByCode(WsEnParamPayForApt param) throws BizException {
		//获取患者信息
		PatDO pat = new PatEP().getPatByCode(param.getPatCode());
		if(pat == null)
			throw new BizException(String.format("获取患者信息[%s]失败！", param.getPatCode()));
		return pat;
	}
	
	/**
	 * 获取患者信息
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private HPDO getHpByCode(WsEnParamPayForApt param) throws BizException {
		HPDO hp = new HpEP().getHpByCode(param.getCode_hp());
		if(hp == null)
			throw new BizException(String.format("获取医保产品[%s]失败！", param.getCode_hp()));
		return hp;
	}
	/**
	 * 组装返回值
	 * 
	 * @param resultPayForApt
	 * @return
	 */
	private WsEnResult<WsEnResultPayForApt> wrap(WsEnResultPayForApt resultPayForApt){
		List<WsEnResultPayForApt> datas = new ArrayList<WsEnResultPayForApt>();
		datas.add(resultPayForApt);
		WsEnResult<WsEnResultPayForApt> result = new WsEnResult<WsEnResultPayForApt>();
		result.setDatas(datas);
		return result;
	}
	
	/**
	 * 设置上下文
	 * 
	 * @param param
	 * @throws BizException
	 */
	private void setContext(WsEnParamPayForApt param) throws BizException {
		if(!EnValidator.isEmpty(param.getOprCode())){
	    	new SetPsnDocContextBP().exec(param.getOprCode());
		}
	}
	/**
	 * 获取预约信息
	 * 
	 * @param aptId
	 * @return
	 * @throws BizException
	 */
	private ScAptDO getAptDo(String aptId) throws BizException {
		IScaptMDORService serv = ServiceFinder.find(IScaptMDORService.class);
		ScAptDO apt = serv.findById(aptId);
		if(apt == null)
			throw new BizException(String.format("未找到[%s]对应预约记录！", aptId));
		// 是否已回收
		if (FBoolean.TRUE.equals(apt.getFg_canc()))
			throw new BizException("该预约已经取消,不允许付费");
		// 是否已支付
		if (IScDictCodeConst.SD_APTSTATUS_PAY.equals(apt.getSd_status()))
			throw new BizException("预约已经支付, 不能重复收费");
		if (IScDictCodeConst.SD_APTSTATUS_FINISH.equals(apt.getSd_status()))
			throw new BizException("预约已经取号, 不能重复收费");
		return apt;
	}
	/**
	 * 组装预约dto信息
	 * 
	 * @param param
	 * @param aptDo
	 * @return
	 * @throws BizException
	 */
	private OpAptDTO assemly(WsEnParamPayForApt param, ScAptDO aptDo) throws BizException {
		IScSchOutQryService scSchOutQryServ = ServiceFinder.find(IScSchOutQryService.class);
		RegResDTO regRes  = scSchOutQryServ.getRegRes4Apt(aptDo.getId_apt(), FBoolean.TRUE);
		if (regRes == null)
			throw new BizException("加载号源信息异常！");
		OpAptDTO aptDTO = new OpAptDTO();
		aptDTO.setId_apt(aptDo.getId_apt());
		aptDTO.setId_dayslot(aptDo.getId_dateslot());// 日期分组
		aptDTO.setId_pat(aptDo.getId_pat());// 患者id
		aptDTO.setDt_b(aptDo.getDt_b());// 预约日期
		aptDTO.setId_sch(aptDo.getId_sch());// 排班
		aptDTO.setId_ticks(aptDo.getId_ticks());// 号段
		aptDTO.setId_tick(aptDo.getId_tick());// 号位
		aptDTO.setQueno(aptDo.getQueno());// 票号
		aptDTO.setFg_payment(aptDo.getFg_payment());
		aptDTO.setRegresarray(EnAppUtils.doArray2List(regRes));
		return aptDTO;
	}
	/**
	 * 设置发票信息
	 * 
	 * @param resultPayForApt
	 * @param param
	 * @throws BizException
	 */
	private void setInvoice(WsEnResultPayForApt resultPayForApt, WsEnParamPayForApt param) throws BizException{
		//获取发票信息
		if(FBoolean.TRUE.equals(FBoolean.valueOf(param.getFg_printInvoice()))){
			InvoiceBean invoice = new GetInvoiceInfoBP().exec(param.getId_apt());
			resultPayForApt.setInvoice(invoice);
		}
	}
	/**
	 * 设置结算信息
	 * 
	 * @param resultPayForApt
	 * @param param
	 * @throws BizException
	 */
	private void setStInfo(WsEnResultPayForApt resultPayForApt, WsEnParamPayForApt param, WsEnResultCfmPaidApt cfmRtn) throws BizException{
		if(cfmRtn != null){
			resultPayForApt.setId_stoep(cfmRtn.getId_stoep());
			resultPayForApt.setCode_st(cfmRtn.getCode_st());
			resultPayForApt.setDt_st(cfmRtn.getDt_st());
		}else{
			GetStOepInfoBP bp = new GetStOepInfoBP();
			BlStOepDO st = bp.queryByAptId(param.getId_apt());
			if(st == null)
				return;
			resultPayForApt.setId_stoep(st.getId_stoep());
			resultPayForApt.setCode_st(st.getCode_st());
			resultPayForApt.setDt_st(st.getDt_st()==null? null : st.getDt_st().toString());
		}
	}
	
	/**
	 * 自费划价
	 * 
	 * @param aptDTO
	 * @throws BizException
	 */
	private void selfPayPricing(OpAptDTO aptDTO) throws BizException {
		AptPricingBP bp = new AptPricingBP();
		bp.exec(aptDTO, FBoolean.FALSE, FBoolean.FALSE);
	}
	/**
	 * 自费设置患者分类
	 * 
	 * @param aptDTO
	 * @throws BizException
	 */
	private void selfPaySetPatCa(OpAptDTO aptDTO, PatDO pat) throws BizException {
		PiPatEP piPatEP = new PiPatEP();
		PiPatCaDO patCa = piPatEP.getAptSelfPayPatca(pat);
		if (patCa == null)
			throw new BizException("自费结算获取患者分类失败！");
		aptDTO.setId_patca(patCa.getId_patca());
		aptDTO.setId_pripat(patCa.getId_patpritp());
		aptDTO.setId_patcret(patCa.getId_patcrettp());
	}
	/**
	 * 医保设置患者分类
	 * 
	 * @param aptDTO
	 * @throws BizException
	 */
	private void hpPaySetPatCa(OpAptDTO aptDTO, HPDO hp) throws BizException {
		PiPatCaDO patCa = new PiPatEP().getOpPatCaByHpId(hp.getId_hp());
		if(patCa == null)
			throw new BizException(String.format("获取医保产品[%s]对应患者分类失败！", hp.getCode()));
		aptDTO.setId_patca(patCa.getId_patca());
		aptDTO.setId_pripat(patCa.getId_patpritp());
		aptDTO.setId_patcret(patCa.getId_patcrettp());
	}
	/**
	 * 自费设置支付信息
	 * 
	 * @param param
	 * @param aptDTO
	 * @return
	 * @throws BizException
	 */
	private AptPayDTO selfPaySetPayInfo(WsEnParamPayForApt param, OpAptDTO aptDTO) throws BizException{
		// 验证支付金额是否足够
		RegResDTO regRes = (RegResDTO)aptDTO.getRegresarray().get(0);
		FDouble relPay = new FDouble(param.getMoney());
		if (relPay.compareTo(regRes.getAmt()) < 0)
			throw new BizException(String.format("支付金额不足，应支付%.2f,实际支付%.2f", regRes.getAmt().toDouble(), relPay.toDouble()));
		// 设置支付信息PayInfoDTO
		PayInfoDTO payInfo = new PayInfoDTO();
		payInfo.setFg_newprice(FBoolean.FALSE);
		payInfo.setFg_print(FBoolean.valueOf(param.getFg_printInvoice()));
		payInfo.setFg_acc(FBoolean.FALSE);
		payInfo.setAmt(regRes.getAmt());
		payInfo.setAmt_st(regRes.getAmt_st());
		payInfo.setAmt_hp(regRes.getAmt_hp());
		payInfo.setAmt_ct(regRes.getAmt_insuracc());
		payInfo.setNo_bank(param.getAccNo());
		payInfo.setPaycred(param.getOrderNo());
		payInfo.setRelpay(relPay);
		payInfo.setChange(relPay.sub(payInfo.getAmt()));
		PriPmDO pmDO = getPriPm(param.getPayType());
		payInfo.setPaystyle(pmDO.getCode());
		payInfo.setId_patstyle(pmDO.getId_pm());
		payInfo.setSd_pttp(this.setPttp(param.getChlType()));
		payInfo.setDt_st(param.getDt_st());
		payInfo.setBusiness_code(param.getBusiness_code());
		AptPayDTO payDTO = new AptPayDTO();
		payDTO.setPayinfo(EnAppUtils.doArray2List(payInfo));
		return payDTO;
	}
	/**
	 * 自费结算
	 * 
	 * @param aptDTO
	 * @param payInfo
	 * @throws BizException
	 */
	private void selfPaySettle(OpAptDTO aptDTO, AptPayDTO payInfo) throws BizException{
		IScAptOutCmdService serv = ServiceFinder.find(IScAptOutCmdService.class);
		serv.settleOpApt(aptDTO, payInfo);
	}
	/**
	 * 医保结算
	 * 
	 * @param param
	 * @param aptDTO
	 * @param pat
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	private String hpPaySettle(WsEnParamPayForApt param, OpAptDTO aptDTO, PatDO pat, String entId) throws BizException{
		BlOpRegPayDTO payInfo = new BlOpRegPayDTO();
		payInfo.setId_pat(pat.getId_pat());
		payInfo.setId_ent(entId);
		payInfo.setId_hp(aptDTO.getId_hp());
		payInfo.setId_stoep(param.getId_stoep());
		payInfo.setFg_printinc(FBoolean.valueOf(param.getFg_printInvoice()));
		PriPmDO pmDO = getPriPm(param.getPayType());
		payInfo.setSd_pm(pmDO.getCode());
		payInfo.setSd_pttp(this.setPttp(param.getChlType()));
		payInfo.setAmt(new FDouble(param.getMoney()));
		payInfo.setPaymodenode(param.getOrderNo());
		payInfo.setBankno(EnValidator.isEmpty(param.getAccNo()) ? param.getBusiness_code() : param.getAccNo());
		if(!EnValidator.isEmpty(param.getCode_hp())){
			WsEnParamPayForAptHpItem hpInfo = param.getHpInfo();
			payInfo.setHpcardinfo(hpInfo.getHpcardinfo());
			payInfo.setHpregisterrtninfo(hpInfo.getHpregisterrtninfo());
			payInfo.setHpdetailuploadrtninfo(hpInfo.getHpdetailuploadrtninfo());
			payInfo.setHpstrtninfo(hpInfo.getHpstrtninfo());
		}
		IBlOpChargeForEnInnerService serv = ServiceFinder.find(IBlOpChargeForEnInnerService.class);
		BlOpRegPayRltDTO blOpRegPayRltDTO = serv.regPay(payInfo);
		if(blOpRegPayRltDTO == null || blOpRegPayRltDTO.getCgdetail() == null)
			throw new BizException("结算失败！");
		return ((BlcgoepAggDO)blOpRegPayRltDTO.getCgdetail().get(0)).getParentDO().getId_cgoep();
	}
	/**
	 * 回写预约状态
	 * 
	 * @param aptId
	 * @param entId
	 * @param cgId
	 * @throws BizException 
	 */
	private void updateCgStatus(String aptId, String entId, String cgId) throws BizException{
		//修改门诊急诊id
		OpEP opEP = new OpEP();
		opEP.updateToSettled(entId, cgId, FBoolean.TRUE);

		//修改预约门诊--就诊信息
		IScAptOpDORService aptOpRService = ServiceFinder.find(IScAptOpDORService.class);
		ScAptOpDO[] aptOpDOs = aptOpRService.findByAttrValString(ScAptOpDO.ID_APT, aptId);
		aptOpDOs[0].setId_en(entId);// 就诊id
		aptOpDOs[0].setDt_en(EnAppUtils.getServerDateTime());// 就诊时间
		aptOpDOs[0].setFg_en(FBoolean.TRUE);// 就诊标识
		aptOpDOs[0].setStatus(DOStatus.UPDATED);
		IScAptOpDOCudService aptOpCudService = ServiceFinder.find(IScAptOpDOCudService.class);
		aptOpCudService.save(new ScAptOpDO[] { aptOpDOs[0] });

		//修改预约为已结算
		ScAptDO aptDo = this.getAptDo(aptId);
		aptDo.setSd_status(IScDictCodeConst.SD_APTSTATUS_PAY); // 状态
		aptDo.setFg_payment(FBoolean.TRUE); // 已支付
		aptDo.setFg_bill(FBoolean.TRUE); // 已记费标志
		aptDo.setStatus(DOStatus.UPDATED);
		IScaptMDOCudService aptCudService = ServiceFinder.find(IScaptMDOCudService.class);
		aptCudService.save(new ScAptDO[]{aptDo});
	}
	/**
	 * 设置医保信息
	 * 
	 * @param param
	 * @param aptDTO
	 * @param hp
	 * @throws BizException
	 */
	private void setHpInfo(WsEnParamPayForApt param, OpAptDTO aptDTO, HPDO hp)throws BizException{
		WsEnParamPayForAptHpItem hpInfo = param.getHpInfo();
		aptDTO.setId_hp(hp.getId_hp());
		aptDTO.setNo_hp(hpInfo.getNo_hp());
		aptDTO.setFg_settlebycard(FBoolean.TRUE);
		aptDTO.setFg_hpsettle(FBoolean.TRUE);
		aptDTO.setFg_hp_card(FBoolean.TRUE);
		aptDTO.setCode_hpkind(hpInfo.getCode_hpkind());
		aptDTO.setCode_hppatca(hpInfo.getCode_hppatca());
		aptDTO.setCode_hpmedkind(hpInfo.getCode_hpmedkind());
	}
	/**
	 * 生成就诊记录
	 * 
	 * @param param
	 * @param aptDTO
	 * @param pat
	 * @return
	 * @throws BizException 
	 */
	private String aptCreateEnt(WsEnParamPayForApt param, OpAptDTO aptDTO, PatDO pat) throws BizException{
		RegInfoDTO regInfo = AptParser.aptToRegDTO(aptDTO);
		WsEnParamPayForAptHpItem hpInfo = param.getHpInfo();
		if(hpInfo != null)
			regInfo.setCode_hparea(hpInfo.getCode_hparea());
		AptCreateEntBP bp = new AptCreateEntBP();
		return bp.exec(pat, regInfo, FBoolean.FALSE);
	}
	/**
	 * 取号
	 * 
	 * @param param
	 * @throws BizException
	 */
	private WsEnResultCfmPaidApt takeTickNo(WsEnParamPayForApt param) throws BizException{
		if(!EnValidator.isEmpty(param.getCode_hp()) 
				|| FBoolean.TRUE.equals(FBoolean.valueOf(param.getFg_takeAptNo()))){
			IEnOpAptInnerService serv = ServiceFinder.find(IEnOpAptInnerService.class);
			WsEnParamCfmPaidApt cfmParam = new WsEnParamCfmPaidApt();
			cfmParam.setId_apt(param.getId_apt());
			cfmParam.setOprCode(param.getOprCode());
			WsEnResult<WsEnResultCfmPaidApt> result = serv.cfmPaidApt(cfmParam);
			if(result != null)
				return result.getDatas().get(0);
		}
		return null;
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
			if(!EnValidator.isEmpty(sd_pttp)){
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
		if(pmDo == null || EnValidator.isEmpty(pmDo.getId_pm())){
			PriPmDO[] pmDos = ServiceFinder.find(IPripmRService.class).findByAttrValString(PriPmDO.CODE, payType);
			if(!EnValidator.isEmpty(pmDos))
				pmDo = pmDos[0];
		}
		if(pmDo == null)
			throw new BizException("支付方式错误！");
		return pmDo;
	}
}
