package iih.bl.inc.i;

import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.inc.blincip.d.BlincipAggDO;
import iih.bl.inc.blincoep.d.BlincoepAggDO;
import iih.bl.inc.blreinccgitmdto.d.BlReIncCgItmDTO;
import iih.bl.inc.blreinccgitmdto.d.BlReIncPageDTO;
import iih.bl.inc.dto.blincprint.d.BlIncPrintDTO;
import iih.bl.st.blstip.d.BlStIpDO;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.dto.d.BlStOepVsIncDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;

/**
 * 票据对外命令服务
 * @author ly 2018/03/29
 *
 */
public interface IBlIncOutCmdService {

	/**
	 * 保存门诊发票(门诊划价时)
	 * @param stDO 结算do
	 * @param cgAggDos 记账aggdo数组
	 * @return 发票数据
	 * @throws BizException
	 * @author ly 2018/03/27
	 */
	public abstract BlincoepAggDO[] saveOpInvoice(BlcgoepAggDO[] cgAggDos) throws BizException;
	
	/**
	 * 保存打印门诊发票(新版收费时) 
	 * @param cgAggDos 记账aggdo数组
	 * @param fgPrint 是否打印发票
	 * @return 发票数据
	 * @throws BizException
	 * @author ly 2018/12/08
	 */
	public abstract BlincoepAggDO[] saveAndPrintInvoice(BlcgoepAggDO[] cgAggDos,FBoolean fgPrint) throws BizException;
	
	/**
	 * 记账数据预分票逻辑
	 * @param cgItmDos 记账明细
	 * @return 发票数据
	 * @throws BizException
	 * @author ly 2019/05/08
	 */
	public abstract BlincoepAggDO[] preSplitInvoice(BlCgItmOepDO[] cgItmDos) throws BizException;
	
	/**
	 * 门诊红冲发票保存(含打印)
	 * @param oldStId 原结算id
	 * @param redCgAggDos 红冲记账数据
	 * @param fgPrintInc 是否打印发票
	 * @return
	 * @throws BizException
	 * @author ly 2018/04/18
	 */
	public abstract BlincoepAggDO[] saveRedOpInvoice(String oldStId, BlcgoepAggDO[] redCgAggDos, FBoolean fgPrintInc) throws BizException;
	
	/**
	 * 门诊金额减免(发票账单项减免金额计算)
	 * @param stId 结算id
	 * @param freeAmt 减免金额
	 * @throws BizException
	 * @author ly 2018/03/27
	 */
	public abstract void calReduceOpAmt(String stId,FDouble freeAmt) throws BizException;
	
	/**
	 * 门诊项目减免(发票账单项减免金额计算)
	 * @param stId 结算id
	 * @param cgItms 记账减免项目
	 * @throws BizException
	 */
	public abstract void calReduceOpItm(String stId,BlCgItmOepDO[] cgItms) throws BizException;
	
	/**
	 * 门诊发票打印
	 * @param stIds 结算id数组
	 * @param printSet 打印配置
	 * @return
	 * @throws BizException
	 */
	public abstract BlincoepAggDO[] printOpInvoice(String[] stIds, BlIncPrintDTO printSet) throws BizException;
	
	/**
	 * 门诊发票重打
	 * @param incIds 发票id数组
	 * @param printSet 打印配置
	 * @return
	 * @throws BizException
	 */
	public abstract BlincoepAggDO[] reprintOpInvoice(String[] incIds, BlIncPrintDTO printSet) throws BizException;

	/**
	 * 保存住院发票(住院收付款时)
	 * @param cgDos 记账数据
	 * @param freeAmt 减免金额
	 * @return 住院发票数据(分票时可能为多条)
	 * @throws BizException
	 * @author ly 2018/08/06
	 */
	public abstract BlincipAggDO[] saveIpInvoice(BlCgIpDO[] cgDos,FDouble freeAmt,BlStIpDO stDO) throws BizException;
	
	/**
	 * 住院发票打印
	 * @param stIds
	 * @return
	 * @date 2018年8月13日
	 * @author wq.li
	 */
	public BlincipAggDO[] printIpInvoice(String[] stIds) throws BizException;
	
	/**
	 * 保存门诊手工拆票
	 * @param cgAggDos 记账aggdo数组
	 * @param incPages 手工拆票分组
	 * @return 发票数据
	 * @throws BizException
	 * @author xb 2019/12/30
	 */
	public abstract BlincoepAggDO[] saveReInvoice(BlcgoepAggDO[] cgAggDos,BlReIncPageDTO[] incPages) throws BizException;
	
	
	/**
	 * 保存住院手工拆票
	 * @param cgAggDos 记账aggdo数组
	 * @param incPages 手工拆票分组
	 * @return 发票数据
	 * @throws BizException
	 * @author xb 2019/12/30
	 */
	public abstract BlincipAggDO[] saveIpReInvoice(BlStIpDO stDO, BlReIncPageDTO[] incPages) throws BizException;

}
