package iih.bl.pay.blpaypat.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.pp.incca.i.IBdInccaCodeConst;
import iih.bl.inc.i.IBlIncUtilService;
import iih.bl.inc.service.i.IBLInvoiceService;
import iih.bl.pay.blpaypat.bp.ip.SavePrepayInfoIpBp;
//import iih.bl.inc.blinciss.Service.i.IBLInvoiceService;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.blpaypat.d.BookRtnDirectEnum;
import iih.bl.pay.blpaypat.i.IBlpaypatRService;
import iih.bl.pay.blprepay.ep.BlPreayPMamtOepDOEp;
import iih.bl.pay.blprepay.ep.BlPrepayPatDOEp;
import iih.bl.pay.blprepay.ep.UpdateAccInfoEp;
import iih.bl.pay.bp.qry.GetInvoiceInfoBP;
import iih.bl.pay.dto.d.BlPayPatItemDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class BlpaypatCrudBp {
	
//	/*
//	 * 获取票据编号、账户余额等信息
//	 * */
//	public BlPayPatItemDTO getBlPayPatItemDTOByQur(String queryStr,String id_user,String payType)
//			throws BizException{
//		BlPayPatItemDTO blPayPatItemDTO = new BlPayPatItemDTO();
//		//获取票据编码
//		IBLInvoiceService incService = (IBLInvoiceService)ServiceFinder.find(IBLInvoiceService.class);
//		String code_rep = "";
//		//判断业务类型（门诊/住院）
//		if(IBdFcDictCodeConst.ID_CODE_ENTP_OP.equals(payType)){
//			IAccountMDORService accRService = (IAccountMDORService)ServiceFinder.find(IAccountMDORService.class);
//			//PiPatAccDO[] accountArr = accRService.find(queryStr.toString(),"id_patacc desc",FBoolean.FALSE);
////			if(accountArr == null || accountArr.length == 0){
////				throw new BizException("患者账户不存在");
////			}
////			blPayPatItemDTO.setPrepay(accountArr[0].getPrepay());
////			blPayPatItemDTO.setAmt_cred(accountArr[0].getAcc_lock());
////			blPayPatItemDTO.setAmt_balance(accountArr[0].getPrepay().add(accountArr[0].getCred()).sub(accountArr[0].getAcc_lock()));
////			code_rep = incService.GetInvoiceNo(id_user, IBdInccaCodeConst.CODE_OUTPATIENT_DEPOSIT);
//			
//			PiPatAccDO[] accountArr = accRService.find(" a0.id_pat = '" + queryStr.toString() + "'","id_patacc desc",FBoolean.FALSE);
//			if(accountArr == null || accountArr.length == 0){
//				throw new BizException("患者账户不存在");
//			}
//			blPayPatItemDTO.setPrepay(accountArr[0].getPrepay());
//			blPayPatItemDTO.setAmt_cred(accountArr[0].getAcc_lock());
//			//blPayPatItemDTO.setAmt_balance(accountArr[0].getPrepay().add(accountArr[0].getCred()).sub(accountArr[0].getAcc_lock()));
//			blPayPatItemDTO.setAmt_balance(accountArr[0].getPrepay().sub(accountArr[0].getAcc_lock()));
//			code_rep = incService.GetInvoiceNo(id_user, IBdInccaCodeConst.CODE_OUTPATIENT_DEPOSIT);
//		}else if(IBdFcDictCodeConst.ID_CODE_ENTP_IP.equals(payType)){
//			//获取就诊编码
////			IPativisitRService entService = ServiceFinder.find(IPativisitRService.class);
////			PatiVisitDO[] patiVisitDOArr =  entService.find(queryStr.toString(), null, FBoolean.FALSE);
////			if(patiVisitDOArr == null || patiVisitDOArr.length == 0){
////				throw new BizException("就诊不存在！");
////			}
////			blPayPatItemDTO.setCode_ent(patiVisitDOArr[0].getCode());
//			
////			IEnaccountMDORService accRService = ServiceFinder.find(IEnaccountMDORService.class);
////			EnAccountDO[] enAccountArr = accRService.find(queryStr.toString(),"id_entacc desc",FBoolean.FALSE);
////			if(enAccountArr == null || enAccountArr.length == 0){
////				throw new BizException("就诊账户不存在！");
////			}
////			blPayPatItemDTO.setPrepay(enAccountArr[0].getAmt_prepay());
////			blPayPatItemDTO.setAmt_cred(enAccountArr[0].getAmt_uncg());
////			blPayPatItemDTO.setAmt_balance(enAccountArr[0].getAmt_prepay().add(enAccountArr[0].getAmt_cred()).sub(enAccountArr[0].getAmt_uncg()));
////			code_rep = incService.GetInvoiceNo(id_user, IBdInccaCodeConst.CODE_INHOS_DEPOSIT);
//
//			IEnOutQryService enService = ServiceFinder.find(IEnOutQryService.class);
//			PatiVisitDO patiVisitDO = enService.getEnInfo(queryStr.toString());
//			if(patiVisitDO == null){
//				throw new BizException("就诊不存在！");
//			}
//			blPayPatItemDTO.setCode_ent(patiVisitDO.getCode());
//			
//			EnAccountDO enAccountDO = enService.getEnAcc(queryStr.toString());
//			if(enAccountDO == null){
//				throw new BizException("就诊账户不存在！");
//			}
//			blPayPatItemDTO.setPrepay(enAccountDO.getAmt_prepay());
//			blPayPatItemDTO.setAmt_cred(enAccountDO.getAmt_uncg());
//			//blPayPatItemDTO.setAmt_balance(enAccountDO.getAmt_prepay().add(enAccountDO.getAmt_cred()).sub(enAccountDO.getAmt_uncg()));
//			blPayPatItemDTO.setAmt_balance(enAccountDO.getAmt_prepay().sub(enAccountDO.getAmt_uncg()));
//			code_rep = incService.GetInvoiceNo(id_user, IBdInccaCodeConst.CODE_INHOS_DEPOSIT);
//		}
//		if(code_rep == null || code_rep.isEmpty()){
//			throw new BizException("请先领取票据号！");
//		}
//		blPayPatItemDTO.setCode_rep(code_rep);
//		//默认选中现金
//		IUdidocRService udService = (IUdidocRService)ServiceFinder.find(IUdidocRService.class);
//		UdidocDO udidocDO = udService.findById(IBdPripmCodeConst.ID_PRI_PM_CASH);
//		blPayPatItemDTO.setId_paymod(IBdPripmCodeConst.ID_PRI_PM_CASH);
//		blPayPatItemDTO.setPaymod_code(IBdPripmCodeConst.CODE_PRI_PM_CASH);
//		blPayPatItemDTO.setPaymod_name(udidocDO.getName());
//		return blPayPatItemDTO;
//	}
	
	/**
	 * 目前供门诊收费节点，退费节点，住院收付款节点使用：
	 * 收、退费方式为预交金，即在预交金中增加相关一条预交金操作记录，并修改预交金账户金额
	 * @param payment_prepay_amt 支付的预交金金额
	 * @param id_pat 患者ID
	 * @param operatorInfoDTO 操作员信息
	 * @param eu_direct 预交金收付款方向
	 * @param entType 就诊类型ID
	 * @param sd_paytp 收付款方式SD
	 * @param id_paytp 收付款方式iD
	 * @param note 备注
	 * @return
	 * @throws BizException
	 */
//	public BlPrePayPatDO[] saveBlPayPatInfoRefund(FDouble payment_prepay_amt,String id_pat,OperatorInfoDTO operatorInfoDTO,Integer eu_direct,String entType,String sd_paytp,String id_paytp,String note) 
//			throws BizException{
//		BlPrePayPatDO blPayPatDO=new BlPrePayPatDO();
//		
////		sd_paytp	预交金收付款类型	21 患者预交金消费
////		blPayPatDO.setSd_paytp(IBlDictCodeConst.SD_PAYTP_CODE_HZYJ);
////		blPayPatDO.setId_paytp(IBlDictCodeConst.SD_PAYTP_ID_HZYJ);
//		blPayPatDO.setSd_paytp(sd_paytp);
//		blPayPatDO.setId_paytp(id_paytp);
//		if(eu_direct==1 && IBlDictCodeConst.SD_PAYTP_CODE_HZYJ.equals(sd_paytp)) //剩余预交金结存
//		{
//			blPayPatDO.setSd_pm(IBdPripmCodeConst.CODE_PRI_PM_CASH);
//			blPayPatDO.setId_pm(IBdPripmCodeConst.ID_PRI_PM_CASH);
//		}
//		else
//		{
//			blPayPatDO.setSd_pm(IBdPripmCodeConst.CODE_PRI_PM_PAY);
//			blPayPatDO.setId_pm(IBdPripmCodeConst.ID_PRI_PM_PAY);
//		}
//		blPayPatDO.setId_pat(id_pat);
//		blPayPatDO.setId_org(operatorInfoDTO.getId_org());
//		blPayPatDO.setId_grp(operatorInfoDTO.getId_grp());
//		blPayPatDO.setId_org_pay(operatorInfoDTO.getId_org_emp());
//		blPayPatDO.setId_dep_pay(operatorInfoDTO.getId_dep());
//		blPayPatDO.setId_emp_pay(operatorInfoDTO.getId_emp());
//		blPayPatDO.setAmt(payment_prepay_amt);//金额
//		blPayPatDO.setId_bank(null);
//		blPayPatDO.setBankno(null);
//		blPayPatDO.setPaymodenode(null);
//		blPayPatDO.setFg_canc(FBoolean.FALSE);
//		blPayPatDO.setId_emp_canc(null);
//		blPayPatDO.setDt_canc(null);
//		blPayPatDO.setFg_cc(FBoolean.FALSE);
//		blPayPatDO.setId_cc(null);
//		blPayPatDO.setId_incca(null);
//		blPayPatDO.setCode_rep(null);
//		blPayPatDO.setId_par(null);
//		blPayPatDO.setFg_rep_return(FBoolean.FALSE);
//		blPayPatDO.setSd_rep_lost(null);
//		blPayPatDO.setId_rep_lost(null);
//		blPayPatDO.setEu_direct(eu_direct);//收退款方向,与预交金账户增减额方向一致
//		blPayPatDO.setDt_return(null);
//		blPayPatDO.setId_emp_return(null);
//		blPayPatDO.setId_st_mid(null);
//		blPayPatDO.setNote(note);
//		TimeService timeService = new TimeServiceImpl();//获取当前服务器时间
//		FDateTime dateTime = timeService.getUFDateTime();
//		blPayPatDO.setDt_pay(dateTime);
////		blPayPatDO.setCode_incca(this.getRepCodeByCCTP(payType));//票据类型编码
////		blPayPatDO.setId_incca(this.getRepIdByCCTP(payType));//票据类型ID
//		blPayPatDO.setId_ent(null);//就诊类型id,门急诊结算不考虑
//		blPayPatDO.setId_enttp(entType);//就诊类型id,门急诊结算不考虑
//		if(IBdFcDictCodeConst.ID_CODE_ENTP_OP.equals(entType)){
//			blPayPatDO.setCode_enttp(IBdFcDictCodeConst.SD_CODE_ENTP_OP);
//		}else if(IBdFcDictCodeConst.ID_CODE_ENTP_IP.equals(entType)){
//			blPayPatDO.setCode_enttp(IBdFcDictCodeConst.SD_CODE_ENTP_IP);
//		}
//		blPayPatDO.setStatus(DOStatus.NEW);//数据状态为新增
//		
//		IBlpaypatCudService payService = (IBlpaypatCudService)ServiceFinder.find(IBlpaypatCudService.class);
//		BlPrePayPatDO[] blPrePayPatDO = payService.save(new BlPrePayPatDO[]{blPayPatDO});
//		if(blPrePayPatDO == null || blPrePayPatDO.length == 0){
//			throw new BizException("保存结算——预交金数据失败！");
//		}
//		
////		//修改患者预交金收退款总额，在DoOepFgAmtAcc中完成
////		if(IBdFcDictCodeConst.ID_CODE_ENTP_OP.equals(entType)){
////			this.updateBlPayMamtOepInfo(blPayPatDO.getId_pat(), eu_direct, blPayPatDO.getAmt(), blPayPatDO.getId_pm(), blPayPatDO.getSd_pm());
////		}
//		
//		//账户信息修改	
//		UpdateAccInfoEp newep=new UpdateAccInfoEp();
//		newep.updatePiPatAccInfo(payment_prepay_amt.multiply(eu_direct).doubleValue(), blPayPatDO, entType);
//		
//		return blPrePayPatDO;
//	}
	
	/**
	 * 门诊零钱转预交金
	 * */
//	public BlPrePayPatDO[] transferBalanceToPatAcc(BlPayItmPatOepDO blPayPatItmDo,String id_pat,OperatorInfoDTO operatorInfoDTO,String entType,String note)
//	throws BizException{
//		//整合到一个方法里
//		//return saveBlPayPatInfoRefund(blPayPatItmDo.getAmt(),id_pat,operatorInfoDTO,1,entType,IBlDictCodeConst.SD_PAYTP_CODE_HZYJ,IBlDictCodeConst.SD_PAYTP_ID_HZYJ,note);
//		PrepayPatOpBp  prepaybp =new PrepayPatOpBp();
//		BlPrePayPatDO[] doArr=	prepaybp.saveBlPayPatInfoRefund(blPayPatItmDo.getAmt(),id_pat,operatorInfoDTO,1,entType,IBlDictCodeConst.SD_PAYTP_CODE_HZYJ,IBlDictCodeConst.SD_PAYTP_ID_HZYJ,note);
//		return doArr;
//	}
		
	
	/**
	 *  收预交金数据的保存，门诊/住院公用，根据支付类型来区分是门诊/住院
	 * @param blPayPatItemDTO
	 * @param blPayPatDO
	 * @param payType
	 * @return
	 * @throws BizException
	 */
	public BlPrePayPatDO[] saveBlPayPatInfo(BlPayPatItemDTO blPayPatItemDTO,BlPrePayPatDO blPayPatDO, String payType) 
			throws BizException{
		//主要业务： 1.校验票据号   2.保存新增的预交金数据   3.更新账户   4，更新票据号
		
		//如果支付类型是住院类型的，则用住院的bp类来实现
		if(IBdFcDictCodeConst.ID_CODE_ENTP_IP.equals(payType)){
			SavePrepayInfoIpBp ppbp=new SavePrepayInfoIpBp();
			return  ppbp.execSaveIpBlPayPatInfo(blPayPatItemDTO, blPayPatDO, payType);
		}
		
		//如果支付类型是门诊类型的，则走下边的逻辑，下边的逻辑为保存门诊预交金数据
		// 1.校验票据号 ：验证票据编号是否可用
    	GetInvoiceInfoBP  incbp=new GetInvoiceInfoBP();
		String code_rep=incbp.getInvoiceInfo(blPayPatDO.getId_emp_pay(), payType);
		if(blPayPatItemDTO.getCode_rep() != null && !(blPayPatItemDTO.getCode_rep()).equals(code_rep)){
			throw new BizException("当前票据已被他人修改，请刷新界面，重做业务！");
		}
		
		// 2.保存新增的预交金数据  录入数据保存
		BlPrepayPatDOEp  prepayEp=new BlPrepayPatDOEp();
		BlPrePayPatDO[] blPrePayPatDOArr =prepayEp.insertBlPayPatInfo(blPayPatItemDTO, blPayPatDO, payType);
		//3.更新患者账户、患者预交金收退款总额
		//，如果是门诊类型收退预交金，修改患者预交金收退款总额
		if(IBdFcDictCodeConst.ID_CODE_ENTP_OP.equals(payType)){
			//this.updateBlPayMamtOepInfo(blPrePayPatDOArr[0].getId_pat(), BookRtnDirectEnum.CHARGE, blPrePayPatDOArr[0].getAmt(), blPrePayPatDOArr[0].getId_pm(), blPrePayPatDOArr[0].getSd_pm());
			BlPreayPMamtOepDOEp  ep  = new  BlPreayPMamtOepDOEp();
			ep.updateBlPayMamtOepInfo(blPrePayPatDOArr[0].getId_pat(), BookRtnDirectEnum.CHARGE, blPrePayPatDOArr[0].getAmt(), blPrePayPatDOArr[0].getId_pm(), blPrePayPatDOArr[0].getSd_pm());
		}
		
		//账户信息修改：当门诊时修改患者账户信息，当为住院时修改就诊账户信息
		UpdateAccInfoEp newep=new UpdateAccInfoEp();
		newep.updatePiPatAccInfo(blPayPatItemDTO.getAmt().doubleValue(), blPayPatDO, payType);
		
		//4，更新票据号   ：票据编码修改
		/*BlPrepayPatDOEp newBl=new BlPrepayPatDOEp ();
		incService.NextInvoiceNoUpdateCurNo(blPayPatDO.getId_emp_pay(), newBl.getRepCodeByCCTP(payType));*/
		
		
		IBlIncUtilService incService = ServiceFinder.find(IBlIncUtilService.class);
		incService.nextInvoiceNo(Context.get().getStuffId(), Context.get().getClientHost(), IBdInccaCodeConst.ID_OUTPATIENT_DEPOSIT);
		
		return blPrePayPatDOArr;
	}

	
	/**
	 * 修改患者预交金收退款总额表
	 * @param id_pat 患者ID
	 * @param direct 收退款方向
	 * @param amt 收退款金额
	 * @param id_pm 收付款方式ID
	 * @param sd_pm 收付款方式编码
	 * @throws BizException 
	 * */
//	public void updateBlPayMamtOepInfo(String id_pat,Integer direct,FDouble amt,String id_pm,String sd_pm) throws BizException{
//		IBlprepaypatpmamtoepRService rservice = ServiceFinder.find(IBlprepaypatpmamtoepRService.class);
//		IBlprepaypatpmamtoepCudService cservice = ServiceFinder.find(IBlprepaypatpmamtoepCudService.class);
//		StringBuffer sql = new StringBuffer();
//		sql.append(" a0.id_pat = '").append(id_pat).append("' and a0.id_pm = '").append(id_pm).append("' ");
//		BlPrepayPatPmamtOepDO[] payArr = rservice.find(sql.toString(), null, FBoolean.FALSE);
//		BlPrepayPatPmamtOepDO blPayOepDO = null;
//		if(payArr == null || payArr.length == 0){
//			blPayOepDO = new BlPrepayPatPmamtOepDO();
//			blPayOepDO.setId_org(Context.get().getOrgId());
//			blPayOepDO.setId_grp(Context.get().getGroupId());
//			blPayOepDO.setId_pat(id_pat);
//			blPayOepDO.setId_pm(id_pm);
//			blPayOepDO.setSd_pm(sd_pm);
//			if(BookRtnDirectEnum.CHARGE == direct){
//				blPayOepDO.setAmt_in(amt);
//				blPayOepDO.setAmt_out(new FDouble(0));
//			}else{
//				blPayOepDO.setAmt_in(new FDouble(0));
//				blPayOepDO.setAmt_out(amt);
//			}
//			blPayOepDO.setStatus(DOStatus.NEW);
//		}else{
//			blPayOepDO = payArr[0];
//			if(BookRtnDirectEnum.CHARGE == direct){
//				blPayOepDO.setAmt_in(blPayOepDO.getAmt_in().add(amt));
//			}else{
//				blPayOepDO.setAmt_out(blPayOepDO.getAmt_out().add(amt));
//			}
//			blPayOepDO.setStatus(DOStatus.UPDATED);
//		}
//		cservice.save(new BlPrepayPatPmamtOepDO[]{blPayOepDO});
//	}
	
	/*
	 * 作废预交金数据
	 * */
//	public void abolishBlPayPatInfo(BlPrePayPatDO blPayPatDO, BlPrePayPatDO abolishDO,String payType) 
//			throws BizException{
//		//作废
//		this.updateBlPayPatInfo(blPayPatDO, abolishDO, payType);
//		//修改患者预交金收退款总额
//		if(IBdFcDictCodeConst.ID_CODE_ENTP_OP.equals(payType)){
//			//this.updateBlPayMamtOepInfo(blPayPatDO.getId_pat(), BookRtnDirectEnum.CHARGE, blPayPatDO.getAmt(), blPayPatDO.getId_pm(), blPayPatDO.getSd_pm());
//			BlPreayPMamtOepDOEp  ep  = new  BlPreayPMamtOepDOEp();
//			ep.updateBlPayMamtOepInfo(blPayPatDO.getId_pat(), BookRtnDirectEnum.CHARGE, blPayPatDO.getAmt(), blPayPatDO.getId_pm(), blPayPatDO.getSd_pm()); //此处写反了，作废时更新方法内部的逻辑看 这里传入的参数应是退费即-1
//		}
//		//修改账户余额
//		//this.updatePiPatAccInfo(-(blPayPatDO.getAmt().doubleValue()), blPayPatDO, payType);
//		UpdateAccInfoEp newep=new UpdateAccInfoEp();
//		newep.updatePiPatAccInfo(-(blPayPatDO.getAmt().doubleValue()), blPayPatDO, payType);
//	}
	
	/*
	 * 通过业务类型取得票据分类编号
	 * */
//	public String getRepCodeByCCTP(String SD_CCTP_ID){
//		if(IBdFcDictCodeConst.ID_CODE_ENTP_OP.equals(SD_CCTP_ID)){
//			return IBdInccaCodeConst.CODE_OUTPATIENT_DEPOSIT;
//		}else if(IBdFcDictCodeConst.ID_CODE_ENTP_IP.equals(SD_CCTP_ID)){
//			return IBdInccaCodeConst.CODE_INHOS_DEPOSIT;
//		}
//		return null;
//	}
//
//	/*
//	 * 通过业务类型取得票据分类ID
//	 * */
//	public String getRepIdByCCTP(String SD_CCTP_ID){
//		if(IBdFcDictCodeConst.ID_CODE_ENTP_OP.equals(SD_CCTP_ID)){
//			return IBdInccaCodeConst.ID_OUTPATIENT_DEPOSIT;
//		}else if(IBdFcDictCodeConst.ID_CODE_ENTP_IP.equals(SD_CCTP_ID)){
//			return IBdInccaCodeConst.ID_INHOS_DEPOSIT;
//		}
//		return null;
//	}
	
	/*
	 * 保存预交金数据
	 * */
//	public BlPrePayPatDO[] insertBlPayPatInfo(BlPayPatItemDTO blPayPatItemDTO,BlPrePayPatDO blPayPatDO, String payType)
//			throws BizException{
//		blPayPatDO.setCode_rep(blPayPatItemDTO.getCode_rep());//票据编号
//		blPayPatDO.setAmt(blPayPatItemDTO.getAmt());//录入金额
//		String id_paymod = blPayPatItemDTO.getId_paymod();
//		blPayPatDO.setId_pm(id_paymod);//收款方式
//		switch(id_paymod){
//			case IBdPripmCodeConst.ID_PRI_PM_CASH:
//				blPayPatDO.setSd_pm(IBdPripmCodeConst.CODE_PRI_PM_CASH);
//				break;
//			case IBdPripmCodeConst.ID_PRI_PM_CREDIT:
//				blPayPatDO.setId_bank(blPayPatItemDTO.getId_bank());
//				blPayPatDO.setBankno(blPayPatItemDTO.getBankno());
//				blPayPatDO.setPaymodenode(blPayPatItemDTO.getPaymodeno());
//				blPayPatDO.setSd_pm(IBdPripmCodeConst.CODE_PRI_PM_CREDIT);
//				break;
//			case IBdPripmCodeConst.ID_PRI_PM_CHECK:
//				blPayPatDO.setId_bank(blPayPatItemDTO.getId_bank());
//				blPayPatDO.setBankno(blPayPatItemDTO.getBankno());
//				blPayPatDO.setPaymodenode(blPayPatItemDTO.getPaymodeno());
//				blPayPatDO.setSd_pm(IBdPripmCodeConst.CODE_PRI_PM_CHECK);
//				break;
//			case IBdPripmCodeConst.ID_PRI_PM_DEAFT:
//				blPayPatDO.setId_bank(blPayPatItemDTO.getId_bank());
//				blPayPatDO.setBankno(blPayPatItemDTO.getBankno());
//				blPayPatDO.setPaymodenode(blPayPatItemDTO.getPaymodeno());
//				blPayPatDO.setSd_pm(IBdPripmCodeConst.CODE_PRI_PM_DEAFT);
//				break;
//			default:
//				break;
//		}
//		blPayPatDO.setDt_pay(new FDateTime());
//		//blPayPatDO.setFg_st(FBoolean.FALSE);//结算标志
//		blPayPatDO.setCode_incca(this.getRepCodeByCCTP(payType));//票据类型编码
//		blPayPatDO.setId_incca(this.getRepIdByCCTP(payType));//票据类型ID
//		blPayPatDO.setEu_direct(BookRtnDirectEnum.CHARGE);//收退款方向
//		blPayPatDO.setFg_canc(FBoolean.FALSE);
//		blPayPatDO.setId_enttp(payType);//结账类型id
//		if(IBdFcDictCodeConst.ID_CODE_ENTP_OP.equals(payType)){
//			blPayPatDO.setCode_enttp(IBdFcDictCodeConst.SD_CODE_ENTP_OP);
//		}else if(IBdFcDictCodeConst.ID_CODE_ENTP_IP.equals(payType)){
//			blPayPatDO.setCode_enttp(IBdFcDictCodeConst.SD_CODE_ENTP_IP);
//		}
//		blPayPatDO.setStatus(DOStatus.NEW);//数据状态为新增
//		
//		IBlpaypatCudService payService = (IBlpaypatCudService)ServiceFinder.find(IBlpaypatCudService.class);
//		BlPrePayPatDO[] blPrePayPatDO = payService.save(new BlPrePayPatDO[]{blPayPatDO});
//		if(blPrePayPatDO == null || blPrePayPatDO.length == 0){
//			throw new BizException("保存新增预交金数据失败！");
//		}
//		return blPrePayPatDO;
//	}
	
//	/*
//	 * 修改用户账户余额
//	 * */
//	public void updatePiPatAccInfo(double amt,BlPrePayPatDO blPayPatDO, String payType) 
//			throws BizException{
//		
//		if(IBdFcDictCodeConst.ID_CODE_ENTP_OP.equals(payType))
//		{
//			//pi_pat_acc.prepay add amt
//			IPatAccServiceExt accDService = ServiceFinder.find(IPatAccServiceExt.class);
//			accDService.updatePatPrepay(blPayPatDO.getId_pat(), new FDouble(amt));
//		}else if(IBdFcDictCodeConst.ID_CODE_ENTP_IP.equals(payType)){
//			IEnOutCmdService accDService = ServiceFinder.find(IEnOutCmdService.class);
//			accDService.recharge(blPayPatDO.getId_ent(), new FDouble(amt));
//		}
//	}

//	/*
//	 * 修改预交金元数据，添加作废数据
//	 * */
//	public void updateBlPayPatInfo(BlPrePayPatDO blPayPatDO, BlPrePayPatDO abolishDO,String payType) 
//			throws BizException{
//		IBlpaypatCudService payService = (IBlpaypatCudService)ServiceFinder.find(IBlpaypatCudService.class);
//		
//		//添加作废数据，修改元数据
//		blPayPatDO.setNote("作废");
//		blPayPatDO.setFg_canc(FBoolean.TRUE);
//		blPayPatDO.setDt_canc(new FDateTime());
//		blPayPatDO.setStatus(DOStatus.UPDATED);
//		
//		//abolishDO.setCode_rep(blPayPatDO.getCode_rep());
//		abolishDO.setAmt(blPayPatDO.getAmt());
//		abolishDO.setId_par(blPayPatDO.getId_paypat());
//		abolishDO.setId_ent(blPayPatDO.getId_ent());
//		abolishDO.setNote("作废"+blPayPatDO.getCode_rep());
//		abolishDO.setFg_rep_return(FBoolean.TRUE);
//		abolishDO.setDt_pay(new FDateTime());
//		abolishDO.setEu_direct(BookRtnDirectEnum.RETURNS);
//		abolishDO.setId_pat(blPayPatDO.getId_pat());
//		abolishDO.setId_enttp(blPayPatDO.getId_enttp());
//		abolishDO.setCode_enttp(blPayPatDO.getCode_enttp());
//		abolishDO.setSd_pm(blPayPatDO.getSd_pm());
//		abolishDO.setId_pm(blPayPatDO.getId_pm());
//		abolishDO.setId_bank(blPayPatDO.getId_bank());
//		abolishDO.setBankno(blPayPatDO.getBankno());
//		abolishDO.setPaymodenode(blPayPatDO.getPaymodenode());
//		abolishDO.setId_enttp(payType);
//		abolishDO.setId_paytp(blPayPatDO.getId_paytp());
//		abolishDO.setSd_paytp(blPayPatDO.getSd_paytp());
//		abolishDO.setSd_pttp(blPayPatDO.getSd_pttp());
//		abolishDO.setStatus(DOStatus.NEW);
//		payService.save(new BlPrePayPatDO[]{blPayPatDO,abolishDO});	
//	} 

//	/* *
//	 * 预交金退款
//	 * */
//	public FBoolean setBlPrePayRefund(BlPrePayPatDO blpreppDO) throws BizException{
//		//添加红冲数据
//		IBlpaypatCudService payService = (IBlpaypatCudService)ServiceFinder.find(IBlpaypatCudService.class);
//		blpreppDO.setNote("退款");
//		TimeService timeService = new TimeServiceImpl();//获取当前服务器时间
//		FDateTime dateTime = timeService.getUFDateTime();
//		blpreppDO.setDt_pay(dateTime);
//		blpreppDO.setEu_direct(BookRtnDirectEnum.RETURNS);
//		String id_paymod = blpreppDO.getId_pm();
//		switch(id_paymod){
//			case IBdPripmCodeConst.ID_PRI_PM_CASH:
//				blpreppDO.setSd_pm(IBdPripmCodeConst.CODE_PRI_PM_CASH);
//				break;
//			case IBdPripmCodeConst.CODE_PRI_PM_CREDIT:
//				blpreppDO.setSd_pm(IBdPripmCodeConst.CODE_PRI_PM_CREDIT);
//				break;
//			case IBdPripmCodeConst.ID_PRI_PM_CHECK:
//				blpreppDO.setSd_pm(IBdPripmCodeConst.CODE_PRI_PM_CHECK);
//				break;
//			case IBdPripmCodeConst.ID_PRI_PM_DEAFT:
//				blpreppDO.setSd_pm(IBdPripmCodeConst.CODE_PRI_PM_DEAFT);
//				break;
//			default:
//				blpreppDO.setSd_pm(IBdPripmCodeConst.CODE_PRI_PM_PAY);
//				break;
//		}
//		blpreppDO.setId_paytp(IBlDictCodeConst.SD_PAYTP_ID_HZYJ);
//		blpreppDO.setSd_paytp(IBlDictCodeConst.SD_PAYTP_CODE_HZYJ);
//		blpreppDO.setStatus(DOStatus.NEW);
//		payService.save(new BlPrePayPatDO[]{blpreppDO});
//		//修改就诊账户信息
//		//this.updatePiPatAccInfo(-(blpreppDO.getAmt().doubleValue()), blpreppDO, IBdFcDictCodeConst.ID_CODE_ENTP_OP);
//		UpdateAccInfoEp newep=new UpdateAccInfoEp();
//		newep.updatePiPatAccInfo(-(blpreppDO.getAmt().doubleValue()), blpreppDO, IBdFcDictCodeConst.ID_CODE_ENTP_OP);
//		return FBoolean.TRUE;
//	}
	
	/*
	 * 门诊预交金退款
	 * */
//	public FBoolean refundBlPayPatInfo(BlPayPatItemDTO blPayPatItemDTO,String id_pat,String sd_pttp) 
//			throws BizException{
//		BlPrePayPatDO blPayPatDO=new BlPrePayPatDO();
//		
//		blPayPatDO.setSd_paytp(IBlDictCodeConst.SD_PAYTP_CODE_HZYJ);
//		blPayPatDO.setId_paytp(IBlDictCodeConst.SD_PAYTP_ID_HZYJ);
//		blPayPatDO.setSd_pm(blPayPatItemDTO.getPaymod_code());
//		blPayPatDO.setId_pm(blPayPatItemDTO.getId_paymod());
//		switch(blPayPatItemDTO.getId_paymod()){
//			case IBdPripmCodeConst.ID_PRI_PM_CREDIT:
//				blPayPatDO.setId_bank(blPayPatItemDTO.getId_bank());
//				blPayPatDO.setBankno(blPayPatItemDTO.getBankno());
//				blPayPatDO.setPaymodenode(blPayPatItemDTO.getPaymodeno());
//				break;
//			case IBdPripmCodeConst.ID_PRI_PM_CHECK:
//				blPayPatDO.setId_bank(blPayPatItemDTO.getId_bank());
//				blPayPatDO.setBankno(blPayPatItemDTO.getBankno());
//				blPayPatDO.setPaymodenode(blPayPatItemDTO.getPaymodeno());
//				break;
//			case IBdPripmCodeConst.ID_PRI_PM_DEAFT:
//				blPayPatDO.setId_bank(blPayPatItemDTO.getId_bank());
//				blPayPatDO.setBankno(blPayPatItemDTO.getBankno());
//				blPayPatDO.setPaymodenode(blPayPatItemDTO.getPaymodeno());
//				break;
//			default:
//				break;
//		}
//		blPayPatDO.setId_pat(id_pat);
//		blPayPatDO.setId_org(Context.get().getOrgId());
//		blPayPatDO.setId_grp(Context.get().getGroupId());
//		blPayPatDO.setId_org_pay(Context.get().getStuffId());
//		blPayPatDO.setId_dep_pay(Context.get().getDeptId());
//		blPayPatDO.setId_emp_pay(Context.get().getStuffId());
//		blPayPatDO.setAmt(blPayPatItemDTO.getAmt());//退款金额
//    	blPayPatDO.setFg_canc(FBoolean.FALSE);
//		blPayPatDO.setFg_cc(FBoolean.FALSE);
//		blPayPatDO.setId_incca(null);
//		blPayPatDO.setCode_rep(null);
//		blPayPatDO.setId_par(null);
//		blPayPatDO.setEu_direct(BookRtnDirectEnum.RETURNS);//收退款方向
//		blPayPatDO.setNote("门诊预交金退款");
//		TimeService timeService = new TimeServiceImpl();//获取当前服务器时间
//		FDateTime dateTime = timeService.getUFDateTime();
//		blPayPatDO.setDt_pay(dateTime);
//		
//		blPayPatDO.setId_enttp(IBdFcDictCodeConst.ID_CODE_ENTP_OP);//就诊类型id
//		blPayPatDO.setCode_enttp(IBdFcDictCodeConst.SD_CODE_ENTP_OP);
//		blPayPatDO.setSd_pttp(sd_pttp);
//		blPayPatDO.setStatus(DOStatus.NEW);//数据状态为新增
//		
//		IBlpaypatCudService payService = (IBlpaypatCudService)ServiceFinder.find(IBlpaypatCudService.class);
//		BlPrePayPatDO[] blPrePayPatDO = payService.save(new BlPrePayPatDO[]{blPayPatDO});
//		if(blPrePayPatDO == null || blPrePayPatDO.length == 0){
//			throw new BizException("保存新增预交金数据失败！");
//		}
//		
//		//修改患者预交金收退款总额
//		//this.updateBlPayMamtOepInfo(blPayPatDO.getId_pat(), BookRtnDirectEnum.RETURNS, blPayPatDO.getAmt(), blPayPatDO.getId_pm(), blPayPatDO.getSd_pm());
//		BlPreayPMamtOepDOEp  ep  = new  BlPreayPMamtOepDOEp();
//		ep.updateBlPayMamtOepInfo(blPayPatDO.getId_pat(), BookRtnDirectEnum.RETURNS, blPayPatDO.getAmt(), blPayPatDO.getId_pm(), blPayPatDO.getSd_pm());
//		
//		//账户信息修改
//		//this.updatePiPatAccInfo((blPayPatItemDTO.getAmt().multiply(BookRtnDirectEnum.RETURNS).doubleValue()), blPayPatDO, IBdFcDictCodeConst.ID_CODE_ENTP_OP);
//		UpdateAccInfoEp newep=new UpdateAccInfoEp();
//		newep.updatePiPatAccInfo((blPayPatItemDTO.getAmt().multiply(BookRtnDirectEnum.RETURNS).doubleValue()), blPayPatDO, IBdFcDictCodeConst.ID_CODE_ENTP_OP);
//		return FBoolean.TRUE;
//	}
	
	/* *
	 * 住院预交金退款
	 * @throws BizException 
	 * */
//	public FBoolean refundIpBlPrePayInfo(BlPrePayPatDO blPrePayPatDO,BlPayPatItemDTO blPayPatItemDTO) 
//			throws BizException{
//		//获取服务器当前时间
//		TimeService timeService = new TimeServiceImpl();
//		FDateTime ntime = timeService.getUFDateTime();
//		
//		BlPrePayPatDO blPrePayInfo = new BlPrePayPatDO();
//		blPrePayInfo.setId_grp(Context.get().getGroupId());
//		blPrePayInfo.setId_org(Context.get().getOrgId());
//		blPrePayInfo.setId_emp_pay(Context.get().getStuffId());
//		blPrePayInfo.setId_dep_pay(Context.get().getDeptId());
//		blPrePayInfo.setId_org_pay(Context.get().getOrgId());
//		blPrePayInfo.setDt_pay(ntime);
//		blPrePayInfo.setAmt(blPayPatItemDTO.getAmt());
//		blPrePayInfo.setId_paytp(IBlDictCodeConst.SD_PAYTP_ID_ZYYJ);
//		blPrePayInfo.setSd_paytp(IBlDictCodeConst.SD_PAYTP_CODE_ZYYJ);
//		blPrePayInfo.setId_par(blPrePayPatDO.getId_paypat());
//		blPrePayInfo.setEu_direct(BookRtnDirectEnum.RETURNS);
//		blPrePayInfo.setId_pat(blPrePayPatDO.getId_pat());
//		blPrePayInfo.setSd_pm(blPayPatItemDTO.getPaymod_code());
//		blPrePayInfo.setId_pm(blPayPatItemDTO.getId_paymod());
//		switch(blPayPatItemDTO.getId_paymod()){
//			case IBdPripmCodeConst.ID_PRI_PM_CREDIT:
//				blPrePayInfo.setId_bank(blPayPatItemDTO.getId_bank());
//				blPrePayInfo.setBankno(blPayPatItemDTO.getBankno());
//				blPrePayInfo.setPaymodenode(blPayPatItemDTO.getPaymodeno());
//				break;
//			case IBdPripmCodeConst.ID_PRI_PM_CHECK:
//				blPrePayInfo.setId_bank(blPayPatItemDTO.getId_bank());
//				blPrePayInfo.setBankno(blPayPatItemDTO.getBankno());
//				blPrePayInfo.setPaymodenode(blPayPatItemDTO.getPaymodeno());
//				break;
//			case IBdPripmCodeConst.ID_PRI_PM_DEAFT:
//				blPrePayInfo.setId_bank(blPayPatItemDTO.getId_bank());
//				blPrePayInfo.setBankno(blPayPatItemDTO.getBankno());
//				blPrePayInfo.setPaymodenode(blPayPatItemDTO.getPaymodeno());
//				break;
//			default:
//				break;
//		}
//		blPrePayInfo.setId_ent(blPrePayPatDO.getId_ent());
//		blPrePayInfo.setId_enttp(blPrePayPatDO.getId_enttp());//就诊类型id
//		blPrePayInfo.setCode_enttp(blPrePayPatDO.getCode_enttp());
//		blPrePayInfo.setFg_canc(FBoolean.FALSE);
//		blPrePayInfo.setFg_cc(FBoolean.FALSE);
//		blPrePayInfo.setId_incca(null);
//		blPrePayInfo.setCode_rep(null);
//		blPrePayInfo.setId_par(null);
//		blPrePayInfo.setFg_rep_return(FBoolean.TRUE);
//		blPrePayInfo.setDt_return(ntime);
//		blPrePayInfo.setId_emp_return(Context.get().getStuffId());
//		blPrePayInfo.setNote("作废：" + blPrePayPatDO.getCode_rep());
//		blPrePayInfo.setSd_pttp(blPrePayPatDO.getSd_pttp());
//		blPrePayInfo.setStatus(DOStatus.NEW);//数据状态为新增
//		
//		blPrePayPatDO.setFg_canc(FBoolean.TRUE);
//		blPrePayPatDO.setDt_canc(ntime);
//		blPrePayPatDO.setId_emp_canc(Context.get().getStuffId());
//		blPrePayPatDO.setNote("已退费");
//		blPrePayPatDO.setStatus(DOStatus.UPDATED);
//		
//		IBlpaypatCudService payService = (IBlpaypatCudService)ServiceFinder.find(IBlpaypatCudService.class);
//		BlPrePayPatDO[] blPrePayPatDOArr = payService.save(new BlPrePayPatDO[]{blPrePayInfo,blPrePayPatDO});
//		if(blPrePayPatDOArr == null || blPrePayPatDOArr.length == 0){
//			throw new BizException("保存新增预交金数据失败！");
//		}
//		
//		//账户信息修改
//		this.updatePiPatAccInfo((blPayPatItemDTO.getAmt().multiply(BookRtnDirectEnum.RETURNS).doubleValue()), blPrePayPatDO, IBdFcDictCodeConst.ID_CODE_ENTP_IP);
//		
//		return FBoolean.TRUE;
//	}
//	
	/**
	 * 根据banner中输入值查询相关患者就诊信息
	 * */
//	@SuppressWarnings({ "unchecked" })
//	public BlBannerDTO[] getBannerEnEntInfo(String inputValue,String[] selectCondition) throws BizException{
//		StringBuffer sql = new StringBuffer();
//		sql.append("select t.id_ent,p.id_pat,p.name as name_pat,t.code as code_ent,t.dt_entry as dt_in,e.times_ip,r.id_pripat,r.name as name_pripat,h.id_hp,h.name as name_hp,t.fg_ip ")
//			 .append("from en_ent t ")
//			 .append("left join pi_pat p on p.id_pat = t.id_pat ")
//			 .append("left join en_ent_ip e on e.id_ent = t.id_ent ")
//			 .append("left join bd_pri_pat r on r.id_pripat = t.id_pripat ")
//			 .append("left join en_ent_hp n on n.id_ent = t.id_ent and n.fg_maj = 'Y' ")
//			 .append("left join bd_hp h on h.id_hp = n.id_hp ")
//			 .append("left outer join pi_pat_card c on c.id_pat = p.id_pat ")
//			 .append("where t.code_entp = 10 ")
//			 .append("and t.fg_canc = 'N' and t.fg_st = 'N' ");
//		sql.append(" and ").append(BlGroupControlUtils.getGroupControlFitler(new PatiVisitDO(), "t"));
//		if(selectCondition != null && selectCondition.length > 0){
//			sql.append("and (");
//			StringBuffer wheresql = new StringBuffer();
//			for(String cond : selectCondition){
//				if("code_ent".equals(cond)){
//					if(wheresql != null && wheresql.length() > 0){
//						wheresql.append(" or ");
//					}
//					wheresql.append("t.code like '%").append(inputValue).append("%'");
//				}else if("id_pat".equals(cond)){
//					if(wheresql != null && wheresql.length() > 0){
//						wheresql.append(" or ");
//					}
//					wheresql.append("p.id_pat like '%").append(inputValue).append("%'");
//				}else if("code_pat".equals(cond)){
//					if(wheresql != null && wheresql.length() > 0){
//						wheresql.append(" or ");
//					}
//					wheresql.append("p.code like '%").append(inputValue).append("%'");
//				}else if("id_code".equals(cond)){
//					if(wheresql != null && wheresql.length() > 0){
//						wheresql.append(" or ");
//					}
//					wheresql.append("p.id_code like '%").append(inputValue).append("%'");
//				}else if("barcode_chis".equals(cond)){
//					if(wheresql != null && wheresql.length() > 0){
//						wheresql.append(" or ");
//					}
//					wheresql.append("p.barcode_chis like '%").append(inputValue).append("%'");
//				}else if("code_amr_ip".equals(cond)){
//					if(wheresql != null && wheresql.length() > 0){
//						wheresql.append(" or ");
//					}
//					wheresql.append("p.code_amr_ip like '%").append(inputValue).append("%'");
//				}else if("patcode".equals(cond)){
//					if(wheresql != null && wheresql.length() > 0){
//						wheresql.append(" or ");
//					}
//					wheresql.append("c.code like '%").append(inputValue).append("%'");
//				}
//			}
//			sql.append(wheresql.toString());
//			sql.append(") ");
//		}
//		sql.append("order by p.id_pat,e.times_ip desc");
//		List<BlBannerDTO> list = (List<BlBannerDTO>)new DAFacade().execQuery(sql.toString(), new BeanListHandler(BlBannerDTO.class));
//		return list.toArray(new BlBannerDTO[]{});
//	}
}
