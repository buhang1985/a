package iih.ci.mi.ord.i.meta;

import iih.ci.mi.basic.MiErrorLevel;
import iih.ci.mi.basic.MiRuleRstType;
import xap.mw.core.data.FMap;

/**
 * 医保规则校验结果
 * @author HUMS
 *
 */
public class OrdSrvRuleRstDTO extends OrdSrvMiBaseDTO{

	private static final long serialVersionUID = 1L;
	
	
	/**
	 * 医嘱id
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 适应症判断方式，控制类型
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	

	/**
	 * 医嘱名称
	 * @return String
	 */
	public String getName_or() {
		return ((String) getAttrVal("Name_or"));
	}
	/**
	 * 医嘱名称
	 * @param Name_or
	 */
	public void setName_or(String Name_or) {
		setAttrVal("Name_or", Name_or);
	}
	
	/**
	 * 医嘱服务项目
	 * @return String
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}
	/**
	 * 医嘱服务项目
	 * @param Id_orsrv
	 */
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}	
	
	/**
	 * 错误级别 ERROR、WARN、INFO
	 * ERROR：弹出提示、不允许继续执行，
	 * WARN:弹出提示、允许继续执行
	 * INFO:不处理记录信息、继续执行
	 * @param Id_orsrv
	 */
	public String getErrorlevel() {
		
		FMap map = this.getError_map();
		if(map== null || map.size() ==0){
			return MiErrorLevel.INFO;
		}
		
		if(map.containsKey(MiRuleRstType.REPEAT_PRES_DRUG) || map.containsKey(MiRuleRstType.GREATER_THAN_ONE_TIME)) {
			return MiErrorLevel.ERROR;
		}
		
		if(map.containsKey(MiRuleRstType.GREATER_THAN_GET_OEP) || map.containsKey(MiRuleRstType.GREATER_THAN_OWN_OEP) || map.containsKey(MiRuleRstType.GREATER_THAN_GET_ER)) {
			return MiErrorLevel.ERROR;
		}
		
		if(map.containsKey(MiRuleRstType.SINGLEIDSRV) || map.containsKey(MiRuleRstType.RADIATION_CLASS_ORDER)) {
			return MiErrorLevel.WARN;
		}
		return MiErrorLevel.INFO;
	}
	
	/**
	 * 校验结果
	 * @return String
	 */
	public FMap getError_map() {
		return ((FMap) getAttrVal("Error_map"));
	}
	/**
	 * 校验是否通过
	 * @param Error_map
	 */
	public void setError_map(FMap Error_map) {
		setAttrVal("Error_map", Error_map);
	}
	
	public String getErrorMsg() {
		
		StringBuffer msgBuffer = new StringBuffer();
		FMap errorMap = this.getError_map();
		if(errorMap == null){
			return "";
		}
		for(Object msgObj : errorMap.values()){
			msgBuffer.append(msgObj.toString()).append(System.lineSeparator());
		}
		return msgBuffer.toString();
	}
}
