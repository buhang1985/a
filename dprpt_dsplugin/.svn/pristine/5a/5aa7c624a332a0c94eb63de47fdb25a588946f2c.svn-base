package iih.bl.cg.oepfeetail;


import iih.bl.pay.prepaymonth.BlPrePayMonthDTO;

import java.text.DecimalFormat;
import java.util.List;

import xap.dp.report.data.reader.sql.SqlReader;
import xap.mw.coreitf.d.FDouble;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanHandler;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnHandler;

public class FeeOepDetailService {
	public FeeOepDetailDTO[] findBlCgOepInfos(String id_psn,String dt_st) throws Exception{
		FeeOepDetailDTO dto = new FeeOepDetailDTO();
		//出纳
		//dto.setName_cn("张三");
		//dto.setCode_cn("34235121");
		//1.判断操作员是否存在
		dto.setName_psn(getPsnName(id_psn));
		

		//dto.setIncInfo("123721,342122,342342");
		dto.setIncInfo(getIncInfo(id_psn,dt_st));
//		List<FeeOepCgInfoDTO> list = new ArrayList<FeeOepCgInfoDTO>();
		List<FeeOepCgInfoDTO> dtoList = this.getBlCgOepInfo(id_psn,dt_st);
		DecimalFormat df   = new DecimalFormat("######0.00");
		if(dtoList != null ){
			FDouble amt = new FDouble(0);
			FDouble amt_qt = new FDouble(0);
			for(int i = 0; i < dtoList.size(); i++){
				amt = amt.add(new FDouble(dtoList.get(i).getAmt()));
				if("西药费".equals(dtoList.get(i).getIncName())){
					dto.setAmt_xy(df.format(Double.valueOf(dtoList.get(i).getAmt())));
				}else if("中药费".equals(dtoList.get(i).getIncName())){
					dto.setAmt_zy(df.format(Double.valueOf(dtoList.get(i).getAmt())));
				}else if("检查费".equals(dtoList.get(i).getIncName())){
					dto.setAmt_jc(df.format(Double.valueOf(dtoList.get(i).getAmt())));
				}else if("放射费".equals(dtoList.get(i).getIncName())){
					dto.setAmt_fs(df.format(Double.valueOf(dtoList.get(i).getAmt())));		
				}else if("手术费".equals(dtoList.get(i).getIncName())){
					dto.setAmt_ss(df.format(Double.valueOf(dtoList.get(i).getAmt())));
				}else if("治疗费".equals(dtoList.get(i).getIncName())){
					dto.setAmt_zl(df.format(Double.valueOf(dtoList.get(i).getAmt())));
				}else if("化验费".equals(dtoList.get(i).getIncName())){
					dto.setAmt_hy(df.format(Double.valueOf(dtoList.get(i).getAmt())));
				}else if("输血费".equals(dtoList.get(i).getIncName())){
					dto.setAmt_sx(df.format(Double.valueOf(dtoList.get(i).getAmt())));
				}else if("输氧费".equals(dtoList.get(i).getIncName())){
					dto.setAmt_sy(df.format(Double.valueOf(dtoList.get(i).getAmt())));
				}else{
					amt_qt = amt_qt.add(new FDouble(dtoList.get(i).getAmt()));
				}
//				if(list.size() + 1 == 6){
//					FeeOepCgInfoDTO info = new FeeOepCgInfoDTO();
//					info.setIncName("出纳收款盖章");
//					list.add(info);
//				}else if((list.size() + 1) % 6 == 0 && i != dtoList.size()){
//					FeeOepCgInfoDTO info = new FeeOepCgInfoDTO();
//					list.add(info);
//				}
//				list.add(dtoList.get(i));
			}
			dto.setAmt_qt(df.format(Double.valueOf(amt_qt.toString())));
			dto.setAmt(df.format(Double.valueOf(amt.toString())));
//			for(int i = 0; i < 5 - (dtoList.size()%5); i++){
//				FeeOepCgInfoDTO info = new FeeOepCgInfoDTO();
//				list.add(info);
//			}
		}
//		dto.setInccaList(list);
		FeeOepDetailDTO[] arr = new FeeOepDetailDTO[]{dto};
		return arr;
	}
	
	/**
	 * 查找费用信息
	 * */
	@SuppressWarnings("unchecked")
	private List<FeeOepCgInfoDTO> getBlCgOepInfo(String id_psn,String dt_st) throws Exception{
		StringBuffer sql = new StringBuffer();
		sql.append("select case when itm.code_inccaitm  in( '005', '006','052','053','055','056') then '中药费'") 
			.append("when itm.code_inccaitm not in('001', '005','052','053','055','056', '006','002','004','009', '008', '003','010','011') then '其他'") 
			.append("else itm.name_inccaitm end as incName,sum(oep.eu_direct * itm.amt_ratio) as amt ") 
			.append("from bl_cg_itm_oep itm inner join  bl_cg_oep  oep on itm.id_cgoep=oep.id_cgoep") 
			.append(" inner join BL_ST_OEP st on st.id_stoep=itm.id_stoep") 
			.append(" inner join BL_INC_OEP inc on inc.id_stoep= st.id_stoep") 
			.append(" where id_emp_st='")
			.append(id_psn).append("' and TRUNC(TO_DATE( st.dt_st,'yyyy-MM-dd hh24:mi:ss')) = TO_DATE('")
			.append(dt_st).append("','yyyy-MM-dd') and itm.fg_free='N' ")
			.append(" group by   case when itm.code_inccaitm  in( '005', '006','052','053','055','056') then '中药费' ") 
			.append(" when itm.code_inccaitm not in('001', '005','052','053','055','056','006','002','004','009', '008', '003','010','011') then '其他' ") 			
			.append(" else itm.name_inccaitm end ");
		SqlReader sql_rdr = new SqlReader(null, sql.toString());
		sql_rdr.runSql(null, true);
		com.sun.rowset.CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		
		BeanListHandler beanlist_handler = new BeanListHandler(FeeOepCgInfoDTO.class);
		List<FeeOepCgInfoDTO> result = (List<FeeOepCgInfoDTO>)beanlist_handler.processRs(cached_rs);
		return result;
	}
	/**
	 * 查询发票号 返回一个字符串
	 * @param id_psn
	 * @param dt_st
	 * @return
	 * @throws Exception
	 */
	private String getIncInfo(String id_psn,String dt_st) throws Exception{
		StringBuilder sql =new StringBuilder();
		StringBuilder str =new StringBuilder();
		sql.append("select  distinct inc.incno as incInfo ")
					.append(" from bl_cg_itm_oep itm inner join  bl_cg_oep  oep on itm.id_cgoep=oep.id_cgoep")
					.append(" inner join BL_ST_OEP st on st.id_stoep=itm.id_stoep")
					.append(" inner join BL_INC_OEP inc on inc.id_stoep= st.id_stoep")
					.append(" where id_emp_st='")
					.append(id_psn)
					.append("'")
					.append(" and TRUNC(TO_DATE( st.dt_st,'yyyy-MM-dd hh24:mi:ss')) = TO_DATE('").append(dt_st)
					.append("','yyyy-MM-dd')")
					.append(" and inc.incno is not null and itm.fg_free='N'");
		SqlReader sql_rdr = new SqlReader(null, sql.toString());
		sql_rdr.runSql(null, true);
		com.sun.rowset.CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		
		BeanListHandler beanlist_handler = new BeanListHandler(FeeOepDetailDTO.class);
		List<FeeOepDetailDTO> result = (List<FeeOepDetailDTO>)beanlist_handler.processRs(cached_rs);	
		for(FeeOepDetailDTO fe:result){
			str.append(fe.getIncInfo()).append(",");	
		}
		return str.toString().length()>0?str.toString().substring(0, str.toString().length()-1):"";
	}
	@SuppressWarnings("unchecked")
	/***
	 * 查询操作员
	 * @param id_psn
	 * @return 
	 * @throws Exception
	 */
	private String getPsnName(String id_psn) throws Exception{
		DAFacade dao = new DAFacade();
		StringBuilder sql = new StringBuilder();
		sql.append("select psn.name from bd_psndoc psn ");
		sql.append(" WHERE psn.id_psndoc ='");
		sql.append(id_psn);
		sql.append("'");
	
		String	result=((String)dao.execQuery(sql.toString(),new ColumnHandler())).toString();
		if(result==null)
		{
			return "";
		}
		return result;
	}		
}
