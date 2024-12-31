package iih.bl.inc.s;

import iih.bl.inc.blinciss.d.BlIncIssDO;
import iih.bl.inc.i.IBlIncUtilService;
import iih.bl.inc.s.bp.inc.GetCurInvoiceDOBP;
import iih.bl.inc.s.bp.inc.GetCurInvoiceNoBP;
import iih.bl.inc.s.bp.inc.GetCurInvoiceNoManyBP;
import iih.bl.inc.s.bp.inc.NextInvoiceManyBP;
import iih.bl.inc.s.bp.inc.NextInvoiceNoByNoBP;
import iih.bl.inc.s.bp.inc.NextInvoiceNoNewBP;
import iih.bl.inc.s.bp.inc.NextInvoiceNoOldBP;
import iih.bl.inc.s.bp.opinc.GetOepRegCurInvoiceDOBP;
import iih.bl.inc.s.bp.opinc.GetOepRegCurInvoiceNoBP;
import xap.mw.core.data.BizException;

/**
 * 票据工具类服务
 * 
 * @author ly 2018/05/19
 *
 */
public class BlIncUtilServiceImpl implements IBlIncUtilService {

	/**
	 * 获取当前票据号
	 * @param empId 人员id
	 * @param hostId PCid
	 * @param inccaId 票据分类id
	 * @return
	 * @throws BizException
	 * @author ly 2018/05/19
	 */
	@Override
	public String getCurInvoiceNo(String empId, String hostId, String inccaId) throws BizException {
		GetCurInvoiceNoBP bp = new GetCurInvoiceNoBP();
		return bp.exec(empId, hostId, inccaId);
	}
	
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
	@Override
	public String[] getCurInvoiceNoMany(String empId, String hostId, String inccaId,Integer num) throws BizException{
		GetCurInvoiceNoManyBP bp = new GetCurInvoiceNoManyBP();
		return bp.exec(empId, hostId, inccaId, num);
	}
	
	/**
	 * 获取当前票据DO
	 * @param empId 人员id
	 * @param hostId PCid
	 * @param inccaId 票据分类id
	 * @return 票据DO
	 * @throws BizException
	 * @author ly 2018/07/04
	 */
	@Override
	public BlIncIssDO getCurInvoiceDO(String empId,String hostId,String inccaId) throws BizException{
		GetCurInvoiceDOBP bp = new GetCurInvoiceDOBP();
		return bp.exec(empId, hostId, inccaId);
	}

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
	@Override
	public BlIncIssDO getCurInvoiceDOBySdPttp(String empId, String hostId, String inccaId, String sdPttp) throws BizException {
		GetCurInvoiceDOBP bp = new GetCurInvoiceDOBP();
		return bp.exec(empId, hostId, inccaId,sdPttp);
	}
	
	/**
	 * 票据包过号
	 * @param empId 人员id
	 * @param hostId PCid
	 * @param inccaId 票据分类id
	 * @throws BizException
	 * @return 过号后的当前号
	 * @author ly 2018/05/19
	 */
	@Override
	public String nextInvoiceNo(String empId, String hostId, String inccaId) throws BizException {
		NextInvoiceNoNewBP bp = new NextInvoiceNoNewBP();
		return bp.exec(empId, hostId, inccaId);
	}

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
	@Override
	public String nextInvoiceNoBySdPttp(String empId, String hostId, String inccaId, String stPttp)
			throws BizException {
		NextInvoiceNoNewBP bp = new NextInvoiceNoNewBP();
		return bp.exec(empId, hostId, inccaId,stPttp);
	}
	/**
	 * 票据包过号
	 * @param empId 人员id
	 * @param hostId PCid
	 * @param inccaId 票据分类id
	 * @throws BizException
	 * @return 过号前的当前号
	 * @author ly 2018/05/23
	 */
	@Override
	public String nextInvoiceNoPre(String empId, String hostId, String inccaId) throws BizException {
		NextInvoiceNoOldBP bp = new NextInvoiceNoOldBP();
		return bp.exec(empId, hostId, inccaId);
	}
	
	/**
	 * 票据包过号
	 * (用于批量获取票号时过号)
	 * @param incIss 票据包信息
	 * @param lastNo 最后使用号码
	 * @return 过号后的当前号
	 * @throws BizException
	 * @author ly 2018/07/28
	 */
	@Override
	public String nextInvoiceNoByNo(BlIncIssDO incIss,String lastNo) throws BizException{
		NextInvoiceNoByNoBP bp = new NextInvoiceNoByNoBP();
		return bp.exec(incIss, lastNo);
	}
	
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
	@Override
	public String nextInvoiceMany(String empId, String hostId, String inccaId, Integer num) throws BizException{
		NextInvoiceManyBP bp = new NextInvoiceManyBP();
		return bp.exec(empId, hostId, inccaId, num);
	}
	
	/**
	 * 获取门诊挂号当前票据号
	 * @param empId
	 * @param hostId
	 * @return
	 * @throws BizException
	 * @author ly 2019/11/01
	 */
	@Override
	public String getOepRegCurInvoiceNo(String empId, String hostId) throws BizException{
		GetOepRegCurInvoiceNoBP bp = new GetOepRegCurInvoiceNoBP();
		return bp.exec(empId, hostId);
	}
	
	/**
	 * 获取门诊挂号当前发票信息
	 * @param empId
	 * @param hostId
	 * @return
	 * @throws BizException
	 * @author ly 2019/11/01
	 */
	@Override
	public BlIncIssDO getOepRegCurInvoiceDO(String empId, String hostId) throws BizException{
		GetOepRegCurInvoiceDOBP bp = new GetOepRegCurInvoiceDOBP();
		return bp.exec(empId, hostId);
	}

	
}
