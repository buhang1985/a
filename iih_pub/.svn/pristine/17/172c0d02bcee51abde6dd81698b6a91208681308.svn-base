package iih.bd.mm.meterial.refs;

import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.utils.BdEnvContextUtil;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import xap.sys.appfw.refinfo.RefGridModel;

public class MeterialWithBlRefModel extends RefGridModel {
	@Override
	public String[] getShowFieldCode() {
		return new String[] { MeterialDO.CODE, MeterialDO.NAME, MeterialDO.SPEC, "Wh_name", "Quan_usable",
				"Pkg_unit_name" };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { MeterialDO.ID_MM, MeterialDO.ID_GRP, MeterialDO.ID_ORG, MeterialDO.FG_ACTIVE,
				MeterialDO.FG_PRICE, MeterialDO.FG_BATCH, MeterialDO.FG_SKIN, MeterialDO.ID_MMTP, MeterialDO.ID_SUP,
				MeterialDO.PRICE, MeterialDO.PRICE_IN, MeterialDO.ID_UNIT_PKGBASE, MeterialDO.NAME_UNIT_PKGBASE,
				MeterialDO.NAME_UNIT_PKGSP, MeterialDO.ID_UNIT_PKGSP, MeterialDO.FACTOR_SB, MeterialDO.ID_MMCA,
				MeterialDO.SUP_NAME, MeterialDO.SD_PRIMODE, MeterialDO.RATE_PAP, MeterialDO.MMTP_NAME };
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { MeterialDO.CODE, MeterialDO.NAME };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "物品编码", "物品名称", "物品规格", "仓库", "可用量", "包装单位" };
	}

	@Override
	public String getPkFieldCode() {
		return MeterialDO.ID_MM;
	}

	@Override
	public String getRefCodeField() {
		return MeterialDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return MeterialDO.NAME;
	}

	@Override
	public String getTableName() {
		return new MeterialDO().getTableName();
	}

	@Override
	public List<String> getOrderPart() {
		List<String> orderPart = new ArrayList<String>();
		orderPart.add(MeterialDO.CODE);
		return orderPart;
	}

	@Override
	public String getRefSql() {
		String id_dep = (String) this.getExtendAttributeValue("id_dep");
		String id_srv = (String) this.getExtendAttributeValue("id_srv");

		StringBuffer wherePartBuffer = new StringBuffer();

		if (!StringUtils.isBlank(id_dep)) {
			wherePartBuffer.append(" and bd_wh.id_dep_belong = '" + id_dep + "' ");
		}
		if (!StringUtils.isBlank(id_srv)) {
			wherePartBuffer.append(" and bd_mm.id_srv = '" + id_srv + "' ");
		}
		
		//药品类型过滤
		wherePartBuffer.append(" and BD_MM.sd_mmtp like '1%' ");

		String wherePart = wherePartBuffer.toString();
		this.addWherePart(wherePart);
		StringBuffer sql = new StringBuffer();
		sql.append(" select distinct BD_MM.Code,");
		sql.append("  BD_MM.Name,");
		sql.append("  BD_MM.Spec,");
		sql.append("  BD_MM.Pycode,");
		sql.append("  BD_MM.Wbcode,");
		sql.append("  BD_MM.Mnecode,");
		sql.append("  BD_MM.Id_mm,");
		sql.append("  BD_MM.Id_grp,");
		sql.append("  BD_MM.Id_org,");
		sql.append("  BD_MM.Fg_active,");
		sql.append("  BD_MM.Fg_price,");
		sql.append("  BD_MM.Fg_batch,");
		sql.append("  BD_MM.Fg_skin,");
		sql.append("  BD_MM.Id_mmtp,");
		sql.append("  BD_MM.Id_sup,");
		sql.append("  BD_MM.Price,");
		sql.append("  BD_MM.Price_in,");
		sql.append("  BD_MM.Id_unit_pkgbase,");
		sql.append("  BD_MM.Name_unit_pkgbase,");
		sql.append("  BD_MM.Name_unit_pkgsp,");
		sql.append("  BD_MM.Id_unit_pkgsp,");
		sql.append("  BD_MM.Factor_sb,");
		sql.append("  BD_MM.Id_mmca,");
		sql.append("  BD_MM.Sup_name,");
		sql.append("  BD_MM.Sd_primode,");
		sql.append("  BD_MM.Rate_pap,");
		sql.append("  bd_wh.Id_wh,");
		sql.append("  bd_wh.name Wh_name,");
		sql.append(
				"  nvl2(mm_pkgu.id_mmpkgu, mm_bl.quan_usable / mm_pkgu.factor, mm_bl.quan_usable / BD_MM.factor_sb) Quan_usable,");
		sql.append("  nvl2(mm_pkgu.id_mmpkgu, mm_pkgu.mmpkguname, BD_MM.Name_unit_pkgsp) Pkg_unit_name");
		sql.append(" from BD_MM");
		sql.append(" inner join (");
		sql.append(
				" select max(quan_usable) quan_usable, id_mm, id_wh from mm_bl group by id_mm, id_wh) mm_bl on bd_mm.id_mm = mm_bl.id_mm");
		sql.append(" inner join bd_mm_wh on mm_bl.id_mm = bd_mm_wh.id_mm and mm_bl.id_wh = bd_mm_wh.id_wh");
		sql.append(" inner join bd_wh on bd_wh.id_wh = mm_bl.id_wh ");
		sql.append(" left join bd_wh_pkgutp pkgtp on pkgtp.id_wh = mm_bl.id_wh and pkgtp.fg_def = 'Y'");
		sql.append(
				" left join bd_mm_pkgu mm_pkgu on mm_pkgu.id_mmpkgutp = pkgtp.id_mmpkgutp and mm_pkgu.id_mm = bd_mm.id_mm");
		sql.append(" where bd_mm.fg_active = 'Y' and bd_mm_wh.fg_active = 'Y' and bd_mm_wh.fg_out = 'N'");
		List<String> whereList = this.getWherePart();
		if (whereList.size() > 0) {
			for (String where : this.getWherePart()) {
				where = where.replace("Id_mm", "BD_MM.Id_mm").replace("BD_MM.BD_MM", "BD_MM");
				sql.append(" and (").append(where).append(") ");
			}
		}

		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new MeterialDO(), "BD_MM");
		sql.append(String.format(" and %s ", BdModeWherePart));

		sql.append(" order by BD_MM.Code");
		return sql.toString();
	}
}
