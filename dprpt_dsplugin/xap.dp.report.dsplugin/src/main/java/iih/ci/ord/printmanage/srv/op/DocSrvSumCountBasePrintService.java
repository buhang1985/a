package iih.ci.ord.printmanage.srv.op;


import iih.ci.ord.printmanage.dto.DocSrvSumCountHeadDTO;
import iih.ci.ord.printmanage.dto.DocSrvSumCountItemDTO;
import iih.ci.ord.printmanage.srv.CiorderPrintUtils;
import xap.mw.core.data.BizException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;




/**
 * 医生诊疗项目汇总统计
 * 
 * @author yzh
 *
 */
public class DocSrvSumCountBasePrintService  {

	
	public List<DocSrvSumCountHeadDTO> exec(String Psndoc_Id, String Dt_st, String Dt_ed,String Sd_Srvtp,String dept_id,String dept_name) throws Exception {
		if (Dt_st ==null ||Dt_ed==null || Dt_st.equals("") || Dt_ed.equals("")) return null;
		java.text.DecimalFormat   df   =new   java.text.DecimalFormat("######0.00");
		Dt_st = Dt_st.substring(0,10)+" 00:00:00";
		Dt_ed = Dt_ed.substring(0,10)+" 23:59:59";
		List<DocSrvSumCountHeadDTO> headList = new ArrayList<DocSrvSumCountHeadDTO>();
		DocSrvSumCountHeadDTO headDTO = new DocSrvSumCountHeadDTO();
		headDTO.setDt_ed(Dt_ed);
		headDTO.setDt_st(Dt_st);
		if(Psndoc_Id == null || Psndoc_Id.equals("")){
			headDTO.setPsndoc_name(dept_name);
		}else{
			Map<String,Object> map = getPsnDoc(Psndoc_Id);
			if(map != null){
				if(map.get("code") != null) headDTO.setPsndoc_code((String)map.get("code"));
				if(map.get("name") != null) headDTO.setPsndoc_name((String)map.get("name"));
			}
		}
		List<DocSrvSumCountItemDTO> srvList = CiorderPrintUtils.GetQueryResulte(DocSrvSumCountItemDTO.class, getItemSql(Psndoc_Id,Dt_st,Dt_ed,Sd_Srvtp,dept_id));
		if(srvList != null && srvList.size()>0){
			double sum = 0.00;
			for (DocSrvSumCountItemDTO docSrvSumCountItemDTO : srvList) {
				BigDecimal count = new BigDecimal(docSrvSumCountItemDTO.getSrv_count());
				BigDecimal price = new BigDecimal(docSrvSumCountItemDTO.getSrv_price());
				double sum_price = count.multiply(price).doubleValue();
				sum= add(sum,sum_price);
				docSrvSumCountItemDTO.setSrv_sum(df.format(sum_price));
			}
			headDTO.setTotal_pri(df.format(sum));
		}
		headDTO.setItemdtolist(srvList);
		headList.add(headDTO);
		return headList;
	}

	
	private  Double add(Double v1, Double v2) {  
		   BigDecimal b1 = new BigDecimal(v1.toString());  
		   BigDecimal b2 = new BigDecimal(v2.toString());  
		   return new Double(b1.add(b2).doubleValue());  
		}  
	
	/**
	 * 获取子类服务
	 * @param idEmpOrs
	 * @param idSrvs
	 * @return
	 */
	private String getItemSql(String psndocId,String Dt_st,String Dt_ed,String Sd_Srvtp,String id_dep_sign){
		StringBuilder str = new StringBuilder();
		str.append("select sum(orsrv.quan_total_medu) as srv_count,");
		str.append("orsrv.pri as srv_price, srv.name as srv_name, srv.code as srv_code ");
		str.append("from ci_order c left outer join bd_psndoc psn on c.id_emp_sign = psn.id_psndoc ");
		str.append("left outer join ci_or_srv orsrv on c.id_or=orsrv.id_or ");
		str.append("left outer join bd_incca_itm_rel rel on orsrv.id_srv = rel.id_srv ");
		str.append("left outer join bd_incca_itm itm on rel.id_inccaitm=itm.id_inccaitm ");
		str.append("left outer join bd_srv srv on srv.id_srv=orsrv.id_srv ");
		str.append("where c.dt_entry >='"+Dt_st+"' and c.dt_entry <='"+Dt_ed+"' ");
		str.append("and c.fg_sign='Y' and c.fg_canc='N' ");
		str.append("and (orsrv.eu_feereversetp is null or orsrv.eu_feereversetp='0') and itm.code in ('002','004','008','009','012','062','063')");
		str.append("and itm.sd_incca='11' and orsrv.fg_bl='Y' ");
		if(Sd_Srvtp != null){
			str.append("and c.sd_srvtp like '"+Sd_Srvtp+"%' ");
		}
		if(psndocId == null || psndocId.equals("")){
			str.append("and c.id_dep_sign='"+id_dep_sign+"' ");
		}else{
			str.append("and c.id_emp_sign ='"+psndocId+"' ");
			str.append("and c.id_dep_sign='"+id_dep_sign+"' ");
		}
		str.append("group by srv.code,orsrv.pri,srv.name");
		return str.toString();
	}
	/**
	 * 根据医生id获取医生code name 集合
	 * @param psndocId
	 * @return
	 */
	private Map<String,Object> getPsnDoc(String psndocId){
		String sql = "select code,name from bd_psndoc where id_psndoc='"+psndocId+"'";
		try {
			List<Map<String, Object>> maps = CiorderPrintUtils.getRsMapList(sql);
			if(maps != null && maps.size()>0){
				return maps.get(0);
			}
		} catch (BizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 根据部门id获取部门名称
	 * @param id_dep
	 * @return
	 */
	private String getDeptInfo(String id_dep){
		String sql = " select name from bd_dep where id_dep='"+id_dep+"'";
		String dep_name="";
		try {
			List<Map<String, Object>> maps = CiorderPrintUtils.getRsMapList(sql);
			if(maps != null && maps.size()>0){
				for (Map<String, Object> map2 : maps) {
					dep_name = (String) map2.get("name");
				}
			}
		} catch (BizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dep_name;
	}

	
}
