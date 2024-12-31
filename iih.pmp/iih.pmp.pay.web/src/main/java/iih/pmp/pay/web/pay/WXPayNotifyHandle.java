package iih.pmp.pay.web.pay;

import iih.pmp.pay.i.IPmpPayOperatorService;
import iih.pmp.pay.ord.d.OrdDO;
import iih.pmp.pay.ord.d.OrdStatusEnum;
import iih.pmp.pay.ordqryrstdto.d.OrdQryRstDTO;
import iih.pmp.pay.ordreqdto.d.OrdReqDTO;
import iih.pmp.pay.ordrstdto.d.BizStatusEnum;
import iih.pmp.pay.trade.d.TradeDO;
import iih.pmp.pay.trade.d.TradeStatusEnum;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import iih.pmp.pay.util.PmpPayAppUtils;
import iih.pmp.pay.util.WXPayAppUtils;
import iih.pmp.pay.util.WXParamUtils.WXCommonRntParamCode;
import iih.pmp.pay.util.wxerrorcode.WXUnifiedErrorCodeConst;
import iih.pmp.pay.web.pay.bp.WXPayLock;
import iih.pmp.pay.web.pay.bp.WXPayNotifyAppUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wxpay.sdk.WXPayConstants;
import wxpay.sdk.WXPayConstants.SignType;
import wxpay.sdk.WXPayUtil;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

@WebServlet("/WXPayNotifyHandle")
public class WXPayNotifyHandle extends HttpServlet  {
	
	
	PmpPayAppBaseUtils pmputils=new PmpPayAppBaseUtils();
	WXPayAppUtils utils=new WXPayAppUtils();
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();			
	}

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
		Map<String,String> r= WXPayUtil.xmlToMap(notityXml); 
		
		if(r!=null&&r.get(WXCommonRntParamCode.RETURN_CODE).equals(WXCommonRntParamCode.SUCCESS)&&WXPayUtil.isSignatureValid(r, PmpPayAppUtils.getWXConfig().getKey(), SignType.HMACSHA256)){
			//如果签名验证成功，则进行下一步操作
			String trade_no=r.get("out_trade_no");
			TradeDO[] tras=WXPayNotifyAppUtils.getTradeRService().find(TradeDO.TRADE_NO+"='"+trade_no+"'", "", FBoolean.FALSE);
			TradeDO tra=tras[0];
			OrdDO ord=WXPayNotifyAppUtils.getOrdRService().findById(tra.getId_ord());
			Object lockkey=WXPayLock.getInstance().getLockkeys(tra.getTrade_no());
			OrdReqDTO dto=new OrdReqDTO();
        	dto.setSd_chl(ord.getSd_chl());
        	dto.setOrd_no(ord.getOrd_no());
        	dto.setId_user_req(ord.getId_emp_op());
        	OrdQryRstDTO[] rst=ServiceFinder.find(IPmpPayOperatorService.class).pmpquery(dto);
			//加上数据锁
//			 synchronized(lockkey) {
//			//判断是否重复发通知
//			if (r.get(WXCommonRntParamCode.RETURN_CODE).equals(WXCommonRntParamCode.SUCCESS)) {
//				if (WXCommonRntParamCode.SUCCESS.equals(r.get(WXCommonRntParamCode.RESULT_CODE))) {
//					//判断是否是重复通知
//					if(!tra.getTrade_status().equals(TradeStatusEnum.PAY_SUCCESS)||!ord.getOrd_status().equals(OrdStatusEnum.PAID)){
//					FDouble fee=WXPayNotifyAppUtils.fenToYuan(r.get("total_fee"));
//					//判断金额是否相等
//					if(WXPayNotifyAppUtils.isFDoubleEq(fee, tra.getAmount())){
//					tra.setDt_finish(pmputils.getServerDateTime());
//					tra.setTrade_status(TradeStatusEnum.PAY_SUCCESS);
//					tra.setTrade_no_chl(r.get("transaction_id"));
//					ord.setDt_pay(pmputils.getServerDateTime());
//					ord.setOrd_status(OrdStatusEnum.PAID);
//					updateOrdAndTrade( tra, ord);
//					}
//					}
//					
//				} else {
//					//判断是否重复发通知
//					if(tra.getErr_code()==null||!r.get(WXCommonRntParamCode.ERR_CODE).equals(tra.getErr_code())){
//					tra.setTrade_status(WXUnifiedErrorCodeConst
//							.getTradeFailStatus(r.get(WXCommonRntParamCode.ERR_CODE)));
//					tra.setErr_code(r.get(WXCommonRntParamCode.ERR_CODE));
//					utils.setOrdState(tra, ord);
//					updateOrdAndTrade( tra, ord);
//					}
//				}				
//             
//			}
//		}
		}
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	private void updateOrdAndTrade(TradeDO tra,OrdDO ord) {
        try{
		tra.setStatus(DOStatus.UPDATED);
		pmputils.getTradeCUDService().update(
				new TradeDO[] { tra });

		ord.setStatus(DOStatus.UPDATED);
		pmputils.getOrdCudService().update(
				new OrdDO[] { ord });
		
        }catch(BizException e){
      	  e.printStackTrace();
        }
	}

}
