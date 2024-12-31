package iih.bd.mm.packageunit.refs;

import org.apache.commons.lang.StringUtils;

import iih.bd.mm.packageunit.d.PackageUnitDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class PackageUnitRefModel extends RefGridModel {

	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { PackageUnitDO.CODE, PackageUnitDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { PackageUnitDO.ID_MMPKGUTP, PackageUnitDO.ID_GRP, PackageUnitDO.ID_ORG,
				PackageUnitDO.EN_ERPKGTP, PackageUnitDO.EN_FMPKGTP, PackageUnitDO.EN_IPPKGTP, PackageUnitDO.EN_OPPKGTP,
				PackageUnitDO.EN_PEPKGTP, PackageUnitDO.EN_ER1PKGTP, PackageUnitDO.EN_ER2PKGTP,PackageUnitDO.EN_PIPPKGTP };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return PackageUnitDO.ID_MMPKGUTP;
	}

	@Override
	public String getRefCodeField() {
		return PackageUnitDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return PackageUnitDO.NAME;
	}

	@Override
	public String getTableName() {
		return new PackageUnitDO().getTableName();
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { PackageUnitDO.NAME, PackageUnitDO.CODE, PackageUnitDO.PYCODE, PackageUnitDO.WBCODE,
				PackageUnitDO.INSTR };
	}

	@Override
	public String getRefSql() {
		String wherePart = BuildWherePart();
		String orderPart = BuildOrderPart();
		String refSql;
		try {
			if (wherePart != null && !"".equals(wherePart)) {
				this.getWherePart().add(wherePart);
			}
			if (orderPart != null && !"".equals(orderPart)) {
				this.getOrderPart().add(orderPart);
			}
			refSql = super.getRefSql();

		} finally {
			if (wherePart != null && !"".equals(wherePart)) {
				this.getWherePart().remove(wherePart);
			}
			if (orderPart != null && !"".equals(orderPart)) {
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
		String codeList = (String) this.getExtendAttributeValue("codeList");
		String whId = (String) this.getExtendAttributeValue("id_wh");

		StringBuilder stringBuilder = new StringBuilder("1 = 1");
		stringBuilder.append(" and ds = 0 ");
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new PackageUnitDO(), false);
		stringBuilder.append(String.format(" and %s ", BdModeWherePart));

		if (!StringUtils.isBlank(codeList)) {
			stringBuilder.append(" and code not in " + codeList);
		}

		if (!StringUtils.isBlank(whId)) {
			stringBuilder.append(String.format(
					" and id_mmpkgutp in (select id_mmpkgutp from BD_WH_PKGUTP where ds = 0 and id_wh = '%s') ", whId));
		}

		return stringBuilder.toString();
	}

	/**
	 * 构建排序语句
	 * 
	 * @return
	 */
	private String BuildOrderPart() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(String.format("%s", PackageUnitDO.CODE));
		return stringBuilder.toString();
	}
}
