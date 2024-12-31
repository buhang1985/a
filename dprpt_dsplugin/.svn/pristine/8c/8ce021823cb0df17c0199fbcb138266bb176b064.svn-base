package iih.mr.mrm;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class HospitalMrQcCensusService {

	//获取医生病案总数
	@SuppressWarnings("unchecked")
	public List<DepMrQcCensusDTO>getHospitalMrCount(String dt_begin , String dt_end , String id_emp_phy) throws Exception{
		DAFacade daf = new DAFacade();
		StringBuilder sql = new StringBuilder();
		sql.append(" select count(1) as mrTotal ,bp.id_psndoc as id_emp_phy,bp.name as name_emp_phy ");
		sql.append(" from ci_mr_fp cmf ");
		sql.append(" left join ci_mr_fp_pat cmfp ");
		sql.append(" on cmf.id_mrfp = cmfp.id_mrfp ");
		sql.append(" left join en_ent ee ");
		sql.append(" on ee.id_ent = cmf.id_ent ");
		sql.append(" left join ci_amr ca ");
		sql.append(" on ca.id_ent = cmf.id_ent ");
		sql.append(" left join bd_psndoc bp ");
		sql.append(" on ee.id_emp_phy = bp.id_psndoc ");
		sql.append(" where ca.fg_complete='Y'and ee.fg_ip='N' ");
		
		SqlParam sq=new SqlParam();
		if(!StringUtil.isEmptyWithTrim(dt_begin)){
			sql.append(" and ee.dt_end>=? ");
			sq.addParam(dt_begin);
		}
		if(!StringUtil.isEmptyWithTrim(dt_end)){
			sql.append(" and ee.dt_end<=? ");
			sq.addParam(dt_end);
		}	
		if(!StringUtil.isEmptyWithTrim(id_emp_phy)){
			sql.append(" and bp.id_psndoc=? ");
			sq.addParam(id_emp_phy);
		}
		sql.append(" group by bp.id_psndoc,bp.name ");
		sql.append(" order by bp.name ");
		List<DepMrQcCensusDTO> result = (List<DepMrQcCensusDTO>) daf.execQuery(sql.toString(),sq,new BeanListHandler(DepMrQcCensusDTO.class));
		
		if(result!=null && result.size()>0)
			getHospitalMrData(dt_begin,dt_end,id_emp_phy,result);	
		return result;	
	}
	
	// 获取住院医生 病案相关内容	
		@SuppressWarnings("unchecked")
		public void getHospitalMrData(String dt_begin,String dt_end,String id_emp_phy,List<DepMrQcCensusDTO> list) throws Exception {
			StringBuilder sql = new StringBuilder();
			sql.append("select bp.id_psndoc        as id_emp_phy, ");
			sql.append("bp.name              as name_emp_phy, ");
			sql.append("cmfo.name_qom_record as name_qom_record, ");
			sql.append(" cmf.id_mrfp, ");
			sql.append(" cmfo.id_qcp_doc as id_qcp_doc, ");
			sql.append(" cmfo.id_cimrfpother ");
			sql.append("from ci_mr_fp cmf ");
			sql.append("left join ci_mr_fp_other cmfo ");
			sql.append("on cmf.id_ent = cmfo.id_ent ");
			sql.append("left join en_ent ee ");
			sql.append("on cmf.id_ent = ee.id_ent ");
			sql.append("left join ci_amr ca ");
			sql.append("on cmf.id_ent = ca.id_ent ");
			sql.append("left join bd_psndoc bp ");
			sql.append("on ee.id_emp_phy = bp.id_psndoc ");
			sql.append("where ca.fg_complete='Y'and ee.fg_ip='N' ");
			
			DAFacade daf = new DAFacade();
			SqlParam sq=new SqlParam();	
			if(!StringUtil.isEmptyWithTrim(dt_begin)){
				sql.append(" and ee.dt_end>=? ");
				sq.addParam(dt_begin);
			}
			if(!StringUtil.isEmptyWithTrim(dt_end)){
				sql.append(" and ee.dt_end<=? ");
				sq.addParam(dt_end);
			}	
			if(!StringUtil.isEmptyWithTrim(id_emp_phy)){
				sql.append(" and bp.id_psndoc= ? ");
				sq.addParam(id_emp_phy);
			}
			List<MrQualityDTO> mrQualityList = (List<MrQualityDTO>) daf.execQuery(sql.toString(),sq,new BeanListHandler(MrQualityDTO.class));
			
			getEvaluatedCount(dt_begin,dt_end,id_emp_phy,mrQualityList,list);	
	    }
		
		// 已评病案数
		public void getEvaluatedCount(String dt_begin,String dt_end,String id_emp_phy,List<MrQualityDTO> mrQualityList,List<DepMrQcCensusDTO> list) throws Exception{
			Map<String,Integer> map=new HashMap<String,Integer>();
			for(MrQualityDTO dto:mrQualityList){
				if(dto.getId_qcp_doc()!=null){
					String key=dto.getId_emp_phy();
					if(map.containsKey(key)){
						map.put(key, map.get(key)+1);
					}else{
						map.put(key, 1);
					}			
				}
			}
			for(DepMrQcCensusDTO censusdto: list){
				String key=censusdto.getId_emp_phy();
				censusdto.setAlreadyEvaluateMr(String.valueOf(map.get(key)==null?"0":String.valueOf(map.get(key))));
			}
			getJYBCount(dt_begin,dt_end,id_emp_phy,mrQualityList,list);
		}	
		
		// 获取甲乙丙数
		public void getJYBCount(String dt_begin,String dt_end,String id_emp_phy,List<MrQualityDTO> mrQualityList,List<DepMrQcCensusDTO> list) throws Exception{
			DAFacade daf = new DAFacade();		
		    for(DepMrQcCensusDTO censusdto: list){
		    	censusdto.setNumberone("0");
		    	censusdto.setNumbertwo("0");
		    	censusdto.setNumberthree("0");
		    	
		    	StringBuilder sql = new StringBuilder();
				sql.append("select count(other.name_qom_record) as count ,other.name_qom_record as name_mr_quality from ci_mr_fp fp ");
				sql.append("left join  ci_mr_fp_other other ");
				sql.append("on other.id_ent=fp.id_ent ");
				sql.append("left join en_ent ee ");
				sql.append("on fp.id_ent=ee.id_ent ");
				sql.append(" left join ci_amr ca ");
				sql.append(" on fp.id_ent = ca.id_ent ");
				sql.append(" left join bd_psndoc bp ");
				sql.append(" on ee.id_emp_phy = bp.id_psndoc ");
				sql.append("where ee.id_emp_phy='"+censusdto.getId_emp_phy()+"' and ca.fg_complete='Y'and ee.fg_ip='N'");
				
				SqlParam sq=new SqlParam();	
				if(!StringUtil.isEmptyWithTrim(dt_begin)){
					sql.append(" and ee.dt_end>=? ");
					sq.addParam(dt_begin);
				}
				if(!StringUtil.isEmptyWithTrim(dt_end)){
					sql.append(" and ee.dt_end<=? ");
					sq.addParam(dt_end);
				}	
				if(!StringUtil.isEmptyWithTrim(id_emp_phy)){
					sql.append(" and bp.id_psndoc= ? ");
					sq.addParam(id_emp_phy);
				}
				sql.append("group by other.name_qom_record ");
				sql.append("order by other.name_qom_record desc ");
				
				@SuppressWarnings("unchecked")
				List<MrQualityDTO> list2 = (List<MrQualityDTO>)daf.execQuery(sql.toString(), sq,new BeanListHandler(MrQualityDTO.class));
				
				for(MrQualityDTO dto: list2){
					String value=String.valueOf(dto.getCount());
					if("甲".equals(dto.getName_mr_quality())){
						censusdto.setNumberone(value);
					}else if("乙".equals(dto.getName_mr_quality())){
						censusdto.setNumbertwo(value);
					}else if("丙".equals(dto.getName_mr_quality())){
						censusdto.setNumberthree(value);
					}
				}
		    }
		    getReturnCount(dt_begin,dt_end,id_emp_phy,mrQualityList,list);
		}
		
		// 获取返回修改数
		public void getReturnCount(String dt_begin,String dt_end,String id_emp_phy,List<MrQualityDTO> mrQualityList,List<DepMrQcCensusDTO> list) throws Exception{
			DAFacade daf = new DAFacade();	
		    for(DepMrQcCensusDTO censusdto: list){
				StringBuilder sql = new StringBuilder();
				sql.append("select count(1) as count from  ci_mr_fp fp ");
				sql.append("left join ci_amr amr ");
				sql.append("on fp.id_ent=amr.id_ent ");
				sql.append("left join en_ent ee ");
				sql.append("on fp.id_ent=ee.id_ent ");
				sql.append("left join ci_mrm_op op ");
				sql.append("on op.id_amr =amr.id_enhr ");
				sql.append(" left join bd_psndoc bp ");
				sql.append(" on ee.id_emp_phy = bp.id_psndoc ");
				sql.append("where ee.id_emp_phy='"+censusdto.getId_emp_phy()+"' ");
				sql.append("and op.sd_optp='03' ");
				sql.append("and amr.fg_complete='Y'and ee.fg_ip='N' ");
				SqlParam sq=new SqlParam();	
				if(!StringUtil.isEmptyWithTrim(dt_begin)){
					sql.append(" and ee.dt_end>=? ");
					sq.addParam(dt_begin);
				}
				if(!StringUtil.isEmptyWithTrim(dt_end)){
					sql.append(" and ee.dt_end<=? ");
					sq.addParam(dt_end);
				}	
				if(!StringUtil.isEmptyWithTrim(id_emp_phy)){
					sql.append(" and bp.id_psndoc= ? ");
					sq.addParam(id_emp_phy);
				}
				int count =(int) daf.execQuery(sql.toString(),sq, new ColumnHandler());
				
				censusdto.setReturn_modify_count(String.valueOf(count));
				getProbability(list);
			 }	
		}
		
		// 获取百分百比小数形式
		public void  getProbability(List<DepMrQcCensusDTO> list){
			DecimalFormat df=new DecimalFormat("0.00%");  
			for(DepMrQcCensusDTO dto:list){
				Double numberJ = Double.valueOf(dto.getNumberone()==null?"0":dto.getNumberone());
				Double numberY = Double.valueOf(dto.getNumbertwo()==null?"0":dto.getNumbertwo());
				Double numberB = Double.valueOf(dto.getNumberthree()==null?"0":dto.getNumberthree());
				Double numberRe =Double.valueOf(dto.getReturn_modify_count()==null?"0":dto.getReturn_modify_count());
				Double total=Double.valueOf(dto.getMrTotal()==null?"0":dto.getMrTotal());		
				dto.setNumberoneRate(df.format(numberJ/total));
				dto.setNumbertwoRate(df.format(numberY/total));
				dto.setNumberthreeRate(df.format(numberB/total));
				dto.setReturn_modify_rate(df.format(numberRe/total));
			}
		}
		
		public String getTableIds(String id_emp_phy,Boolean bool,List<MrQualityDTO> mrQualityList){
			String  ids = "( ";
	    	for(int i=0;i<mrQualityList.size();i++){	
	    		if(mrQualityList.get(i).getId_emp_phy()==null || mrQualityList.get(i).getId_emp_phy().equals(id_emp_phy)) continue;
	    		if(bool){  
					ids +=" '"+mrQualityList.get(i).getId_cimrfpother()+"',"; 			
	    		}else{ 	
					ids +=" '"+mrQualityList.get(i).getId_mrfp()+"',";       			
	    		}			
			}	
	    	int length = ids.length();
	    	String substring="";
	    	if(length>0){
	    	   substring = ids.substring(0,ids.length()-1);
	    	}
			String idsNew = substring+")";
			return idsNew;
		}
		
		public String[] getSqlWhere(String dt_begin,String dt_end,String id_emp_phy){
		
			StringBuilder sb = new StringBuilder();
			SqlParam sq=new SqlParam();
			if(!StringUtil.isEmptyWithTrim(dt_begin)){
				sb.append(" and ee.dt_end>=? ");
				sq.addParam(dt_begin);
			}
			if(!StringUtil.isEmptyWithTrim(dt_end)){
				sb.append(" and ee.dt_end<=? ");
				sq.addParam(dt_end);
			}	
			if(!StringUtil.isEmptyWithTrim(id_emp_phy)){
				sb.append(" and bp.id_psndoc=? ");
				sq.addParam(id_emp_phy);
			}
			String [] str = new String[]{sb.toString(),sq.toString()};
					
			return str;
		}
}
