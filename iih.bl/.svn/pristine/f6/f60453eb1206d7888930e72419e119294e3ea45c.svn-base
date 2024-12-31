package iih.bl.itf.std.bp.ipcharge;

import iih.bd.utils.CommDAFacade;
import iih.bl.itf.std.bp.ipcharge.qry.GetTotalCostInfoQry;
import iih.bl.itf.std.bp.ipcharge.qry.GetTotalCostQry;
import iih.bl.itf.std.d.ipchargeqry.BlTotalCostDTO;
import iih.bl.itf.std.d.ipchargeqry.BlTotalCostInfoDTO;
import xap.mw.core.data.BizException;


public class GetTotalCostInfoBP {
	/**
	 * 预交金交费查询
	 * 
	 * @param patCode 患者编码
	 * @param times 住院次数
	 * @return
	 * @throws BizException
	 * @author dupeng
	 */
	public BlTotalCostInfoDTO[] exec(String patCode,Integer times) throws BizException{
		
		BlTotalCostInfoDTO[] list = (BlTotalCostInfoDTO[]) CommDAFacade.execQuery(new GetTotalCostInfoQry(patCode, times), BlTotalCostInfoDTO.class);
		BlTotalCostDTO[] totalCost = (BlTotalCostDTO[]) CommDAFacade.execQuery(new GetTotalCostQry(patCode, times), BlTotalCostDTO.class);
		Double totalAmt;
		totalAmt = totalCost[0].getTotalAmt();
		if (totalAmt != 0)
		{
			for(BlTotalCostInfoDTO dto : list){
				dto.setTotalAmt(totalAmt);
			}	
		}
		return list;
	}
}
