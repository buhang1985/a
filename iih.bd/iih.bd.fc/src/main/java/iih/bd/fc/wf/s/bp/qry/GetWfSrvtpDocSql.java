package iih.bd.fc.wf.s.bp.qry;

import iih.bd.fc.s.bp.common.BdFcEnvContextUtil;
import iih.bd.fc.wf.d.WfDO;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetWfSrvtpDocSql implements ITransQry {

	private String Code_entp;
	private Integer Eu_wftp;
	private String Id_wf;

	public GetWfSrvtpDocSql(String code_entp, Integer eu_wftp, String id_wf) {

		Code_entp = code_entp;
		Eu_wftp = eu_wftp;
		Id_wf = id_wf;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		param.addParam(Code_entp);
		param.addParam(Eu_wftp);
		if (!StringUtil.isEmptyWithTrim(Id_wf)) {
			param.addParam(Id_wf);
		}
		return param;
	}

	@Override
	public String getQrySQLStr() {

		StringBuffer SqlStr = new StringBuffer();
		SqlStr.append(" select                                                    ");
		SqlStr.append(" doc.*                                                     ");
		SqlStr.append(" from bd_wf_srvtp srvtp                                    ");
		SqlStr.append(" inner join bd_udidoc doc on doc.id_udidoc=srvtp.id_srvtp  ");
		SqlStr.append(" inner join bd_wf wf on wf.id_wf=srvtp.id_wf               ");
		SqlStr.append(" where wf.code_entp=?                                      ");
		SqlStr.append(" and wf.eu_wftp=?                                          ");
		SqlStr.append(" and " + new BdFcEnvContextUtil().getWherePart(new WfDO(), "wf"));
		if (!StringUtil.isEmptyWithTrim(Id_wf)) {
			SqlStr.append(" and wf.id_wf<>?                                           ");
		}

		return SqlStr.toString();
	}

}
