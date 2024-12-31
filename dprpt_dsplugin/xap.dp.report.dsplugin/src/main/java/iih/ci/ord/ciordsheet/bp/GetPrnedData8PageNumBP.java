package iih.ci.ord.ciordsheet.bp;

import iih.ci.ord.ciordsheet.CiOrdSheetParamDTO;

/**
 * 查询指定页码的已打印数据
 * @author Young
 *
 */
public class GetPrnedData8PageNumBP extends GetOrdData4PrnedBP {
	
	/**
	 * 获取where部分语句
	 * @return
	 */
	@Override
	protected String getWhereSqlOrSrvMM(CiOrdSheetParamDTO paramDTO, String pageNums) {
		return String.format(" where ORPRN.id_en='%s' and ORPRN.id_ordsheet='%s' and ORPRN.fg_reformrow='N' and ORPRN.ds<1 and ORPRN.page_num in (%s) ", paramDTO.getId_en(), paramDTO.getId_ordsheet(), pageNums);
	}
	
	/**
	 * 查询重整标记行where语句字段
	 * @return
	 */
	@Override
	protected String getWhereSqlReformrow(CiOrdSheetParamDTO paramDTO, String pageNums) {
		StringBuilder sb = new StringBuilder();
		sb.append(super.getWhereSqlReformrow(paramDTO, pageNums));
		sb.append(String.format(" and ORPRN.id_en='%s' and ORPRN.id_ordsheet='%s' and ORPRN.page_num in (%s)", paramDTO.getId_en(), paramDTO.getId_ordsheet(), pageNums));
		return sb.toString();
	}
}
