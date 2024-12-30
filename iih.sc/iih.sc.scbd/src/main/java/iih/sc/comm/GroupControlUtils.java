package iih.sc.comm;

import xap.mw.core.data.BizException;

/**
 * 集团管控
 * @author yank
 *
 */
public class GroupControlUtils {
	private static final String FIELD_GROUP_ID = "id_grp";
	private static final String FIELD_ORG_ID = "id_org";
	/**
	 * 获取过滤器
	 * @return
	 * @throws BizException
	 */
	public static String getFilter() throws BizException{
		return getFilter(FIELD_GROUP_ID,FIELD_ORG_ID);
	}
	/**
	 * 获取过滤器
	 * @param grpField 集团字段
	 * @param orgField 组织字段
	 * @return SQL查询条件片段
	 * @throws BizException
	 */
	public static String getFilter(String grpField,String orgField) throws BizException{
		StringBuilder filterBuilder = new StringBuilder();
		filterBuilder.append(String.format(" AND %s='%s'",grpField,ScContextUtils.getGrpId()));
		filterBuilder.append(String.format(" AND %s='%s'",orgField,ScContextUtils.getOrgId()));		
		return filterBuilder.toString();		
	}
	/**
	 * 获取过滤器(含空情况，空也可以查到)
	 * @param grpField 集团字段
	 * @param orgField 组织字段
	 * @return SQL查询条件片段
	 * @throws BizException
	 */
	public static String getContainNullFilter(String grpField,String orgField) throws BizException{
		StringBuilder filterBuilder = new StringBuilder();
		filterBuilder.append(String.format(" AND (%s='%s' or isnull(%s,'~')='~')",grpField,ScContextUtils.getGrpId()));
		filterBuilder.append(String.format(" AND (%s='%s' or isnull(%s,'~')='~')",orgField,ScContextUtils.getOrgId()));		
		return filterBuilder.toString();		
	}
	/**
	 * 获取过滤器
	 * @param tableAliaxName 表别名
	 * @param grpField 集团字段
	 * @param orgField 组织字段
	 * @return SQL查询条件片段
	 * @throws BizException
	 */
	public static String getFilter(String tableAliaxName,String grpField,String orgField) throws BizException{
		StringBuilder filterBuilder = new StringBuilder();
		filterBuilder.append(String.format(" AND %s.%s='%s'",tableAliaxName,grpField,ScContextUtils.getGrpId()));
		filterBuilder.append(String.format(" AND %s.%s='%s'",tableAliaxName,orgField,ScContextUtils.getOrgId()));		
		return filterBuilder.toString();		
	}
}
