package iih.bd.pp.hpsrvorca.refs;

import java.util.List;

import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.refinfo.RefGridModel;
import xap.sys.appfw.refinfo.RefResultSet;

/**
 * 医保目录对照参照模型 </br>
 * 使用Code作为主键
 * 
 * @author hao_wu
 *
 */
public class HpSrvorcaRefModel extends RefGridModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1965253386100189159L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { HPSrvorcaDO.CODE, HPSrvorcaDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { HPSrvorcaDO.EU_HPSRVTP,HPSrvorcaDO.ID_MM };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "医保编码", "医保名称" };
	}

	@Override
	public String getRefTitle() {
		return super.getRefTitle();
	}

	@Override
	public String getPkFieldCode() {
		return HPSrvorcaDO.CODE;
	}

	@Override
	public String getRefCodeField() {
		return HPSrvorcaDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return HPSrvorcaDO.NAME;
	}

	@Override
	public String getTableName() {
		return new HPSrvorcaDO().getTableName();
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { "BD_HP_SRVORCA.NAME", "BD_HP_SRVORCA.CODE" };
	}

	@Override
	public String getRefSql() {
		StringBuilder refSql = new StringBuilder();

		refSql.append(" SELECT code,								  ");
		refSql.append("   name,									  ");
		refSql.append("   eu_hpsrvtp,								  ");
		refSql.append("   id_mm								  ");
		refSql.append(" FROM bd_hp_srvorca							  ");
		refSql.append(" WHERE ID_HPSRVORCA IN								  ");
		refSql.append("   (SELECT min(ID_HPSRVORCA)							  ");
		refSql.append("   FROM bd_hp_srvorca							  ");

		// 管控条件
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new HPSrvorcaDO(), "bd_hp_srvorca");
		refSql.append(String.format(" WHERE %s ", BdModeWherePart));
		
		refSql.append(" GROUP BY CODE                          ");
		refSql.append("   )									  ");
		
		// 这个是原有的条件语句
		List<String> oldWherepartArr = this.getWherePart();
		for (String strWhere : oldWherepartArr) {
			refSql = refSql.append(" and ").append(strWhere);
		}		

		return refSql.toString();
	}

	@Override
	public RefResultSet filterRefBlurValue(String blurValue, PaginationInfo pg) {
		// 重写该方法，该方法是模糊字段检索的处理
		String[] fields = this.getBlurFields();
		if (fields == null)
			fields = this.getShowFieldCode();

		StringBuilder buf = new StringBuilder();
		buf.append("(");
		for (int i = 0; i < fields.length; i++) {
			String field = fields[i];
			buf.append("lower(");
			buf.append(field);
			buf.append(")");
			buf.append(" like '%");
			buf.append(blurValue.toLowerCase());
			buf.append("%'");
			if (i != fields.length - 1)
				buf.append(" or ");
		}
		buf.append(")");
		String str = buf.toString();
		this.addWherePart(str);
		try {
			if (pg == null)
				return this.getRefData();
			else
				return this.getRefData(pg);
		} finally {
			this.removeWherePart(str);
		}
	}
}
