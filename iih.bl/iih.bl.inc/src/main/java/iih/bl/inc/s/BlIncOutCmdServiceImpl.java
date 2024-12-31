package iih.bl.inc.s;

import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.inc.blincip.d.BlincipAggDO;
import iih.bl.inc.blincoep.d.BlincoepAggDO;
import iih.bl.inc.blreinccgitmdto.d.BlReIncPageDTO;
import iih.bl.inc.bp.reinc.ReIncByCgItmBP;
import iih.bl.inc.dto.blincprint.d.BlIncPrintDTO;
import iih.bl.inc.i.IBlIncOutCmdService;
import iih.bl.inc.s.bp.ipinc.IpIncPrintInvioceBP;
import iih.bl.inc.s.bp.ipinc.IpIncSaveInvoiceBP;
import iih.bl.inc.s.bp.opinc.OpIncCalReduceAmtBP;
import iih.bl.inc.s.bp.opinc.OpIncCalReduceItmBP;
import iih.bl.inc.s.bp.opinc.OpIncPreSplitBP;
import iih.bl.inc.s.bp.opinc.OpIncPrintInvioceBP;
import iih.bl.inc.s.bp.opinc.OpIncReprintInvioceBP;
import iih.bl.inc.s.bp.opinc.OpIncSaveAndPrintInvoiceBP;
import iih.bl.inc.s.bp.opinc.OpIncSaveInvoiceBP;
import iih.bl.inc.s.bp.opinc.OpIncSaveRedInvoiceBP;
import iih.bl.st.blstip.d.BlStIpDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;

/**
 * 票据对外命令服务
 * @author ly 2018/03/29
 *
 */
public class BlIncOutCmdServiceImpl implements IBlIncOutCmdService{

	/**
	 * 保存门诊发票(门诊划价时)
	 * @param stDO 结算do
	 * @param cgAggDos 记账aggdo数组
	 * @return 发票数据
	 * @throws BizException
	 * @author ly 2018/03/27
	 */
	@Override
	public BlincoepAggDO[] saveOpInvoice(BlcgoepAggDO[] cgAggDos) throws BizException {
		OpIncSaveInvoiceBP bp = new OpIncSaveInvoiceBP();
		return bp.exec(cgAggDos);
	}
	
	/**
	 * 保存打印门诊发票(新版收费时) 
	 * @param cgAggDos 记账aggdo数组
	 * @param fgPrint 是否打印
	 * @return 发票数据
	 * @throws BizException
	 * @author ly 2018/12/08
	 */
	@Override
	public BlincoepAggDO[] saveAndPrintInvoice(BlcgoepAggDO[] cgAggDos, FBoolean fgPrint) throws BizException{
		OpIncSaveAndPrintInvoiceBP bp = new OpIncSaveAndPrintInvoiceBP();
		return bp.exec(cgAggDos, fgPrint);
	}
	
	/**
	 * 门诊记账数据预分票
	 * @param cgItmDos 记账明细
	 * @return 发票数据
	 * @throws BizException
	 * @author ly 2019/05/08
	 */
	@Override
	public BlincoepAggDO[] preSplitInvoice(BlCgItmOepDO[] cgItmDos) throws BizException{
		OpIncPreSplitBP bp = new OpIncPreSplitBP();
		return bp.exec(cgItmDos);
	}
	
	/**
	 * 门诊红冲发票保存(含打印)
	 * @param oldStId 原结算id
	 * @param redCgAggDos 红冲记账数据
	 * @param fgPrintInc 是否打印发票
	 * @return
	 * @throws BizException
	 * @author ly 2018/04/18
	 */
	@Override
	public BlincoepAggDO[] saveRedOpInvoice(String oldStId, BlcgoepAggDO[] redCgAggDos, FBoolean fgPrintInc) throws BizException{
		OpIncSaveRedInvoiceBP bp = new OpIncSaveRedInvoiceBP();
		return bp.exec(oldStId, redCgAggDos, fgPrintInc);
	}
	

	/**
	 * 门诊金额减免(发票账单项减免金额计算)
	 * @param stId 结算id
	 * @param freeAmt 减免金额
	 * @throws BizException
	 * @author ly 2018/03/27
	 */
	@Override
	public void calReduceOpAmt(String stId, FDouble freeAmt) throws BizException {
		OpIncCalReduceAmtBP bp = new OpIncCalReduceAmtBP();
		bp.exec(stId, freeAmt);
	}
	
	/**
	 * 门诊项目减免(发票账单项减免金额计算)
	 * @param stId 结算id
	 * @param cgItms 记账减免项目
	 * @throws BizException
	 */
	@Override
	public void calReduceOpItm(String stId,BlCgItmOepDO[] cgItms) throws BizException{
		OpIncCalReduceItmBP bp = new OpIncCalReduceItmBP();
		bp.exec(stId, cgItms);
	}
	
	/**
	 * 门诊发票打印
	 * @param stId 结算id数组
	 * @param printSet 打印配置
	 * @return
	 * @throws BizException
	 */
	@Override
	public BlincoepAggDO[] printOpInvoice(String[] stIds, BlIncPrintDTO printSet) throws BizException{
		OpIncPrintInvioceBP bp = new OpIncPrintInvioceBP();
		return bp.exec(stIds, printSet);
	}
	
	/**
	 * 门诊发票重打
	 * @param incIds 发票id数组
	 * @param printSet 打印配置
	 * @return
	 * @throws BizException
	 */
	@Override
	public BlincoepAggDO[] reprintOpInvoice(String[] incIds, BlIncPrintDTO printSet) throws BizException{
		OpIncReprintInvioceBP bp = new OpIncReprintInvioceBP();
		return bp.exec(incIds, printSet);
	}
	
	/**
	 * 保存住院发票(住院收付款时)
	 * 
	 * @param cgDos 记账数据
	 * @param freeAmt 减免金额
	 * @return 住院发票数据(分票时可能为多条)
	 * @throws BizException
	 * @author ly 2018/08/06
	 */
	@Override
	public BlincipAggDO[] saveIpInvoice(BlCgIpDO[] cgDos, FDouble freeAmt,BlStIpDO stDO) throws BizException {
		IpIncSaveInvoiceBP bp = new IpIncSaveInvoiceBP();
		return bp.exec(cgDos, freeAmt,stDO);
	}

	/**
	 * 住院发票打印
	 * 
	 * @param stIds
	 * @return
	 * @date 2018年8月13日
	 * @author wq.li
	 */
	public BlincipAggDO[] printIpInvoice(String[] stIds) throws BizException {
		IpIncPrintInvioceBP bp = new IpIncPrintInvioceBP();
		return bp.exec(stIds);
	}
	
	/**
	 * 保存门诊手工拆票
	 * @param cgAggDos 记账aggdo数组
	 * @param incPages 手工拆票分组
	 * @return 发票数据
	 * @throws BizException
	 * @author xb 2019/12/30
	 */
	@Override
	public BlincoepAggDO[] saveReInvoice(BlcgoepAggDO[] cgAggDos,BlReIncPageDTO[] incPages) throws BizException{
		OpIncSaveAndPrintInvoiceBP bp = new OpIncSaveAndPrintInvoiceBP();
		return bp.execReInc(cgAggDos, incPages);
	}
	
	/**
	 * 保存住院手工拆票
	 * @param cgAggDos 记账aggdo数组
	 * @param incPages 手工拆票分组
	 * @return 发票数据
	 * @throws BizException
	 * @author xb 2019/12/30
	 */
	@Override
	public BlincipAggDO[] saveIpReInvoice(BlStIpDO stDO, BlReIncPageDTO[] incPages) throws BizException
	{
		IpIncSaveInvoiceBP bp = new IpIncSaveInvoiceBP();
		return bp.execReInc(stDO, incPages);
	}
}
