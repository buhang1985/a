package iih.ei.std.s.v1.bp.mp.common.qry;

import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetUdidocListByCodeAndParSql implements ITransQry {

	private String ParentCode;
	private String Code;
	private boolean ContainPar;

	public GetUdidocListByCodeAndParSql(String parentCode, String code, boolean containPar) {

		ParentCode = parentCode;
		Code = code;
		ContainPar = containPar;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {

		SqlParam Param = new SqlParam();

		if (!StringUtil.isEmpty(ParentCode)) {

			Param.addParam(ParentCode);
		}

		Param.addParam(Code);

		if (ContainPar) {

			Param.addParam(ParentCode);
		}
		return Param;
	}

	@Override
	public String getQrySQLStr() {

		return getSqlStr();
	}

	public String getSqlStr() {

		StringBuffer SqlStr = new StringBuffer();

		SqlStr.append(" select doc.* from bd_udidoc doc                               ");
		SqlStr.append(" inner join bd_udidoclist doclist                              ");
		SqlStr.append(" on doc.id_udidoclist=doclist.id_udidoclist                    ");
		SqlStr.append(" and doclist.code=?                                            ");
		SqlStr.append(" left join bd_udidoc docpar on docpar.id_udidoc=doc.id_parent  ");
		SqlStr.append(" where 1=1                                                     ");
		//SqlStr.append(" and " + new MpNrEnvContextUtil().getWherePart(new UdidocDO(), "doc"));//2017-06-09_增加管控_xuxing

		if (!StringUtil.isEmpty(ParentCode)) {

			SqlStr.append(" and docpar.code=?                                          ");
		}

		if (ContainPar) {

			SqlStr.append(" or doc.code=? ");
		}
		
		SqlStr.append(" order by doc.code asc ");

		return SqlStr.toString();
	}
}
