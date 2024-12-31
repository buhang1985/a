package iih.bl.pay.bp.qry;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.pp.incca.i.IBdInccaCodeConst;
import iih.bl.inc.i.IBlIncUtilService;
import iih.bl.inc.service.i.IBLInvoiceService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.sf.core.util.ServiceFinder;

/**
 *  通过操作员的主键id_emp_pay 和 票据类型  获得该操作员的对应类型的可用票据号
 * @author li_pengying
 *
 */
public class GetInvoiceInfoBP {
	
	/**
	 * 通过操作员的主键id_emp_pay 和支付类型 获得该操作员的对应类型的可用票据号
	 * @param id_emp_pay
	 * @param payType
	 * @author li_pengying
	 * @return
	 */
	public String getInvoiceInfo(String id_emp_pay,String payType) throws BizException{
		//验证票据编号是否可用
		/*IBLInvoiceService incService = (IBLInvoiceService)ServiceFinder.find(IBLInvoiceService.class);
		String code_rep = "";
		if(IBdFcDictCodeConst.ID_CODE_ENTP_IP.equals(payType)){
			code_rep = incService.GetInvoiceNo(id_emp_pay, IBdInccaCodeConst.CODE_INHOS_DEPOSIT);
		}else if(IBdFcDictCodeConst.ID_CODE_ENTP_OP.equals(payType)){
			code_rep = incService.GetInvoiceNo(id_emp_pay, IBdInccaCodeConst.CODE_OUTPATIENT_DEPOSIT);
		}*/
		
		String inccaId = "";

		if (IBdFcDictCodeConst.ID_CODE_ENTP_IP.equals(payType)) {
			inccaId = IBdInccaCodeConst.ID_INHOS_DEPOSIT;
		} else if (IBdFcDictCodeConst.ID_CODE_ENTP_OP.equals(payType)) {
			inccaId = IBdInccaCodeConst.ID_OUTPATIENT_DEPOSIT;
		} else if (IBdFcDictCodeConst.ID_CODE_ENTP_ET_OBS.equals(payType)) {
			inccaId = IBdInccaCodeConst.ID_ET_INVOICE;
		}
		
		IBlIncUtilService service = ServiceFinder.find(IBlIncUtilService.class);
		String code_rep = service.getCurInvoiceNo(id_emp_pay, Context.get().getClientHost(), inccaId);

		return code_rep;
	}
	
}
