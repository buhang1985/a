package iih.mp.dg.ipbaseticdrugratio;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import xap.dp.report.data.reader.sql.SqlReader;
import xap.sys.jdbc.handler.BeanListHandler;

public class IpBaseTicDrugRatioService {

	public List<IpBaseTicDrugRatioDTO> exec(String wholeHosOrIpOrOp, String begainDt, String endDt, String disCharDrug)
			throws Exception {
		if ("".equals(wholeHosOrIpOrOp) || wholeHosOrIpOrOp == null) {
			return getWholeHosData(begainDt, endDt, disCharDrug);
		} else if ("0".equals(wholeHosOrIpOrOp)) {
			return getOpData(begainDt, endDt);
		} else if ("1".equals(wholeHosOrIpOrOp)) {
			return getIpData(begainDt, endDt, disCharDrug);
		}
		return null;
	}

	private List<IpBaseTicDrugRatioDTO> getIpData(String begainDt, String endDt, String disCharDrug) throws Exception {
		StringBuffer strSql = new StringBuffer();
		strSql.append("SELECT depname,													  ");
		strSql.append("  usebasedrugtype,													  ");
		strSql.append("  basedruptype,														  ");
		strSql.append("  ROUND(usebasedrugtype/basedruptype,4) configratio,							  ");
		strSql.append("  sumbaseprice,														  ");
		strSql.append("  sumdrugprice,														  ");
		strSql.append("  ROUND(sumbaseprice/sumdrugprice,4) amountratio							  ");
		strSql.append("FROM																  ");
		strSql.append("  (SELECT depname,													  ");
		strSql.append("    COUNT(mmcode) usebasedrugtype,										  ");
		strSql.append("    (SELECT COUNT(*) FROM bd_mm WHERE SD_BASEDRUGRANGE = '01') basedruptype,	  ");
		strSql.append("    sumbaseprice,														  ");
		strSql.append("    sumdrugprice														  ");
		strSql.append("  FROM															  ");
		strSql.append("    (SELECT DISTINCT bddep.name depname,								  ");
		strSql.append("      bdmm.code mmcode,												  ");
		strSql.append("      sumbase.sumbaseprice,												  ");
		strSql.append("      sumdrug.sumdrugprice												  ");
		strSql.append("    FROM mp_dg_ip_apde_dt mpdgipdt										  ");
		strSql.append("    JOIN en_ent enent													  ");
		strSql.append("    ON mpdgipdt.id_ent = enent.id_ent										  ");
		strSql.append("    JOIN bd_dep bddep													  ");
		strSql.append("    ON bddep.id_dep = ENENT.ID_DEP_NUR									  ");
		strSql.append("    JOIN bd_mm bdmm													  ");
		strSql.append("    ON bdmm.id_mm = mpdgipdt.id_mm										  ");
		strSql.append("    JOIN															  ");
		strSql.append("      (SELECT * FROM													  ");
		strSql.append("        (SELECT mpdgipdt.ID_DEP_NUR,										  ");
		strSql.append("          SUM(ROUND(mpdgipdt.quan_ap * mpdgipdt.price,2)) sumbaseprice			  ");
		strSql.append("        FROM MP_DG_IP_APDE_DT mpdgipdt									  ");
		strSql.append("        JOIN bd_mm bdmm												  ");
		strSql.append("        ON bdmm.id_mm = mpdgipdt.id_mm									  ");
		strSql.append("        WHERE bdmm.SD_BASEDRUGRANGE = '01'								  ");
		strSql.append("        AND NVL(mpdgipdt.id_dgipde, '~') <> '~'								  ");
		strSql.append("        AND mpdgipdt.en_opde = 1											  ");
		if (!StringUtils.isBlank(begainDt) && !"".equals(begainDt.trim())) {
			strSql.append(" AND mpdgipdt.dt_mp_plan  >= '" + begainDt + " 00:00:00'");
		}
		if (!StringUtils.isBlank(endDt) && !"".equals(endDt.trim())) {
			strSql.append(" AND mpdgipdt.dt_mp_plan  <= '" + endDt + " 23:59:59' ");
		}
		if (!StringUtils.isBlank(endDt) && !"".equals(endDt.trim())) {
			strSql.append(" AND mpdgipdt.dt_mp_plan  <= '" + endDt + " 23:59:59' ");
		}
		if (!StringUtils.isBlank(disCharDrug) && !"".equals(disCharDrug.trim())) {
			if ("Y".equals(disCharDrug)) {
				strSql.append("AND mpdgipdt.fg_pres_outtp  = '" + disCharDrug + "' ");
			} else {
				strSql.append("AND mpdgipdt.fg_pres_outtp  = '" + disCharDrug + "' ");
			}
		}
		strSql.append("        GROUP BY mpdgipdt.ID_DEP_NUR										  ");
		strSql.append("        ) sumbase														  ");
		strSql.append("      WHERE sumbaseprice <> 0											  ");
		strSql.append("      ) sumbase ON sumbase.ID_DEP_NUR = ENENT.ID_DEP_NUR					  ");
		strSql.append("    JOIN															  ");
		strSql.append("      (SELECT * FROM													  ");
		strSql.append("        (SELECT mpdgipdt.ID_DEP_NUR,										  ");
		strSql.append("          SUM(ROUND(mpdgipdt.quan_ap * mpdgipdt.price,2)) sumdrugprice			  ");
		strSql.append("        FROM MP_DG_IP_APDE_DT mpdgipdt									  ");
		strSql.append("        WHERE NVL(mpdgipdt.id_dgipde, '~') <> '~'								  ");
		strSql.append("        AND mpdgipdt.en_opde = 1											  ");
		if (!StringUtils.isBlank(begainDt) && !"".equals(begainDt.trim())) {
			strSql.append(" AND mpdgipdt.dt_mp_plan  >= '" + begainDt + " 00:00:00'");
		}
		if (!StringUtils.isBlank(endDt) && !"".equals(endDt.trim())) {
			strSql.append(" AND mpdgipdt.dt_mp_plan  <= '" + endDt + " 23:59:59' ");
		}
		if (!StringUtils.isBlank(disCharDrug) && !"".equals(disCharDrug.trim())) {
			if ("Y".equals(disCharDrug)) {
				strSql.append("AND mpdgipdt.fg_pres_outtp  = '" + disCharDrug + "' ");
			} else {
				strSql.append("AND mpdgipdt.fg_pres_outtp  = '" + disCharDrug + "' ");
			}
		}
		strSql.append("        GROUP BY mpdgipdt.ID_DEP_NUR ) sumdrug								  ");
		strSql.append("      WHERE sumdrugprice <> 0											  ");
		strSql.append("      ) sumdrug														  ");
		strSql.append("    ON sumdrug.ID_DEP_NUR = ENENT.ID_DEP_NUR							  ");
		strSql.append("    WHERE mpdgipdt.sd_srvtp LIKE '01%'									  ");
		strSql.append("    AND mpdgipdt.fg_mm = 'Y'											  ");
		strSql.append("    AND bdmm.SD_BASEDRUGRANGE = '01'									  ");
		strSql.append("    AND NVL(mpdgipdt.id_dgipde, '~') <> '~'									  ");
		strSql.append("    AND mpdgipdt.en_opde = 1											  ");
		if (!StringUtils.isBlank(begainDt) && !"".equals(begainDt.trim())) {
			strSql.append(" AND mpdgipdt.dt_mp_plan  >= '" + begainDt + " 00:00:00'");
		}
		if (!StringUtils.isBlank(endDt) && !"".equals(endDt.trim())) {
			strSql.append(" AND mpdgipdt.dt_mp_plan  <= '" + endDt + " 23:59:59' ");
		}
		if (!StringUtils.isBlank(disCharDrug) && !"".equals(disCharDrug.trim())) {
			if ("Y".equals(disCharDrug)) {
				strSql.append("AND mpdgipdt.fg_pres_outtp  = '" + disCharDrug + "' ");
			} else {
				strSql.append("AND mpdgipdt.fg_pres_outtp  = '" + disCharDrug + "' ");
			}
		}
		strSql.append("    )																  ");
		strSql.append("  GROUP BY depname,													  ");
		strSql.append("    sumbaseprice,														  ");
		strSql.append("    sumdrugprice														  ");
		strSql.append("  )																  ");
		strSql.append("ORDER BY depname													  ");

		return this.getResultBySql(strSql.toString());
	}

	private List<IpBaseTicDrugRatioDTO> getOpData(String begainDt, String endDt) throws Exception {
		StringBuffer strSql = new StringBuffer();
		strSql.append("SELECT depname,													 ");
		strSql.append("  usebasedrugtype,													 ");
		strSql.append("  basedruptype,														 ");
		strSql.append("  ROUND(usebasedrugtype/basedruptype,4) configratio ,							 ");
		strSql.append("  sumbaseprice,														 ");
		strSql.append("  sumdrugprice,														 ");
		strSql.append("  ROUND(sumbaseprice/sumdrugprice,4) amountratio							 ");
		strSql.append("FROM																 ");
		strSql.append("  (SELECT depname,													 ");
		strSql.append("    COUNT(mmcode) usebasedrugtype,										 ");
		strSql.append("    (SELECT COUNT(*) FROM bd_mm WHERE SD_BASEDRUGRANGE = '01') basedruptype,	 ");
		strSql.append("    sumbaseprice,														 ");
		strSql.append("    sumdrugprice														 ");
		strSql.append("  FROM															 ");
		strSql.append("    (SELECT DISTINCT bddep.name depname,								 ");
		strSql.append("      bdmm.code mmcode,												 ");
		strSql.append("      sumbasedrug.sumbaseprice,											 ");
		strSql.append("      sumdrug.sumdrugprice												 ");
		strSql.append("    FROM mp_dg_op mpdgop												 ");
		strSql.append("    JOIN en_ent enent													 ");
		strSql.append("    ON mpdgop.id_ent = enent.id_ent										 ");
		strSql.append("    JOIN bd_dep bddep													 ");
		strSql.append("    ON bddep.id_dep = enent.id_dep_phy									 ");
		strSql.append("    JOIN mp_dg_op_dt mpdgopdt											 ");
		strSql.append("    ON mpdgop.id_dgop = mpdgopdt.id_dgop									 ");
		strSql.append("    JOIN bd_mm bdmm													 ");
		strSql.append("    ON bdmm.id_mm = mpdgopdt.id_mm									 ");
		strSql.append("    JOIN (															 ");
		strSql.append("      (SELECT enent.id_dep_phy iddepphy,									 ");
		strSql.append("      ROUND(SUM((mpdgopdt.quan_mp - mpdgopdt.quan_bk)* mpdgopdt.price_pkgu_cur),2) sumbaseprice							 ");
		strSql.append("      FROM mp_dg_op_dt mpdgopdt										 ");
		strSql.append("      JOIN mp_dg_op mpdgop												 ");
		strSql.append("      ON mpdgop.id_dgop = mpdgopdt.id_dgop								 ");
		strSql.append("      JOIN en_ent enent													 ");
		strSql.append("      ON mpdgop.id_ent = enent.id_ent										 ");
		strSql.append("      JOIN bd_mm bdmm												 ");
		strSql.append("      ON bdmm.id_mm = mpdgopdt.id_mm									 ");
		strSql.append("      WHERE bdmm.SD_BASEDRUGRANGE = '01'								 ");
		strSql.append("      AND mpdgop.eu_su_mp = '1'											 ");
		if (!StringUtils.isBlank(begainDt) && !"".equals(begainDt.trim())) {
			strSql.append("  AND mpdgop.dt_dp >= '" + begainDt + " 00:00:00'");
		}
		if (!StringUtils.isBlank(endDt) && !"".equals(endDt.trim())) {
			strSql.append("  AND mpdgop.dt_dp <= '" + endDt + " 23:59:59' ");
		}
		strSql.append("      GROUP BY enent.id_dep_phy											 ");
		strSql.append("      )) sumbasedrug ON sumbasedrug.iddepphy = enent.id_dep_phy				 ");
		strSql.append("    JOIN															 ");
		strSql.append("      (SELECT enent.id_dep_phy iddepphy,									 ");
		strSql.append("      ROUND(SUM((mpdgopdt.quan_mp - mpdgopdt.quan_bk)* mpdgopdt.price_pkgu_cur),2) sumdrugprice							 ");
		strSql.append("      FROM mp_dg_op_dt mpdgopdt										 ");
		strSql.append("      JOIN mp_dg_op mpdgop												 ");
		strSql.append("      ON mpdgop.id_dgop = mpdgopdt.id_dgop								 ");
		strSql.append("      JOIN en_ent enent													 ");
		strSql.append("      ON mpdgop.id_ent = enent.id_ent										 ");
		strSql.append("      JOIN bd_mm bdmm												 ");
		strSql.append("      ON bdmm.id_mm = mpdgopdt.id_mm									 ");
		strSql.append("      WHERE mpdgop.eu_su_mp = '1'										 ");
		if (!StringUtils.isBlank(begainDt) && !"".equals(begainDt.trim())) {
			strSql.append("  AND mpdgop.dt_dp >= '" + begainDt + " 00:00:00'");
		}
		if (!StringUtils.isBlank(endDt) && !"".equals(endDt.trim())) {
			strSql.append("  AND mpdgop.dt_dp <= '" + endDt + " 23:59:59' ");
		}
		strSql.append("      GROUP BY enent.id_dep_phy											 ");
		strSql.append("      ) sumdrug ON sumdrug.iddepphy = enent.id_dep_phy						 ");
		strSql.append("    WHERE bdmm.SD_BASEDRUGRANGE = '01'								 ");
		strSql.append("    AND mpdgop.eu_su_mp = '1'											 ");
		if (!StringUtils.isBlank(begainDt) && !"".equals(begainDt.trim())) {
			strSql.append("  AND mpdgop.dt_dp >= '" + begainDt + " 00:00:00'");
		}
		if (!StringUtils.isBlank(endDt) && !"".equals(endDt.trim())) {
			strSql.append("  AND mpdgop.dt_dp <= '" + endDt + " 23:59:59' ");
		}
		strSql.append("    )																 ");
		strSql.append("  GROUP BY depname,													 ");
		strSql.append("    sumbaseprice,														 ");
		strSql.append("    sumdrugprice														 ");
		strSql.append("  )																 ");
		strSql.append("ORDER BY depname													 ");

		return this.getResultBySql(strSql.toString());

	}

	private List<IpBaseTicDrugRatioDTO> getWholeHosData(String begainDt, String endDt, String disCharDrug)
			throws Exception {
		StringBuffer strSql = new StringBuffer();
		strSql.append("SELECT depname," + "  usebasedrugtype," + "  basedruptype," + "  configratio,"
				+ "  sumbaseprice," + "  sumdrugprice," + "  amountratio from ( ");
		strSql.append("SELECT depname,													  ");
		strSql.append("  usebasedrugtype,													  ");
		strSql.append("  basedruptype,														  ");
		strSql.append("  ROUND(usebasedrugtype/basedruptype,4) configratio,							  ");
		strSql.append("  sumbaseprice,														  ");
		strSql.append("  sumdrugprice,														  ");
		strSql.append("  ROUND(sumbaseprice/sumdrugprice,4) amountratio							  ");
		strSql.append("FROM																  ");
		strSql.append("  (SELECT depname,													  ");
		strSql.append("    COUNT(mmcode) usebasedrugtype,										  ");
		strSql.append("    (SELECT COUNT(*) FROM bd_mm WHERE SD_BASEDRUGRANGE = '01') basedruptype,	  ");
		strSql.append("    sumbaseprice,														  ");
		strSql.append("    sumdrugprice														  ");
		strSql.append("  FROM															  ");
		strSql.append("    (SELECT DISTINCT bddep.name depname,								  ");
		strSql.append("      bdmm.code mmcode,												  ");
		strSql.append("      sumbase.sumbaseprice,												  ");
		strSql.append("      sumdrug.sumdrugprice												  ");
		strSql.append("    FROM mp_dg_ip_apde_dt mpdgipdt										  ");
		strSql.append("    JOIN en_ent enent													  ");
		strSql.append("    ON mpdgipdt.id_ent = enent.id_ent										  ");
		strSql.append("    JOIN bd_dep bddep													  ");
		strSql.append("    ON bddep.id_dep = ENENT.ID_DEP_NUR									  ");
		strSql.append("    JOIN bd_mm bdmm													  ");
		strSql.append("    ON bdmm.id_mm = mpdgipdt.id_mm										  ");
		strSql.append("    JOIN															  ");
		strSql.append("      (SELECT * FROM													  ");
		strSql.append("        (SELECT mpdgipdt.ID_DEP_NUR,										  ");
		strSql.append("          SUM(ROUND(mpdgipdt.quan_ap * mpdgipdt.price,2)) sumbaseprice			  ");
		strSql.append("        FROM MP_DG_IP_APDE_DT mpdgipdt									  ");
		strSql.append("        JOIN bd_mm bdmm												  ");
		strSql.append("        ON bdmm.id_mm = mpdgipdt.id_mm									  ");
		strSql.append("        WHERE bdmm.SD_BASEDRUGRANGE = '01'								  ");
		strSql.append("        AND NVL(mpdgipdt.id_dgipde, '~') <> '~'								  ");
		strSql.append("        AND mpdgipdt.en_opde = 1											  ");
		if (!StringUtils.isBlank(begainDt) && !"".equals(begainDt.trim())) {
			strSql.append(" AND mpdgipdt.dt_mp_plan  >= '" + begainDt + " 00:00:00'");
		}
		if (!StringUtils.isBlank(endDt) && !"".equals(endDt.trim())) {
			strSql.append(" AND mpdgipdt.dt_mp_plan  <= '" + endDt + " 23:59:59' ");
		}
		if (!StringUtils.isBlank(disCharDrug) && !"".equals(disCharDrug.trim())) {
			if ("Y".equals(disCharDrug)) {
				strSql.append("AND mpdgipdt.fg_pres_outtp  = '" + disCharDrug + "' ");
			} else {
				strSql.append("AND mpdgipdt.fg_pres_outtp  = '" + disCharDrug + "' ");
			}
		}
		strSql.append("        GROUP BY mpdgipdt.ID_DEP_NUR										  ");
		strSql.append("        ) sumbase														  ");
		strSql.append("      WHERE sumbaseprice <> 0											  ");
		strSql.append("      ) sumbase ON sumbase.ID_DEP_NUR = ENENT.ID_DEP_NUR					  ");
		strSql.append("    JOIN															  ");
		strSql.append("      (SELECT * FROM													  ");
		strSql.append("        (SELECT mpdgipdt.ID_DEP_NUR,										  ");
		strSql.append("          SUM(ROUND(mpdgipdt.quan_ap * mpdgipdt.price,2)) sumdrugprice			  ");
		strSql.append("        FROM MP_DG_IP_APDE_DT mpdgipdt									  ");
		strSql.append("        WHERE NVL(mpdgipdt.id_dgipde, '~') <> '~'								  ");
		strSql.append("        AND mpdgipdt.en_opde = 1											  ");
		if (!StringUtils.isBlank(begainDt) && !"".equals(begainDt.trim())) {
			strSql.append(" AND mpdgipdt.dt_mp_plan  >= '" + begainDt + " 00:00:00'");
		}
		if (!StringUtils.isBlank(endDt) && !"".equals(endDt.trim())) {
			strSql.append(" AND mpdgipdt.dt_mp_plan  <= '" + endDt + " 23:59:59' ");
		}
		if (!StringUtils.isBlank(disCharDrug) && !"".equals(disCharDrug.trim())) {
			if ("Y".equals(disCharDrug)) {
				strSql.append("AND mpdgipdt.fg_pres_outtp  = '" + disCharDrug + "' ");
			} else {
				strSql.append("AND mpdgipdt.fg_pres_outtp  = '" + disCharDrug + "' ");
			}
		}
		strSql.append("        GROUP BY mpdgipdt.ID_DEP_NUR ) sumdrug								  ");
		strSql.append("      WHERE sumdrugprice <> 0											  ");
		strSql.append("      ) sumdrug														  ");
		strSql.append("    ON sumdrug.ID_DEP_NUR = ENENT.ID_DEP_NUR							  ");
		strSql.append("    WHERE mpdgipdt.sd_srvtp LIKE '01%'									  ");
		strSql.append("    AND mpdgipdt.fg_mm = 'Y'											  ");
		strSql.append("    AND bdmm.SD_BASEDRUGRANGE = '01'									  ");
		strSql.append("    AND NVL(mpdgipdt.id_dgipde, '~') <> '~'									  ");
		strSql.append("    AND mpdgipdt.en_opde = 1											  ");
		if (!StringUtils.isBlank(begainDt) && !"".equals(begainDt.trim())) {
			strSql.append(" AND mpdgipdt.dt_mp_plan  >= '" + begainDt + " 00:00:00'");
		}
		if (!StringUtils.isBlank(endDt) && !"".equals(endDt.trim())) {
			strSql.append(" AND mpdgipdt.dt_mp_plan  <= '" + endDt + " 23:59:59' ");
		}
		if (!StringUtils.isBlank(disCharDrug) && !"".equals(disCharDrug.trim())) {
			if ("Y".equals(disCharDrug)) {
				strSql.append("AND mpdgipdt.fg_pres_outtp  = '" + disCharDrug + "' ");
			} else {
				strSql.append("AND mpdgipdt.fg_pres_outtp  = '" + disCharDrug + "' ");
			}
		}
		strSql.append("    )																  ");
		strSql.append("  GROUP BY depname,													  ");
		strSql.append("    sumbaseprice,														  ");
		strSql.append("    sumdrugprice														  ");
		strSql.append("  )																  ");

		strSql.append(" UNION ");

		strSql.append("SELECT depname,													 ");
		strSql.append("  usebasedrugtype,													 ");
		strSql.append("  basedruptype,														 ");
		strSql.append("  ROUND(usebasedrugtype/basedruptype,4) configratio ,							 ");
		strSql.append("  sumbaseprice,														 ");
		strSql.append("  sumdrugprice,														 ");
		strSql.append("  ROUND(sumbaseprice/sumdrugprice,4) amountratio							 ");
		strSql.append("FROM																 ");
		strSql.append("  (SELECT depname,													 ");
		strSql.append("    COUNT(mmcode) usebasedrugtype,										 ");
		strSql.append("    (SELECT COUNT(*) FROM bd_mm WHERE SD_BASEDRUGRANGE = '01') basedruptype,	 ");
		strSql.append("    sumbaseprice,														 ");
		strSql.append("    sumdrugprice														 ");
		strSql.append("  FROM															 ");
		strSql.append("    (SELECT DISTINCT bddep.name depname,								 ");
		strSql.append("      bdmm.code mmcode,												 ");
		strSql.append("      sumbasedrug.sumbaseprice,											 ");
		strSql.append("      sumdrug.sumdrugprice												 ");
		strSql.append("    FROM mp_dg_op mpdgop												 ");
		strSql.append("    JOIN en_ent enent													 ");
		strSql.append("    ON mpdgop.id_ent = enent.id_ent										 ");
		strSql.append("    JOIN bd_dep bddep													 ");
		strSql.append("    ON bddep.id_dep = enent.id_dep_phy									 ");
		strSql.append("    JOIN mp_dg_op_dt mpdgopdt											 ");
		strSql.append("    ON mpdgop.id_dgop = mpdgopdt.id_dgop									 ");
		strSql.append("    JOIN bd_mm bdmm													 ");
		strSql.append("    ON bdmm.id_mm = mpdgopdt.id_mm									 ");
		strSql.append("    JOIN (															 ");
		strSql.append("      (SELECT enent.id_dep_phy iddepphy,									 ");
		strSql.append("      ROUND(SUM((mpdgopdt.quan_mp - mpdgopdt.quan_bk)* mpdgopdt.price_pkgu_cur),2) sumbaseprice							 ");
		strSql.append("      FROM mp_dg_op_dt mpdgopdt										 ");
		strSql.append("      JOIN mp_dg_op mpdgop												 ");
		strSql.append("      ON mpdgop.id_dgop = mpdgopdt.id_dgop								 ");
		strSql.append("      JOIN en_ent enent													 ");
		strSql.append("      ON mpdgop.id_ent = enent.id_ent										 ");
		strSql.append("      JOIN bd_mm bdmm												 ");
		strSql.append("      ON bdmm.id_mm = mpdgopdt.id_mm									 ");
		strSql.append("      WHERE bdmm.SD_BASEDRUGRANGE = '01'								 ");
		strSql.append("      AND mpdgop.eu_su_mp = '1'											 ");
		if (!StringUtils.isBlank(begainDt) && !"".equals(begainDt.trim())) {
			strSql.append("  AND mpdgop.dt_dp >= '" + begainDt + " 00:00:00'");
		}
		if (!StringUtils.isBlank(endDt) && !"".equals(endDt.trim())) {
			strSql.append("  AND mpdgop.dt_dp <= '" + endDt + " 23:59:59' ");
		}
		strSql.append("      GROUP BY enent.id_dep_phy											 ");
		strSql.append("      )) sumbasedrug ON sumbasedrug.iddepphy = enent.id_dep_phy				 ");
		strSql.append("    JOIN															 ");
		strSql.append("      (SELECT enent.id_dep_phy iddepphy,									 ");
		strSql.append("      ROUND(SUM((mpdgopdt.quan_mp - mpdgopdt.quan_bk)* mpdgopdt.price_pkgu_cur),2) sumdrugprice							 ");
		strSql.append("      FROM mp_dg_op_dt mpdgopdt										 ");
		strSql.append("      JOIN mp_dg_op mpdgop												 ");
		strSql.append("      ON mpdgop.id_dgop = mpdgopdt.id_dgop								 ");
		strSql.append("      JOIN en_ent enent													 ");
		strSql.append("      ON mpdgop.id_ent = enent.id_ent										 ");
		strSql.append("      JOIN bd_mm bdmm												 ");
		strSql.append("      ON bdmm.id_mm = mpdgopdt.id_mm									 ");
		strSql.append("      WHERE mpdgop.eu_su_mp = '1'										 ");
		if (!StringUtils.isBlank(begainDt) && !"".equals(begainDt.trim())) {
			strSql.append("  AND mpdgop.dt_dp >= '" + begainDt + " 00:00:00'");
		}
		if (!StringUtils.isBlank(endDt) && !"".equals(endDt.trim())) {
			strSql.append("  AND mpdgop.dt_dp <= '" + endDt + " 23:59:59' ");
		}
		strSql.append("      GROUP BY enent.id_dep_phy											 ");
		strSql.append("      ) sumdrug ON sumdrug.iddepphy = enent.id_dep_phy						 ");
		strSql.append("    WHERE bdmm.SD_BASEDRUGRANGE = '01'								 ");
		strSql.append("    AND mpdgop.eu_su_mp = '1'											 ");
		if (!StringUtils.isBlank(begainDt) && !"".equals(begainDt.trim())) {
			strSql.append("  AND mpdgop.dt_dp >= '" + begainDt + " 00:00:00'");
		}
		if (!StringUtils.isBlank(endDt) && !"".equals(endDt.trim())) {
			strSql.append("  AND mpdgop.dt_dp <= '" + endDt + " 23:59:59' ");
		}
		strSql.append("    )																 ");
		strSql.append("  GROUP BY depname,													 ");
		strSql.append("    sumbaseprice,														 ");
		strSql.append("    sumdrugprice														 ");
		strSql.append("  )	) order by depname										 ");

		return this.getResultBySql(strSql.toString());
	}

	private List<IpBaseTicDrugRatioDTO> getResultBySql(String strSql) throws Exception {
		SqlReader sql_rdr = new SqlReader(null, strSql);
		sql_rdr.runSql(null, true);
		com.sun.rowset.CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();

		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(IpBaseTicDrugRatioDTO.class);
		@SuppressWarnings("unchecked")
		List<IpBaseTicDrugRatioDTO> result = (List<IpBaseTicDrugRatioDTO>) beanlist_handler.processRs(cached_rs);

		sql_rdr.destroy();

		if (result == null || result.size() <= 0) {
			return null;
		}

		return result;
	}
}
