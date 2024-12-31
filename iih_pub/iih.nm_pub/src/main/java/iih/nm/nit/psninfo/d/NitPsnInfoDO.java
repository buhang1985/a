package iih.nm.nit.psninfo.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nit.psninfo.d.desc.NitPsnInfoDODesc;
import java.math.BigDecimal;

/**
 * 实习进修管理 DO数据 
 * 
 */
public class NitPsnInfoDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//唯一标识
	public static final String ID_NIT_PSNINFO= "Id_nit_psninfo";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//姓名
	public static final String NAME= "Name";
	//编码
	public static final String CODE= "Code";
	//性别id
	public static final String ID_SEX= "Id_sex";
	//性别编码
	public static final String SD_SEX= "Sd_sex";
	//职工类表id
	public static final String ID_WKCA= "Id_wkca";
	//职工类别编码
	public static final String SD_WKCA= "Sd_wkca";
	//出生日期
	public static final String DT_BIRTH= "Dt_birth";
	//民族id
	public static final String ID_NATION= "Id_nation";
	//民族编码
	public static final String SD_NATION= "Sd_nation";
	//户口所在地
	public static final String ADD_HOUSE= "Add_house";
	//到院日期
	public static final String DT_IN= "Dt_in";
	//结束日期
	public static final String DT_END= "Dt_end";
	//籍贯
	public static final String BTH_PLACE= "Bth_place";
	//身高
	public static final String HEIGHT= "Height";
	//院校
	public static final String ID_NIT_SRO= "Id_nit_sro";
	//批次
	public static final String ID_NIT_SRO_BCH= "Id_nit_sro_bch";
	//护士鞋号
	public static final String SHOE_SIZE= "Shoe_size";
	//外语等级id
	public static final String ID_FLANG_LVL= "Id_flang_lvl";
	//外语等级编码
	public static final String SD_FLANG_LVL= "Sd_flang_lvl";
	//护士层级id
	public static final String ID_NUR_LVL= "Id_nur_lvl";
	//护士层级编码
	public static final String SD_NUR_LVL= "Sd_nur_lvl";
	//注销原因id
	public static final String ID_OUT_REAS= "Id_out_reas";
	//注销原因编码
	public static final String SD_OUT_REAS= "Sd_out_reas";
	//手机号码
	public static final String TEL= "Tel";
	//邮箱
	public static final String EMAIL= "Email";
	//家庭地址
	public static final String ADDRESS= "Address";
	//护理单元
	public static final String ID_DEP_NUR= "Id_dep_nur";
	//毕业去向
	public static final String GRAD_TO= "Grad_to";
	//备注
	public static final String DES= "Des";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//组织名称
	public static final String NAME_ORG= "Name_org";
	//名称
	public static final String NAME_GRP= "Name_grp";
	//性别
	public static final String NAME_SEX= "Name_sex";
	//名称
	public static final String NAME_WKCA= "Name_wkca";
	//名称
	public static final String NAME_NATION= "Name_nation";
	//院校
	public static final String NAME_NIT_SRO= "Name_nit_sro";
	//批次
	public static final String NAME_NIT_SRO_BCH= "Name_nit_sro_bch";
	//名称
	public static final String NAME_FLANG_LVL= "Name_flang_lvl";
	//名称
	public static final String NAME_NUR_LVL= "Name_nur_lvl";
	//名称
	public static final String NAME_OUT_REAS= "Name_out_reas";
	//名称
	public static final String NAME_DEP_NUR= "Name_dep_nur";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 唯一标识
	 * @return String
	 */
	public String getId_nit_psninfo() {
		return ((String) getAttrVal("Id_nit_psninfo"));
	}	
	/**
	 * 唯一标识
	 * @param Id_nit_psninfo
	 */
	public void setId_nit_psninfo(String Id_nit_psninfo) {
		setAttrVal("Id_nit_psninfo", Id_nit_psninfo);
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
	 * 姓名
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 姓名
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 性别id
	 * @return String
	 */
	public String getId_sex() {
		return ((String) getAttrVal("Id_sex"));
	}	
	/**
	 * 性别id
	 * @param Id_sex
	 */
	public void setId_sex(String Id_sex) {
		setAttrVal("Id_sex", Id_sex);
	}
	/**
	 * 性别编码
	 * @return String
	 */
	public String getSd_sex() {
		return ((String) getAttrVal("Sd_sex"));
	}	
	/**
	 * 性别编码
	 * @param Sd_sex
	 */
	public void setSd_sex(String Sd_sex) {
		setAttrVal("Sd_sex", Sd_sex);
	}
	/**
	 * 职工类表id
	 * @return String
	 */
	public String getId_wkca() {
		return ((String) getAttrVal("Id_wkca"));
	}	
	/**
	 * 职工类表id
	 * @param Id_wkca
	 */
	public void setId_wkca(String Id_wkca) {
		setAttrVal("Id_wkca", Id_wkca);
	}
	/**
	 * 职工类别编码
	 * @return String
	 */
	public String getSd_wkca() {
		return ((String) getAttrVal("Sd_wkca"));
	}	
	/**
	 * 职工类别编码
	 * @param Sd_wkca
	 */
	public void setSd_wkca(String Sd_wkca) {
		setAttrVal("Sd_wkca", Sd_wkca);
	}
	/**
	 * 出生日期
	 * @return FDate
	 */
	public FDate getDt_birth() {
		return ((FDate) getAttrVal("Dt_birth"));
	}	
	/**
	 * 出生日期
	 * @param Dt_birth
	 */
	public void setDt_birth(FDate Dt_birth) {
		setAttrVal("Dt_birth", Dt_birth);
	}
	/**
	 * 民族id
	 * @return String
	 */
	public String getId_nation() {
		return ((String) getAttrVal("Id_nation"));
	}	
	/**
	 * 民族id
	 * @param Id_nation
	 */
	public void setId_nation(String Id_nation) {
		setAttrVal("Id_nation", Id_nation);
	}
	/**
	 * 民族编码
	 * @return String
	 */
	public String getSd_nation() {
		return ((String) getAttrVal("Sd_nation"));
	}	
	/**
	 * 民族编码
	 * @param Sd_nation
	 */
	public void setSd_nation(String Sd_nation) {
		setAttrVal("Sd_nation", Sd_nation);
	}
	/**
	 * 户口所在地
	 * @return String
	 */
	public String getAdd_house() {
		return ((String) getAttrVal("Add_house"));
	}	
	/**
	 * 户口所在地
	 * @param Add_house
	 */
	public void setAdd_house(String Add_house) {
		setAttrVal("Add_house", Add_house);
	}
	/**
	 * 到院日期
	 * @return FDate
	 */
	public FDate getDt_in() {
		return ((FDate) getAttrVal("Dt_in"));
	}	
	/**
	 * 到院日期
	 * @param Dt_in
	 */
	public void setDt_in(FDate Dt_in) {
		setAttrVal("Dt_in", Dt_in);
	}
	/**
	 * 结束日期
	 * @return FDate
	 */
	public FDate getDt_end() {
		return ((FDate) getAttrVal("Dt_end"));
	}	
	/**
	 * 结束日期
	 * @param Dt_end
	 */
	public void setDt_end(FDate Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 籍贯
	 * @return String
	 */
	public String getBth_place() {
		return ((String) getAttrVal("Bth_place"));
	}	
	/**
	 * 籍贯
	 * @param Bth_place
	 */
	public void setBth_place(String Bth_place) {
		setAttrVal("Bth_place", Bth_place);
	}
	/**
	 * 身高
	 * @return Integer
	 */
	public Integer getHeight() {
		return ((Integer) getAttrVal("Height"));
	}	
	/**
	 * 身高
	 * @param Height
	 */
	public void setHeight(Integer Height) {
		setAttrVal("Height", Height);
	}
	/**
	 * 院校
	 * @return String
	 */
	public String getId_nit_sro() {
		return ((String) getAttrVal("Id_nit_sro"));
	}	
	/**
	 * 院校
	 * @param Id_nit_sro
	 */
	public void setId_nit_sro(String Id_nit_sro) {
		setAttrVal("Id_nit_sro", Id_nit_sro);
	}
	/**
	 * 批次
	 * @return String
	 */
	public String getId_nit_sro_bch() {
		return ((String) getAttrVal("Id_nit_sro_bch"));
	}	
	/**
	 * 批次
	 * @param Id_nit_sro_bch
	 */
	public void setId_nit_sro_bch(String Id_nit_sro_bch) {
		setAttrVal("Id_nit_sro_bch", Id_nit_sro_bch);
	}
	/**
	 * 护士鞋号
	 * @return FDouble
	 */
	public FDouble getShoe_size() {
		return ((FDouble) getAttrVal("Shoe_size"));
	}	
	/**
	 * 护士鞋号
	 * @param Shoe_size
	 */
	public void setShoe_size(FDouble Shoe_size) {
		setAttrVal("Shoe_size", Shoe_size);
	}
	/**
	 * 外语等级id
	 * @return String
	 */
	public String getId_flang_lvl() {
		return ((String) getAttrVal("Id_flang_lvl"));
	}	
	/**
	 * 外语等级id
	 * @param Id_flang_lvl
	 */
	public void setId_flang_lvl(String Id_flang_lvl) {
		setAttrVal("Id_flang_lvl", Id_flang_lvl);
	}
	/**
	 * 外语等级编码
	 * @return String
	 */
	public String getSd_flang_lvl() {
		return ((String) getAttrVal("Sd_flang_lvl"));
	}	
	/**
	 * 外语等级编码
	 * @param Sd_flang_lvl
	 */
	public void setSd_flang_lvl(String Sd_flang_lvl) {
		setAttrVal("Sd_flang_lvl", Sd_flang_lvl);
	}
	/**
	 * 护士层级id
	 * @return String
	 */
	public String getId_nur_lvl() {
		return ((String) getAttrVal("Id_nur_lvl"));
	}	
	/**
	 * 护士层级id
	 * @param Id_nur_lvl
	 */
	public void setId_nur_lvl(String Id_nur_lvl) {
		setAttrVal("Id_nur_lvl", Id_nur_lvl);
	}
	/**
	 * 护士层级编码
	 * @return String
	 */
	public String getSd_nur_lvl() {
		return ((String) getAttrVal("Sd_nur_lvl"));
	}	
	/**
	 * 护士层级编码
	 * @param Sd_nur_lvl
	 */
	public void setSd_nur_lvl(String Sd_nur_lvl) {
		setAttrVal("Sd_nur_lvl", Sd_nur_lvl);
	}
	/**
	 * 注销原因id
	 * @return String
	 */
	public String getId_out_reas() {
		return ((String) getAttrVal("Id_out_reas"));
	}	
	/**
	 * 注销原因id
	 * @param Id_out_reas
	 */
	public void setId_out_reas(String Id_out_reas) {
		setAttrVal("Id_out_reas", Id_out_reas);
	}
	/**
	 * 注销原因编码
	 * @return String
	 */
	public String getSd_out_reas() {
		return ((String) getAttrVal("Sd_out_reas"));
	}	
	/**
	 * 注销原因编码
	 * @param Sd_out_reas
	 */
	public void setSd_out_reas(String Sd_out_reas) {
		setAttrVal("Sd_out_reas", Sd_out_reas);
	}
	/**
	 * 手机号码
	 * @return String
	 */
	public String getTel() {
		return ((String) getAttrVal("Tel"));
	}	
	/**
	 * 手机号码
	 * @param Tel
	 */
	public void setTel(String Tel) {
		setAttrVal("Tel", Tel);
	}
	/**
	 * 邮箱
	 * @return String
	 */
	public String getEmail() {
		return ((String) getAttrVal("Email"));
	}	
	/**
	 * 邮箱
	 * @param Email
	 */
	public void setEmail(String Email) {
		setAttrVal("Email", Email);
	}
	/**
	 * 家庭地址
	 * @return String
	 */
	public String getAddress() {
		return ((String) getAttrVal("Address"));
	}	
	/**
	 * 家庭地址
	 * @param Address
	 */
	public void setAddress(String Address) {
		setAttrVal("Address", Address);
	}
	/**
	 * 护理单元
	 * @return String
	 */
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}	
	/**
	 * 护理单元
	 * @param Id_dep_nur
	 */
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	/**
	 * 毕业去向
	 * @return String
	 */
	public String getGrad_to() {
		return ((String) getAttrVal("Grad_to"));
	}	
	/**
	 * 毕业去向
	 * @param Grad_to
	 */
	public void setGrad_to(String Grad_to) {
		setAttrVal("Grad_to", Grad_to);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 备注
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
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
	 * 组织名称
	 * @return String
	 */
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}	
	/**
	 * 组织名称
	 * @param Name_org
	 */
	public void setName_org(String Name_org) {
		setAttrVal("Name_org", Name_org);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_grp() {
		return ((String) getAttrVal("Name_grp"));
	}	
	/**
	 * 名称
	 * @param Name_grp
	 */
	public void setName_grp(String Name_grp) {
		setAttrVal("Name_grp", Name_grp);
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
	 * 名称
	 * @return String
	 */
	public String getName_wkca() {
		return ((String) getAttrVal("Name_wkca"));
	}	
	/**
	 * 名称
	 * @param Name_wkca
	 */
	public void setName_wkca(String Name_wkca) {
		setAttrVal("Name_wkca", Name_wkca);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_nation() {
		return ((String) getAttrVal("Name_nation"));
	}	
	/**
	 * 名称
	 * @param Name_nation
	 */
	public void setName_nation(String Name_nation) {
		setAttrVal("Name_nation", Name_nation);
	}
	/**
	 * 院校
	 * @return String
	 */
	public String getName_nit_sro() {
		return ((String) getAttrVal("Name_nit_sro"));
	}	
	/**
	 * 院校
	 * @param Name_nit_sro
	 */
	public void setName_nit_sro(String Name_nit_sro) {
		setAttrVal("Name_nit_sro", Name_nit_sro);
	}
	/**
	 * 批次
	 * @return String
	 */
	public String getName_nit_sro_bch() {
		return ((String) getAttrVal("Name_nit_sro_bch"));
	}	
	/**
	 * 批次
	 * @param Name_nit_sro_bch
	 */
	public void setName_nit_sro_bch(String Name_nit_sro_bch) {
		setAttrVal("Name_nit_sro_bch", Name_nit_sro_bch);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_flang_lvl() {
		return ((String) getAttrVal("Name_flang_lvl"));
	}	
	/**
	 * 名称
	 * @param Name_flang_lvl
	 */
	public void setName_flang_lvl(String Name_flang_lvl) {
		setAttrVal("Name_flang_lvl", Name_flang_lvl);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_nur_lvl() {
		return ((String) getAttrVal("Name_nur_lvl"));
	}	
	/**
	 * 名称
	 * @param Name_nur_lvl
	 */
	public void setName_nur_lvl(String Name_nur_lvl) {
		setAttrVal("Name_nur_lvl", Name_nur_lvl);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_out_reas() {
		return ((String) getAttrVal("Name_out_reas"));
	}	
	/**
	 * 名称
	 * @param Name_out_reas
	 */
	public void setName_out_reas(String Name_out_reas) {
		setAttrVal("Name_out_reas", Name_out_reas);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_dep_nur() {
		return ((String) getAttrVal("Name_dep_nur"));
	}	
	/**
	 * 名称
	 * @param Name_dep_nur
	 */
	public void setName_dep_nur(String Name_dep_nur) {
		setAttrVal("Name_dep_nur", Name_dep_nur);
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
		return "Id_nit_psninfo";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NIT_PSNINFO";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NitPsnInfoDODesc.class);
	}
	
}