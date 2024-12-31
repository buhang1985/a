package iih.bd.srv.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetMrtplItmDTOListSql implements ITransQry {

	private String Id_mrtplvt;

	public GetMrtplItmDTOListSql(String id_mrtplvt) {
		Id_mrtplvt = id_mrtplvt;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {

		SqlParam param = new SqlParam();
		param.addParam(Id_mrtplvt);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		return getSqlStr();
	}

	public String getSqlStr() {
		StringBuffer SqlStr = new StringBuffer();
		SqlStr.append("select ");
		SqlStr.append("mrtplvtitm.id_mrtplvtitm as id_mrtpl_vt_itm, ");
		SqlStr.append("mrtplvtitm.id_mrtplvt, ");
		SqlStr.append("mrtplvtitm.sortno, ");
		SqlStr.append("srvvt.id_srv, ");
		SqlStr.append("srv.name as id_srv_name, ");
		SqlStr.append("mrtplvtitm.id_freq, ");
		SqlStr.append("freq.name as id_freq_name, ");
		SqlStr.append("srvvt.id_de, ");
		SqlStr.append("de.name as id_de_name, ");
		SqlStr.append("srvvt.id_dedatatp, ");
		SqlStr.append("datatype.name as id_dedatatp_name, ");
		SqlStr.append("srvvt.id_unit, ");
		SqlStr.append("unit.name as id_unit_name, ");
		SqlStr.append("srvvt.devalmax, ");
		SqlStr.append("srvvt.devalmin, ");
		SqlStr.append("srvvt.fg_pos, ");
		SqlStr.append("srvvt.id_vt_pos_ca, ");
		SqlStr.append("positionca.name as id_vt_pos_ca_name, ");
		SqlStr.append("srvvt.id_vt_pos_def, ");
		SqlStr.append("position.name as id_vt_pos_def_name, ");
		SqlStr.append("srvvt.fg_aux, ");
		SqlStr.append("srvvt.id_vt_aux_ca, ");
		SqlStr.append("measureaux.name as id_vt_aux_ca_name,  ");
		SqlStr.append("srvvt.valcount ");
		SqlStr.append("from BD_MRTPL_VT_ITM mrtplvtitm ");
		SqlStr.append("inner join BD_SRV_VT srvvt on mrtplvtitm.id_srv=srvvt.id_srv ");
		SqlStr.append("inner join BD_SRV srv on mrtplvtitm.id_srv=srv.id_srv ");
		SqlStr.append("left join BD_DE de on srvvt.id_de=de.id_de ");
		SqlStr.append("left join bd_measdoc unit on srvvt.id_unit=unit.id_measdoc ");
		SqlStr.append("left join BD_UDIDOC positionca on srvvt.id_vt_pos_ca=positionca.id_udidoc ");
		SqlStr.append("left join BD_UDIDOC position on srvvt.id_vt_pos_def=position.id_udidoc ");
		SqlStr.append("left join BD_UDIDOC measureaux on srvvt.id_vt_aux_ca=measureaux.id_udidoc ");
		SqlStr.append("left join bd_freq freq on mrtplvtitm.id_freq=freq.id_freq ");
		SqlStr.append("left join BD_UDIDOC datatype on srvvt.id_dedatatp=datatype.id_udidoc ");
		SqlStr.append("where  mrtplvtitm.ds=0 and  mrtplvtitm.id_mrtplvt=? ");
		SqlStr.append("order by mrtplvtitm.sortno ASC ");

		return SqlStr.toString();
	}
}
