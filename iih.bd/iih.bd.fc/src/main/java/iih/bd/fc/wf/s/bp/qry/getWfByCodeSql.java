package iih.bd.fc.wf.s.bp.qry;

import iih.bd.fc.s.bp.common.BdFcEnvContextUtil;
import iih.bd.fc.wf.d.WfDO;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class getWfByCodeSql implements ITransQry {

	private String id_wf;
	private String code_entp;// 就诊类型ID
	private Integer eu_wftp;// 流向编码
	private String[] sd_srvtps;// 服务类型ID

	/**
	 * 获取给定就诊类型的流向
	 * 
	 * @param code_entp
	 *            就诊类型编码
	 * @param eu_wftp
	 *            流向编码
	 */
	public getWfByCodeSql(String Id_wf, String Code_entp, Integer Eu_wftp, String[] Sd_srvtps) {

		this.id_wf = Id_wf;

		this.code_entp = Code_entp;

		this.eu_wftp = Eu_wftp;

		this.sd_srvtps = Sd_srvtps;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {

		SqlParam param = new SqlParam();

		param.addParam(code_entp);

		param.addParam(eu_wftp);

		if (!StringUtil.isEmptyWithTrim(id_wf)) {
			
			param.addParam(id_wf);
		}

		return param;
	}

	@Override
	public String getQrySQLStr() {

		StringBuffer SqlStr = new StringBuffer();

		SqlStr.append("select wfsrvtp.sd_srvtp,wf.code_entp,wf.eu_wftp from Bd_Wf_Srvtp wfsrvtp ");
		SqlStr.append("inner join Bd_Wf wf on wf.id_wf=wfsrvtp.id_wf ");
		SqlStr.append(" where wf.code_entp=? ");
		SqlStr.append(" and wf.eu_wftp=? ");
		SqlStr.append(" and " + new BdFcEnvContextUtil().getWherePart(new WfDO(), "wf"));

		if (!StringUtil.isEmptyWithTrim(id_wf)) {

			SqlStr.append(" and  wf.id_wf<>? ");
		}

		String wherePart = "";

		if (sd_srvtps != null && sd_srvtps.length > 0) {

			for (String sd_srvtp : sd_srvtps) {

				wherePart += (StringUtil.isEmptyWithTrim(wherePart) ? "" : ",") + "'"+sd_srvtp+"'";
			}

			if (sd_srvtps.length == 1) {

				wherePart = " and wfsrvtp.sd_srvtp = " + wherePart;
			} else {

				wherePart = " and wfsrvtp.sd_srvtp in (" + wherePart + ")";
			}
			wherePart += " group by wfsrvtp.sd_srvtp,wf.code_entp,wf.eu_wftp having count(*)>0";

		} else {

			wherePart = " and 1=2";
		}

		SqlStr.append(wherePart);

		return SqlStr.toString();
	}
}
