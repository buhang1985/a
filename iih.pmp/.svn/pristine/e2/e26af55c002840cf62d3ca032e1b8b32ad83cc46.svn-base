package iih.pmp.yxpaySDK.s;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.alibaba.fastjson.JSON;

import iih.pmp.pay.util.PmpPayAppBaseUtils;
import iih.pmp.pay.util.PmpPayToolUtils;
import iih.pmp.pay.utils.PmpAliPayLogUtils;
import iih.pmp.pay.yx.billcheck.i.IYXBillCheckWSService;
import iih.pmp.yxpaySDK.bp.BusinessDataBp;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FDate;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapListHandler;

@Service(serviceInterfaces = { IYXBillCheckWSService.class }, binding = Binding.WS)
public class YXBillCheckWSServiceImpl implements IYXBillCheckWSService{
	PmpPayAppBaseUtils pmputils=new PmpPayAppBaseUtils();
	@Override
	public String getPayInfos(String startDate,String endDate,String payType) throws BizException {
		// TODO Auto-generated method stub
		//FDate start=new FDate(startDate);
		//FDate end=new FDate(endDate);
		BusinessDataBp Bp= new BusinessDataBp();
		//String[] pts=payType.split(",");
		//StringBuilder sb=new StringBuilder();
		//for (String s : pts) {
		//	if(sb.length()==0) {			
		//		sb.append("'"+s.trim()+"'");
		//	}else {
		//		sb.append(",'"+s.trim()+"'");
		//	}
		//}
		//String sql=" select a.*,b.id_pat,b.sd_bizscene,c.name patname,c.code patcode,d.name bizname,e.name priname,e.code pricode from pmp_trade a "
		//		+ " left join pmp_ord b on a.id_ord=b.id_ord "
		//		+ " left join pi_pat c on b.id_pat=c.id_pat left join bd_udidoc d on b.id_bizscene=d.id_udidoc "
		//		+ " left join bd_pri_pm e on b.id_pri_pm=e.id_pm "
		//		+ " where  "+pmputils.getTimeSpanSql2("a.dt_req", start, end)+" and  a.paymode in ("+sb.toString()+")"
		//				+ " and (a.trade_status=4 or a.trade_status=1)";
		//DAFacade da=new DAFacade();
		//Object result=da.execQuery(sql,  new MapListHandler());
		List<HashMap<String, Object>> res=new ArrayList<HashMap<String, Object>>();
		
		//if(result!=null){
		//	List<HashMap<String, Object>> b=(List<HashMap<String, Object>>)result;
		//	for (HashMap<String, Object> m : b) {
		//		HashMap<String, Object> o=new HashMap<>();
		//		String eu=m.get("trade_status")+"";
        //        if("1".equals(eu))
		//		o.put("amount", pmputils.Yuan2Fen2(m.get("amount").toString()));
        //        else if("4".equals(eu)){
        //        	o.put("amount", "-"+pmputils.Yuan2Fen2(m.get("amount").toString()));
        //        }else {
        //        	o.put("amount", "");
        //        }
		//		o.put("payNum", valConvert(m.get("bankorderno")));
		//		o.put("payOrderID", valConvert(m.get("trade_no_chl")));
		//		o.put("payMode", valConvert(m.get("paymode")));
		//		o.put("payTime", valConvert(m.get("dt_req")));
		//		o.put("patientID", valConvert(m.get("patcode")));
		//		o.put("patientName", valConvert(m.get("patname")));
		//		o.put("payModeDesc", getPayModeDesc(m.get("tradetype")+""));
		//		o.put("typeDesc",valConvert(m.get("bizname")));
		//		o.put("typeFlag", valConvert(m.get("sd_bizscene")));
		//		o.put("sourceCode", valConvert(m.get("pricode")));
		//		o.put("source", valConvert(m.get("priname")));
		//		res.add(o);
		//	}
			
			List<HashMap<String, Object>> blList = Bp.businessDataEncapsulation(startDate, endDate, payType);
			if(blList!=null){
				res.addAll(blList);
			}
		//}
		if(res!=null){
			return PmpPayToolUtils.m2json2(res);
		}else{
			return null;
		}
		
	}
	
	private String getPayModeDesc(String tradetype) {
		if("API_WXSCAN".equals(tradetype)) {
			return "窗口微信反扫";
		}else if("API_ZFBSCAN".equals(tradetype)){
			return "窗口支付宝反扫";
		}
		return "";
	}
	
	private String valConvert(Object o) {
		if(o==null) {
			return "";
		}else {
			return o+"";
		}
	}

	@Override
	public String writePublicPayInfos(String data) throws BizException {
		// TODO Auto-generated method stub		
		return null;
	}

	@Override
	public String writeRefundInfos(String data) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
