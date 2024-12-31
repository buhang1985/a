package iih.pe.phm.dto.petcmevaldto.d;

import java.util.List;
import xap.mw.sf.core.annotation.RPCField;
import xap.mw.sf.core.annotation.RPCStruct;
@RPCStruct
public class PeTCMConDTO {

	// 体检中医评估得分主键标识
	@RPCField(id = 1)
	private String id_petcmcon;
	// 心理特征
	@RPCField(id = 10)
	private String psychology;
	// 发病倾向
	@RPCField(id = 11)
	private String morbidity;
	// 适应能力
	@RPCField(id = 12)
	private String adaptability;
	// 辨识方法
	@RPCField(id = 13)
	private String identification;
	// 调节方法
	@RPCField(id = 14)
	private String adjust;
	// 主体质标识
	@RPCField(id = 15)
	private boolean primary_flag;
	// 序号
	@RPCField(id = 16)
	private int sortno;
	// 健康预约单ID
	@RPCField(id = 2)
	private String id_pehmappt;
	// 体检中医体质分型定义主键
	@RPCField(id = 3)
	private String id_petcmconstcadef;
	// 评估结果
	@RPCField(id = 4)
	private int rst;
	// 评估分值
	@RPCField(id = 5)
	private double rst_score;
	// 名称
	@RPCField(id = 6)
	private String name;
	// 总体特征
	@RPCField(id = 7)
	private String general;
	// 形体特征
	@RPCField(id = 8)
	private String shape;
	// 常见表现
	@RPCField(id = 9)
	private String present;

	public String getId_petcmcon() {
		return id_petcmcon;
	}

	public void setId_petcmcon(String id_petcmcon) {
		this.id_petcmcon = id_petcmcon;
	}

	public String getPsychology() {
		return psychology;
	}

	public void setPsychology(String psychology) {
		this.psychology = psychology;
	}

	public String getMorbidity() {
		return morbidity;
	}

	public void setMorbidity(String morbidity) {
		this.morbidity = morbidity;
	}

	public String getAdaptability() {
		return adaptability;
	}

	public void setAdaptability(String adaptability) {
		this.adaptability = adaptability;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public String getAdjust() {
		return adjust;
	}

	public void setAdjust(String adjust) {
		this.adjust = adjust;
	}

	public boolean getPrimary_flag() {
		return primary_flag;
	}

	public void setPrimary_flag(boolean primary_flag) {
		this.primary_flag = primary_flag;
	}

	public int getSortno() {
		return sortno;
	}

	public void setSortno(int sortno) {
		this.sortno = sortno;
	}

	public String getId_pehmappt() {
		return id_pehmappt;
	}

	public void setId_pehmappt(String id_pehmappt) {
		this.id_pehmappt = id_pehmappt;
	}

	public String getId_petcmconstcadef() {
		return id_petcmconstcadef;
	}

	public void setId_petcmconstcadef(String id_petcmconstcadef) {
		this.id_petcmconstcadef = id_petcmconstcadef;
	}

	public int getRst() {
		return rst;
	}

	public void setRst(int rst) {
		this.rst = rst;
	}

	public double getRst_score() {
		return rst_score;
	}

	public void setRst_score(double rst_score) {
		this.rst_score = rst_score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGeneral() {
		return general;
	}

	public void setGeneral(String general) {
		this.general = general;
	}

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	public String getPresent() {
		return present;
	}

	public void setPresent(String present) {
		this.present = present;
	}

}
