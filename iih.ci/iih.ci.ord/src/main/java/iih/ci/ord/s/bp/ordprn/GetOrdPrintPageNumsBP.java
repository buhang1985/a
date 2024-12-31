package iih.ci.ord.s.bp.ordprn;

import java.util.List;

import org.apache.commons.lang.ArrayUtils;

import iih.ci.ord.dto.ordprintdto.d.OrdPrintParamDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取已打医嘱页码集合
 * @author Young
 *
 */
public class GetOrdPrintPageNumsBP {

	public int[] exec(OrdPrintParamDTO paramDTO) throws BizException {
		return this.getPageNums(paramDTO);
	}

	/**
	 * 获取页码集合
	 * @param paramDTO
	 * @return
	 * @throws BizException
	 */
	private int[] getPageNums(OrdPrintParamDTO paramDTO) throws BizException {
		SqlParam sqlparam = new SqlParam();
		sqlparam.addParam(paramDTO.getId_en());
		if(!FBoolean.TRUE.equals(paramDTO.getFg_herb())){
			sqlparam.addParam(paramDTO.getFg_long());
		}
		StringBuilder sb = new StringBuilder();
		sb.append("select distinct prn.page_num from ci_or_prn prn ");
		sb.append("left join ci_order ord on prn.id_or=ord.id_or where prn.ds<1 and prn.id_en=? ");
		if(!FBoolean.TRUE.equals(paramDTO.getFg_herb())){
			sb.append("and prn.fg_long = ? ");
			sb.append("and prn.sd_srvtp not like '0103%' ");
		}else {
			sb.append("and prn.sd_srvtp like '0103%' ");
		}
		sb.append("order by prn.page_num ");
		@SuppressWarnings("unchecked")
		List<Integer> pageNums = (List<Integer>) new DAFacade().execQuery(sb.toString(), sqlparam, new ColumnListHandler());
		int[] pageNumArr = ArrayUtils.toPrimitive(pageNums.toArray(new Integer[pageNums.size()]));
		return pageNumArr;
	}
}
