package iih.bd.srv.udidoc.refs;

import org.apache.commons.lang.StringUtils;

import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.d.UdidoclistDO;

/**
 * 处方标识_显示名称参照模型</br>
 * CI.OR.0800
 * 
 * @author hao_wu
 *
 */
public class PresTpWordRefModel extends RefGridModel {

	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { UdidocDO.CTRL1 };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { UdidocDO.ID_UDIDOC, UdidocDO.CODE, UdidocDO.NAME };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "显示名称" };
	}

	@Override
	public String getPkFieldCode() {
		return UdidocDO.ID_UDIDOC;
	}

	@Override
	public String getRefCodeField() {
		return UdidocDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return UdidocDO.CTRL1;
	}

	@Override
	public String getTableName() {
		return new UdidocDO().getTableName();
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { UdidocDO.NAME, UdidocDO.CODE, UdidocDO.PYCODE, UdidocDO.WBCODE, UdidocDO.MNECODE,
				UdidocDO.CTRL1 };
	}

	@Override
	public String getRefSql() {
		String wherePart = BuildWherePart();
		String orderPart = BuildOrderPart();
		String refSql;
		try {
			if (StringUtils.isNotEmpty(wherePart)) {
				this.getWherePart().add(wherePart);
			}
			if (StringUtils.isNotEmpty(orderPart)) {
				this.getOrderPart().add(orderPart);
			}

			refSql = super.getRefSql();

		} finally {
			if (StringUtils.isNotEmpty(wherePart)) {
				this.getWherePart().remove(wherePart);
			}
			if (StringUtils.isNotEmpty(orderPart)) {
				this.getOrderPart().remove(orderPart);
			}
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
		stringBuilder.append(" and ds = 0");
		stringBuilder.append(" and CTRL1 is not null");

		String wherePart = getDocListWherePart();
		stringBuilder.append(" and ");
		stringBuilder.append(wherePart);

		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new UdidocDO(), false);
		stringBuilder.append(String.format(" and %s", BdModeWherePart));

		return stringBuilder.toString();
	}

	/**
	 * 获取档案列表条件片段
	 * 
	 * @return
	 */
	private String getDocListWherePart() {
		StringBuilder sqlBuilder = new StringBuilder();

		sqlBuilder.append("id_udidoclist in (");

		sqlBuilder.append("select id_udidoclist from bd_udidoclist where code = 'CI.OR.0800'");

		String wherePart = BdEnvContextUtil.processEnvContext(new UdidoclistDO(), false);
		sqlBuilder.append(" and ");
		sqlBuilder.append(wherePart);

		sqlBuilder.append(")");
		return sqlBuilder.toString();
	}

	/**
	 * 构建排序语句
	 * 
	 * @return
	 */
	private String BuildOrderPart() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(String.format("%s", UdidocDO.CODE));
		return stringBuilder.toString();
	}
}
