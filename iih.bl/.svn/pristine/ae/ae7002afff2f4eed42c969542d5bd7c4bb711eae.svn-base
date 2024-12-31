package iih.bl.itf.std.bp.balacc;

import java.util.List;

import iih.bl.itf.std.bean.input.balacc.sub.WsParamThirdPayBillItem;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.sie.common.utils.StringUtils;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 检查是否是异常数据
 *  异常数据不允许退费  不支持半退
 * @author zhang
 *
 */
public class CheckAbnormalDataBP {
	@SuppressWarnings("static-access")
	public FBoolean exec (String ord_no) throws BizException{
    	if(StringUtils.isEmpty(ord_no)){
    		throw new BizException("订单号 或者交易方向不能为空");
    	}
    	StringBuffer sql = new StringBuffer();
    	sql.append("   select sum(amount ) from   ( ");
    	sql.append(" select sum(payitm.eu_direct*payitm.amt) amount ");
    	sql.append(" from bl_pay_itm_pat_oep payitm where payitm.fg_realpay='Y' and payitm.paymodenode ='"+ord_no+"'");
    	sql.append(" union all ");
    	sql.append(" select sum(pat.eu_direct*pat.amt) amount ");
    	sql.append(" from bl_prepay_pat pat where pat.sd_paytp in ('11','12')  and  pat.paymodenode ='"+ord_no+"'");
    	sql.append(" union all");
    	sql.append(" select sum(patip.eu_direct*patip.amt) amount  ");
    	sql.append(" from bl_pay_itm_pat_ip patip where patip.fg_realpay ='Y' and patip.paymodenode ='"+ord_no+"'");
    	sql.append(" ) ");
    	@SuppressWarnings("unchecked")
		List<WsParamThirdPayBillItem> list  = (List<WsParamThirdPayBillItem>) new DAFacade().execQuery(sql.toString(),
				null, new BeanListHandler(WsParamThirdPayBillItem.class));
  	    if(!ListUtil.isEmpty(list)){
  	    	FDouble amount = new FDouble(list.get(0).getAmount());
  	    	if(amount.compareTo(new FDouble().ZERO_DBL)>0){
  	    		return FBoolean.TRUE;
  	    	}else {
  	    		return  FBoolean.FALSE;
  	    	}
         }
		return  FBoolean.TRUE;	
    		
    }
}
