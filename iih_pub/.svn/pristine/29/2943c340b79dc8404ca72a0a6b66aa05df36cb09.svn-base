package iih.bd.mm.common;

import org.apache.commons.lang3.StringUtils;

public class MmSQLHelper {
	
    public static String initInCondition(String columnName, String[] ids) {
    	
    	if(ids == null || ids.length <= 0) {
    		
    		return null;
    	}
    	
		StringBuffer condition = new StringBuffer("(");
		
		int maxNum = 1000;
		int num = ids.length / maxNum;
		for(int i = 0; i <= num; i ++) {
			
			StringBuffer subCondition = new StringBuffer(columnName + " in ");
			String[] subIds = new String[maxNum];
			if(i * maxNum < ids.length) {
				
				int length = i < num ? maxNum : ids.length - i * maxNum;
				System.arraycopy(ids, i * maxNum, subIds, 0, length);
				condition.append(subCondition.append(getCondition(subIds)));
			}
			
	        if(((i + 1) * maxNum < ids.length)) {
	        	
	        	condition.append(" or ");
	        }
		}
		
		return condition.append(")").toString();
	}
	
	private static String getCondition(String[] ids) {
		
		StringBuffer subCondition = new StringBuffer("(");
		for(String id : ids) {
			
			if(StringUtils.isBlank(id)) {
				
				continue;
			}
			subCondition.append("'" + id + "' ,");
		}
		
        int index = subCondition.lastIndexOf(",");
        subCondition = subCondition.replace(index, index + 1, ")");
		
        return subCondition.toString();
	}
}
