package iih.sc.scbd.log.s.bp;

import java.util.HashMap;
import java.util.Map;

import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.i.IAttrDesc;

/**
 * 日志解析器
 * @author yank,caichenji
 *
 */
public class LogParser {	
	public static final String PARAM_FIELD_LABEL = "@field_label";//字段标题
	public static final String PARAM_FIELD_NAME = "@field_name";//字段名
	public static final String PARAM_OLD_VALUE = "@old_value";//旧值
	public static final String PARAM_NEW_VALUE = "@new_value";//新值	
	/**
	 * 生成日志内容
	 * @param template 模板
	 * @param fileds 字段名，逗号分隔
	 * @param entityData 新数据DO
	 * @param origData 旧数据DO
	 * @return
	 * @throws BizException
	 */
	public String generate(String template,String fileds,BaseDO entityData,BaseDO origData) throws BizException{
		BaseDO doObj = entityData ==null ? origData : entityData;
		if(doObj==null){
			throw new BizException("参数新数据、旧数据都为空！");
		}		
		String[] fieldArray = fileds.split(",");
		StringBuilder builder = new StringBuilder();
		boolean first = true;
		for(String field : fieldArray){
	
			field = StringUtil.firstCharUpper(field.trim());
			IAttrDesc attrDesc = doObj.getDODesc().getAttrDesc(field);
			if(attrDesc==null){
				first = true;
				continue;
			}
//			if(attrDesc.isRefType()){
//				//参照类型字段特殊处理
//				attrDesc.getRefDoc();
//				attrDesc.getRefTblinfos();
//			}
			//旧值
			String oldValue =  (null == origData || null == origData.getAttrVal(field)  ? " " : origData.getAttrVal(field)).toString(); 
			//新值
			String newValue =  (null == entityData || null == entityData.getAttrVal(field) ? " " : entityData.getAttrVal(field)).toString(); 
			//如果旧值和新增 相等则不记录
			if(oldValue.equals(newValue)) {
				continue;
			}
			if(first){first = false;}
			else//字段日志分隔符	
				builder.append(",");
			Map<String,Object> data = new HashMap<String,Object>();
			data.put(PARAM_FIELD_LABEL, attrDesc.getColumn().getLabel());
			data.put(PARAM_FIELD_NAME, attrDesc.getColumn().getName());
			data.put(PARAM_OLD_VALUE, oldValue);
			data.put(PARAM_NEW_VALUE, newValue);
			
			String content = this.parseAndReplace(template, data);
			builder.append(content);
		}	
		return builder.toString();
	}
	/**
	 * 解析替换
	 * @param template 模板
	 * @param data 数据
	 * @return
	 */
	private String parseAndReplace(String template,Map<String,Object> data){
		// 替换字段显示名
		template = template.replaceAll(PARAM_FIELD_LABEL, ""+(String)data.get(PARAM_FIELD_LABEL));
		// 替换字段名称
		template = template.replaceAll(PARAM_FIELD_NAME, ""+data.get(PARAM_FIELD_NAME));
		// 替换老值
		template = template.replaceAll(PARAM_OLD_VALUE, ""+data.get(PARAM_OLD_VALUE));
		// 替换新值
		template = template.replaceAll(PARAM_NEW_VALUE, ""+data.get(PARAM_NEW_VALUE));
		return template;
	}
}
