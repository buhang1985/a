package iih.pmp.pay.custom.bill.bp;

import java.util.ArrayList;
import java.util.List;

import iih.pmp.pay.channelbillitem.d.ChlBillItemDO;
import iih.pmp.pay.channelbillitem.i.IChannelbillitemRService;
import iih.pmp.pay.d.Reconcilldto;
import iih.pmp.pay.trade.d.TradeDO;
import iih.pmp.pay.trade.i.ITradeRService;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

public class PmpBillCheckExternalBP {
	PmpPayAppBaseUtils pmputils = new PmpPayAppBaseUtils();

	public Reconcilldto[] exec(String startTime, String endTime) throws BizException {
		ITradeRService itradeRService = pmputils.getTradeRService();
		IChannelbillitemRService ichannelbillitemRService = ServiceFinder.find(IChannelbillitemRService.class);
		ChlBillItemDO[] chlBillItemDOs = ichannelbillitemRService
				.find("tradetime between '" + startTime + "' and '" + endTime + "' and sd_chl = 'pay.pmp.0005'", "", FBoolean.FALSE);
		TradeDO[] tradeDOs = itradeRService.find("(Trade_status = 1 or Trade_status = 4) and dt_req between '" + startTime + "' and '" + endTime + "' and  sd_chl = 'pay.pmp.0005'", "",
				FBoolean.FALSE);
		List<Reconcilldto> reconcill = new ArrayList<Reconcilldto>();
		for (ChlBillItemDO chlBillItemDO : chlBillItemDOs) {
			Boolean isHave = false;
			for (TradeDO tradeDO : tradeDOs) {
				
				if (tradeDO.getTrade_status() == 1 && "SUCCESS".equals(chlBillItemDO.getTrade_status())&&chlBillItemDO.getMch_trade_no().equals(tradeDO.getTrade_no()) && !(chlBillItemDO.getTotal_fee().equals(tradeDO.getAmount()))) {
						reconcill.add(creatDto(tradeDO.getAmount().toString(),(tradeDO.getAmount().sub(chlBillItemDO.getTotal_fee())).toString(),"交易差额",tradeDO.getOrd_no(),tradeDO.getName_payemp()));
						isHave = true;
						break;
				} else if (tradeDO.getTrade_status() == 4 && "REFUND".equals(chlBillItemDO.getTrade_status())&&chlBillItemDO.getMch_refund_no().equals(tradeDO.getTrade_no()) && !(chlBillItemDO.getRefund_fee().equals(tradeDO.getAmount()))) {
						reconcill.add(creatDto(tradeDO.getAmount().toString(),(tradeDO.getAmount().sub(chlBillItemDO.getRefund_fee())).toString(),"交易差额",tradeDO.getOrd_no(),tradeDO.getName_payemp()));
						isHave = true;
						break;
				}else if(tradeDO.getTrade_status() == 4 && "REFUND".equals(chlBillItemDO.getTrade_status())&&chlBillItemDO.getMch_refund_no().equals(tradeDO.getTrade_no()) ){
					isHave = true;
					break;
				}else if(tradeDO.getTrade_status() == 1 && "SUCCESS".equals(chlBillItemDO.getTrade_status())&&chlBillItemDO.getMch_trade_no().equals(tradeDO.getTrade_no()) ){
					isHave = true;
					break;
				}

			}
			 if(!isHave){
				 if(chlBillItemDO.getTrade_status().equals("SUCCESS")){
					 reconcill.add(creatDto(chlBillItemDO.getTotal_fee().toString(),null,"第三方支付单边",chlBillItemDO.getMch_trade_no(),null));
				 }else if(chlBillItemDO.getTrade_status().equals("REFUND")){
					 reconcill.add(creatDto(chlBillItemDO.getTotal_fee().toString(),null,"第三方退款单边",chlBillItemDO.getMch_trade_no(),null));
				 }
			}
		}

		for (TradeDO tradeDO : tradeDOs) {
			Boolean isHave = false;
			for (ChlBillItemDO chlBillItemDO : chlBillItemDOs) {
				if (tradeDO.getTrade_status() == 1 &&  "SUCCESS".equals(chlBillItemDO.getTrade_status())&&tradeDO.getTrade_no().equals(chlBillItemDO.getMch_trade_no())) {
					isHave = true;	
					break;
				} else if (tradeDO.getTrade_status() == 4 && "REFUND".equals(chlBillItemDO.getTrade_status())&&tradeDO.getTrade_no().equals(chlBillItemDO.getMch_refund_no())) {
					isHave = true;	
					break;
				} 
			}
			if(!isHave){
				 if(tradeDO.getTrade_status() == 4){
					reconcill.add(creatDto(tradeDO.getAmount().toString(),null,"HIS退款单边",tradeDO.getOrd_no(),tradeDO.getName_refund_emp()));
				}else if(tradeDO.getTrade_status() == 1){
					reconcill.add(creatDto(tradeDO.getAmount().toString(),null,"HIS支付单边",tradeDO.getOrd_no(),tradeDO.getName_payemp()));
				}
			}
			
		}
		return reconcill.toArray(new Reconcilldto[] {});
	}

	public Reconcilldto creatDto(String Amount,String Amount_ex,String Ex_type,String Ord_no,String Recon_ps) {
		Reconcilldto reconcilldto=new Reconcilldto();
		reconcilldto.setAmount(Amount);
		reconcilldto.setAmount_ex(Amount_ex);
		reconcilldto.setEx_type(Ex_type);
		reconcilldto.setOrd_no(Ord_no);
		reconcilldto.setRecon_ps(Recon_ps);
		return reconcilldto;
	}
}
