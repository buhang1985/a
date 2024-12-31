package iih.bd.srv.medusage.refs;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.medusage.d.MedUsageDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class MedusageRefModel extends RefGridModel {
	// 用法关联的药品服务类型Code查询参数名
	private static final String WHERE_MEDSRVTP_SD = "Sd_srvtp";
	// 用法关联的药品服务Id查询参数名
	private static final String WHERE_MEDSRV_ID = "Id_srv";

	@Override
	public String[] getShowFieldCode() {
		return new String[] { MedUsageDO.NAME, MedUsageDO.CODE };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { MedUsageDO.PYCODE, MedUsageDO.WBCODE, MedUsageDO.MNECODE, MedUsageDO.ID_ROUTE };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "用法名称", "编码" };
	}

	@Override
	public List<String> getOrderPart() {
		List<String> orderPartList = super.getOrderPart();
		if (orderPartList == null) {
			orderPartList = new ArrayList<String>();
		}
		orderPartList.add(MedUsageDO.CODE);
		return orderPartList;
	}

	@Override
	public String getPkFieldCode() {
		return MedUsageDO.ID_ROUTE;
	}

	@Override
	public String getRefCodeField() {
		return MedUsageDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return MedUsageDO.NAME;
	}

	@Override
	public String getTableName() {
		return new MedUsageDO().getTableName();
	}

	@Override
	public String getRefSql() {
		List<String> whereList = this.getWherePart();
		// 解析where子句，得到 Sd_srvtp + Id_Medsrv
		String[] arr_medsrv = this._parseMedsrv(whereList);
		if (whereList != null && whereList.size() > 0 && arr_medsrv != null && arr_medsrv.length > 0) {
			// 诊疗计划单独使用
			// 药品类医嘱，根据 Id_srv 条件，定制参照查询语句
			String sql = this._getRefSqlByMedsrv(arr_medsrv[1]);
			return sql;
		}

		String wherePart = _getRefSqlUsual();
		this.addWherePart(wherePart);

		String where = BdEnvContextUtil.processEnvContext(new MedUsageDO(), false);
		getWherePart().add(where);

		String sql = null;
		try {
			sql = super.getRefSql();
		} finally {
			this.removeWherePart(wherePart);
		}

		return sql;
	}

	/**
	 * 按常规参照生成"用法"查询语句
	 */
	private String _getRefSqlUsual() {
		String srvtp = (String) getExtendAttributeValue("srvtp");
		String sd_srvtp_leftlike = (String) getExtendAttributeValue("sd_srvtp_leftlike");
		String sd_dosage = (String) getExtendAttributeValue("sd_dosage");
		String id_dosage = (String) getExtendAttributeValue("id_dosage");

		StringBuilder wherePart = new StringBuilder(" 1 = 1 ");
		wherePart.append(" and ds = 0 and fg_active = 'Y' ");

		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new MedUsageDO(), false);
		wherePart.append(String.format(" and %s ", BdModeWherePart));

		if (srvtp != null) {
			wherePart.append(String.format(" and id_srvtp='%s'", srvtp));
		}

		if (sd_srvtp_leftlike != null) {
			wherePart.append(String.format(" and sd_srvtp like '%s%%'", sd_srvtp_leftlike));
		}

		if (sd_dosage != null) {
			wherePart.append(String.format(
					" and id_route in (select id_route from bd_route_dosage_ref where sd_dosage = '%s')", sd_dosage));
		}

		if (id_dosage != null) {
			wherePart.append(String.format(
					" and id_route in (select id_route from bd_route_dosage_ref where id_dosage = '%s')", id_dosage));
		}

		return wherePart.toString();
	}

	/**
	 * 对应bug 0077815 <br/>
	 * 1. 药品类医嘱：需要根据"用法关联剂型"过滤，比如：六味地黄软胶囊，剂型是"胶囊"，胶囊类的只有三种用法<br/>
	 * 2. 非药品类医嘱：不需要定制查询
	 * 
	 * @param sqlSelect
	 * @param idMedsrv
	 *            带引号的药品服务项Id
	 */
	private String _getRefSqlByMedsrv(String idMedsrv) {
		String sqlSelect = "select name, code, pycode, wbcode, mnecode, id_route from bd_route";

		StringBuffer str_buf = new StringBuffer();

		// 构造查询语句
		str_buf.append(sqlSelect).append(" where");
		str_buf.append(" id_route in ( select id_route from bd_route_dosage_ref where");
		str_buf.append(" id_dosage in (select id_dosage from bd_srv_drug where id_srv=");
		str_buf.append(idMedsrv).append(")) ");
		List<String> whereList = this.getWherePart();
		for (int i=1;i<whereList.size();i++) {
			str_buf.append("  and  ").append(whereList.get(i));
		}
		str_buf.append(" order by name ");
		String sql = str_buf.toString();
		str_buf.setLength(0);
		str_buf.trimToSize();	
		this.clearWherePart();
		return sql;
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { MedUsageDO.NAME, MedUsageDO.CODE, MedUsageDO.MNECODE, MedUsageDO.PYCODE,
				MedUsageDO.WBCODE };
	}

	/**
	 * 从where子句解析 Sd_srvtp + Id_srv
	 * 
	 * @param whereList
	 * 
	 * @return
	 * @author qi_yongsheng
	 */
	private String[] _parseMedsrv(List<String> whereList) {
		if (null == whereList || whereList.isEmpty())
			return null;

		String where_01 = whereList.get(0);
		if (null == where_01 || where_01.isEmpty())
			return null;

		String[] res_medsrv = new String[] { null, null };

		String str_regx = "([^\\s]+)\\s+(like|=)\\s+([^\\s]+)";
		// where_01 = " Sd_srvtp like 'aa%' and Id_srv = 'bb'";

		Pattern p = Pattern.compile(str_regx);
		Matcher m = p.matcher(where_01);

		int m_grpcnt = 0;
		while (m.find()) {
			m_grpcnt = m.groupCount();
			if (m_grpcnt < 3)
				continue;

			String key = m.group(1);

			if (WHERE_MEDSRVTP_SD.equals(key)) {
				res_medsrv[0] = m.group(3);
			} else if (WHERE_MEDSRV_ID.equals(key)) {
				res_medsrv[1] = m.group(3);
			}
		}

		// 没有解析到 Sd_srvtp 或者 Id_srv，或者解析到的 Sd_srvtp 前缀不是药品服务
		// 修正查询条件（去掉Id_medsrv部分），并按默认查询
		if (null == res_medsrv[0] || res_medsrv[0].isEmpty()
				|| !res_medsrv[0].startsWith(String.format("'%s", IBdSrvDictCodeConst.SD_SRVTP_DRUG))
				|| null == res_medsrv[1] || res_medsrv[1].isEmpty() || "''".equals(res_medsrv[1])) {
			String str_regx_repl = String.format("\\s+(and|)\\s%s[\\s=]+'[\\w.-]*'", WHERE_MEDSRV_ID);
			whereList.set(0, where_01.replaceFirst(str_regx_repl, ""));

			res_medsrv = null;
		}

		return res_medsrv;
	}
	
	
}
