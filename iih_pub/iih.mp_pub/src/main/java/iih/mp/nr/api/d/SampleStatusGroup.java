package iih.mp.nr.api.d;

import iih.mp.nr.dto.internal.d.OrPlanDTO;

import java.util.List;

/**
 * 标签参数与状态对照赋值类
 * 
 * @author xuxing_2017年5月16日11:05:20
 *
 */
public class SampleStatusGroup {

	private String Sd_status;
	private List<PlanParamDTO> ListParams;
	private StatusContrastDTO StatusDTO;
	private List<String> ListBars;

	/**
	 * 执行状态
	 * 
	 * @return
	 */
	public String getSd_status() {
		return Sd_status;
	}

	public void setSd_status(String sd_status) {
		Sd_status = sd_status;
	}

	/**
	 * 参数集合
	 * 
	 * @return
	 */
	public List<PlanParamDTO> getListParams() {
		return ListParams;
	}

	public void setListParams(List<PlanParamDTO> listParams) {
		ListParams = listParams;
	}

	/**
	 * 状态对照
	 * 
	 * @return
	 */
	public StatusContrastDTO getStatusDTO() {
		return StatusDTO;
	}

	public void setStatusDTO(StatusContrastDTO statusDTO) {
		StatusDTO = statusDTO;
	}

	/**
	 * 标签号
	 * 
	 * @return
	 */
	public List<String> getListBars() {
		return ListBars;
	}

	public void setListBars(List<String> listBars) {
		ListBars = listBars;
	}
}
