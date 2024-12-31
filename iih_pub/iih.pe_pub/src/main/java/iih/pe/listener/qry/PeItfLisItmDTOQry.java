package iih.pe.listener.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class PeItfLisItmDTOQry implements ITransQry {
	String id_pepsnappt;
	String item_name;
	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		param.addParam(id_pepsnappt);
		param.addParam(item_name);
		return param;
	}

	public PeItfLisItmDTOQry(String id_pepsnappt,String item_name){
		this.id_pepsnappt = id_pepsnappt;
		this.item_name = item_name;
	}
	
	@Override
	public String getQrySQLStr() {
		StringBuilder sqlBF = new StringBuilder();
		sqlBF.append("select lis.name_unit as Unit, lis.val_rstrptlab as ref");
		sqlBF.append("  from PE_ITM_PEITMLIS itm");
		sqlBF.append("  inner join PE_WF_PERSTLISITM lis");
		sqlBF.append("    on itm.code_lis = lis.code_srv");
		sqlBF.append("    where lis.id_pepsnappt = ? ");
		sqlBF.append("	and lis.name_srv like '%' || ? || '%' ");
		return sqlBF.toString();
	}

}
