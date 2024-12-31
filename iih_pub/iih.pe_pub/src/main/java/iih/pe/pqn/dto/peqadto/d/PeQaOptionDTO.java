package iih.pe.pqn.dto.peqadto.d;

import java.util.List;
import xap.mw.sf.core.annotation.RPCField;
import xap.mw.sf.core.annotation.RPCStruct;
@RPCStruct
public class PeQaOptionDTO {

	// 体检问卷选项主键标识
	@RPCField(id = 1)
	private String id_peqakeydef;
	// 输入类型
	@RPCField(id = 10)
	private Integer inputtp;
	// 答案
	@RPCField(id = 11)
	private String answer;
	// 体检问卷问题库ID
	@RPCField(id = 12)
	private String id_peqacontentdef;
	// 选中标识
	@RPCField(id = 13)
	private Boolean fg_select;
	// 编码
	@RPCField(id = 14)
	private String code;
	// 名称
	@RPCField(id = 2)
	private String name;
	// 英文名称
	@RPCField(id = 3)
	private String ename;
	// 分值
	@RPCField(id = 4)
	private Double score;
	// 阳性标识
	@RPCField(id = 5)
	private Boolean fg_posi;
	// 创建时间
	@RPCField(id = 6)
	private String createdtime;
	// 最后修改时间
	@RPCField(id = 7)
	private String modifiedtime;
	// 排序
	@RPCField(id = 8)
	private Integer sortno;
	// 性别限制
	@RPCField(id = 9)
	private Integer sexlimit;

	public String getId_peqakeydef() {
		return id_peqakeydef;
	}

	public void setId_peqakeydef(String id_peqakeydef) {
		this.id_peqakeydef = id_peqakeydef;
	}

	public Integer getInputtp() {
		return inputtp;
	}

	public void setInputtp(Integer inputtp) {
		this.inputtp = inputtp;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getId_peqacontentdef() {
		return id_peqacontentdef;
	}

	public void setId_peqacontentdef(String id_peqacontentdef) {
		this.id_peqacontentdef = id_peqacontentdef;
	}

	public Boolean getFg_select() {
		return fg_select;
	}

	public void setFg_select(Boolean fg_select) {
		this.fg_select = fg_select;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public Boolean getFg_posi() {
		return fg_posi;
	}

	public void setFg_posi(Boolean fg_posi) {
		this.fg_posi = fg_posi;
	}

	public String getCreatedtime() {
		return createdtime;
	}

	public void setCreatedtime(String createdtime) {
		this.createdtime = createdtime;
	}

	public String getModifiedtime() {
		return modifiedtime;
	}

	public void setModifiedtime(String modifiedtime) {
		this.modifiedtime = modifiedtime;
	}

	public Integer getSortno() {
		return sortno;
	}

	public void setSortno(Integer sortno) {
		this.sortno = sortno;
	}

	public Integer getSexlimit() {
		return sexlimit;
	}

	public void setSexlimit(Integer sexlimit) {
		this.sexlimit = sexlimit;
	}

}
