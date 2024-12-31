/*
 * 扼要描述
     * 详细描述：〈描述〉
 * author：〈创建人/修改人〉
 */
package iih.ci.mr.s.util;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BaseDTO;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;

/**
 * 〈扼要描述〉
 * 根据dto的字段名称 以及value生成insert语句  主要用于插入三方表
 * @author    [邹海强]
 * @version   [版本号, YYYY-MM-DD]
 */
public class GetInsertSqlByDtoUtil {

	public static List<String> GetGetInsertSqlByDto(BaseDTO[] dtoArr,String tableName){
		 List<String> sqlList=new ArrayList<String>();
		 for (BaseDTO baseDto : dtoArr) {
			String[] attrNames = baseDto.getAttrNames();
			StringBuilder sb = new StringBuilder("insert into "+tableName+"(%s) values(%s)");
			StringBuilder sbfields = new StringBuilder();
			StringBuilder sbvalues = new StringBuilder(); 
			for(String name:attrNames) {
				name = (name.charAt(0) + "").toUpperCase() + name.substring(1, name.length());
				Object ziduan= baseDto.getAttrVal(name);
				String valuestr;
				if (ziduan instanceof FDateTime) {
					valuestr = baseDto.getAttrVal(name) == null?"":"to_date('"+baseDto.getAttrVal(name).toString()+"','yyyy-mm-dd,hh24:mi:ss')";
				}else if(ziduan instanceof FDate){
					valuestr = baseDto.getAttrVal(name) == null?"":"to_date('"+baseDto.getAttrVal(name).toString()+"','yyyy-mm-dd')";
				}else{
					valuestr = baseDto.getAttrVal(name) == null?"":baseDto.getAttrVal(name).toString();
					valuestr = "'"+valuestr+"'";
				}
				
				if(sbfields.length() ==  0) {
					sbfields.append(name);
					sbvalues.append(valuestr);
				}else {
					sbfields.append(",").append(name);
					sbvalues.append(",").append(valuestr);
				}
			}
			String sql = String.format(sb.toString(), sbfields.toString(),sbvalues.toString());
			sqlList.add(sql);
		 }
		return sqlList;	
	}
}
