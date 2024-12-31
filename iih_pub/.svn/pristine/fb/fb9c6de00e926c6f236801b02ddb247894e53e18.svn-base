package iih.mm.common.qry;

import iih.bd.base.utils.SqlUtils;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetStockNumValueSql implements ITransQry {
	
	private String[] id_whs;
	private String[] id_mms;
	private Integer day;
	
	public GetStockNumValueSql(String[] id_whs, String[] id_mms, Integer day) {
		this.id_whs = id_whs;
		this.id_mms = id_mms;
		this.day = day;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		
		SqlParam Param = new SqlParam();
		Param.addParam(this.day);
		return Param;
	}

	@Override
	public String getQrySQLStr() {
		
		return this._getQrySQLStr();
	}

	private String _getQrySQLStr() {
		
		StringBuffer SqlStr = new StringBuffer();
		SqlStr.append(" select ");
		SqlStr.append(" out.id_wh, ");
		SqlStr.append(" itm.id_mm, ");
		SqlStr.append(" pkgu.id_mmpkgu Id_mmpkgu_base, ");
		SqlStr.append(" itm.id_mmpkgu_actual, ");
		SqlStr.append(" sum(itm.quan_actual) quan_actual ");
		SqlStr.append(" from mm_out_itm itm ");
		SqlStr.append(" inner join mm_out out "); 
		SqlStr.append(" on out.id_out = itm.id_out ");
		SqlStr.append(" inner join bd_mm_wh mm_wh ");
		SqlStr.append(" on itm.id_mm = mm_wh.id_mm and out.id_wh = mm_wh.id_wh ");
		SqlStr.append(" inner join bd_mm_pkgu pkgu ");
		SqlStr.append(" on pkgu.id_mm = itm.id_mm and pkgu.sd_mmpkgupro = '0' ");
		SqlStr.append(" where out.id_wh in (" + SqlUtils.arrayToStr(id_whs) + ") ");
		if(id_mms != null && id_mms.length > 0) {
			SqlStr.append(" and " + SqlUtils.getInSqlByIds("mm_wh.id_mm", id_mms));
		}
		SqlStr.append(" and to_date(out.dt_conf, 'YYYY-MM-DD HH24:MI:SS')  + ? > sysdate ");
		SqlStr.append(" and out.sd_sttp in ('21','22','23','24') ");
		SqlStr.append(" group by out.id_wh,itm.id_mm,pkgu.id_mmpkgu,itm.id_mmpkgu_actual ");
		
		return SqlStr.toString();
	}
}
