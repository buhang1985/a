package iih.pmp.pay.custom.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.pmp.pay.ordqryrstdto.d.OrdQryRstDTO;
import iih.pmp.pay.ordreqdto.d.OrdReqDTO;
import iih.pmp.pay.trade.d.TradeStatusEnum;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
/**
 * 批量退款查询
 * @author think
 *
 */
public class PmpQueryBatchBP {

	PmpPayAppBaseUtils pmputils=new PmpPayAppBaseUtils();
	
	@SuppressWarnings("unchecked")
	public OrdQryRstDTO[] queryrefund(OrdReqDTO[] dtos) throws BizException{
		if(dtos==null||dtos.length==0)throw new BizException("查询参数为空！");
		
		StringBuilder sb=new StringBuilder();
		StringBuilder sb2=new StringBuilder();
		List<OrdQryRstDTO> rstlist=new ArrayList<>();
		
		for (OrdReqDTO d : dtos) {

			if(pmputils.isStrEmpty(d.getOrd_no()))
				continue;			
			if(pmputils.isStrEmpty(d.getId_user_req()))
				continue;
			if(pmputils.isStrEmpty(d.getRefund_req_no()))
			{	
				String val=d.getOrd_no().trim()+""+d.getId_user_req().trim();
				if(sb2.length()==0) {
					sb2.append("'"+val+"'");
				}else {
					sb2.append(",'"+val+"'");
				}
			}
			else{
			String val=d.getOrd_no().trim()+""+d.getRefund_req_no().trim()+""+d.getId_user_req().trim();
			if(sb.length()==0) {
				sb.append("'"+val+"'");
			}else {
				sb.append(",'"+val+"'");
			}
			}
		}
		String sql=" select b.ord_no Ord_no," + 
		"       b.ord_status Ord_status," + 
		"       b.dt_ord Dt_ord," + 
		"       b.amount Amount," + 
		"       b.amount_bk Amount_bk," + 
		"       b.subject Subject," + 
		"       b.body Body," + 
		"       a.trade_no Trade_no," + 
		"       a.dt_req Tradetime," + 
		"       a.err_code Err_code," + 
		"       a.bankorderno Bankorderno," + 
		"       a.trade_no_chl Trade_no_chl," + 
		"       a.trade_status Trade_status," + 
		"       a.refund_req_no Refund_no," + 
		"       b.code Mch_order_no," + 
		"       a.banktradeno Banktradeno," + 
		"       a.tradetype Tradetype," + 
		"       a.sd_chl Sd_chl," + 
		"       a.id_emp_op Id_user_req," + 
		"       a.amount Trade_amount from pmp_trade a left join pmp_ord b on a.id_ord=b.id_ord ";
		if(sb.length()>0) {
			Map<String,OrdQryRstDTO> map=new HashMap<>();
			Map<String,OrdQryRstDTO> map2=new HashMap<>();
			sql=sql+" where a.ord_no||a.refund_req_no||a.id_emp_op in ("+sb.toString()+") ";
			DAFacade da=new DAFacade();
			List<OrdQryRstDTO> result=(List<OrdQryRstDTO>) da.execQuery(sql,  new BeanListHandler(OrdQryRstDTO.class));		
            for (OrdQryRstDTO t : result) {
            	String val=t.getOrd_no()+""+t.getRefund_no()+""+t.getId_user_req();
            	if(TradeStatusEnum.TRADE_UNKNOWN.equals(t.getTrade_status())) {
					rstlist.add(t);
					if(!map.containsKey(val)) {												
						map.put(val, t);
					}
					
				}else if(TradeStatusEnum.REFUND_SUCCESS.equals(t.getTrade_status())) {
					rstlist.add(t);
					if(!map.containsKey(val)) {												
						map.put(val, t);
					}
				}
			}
            for (OrdQryRstDTO t : result) {
            	String val=t.getOrd_no()+""+t.getRefund_no()+""+t.getId_user_req();
				if(!map2.containsKey(val)&&!map.containsKey(val)) {	
				rstlist.add(t);
				map2.put(val, t);
			}
            }
//			for (TradeDO t : tras) {
//				String val=t.getOrd_no()+""+t.getRefund_req_no()+""+t.getId_emp_op();
//				if(!map2.containsKey(val)&&!map.containsKey(val)) {
//					OrdQryRstDTO rst=createQryRst(t);	
//					rstlist.add(rst);
//					map2.put(val, rst);
//				}
//			}
		}
		if(sb2.length()>0) {
			Map<String,OrdQryRstDTO> map=new HashMap<>();
			Map<String,OrdQryRstDTO> map2=new HashMap<>();
			sql=sql+" where a.ord_no||a.id_emp_op in ("+sb2.toString()+")  and a.eu_direct=1 ";
			DAFacade da=new DAFacade();
			List<OrdQryRstDTO> result = (List<OrdQryRstDTO>) da.execQuery(sql, new BeanListHandler(OrdQryRstDTO.class));		
			 for (OrdQryRstDTO t : result) {
				String val=t.getOrd_no()+""+t.getId_user_req();
	               if(TradeStatusEnum.TRADE_UNKNOWN.equals(t.getTrade_status())||TradeStatusEnum.PAY_SUCCESS.equals(t.getTrade_status())||TradeStatusEnum.PAY_WAIT.equals(t.getTrade_status())||TradeStatusEnum.NOTPAY.equals(t.getTrade_status())||TradeStatusEnum.TURN_REFUND.equals(t.getTrade_status())) {
					rstlist.add(t);
					if(!map.containsKey(val)) {												
						map.put(val, t);
					}					
				}
			}
			 for (OrdQryRstDTO t : result) {
				 String val=t.getOrd_no()+""+t.getId_user_req();
				if(!map2.containsKey(val)&&!map.containsKey(val)) {	
					rstlist.add(t);
					map2.put(val, t);
				}
			}
		}		
		return rstlist.toArray(new OrdQryRstDTO[0]);
	}
	

}
