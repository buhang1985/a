package iih.bl.st.s.bp.oepcharge;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import iih.bd.base.utils.FDoubleUtils;
import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blcgoep.i.IBlCgItmOepDOCudService;
import iih.bl.cg.blcgquery.d.BookRtnDirectEnum;
import iih.bl.comm.s.bp.BlThirdPayBP;
import iih.bl.comm.util.BlFlowContextUtil;
import iih.bl.comm.util.BlUpdateOrChargeStateUtil;
import iih.bl.inc.blincoep.d.BlincoepAggDO;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.dto.prepay.d.BlPrepayCDTO;
import iih.bl.pay.dto.prepay.d.BlPrepayRDTO;
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
import iih.bl.st.blstoep.d.StTypeEnum;
import iih.bl.st.dto.blpayoep.d.BlPayOepDTO;
import iih.bl.st.dto.blpayoep.d.BlPayOepPmDTO;
import iih.bl.st.dto.blpayoep.d.BlPayOepRltDTO;
import iih.bl.st.s.bp.oepcharge.base.BlOepPaymentBaseBP;
import iih.bl.st.s.bp.oepcharge.util.BlOepChargeDataUtil;
import iih.bl.st.s.bp.oepcharge.validate.OepPaymentParamValidator;
import iih.ci.ord.ciorder.d.FeeReverseType;
import iih.en.pv.i.IEnOutCmdService;
import iih.mi.biz.dto.d.HisPropertyRefHpDTO;
import iih.mi.biz.dto.d.OepSettleRtnValDTO;
import iih.mi.itf.context.InsureContext;
import iih.mi.itf.facade.InsureFacade;
import iih.mi.itf2.dto.MiContext;
import iih.mi.itf2.facade.MiFacade;
import iih.mi.itf2.util.MiParamUtil;
import iih.mp.dg.i.IMpDgConst;
import iih.mp.dg.i.IMpDgOutService;
import iih.pi.acc.account.d.PiPatAccDO;
import iih.pi.acc.account.i.IAccountMDOCudService;
import xap.lui.core.xml.StringUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.dataaccess.DBUtil;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 门诊收付款
 * @author ly 2018/12/08
 *
 */
public class BlOepPaymentBP extends BlOepPaymentBaseBP{

	private FDouble amtPrepay;//预交金消费金额
	private FDouble amtPrepayCg;//预交金记账金额
	private FDouble amtPrepayCharge;//预交金回冲金额
	
	public BlOepPaymentBP(){
		this.amtPrepay = FDouble.ZERO_DBL;
		this.amtPrepayCg = FDouble.ZERO_DBL;
		this.amtPrepayCharge = FDouble.ZERO_DBL;
	}
	
	/**
	 * 门诊收付款
	 * @param payoepDto 收付款信息
	 * @param payOepPmDtos 支付方式
	 * @param freeCgIds 减免项目
	 * @return 收付款结果
	 * @throws BizException
	 */
	public BlPayOepRltDTO exec(BlPayOepDTO payoepDto, BlPayOepPmDTO[] payOepPmDtos, String[] freeCgIds) throws BizException{
		
		//1.入参逻辑校验 
		OepPaymentParamValidator validator = new OepPaymentParamValidator(this.getBusinessName());
		validator.validate(payoepDto, payOepPmDtos);
		
		if(!StringUtil.isEmpty(payoepDto.getId_emp_pay())){
			Context.get().setStuffId(payoepDto.getId_emp_pay());
		}
		
		//2.加锁 
		super.addLock( payoepDto.getId_st());
		
		//3.查询结算数据
		BlStOepDO stDO = this.findAndCheckStInfo(payoepDto.getId_st());

		//4.获取记账数据
		BlCgItmOepDO[] cgItmDos = super.findCgInfo(payoepDto.getId_st());
		BlcgoepAggDO[] cgAggDos = super.findCgAggInfo(cgItmDos);
		//设置待更新信息
		this.setCgItmUpdateInfo(cgItmDos, freeCgIds);
		
		//5.校验金额
		this.validateAmt(cgItmDos, payoepDto, payOepPmDtos);
		
		//6.生成发票数据
		BlincoepAggDO[] incAggDos = super.saveIncData(cgAggDos, payoepDto.getFg_print());
		
		//7.预交金消费
		this.prepayConsume(payoepDto, payOepPmDtos);
		
		//8.找零结转
		String transPrepayId = this.chargeTransfer(payoepDto, payOepPmDtos);
		
		//8.预交金找零回冲
		//BlPrePayPatDO prepayRechargeDO = this.prepayRecharge(payoepDto, payOepPmDtos);
		
		//9.组装保存收付款数据
		BlpaypatoepAggDO payAggDO = this.savePaymentInfo(payoepDto, payOepPmDtos, stDO);
		
		//10.回写保存结算数据
		this.updateStInfo(stDO, payAggDO.getParentDO().getId_paypatoep(),payoepDto);
		
		//11.更新记账数据
		this.updateCgInfo(cgItmDos);
		
		//12.回写账户
		this.writebackAcc(payoepDto.getId_pat());
		
		//13.回写状态
		this.writebackState(cgItmDos,payAggDO,stDO);
		
		//14.药品分窗口
		this.dealWin(cgItmDos);
		
		//15.处理医保（旧接口）
		this.dealHpOld(payoepDto, stDO);
		
		//16.发送事件
		super.invokeChargeEvent(cgAggDos, stDO, payAggDO, incAggDos);
		
		//设置返回值
		return this.setReturnValue(stDO, cgItmDos, incAggDos, payAggDO.getParentDO(), transPrepayId);
	} 

	/**
	 * 校验金额
	 * 校验记账金额和支付金额是否一致
	 * @param cgItmDos
	 * @param payoepDto
	 * @param payOepPmDtos
	 * @throws BizException
	 */
	private void validateAmt(BlCgItmOepDO[] cgItmDos, BlPayOepDTO payoepDto, BlPayOepPmDTO[] payOepPmDtos) throws BizException{
		
		FDouble amtCgAll = FDouble.ZERO_DBL;
		for (BlCgItmOepDO cgItmDO : cgItmDos) {
			if(FBoolean.TRUE.equals(cgItmDO.getFg_acc())){
				this.amtPrepayCg = this.amtPrepayCg.add(cgItmDO.getAmt_ratio());
			}
			amtCgAll = amtCgAll.add(cgItmDO.getAmt_ratio());
		}
		
		FDouble amtPayAll = FDouble.ZERO_DBL;
		for (BlPayOepPmDTO pmDto : payOepPmDtos) {
			if(IBdPripmCodeConst.CODE_PRI_PM_PAY.equals(pmDto.getSd_pm()) && 
					FBoolean.FALSE.equals(pmDto.getFg_charge())){
				this.amtPrepay = pmDto.getAmt();
			}
			amtPayAll = amtPayAll.add(pmDto.getAmt().multiply(pmDto.getEu_direct()));
		}
		
		if(!FDoubleUtils.isEqualWithTwoFDouble(payoepDto.getAmt_pay(),amtCgAll)){
			throw new BizException(String.format("%s:付款金额与记账金额不一致", getBusinessName()));
		}
		
		if(!FDoubleUtils.isEqualWithTwoFDouble(payoepDto.getAmt_pay(),amtPayAll)){
			throw new BizException(String.format("%s:前后端付款金额不一致", getBusinessName()));
		}
	}
	
	/**
	 * 查询校验结算信息
	 * @param stId
	 * @return
	 * @throws BizException
	 */
	private BlStOepDO findAndCheckStInfo(String stId) throws BizException{
		
		BlStOepDO stDO = (BlStOepDO)this.daf.findByPK(BlStOepDO.class, stId);
		if(stDO == null){
			throw new BizException(String.format("%s:结算信息不存在", getBusinessName()));
		}
		
		if(!StringUtil.isEmpty(stDO.getId_paypatoep())){
			throw new BizException(String.format("%s:已收付款，无法再次付款", getBusinessName()));
		}
		
		return stDO;
	}

	/**
	 * 设置记账数据待更新信息
	 * @param cgItmDos
	 * @param freeCgIds
	 * @throws BizException
	 */
	private void setCgItmUpdateInfo(BlCgItmOepDO[] cgItmDos, String[] freeCgIds) throws BizException{
		
		for (BlCgItmOepDO cgItmDO : cgItmDos) {
			cgItmDO.setStatus(DOStatus.UPDATED);
			cgItmDO.setFg_susp(FBoolean.FALSE);
			
			if(!ArrayUtil.isEmpty(freeCgIds)){
				for (String cgId : freeCgIds) {
					if(cgItmDO.getId_cgitmoep().equals(cgId)){
						cgItmDO.setFg_free(FBoolean.TRUE);
						break;
					}
				}
			}
		}
	}
	
	/**
	 * 预交金消费
	 * @param payOepPmDtos
	 * @throws BizException
	 */
	private void prepayConsume(BlPayOepDTO payoepDto, BlPayOepPmDTO[] payOepPmDtos) throws BizException{
		
		for (BlPayOepPmDTO pmDto : payOepPmDtos) {
			if(IBdPripmCodeConst.CODE_PRI_PM_PAY.equals(pmDto.getSd_pm()) && 
					BookRtnDirectEnum.CHARGES == pmDto.getEu_direct()){
				IBlPrepayCmdService prepayService = ServiceFinder.find(IBlPrepayCmdService.class);
				BlPrepayCDTO prepayDto = new BlPrepayCDTO();
				prepayDto.setId_pat(payoepDto.getId_pat());
				prepayDto.setSd_pttp(payoepDto.getSd_pttp());
				prepayDto.setAmt(pmDto.getAmt());
				prepayDto.setAmt_lock(this.amtPrepayCg);
				prepayDto.setNote("门诊预交金结算");
				
				BlPrepaySetDTO setDto = new BlPrepaySetDTO();
				setDto.setFg_print(FBoolean.FALSE);
				setDto.setFg_accupdate(FBoolean.FALSE);
				setDto.setFg_checkacc(FBoolean.TRUE);
				
				BlPrePayPatDO prepayDO = prepayService.consumeAmt(prepayDto, setDto);
				pmDto.setId_paypat(prepayDO.getId_paypat());
				
				break;
			}
		}
	}
	
	/**
	 * 找零结转
	 * @param payoepDto
	 * @param payOepPmDtos
	 * @return
	 * @throws BizException
	 */
	private String chargeTransfer(BlPayOepDTO payoepDto, BlPayOepPmDTO[] payOepPmDtos) throws BizException{
		
		BlPayOepPmDTO transferPmDto = null;
		for (BlPayOepPmDTO blPayOepPmDTO : payOepPmDtos) {
			if(FBoolean.TRUE.equals(blPayOepPmDTO.getFg_transfer())){
				transferPmDto = blPayOepPmDTO;
			}
		}
		
		if(transferPmDto == null)
			return null;
		
		BlPrepayRDTO prepayDto = new BlPrepayRDTO();
		prepayDto.setId_pat(payoepDto.getId_pat());
		prepayDto.setAmt(transferPmDto.getAmt());
		prepayDto.setSd_pttp(payoepDto.getSd_pttp());
		prepayDto.setId_pm(transferPmDto.getId_pm());
		prepayDto.setSd_pm(transferPmDto.getSd_pm());
		prepayDto.setId_emp_pay(payoepDto.getId_emp_pay());
		prepayDto.setEu_direct(BookRtnDirectEnum.CHARGES);
		prepayDto.setDt_pay(BlFlowContextUtil.getNowTime());
		prepayDto.setNote("门诊结算找零结存");
		
		BlPrepaySetDTO prepaySet = new BlPrepaySetDTO();
		prepaySet.setFg_accupdate(FBoolean.TRUE);
		
		IBlPrepayCmdService prepayService = ServiceFinder.find(IBlPrepayCmdService.class);
		BlPrePayPatDO prepayDO = prepayService.recharge(prepayDto, prepaySet);
		
		transferPmDto.setId_paypat(prepayDO.getId_paypat());
		return transferPmDto.getId_paypat();
	}
	
	/**
	 * 预交金找零充值 
	 * @param payoepDto
	 * @param payOepPmDtos
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unused")
	private BlPrePayPatDO prepayRecharge(BlPayOepDTO payoepDto, BlPayOepPmDTO[] payOepPmDtos) throws BizException{
		
		BlPrePayPatDO prepayDO = null;
		for (BlPayOepPmDTO pmDto : payOepPmDtos) {
			if(IBdPripmCodeConst.CODE_PRI_PM_PAY.equals(pmDto.getSd_pm()) && 
					FBoolean.TRUE.equals(pmDto.getFg_charge())){
				IBlPrepayCmdService prepayService = ServiceFinder.find(IBlPrepayCmdService.class);
				BlPrepayRDTO prepayDto = new BlPrepayRDTO();
				prepayDto.setId_pat(payoepDto.getId_pat());
				prepayDto.setAmt(pmDto.getAmt());
				prepayDto.setSd_pttp(payoepDto.getSd_pttp());
				prepayDto.setEu_direct(BookRtnDirectEnum.CHARGES);
				prepayDto.setId_pm(IBdPripmCodeConst.CODE_PRI_PM_PAY);
				prepayDto.setSd_pm(IBdPripmCodeConst.ID_PRI_PM_PAY);
			
				BlPrepaySetDTO setDto = new BlPrepaySetDTO();
				setDto.setFg_print(FBoolean.TRUE);
				setDto.setFg_accupdate(FBoolean.FALSE);
				setDto.setFg_checkacc(FBoolean.TRUE);
				
				prepayDO = prepayService.recharge(prepayDto, setDto);
				pmDto.setId_paypat(prepayDO.getId_paypat());
				break;
			}
		}
		
		return prepayDO;
	}
	
	/**
	 * 保存收付款数据
	 * @param payoepDto
	 * @param payOepPmDtos
	 * @return
	 * @throws BizException
	 */
	private BlpaypatoepAggDO savePaymentInfo(BlPayOepDTO payoepDto, BlPayOepPmDTO[] payOepPmDtos,BlStOepDO stDO) throws BizException{
		
		BlpaypatoepAggDO payAggDO = new BlpaypatoepAggDO();
		BlPayPatOepDO payDO = BlOepChargeDataUtil.buildPayHeadData(stDO, payoepDto.getSd_pttp());
		payAggDO.setParentDO(payDO);
		
		BlPayItmPatOepDO[] payItmDos = new BlPayItmPatOepDO[payOepPmDtos.length];
		for (int i = 0; i < payOepPmDtos.length; i++) {
			BlPayItmPatOepDO payItmDO = BlOepChargeDataUtil.buildPayItmData(payOepPmDtos[i]);
			payItmDos[i] = payItmDO;
		}
		payAggDO.setBlPayItmPatOepDO(payItmDos);
		
		
		payAggDO = this.payCudService.insert(new BlpaypatoepAggDO[]{payAggDO})[0];
		return payAggDO;
	}
 
	/**
	 * 更新结算数据
	 * @param stDO
	 * @param payId
	 * @throws BizException
	 */
	private void updateStInfo(BlStOepDO stDO, String payId, BlPayOepDTO payoepDto) throws BizException{
		stDO.setId_paypatoep(payId);
		stDO.setId_hp(payoepDto.getId_hp());
		stDO.setId_patca(payoepDto.getId_patca());
		stDO.setId_medkind(payoepDto.getId_medkind());
		
		if(!StringUtil.isEmpty(payoepDto.getId_hp())){
			stDO.setAmt_hp(FDoubleUtils.nullToZero(payoepDto.getAmt_hp()).add(FDoubleUtils.nullToZero(payoepDto.getAmt_hosbear())));
			stDO.setAmt_pat(FDoubleUtils.nullToZero(payoepDto.getAmt_cash()).add(FDoubleUtils.nullToZero(payoepDto.getAmt_psnacc())));
			stDO.setAmt(stDO.getAmt_ratio().sub(stDO.getAmt_hp()));
		}
		
		daf.updateDO(stDO, new String[]{BlStOepDO.ID_PAYPATOEP,BlStOepDO.ID_HP,BlStOepDO.ID_PATCA,BlStOepDO.ID_MEDKIND,BlStOepDO.AMT,BlStOepDO.AMT_HP,BlStOepDO.AMT_PAT});
	}
	
	/**
	 * 更新记账数据
	 * @param cgItmDos
	 * @throws BizException
	 */
	private void updateCgInfo(BlCgItmOepDO[] cgItmDos) throws BizException{
		IBlCgItmOepDOCudService cgService = ServiceFinder.find(IBlCgItmOepDOCudService.class);
		cgService.update(cgItmDos);
	}
	
	/**
	 * 回写账户
	 * @param patId
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void writebackAcc(String patId) throws BizException{
		
		if(this.amtPrepay.compareTo(FDouble.ZERO_DBL) == 0 && 
				this.amtPrepayCg.compareTo(FDouble.ZERO_DBL) == 0 && 
				this.amtPrepayCharge.compareTo(FDouble.ZERO_DBL) == 0)
			return;
			
		DAFacade daf = new DAFacade();
		List<PiPatAccDO> patAccList = (List<PiPatAccDO>)daf.findByAttrValString(PiPatAccDO.class, PiPatAccDO.ID_PAT, patId, null);
		if(ListUtil.isEmpty(patAccList)){
			throw new BizException("患者账户不存在,患者id" + patId);
		}
		PiPatAccDO patAccDO = null;
		for (PiPatAccDO piPatAccDO : patAccList) {
			if(FBoolean.TRUE.equals(piPatAccDO.getFg_active())){
				patAccDO = piPatAccDO;
				break;
			}
		}
		if(patAccDO == null){
			throw new BizException("患者账户不存在,患者id" + patId);
		}
		
		patAccDO.setPrepay(patAccDO.getPrepay().sub(this.amtPrepay).add(this.amtPrepayCharge));
		patAccDO.setAcc_lock(patAccDO.getAcc_lock().sub(this.amtPrepayCg));
		
		IAccountMDOCudService accMService = ServiceFinder.find(IAccountMDOCudService.class);
		accMService.update(new PiPatAccDO[]{patAccDO});
	}
	
	/**
	 * 回写各种状态
	 * @param cgItmDos
	 * @throws BizException
	 */
	private void writebackState(BlCgItmOepDO[] cgItmDos,BlpaypatoepAggDO payAggDO, BlStOepDO stDO) throws BizException{
		
		List<String> orsrvIdList = new ArrayList<String>();
		for (BlCgItmOepDO itmDO : cgItmDos) {
			if (FBoolean.FALSE.equals(itmDO.getFg_acc()) && FBoolean.FALSE.equals(itmDO.getFg_hpcg())
					&& !StringUtil.isEmpty(itmDO.getId_orsrv())) {
				orsrvIdList.add(itmDO.getId_orsrv());
			}
		}
		
		//回写医嘱状态
		if(orsrvIdList.size() > 0){
			BlUpdateOrChargeStateUtil.updateChargeStatus(orsrvIdList.toArray(new String[0]), BlFlowContextUtil.getNowTime(), FeeReverseType.NOBLCANCEL);
		}
		
		//回写医嘱打印单状态
		
		//回写就诊状态
		if (StTypeEnum.ST_OEP_REG.equals(stDO.getEu_sttp())) {
			IEnOutCmdService enService = ServiceFinder.find(IEnOutCmdService.class);
			enService.ubpdateFgstAfterSt(stDO.getId_stoep());
		}
		
		//回写第三方支付 第三方交易记录状态  zhangxin 
		ThirdPaySettle(cgItmDos,payAggDO,stDO);
	}
	
	/**
	 * 处理医保(旧接口)
	 * @param payoepDto
	 */
	@SuppressWarnings("unchecked")
	private void dealHpOld(BlPayOepDTO payoepDto,BlStOepDO stDO) throws BizException{
		
		if(StringUtil.isEmpty(payoepDto.getId_hp()))
			return;
		
		String propId = new DBUtil().getOIDs(1)[0];
		//分摊数据
		BlPropOepDO propDO = BlOepChargeDataUtil.buildPropOepData(propId, stDO);
		//应收数据
		BlPropArOepDO propArDO = BlOepChargeDataUtil.buildPropArOepData(propId, stDO, payoepDto);
		
		IBlpropoepCudService propService = ServiceFinder.find(IBlpropoepCudService.class);
		IBlproparoepMDOCudService propArService = ServiceFinder.find(IBlproparoepMDOCudService.class);
		
		propService.insert(new BlPropOepDO[]{propDO});
		BlPropArOepDO newPropArDO = propArService.insert(new BlPropArOepDO[]{propArDO})[0];
		
		//医保接口调用接口类型
		int miBd0001= MiParamUtil.MIBD0001();
		if(miBd0001==1){
			InsureContext insContext = new InsureContext();
			insContext.setIdHp(payoepDto.getId_hp());
			InsureFacade insFacade = new InsureFacade(insContext);
			
			OepSettleRtnValDTO rtnVal = null;
			if(!ListUtil.isEmpty(payoepDto.getOldpropdata())){
				rtnVal = (OepSettleRtnValDTO)payoepDto.getOldpropdata().get(0);
			}
			HisPropertyRefHpDTO refHpDto = new HisPropertyRefHpDTO();
			refHpDto.setId_ref(newPropArDO.getId_proparoep());
			insFacade.savePayPropDataOep(rtnVal, refHpDto);
		}else{
			MiContext miContext = new MiContext();
			miContext.setIdHp(payoepDto.getId_hp());
			MiFacade miFacade = new MiFacade(miContext);
			
			OepSettleRtnValDTO rtnVal = null;
			if(!ListUtil.isEmpty(payoepDto.getOldpropdata())){
				rtnVal = (OepSettleRtnValDTO)payoepDto.getOldpropdata().get(0);
			}
			HisPropertyRefHpDTO refHpDto = new HisPropertyRefHpDTO();
			refHpDto.setId_ref(newPropArDO.getId_proparoep());
			miFacade.savePayPropDataOep(rtnVal, refHpDto);		
		}
	}
	
	/**
	 * 处理摆药窗口
	 * @param cgItmDos
	 */
	private void dealWin(BlCgItmOepDO[] cgItmDos) throws BizException{
		
		Set<String> presIdSet = new HashSet<String>();
		for (BlCgItmOepDO cgItmDO : cgItmDos) {
			
			if(FBoolean.TRUE.equals(cgItmDO.getFg_acc()) || FBoolean.TRUE.equals(cgItmDO.getFg_hpcg()))
				continue;
			
			if(FBoolean.TRUE.equals(cgItmDO.getFg_mm()) && !StringUtil.isEmpty(cgItmDO.getId_pres())){
				presIdSet.add(cgItmDO.getId_pres());
			}
		}
		
		if(presIdSet.size() > 0){
			IMpDgOutService mpDgoutService = ServiceFinder.find(IMpDgOutService.class);
			for (String presId : presIdSet) {
				mpDgoutService.insertPresWindowData(presId, IMpDgConst.ENTRY_AFTER_CHARGE);
			}
		}
	}
	
	/**
	 * 设置返回值  
	 * @param stDO
	 * @param incAggDos
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private BlPayOepRltDTO setReturnValue(BlStOepDO stDO, BlCgItmOepDO[] cgItmDos,
			BlincoepAggDO[] incAggDos, BlPayPatOepDO payHeadDO, 
			String prepayId) throws BizException {
		
		BlPayOepRltDTO rlt = new BlPayOepRltDTO();
		rlt.setId_pat(stDO.getId_pat());
		rlt.setId_st(stDO.getId_stoep());
		rlt.setId_hp(stDO.getId_hp());
		
		Set<String> entIdSet = new HashSet<String>();
		for (BlCgItmOepDO cgItmDO : cgItmDos) {
			if(StringUtil.isEmpty(cgItmDO.getId_ent()))
				continue;
			entIdSet.add(cgItmDO.getId_ent());
		}
		if(entIdSet.size() > 0){
			FArrayList fEntList = new FArrayList();
			fEntList.addAll(entIdSet);
			rlt.setId_ent(fEntList);
		}
		
		List<String> incIdList = new ArrayList<String>();
		for (BlincoepAggDO incAggDO : incAggDos) {
			incIdList.add(incAggDO.getParentDO().getId_incoep());
		}
		FArrayList fIncList = new FArrayList();
		fIncList.addAll(incIdList);
		rlt.setId_inc(fIncList);
		rlt.setId_paypatoep(payHeadDO.getId_paypatoep());
		rlt.setId_prepaypat(prepayId);
		
		return rlt;
	}
	/**
	 * 第三方支付  处理逻辑 修改付款方式 回写日志信息
	 * @param blcgoepAggDOArr
	 * @param blpaypatoepAggDOs
	 * @throws BizException 
	 */
	private void ThirdPaySettle(BlCgItmOepDO[] blcgItmOepDOs,BlpaypatoepAggDO blpaypatoepAggDOs,BlStOepDO  blstoepDO) throws BizException{
		// 12.如果收款类型为窗口，并且付款方式为支付宝或者微信，则回写日志信息
		if (IBlDictCodeConst.SD_PTTP_WINDOW.equals(blpaypatoepAggDOs.getParentDO().getSd_pttp())
				||IBlDictCodeConst.SD_PTTP_ROOM.equals(blpaypatoepAggDOs.getParentDO().getSd_pttp())
				) {
			BlPayItmPatOepDO[] blPayItmPatOepDOArr = blpaypatoepAggDOs.getBlPayItmPatOepDO();
			List<String> ordNoList = new ArrayList<String>();
			
			BlPayItmPatOepDO payItmPatOepDO = BlThirdPayBP.validate(blPayItmPatOepDOArr,BlThirdPayBP.isScene(blstoepDO));
			if (payItmPatOepDO != null) {
				// 如果支付方式为微信或支付宝 并且外部订单号不为空
				if (!StringUtils.isEmpty(payItmPatOepDO.getPaymodenode())) {
					ordNoList.add(payItmPatOepDO.getPaymodenode());
				}
			}
			if (!ListUtil.isEmpty(ordNoList)) {
				saveThirdLog(ordNoList, blstoepDO.getId_stoep());
			}
		}
	}
	/**
	 * 保存窗口支付(微信支付宝)日志
	 * @param ordNoList 外部订单号
	 * @param id_stoep 结算id
	 * @throws  
	 */
	private void saveThirdLog(List<String> ordNoList,String id_stoep) throws BizException{	
		StringBuilder sql= new StringBuilder();
		sql.append("update");
		sql.append(" bl_trd_trans_rcd");
		sql.append(" set id_st='"+id_stoep+"',");
		sql.append(" eu_status='1',");
		sql.append(" fg_rollback='N',");
		sql.append(" id_pay=(select itm.id_payitmpatoep");
		sql.append(" from bl_pay_itm_pat_oep itm "
				+ "  inner join bl_pay_pat_oep pay on itm.id_paypatoep=pay.id_paypatoep"
				+ "  inner join bl_st_oep st on itm.id_paypatoep=st.id_paypatoep"
				+ " where st.id_stoep='"+id_stoep+"' and bl_trd_trans_rcd.order_no=itm.paymodenode and bl_trd_trans_rcd.id_emp_oper=pay.id_emp_pay)");
		sql.append(" where ");
		sql.append(SqlUtils.getInSqlByIds("bl_trd_trans_rcd.order_no", ordNoList));
		new DAFacade().execUpdate(sql.toString());
	}
	@Override
	protected String getBusinessName() {
		return "门诊收费";
	}
}
