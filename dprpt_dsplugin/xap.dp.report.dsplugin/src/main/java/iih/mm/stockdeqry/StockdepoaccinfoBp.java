package iih.mm.stockdeqry;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import xap.dp.report.data.reader.sql.SqlReader;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDouble;
import xap.sys.jdbc.handler.BeanListHandler;

public class StockdepoaccinfoBp {

	public List<StockDepoAccView> getAccresult(String id_wh, String id_mm, String date_busi, String date_busiend)
			throws Exception {

		StringBuffer sb = new StringBuffer();

		sb.append(" select mm.name         MM_NAME, ");
		sb.append("  mm.code         MM_CODE, ");
		sb.append("  mmst.DATE_BUSI, ");
		sb.append(" stca.name       STCA_NAME, ");
		sb.append("  wh.name         WH_NAME, ");
		sb.append(" mmst.BUSI_CODE, ");
		sb.append("  fac.name        FACTORY_NAME, ");
		sb.append("  sup.name        SUP_NAME, ");
		sb.append("  dep.name        DEP_NAME, ");
		sb.append("  mmca.name       MMCA_NAME, ");
		sb.append(" mmst.ID_INOUT_ITM,  ");
		sb.append("  mmst.ID_MM, ");
		sb.append(" mmst.ID_MMSTCA, ");
		sb.append("  mmst.ID_WH, ");
		sb.append("   mmst.ID_SUP, ");
		sb.append("  mmst.ID_FACTORY, ");
		sb.append(" mmst.ID_DEP, ");
		sb.append("  mmst.ID_MMCA, ");
		sb.append(" mmst.Id_Mmpkgu_Actual,  ");
		sb.append("  mmst.ID_EMP_ST, ");
		sb.append("  mmst.FG_IN, ");

		sb.append("  mm.spec MM_SPEC, ");
		sb.append(" mmst.BATCH,  ");
		sb.append("  mmst.DATE_EXPI, ");
		sb.append(" pkgu.mmpkguname MMPKGUNAME,  ");
		sb.append(" mmst.PRI_SA, ");
		sb.append("  mmst.PRI_ACT, ");
		sb.append("  mmst.QUAN_ACT, ");
		sb.append("  (case when stca.sd_direct = '1'  then mmst.QUAN_ACT else 0 end) as QUAN_ACT_IN, ");
		sb.append("  (case when stca.sd_direct = '-1'  then mmst.QUAN_ACT else 0 end) as QUAN_ACT_OUT, ");
		sb.append("  mmst.AMT, ");
		sb.append(" mmst.QUAN_BL, ");
		sb.append(" psndoc.name     EMPST_NAME, ");
		sb.append("   psndoc2.name    EMPCONF_NAME, ");
		sb.append(" wh_in.name WH_IN, ");
		sb.append(" wh_out.name WH_OUT, ");
		sb.append("  mmst.DT_CONF ");
		sb.append("  from V_MM_STDEAC_QUERY mmst  ");
		sb.append("   left join bd_mm mm on mm.id_mm = mmst.ID_MM ");
		sb.append("  left join BD_MM_STCA stca on stca.id_mmstca = mmst.ID_MMSTCA ");
		sb.append("   left join bd_wh wh on wh.id_wh = mmst.ID_WH ");
		sb.append("   left join BD_SUP fac on fac.id_sup = mmst.ID_FACTORY");
		sb.append("   left join BD_SUP sup on sup.id_sup = mmst.ID_SUP  ");
		sb.append("   left join bd_dep dep on dep.id_dep = mmst.ID_DEP ");
		sb.append("   left join BD_MMCA mmca on mmca.id_mmca = mmst.ID_MMCA ");
		sb.append("   left join BD_MM_PKGU pkgu on pkgu.id_mmpkgu = mmst.Id_Mmpkgu_Actual ");
		sb.append("   left join bd_psndoc psndoc on psndoc.id_psndoc = mmst.ID_EMP_ST ");
		sb.append("   left join bd_psndoc psndoc2 on psndoc2.id_psndoc = mmst.ID_EMP_CONF ");
		sb.append("   left join bd_wh wh_in on wh_in.id_wh = mmst.WH_I ");
		sb.append("   left join bd_wh wh_out on wh_out.id_wh = mmst.WH_O ");

		sb.append(" where  1=1 ");
		if (!StringUtils.isBlank(id_mm) && !"null".equals(id_mm) && !"".equals(id_mm.trim())) {
			sb.append(" and MMST.ID_MM = '" + id_mm + "' ");
		}
		if (!StringUtils.isBlank(id_wh) && !"null".equals(id_wh) && !"".equals(id_wh.trim())) {
			sb.append(" and  MMST.ID_WH = '" + id_wh + "' ");
		}
		if (!"null".equals(date_busi) && !"".equals(date_busi)) {
			sb.append(" and MMST.DATE_BUSI >= '" + date_busi + "' ");
		}
		if (!"null".equals(date_busiend) && !"".equals(date_busiend)) {
			sb.append(" and  MMST.DATE_BUSI <= '" + date_busiend + "' ");
		}
		sb.append(" order by MMST.DT_CONF,MMST.BATCH,MMST.PRI_ACT ");
		return this.getResultBySql(sb.toString());

	}

	public void exec(List<StockDepoAccView> accList, String date_busi) throws Exception {

		// StockDepoAccView[] acc = accList.toArray(new StockDepoAccView[0]);
		// ■ 包装单位获取
		Map<String, MMPackageUnitPrintDO> pkgMap = this.findPackUnit(accList.get(0).getId_mm(),
				accList.get(0).getId_wh());

		// ■ 默认包装单位获取
		MMPackageUnitPrintDO defPkgUnitDO = this.getDefPkgUnitDO(pkgMap);

		// ■ 根据查询条件计算结存信息<入/出库明细主键:结存数量>
		Map<String, FDouble> mmQuanBlInfo = this.calculQuanBl(date_busi, accList, defPkgUnitDO, pkgMap);

		// ■ 设置库存量
		this.setMmBlInfo(mmQuanBlInfo, accList, defPkgUnitDO, pkgMap);

	}

	private MMPackageUnitPrintDO getDefPkgUnitDO(Map<String, MMPackageUnitPrintDO> pkgMap) throws Exception {

		MMPackageUnitPrintDO defpkgDO = null;
		MMPackageUnitPrintDO salepkgDO = null;
		for (MMPackageUnitPrintDO pkgDO : pkgMap.values()) {

			if (pkgDO.getFg_def() != null && pkgDO.getFg_def().booleanValue()) {

				defpkgDO = pkgDO;
			}
			if ("1".equals(pkgDO.getSd_mmpkgupro())) {

				salepkgDO = pkgDO;
			}
		}

		return defpkgDO == null ? salepkgDO : defpkgDO;
	}

	private void setMmBlInfo(Map<String, FDouble> mmQuanBlInfo, List<StockDepoAccView> accList,
			MMPackageUnitPrintDO defPkgUnitDO, Map<String, MMPackageUnitPrintDO> pkgMap) throws BizException {
		for (StockDepoAccView depoAccDO : accList) {
			MMPackageUnitPrintDO pkdo = pkgMap.get(depoAccDO.getId_mmpkgu_actual());
			// 进价
			FDouble pri_act = packageUnitConvPri(depoAccDO.getPri_act(), pkdo.getFactor(),
					defPkgUnitDO.getFactor());

			depoAccDO.setPri_act(pri_act);
			// 零售价
			FDouble pri_sa = packageUnitConvPri(depoAccDO.getPri_sa(), pkdo.getFactor(),
					defPkgUnitDO.getFactor());
			depoAccDO.setPri_sa(pri_sa);
			// 数量
			FDouble quan = packageUnitConversionNum(depoAccDO.getQuan_act(), pkdo.getFactor(),
					defPkgUnitDO.getFactor());
			depoAccDO.setQuan_act(quan);
			// 入库数量(默认包装单位)
			FDouble quan_def_in = packageUnitConversionNum(depoAccDO.getQuan_act_in(), pkdo.getFactor(),
					defPkgUnitDO.getFactor());
			depoAccDO.setQuan_def_in(quan_def_in);
			// 出库数量(默认包装单位)
			FDouble quan_def_out = packageUnitConversionNum(depoAccDO.getQuan_act_out(), pkdo.getFactor(),
					defPkgUnitDO.getFactor());
			depoAccDO.setQuan_def_out(quan_def_out);
			if (mmQuanBlInfo != null && !mmQuanBlInfo.isEmpty()) {
				// 结存数量
				depoAccDO.setQuan_bl(mmQuanBlInfo.get(depoAccDO.getId_inout_itm()));
			}
			// 实际包装单位
			depoAccDO.setId_mmpkgu_def(defPkgUnitDO.getId_mmpkgu());
			depoAccDO.setDef_mmpkguname(defPkgUnitDO.getMmpkguname());
		}

	}

	private Map<String, FDouble> calculQuanBl(String date_busi, List<StockDepoAccView> accList,
			MMPackageUnitPrintDO defPkgUnitDO, Map<String, MMPackageUnitPrintDO> pkgMap) throws Exception {

		Map<String, FDouble> result = new HashMap<String, FDouble>();
		// 开始日期前物品库存数量合计
		FDouble quanBl = this.getMmQuanBl(date_busi, accList.toArray(new StockDepoAccView[accList.size()])[0],
				defPkgUnitDO, pkgMap);
		// 价格、库存量设定
		for (StockDepoAccView depoAccDO : accList) {
			MMPackageUnitPrintDO pkdo = pkgMap.get(depoAccDO.getId_mmpkgu_actual());
			// 数量
			FDouble quan = packageUnitConversionNum(depoAccDO.getQuan_act(), pkdo.getFactor(),
					defPkgUnitDO.getFactor());
			// 结存数量计算
			if (depoAccDO.getFg_in().booleanValue()) {

				quanBl = quanBl.add(quan);
			} else {

				quanBl = quanBl.sub(quan);
			}

			result.put(depoAccDO.getId_inout_itm(), quanBl);
		}

		return result;
	}

	private FDouble getMmQuanBl(String date_busi, StockDepoAccView stockDepoAccView, MMPackageUnitPrintDO defPkgUnitDO,
			Map<String, MMPackageUnitPrintDO> pkgMap) throws Exception {

		// 期初数量
		FDouble quan_PerInit = this.setIniQuan(date_busi, stockDepoAccView, defPkgUnitDO, pkgMap);
		// 入库数量
		FDouble quan_In = this.setInQuan(date_busi, stockDepoAccView, defPkgUnitDO, pkgMap);
		// 出库数量
		FDouble quan_Out = this.setOutQuan(date_busi, stockDepoAccView, defPkgUnitDO, pkgMap);

		return quan_PerInit.add(quan_In).sub(quan_Out);
	}

	@SuppressWarnings("unchecked")
	private FDouble setOutQuan(String date_busi, StockDepoAccView stockDepoAccView, MMPackageUnitPrintDO defPkgUnitDO,
			Map<String, MMPackageUnitPrintDO> pkgMap) throws Exception {

		FDouble quan_PerOut = FDouble.ZERO_DBL;
		StringBuffer sb = new StringBuffer();

		sb.append(" select b.quan_actual, b.id_mmpkgu_actual ");
		sb.append("   from mm_out a   ");
		sb.append("  left join mm_out_itm b on a.id_out = b.id_out");
		sb.append("  where a.id_wh = '" + stockDepoAccView.getId_wh() + "'");
		sb.append("    and b.id_mm = '" + stockDepoAccView.getId_mm() + "'");
		sb.append("    and substr(a.dt_st, 0, 10) < '" + date_busi + "'");
		sb.append("    and sd_su_st = '1'");
		SqlReader sql_rdr = new SqlReader(null, sb.toString());
		sql_rdr.runSql(null, true);
		com.sun.rowset.CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();

		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(MmQuanBlDTO.class);
		List<MmQuanBlDTO> result = (List<MmQuanBlDTO>) beanlist_handler.processRs(cached_rs);
		sql_rdr.destroy();

		// 累计数量
		for (MmQuanBlDTO initItemDO : result) {
			MMPackageUnitPrintDO pkdo = pkgMap.get(initItemDO.getId_mmpkgu_actual());
			FDouble quan = packageUnitConversionNum(initItemDO.getQuan_actual(), pkdo.getFactor(),
					defPkgUnitDO.getFactor());
			quan_PerOut = quan_PerOut.add(quan);
		}
		return quan_PerOut;
	}

	@SuppressWarnings("unchecked")
	private FDouble setInQuan(String date_busi, StockDepoAccView stockDepoAccView, MMPackageUnitPrintDO defPkgUnitDO,
			Map<String, MMPackageUnitPrintDO> pkgMap) throws Exception {

		FDouble quan_PerIn = FDouble.ZERO_DBL;
		StringBuffer sb = new StringBuffer();

		sb.append(" select b.quan_actual,b.id_mmpkgu_actual ");
		sb.append("  from mm_in a ");
		sb.append("  left join mm_in_itm b on a.id_in = b.id_in");
		sb.append("  where a.id_wh = '" + stockDepoAccView.getId_wh() + "'");
		sb.append("    and b.id_mm = '" + stockDepoAccView.getId_mm() + "'");
		sb.append("    and substr(a.dt_st, 0, 10) < '" + date_busi + "'");
		sb.append("    and sd_sttp in ('11', '12', '13', '14') and sd_su_st = '1'");
		SqlReader sql_rdr = new SqlReader(null, sb.toString());
		sql_rdr.runSql(null, true);
		com.sun.rowset.CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();

		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(MmQuanBlDTO.class);
		List<MmQuanBlDTO> result = (List<MmQuanBlDTO>) beanlist_handler.processRs(cached_rs);
		sql_rdr.destroy();

		// 累计数量
		for (MmQuanBlDTO initItemDO : result) {
			MMPackageUnitPrintDO pkdo = pkgMap.get(initItemDO.getId_mmpkgu_actual());
			FDouble quan = packageUnitConversionNum(initItemDO.getQuan_actual(), pkdo.getFactor(),
					defPkgUnitDO.getFactor());
			quan_PerIn = quan_PerIn.add(quan);
		}
		return quan_PerIn;
	}

	@SuppressWarnings("unchecked")
	private FDouble setIniQuan(String date_busi, StockDepoAccView stockDepoAccView, MMPackageUnitPrintDO defPkgUnitDO,
			Map<String, MMPackageUnitPrintDO> pkgMap) throws Exception {

		FDouble quan_PerInit = FDouble.ZERO_DBL;
		StringBuffer sb = new StringBuffer();

		sb.append(" select b.quan_bk_actual,b.id_mmpkgu_actual ");
		sb.append("  from mm_ini a  ");
		sb.append("  left join mm_ini_itm b on a.id_ini = b.id_ini");
		sb.append("  where a.id_wh = '" + stockDepoAccView.getId_wh() + "'");
		sb.append("    and b.id_mm = '" + stockDepoAccView.getId_mm() + "'");
		SqlReader sql_rdr = new SqlReader(null, sb.toString());
		sql_rdr.runSql(null, true);
		com.sun.rowset.CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();

		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(MmQuanBlDTO.class);
		List<MmQuanBlDTO> result = (List<MmQuanBlDTO>) beanlist_handler.processRs(cached_rs);
		sql_rdr.destroy();

		// 累计数量
		for (MmQuanBlDTO initItemDO : result) {
			MMPackageUnitPrintDO pkdo = pkgMap.get(initItemDO.getId_mmpkgu_actual());
			FDouble quan = packageUnitConversionNum(initItemDO.getQuan_bk_actual(), pkdo.getFactor(),
					defPkgUnitDO.getFactor());
			quan_PerInit = quan_PerInit.add(quan);
		}
		return quan_PerInit;
	}

	private FDouble packageUnitConvPri(FDouble srcPri, FDouble srcFactor, FDouble desFactor) throws BizException {
		if (srcPri == null || FDouble.ZERO_DBL.compareTo(srcPri) == 0) {

			return FDouble.ZERO_DBL;
		}
		return srcPri.div(srcFactor).multiply(desFactor);
	}

	private FDouble packageUnitConversionNum(FDouble srcNum, FDouble srcFactor, FDouble desFactor) throws BizException {

		if (srcNum == null || FDouble.ZERO_DBL.compareTo(srcNum) == 0) {

			return FDouble.ZERO_DBL;
		}

		return srcNum.multiply(srcFactor).div(desFactor);
	}

	@SuppressWarnings("unchecked")
	private Map<String, MMPackageUnitPrintDO> findPackUnit(String id_mm, String id_wh) throws Exception {

		StringBuffer sb = new StringBuffer();

		sb.append(" select a.id_mmpkgu,  a.mmpkguname,a.SD_MMPKGUPRO, a.factor, b.fg_def ");
		sb.append("  from bd_mm_pkgu a ");
		sb.append("  left join BD_WH_PKGUTP b on a.ID_MMPKGUTP = b.ID_MMPKGUTP");
		sb.append("   and b.id_wh = '" + id_wh + "'");
		sb.append("   where a.id_mm = '" + id_mm + "'");
		SqlReader sql_rdr = new SqlReader(null, sb.toString());
		sql_rdr.runSql(null, true);
		com.sun.rowset.CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();

		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(MMPackageUnitPrintDO.class);
		List<MMPackageUnitPrintDO> result = (List<MMPackageUnitPrintDO>) beanlist_handler.processRs(cached_rs);
		Map<String, MMPackageUnitPrintDO> pkgMap = new HashMap<String, MMPackageUnitPrintDO>();
		for (MMPackageUnitPrintDO pkgDO : result) {

			pkgMap.put(pkgDO.getId_mmpkgu(), pkgDO);
		}
		sql_rdr.destroy();
		return pkgMap;
	}

	@SuppressWarnings("unchecked")
	private List<StockDepoAccView> getResultBySql(String strSql) throws Exception {
		SqlReader sql_rdr = new SqlReader(null, strSql);
		sql_rdr.runSql(null, true);
		com.sun.rowset.CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();

		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(StockDepoAccView.class);
		List<StockDepoAccView> result = (List<StockDepoAccView>) beanlist_handler.processRs(cached_rs);
		if (result != null &&result.size() >0) {
			sql_rdr.destroy();
		}

		return result;
	}
	
	/**
	 * getMmIniresult:获取当前查询时间段内的期初记账数据<br/>  
	 * @author zmyang  
	 * @param id_wh
	 * @param id_mm
	 * @param date_busi
	 * @param date_busiend
	 * @return  
	 * @throws Exception 
	 * @since JDK 1.7.0_76
	 */
	public List<StockDepoAccView> getMmIniresult(String id_wh, String id_mm, String date_busi, String date_busiend) throws Exception {
		  
		StringBuilder sb = new StringBuilder();
		sb.append("select mm.name               MM_NAME, ");
		sb.append("mm.code               MM_CODE, ");
		sb.append("substr(mmini.dt_st, 0, 10) DATE_BUSI, ");
		sb.append("'期初入库'            STCA_NAME, ");
		sb.append("wh.name               WH_NAME, ");
		sb.append("null                  BUSI_CODE, ");
		sb.append("null              FACTORY_NAME, ");
		sb.append("sup.name              SUP_NAME, ");
		sb.append("null              DEP_NAME, ");
		sb.append("mmca.name             MMCA_NAME, ");
		sb.append("initm.id_iniitm    ID_INOUT_ITM, ");
		sb.append("initm.id_mm, ");
		sb.append("null               ID_MMSTCA, ");
		sb.append("mmini.id_wh        ID_WH, ");
		sb.append("mm.ID_SUP, ");
		sb.append("null             ID_FACTORY, ");
		sb.append("null             ID_DEP, ");
		sb.append("initm.id_mmca    ID_MMCA, ");
		sb.append("initm.id_mmpkgu_actual   Id_Mmpkgu_Actual, ");
		sb.append("mmini.id_emp_st     ID_EMP_ST, ");
		sb.append("null               FG_IN, ");
		sb.append("mm.spec MM_SPEC, ");
		sb.append("initm.BATCH, ");
		sb.append("initm.DATE_EXPI, ");
		sb.append("pkgu.mmpkguname MMPKGUNAME, ");
		sb.append("initm.PRI_SA, ");
		sb.append("initm.PRI_ACT, ");
		sb.append("initm.quan_bk_actual QUAN_ACT, ");
		sb.append("initm.quan_bk_actual QUAN_ACT_in, ");
		sb.append("0 QUAN_ACT_OUT, ");
		sb.append("initm.amt_cost AMT, ");
		sb.append("null       QUAN_BL, ");
		sb.append("psndoc.name EMPST_NAME, ");
		sb.append("psndoc.name     EMPCONF_NAME, ");
		sb.append("null WH_IN, ");
		sb.append("null  WH_OUT, ");
		sb.append("mmini.dt_st  DT_CONF ");
		sb.append("from mm_ini mmini ");
		sb.append("inner join mm_ini_itm initm on initm.id_ini = mmini.id_ini ");
		sb.append("inner join bd_mm mm on mm.id_mm = initm.id_mm ");
		sb.append("inner join bd_wh wh on wh.id_wh = mmini.id_wh ");
		sb.append("left join bd_sup sup on sup.id_sup = mm.id_sup ");
		sb.append("left join bd_mmca mmca on mmca.id_mmca = initm.id_mmca ");
		sb.append("left join bd_mm_pkgu pkgu on pkgu.id_mmpkgu = initm.id_mmpkgu_actual ");
		sb.append("left join bd_psndoc psndoc on psndoc.id_psndoc = mmini.id_emp_st ");
		sb.append("left join bd_wh wh on wh.id_wh = mmini.id_wh ");
		sb.append("where 1=1 ");
		if (!StringUtils.isBlank(id_mm) && !"null".equals(id_mm) && !"".equals(id_mm.trim())) {
			sb.append(" and initm.ID_MM = '" + id_mm + "' ");
		}
		if (!StringUtils.isBlank(id_wh) && !"null".equals(id_wh) && !"".equals(id_wh.trim())) {
			sb.append(" and  mmini.ID_WH = '" + id_wh + "' ");
		}
		if (!"null".equals(date_busi) && !"".equals(date_busi)) {
			sb.append(" and mmini.dt_st >= '" + date_busi + "' ");
		}
		if (!"null".equals(date_busiend) && !"".equals(date_busiend)) {
			sb.append(" and  mmini.dt_st <= '" + date_busiend + "' ");
		}
		sb.append(" order by mmini.dt_st,initm.BATCH,initm.PRI_ACT ");
		
		
		SqlReader sql_rdr = new SqlReader(null, sb.toString());
		sql_rdr.runSql(null, true);
		com.sun.rowset.CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();

		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(StockDepoAccView.class);
		List<StockDepoAccView> result = (List<StockDepoAccView>) beanlist_handler.processRs(cached_rs);
		if (result != null &&result.size() >0) {
			sql_rdr.destroy();
			this.handleResult(result);
		}
		return result;
	}

	private void handleResult(List<StockDepoAccView> result) throws Exception {

		// ■ 包装单位获取
		Map<String, MMPackageUnitPrintDO> pkgMap = this.findPackUnit(result.get(0).getId_mm(),result.get(0).getId_wh());

		// ■ 默认包装单位获取
		MMPackageUnitPrintDO defPkgUnitDO = this.getDefPkgUnitDO(pkgMap);

		// ■ 设置库存量
		this.setMmBlInfo(null, result, defPkgUnitDO, pkgMap);

	}

	public StockDepoAccView getBusiDateResult(String id_wh, String id_mm, String date_busi, String date_busiend) throws Exception {
		// ■ 包装单位获取
		Map<String, MMPackageUnitPrintDO> pkgMap = this.findPackUnit(id_mm, id_wh);

		// ■ 默认包装单位获取
		MMPackageUnitPrintDO defPkgUnitDO = this.getDefPkgUnitDO(pkgMap);
		
		// ■ 获取业务结束日期对应结存数量
		return this.getBusiDateResult(id_wh, id_mm, date_busiend, defPkgUnitDO);
	}

	private StockDepoAccView getBusiDateResult(String id_wh, String id_mm, String date_busiend,
			MMPackageUnitPrintDO defPkgUnitDO) throws Exception {
		StockDepoAccView result = new StockDepoAccView();
		result.setDate_busi(date_busiend);
		result.setDef_mmpkguname(defPkgUnitDO.getMmpkguname());
		List<StockDepoAccView> stockblList = null;
		//业务结束日期是当前日期
		if(date_busiend.equals(new FDate().asLocalBegin().toLocalString())) {
			StringBuffer sb = new StringBuffer();
			sb.append(" select sum(quan_stock) quan_bl ");
			sb.append(" from mm_bl ");
			sb.append(" where id_wh = '" + id_wh + "' ");
			sb.append(" and id_mm = '" + id_mm + "' ");
			SqlReader sql_rdr = new SqlReader(null, sb.toString());
			sql_rdr.runSql(null, true);
			com.sun.rowset.CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
			// 转换成对应 DTO 对象
			BeanListHandler beanlist_handler = new BeanListHandler(StockDepoAccView.class);
			stockblList = (List<StockDepoAccView>) beanlist_handler.processRs(cached_rs);
			if(stockblList == null || stockblList.size() <= 0) {
				result.setQuan_bl(FDouble.ZERO_DBL);
			}
		} else {
			StringBuffer sb = new StringBuffer();
			sb.append(" select sum(quan_stock) quan_bl ");
			sb.append(" from mm_bl_bak ");
			sb.append(" where id_wh = '" + id_wh + "' ");
			sb.append(" and id_mm = '" + id_mm + "' ");
			sb.append(" and substr(dt_current,0,10) = '" + date_busiend + "' ");
			SqlReader sql_rdr = new SqlReader(null, sb.toString());
			sql_rdr.runSql(null, true);
			com.sun.rowset.CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
			// 转换成对应 DTO 对象
			BeanListHandler beanlist_handler = new BeanListHandler(StockDepoAccView.class);
			stockblList = (List<StockDepoAccView>) beanlist_handler.processRs(cached_rs);
			if(stockblList == null || stockblList.size() <= 0) {
				result.setQuan_bl(null);
			}
		}
		//组装返回结果
		if(stockblList == null || stockblList.size() <= 0) {
			return result;
		} else {
			FDouble quan_bl = packageUnitConversionNum(stockblList.get(0).getQuan_bl(), FDouble.ONE_DBL, defPkgUnitDO.getFactor());
			result.setQuan_bl(quan_bl);
			return result;
		}
	}
}
