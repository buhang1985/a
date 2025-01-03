package iih.ci.ord.dto.ems.uiemsdto.d;

import iih.ci.ord.dto.ems.uiemsdto.b.BaseEmsViewDTO;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;

/**
 * 海淀妇幼病理医疗单主 DTO数据 
 * 
 */
public class EmsPathgyHDWViewDTO extends BaseEmsViewDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱ID
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱ID
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 服务id
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 服务id
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 处置项目
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 * 处置项目
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	/**
	 * 明细
	 * @return String
	 */
	public String getDetails() {
		return ((String) getAttrVal("Details"));
	}
	/**
	 * 明细
	 * @param Details
	 */
	public void setDetails(String Details) {
		setAttrVal("Details", Details);
	}
	/**
	 * 标本类型ID
	 * @return String
	 */
	public String getId_samptp() {
		return ((String) getAttrVal("Id_samptp"));
	}
	/**
	 * 标本类型ID
	 * @param Id_samptp
	 */
	public void setId_samptp(String Id_samptp) {
		setAttrVal("Id_samptp", Id_samptp);
	}
	/**
	 * 标本类型SD
	 * @return String
	 */
	public String getSd_samptp() {
		return ((String) getAttrVal("Sd_samptp"));
	}
	/**
	 * 标本类型SD
	 * @param Sd_samptp
	 */
	public void setSd_samptp(String Sd_samptp) {
		setAttrVal("Sd_samptp", Sd_samptp);
	}
	/**
	 * 标本类型名称
	 * @return String
	 */
	public String getName_samptp() {
		return ((String) getAttrVal("Name_samptp"));
	}
	/**
	 * 标本类型名称
	 * @param Name_samptp
	 */
	public void setName_samptp(String Name_samptp) {
		setAttrVal("Name_samptp", Name_samptp);
	}
	/**
	 * 临床诊断ID
	 * @return String
	 */
	public String getId_di() {
		return ((String) getAttrVal("Id_di"));
	}
	/**
	 * 临床诊断ID
	 * @param Id_di
	 */
	public void setId_di(String Id_di) {
		setAttrVal("Id_di", Id_di);
	}
	/**
	 * 临床诊断
	 * @return String
	 */
	public String getName_di() {
		return ((String) getAttrVal("Name_di"));
	}
	/**
	 * 临床诊断
	 * @param Name_di
	 */
	public void setName_di(String Name_di) {
		setAttrVal("Name_di", Name_di);
	}
	/**
	 * 诊断子项ID
	 * @return String
	 */
	public String getId_diitm() {
		return ((String) getAttrVal("Id_diitm"));
	}
	/**
	 * 诊断子项ID
	 * @param Id_diitm
	 */
	public void setId_diitm(String Id_diitm) {
		setAttrVal("Id_diitm", Id_diitm);
	}
	/**
	 * 加急标识
	 * @return FBoolean
	 */
	public FBoolean getFg_urgent() {
		return ((FBoolean) getAttrVal("Fg_urgent"));
	}
	/**
	 * 加急标识
	 * @param Fg_urgent
	 */
	public void setFg_urgent(FBoolean Fg_urgent) {
		setAttrVal("Fg_urgent", Fg_urgent);
	}
	/**
	 * 申请单号
	 * @return String
	 */
	public String getNo_pathgy() {
		return ((String) getAttrVal("No_pathgy"));
	}
	/**
	 * 申请单号
	 * @param No_pathgy
	 */
	public void setNo_pathgy(String No_pathgy) {
		setAttrVal("No_pathgy", No_pathgy);
	}
	/**
	 * 执行科室ID
	 * @return String
	 */
	public String getId_dep_mp() {
		return ((String) getAttrVal("Id_dep_mp"));
	}
	/**
	 * 执行科室ID
	 * @param Id_dep_mp
	 */
	public void setId_dep_mp(String Id_dep_mp) {
		setAttrVal("Id_dep_mp", Id_dep_mp);
	}
	/**
	 * 执行科室
	 * @return String
	 */
	public String getName_dep_mp() {
		return ((String) getAttrVal("Name_dep_mp"));
	}
	/**
	 * 执行科室
	 * @param Name_dep_mp
	 */
	public void setName_dep_mp(String Name_dep_mp) {
		setAttrVal("Name_dep_mp", Name_dep_mp);
	}
	/**
	 * 执行科室过滤条件
	 * @return String
	 */
	public String getFilter_dep_mp() {
		return ((String) getAttrVal("Filter_dep_mp"));
	}
	/**
	 * 执行科室过滤条件
	 * @param Filter_dep_mp
	 */
	public void setFilter_dep_mp(String Filter_dep_mp) {
		setAttrVal("Filter_dep_mp", Filter_dep_mp);
	}
	/**
	 * 单价
	 * @return FDouble
	 */
	public FDouble getPrice() {
		return ((FDouble) getAttrVal("Price"));
	}
	/**
	 * 单价
	 * @param Price
	 */
	public void setPrice(FDouble Price) {
		setAttrVal("Price", Price);
	}
	/**
	 * 病情描述
	 * @return String
	 */
	public String getDes_sympsign() {
		return ((String) getAttrVal("Des_sympsign"));
	}
	/**
	 * 病情描述
	 * @param Des_sympsign
	 */
	public void setDes_sympsign(String Des_sympsign) {
		setAttrVal("Des_sympsign", Des_sympsign);
	}
	/**
	 * 检查要求
	 * @return String
	 */
	public String getAnnouncements() {
		return ((String) getAttrVal("Announcements"));
	}
	/**
	 * 检查要求
	 * @param Announcements
	 */
	public void setAnnouncements(String Announcements) {
		setAttrVal("Announcements", Announcements);
	}
	/**
	 * 肿瘤生长时间（def9）
	 * @return String
	 */
	public String getTumourtime() {
		return ((String) getAttrVal("Tumourtime"));
	}
	/**
	 * 肿瘤生长时间（def9）
	 * @param Tumourtime
	 */
	public void setTumourtime(String Tumourtime) {
		setAttrVal("Tumourtime", Tumourtime);
	}
	/**
	 * 肿瘤生长时间单位(def10)
	 * @return String
	 */
	public String getTumourtimeunit() {
		return ((String) getAttrVal("Tumourtimeunit"));
	}
	/**
	 * 肿瘤生长时间单位(def10)
	 * @param Tumourtimeunit
	 */
	public void setTumourtimeunit(String Tumourtimeunit) {
		setAttrVal("Tumourtimeunit", Tumourtimeunit);
	}
	/**
	 * 肿瘤大小(def11)
	 * @return String
	 */
	public String getTumoursize() {
		return ((String) getAttrVal("Tumoursize"));
	}
	/**
	 * 肿瘤大小(def11)
	 * @param Tumoursize
	 */
	public void setTumoursize(String Tumoursize) {
		setAttrVal("Tumoursize", Tumoursize);
	}
	/**
	 * 肿瘤位置(def12)
	 * @return String
	 */
	public String getTumourplace() {
		return ((String) getAttrVal("Tumourplace"));
	}
	/**
	 * 肿瘤位置(def12)
	 * @param Tumourplace
	 */
	public void setTumourplace(String Tumourplace) {
		setAttrVal("Tumourplace", Tumourplace);
	}
	/**
	 * 转移瘤位置(def13)
	 * @return String
	 */
	public String getTumourtransfer() {
		return ((String) getAttrVal("Tumourtransfer"));
	}
	/**
	 * 转移瘤位置(def13)
	 * @param Tumourtransfer
	 */
	public void setTumourtransfer(String Tumourtransfer) {
		setAttrVal("Tumourtransfer", Tumourtransfer);
	}
	/**
	 * 上次月经(def3)
	 * @return FDateTime
	 */
	public FDateTime getMenslast() {
		return ((FDateTime) getAttrVal("Menslast"));
	}
	/**
	 * 上次月经(def3)
	 * @param Menslast
	 */
	public void setMenslast(FDateTime Menslast) {
		setAttrVal("Menslast", Menslast);
	}
	/**
	 * 本次月经（def4）
	 * @return FDateTime
	 */
	public FDateTime getMensthis() {
		return ((FDateTime) getAttrVal("Mensthis"));
	}
	/**
	 * 本次月经（def4）
	 * @param Mensthis
	 */
	public void setMensthis(FDateTime Mensthis) {
		setAttrVal("Mensthis", Mensthis);
	}
	/**
	 * 出血量(def5)
	 * @return String
	 */
	public String getBloodv() {
		return ((String) getAttrVal("Bloodv"));
	}
	/**
	 * 出血量(def5)
	 * @param Bloodv
	 */
	public void setBloodv(String Bloodv) {
		setAttrVal("Bloodv", Bloodv);
	}
	/**
	 * 人工周期治疗标识(def6)
	 * @return FBoolean
	 */
	public FBoolean getFg_hascure() {
		return ((FBoolean) getAttrVal("Fg_hascure"));
	}
	/**
	 * 人工周期治疗标识(def6)
	 * @param Fg_hascure
	 */
	public void setFg_hascure(FBoolean Fg_hascure) {
		setAttrVal("Fg_hascure", Fg_hascure);
	}
	/**
	 * 治疗时间(def7)
	 * @return FDateTime
	 */
	public FDateTime getTreattiem() {
		return ((FDateTime) getAttrVal("Treattiem"));
	}
	/**
	 * 治疗时间(def7)
	 * @param Treattiem
	 */
	public void setTreattiem(FDateTime Treattiem) {
		setAttrVal("Treattiem", Treattiem);
	}
	/**
	 * 剂量(def8)
	 * @return FDouble
	 */
	public FDouble getDosage() {
		return ((FDouble) getAttrVal("Dosage"));
	}
	/**
	 * 剂量(def8)
	 * @param Dosage
	 */
	public void setDosage(FDouble Dosage) {
		setAttrVal("Dosage", Dosage);
	}
	/**
	 * 既往病理外院标识
	 * @return FBoolean
	 */
	public FBoolean getFg_outer() {
		return ((FBoolean) getAttrVal("Fg_outer"));
	}
	/**
	 * 既往病理外院标识
	 * @param Fg_outer
	 */
	public void setFg_outer(FBoolean Fg_outer) {
		setAttrVal("Fg_outer", Fg_outer);
	}
	/**
	 * 既往医院名称
	 * @return String
	 */
	public String getOrg_pathgy_old() {
		return ((String) getAttrVal("Org_pathgy_old"));
	}
	/**
	 * 既往医院名称
	 * @param Org_pathgy_old
	 */
	public void setOrg_pathgy_old(String Org_pathgy_old) {
		setAttrVal("Org_pathgy_old", Org_pathgy_old);
	}
	/**
	 * 既往病理号
	 * @return String
	 */
	public String getNo_pathgy_old() {
		return ((String) getAttrVal("No_pathgy_old"));
	}
	/**
	 * 既往病理号
	 * @param No_pathgy_old
	 */
	public void setNo_pathgy_old(String No_pathgy_old) {
		setAttrVal("No_pathgy_old", No_pathgy_old);
	}
	/**
	 * 既往报告日期
	 * @return FDateTime
	 */
	public FDateTime getDt_pathgy_old() {
		return ((FDateTime) getAttrVal("Dt_pathgy_old"));
	}
	/**
	 * 既往报告日期
	 * @param Dt_pathgy_old
	 */
	public void setDt_pathgy_old(FDateTime Dt_pathgy_old) {
		setAttrVal("Dt_pathgy_old", Dt_pathgy_old);
	}
	/**
	 * 既往病理诊断
	 * @return String
	 */
	public String getDi_pathgy_old() {
		return ((String) getAttrVal("Di_pathgy_old"));
	}
	/**
	 * 既往病理诊断
	 * @param Di_pathgy_old
	 */
	public void setDi_pathgy_old(String Di_pathgy_old) {
		setAttrVal("Di_pathgy_old", Di_pathgy_old);
	}
	/**
	 * 采集所见
	 * @return String
	 */
	public String getCollectdes() {
		return ((String) getAttrVal("Collectdes"));
	}
	/**
	 * 采集所见
	 * @param Collectdes
	 */
	public void setCollectdes(String Collectdes) {
		setAttrVal("Collectdes", Collectdes);
	}
	/**
	 * 采集人id
	 * @return String
	 */
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}
	/**
	 * 采集人id
	 * @param Id_emp
	 */
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	/**
	 * 采集人
	 * @return String
	 */
	public String getName_emp() {
		return ((String) getAttrVal("Name_emp"));
	}
	/**
	 * 采集人
	 * @param Name_emp
	 */
	public void setName_emp(String Name_emp) {
		setAttrVal("Name_emp", Name_emp);
	}
	/**
	 * 采集时间
	 * @return FDateTime
	 */
	public FDateTime getDt_coll() {
		return ((FDateTime) getAttrVal("Dt_coll"));
	}
	/**
	 * 采集时间
	 * @param Dt_coll
	 */
	public void setDt_coll(FDateTime Dt_coll) {
		setAttrVal("Dt_coll", Dt_coll);
	}
	/**
	 * sv
	 * @return String
	 */
	public String getSv() {
		return ((String) getAttrVal("Sv"));
	}
	/**
	 * sv
	 * @param Sv
	 */
	public void setSv(String Sv) {
		setAttrVal("Sv", Sv);
	}
	/**
	 * 服务套标识
	 * @return FBoolean
	 */
	public FBoolean getFg_set() {
		return ((FBoolean) getAttrVal("Fg_set"));
	}
	/**
	 * 服务套标识
	 * @param Fg_set
	 */
	public void setFg_set(FBoolean Fg_set) {
		setAttrVal("Fg_set", Fg_set);
	}
	/**
	 * 病理标本信息
	 * @return FArrayList
	 */
	public FArrayList getEmspathgyitems() {
		return ((FArrayList) getAttrVal("Emspathgyitems"));
	}
	/**
	 * 病理标本信息
	 * @param Emspathgyitems
	 */
	public void setEmspathgyitems(FArrayList Emspathgyitems) {
		setAttrVal("Emspathgyitems", Emspathgyitems);
	}
	/**
	 * 单选标识
	 * @return String
	 */
	public String getFg_radio() {
		return ((String) getAttrVal("Fg_radio"));
	}
	/**
	 * 单选标识
	 * @param Fg_radio
	 */
	public void setFg_radio(String Fg_radio) {
		setAttrVal("Fg_radio", Fg_radio);
	}
	/**
	 * 医嘱服务ID
	 * @return String
	 */
	public String getId_or_srv() {
		return ((String) getAttrVal("Id_or_srv"));
	}
	/**
	 * 医嘱服务ID
	 * @param Id_or_srv
	 */
	public void setId_or_srv(String Id_or_srv) {
		setAttrVal("Id_or_srv", Id_or_srv);
	}
}