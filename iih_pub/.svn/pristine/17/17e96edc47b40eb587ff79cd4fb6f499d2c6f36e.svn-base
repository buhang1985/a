package iih.bl.cg.i;

import java.text.ParseException;

import iih.bl.cg.api.d.AlipayPayInfo;
import iih.bl.cg.api.d.InsPresInfo;
import iih.bl.cg.api.d.OpPayInfo;
import iih.bl.cg.api.d.OpPayParam;
import iih.bl.cg.api.d.OpPayReturn;
import iih.bl.cg.api.d.PresInfo;
import iih.bl.cg.api.d.RechargeInfo;
import iih.bl.cg.api.d.PrepayTradeRecord;
import iih.bl.cg.api.d.RechargeResult;
import iih.bl.cg.api.d.UnpaidInfo;
import iih.bl.cg.api.d.WeChatPayInfo;
import xap.mw.core.data.BizException;

/**
 * 门诊结算对外服务
 * 
 * (试用于IIH外部系统)
 * 
 * @author yankan
 * @since 2017-06-19
 *
 */
public interface IBlOpCgExternalService {
	/**
	 * 获取检查检验处方信息
	 * 
	 * @param patCode 患者编码
	 * @param opTimes 门诊就诊次数
	 * @param applyNos 申请单号集合
	 * @return
	 * @throws BizException
	 */
	public abstract InsPresInfo[] getInsPresInfo(String patCode,Integer opTimes, String[] applyNos) throws BizException;

	/**
	 * 获取未缴费列表
	 * 
	 * @param patCode 患者编码
	 * @param patType 患者类型
	 * @param beginDateTime 开始日期，格式：yyyy-MM-dd HH:mm:ss 如2017-06-01 13:24:23
	 * @param endDateTime 结束日期，格式：yyyy-MM-dd HH:mm:ss 如2017-06-01 13:24:23
	 * @return
	 * @throws BizException
	 * @throws ParseException
	 */
	public abstract UnpaidInfo[] getUnpaidInfos(String patCode, String patType, String beginDateTime, String endDateTime) throws BizException;

	/**
	 * 获取取药窗口号
	 * 
	 * @param patCode 患者编码
	 * @param stCode 结算号
	 * @return 返回取药窗口信息。如果多张处方的的取药窗口不同，则按照规则拼接。 注：北大国际医院规则是使用1个逗号 + 1个空格做分隔符
	 * @throws BizException
	 */
	public abstract String getDrugWindowsNo(String patCode, String stCode)
			throws BizException;

	/**
	 * 获取微信缴费信息
	 * 
	 * @param beginDateTime 开始日期（收款日期），格式：yyyy-MM-dd HH:mm:ss，如2017-06-01 13:24:23
	 * @param endDateTime 结束日期（收款日期），格式：yyyy-MM-dd HH:mm:ss，如2017-06-01 13:24:23
	 * @return
	 * @throws BizException
	 */
	public abstract WeChatPayInfo[] getWeChatPayInfos(String beginDateTime,String endDateTime) throws BizException;

	/**
	 * 获取支付宝缴费信息
	 * 
	 * @param beginDateTime 开始日期（收款日期），格式：yyyy-MM-dd HH:mm:ss，如2017-06-01 13:24:23
	 * @param endDateTime 结束日期（收款日期），格式：yyyy-MM-dd HH:mm:ss，如2017-06-01 13:24:23
	 * @return
	 * @throws BizException
	 */
	public abstract AlipayPayInfo[] getAlipayPayInfos(String beginDateTime,String endDateTime) throws BizException;

	/**
	 * 获取门诊缴费列表
	 * 
	 * @param patCode 患者编码
	 * @param beginDateTime 开始日期（收款日期），格式：yyyy-MM-dd HH:mm:ss，如2017-06-01 13:24:23
	 * @param endDateTime 结束日期（收款日期），格式：yyyy-MM-dd HH:mm:ss，如2017-06-01 13:24:23
	 * @return
	 * @throws BizException
	 */
	public abstract OpPayInfo[] getOpPayInfos(String patCode,String beginDateTime, String endDateTime) throws BizException;

	/**
	 * 门诊患者缴费
	 * 
	 * @param param 门诊付款信息
	 * @return OpPayReturn.code 成功返回0，失败返回1 OpPayReturn.result (返回错误信息
	 *         场景1，需付费处方不存在应返回错误信息：病人无交费记录！ 场景2，支付金额错误应返回错误信息：输入金额错误！
	 *         场景3，第三方支付订单号重复应返回错误信息：该订单号无效！ 场景4，成功缴费应返回信息：操作成功！)
	 */
	public abstract OpPayReturn pay(OpPayParam param) throws BizException;
}
