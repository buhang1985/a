package iih.mr.mrm;

import java.util.List;

import iih.mr.mrconst.IMrParamConst;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class DiseaseSortReportService {
	
	// 获取疾病名称总数
	@SuppressWarnings("unchecked")
	public  List<DiseaseSortReportDTO>  getDiseaseAnnualReport(String dt_begin,String dt_end) throws BizException{
		DAFacade daf = new DAFacade();
		StringBuilder sql = new StringBuilder();
		sql.append("select count(xy.name_di) as total,xy.name_di as disease,xy.sd_di from CI_MR_FP_XYDI  xy ");
		sql.append("left join ci_mr_fp_di di ");
		sql.append("on di.id_mrfpdi =xy.id_mrfpdi ");
		sql.append("left join en_ent ent ");
		sql.append("on di.id_ent=ent.id_ent ");
		sql.append("left join ci_amr amr ");
		sql.append("on amr.id_ent=di.id_ent ");
		sql.append("where amr.fg_complete='Y' and ent.fg_ip='N' and fg_maindi='Y' ");
		
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
		sql.append(" group by xy.name_di,xy.sd_di ");	
		List<DiseaseSortReportDTO> list = (List<DiseaseSortReportDTO>) daf.execQuery(sql.toString(),sq,new BeanListHandler(DiseaseSortReportDTO.class));
		if(list!=null && list.size()>0)
			getDiseaseData(dt_begin,dt_end,list);
		return list;
	}
	
	
	// 获取疾病相关数据
	@SuppressWarnings("unchecked")
	public void getDiseaseData(String dt_begin,String dt_end,List<DiseaseSortReportDTO> list) throws BizException{
		DAFacade daf = new DAFacade();
		StringBuilder sql = new StringBuilder();
		sql.append("select  xy.name_di,xy.sd_di,xy.id_mrfpxydi,xy.sd_treatment_outcome, ");
		sql.append("pat.id_cimrfppat,pat.hosdays from CI_MR_FP_XYDI  xy ");
		sql.append("left join ci_mr_fp_di di ");
		sql.append("on di.id_mrfpdi =xy.id_mrfpdi ");
		sql.append("left join en_ent ent ");
		sql.append("on di.id_ent=ent.id_ent ");
		sql.append("left join ci_amr amr ");
		sql.append("on amr.id_ent=di.id_ent ");
		sql.append("left join ci_mr_fp_pat pat ");
		sql.append("on pat.id_ent=di.id_ent ");
		sql.append("where amr.fg_complete='Y' and ent.fg_ip='N' and fg_maindi='Y' ");
		
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
		List<MrQualityDTO> mrQualityList = (List<MrQualityDTO>) daf.execQuery(sql.toString(),sq,new BeanListHandler(MrQualityDTO.class));
	    getOutcomeDisease(list,mrQualityList);
	}
	
	
	// 获取疾病转归人数
	public void getOutcomeDisease(List<DiseaseSortReportDTO> list,List<MrQualityDTO> mrQualityList) throws BizException{		
		DAFacade daf = new DAFacade();		
		for(DiseaseSortReportDTO diseaseDto: list){
			diseaseDto.setCure("0");
			diseaseDto.setBecome_better("0");
			diseaseDto.setHealed("0");
			diseaseDto.setDeath("0");
			diseaseDto.setOther("0");
		
			StringBuilder sql = new StringBuilder();
			sql.append("select  count(xy.sd_treatment_outcome) as treatment_count, ");
			sql.append(" xy.sd_treatment_outcome from CI_MR_FP_XYDI xy ");
			sql.append(" where  xy.sd_di='"+diseaseDto.getSd_di()+"' ");
			sql.append(" and xy.id_mrfpxydi in ");
			String  mrfpxydiId =getTableIds(diseaseDto.getSd_di(),true,mrQualityList);
			sql.append(mrfpxydiId);
			sql.append(" group by (xy.sd_treatment_outcome) ");		
			@SuppressWarnings("unchecked")
			List<MrQualityDTO> list2 = (List<MrQualityDTO>)daf.execQuery(sql.toString(), new BeanListHandler(MrQualityDTO.class));
			for(MrQualityDTO dto: list2){		
				String sd_treatment=dto.getSd_treatment_outcome();
				if(StringUtil.isEmptyWithTrim(sd_treatment))break;
				String value=String.valueOf(dto.getTreatment_count());
				switch(sd_treatment){
					case IMrParamConst.PARAM_CURE:
						diseaseDto.setCure(value);
						break;
					case IMrParamConst.PARAM_BECOME_BETTER:
						diseaseDto.setBecome_better(value);
						break;
					case IMrParamConst.PARAM_HEALED:
						diseaseDto.setHealed(value);
						break;
					case IMrParamConst.PARAM_DEATH:
						diseaseDto.setDeath(value);
						break;
					case IMrParamConst.PARAM_OTHER:
						diseaseDto.setOther(value);
						break;
				}				
			}
		}
		getOccupyingBedDays(list,mrQualityList);
	}
 
	// 获取占床总天数
	public void getOccupyingBedDays(List<DiseaseSortReportDTO> list,List<MrQualityDTO> mrQualityList) throws BizException{
		DAFacade daf = new DAFacade();		
		for(DiseaseSortReportDTO diseaseDto: list){
			diseaseDto.setIn_hospital_day("0");
			StringBuilder sql = new StringBuilder();
			sql.append("select sum(pat.hosdays) as hosdays from ci_mr_fp_pat pat ");
			sql.append("left join ci_mr_fp_di di ");
			sql.append("on di.id_ent=pat.id_ent ");
			sql.append("left join ci_mr_fp_xydi xy ");
			sql.append("on xy.id_mrfpdi=di.id_mrfpdi ");
			sql.append(" where pat.id_cimrfppat in ");
			String cimrfppatId =getTableIds(diseaseDto.getSd_di(),false,mrQualityList);
			sql.append(cimrfppatId);			
			sql.append(" and xy.sd_di ='"+diseaseDto.getSd_di()+"'");
			@SuppressWarnings("unchecked")
			List<MrQualityDTO> daylist = (List<MrQualityDTO>)daf.execQuery(sql.toString(), new BeanListHandler(MrQualityDTO.class));
			if(daylist!=null && daylist.size()>0){
				diseaseDto.setIn_hospital_day(daylist.get(0).getHosdays()==null?"0":daylist.get(0).getHosdays());
			}
		}
	}
	
	
	public String getTableIds(String sd_di,Boolean bool,List<MrQualityDTO> mrQualityList){	
		String  ids = "( ";
    	for(int i=0;i<mrQualityList.size();i++){	
    		if(mrQualityList.get(i).getSd_di()==null || !mrQualityList.get(i).getSd_di().equals(sd_di)) continue;
    		if(bool){	
				ids +=" '"+mrQualityList.get(i).getId_mrfpxydi()+"',";      			
    		}else{   		
				ids +=" '"+mrQualityList.get(i).getId_cimrfppat()+"',";		
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
