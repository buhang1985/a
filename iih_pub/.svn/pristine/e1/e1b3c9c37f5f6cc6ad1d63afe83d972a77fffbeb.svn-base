package iih.ci.ord.ciorder.refs;

import java.util.List;

import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * 医嘱参照模型-->费用域使用
 * @author ly 2018/07/30
 *
 */
public class OrderForBlRefModel extends RefGridModel {

	private static final long serialVersionUID = 1L;
	
	@Override
	public String[] getShowFieldCode() {
		return new String[] { "code", "name", "dt_entry","content_or"};
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { "id_or", "wbcode", "pycode" };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称", "开立时间","医嘱内容" };
	}

	@Override
	public String getPkFieldCode() {
		return "id_or";
	}

	@Override
	public String getRefCodeField() {
		return "code";
	}

	@Override
	public String getRefNameField() {
		return "name";
	}

	@Override
	public String getTableName() {
		return "ordsrv";
	}
	
	@Override
	public String getRefSql() {
		
		String entId = (String) this.getExtendAttributeValue("id_ent");
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select * from(");
		sqlSb.append("select ");
		sqlSb.append("srv.code,");
		sqlSb.append("srv.name,");
		sqlSb.append("ord.dt_entry,");
		sqlSb.append("ord.content_or,");
		sqlSb.append("ord.id_or,");
		sqlSb.append("srv.wbcode,");
		sqlSb.append("srv.pycode ");
		sqlSb.append("from ci_order ord ");
		sqlSb.append("inner join bd_srv srv ");
		sqlSb.append("on ord.id_srv = srv.id_srv ");
		sqlSb.append("where ord.fg_chk = 'Y' ");
		sqlSb.append("and ord.ds = 0 ");
		if (!StringUtil.isEmpty(entId)) {
			sqlSb.append("and ord.id_en = '" + entId + "' ");
		}
		sqlSb.append("order by ord.dt_entry ) ordsrv ");
		sqlSb.append("where 1=1 ");
		
		
		List<String> whereList = this.getWherePart();
		if (whereList.size() > 0) {
			for (String where : this.getWherePart()) {
				sqlSb.append(" And (").append(where).append(") ");
			}
		}
		
		return sqlSb.toString();
	}
	
	@Override
	public String[] getBlurFields() {
		return new String[] { "code", "name", "wbcode", "pycode", "content_or"};
	}
}
