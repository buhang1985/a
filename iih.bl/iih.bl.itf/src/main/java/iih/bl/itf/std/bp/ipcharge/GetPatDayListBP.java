package iih.bl.itf.std.bp.ipcharge;

import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import iih.bd.utils.CommDAFacade;
import iih.bl.itf.std.bp.ipcharge.qry.GetPatDayListQry;
import iih.bl.itf.std.bp.ipcharge.qry.GetTotalCostQry;
import iih.bl.itf.std.d.ipchargeqry.BlPatDayListDTO;
import iih.bl.itf.std.d.ipchargeqry.BlTotalCostDTO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.kernel.SqlParam;

public class GetPatDayListBP {
	/**
	 * 预交金交费查询
	 * 
	 * @param patCode 患者编码
	 * @param times 住院次数
	 * @return
	 * @throws BizException
	 * @author dupeng
	 */
	public BlPatDayListDTO[] exec(String patCode,Integer times, String startDate, String endDate) throws BizException{
		
		BlPatDayListDTO[] patDayListDTO =  (BlPatDayListDTO[]) CommDAFacade.execQuery(new GetPatDayListQry(patCode, times, startDate, endDate), BlPatDayListDTO.class);
		BlTotalCostDTO[] totalCostDTO = (BlTotalCostDTO[]) CommDAFacade.execQuery(new GetTotalCostQry(patCode, times), BlTotalCostDTO.class);
		Double totalAmt;
		Double dayAmt;
		totalAmt = totalCostDTO[0].getTotalAmt();
		dayAmt = 0.00;
		/**
		for(BlPatDayListDTO dto : patDayListDTO){
			dayAmt = dayAmt + dto.getAmt();
		}
		*/
		DAFacade daFacade = new DAFacade();
		StringBuffer sqlStrBuf = new StringBuffer();
		sqlStrBuf.append("SELECT  ");
		sqlStrBuf.append("nvl(sum(c.amt),0) as totalAmt ");
		sqlStrBuf.append("FROM en_ent a ");
		sqlStrBuf.append("inner join en_ent_ip b on a.id_ent = b.id_ent ");
		sqlStrBuf.append("inner join bl_cg_ip c on a.id_ent = c.id_ent and a.id_pat= c.id_pat ");
		sqlStrBuf.append("left join bd_hp_srvorca d on c.id_srv = d.id_srv and c.id_mm= d.id_mm ");
		sqlStrBuf.append("inner join pi_pat pat on a.id_pat= pat.id_pat ");
		sqlStrBuf.append("WHERE nvl(c.fg_research,'N')='N' and (pat.code = ?)");
		sqlStrBuf.append(" AND (b.times_ip = ?)");
		sqlStrBuf.append(" AND (c.dt_cg >= ?)");
		sqlStrBuf.append(" AND (c.dt_cg < ?)");
		SqlParam sqlp1 = new SqlParam();
		sqlp1.addParam(patCode);
		sqlp1.addParam(times);
		sqlp1.addParam(startDate);
		sqlp1.addParam(endDate);
		List<BlTotalCostDTO> tmpDTO = (List<BlTotalCostDTO>) daFacade.execQuery(sqlStrBuf.toString(), sqlp1, new BeanListHandler(BlTotalCostDTO.class));
		if (tmpDTO != null && tmpDTO.size() > 0) 
		{
			dayAmt = tmpDTO.get(0).getTotalAmt();
		}
		for(BlPatDayListDTO dto : patDayListDTO){
			if (totalAmt != 0)
			{
				dto.setTotalAmt(totalAmt);
			}
			if (dayAmt != 0)
			{
				dto.setDayAmt(dayAmt);
			}
		}
			
		return patDayListDTO;
	}

}
