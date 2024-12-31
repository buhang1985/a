package iih.bd.srv.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetMrtplvtDTObpSql implements ITransQry {

	private String _Id_mtplvt;

	public GetMrtplvtDTObpSql(String Id_mtplvt) {
		_Id_mtplvt = Id_mtplvt;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {

		SqlParam param = new SqlParam();
		param.addParam(_Id_mtplvt);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		return getSqlStr();
	}

	public String getSqlStr() {
		
		StringBuffer sqlStr = new StringBuffer();
		
		sqlStr.append("select  ");
		sqlStr.append("mrtplvt.id_mrtplvt,  ");
		sqlStr.append("mrtplvt.id_mrtpl,  ");
		sqlStr.append("mrtplvt.name,  ");
		sqlStr.append("mrtplvt.code,  ");
		sqlStr.append("mrtplvt.id_level_nur,  ");

		sqlStr.append("mrtp.id_mrtp,  ");
		sqlStr.append("mrtp.name as name_mrtp,  ");
		sqlStr.append("mrtp.code as code_mrtp,  ");
		
		sqlStr.append("nur.name as id_level_nur_name, ");
		sqlStr.append("mrtplvt.id_level_dise,  ");
		sqlStr.append("dise.name as id_level_dise_name, ");
		sqlStr.append("mrtpl.id_owtp,  ");
		sqlStr.append("owtp.name as id_owtp_name,  ");
		sqlStr.append("mrtpl.id_dept,  ");
		sqlStr.append("dept.name as id_dept_name, ");
		sqlStr.append("mrtpl.pycode,  ");
		sqlStr.append("mrtpl.wbcode,  ");
		sqlStr.append("mrtpl.mnecode,  ");
		sqlStr.append("mrtplvt.fg_sys  ");
		sqlStr.append("from BD_MRTPL_VT mrtplvt  ");
		sqlStr.append("left join BD_MRTPL mrtpl on mrtplvt.id_mrtpl=mrtpl.id_mrtpl ");
		sqlStr.append("left join BD_MRTP mrtp on mrtpl.id_mrtp=mrtp.id_mrtp ");
		sqlStr.append("left join bd_udidoc nur on mrtplvt.id_level_nur=nur.id_udidoc ");
		sqlStr.append("left join bd_udidoc dise on mrtplvt.id_level_dise=dise.id_udidoc ");
		sqlStr.append("left join bd_udidoc owtp on mrtpl.id_owtp=owtp.id_udidoc ");
		sqlStr.append("left join bd_dep dept on mrtpl.id_dept=dept.id_dep ");
		sqlStr.append("where mrtplvt.id_mrtplvt=? ");

		return sqlStr.toString();
	}

}
