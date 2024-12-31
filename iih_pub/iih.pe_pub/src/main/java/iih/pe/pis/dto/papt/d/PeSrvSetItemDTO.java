package iih.pe.pis.dto.papt.d;

import xap.mw.sf.core.annotation.RPCField;
import xap.mw.sf.core.annotation.RPCStruct;
@RPCStruct
public class PeSrvSetItemDTO {

	// 体检套餐项目主键标识
	@RPCField(id = 1)
	private String id_pesrvsetitmdef;
	// 体检套餐编码
	@RPCField(id = 10)
	private String sd_set;
	// 体检项目编码
	@RPCField(id = 11)
	private String sd_catlog;
	// 体检项目套餐内价格
	@RPCField(id = 12)
	private double pri_iteminset;
	// 必选标识
	@RPCField(id = 13)
	private boolean fg_required;
	// 体检套餐主键标识
	@RPCField(id = 2)
	private String id_pesrvsetdef;
	// 体检项目主键标识
	@RPCField(id = 3)
	private String id_pesrvbcatlog;
	// 数量
	@RPCField(id = 4)
	private int qty;
	// 显示序号
	@RPCField(id = 5)
	private String sortno;
	// 创建人
	@RPCField(id = 6)
	private String createdby;
	// 创建时间
	@RPCField(id = 7)
	private String createdtime;
	// 最后修改人
	@RPCField(id = 8)
	private String modifiedby;
	// 最后修改时间
	@RPCField(id = 9)
	private String modifiedtime;

	public String getId_pesrvsetitmdef() {
		return id_pesrvsetitmdef;
	}

	public void setId_pesrvsetitmdef(String id_pesrvsetitmdef) {
		this.id_pesrvsetitmdef = id_pesrvsetitmdef;
	}

	public String getSd_set() {
		return sd_set;
	}

	public void setSd_set(String sd_set) {
		this.sd_set = sd_set;
	}

	public String getSd_catlog() {
		return sd_catlog;
	}

	public void setSd_catlog(String sd_catlog) {
		this.sd_catlog = sd_catlog;
	}

	public double getPri_iteminset() {
		return pri_iteminset;
	}

	public void setPri_iteminset(double pri_iteminset) {
		this.pri_iteminset = pri_iteminset;
	}

	public boolean getFg_required() {
		return fg_required;
	}

	public void setFg_required(boolean fg_required) {
		this.fg_required = fg_required;
	}

	public String getId_pesrvsetdef() {
		return id_pesrvsetdef;
	}

	public void setId_pesrvsetdef(String id_pesrvsetdef) {
		this.id_pesrvsetdef = id_pesrvsetdef;
	}

	public String getId_pesrvbcatlog() {
		return id_pesrvbcatlog;
	}

	public void setId_pesrvbcatlog(String id_pesrvbcatlog) {
		this.id_pesrvbcatlog = id_pesrvbcatlog;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getSortno() {
		return sortno;
	}

	public void setSortno(String sortno) {
		this.sortno = sortno;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public String getCreatedtime() {
		return createdtime;
	}

	public void setCreatedtime(String createdtime) {
		this.createdtime = createdtime;
	}

	public String getModifiedby() {
		return modifiedby;
	}

	public void setModifiedby(String modifiedby) {
		this.modifiedby = modifiedby;
	}

	public String getModifiedtime() {
		return modifiedtime;
	}

	public void setModifiedtime(String modifiedtime) {
		this.modifiedtime = modifiedtime;
	}

}
