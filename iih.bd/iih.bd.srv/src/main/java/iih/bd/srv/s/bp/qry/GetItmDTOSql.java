package iih.bd.srv.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetItmDTOSql  implements ITransQry {

	private String Id_mrtplvtitm;
	
	public GetItmDTOSql(String id_mrtplvtitm)
	{
		Id_mrtplvtitm=id_mrtplvtitm;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		param.addParam(Id_mrtplvtitm);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		return getSqlStr();
	}
	
	public String getSqlStr()
	{
		StringBuffer SqlStr=new StringBuffer();
		
		SqlStr.append("select ");
		SqlStr.append("tm.id_srv, ");
		SqlStr.append("tm.sortno, ");
		SqlStr.append("tm.id_freq, ");
		SqlStr.append("vt.id_de, ");
		SqlStr.append("vt.id_dedatatp, ");
		SqlStr.append("vt.id_unit, ");
		SqlStr.append("vt.devalmax, ");
		SqlStr.append("vt.devalmin, ");
		SqlStr.append("vt.fg_pos, ");
		SqlStr.append("vt.id_vt_pos_ca,vt.id_vt_pos_def,vt.fg_aux,vt.id_vt_aux_ca,vt.valcount ");
		SqlStr.append("from bd_mr_vt_itm tm ");
		SqlStr.append("inner join bd_srv_vt vt on tm.id_srv=vt.id_srv ");
		SqlStr.append("where tm.id_srv =? ");
		
		return SqlStr.toString();
	}

}
