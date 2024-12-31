package iih.nmr.pkuf.barthel.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nmr.pkuf.barthel.d.desc.BarthelDODesc;
import java.math.BigDecimal;

/**
 * Barthel指数评定量表 DO数据 
 * 
 */
public class BarthelDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//Brarthel主键
	public static final String ID_BARTHEL= "Id_barthel";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//就诊ID
	public static final String ID_ENT= "Id_ent";
	//患者ID
	public static final String ID_PAT= "Id_pat";
	//就诊病区
	public static final String NAME_DEP_NUR= "Name_dep_nur";
	//就诊科室
	public static final String NAME_DEP_PHY= "Name_dep_phy";
	//床号
	public static final String NAME_BED= "Name_bed";
	//患者姓名
	public static final String NAME_PAT= "Name_pat";
	//性别
	public static final String NAME_SEX= "Name_sex";
	//年龄
	public static final String AGE= "Age";
	//住院病案编号
	public static final String CODE_AMR_IP= "Code_amr_ip";
	//id_sign
	public static final String ID_SIGN= "Id_sign";
	//dt_create
	public static final String DT_CREATE= "Dt_create";
	//评估点
	public static final String ID_ASSESS_POINT= "Id_assess_point";
	//评估点编码
	public static final String SD_ASSESS_POINT= "Sd_assess_point";
	//进食
	public static final String ID_EAT= "Id_eat";
	//进食编码
	public static final String SD_EAT= "Sd_eat";
	//进食评分
	public static final String SC_EAT= "Sc_eat";
	//洗澡
	public static final String ID_TAKE_SHOWER= "Id_take_shower";
	//洗澡编码
	public static final String SD_TAKE_SHOWER= "Sd_take_shower";
	//洗澡评分
	public static final String SC_TAKE_SHOWER= "Sc_take_shower";
	//修饰
	public static final String ID_MODIFI= "Id_modifi";
	//修饰编码
	public static final String SD_MODIFI= "Sd_modifi";
	//修饰评分
	public static final String SC_MODIFI= "Sc_modifi";
	//穿衣
	public static final String ID_DRESS= "Id_dress";
	//穿衣编码
	public static final String SD_DRESS= "Sd_dress";
	//穿衣评分
	public static final String SC_DRESS= "Sc_dress";
	//控制大便
	public static final String ID_CONTRO_STOOL= "Id_contro_stool";
	//控制大便编码
	public static final String SD_CONTRO_STOOL= "Sd_contro_stool";
	//控制大便评分
	public static final String SC_CONTRO_STOOL= "Sc_contro_stool";
	//控制小便
	public static final String ID_CONTRO_URIN= "Id_contro_urin";
	//控制小便编码
	public static final String SD_CONTRO_URIN= "Sd_contro_urin";
	//控制小便评分
	public static final String SC_CONTRO_URIN= "Sc_contro_urin";
	//如厕
	public static final String ID_TOILET= "Id_toilet";
	//如厕编码
	public static final String SD_TOILET= "Sd_toilet";
	//如厕评分
	public static final String SC_TOILET= "Sc_toilet";
	//座椅转移
	public static final String ID_SEAT_TRANS= "Id_seat_trans";
	//座椅转移编码
	public static final String SD_SEAT_TRANS= "Sd_seat_trans";
	//座椅转移评分
	public static final String SC_SEAT_TRANS= "Sc_seat_trans";
	//平地行走
	public static final String ID_WALK_GROUND= "Id_walk_ground";
	//平地行走编码
	public static final String SD_WALK_GROUND= "Sd_walk_ground";
	//平地行走评分
	public static final String SC_WALK_GROUND= "Sc_walk_ground";
	//上下楼梯
	public static final String ID_STAIR= "Id_stair";
	//上下楼梯编码
	public static final String SD_STAIR= "Sd_stair";
	//上下楼梯评分
	public static final String SC_STAIR= "Sc_stair";
	//总分
	public static final String SC_TOTAL= "Sc_total";
	//建议
	public static final String ID_PROPOSAL= "Id_proposal";
	//建议编码
	public static final String SD_PROPOSAL= "Sd_proposal";
	//自理能力等级
	public static final String ID_SELF_LEAVE= "Id_self_leave";
	//自理能力等级编码
	public static final String SD_SELF_LEAVE= "Sd_self_leave";
	//死亡出院请选择
	public static final String IS_DEADTH= "Is_deadth";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//记录人
	public static final String NAME_SIGN= "Name_sign";
	//评估点
	public static final String NAME_ASSESS_POINT= "Name_assess_point";
	//进食
	public static final String NAME_EAT= "Name_eat";
	//洗澡
	public static final String NAME_TAKE_SHOWER= "Name_take_shower";
	//修饰
	public static final String NAME_MODIFI= "Name_modifi";
	//穿衣
	public static final String NAME_DRESS= "Name_dress";
	//控制大便
	public static final String NAME_CONTRO_STOOL= "Name_contro_stool";
	//控制小便
	public static final String NAME_CONTRO_URIN= "Name_contro_urin";
	//如厕
	public static final String NAME_TOILET= "Name_toilet";
	//座椅转移
	public static final String NAME_SEAT_TRANS= "Name_seat_trans";
	//平地行走
	public static final String NAME_WALK_GROUND= "Name_walk_ground";
	//上下楼梯
	public static final String NAME_STAIR= "Name_stair";
	//建议
	public static final String NAME_PROPOSAL= "Name_proposal";
	//自理能力等级
	public static final String NAME_SELF_LEAVE= "Name_self_leave";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * Brarthel主键
	 * @return String
	 */
	public String getId_barthel() {
		return ((String) getAttrVal("Id_barthel"));
	}	
	/**
	 * Brarthel主键
	 * @param Id_barthel
	 */
	public void setId_barthel(String Id_barthel) {
		setAttrVal("Id_barthel", Id_barthel);
	}
	/**
	 * 组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
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
	 * 就诊ID
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	/**
	 * 就诊ID
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 患者ID
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	/**
	 * 患者ID
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 就诊病区
	 * @return String
	 */
	public String getName_dep_nur() {
		return ((String) getAttrVal("Name_dep_nur"));
	}	
	/**
	 * 就诊病区
	 * @param Name_dep_nur
	 */
	public void setName_dep_nur(String Name_dep_nur) {
		setAttrVal("Name_dep_nur", Name_dep_nur);
	}
	/**
	 * 就诊科室
	 * @return String
	 */
	public String getName_dep_phy() {
		return ((String) getAttrVal("Name_dep_phy"));
	}	
	/**
	 * 就诊科室
	 * @param Name_dep_phy
	 */
	public void setName_dep_phy(String Name_dep_phy) {
		setAttrVal("Name_dep_phy", Name_dep_phy);
	}
	/**
	 * 床号
	 * @return String
	 */
	public String getName_bed() {
		return ((String) getAttrVal("Name_bed"));
	}	
	/**
	 * 床号
	 * @param Name_bed
	 */
	public void setName_bed(String Name_bed) {
		setAttrVal("Name_bed", Name_bed);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	/**
	 * 患者姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 性别
	 * @return String
	 */
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}	
	/**
	 * 性别
	 * @param Name_sex
	 */
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
	}
	/**
	 * 年龄
	 * @return String
	 */
	public String getAge() {
		return ((String) getAttrVal("Age"));
	}	
	/**
	 * 年龄
	 * @param Age
	 */
	public void setAge(String Age) {
		setAttrVal("Age", Age);
	}
	/**
	 * 住院病案编号
	 * @return String
	 */
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}	
	/**
	 * 住院病案编号
	 * @param Code_amr_ip
	 */
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	/**
	 * id_sign
	 * @return String
	 */
	public String getId_sign() {
		return ((String) getAttrVal("Id_sign"));
	}	
	/**
	 * id_sign
	 * @param Id_sign
	 */
	public void setId_sign(String Id_sign) {
		setAttrVal("Id_sign", Id_sign);
	}
	/**
	 * dt_create
	 * @return FDateTime
	 */
	public FDateTime getDt_create() {
		return ((FDateTime) getAttrVal("Dt_create"));
	}	
	/**
	 * dt_create
	 * @param Dt_create
	 */
	public void setDt_create(FDateTime Dt_create) {
		setAttrVal("Dt_create", Dt_create);
	}
	/**
	 * 评估点
	 * @return String
	 */
	public String getId_assess_point() {
		return ((String) getAttrVal("Id_assess_point"));
	}	
	/**
	 * 评估点
	 * @param Id_assess_point
	 */
	public void setId_assess_point(String Id_assess_point) {
		setAttrVal("Id_assess_point", Id_assess_point);
	}
	/**
	 * 评估点编码
	 * @return String
	 */
	public String getSd_assess_point() {
		return ((String) getAttrVal("Sd_assess_point"));
	}	
	/**
	 * 评估点编码
	 * @param Sd_assess_point
	 */
	public void setSd_assess_point(String Sd_assess_point) {
		setAttrVal("Sd_assess_point", Sd_assess_point);
	}
	/**
	 * 进食
	 * @return String
	 */
	public String getId_eat() {
		return ((String) getAttrVal("Id_eat"));
	}	
	/**
	 * 进食
	 * @param Id_eat
	 */
	public void setId_eat(String Id_eat) {
		setAttrVal("Id_eat", Id_eat);
	}
	/**
	 * 进食编码
	 * @return String
	 */
	public String getSd_eat() {
		return ((String) getAttrVal("Sd_eat"));
	}	
	/**
	 * 进食编码
	 * @param Sd_eat
	 */
	public void setSd_eat(String Sd_eat) {
		setAttrVal("Sd_eat", Sd_eat);
	}
	/**
	 * 进食评分
	 * @return Integer
	 */
	public Integer getSc_eat() {
		return ((Integer) getAttrVal("Sc_eat"));
	}	
	/**
	 * 进食评分
	 * @param Sc_eat
	 */
	public void setSc_eat(Integer Sc_eat) {
		setAttrVal("Sc_eat", Sc_eat);
	}
	/**
	 * 洗澡
	 * @return String
	 */
	public String getId_take_shower() {
		return ((String) getAttrVal("Id_take_shower"));
	}	
	/**
	 * 洗澡
	 * @param Id_take_shower
	 */
	public void setId_take_shower(String Id_take_shower) {
		setAttrVal("Id_take_shower", Id_take_shower);
	}
	/**
	 * 洗澡编码
	 * @return String
	 */
	public String getSd_take_shower() {
		return ((String) getAttrVal("Sd_take_shower"));
	}	
	/**
	 * 洗澡编码
	 * @param Sd_take_shower
	 */
	public void setSd_take_shower(String Sd_take_shower) {
		setAttrVal("Sd_take_shower", Sd_take_shower);
	}
	/**
	 * 洗澡评分
	 * @return Integer
	 */
	public Integer getSc_take_shower() {
		return ((Integer) getAttrVal("Sc_take_shower"));
	}	
	/**
	 * 洗澡评分
	 * @param Sc_take_shower
	 */
	public void setSc_take_shower(Integer Sc_take_shower) {
		setAttrVal("Sc_take_shower", Sc_take_shower);
	}
	/**
	 * 修饰
	 * @return String
	 */
	public String getId_modifi() {
		return ((String) getAttrVal("Id_modifi"));
	}	
	/**
	 * 修饰
	 * @param Id_modifi
	 */
	public void setId_modifi(String Id_modifi) {
		setAttrVal("Id_modifi", Id_modifi);
	}
	/**
	 * 修饰编码
	 * @return String
	 */
	public String getSd_modifi() {
		return ((String) getAttrVal("Sd_modifi"));
	}	
	/**
	 * 修饰编码
	 * @param Sd_modifi
	 */
	public void setSd_modifi(String Sd_modifi) {
		setAttrVal("Sd_modifi", Sd_modifi);
	}
	/**
	 * 修饰评分
	 * @return Integer
	 */
	public Integer getSc_modifi() {
		return ((Integer) getAttrVal("Sc_modifi"));
	}	
	/**
	 * 修饰评分
	 * @param Sc_modifi
	 */
	public void setSc_modifi(Integer Sc_modifi) {
		setAttrVal("Sc_modifi", Sc_modifi);
	}
	/**
	 * 穿衣
	 * @return String
	 */
	public String getId_dress() {
		return ((String) getAttrVal("Id_dress"));
	}	
	/**
	 * 穿衣
	 * @param Id_dress
	 */
	public void setId_dress(String Id_dress) {
		setAttrVal("Id_dress", Id_dress);
	}
	/**
	 * 穿衣编码
	 * @return String
	 */
	public String getSd_dress() {
		return ((String) getAttrVal("Sd_dress"));
	}	
	/**
	 * 穿衣编码
	 * @param Sd_dress
	 */
	public void setSd_dress(String Sd_dress) {
		setAttrVal("Sd_dress", Sd_dress);
	}
	/**
	 * 穿衣评分
	 * @return Integer
	 */
	public Integer getSc_dress() {
		return ((Integer) getAttrVal("Sc_dress"));
	}	
	/**
	 * 穿衣评分
	 * @param Sc_dress
	 */
	public void setSc_dress(Integer Sc_dress) {
		setAttrVal("Sc_dress", Sc_dress);
	}
	/**
	 * 控制大便
	 * @return String
	 */
	public String getId_contro_stool() {
		return ((String) getAttrVal("Id_contro_stool"));
	}	
	/**
	 * 控制大便
	 * @param Id_contro_stool
	 */
	public void setId_contro_stool(String Id_contro_stool) {
		setAttrVal("Id_contro_stool", Id_contro_stool);
	}
	/**
	 * 控制大便编码
	 * @return String
	 */
	public String getSd_contro_stool() {
		return ((String) getAttrVal("Sd_contro_stool"));
	}	
	/**
	 * 控制大便编码
	 * @param Sd_contro_stool
	 */
	public void setSd_contro_stool(String Sd_contro_stool) {
		setAttrVal("Sd_contro_stool", Sd_contro_stool);
	}
	/**
	 * 控制大便评分
	 * @return Integer
	 */
	public Integer getSc_contro_stool() {
		return ((Integer) getAttrVal("Sc_contro_stool"));
	}	
	/**
	 * 控制大便评分
	 * @param Sc_contro_stool
	 */
	public void setSc_contro_stool(Integer Sc_contro_stool) {
		setAttrVal("Sc_contro_stool", Sc_contro_stool);
	}
	/**
	 * 控制小便
	 * @return String
	 */
	public String getId_contro_urin() {
		return ((String) getAttrVal("Id_contro_urin"));
	}	
	/**
	 * 控制小便
	 * @param Id_contro_urin
	 */
	public void setId_contro_urin(String Id_contro_urin) {
		setAttrVal("Id_contro_urin", Id_contro_urin);
	}
	/**
	 * 控制小便编码
	 * @return String
	 */
	public String getSd_contro_urin() {
		return ((String) getAttrVal("Sd_contro_urin"));
	}	
	/**
	 * 控制小便编码
	 * @param Sd_contro_urin
	 */
	public void setSd_contro_urin(String Sd_contro_urin) {
		setAttrVal("Sd_contro_urin", Sd_contro_urin);
	}
	/**
	 * 控制小便评分
	 * @return Integer
	 */
	public Integer getSc_contro_urin() {
		return ((Integer) getAttrVal("Sc_contro_urin"));
	}	
	/**
	 * 控制小便评分
	 * @param Sc_contro_urin
	 */
	public void setSc_contro_urin(Integer Sc_contro_urin) {
		setAttrVal("Sc_contro_urin", Sc_contro_urin);
	}
	/**
	 * 如厕
	 * @return String
	 */
	public String getId_toilet() {
		return ((String) getAttrVal("Id_toilet"));
	}	
	/**
	 * 如厕
	 * @param Id_toilet
	 */
	public void setId_toilet(String Id_toilet) {
		setAttrVal("Id_toilet", Id_toilet);
	}
	/**
	 * 如厕编码
	 * @return String
	 */
	public String getSd_toilet() {
		return ((String) getAttrVal("Sd_toilet"));
	}	
	/**
	 * 如厕编码
	 * @param Sd_toilet
	 */
	public void setSd_toilet(String Sd_toilet) {
		setAttrVal("Sd_toilet", Sd_toilet);
	}
	/**
	 * 如厕评分
	 * @return Integer
	 */
	public Integer getSc_toilet() {
		return ((Integer) getAttrVal("Sc_toilet"));
	}	
	/**
	 * 如厕评分
	 * @param Sc_toilet
	 */
	public void setSc_toilet(Integer Sc_toilet) {
		setAttrVal("Sc_toilet", Sc_toilet);
	}
	/**
	 * 座椅转移
	 * @return String
	 */
	public String getId_seat_trans() {
		return ((String) getAttrVal("Id_seat_trans"));
	}	
	/**
	 * 座椅转移
	 * @param Id_seat_trans
	 */
	public void setId_seat_trans(String Id_seat_trans) {
		setAttrVal("Id_seat_trans", Id_seat_trans);
	}
	/**
	 * 座椅转移编码
	 * @return String
	 */
	public String getSd_seat_trans() {
		return ((String) getAttrVal("Sd_seat_trans"));
	}	
	/**
	 * 座椅转移编码
	 * @param Sd_seat_trans
	 */
	public void setSd_seat_trans(String Sd_seat_trans) {
		setAttrVal("Sd_seat_trans", Sd_seat_trans);
	}
	/**
	 * 座椅转移评分
	 * @return Integer
	 */
	public Integer getSc_seat_trans() {
		return ((Integer) getAttrVal("Sc_seat_trans"));
	}	
	/**
	 * 座椅转移评分
	 * @param Sc_seat_trans
	 */
	public void setSc_seat_trans(Integer Sc_seat_trans) {
		setAttrVal("Sc_seat_trans", Sc_seat_trans);
	}
	/**
	 * 平地行走
	 * @return String
	 */
	public String getId_walk_ground() {
		return ((String) getAttrVal("Id_walk_ground"));
	}	
	/**
	 * 平地行走
	 * @param Id_walk_ground
	 */
	public void setId_walk_ground(String Id_walk_ground) {
		setAttrVal("Id_walk_ground", Id_walk_ground);
	}
	/**
	 * 平地行走编码
	 * @return String
	 */
	public String getSd_walk_ground() {
		return ((String) getAttrVal("Sd_walk_ground"));
	}	
	/**
	 * 平地行走编码
	 * @param Sd_walk_ground
	 */
	public void setSd_walk_ground(String Sd_walk_ground) {
		setAttrVal("Sd_walk_ground", Sd_walk_ground);
	}
	/**
	 * 平地行走评分
	 * @return Integer
	 */
	public Integer getSc_walk_ground() {
		return ((Integer) getAttrVal("Sc_walk_ground"));
	}	
	/**
	 * 平地行走评分
	 * @param Sc_walk_ground
	 */
	public void setSc_walk_ground(Integer Sc_walk_ground) {
		setAttrVal("Sc_walk_ground", Sc_walk_ground);
	}
	/**
	 * 上下楼梯
	 * @return String
	 */
	public String getId_stair() {
		return ((String) getAttrVal("Id_stair"));
	}	
	/**
	 * 上下楼梯
	 * @param Id_stair
	 */
	public void setId_stair(String Id_stair) {
		setAttrVal("Id_stair", Id_stair);
	}
	/**
	 * 上下楼梯编码
	 * @return String
	 */
	public String getSd_stair() {
		return ((String) getAttrVal("Sd_stair"));
	}	
	/**
	 * 上下楼梯编码
	 * @param Sd_stair
	 */
	public void setSd_stair(String Sd_stair) {
		setAttrVal("Sd_stair", Sd_stair);
	}
	/**
	 * 上下楼梯评分
	 * @return Integer
	 */
	public Integer getSc_stair() {
		return ((Integer) getAttrVal("Sc_stair"));
	}	
	/**
	 * 上下楼梯评分
	 * @param Sc_stair
	 */
	public void setSc_stair(Integer Sc_stair) {
		setAttrVal("Sc_stair", Sc_stair);
	}
	/**
	 * 总分
	 * @return Integer
	 */
	public Integer getSc_total() {
		return ((Integer) getAttrVal("Sc_total"));
	}	
	/**
	 * 总分
	 * @param Sc_total
	 */
	public void setSc_total(Integer Sc_total) {
		setAttrVal("Sc_total", Sc_total);
	}
	/**
	 * 建议
	 * @return String
	 */
	public String getId_proposal() {
		return ((String) getAttrVal("Id_proposal"));
	}	
	/**
	 * 建议
	 * @param Id_proposal
	 */
	public void setId_proposal(String Id_proposal) {
		setAttrVal("Id_proposal", Id_proposal);
	}
	/**
	 * 建议编码
	 * @return String
	 */
	public String getSd_proposal() {
		return ((String) getAttrVal("Sd_proposal"));
	}	
	/**
	 * 建议编码
	 * @param Sd_proposal
	 */
	public void setSd_proposal(String Sd_proposal) {
		setAttrVal("Sd_proposal", Sd_proposal);
	}
	/**
	 * 自理能力等级
	 * @return String
	 */
	public String getId_self_leave() {
		return ((String) getAttrVal("Id_self_leave"));
	}	
	/**
	 * 自理能力等级
	 * @param Id_self_leave
	 */
	public void setId_self_leave(String Id_self_leave) {
		setAttrVal("Id_self_leave", Id_self_leave);
	}
	/**
	 * 自理能力等级编码
	 * @return String
	 */
	public String getSd_self_leave() {
		return ((String) getAttrVal("Sd_self_leave"));
	}	
	/**
	 * 自理能力等级编码
	 * @param Sd_self_leave
	 */
	public void setSd_self_leave(String Sd_self_leave) {
		setAttrVal("Sd_self_leave", Sd_self_leave);
	}
	/**
	 * 死亡出院请选择
	 * @return FBoolean
	 */
	public FBoolean getIs_deadth() {
		return ((FBoolean) getAttrVal("Is_deadth"));
	}	
	/**
	 * 死亡出院请选择
	 * @param Is_deadth
	 */
	public void setIs_deadth(FBoolean Is_deadth) {
		setAttrVal("Is_deadth", Is_deadth);
	}
	/**
	 * 创建人
	 * @return String
	 */
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	/**
	 * 创建人
	 * @param Createdby
	 */
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	/**
	 * 创建时间
	 * @return FDateTime
	 */
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}	
	/**
	 * 创建时间
	 * @param Createdtime
	 */
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	/**
	 * 最后修改人
	 * @return String
	 */
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}	
	/**
	 * 最后修改人
	 * @param Modifiedby
	 */
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	/**
	 * 最后修改时间
	 * @return FDateTime
	 */
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}	
	/**
	 * 最后修改时间
	 * @param Modifiedtime
	 */
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
	}
	/**
	 * 记录人
	 * @return String
	 */
	public String getName_sign() {
		return ((String) getAttrVal("Name_sign"));
	}	
	/**
	 * 记录人
	 * @param Name_sign
	 */
	public void setName_sign(String Name_sign) {
		setAttrVal("Name_sign", Name_sign);
	}
	/**
	 * 评估点
	 * @return String
	 */
	public String getName_assess_point() {
		return ((String) getAttrVal("Name_assess_point"));
	}	
	/**
	 * 评估点
	 * @param Name_assess_point
	 */
	public void setName_assess_point(String Name_assess_point) {
		setAttrVal("Name_assess_point", Name_assess_point);
	}
	/**
	 * 进食
	 * @return String
	 */
	public String getName_eat() {
		return ((String) getAttrVal("Name_eat"));
	}	
	/**
	 * 进食
	 * @param Name_eat
	 */
	public void setName_eat(String Name_eat) {
		setAttrVal("Name_eat", Name_eat);
	}
	/**
	 * 洗澡
	 * @return String
	 */
	public String getName_take_shower() {
		return ((String) getAttrVal("Name_take_shower"));
	}	
	/**
	 * 洗澡
	 * @param Name_take_shower
	 */
	public void setName_take_shower(String Name_take_shower) {
		setAttrVal("Name_take_shower", Name_take_shower);
	}
	/**
	 * 修饰
	 * @return String
	 */
	public String getName_modifi() {
		return ((String) getAttrVal("Name_modifi"));
	}	
	/**
	 * 修饰
	 * @param Name_modifi
	 */
	public void setName_modifi(String Name_modifi) {
		setAttrVal("Name_modifi", Name_modifi);
	}
	/**
	 * 穿衣
	 * @return String
	 */
	public String getName_dress() {
		return ((String) getAttrVal("Name_dress"));
	}	
	/**
	 * 穿衣
	 * @param Name_dress
	 */
	public void setName_dress(String Name_dress) {
		setAttrVal("Name_dress", Name_dress);
	}
	/**
	 * 控制大便
	 * @return String
	 */
	public String getName_contro_stool() {
		return ((String) getAttrVal("Name_contro_stool"));
	}	
	/**
	 * 控制大便
	 * @param Name_contro_stool
	 */
	public void setName_contro_stool(String Name_contro_stool) {
		setAttrVal("Name_contro_stool", Name_contro_stool);
	}
	/**
	 * 控制小便
	 * @return String
	 */
	public String getName_contro_urin() {
		return ((String) getAttrVal("Name_contro_urin"));
	}	
	/**
	 * 控制小便
	 * @param Name_contro_urin
	 */
	public void setName_contro_urin(String Name_contro_urin) {
		setAttrVal("Name_contro_urin", Name_contro_urin);
	}
	/**
	 * 如厕
	 * @return String
	 */
	public String getName_toilet() {
		return ((String) getAttrVal("Name_toilet"));
	}	
	/**
	 * 如厕
	 * @param Name_toilet
	 */
	public void setName_toilet(String Name_toilet) {
		setAttrVal("Name_toilet", Name_toilet);
	}
	/**
	 * 座椅转移
	 * @return String
	 */
	public String getName_seat_trans() {
		return ((String) getAttrVal("Name_seat_trans"));
	}	
	/**
	 * 座椅转移
	 * @param Name_seat_trans
	 */
	public void setName_seat_trans(String Name_seat_trans) {
		setAttrVal("Name_seat_trans", Name_seat_trans);
	}
	/**
	 * 平地行走
	 * @return String
	 */
	public String getName_walk_ground() {
		return ((String) getAttrVal("Name_walk_ground"));
	}	
	/**
	 * 平地行走
	 * @param Name_walk_ground
	 */
	public void setName_walk_ground(String Name_walk_ground) {
		setAttrVal("Name_walk_ground", Name_walk_ground);
	}
	/**
	 * 上下楼梯
	 * @return String
	 */
	public String getName_stair() {
		return ((String) getAttrVal("Name_stair"));
	}	
	/**
	 * 上下楼梯
	 * @param Name_stair
	 */
	public void setName_stair(String Name_stair) {
		setAttrVal("Name_stair", Name_stair);
	}
	/**
	 * 建议
	 * @return String
	 */
	public String getName_proposal() {
		return ((String) getAttrVal("Name_proposal"));
	}	
	/**
	 * 建议
	 * @param Name_proposal
	 */
	public void setName_proposal(String Name_proposal) {
		setAttrVal("Name_proposal", Name_proposal);
	}
	/**
	 * 自理能力等级
	 * @return String
	 */
	public String getName_self_leave() {
		return ((String) getAttrVal("Name_self_leave"));
	}	
	/**
	 * 自理能力等级
	 * @param Name_self_leave
	 */
	public void setName_self_leave(String Name_self_leave) {
		setAttrVal("Name_self_leave", Name_self_leave);
	}

	public Integer getDs() {
		return ((Integer) getAttrVal(GlobalConst.DELETE_SIGN));
	}
	
	public void setDs(Integer ds) {
		setAttrVal(GlobalConst.DELETE_SIGN, ds);
	}
	
	public FDateTime getSv() {
		return ((FDateTime) getAttrVal(GlobalConst.SYSTEM_VERSION));
	}
	
	public void setSv(FDateTime sv) {
		setAttrVal(GlobalConst.SYSTEM_VERSION, sv);
	}

//	@Override
//	public java.lang.String getParentPKFieldName() {
//		return null;
//	}
  
	@Override
	public String getPKFieldName() {
		return "Id_barthel";
	}
	
	@Override
	public String getTableName() {	  
		return "NMR_PKUF_BARTHEL";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BarthelDODesc.class);
	}
	
}