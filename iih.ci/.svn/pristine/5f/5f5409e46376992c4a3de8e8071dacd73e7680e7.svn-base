package iih.ci.mr.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class DataElementSql implements ITransQry {

	private String Id_mrvtca;

	public DataElementSql(String id_mrvtca) {
		Id_mrvtca = id_mrvtca;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		SqlParam rtnParam = new SqlParam();
		rtnParam.addParam(Id_mrvtca);
		// rtnParam.addParam(Id_mrvtca);
		// rtnParam.addParam(Id_mrtpl);
		// rtnParam.addParam(Id_mrtpl);
		return rtnParam;
	}

	@Override
	public String getQrySQLStr() {
		return _getQrySQLStr();
	}

	private String _getQrySQLStr() {
		// 获取当前选中医疗记录模板中涉及到的全部公共数据元
		// String SqlStr = ""
		// + "("
		// +
		// "  select de.id_de,de.name,de.id_detp,de.devalmax,de.devalmin,de.destdvalmax,de.destdvalmin,stbsecitem.id_mrtplstbsec as def1,stbsecitem.id_mrtplstbsecitm as def2"
		// + "  from BD_MRTPL_STBSEC_ITM stbsecitem"
		// +
		// "  inner join BD_MRTPL_STBSEC stbsec on stbsecitem.id_mrtplstbsec=stbsec.id_mrtplstbsec and stbsec.id_mrtpl=? and stbsecitem.fg_srv='N'and stbsecitem.id_de is not null"
		// + "  inner join BD_DE de on stbsecitem.id_de=de.id_de"
		// + ")"
		// + "union"
		// + "("
		// +
		// "  select de.id_de,de.name,de.id_detp,de.devalmax,de.devalmin,de.destdvalmax,de.destdvalmin,stbsecitem.id_mrtplstbsec as def1,stbsecitem.id_mrtplstbsecitm as def2"
		// + "  from BD_MRTPL_STBSEC_ITM stbsecitem"
		// +
		// "  inner join BD_MRTPL_STBSEC stbsec on stbsecitem.id_mrtplstbsec=stbsec.id_mrtplstbsec and stbsec.id_mrtpl=? and stbsecitem.fg_srv1='N' and stbsecitem.fg_value1='Y' and stbsecitem.id_de1 is not null"
		// + "  inner join BD_DE de on stbsecitem.id_de1=de.id_de"
		// + ")"
		// + "union"
		// + "("
		// +
		// "  select de.id_de,srv.name,de.id_detp,de.devalmax,de.devalmin,de.destdvalmax,de.destdvalmin,stbsecitem.id_mrtplstbsec as def1,stbsecitem.id_mrtplstbsecitm as def2"
		// + "  from BD_MRTPL_STBSEC_ITM stbsecitem"
		// +
		// "  inner join BD_MRTPL_STBSEC stbsec on stbsecitem.id_mrtplstbsec=stbsec.id_mrtplstbsec and stbsec.id_mrtpl=? and stbsecitem.fg_srv='Y' and stbsecitem.id_srv is not null"
		// + "  left join BD_SRV_VT srvvt on stbsecitem.id_srv=srvvt.id_srvvt"
		// + "  inner join BD_DE de on srvvt.id_de=de.id_de"
		// + "  left join BD_SRV srv on stbsecitem.id_srv=srv.id_srv"
		// + ")"
		// + "union"
		// + "("
		// +
		// "  select de.id_de,srv.name,de.id_detp,de.devalmax,de.devalmin,de.destdvalmax,de.destdvalmin,stbsecitem.id_mrtplstbsec as def1,stbsecitem.id_mrtplstbsecitm as def2"
		// + "  from BD_MRTPL_STBSEC_ITM stbsecitem"
		// +
		// "  inner join BD_MRTPL_STBSEC stbsec on stbsecitem.id_mrtplstbsec=stbsec.id_mrtplstbsec and stbsec.id_mrtpl=? and stbsecitem.fg_srv1='Y' and stbsecitem.id_srv1 is not null"
		// + "  left join BD_SRV_VT srvvt on stbsecitem.id_srv=srvvt.id_srvvt"
		// + "  inner join BD_DE de on srvvt.id_de=de.id_de"
		// + "  left join BD_SRV srv on stbsecitem.id_srv=srv.id_srv"
		// + ")";
		// String SqlStr = "("
		// +
		// " select bdsrvt.*,bdmrvtca.id_mrvtca as def1,bdmrvtitem.id_mrvtcaitm as def2"
		// + " from BD_MR_VT_ITM bdmrvtitem"
		// +
		// " inner join BD_MR_VT_CA bdmrvtca on bdmrvtitem.id_mrvtca=bdmrvtca.id_mrvtca and bdmrvtca.id_mrtpl=?"
		// + " inner join BD_SRV_VT bdsrvt on bdmrvtitem.id_srv=bdsrvt.id_srv"
		// + ")"
		// + "union"
		// + "("
		// +
		// "  select  bdsrvt.*,bdmrvtca.id_mrvtca as def1,bdmrvtitem.id_mrvtcaitm as def2"
		// + "  from BD_MR_VT_ITM bdmrvtitem"
		// +
		// "  inner join BD_MR_VT_CA bdmrvtca on bdmrvtitem.id_mrvtca=bdmrvtca.id_mrvtca and bdmrvtca.id_mrtpl=?"
		// +
		// "  inner join BD_SRV_VT bdsrvt on bdmrvtitem.id_srv1=bdsrvt.id_srv and bdmrvtitem.fg_value1_enable='Y'"
		// + ")";
		String SqlStr = "select "
				+ " srvvt.*,"
				+ " vtitem.id_mrtplvt as def1,"
				+ " vtitem.id_mrtplvtitm as def2"
				+ " from BD_MRTPL_VT_ITM vtitem"
				+ " inner join BD_SRV_VT srvvt on vtitem.id_srv=srvvt.id_srv and vtitem.id_mrtplvt=?"
				+ " inner join BD_SRV srv on srv.id_srv=srvvt.id_srv"
		        + " where vtitem.ds=0 ";
		return SqlStr;

	}
}
