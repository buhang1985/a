package iih.ei.std.cr_technology.v1.d;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * 药局(房)库存基本信息JavaBean
 * 
 * @author dj.zhang
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class PivasFindPharmStockDicResultBeanInfoDt implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlElement(name = "SPID")
	private String spid;
	@XmlElement(name = "CKID")
	private String ckid;
	@XmlElement(name = "SHENGCCJ")
	private String shengccj;
	@XmlElement(name = "IS_HEGE")
	private String is_hege;
	@XmlElement(name = "CKSHL")
	private String ckshl;
	@XmlElement(name = "KCSX")
	private String kcsx;
	@XmlElement(name = "KCXX")
	private String kcxx;
	@XmlElement(name = "SPBH")
	private String spbh;
	@XmlElement(name = "COSTS_DJ")
	private String costs_dj;
	@XmlElement(name = "JWH")
	private String jwh;
	@XmlElement(name = "SEQID")
	private String seqid;

	/**
	 * 商品ID
	 * 
	 * @return
	 */
	public String getSpid() {
		return spid;
	}

	/**
	 * 商品ID
	 * 
	 * @param spid
	 */
	public void setSpid(String spid) {
		this.spid = spid;
	}

	/**
	 * 药局ID
	 * 
	 * @return
	 */
	public String getCkid() {
		return ckid;
	}

	/**
	 * 药局ID
	 * 
	 * @param ckid
	 */
	public void setCkid(String ckid) {
		this.ckid = ckid;
	}

	/**
	 * 生产厂家
	 * 
	 * @return
	 */
	public String getShengccj() {
		return shengccj;
	}

	/**
	 * 生产厂家
	 * 
	 * @param shengccj
	 */
	public void setShengccj(String shengccj) {
		this.shengccj = shengccj;
	}

	/**
	 * 是否合格
	 * 
	 * @return
	 */
	public String getIs_hege() {
		return is_hege;
	}

	/**
	 * 是否合格
	 * 
	 * @param is_hege
	 */
	public void setIs_hege(String is_hege) {
		this.is_hege = is_hege;
	}

	/**
	 * 仓库数量（求和总数量）
	 * 
	 * @return
	 */
	public String getCkshl() {
		return ckshl;
	}

	/**
	 * 仓库数量（求和总数量）
	 * 
	 * @param ckshl
	 */
	public void setCkshl(String ckshl) {
		this.ckshl = ckshl;
	}

	/**
	 * 库存上限
	 * 
	 * @return
	 */
	public String getKcsx() {
		return kcsx;
	}

	/**
	 * 库存上限
	 * 
	 * @param kcsx
	 */
	public void setKcsx(String kcsx) {
		this.kcsx = kcsx;
	}

	/**
	 * 库存下限
	 * 
	 * @return
	 */
	public String getKcxx() {
		return kcxx;
	}

	/**
	 * 库存下限
	 * 
	 * @param kcxx
	 */
	public void setKcxx(String kcxx) {
		this.kcxx = kcxx;
	}

	/**
	 * 商品编号
	 * 
	 * @return
	 */
	public String getSpbh() {
		return spbh;
	}

	/**
	 * 商品编号
	 * 
	 * @param spbh
	 */
	public void setSpbh(String spbh) {
		this.spbh = spbh;
	}

	/**
	 * 单价
	 * 
	 * @return
	 */
	public String getCosts_dj() {
		return costs_dj;
	}

	/**
	 * 单价
	 * 
	 * @param costs_dj
	 */
	public void setCosts_dj(String costs_dj) {
		this.costs_dj = costs_dj;
	}

	/**
	 * HIS架位号
	 * 
	 * @return
	 */
	public String getJwh() {
		return jwh;
	}

	/**
	 * HIS架位号
	 * 
	 * @param jwh
	 */
	public void setJwh(String jwh) {
		this.jwh = jwh;
	}

	/**
	 * 客户端序列号
	 * 
	 * @return
	 */
	public String getSeqid() {
		return seqid;
	}

	/**
	 * 客户端序列号
	 * 
	 * @param seqid
	 */
	public void setSeqid(String seqid) {
		this.seqid = seqid;
	}
}
