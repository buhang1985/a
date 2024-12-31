package iih.bl.st.s.bp.oepcharge;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import iih.bd.base.utils.FDoubleUtils;
import iih.bd.base.utils.MapUtils;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlCgOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blcgquery.d.BookRtnDirectEnum;
import iih.bl.comm.IBlConst;
import iih.bl.comm.util.BlCodeUtils;
import iih.bl.comm.util.BlFlowContextUtil;
import iih.bl.inc.blincoep.d.BlIncOepDO;
import iih.bl.inc.blincoep.d.BlincoepAggDO;
import iih.bl.inc.blincoep.i.IBlincoepRService;
import iih.bl.inc.i.IBlIncOutCmdService;
import iih.bl.inc.i.IBlIncValidateService;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.dto.prepay.d.BlPrepayCDTO;
import iih.bl.pay.dto.prepay.d.BlPrepaySetDTO;
import iih.bl.pay.i.IBlPrepayCmdService;
import iih.bl.prop.blproparoep.d.BlPropArOepDO;
import iih.bl.prop.blproparoep.i.IBlproparoepMDOCudService;
import iih.bl.prop.blpropoep.d.BlPropOepDO;
import iih.bl.prop.blpropoep.i.IBlpropoepCudService;
import iih.bl.st.blpaypatoep.d.BlPayItmPatOepDO;
import iih.bl.st.blpaypatoep.d.BlPayPatOepDO;
import iih.bl.st.blpaypatoep.d.BlpaypatoepAggDO;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.dto.bloeprefunddto.d.BlOepRefundItmDTO;
import iih.bl.st.dto.bloeprefunddto.d.BlOepRefundRltDTO;
import iih.bl.st.dto.bloeprefunddto.d.BlOepRefundSetDTO;
import iih.bl.st.dto.blpayoep.d.BlPayOepDTO;
import iih.bl.st.dto.blpayoep.d.BlPayOepPmDTO;
import iih.bl.st.s.bp.oepcharge.base.BlOepPaymentBaseBP;
import iih.bl.st.s.bp.oepcharge.help.BlReturnDrugBP;
import iih.bl.st.s.bp.oepcharge.util.BlOepChargeDataUtil;
import iih.bl.st.s.bp.oepcharge.validate.CgReturnableValidator;
import iih.bl.st.s.bp.oepcharge.validate.OepRefundParamValidator;
import iih.bl.st.s.bp.oepcharge.validate.PeReturnableValidator;
import iih.bl.st.s.event.BlOpPayEvent;
import iih.ci.ord.ciorder.d.FeeReverseType;
import iih.ci.ord.i.ICiOrdMaintainService;
import iih.mi.biz.dto.d.HisPropertyRefHpDTO;
import iih.mi.biz.dto.d.OepSettleRtnValDTO;
import iih.mi.itf.context.InsureContext;
import iih.mi.itf.facade.InsureFacade;
import iih.mi.itf2.dto.MiContext;
import iih.mi.itf2.facade.MiFacade;
import iih.mi.itf2.util.MiParamUtil;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.dataaccess.DBUtil;
import xap.sys.custcfg.billcode.i.IBillcodeManage;

/**
 * 门诊退费
 * @author ly 2018/12/12
 *
 */
public class BlOepRefundBP extends BlOepPaymentBaseBP{

	private FBoolean fgPrintRedInc = FBoolean.FALSE;//是否打印红冲发票
	
	/**
	 * 门诊退费
	 * @param refundSet 退费信息
	 * @param cgItmDtos 退费明细
	 * @param payOepPmDtos 支付方式
	 * @return 退费结果
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public BlOepRefundRltDTO exec(BlOepRefundSetDTO refundSet, BlOepRefundItmDTO[] cgItmDtos, BlPayOepPmDTO[] payOepPmDtos)
			throws BizException {
		
		//1.入参校验
		OepRefundParamValidator validator = new OepRefundParamValidator(this.getBusinessName());
		validator.validate(refundSet, cgItmDtos, payOepPmDtos);
		
		this.initRefundSet(refundSet);
		
		//2.加锁 
		super.addLock(refundSet.getId_stoep());
				
		//3.准备数据
		BlCgItmOepDO[] oldCgItmDos = super.findCgInfo(refundSet.getId_stoep());
		BlcgoepAggDO[] oldCgAggDos = super.findCgAggInfo(oldCgItmDos);
		BlStOepDO oldStDO = super.findStInfo(refundSet.getId_stoep());
		BlpaypatoepAggDO oldPayAggDO = super.findPayInfo(oldStDO.getId_paypatoep());
		Map<String, BlCgItmOepDO> oldCgItmMap = (Map<String, BlCgItmOepDO>) MapUtils
				.convertArrayToMap(oldCgItmDos, BlCgItmOepDO.ID_CGITMOEP);
		BlPropOepDO oldPropDO = super.findPropInfo(refundSet.getId_stoep());
		BlPropArOepDO oldPropArDO = null;
		if(oldPropDO != null){
			oldPropArDO = super.findPropArInfo(oldPropDO.getId_propoep());
		}
		
		//4.可退性校验
		boolean allRefund = this.validateRefundable(oldStDO, cgItmDtos, oldCgItmMap);
		
		//5.预交金退回
		this.prepayRecharge(refundSet, payOepPmDtos);
		
		//6.红冲原记账，结算，收付款，发票信息，分摊信息
		String[] keys =  new DBUtil().getOIDs(2);
		String redStId = keys[0];
		String redPayId = keys[1];
		BlcgoepAggDO[] redCgAggDos = this.refundCg(oldCgAggDos, redStId);
		BlStOepDO redStDO = this.refundSt(oldStDO, redStId, redPayId, refundSet);
		BlpaypatoepAggDO redPayAggDO = this.refundPay(oldPayAggDO, payOepPmDtos, refundSet, allRefund, redPayId);
		BlincoepAggDO[] redIncAggDos = this.refundInc(oldStDO, redCgAggDos, refundSet);
		if(oldPropDO != null){
			BlPropOepDO redPropDO = this.refundProp(redStId);
			BlPropArOepDO redPropArDO = this.refundPropAr(oldPropArDO, redPropDO, refundSet.getCode_business());
			this.refundHpOld(oldPropArDO, redPropDO, redPropArDO);
		}
		
		if(!FBoolean.TRUE.equals(refundSet.getFg_dealfeeonly())){
			//7.处理药品
			new BlReturnDrugBP().exec(cgItmDtos, oldCgItmMap);
		}
		
		//8.重收
		BlcgoepAggDO reCgAggDO = null;
		BlStOepDO reStDO = null;
		BlpaypatoepAggDO rePayAggDO = null;
		BlincoepAggDO[] reIncAggDos = null;
		if(!allRefund){
			
			String[] reKeys =  new DBUtil().getOIDs(2);
			String reStId = reKeys[0];
			String rePayId = reKeys[1];
			
			//8.1重收记账数据
			reCgAggDO = this.reCalCgData(oldStDO.getId_pat(), reStId, cgItmDtos, oldCgItmDos);
			//8.2重收结算数据
			reStDO = this.reCalStData(reStId, rePayId, reCgAggDO.getBlCgItmOepDO(), oldStDO, refundSet);
			//8.3重收支付数据
			rePayAggDO = this.reCalPayData(reStDO, oldPayAggDO, refundSet, payOepPmDtos);
			//8.4重收发票数据
			reIncAggDos = super.saveIncData(new BlcgoepAggDO[]{reCgAggDO}, refundSet.getFg_print());
			//8.5处理医保
			this.rechargeHpOld(refundSet, reStDO);
		}
		
		if(!FBoolean.TRUE.equals(refundSet.getFg_dealfeeonly())){
			//9.修改原数据
			this.updateOldData(oldCgItmDos, oldStDO);
		
			//10.更新各种状态
			this.updateState(cgItmDtos,oldCgItmDos, reCgAggDO);
			
			//11.发送退费事件
			this.invokeRefund(allRefund, cgItmDtos,
					oldCgAggDos, oldStDO, oldPayAggDO,
					redCgAggDos, redStDO, redPayAggDO, redIncAggDos,
					reCgAggDO == null ? null : new BlcgoepAggDO[] { reCgAggDO },
					reStDO, rePayAggDO, reIncAggDos);
		}
		
		//13.组织返回值
		BlOepRefundRltDTO rlt = new BlOepRefundRltDTO();
		rlt.setId_pat(oldStDO.getId_pat());
		rlt.setId_stold(oldStDO.getId_stoep());
		rlt.setId_strefund(redStDO.getId_stoep());
		rlt.setFg_printred(this.fgPrintRedInc);
		
		FArrayList redIncList = new FArrayList();
		for (BlincoepAggDO redIncAggDO : redIncAggDos) {
			redIncList.add(redIncAggDO.getParentDO().getId_incoep());
		}
		rlt.setId_incred(redIncList);
		
		if(!allRefund){
			rlt.setId_strecharge(reStDO.getId_stoep());
			rlt.setId_payrecharge(rePayAggDO.getParentDO().getId_paypatoep());
			
			FArrayList reIncList = new FArrayList();
			for (BlincoepAggDO reIncAggDO : reIncAggDos) {
				reIncList.add(reIncAggDO.getParentDO().getId_incoep());
			}
			
			rlt.setId_increcharge(null);
		}
		
		rlt.setId_hp(oldStDO.getId_hp());
		
		return rlt;
	}
	
	/**
	 * 初始化退费配置的一些数据
	 * @param refundSet
	 */
	private void initRefundSet(BlOepRefundSetDTO refundSet){
		
		if(!StringUtil.isEmpty(refundSet.getId_hp())){
			
			if(refundSet.getAmt_all() == null){
				refundSet.setAmt_all(FDouble.ZERO_DBL);
			}
			
			if(refundSet.getAmt_hpall() == null){
				refundSet.setAmt_hpall(FDouble.ZERO_DBL);
			}
			
			if(refundSet.getAmt_hp() == null){
				refundSet.setAmt_hp(FDouble.ZERO_DBL);
			}
			
			if(refundSet.getAmt_psnacc() == null){
				refundSet.setAmt_psnacc(FDouble.ZERO_DBL);
			}
			
			if(refundSet.getAmt_diff() == null){
				refundSet.setAmt_diff(FDouble.ZERO_DBL);
			}
			
			if(refundSet.getAmt_hosbear() == null){
				refundSet.setAmt_hosbear(FDouble.ZERO_DBL);
			}
		}
	}

	/**
	 * 回写各种状态
	 * @param cgItmDtos
	 * @param oldCgItmDos
	 * @param reCgAggDO
	 */
	private void updateState(BlOepRefundItmDTO[] cgItmDtos, BlCgItmOepDO[] oldCgItmDos,BlcgoepAggDO reCgAggDO) throws BizException {
		
		Set<String> refundItmCgIdSet = new HashSet<String>();
		for (BlOepRefundItmDTO refundItm : cgItmDtos) {
			refundItmCgIdSet.add(refundItm.getId_cgitm());
		}
		
		List<String> rechargeOldCgIdList= new ArrayList<String>();
		if(reCgAggDO != null){
			for (BlCgItmOepDO ctItmDO : reCgAggDO.getBlCgItmOepDO()) {
				rechargeOldCgIdList.add(ctItmDO.getId_par());
			}
		}
		
		//1.回写医嘱退费状态
		List<String> orsrvIdList = new ArrayList<String>();
		for (BlCgItmOepDO oldCgItm : oldCgItmDos) {
			
			if(!refundItmCgIdSet.contains(oldCgItm.getId_cgitmoep()))
				continue;
			
			if(rechargeOldCgIdList.contains(oldCgItm.getId_cgitmoep()))
				continue;
			
			if(!StringUtil.isEmpty(oldCgItm.getId_orsrv())){
				orsrvIdList.add(oldCgItm.getId_orsrv());
			}
		}
		if(orsrvIdList.size() > 0){
			ICiOrdMaintainService ciService = ServiceFinder.find(ICiOrdMaintainService.class);
			ciService.UpdateOrdChargeRelInfo2(orsrvIdList.toArray(new String[0]), ICiDictCodeConst.SD_SU_BL_REFOUND_ID, ICiDictCodeConst.SD_SU_BL_REFOUND, BlFlowContextUtil.getNowTime(), FeeReverseType.BLSTREVERSE);
		}
	}

	/**
	 * 可退性校验
	 * @param cgItmDtos
	 * @param cgItmDos
	 * @return 是否全部退费
	 * @throws BizException
	 */
	private boolean validateRefundable(BlStOepDO stDO, BlOepRefundItmDTO[] cgItmDtos,Map<String, BlCgItmOepDO> cgItmMap) throws BizException {
		
		if(StringUtil.isEmpty(stDO.getId_paypatoep())){
			throw new BizException(String.format("%s:原结算信息未进行收付款", getBusinessName()));
		}
		
		if(FBoolean.TRUE.equals(stDO.getFg_canc())){
			throw new BizException(String.format("%s:该结算已退费", getBusinessName()));
		}
		
		//是否全部退费
		boolean allRefund = cgItmDtos.length == cgItmMap.size();
		
		List<BlCgItmOepDO> checkCgList = new ArrayList<BlCgItmOepDO>();
		for (BlOepRefundItmDTO cgItmDto : cgItmDtos) {
			
			BlCgItmOepDO cgItmDO = cgItmMap.get(cgItmDto.getId_cgitm());
			checkCgList.add(cgItmDO);
			
			if (!FDoubleUtils.isEqualWithTwoFDouble(cgItmDO.getQuan(),
					cgItmDto.getQuan_bk())) {
				allRefund = false;
				
				if(cgItmDto.getQuan_bk().compareTo(cgItmDO.getQuan()) > 0){
					throw new BizException(String.format(
							"退费数量不能大于记账数量,服务:%s 退数量:", cgItmDO.getName_srv(),
							cgItmDto.getQuan_bk().toString()));
				}
			}
		}
		
		if(!StringUtil.isEmpty(stDO.getPecode())){
			PeReturnableValidator peValidator = new PeReturnableValidator();
			peValidator.validate(checkCgList.toArray(new BlCgItmOepDO[0]));
			
		}else{
			CgReturnableValidator cgValidator = new CgReturnableValidator();
			cgValidator.validate(checkCgList.toArray(new BlCgItmOepDO[0]));
		}
		
		return allRefund;
	}

	/**
	 * 预交金退回充值
	 * @param refundSet
	 * @param payOepPmDtos
	 * @throws BizException
	 */
	private void prepayRecharge(BlOepRefundSetDTO refundSet, BlPayOepPmDTO[] payOepPmDtos) throws BizException{
		
		for (BlPayOepPmDTO pmDto : payOepPmDtos) {
			if(IBdPripmCodeConst.CODE_PRI_PM_PAY.equals(pmDto.getSd_pm())){
				
				BlPrepayCDTO prepayDto = new BlPrepayCDTO();
				prepayDto.setId_pat(refundSet.getId_pat());
				prepayDto.setSd_pttp(refundSet.getSd_pttp());
				prepayDto.setAmt(pmDto.getAmt());
				prepayDto.setNote("门诊预交金结算");
				
				BlPrepaySetDTO setDto = new BlPrepaySetDTO();
				setDto.setFg_print(FBoolean.FALSE);
				setDto.setFg_accupdate(FBoolean.TRUE);
				setDto.setFg_checkacc(FBoolean.FALSE);
				
				IBlPrepayCmdService prepayService = ServiceFinder.find(IBlPrepayCmdService.class);
				BlPrePayPatDO prepayDO = prepayService.consumeAmtRefund(prepayDto, setDto);
				
				pmDto.setId_paypat(prepayDO.getId_paypat());
				break;
			}
		}
	}
	
	/**
	 * 红冲记账数据
	 * @param oldCgAggDos
	 * @param stId
	 * @return
	 * @throws BizException
	 */
	private BlcgoepAggDO[] refundCg(BlcgoepAggDO[] oldCgAggDos, String stId) throws BizException{
		
		BlcgoepAggDO[] redCgAggDos = new BlcgoepAggDO[oldCgAggDos.length];
		IBillcodeManage iBillcodeManage = ServiceFinder.find(IBillcodeManage.class);
		String[] codes = iBillcodeManage.getBatchBillCodes_RequiresNew(BlCgOepDO.class.getName(),new BlCgOepDO(), oldCgAggDos.length);
		
		for (int i = 0; i < oldCgAggDos.length; i++) {
			BlcgoepAggDO redCgAggDO = BlOepChargeDataUtil.buildRedCgData(oldCgAggDos[i], stId);
			redCgAggDO.getParentDO().setCode_cg(codes[i]);
			redCgAggDos[i] = redCgAggDO;
		}
		
		redCgAggDos = this.cgCudService.insert(redCgAggDos);
		
		return redCgAggDos;
	}
	
	/**
	 * 红冲结算数据
	 * @param oldStDO
	 * @param stId
	 * @param refundSet 退费信息
	 * @return
	 * @throws BizException
	 */
	private BlStOepDO refundSt(BlStOepDO oldStDO, String stId, String payId, BlOepRefundSetDTO refundSet) throws BizException{
		BlStOepDO redStDO = BlOepChargeDataUtil.buildRedStDataWithRefundSet(oldStDO, stId, payId,refundSet);
		redStDO = this.stCudService.insert(new BlStOepDO[]{redStDO})[0];
		return redStDO;
	}
	
	/**
	 * 红冲收付款数据
	 * @param oldPayAggDO
	 * @param payOepPmDtos
	 * @param refundSet
	 * @param allRefund
	 * @param redPayId
	 * @return
	 */
	private BlpaypatoepAggDO refundPay(BlpaypatoepAggDO oldPayAggDO, BlPayOepPmDTO[] payOepPmDtos, BlOepRefundSetDTO refundSet, boolean allRefund, String redPayId) throws BizException {
		
		BlpaypatoepAggDO redPayAggDO = null;
		if(allRefund){
			redPayAggDO = new BlpaypatoepAggDO();
			BlPayPatOepDO redPayDO = BlOepChargeDataUtil.buildRedPayHeadData(oldPayAggDO.getParentDO(), refundSet.getSd_pttp(), redPayId);
			BlPayItmPatOepDO[] redPayItmDos = new BlPayItmPatOepDO[payOepPmDtos.length];
			for (int i = 0; i < payOepPmDtos.length; i++) {
				BlPayItmPatOepDO redPayItmDO = BlOepChargeDataUtil.buildPayItmData(payOepPmDtos[i]);
				redPayItmDos[i] = redPayItmDO;
			}
			redPayAggDO.setParentDO(redPayDO);
			redPayAggDO.setBlPayItmPatOepDO(redPayItmDos);
			
		}else{
			redPayAggDO = BlOepChargeDataUtil.buildAllRefundRedPayData(oldPayAggDO, refundSet.getSd_pttp(), redPayId);
		}
		
		redPayAggDO = this.payCudService.insert(new BlpaypatoepAggDO[]{redPayAggDO})[0];
		return redPayAggDO;
	}
	
	/**
	 * 红冲发票数据
	 * @param oldStDO
	 * @param redCgAggDos
	 * @return
	 * @throws BizException
	 */
	private BlincoepAggDO[] refundInc(BlStOepDO oldStDO, BlcgoepAggDO[] redCgAggDos, BlOepRefundSetDTO refundSet) throws BizException {
		
		IBlIncValidateService incValidateService = ServiceFinder.find(IBlIncValidateService.class);
		IBlIncOutCmdService incCmdService = ServiceFinder.find(IBlIncOutCmdService.class);
		
		if(FBoolean.TRUE.equals(refundSet.getFg_printred())){
			if(!StringUtil.isEmpty(oldStDO.getId_hp())){
				this.fgPrintRedInc = incValidateService.isPrintRedInc2(oldStDO.getId_hp(), FBoolean.FALSE);
			}
		}
		
		BlincoepAggDO[] incAggDos = incCmdService.saveRedOpInvoice(oldStDO.getId_stoep(), redCgAggDos, this.fgPrintRedInc);
		return incAggDos;
	}
	
	/**
	 * 红冲分摊数据
	 * @param oldPropDO
	 * @param redStId
	 * @return
	 */
	private BlPropOepDO refundProp(String redStId) throws BizException {
		BlPropOepDO redPropDO = BlOepChargeDataUtil.buildRedPropData(redStId);
		IBlpropoepCudService propService = ServiceFinder.find(IBlpropoepCudService.class);
		redPropDO = propService.insert(new BlPropOepDO[]{redPropDO})[0];
		return redPropDO;
	}
	
	/**
	 * 红冲分摊数据
	 * @param oldPropArDO
	 * @param redPropDO
	 * @param busiCode
	 */
	private BlPropArOepDO refundPropAr(BlPropArOepDO oldPropArDO, BlPropOepDO redPropDO,String busiCode) throws BizException {
		BlPropArOepDO redPropArDO = BlOepChargeDataUtil.buildRedPropArData(oldPropArDO, redPropDO.getId_propoep(), busiCode);
		IBlproparoepMDOCudService service = ServiceFinder.find(IBlproparoepMDOCudService.class);
		redPropArDO = service.insert(new BlPropArOepDO[]{redPropArDO})[0];
		return redPropArDO;
	}
	
	/**
	 * 计算重收记账数据
	 * @param patId
	 * @param reStId
	 * @param cgItmDtos
	 * @param oldCgItmDos
	 * @return
	 */
	private BlcgoepAggDO reCalCgData(String patId, String reStId, BlOepRefundItmDTO[] cgItmDtos, BlCgItmOepDO[] oldCgItmDos) throws BizException {
		
		BlcgoepAggDO reCgAggDO = new BlcgoepAggDO();
		BlCgOepDO reCgDO = new BlCgOepDO();
		reCgDO.setId_grp(Context.get().getGroupId());
		reCgDO.setId_org(Context.get().getOrgId());
		reCgDO.setCode_cg(BlCodeUtils.generateOepCgCode());
		reCgDO.setId_pat(patId);
		reCgDO.setEu_direct(BookRtnDirectEnum.CHARGES);
		reCgDO.setDt_cg(BlFlowContextUtil.getNowTime());
		reCgDO.setId_org_cg(Context.get().getOrgId());
		reCgDO.setId_dep_cg(Context.get().getDeptId());
		reCgDO.setId_emp_cg(Context.get().getStuffId());
		reCgDO.setStatus(DOStatus.NEW);
		reCgAggDO.setParentDO(reCgDO);
		
		Map<String, BlOepRefundItmDTO> cgItmDtoMap = (Map<String, BlOepRefundItmDTO>) MapUtils
				.convertArrayToMap(cgItmDtos, "Id_cgitm");
		
		List<BlCgItmOepDO> reCgItmList = new ArrayList<BlCgItmOepDO>();
		for (BlCgItmOepDO cgItmDO : oldCgItmDos) {
			
			BlOepRefundItmDTO cgItmDto = cgItmDtoMap.get(cgItmDO.getId_cgitmoep());
			if(cgItmDto == null || !FDoubleUtils.isEqualWithTwoFDouble(cgItmDto.getQuan_bk(), cgItmDO.getQuan())){
			
				FDouble subQuan = cgItmDto == null ? cgItmDO.getQuan() : cgItmDO.getQuan().sub(cgItmDto.getQuan_bk());
				BlCgItmOepDO reCgItmDO = (BlCgItmOepDO)cgItmDO.clone();
				reCgItmDO.setId_cgoep(null);
				reCgItmDO.setId_cgitmoep(null);
				reCgItmDO.setQuan(subQuan);
				reCgItmDO.setAmt_std(reCgItmDO.getPrice().multiply(reCgItmDO.getQuan(), IBlConst.PRECISION_AMOUNT));
				reCgItmDO.setAmt_ratio(reCgItmDO.getPrice_ratio().multiply(reCgItmDO.getQuan(), IBlConst.PRECISION_AMOUNT));
				reCgItmDO.setAmt(reCgItmDO.getAmt_ratio());
				reCgItmDO.setAmt_pat(reCgItmDO.getAmt_ratio());
				reCgItmDO.setFg_refund(FBoolean.FALSE);
				reCgItmDO.setDt_st(BlFlowContextUtil.getNowTime());
				reCgItmDO.setId_stoep(reStId);
				reCgItmDO.setId_par(cgItmDO.getId_cgitmoep());
				reCgItmDO.setNote(String.format("退重收，对象：【%s】", cgItmDO.getId_cgitmoep()));
				reCgItmDO.setId_root(StringUtil.isEmpty(cgItmDO.getId_root()) ? cgItmDO.getId_cgitmoep() : cgItmDO.getId_root());
				reCgItmList.add(reCgItmDO);
			}
		}
		
		reCgAggDO.setBlCgItmOepDO(reCgItmList.toArray(new BlCgItmOepDO[0]));
		
		reCgAggDO = this.cgCudService.insert(new BlcgoepAggDO[]{reCgAggDO})[0];
		return reCgAggDO;
	}

	/**
	 * 重收结算数据
	 * @param reStId
	 * @param rePayId
	 * @param blCgItmOepDO
	 * @param oldStDO
	 * @param codeSt
	 * @return
	 */
	private BlStOepDO reCalStData(String reStId, String rePayId, BlCgItmOepDO[] cgItmDos, BlStOepDO oldStDO, BlOepRefundSetDTO refundSet) throws BizException {
		
		//计算金额
		Set<String> pecodeSet = new HashSet<String>();
		FDouble amtStd = FDouble.ZERO_DBL;
		FDouble amtRatio = FDouble.ZERO_DBL;
		for (BlCgItmOepDO cgItmDO : cgItmDos) {
			amtStd = amtStd.add(cgItmDO.getAmt_std());
			amtRatio = amtRatio.add(cgItmDO.getAmt_ratio());
			if(!StringUtil.isEmpty(cgItmDO.getPecode())){
				pecodeSet.add(cgItmDO.getPecode());
			}
		}
		
		BlStOepDO stDO = new BlStOepDO();
		stDO.setId_patca(oldStDO.getId_patca());
		stDO.setId_stoep(reStId);
		stDO.setId_org(Context.get().getOrgId());
		stDO.setId_grp(Context.get().getGroupId());
		stDO.setId_pat(oldStDO.getId_pat());
		stDO.setId_ent(oldStDO.getId_ent());
		stDO.setId_enttp(oldStDO.getId_enttp());
		stDO.setCode_enttp(oldStDO.getCode_enttp());
		if(!StringUtil.isEmpty(refundSet.getCode_st())){
			stDO.setCode_st(refundSet.getCode_st());
		}else{
			stDO.setCode_st(BlCodeUtils.generateOepStCode());
		}
		
		stDO.setEu_direct(BookRtnDirectEnum.CHARGES);
		stDO.setEu_sttp(BlOepChargeDataUtil.getStType(cgItmDos));
		stDO.setId_stresult(IBlDictCodeConst.ID_STRESULT_NORMAL);
		stDO.setSd_stresult(IBlDictCodeConst.SD_STRESULT_NORMAL);
		stDO.setAmt_std(amtStd);
		stDO.setAmt_ratio(amtRatio);
		if(StringUtil.isEmpty(refundSet.getId_hp())){
			stDO.setAmt(amtRatio);
			stDO.setAmt_pat(amtRatio);
			stDO.setAmt_hp(FDouble.ZERO_DBL);
		}else{
			stDO.setAmt_hp(FDoubleUtils.nullToZero(refundSet.getAmt_hp()).add(FDoubleUtils.nullToZero(refundSet.getAmt_hosbear())));
			stDO.setAmt_pat(FDoubleUtils.nullToZero(refundSet.getAmt_cash()).add(FDoubleUtils.nullToZero(refundSet.getAmt_psnacc())));
			stDO.setAmt(stDO.getAmt_ratio().sub(stDO.getAmt_hp()));
		}
		
		stDO.setId_par(oldStDO.getId_stoep());
		stDO.setDt_st(BlFlowContextUtil.getNowTime());
		stDO.setId_dep_st(Context.get().getDeptId());
		stDO.setId_emp_st(Context.get().getStuffId());
		stDO.setFg_cc(FBoolean.FALSE);
		stDO.setFg_canc(FBoolean.FALSE);
		stDO.setFg_arclear(FBoolean.TRUE);
		stDO.setId_paypatoep(rePayId);
		stDO.setId_hp(oldStDO.getId_hp());
		stDO.setId_hpsttp(oldStDO.getId_hpsttp());
		stDO.setSd_hpsttp(oldStDO.getSd_hpsttp());
		if(StringUtil.isEmpty(oldStDO.getId_rootst())){
			stDO.setId_rootst(oldStDO.getId_stoep());
		}else{
			stDO.setId_rootst(oldStDO.getId_rootst());
		}
		if(pecodeSet.size() > 0){
			String pecode = "";
			for (String str : pecodeSet) {
				pecode += str + ",";
			}
			
			pecode = pecode.substring(0, pecode.length() - 1);
			stDO.setPecode(pecode);
		}
		
		stDO.setStatus(DOStatus.NEW);
		
		stDO = this.stCudService.insert(new BlStOepDO[]{stDO})[0];
		return stDO;
	}

	/**
	 * 重收收付款数据
	 * @param reStDO
	 * @param redPaoldPayAggDOyAggDO
	 * @param payOepPmDtos
	 * @return
	 */
	private BlpaypatoepAggDO reCalPayData(BlStOepDO reStDO, BlpaypatoepAggDO oldPayAggDO, BlOepRefundSetDTO refundSet, BlPayOepPmDTO[] payOepPmDtos) throws BizException {
		
		BlpaypatoepAggDO rePayAggDO = new BlpaypatoepAggDO();
		BlPayPatOepDO rePayDO = BlOepChargeDataUtil.buildPayHeadData(reStDO, refundSet.getSd_pttp());
		rePayDO.setId_paypatoep(reStDO.getId_paypatoep());
		rePayAggDO.setParentDO(rePayDO);
		
		List<BlPayItmPatOepDO> rePayItmList = new ArrayList<BlPayItmPatOepDO>();
		//原支付方式，虚交易
		for (BlPayItmPatOepDO oldPayItmDO : oldPayAggDO.getBlPayItmPatOepDO()) {
			BlPayItmPatOepDO rePayItmDO = (BlPayItmPatOepDO)oldPayItmDO.clone();
			rePayItmDO.setId_paypatoep(null);
			rePayItmDO.setId_payitmpatoep(null);
			rePayItmDO.setId_paypat(null);
			rePayItmDO.setFg_realpay(FBoolean.FALSE);
			rePayItmList.add(rePayItmDO);
		}
		
		//新支付方式，实交易
		for (BlPayOepPmDTO payPmDto : payOepPmDtos) {
			BlPayItmPatOepDO rePayItmDO = BlOepChargeDataUtil.buildPayItmData(payPmDto);
			rePayItmList.add(rePayItmDO);
		}
		
		rePayAggDO.setBlPayItmPatOepDO(rePayItmList.toArray(new BlPayItmPatOepDO[0]));
		
		rePayAggDO = this.payCudService.insert(new BlpaypatoepAggDO[]{rePayAggDO})[0];
		return rePayAggDO;
	}
	
	/**
	 * 更新旧数据
	 * @param oldCgItmDos
	 * @param oldStDO
	 * @throws BizException 
	 */
	private void updateOldData(BlCgItmOepDO[] oldCgItmDos, BlStOepDO oldStDO) throws BizException {
		
		for (BlCgItmOepDO cgItmDO : oldCgItmDos) {
			cgItmDO.setFg_refund(FBoolean.TRUE);
		}
		
		oldStDO.setFg_canc(FBoolean.TRUE);
		oldStDO.setId_emp_canc(Context.get().getStuffId());
		oldStDO.setDt_canc(BlFlowContextUtil.getNowTime());
		
		this.daf.updateDOArray(oldCgItmDos, new String[]{BlCgItmOepDO.FG_REFUND});
		this.daf.updateDO(oldStDO, new String[] { BlStOepDO.FG_CANC, BlStOepDO.ID_EMP_CANC, BlStOepDO.DT_CANC });
	}
	
	/**
	 * 发送退费事件
	 * @param oldCgAggDos
	 * @param oldStDO
	 * @param oldPayAggDO
	 * @param redCgAggDos
	 * @param redStDO
	 * @param redPayAggDO
	 * @param redIncAggDos
	 * @throws BizException
	 */
	private void invokeRefund(boolean allRefund, BlOepRefundItmDTO[] cgItmDtos,
			BlcgoepAggDO[] oldCgAggDos, BlStOepDO oldStDO, BlpaypatoepAggDO oldPayAggDO, 
			BlcgoepAggDO[] redCgAggDos, BlStOepDO redStDO, BlpaypatoepAggDO redPayAggDO, BlincoepAggDO[] redIncAggDos,
			BlcgoepAggDO[] newCgAggDos, BlStOepDO newStDO, BlpaypatoepAggDO newPayAggDO, BlincoepAggDO[] newIncAggDos)
			throws BizException {
		
		IBlincoepRService incService = ServiceFinder.find(IBlincoepRService.class);
		BlincoepAggDO[] oldIncAggDos = incService.findByAttrValString(BlIncOepDO.ID_STOEP, oldStDO.getId_stoep());
		
		//实际退费项目
		List<String> refundItmCgIdList = new ArrayList<String>();
		for (BlOepRefundItmDTO refundItm : cgItmDtos) {
			refundItmCgIdList.add(refundItm.getId_cgitm());
		}
		
		List<BlCgItmOepDO> actualCgList = new ArrayList<BlCgItmOepDO>();
		for (BlcgoepAggDO cgAggDO : oldCgAggDos) {
			for (BlCgItmOepDO oldCgItm : cgAggDO.getBlCgItmOepDO()) {
				if(refundItmCgIdList.contains(oldCgItm.getId_cgitmoep())){
					actualCgList.add(oldCgItm);
				}
			}
		}
		
		BlOpPayEvent.invokeRefund(new FBoolean(allRefund), actualCgList.toArray(new BlCgItmOepDO[0]),
				oldCgAggDos, oldStDO, oldPayAggDO, oldIncAggDos,
				redCgAggDos, redStDO, redPayAggDO, redIncAggDos,
				newCgAggDos, newStDO, newPayAggDO, newIncAggDos);
	}
	
	/**
	 * 红冲医保分摊
	 * @param oldPropArDO
	 * @param redPropDO
	 * @param redPropArDO
	 * @throws BizException
	 */
	private void refundHpOld(BlPropArOepDO oldPropArDO, BlPropOepDO redPropDO, BlPropArOepDO redPropArDO) throws BizException {
		//医保接口调用接口类型
		int miBd0001= MiParamUtil.MIBD0001();
		if(miBd0001==1){
			InsureContext insContext = new InsureContext();
			insContext.setIdHp(redPropArDO.getId_hp());
			InsureFacade insFacade = new InsureFacade(insContext);
			
			HisPropertyRefHpDTO dto =new HisPropertyRefHpDTO();
		    dto.setId_ref(redPropArDO.getId_proparoep());
		    dto.setId_ref_prop(redPropDO.getId_propoep());
		    dto.setId_refold(oldPropArDO.getId_proparoep());
		    
		    insFacade.saveBackPropDataOep(dto);
		}else{
			MiContext miContext = new MiContext();
			miContext.setIdHp(redPropArDO.getId_hp());
			MiFacade miFacade = new MiFacade(miContext);
			
			HisPropertyRefHpDTO dto =new HisPropertyRefHpDTO();
		    dto.setId_ref(redPropArDO.getId_proparoep());
		    dto.setId_ref_prop(redPropDO.getId_propoep());
		    dto.setId_refold(oldPropArDO.getId_proparoep());
		    
		    miFacade.saveBackPropDataOep(dto);		
		}
	}
	
	/**
	 * 重收医保(旧接口)
	 * @param payoepDto
	 */
	@SuppressWarnings("unchecked")
	private void rechargeHpOld(BlOepRefundSetDTO refundSet, BlStOepDO stDO) throws BizException{
		
		if(StringUtil.isEmpty(refundSet.getId_hp()))
			return;
		
		String propId = new DBUtil().getOIDs(1)[0];
		//分摊数据
		BlPropOepDO propDO = BlOepChargeDataUtil.buildPropOepData(propId, stDO);
		//应收数据
		BlPayOepDTO payoepDto = new BlPayOepDTO();
		payoepDto.setId_hp(refundSet.getId_hp());  
		payoepDto.setAmt_hp(refundSet.getAmt_hp());
		payoepDto.setAmt_psnacc(refundSet.getAmt_psnacc());
		payoepDto.setAmt_cash(refundSet.getAmt_cash());
		payoepDto.setAmt_hosbear(refundSet.getAmt_hosbear());
		payoepDto.setCode_business(refundSet.getCode_business());
		
		BlPropArOepDO propArDO = BlOepChargeDataUtil.buildPropArOepData(propId, stDO, payoepDto);
		
		IBlpropoepCudService propService = ServiceFinder.find(IBlpropoepCudService.class);
		IBlproparoepMDOCudService propArService = ServiceFinder.find(IBlproparoepMDOCudService.class);
		
		propService.insert(new BlPropOepDO[]{propDO});
		BlPropArOepDO newPropArDO = propArService.insert(new BlPropArOepDO[]{propArDO})[0];
		
		//医保接口调用接口类型
		int miBd0001= MiParamUtil.MIBD0001();
		if(miBd0001==1){
			InsureContext insContext = new InsureContext();
			insContext.setIdHp(refundSet.getId_hp());
			InsureFacade insFacade = new InsureFacade(insContext);
			
			OepSettleRtnValDTO rtnVal = null;
			if(!ListUtil.isEmpty(refundSet.getOldpropdata())){
				rtnVal = (OepSettleRtnValDTO)refundSet.getOldpropdata().get(0);
			}
			HisPropertyRefHpDTO refHpDto = new HisPropertyRefHpDTO();
			refHpDto.setId_ref(newPropArDO.getId_proparoep());
			refHpDto.setId_ref_prop(propId);
			refHpDto.setId_ref_preflow(stDO.getId_stoep());
			insFacade.savePayPropDataOep(rtnVal, refHpDto);
		}else{
			MiContext miContext = new MiContext();
			miContext.setIdHp(refundSet.getId_hp());
			MiFacade miFacade = new MiFacade(miContext);
			
			OepSettleRtnValDTO rtnVal = null;
			if(!ListUtil.isEmpty(refundSet.getOldpropdata())){
				rtnVal = (OepSettleRtnValDTO)refundSet.getOldpropdata().get(0);
			}
			HisPropertyRefHpDTO refHpDto = new HisPropertyRefHpDTO();
			refHpDto.setId_ref(newPropArDO.getId_proparoep());
			refHpDto.setId_ref_prop(propId);
			refHpDto.setId_ref_preflow(stDO.getId_stoep());
			miFacade.savePayPropDataOep(rtnVal, refHpDto);	
		}
	}

	@Override
	protected String getBusinessName() {
		return "门诊退费";
	}
}
