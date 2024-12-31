package iih.bd.mm.meterial.refs;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IBdMmDictCodeConst;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.mmcategory.d.MMCategoryDO;
import iih.bd.srv.medsrv.refs.sql.ip.DrugCheckDisplayMd4IP;
import iih.bd.utils.BdEnvContextUtil;
import xap.mw.core.data.Context;
import xap.sys.appfw.orm.handle.dataobject.DOQuery;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.refinfo.RefGridModel;
import xap.sys.appfw.refinfo.RefResultSet;

public class MeterialRefModel extends RefGridModel {
	@Override
	public String[] getShowFieldCode() {
		return new String[] { MeterialDO.NAME, MeterialDO.SPEC, MeterialDO.SUP_NAME, MeterialDO.CODE, MeterialDO.SRV_NAME, MeterialDO.MMGRP_NAME, MeterialDO.PRICE, MeterialDO.PRICE_IN};
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { MeterialDO.ID_MM, MeterialDO.ID_GRP, MeterialDO.ID_ORG, MeterialDO.FG_ACTIVE,
				MeterialDO.FG_PRICE, MeterialDO.FG_BATCH, MeterialDO.FG_SKIN, MeterialDO.ID_MMTP, MeterialDO.SD_MMTP,
				MeterialDO.ID_SUP, MeterialDO.ID_UNIT_PKGBASE,
				MeterialDO.NAME_UNIT_PKGBASE, MeterialDO.NAME_UNIT_PKGSP, MeterialDO.ID_UNIT_PKGSP,
				MeterialDO.FACTOR_SB, MeterialDO.ID_MMCA, MeterialDO.PLACE, MeterialDO.SD_PRIMODE,
				MeterialDO.RATE_PAP, MeterialDO.MMTP_NAME,MeterialDO.ID_SRV, MeterialDO.FG_STOP_MMPO, MeterialDO.FG_STOP_MMTR,MeterialDO.SRV_CODE};
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { MeterialDO.CODE, MeterialDO.NAME, MeterialDO.PYCODE, MeterialDO.WBCODE,
				MeterialDO.MNECODE };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "物品名称", "物品规格", "生产厂家", "物品编码", "通用名", "物品分组", "售价", "进价" };
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
	public String getRefSql() {
		String sd_mmtp = (String) this.getExtendAttributeValue("sd_mmtp");
		String id_mmca = (String) this.getExtendAttributeValue("id_mmca");
		String id_mmcainnercode = (String) this.getExtendAttributeValue("id_mmca.innercode");
		String sd_primode = (String) this.getExtendAttributeValue("sd_primode");
		String id_dep = (String) this.getExtendAttributeValue("id_dep");
		String id_wh = (String) this.getExtendAttributeValue("id_wh");
		String id_wh_ap = (String) this.getExtendAttributeValue("id_wh_ap");
		Boolean stockBl = (Boolean) this.getExtendAttributeValue("stockBl");
		Boolean stockBl_MC = (Boolean) this.getExtendAttributeValue("stockBl_MC");
		Boolean redblue = (Boolean) this.getExtendAttributeValue("redblue");
		String id_srv = (String) this.getExtendAttributeValue("id_srv");
		Boolean fg_bl = (Boolean) this.getExtendAttributeValue("fg_bl");
		String whereStr=(String) this.getExtendAttributeValue("where");

		String id_grp = Context.get().getGroupId();
		String id_org = Context.get().getOrgId();

		StringBuffer wherePartBuffer = new StringBuffer("BD_MM.fg_active='Y'");
		wherePartBuffer.append(" and BD_MM.ds=0");

		if (!StringUtils.isBlank(sd_mmtp)) {
			wherePartBuffer.append(" and BD_MM.sd_mmtp like '" + sd_mmtp + "%' ");
		}else{
			//药品类型过滤
			wherePartBuffer.append(" and BD_MM.sd_mmtp like '1%' ");
		}
		

		if (!StringUtils.isBlank(id_mmca)) {
			if (id_mmca.indexOf(',') != -1) {
				String id_mmcasql = SqlUtils.getInSqlByIdsSplit(id_mmca);
				wherePartBuffer.append(
						" and BD_MM.id_mmca in (select id_mmca from BD_MMCA where id_mmca "+id_mmcasql+") ");
			}else {
				DOQuery<MMCategoryDO> doQuery = new DOQuery<MMCategoryDO>(MMCategoryDO.class);
				String[] keys = new String[1];
				keys[0] = id_mmca;
				MMCategoryDO[] categorys = (MMCategoryDO[]) doQuery.query(keys);
				if (categorys == null || categorys.length <= 0) {
					return null;
				}
				String innerCode = categorys[0].getInnercode();
				
				wherePartBuffer.append(
						" and BD_MM.id_mmca in (select id_mmca from BD_MMCA where innercode like '" + innerCode + "%') ");
			}
		}
		
		if(!StringUtils.isBlank(id_mmcainnercode)) {
			wherePartBuffer.append(
					" and BD_MM.id_mmca in (select id_mmca from BD_MMCA where innercode like '" + id_mmcainnercode + "%') ");
		}

		if (!StringUtils.isBlank(id_grp)) {
			wherePartBuffer.append(" and BD_MM.id_grp = '" + id_grp + "' ");
		}

		if (!StringUtils.isBlank(id_org)) {
			wherePartBuffer.append(" and BD_MM.id_org = '" + id_org + "' ");
		}

		if (!StringUtils.isBlank(sd_primode)) {
			wherePartBuffer.append(" and BD_MM.sd_primode = '" + sd_primode + "' ");
		}

		if (!StringUtils.isBlank(id_dep)) {
			wherePartBuffer.append(String.format(
					" and BD_MM.id_mm in (select id_mm from BD_MM_WH where id_dep = '%s' AND　fg_active = 'Y' AND ds = 0)",
					id_dep));
		}

		if (!StringUtils.isBlank(id_wh)) {
			wherePartBuffer.append(String.format(
					" and BD_MM.id_mm in (select id_mm from BD_MM_WH where id_wh = '%s' AND　fg_active = 'Y' AND ds = 0)",
					id_wh));
		}

		if (!StringUtils.isBlank(id_wh_ap)) {
			wherePartBuffer.append(String.format(
					" and BD_MM.id_mm in (select id_mm from BD_MM_WH where id_wh = '%s' AND　fg_active = 'Y' AND ds = 0)",
					id_wh_ap));
		}

		if (!StringUtils.isBlank(id_wh) && stockBl != null && stockBl) {
			if (redblue == null || !redblue) {
				if(fg_bl != null && fg_bl) {
					wherePartBuffer.append(String.format(
							"and BD_MM.id_mm in (select id_mm from MM_BL where id_wh = '%s' AND quan_usable > 0)", id_wh));
				}else {
					wherePartBuffer.append(String.format(
							"and BD_MM.id_mm in (select id_mm from MM_BL where id_wh = '%s' AND quan_usable >= 0)", id_wh));
				}
			} else {
				wherePartBuffer.append(
						String.format("and BD_MM.id_mm in (select id_mm from MM_BL where id_wh = '%s')", id_wh));
			}
		}
		if (!StringUtils.isBlank(id_wh) && stockBl_MC != null && stockBl_MC) {
			if (redblue == null || !redblue) {
				wherePartBuffer.append(String.format(
						"and BD_MM.id_mm in (select id_mm from MC_BL where id_wh = '%s' AND quan_usable >= 0)", id_wh));
			} else {
				wherePartBuffer.append(
						String.format("and BD_MM.id_mm in (select id_mm from MC_BL where id_wh = '%s')", id_wh));
			}
		}

		if (!StringUtils.isBlank(id_srv)) {
			wherePartBuffer.append(String.format(" and BD_MM.id_srv = '%s'", id_srv));
		}
		
		if(StringUtils.isNotEmpty(whereStr)){
			wherePartBuffer.append(" and ");
			wherePartBuffer.append(whereStr);
		}
		String wherePart = wherePartBuffer.toString();
		this.addWherePart(wherePart);
		StringBuffer sql = new StringBuffer();
		sql.append(" select distinct BD_MM.Name,");
		sql.append("  BD_MM.Spec,");
		sql.append("  BD_MM.Sup_name,");
		sql.append("  BD_MM.Code,");
		sql.append("  BD_SRV.NAME SRV_NAME,");
		sql.append("  mmgrp.mmgrp_name, ");
		sql.append("  BD_MM.Price,");
		sql.append("  BD_MM.Price_in,");
		sql.append("  BD_MM.Id_mm,");
		sql.append("  BD_MM.Id_grp,");
		sql.append("  BD_MM.Id_org,");
		sql.append("  BD_MM.Fg_active,");
		sql.append("  BD_MM.Fg_price,");
		sql.append("  BD_MM.Fg_batch,");
		sql.append("  BD_MM.Fg_skin,");
		sql.append("  BD_MM.Id_mmtp,");
		sql.append("  BD_MM.Sd_mmtp,");
		sql.append("  BD_MM.Id_sup,");
		sql.append("  BD_MM.Id_unit_pkgbase,");
		sql.append("  BD_MM.Name_unit_pkgbase,");
		sql.append("  BD_MM.Name_unit_pkgsp,");
		sql.append("  BD_MM.Id_unit_pkgsp,");
		sql.append("  BD_MM.Factor_sb,");
		sql.append("  BD_MM.Id_mmca,");
		sql.append("  BD_MM.Place,");
		sql.append("  BD_MM.Sd_primode,");
		sql.append("  BD_MM.Rate_pap,");
		sql.append("  doc.name as Mmtp_name ,");
		sql.append("  bd_srv.Id_srv, ");
		sql.append("  BD_MM.fg_stop_mmpo, ");
		sql.append("  BD_MM.fg_stop_mmtr, ");
		sql.append("  BD_SRV.code SRV_code ");
		sql.append(" from BD_MM BD_MM");
		sql.append("  left outer join bd_mm_name mm_name ");
		sql.append(" on BD_MM.id_mm=mm_name.id_mm ");
		sql.append("  left outer join bd_srv bd_srv ");
		sql.append(" on BD_MM.id_srv= bd_srv.id_srv ");
		sql.append("  left outer join bd_udidoc doc ");
		sql.append(" on BD_MM.Id_Mmtp=doc.id_udidoc ");
		sql.append("  left outer join bd_udidoclist doclist ");
		sql.append(String.format(" on doc.id_udidoclist=doclist.id_udidoclist and doclist.code='%s'",
				IBdMmDictCodeConst.SD_MMTP));
		
		sql.append(" left outer join (SELECT itm.id_mm, listagg(grp.name, ';') within GROUP (ORDER BY grp.name) AS mmgrp_name ");
		sql.append("  FROM bd_mmgrp grp INNER JOIN bd_mmgrp_itm itm ON grp.ID_MMGRP = itm.id_mmgrp ");
		sql.append(String.format(" WHERE grp.code IN(%s) ", DrugCheckDisplayMd4IP.getInstance().getDrugGroupParam()));
		sql.append("  GROUP BY itm.id_mm) mmgrp ");
		sql.append(" on bd_mm.id_mm = mmgrp.id_mm ");
		
		List<String> whereList = this.getWherePart();
		if (whereList.size() > 0) {
			sql.append(" where 1 = 1 ");
			for (String where : this.getWherePart()) {
				where = where.replace("Id_mm", "BD_MM.Id_mm").replace("BD_MM.BD_MM", "BD_MM").replace("id_srv", "bd_srv.id_srv").replace("bd_srv.bd_srv", "bd_srv").replace("BD_MM.bd_srv", "BD_MM");
				sql.append(" and (").append(where).append(") ");
			}
		}

		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new MeterialDO(), "BD_MM");
		sql.append(String.format(" and %s ", BdModeWherePart));

		sql.append(" order by BD_MM.Code");
		return sql.toString();
	}

	@Override
	public RefResultSet filterRefBlurValue(String blurValue, PaginationInfo pg) {

		String[] fields = this.getBlurFields();
		if (fields == null)
			fields = this.getShowFieldCode();

		StringBuilder buf = new StringBuilder();

		buf.append("( 1<>1");
		for (String field : fields) {

			buf.append(" or lower(" + this.getTableName() + "." + field + ") like lower('%" + blurValue + "%')");
		}
		buf.append(" or lower(mm_name.name) like lower('%");
		buf.append(blurValue);
		buf.append("%')");
		buf.append(" or ");
		buf.append(" lower(mm_name.wbcode) like lower('%");
		buf.append(blurValue);
		buf.append("%')");
		buf.append(" or ");
		buf.append(" lower(mm_name.pycode) like lower('%");
		buf.append(blurValue);
		buf.append("%')");
		buf.append(" or lower(bd_srv.name) like lower('%");
		buf.append(blurValue);
		buf.append("%')");
		buf.append(" or lower(bd_srv.pycode) like lower('%");
		buf.append(blurValue);
		buf.append("%')");
		buf.append(" or lower(bd_srv.wbcode) like lower('%");
		buf.append(blurValue);
		buf.append("%')");
		buf.append(")");

		String str = buf.toString();
		this.addWherePart(str);
		try {
			if (pg == null)
				return this.getRefData();
			else
				return this.getRefData(pg);
		} finally {
			this.removeWherePart(str);
		}
	}
}
