package iih.bl.inc.s;

import iih.bl.inc.blecincprint.d.BlEcSwithPaperInDTO;
import iih.bl.inc.blecincprint.d.BlEcSwithPaperOutDTO;
import iih.bl.inc.blincoep.d.BlincoepAggDO;
import iih.bl.inc.blreinccgitmdto.d.BlReIncPageDTO;
import iih.bl.inc.bp.reinc.ReIncByCgItmBP;
import iih.bl.inc.dto.blinctf.d.BlIncTfCondDTO;
import iih.bl.inc.i.IBlIncCmdService;
import iih.bl.inc.s.bp.IncTransferBP;
import iih.bl.inc.s.bp.IncTransferRevokeBP;
import iih.bl.inc.s.bp.ecinc.BlEcIncChangeNotPirntIncToEcOpBP;
import iih.bl.inc.s.bp.ecinc.BlEcIncSwitchPaperIpBP;
import iih.bl.inc.s.bp.ecinc.BlEcIncSwitchPaperOpBP;
import iih.bl.inc.s.bp.ecinc.BlEcIncWriteBackPaperOpBP;
import iih.bl.inc.s.bp.ecinc.BlEcincTransEcptDealBP;
import iih.bl.inc.s.oldbp.ReprintIpIncBp;
import iih.bl.st.dto.d.BlStIpPayInvoceInfoDTO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

/**
 * 票据命令服务
 * @author yankan
 * @since 2017-06-15
 *
 */
@Service(serviceInterfaces={IBlIncCmdService.class}, binding=Binding.JSONRPC)
public class BlIncCmdServiceImpl implements IBlIncCmdService	{

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
	@Override
	public BlStIpPayInvoceInfoDTO ReprintInc(String incId) throws BizException {
		// TODO Auto-generated method stub
		ReprintIpIncBp bp=new ReprintIpIncBp();
		return bp.exec(incId);
	}
   /**
    * 发票票据转移
    * @author  houll
    * @throws BizException
    */
	@Override
	public void incTransfer(BlIncTfCondDTO cond) throws BizException {
		IncTransferBP bp=new IncTransferBP();
		 bp.exec(cond);
		
	}
	/**
	 * 撤销发票票据转移
	 */

	@Override
	public void incTransferRevoke(BlIncTfCondDTO cond) throws BizException {
		IncTransferRevokeBP bp=new IncTransferRevokeBP();
		bp.exec(cond);
	}
	
	/**
	 * 电子发票异常记录处理
	 * @param transIds
	 * @throws BizException
	 * @author ly 2019/12/24
	 */
	@Override
	public void ecincTransEcptDeal(String[] transIds) throws BizException{
		BlEcincTransEcptDealBP bp = new BlEcincTransEcptDealBP();
		bp.exec(transIds);
	}
	
	@Override
	public String reInc(BlReIncPageDTO[] pages) throws BizException {
		ReIncByCgItmBP bp = new ReIncByCgItmBP();
		return bp.exec(pages);
	}	
	
	@Override
	public String reIncIp(BlReIncPageDTO[] pages) throws BizException{
		ReIncByCgItmBP bp = new ReIncByCgItmBP();
		return bp.execIp(pages);
	}
	
	@Override
	public BlStIpPayInvoceInfoDTO[] FindIncIp(String strIdStIp) throws BizException
	{
		ReprintIpIncBp bp=new ReprintIpIncBp();
		return bp.findReIncIp(strIdStIp);
	}

	/**
	 * 电子发票换开纸质发票
	 * @param dto
	 * @return
	 * @throws BizException
	 * @author ly 2020/01/06
	 */
	@Override
	public BlEcSwithPaperOutDTO ecIncSwitchPaperOp(BlEcSwithPaperInDTO dto) throws BizException{
		BlEcIncSwitchPaperOpBP bp = new BlEcIncSwitchPaperOpBP();
		return bp.exec(dto);
	}
	
	/**
	 * 电子发票打印纸质发票后回写数据(门诊)
	 * @param dto
	 * @throws BizException
	 * @author ly 2020/01/06
	 */
	@Override
	public void ecIncWriteBackPaperOp(BlEcSwithPaperInDTO dto) throws BizException{
		BlEcIncWriteBackPaperOpBP bp = new BlEcIncWriteBackPaperOpBP();
		bp.exec(dto);
	}
	
	/**
	 * 电子发票换开纸质发票
	 * @param dto
	 * @return
	 * @throws BizException
	 * @author ly 2020/01/06
	 */
	@Override
	public BlEcSwithPaperOutDTO ecIncSwitchPaperIp(BlEcSwithPaperInDTO dto) throws BizException{
		BlEcIncSwitchPaperIpBP bp = new BlEcIncSwitchPaperIpBP();
		return bp.exec(dto);
	}
	
	/**
	 * 未打印发票转换为电子发票(门诊)
	 * @param stIds
	 * @return
	 * @throws BizException
	 * @author ly 2020/01/10
	 */
	@Override
	public BlincoepAggDO[] changeNotPirntIncToEcIncOp(String[] stIds) throws BizException{
		BlEcIncChangeNotPirntIncToEcOpBP bp = new BlEcIncChangeNotPirntIncToEcOpBP();
		return bp.exec(stIds);
	}
}
