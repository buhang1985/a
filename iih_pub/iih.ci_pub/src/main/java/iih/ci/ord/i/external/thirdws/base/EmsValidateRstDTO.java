package iih.ci.ord.i.external.thirdws.base;

import xap.mw.core.data.BaseDTO;
/**
 * 
 * @author 校验结果
 *
 */
public class EmsValidateRstDTO extends BaseDTO  {
	private static final long serialVersionUID = 1L;
	/**
	 * 提示信息的等级
	 */
	public static Integer INFO = 0;//提示信息
	public static Integer WARN = 1;//警告信息
	public static Integer ERROR = 2;//错误信息
	public EmsValidateRstDTO(){
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
	/**
	 * 信息内容
	 * @return
	 */
	public StringList getMsgInfoList(){
		StringList list = ((StringList) getAttrVal("MsgInfoList"));
		if(list == null) {
			list = new StringList();
			this.setMsgInfoList(list);
		}
		return list;
	}
	/**
	 * 信息内容
	 * @param MsgInfoList
	 * @return
	 */
	public void setMsgInfoList(StringList MsgInfoList){
		setAttrVal("MsgInfoList", MsgInfoList);
	}
}
