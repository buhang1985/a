package iih.bl.pay.prepaymonth;


import java.util.ArrayList;
import java.util.List;
import xap.dp.report.data.reader.sql.SqlReader;
import xap.mw.coreitf.d.FDouble;
import xap.sys.jdbc.handler.BeanListHandler;
/***
 * 
 * @author LIM
 *报表1234203（预付费卡月报）
 */
public class PrepayMonthService {
	public List<BlPrePayMonthDTO> assemPatPayInfo(String beginDate,String endDate) throws Exception{
		List<BlPrePayMonthDTO> list = new ArrayList<BlPrePayMonthDTO>();
		List<BlPrePayMonthDTO> blPrePayMonthDTO = this.getPrePaYInfo(beginDate,endDate);
		FDouble bala_AmtSum= this.getPrePayBalance(beginDate);
		if(blPrePayMonthDTO != null){
			for(BlPrePayMonthDTO bl: blPrePayMonthDTO){
				bl.setPrepay_Date(bl.getPrepay_Date().substring(0, 10));
				bala_AmtSum=bl.getBala_Amt().add(bala_AmtSum);		
				bl.setBala_AmtSum(bala_AmtSum);
				list.add(bl);	
			}
		}		
		return list;
	}
	@SuppressWarnings("unchecked")
	private List<BlPrePayMonthDTO> getPrePaYInfo(String beginDate,String endDate) throws Exception{
		StringBuilder sql = new StringBuilder();
		sql.append("select SUBSTR(dt_pay,0,10) as prepay_Date, ")
			 .append(" sum(case when oep.eu_direct = '1' then oep.Amt end) as add_Amt,")
			 .append(" sum(case when oep.eu_direct = '-1' then oep.Amt end) as reduce_Amt, ")
			 .append("sum(oep.eu_direct*oep.Amt) as bala_Amt")
			 .append(" from BL_PAY_ITM_PAT_OEP itm ")
			 .append(" inner join BL_PAY_PAT_OEP oep on itm.id_paypatoep = oep.id_paypatoep")
			 .append(" inner join bl_st_oep st on itm.id_paypatoep = st.id_paypatoep ")
			 .append(" WHERE itm.id_pm in ('@@@@AA1000000001JPEM') and oep.Amt<>0 and dt_pay>='")
			 .append(beginDate)
			 .append("' and dt_pay<='")
			 .append(endDate)
			 .append("'")
			 .append(" group by SUBSTR(dt_pay,0,10)")
			 .append(" order  by SUBSTR(dt_pay,0,10)");
		SqlReader sql_rdr = new SqlReader(null, sql.toString());
		sql_rdr.runSql(null, true);
		com.sun.rowset.CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		
		BeanListHandler beanlist_handler = new BeanListHandler(BlPrePayMonthDTO.class);
		List<BlPrePayMonthDTO> result = (List<BlPrePayMonthDTO>)beanlist_handler.processRs(cached_rs);
		if(result == null || result.size() == 0){
			return null;
		}
		return result;
	}	
	@SuppressWarnings("unchecked")
	/***
	 * 查询累计余额
	 * @param beginDate
	 * @return 
	 * @throws Exception
	 */
	private FDouble getPrePayBalance(String beginDate) throws Exception{
		StringBuilder sql = new StringBuilder();
		sql.append("select sum(oep.eu_direct*oep.Amt) as bala_AmtSum")
			 .append(" from BL_PAY_ITM_PAT_OEP itm ")
			 .append(" inner join BL_PAY_PAT_OEP oep on itm.id_paypatoep = oep.id_paypatoep")
			 .append(" inner join bl_st_oep st on itm.id_paypatoep = st.id_paypatoep ")
			 .append(" WHERE itm.id_pm in ('@@@@AA1000000001JPEM') and oep.Amt<>0 and dt_pay<'")
			 .append(beginDate)
			 .append("'");
		SqlReader sql_rdr = new SqlReader(null, sql.toString());
		sql_rdr.runSql(null, true);
		com.sun.rowset.CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		
		BeanListHandler beanlist_handler = new BeanListHandler(BlPrePayMonthDTO.class);
		List<BlPrePayMonthDTO> result = (List<BlPrePayMonthDTO>)beanlist_handler.processRs(cached_rs);
		if(result == null){
			return FDouble.ZERO_DBL;
		}
		BlPrePayMonthDTO bl = result.get(0);
		//add   0132302: 预付费金额统计查询不到数据  begin 
		if(bl.getBala_AmtSum() == null){
			return FDouble.ZERO_DBL;
		}
		//add  0132302: 预付费金额统计查询不到数据 end  
		return bl.getBala_AmtSum();
	}	
}
