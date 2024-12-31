package iih.bd.res.bed.refs;

import iih.bd.res.bed.d.Bdbed;
import iih.bd.utils.BdEnvContextUtil;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.refinfo.RefGridModel;
/**
 * 就诊专用床位参照，请不要随意修改
 * @author renying
 *
 */
public class BedRefForEn  extends RefGridModel{
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
		String bedTp = (String)getExtendAttributeValue("sd_bedtp");

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
			sb.append(" and bd_bed.fg_act = 'Y'  and bd_bed.ds = '0' ");
			sb.append(getBedTpWhereStr(bedTp));
			sb.append(" order by ");
			sb.append(getBedTpOrderByStr(bedTp));
			sb.append(" bd_bed.fg_appt asc , bd_bed.name asc ");
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
			sb.append(" and bd_bed.fg_act = 'Y'  and bd_bed.ds = '0' ");
			sb.append(getBedTpWhereStr(bedTp));
			sb.append(" order by ");
			sb.append(getBedTpOrderByStr(bedTp));
			sb.append(" bd_bed.fg_appt asc , bd_bed.name asc ");
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
				sb.append(" and bd_bed.fg_act = 'Y' and bd_bed.ds = '0' ");
				sb.append(getBedTpWhereStr(bedTp));
				sb.append(" order by ");
				sb.append(getBedTpOrderByStr(bedTp));
				sb.append(" bd_bed.fg_appt asc , bd_bed.name asc ");
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

	/**
	 * 拼接sd_bedtp的条件，RefParams 针对参数ENIP0108
	 * 如果之后有其他的需求过滤sd_bedtp,用wherePart
	 * @param bedTp
	 * @return
	 */
	private String getBedTpWhereStr(String bedTp){
		if (StringUtil.isEmpty(bedTp)) {
			return "";
		}
		String[] strs = bedTp.split(",");
		int num = 1;
		String whereStr = " and bd_bed.sd_bedtp in (";
		for (String str : strs) {
			whereStr += " '"+str+"' ";
			if (strs.length != num) {
				whereStr += ",";
			}
			num++;
		}
		whereStr += ")";
		return whereStr;
	}
	/**
	 * 拼接sd_bedtp的排序，RefParams 针对参数ENIP0108
	 * 如果之后有其他的需求过滤sd_bedtp,用wherePart
	 * @param bedTp
	 * @return
	 */
	private String getBedTpOrderByStr(String bedTp){
		if (StringUtil.isEmpty(bedTp)) {
			return " bd_bed.sd_bedtp desc, ";
		}
		String[] strs = bedTp.split(",");
		int num = 1;
		String orderStr = " (case bd_bed.sd_bedtp ";
		for (String str : strs) {
			orderStr += " when '"+str+"' then "+num+" ";
			num++;
		}
		orderStr += " end), ";
		return orderStr;
	}
}
