package iih.bl.pay.s.bp.prepay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.pp.incca.i.IBdInccaCodeConst;
import iih.bl.comm.IBlConst;
import iih.bl.comm.util.BlFlowContextUtil;
import iih.bl.inc.blinciss.d.BlIncIssDO;
import iih.bl.inc.i.IBlIncUtilService;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.blpaypat.i.IBlpaypatCudService;
import iih.bl.pay.dto.prepay.d.BlPrepaySTDTO;
import iih.bl.pay.dto.prepay.d.BlPrepaySetDTO;
import iih.bl.pay.prepaypatrcpt.d.BlPrepayPatRcptDO;
import iih.bl.pay.prepaypatrcpt.i.IPrepaypatrcptCudService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 预交金结转
 * 
 * @author 2018/07/19
 *
 */
public class BlPrepayStTransferBP extends BlPrepayBaseBP {

	private static FDateTime dateTime = null;

	public BlPrepayStTransferBP(BlPrepaySetDTO setDto) {
		super(setDto);
	}

	/**
	 * 预交金结转
	 * 
	 * @param dto
	 *            结转数据
	 * @return 预交金DO
	 * @throws BizException
	 */
	public BlPrePayPatDO[] exec(BlPrepaySTDTO[] dto) throws BizException {

		if (ArrayUtil.isEmpty(dto)) {
			return null;
		}
		// 当前时间
		dateTime = BlFlowContextUtil.getNowTime();
		
		this.analysisAccType(dto[0].getId_pat(),dto[0].getId_ent(),dto[0].getId_pecmpy());

		if(FBoolean.TRUE.equals(this.setDto.getFg_useinc())){
			super.judgeIncManage();
		}
		
		String[] codeReps = null;
		BlIncIssDO issDO = null;
		if(FBoolean.TRUE.equals(this.setDto.getFg_useinc())){
			// 获取票据包数据
			IBlIncUtilService incUtil = ServiceFinder.find(IBlIncUtilService.class);
			issDO = incUtil.getCurInvoiceDO(Context.get().getStuffId(), Context.get().getClientHost(),IBdInccaCodeConst.ID_INHOS_DEPOSIT);
			//获取当前可用票据号
			codeReps = incUtil.getCurInvoiceNoMany(Context.get().getStuffId(),Context.get().getClientHost(),IBdInccaCodeConst.ID_INHOS_DEPOSIT,dto.length);
			//进行跳号
			incUtil.nextInvoiceNoByNo(issDO, codeReps[codeReps.length-1]);
		}else{
			codeReps = super.generateAutoCodes(dto.length);
		}
		
		//给结转预交金数据绑定票据号
		Map<String, String> repMap=new HashMap<String, String>();
		for (int i=0;i<dto.length;i++ ) {
			repMap.put(dto[i].getId_prepay_new(), codeReps[i]);
		}

		List<String> entStr = new ArrayList<>();
		for (BlPrepaySTDTO preDto : dto) {
			entStr.add(preDto.getId_ent());
		}

		if (entStr.size() == 0) {
			throw new BizException("就诊id为空");
		}
		// 查询患者就诊信息
		IPativisitRService entRService = ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO[] entDoarr = entRService.findByIds(entStr.toArray(new String[0]), FBoolean.FALSE);

		if (ArrayUtil.isEmpty(entDoarr)) {
			throw new BizException("就诊信息为空");
		}
		Map<String, PatiVisitDO> entMap = new HashMap<String, PatiVisitDO>();
		for (PatiVisitDO patiVisitDO : entDoarr) {
			entMap.put(patiVisitDO.getId_ent(), patiVisitDO);
		}
		// 保存结转预交金数据
		BlPrePayPatDO[] payPatArr = assemblePreapyPatData(dto, entMap, repMap);

		// 生成票据信息
		saveRcptData(payPatArr, issDO, repMap);

		// 更新个人账户
		updateIpAcc(payPatArr);

		return payPatArr;
	}
	
	private void updateIpAcc(BlPrePayPatDO[] payPatArr) throws BizException{
		FDouble amt=FDouble.ZERO_DBL;
		for (BlPrePayPatDO blPrePayPatDO : payPatArr) {
			amt=amt.add(blPrePayPatDO.getAmt());
		}
		this.chargeAcc(amt);
	}

	/**
	 * 保存票据信息
	 * 
	 * @param payPatArr
	 * @return
	 * @throws BizException
	 * @date 2018年8月14日
	 * @author wq.li
	 */
	private BlPrepayPatRcptDO[] saveRcptData(BlPrePayPatDO[] payPatArr,BlIncIssDO issDO,Map<String, String> repMap) throws BizException {

		List<BlPrepayPatRcptDO> rcptDoList = new ArrayList<BlPrepayPatRcptDO>();
		for (BlPrePayPatDO payPatDO : payPatArr) {
			BlPrepayPatRcptDO rcptDo = new BlPrepayPatRcptDO();
			rcptDo.setId_paypat(payPatDO.getId_paypat());
			rcptDo.setId_grp(Context.get().getGroupId());
			rcptDo.setId_org(Context.get().getOrgId());
			rcptDo.setId_pat(payPatDO.getId_pat());
			rcptDo.setId_ent(payPatDO.getId_ent());
			rcptDo.setId_entp(payPatDO.getId_enttp());
			rcptDo.setCode_entp(payPatDO.getCode_enttp());
			if(issDO != null){
				rcptDo.setCode_incpkg(issDO.getCode_incpkg());
			}
			rcptDo.setId_incca(IBdInccaCodeConst.ID_INHOS_DEPOSIT);
			rcptDo.setCode_rep(repMap.get(payPatDO.getId_paypat()));
			rcptDo.setDt_receipt(dateTime);
			rcptDo.setId_emp_grp(Context.get().getGroupId());
			rcptDo.setId_emp_org(Context.get().getOrgId());
			//给票据开立人员赋值  by lim 2018-08-21
			rcptDo.setId_emp_rcpt(Context.get().getStuffId());
			rcptDo.setPrint_times(1);
			rcptDo.setFg_rep_return(FBoolean.FALSE);
			rcptDo.setId_rep_lost(null);
			rcptDo.setSd_rep_lost(null);
			rcptDo.setDt_return(null);
			rcptDo.setId_emp_return(null);
			rcptDo.setFg_cc_rcpt(FBoolean.FALSE);
			rcptDo.setId_cc(null);
			rcptDo.setNote(null);
			rcptDo.setId_res_reprint(null);
			rcptDo.setSd_res_reprint(null);
			rcptDo.setStatus(DOStatus.NEW);
			rcptDoList.add(rcptDo);
		}

		IPrepaypatrcptCudService rcptCudService = ServiceFinder.find(IPrepaypatrcptCudService.class);
		BlPrepayPatRcptDO[] rcptDOArr = rcptCudService.save(rcptDoList.toArray(new BlPrepayPatRcptDO[0]));

		return rcptDOArr;
	}

	/**
	 * 保存预交金信息
	 * 
	 * @param dto
	 * @param entMap
	 * @return
	 * @throws BizException
	 * @date 2018年8月14日
	 * @author wq.li
	 */
	private BlPrePayPatDO[] assemblePreapyPatData(BlPrepaySTDTO[] dto, Map<String, PatiVisitDO> entMap,Map<String, String> repMap)
			throws BizException {

		// 生成结转预交金数据
		List<BlPrePayPatDO> prePayDtoArr = new ArrayList<BlPrePayPatDO>();
		for (BlPrepaySTDTO prepaySTDTO : dto) {
			PatiVisitDO entDo = entMap.get(prepaySTDTO.getId_ent());
			BlPrePayPatDO preDo = new BlPrePayPatDO();
			preDo.setId_paypat(prepaySTDTO.getId_prepay_new());
			preDo.setId_grp(Context.get().getGroupId());
			preDo.setId_org(Context.get().getOrgId());
			preDo.setId_paytp(IBlDictCodeConst.ID_PAYTP_IPPREPAYSTTRANSFER);
			preDo.setSd_paytp(IBlDictCodeConst.SD_PAYTP_IPPREPAYSTTRANSFER);
			preDo.setId_pat(entDo.getId_pat());
			preDo.setId_enttp(entDo.getId_entp());
			preDo.setCode_enttp(entDo.getCode_entp());
			preDo.setId_ent(entDo.getId_ent());
//			preDo.setId_pecmpy(prepaySTDTO.getId_pecmpy());
//			preDo.setId_cust(null);
			preDo.setEu_direct(IBlConst.BL_CHARGES);
			preDo.setAmt(prepaySTDTO.getAmt());
			preDo.setSd_pttp(prepaySTDTO.getSd_pttp());
			preDo.setId_pm(prepaySTDTO.getId_pm());
			preDo.setSd_pm(prepaySTDTO.getSd_pm());
			preDo.setId_bank(null);
			preDo.setBankno(null);
			preDo.setPaymodenode(null);
			preDo.setDt_pay(dateTime);
			preDo.setId_org_pay(Context.get().getOrgId());
			preDo.setId_dep_pay(Context.get().getDeptId());
			if(StringUtils.isNotBlank(prepaySTDTO.getId_emp_pay())){
				preDo.setId_emp_pay(prepaySTDTO.getId_emp_pay());
			}else{
				preDo.setId_emp_pay(Context.get().getStuffId());
			}
			
			preDo.setFg_cc(FBoolean.FALSE);
			preDo.setId_cc(null);
			preDo.setId_incca(IBdInccaCodeConst.ID_INHOS_DEPOSIT);
			preDo.setCode_incca(IBdInccaCodeConst.CODE_INHOS_DEPOSIT);
			preDo.setCode_rep(repMap.get(prepaySTDTO.getId_prepay_new()));
			preDo.setFg_rep_return(FBoolean.FALSE);
			preDo.setId_rep_lost(null);
			preDo.setSd_rep_lost(null);
			preDo.setDt_return(null);
			preDo.setId_emp_return(null);
			preDo.setId_par(null);
			preDo.setId_st_mid(prepaySTDTO.getId_st());
			preDo.setFg_canc(FBoolean.FALSE);
			preDo.setId_emp_canc(null);
			preDo.setDt_canc(null);
			preDo.setNote("找零结转");
			preDo.setStatus(DOStatus.NEW);
			//zx 2019年12月12日 增加手工退账标志 0178968
			preDo.setFg_refund_manual(FBoolean.FALSE);
			prePayDtoArr.add(preDo);
		}
		IBlpaypatCudService paypatCudSerivce = ServiceFinder.find(IBlpaypatCudService.class);
		BlPrePayPatDO[] payPatArr = paypatCudSerivce.save(prePayDtoArr.toArray(new BlPrePayPatDO[0]));

		return payPatArr;
	}
}
