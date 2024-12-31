package iih.pmp.pay.web.pay;

import iih.pmp.pay.i.IPmpPayOperatorService;
import iih.pmp.pay.ord.d.OrdDO;
import iih.pmp.pay.ordqryrstdto.d.OrdQryRstDTO;
import iih.pmp.pay.ordreqdto.d.OrdReqDTO;
import iih.pmp.pay.trade.d.TradeDO;
import iih.pmp.pay.trade.d.TradeStatusEnum;
import iih.pmp.pay.web.pay.bp.CipherTextUtil;
import iih.pmp.pay.web.pay.bp.WXPayNotifyAppUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Security;
import java.util.Map;

import javax.crypto.Cipher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.misc.BASE64Decoder;
import test.wxpay.sdk.WXPayConfigImpl;
import wxpay.sdk.WXPayUtil;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
@WebServlet("/WXReFundNotifyHandler")
public class WXReFundNotifyHandler  extends HttpServlet  {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String inputLine;  
        String notityXml = "";  
        try {
  
            while ((inputLine = req.getReader().readLine()) != null) {  
                notityXml += inputLine;  
            }  
            req.getReader().close();  
        } catch (Exception e) {  
 
  
        }  
       try {
		Map<String,String> m= WXPayUtil.xmlToMap(notityXml);
		if(m.get("return_code").equals("SUCCESS")){
			String appid = m.get("appid").toString();  
			String mch_id = m.get("mch_id").toString(); 
			String req_info = m.get("req_info").toString(); 
			//对加密数据解码
			byte[] k=new BASE64Decoder().decodeBuffer(req_info);		      
		    String B = CipherTextUtil.decryptData(k);
		    
		    Map<String,String> reqm= WXPayUtil.xmlToMap(B);
            if(reqm.get("refund_status").equals("SUCCESS")){
            	TradeDO t=getTrade8no(reqm.get("out_refund_no"));
            	if(t.getTrade_status().equals(TradeStatusEnum.REFUND_SUCCESS)) {
            		PrintWriter out = resp.getWriter();
            		out.print("<xml><return_code><![CDATA[SUCCESS]]></return_code></xml>");
            		out.flush();
            		out.close();
            	}else {
            	OrdReqDTO dto=new OrdReqDTO();
            	dto.setSd_chl(t.getSd_chl());
            	dto.setOrd_no(t.getOrd_no());
            	dto.setRefund_req_no(t.getRefund_req_no());
            	dto.setId_user_req(t.getId_emp_op());
            	OrdQryRstDTO[] rst=ServiceFinder.find(IPmpPayOperatorService.class).refundquery(dto);
            	if(rst!=null&&rst.length>0) {
            		if(rst[0].getTrade_status().equals(TradeStatusEnum.REFUND_SUCCESS)) {
            			PrintWriter out = resp.getWriter();
                		out.print("<xml><return_code><![CDATA[SUCCESS]]></return_code></xml>");
                		out.flush();
                		out.close();
            		}
            	}
            	}
//            	if(t!=null){
//            		updateTrade(t,TradeStatusEnum.REFUND_SUCCESS);
//            	}
            	
            }
			int a=1;
		}
 
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		/* 测试代码
		String A = "XjNzqEfAUM1mlqHrZAI0ET+UdSmIcCWKjvnMgINFm93ELqgM+Wso4z3EoWGRdYD7lNKLxPwxKFb1azATWbXF/BA5smGJ8Ib7VRY125x4Sv7EXTiZojPtxLVsgIlF9bq3CRa/f4ba4UcJPkXt2e5rp7FP7jPbGnh7TJo3VymlcJC6iNTSw1ilQpyCQHiimRxy4QXHPysOcKNtlhWf4Yzjoqj3j1kgYAuM+VMuEphnNMGMIs4GRDMhqsHGAhBd/4KwTgdVG0r1dREzdrrfqpXKyQ5yeslBruHWDMBThI8KmVspwHtTuOVztM2KEiozo5+ytXq++gQZ9pr0i/QYICwBfCUhRVA2SAP3H01sLppbED/fQF7DnydUyyrOYizwn/7QVhoYxt0lePfAojsfSowkhTcyqvOOCvH84uPFuXP88R4WHyiR3GiF6mCjhpvRkdNddTiLi4/vPpQfIA0IU3SD2qzKmJty1oPSWhHy0ol3rOtqT01aayVkez+rAiDQ5R742uUL3HGIqszW2JuAyYA04DZlNN4H0tq/F5B6/PAFOQwoo4M+at/7arVVtXVr92PKvBgBvbkLkGWVHMUR0w8/BdU0kVEdwFB61E52rbYbPFZL1+JmJo5yQ5TndKpVVVTLewDznZAn/cSx47TOQJXyCO6IUYJYZmuC+28+LrP1KUUrmjg3Y6J4cq2QnsYSr4lKcPnjYn+sBgyJnG+qhtQX/alviWVm0+z5NZ/H6QBQa0+AX5xBECQfz5/IUXodR3i1LcaRvbkELnrZWgXTRLEeNFnq2lHHm21Y88iCu7jN9Rcd7iBIcde5PEPBCjJQQ0tlOdvld71JdyklsNj9b5zckj1fUj9xf49JNXI1djQSla93zNzmgy7n/RczzsbgZExmYJeECrOwONzxvIzPF9d3ekslPuRXdUpygImvE+yr664U/oKyZYWYf5U+D1nWwShJlqMO5eUx/uYdIu/0hMXUz2fv+BOJK+h0y//G45w/sFSyguv/Bd30aPlP3kFcrg5gbORcsn6dd6Zjh6TsGbeBbA==";
	     
        byte[] k=new BASE64Decoder().decodeBuffer(A);
      
        String B;
		try {
			B = CipherTextUtil.decryptData(k);
			System.out.println(B);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        */
	}
	
	private void updateTrade(TradeDO t,int tradestatus) throws BizException{
		if (!t.getTrade_status().equals(tradestatus)) {
			FDouble total=getTotalRefundFee(t.getId_ord());
			t.setTrade_status(tradestatus);
			t.setDt_finish(WXPayNotifyAppUtils.getServerDateTime());
		t.setStatus(DOStatus.UPDATED);
		WXPayNotifyAppUtils.getTradeCUDService().update(new TradeDO[]{t});
		total=total.add(t.getAmount());
		updateOrdfee_kt( total, t.getTrade_no_rel(),t.getId_ord());
		}
	}
	
	private TradeDO getTrade8no(String trade_no) throws BizException{
		TradeDO[] tras=WXPayNotifyAppUtils.getTradeRService().find(TradeDO.TRADE_NO+"='"+trade_no+"' and "+TradeDO.EU_DIRECT+"=-1", "", FBoolean.FALSE);
		if(tras!=null&&tras.length>0){
			return tras[0];
		}
		return null;
	}
	
	private FDouble getTotalRefundFee(String id_ord) throws BizException{
		TradeDO[] tras=WXPayNotifyAppUtils.getTradeRService().find(TradeDO.ID_ORD+"='"+id_ord+"' and "+TradeDO.EU_DIRECT+"=-1 and "+TradeDO.TRADE_STATUS+"="+TradeStatusEnum.REFUND_SUCCESS, "", FBoolean.FALSE);
		FDouble total=new FDouble(0);
		if(tras!=null&&tras.length>0){
			for (TradeDO o : tras) {
				total=total.add(o.getAmount());
			}
		}
		return total;
	}
	/**
	 * 设置可退金额
	 * @param total
	 * @param reltradeno
	 * @param id_ord
	 * @throws BizException
	 */
	private void updateOrdfee_kt(FDouble total,String reltradeno,String id_ord) throws BizException{
		TradeDO[] tras=WXPayNotifyAppUtils.getTradeRService().find(TradeDO.TRADE_NO+"='"+reltradeno+"' ", "", FBoolean.FALSE);
		if(tras!=null&&tras.length>0){
			FDouble  ktfee=tras[0].getAmount().sub(total);
			OrdDO ord=WXPayNotifyAppUtils.getOrdRService().findById(id_ord);
			if(ord!=null&&ord.getAmount_bk().getDouble()!=ktfee.getDouble()){
				ord.setAmount_bk(ktfee);
				ord.setStatus(DOStatus.UPDATED);
				WXPayNotifyAppUtils.getOrdCudService().update(new OrdDO[]{ord});
			}
		}
	}

}
