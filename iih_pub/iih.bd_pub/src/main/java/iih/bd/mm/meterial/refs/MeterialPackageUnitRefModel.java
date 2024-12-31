package iih.bd.mm.meterial.refs;

import iih.bd.mm.meterial.d.MMPackageUnitDO;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import xap.sys.appfw.refinfo.RefGridModel;

public class MeterialPackageUnitRefModel extends RefGridModel {
	@Override
	public String[] getShowFieldCode() {
		return new String[] { MMPackageUnitDO.MMPKGUNAME, MMPackageUnitDO.FACTOR, MMPackageUnitDO.MMPKGUTP_NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { MMPackageUnitDO.ID_MMPKGU, MMPackageUnitDO.ID_MM, MMPackageUnitDO.SD_MMPKGUPRO,
				MMPackageUnitDO.ID_MMPKGUTP, MMPackageUnitDO.ID_UNIT_PKG };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "物品包装单位", "换算系数", "包装单位类型" };
	}
	
	@Override
	public String[] getBlurFields() {
		return new String[] { MMPackageUnitDO.MMPKGUNAME };
	}

	@Override
	public String getPkFieldCode() {
		return MMPackageUnitDO.ID_MMPKGU;
	}

	@Override
	public String getRefCodeField() {
		return MMPackageUnitDO.ID_MMPKGU;
	}

	@Override
	public String getRefNameField() {
		return MMPackageUnitDO.MMPKGUNAME;
	}

	@Override
	public String getTableName() {
		return new MMPackageUnitDO().getTableName();
	}

	@Override
	public String getRefSql() {
		String id_mm = (String) this.getExtendAttributeValue("id_mm");
		String id_wh = (String) this.getExtendAttributeValue("id_wh");
		String id_wh_ap = (String) this.getExtendAttributeValue("id_wh_ap");

		StringBuffer wherePartBuffer = new StringBuffer();
		wherePartBuffer.append("BD_MM_PKGU.ds=0");
		if (!StringUtils.isBlank(id_mm)) {
			wherePartBuffer.append(" and BD_MM_PKGU.id_mm = '" + id_mm + "' ");
		}

		if (!StringUtils.isBlank(id_wh) && StringUtils.isBlank(id_wh_ap)) {
			wherePartBuffer.append(String.format(
					" and BD_MM_PKGU.id_mmpkgutp in (select id_mmpkgutp from BD_WH_PKGUTP where id_wh = '%s' AND ds = 0)",
					id_wh));
		}

		if (!StringUtils.isBlank(id_wh) && !StringUtils.isBlank(id_wh_ap)) {
			String condition1 = String.format(
					"(BD_MM_PKGU.id_mmpkgutp in (select id_mmpkgutp from BD_WH_PKGUTP where id_wh = '%s' AND ds = 0))",
					id_wh);
			String condition2 = String.format(
					"(BD_MM_PKGU.id_mmpkgutp in (select id_mmpkgutp from BD_WH_PKGUTP where id_wh = '%s' AND ds = 0))",
					id_wh_ap);
			String condition = String.format("%s or %s", condition1, condition2);
			wherePartBuffer.append(String.format(" and (%s)", condition));
		}

		String wherePart = wherePartBuffer.toString();
		this.addWherePart(wherePart);
		StringBuffer sql = new StringBuffer();
		sql.append(" select BD_MM_PKGU.mmpkguname, ");
		sql.append(" BD_MM_PKGU.factor, ");
		sql.append(" bd_mm_pkgutp.name Mmpkgutp_name, ");
		sql.append(" BD_MM_PKGU.id_mmpkgu, ");
		sql.append(" BD_MM_PKGU.id_mm, ");
		sql.append(" BD_MM_PKGU.sd_mmpkgupro, ");
		sql.append(" BD_MM_PKGU.id_mmpkgutp, ");
		sql.append(" BD_MM_PKGU.id_unit_pkg ");
		sql.append(" from BD_MM_PKGU ");
		sql.append(" left join bd_mm_pkgutp on BD_MM_PKGU.id_mmpkgutp = bd_mm_pkgutp.id_mmpkgutp ");
		List<String> whereList = this.getWherePart();
		if (whereList.size() > 0) {
			sql.append(" where 1 = 1 ");
			for (String where : this.getWherePart()) {
				sql.append(" and (").append(where).append(") ");
			}
		}

		return sql.toString();
	}
}
