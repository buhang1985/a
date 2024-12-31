package iih.bl.inc.s.bp.inc;

import iih.bd.base.exception.ArgumentNullException;
import iih.bl.comm.IBlMsgConst;
import iih.bl.inc.blinccanc.d.BlIncCancDO;
import iih.bl.inc.blinciss.d.BlIncIssDO;
import iih.bl.inc.s.ep.CancIncEP;
import iih.bl.inc.s.ep.IncIssEP;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.lock.PKLock;

/**
 * 票据包过号(用于批量获取票号时过号)
 * @author ly 2018/07/28
 *
 */
public class NextInvoiceNoByNoBP {

	/**
	 * 票据包过号
	 * (用于批量获取票号时过号)
	 * @param incIss 票据包信息
	 * @param lastNo 最后使用号码
	 * @return 过号后的当前号
	 * @throws BizException
	 */
	public String exec(BlIncIssDO incIss,String lastNo) throws BizException{
		
		if(incIss == null){
			throw new ArgumentNullException("票据包过号", "票据包信息");
		}
		
		if(StringUtil.isEmpty(lastNo)){
			throw new ArgumentNullException("票据包过号", "最后使用号码");
		}
		
		boolean lock = PKLock.getInstance().addDynamicLock(incIss.getId_emp_iss() + incIss.getId_incca(), 5 * 1000);
		
		if(!lock){
			throw new BizException(IBlMsgConst.ERROR_INCISS_LOCK_ALERT);
		}
		
		CancIncEP cancEp = new CancIncEP();
		BlIncCancDO[] incCanc = cancEp.findCancInc(incIss.getId_incca(), incIss.getCode_incpkg(), incIss.getIncno_cur());
		
		IncIssEP issEp = new IncIssEP();
		incIss = issEp.updateNextProvince(incIss, incCanc, lastNo);
		
		return incIss.getIncno_cur();
	}
}
