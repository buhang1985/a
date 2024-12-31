/*
 * 扼要描述
     * 详细描述：〈描述〉
 * author：〈创建人/修改人〉
 */
package iih.ci.mr.s.util;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BaseDTO;

/**
 * 根据dto主键生成delete语句  主要用于删除三方表
 * @author F
 *
 */
public class GetDeleteSqlByDtoUtil {
	public static List<String> GetDeleteSqlByDto(BaseDTO[] dtoArr,String tableName){		
		 List<String> sqlList=new ArrayList<String>();
		 for (BaseDTO baseDto : dtoArr) {	
			StringBuilder sb = new StringBuilder("delete from "+tableName+" where ipid= %s");		
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
