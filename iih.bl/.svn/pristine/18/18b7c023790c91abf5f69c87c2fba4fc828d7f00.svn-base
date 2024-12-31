package iih.bl.itf.std.bp.ipcharge;


import iih.bd.utils.CommDAFacade;
import iih.bl.itf.std.bp.ipcharge.qry.GetPrepaymentRecordQry;
import iih.bl.itf.std.d.ipchargeqry.BlPrepaymentRecordDTO;
import xap.mw.core.data.BizException;

public class GetPrepaymentRecordBP {
	/**
	 * 预交金交费查询
	 * 
	 * @param patCode 患者编码
	 * @param times 住院次数
	 * @return
	 * @throws BizException
	 * @author dupeng
	 */
	public BlPrepaymentRecordDTO[] exec(String patCode,Integer times) throws BizException{
		
		return (BlPrepaymentRecordDTO[]) CommDAFacade.execQuery(new GetPrepaymentRecordQry(patCode, times), BlPrepaymentRecordDTO.class);


	}
}
