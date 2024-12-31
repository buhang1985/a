package iih.mp.nr.hcis.d;

import java.io.Serializable;

/**
 * @ClassName: QueryTestResultData 
* @Description: 查询化验结果数据
* @author zhy
* @date 2019年5月23日 下午4:47:27 
*
 */
public class QueryTestResultData implements Serializable{

	/** 
	* @Fields serialVersionUID : TODO
	*/
	private static final long serialVersionUID = 1L;
	
	/**
	 * 申请编号
	 */
	private String inspectionId;
	
	/**
	 * 检验项目编号
	 */
	private String itemId;

	public String getInspectionId() {
		return inspectionId;
	}

	public String getItemId() {
		return itemId;
	}

	public void setInspectionId(String inspectionId) {
		this.inspectionId = inspectionId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	
	
	

}
