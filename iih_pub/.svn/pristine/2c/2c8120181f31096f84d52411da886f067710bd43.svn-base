package iih.bd.srv.oth.ref;

import iih.bd.srv.oth.d.ExternFuncRegDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class ExternFuncRegRefModel extends RefGridModel {
	@Override
	public String[] getShowFieldCode() {
		return new String[] { ExternFuncRegDO.DISPLAYNAME, ExternFuncRegDO.FULLCLASSNAME, ExternFuncRegDO.CNT_PARAM };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { ExternFuncRegDO.ID_EXTERNFUN, ExternFuncRegDO.PARAMSSTR };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "外挂函数", "全路径名", "参数个数" };
	}

	@Override
	public String getPkFieldCode() {
		return ExternFuncRegDO.ID_EXTERNFUN;
	}

	@Override
	public String getRefCodeField() {
		return ExternFuncRegDO.FULLCLASSNAME;
	}

	@Override
	public String getRefNameField() {
		return ExternFuncRegDO.DISPLAYNAME;
	}

	@Override
	public String getTableName() {
		return new ExternFuncRegDO().getTableName();
	}

	@Override
	public String afterBuilderSql(String sql) {

		return super.afterBuilderSql(sql);
	}

	@Override
	public void addWherePart(String wherePart) {

		getWherePart().add(wherePart);
	}

	@Override
	public String getRefSql() {
		String wherePart = BuildWherePart();
		String orderPart = BuildOrderPart();
		String refSql;
		try {
			if(wherePart != null && !"".equals(wherePart))  {this.getWherePart().add(wherePart);}
			if(orderPart != null && !"".equals(orderPart))  {this.getOrderPart().add(orderPart);}
			refSql = super.getRefSql();

		} finally {
			if(wherePart != null && !"".equals(wherePart))  {this.getWherePart().remove(wherePart);}
			if(orderPart != null && !"".equals(orderPart))  {this.getOrderPart().remove(orderPart);}
		}

		return refSql;
	}

	/**
	 * 构建条件语句
	 * 
	 * @return
	 */
	private String BuildWherePart() {

		StringBuilder stringBuilder = new StringBuilder("1 = 1");
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new ExternFuncRegDO(), false);
		stringBuilder.append(String.format(" and %s ", BdModeWherePart));

		return stringBuilder.toString();
	}

	/**
	 * 构建排序语句
	 * 
	 * @return
	 */
	private String BuildOrderPart() {
		StringBuilder stringBuilder = new StringBuilder();
		return stringBuilder.toString();
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { ExternFuncRegDO.DISPLAYNAME, ExternFuncRegDO.FULLCLASSNAME };
	}

}
