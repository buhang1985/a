package iih.ci.mr.cimrknowledgedto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 病历内容保存知识库DTO DTO数据 
 * 
 */
public class CiMrKnowledgeDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 知识库主键
	 * @return String
	 */
	public String getId_knowledge() {
		return ((String) getAttrVal("Id_knowledge"));
	}
	/**
	 * 知识库主键
	 * @param Id_knowledge
	 */
	public void setId_knowledge(String Id_knowledge) {
		setAttrVal("Id_knowledge", Id_knowledge);
	}
	/**
	 * 所属集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}
	/**
	 * 所属集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 所属组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}
	/**
	 * 所属组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 模板序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}
	/**
	 * 模板序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 模板编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 模板编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 模板名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 模板名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 拼音码
	 * @return String
	 */
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}
	/**
	 * 拼音码
	 * @param Pycode
	 */
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	/**
	 * 五笔码
	 * @return String
	 */
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}
	/**
	 * 五笔码
	 * @param Wbcode
	 */
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
	}
	/**
	 * 助记码
	 * @return String
	 */
	public String getMnecode() {
		return ((String) getAttrVal("Mnecode"));
	}
	/**
	 * 助记码
	 * @param Mnecode
	 */
	public void setMnecode(String Mnecode) {
		setAttrVal("Mnecode", Mnecode);
	}
	/**
	 * 知识内容
	 * @return String
	 */
	public String getKnowledge_content() {
		return ((String) getAttrVal("Knowledge_content"));
	}
	/**
	 * 知识内容
	 * @param Knowledge_content
	 */
	public void setKnowledge_content(String Knowledge_content) {
		setAttrVal("Knowledge_content", Knowledge_content);
	}
	/**
	 * 知识库类型id
	 * @return String
	 */
	public String getId_knowledge_type() {
		return ((String) getAttrVal("Id_knowledge_type"));
	}
	/**
	 * 知识库类型id
	 * @param Id_knowledge_type
	 */
	public void setId_knowledge_type(String Id_knowledge_type) {
		setAttrVal("Id_knowledge_type", Id_knowledge_type);
	}
	/**
	 * 知识库类型code
	 * @return String
	 */
	public String getSd_knowledge_type() {
		return ((String) getAttrVal("Sd_knowledge_type"));
	}
	/**
	 * 知识库类型code
	 * @param Sd_knowledge_type
	 */
	public void setSd_knowledge_type(String Sd_knowledge_type) {
		setAttrVal("Sd_knowledge_type", Sd_knowledge_type);
	}
	/**
	 * 知识库类型name
	 * @return String
	 */
	public String getName_knowledge_type() {
		return ((String) getAttrVal("Name_knowledge_type"));
	}
	/**
	 * 知识库类型name
	 * @param Name_knowledge_type
	 */
	public void setName_knowledge_type(String Name_knowledge_type) {
		setAttrVal("Name_knowledge_type", Name_knowledge_type);
	}
	/**
	 * 所属科室id
	 * @return String
	 */
	public String getId_dept() {
		return ((String) getAttrVal("Id_dept"));
	}
	/**
	 * 所属科室id
	 * @param Id_dept
	 */
	public void setId_dept(String Id_dept) {
		setAttrVal("Id_dept", Id_dept);
	}
	/**
	 * 所属科室code
	 * @return String
	 */
	public String getSd_dept() {
		return ((String) getAttrVal("Sd_dept"));
	}
	/**
	 * 所属科室code
	 * @param Sd_dept
	 */
	public void setSd_dept(String Sd_dept) {
		setAttrVal("Sd_dept", Sd_dept);
	}
	/**
	 * 所属科室name
	 * @return String
	 */
	public String getName_dept() {
		return ((String) getAttrVal("Name_dept"));
	}
	/**
	 * 所属科室name
	 * @param Name_dept
	 */
	public void setName_dept(String Name_dept) {
		setAttrVal("Name_dept", Name_dept);
	}
	/**
	 * 所属用户id
	 * @return String
	 */
	public String getId_user() {
		return ((String) getAttrVal("Id_user"));
	}
	/**
	 * 所属用户id
	 * @param Id_user
	 */
	public void setId_user(String Id_user) {
		setAttrVal("Id_user", Id_user);
	}
	/**
	 * 所属用户code
	 * @return String
	 */
	public String getSd_user() {
		return ((String) getAttrVal("Sd_user"));
	}
	/**
	 * 所属用户code
	 * @param Sd_user
	 */
	public void setSd_user(String Sd_user) {
		setAttrVal("Sd_user", Sd_user);
	}
	/**
	 * 所属用户name
	 * @return String
	 */
	public String getName_user() {
		return ((String) getAttrVal("Name_user"));
	}
	/**
	 * 所属用户name
	 * @param Name_user
	 */
	public void setName_user(String Name_user) {
		setAttrVal("Name_user", Name_user);
	}
	/**
	 * 启用标识
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}
	/**
	 * 启用标识
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
}