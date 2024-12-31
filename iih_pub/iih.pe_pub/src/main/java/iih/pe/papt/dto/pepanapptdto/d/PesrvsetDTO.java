package iih.pe.papt.dto.pepanapptdto.d;

import java.util.List;
import xap.mw.sf.core.annotation.RPCField;
import xap.mw.sf.core.annotation.RPCStruct;
@RPCStruct
public class PesrvsetDTO {

	// 套餐编码
	@RPCField(id = 1)
	private String code;
	// 套餐名称
	@RPCField(id = 2)
	private String name;
	// 性别限制
	@RPCField(id = 3)
	private String sexlimit;
	// 原始价格
	@RPCField(id = 4)
	private double pri_original;
	// 体检套餐主键标识
	@RPCField(id = 5)
	private String id_pesrvset;
	// 基础价格
	@RPCField(id = 6)
	private double pri_srvset;
	// 会员标识
	@RPCField(id = 7)
	private boolean fg_vip;
	// 体检套餐介绍
	@RPCField(id = 8)
	private String introduction;

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

	public String getSexlimit() {
		return sexlimit;
	}

	public void setSexlimit(String sexlimit) {
		this.sexlimit = sexlimit;
	}

	public double getPri_original() {
		return pri_original;
	}

	public void setPri_original(double pri_original) {
		this.pri_original = pri_original;
	}

	public String getId_pesrvset() {
		return id_pesrvset;
	}

	public void setId_pesrvset(String id_pesrvset) {
		this.id_pesrvset = id_pesrvset;
	}

	public double getPri_srvset() {
		return pri_srvset;
	}

	public void setPri_srvset(double pri_srvset) {
		this.pri_srvset = pri_srvset;
	}

	public boolean getFg_vip() {
		return fg_vip;
	}

	public void setFg_vip(boolean fg_vip) {
		this.fg_vip = fg_vip;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

}
