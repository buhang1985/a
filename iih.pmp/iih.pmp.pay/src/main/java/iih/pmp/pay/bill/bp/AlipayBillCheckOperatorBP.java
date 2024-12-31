package iih.pmp.pay.bill.bp;

import xap.mw.core.data.BizException;

public class AlipayBillCheckOperatorBP {
	
	public void exec() throws BizException {		
		//1、下载账单
		new AlipayDownloadBillBP().exec();
		//2、生成账单明细
		new AlipayGenerateBillItemBP().exec();
		//3、校验更新交易状态
		new AlipayUpdateOrdStatusBP().exec();
		//4、校验支付宝后台和交易表的数据
		new AlipayBillCheckBP().exec();
		//5、校验订单表和交易表的数据
		new AlipayOrderCheckBP().exec();			
	}
}
