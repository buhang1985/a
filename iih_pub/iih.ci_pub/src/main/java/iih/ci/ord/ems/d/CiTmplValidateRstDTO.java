package iih.ci.ord.ems.d;

import xap.mw.core.data.BaseDTO;
/**
 * 模板保存时，校验结果返回值(不是元数据)
 * 
 */
public class CiTmplValidateRstDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	/**
	 * 提示信息的等级
	 */
	public static Integer INFO = 0;//提示信息
	public static Integer WARN = 1;//警告信息
	public static Integer ERROR = 2;//错误信息
	public CiTmplValidateRstDTO(){
		//默认等级为INFO
		this.setLevel(INFO);
	}
	/**
	 * 校验结果等级
	 * @return Integer
	 */
	public Integer getLevel() {
		return ((Integer) getAttrVal("Level"));
	}	
	/**
	 * 校验结果等级
	 * @param Level
	 */
	public void setLevel(Integer Level) {
		if(this.getLevel()!=null && this.getLevel().compareTo(Level)>0){
			return;
		}
		setAttrVal("Level", Level);
	}
}