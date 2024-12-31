package iih.ci.ord.s.bp;

import java.util.List;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.ortpl.dto.OrTmplDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.data.FMap;
import xap.mw.core.data.FMap2;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class getTemplateClassIficationBP {
  
	public   FMap getTemplateClassIfication(String en_entp,String id_dept,String id_emp,String sd_tp)throws BizException{
		
		 FMap map = new FMap();
		 String fg_use= getEnTp(en_entp); 
		 String sql ="";
		 if(fg_use != ""){
			  sql =  getfunHispitals()+" and "+fg_use  +"  union all " +getDept(id_dept)+" and "+fg_use  +" union all "+getpersonal(id_emp)+"  and "+fg_use;
		 }else {
			   sql =  getfunHispitals() +" union all " +getDept(id_dept)+" union all "+getpersonal(id_emp); 
		 }
		
		List<OrTmplDTO> hispital = (List<OrTmplDTO> ) new DAFacade()
		.execQuery(sql,  new BeanListHandler(
				OrTmplDTO.class));
		
		 
		map.put(IBdSrvDictCodeConst.SD_OWTP_HOSPIAL_ID, ListConvertFArrayList2(hispital));
		//map.put(IBdSrvDictCodeConst.SD_OWTP_DEPARTMENT_ID, ListConvertFArrayList2(dept));
		//map.put(IBdSrvDictCodeConst.SD_OWTP_PERSONAL_ID, ListConvertFArrayList2(personal));
		
		return map;
	}
	
	private String getEnTp(String code_entp) {
		String entp = null;
		if (IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(code_entp)) {
			entp = " fg_entp_op ='Y'";
		} else if (IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW.equals(code_entp)) {
			entp = " fg_entp_er ='Y'";
		} else if (IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID.equals(code_entp)) {
			entp = " fg_entp_er1 ='Y'";
		} else if (IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS.equals(code_entp)) {
			entp = " fg_entp_er2 ='Y'";
		} else if (IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(code_entp)) {
			entp = " fg_entp_ip ='Y'";
		} else if (IBdFcDictCodeConst.SD_CODE_ENTP_FA.equals(code_entp)) {
			entp = "  fg_entp_fm ='Y'";
		} else if (IBdFcDictCodeConst.SD_CODE_ENTP_PE.equals(code_entp)) {
			entp = "  fg_entp_pe ='Y'";
		}
		return entp;
	}
	
	
	private FArrayList ListConvertFArrayList2(List<OrTmplDTO> list){
		FArrayList Flist = new FArrayList();
		if(list != null){
			for(OrTmplDTO dto:list){
				Flist.add(dto);
			}
		}
		return Flist;
	}
	
	
	private String getfunHispitals(){
		 StringBuffer sb = new StringBuffer();
		  sb.append(" select  'H' Id_ortmplcarel, '");
		  sb.append(IBdSrvDictCodeConst.SD_OWTP_HOSPIAL_ID);
		  sb.append("' Id_ortmpl,'全院' name , '0' id_ortmplca,'' sd_ortmpltp,'0' as OrtmplType,0 as orders from dual" );
		  sb.append(" union all ");
		  sb.append(" select ca.id_ortmplca  Id_ortmplcarel,  ca.id_ortmplca|| 'H' Id_ortmpl , ca.name,case  ca.id_parent || 'H' when '~H' then '");
		  sb.append(IBdSrvDictCodeConst.SD_OWTP_HOSPIAL_ID);
		  sb.append("' else  ca.id_parent || 'H' end id_ortmplca ,'' sd_ortmpltp ,'0' as OrtmplType,0 as orders from bd_srv_ortmpl_ca ca where "+getContextManager("ca"));
		  sb.append("  union all ");
		  sb.append( "  select ortmpl.id_ortmpl  Id_ortmplcarel  ,");
		  sb.append(" case when carel.fg_sync ='N' then ortmpl.id_ortmpl || 'X' else ");
		  sb.append(" ortmpl.id_ortmpl || 'H' end  Id_ortmpl,  ");
		  sb.append(" ortmpl.name ,carel.id_ortmplca|| 'H' id_ortmplca ,ortmpl.sd_ortmpltp ,'1' as OrtmplType,ortmpl.seqno as orders from ");
		  sb.append("  bd_srv_ortmpl ortmpl ,bd_srv_ortmpl_ca_rel carel  ");
		  sb.append(" where  ortmpl.id_ortmpl = carel.id_ortmpl and ortmpl.id_srvorrt='");
		  sb.append(IBdSrvDictCodeConst.SD_OWTP_HOSPIAL_ID);
		  sb.append("' and ortmpl.ds='0' and carel.ds='0' and ortmpl.fg_active='Y' and "+getContextManager("ortmpl"));
		  return sb.toString();
		/*return  " select  'H' Id_ortmplcarel, '"+IBdSrvDictCodeConst.SD_OWTP_HOSPIAL_ID+"' Id_ortmpl,'全院' name , '0' id_ortmplca,'' sd_ortmpltp,'0' as OrtmplType from dual "
                +" union all "
				+" select ca.id_ortmplca  Id_ortmplcarel,  ca.id_ortmplca|| 'H' Id_ortmpl , ca.name,case  ca.id_parent || 'H' when '~H' then '"+IBdSrvDictCodeConst.SD_OWTP_HOSPIAL_ID+"' else  ca.id_parent || 'H' end id_ortmplca ,'' sd_ortmpltp ,'0' as OrtmplType from bd_srv_ortmpl_ca ca "+
				"  where ca.id_srvorrt='"+IBdSrvDictCodeConst.SD_OWTP_HOSPIAL_ID+"' and ca.ds='0'"+
				"  union all "+
				"  select ortmpl.id_ortmpl  Id_ortmplcarel  ,"
				+" case when carel.fg_sync ='N' then ortmpl.id_ortmpl || 'X' else "
				+" ortmpl.id_ortmpl || 'H' end  Id_ortmpl,  "
				+" ortmpl.name ,carel.id_ortmplca|| 'H' id_ortmplca ,ortmpl.sd_ortmpltp ,'1' as OrtmplType from "+
				"  bd_srv_ortmpl ortmpl ,bd_srv_ortmpl_ca_rel carel  "+  
				"  where  ortmpl.id_ortmpl = carel.id_ortmpl and ortmpl.id_srvorrt='"+IBdSrvDictCodeConst.SD_OWTP_HOSPIAL_ID+"'"
				+" and ortmpl.ds='0' and carel.ds='0'  ";
				 */
				 
		}
	
	
	private String getDept(String id_dep){
		
		StringBuffer sb = new StringBuffer();
		sb.append(" select  'D' Id_ortmplcarel, '");
		sb.append(IBdSrvDictCodeConst.SD_OWTP_DEPARTMENT_ID);
		sb.append("' Id_ortmpl,'科室' name , '0' id_ortmplca,'' sd_ortmpltp,'0' as OrtmplType,0 as orders from dual ");
		sb.append(" union all ");
		sb.append(" select ca.id_ortmplca  Id_ortmplcarel  ,ca.id_ortmplca||'D' Id_ortmpl ,ca.name,case  ca.id_parent || 'D' when '~D' then '");
		sb.append(IBdSrvDictCodeConst.SD_OWTP_DEPARTMENT_ID);
		sb.append("' else  ca.id_parent || 'D' end id_ortmplca, '' sd_ortmpltp,'0' as OrtmplType,0 as orders from bd_srv_ortmpl_ca ca ");
		sb.append(" where ca.id_srvorrt='");
		sb.append(IBdSrvDictCodeConst.SD_OWTP_DEPARTMENT_ID);
		sb.append("'  and  ca.id_dep='");
		sb.append(id_dep);
		sb.append("' and ca.ds='0'");
		sb.append(" and " + this.getContextManager("ca"));
		sb.append(" union all ");
	 
		sb.append(" select ortmpl.id_ortmpl  Id_ortmplcarel ,");
		sb.append(" case when carel.fg_sync ='N' then ortmpl.id_ortmpl || 'X' else ");
		sb.append(" ortmpl.id_ortmpl || 'D' end  Id_ortmpl,  ");
		sb.append(" ortmpl.name ,carel.id_ortmplca||'D' id_ortmplca,ortmpl.sd_ortmpltp,'1' as OrtmplType,ortmpl.seqno as orders from ");
		sb.append(" bd_srv_ortmpl ortmpl ,bd_srv_ortmpl_ca_rel carel  ");
		sb.append(" where  ortmpl.id_ortmpl = carel.id_ortmpl ");
		sb.append(" and ortmpl.id_srvorrt='");
		sb.append(IBdSrvDictCodeConst.SD_OWTP_DEPARTMENT_ID);
		sb.append("'  and ortmpl.id_dep='");
		sb.append(id_dep);
		sb.append("' and ortmpl.ds='0' and carel.ds='0' and ortmpl.fg_active='Y' and "+this.getContextManager("ortmpl"));
		return sb.toString();
	/*	return  " select  'D' Id_ortmplcarel, '"+IBdSrvDictCodeConst.SD_OWTP_DEPARTMENT_ID+"' Id_ortmpl,'科室' name , '0' id_ortmplca,'' sd_ortmpltp,'0' as OrtmplType from dual "+
				" union all "+
				" select ca.id_ortmplca  Id_ortmplcarel  ,ca.id_ortmplca||'D' Id_ortmpl ,ca.name,case  ca.id_parent || 'D' when '~D' then '"+IBdSrvDictCodeConst.SD_OWTP_DEPARTMENT_ID+"' else  ca.id_parent || 'D' end id_ortmplca, '' sd_ortmpltp,'0' as OrtmplType from bd_srv_ortmpl_ca ca "+
				" where ca.id_srvorrt='"+IBdSrvDictCodeConst.SD_OWTP_DEPARTMENT_ID+"'"+
				"  and  ca.id_dep='"+ id_dep+"' and ca.ds='0'" + 
				" union all "+
				" select ortmpl.id_ortmpl  Id_ortmplcarel ,"
				+" case when carel.fg_sync ='N' then ortmpl.id_ortmpl || 'X' else "
				+" ortmpl.id_ortmpl || 'D' end  Id_ortmpl,  "
				+ "ortmpl.name ,carel.id_ortmplca||'D' id_ortmplca,ortmpl.sd_ortmpltp,'1' as OrtmplType from "+
				" bd_srv_ortmpl ortmpl ,bd_srv_ortmpl_ca_rel carel  "+  
				" where  ortmpl.id_ortmpl = carel.id_ortmpl "
				+ " and ortmpl.id_srvorrt='"+IBdSrvDictCodeConst.SD_OWTP_DEPARTMENT_ID+"'"
				+"  and ortmpl.id_dep='"+id_dep+"' and ortmpl.ds='0' and carel.ds='0'    "
				;*/
				 
		}
	
	private String getpersonal(String id_emp){
		
		StringBuffer sb = new StringBuffer();
		sb.append(" select  'R' Id_ortmplcarel, '");
		sb.append(IBdSrvDictCodeConst.SD_OWTP_PERSONAL_ID);
		sb.append("' Id_ortmpl,'个人' name , '0' id_ortmplca,'' sd_ortmpltp,'0' as OrtmplType,0 as orders from dual ");
		sb.append(" union all ");
		sb.append(" select ca.id_ortmplca  Id_ortmplcarel ,ca.id_ortmplca||'R' Id_ortmpl ,ca.name,case  ca.id_parent || 'R' when '~R' then '");
		sb.append(IBdSrvDictCodeConst.SD_OWTP_PERSONAL_ID);
		sb.append("' else  ca.id_parent || 'R' end id_ortmplca,'' sd_ortmpltp,'0' as OrtmplType, 0 as orders from bd_srv_ortmpl_ca ca ");
		sb.append(" where ca.id_srvorrt='");
		sb.append(IBdSrvDictCodeConst.SD_OWTP_PERSONAL_ID);
		sb.append("' and  ca.id_emp='");
		sb.append(id_emp);
		sb.append("' and ca.ds='0'");
		sb.append(" and "+this.getContextManager("ca"));
		sb.append(" union all ");
		sb.append(" select ortmpl.id_ortmpl Id_ortmplcarel ,");
		sb.append(" case when carel.fg_sync ='N' then ortmpl.id_ortmpl || 'X' else ");
		sb.append(" ortmpl.id_ortmpl || 'R' end  Id_ortmpl,  ");
		sb.append(" ortmpl.name ,carel.id_ortmplca||'R' id_ortmplca ,ortmpl.sd_ortmpltp,'1' as OrtmplType,ortmpl.seqno as orders from ");
		sb.append(" bd_srv_ortmpl ortmpl ,bd_srv_ortmpl_ca_rel carel  ");
		sb.append("  where  ortmpl.id_ortmpl = carel.id_ortmpl ");
		sb.append("  and ortmpl.id_srvorrt='");
		sb.append(IBdSrvDictCodeConst.SD_OWTP_PERSONAL_ID);
		sb.append("'  and ortmpl.id_emp ='");
		sb.append(id_emp);
		sb.append("' and ortmpl.ds='0' and carel.ds='0' and ortmpl.fg_active='Y' and "+this.getContextManager("ortmpl"));
		return sb.toString();
		
		/*return  " select  'R' Id_ortmplcarel, '"+IBdSrvDictCodeConst.SD_OWTP_PERSONAL_ID+"' Id_ortmpl,'个人' name , '0' id_ortmplca,'' sd_ortmpltp,'0' as OrtmplType from dual "+
				" union all "+
				" select ca.id_ortmplca  Id_ortmplcarel ,ca.id_ortmplca||'R' Id_ortmpl ,ca.name,case  ca.id_parent || 'R' when '~R' then '"+IBdSrvDictCodeConst.SD_OWTP_PERSONAL_ID+"' else  ca.id_parent || 'R' end id_ortmplca,'' sd_ortmpltp,'0' as OrtmplType from bd_srv_ortmpl_ca ca "+
				" where ca.id_srvorrt='"+IBdSrvDictCodeConst.SD_OWTP_PERSONAL_ID+"'"+
				" and  ca.id_emp='" +id_emp+"' and ca.ds='0'"+
				" union all "+
				" select ortmpl.id_ortmpl Id_ortmplcarel ,"
				+" case when carel.fg_sync ='N' then ortmpl.id_ortmpl || 'X' else "
				+" ortmpl.id_ortmpl || 'R' end  Id_ortmpl,  "
				+ " ortmpl.name ,carel.id_ortmplca||'R' id_ortmplca ,ortmpl.sd_ortmpltp,'1' as OrtmplType from "+
				" bd_srv_ortmpl ortmpl ,bd_srv_ortmpl_ca_rel carel  "+  
				"  where  ortmpl.id_ortmpl = carel.id_ortmpl "
				+"  and ortmpl.id_srvorrt='"+IBdSrvDictCodeConst.SD_OWTP_PERSONAL_ID+"'"
				+"  and ortmpl.id_emp ='"+id_emp+"' and ortmpl.ds='0' and carel.ds='0'   "
				;*/
				 
		}
	/**
	 * 管控信息
	 * @param fg_tableAlias
	 * @return
	 */
	private String getContextManager(String tableAlias){
		String org = Context.get().getOrgId();
		String group = Context.get().getGroupId();
		return tableAlias+".Id_grp='"+group+"' and "+tableAlias+".Id_org='"+org+"'"; 
	}
}
