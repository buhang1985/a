package iih.ci.mrm.bp;

import java.util.List;

import com.sun.rowset.CachedRowSetImpl;

import iih.ci.mrm.CiMrmPerformanceDTO;
import xap.dp.report.data.reader.sql.SqlReader;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.jdbc.handler.BeanListHandler;

public class getpatlistbp extends PagingServiceImpl<CiMrmPerformanceDTO> {

	public List<CiMrmPerformanceDTO> getpatlist(String sql,String performance) throws Exception{
		
		SqlReader sql_rdr = new SqlReader(null, sql);
		sql_rdr.runSql(null, true);
		CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(CiMrmPerformanceDTO.class);
		List<CiMrmPerformanceDTO> result = (List<CiMrmPerformanceDTO>) beanlist_handler
				.processRs(cached_rs);
		sql_rdr.destroy();
//		for (CiMrmPerformanceDTO dto : result) {
//			StringBuilder sb = new StringBuilder();
//			sb.append(" select c.code_element from ci_mr_doc_reference_value c where c.id_mr = '"+dto.getId_mr()+"' ");
//			SqlReader sqlrdr = new SqlReader(null, sb.toString());
//			sqlrdr.runSql(null, true);
//			CachedRowSetImpl cachedrs = sqlrdr.getCacheRowSet();
//			// 转换成对应 DTO 对象
//			BeanListHandler beanlisthandler = new BeanListHandler(MrDocRefValueDO.class);
//			List<MrDocRefValueDO> list = (List<MrDocRefValueDO>) beanlisthandler
//					.processRs(cachedrs);
//			sqlrdr.destroy();
//			FBoolean ZS = FBoolean.FALSE;
//			FBoolean XBS = FBoolean.FALSE;
//			FBoolean JWS = FBoolean.FALSE;
//			FBoolean TGJC = FBoolean.FALSE;
//			if(list.size() > 0 && list != null){
//				for (MrDocRefValueDO mrDocRefValueDO : list) {
//					if(mrDocRefValueDO.getCode_element().equals("S.01")){
//						ZS = FBoolean.TRUE; 
//						dto.setMain_suit("有");
//					}
//					if(mrDocRefValueDO.getCode_element().equals("S.02") ){
//						TGJC = FBoolean.TRUE;
//						dto.setHealth_checkup("有");
//					}
//					if(mrDocRefValueDO.getCode_element().equals("S.03")){
//						XBS = FBoolean.TRUE;
//						dto.setPresent_illness("有");
//					}
//					if(mrDocRefValueDO.getCode_element().endsWith("S.04")){
//						JWS = FBoolean.TRUE;
//						dto.setPrevious("有");
//					}
//					if(ZS.equals(FBoolean.FALSE)){
//						dto.setMain_suit("无");
//					}
//					if(TGJC.equals(FBoolean.FALSE)){
//						dto.setHealth_checkup("无");
//					}
//					if(XBS.equals(FBoolean.FALSE)){
//						dto.setPresent_illness("无");
//					}
//					if(JWS.equals(FBoolean.FALSE)){
//						dto.setPrevious("无");
//					}
//					if(ZS.equals(FBoolean.TRUE)&&JWS.equals(FBoolean.TRUE)&&XBS.equals(FBoolean.TRUE)&&TGJC.equals(FBoolean.TRUE)){
//						dto.setPerformance("完成");
//					}else{
//						dto.setPerformance("不完善");
//					}
//					if(ZS.equals(FBoolean.FALSE)&&JWS.equals(FBoolean.FALSE)&&XBS.equals(FBoolean.FALSE)&&TGJC.equals(FBoolean.FALSE)){
//						dto.setPerformance("未完成");
//					}
//				}
//			}else{
//				dto.setMain_suit("无");
//				dto.setHealth_checkup("无");
//				dto.setPresent_illness("无");
//				dto.setPrevious("无");
//				dto.setPerformance("未完成");
//			}
//			
//		}
//		//未完成00，不完善01，完成02
//		for (int i = 0 ; i < result.size() ; i++) {
//			
//			CiMrmPerformanceDTO news =  (CiMrmPerformanceDTO)result.get(i);
//			if(performance.equals("00,01")||performance.equals("01,00")){
//				if(result.get(i).getPerformance().equals("完成")){
//					result.remove(i);
//					i--;
//				}
//			}
//			if(performance.equals("00,02")||performance.equals("02,00")){
//				if(result.get(i).getPerformance().equals("不完善")){
//					result.remove(i);
//					i--;
//				}
//			}
//			if(performance.equals("01,02")||performance.equals("02,01")){
//				if(result.get(i).getPerformance().equals("未完成")){
//					result.remove(i);
//					i--;
//				}
//			}
//			if(performance.equals("00")){
//				if(!result.get(i).getPerformance().equals("未完成")){
//					result.remove(i);
//					i--;
//				}
//			}
//			if(performance.equals("01")){
//				if(!result.get(i).getPerformance().equals("不完善")){
//					
//					result.remove(i);
//					i--;
//				}
//			}
//			if(performance.equals("02")){
//				if(!result.get(i).getPerformance().equals("完成")){
//					 result.remove(i);
//					 i--;
//				}
//			}
//		}
		
		return result;
	} 
}
