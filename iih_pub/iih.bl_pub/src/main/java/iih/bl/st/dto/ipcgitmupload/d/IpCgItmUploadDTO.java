package iih.bl.st.dto.ipcgitmupload.d;

import xap.mw.core.data.BaseDTO;

/**
 * 住院明细定时上传Dto DTO数据 
 * 
 */
public class IpCgItmUploadDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 每页显示条数
	 * @return Integer
	 */
	public Integer getRownum() {
		return ((Integer) getAttrVal("Rownum"));
	}
	/**
	 * 每页显示条数
	 * @param Rownum
	 */
	public void setRownum(Integer Rownum) {
		setAttrVal("Rownum", Rownum);
	}
	/**
	 * 定时任务间隔秒数
	 * @return Integer
	 */
	public Integer getInterval() {
		return ((Integer) getAttrVal("Interval"));
	}
	/**
	 * 定时任务间隔秒数
	 * @param Interval
	 */
	public void setInterval(Integer Interval) {
		setAttrVal("Interval", Interval);
	}
	/**
	 * 上传总次数
	 * @return Integer
	 */
	public Integer getTotaltimes() {
		return ((Integer) getAttrVal("Totaltimes"));
	}
	/**
	 * 上传总次数
	 * @param Totaltimes
	 */
	public void setTotaltimes(Integer Totaltimes) {
		setAttrVal("Totaltimes", Totaltimes);
	}
	/**
	 * 上传成功次数
	 * @return Integer
	 */
	public Integer getSuctimes() {
		return ((Integer) getAttrVal("Suctimes"));
	}
	/**
	 * 上传成功次数
	 * @param Suctimes
	 */
	public void setSuctimes(Integer Suctimes) {
		setAttrVal("Suctimes", Suctimes);
	}
	/**
	 * 上传失败次数
	 * @return Integer
	 */
	public Integer getFailtimes() {
		return ((Integer) getAttrVal("Failtimes"));
	}
	/**
	 * 上传失败次数
	 * @param Failtimes
	 */
	public void setFailtimes(Integer Failtimes) {
		setAttrVal("Failtimes", Failtimes);
	}
	/**
	 * 无上传数据时的定时间隔秒数
	 * @return Integer
	 */
	public Integer getNotaskinterval() {
		return ((Integer) getAttrVal("Notaskinterval"));
	}
	/**
	 * 无上传数据时的定时间隔秒数
	 * @param Notaskinterval
	 */
	public void setNotaskinterval(Integer Notaskinterval) {
		setAttrVal("Notaskinterval", Notaskinterval);
	}
}