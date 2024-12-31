package iih.ci.mr.s.util;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BaseDTO;

public class GetUpdateSqlByDtoUtil {
	public static List<String> GetUpdateSqlByDto(BaseDTO[] dtoArr,String tableName){		
		 List<String> sqlList=new ArrayList<String>();
		 for (BaseDTO baseDto : dtoArr) {	
			 StringBuilder sb = new StringBuilder("update "+tableName+
					 " set dept_director='"+(String)baseDto.getAttrVal("Dept_director")+"',dept_director_no='"+(String)baseDto.getAttrVal("Dept_director_no")
					 +"',chiefly_doctor='"+(String)baseDto.getAttrVal("Chiefly_doctor")+"',chiefly_doctor_no='"+(String)baseDto.getAttrVal("Chiefly_doctor_no")
					 +"',sub_doctor='"+(String)baseDto.getAttrVal("Sub_doctor")+"',sub_doctor_no='"+(String)baseDto.getAttrVal("Sub_doctor_no")
					 +"',name_zy_doc='"+(String)baseDto.getAttrVal("Name_zy_doc")+"',sd_zy_doc='"+(String)baseDto.getAttrVal("Sd_zy_doc")
					 +"',in_doctor='"+(String)baseDto.getAttrVal("In_doctor")+"',in_doctor_no='"+(String)baseDto.getAttrVal("In_doctor_no")
					 +"',main_doctor='"+(String)baseDto.getAttrVal("Main_doctor")+"',main_doctor_no='"+(String)baseDto.getAttrVal("Main_doctor_no")+"' where ipid= %s");
				
				String ipid="";
			    
				String[] attrNames = baseDto.getAttrNames();
				for(String name:attrNames){
					name = (name.charAt(0) + "").toUpperCase() + name.substring(1, name.length());
					if(name.equals("Ipid")){	
					   ipid="'"+(String)baseDto.getAttrVal(name)+"'";	
					}  					 
				}			
				String sql = String.format(sb.toString(),ipid);
				sqlList.add(sql);
			 }
			return sqlList;	
	}
}
