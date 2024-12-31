package iih.bd.srv.medusage.refs;

import java.util.List;

import com.mysql.jdbc.StringUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.medusage.d.MedUsageDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * 医嘱模板明细用法参照
 * @author Young
 *
 */
public class OrtmplMedusageRefModel extends RefGridModel {

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
		return new String[] { "名称", "编码" };
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
	public void addWherePart(String wherePart) {
		getWherePart().add(wherePart);
	}

	@Override
	public String getRefSql() {
		String sd_srvtp = (String) getExtendAttributeValue("SDSrvtp");
		String str_id_srvs = (String) getExtendAttributeValue("IDSrvs");

		StringBuilder sb = new StringBuilder("select name,code,pycode,wbcode,mnecode,id_route from bd_route where ds=0 and fg_active = 'Y' ");
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new MedUsageDO(), "bd_route");
		sb.append(String.format(" and %s ", BdModeWherePart));

		List<String> oldWherepartArr = this.getWherePart();
		for (String strWhere : oldWherepartArr) {
			sb.append(" and " + strWhere);
		}

		if (!StringUtils.isNullOrEmpty(sd_srvtp)) {
			sb.append(" and sd_srvtp='" + sd_srvtp.substring(0, 2) + "'");
			if (sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG) && !StringUtils.isNullOrEmpty(str_id_srvs)) {
				sb.append(" and id_route in (");
				String[] id_srvs = str_id_srvs.split(",");
				int i = 0;
				for (String id_srv : id_srvs) {
					if (i > 0) {
						sb.append(" intersect ");
					}
					sb.append("(select C.id_route from bd_srv A")
					.append(" left join bd_srv_drug B on A.id_srv=B.id_srv")
					.append(" left join bd_route_dosage_ref C on B.id_dosage=C.id_dosage")
					.append(" where A.id_srv=" + id_srv + ")");
					i++;
				}
				sb.append(")");
			}
		}

		sb.append(" order by code");
		return sb.toString();
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { MedUsageDO.NAME, MedUsageDO.CODE, MedUsageDO.MNECODE, MedUsageDO.PYCODE, MedUsageDO.WBCODE };
	}
}
