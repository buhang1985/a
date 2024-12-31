package iih.bl.cg.ipfeetail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.dp.report.data.reader.sql.SqlReader;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDouble;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanHandler;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class DayIpFeeDetailedService {

	public List<DayIpCgInfoDTO> assemIpFeeDetailedInfo(String id_ent, String name_pat, String code_amr_ip, String dt_b,
			String dt_e, String flag) throws Exception {

		List<DayIpCgInfoDTO> list = null;
		List<DayIpCgInfoDTO> cgDtoList = this.getIpFeeDetailedCgInfo(id_ent, dt_b, dt_e, flag);
		int index = 0;
		if (cgDtoList != null && cgDtoList.size() > 0) {
			DayIpCgInfoDTO amtInfo = this.getTotalAmt(id_ent, dt_b, dt_e, flag);
			list = new ArrayList<DayIpCgInfoDTO>();
			Map<String, List<DayIpCgInfoDTO>> map = new HashMap<String, List<DayIpCgInfoDTO>>();
			Map<String, MeasDocDTO> measMap = this.getMeasdocInfos();
			for (DayIpCgInfoDTO cgInfo : cgDtoList) {
				cgInfo.setAmt_drug(amtInfo.getAmt_drug());
				cgInfo.setAmt_left(amtInfo.getAmt_left());
				cgInfo.setAmt_other(amtInfo.getAmt_other());
				cgInfo.setAmt_prepay(amtInfo.getAmt_prepay());
				cgInfo.setAmt_sum(amtInfo.getAmt_sum());
				cgInfo.setAmt_total(amtInfo.getAmt_total());
				if (StringUtil.isEmpty(cgInfo.name_itm)) {
					// cgInfo.setName_itm("其他");
					continue;
				}
				if (cgInfo.getSruv() != null) {
					if (measMap.get(cgInfo.getSruv()) != null && measMap.containsKey(cgInfo.getSruv())) {
						cgInfo.setSruv(measMap.get(cgInfo.getSruv()).getName());
					} else {
						cgInfo.setSruv(null);
					}
				}
				index++;
				FDate date = new FDate(cgInfo.getDt_cg());
				String key = date.toString();
				if("11509437".equals(cgInfo.getCode_srv())){
					key+=index;
				}
				cgInfo.setDt_cg(key);
				List<DayIpCgInfoDTO> cgDtList = map.get(key);
				if (cgDtList == null) {
					cgDtList = new ArrayList<DayIpCgInfoDTO>();
					cgDtList.add(cgInfo);
					map.put(key, cgDtList);
				} else {
					Boolean has = this.setMapMend(cgDtList, cgInfo);
					if (!has) {
						cgDtList.add(cgInfo);
					}
				}
			}
			for (Map.Entry<String, List<DayIpCgInfoDTO>> entry : map.entrySet()) {
				for (DayIpCgInfoDTO itm : entry.getValue()) {
					if(itm.getAmt_ratio() != null && itm.getAmt_ratio().compareTo(FDouble.ZERO_DBL) != 0){
						list.add(itm);
					}
				}
			}
		}
		return list;
	}

	public Boolean setMapMend(List<DayIpCgInfoDTO> cgDtList, DayIpCgInfoDTO cgInfo) {
		for (DayIpCgInfoDTO dto : cgDtList) {
			if (dto.getName_srv().equals(cgInfo.getName_srv())
					&& dto.getPrice_ratio().doubleValue() == cgInfo.getPrice_ratio().doubleValue()
					&& dto.getName_itm().equals(cgInfo.getName_itm())) {
				if (dto.getQuan() == null) {
					dto.setQuan(cgInfo.getQuan());
				} else {
					dto.setQuan(dto.getQuan().add(cgInfo.getQuan()));
				}
				if (dto.getAmt_ratio() == null) {
					dto.setAmt_ratio(cgInfo.getAmt_ratio());
				} else {
					dto.setAmt_ratio(dto.getAmt_ratio().add(cgInfo.getAmt_ratio()));
				}
				return true;
			}
		}
		return false;
	}

	/**
	 * 获取单位信息
	 * 
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public Map<String, MeasDocDTO> getMeasdocInfos() throws BizException {
		Map<String, MeasDocDTO> measMap = new HashMap<String, MeasDocDTO>();
		DAFacade dafacade = new DAFacade();
		List<MeasDocDTO> measLst = (List<MeasDocDTO>) dafacade.execQuery("SELECT ID_MEASDOC,CODE,NAME FROM BD_MEASDOC",
				new BeanListHandler(MeasDocDTO.class));
		if (measLst == null || measLst.size() == 0) {
			throw new BizException("单位信息不存在！");
		}
		for (MeasDocDTO measDocDO : measLst) {
			measMap.put(measDocDO.getId_measdoc(), measDocDO);
		}
		return measMap;
	}

	/*
	 * wm_concat为oracle内置函数，将多行数据合并为一行，以逗号分割 2018-05-24, nielisheng
	 */
	@SuppressWarnings("unchecked")
	public List<DayIpCgInfoDTO> getIpFeeDetailedCgInfo(String id_ent, String dt_b, String dt_e, String flag)
			throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append(" select * from ( ");
		sql.append("SELECT A2.NAME as NAME_ITM, A1.CODE_SRV,A1.NAME_SRV,A1.SPEC,A1.PRICE_ratio as PRICE_RATIO, \r\n")
				.append("(A1.QUAN * A1.EU_DIRECT) AS QUAN,(A1.AMT_RATIO * A1.EU_DIRECT) AS AMT_RATIO ,A1.DT_CG,A1.SRVU AS SRUV, \r\n")
//				.append("A4.NAME_BED, A5.NAME as NAME_DEP, NVL(A6.AMT_PREPAY, 0) AS AMT_PREPAY, A6.AMT_UNCG AS AMT_TOTAL, (A6.AMT_PREPAY - A6.AMT_UNCG) AS AMT_LEFT, \r\n")
//				.append("NVL(A8.AMT_DRUG, 0) AS AMT_DRUG, NVL(A9.AMT_OTHER, 0) AS AMT_OTHER, A15.NAME AS NAME_HP, \r\n")
//				.append("A11.AMT_SUM, A12.DT_ACPT, A14.NAME AS NAME_HPSRVTP, \r\n").append("  '' AS ID_OR \r\n ")
				
				.append("A4.NAME_BED, A5.NAME as NAME_DEP,  \r\n")
				.append("A15.NAME AS NAME_HP, \r\n")
				.append("A12.DT_ACPT, A14.NAME AS NAME_HPSRVTP, \r\n").append("  '' AS ID_OR \r\n ")
				// .append(",(case A1.fg_mm when 'Y' then A1.srvu when 'N' then
				// A1.pgku_cur end) as srvu ")
				.append("FROM BL_CG_IP A1 \r\n").append("LEFT JOIN (SELECT B3.ID_SRV, B2.CODE, B2.NAME \r\n")
				.append("FROM BD_INCCA B1 \r\n").append("LEFT JOIN BD_INCCA_ITM B2 ON B1.ID_INCCA = B2.ID_INCCA \r\n")
				.append("LEFT JOIN BD_INCCA_ITM_REL B3 ON B2.ID_INCCAITM = B3.ID_INCCAITM \r\n")
				.append("WHERE B1.CODE = '12') A2 ON A1.ID_SRV = A2.ID_SRV \r\n")
				.append("LEFT JOIN PI_PAT A3 ON A1.ID_PAT = A3.ID_PAT \r\n")
				.append("LEFT JOIN EN_ENT_IP A4 on A1.ID_ENT = A4.ID_ENT \r\n")
				.append("LEFT JOIN BD_DEP A5 ON A4.ID_DEP_NURADM = A5.ID_DEP \r\n")
//				.append("LEFT JOIN EN_ENT_ACC A6 ON A1.ID_ENT = A6.ID_ENT \r\n")
//				.append("LEFT JOIN (SELECT ID_ENT, SUM(AMT_RATIO*EU_DIRECT) AS AMT_TOTAL FROM BL_CG_IP WHERE ID_ENT='")
//				.append(id_ent).append("' GROUP BY ID_ENT) A7 ON A1.ID_ENT = A7.ID_ENT \r\n")
//				.append("LEFT JOIN (SELECT ID_ENT, SUM(AMT_RATIO*EU_DIRECT) AS AMT_DRUG FROM BL_CG_IP A WHERE A.ID_ENT='")
//				.append(id_ent).append("' \r\n")
				;

//		if (dt_b.trim().length() == 10) {
//			sql.append(" AND A.DT_CG >= '").append(dt_b.trim()).append(" 00:00:00' \r\n");
//		} else {
//			sql.append(" AND A.DT_CG >= '").append(dt_b.trim()).append("'");
//		}

//		if (dt_e.trim().length() == 10) {
//			sql.append(" AND A.DT_CG <= '").append(dt_e.trim()).append(" 23:59:59' \r\n");
//		} else {
//			sql.append(" AND A.DT_CG <= '").append(dt_e.trim()).append("'");
//		}

//		sql.append(" AND FG_MM='Y' and exists (select * from bd_mmca mmca where mmca.id_mmtp = a.id_mmtp and mmca.sd_mmtp like '1%') GROUP BY A.ID_ENT) A8 ON A1.ID_ENT = A8.ID_ENT \r\n")
//				.append("LEFT JOIN (SELECT ID_ENT, SUM(AMT_RATIO*EU_DIRECT) AS AMT_OTHER FROM BL_CG_IP WHERE ID_ENT='")
//				.append(id_ent).append("' \r\n");
//
//		if (dt_b.trim().length() == 10) {
//			sql.append(" AND DT_CG >= '").append(dt_b.trim()).append(" 00:00:00' \r\n");
//		} else {
//			sql.append(" AND DT_CG >= '").append(dt_b.trim()).append("'");
//		}
//
//		if (dt_e.trim().length() == 10) {
//			sql.append(" AND DT_CG <= '").append(dt_e.trim()).append(" 23:59:59' \r\n");
//		} else {
//			sql.append(" AND DT_CG <= '").append(dt_e.trim()).append("'");
//		}

//		sql.append(" AND FG_MM='N' GROUP BY ID_ENT) A9 ON A1.ID_ENT = A9.ID_ENT \r\n")
		sql.append("")
				.append("LEFT JOIN EN_ENT_HP A10 ON A1.ID_ENT = A10.ID_ENT AND A10.FG_MAJ = 'Y' \r\n")
				.append("LEFT JOIN BD_HP HP ON A10.ID_HP = HP.ID_HP \r\n")
//				.append("LEFT JOIN (SELECT ID_ENT, SUM(AMT_RATIO*EU_DIRECT) AS AMT_SUM FROM  BL_CG_IP WHERE ID_ENT='")
//				.append(id_ent).append("' \r\n")
				;

//		if (dt_b.trim().length() == 10) {
//			sql.append(" AND DT_CG >= '").append(dt_b.trim()).append(" 00:00:00' \r\n");
//		} else {
//			sql.append(" AND DT_CG >= '").append(dt_b.trim()).append("'");
//		}
//
//		if (dt_e.trim().length() == 10) {
//			sql.append(" AND DT_CG <= '").append(dt_e.trim()).append(" 23:59:59' \r\n");
//		} else {
//			sql.append(" AND DT_CG <= '").append(dt_e.trim()).append("'");
//		}

//		sql.append(" GROUP BY ID_ENT) A11 ON A1.ID_ENT = A11.ID_ENT \r\n")
		sql.append("")
				.append("LEFT JOIN EN_ENT A12 ON A1.ID_ENT = A12.ID_ENT \r\n")
				.append("LEFT JOIN BD_HP_SRVORCA A13 ON A1.ID_HP = A13.ID_HP AND A1.ID_SRV = A13.ID_SRV AND (A1.ID_MM = A13.ID_MM OR nvl(A1.ID_MM,'~') = '~') \r\n")
				.append("LEFT JOIN BD_UDIDOC A14 ON A13.ID_HPSRVTP = A14.ID_UDIDOC \r\n")
				.append("LEFT JOIN PI_PAT_CA A15 ON A12.ID_PATCA = A15.ID_PATCA \r\n")
				.append("WHERE a1.fg_real = 'Y' and A1.ID_ENT = '").append(id_ent).append("' \r\n");

		if (dt_b.trim().length() == 10) {
			sql.append("AND A1.DT_CG >= '").append(dt_b.trim()).append(" 00:00:00' \r\n");
		} else {
			sql.append("AND A1.DT_CG >= '").append(dt_b.trim()).append("'");
		}

		if (dt_e.trim().length() == 10) {
			sql.append("AND A1.DT_CG <= '").append(dt_e.trim()).append(" 23:59:59' \r\n");
		} else {
			sql.append("AND A1.DT_CG <= '").append(dt_e.trim()).append("'");
		}

		sql.append("AND (A1.SD_SRVTP NOT LIKE '03%' OR  NVL(A1.ID_OR,'~') = '~' )  \r\n "); // 非检验项目或者无医嘱项目
		// 新增 检验类按医嘱显示 zx 2018年10月16日 次数取 1 ,时间取 dt_or ,单位默认去 项 。其他不需要字段设置空或0
		if ("TRUE".equals(flag) || "true".equals(flag)) {
			sql.append("AND A1.FG_ST = 'Y' \r\n");
		}else if("FALSE".equals(flag) || "false".equals(flag)){
			sql.append("AND A1.FG_ST = 'N' \r\n");
		}
		sql.append(" UNION ALL \r\n ");
		
		//合血特殊处理不group by
		StringBuffer hxsql = new StringBuffer();
//		hxsql.append(" SELECT A2.NAME as NAME_ITM, cg.CODE_SRV, cg.NAME_SRV, '' as SPEC,  cg.PRICE_RATIO,  cg.QUAN,  SUM(CG.AMT_RATIO * CG.EU_DIRECT) AS AMT_RATIO, CG.DT_OR AS  DT_CG, \r\n ")
//				.append(" decode( CI.ID_UNIT_MED,'~','0001Z8100000000LO8K6',CI.ID_UNIT_MED) AS SRUV,  A4.NAME_BED,   '' as NAME_DEP,   0 AS AMT_PREPAY,   0 AMT_TOTAL,  0 AS AMT_LEFT,  0 AS AMT_DRUG, 0 AS AMT_OTHER, \r\n ")
//				.append(" '' AS NAME_HP, 0 AS AMT_SUM,  '' AS DT_ACPT,  '' AS NAME_HPSRVTP,  CG.ID_OR \r\n ")
		hxsql.append(" SELECT A2.NAME as NAME_ITM, cg.CODE_SRV, cg.NAME_SRV, '' as SPEC,  cg.PRICE_RATIO,  cg.QUAN,  SUM(CG.AMT_RATIO * CG.EU_DIRECT) AS AMT_RATIO, CG.DT_OR AS  DT_CG, \r\n ")
			.append(" decode( CI.ID_UNIT_MED,'~','0001Z8100000000LO8K6',CI.ID_UNIT_MED) AS SRUV,  A4.NAME_BED,   '' as NAME_DEP,\r\n ")
			.append(" '' AS NAME_HP,'' AS DT_ACPT,  '' AS NAME_HPSRVTP,  CG.ID_OR \r\n ")
			.append(" from BL_CG_IP CG  \r\n ").append(" LEFT JOIN CI_ORDER CI ON CG.ID_OR = CI.ID_OR \r\n ")
			.append(" LEFT JOIN (SELECT B3.ID_SRV, B2.CODE, B2.NAME \r\n ").append(" FROM BD_INCCA B1 \r\n ")
			.append(" LEFT JOIN BD_INCCA_ITM B2 ON B1.ID_INCCA = B2.ID_INCCA \r\n")
			.append(" LEFT JOIN BD_INCCA_ITM_REL B3 ON B2.ID_INCCAITM = B3.ID_INCCAITM \r\n ")
			.append(" WHERE B1.CODE = '12') A2 ON CG.ID_SRV = A2.ID_SRV \r\n ")
			.append(" LEFT JOIN EN_ENT_IP A4 on CG.ID_ENT = A4.ID_ENT \r\n")
			.append(" WHERE cg.fg_real = 'Y' and CG.SD_SRVTP LIKE '03%' \r\n ")
			.append(" AND CG.ID_ENT = '").append(id_ent).append("' \r\n");

		if (dt_b.trim().length() == 10) {
			hxsql.append(" AND CG.DT_CG >= '").append(dt_b.trim()).append(" 00:00:00' \r\n");
		} else {
			hxsql.append(" AND CG.DT_CG >= '").append(dt_b.trim()).append("'");
		}

		if (dt_e.trim().length() == 10) {
			hxsql.append(" AND CG.DT_CG <= '").append(dt_e.trim()).append(" 23:59:59' \r\n");
		} else {
			hxsql.append(" AND CG.DT_CG <= '").append(dt_e.trim()).append("'");
		}

		if ("TRUE".equals(flag) || "true".equals(flag)) {
			hxsql.append("AND CG.FG_ST = 'Y' \r\n");
		}else if("FALSE".equals(flag) || "false".equals(flag)){
			hxsql.append("AND CG.FG_ST = 'N' \r\n");
		}
		sql.append(hxsql.toString().replace("SUM(CG.AMT_RATIO * CG.EU_DIRECT)", "CG.AMT_RATIO * CG.EU_DIRECT"));
		sql.append(" and CI.CODE_OR = '11509437' ");
		sql.append(" UNION ALL \r\n ");
		sql.append(hxsql);
		sql.append(" and CI.CODE_OR != '11509437' ");
		sql.append(
				" GROUP BY cg.CODE_SRV, cg.NAME_SRV,CG.ID_OR,CI.TIMES_CUR * CG.EU_DIRECT,A2.NAME,CI.ID_UNIT_MED,CG.DT_OR,A4.NAME_BED,cg.price_ratio,cg.quan ");
		
		sql.append(" ) ");
		sql.append(" ORDER BY DT_CG \r\n");
		SqlReader sql_rdr = new SqlReader(null, sql.toString());
		sql_rdr.runSql(null, true);
		com.sun.rowset.CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		System.out.println("report sql=" + sql.toString());
		BeanListHandler beanlist_handler = new BeanListHandler(DayIpCgInfoDTO.class);
		List<DayIpCgInfoDTO> result = (List<DayIpCgInfoDTO>) beanlist_handler.processRs(cached_rs);

		return result;
	}
	
	/**
	 * 获取金额信息
	 * @param id_ent
	 * @param dt_b
	 * @param dt_e
	 * @param flag
	 * @return
	 * @throws DAException
	 */
	public DayIpCgInfoDTO getTotalAmt(String id_ent, String dt_b, String dt_e, String flag) throws DAException{
		
		if (dt_b.trim().length() == 10) {
			dt_b = dt_b.trim() + " 00:00:00";
		}

		if (dt_e.trim().length() == 10) {
			dt_e = dt_e.trim() + " 23:59:59";
		}
		
		StringBuffer sql = new StringBuffer();
		sql.append("select		");
		sql.append("	nvl(t2.AMT_SUM,0) AMT_SUM,nvl(t4.AMT_DRUG,0) AMT_DRUG,nvl(t5.AMT_OTHER,0) AMT_OTHER,	");
		sql.append("	NVL(t6.AMT_PREPAY, 0) AS AMT_PREPAY, nvl(t6.AMT_UNCG,0) AS AMT_TOTAL,	");
		sql.append("	nvl((t6.AMT_PREPAY - t6.AMT_UNCG),0) AS AMT_LEFT	");
		sql.append("from en_ent t1		");
		sql.append("left JOIN (SELECT ID_ENT, SUM(AMT_RATIO * EU_DIRECT) AS AMT_SUM		");
		sql.append("	FROM BL_CG_IP	");
		sql.append("	WHERE ID_ENT = ? AND DT_CG >= ? AND DT_CG <= ?	");
		sql.append("	GROUP BY ID_ENT) t2    ON t1.ID_ENT = t2.ID_ENT	");
		sql.append("LEFT JOIN (SELECT ID_ENT, SUM(AMT_RATIO * EU_DIRECT) AS AMT_DRUG		");
		sql.append("	FROM BL_CG_IP A	");
		sql.append("	WHERE A.ID_ENT = ?  AND A.DT_CG >= ?  AND A.DT_CG <= ?  AND FG_MM = 'Y'	");
		//sql.append("		and exists (select 1 from bd_mmca mmca   where mmca.id_mmtp = a.id_mmtp  and mmca.sd_mmtp like '1%')	");
		sql.append("	GROUP BY A.ID_ENT) t4    ON t1.ID_ENT = t4.ID_ENT	");
		sql.append("LEFT JOIN (SELECT ID_ENT, SUM(AMT_RATIO * EU_DIRECT) AS AMT_OTHER		");
		sql.append("	FROM BL_CG_IP	");
		sql.append("	WHERE ID_ENT = ? AND DT_CG >= ?  AND DT_CG <= ? AND FG_MM = 'N'	");
		sql.append("	GROUP BY ID_ENT) t5   ON t1.ID_ENT = t5.ID_ENT	");
		sql.append("LEFT JOIN EN_ENT_ACC t6    ON t1.ID_ENT = t6.ID_ENT		");
		sql.append("where t1.id_ent = ?		");
		
		SqlParam param = new SqlParam();
		param.addParam(id_ent);
		param.addParam(dt_b);
		param.addParam(dt_e);
		
		param.addParam(id_ent);
		param.addParam(dt_b);
		param.addParam(dt_e);
		
		param.addParam(id_ent);
		param.addParam(dt_b);
		param.addParam(dt_e);
		
		param.addParam(id_ent);
		
		DAFacade daf = new DAFacade();
		DayIpCgInfoDTO result = (DayIpCgInfoDTO) daf.execQuery(sql.toString(), param,new BeanHandler(DayIpCgInfoDTO.class));
		return result;
	}

}
