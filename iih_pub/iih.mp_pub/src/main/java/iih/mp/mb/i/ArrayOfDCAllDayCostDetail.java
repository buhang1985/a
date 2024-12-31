package iih.mp.mb.i;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @author huang_junhao 
 * version: 2018年4月1日下午4:08:46 
 * Description:
 */
public class ArrayOfDCAllDayCostDetail {

	@JsonProperty(value = "DCAllDayCostDetail")
	private DCAllDayCostDetail[] DCAllDayCostDetail;

	public void setDCAllDayCostDetail(DCAllDayCostDetail[] DCAllDayCostDetail) {
		this.DCAllDayCostDetail = DCAllDayCostDetail;
	}

	public DCAllDayCostDetail[] getDCAllDayCostDetail() {
		return this.DCAllDayCostDetail;
	}
}
