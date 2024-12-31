package iih.mbh.mp.medlabor.d;

import java.util.List;
import xap.mw.sf.core.annotation.RPCField;
import xap.mw.sf.core.annotation.RPCStruct;
@RPCStruct
public class MedLaborDTO {

	// 检验采集id
	@RPCField(id = 1)
	private String id_medlabor;
	// 检验状态
	@RPCField(id = 10)
	private int labsta;
	// 床号
	@RPCField(id = 11)
	private String name_bed;
	// 姓名
	@RPCField(id = 12)
	private String name_pat;
	// 性别
	@RPCField(id = 13)
	private String sex;
	// 年龄
	@RPCField(id = 14)
	private String age;
	// 就诊科室
	@RPCField(id = 15)
	private String name_dept;
	// 功能编码
	@RPCField(id = 16)
	private String funcode;
	// 项目名称
	@RPCField(id = 2)
	private String name_lab;
	// 标本类型
	@RPCField(id = 3)
	private String name_labsamptp;
	// 标本条码
	@RPCField(id = 4)
	private String no_bar;
	// 医嘱闭环状态
	@RPCField(id = 5)
	private String id_labsta;
	// 管头颜色
	@RPCField(id = 6)
	private String color;
	// 管头色值
	@RPCField(id = 7)
	private String color_value;
	// 就诊id
	@RPCField(id = 8)
	private String id_ent;
	// 患者id
	@RPCField(id = 9)
	private String id_pat;

	public String getId_medlabor() {
		return id_medlabor;
	}

	public void setId_medlabor(String id_medlabor) {
		this.id_medlabor = id_medlabor;
	}

	public int getLabsta() {
		return labsta;
	}

	public void setLabsta(int labsta) {
		this.labsta = labsta;
	}

	public String getName_bed() {
		return name_bed;
	}

	public void setName_bed(String name_bed) {
		this.name_bed = name_bed;
	}

	public String getName_pat() {
		return name_pat;
	}

	public void setName_pat(String name_pat) {
		this.name_pat = name_pat;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getName_dept() {
		return name_dept;
	}

	public void setName_dept(String name_dept) {
		this.name_dept = name_dept;
	}

	public String getFuncode() {
		return funcode;
	}

	public void setFuncode(String funcode) {
		this.funcode = funcode;
	}

	public String getName_lab() {
		return name_lab;
	}

	public void setName_lab(String name_lab) {
		this.name_lab = name_lab;
	}

	public String getName_labsamptp() {
		return name_labsamptp;
	}

	public void setName_labsamptp(String name_labsamptp) {
		this.name_labsamptp = name_labsamptp;
	}

	public String getNo_bar() {
		return no_bar;
	}

	public void setNo_bar(String no_bar) {
		this.no_bar = no_bar;
	}

	public String getId_labsta() {
		return id_labsta;
	}

	public void setId_labsta(String id_labsta) {
		this.id_labsta = id_labsta;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getColor_value() {
		return color_value;
	}

	public void setColor_value(String color_value) {
		this.color_value = color_value;
	}

	public String getId_ent() {
		return id_ent;
	}

	public void setId_ent(String id_ent) {
		this.id_ent = id_ent;
	}

	public String getId_pat() {
		return id_pat;
	}

	public void setId_pat(String id_pat) {
		this.id_pat = id_pat;
	}

}
