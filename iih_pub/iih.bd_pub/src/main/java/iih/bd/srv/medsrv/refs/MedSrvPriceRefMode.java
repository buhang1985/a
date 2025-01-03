package iih.bd.srv.medsrv.refs;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import iih.bd.base.refs.BdRefGridModel;
import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.pripat.d.PriRateMdEnum;
import iih.bd.srv.medsrv.d.MedSrvDO;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.i.IBaseDO;

/**
 * 医疗服务标准价格参照
 * 
 * @author hao_wu 2019-3-14
 *
 */
public class MedSrvPriceRefMode extends BdRefGridModel {

	private static final long serialVersionUID = 6780666891256313056L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { MedSrvDO.NAME, "name_srvtp", MedSrvDO.MED_NAME, MedSrvDO.PRI, MedSrvDO.CODE };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { MedSrvDO.ID_SRV, MedSrvDO.ID_SRVTP, MedSrvDO.ID_UNIT_MED, MedSrvDO.FG_MM };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "名称", "服务类型", "单位", "参考价格", "编码" };
	}

	@Override
	protected IBaseDO getDo() {
		return new MedSrvDO();
	}

	@Override
	protected String getBaseRefSql() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT bd_srv.name,");
		sqlBuilder.append("srvtp.name AS name_srvtp,");
		sqlBuilder.append("unit.name AS med_name,");
		sqlBuilder.append("NVL(pri_std.price_std,0) AS pri,");
		sqlBuilder.append("bd_srv.code,");
		sqlBuilder.append("bd_srv.id_srv,");
		sqlBuilder.append("bd_srv.id_srvtp,");
		sqlBuilder.append("bd_srv.id_unit_med,");
		sqlBuilder.append("bd_srv.fg_mm ");
		sqlBuilder.append("FROM bd_srv ");
		sqlBuilder.append("INNER JOIN bd_udidoc srvtp ");
		sqlBuilder.append("ON srvtp.id_udidoc = bd_srv.id_srvtp ");
		sqlBuilder.append("LEFT JOIN view_price_rp pri_std ");
		sqlBuilder.append("ON pri_std.id_pripat = '@@@@Z8100000002YL8PO'");
		sqlBuilder.append("AND id_mm = '~' ");
		sqlBuilder.append("AND pri_std.id_srv = bd_srv.id_srv ");
		sqlBuilder.append("LEFT JOIN bd_measdoc unit ");
		sqlBuilder.append("ON unit.id_measdoc = bd_srv.id_unit_med ");
		return sqlBuilder.toString();
	}

	@Override
	protected StringBuilder buildWhereParter() {
		StringBuilder wherePartBuilder = super.buildWhereParter();

		wherePartBuilder.append(
				" and ((bd_srv.sd_primd = '00' and bd_srv.fg_active_bl = 'Y') or (bd_srv.sd_primd <> '00' and bd_srv.fg_active = 'Y'))");

		// 根据主键排除
		String excludeIdStr = (String) this.getExtendAttributeValue("ids_exclude");
		if (StringUtils.isNotBlank(excludeIdStr)) {
			String[] excludeIds = excludeIdStr.split(",");
			if (ArrayUtils.isNotEmpty(excludeIds)) {
				String wherePart = SqlUtils.getNotInSqlByIds("bd_srv.id_srv", excludeIds);
				wherePartBuilder.append(" and ");
				wherePartBuilder.append(wherePart);
			}
		}

		// 查询特殊定价
		String priPatId = (String) this.getExtendAttributeValue("id_pripat_special_pri");
		if (StringUtils.isNotBlank(priPatId)) {
			String wherePart = String.format(
					" and exists (select id_srv from bd_pri_pat_srvorca where Id_pripat = '%s' and EU_PI_PRIRATEMD = %s and id_srv = bd_srv.id_Srv)",
					priPatId, PriRateMdEnum.PRICEMODEL);
			wherePartBuilder.append(wherePart);
		}

		FBoolean mmFlag = (FBoolean) this.getExtendAttributeValue("fg_mm");
		if (mmFlag != null) {
			String wherePart = String.format(" and bd_srv.fg_mm = '%s'", mmFlag);
			wherePartBuilder.append(wherePart);
		}

		// 排除患者价格分类下已定义的特殊定价
		String excludePriPatId = (String) this.getExtendAttributeValue("id_pripat_exclude");
		if (StringUtils.isNotBlank(excludePriPatId)) {
			String wherePart = String.format(
					" and not exists (select id_srv from bd_pri_pat_srvorca where Id_pripat = '%s' and dt_e = '2099-12-31 23:59:59' and id_srv = bd_srv.id_Srv)",
					excludePriPatId);
			wherePartBuilder.append(wherePart);
		}

		return wherePartBuilder;
	}

}
