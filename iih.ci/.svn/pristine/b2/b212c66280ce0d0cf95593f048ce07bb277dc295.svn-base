package iih.ci.ord.s.bp.ordprn.qry;

import iih.ci.ord.ordprn.dto.d.CiOrdSheetParamDTO;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取已打印的最后一条医嘱单数据
 * @author Young
 */
public class GetOrdPrintDOLastPrnedQry implements ITransQry {

	private CiOrdSheetParamDTO paramDTO;
	public GetOrdPrintDOLastPrnedQry(CiOrdSheetParamDTO paramDTO) {
		this.paramDTO = paramDTO;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		// TODO Auto-generated method stub
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(this.paramDTO.getId_en());
		sqlParam.addParam(this.paramDTO.getId_ordsheet());
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append("select * from (select id_or,page_num,row_num,row_cnt from ci_or_prn ");
		sb.append(" where ds<1 and id_en=? and id_ordsheet=?");
		sb.append(" order by page_num desc,row_num desc) where rownum=1");
		return sb.toString();
	}
}
