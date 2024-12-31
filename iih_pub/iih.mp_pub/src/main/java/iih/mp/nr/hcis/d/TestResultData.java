package iih.mp.nr.hcis.d;

import java.io.Serializable;
/**
 * 
* @ClassName: TestResultData 
* @Description: 化验结果数据
* @author zhy
* @date 2019年5月23日 下午5:08:03 
*
 */
public class TestResultData implements Serializable{

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
	 * 检验结果排序号(打印序号)
	 */
	private String print_order;
	
	/**
	 * 检验结果中文名称
	 */
	private String item_name_zh;
	
	/**
	 * 检验结果英文名称(或缩写)，如果没有可留空
	 */
	private String item_name_en;
	
	/**
	 * 检验结果值
	 */
	private String item_result_value;
	
	/**
	 * 检验结果标识(偏高，偏低等)
	 */
	private String item_result_indicator;
	
	/**
	 * 参考范围
	 */
	private String item_reference;
	
	/**
	 * 单位
	 */
	private String item_unit;
	
	/**
	 * 检验项代码(必须包含项)
	 */
	private String  item_code;

	public String getInspection_id() {
		return inspection_id;
	}

	public String getItem_id() {
		return item_id;
	}

	public String getPrint_order() {
		return print_order;
	}

	public String getItem_name_zh() {
		return item_name_zh;
	}

	public String getItem_name_en() {
		return item_name_en;
	}

	public String getItem_result_value() {
		return item_result_value;
	}

	public String getItem_result_indicator() {
		return item_result_indicator;
	}

	public String getItem_reference() {
		return item_reference;
	}

	public String getItem_unit() {
		return item_unit;
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

	public void setPrint_order(String print_order) {
		this.print_order = print_order;
	}

	public void setItem_name_zh(String item_name_zh) {
		this.item_name_zh = item_name_zh;
	}

	public void setItem_name_en(String item_name_en) {
		this.item_name_en = item_name_en;
	}

	public void setItem_result_value(String item_result_value) {
		this.item_result_value = item_result_value;
	}

	public void setItem_result_indicator(String item_result_indicator) {
		this.item_result_indicator = item_result_indicator;
	}

	public void setItem_reference(String item_reference) {
		this.item_reference = item_reference;
	}

	public void setItem_unit(String item_unit) {
		this.item_unit = item_unit;
	}

	public void setItem_code(String item_code) {
		this.item_code = item_code;
	}
	
	

}
