package iih.bd.fc.quesite.refs;

import java.util.List;

import iih.bd.fc.quesite.d.QueSiteDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * 诊间参照 诊间只是站点的诊间字段集合
 * 
 * @author yank
 *
 */
public class RoomRefModel extends RefGridModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { "Room" };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "名称" };
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { "Room" };
	}

	@Override
	public String getRefTitle() {
		return "诊间参照";
	}

	@Override
	public String getPkFieldCode() {
		return "Room";
	}

	@Override
	public String getRefNameField() {
		return "Room";
	}

	@Override
	public String getTableName() {
		return "BS";
	}

	@Override
	public String getRefSql() {
		String sql = " SELECT DISTINCT ROOM FROM BD_QUE_SITE BS ";

		String wherePart = BuildWherePart();
		String orderPart = BuildOrderPart();
		String refSql;
		try {
			if(wherePart != null && !"".equals(wherePart))  {this.getWherePart().add(wherePart);}
			if(orderPart != null && !"".equals(orderPart))  {this.getOrderPart().add(orderPart);}

			StringBuilder refSqlBuilder = new StringBuilder();
			refSqlBuilder.append(sql);

			List<String> whereList = this.getWherePart();
			if (whereList.size() > 0) {
				refSqlBuilder.append(" WHERE 1 = 1 ");
				for (String where : this.getWherePart()) {
					refSqlBuilder.append(" And (").append(where).append(") ");
				}

			}

			refSqlBuilder.append(" AND BS.ROOM IS NOT NULL ");

			List<String> orderPartList = this.getOrderPart();
			if (orderPartList != null && orderPartList.size() > 0) {
				refSqlBuilder.append(String.format(" order by %s", orderPartList.get(0)));
				for (int i = 1; i < orderPartList.size(); i++) {
					refSqlBuilder.append(String.format(" ,%s ", orderPartList.get(i)));
				}
			}

			refSql = refSqlBuilder.toString();

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
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new QueSiteDO(), "BS");
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

}
