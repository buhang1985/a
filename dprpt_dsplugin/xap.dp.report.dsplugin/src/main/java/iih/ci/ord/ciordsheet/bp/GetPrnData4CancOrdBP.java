package iih.ci.ord.ciordsheet.bp;

import iih.ci.ord.ciordsheet.CiOrdSheetDTO;
import iih.ci.ord.ciordsheet.CiOrdSheetParamDTO;
import iih.ci.ord.printmanage.dto.UtilsDTO;
import iih.ci.ord.printmanage.srv.CiorderPrintUtils;

import java.util.List;


/**
 * 获取补打作废信息的数据
 * @author Young
 *
 */
public class GetPrnData4CancOrdBP {

	public List<CiOrdSheetDTO> exec(CiOrdSheetParamDTO paramDTO)
			throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("select distinct ORPRN.page_num def1 ")
		.append(" from ci_or_prn ORPRN")
		.append(" left join ci_order ORD on ORPRN.id_en=ORD.id_en and ORPRN.id_or=ORD.id_or")
		.append(" left join ci_or_srv ORSRV on ORSRV.id_or=ORD.id_or and ORPRN.id_srv=ORSRV.id_srv and ORSRV.fg_or='Y' and (ORSRV.SD_NODISPENSE!='2' or ORSRV.SD_NODISPENSE is null)")
		.append(String.format(" where ORPRN.id_en='%s' and ORPRN.id_ordsheet='%s'", paramDTO.getId_en(), paramDTO.getId_ordsheet()))
		.append(" and ORPRN.fg_canc_prn='N' and ORD.fg_chk_canc='Y' and ORPRN.fg_reformed='N' and ORPRN.ds<1");
		List<UtilsDTO> rst = CiorderPrintUtils.GetQueryResulte(UtilsDTO.class, sb.toString());
		if (rst != null && rst.size() > 0) {
			StringBuilder page_nums = new StringBuilder();
			for(UtilsDTO dto : rst) {
				page_nums.append(String.format(",'%s'", dto.getDef1()));
			}
			GetPrnedData8PageNumBP bp = new GetPrnedData8PageNumBP();
			return bp.exec(paramDTO, page_nums.substring(1));
		}
		return null;
	}
}
