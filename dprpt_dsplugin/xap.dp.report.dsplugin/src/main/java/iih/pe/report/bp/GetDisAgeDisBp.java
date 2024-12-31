package iih.pe.report.bp;

import iih.pe.pqry.pedisagedisrpt.d.PeDisAgeDisDTO;
import iih.pe.report.bp.qry.GetDisAgeDisQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

public class GetDisAgeDisBp {
	
	public GetDisAgeDisBp(){

	}
	
	public PeDisAgeDisDTO[] exec(String dt_begin, String dt_end, String sex, String age_start, String age_end, String fg_marry, String petype, String pediag) throws BizException {

		System.out.println("<--------------------查询体检疾病或异常发现年龄分布！------------------->");
		if(dt_begin != null && dt_end != null && sex != null && age_start != null && age_end != null && fg_marry != null && petype != null && pediag != null){			
			PeDisAgeDisDTO[] peDisAgeDisDTOs = (PeDisAgeDisDTO[]) AppFwUtil.getDORstWithDao(new GetDisAgeDisQry(dt_begin, dt_end, sex, age_start, age_end, fg_marry, petype, pediag), PeDisAgeDisDTO.class);
			return peDisAgeDisDTOs;
		}
		return new PeDisAgeDisDTO[0];
	}
}
