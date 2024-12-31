package iih.bl.inc.s.bp.inc;

import org.apache.commons.lang.StringUtils;

import iih.bl.inc.s.bp.inc.base.NextInvoiceNoBaseBP;
import xap.mw.core.data.BizException;

/**
 * 票据包过号
 * @author ly 2015/05/23
 *
 */
public class NextInvoiceNoNewBP extends NextInvoiceNoBaseBP{

	/**
	 * 票据包过号
	 * @param empId 人员id
	 * @param inccaId 票据分类id
	 * @param hostId PCid
	 * @throws BizException
	 * @return 过号后的当前号
	 */
	public String exec(String empId, String hostId, String inccaId) throws BizException{
		super.newInvioce(empId, hostId, inccaId);
		return super.newIncnoCur;
	}

	/**
	 * 窗口类型票据包过号
	 * @description:
	 * @author:hanjq  2020年6月23日
	 * @param empId
	 * @param hostId
	 * @param inccaId
	 * @param stPttp
	 * @return
	 * @throws BizException
	 */
	public String exec(String empId, String hostId, String inccaId, String stPttp) throws BizException {
		if(StringUtils.isBlank(stPttp)){
			super.newInvioce(empId, hostId, inccaId);
		}else{
			super.newInvioce(empId, hostId, inccaId,stPttp);
		}
		
		return super.newIncnoCur;
	}
}
