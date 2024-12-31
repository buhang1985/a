package iih.pmp.pay.custom.i;

import java.util.List;
import java.util.Map;

import iih.pmp.pay.channelbillitem.d.ChlBillItemDO;
import iih.pmp.pay.ord.d.OrdDO;
import iih.pmp.pay.ordreqdto.d.OrdReqDTO;
import iih.pmp.pay.ordrstdto.d.OrdRstDTO;
import iih.pmp.pay.trade.d.TradeDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDouble;

public interface IPmpDataconvert {
	/**
	 * 反扫支付参数组装
	 * @param dto  请求dto
	 * @param ord  订单表
	 * @param tra  交易表
	 * @return
	 */
	Map<String,Object> getBarcodeParam(OrdReqDTO dto,OrdDO ord,TradeDO tra) throws BizException;
	/**
	 * 正扫支付参数组成
	 * @param dto
	 * @param ord
	 * @param tra
	 * @return
	 * @throws BizException
	 */
	Map<String,Object> getQRCODEParam(OrdReqDTO dto,OrdDO ord,TradeDO tra) throws BizException;
	/**
	 * 查询参数组装
	 * @param dto  请求dto
	 * @param ord  订单表
	 * @param tra  交易表
	 * @return
	 */
	Map<String,Object> getQueryParam(OrdDO ord,TradeDO tra) throws BizException;
	/**
	 * 退款查询参数组装
	 * @param dto  请求dto
	 * @param ord  订单表
	 * @param tra  交易表
	 * @param paidtra  支付交易
	 * @return
	 */
	Map<String,Object> getRefundQueryParam(OrdDO ord,TradeDO tra,TradeDO paidtra) throws BizException;
	/**
	 * 退款参数组装
	 * @param ord  订单表
	 * @param tra  交易表
	 * @param dto  请求dto
	 * @param paidtra  支付交易
	 * @return
	 */
	Map<String, Object> getReFundParam(OrdDO ord,TradeDO tra,OrdReqDTO dto,TradeDO paidtra) throws BizException;
	/**
	 * 支付返回参数转换
	 * @param rnt
	 * @return
	 * @throws BizException 
	 */
	Map<String, String> BarcodeRntConvert(Map<String, String> rnt) throws BizException;
	/**
	 * 正扫支付返回参数转换
	 * @param rnt
	 * @return
	 * @throws BizException
	 */
	Map<String, String> QrcodeRntConvert(Map<String, String> rnt) throws BizException;
	/**
	 * 查询返回参数转换
	 * @param rnt
	 * @return
	 * @throws BizException 
	 */
	Map<String, String> QueryRntConvert(Map<String, String> rnt) throws BizException;
	/**
	 * 退款查询返回参数转换
	 * @param rnt
	 * @return
	 * @throws BizException 
	 */
	Map<String, String> RefundQueryRntConvert(Map<String, String> rnt) throws BizException;
	/**
	 * 退款返回参数转换
	 * @param rnt
	 * @return
	 * @throws BizException 
	 */
	Map<String, String> RefundRntConvert(Map<String, String> rnt) throws BizException;
	/**
	 *写入交易表、订单表、返回结果数据集
	 * @param t
	 * @param m
	 * @param fee
	 * @param rnt
	 */
	void setTradeVal(TradeDO t,Map<String, String> m,FDouble fee, OrdRstDTO rnt)throws BizException;
	/**
	 * 字符串转对账do
	 * @param str
	 * @param sd_chl
	 * @param dt
	 * @param map
	 * @return
	 */
	ChlBillItemDO str2BillItem(String str,String sd_chl,FDate dt,Map<String,Object> map)throws BizException;
	/**
	 * 获取对账参数
	 * @param dt
	 * @return
	 */
	List<Map<String,Object>> getBillItemParam(FDate dt)throws BizException;
	
    /**
     * 获取渠道编码
     * @return
     */
    String getChlCode();
}
