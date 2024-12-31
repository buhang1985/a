package iih.bd.pp.s.samppri.qry;

/**
 * 
 * @Description:标本费用对照,查询标本类型
 * @author zheng.yx@founder.com.cn
 * @version：2019年4月11日 上午10:40:63 创建
 */
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetSamptpDocQry implements ITransQry {

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append(" SELECT doc.id_udidoc,                          ");
		sqlStr.append("        doc.name,                               ");
		sqlStr.append("        doc.code,                               ");
		sqlStr.append("        sampri.id_samp_pri as Ctrl1             ");
		sqlStr.append("   FROM bd_udidoc doc                           ");
		sqlStr.append("   left join bd_samp_pri sampri                 ");
		sqlStr.append("     on sampri.id_samptp = doc.id_udidoc        ");
		sqlStr.append("    and eu_pritp = 0                            ");
		sqlStr.append("  where id_udidoclist = '@@@@ZZ20000000000026'  ");
		return sqlStr.toString();
	}

}
