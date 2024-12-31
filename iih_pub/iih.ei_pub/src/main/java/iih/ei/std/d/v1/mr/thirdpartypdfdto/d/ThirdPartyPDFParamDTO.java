package iih.ei.std.d.v1.mr.thirdpartypdfdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;

/**
 * 接收第三方pdf入参 DTO数据 
 * 
 */
public class ThirdPartyPDFParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者编码
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}	
	/**
	 * 患者编码
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	/**
	 * 住院次数
	 * @return String
	 */
	public String getTimes_inhos() {
		return ((String) getAttrVal("Times_inhos"));
	}	
	/**
	 * 住院次数
	 * @param Times_inhos
	 */
	public void setTimes_inhos(String Times_inhos) {
		setAttrVal("Times_inhos", Times_inhos);
	}
	/**
	 * 就诊唯一编码
	 * @return String
	 */
	public String getCode_ent() {
		return ((String) getAttrVal("Code_ent"));
	}	
	/**
	 * 就诊唯一编码
	 * @param Code_ent
	 */
	public void setCode_ent(String Code_ent) {
		setAttrVal("Code_ent", Code_ent);
	}
	/**
	 * 业务主键id
	 * @return String
	 */
	public String getId_busy() {
		return ((String) getAttrVal("Id_busy"));
	}	
	/**
	 * 业务主键id
	 * @param Id_busy
	 */
	public void setId_busy(String Id_busy) {
		setAttrVal("Id_busy", Id_busy);
	}
	/**
	 * 数据集编码
	 * @return String
	 */
	public String getId_set() {
		return ((String) getAttrVal("Id_set"));
	}	
	/**
	 * 数据集编码
	 * @param Id_set
	 */
	public void setId_set(String Id_set) {
		setAttrVal("Id_set", Id_set);
	}
	/**
	 * 记录名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 记录名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 文件内容
	 * @return String
	 */
	public String getFile() {
		return ((String) getAttrVal("File"));
	}	
	/**
	 * 文件内容
	 * @param File
	 */
	public void setFile(String File) {
		setAttrVal("File", File);
	}
	/**
	 * 是否覆盖相同数据
	 * @return FBoolean
	 */
	public FBoolean getIsclear() {
		return ((FBoolean) getAttrVal("Isclear"));
	}	
	/**
	 * 是否覆盖相同数据
	 * @param Isclear
	 */
	public void setIsclear(FBoolean Isclear) {
		setAttrVal("Isclear", Isclear);
	}
	/**
	 * 序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 数据集中应该包含文件的总数量
	 * @return Integer
	 */
	public Integer getTcount() {
		return ((Integer) getAttrVal("Tcount"));
	}	
	/**
	 * 数据集中应该包含文件的总数量
	 * @param Tcount
	 */
	public void setTcount(Integer Tcount) {
		setAttrVal("Tcount", Tcount);
	}
}