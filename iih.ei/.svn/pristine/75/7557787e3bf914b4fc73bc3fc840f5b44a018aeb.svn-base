package iih.ei.std.s.v1.bp.mp.common.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.udi.d.UdidocDO;

public class GetUdidocByCodeSql implements ITransQry{

	private String ParentCode;
	private String Code;

	public GetUdidocByCodeSql(String parentCode, String code) {
		ParentCode = parentCode;
		Code = code;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {

		SqlParam Param = new SqlParam();
		Param.addParam(ParentCode);
		Param.addParam(Code);
		return Param;
	}

	@Override
	public String getQrySQLStr() {
		return getSqlStr();
	}

	public String getSqlStr() {
		
		StringBuffer SqlStr = new StringBuffer();

		SqlStr.append(" select doc.* from bd_udidoc doc ");
		SqlStr.append(" left join bd_udidoclist doclist on doc.id_udidoclist=doclist.id_udidoclist ");
		SqlStr.append(" where doclist.code=?  ");
		SqlStr.append(" and doc.code=? ");
		//SqlStr.append(" and " + new MpNrEnvContextUtil().getWherePart(new UdidocDO(), "doc"));//2017-06-09_增加管控_xuxing

		return SqlStr.toString();

	}

}
