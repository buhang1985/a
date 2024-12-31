package iih.bd.srv.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询特殊诊断
 * @author YANG
 *
 */
public class GetDiDefSpecQry implements ITransQry {

	private String id_org;
	private String sqlWhere;
	
	public GetDiDefSpecQry(String id_org, String sqlWhere) {
		this.id_org = id_org;
		this.sqlWhere = sqlWhere;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		// TODO Auto-generated method stub
		return new SqlParam();
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		StringBuilder strSql = new StringBuilder();
        strSql.append("SELECT DISTINCT DI.*,");
        strSql.append("CDSYS.code as cdsys_code,");
        strSql.append("CDSYS.name as cdsys_name,");
        strSql.append("CDSYSTP.code as sys_code,");
        strSql.append("CDSYSTP.name as sys_name,");
        strSql.append("DICA.code as code_distdca,");
        strSql.append("DICA.name as name_distdca ");
        strSql.append("FROM bd_hp HP ");
        strSql.append("INNER JOIN bd_hp_spec HP_SPEC ON HP.id_hp = HP_SPEC.id_hp ");
        strSql.append("LEFT JOIN bd_di_def DI ON HP_SPEC.code_di = DI.code ");
        strSql.append("LEFT JOIN bd_cdsys CDSYS ON CDSYS.id_cdsys = DI.id_cdsys ");
        strSql.append("LEFT JOIN bd_udidoc CDSYSTP on CDSYSTP.Id_udidoc = DI.id_cdsystp ");
        strSql.append("LEFT JOIN bd_di_stdca DICA on DICA.id_distdca = DI.id_distdca ");
        strSql.append("WHERE HP.fg_active = 'Y' ");
        strSql.append("AND DI.fg_active = 'Y'");
        strSql.append(String.format("AND HP.id_org = '%s'", this.id_org));
        strSql.append(this.sqlWhere);

        return strSql.toString();
	}

}
