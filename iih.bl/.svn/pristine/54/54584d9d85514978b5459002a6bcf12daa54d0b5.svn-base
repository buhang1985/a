package iih.bl.itf.std.bp.ipprepay;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.pp.incca.i.IBdInccaCodeConst;
import iih.bd.pp.pripm.d.PriPmDO;
import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.bl.comm.GetPayCodeBP;
import iih.bl.inc.service.i.IBLInvoiceService;
import iih.bl.itf.std.bean.input.prepay.BlIpPrepayParamDTO;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.blpaypat.d.BookRtnDirectEnum;
import iih.bl.pay.blpaypat.i.IBlpaypatCudService;
import iih.en.pv.i.IEnOutCmdService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.pi.acc.account.i.IPatAccServiceExt;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

public class BlPrepayPatDOEp {
	/**
	 * 保存收预交金数据
	 * @param blIpPrepayParamDTO  从第三方传入的预交金相关信息，包括患者信息、操作员信息、支付凭证号、收单机构流水号、录入的收款金额、 支付方式等
	 * @param blPayPatDO  新插入的一条预交金数据
	 * @param payType     支付类型：取门诊预交金或者住院预交金
	 * @param deptD       收费科室ID
	 * @return
	 * @throws BizException
	 */
	public BlPrePayPatDO[] insertPrepayInfo(BlIpPrepayParamDTO blIpPrepayParamDTO, PatiVisitDO patiVistDO, String payType, String depID)
			throws BizException{
		//1.组装数据
		BlPrePayPatDO  saveDO  = this.assembleData(blIpPrepayParamDTO, patiVistDO, payType, depID) ;
		
		//2.直接获取票据号然后后移票号
		IBLInvoiceService incService = (IBLInvoiceService)ServiceFinder.find(IBLInvoiceService.class);
		String code_rep=incService.GetInvoiceNoAndNextInvoiceNoUpdateCurNo(saveDO.getId_emp_pay(), this.getRepCodeByCCTP(payType));
		
		saveDO.setCode_rep(code_rep); //票据编号赋值
		//3.保存数据
		IBlpaypatCudService payService = (IBlpaypatCudService)ServiceFinder.find(IBlpaypatCudService.class);
		BlPrePayPatDO[] blPrePayPatDOArr = payService.save(new BlPrePayPatDO[]{saveDO});
		if(blPrePayPatDOArr == null || blPrePayPatDOArr.length == 0){
			throw new BizException("保存新增预交金数据失败！");
		}
		return  blPrePayPatDOArr ;
	}
	
	public void updatePiPatAccInfo(FDouble amt,BlPrePayPatDO blPayPatDO, String payType) 
			throws BizException{
		
		if(IBdFcDictCodeConst.ID_CODE_ENTP_OP.equals(payType))
		{
			//pi_pat_acc.prepay add amt
			IPatAccServiceExt accDService = ServiceFinder.find(IPatAccServiceExt.class);
			accDService.updatePatPrepay(blPayPatDO.getId_pat(), new FDouble(amt));
		}else if(IBdFcDictCodeConst.ID_CODE_ENTP_IP.equals(payType)){
			IEnOutCmdService accDService = ServiceFinder.find(IEnOutCmdService.class);
			accDService.recharge(blPayPatDO.getId_ent(), new FDouble(amt));
		}
	}
	
	private BlPrePayPatDO assembleData(BlIpPrepayParamDTO blIpPrepayParamDTO, PatiVisitDO patiVistDO, String payType, String depID)
    {
		BlPrePayPatDO blPayPatDO = new BlPrePayPatDO();
		blPayPatDO.setId_org(Context.get().getOrgId());
		blPayPatDO.setId_grp(Context.get().getGroupId());
		blPayPatDO.setSd_pttp(IBlDictCodeConst.SD_PTTP_PHONE_APP); //收付款使用的终端的类型
		blPayPatDO.setId_org_pay(Context.get().getOrgId());
		blPayPatDO.setId_dep_pay(depID); //收付款部门
		blPayPatDO.setId_emp_pay(Context.get().getStuffId());
		blPayPatDO.setId_pat(patiVistDO.getId_pat());
		blPayPatDO.setId_ent(patiVistDO.getId_ent());
		blPayPatDO.setCode_rep("");//票据编号
		//押金缴费金额
		FDouble tmpAmt = new FDouble(blIpPrepayParamDTO.getPaymoney());
		blPayPatDO.setAmt(tmpAmt);//录入金额
		
		GetPayCodeBP payhelp = new GetPayCodeBP();
		PriPmDO pripm = payhelp.exec(blIpPrepayParamDTO.getPaymentmethod(), true);	
		String id_paymod = pripm.getId_pm();
		blPayPatDO.setId_pm(id_paymod);//收款方式
		switch(id_paymod){
			case IBdPripmCodeConst.ID_PRI_PM_CASH:
				blPayPatDO.setSd_pm(IBdPripmCodeConst.CODE_PRI_PM_CASH);
				break;
			case IBdPripmCodeConst.ID_PRI_PM_CREDIT:
//				blPayPatDO.setId_bank(blPayPatItemDTO.getId_bank());
				blPayPatDO.setBankno(blIpPrepayParamDTO.getOrdernumber());
				blPayPatDO.setPaymodenode(blIpPrepayParamDTO.getDocumentnumber());
				blPayPatDO.setSd_pm(IBdPripmCodeConst.CODE_PRI_PM_CREDIT);
				break;
			case IBdPripmCodeConst.ID_PRI_PM_CHECK:
//				blPayPatDO.setId_bank(blPayPatItemDTO.getId_bank());
				blPayPatDO.setBankno(blIpPrepayParamDTO.getOrdernumber());
				blPayPatDO.setPaymodenode(blIpPrepayParamDTO.getDocumentnumber());
				blPayPatDO.setSd_pm(IBdPripmCodeConst.CODE_PRI_PM_CHECK);
				break;
			case IBdPripmCodeConst.ID_PRI_PM_DEAFT:
//				blPayPatDO.setId_bank(blPayPatItemDTO.getId_bank());
				blPayPatDO.setBankno(blIpPrepayParamDTO.getOrdernumber());
				blPayPatDO.setPaymodenode(blIpPrepayParamDTO.getDocumentnumber());
				blPayPatDO.setSd_pm(IBdPripmCodeConst.CODE_PRI_PM_DEAFT);
				break;
			case IBdPripmCodeConst.ID_PRI_PM_BANK_DIFF:
//				blPayPatDO.setId_bank(blIpPrepayParamDTO.getId_bank());
				blPayPatDO.setBankno(blIpPrepayParamDTO.getOrdernumber());
				blPayPatDO.setPaymodenode(blIpPrepayParamDTO.getDocumentnumber());
				blPayPatDO.setSd_pm(IBdPripmCodeConst.CODE_PRI_PM_BANK_DIFF);
				break;	
			case IBdPripmCodeConst.ID_PRI_PM_ALIPAY: //支付宝
				blPayPatDO.setBankno(blIpPrepayParamDTO.getOrdernumber()); //收单机构流水号
				blPayPatDO.setPaymodenode(blIpPrepayParamDTO.getPaymentmethod()); //支付凭证号
				blPayPatDO.setSd_pm(IBdPripmCodeConst.CODE_PRI_PM_ALIPAY);				
				break;
			case IBdPripmCodeConst.ID_PRI_PM_WECHAT: //微信
				blPayPatDO.setBankno(blIpPrepayParamDTO.getOrdernumber()); //收单机构流水号
				blPayPatDO.setPaymodenode(blIpPrepayParamDTO.getDocumentnumber()); //支付凭证号
				blPayPatDO.setSd_pm(IBdPripmCodeConst.CODE_PRI_PM_WECHAT);						
				break;				
			default:
				break;
		}
		blPayPatDO.setDt_pay(new FDateTime());
		//blPayPatDO.setFg_st(FBoolean.FALSE);//结算标志
		blPayPatDO.setCode_incca(this.getRepCodeByCCTP(payType));//票据类型编码
		blPayPatDO.setId_incca(this.getRepIdByCCTP(payType));//票据类型ID
		blPayPatDO.setEu_direct(BookRtnDirectEnum.CHARGE);//收退款方向
		blPayPatDO.setFg_canc(FBoolean.FALSE);
		blPayPatDO.setId_enttp(payType);//结账类型id
		if(IBdFcDictCodeConst.ID_CODE_ENTP_OP.equals(payType)){
			blPayPatDO.setCode_enttp(IBdFcDictCodeConst.SD_CODE_ENTP_OP);
			blPayPatDO.setId_paytp(IBlDictCodeConst.ID_PAYTP_OPPREPAY); //预交金收付款类型ID
			blPayPatDO.setSd_paytp(IBlDictCodeConst.SD_PAYTP_OPPREPAY); //预交金收付款类型
		}else if(IBdFcDictCodeConst.ID_CODE_ENTP_IP.equals(payType)){
			blPayPatDO.setCode_enttp(IBdFcDictCodeConst.SD_CODE_ENTP_IP);
			blPayPatDO.setId_paytp(IBlDictCodeConst.ID_PAYTP_IPPREPAY); //预交金收付款类型ID
			blPayPatDO.setSd_paytp(IBlDictCodeConst.SD_PAYTP_IPPREPAY); //预交金收付款类型
		}
		blPayPatDO.setStatus(DOStatus.NEW);//数据状态为新增
		return    blPayPatDO;
	}
	
	/*
	 * 通过业务类型取得票据分类编号
	 * */
	public String getRepCodeByCCTP(String SD_CCTP_ID){
		if(IBdFcDictCodeConst.ID_CODE_ENTP_OP.equals(SD_CCTP_ID)){
			return IBdInccaCodeConst.CODE_OUTPATIENT_DEPOSIT;
		}else if(IBdFcDictCodeConst.ID_CODE_ENTP_IP.equals(SD_CCTP_ID)){
			return IBdInccaCodeConst.CODE_INHOS_DEPOSIT;
		}
		return null;
	}

	/*
	 * 通过业务类型取得票据分类ID
	 * */
	public  String getRepIdByCCTP(String SD_CCTP_ID){
		if(IBdFcDictCodeConst.ID_CODE_ENTP_OP.equals(SD_CCTP_ID)){
			return IBdInccaCodeConst.ID_OUTPATIENT_DEPOSIT;
		}else if(IBdFcDictCodeConst.ID_CODE_ENTP_IP.equals(SD_CCTP_ID)){
			return IBdInccaCodeConst.ID_INHOS_DEPOSIT;
		}
		return null;
	}


}
