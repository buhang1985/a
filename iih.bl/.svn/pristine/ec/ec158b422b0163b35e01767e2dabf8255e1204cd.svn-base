package iih.bl.itf.std.bp.ipcharge;

import xap.mw.core.data.BizException;
import iih.bd.utils.CommDAFacade;
import iih.bl.itf.std.bp.ipcharge.qry.GetPrepaymentBalanceQry;
import iih.bl.itf.std.bp.ipcharge.qry.GetTotalCostQry;
import iih.bl.itf.std.d.ipchargeqry.BlPrepaymentBalanceDTO;
import iih.bl.itf.std.d.ipchargeqry.BlTotalCostDTO;

public class GetPrepaymentBalanceBP {
	
	/**
	 * 获取患者预交金余额查询
	 * 
	 * @param patCode 患者编码
	 * @param times 住院次数
	 * @return
	 * @throws BizException
	 * @author dupeng
	 */
	public BlPrepaymentBalanceDTO[] exec(String patCode,Integer times) throws BizException{
		
		BlPrepaymentBalanceDTO[] prepaymentBalanceDTO =  (BlPrepaymentBalanceDTO[]) CommDAFacade.execQuery(new GetPrepaymentBalanceQry(patCode, times), BlPrepaymentBalanceDTO.class);
		BlTotalCostDTO[] totalCostDTO = (BlTotalCostDTO[]) CommDAFacade.execQuery(new GetTotalCostQry(patCode, times), BlTotalCostDTO.class);
		Double prepayment;
		Double prepaidBalance;
		Double totalAmt;
		prepayment = prepaymentBalanceDTO[0].getPrepayment();
		totalAmt = totalCostDTO[0].getTotalAmt();
		prepaidBalance = prepayment - totalAmt;
		prepaymentBalanceDTO[0].setPrepaidBalance(prepaidBalance);
		return prepaymentBalanceDTO;
	}

}
