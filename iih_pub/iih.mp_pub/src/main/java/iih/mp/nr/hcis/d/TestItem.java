package iih.mp.nr.hcis.d;

import java.io.Serializable;

/**
 * 
* @ClassName: TestItem 
* @Description: 检验项目数据
* @author zhy
* @date 2019年5月23日 下午3:51:56 
*
 */
public class TestItem implements Serializable{

	/** 
	* @Fields serialVersionUID : TODO
	*/
	private static final long serialVersionUID = 1L;
    
	/**
	 * 申请编号
	 */
	private String inspection_id;
	
	/**
	 * 检验项目编号
	 */
	private String item_id;
	
	/**
	 * 检验项目名称
	 */
	private String  item_name;
	
	/**
	 * 项目代码
	 */
	private String item_code;

	public String getInspection_id() {
		return inspection_id;
	}

	public String getItem_id() {
		return item_id;
	}

	public String getItem_name() {
		return item_name;
	}

	public String getItem_code() {
		return item_code;
	}

	public void setInspection_id(String inspection_id) {
		this.inspection_id = inspection_id;
	}

	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public void setItem_code(String item_code) {
		this.item_code = item_code;
	}
	
	
}
