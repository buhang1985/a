package iih.bd.pp.hp.refs;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.hp.d.BdHpPatcaDO;
import iih.bd.pp.hp.d.desc.BdHpPatcaDODesc;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * 医保计划患者身份参照模型
 * 
 * @author hao_wu
 *
 */
public class HpPatCaRefModel extends RefGridModel {
	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { BdHpPatcaDO.NAME_HPPATCA, BdHpPatcaDO.CODE_HPPATCA, };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "医保身份名称", "医保身份编码" };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { BdHpPatcaDO.ID_HPPATCA, BdHpPatcaDO.ID_HP };
	}

	@Override
	public String getPkFieldCode() {
		return BdHpPatcaDO.ID_HPPATCA;
	}

	@Override
	public String getRefCodeField() {
		return BdHpPatcaDO.CODE_HPPATCA;
	}

	@Override
	public String getRefNameField() {
		return BdHpPatcaDO.NAME_HPPATCA;
	}

	@Override
	public String getTableName() {
		return BdHpPatcaDODesc.TABLE_NAME;
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { BdHpPatcaDO.CODE_HPPATCA, BdHpPatcaDO.NAME_HPPATCA };
	}

	@Override
	public String getRefSql() {
		String wherePart = buildWherePart();
		String orderPart = buildOrderPart();
		String refSql;
		try {
			if (StringUtils.isNotBlank(wherePart)) {
				this.getWherePart().add(wherePart);
			}
			if (StringUtils.isNotBlank(orderPart)) {
				this.getOrderPart().add(orderPart);
			}
			refSql = super.getRefSql();

		} finally {
			if (StringUtils.isNotBlank(wherePart)) {
				this.getWherePart().remove(wherePart);
			}
			if (StringUtils.isNotBlank(orderPart)) {
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
	private String buildWherePart() {

		StringBuilder stringBuilder = new StringBuilder("1 = 1");
		stringBuilder.append(" and ds = 0 ");

		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new BdHpPatcaDO(), false);
		stringBuilder.append(String.format(" and %s ", BdModeWherePart));

		String patCaIdsStr = (String) getExtendAttributeValue("id_patcas");
		if (StringUtils.isNotBlank(patCaIdsStr)) {
			String[] patCaIds = patCaIdsStr.split(",");
			stringBuilder.append(" AND EXISTS ");
			stringBuilder.append("(SELECT ID_HPPATCA ");
			stringBuilder.append("FROM bd_hp_patca hppatca ");
			stringBuilder.append("INNER JOIN PI_PAT_CA_HP pipatcahp ");
			stringBuilder.append("ON pipatcahp.id_hp = hppatca.id_hp ");

			String wherePart = String.format("WHERE %s", SqlUtils.getInSqlByIds("pipatcahp.ID_PATCA", patCaIds));
			stringBuilder.append(wherePart);
			stringBuilder.append("AND hppatca.ID_HPPATCA = bd_hp_patca.ID_HPPATCA) ");
		}

		return stringBuilder.toString();
	}

	/**
	 * 构建排序语句
	 * 
	 * @return
	 */
	private String buildOrderPart() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(String.format("%s", BdHpPatcaDO.CODE_HPPATCA));
		return stringBuilder.toString();
	}
}
