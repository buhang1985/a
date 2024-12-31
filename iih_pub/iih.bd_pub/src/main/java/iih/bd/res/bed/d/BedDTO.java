package iih.bd.res.bed.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 床位信息DTO DTO数据 
 * 
 */
public class BedDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 床位ID
	 * @return String
	 */
	public String getId_bed() {
		return ((String) getAttrVal("Id_bed"));
	}
	/**
	 * 床位ID
	 * @param Id_bed
	 */
	public void setId_bed(String Id_bed) {
		setAttrVal("Id_bed", Id_bed);
	}
	/**
	 * 集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}
	/**
	 * 集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 机构
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}
	/**
	 * 机构
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 床位编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 床位编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 床位名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 床位名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 床位描述
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}
	/**
	 * 床位描述
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 所属部门id
	 * @return String
	 */
	public String getId_dep_belong() {
		return ((String) getAttrVal("Id_dep_belong"));
	}
	/**
	 * 所属部门id
	 * @param Id_dep_belong
	 */
	public void setId_dep_belong(String Id_dep_belong) {
		setAttrVal("Id_dep_belong", Id_dep_belong);
	}
	/**
	 * 所属部门
	 * @return String
	 */
	public String getName_dep_belong() {
		return ((String) getAttrVal("Name_dep_belong"));
	}
	/**
	 * 所属部门
	 * @param Name_dep_belong
	 */
	public void setName_dep_belong(String Name_dep_belong) {
		setAttrVal("Name_dep_belong", Name_dep_belong);
	}
	/**
	 * 使用部门id
	 * @return String
	 */
	public String getId_dep_use() {
		return ((String) getAttrVal("Id_dep_use"));
	}
	/**
	 * 使用部门id
	 * @param Id_dep_use
	 */
	public void setId_dep_use(String Id_dep_use) {
		setAttrVal("Id_dep_use", Id_dep_use);
	}
	/**
	 * 使用部门
	 * @return String
	 */
	public String getName_dep_use() {
		return ((String) getAttrVal("Name_dep_use"));
	}
	/**
	 * 使用部门
	 * @param Name_dep_use
	 */
	public void setName_dep_use(String Name_dep_use) {
		setAttrVal("Name_dep_use", Name_dep_use);
	}
	/**
	 * 床位类型id
	 * @return String
	 */
	public String getId_bedtp() {
		return ((String) getAttrVal("Id_bedtp"));
	}
	/**
	 * 床位类型id
	 * @param Id_bedtp
	 */
	public void setId_bedtp(String Id_bedtp) {
		setAttrVal("Id_bedtp", Id_bedtp);
	}
	/**
	 * 床位类型编码
	 * @return String
	 */
	public String getSd_bedtp() {
		return ((String) getAttrVal("Sd_bedtp"));
	}
	/**
	 * 床位类型编码
	 * @param Sd_bedtp
	 */
	public void setSd_bedtp(String Sd_bedtp) {
		setAttrVal("Sd_bedtp", Sd_bedtp);
	}
	/**
	 * 床位类型
	 * @return String
	 */
	public String getName_bedtp() {
		return ((String) getAttrVal("Name_bedtp"));
	}
	/**
	 * 床位类型
	 * @param Name_bedtp
	 */
	public void setName_bedtp(String Name_bedtp) {
		setAttrVal("Name_bedtp", Name_bedtp);
	}
	/**
	 * 服务项目
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 服务项目
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 地点
	 * @return String
	 */
	public String getId_plc() {
		return ((String) getAttrVal("Id_plc"));
	}
	/**
	 * 地点
	 * @param Id_plc
	 */
	public void setId_plc(String Id_plc) {
		setAttrVal("Id_plc", Id_plc);
	}
	/**
	 * 房间号
	 * @return String
	 */
	public String getRoom() {
		return ((String) getAttrVal("Room"));
	}
	/**
	 * 房间号
	 * @param Room
	 */
	public void setRoom(String Room) {
		setAttrVal("Room", Room);
	}
	/**
	 * displaynam26
	 * @return String
	 */
	public String getName_bedsu() {
		return ((String) getAttrVal("Name_bedsu"));
	}
	/**
	 * displaynam26
	 * @param Name_bedsu
	 */
	public void setName_bedsu(String Name_bedsu) {
		setAttrVal("Name_bedsu", Name_bedsu);
	}
	/**
	 * 床位状态编码
	 * @return String
	 */
	public String getSd_bedsu() {
		return ((String) getAttrVal("Sd_bedsu"));
	}
	/**
	 * 床位状态编码
	 * @param Sd_bedsu
	 */
	public void setSd_bedsu(String Sd_bedsu) {
		setAttrVal("Sd_bedsu", Sd_bedsu);
	}
	/**
	 * 床位状态
	 * @return String
	 */
	public String getId_bedsu() {
		return ((String) getAttrVal("Id_bedsu"));
	}
	/**
	 * 床位状态
	 * @param Id_bedsu
	 */
	public void setId_bedsu(String Id_bedsu) {
		setAttrVal("Id_bedsu", Id_bedsu);
	}
	/**
	 * 已预约标志
	 * @return FBoolean
	 */
	public FBoolean getFg_appt() {
		return ((FBoolean) getAttrVal("Fg_appt"));
	}
	/**
	 * 已预约标志
	 * @param Fg_appt
	 */
	public void setFg_appt(FBoolean Fg_appt) {
		setAttrVal("Fg_appt", Fg_appt);
	}
	/**
	 * 临时加床标志
	 * @return FBoolean
	 */
	public FBoolean getFg_tmp() {
		return ((FBoolean) getAttrVal("Fg_tmp"));
	}
	/**
	 * 临时加床标志
	 * @param Fg_tmp
	 */
	public void setFg_tmp(FBoolean Fg_tmp) {
		setAttrVal("Fg_tmp", Fg_tmp);
	}
	/**
	 * 包床标志
	 * @return FBoolean
	 */
	public FBoolean getFg_share() {
		return ((FBoolean) getAttrVal("Fg_share"));
	}
	/**
	 * 包床标志
	 * @param Fg_share
	 */
	public void setFg_share(FBoolean Fg_share) {
		setAttrVal("Fg_share", Fg_share);
	}
	/**
	 * 启用标志
	 * @return FBoolean
	 */
	public FBoolean getFg_act() {
		return ((FBoolean) getAttrVal("Fg_act"));
	}
	/**
	 * 启用标志
	 * @param Fg_act
	 */
	public void setFg_act(FBoolean Fg_act) {
		setAttrVal("Fg_act", Fg_act);
	}
	/**
	 * 主床id
	 * @return String
	 */
	public String getId_bed_main() {
		return ((String) getAttrVal("Id_bed_main"));
	}
	/**
	 * 主床id
	 * @param Id_bed_main
	 */
	public void setId_bed_main(String Id_bed_main) {
		setAttrVal("Id_bed_main", Id_bed_main);
	}
	/**
	 * 待出院
	 * @return FBoolean
	 */
	public FBoolean getFg_willlv() {
		return ((FBoolean) getAttrVal("Fg_willlv"));
	}
	/**
	 * 待出院
	 * @param Fg_willlv
	 */
	public void setFg_willlv(FBoolean Fg_willlv) {
		setAttrVal("Fg_willlv", Fg_willlv);
	}
	/**
	 * 床位费用
	 * @return String
	 */
	public String getBed_pric() {
		return ((String) getAttrVal("Bed_pric"));
	}
	/**
	 * 床位费用
	 * @param Bed_pric
	 */
	public void setBed_pric(String Bed_pric) {
		setAttrVal("Bed_pric", Bed_pric);
	}
	/**
	 * 床位性别
	 * @return String
	 */
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}
	/**
	 * 床位性别
	 * @param Name_sex
	 */
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
	}
	/**
	 * 床位性别sd
	 * @return String
	 */
	public String getSd_sex() {
		return ((String) getAttrVal("Sd_sex"));
	}
	/**
	 * 床位性别sd
	 * @param Sd_sex
	 */
	public void setSd_sex(String Sd_sex) {
		setAttrVal("Sd_sex", Sd_sex);
	}
	/**
	 * 床位性别id
	 * @return String
	 */
	public String getId_sex() {
		return ((String) getAttrVal("Id_sex"));
	}
	/**
	 * 床位性别id
	 * @param Id_sex
	 */
	public void setId_sex(String Id_sex) {
		setAttrVal("Id_sex", Id_sex);
	}
}