package iih.bd.res.dayslot.refs;

import java.util.List;

import iih.bd.res.dayslot.d.DaysLotDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class DaylotRegRefModel extends RefGridModel {

	@Override
	public String[] getShowFieldCode() {
		return new String[] { DaysLotDO.CODE, DaysLotDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { DaysLotDO.ID_DAYSLOT };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return DaysLotDO.ID_DAYSLOT;
	}

	@Override
	public String getRefCodeField() {
		return DaysLotDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return DaysLotDO.NAME;
	}

	@Override
	public String getRefSql() {
		String datelotCaStr = (String) this.getExtendAttributeValue("dayslotca");
		String whereParamStr = (String) this.getExtendAttributeValue("whereparamstr");
		StringBuilder sqlBuilder = new StringBuilder();
		List<String> whereList = this.getWherePart();
		// if(whereParamStr != null && !whereParamStr.equals("")){
		if (!(whereList.size() > 0)) {
			sqlBuilder.append("select code,name,id_dayslot from");
			sqlBuilder.append(" (");
		}
		// }
		sqlBuilder.append("select code,name,id_dayslot,time_begin from");
		sqlBuilder.append(" (");
		sqlBuilder.append("select days.code,days.name,days.id_dayslot,days.time_begin from BD_DAYSLOT days ");
		sqlBuilder.append(" Where 1=1  and days.fg_active = 'Y' ");
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new DaysLotDO(), "days");
		sqlBuilder.append(String.format(" and %s ", BdModeWherePart));
		if (datelotCaStr != null) {
			sqlBuilder.append(" And days.id_dayslotca = (select id_dayslottp from sc_ca where sd_sctp='" + datelotCaStr
					+ "') ORDER BY days.TIME_BEGIN");
		}
		sqlBuilder.append(") DAYSLOT ");

		if (whereList.size() > 0) {
			sqlBuilder.append(" where 1=1 ");
			for (String where : this.getWherePart()) {
				sqlBuilder.append(" And (").append(where).append(") ");
			}
		}

		if (whereParamStr != null && !whereParamStr.equals("") && !(whereList.size() > 0)) {
			sqlBuilder.append(" where " + whereParamStr);
		}
		if (!(whereList.size() > 0)) {
			sqlBuilder.append(
					" union select 'QB' as code,'全部' as name, '99999999999999999999' as ID_DAYSLOT,'24:00:00' from BD_DAYSLOT");
			sqlBuilder.append(")");
			sqlBuilder.append(" order by time_begin");
		}
		// }
		return sqlBuilder.toString();
	}

	@Override
	public String getTableName() {
		return "DAYSLOT";
	}
}
