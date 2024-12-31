package iih.pe.pis.dto.papt.d;

import xap.mw.sf.core.annotation.RPCField;
import xap.mw.sf.core.annotation.RPCStruct;
@RPCStruct
public class PePsnApptCatDTO {

	// 体检个人预约项目主键标识
	@RPCField(id = 1)
	private String id_pepsnapptcat;
	// 折扣
	@RPCField(id = 10)
	private double dis_cat;
	// 数量
	@RPCField(id = 11)
	private double qty_cat;
	// 金额
	@RPCField(id = 12)
	private double amt_cat;
	// 创建人
	@RPCField(id = 13)
	private String createdby;
	// 创建时间
	@RPCField(id = 14)
	private String createdtime;
	// 最后修改人
	@RPCField(id = 15)
	private String modifiedby;
	// 最后修改时间
	@RPCField(id = 16)
	private String modifiedtime;
	// 个人标识
	@RPCField(id = 17)
	private boolean fg_psn;
	// 收费标识
	@RPCField(id = 18)
	private boolean fg_paid;
	// 申请传输标识
	@RPCField(id = 19)
	private boolean fg_trans;
	// 体检预约单ID
	@RPCField(id = 2)
	private String id_pepsnappt;
	// 申请单号
	@RPCField(id = 20)
	private String no_apply;
	// 条码号打印标识
	@RPCField(id = 21)
	private boolean fg_barcode;
	// 条码号
	@RPCField(id = 22)
	private String no_barcode;
	// 医嘱单号
	@RPCField(id = 23)
	private String id_or;
	// 体检团体预约分组ID
	@RPCField(id = 3)
	private String id_pecorpapptgrp;
	// 所属科室
	@RPCField(id = 4)
	private String id_pedeptset;
	// 体检项目
	@RPCField(id = 5)
	private String id_pesrvcatlog;
	// 加项标识
	@RPCField(id = 6)
	private boolean fg_add;
	// 自付标识
	@RPCField(id = 7)
	private boolean fg_payself;
	// 基础价格
	@RPCField(id = 8)
	private double pri_base;
	// 实收价格
	@RPCField(id = 9)
	private double pri_cat;

	public String getId_pepsnapptcat() {
		return id_pepsnapptcat;
	}

	public void setId_pepsnapptcat(String id_pepsnapptcat) {
		this.id_pepsnapptcat = id_pepsnapptcat;
	}

	public double getDis_cat() {
		return dis_cat;
	}

	public void setDis_cat(double dis_cat) {
		this.dis_cat = dis_cat;
	}

	public double getQty_cat() {
		return qty_cat;
	}

	public void setQty_cat(double qty_cat) {
		this.qty_cat = qty_cat;
	}

	public double getAmt_cat() {
		return amt_cat;
	}

	public void setAmt_cat(double amt_cat) {
		this.amt_cat = amt_cat;
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

	public boolean getFg_psn() {
		return fg_psn;
	}

	public void setFg_psn(boolean fg_psn) {
		this.fg_psn = fg_psn;
	}

	public boolean getFg_paid() {
		return fg_paid;
	}

	public void setFg_paid(boolean fg_paid) {
		this.fg_paid = fg_paid;
	}

	public boolean getFg_trans() {
		return fg_trans;
	}

	public void setFg_trans(boolean fg_trans) {
		this.fg_trans = fg_trans;
	}

	public String getId_pepsnappt() {
		return id_pepsnappt;
	}

	public void setId_pepsnappt(String id_pepsnappt) {
		this.id_pepsnappt = id_pepsnappt;
	}

	public String getNo_apply() {
		return no_apply;
	}

	public void setNo_apply(String no_apply) {
		this.no_apply = no_apply;
	}

	public boolean getFg_barcode() {
		return fg_barcode;
	}

	public void setFg_barcode(boolean fg_barcode) {
		this.fg_barcode = fg_barcode;
	}

	public String getNo_barcode() {
		return no_barcode;
	}

	public void setNo_barcode(String no_barcode) {
		this.no_barcode = no_barcode;
	}

	public String getId_or() {
		return id_or;
	}

	public void setId_or(String id_or) {
		this.id_or = id_or;
	}

	public String getId_pecorpapptgrp() {
		return id_pecorpapptgrp;
	}

	public void setId_pecorpapptgrp(String id_pecorpapptgrp) {
		this.id_pecorpapptgrp = id_pecorpapptgrp;
	}

	public String getId_pedeptset() {
		return id_pedeptset;
	}

	public void setId_pedeptset(String id_pedeptset) {
		this.id_pedeptset = id_pedeptset;
	}

	public String getId_pesrvcatlog() {
		return id_pesrvcatlog;
	}

	public void setId_pesrvcatlog(String id_pesrvcatlog) {
		this.id_pesrvcatlog = id_pesrvcatlog;
	}

	public boolean getFg_add() {
		return fg_add;
	}

	public void setFg_add(boolean fg_add) {
		this.fg_add = fg_add;
	}

	public boolean getFg_payself() {
		return fg_payself;
	}

	public void setFg_payself(boolean fg_payself) {
		this.fg_payself = fg_payself;
	}

	public double getPri_base() {
		return pri_base;
	}

	public void setPri_base(double pri_base) {
		this.pri_base = pri_base;
	}

	public double getPri_cat() {
		return pri_cat;
	}

	public void setPri_cat(double pri_cat) {
		this.pri_cat = pri_cat;
	}

}
