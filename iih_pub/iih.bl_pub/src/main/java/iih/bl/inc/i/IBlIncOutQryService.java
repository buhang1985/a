package iih.bl.inc.i;

import iih.bl.inc.blincquerydto.d.BlIncItmVsTypeDTO;
import iih.bl.inc.dto.d.RePrintInvoiceInfoDTO;
import iih.bl.inc.dto.incprint.d.BlIncPrintInfoDTO;
import iih.bl.inc.dto.incprint.d.BlIncPrintInfoItemDTO;
import iih.bl.st.dto.d.BlStIpPayInvoceInfoDTO;
import iih.bl.st.dto.d.BlStReFundBillDTO;
import xap.mw.core.data.BizException;

/**
 * 票据对外查询服务
 * @author yankan
 * @since 2017-06-26
 *
 */
public interface IBlIncOutQryService {

	/**
	 * 获取患者上次门诊发票信息
	 * @param patId 患者id
	 * @return
	 * @throws BizException
	 * @author ly 2018/04/04
	 */
	public abstract RePrintInvoiceInfoDTO[] getPatLastOpIncInfo(String patId) throws BizException;
	
	/**
	 * 获取患者门诊挂号发票信息
	 * @param patId
	 * @param incno
	 * @return
	 * @throws BizException
	 * @author ly 2018/04/04
	 */
	public abstract RePrintInvoiceInfoDTO getPatOpRegIncInfo(String patId,String incno) throws BizException;

	/**
	 * 获取票据包指定数量的可用发票号
	 * 从当前可用号开始
	 * @param incIssId 票据包id
	 * @param num 数量
	 * @return
	 * @throws BizException
	 */
	public abstract String[] getAvailableIncno(String incIssId, int num) throws BizException;

	/**
	 * 获取门诊未打印发票
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	public abstract BlIncPrintInfoDTO[] getNotPrintedIncInfo(String patId)throws BizException;

	/**
	 * 获取发票对应的服务明细
	 * @param incId
	 * @return
	 * @throws BizException
	 */
	public BlIncPrintInfoItemDTO[] getIncItmInfo(String incId) throws BizException;
	
	/**
	 * 获取门诊已有发票信息（不重新生成发票号）
	 * @param stId
	 * @return
	 * @throws BizException
	 * @author wq.li 2019年1月2日
	 */
	public BlIncItmVsTypeDTO[] getOpIncInfoByStId(String stId) throws BizException;
	/**
	 * 获取根据就诊id已有发票信息（不重新生成发票号）
	 * @param entId
	 * @return
	 * @throws BizException
	 * @author zhangxin 2019年4月30日
	 */
	public BlIncItmVsTypeDTO[] getOpIncInfoByEntId(String entId) throws BizException;
	
	/**
	 * 获取发票打印信息
	 * @param stId
	 * @return
	 * @throws BizException
	 * @date 2018年8月14日
	 * @author wq.li
	 */
	public abstract BlStIpPayInvoceInfoDTO GetIncIPInfo(String stId) throws BizException;
	
	/**
	 * 获取发票对应的服务明细
	 * @param incId
	 * @return
	 * @throws BizException
	 */
	public BlStReFundBillDTO[] getIncItm(String[] incOepIds) throws BizException;
}
