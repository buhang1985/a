package iih.pe.pis.dto.pepsnreport.d;

import java.util.List;
import xap.mw.sf.core.annotation.RPCField;
import xap.mw.sf.core.annotation.RPCStruct;
@RPCStruct
public class PePsnRptPhyDTO {

	// 个人预约单ID
	@RPCField(id = 1)
	private String id_pepsnappt;
	// 检查时间
	@RPCField(id = 10)
	private String time_check;
	// 阳性标识
	@RPCField(id = 11)
	private String fg_posi;
	// 异常标识
	@RPCField(id = 12)
	private String fg_abn;
	// 结果ID
	@RPCField(id = 2)
	private String id_perst;
	// 体检项目ID
	@RPCField(id = 3)
	private String id_pesrvitem;
	// 结果
	@RPCField(id = 4)
	private String rst;
	// 小结
	@RPCField(id = 5)
	private String sumup;
	// 项目名称
	@RPCField(id = 6)
	private String name_itm;
	// 序号
	@RPCField(id = 7)
	private String sortno;
	// 科室名称
	@RPCField(id = 8)
	private String name_dep;
	// 检查医生
	@RPCField(id = 9)
	private String name_doc;

	public String getId_pepsnappt() {
		return id_pepsnappt;
	}

	public void setId_pepsnappt(String id_pepsnappt) {
		this.id_pepsnappt = id_pepsnappt;
	}

	public String getTime_check() {
		return time_check;
	}

	public void setTime_check(String time_check) {
		this.time_check = time_check;
	}

	public String getFg_posi() {
		return fg_posi;
	}

	public void setFg_posi(String fg_posi) {
		this.fg_posi = fg_posi;
	}

	public String getFg_abn() {
		return fg_abn;
	}

	public void setFg_abn(String fg_abn) {
		this.fg_abn = fg_abn;
	}

	public String getId_perst() {
		return id_perst;
	}

	public void setId_perst(String id_perst) {
		this.id_perst = id_perst;
	}

	public String getId_pesrvitem() {
		return id_pesrvitem;
	}

	public void setId_pesrvitem(String id_pesrvitem) {
		this.id_pesrvitem = id_pesrvitem;
	}

	public String getRst() {
		return rst;
	}

	public void setRst(String rst) {
		this.rst = rst;
	}

	public String getSumup() {
		return sumup;
	}

	public void setSumup(String sumup) {
		this.sumup = sumup;
	}

	public String getName_itm() {
		return name_itm;
	}

	public void setName_itm(String name_itm) {
		this.name_itm = name_itm;
	}

	public String getSortno() {
		return sortno;
	}

	public void setSortno(String sortno) {
		this.sortno = sortno;
	}

	public String getName_dep() {
		return name_dep;
	}

	public void setName_dep(String name_dep) {
		this.name_dep = name_dep;
	}

	public String getName_doc() {
		return name_doc;
	}

	public void setName_doc(String name_doc) {
		this.name_doc = name_doc;
	}

}
