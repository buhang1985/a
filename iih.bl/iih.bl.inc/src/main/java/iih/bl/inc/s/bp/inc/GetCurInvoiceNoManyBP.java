package iih.bl.inc.s.bp.inc;

import iih.bd.base.exception.ArgumentNullException;
import iih.bl.inc.s.util.InvoiceCalUtil;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;

/**
 * 获取当前票票据号(多个)
 * @author ly 2018/07/28
 *
 */
public class GetCurInvoiceNoManyBP {

	/**
	 * 获取当前票票据号
	 * @param empId 人员id
	 * @param hostId PCid
	 * @param inccaId 票据分类id
	 * @param num 数量
	 * @return 当票据号
	 * @throws BizException
	 */
	public String[] exec(String empId, String hostId, String inccaId, Integer num) throws BizException{
		
		if(StringUtil.isEmpty(empId) && StringUtil.isEmpty(hostId)){
			throw new ArgumentNullException("获取当前在用的票据信息","人员id和PCid");
		}
		
		if(StringUtil.isEmpty(inccaId)){
			throw new ArgumentNullException("获取当前在用的票据信息","人员id");
		}
		
		if(num == null || num <=0){
			throw new BizException("获取当前在用的票据信息:票据数据不正确");
		}
		
		String[] incs = InvoiceCalUtil.nextInvoice(num, empId, hostId, inccaId);
		return incs;
	}
}
