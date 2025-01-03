package iih.bd.mm.meterial.refs;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import iih.bd.base.refs.BdRefGridModel;
import iih.bd.base.utils.SqlUtils;
import iih.bd.mm.meterial.d.MMAliasDO;
import iih.bd.mm.meterial.d.MeterialDO;
import xap.mw.coreitf.i.IBaseDO;

/**
 * 药品（带通用名）参照模型
 * 
 * @author hao_wu 2019-3-14
 *
 */
public class DrugAndNameRefModel extends BdRefGridModel {

	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { MeterialDO.NAME, MeterialDO.SRV_NAME, MeterialDO.NAME_UNIT_PKGSP, MeterialDO.PRICE,
				MeterialDO.SPEC, MeterialDO.SUP_NAME, MeterialDO.CODE };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { MeterialDO.ID_MM, MeterialDO.ID_SRV, MeterialDO.FG_SKIN, MeterialDO.ID_MMTP,
				MeterialDO.SD_MMTP, MeterialDO.MMTP_NAME, MeterialDO.ID_SUP };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "药品名称", "通用名称", "包装单位", "参考价", "物品规格", "生产厂家", "物品编码" };
	}

	@Override
	protected String getBaseRefSql() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("select bd_mm.name,");
		sqlBuilder.append("srv.name as srv_name,");
		sqlBuilder.append("unit_sp.name as name_unit_pkgsp,");
		sqlBuilder.append("pri_mm.price_ratio as price,");
		sqlBuilder.append("bd_mm.spec,");
		sqlBuilder.append("bd_mm.sup_name,");
		sqlBuilder.append("bd_mm.code,");
		sqlBuilder.append("bd_mm.id_mm,");
		sqlBuilder.append("bd_mm.id_srv,");
		sqlBuilder.append("bd_mm.fg_skin,");
		sqlBuilder.append("bd_mm.id_mmtp,");
		sqlBuilder.append("bd_mm.sd_mmtp,");
		sqlBuilder.append("mmtp.name as mmtp_name ,");
		sqlBuilder.append("bd_mm.id_sup ");
		sqlBuilder.append("from bd_mm ");
		sqlBuilder.append("inner join bd_srv srv ");
		sqlBuilder.append("on srv.id_srv = bd_mm.id_srv ");
		sqlBuilder.append("inner join bd_udidoc mmtp ");
		sqlBuilder.append("on bd_mm.id_mmtp=mmtp.id_udidoc ");
		sqlBuilder.append("inner join bd_measdoc unit_sp ");
		sqlBuilder.append("on unit_sp.id_measdoc = bd_mm.id_unit_pkgsp ");
		sqlBuilder.append("inner join view_price_rp pri_mm ");
		sqlBuilder.append("on pri_mm.id_pripat = '@@@@Z8100000002YL8PO' ");
		sqlBuilder.append("and pri_mm.id_mm = bd_mm.id_mm ");
		sqlBuilder.append("and pri_mm.id_unit = bd_mm.id_unit_pkgsp ");
		return sqlBuilder.toString();
	}

	@Override
	protected String buildWherePart() {
		StringBuilder wherePartBuilder = new StringBuilder();

		String wherePart = super.buildWherePart();
		wherePartBuilder.append(wherePart);

		// 启用标识
		wherePartBuilder.append(" and BD_MM.fg_active='Y'");

		String sd_mmtp = (String) this.getExtendAttributeValue("sd_mmtp");
		String sd_primode = (String) this.getExtendAttributeValue("sd_primode");
		String id_dep = (String) this.getExtendAttributeValue("id_dep");
		String id_wh = (String) this.getExtendAttributeValue("id_wh");
		String id_srv = (String) this.getExtendAttributeValue("id_srv");

		if (StringUtils.isNotBlank(sd_mmtp)) {
			// 药品类型
			wherePart = String.format(" and BD_MM.sd_mmtp like '%s%%'", sd_mmtp);
			wherePartBuilder.append(wherePart);
		}

		if (StringUtils.isNotBlank(sd_primode)) {
			// 售价计算模式
			wherePart = String.format(" and BD_MM.sd_primode = '%s'", sd_primode);
			wherePartBuilder.append(wherePart);
		}

		if (StringUtils.isNotBlank(id_dep)) {
			// 科室
			wherePart = String.format(
					" and BD_MM.id_mm in (select id_mm from BD_MM_WH where id_dep = '%s' AND　fg_active = 'Y' AND ds = 0)",
					id_dep);
			wherePartBuilder.append(wherePart);
		}

		if (StringUtils.isNotBlank(id_wh)) {
			// 仓库
			wherePart = String.format(
					" and BD_MM.id_mm in (select id_mm from BD_MM_WH where id_wh = '%s' AND　fg_active = 'Y' AND ds = 0)",
					id_wh);
			wherePartBuilder.append(wherePart);
		}

		if (StringUtils.isNotBlank(id_srv)) {
			// 通用名主键
			wherePart = String.format(" and BD_MM.id_srv = '%s'", id_srv);
			wherePartBuilder.append(wherePart);
		}

		// 根据主键排除
		String excludeIdStr = (String) this.getExtendAttributeValue("ids_exclude");
		if (StringUtils.isNotBlank(excludeIdStr)) {
			String[] excludeIds = excludeIdStr.split(",");
			if (ArrayUtils.isNotEmpty(excludeIds)) {
				wherePart = SqlUtils.getNotInSqlByIds("bd_mm.id_mm", excludeIds);
				wherePartBuilder.append(" and ");
				wherePartBuilder.append(wherePart);
			}
		}

		return wherePartBuilder.toString();
	}

	@Override
	protected IBaseDO getDo() {
		return new MeterialDO();
	}

	@Override
	protected IBaseDO getAliasDo() {
		return new MMAliasDO();
	}

	@Override
	public String[] getAliasBlurFields() {
		return new String[] { MMAliasDO.PYCODE, MMAliasDO.MNECODE, MMAliasDO.NAME, MMAliasDO.WBCODE };
	}

}
