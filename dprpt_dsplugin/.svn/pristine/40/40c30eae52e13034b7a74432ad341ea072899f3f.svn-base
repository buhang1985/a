package iih.pe.report.bp;

import iih.pe.pqry.sortofabnordetecrate.d.SortOfAbnormalDetecRateDTO;
import iih.pe.report.bp.qry.SortOfAbnormalDetecRateQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

public class SortOfAbnormalDetecRateBp {
	public SortOfAbnormalDetecRateBp(){

	}
	
	public SortOfAbnormalDetecRateDTO[] exec(String dt_begin, String dt_end) throws BizException {

		System.out.println("<--------------------查询体检异常发现检出率排序！------------------->");
		if(dt_begin != null && dt_end != null){			
			SortOfAbnormalDetecRateDTO[] sortOfAbnormalDetecRateDTOs = (SortOfAbnormalDetecRateDTO[]) AppFwUtil.getDORstWithDao(new SortOfAbnormalDetecRateQry(dt_begin, dt_end), SortOfAbnormalDetecRateDTO.class);
			return sortOfAbnormalDetecRateDTOs;
		}
		return new SortOfAbnormalDetecRateDTO[0];
	}
}
