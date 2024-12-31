package iih.mm.outdetailacc;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import xap.dp.report.data.reader.sql.SqlReader;
import xap.sys.jdbc.handler.BeanListHandler;

public class MmOutSumAccService {
	//出入库单状态(已确认)
	private static final String SD_SU_ST_SUBMIT = "1";
	
	public List<?> fillBeanList(String stDeSchemeID, String mmcaSchemeID, String whID, String yearmonth1, String yearmonth2, String depID) throws Exception {
		if("null".equals(stDeSchemeID) && "null".equals(whID) && "null".equals(yearmonth1) && "null".equals(yearmonth2) && "null".equals(mmcaSchemeID)) {
			return new ArrayList<MmOutDetailAccDTO>();
		}
		
		List<StockDealTypeConfigItmDO> stockDealTypeConfigItmDOS = this.getStockDealTmpl(stDeSchemeID);
		if(stockDealTypeConfigItmDOS == null || stockDealTypeConfigItmDOS.size() <= 0) {
			return new ArrayList<MmOutDetailAccDTO>();
		}
		
		List<MmOutDetailAccDTO> result = new ArrayList<MmOutDetailAccDTO>();
		for(StockDealTypeConfigItmDO stoDealTyConItemDO : stockDealTypeConfigItmDOS) {
			List<MmOutDetailAccDTO> mmOutDetailAccDTOS = this.getMmOutSumAccCount(stoDealTyConItemDO.getId_mmstca(), stDeSchemeID, whID, yearmonth1, yearmonth2, depID);
			
			if(mmOutDetailAccDTOS == null || mmOutDetailAccDTOS.size() <= 0) {
				String stcaCode = this.getMmStcaCode(stoDealTyConItemDO.getId_mmstca());
				mmOutDetailAccDTOS = this.getMmOutSumInfoFix(whID, yearmonth1, yearmonth2, depID, stcaCode, stoDealTyConItemDO.getDisplay_nm());
			} else {
				mmOutDetailAccDTOS = this.getMmOutSumInfoAuto(stoDealTyConItemDO.getId_mmstca(), stDeSchemeID, whID, yearmonth1, yearmonth2, depID);
			}		
			
			if(mmOutDetailAccDTOS == null || mmOutDetailAccDTOS.size() <= 0) {
				continue;
			}
			
			for(MmOutDetailAccDTO mmOutDetailAccDTO : mmOutDetailAccDTOS) {
				result.add(mmOutDetailAccDTO);
			}
		}
		
		return result;
	}

	private List<MmOutDetailAccDTO> getMmOutSumInfoAuto(String id_mmstca, String stDeSchemeID, 
			String whID, String yearmonth1, String yearmonth2, String depID) throws Exception {
		StringBuffer strSql = new StringBuffer();
		strSql.append(" select BD_WH.Name WH_NAME, BD_WH.Id_Wh, ");
		strSql.append(" null MM_CODE, null MM_NAME, ");
		strSql.append(" BD_MMCA.Code MMCA_CODE, BD_MMCA.Name MMCA_NAME, ");
		strSql.append(" null Spec, null Sup_Name, null ID_MMPKGU, null MMPKGU_NAME, ");
		strSql.append(" BD_DEP.code DEP_CODE, BD_DEP.Name DEP_NAME, ");
		strSql.append(" (BD_MMCA.Code || nvl(BD_DEP.code, '')) ONLY_CODE, ");
		strSql.append(" BD_MM_STCA.Code STCA_CODE, MM_SDT_CONFIG_ITM.Display_Nm STCA_NAME, ");
		strSql.append(" null OUT_QUAN, sum(OUT_ITEM.Amt) OUT_AMT ");
		strSql.append(" from BD_MM_WH ");
		strSql.append(" left outer join BD_WH on BD_MM_WH.Id_Wh = BD_WH.Id_Wh ");
		strSql.append(" left outer join BD_MM on BD_MM_WH.Id_Mm = BD_MM.Id_Mm ");
		strSql.append(" left outer join Mm_Out_Itm OUT_ITEM on BD_MM.Id_Mm = OUT_ITEM.Id_Mm ");
		strSql.append(" left outer join Mm_Out on OUT_ITEM.Id_Out = Mm_Out.ID_OUT ");
		strSql.append(" left outer join BD_MMCA on BD_MM.Id_Mmca = BD_MMCA.Id_Mmca ");
		strSql.append(" left outer join BD_MM_STCA on Mm_Out.Id_Mmstca = BD_MM_STCA.Id_Mmstca ");
		strSql.append(" left outer join MM_SDT_CONFIG_ITM on MM_SDT_CONFIG_ITM.id_mmstca = Mm_Out.Id_Mmstca ");
		strSql.append(" left outer join BD_DEP on Mm_Out.Id_Dep = BD_DEP.Id_Dep ");
		strSql.append(" where BD_MM_WH.Ds = 0 and BD_WH.Ds = 0 ");
		if(!StringUtils.isBlank(whID) && !"null".equals(whID) && !"".equals(whID.trim())) {
			strSql.append(" and BD_WH.Id_Wh = '"+ whID +"' ");
		}
		strSql.append(" and OUT_ITEM.ds = 0 ");
		if(!StringUtils.isBlank(yearmonth1) && !"null".equals(yearmonth1) && !"".equals(yearmonth1.trim())) {
			strSql.append(" and Mm_Out.Year_Month >= '"+ yearmonth1 +"' ");
		}
		if(!StringUtils.isBlank(yearmonth2) && !"null".equals(yearmonth2) && !"".equals(yearmonth2.trim())) {
			strSql.append(" and Mm_Out.Year_Month <= '"+ yearmonth2 +"' ");
		}
		if(!StringUtils.isBlank(whID) && !"null".equals(whID) && !"".equals(whID.trim())) {
			strSql.append(" and Mm_Out.Id_Wh = '"+ whID +"' ");
		}
		if(!StringUtils.isBlank(depID) && !"null".equals(depID) && !"".equals(depID.trim())) {
			strSql.append(" and Mm_Out.Id_Dep = '"+ depID +"' ");
		}
		strSql.append(" and Mm_Out.Sd_Su_St = '" + this.SD_SU_ST_SUBMIT + "' ");
		strSql.append(" and Mm_Out.Id_Mmstca = '"+ id_mmstca +"' ");
		strSql.append(" and MM_SDT_CONFIG_ITM.Id_sdt = '"+ stDeSchemeID +"' ");
		strSql.append(" group by BD_WH.Id_Wh, BD_WH.Name,BD_MMCA.Code,BD_MMCA.Name,BD_DEP.code, ");
		strSql.append(" BD_DEP.name,BD_MM_STCA.Code,MM_SDT_CONFIG_ITM.Display_Nm,(BD_MMCA.Code || nvl(BD_DEP.code, '')) ");
		
		return this.getResultBySql(strSql.toString());
	}

	private List<MmOutDetailAccDTO> getMmOutSumInfoFix(String whID,
			String yearmonth1, String yearmonth2, String depID,
			String stcaCode, String display_nm) throws Exception {
		StringBuffer strSql = new StringBuffer();
		strSql.append(" select BD_WH.Name WH_NAME, BD_WH.Id_Wh, ");
		strSql.append(" null MM_CODE, null MM_NAME, ");
		strSql.append(" BD_MMCA.Code MMCA_CODE, BD_MMCA.Name MMCA_NAME, ");
		strSql.append(" null Spec, null Sup_Name, null ID_MMPKGU, null MMPKGU_NAME, ");
		strSql.append(" BD_DEP.code DEP_CODE, BD_DEP.Name DEP_NAME, ");
		strSql.append(" (BD_MMCA.Code || nvl(BD_DEP.code, '')) ONLY_CODE, ");
		strSql.append(" '" + stcaCode + "' STCA_CODE, '" + display_nm + "' STCA_NAME, ");
		strSql.append(" null OUT_QUAN, null OUT_AMT ");
		strSql.append(" from BD_MM_WH ");
		strSql.append(" left outer join BD_WH on BD_MM_WH.Id_Wh = BD_WH.Id_Wh ");
		strSql.append(" left outer join BD_MM on BD_MM_WH.Id_Mm = BD_MM.Id_Mm ");
		strSql.append(" left outer join Mm_Out_Itm OUT_ITEM on BD_MM.Id_Mm = OUT_ITEM.Id_Mm ");
		strSql.append(" left outer join Mm_Out on OUT_ITEM.Id_Out = Mm_Out.ID_OUT ");
		strSql.append(" left outer join BD_MMCA on BD_MM.Id_Mmca = BD_MMCA.Id_Mmca ");
		strSql.append(" left outer join BD_MM_STCA on Mm_Out.Id_Mmstca = BD_MM_STCA.Id_Mmstca ");
		strSql.append(" left outer join MM_SDT_CONFIG_ITM on MM_SDT_CONFIG_ITM.id_mmstca = Mm_Out.Id_Mmstca ");
		strSql.append(" left outer join BD_DEP on Mm_Out.Id_Dep = BD_DEP.Id_Dep ");
		strSql.append(" where BD_MM_WH.Ds = 0 and BD_WH.Ds = 0 ");
		if(!StringUtils.isBlank(whID) && !"null".equals(whID) && !"".equals(whID.trim())) {
			strSql.append(" and BD_WH.Id_Wh = '"+ whID +"' ");
		}
		strSql.append(" and OUT_ITEM.ds = 0 ");
		if(!StringUtils.isBlank(yearmonth1) && !"null".equals(yearmonth1) && !"".equals(yearmonth1.trim())) {
			strSql.append(" and Mm_Out.Year_Month >= '"+ yearmonth1 +"' ");
		}
		if(!StringUtils.isBlank(yearmonth2) && !"null".equals(yearmonth2) && !"".equals(yearmonth2.trim())) {
			strSql.append(" and Mm_Out.Year_Month <= '"+ yearmonth2 +"' ");
		}
		if(!StringUtils.isBlank(whID) && !"null".equals(whID) && !"".equals(whID.trim())) {
			strSql.append(" and Mm_Out.Id_Wh = '"+ whID +"' ");
		}
		if(!StringUtils.isBlank(depID) && !"null".equals(depID) && !"".equals(depID.trim())) {
			strSql.append(" and Mm_Out.Id_Dep = '"+ depID +"' ");
		}
		strSql.append(" and Mm_Out.Sd_Su_St = '" + this.SD_SU_ST_SUBMIT + "' ");
		
		return this.getResultBySql(strSql.toString());
	}

	private String getMmStcaCode(String id_mmstca) throws Exception {
		StringBuffer strSql = new StringBuffer();
		strSql.append(" select code Mmstca_code ");
		strSql.append(" from BD_MM_STCA ");
		strSql.append(" where id_mmstca = '" + id_mmstca + "' " );
		
		List<StockDealTypeConfigItmDO> result = this.getResultBySqlStock(strSql.toString());
		if(result == null) {
			return "";
		}
		
		return result.toArray(new StockDealTypeConfigItmDO[result.size()])[0].getMmstca_code();
	}

	private List<MmOutDetailAccDTO> getMmOutSumAccCount(String mmstcaID, String stDeSchemeID,
			String whID, String yearmonth1, String yearmonth2, String depID) throws Exception {
		StringBuffer strSql = new StringBuffer();
		strSql.append(" select id_wh ");
		strSql.append(" from BD_MM_WH ");
		strSql.append(" left outer join BD_WH on BD_MM_WH.Id_Wh = BD_WH.Id_Wh ");
		strSql.append(" left outer join BD_MM on BD_MM_WH.Id_Mm = BD_MM.Id_Mm ");
		strSql.append(" left outer join Mm_Out_Itm OUT_ITEM on BD_MM.Id_Mm = OUT_ITEM.Id_Mm ");
		strSql.append(" left outer join Mm_Out on OUT_ITEM.Id_Out = Mm_Out.ID_OUT ");
		strSql.append(" left outer join BD_MMCA on BD_MM.Id_Mmca = BD_MMCA.Id_Mmca ");
		strSql.append(" left outer join BD_MM_STCA on Mm_Out.Id_Mmstca = BD_MM_STCA.Id_Mmstca ");
		strSql.append(" left outer join MM_SDT_CONFIG_ITM on MM_SDT_CONFIG_ITM.id_mmstca = Mm_Out.Id_Mmstca ");
		strSql.append(" left outer join BD_DEP on Mm_Out.Id_Dep = BD_DEP.Id_Dep ");
		strSql.append(" where BD_MM_WH.Ds = 0 and BD_WH.Ds = 0 ");
		if(!StringUtils.isBlank(whID) && !"null".equals(whID) && !"".equals(whID.trim())) {
			strSql.append(" and BD_WH.Id_Wh = '"+ whID +"' ");
		}
		strSql.append(" and OUT_ITEM.ds = 0 ");
		if(!StringUtils.isBlank(yearmonth1) && !"null".equals(yearmonth1) && !"".equals(yearmonth1.trim())) {
			strSql.append(" and Mm_Out.Year_Month >= '"+ yearmonth1 +"' ");
		}
		if(!StringUtils.isBlank(yearmonth2) && !"null".equals(yearmonth2) && !"".equals(yearmonth2.trim())) {
			strSql.append(" and Mm_Out.Year_Month <= '"+ yearmonth2 +"' ");
		}
		if(!StringUtils.isBlank(whID) && !"null".equals(whID) && !"".equals(whID.trim())) {
			strSql.append(" and Mm_Out.Id_Wh = '"+ whID +"' ");
		}
		if(!StringUtils.isBlank(depID) && !"null".equals(depID) && !"".equals(depID.trim())) {
			strSql.append(" and Mm_Out.Id_Dep = '"+ depID +"' ");
		}
		strSql.append(" and Mm_Out.Sd_Su_St = '" + this.SD_SU_ST_SUBMIT + "' ");
		strSql.append(" and Mm_Out.Id_Mmstca = '"+ mmstcaID +"' ");
		strSql.append(" and MM_SDT_CONFIG_ITM.Id_sdt = '"+ stDeSchemeID +"' ");
		
		return this.getResultBySql(strSql.toString());
	}

	private List<StockDealTypeConfigItmDO> getStockDealTmpl(String stDeSchemeID) throws Exception {
		StringBuffer strSql = new StringBuffer();
		strSql.append(" select id_mmstca, display_nm ");
		strSql.append(" from MM_SDT_CONFIG_ITM ");
		strSql.append(" where id_sdt = '" + stDeSchemeID + "' " );
		strSql.append(" and ds = 0 " );
		
		return this.getResultBySqlStock(strSql.toString());
	}
	
	@SuppressWarnings("unchecked")
	private List<StockDealTypeConfigItmDO> getResultBySqlStock(String strSql) throws Exception {
		SqlReader sql_rdr = new SqlReader(null, strSql);
		sql_rdr.runSql(null, true);
		com.sun.rowset.CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(StockDealTypeConfigItmDO.class);
		List<StockDealTypeConfigItmDO> result = (List<StockDealTypeConfigItmDO>)beanlist_handler.processRs(cached_rs);

		sql_rdr.destroy();
		
		if(result == null || result.size() <= 0) {
			return null;
		}
		
		return result;
	}
	
	@SuppressWarnings("unchecked")
	private List<MmOutDetailAccDTO> getResultBySql(String strSql) throws Exception {
		SqlReader sql_rdr = new SqlReader(null, strSql);
		sql_rdr.runSql(null, true);
		com.sun.rowset.CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(MmOutDetailAccDTO.class);
		List<MmOutDetailAccDTO> result = (List<MmOutDetailAccDTO>)beanlist_handler.processRs(cached_rs);

		sql_rdr.destroy();
		
		if(result == null || result.size() <= 0) {
			return null;
		}
		
		return result;
	}
}
