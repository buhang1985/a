package iih.sc.scbd.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 排班计划医疗项目DTO DTO数据 
 * 
 */
public class ScBdSrvDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 排班类型sd
	 * @return String
	 */
	public String getSd_sctp() {
		return ((String) getAttrVal("Sd_sctp"));
	}
	/**
	 * 排班类型sd
	 * @param Sd_sctp
	 */
	public void setSd_sctp(String Sd_sctp) {
		setAttrVal("Sd_sctp", Sd_sctp);
	}
	/**
	 * sc医疗服务id
	 * @return String
	 */
	public String getId_scbdsrv() {
		return ((String) getAttrVal("Id_scbdsrv"));
	}
	/**
	 * sc医疗服务id
	 * @param Id_scbdsrv
	 */
	public void setId_scbdsrv(String Id_scbdsrv) {
		setAttrVal("Id_scbdsrv", Id_scbdsrv);
	}
	/**
	 * 医疗服务主键标识
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 医疗服务主键标识
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 项目类别细目id
	 * @return String
	 */
	public String getId_scsrvkinditem() {
		return ((String) getAttrVal("Id_scsrvkinditem"));
	}
	/**
	 * 项目类别细目id
	 * @param Id_scsrvkinditem
	 */
	public void setId_scsrvkinditem(String Id_scsrvkinditem) {
		setAttrVal("Id_scsrvkinditem", Id_scsrvkinditem);
	}
	/**
	 * 排班分类名称
	 * @return String
	 */
	public String getName_scca() {
		return ((String) getAttrVal("Name_scca"));
	}
	/**
	 * 排班分类名称
	 * @param Name_scca
	 */
	public void setName_scca(String Name_scca) {
		setAttrVal("Name_scca", Name_scca);
	}
	/**
	 * 时长
	 * @return Integer
	 */
	public Integer getSrvslot() {
		return ((Integer) getAttrVal("Srvslot"));
	}
	/**
	 * 时长
	 * @param Srvslot
	 */
	public void setSrvslot(Integer Srvslot) {
		setAttrVal("Srvslot", Srvslot);
	}
	/**
	 * 排班分类id
	 * @return String
	 */
	public String getId_scca() {
		return ((String) getAttrVal("Id_scca"));
	}
	/**
	 * 排班分类id
	 * @param Id_scca
	 */
	public void setId_scca(String Id_scca) {
		setAttrVal("Id_scca", Id_scca);
	}
	/**
	 * 参考价格
	 * @return FDouble
	 */
	public FDouble getPri() {
		return ((FDouble) getAttrVal("Pri"));
	}
	/**
	 * 参考价格
	 * @param Pri
	 */
	public void setPri(FDouble Pri) {
		setAttrVal("Pri", Pri);
	}
	/**
	 * 项目类别细目名称
	 * @return String
	 */
	public String getName_scsrvkinditem() {
		return ((String) getAttrVal("Name_scsrvkinditem"));
	}
	/**
	 * 项目类别细目名称
	 * @param Name_scsrvkinditem
	 */
	public void setName_scsrvkinditem(String Name_scsrvkinditem) {
		setAttrVal("Name_scsrvkinditem", Name_scsrvkinditem);
	}
	/**
	 * 项目类别编码
	 * @return String
	 */
	public String getCode_scsrvkind() {
		return ((String) getAttrVal("Code_scsrvkind"));
	}
	/**
	 * 项目类别编码
	 * @param Code_scsrvkind
	 */
	public void setCode_scsrvkind(String Code_scsrvkind) {
		setAttrVal("Code_scsrvkind", Code_scsrvkind);
	}
	/**
	 * 服务编码
	 * @return String
	 */
	public String getCode_srv() {
		return ((String) getAttrVal("Code_srv"));
	}
	/**
	 * 服务编码
	 * @param Code_srv
	 */
	public void setCode_srv(String Code_srv) {
		setAttrVal("Code_srv", Code_srv);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 * 服务名称
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	/**
	 * 排班项目类别
	 * @return String
	 */
	public String getId_scsrvkind() {
		return ((String) getAttrVal("Id_scsrvkind"));
	}
	/**
	 * 排班项目类别
	 * @param Id_scsrvkind
	 */
	public void setId_scsrvkind(String Id_scsrvkind) {
		setAttrVal("Id_scsrvkind", Id_scsrvkind);
	}
	/**
	 * 是否需确认
	 * @return FBoolean
	 */
	public FBoolean getFg_needcfm() {
		return ((FBoolean) getAttrVal("Fg_needcfm"));
	}
	/**
	 * 是否需确认
	 * @param Fg_needcfm
	 */
	public void setFg_needcfm(FBoolean Fg_needcfm) {
		setAttrVal("Fg_needcfm", Fg_needcfm);
	}
	/**
	 * 排班服务对照ID
	 * @return String
	 */
	public String getId_scsrvrel() {
		return ((String) getAttrVal("Id_scsrvrel"));
	}
	/**
	 * 排班服务对照ID
	 * @param Id_scsrvrel
	 */
	public void setId_scsrvrel(String Id_scsrvrel) {
		setAttrVal("Id_scsrvrel", Id_scsrvrel);
	}
	/**
	 * 排班服务
	 * @return String
	 */
	public String getId_scsrv() {
		return ((String) getAttrVal("Id_scsrv"));
	}
	/**
	 * 排班服务
	 * @param Id_scsrv
	 */
	public void setId_scsrv(String Id_scsrv) {
		setAttrVal("Id_scsrv", Id_scsrv);
	}
	/**
	 * 门诊是否自动预约
	 * @return FBoolean
	 */
	public FBoolean getFg_autoapt_op() {
		return ((FBoolean) getAttrVal("Fg_autoapt_op"));
	}
	/**
	 * 门诊是否自动预约
	 * @param Fg_autoapt_op
	 */
	public void setFg_autoapt_op(FBoolean Fg_autoapt_op) {
		setAttrVal("Fg_autoapt_op", Fg_autoapt_op);
	}
	/**
	 * 住院是否自动预约
	 * @return FBoolean
	 */
	public FBoolean getFg_autoapt_ip() {
		return ((FBoolean) getAttrVal("Fg_autoapt_ip"));
	}
	/**
	 * 住院是否自动预约
	 * @param Fg_autoapt_ip
	 */
	public void setFg_autoapt_ip(FBoolean Fg_autoapt_ip) {
		setAttrVal("Fg_autoapt_ip", Fg_autoapt_ip);
	}
}