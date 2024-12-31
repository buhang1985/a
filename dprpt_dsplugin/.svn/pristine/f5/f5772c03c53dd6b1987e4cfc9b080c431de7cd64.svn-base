package iih.ci.ord.printmanage.common;

import java.util.List;
import com.mysql.jdbc.StringUtils;
import iih.ci.ord.printmanage.dto.PrintDiagDTO;
import iih.ci.ord.printmanage.srv.CiorderPrintUtils;

/**
 * 查最新诊断 打印公共接口
 * @author LiYue
 *
 */
public class CiOrderPrintDiagService {

	public static final String CHANA_DIAG = "中医诊断";
	public static final String WESTE_DIAG = "西医诊断";
	public static final String SD_SUPPLY = "14";
 /**
  * 通过id_en查最新诊断
  * @param id_en
  * @return
 * @throws Exception 
  */
	public String exec(String id_en) throws Exception {
	
 		if (StringUtils.isNullOrEmpty(id_en))
			return "";
		List<PrintDiagDTO> cidiag = CiorderPrintUtils.GetQueryResulte(PrintDiagDTO.class, this.sql(id_en));
		
		if(cidiag != null && cidiag.size()>0){
			  String sql = " ";
			  for(PrintDiagDTO item :cidiag){
				  //补充诊断+最后的诊断（都是签署的）
				  if(item.getSd_ditp() == SD_SUPPLY){
					  sql += "'"+item.getId_di()+"',";
				  }else{
					  sql += "'"+item.getId_di()+"',";
					  break;
				  }
			  }
			  sql = sql.substring(0, sql.lastIndexOf(","));
			 
		List<PrintDiagDTO> diag = CiorderPrintUtils.GetQueryResulte(PrintDiagDTO.class, this.getDiag(sql));
			if (diag != null && diag.size() > 0) {
				String strDiag = " ";
				for (PrintDiagDTO item : diag) {
					//诊断补充
					if (StringUtils.isNullOrEmpty(item.getSupplement())) {
						strDiag += item.getDiag();
					} else {
						strDiag += item.getDiag() + " (" + item.getSupplement()+") ";
					}
					//中医候诊
					if (StringUtils.isNullOrEmpty(item.getID_DIDEF_SYN_NAME())) {
						strDiag += "、";
					} else {
						strDiag += " (" + item.getID_DIDEF_SYN_NAME()+") ";
						strDiag += "、";
					}
				}
				return strDiag.substring(0, strDiag.length()-1);
			}
		}
		return "";
	}
	 /**
	  *  （区分中西医）
	  * 通过id_en查最新诊断
	  * @param id_en
	  * @return
	 * @throws Exception 
	  */
		public String exec(String id_en,String diagTp) throws Exception {
		
	 		if (StringUtils.isNullOrEmpty(id_en))
				return "";
			List<PrintDiagDTO> cidiag = CiorderPrintUtils.GetQueryResulte(PrintDiagDTO.class, this.sql(id_en));
			
			if(cidiag != null && cidiag.size()>0){
				  String sql = " ";
				  for(PrintDiagDTO item :cidiag){
					  //补充诊断+最后的诊断（都是签署的）
					  if(item.getSd_ditp() == SD_SUPPLY){
						  sql += "'"+item.getId_di()+"',";
					  }else{
						  sql += "'"+item.getId_di()+"',";
						  break;
					  }
				  }
				  sql = sql.substring(0, sql.lastIndexOf(","));
				 
			List<PrintDiagDTO> diag = CiorderPrintUtils.GetQueryResulte(PrintDiagDTO.class, this.getDiag(sql,diagTp));
				if (diag != null && diag.size() > 0) {
					String strDiag = " ";
					for (PrintDiagDTO item : diag) {
						//诊断补充
						if (StringUtils.isNullOrEmpty(item.getSupplement())) {
							strDiag += item.getDiag();
						} else {
							strDiag += item.getDiag() + " (" + item.getSupplement()+") ";
						}
						//中医候诊
						if (StringUtils.isNullOrEmpty(item.getID_DIDEF_SYN_NAME())) {
							strDiag += "、";
						} else {
							strDiag += " (" + item.getID_DIDEF_SYN_NAME()+") ";
							strDiag += "、";
						}
					}
					return strDiag.substring(0, strDiag.length()-1);
				}
			}
			return "";
		}
	 /**
	  * 通过id_en查最新诊断sql
	  * @param id_en
	  * @return
	  */
	private String getDiag(String sql) {
		StringBuilder str =new StringBuilder();
		str.append(" select ci_di_itm.ID_DIDEF_NAME as Diag,ci_di_itm.SUPPLEMENT as Supplement,ci_di_itm.ID_DIDEF_SYN_NAME from CI_DI_ITM ci_di_itm ")
		.append(" left join CI_DI ci_di on ci_di.ID_DI = ci_di_itm.ID_DI ")
		.append(" where ci_di.id_di in ("+sql+")");
		
		return str.toString();
	}
	 /**
	  * （区分中西医）
	  * 通过id_en查最新诊断sql
	  * @param id_en,diagTp
	  * @return
	  */
	protected String getDiag(String sql,String diagTp) {
		StringBuilder str =new StringBuilder();
		str.append(" select ci_di_itm.ID_DIDEF_NAME as Diag,ci_di_itm.SUPPLEMENT as Supplement,ci_di_itm.ID_DIDEF_SYN_NAME from CI_DI_ITM ci_di_itm ")
		.append(" left join CI_DI ci_di on ci_di.ID_DI = ci_di_itm.ID_DI ")
		.append(" where ci_di.id_di in ("+sql+")");
		if(WESTE_DIAG.equals(diagTp)) {
			str.append(" and ci_di_itm.id_disys ='@@@@AA10000000076SML'");
		}else if(CHANA_DIAG.equals(diagTp)) {
			str.append(" and ci_di_itm.id_disys ='@@@@AA10000000076SMM'");
		}
		return str.toString();
	}
	
	private String sql(String id_en) {
		StringBuilder str =new StringBuilder();
		str.append(" select  *   from ci_di  where id_en= '"+id_en+"' ")
		.append("and ci_di.fg_sign = 'Y' and ci_di.fg_cancel='N' order  by  ci_di.dt_sign desc ");
		return str.toString();
		
	}

}
