package iih.bl.pay.blpaypat.bp;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.pp.incca.i.IBdInccaCodeConst;
import iih.bl.inc.i.IBlIncUtilService;
import iih.bl.inc.service.i.IBLInvoiceService;
import iih.bl.pay.blpaypat.bp.ip.SavePrepayInfoIpBp;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.blpaypat.d.BookRtnDirectEnum;
import iih.bl.pay.blprepay.ep.BlPreayPMamtOepDOEp;
import iih.bl.pay.blprepay.ep.BlPrepayPatDOEp;
import iih.bl.pay.blprepay.ep.UpdateAccInfoEp;
import iih.bl.pay.bp.qry.GetInvoiceInfoBP;
import iih.bl.pay.dto.d.BlPayPatItemDTO;
import iih.bl.pay.prepaypatrcpt.d.BlPrepayPatRcptDO;
import iih.bl.pay.prepaypatrcpt.i.IPrepaypatrcptCudService;
import iih.bl.pay.s.bp.util.PrepayReceiptAssembleUtil;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.sf.core.util.ServiceFinder;

public class SavePrePayInfoBp {
	/**
	 *  保存收预交金数据，门诊/住院公用，根据支付类型来区分是门诊/住院, 
	 * @param blPayPatItemDTO
	 * @param blPayPatDO
	 * @param payType
	 * @return
	 * @throws BizException
	 */
	public BlPrePayPatDO[] execSaveBlPayPatInfo(BlPayPatItemDTO blPayPatItemDTO,BlPrePayPatDO blPayPatDO, String payType) 
			throws BizException{
		//主要业务： 1.校验票据号   2.保存新增的预交金数据   3.更新账户   4，更新票据号
		
		//如果支付类型是住院类型的，则用住院的bp类来实现
		if(IBdFcDictCodeConst.ID_CODE_ENTP_IP.equals(payType)){
			SavePrepayInfoIpBp ppbp=new SavePrepayInfoIpBp();
			return  ppbp.execSaveIpBlPayPatInfo(blPayPatItemDTO, blPayPatDO, payType);
		}
		
		//如果支付类型是门诊类型的，则走下边的逻辑
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
		//3.1，如果是门诊类型收退预交金，修改患者预交金收退款总额
		if(IBdFcDictCodeConst.ID_CODE_ENTP_OP.equals(payType)){
			//this.updateBlPayMamtOepInfo(blPrePayPatDOArr[0].getId_pat(), BookRtnDirectEnum.CHARGE, blPrePayPatDOArr[0].getAmt(), blPrePayPatDOArr[0].getId_pm(), blPrePayPatDOArr[0].getSd_pm());
			BlPreayPMamtOepDOEp  ep  = new  BlPreayPMamtOepDOEp();
			ep.updateBlPayMamtOepInfo(blPrePayPatDOArr[0].getId_pat(), BookRtnDirectEnum.CHARGE, blPrePayPatDOArr[0].getAmt(), blPrePayPatDOArr[0].getId_pm(), blPrePayPatDOArr[0].getSd_pm());
		}
		
		//3.2 账户信息修改：当门诊时修改患者账户信息
		UpdateAccInfoEp newep=new UpdateAccInfoEp();
		newep.updatePiPatAccInfo(blPayPatItemDTO.getAmt().doubleValue(), blPayPatDO, payType);
		
		//4，更新票据号   ：票据编码修改
		BlPrepayPatDOEp newBl=new BlPrepayPatDOEp ();
		IBlIncUtilService incService = ServiceFinder.find(IBlIncUtilService.class);
		String inccaId = getInccaIdByPayType(payType);
		incService.nextInvoiceNo(blPayPatDO.getId_emp_pay(), Context.get().getClientHost(), inccaId);
		
		//5，新增票据打印记录
		BlPrepayPatRcptDO tempDO = new BlPrepayPatRcptDO();
		tempDO = PrepayReceiptAssembleUtil.assemble(blPayPatDO, "", blPayPatDO.getCode_rep(), 1, "");
		IPrepaypatrcptCudService service = ServiceFinder.find(IPrepaypatrcptCudService.class);
		service.save(new BlPrepayPatRcptDO[]{tempDO});
		
		return blPrePayPatDOArr;
	}

	/*
	 * 根据就诊类型，返回押金条类别
	 */
	private String getInccaIdByPayType(String payType)
	{
		String inccaId = "";
		if (IBdFcDictCodeConst.ID_CODE_ENTP_IP.equals(payType)) {
			inccaId = IBdInccaCodeConst.ID_INHOS_DEPOSIT;
		} else if (IBdFcDictCodeConst.ID_CODE_ENTP_OP.equals(payType)) {
			inccaId = IBdInccaCodeConst.ID_OUTPATIENT_DEPOSIT;
		} else if (IBdFcDictCodeConst.ID_CODE_ENTP_ET_OBS.equals(payType)) {
			inccaId = IBdInccaCodeConst.ID_ET_INVOICE;
		}
		return inccaId;
	}
}
