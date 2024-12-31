package iih.bl.cc.s.bp;

import iih.bl.pay.prepaypatrcpt.d.BlPrepayPatRcptDO;
import iih.bl.pay.prepaypatrcpt.i.IPrepaypatrcptCudService;
import iih.bl.pay.prepaypatrcpt.i.IPrepaypatrcptRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
/**
 * 预交金_预交金票据(取消结账)
 * @author LIM
 *
 */
public class UpdatePrePayPatRcptForCancelBP {
	/**
	 * 修改预交金_预交金票据(BL_PREPAY_PAT_RCPT)中的结账标志为未结账
	 * @param sqlStr
	 * @throws BizException
	 */
	public void exec(String sqlStr)throws BizException{
		StringBuilder sb = new StringBuilder();
		sb.append(" update bl_prepay_pat_rcpt a0 set Id_cc='' ,Fg_cc_rcpt='N'");
		sb.append(" where ");
		sb.append(sqlStr);
		 DAFacade daFacade=new DAFacade();
		 daFacade.execUpdate(sb.toString());
//		IPrepaypatrcptRService payRService = ServiceFinder.find(IPrepaypatrcptRService.class);		
//		BlPrepayPatRcptDO[] blPrePayPatRcptDOArr = payRService.find(sqlStr, null, FBoolean.FALSE);
//		if(blPrePayPatRcptDOArr != null && blPrePayPatRcptDOArr.length > 0){
//			for(BlPrepayPatRcptDO blPrePayPatDO : blPrePayPatRcptDOArr){
//				blPrePayPatDO.setId_cc(null);
//				blPrePayPatDO.setFg_cc_rcpt(FBoolean.FALSE);
//				blPrePayPatDO.setStatus(DOStatus.UPDATED);
//			}
//			IPrepaypatrcptCudService payCService = ServiceFinder.find(IPrepaypatrcptCudService.class);
//			payCService.save(blPrePayPatRcptDOArr);
//		}	
	}
}
