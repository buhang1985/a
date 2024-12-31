package iih.mr.mrm;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class DepMrQcCensusService {
	
	// 获取科室病案总数	
	@SuppressWarnings("unchecked")
	public List<DepMrQcCensusDTO> getDepAndCount(String dt_begin,String dt_end,String id_dep) throws BizException {
		DAFacade daf = new DAFacade();
		StringBuilder sql = new StringBuilder();
		sql.append("select count(1) as mrTotal, dep.name as dep, dep.id_dep as id_dep from ci_mr_fp fp ");
		sql.append("left join ci_amr amr ");
		sql.append("on fp.id_ent=amr.id_ent ");
		sql.append("left join en_ent ent ");
		sql.append("on fp.id_ent=ent.id_ent ");
		sql.append("left join  ci_mr_fp_other  other ");
		sql.append("on other.id_ent=fp.id_ent ");
		sql.append("left join ci_mr_fp_pat pat ");
		sql.append("on fp.id_ent=pat.id_ent ");
		sql.append("left join bd_dep dep ");
		sql.append("on dep.id_dep=pat.id_dep_phyadm ");
		sql.append("where amr.fg_complete='Y'and ent.fg_ip='N' and dep.name is not null ");
		
		SqlParam sq=new SqlParam();
		if(!StringUtil.isEmptyWithTrim(dt_begin) && !StringUtil.isEmptyWithTrim(dt_end)){
			sql.append(" and ent.dt_acpt>=? ");
			sql.append(" and ent.dt_end<=? ");
			sq.addParam(dt_begin);sq.addParam(dt_end);
		}else if(!StringUtil.isEmptyWithTrim(dt_begin)){
			sql.append(" and ent.dt_acpt>=? ");
			sq.addParam(dt_begin);
		}else if(!StringUtil.isEmptyWithTrim(dt_end)){
			sql.append(" and ent.dt_end<=? ");
			sq.addParam(dt_end);
		}	
		if(!StringUtil.isEmptyWithTrim(id_dep)){
			sql.append(" and dep.id_dep=? ");
			sq.addParam(id_dep);
		}
		sql.append(" group by dep.name, dep.id_dep ");
		sql.append(" order by dep.name ");
		List<DepMrQcCensusDTO> list = (List<DepMrQcCensusDTO>) daf.execQuery(sql.toString(),sq,new BeanListHandler(DepMrQcCensusDTO.class));
		if(list!=null && list.size()>0)
			getDepMrData(dt_begin,dt_end,id_dep,list);	
		return list;	
    }
	
	
	// 获取科室 病案相关内容	
	@SuppressWarnings("unchecked")
	public void getDepMrData(String dt_begin,String dt_end,String id_dep,List<DepMrQcCensusDTO> list) throws BizException {
		DAFacade daf = new DAFacade();
		StringBuilder sql = new StringBuilder();
		sql.append("select dep.id_dep,dep.name,fp.id_mrfp,other.id_cimrfpother,other.id_qcp_doc as id_qcp_doc, ");
		sql.append("other.id_qcp_doc as id_qcp_doc,other.name_qom_record as name_qom_record from ci_mr_fp fp ");
		sql.append("left join ci_amr amr ");
		sql.append("on fp.id_ent=amr.id_ent ");
		sql.append("left join en_ent ent ");
		sql.append("on fp.id_ent=ent.id_ent ");
		sql.append("left join  ci_mr_fp_other  other ");
		sql.append("on other.id_ent=fp.id_ent ");
		sql.append("left join ci_mr_fp_pat pat ");
		sql.append("on fp.id_ent=pat.id_ent ");
		sql.append("left join bd_dep dep ");
		sql.append("on dep.id_dep=pat.id_dep_phyadm ");
		sql.append("where amr.fg_complete='Y'and ent.fg_ip='N' and dep.name is not null ");
		
		SqlParam sq=new SqlParam();	
		if(!StringUtil.isEmptyWithTrim(dt_begin) && !StringUtil.isEmptyWithTrim(dt_end)){
			sql.append(" and ent.dt_acpt>=? ");
			sql.append(" and ent.dt_end<=? ");
			sq.addParam(dt_begin);sq.addParam(dt_end);
		}else if(!StringUtil.isEmptyWithTrim(dt_begin)){
			sql.append(" and ent.dt_acpt>=? ");
			sq.addParam(dt_begin);
		}else if(!StringUtil.isEmptyWithTrim(dt_end)){
			sql.append(" and ent.dt_end<=? ");
			sq.addParam(dt_end);
		}	
		if(!StringUtil.isEmptyWithTrim(id_dep)){
			sql.append(" and dep.id_dep=? ");
			sq.addParam(id_dep);
		}
		List<MrQualityDTO> mrQualityList = (List<MrQualityDTO>) daf.execQuery(sql.toString(),sq,new BeanListHandler(MrQualityDTO.class));
		getEvaluatedCount(mrQualityList,list);	
    }
	
	
	// 已评病案数
	public void getEvaluatedCount(List<MrQualityDTO> mrQualityList,List<DepMrQcCensusDTO> list) throws BizException{
		Map<String,Integer> map=new HashMap<String,Integer>();
		for(MrQualityDTO dto:mrQualityList){
			if(dto.getId_qcp_doc()!=null){
				String key=dto.getId_dep();
				if(map.containsKey(key)){
					map.put(key, map.get(key)+1);
				}else{
					map.put(key, 1);
				}			
			}
		}
		for(DepMrQcCensusDTO censusdto: list){
			String key=censusdto.getId_dep();
			censusdto.setAlreadyEvaluateMr(String.valueOf(map.get(key)==null?"0":String.valueOf(map.get(key))));
		}
		getJYBCount(mrQualityList,list);
	}		
	
	
	// 获取甲乙丙数
	public void getJYBCount(List<MrQualityDTO> mrQualityList,List<DepMrQcCensusDTO> list) throws BizException{
		DAFacade daf = new DAFacade();		
	    for(DepMrQcCensusDTO censusdto: list){
	    	censusdto.setNumberone("0");
	    	censusdto.setNumbertwo("0");
	    	censusdto.setNumberthree("0");
	    	
	    	StringBuilder sql = new StringBuilder();
			sql.append("select count(other.name_qom_record) as count ,other.name_qom_record as name_mr_quality from ci_mr_fp fp ");
			sql.append("left join  ci_mr_fp_other other ");
			sql.append("on other.id_ent=fp.id_ent ");
			sql.append("left join ci_mr_fp_pat pat ");
			sql.append("on fp.id_ent=pat.id_ent ");
			sql.append("where pat.id_dep_phyadm='"+censusdto.getId_dep()+"' ");
			sql.append("and other.id_cimrfpother in ");
			String  cimrfpotherId =getTableIds(censusdto.getId_dep(),true,mrQualityList);
			sql.append(cimrfpotherId);	
			sql.append("group by other.name_qom_record ");
			sql.append("order by other.name_qom_record desc ");
			
			@SuppressWarnings("unchecked")
			List<MrQualityDTO> list2 = (List<MrQualityDTO>)daf.execQuery(sql.toString(), new BeanListHandler(MrQualityDTO.class));
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
	    getReturnCount(mrQualityList,list);
	}
	
	
	// 获取返回修改数
	public void getReturnCount(List<MrQualityDTO> mrQualityList,List<DepMrQcCensusDTO> list) throws BizException{
		DAFacade daf = new DAFacade();	
	    for(DepMrQcCensusDTO censusdto: list){
			StringBuilder sql = new StringBuilder();
			sql.append("select count(1) as count from  ci_mr_fp fp ");
			sql.append("left join ci_amr amr ");
			sql.append("on fp.id_ent=amr.id_ent ");
			sql.append("left join ci_mr_fp_pat pat ");
			sql.append("on fp.id_ent=pat.id_ent ");
			sql.append("left join ci_mrm_op op ");
			sql.append("on op.id_amr =amr.id_enhr ");
			sql.append("where pat.id_dep_phyadm='"+censusdto.getId_dep()+"' ");
			sql.append("and op.sd_optp='03' ");
			sql.append("and fp.id_mrfp in ");
			String  cimrfpId =getTableIds(censusdto.getId_dep(),true,mrQualityList);
			sql.append(cimrfpId);
			int count =(int) daf.execQuery(sql.toString(), new ColumnHandler());
			censusdto.setReturn_modify_count(String.valueOf(count));
			getProbability(list);
		 }	
	}
	
	// 获取百分百比小数形式
	public void  getProbability(List<DepMrQcCensusDTO> list){
		DecimalFormat df=new DecimalFormat("######0.00");  
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
	
	public String getTableIds(String id_dep,Boolean bool,List<MrQualityDTO> mrQualityList){
		String  ids = "( ";
    	for(int i=0;i<mrQualityList.size();i++){	
    		if(mrQualityList.get(i).getId_dep()==null || !mrQualityList.get(i).getId_dep().equals(id_dep)) continue;
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
}
