package iih.pmp.pay.bill.bp;

import iih.pmp.pay.util.PmpPayAppBaseUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDate;

public class BillCheckOperatorBP {
	PmpPayAppBaseUtils pmputils=new PmpPayAppBaseUtils();
	public void exec() throws BizException{
		
		//1、下载账单
		new DownLoadBillBP().exec();
		//2、生成账单明细
		new GenerateBillItemBP().exec();
		//3、校验更新交易状态
		new updateOrdStatusBP().exec();
		//4、更新退款交易状态
		new updateRefundStatus().exec();
		//5、校验微信后台和交易表的数据
		new BillCheckBP().exec();
		//6、校验订单表和交易表的数据
		new OrderCheckBP().exec();
		//7、退款交易与微信后台对账
		new CheckRefundBillBP().exec();
		//8、已撤回交易与微信后台对账
		new CheckRevokedBillBP().exec();
		
		
	
	}
	
	public void exec( int days) throws BizException{
		
		FDate end=pmputils.getServerDateTime().getDate();
		FDate start=end.getDateBefore(days);
		//1、下载账单
		new DownLoadBillBP().exec(start,end);
		//2、生成账单明细
		new GenerateBillItemBP().exec(start,end);
		//3、校验更新交易状态
		new updateOrdStatusBP().exec();
		//4、更新退款交易状态
		new updateRefundStatus().exec();
		//5、校验微信后台和交易表的数据
		new BillCheckBP().exec(start,end);
		//6、校验订单表和交易表的数据
		new OrderCheckBP().exec(start,end);
		//7、退款交易与微信后台对账
		new CheckRefundBillBP().exec(start,end);
		//8、已撤回交易与微信后台对账
		new CheckRevokedBillBP().exec(start,end);
		//生成异常数据
		new GenerateCheckExceptionBP().Exec(start, end);
		
	
	}

}
