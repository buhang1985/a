package iih.syn.sbd.dto.datainit.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 基础数据初始化参数 DTO数据 
 * 
 */
public class InitDataParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 实体全路径
	 * @return String
	 */
	public String getName_class() {
		return ((String) getAttrVal("Name_class"));
	}
	/**
	 * 实体全路径
	 * @param Name_class
	 */
	public void setName_class(String Name_class) {
		setAttrVal("Name_class", Name_class);
	}
	/**
	 * 目标库
	 * @return String
	 */
	public String getSrc_to() {
		return ((String) getAttrVal("Src_to"));
	}
	/**
	 * 目标库
	 * @param Src_to
	 */
	public void setSrc_to(String Src_to) {
		setAttrVal("Src_to", Src_to);
	}
	/**
	 * 来源库
	 * @return String
	 */
	public String getSrc_from() {
		return ((String) getAttrVal("Src_from"));
	}
	/**
	 * 来源库
	 * @param Src_from
	 */
	public void setSrc_from(String Src_from) {
		setAttrVal("Src_from", Src_from);
	}
	/**
	 * 初始化条目
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 初始化条目
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 条件
	 * @return String
	 */
	public String getWhere() {
		return ((String) getAttrVal("Where"));
	}
	/**
	 * 条件
	 * @param Where
	 */
	public void setWhere(String Where) {
		setAttrVal("Where", Where);
	}
	/**
	 * 上传标识
	 * @return FBoolean
	 */
	public FBoolean getFg_upload() {
		return ((FBoolean) getAttrVal("Fg_upload"));
	}
	/**
	 * 上传标识
	 * @param Fg_upload
	 */
	public void setFg_upload(FBoolean Fg_upload) {
		setAttrVal("Fg_upload", Fg_upload);
	}
	/**
	 * 是否更新全表
	 * @return FBoolean
	 */
	public FBoolean getFg_full() {
		return ((FBoolean) getAttrVal("Fg_full"));
	}
	/**
	 * 是否更新全表
	 * @param Fg_full
	 */
	public void setFg_full(FBoolean Fg_full) {
		setAttrVal("Fg_full", Fg_full);
	}
}