package iih.en.pv.appoint.result;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import iih.bd.webservice.BaseWsParam;

/***
 * 预约渠道统计信息-出参解析
 * @author zhangpp
 *
 */
@XmlRootElement(name = "data")
@XmlAccessorType(XmlAccessType.FIELD)
public class ChlSchStatsResult extends BaseWsParam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 总号源数
	 */
	private Integer total;
	/**
	 * 已使用数
	 */
	private Integer used;
	/**
	 * 可用号源数
	 */
	private Integer available;
	/**
	 * 取消预约数量
	 */
	private Integer cancNum;
	/**
	 * 渠道类型
	 */
	private String chlType;
	/**
	 * 预约未付费数量
	 */
	private Integer num_aptNoFe;
	/**
	 * 预约且支付数量
	 */
	private Integer num_aptWithFee;
	/**
	 * 预约取号数量
	 */
	private Integer num_aptCfm;
	/**
	 * 取消预约
	 */
	private Integer num_aptCanc;
	/**
	 * 退号数量
	 */
	private Integer num_aptCfmCanc;
	/**
	 * 取号后未到诊数量
	 */
	private Integer num_aptCfmAbsent;
	
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getUsed() {
		return used;
	}
	public void setUsed(Integer used) {
		this.used = used;
	}
	public Integer getAvailable() {
		return available;
	}
	public void setAvailable(Integer available) {
		this.available = available;
	}
	public Integer getCancNum() {
		return cancNum;
	}
	public void setCancNum(Integer cancNum) {
		this.cancNum = cancNum;
	}
	public String getChlType() {
		return chlType;
	}
	public void setChlType(String chlType) {
		this.chlType = chlType;
	}
	public Integer getNum_aptNoFe() {
		return num_aptNoFe;
	}
	public void setNum_aptNoFe(Integer num_aptNoFe) {
		this.num_aptNoFe = num_aptNoFe;
	}
	public Integer getNum_aptWithFee() {
		return num_aptWithFee;
	}
	public void setNum_aptWithFee(Integer num_aptWithFee) {
		this.num_aptWithFee = num_aptWithFee;
	}
	public Integer getNum_aptCfm() {
		return num_aptCfm;
	}
	public void setNum_aptCfm(Integer num_aptCfm) {
		this.num_aptCfm = num_aptCfm;
	}
	public Integer getNum_aptCanc() {
		return num_aptCanc;
	}
	public void setNum_aptCanc(Integer num_aptCanc) {
		this.num_aptCanc = num_aptCanc;
	}
	public Integer getNum_aptCfmCanc() {
		return num_aptCfmCanc;
	}
	public void setNum_aptCfmCanc(Integer num_aptCfmCanc) {
		this.num_aptCfmCanc = num_aptCfmCanc;
	}
	public Integer getNum_aptCfmAbsent() {
		return num_aptCfmAbsent;
	}
	public void setNum_aptCfmAbsent(Integer num_aptCfmAbsent) {
		this.num_aptCfmAbsent = num_aptCfmAbsent;
	}
	
}
