package iih.ei.std.s.v1.bp.mp.common.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetUdidocListByCodeSql implements ITransQry {


	private String ParentCode;
	private String Code;
	private boolean ContainRoot;

	public GetUdidocListByCodeSql(String parentCode, String code, boolean containRoot) {

		ParentCode = parentCode;
		Code = code;
		ContainRoot = containRoot;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {

		SqlParam Param = new SqlParam();

		Param.addParam(Code);

		Param.addParam(ParentCode);

		if (!ContainRoot) {

			Param.addParam(Code);
		}
		return Param;
	}

	@Override
	public String getQrySQLStr() {

		return getSqlStr();
	}

	public String getSqlStr() {

		StringBuffer SqlStr = new StringBuffer();

		SqlStr.append(" select temdoc.* from  ");
		SqlStr.append(" ( ");
		SqlStr.append("   select * from bd_udidoc doc ");
		SqlStr.append("   start with doc.code =? ");
		SqlStr.append("   connect by prior doc.id_udidoc=doc.id_parent ");
		SqlStr.append(" )temdoc ");
		SqlStr.append(" left join  bd_udidoclist doclist on temdoc.id_udidoclist=doclist.id_udidoclist ");
		SqlStr.append(" where doclist.code=? ");
	//	SqlStr.append(" and " + new MpNrEnvContextUtil().getWherePart(new UdidocDO(), "temdoc"));//2017-06-09_增加管控_xuxing

		if (!ContainRoot) {

			SqlStr.append(" and temdoc.code<>?");
		}

		return SqlStr.toString();
	}

}
