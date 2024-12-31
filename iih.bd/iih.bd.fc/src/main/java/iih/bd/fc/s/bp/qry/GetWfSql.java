package iih.bd.fc.s.bp.qry;

import iih.bd.bc.udi.pub.IMpNsDictCodeTypeConst;
import iih.bd.fc.s.bp.common.BdFcEnvContextUtil;
import iih.bd.fc.wf.d.EnumFlow;
import iih.bd.fc.wf.d.WfDO;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 根据就诊类型和服务类型，获取流向主DO
 * 
 * @author Administrator
 *
 */
public class GetWfSql implements ITransQry {

	private String Id_udidoclist;
	private String Code_entp;
	private String[] InnerCodes;
	private Integer Eu_wftp;

	public GetWfSql(String code_entp, String[] innerCodes, Integer eu_wftp) {

		Id_udidoclist = IMpNsDictCodeTypeConst.SD_SRVTP_CODE;
		Code_entp = code_entp;
		InnerCodes = innerCodes;
		Eu_wftp = eu_wftp;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {

		SqlParam Param = new SqlParam();
		Param.addParam(Id_udidoclist);
		Param.addParam(Code_entp);

		if (InnerCodes != null && InnerCodes.length > 0) {

			for (String innerCode : InnerCodes) {

				Param.addParam(innerCode);
			}
		}

		if (!EnumFlow.NULL.equals(Eu_wftp)) {

			Param.addParam(Eu_wftp);
		}

		return Param;
	}

	@Override
	public String getQrySQLStr() {
		return getSqlStr();
	}

	private String getSqlStr() {

		StringBuffer SqlStr = new StringBuffer();

		// SqlStr.append(" select wf.* from bd_wf_srvtp wfsrvtp              ");
		// SqlStr.append(" inner join bd_wf wf on wfsrvtp.id_wf=wf.id_wf     ");
		// SqlStr.append(" where wfsrvtp.ds=0 and wf.ds=0                    ");
		// SqlStr.append(" and ?                                             ");
		// SqlStr.append(" in                                                ");
		// SqlStr.append(" (                                                 ");
		// SqlStr.append("     select doc.code from bd_udidoc doc            ");
		// SqlStr.append("     left join bd_udidoclist doclist               ");
		// SqlStr.append("     on doclist.id_udidoclist=doc.id_udidoclist    ");
		// SqlStr.append("     start with doclist.code=?                     ");
		// SqlStr.append(" 	and doc.code=wfsrvtp.sd_srvtp                 ");
		// SqlStr.append("     connect by prior doc.id_udidoc=doc.id_parent  ");
		// SqlStr.append("                                                   ");
		// SqlStr.append(" )                                                 ");
		// SqlStr.append(" and wf.code_entp=?                                ");

		SqlStr.append(" select wf.* from bd_wf_srvtp wfsrvtp                  ");
		SqlStr.append(" inner join bd_wf wf on wfsrvtp.id_wf=wf.id_wf         ");
		SqlStr.append(" left join bd_udidoc doc on doc.code=wfsrvtp.sd_srvtp  ");
		SqlStr.append(" left join bd_udidoclist doclist on doc.id_udidoclist=doclist.id_udidoclist  ");
		SqlStr.append(" and doclist.code=?                                    ");
		SqlStr.append(" where wfsrvtp.ds=0 and wf.ds=0                        ");
		SqlStr.append(" and nvl(doc.innercode,'~')<>'~'                       ");
		SqlStr.append(" and wf.code_entp=?                                    ");
		SqlStr.append(" and " + new BdFcEnvContextUtil().getWherePart(new WfDO(), "wf"));

		if (InnerCodes != null && InnerCodes.length > 0) {

			if (InnerCodes.length == 1) {

				SqlStr.append(" and ? like doc.innercode||'%'");

			} else {

				String whereStr = "";

				for (int i = 0; i < InnerCodes.length; i++) {

					whereStr += ((whereStr.length() == 0 ? "" : " or ") + " ? like doc.innercode||'%' ");
				}

				SqlStr.append(" and (" + whereStr + ")");
			}

		} else {

			SqlStr.append(" and 1=2 ");
		}

		//增加执行执行流向过滤
		if (!EnumFlow.NULL.equals(Eu_wftp)) {

			SqlStr.append(" and wf.eu_wftp=? ");
		}

		return SqlStr.toString();
	}
}
