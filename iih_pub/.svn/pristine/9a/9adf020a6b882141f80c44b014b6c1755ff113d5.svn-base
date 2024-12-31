package iih.pmp.pay.custom.i;

import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDate;

public interface IPmpSdk {
	
	/**
	 * 反扫支付
	 * @param map
	 * @return
	 */
	Map<String,String> doScanPay(Map<String,Object> map)throws BizException;
	/**
	 * 正扫支付
	 * @param map
	 * @return
	 * @throws BizException
	 */
	Map<String,String> doQRCODEPay(Map<String,Object> map)throws BizException;
	/**
	 * 查询
	 * @param map
	 * @return
	 */
	Map<String,String> doQuery(Map<String,Object> map)throws BizException;
	/**
	 * 订单撤销
	 * @param map
	 * @return
	 */
	Map<String,String> reverse(Map<String,Object> map)throws BizException;
	/**
	 * 退款
	 * @param map
	 * @return
	 */
	Map<String,String> refund(Map<String,Object> map)throws BizException;
	/**
	 * 退款查询
	 * @param map
	 * @return
	 */
	Map<String,String> dorefundquery(Map<String,Object> map)throws BizException; 
	/**
	 * 日终业务总账对账
	 * @param map
	 * @return
	 */
	 Map<String,String> GetCheckLedgerInfo(Map<String,Object> map)throws BizException;
	 /**
	  * 对账单明细下载
	  * @param map
	  * @return
	  */
	 Map<String,String> downloadfile(Map<String,Object> map)throws BizException;
     /**
      * 获取账单明细  转成字符串格式
      * @param dt
      * @return
      */
     String[] getBillContent(Map<String, Object> map) throws BizException;
     /**
      * 获取渠道编码
      * @return
      */
     String getChlCode();
	 
}
