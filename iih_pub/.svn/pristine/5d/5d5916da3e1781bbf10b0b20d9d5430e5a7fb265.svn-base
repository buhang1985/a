package iih.bd.srv.medsrv.refs.sql.ip;

public class IpWuweiMedSrvRefSql extends IpWuweiMedSrvRefGetSql{
	
	protected String getQueryColumn() {
		StringBuffer sb = new StringBuffer("select");
		sb.append(
				" distinct Name_srv_desc,'【'||fullname||'】' AS name_srvca, name_srvtp, des_pri, des   || CASE WHEN hp_des_new IS NOT NULL THEN ' (' ||hp_des_new   ||') ' ELSE ''END || CASE WHEN hp_note IS NOT NULL THEN ' ('  ||hp_note  ||') ' ELSE '' END || case when drugrange is not null then ' ('||drugrange||') ' else '' end || case when abrd_name is not null then ' ('||abrd_name||') ' else '' end ||sup_name as des, id_Srv, Id_mm, sd_srvtp,pycode,id_unit_sale,name_unit_sale");
		sb.append(" from ( ");
		;
		return sb.toString();
	}

	@Override
	public Integer getRowsCount() {
		return 300;
	}

	@Override
	protected String getIdWh() {
		return " fg_use_ip='Y' ";
	}
	
}
