package iih.bl.inc.i;

import iih.bl.inc.blinciss.d.BlIncIssDO;
import xap.mw.core.data.BizException;

/**
 * 票据工具类服务
 * @author ly 2018/05/19
 *
 */
public interface IBlIncUtilService {

	/**
	 * 获取当前票据号
	 * @param empId 人员id
	 * @param hostId PCid
	 * @param inccaId 票据分类id
	 * @return 当前票据号
	 * @throws BizException
	 * @author ly 2018/05/19
	 */
	public abstract String getCurInvoiceNo(String empId,String hostId,String inccaId) throws BizException;
	
	/**
	 * 获取当前票票据号
	 * @param empId 人员id
	 * @param hostId PCid
	 * @param inccaId 票据分类id
	 * @param num 数量
	 * @return 当票据号
	 * @throws BizException
	 * @author ly 2018/07/28
	 */
	public abstract String[] getCurInvoiceNoMany(String empId, String hostId, String inccaId,Integer num) throws BizException;
	
	/**
	 * 获取当前票据DO
	 * @param empId 人员id
	 * @param hostId PCid
	 * @param inccaId 票据分类id
	 * @return 票据DO
	 * @throws BizException
	 * @author ly 2018/07/04
	 */
	public abstract BlIncIssDO getCurInvoiceDO(String empId,String hostId,String inccaId) throws BizException;
	
	/**
	 * 获取当前窗口类型的票据DO
	 * @description:
	 * @author:hanjq  2020年6月23日
	 * @param empId
	 * @param hostId
	 * @param inccaId
	 * @param sdPttp
	 * @return
	 * @throws BizException
	 */
	public abstract BlIncIssDO getCurInvoiceDOBySdPttp(String empId,String hostId,String inccaId,String sdPttp) throws BizException;
	
	/**
	 * 票据包过号
	 * @param empId 人员id
	 * @param hostId PCid
	 * @param inccaId 票据分类id
	 * @throws BizException
	 * @return 过号后的当前号
	 * @author ly 2018/05/19
	 */
	public abstract String nextInvoiceNo(String empId,String hostId,String inccaId) throws BizException;
	
	/**
	 * 票据包过号(窗口类型-床旁结算)
	 * @description:
	 * @author:hanjq  2020年6月23日
	 * @param empId
	 * @param hostId
	 * @param inccaId
	 * @return
	 * @throws BizException
	 */
	public abstract String nextInvoiceNoBySdPttp(String empId,String hostId,String inccaId,String stPttp) throws BizException;
	/**
	 * 票据包过号
	 * @param empId 人员id
	 * @param hostId PCid
	 * @param inccaId 票据分类id
	 * @throws BizException
	 * @return 过号前的当前号
	 * @author ly 2018/05/23
	 */
	public abstract String nextInvoiceNoPre(String empOrPcId,String hostId,String inccaId) throws BizException;

	/**
	 * 票据包过号
	 * (用于批量获取票号时过号)
	 * @param incIss 票据包信息
	 * @param lastNo 最后使用号码
	 * @return 过号后的当前号
	 * @throws BizException
	 * @author ly 2018/07/28
	 */
	public abstract String nextInvoiceNoByNo(BlIncIssDO incIss, String lastNo) throws BizException;
	
	/**
	 * 票据包过多个号
	 * @param empId 人员id
	 * @param hostId PCid
	 * @param inccaId 票据分类id
	 * @param num 数量
	 * @throws BizException
	 * @return 过号后的当前号
	 * @author ly 2018/07/28
	 */
	public abstract String nextInvoiceMany(String empId, String hostId, String inccaId, Integer num) throws BizException;

	/**
	 * 获取门诊挂号当前票据号
	 * @param empId
	 * @param hostId
	 * @return
	 * @throws BizException
	 * @author ly 2019/11/01
	 */
	public abstract String getOepRegCurInvoiceNo(String empId, String hostId) throws BizException;

	/**
	 * 获取门诊挂号当前发票信息
	 * @param empId
	 * @param hostId
	 * @return
	 * @throws BizException
	 * @author ly 2019/11/01
	 */
	public abstract BlIncIssDO getOepRegCurInvoiceDO(String empId, String hostId) throws BizException;
}
