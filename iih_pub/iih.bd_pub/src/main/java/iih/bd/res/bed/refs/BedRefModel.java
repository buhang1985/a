package iih.bd.res.bed.refs;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import iih.bd.res.bed.d.Bdbed;
import iih.bd.utils.BdEnvContextUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class BedRefModel extends RefGridModel {

	@Override
	public String[] getShowFieldCode() {
		return new String[] { Bdbed.CODE, Bdbed.NAME, "Name_tp_bed", "name_bedsex", "sd_bedsexlimit"};
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] {Bdbed.FG_APPT, Bdbed.SD_BEDTP,Bdbed.ID_BED  };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称", "床位类型", "床位性别", "床位性别编码" };
	}

	@Override
	public String getPkFieldCode() {
		return Bdbed.ID_BED;
	}

	@Override
	public String getRefCodeField() {
		return Bdbed.CODE;
	}

	@Override
	public String getRefNameField() {
		return Bdbed.NAME;
	}

	@Override
	public String getTableName() {
		return "bd_bed";
	}

	@Override
	public String getRefSql() {

		String depId = (String) getExtendAttributeValue("id_dep");
		String bedSu = (String) getExtendAttributeValue("sd_bedsu");
		String oldBedId = (String) getExtendAttributeValue("id_bed_old");

		String sql = "select * from (select bd_bed.code,  " + "CASE WHEN bd_bed.fg_appt = 'Y' THEN concat('[预]', bd_bed.name)  ELSE bd_bed.name END as name, "
				+ "udi.name name_tp_bed,bedsex.name name_bedsex,"
				+ "bd_bed.sd_bedsexlimit, bd_bed.fg_appt, bd_bed.SD_BEDTP,bd_bed.id_bed ";
		StringBuilder sb = new StringBuilder(sql);

		if (!StringUtil.isEmpty(depId) && !StringUtils.isEmpty(bedSu) && StringUtil.isEmpty(oldBedId)) {
			sql += " from bd_bed left join bd_udidoc udi on bd_bed.id_bedtp = udi.id_udidoc "
					+ "left join bd_udidoc bedsex on bd_bed.id_bedsexlimit = bedsex.id_udidoc "
					+ "where bd_bed.sd_bedsu='" + bedSu + "'" + " and bd_bed.id_dep_belong='" + depId + "'";
			sb = new StringBuilder(sql);
			List<String> whereList = this.getWherePart();
			if (whereList.size() > 0) {
				for (String where : this.getWherePart()) {
					sb.append(" and (").append(where).append(") ");
				}
			}
			String BdModeWherePart = BdEnvContextUtil.processEnvContext( new Bdbed(), false);
			sb.append(String.format(" and %s ", BdModeWherePart));
			sb.append(" and bd_bed.fg_act = 'Y'  and bd_bed.ds = '0' order  by bd_bed.fg_appt Asc , bd_bed.name Asc");
		} else if (!StringUtil.isEmpty(depId) && !StringUtils.isEmpty(bedSu) && !StringUtil.isEmpty(oldBedId)) {
			sql += ", CASE WHEN bd_bed.id_bed = '" + oldBedId + "' then 0 else 1 end as priority from bd_bed "
					+ "left join bd_udidoc udi on bd_bed.id_bedtp = udi.id_udidoc "
					+ "left join bd_udidoc bedsex on bd_bed.id_bedsexlimit = bedsex.id_udidoc where bd_bed.id_bed ='"
					+ oldBedId + "' or(" + "bd_bed.sd_bedsu='" + bedSu + "'" + " and bd_bed.id_dep_belong='" + depId + "')";
			sb = new StringBuilder(sql);
			List<String> whereList = this.getWherePart();
			if (whereList.size() > 0) {
				for (String where : this.getWherePart()) {
					sb.append(" and (").append(where).append(") ");
				}
			}
			String BdModeWherePart = BdEnvContextUtil.processEnvContext(new Bdbed(), false);
			sb.append(String.format(" and %s ", BdModeWherePart));
			sb.append(" and bd_bed.fg_act = 'Y'  and bd_bed.ds = '0' order by priority, bd_bed.fg_appt Asc , bd_bed.name Asc");
		} else {
			List<String> whereList = this.getWherePart();
			if (whereList.size() > 0) {
				sb.append("  from bd_bed left join bd_udidoc udi on bd_bed.id_bedtp = udi.id_udidoc "
						+ "left join bd_udidoc bedsex on bd_bed.id_bedsexlimit = bedsex.id_udidoc where 1 = 1 ");
				String BdModeWherePart = BdEnvContextUtil.processEnvContext(new Bdbed(), false);
				sb.append(String.format(" and %s ", BdModeWherePart));
				for (String where : this.getWherePart()) {
					sb.append(" and (").append(where).append(") ");
				}
				sb.append(" and bd_bed.fg_act = 'Y' and bd_bed.ds = '0' order  by bd_bed.fg_appt Asc , bd_bed.name Asc");
			}
			// TODO 重构，这不应有潜规则
			else {
				sb.append("  from bd_bed left join bd_udidoc udi on bd_bed.id_bedtp = udi.id_udidoc "
						+ "left join bd_udidoc bedsex on bd_bed.id_bedsexlimit = bedsex.id_udidoc where 1 = 2 ");
			}
		}
		
		sb.append(" ) bd_bed");

		return sb.toString();
	}
	
	@Override
	public String[] getBlurFields() {
		return new String[] { Bdbed.CODE, Bdbed.NAME };
	}

}
