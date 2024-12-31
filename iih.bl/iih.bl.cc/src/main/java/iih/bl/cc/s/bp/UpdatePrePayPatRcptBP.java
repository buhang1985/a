package iih.bl.cc.s.bp;

import iih.bl.pay.prepaypatrcpt.d.BlPrepayPatRcptDO;
import iih.bl.pay.prepaypatrcpt.i.IPrepaypatrcptCudService;
import iih.bl.pay.prepaypatrcpt.i.IPrepaypatrcptRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 预交金_预交金票据(结账)
 * @author LIM
 *
 */
public class UpdatePrePayPatRcptBP {
	/**
	 * 预交金_预交金票据记录(BL_PREPAY_PAT_RCPT)中结账标志为已结账
	 * @param id_user 操作员id
	 * @param id_cc 结账id
	 * @param end_time 结账日期
	 * @param code_entp 患者就诊类型
	 * @throws BizException
	 * @author LIM
	 */
	public void exec(String id_user,String id_cc,FDateTime end_time,String code_entp) throws BizException{
		StringBuilder paySql = new StringBuilder();
		
		paySql.append(" update bl_prepay_pat_rcpt set id_cc='"+ id_cc +"',Fg_cc_rcpt='Y' ");
		paySql.append("  where code_entp='").append(code_entp).append("'");
		paySql.append(" and Fg_cc_rcpt = 'N'");
		paySql.append(" and ((Id_emp_rcpt = '").append(id_user).append("'");
		paySql.append(" and dt_receipt < '").append(end_time).append("')");
		paySql.append(" or (id_emp_return = '").append(id_user).append("'");
		paySql.append(" and dt_return < '").append(end_time).append("'))");
		 DAFacade daFacade=new DAFacade();
		 daFacade.execUpdate(paySql.toString());
		
		
//		paySql.append(" a0.code_entp='").append(code_entp).append("'");
//		paySql.append(" and a0.Fg_cc_rcpt = 'N'");
//		paySql.append(" and ((a0.Id_emp_rcpt = '").append(id_user).append("'");
//		paySql.append(" and a0.dt_receipt < '").append(end_time).append("')");
//		paySql.append(" or (a0.id_emp_return = '").append(id_user).append("'");
//		paySql.append(" and a0.dt_return < '").append(end_time).append("'))");
		
//		IPrepaypatrcptRService payRService = ServiceFinder.find(IPrepaypatrcptRService.class);
//		IPrepaypatrcptCudService payCService = ServiceFinder.find(IPrepaypatrcptCudService.class);
//		BlPrepayPatRcptDO[] blPrePayPatRcptDOArr = payRService.find(paySql.toString(), null, FBoolean.FALSE);
//		if(blPrePayPatRcptDOArr != null && blPrePayPatRcptDOArr.length > 0){
//			for(BlPrepayPatRcptDO blPrePayPatRcptDO : blPrePayPatRcptDOArr){
//				blPrePayPatRcptDO.setId_cc(id_cc);
//				blPrePayPatRcptDO.setFg_cc_rcpt(FBoolean.TRUE);
//				blPrePayPatRcptDO.setStatus(DOStatus.UPDATED);
//			}
//			payCService.save(blPrePayPatRcptDOArr);				
//		}
	}
}
