package iih.bd.srv.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class SetItmDeInfoSql implements ITransQry {

	private String Id_srv;

	public SetItmDeInfoSql(String id_srv) {
		Id_srv = id_srv;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {

		SqlParam param = new SqlParam();
		param.addParam(Id_srv);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		return getSqlStr();
	}

	public String getSqlStr() {
		
		StringBuffer SqlStr = new StringBuffer();
		SqlStr.append("select ");
		SqlStr.append("null as id_mrtpl_vt_itm, ");
		SqlStr.append("null as id_mrtplvt, ");
		SqlStr.append("null as sortno,  ");
		SqlStr.append("srvvt.id_srv,  ");
		SqlStr.append("srv.name as id_srv_name,  ");
		SqlStr.append("null as id_freq,  ");
		SqlStr.append("null as id_freq_name, ");
		SqlStr.append("srvvt.id_de,  ");
		SqlStr.append("de.name as id_de_name,  ");
		SqlStr.append("srvvt.id_dedatatp,  ");
		SqlStr.append("datatype.name as id_dedatatp_name,  ");
		SqlStr.append("datatype.code as id_dedatatp_code,  ");
		SqlStr.append("srvvt.id_unit,  ");
		SqlStr.append("unit.name as id_unit_name, ");
		SqlStr.append("srvvt.devalmax,  ");
		SqlStr.append("srvvt.devalmin,  ");
		SqlStr.append("srvvt.fg_pos,  ");
		SqlStr.append("srvvt.id_vt_pos_ca,  ");
		SqlStr.append("positionca.name as id_vt_pos_ca_name, ");
		SqlStr.append("srvvt.id_vt_pos_def,  ");
		SqlStr.append("position.name as id_vt_pos_def_name, ");
		SqlStr.append("srvvt.fg_aux,  ");
		SqlStr.append("srvvt.id_vt_aux_ca,  ");
		SqlStr.append("measureaux.name as id_vt_aux_ca_name,  ");
		SqlStr.append("srvvt.valcount  ");
		SqlStr.append("from BD_SRV_VT srvvt ");
		SqlStr.append("inner join BD_SRV srv on srvvt.id_srv=srv.id_srv  ");
		SqlStr.append("left join BD_DE de on srvvt.id_de=de.id_de  ");
		SqlStr.append("left join bd_measdoc unit on srvvt.id_unit=unit.id_measdoc  ");
		SqlStr.append("left join BD_UDIDOC positionca on srvvt.id_vt_pos_ca=positionca.id_udidoc  ");
		SqlStr.append("left join BD_UDIDOC position on srvvt.id_vt_pos_def=position.id_udidoc  ");
		SqlStr.append("left join BD_UDIDOC measureaux on srvvt.id_vt_aux_ca=measureaux.id_udidoc  ");
		SqlStr.append("left join BD_UDIDOC datatype on srvvt.id_dedatatp=datatype.id_udidoc  ");
		SqlStr.append("where srvvt.id_srv=? ");
		return SqlStr.toString();
	}

}
