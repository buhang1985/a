package iih.ci.ord.ciordsheet.bp;

import java.util.List;

import iih.ci.ord.ciordsheet.CiOrdSheetDTO;
import iih.ci.ord.ciordsheet.CiOrdSheetParamDTO;
import iih.ci.ord.printmanage.dto.UtilsDTO;
import iih.ci.ord.printmanage.srv.CiorderPrintUtils;

/**
 * 查询当前就诊已打印最后一页的医嘱数据
 * @author Young
 *
 */
public class GetLastPagePrnedDataBP {

	public List<CiOrdSheetDTO> exec(CiOrdSheetParamDTO paramDTO) throws Exception {
		//查询已打印最后一行数据的页号、行号、行数
		StringBuilder sb = new StringBuilder();
		sb.append("select * from (select id_or def1,page_num def2,row_num def3,row_cnt def4 from ci_or_prn")
		.append(String.format(" where ds<1 and id_en='%s' and id_ordsheet='%s'", paramDTO.getId_en(), paramDTO.getId_ordsheet()))
		.append(" order by page_num desc,row_num desc) where rownum=1");
		List<UtilsDTO> rst = CiorderPrintUtils.GetQueryResulte(UtilsDTO.class, sb.toString());
		if (rst != null && rst.size() > 0) {
			int row_num = Integer.parseInt(rst.get(0).getDef3());
			int row_cnt = Integer.parseInt(rst.get(0).getDef4());
			//判断最后一页是否打满
			if (row_num + row_cnt < 26) {
				GetPrnedData8PageNumBP bp = new GetPrnedData8PageNumBP();
				return bp.exec(paramDTO, String.format("'%s'", rst.get(0).getDef2()));
			}
		}
		return null;
	}
}
