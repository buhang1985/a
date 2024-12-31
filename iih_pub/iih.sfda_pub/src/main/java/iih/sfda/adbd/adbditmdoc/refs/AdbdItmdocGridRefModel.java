package iih.sfda.adbd.adbditmdoc.refs;

import iih.sfda.adbd.adbditmdoc.d.AdbdItmdocDO;

import java.util.List;

import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.refinfo.RefGridModel;
import xap.sys.permfw.pub.EnvContextUtil;

public class AdbdItmdocGridRefModel extends RefGridModel {
	@Override
	public String[] getShowFieldCode() {
		return new String[] { AdbdItmdocDO.SORTNO, AdbdItmdocDO.NAME, AdbdItmdocDO.CODE };
	}

	public String[] getShowFieldName() {
		return new String[] { "序号", "名称", "编码" };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { AdbdItmdocDO.ID_ITMDOC, AdbdItmdocDO.ID_PARENT };
	}

	@Override
	public String getPkFieldCode() {
		return AdbdItmdocDO.ID_ITMDOC;
	}

	@Override
	public String getRefNameField() {
		return AdbdItmdocDO.NAME;
	}

	@Override
	public String getTableName() {
		return new AdbdItmdocDO().getTableName();
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { AdbdItmdocDO.NAME, AdbdItmdocDO.CODE, AdbdItmdocDO.WBCODE, AdbdItmdocDO.PYCODE, AdbdItmdocDO.MNECODE };
	}

	@Override
	public String getRefSql() {
		StringBuffer sql = new StringBuffer();
		sql.append(" select sfda_adbd_itmdoc.sortno,																								");
		sql.append("        sfda_adbd_itmdoc.name,                                                                                              ");
		sql.append("        sfda_adbd_itmdoc.code,                                                                                         ");
		sql.append("        sfda_adbd_itmdoc.id_itmdoc,                                                                                            ");
		sql.append("        sfda_adbd_itmdoc.id_parent,                                                                                               ");
		sql.append("        sfda_adbd_itmdoc.shortname,                                                                                         ");
		sql.append("        sfda_adbd_itmdoc.id_itmdoclist,                                                                                     ");
		sql.append("        sfda_adbd_itmdoc.des                                                                                          ");
		sql.append(" from sfda_adbd_itmdoc sfda_adbd_itmdoc                                                                                     ");
		sql.append(" inner join sfda_adbd_itmdoclist sfda_adbd_itmdoclist on sfda_adbd_itmdoc.id_itmdoclist=sfda_adbd_itmdoclist.id_itmdoclist  ");
		sql.append(" where sfda_adbd_itmdoc.active_state=2                                                                                      ");
		sql.append("   and (sfda_adbd_itmdoc.ds is null or sfda_adbd_itmdoc.ds = 0)                                                             ");
		String wherePart = BuildWherePart();
		String orderPart = BuildOrderPart();
		if (!StringUtil.isEmptyWithTrim(wherePart)) {
			sql.append(wherePart);
		}
		if (!StringUtil.isEmptyWithTrim(orderPart)) {
			sql.append(orderPart);
		}
		return sql.toString();
	}

	/**
	 * 构建条件语句
	 * 
	 * @return
	 */
	private String BuildWherePart() {
		StringBuilder stringBuilder = new StringBuilder();
		List<String> wherePart = this.getWherePart();
		if (wherePart != null && wherePart.size() > 0) {
			for (String partStr : wherePart) {
				stringBuilder.append(" and " + partStr);
			}
		}
		String NmModeWherePart = EnvContextUtil.processEnvContext("", new AdbdItmdocDO(), false);
		stringBuilder.append(String.format(" and %s ", NmModeWherePart));
		return stringBuilder.toString();
	}

	/**
	 * 构建排序语句
	 * 
	 * @return
	 */
	private String BuildOrderPart() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("order by sfda_adbd_itmdoc." + String.format("%s", AdbdItmdocDO.SORTNO));
		return stringBuilder.toString();
	}
}
