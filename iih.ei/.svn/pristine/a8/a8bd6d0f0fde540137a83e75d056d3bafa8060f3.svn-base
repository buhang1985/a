package iih.ei.std.s.v1.bp.mp.updatebyplan.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetOrpltpFuncByStatusSql implements ITransQry{

	private String code_status;
	private String id_orpltp;

	public GetOrpltpFuncByStatusSql(String code_status,String id_orpltp) {

		this.code_status = code_status;
		this.id_orpltp = id_orpltp;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {

		SqlParam param = new SqlParam();
		param.addParam(code_status);
		param.addParam(id_orpltp);

		return param;
	}

	@Override
	public String getQrySQLStr() {

		StringBuffer SqlStr = new StringBuffer();

		SqlStr.append(" select                                                                            ");
		SqlStr.append(" orpltp.id_orpltp,                                                                 ");
		SqlStr.append(" orpltp.code as code_orpltp,                                                       ");
		SqlStr.append(" orpltp.name as name_orpltp,                                                       ");
		SqlStr.append(" orpltpsta.id_orpltpsta,                                                           ");
		SqlStr.append(" orpltpsta.code as code_orpltpsta,                                                 ");
		SqlStr.append(" orpltpsta.name as name_orpltpsta,                                                 ");
		SqlStr.append(" orpltpsta.sortno,                                                                 ");
		SqlStr.append(" func.id_fun,                                                                      ");
		SqlStr.append(" func.code as fun_code,                                                            ");
		SqlStr.append(" func.name as name_func,                                                           ");
		SqlStr.append(" stafunc.id_oper,                                                                  ");
		SqlStr.append(" doc.code as code_oper,                                                            ");
		SqlStr.append(" doc.name as name_oper,                                                            ");
		SqlStr.append(" stamap.id_map_org,                                                                ");
		SqlStr.append(" docorg.code as code_map_org,                                                      ");
		SqlStr.append(" docorg.name as name_map_org,                                                      ");
		SqlStr.append(" stamap.id_map_product,                                                            ");
		SqlStr.append(" docproduct.code as code_map_product,                                              ");
		SqlStr.append(" docproduct.name as name_map_product,                                              ");
		SqlStr.append(" stamap.map_code_sta,                                                              ");
		SqlStr.append(" stamap.map_name_sta                                                               ");
		SqlStr.append(" from BD_ORPLTPSTA_MAP stamap                                                      ");
		SqlStr.append(" inner join bd_orpltpsta_func stafunc on stamap.id_orpltpsta=stafunc.id_orpltpsta  ");
		SqlStr.append(" inner join bd_orpltp orpltp on orpltp.id_orpltp=stafunc.id_orpltp                 ");
		SqlStr.append(" inner join bd_orpltpsta orpltpsta on orpltpsta.id_orpltpsta=stafunc.id_orpltpsta  ");
		SqlStr.append(" inner join sys_funcreg func on func.id_fun=stafunc.id_fun                         ");
		SqlStr.append(" left join bd_udidoc doc on doc.id_udidoc=stafunc.id_oper                          ");
		SqlStr.append(" left join bd_udidoc docorg on docorg.id_udidoc=stamap.id_map_org                  ");
		SqlStr.append(" left join bd_udidoc docproduct on docproduct.id_udidoc=stamap.id_map_product      ");
		SqlStr.append(" where stamap.ds=0 and stafunc.ds=0                                                ");
		SqlStr.append("  and stamap.map_code_sta = ?  and orpltp.id_orpltp = ? ");

		return SqlStr.toString();
	}
}
