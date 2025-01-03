package iih.bl.inc.s.bp.inc.base;

import iih.bd.base.exception.ArgumentNullException;
import iih.bl.comm.IBlMsgConst;
import iih.bl.inc.blinccanc.d.BlIncCancDO;
import iih.bl.inc.blinciss.d.BlIncIssDO;
import iih.bl.inc.s.ep.CancIncEP;
import iih.bl.inc.s.ep.IncIssEP;
import xap.lui.core.xml.StringUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.lock.PKLock;

/**
 * 票据过号基类
 * @author ly 2018/05/23
 *
 */
public class NextInvoiceNoBaseBP {

	protected String oldIncnoCur = null;
	protected String newIncnoCur = null;
	
	/**
	 * 票据过号
	 * @param empId 人员id
	 * @param hostId PCid
	 * @param inccaId 票据分类id
	 */
	protected void newInvioce(String empId, String hostId, String inccaId) throws BizException {
	
		if(StringUtil.isEmpty(empId) && StringUtil.isEmpty(hostId)){
			throw new ArgumentNullException("票据包过号","人员和PCid");
		}
		
		if(StringUtil.isEmpty(inccaId)){
			throw new ArgumentNullException("票据包过号","票据分类id");
		}
		
		boolean lock = PKLock.getInstance().addDynamicLock(empId + hostId + inccaId, 5 * 1000);
		if(!lock){
			throw new BizException(IBlMsgConst.ERROR_INCISS_LOCK_ALERT);
		}
		
		IncIssEP issEp = new IncIssEP();
		BlIncIssDO incIss = issEp.findUsingInc(empId, hostId, inccaId);
		
		CancIncEP cancEp = new CancIncEP();
		BlIncCancDO[] incCanc = cancEp.findCancInc(inccaId, incIss.getCode_incpkg(), incIss.getIncno_cur());
	
		oldIncnoCur = incIss.getIncno_cur();
		incIss = issEp.updateNextProvince(incIss, incCanc, incIss.getIncno_cur());
		newIncnoCur = incIss.getIncno_cur();
	}

	/**
	 * 窗口类型（床旁结算）票据过号
	 * @description:
	 * @author:hanjq  2020年6月23日
	 * @param empId
	 * @param hostId
	 * @param inccaId
	 * @param stPttp
	 * @throws BizException 
	 */
	protected void newInvioce(String empId, String hostId, String inccaId, String stPttp) throws BizException {
		if(StringUtil.isEmpty(empId) && StringUtil.isEmpty(hostId)){
			throw new ArgumentNullException("票据包过号","人员和PCid");
		}
		
		if(StringUtil.isEmpty(inccaId)){
			throw new ArgumentNullException("票据包过号","票据分类id");
		}
		
		boolean lock = PKLock.getInstance().addDynamicLock(empId + hostId + inccaId, 5 * 1000);
		if(!lock){
			throw new BizException(IBlMsgConst.ERROR_INCISS_LOCK_ALERT);
		}
		
		IncIssEP issEp = new IncIssEP();
		BlIncIssDO incIss = issEp.findUsingInc(empId, hostId, inccaId,stPttp);
		
		CancIncEP cancEp = new CancIncEP();
		BlIncCancDO[] incCanc = cancEp.findCancInc(inccaId, incIss.getCode_incpkg(), incIss.getIncno_cur());
	
		oldIncnoCur = incIss.getIncno_cur();
		incIss = issEp.updateNextProvince(incIss, incCanc, incIss.getIncno_cur());
		newIncnoCur = incIss.getIncno_cur();
		
	}
}
