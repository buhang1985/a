package iih.pis.ivx.dto.peappttimes.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 体检预约时间段 DTO数据 
 * 
 */
public class PeApptTimesDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 预约时间段主键标识
	 * @return String
	 */
	public String getId_peappttimes() {
		return ((String) getAttrVal("Id_peappttimes"));
	}
	/**
	 * 预约时间段主键标识
	 * @param Id_peappttimes
	 */
	public void setId_peappttimes(String Id_peappttimes) {
		setAttrVal("Id_peappttimes", Id_peappttimes);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 开始时间
	 * @return FTime
	 */
	public FTime getTime_begin() {
		return ((FTime) getAttrVal("Time_begin"));
	}
	/**
	 * 开始时间
	 * @param Time_begin
	 */
	public void setTime_begin(FTime Time_begin) {
		setAttrVal("Time_begin", Time_begin);
	}
	/**
	 * 结束时间
	 * @return FTime
	 */
	public FTime getTime_end() {
		return ((FTime) getAttrVal("Time_end"));
	}
	/**
	 * 结束时间
	 * @param Time_end
	 */
	public void setTime_end(FTime Time_end) {
		setAttrVal("Time_end", Time_end);
	}
	/**
	 * 次序
	 * @return String
	 */
	public String getSortno() {
		return ((String) getAttrVal("Sortno"));
	}
	/**
	 * 次序
	 * @param Sortno
	 */
	public void setSortno(String Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 说明
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}
	/**
	 * 说明
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 开放人数
	 * @return Integer
	 */
	public Integer getPsnlimit() {
		return ((Integer) getAttrVal("Psnlimit"));
	}
	/**
	 * 开放人数
	 * @param Psnlimit
	 */
	public void setPsnlimit(Integer Psnlimit) {
		setAttrVal("Psnlimit", Psnlimit);
	}
}