package iih.pmp.pay.udi;

import java.util.HashMap;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocRService;

public class PmpPayConst {
	

	/**
	 * 支付参数转换
	 */
	public final static String PMP_RESULT="pmpresult";//支付结果
	public final static String PMP_TRADE_STATUS="pmpstatus";//交易状态
	public final static String PMP_AMOUNT="pmpamount";//交易金额  以元为单位
	public final static String PMP_ERR_CODE="pmperrcode";//错误代码
	public final static String PMP_ERR_MSG="pmperrmsg";//错误信息
	public final static String PMP_TRADE_NO="pmptradeno";//交易号
	public final static String PMP_ORDER_NO="pmporderno";//订单号
	public final static String PMP_TRADE_CHL_NO="pmptradechlno";//渠道订单号
	public final static String PMP__CHL_CODE="pmpchlcode";//渠道编码
	public final static String PMP__QR_CODE="pmpqrcode";//二维码
	public final static String PMP__PREPAY_ID="pmpprepayid";//预支付id
	public final static String PMP__YX_PAYMODE="yx_pay_mode";//创新中心支付方式
	public final static String PMP_BANKNO = "pmp_bankno";//银行卡号
	
	public final static String PMP_SUCCESS="SUCCESS";//交易成功
	public final static String PMP_ERROR="ERROR";//交易失败
	public final static String PMP_USERPAYING="USERPAYING";//支付中
	public final static String PMP_UNKNOW="UNKNOW";//状态未知
	/**
	 * 订单或退款订单不存在错误码
	 * 支付查询或退款查询时，如果是订单不存在，请将pmp_err_code置为PMP_ORD_NOT_EXIST
	 */
	public final static String PMP_ORD_NOT_EXIST="pmp_ord_not_exist";//状态未知
	/**
	 * 支付宝渠道编码
	 */
	public final static String ALIPAY_CHANNEL_CODE="pay.ali.0001";
//	public final static String ALIPAY_CHANNEL_ID="0001Z8100000000N00NS";
	/**
	 * 微信渠道编码
	 */
	public final static String WXPAY_CHANNEL_CODE="pay.wx.0002";
//	public final static String WXPAY_CHANNEL_ID="0001Z8100000000N00NT";
	/**
	 * 民生银行渠道编码
	 */
	public final static String CMBC_CHANNEL_CODE="pay.cmbc.0003";
//	public final static String CMBC_CHANNEL_ID="0001Z81000000011OSXB";
	/**
	 * 医路通渠道编码
	 */
	public final static String YLT_CHANNEL_CODE="pay.YLT.0004";
//	public final static String CMBC_CHANNEL_ID="0001Z81000000011OSXB";
	
	public final static String PAY_PMP_CHANNEL_CODE="pay.pmp.0005";
	
	/**
	 * 业务场景
	 */
	
	/**
	 * 扫码支付
	 */
	public final static String SCANPAY_SCENE_CODE="NATIVE";
//	public final static String SCANPAY_SCENE_ID="0001Z8100000000N0LHK";
	/**
	 * 刷卡支付
	 */
	public final static String BARCODEPAY_SCENE_CODE="MICROPAY";
//	public final static String BARCODEPAY_SCENE_ID="0001Z8100000000N0LHN";
	/**
	 * 公众号支付
	 */
	public final static String PUBLICPAU_SCENE_CODE="JSAPI";
//	public final static String PUBLICPAU_SCENE_ID="0001Z8100000000N0LHJ";
	/**
	 * APP支付
	 */
	public final static String APPPAY_SCENE_CODE="APP";
//	public final static String APPPAY_SCENE_ID="0001Z8100000000N0LHL";
	/**
	 * H5支付
	 */
	public final static String H5PAY_SCENE_CODE="MWEB";
//	public final static String H5PAY_SCENE_ID="0001Z8100000000N0LHM";
	
	public final static String CHANNEL_DOCLIST_ID="@@@@TL4000000000013I";
	public final static String SCENE_DOCLIST_ID="@@@@TL40000000000140";
	public final static String BIZ_SCENE_DOCLIST_ID="@@@@BZ400000000001UY";
	
	/**
	 * 交易方向  -----支付
	 */
	public final static int TRADE_DIRECT_PAY=1;
	/**
	 * 交易方向------退款
	 */
	public final static int TRADE_DIRECT_REFUND=-1;
	
	
	/**
	 * 支付请求状态编码
	 */
	public static final int REQ_STATUS_CODE_ORDNEW = 10;
	public static final int REQ_STATUS_CODE_ORDFAIL = 12;
	public static final int REQ_STATUS_CODE_ORDUNKNOWN = 13;
	public static final int REQ_STATUS_CODE_ORDPAID = 14;
	public static final int REQ_STATUS_CODE_ORDWAIT = 15;
	
	/**
	 * 退款请求状态编码
	 */
	public static final int REQ_STATUS_CODE_REFUNDNEW = 16;
	public static final int REQ_STATUS_CODE_REFUNDFAIL = 17;
	public static final int REQ_STATUS_CODE_REFUNDUNKNOWN = 18;
	public static final int REQ_STATUS_CODE_REFUNDDONE = 19;
	
	/**
	 * 获取渠道id
	 * @param code
	 * @param doclist
	 * @return
	 */
	public static String getUdiID(String code,String doclist){
		if(code==null||doclist==null)return null;
		if(docmap.containsKey(code+doclist)){
			return docmap.get(code+doclist);
		}
		return null;
	}
	private static HashMap<String, String>docmap=setUdiIDs();
	static HashMap<String, String> setUdiIDs() {
		  HashMap<String, String> m=new HashMap<>();
		 IUdidocRService service=ServiceFinder.find(IUdidocRService.class);
		 UdidocDO[] udis=null;
		try {
			udis = service.find(" id_udidoclist in ('"+PmpPayConst.CHANNEL_DOCLIST_ID+"', '"+PmpPayConst.SCENE_DOCLIST_ID+"', '"+PmpPayConst.BIZ_SCENE_DOCLIST_ID+"')", null, FBoolean.FALSE);
		} catch (BizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 for (UdidocDO u : udis) {
			 m.put(u.getCode()+u.getId_udidoclist(), u.getId_udidoc());
		}
		 return m;
	}

}
