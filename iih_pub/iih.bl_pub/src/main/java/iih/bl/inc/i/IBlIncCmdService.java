package iih.bl.inc.i;

import iih.bl.inc.blecincprint.d.BlEcSwithPaperInDTO;
import iih.bl.inc.blecincprint.d.BlEcSwithPaperOutDTO;
import iih.bl.inc.blincoep.d.BlincoepAggDO;
import iih.bl.inc.blreinccgitmdto.d.BlReIncPageDTO;
import iih.bl.inc.dto.blinctf.d.BlIncTfCondDTO;
import iih.bl.st.dto.d.BlStIpPayInvoceInfoDTO;
import xap.mw.core.data.BizException;

/**
 * 票据命令服务
 * @author yankan
 * @since 2017-06-15
 *
 */
public interface IBlIncCmdService {
	
	/**
	 * 重打发票操作
	 * @Title: ReprintInc   
	 * @Description: TODO  
	 * @param blincIpDo
	 * @return
	 * @throws BizException      
	 * @return: BlStIpPayInvoceInfoDTO 
	 * @author: wq.li     
	 * @throws
	 */
	public abstract BlStIpPayInvoceInfoDTO ReprintInc(String incId) throws BizException;

	/**
	 * 票据领用转移
	 * @param cond 转移条件
	 * @throws BizException
	 * @author ly 2019/02/19
	 */
	public abstract void incTransfer(BlIncTfCondDTO cond) throws BizException;
	
	/**
	 * 票据领用转移撤销
	 * @param cond 撤销条件
	 * @throws BizException
	 * @author ly 2019/02/19
	 */
	public abstract void incTransferRevoke(BlIncTfCondDTO cond) throws BizException;
	
	/**
	 * 电子发票异常记录处理
	 * @param transIds
	 * @throws BizException
	 * @author ly 2019/12/24
	 */
	public abstract void ecincTransEcptDeal(String[] transIds) throws BizException;
	
	/**
	 * 重拆票门诊
	 * @param pages
	 * @throws BizException
	 */
	public abstract String reInc(BlReIncPageDTO[] pages) throws BizException;
	
	/**
	 * 重拆票住院
	 * @param pages
	 * @return
	 * @throws BizException
	 */
	public abstract String reIncIp(BlReIncPageDTO[] pages) throws BizException;
	
	/**
	 * 查询住院重拆票之后可打印数据
	 * @param strIdStIp
	 * @return
	 * @throws BizException
	 */
	public abstract BlStIpPayInvoceInfoDTO[] FindIncIp(String strIdStIp) throws BizException;
	
	/**
	 * 电子发票换开纸质发票(门诊)
	 * @param dto
	 * @return
	 * @throws BizException
	 * @author ly 2020/01/06
	 */
	public abstract BlEcSwithPaperOutDTO ecIncSwitchPaperOp(BlEcSwithPaperInDTO dto) throws BizException;

	/**
	 * 电子发票打印纸质发票后回写数据(门诊)
	 * @param dto
	 * @throws BizException
	 * @author ly 2020/01/06
	 */
	public abstract void ecIncWriteBackPaperOp(BlEcSwithPaperInDTO dto) throws BizException;
	
	/**
	 * 电子发票换开纸质发票(住院)
	 * @param dto
	 * @return
	 * @throws BizException
	 * @author ly 2020/01/06
	 */
	public abstract BlEcSwithPaperOutDTO ecIncSwitchPaperIp(BlEcSwithPaperInDTO dto) throws BizException;

	/**
	 * 未打印发票转换为电子发票(门诊)
	 * @param stIds
	 * @return
	 * @throws BizException
	 * @author ly 2020/01/10
	 */
	public abstract BlincoepAggDO[] changeNotPirntIncToEcIncOp(String[] stIds) throws BizException;
}
