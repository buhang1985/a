package iih.pmp.yxpaySDK.bp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.cxf.common.util.Base64Exception;

import com.alibaba.fastjson.JSON;

import bsh.StringUtil;
import iih.bl.itf.dto.blthirdnowindcheckdto.d.BlThirdNOWindCheckDTO;
import iih.bl.itf.std.IBlPmpBalanceQryService;
import iih.pmp.pay.channelbillitem.i.IChannelbillitemRService;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import iih.pmp.pay.util.PmpPayToolUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

public class BusinessDataBp {
	PmpPayAppBaseUtils pmputils = new PmpPayAppBaseUtils();
	List<String> list;
	public List<HashMap<String, Object>> businessDataEncapsulation(String startDate, String endDate, String payType) throws BizException {
		 IBlPmpBalanceQryService iblPmpBalanceQryService = ServiceFinder.find(IBlPmpBalanceQryService.class);
		List<HashMap<String, Object>> dataList = new ArrayList<HashMap<String, Object>>();
		String[] pts=payType.split(",");
		StringBuilder sb=new StringBuilder();
		
		 list = new ArrayList<String>();
		 for (String s : pts) {
				list.add(s);
			}
	//		PmpWsLogUtils.info("支付平台入参bl：%s.",list.toString());
		 BlThirdNOWindCheckDTO[] blThirdNOWindCheckDTO = iblPmpBalanceQryService.CheckNoWindBill(startDate,endDate,list);
		
		if(blThirdNOWindCheckDTO!=null){
			for (BlThirdNOWindCheckDTO blThirdNO : blThirdNOWindCheckDTO) {
				HashMap<String, Object> tradeData = new HashMap<>();
				BigDecimal b=new BigDecimal(Double.toString(blThirdNO.getAmt().doubleValue()));
				b=b.multiply(new BigDecimal("100"));
				tradeData.put("amount", b.stripTrailingZeros().toPlainString());
				tradeData.put("payNum", valConvert(blThirdNO.getBankno()));
				tradeData.put("payOrderID", valConvert(blThirdNO.getOrd_no()));
				tradeData.put("payMode", getPayMode(valConvert(blThirdNO.getSd_pttp()),valConvert(blThirdNO.getCode_pm())));
				tradeData.put("payTime", valConvert(blThirdNO.getPay_time()));
				tradeData.put("patientID", valConvert(blThirdNO.getId_pat()));
				tradeData.put("patientName", valConvert(blThirdNO.getName_pat()));
				tradeData.put("payModeDesc", getPayModeDesc(valConvert(blThirdNO.getSd_pttp()),valConvert(blThirdNO.getCode_pm())));
				tradeData.put("typeDesc", valConvert(blThirdNO.getName_bizscene()));
				tradeData.put("typeFlag", valConvert(blThirdNO.getSd_bizscene()));
				tradeData.put("sourceCode", valConvert(blThirdNO.getSd_pttp()));
				tradeData.put("source", valConvert(blThirdNO.getName_pttp()));
				dataList.add(tradeData);
		//		PmpWsLogUtils.info("bl返回参数：%s.",tradeData.toString());
			}
		}
		
//		PmpWsLogUtils.info("bl出参：%s.",PmpPayToolUtils.m2json2(dataList));
		return dataList;
	}

	private String valConvert(Object o) {
		if (o == null) {
			return "";
		} else {
			return o + "";
		}
	}

	private String getPayMode(String tradetype, String terminalType) throws BizException {
		String swtype = "";
		if (tradetype != "" && terminalType != "") {
			swtype = tradetype + terminalType;
		} else {
			throw new BizException("转换参数不足！");
		}
		switch (swtype) {
		case "0211":
			return "231";
		case "0212":
			return "132";
		case "0202":
			return "暂无";
		case "0312":
			return "141";
		case "0411":
			return "暂无";
		case "0412":
			return "暂无";
		case "0402":
			return "暂无";
		case "0611":
			return "231";
		case "0612":
			return "141";
		case "0602":
			return "暂无";
		case "0111":
			return "241";
		case "0112":
			return "121";
		}
		return "";
	}
	
	private String getPayModeDesc(String tradetype, String terminalType) throws BizException {
		String swtype = "";
		if (tradetype != "" && terminalType != "") {
			swtype = tradetype + terminalType;
		} else {
			throw new BizException("转换参数不足！");
		}
		switch (swtype) {
		case "0211":
			return "支付宝扫码正扫";
		case "0212":
			return "微信扫码付正扫";
		case "0202":
			return "暂无";
		case "0312":
			return "微信公众号支付";
		case "0411":
			return "暂无";
		case "0412":
			return "暂无";
		case "0402":
			return "暂无";
		case "0611":
			return "处方支付";
		case "0612":
			return "处方支付";
		case "0602":
			return "暂无";
		case "0111":
			return "窗口支付宝反扫";
		case "0112":
			return "窗口微信反扫";
		}
		return "";
	}

}
