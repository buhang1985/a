package iih.bd.res.bed.refs;

import org.apache.commons.lang.StringUtils;

import iih.bd.res.bed.d.BedAttrDefDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class BedAttrDefModel extends RefGridModel {

	@Override
	public String[] getShowFieldCode() {
		return new String[] { BedAttrDefDO.NAME, BedAttrDefDO.VAL };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { BedAttrDefDO.ID_BEDATTRDEF, BedAttrDefDO.SD_BEDATTR_TP };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "特征值名称", "特征值" };
	}

	@Override
	public String getPkFieldCode() {
		return BedAttrDefDO.ID_BEDATTRDEF;
	}

	@Override
	public String getRefNameField() {
		return BedAttrDefDO.NAME;
	}

	@Override
	public String getTableName() {
		return new BedAttrDefDO().getTableName();
	}

	@Override
	public String getRefSql() {
		String wherePart = BuildWherePart();

		this.addWherePart(wherePart);
		String sql = null;
		try {
			sql = super.getRefSql();
		} finally {
			this.removeWherePart(wherePart);
		}
		sql += " order by Val";
		return sql;
	}

	/**
	 * 构建条件片断
	 * 
	 * @return
	 */
	private String BuildWherePart() {
		String id_bedattr_tp = (String) this.getExtendAttributeValue("Id_bedattr_tp");
		String sd_bedattr_tp = (String) this.getExtendAttributeValue("Sd_bedattr_tp");

		StringBuffer wherePartBuffer = new StringBuffer();
		wherePartBuffer.append("1 = 1");
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new BedAttrDefDO(), false);
		wherePartBuffer.append(String.format(" and %s ", BdModeWherePart));

		if (!StringUtils.isBlank(id_bedattr_tp)) {
			wherePartBuffer.append(String.format(" and id_bedattr_tp = '%s' ", id_bedattr_tp));
		}

		if (!StringUtils.isBlank(sd_bedattr_tp)) {
			wherePartBuffer.append(String.format("  and Sd_bedattr_tp = '%s'", sd_bedattr_tp));
		}

		String orgWhere = BdEnvContextUtil.processEnvContext( new BedAttrDefDO(), false);
		wherePartBuffer.append(String.format(" and %s ", orgWhere));
		String wherePart = wherePartBuffer.toString();
		return wherePart;
	}

}
