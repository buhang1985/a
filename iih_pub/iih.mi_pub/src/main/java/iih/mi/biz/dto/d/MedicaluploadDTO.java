package iih.mi.biz.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 病案首页-西医 DTO数据 
 * 
 */
public class MedicaluploadDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 住院号
	 * @return String
	 */
	public String getZyh() {
		return ((String) getAttrVal("Zyh"));
	}
	/**
	 * 住院号
	 * @param Zyh
	 */
	public void setZyh(String Zyh) {
		setAttrVal("Zyh", Zyh);
	}
	/**
	 * 医疗机构名称
	 * @return String
	 */
	public String getHdsd00_11_118() {
		return ((String) getAttrVal("Hdsd00_11_118"));
	}
	/**
	 * 医疗机构名称
	 * @param Hdsd00_11_118
	 */
	public void setHdsd00_11_118(String Hdsd00_11_118) {
		setAttrVal("Hdsd00_11_118", Hdsd00_11_118);
	}
	/**
	 * 医疗结构组织机构代码
	 * @return String
	 */
	public String getHdsd00_11_119() {
		return ((String) getAttrVal("Hdsd00_11_119"));
	}
	/**
	 * 医疗结构组织机构代码
	 * @param Hdsd00_11_119
	 */
	public void setHdsd00_11_119(String Hdsd00_11_119) {
		setAttrVal("Hdsd00_11_119", Hdsd00_11_119);
	}
	/**
	 * 医疗付费方式代码
	 * @return String
	 */
	public String getHdsd00_11_117() {
		return ((String) getAttrVal("Hdsd00_11_117"));
	}
	/**
	 * 医疗付费方式代码
	 * @param Hdsd00_11_117
	 */
	public void setHdsd00_11_117(String Hdsd00_11_117) {
		setAttrVal("Hdsd00_11_117", Hdsd00_11_117);
	}
	/**
	 * 居民健康卡号
	 * @return String
	 */
	public String getHdsd00_11_053() {
		return ((String) getAttrVal("Hdsd00_11_053"));
	}
	/**
	 * 居民健康卡号
	 * @param Hdsd00_11_053
	 */
	public void setHdsd00_11_053(String Hdsd00_11_053) {
		setAttrVal("Hdsd00_11_053", Hdsd00_11_053);
	}
	/**
	 * 住院次数
	 * @return String
	 */
	public String getHdsd00_11_139() {
		return ((String) getAttrVal("Hdsd00_11_139"));
	}
	/**
	 * 住院次数
	 * @param Hdsd00_11_139
	 */
	public void setHdsd00_11_139(String Hdsd00_11_139) {
		setAttrVal("Hdsd00_11_139", Hdsd00_11_139);
	}
	/**
	 * HIS系统住院号
	 * @return String
	 */
	public String getHdsd00_11_140() {
		return ((String) getAttrVal("Hdsd00_11_140"));
	}
	/**
	 * HIS系统住院号
	 * @param Hdsd00_11_140
	 */
	public void setHdsd00_11_140(String Hdsd00_11_140) {
		setAttrVal("Hdsd00_11_140", Hdsd00_11_140);
	}
	/**
	 * 病案号
	 * @return String
	 */
	public String getHdsd00_11_006() {
		return ((String) getAttrVal("Hdsd00_11_006"));
	}
	/**
	 * 病案号
	 * @param Hdsd00_11_006
	 */
	public void setHdsd00_11_006(String Hdsd00_11_006) {
		setAttrVal("Hdsd00_11_006", Hdsd00_11_006);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getHdsd00_11_110() {
		return ((String) getAttrVal("Hdsd00_11_110"));
	}
	/**
	 * 姓名
	 * @param Hdsd00_11_110
	 */
	public void setHdsd00_11_110(String Hdsd00_11_110) {
		setAttrVal("Hdsd00_11_110", Hdsd00_11_110);
	}
	/**
	 * 性别代码
	 * @return String
	 */
	public String getHdsd00_11_109() {
		return ((String) getAttrVal("Hdsd00_11_109"));
	}
	/**
	 * 性别代码
	 * @param Hdsd00_11_109
	 */
	public void setHdsd00_11_109(String Hdsd00_11_109) {
		setAttrVal("Hdsd00_11_109", Hdsd00_11_109);
	}
	/**
	 * 出生日期
	 * @return String
	 */
	public String getHdsd00_11_014() {
		return ((String) getAttrVal("Hdsd00_11_014"));
	}
	/**
	 * 出生日期
	 * @param Hdsd00_11_014
	 */
	public void setHdsd00_11_014(String Hdsd00_11_014) {
		setAttrVal("Hdsd00_11_014", Hdsd00_11_014);
	}
	/**
	 * 年龄(岁)
	 * @return String
	 */
	public String getHdsd00_11_079() {
		return ((String) getAttrVal("Hdsd00_11_079"));
	}
	/**
	 * 年龄(岁)
	 * @param Hdsd00_11_079
	 */
	public void setHdsd00_11_079(String Hdsd00_11_079) {
		setAttrVal("Hdsd00_11_079", Hdsd00_11_079);
	}
	/**
	 * 年龄(月)
	 * @return String
	 */
	public String getHdsd00_11_080() {
		return ((String) getAttrVal("Hdsd00_11_080"));
	}
	/**
	 * 年龄(月)
	 * @param Hdsd00_11_080
	 */
	public void setHdsd00_11_080(String Hdsd00_11_080) {
		setAttrVal("Hdsd00_11_080", Hdsd00_11_080);
	}
	/**
	 * 国籍代码
	 * @return String
	 */
	public String getHdsd00_11_036() {
		return ((String) getAttrVal("Hdsd00_11_036"));
	}
	/**
	 * 国籍代码
	 * @param Hdsd00_11_036
	 */
	public void setHdsd00_11_036(String Hdsd00_11_036) {
		setAttrVal("Hdsd00_11_036", Hdsd00_11_036);
	}
	/**
	 * 新生儿出生体重
	 * @return String
	 */
	public String getHdsd00_11_107() {
		return ((String) getAttrVal("Hdsd00_11_107"));
	}
	/**
	 * 新生儿出生体重
	 * @param Hdsd00_11_107
	 */
	public void setHdsd00_11_107(String Hdsd00_11_107) {
		setAttrVal("Hdsd00_11_107", Hdsd00_11_107);
	}
	/**
	 * 新生儿入院体重
	 * @return String
	 */
	public String getHdsd00_11_108() {
		return ((String) getAttrVal("Hdsd00_11_108"));
	}
	/**
	 * 新生儿入院体重
	 * @param Hdsd00_11_108
	 */
	public void setHdsd00_11_108(String Hdsd00_11_108) {
		setAttrVal("Hdsd00_11_108", Hdsd00_11_108);
	}
	/**
	 * 出生地-省
	 * @return String
	 */
	public String getHdsd00_11_011() {
		return ((String) getAttrVal("Hdsd00_11_011"));
	}
	/**
	 * 出生地-省
	 * @param Hdsd00_11_011
	 */
	public void setHdsd00_11_011(String Hdsd00_11_011) {
		setAttrVal("Hdsd00_11_011", Hdsd00_11_011);
	}
	/**
	 * 出生地-市
	 * @return String
	 */
	public String getHdsd00_11_012() {
		return ((String) getAttrVal("Hdsd00_11_012"));
	}
	/**
	 * 出生地-市
	 * @param Hdsd00_11_012
	 */
	public void setHdsd00_11_012(String Hdsd00_11_012) {
		setAttrVal("Hdsd00_11_012", Hdsd00_11_012);
	}
	/**
	 * 出生地-县
	 * @return String
	 */
	public String getHdsd00_11_013() {
		return ((String) getAttrVal("Hdsd00_11_013"));
	}
	/**
	 * 出生地-县
	 * @param Hdsd00_11_013
	 */
	public void setHdsd00_11_013(String Hdsd00_11_013) {
		setAttrVal("Hdsd00_11_013", Hdsd00_11_013);
	}
	/**
	 * 籍贯-省
	 * @return String
	 */
	public String getHdsd00_11_051() {
		return ((String) getAttrVal("Hdsd00_11_051"));
	}
	/**
	 * 籍贯-省
	 * @param Hdsd00_11_051
	 */
	public void setHdsd00_11_051(String Hdsd00_11_051) {
		setAttrVal("Hdsd00_11_051", Hdsd00_11_051);
	}
	/**
	 * 籍贯-市
	 * @return String
	 */
	public String getHdsd00_11_052() {
		return ((String) getAttrVal("Hdsd00_11_052"));
	}
	/**
	 * 籍贯-市
	 * @param Hdsd00_11_052
	 */
	public void setHdsd00_11_052(String Hdsd00_11_052) {
		setAttrVal("Hdsd00_11_052", Hdsd00_11_052);
	}
	/**
	 * 民族
	 * @return String
	 */
	public String getHdsd00_11_077() {
		return ((String) getAttrVal("Hdsd00_11_077"));
	}
	/**
	 * 民族
	 * @param Hdsd00_11_077
	 */
	public void setHdsd00_11_077(String Hdsd00_11_077) {
		setAttrVal("Hdsd00_11_077", Hdsd00_11_077);
	}
	/**
	 * 身份证件类别代码
	 * @return String
	 */
	public String getHdsd00_11_049() {
		return ((String) getAttrVal("Hdsd00_11_049"));
	}
	/**
	 * 身份证件类别代码
	 * @param Hdsd00_11_049
	 */
	public void setHdsd00_11_049(String Hdsd00_11_049) {
		setAttrVal("Hdsd00_11_049", Hdsd00_11_049);
	}
	/**
	 * 患者身份证件号码
	 * @return String
	 */
	public String getHdsd00_11_048() {
		return ((String) getAttrVal("Hdsd00_11_048"));
	}
	/**
	 * 患者身份证件号码
	 * @param Hdsd00_11_048
	 */
	public void setHdsd00_11_048(String Hdsd00_11_048) {
		setAttrVal("Hdsd00_11_048", Hdsd00_11_048);
	}
	/**
	 * 职业类别代码
	 * @return String
	 */
	public String getHdsd00_11_125() {
		return ((String) getAttrVal("Hdsd00_11_125"));
	}
	/**
	 * 职业类别代码
	 * @param Hdsd00_11_125
	 */
	public void setHdsd00_11_125(String Hdsd00_11_125) {
		setAttrVal("Hdsd00_11_125", Hdsd00_11_125);
	}
	/**
	 * 婚姻状况代码
	 * @return String
	 */
	public String getHdsd00_11_050() {
		return ((String) getAttrVal("Hdsd00_11_050"));
	}
	/**
	 * 婚姻状况代码
	 * @param Hdsd00_11_050
	 */
	public void setHdsd00_11_050(String Hdsd00_11_050) {
		setAttrVal("Hdsd00_11_050", Hdsd00_11_050);
	}
	/**
	 * 现住址-省
	 * @return String
	 */
	public String getHdsd00_11_102() {
		return ((String) getAttrVal("Hdsd00_11_102"));
	}
	/**
	 * 现住址-省
	 * @param Hdsd00_11_102
	 */
	public void setHdsd00_11_102(String Hdsd00_11_102) {
		setAttrVal("Hdsd00_11_102", Hdsd00_11_102);
	}
	/**
	 * 现住址-市
	 * @return String
	 */
	public String getHdsd00_11_103() {
		return ((String) getAttrVal("Hdsd00_11_103"));
	}
	/**
	 * 现住址-市
	 * @param Hdsd00_11_103
	 */
	public void setHdsd00_11_103(String Hdsd00_11_103) {
		setAttrVal("Hdsd00_11_103", Hdsd00_11_103);
	}
	/**
	 * 现住址-县
	 * @return String
	 */
	public String getHdsd00_11_104() {
		return ((String) getAttrVal("Hdsd00_11_104"));
	}
	/**
	 * 现住址-县
	 * @param Hdsd00_11_104
	 */
	public void setHdsd00_11_104(String Hdsd00_11_104) {
		setAttrVal("Hdsd00_11_104", Hdsd00_11_104);
	}
	/**
	 * 现住址-乡
	 * @return String
	 */
	public String getHdsd00_11_105() {
		return ((String) getAttrVal("Hdsd00_11_105"));
	}
	/**
	 * 现住址-乡
	 * @param Hdsd00_11_105
	 */
	public void setHdsd00_11_105(String Hdsd00_11_105) {
		setAttrVal("Hdsd00_11_105", Hdsd00_11_105);
	}
	/**
	 * 现住址-村
	 * @return String
	 */
	public String getHdsd00_11_100() {
		return ((String) getAttrVal("Hdsd00_11_100"));
	}
	/**
	 * 现住址-村
	 * @param Hdsd00_11_100
	 */
	public void setHdsd00_11_100(String Hdsd00_11_100) {
		setAttrVal("Hdsd00_11_100", Hdsd00_11_100);
	}
	/**
	 * 现住址-门牌号码
	 * @return String
	 */
	public String getHdsd00_11_101() {
		return ((String) getAttrVal("Hdsd00_11_101"));
	}
	/**
	 * 现住址-门牌号码
	 * @param Hdsd00_11_101
	 */
	public void setHdsd00_11_101(String Hdsd00_11_101) {
		setAttrVal("Hdsd00_11_101", Hdsd00_11_101);
	}
	/**
	 * 电话号码
	 * @return String
	 */
	public String getHdsd00_11_026() {
		return ((String) getAttrVal("Hdsd00_11_026"));
	}
	/**
	 * 电话号码
	 * @param Hdsd00_11_026
	 */
	public void setHdsd00_11_026(String Hdsd00_11_026) {
		setAttrVal("Hdsd00_11_026", Hdsd00_11_026);
	}
	/**
	 * 现住址-邮政编码
	 * @return String
	 */
	public String getHdsd00_11_106() {
		return ((String) getAttrVal("Hdsd00_11_106"));
	}
	/**
	 * 现住址-邮政编码
	 * @param Hdsd00_11_106
	 */
	public void setHdsd00_11_106(String Hdsd00_11_106) {
		setAttrVal("Hdsd00_11_106", Hdsd00_11_106);
	}
	/**
	 * 户口地址-省
	 * @return String
	 */
	public String getHdsd00_11_043() {
		return ((String) getAttrVal("Hdsd00_11_043"));
	}
	/**
	 * 户口地址-省
	 * @param Hdsd00_11_043
	 */
	public void setHdsd00_11_043(String Hdsd00_11_043) {
		setAttrVal("Hdsd00_11_043", Hdsd00_11_043);
	}
	/**
	 * 户口地址-市
	 * @return String
	 */
	public String getHdsd00_11_044() {
		return ((String) getAttrVal("Hdsd00_11_044"));
	}
	/**
	 * 户口地址-市
	 * @param Hdsd00_11_044
	 */
	public void setHdsd00_11_044(String Hdsd00_11_044) {
		setAttrVal("Hdsd00_11_044", Hdsd00_11_044);
	}
	/**
	 * 户口地址-县
	 * @return String
	 */
	public String getHdsd00_11_045() {
		return ((String) getAttrVal("Hdsd00_11_045"));
	}
	/**
	 * 户口地址-县
	 * @param Hdsd00_11_045
	 */
	public void setHdsd00_11_045(String Hdsd00_11_045) {
		setAttrVal("Hdsd00_11_045", Hdsd00_11_045);
	}
	/**
	 * 户口地址-乡
	 * @return String
	 */
	public String getHdsd00_11_046() {
		return ((String) getAttrVal("Hdsd00_11_046"));
	}
	/**
	 * 户口地址-乡
	 * @param Hdsd00_11_046
	 */
	public void setHdsd00_11_046(String Hdsd00_11_046) {
		setAttrVal("Hdsd00_11_046", Hdsd00_11_046);
	}
	/**
	 * 户口地址-村
	 * @return String
	 */
	public String getHdsd00_11_041() {
		return ((String) getAttrVal("Hdsd00_11_041"));
	}
	/**
	 * 户口地址-村
	 * @param Hdsd00_11_041
	 */
	public void setHdsd00_11_041(String Hdsd00_11_041) {
		setAttrVal("Hdsd00_11_041", Hdsd00_11_041);
	}
	/**
	 * 户口地址-门牌号码
	 * @return String
	 */
	public String getHdsd00_11_042() {
		return ((String) getAttrVal("Hdsd00_11_042"));
	}
	/**
	 * 户口地址-门牌号码
	 * @param Hdsd00_11_042
	 */
	public void setHdsd00_11_042(String Hdsd00_11_042) {
		setAttrVal("Hdsd00_11_042", Hdsd00_11_042);
	}
	/**
	 * 户口地址-邮政编码
	 * @return String
	 */
	public String getHdsd00_11_047() {
		return ((String) getAttrVal("Hdsd00_11_047"));
	}
	/**
	 * 户口地址-邮政编码
	 * @param Hdsd00_11_047
	 */
	public void setHdsd00_11_047(String Hdsd00_11_047) {
		setAttrVal("Hdsd00_11_047", Hdsd00_11_047);
	}
	/**
	 * 工作单位名称
	 * @return String
	 */
	public String getHdsd00_11_035() {
		return ((String) getAttrVal("Hdsd00_11_035"));
	}
	/**
	 * 工作单位名称
	 * @param Hdsd00_11_035
	 */
	public void setHdsd00_11_035(String Hdsd00_11_035) {
		setAttrVal("Hdsd00_11_035", Hdsd00_11_035);
	}
	/**
	 * 工作单位地址-省
	 * @return String
	 */
	public String getHdsd00_11_029() {
		return ((String) getAttrVal("Hdsd00_11_029"));
	}
	/**
	 * 工作单位地址-省
	 * @param Hdsd00_11_029
	 */
	public void setHdsd00_11_029(String Hdsd00_11_029) {
		setAttrVal("Hdsd00_11_029", Hdsd00_11_029);
	}
	/**
	 * 工作单位地址-市
	 * @return String
	 */
	public String getHdsd00_11_030() {
		return ((String) getAttrVal("Hdsd00_11_030"));
	}
	/**
	 * 工作单位地址-市
	 * @param Hdsd00_11_030
	 */
	public void setHdsd00_11_030(String Hdsd00_11_030) {
		setAttrVal("Hdsd00_11_030", Hdsd00_11_030);
	}
	/**
	 * 工作单位地址-县
	 * @return String
	 */
	public String getHdsd00_11_031() {
		return ((String) getAttrVal("Hdsd00_11_031"));
	}
	/**
	 * 工作单位地址-县
	 * @param Hdsd00_11_031
	 */
	public void setHdsd00_11_031(String Hdsd00_11_031) {
		setAttrVal("Hdsd00_11_031", Hdsd00_11_031);
	}
	/**
	 * 工作单位地址-乡
	 * @return String
	 */
	public String getHdsd00_11_032() {
		return ((String) getAttrVal("Hdsd00_11_032"));
	}
	/**
	 * 工作单位地址-乡
	 * @param Hdsd00_11_032
	 */
	public void setHdsd00_11_032(String Hdsd00_11_032) {
		setAttrVal("Hdsd00_11_032", Hdsd00_11_032);
	}
	/**
	 * 工作单位地址-村
	 * @return String
	 */
	public String getHdsd00_11_027() {
		return ((String) getAttrVal("Hdsd00_11_027"));
	}
	/**
	 * 工作单位地址-村
	 * @param Hdsd00_11_027
	 */
	public void setHdsd00_11_027(String Hdsd00_11_027) {
		setAttrVal("Hdsd00_11_027", Hdsd00_11_027);
	}
	/**
	 * 工作单位地址-门牌号码
	 * @return String
	 */
	public String getHdsd00_11_028() {
		return ((String) getAttrVal("Hdsd00_11_028"));
	}
	/**
	 * 工作单位地址-门牌号码
	 * @param Hdsd00_11_028
	 */
	public void setHdsd00_11_028(String Hdsd00_11_028) {
		setAttrVal("Hdsd00_11_028", Hdsd00_11_028);
	}
	/**
	 * 工作单位电话号码
	 * @return String
	 */
	public String getHdsd00_11_034() {
		return ((String) getAttrVal("Hdsd00_11_034"));
	}
	/**
	 * 工作单位电话号码
	 * @param Hdsd00_11_034
	 */
	public void setHdsd00_11_034(String Hdsd00_11_034) {
		setAttrVal("Hdsd00_11_034", Hdsd00_11_034);
	}
	/**
	 * 工作单位地址-邮政编码
	 * @return String
	 */
	public String getHdsd00_11_033() {
		return ((String) getAttrVal("Hdsd00_11_033"));
	}
	/**
	 * 工作单位地址-邮政编码
	 * @param Hdsd00_11_033
	 */
	public void setHdsd00_11_033(String Hdsd00_11_033) {
		setAttrVal("Hdsd00_11_033", Hdsd00_11_033);
	}
	/**
	 * 联系人姓名
	 * @return String
	 */
	public String getHdsd00_11_065() {
		return ((String) getAttrVal("Hdsd00_11_065"));
	}
	/**
	 * 联系人姓名
	 * @param Hdsd00_11_065
	 */
	public void setHdsd00_11_065(String Hdsd00_11_065) {
		setAttrVal("Hdsd00_11_065", Hdsd00_11_065);
	}
	/**
	 * 联系人与患者的关系代码
	 * @return String
	 */
	public String getHdsd00_11_066() {
		return ((String) getAttrVal("Hdsd00_11_066"));
	}
	/**
	 * 联系人与患者的关系代码
	 * @param Hdsd00_11_066
	 */
	public void setHdsd00_11_066(String Hdsd00_11_066) {
		setAttrVal("Hdsd00_11_066", Hdsd00_11_066);
	}
	/**
	 * 联系人地址-省
	 * @return String
	 */
	public String getHdsd00_11_060() {
		return ((String) getAttrVal("Hdsd00_11_060"));
	}
	/**
	 * 联系人地址-省
	 * @param Hdsd00_11_060
	 */
	public void setHdsd00_11_060(String Hdsd00_11_060) {
		setAttrVal("Hdsd00_11_060", Hdsd00_11_060);
	}
	/**
	 * 联系人地址-市
	 * @return String
	 */
	public String getHdsd00_11_061() {
		return ((String) getAttrVal("Hdsd00_11_061"));
	}
	/**
	 * 联系人地址-市
	 * @param Hdsd00_11_061
	 */
	public void setHdsd00_11_061(String Hdsd00_11_061) {
		setAttrVal("Hdsd00_11_061", Hdsd00_11_061);
	}
	/**
	 * 联系人地址-县
	 * @return String
	 */
	public String getHdsd00_11_062() {
		return ((String) getAttrVal("Hdsd00_11_062"));
	}
	/**
	 * 联系人地址-县
	 * @param Hdsd00_11_062
	 */
	public void setHdsd00_11_062(String Hdsd00_11_062) {
		setAttrVal("Hdsd00_11_062", Hdsd00_11_062);
	}
	/**
	 * 联系人地址-乡
	 * @return String
	 */
	public String getHdsd00_11_063() {
		return ((String) getAttrVal("Hdsd00_11_063"));
	}
	/**
	 * 联系人地址-乡
	 * @param Hdsd00_11_063
	 */
	public void setHdsd00_11_063(String Hdsd00_11_063) {
		setAttrVal("Hdsd00_11_063", Hdsd00_11_063);
	}
	/**
	 * 联系人地址-村
	 * @return String
	 */
	public String getHdsd00_11_058() {
		return ((String) getAttrVal("Hdsd00_11_058"));
	}
	/**
	 * 联系人地址-村
	 * @param Hdsd00_11_058
	 */
	public void setHdsd00_11_058(String Hdsd00_11_058) {
		setAttrVal("Hdsd00_11_058", Hdsd00_11_058);
	}
	/**
	 * 联系人地址-门牌号码
	 * @return String
	 */
	public String getHdsd00_11_059() {
		return ((String) getAttrVal("Hdsd00_11_059"));
	}
	/**
	 * 联系人地址-门牌号码
	 * @param Hdsd00_11_059
	 */
	public void setHdsd00_11_059(String Hdsd00_11_059) {
		setAttrVal("Hdsd00_11_059", Hdsd00_11_059);
	}
	/**
	 * 联系人电话号码
	 * @return String
	 */
	public String getHdsd00_11_064() {
		return ((String) getAttrVal("Hdsd00_11_064"));
	}
	/**
	 * 联系人电话号码
	 * @param Hdsd00_11_064
	 */
	public void setHdsd00_11_064(String Hdsd00_11_064) {
		setAttrVal("Hdsd00_11_064", Hdsd00_11_064);
	}
	/**
	 * 入院途径代码
	 * @return String
	 */
	public String getHdsd00_11_086() {
		return ((String) getAttrVal("Hdsd00_11_086"));
	}
	/**
	 * 入院途径代码
	 * @param Hdsd00_11_086
	 */
	public void setHdsd00_11_086(String Hdsd00_11_086) {
		setAttrVal("Hdsd00_11_086", Hdsd00_11_086);
	}
	/**
	 * 入院日期时间
	 * @return String
	 */
	public String getHdsd00_11_085() {
		return ((String) getAttrVal("Hdsd00_11_085"));
	}
	/**
	 * 入院日期时间
	 * @param Hdsd00_11_085
	 */
	public void setHdsd00_11_085(String Hdsd00_11_085) {
		setAttrVal("Hdsd00_11_085", Hdsd00_11_085);
	}
	/**
	 * 入院科别
	 * @return String
	 */
	public String getHdsd00_11_084() {
		return ((String) getAttrVal("Hdsd00_11_084"));
	}
	/**
	 * 入院科别
	 * @param Hdsd00_11_084
	 */
	public void setHdsd00_11_084(String Hdsd00_11_084) {
		setAttrVal("Hdsd00_11_084", Hdsd00_11_084);
	}
	/**
	 * 入院病房
	 * @return String
	 */
	public String getHdsd00_11_083() {
		return ((String) getAttrVal("Hdsd00_11_083"));
	}
	/**
	 * 入院病房
	 * @param Hdsd00_11_083
	 */
	public void setHdsd00_11_083(String Hdsd00_11_083) {
		setAttrVal("Hdsd00_11_083", Hdsd00_11_083);
	}
	/**
	 * 转科科别
	 * @return String
	 */
	public String getHdsd00_11_144() {
		return ((String) getAttrVal("Hdsd00_11_144"));
	}
	/**
	 * 转科科别
	 * @param Hdsd00_11_144
	 */
	public void setHdsd00_11_144(String Hdsd00_11_144) {
		setAttrVal("Hdsd00_11_144", Hdsd00_11_144);
	}
	/**
	 * 出院日期时间
	 * @return String
	 */
	public String getHdsd00_11_019() {
		return ((String) getAttrVal("Hdsd00_11_019"));
	}
	/**
	 * 出院日期时间
	 * @param Hdsd00_11_019
	 */
	public void setHdsd00_11_019(String Hdsd00_11_019) {
		setAttrVal("Hdsd00_11_019", Hdsd00_11_019);
	}
	/**
	 * 出院科别
	 * @return String
	 */
	public String getHdsd00_11_018() {
		return ((String) getAttrVal("Hdsd00_11_018"));
	}
	/**
	 * 出院科别
	 * @param Hdsd00_11_018
	 */
	public void setHdsd00_11_018(String Hdsd00_11_018) {
		setAttrVal("Hdsd00_11_018", Hdsd00_11_018);
	}
	/**
	 * 出院病房
	 * @return String
	 */
	public String getHdsd00_11_017() {
		return ((String) getAttrVal("Hdsd00_11_017"));
	}
	/**
	 * 出院病房
	 * @param Hdsd00_11_017
	 */
	public void setHdsd00_11_017(String Hdsd00_11_017) {
		setAttrVal("Hdsd00_11_017", Hdsd00_11_017);
	}
	/**
	 * 实际住院天数
	 * @return String
	 */
	public String getHdsd00_11_087() {
		return ((String) getAttrVal("Hdsd00_11_087"));
	}
	/**
	 * 实际住院天数
	 * @param Hdsd00_11_087
	 */
	public void setHdsd00_11_087(String Hdsd00_11_087) {
		setAttrVal("Hdsd00_11_087", Hdsd00_11_087);
	}
	/**
	 * 门(急)诊诊断名称
	 * @return String
	 */
	public String getHdsd00_11_076() {
		return ((String) getAttrVal("Hdsd00_11_076"));
	}
	/**
	 * 门(急)诊诊断名称
	 * @param Hdsd00_11_076
	 */
	public void setHdsd00_11_076(String Hdsd00_11_076) {
		setAttrVal("Hdsd00_11_076", Hdsd00_11_076);
	}
	/**
	 * 门(急)诊诊断疾病代码
	 * @return String
	 */
	public String getHdsd00_11_075() {
		return ((String) getAttrVal("Hdsd00_11_075"));
	}
	/**
	 * 门(急)诊诊断疾病代码
	 * @param Hdsd00_11_075
	 */
	public void setHdsd00_11_075(String Hdsd00_11_075) {
		setAttrVal("Hdsd00_11_075", Hdsd00_11_075);
	}
	/**
	 * 出院诊断信息
	 * @return String
	 */
	public String getHdsd00_11_x01() {
		return ((String) getAttrVal("Hdsd00_11_x01"));
	}
	/**
	 * 出院诊断信息
	 * @param Hdsd00_11_x01
	 */
	public void setHdsd00_11_x01(String Hdsd00_11_x01) {
		setAttrVal("Hdsd00_11_x01", Hdsd00_11_x01);
	}
	/**
	 * 损伤中毒的外部原因
	 * @return String
	 */
	public String getHdsd00_11_096() {
		return ((String) getAttrVal("Hdsd00_11_096"));
	}
	/**
	 * 损伤中毒的外部原因
	 * @param Hdsd00_11_096
	 */
	public void setHdsd00_11_096(String Hdsd00_11_096) {
		setAttrVal("Hdsd00_11_096", Hdsd00_11_096);
	}
	/**
	 * 损伤中毒的外部原因疾病编码
	 * @return String
	 */
	public String getHdsd00_11_097() {
		return ((String) getAttrVal("Hdsd00_11_097"));
	}
	/**
	 * 损伤中毒的外部原因疾病编码
	 * @param Hdsd00_11_097
	 */
	public void setHdsd00_11_097(String Hdsd00_11_097) {
		setAttrVal("Hdsd00_11_097", Hdsd00_11_097);
	}
	/**
	 * 病理诊断名称
	 * @return String
	 */
	public String getHdsd00_11_010() {
		return ((String) getAttrVal("Hdsd00_11_010"));
	}
	/**
	 * 病理诊断名称
	 * @param Hdsd00_11_010
	 */
	public void setHdsd00_11_010(String Hdsd00_11_010) {
		setAttrVal("Hdsd00_11_010", Hdsd00_11_010);
	}
	/**
	 * 病理诊断疾病编码
	 * @return String
	 */
	public String getHdsd00_11_009() {
		return ((String) getAttrVal("Hdsd00_11_009"));
	}
	/**
	 * 病理诊断疾病编码
	 * @param Hdsd00_11_009
	 */
	public void setHdsd00_11_009(String Hdsd00_11_009) {
		setAttrVal("Hdsd00_11_009", Hdsd00_11_009);
	}
	/**
	 * 病理号
	 * @return String
	 */
	public String getHdsd00_11_008() {
		return ((String) getAttrVal("Hdsd00_11_008"));
	}
	/**
	 * 病理号
	 * @param Hdsd00_11_008
	 */
	public void setHdsd00_11_008(String Hdsd00_11_008) {
		setAttrVal("Hdsd00_11_008", Hdsd00_11_008);
	}
	/**
	 * 药物过敏标志
	 * @return String
	 */
	public String getHdsd00_11_116() {
		return ((String) getAttrVal("Hdsd00_11_116"));
	}
	/**
	 * 药物过敏标志
	 * @param Hdsd00_11_116
	 */
	public void setHdsd00_11_116(String Hdsd00_11_116) {
		setAttrVal("Hdsd00_11_116", Hdsd00_11_116);
	}
	/**
	 * 过敏药物
	 * @return String
	 */
	public String getHdsd00_11_037() {
		return ((String) getAttrVal("Hdsd00_11_037"));
	}
	/**
	 * 过敏药物
	 * @param Hdsd00_11_037
	 */
	public void setHdsd00_11_037(String Hdsd00_11_037) {
		setAttrVal("Hdsd00_11_037", Hdsd00_11_037);
	}
	/**
	 * 死亡患者尸检标志
	 * @return String
	 */
	public String getHdsd00_11_095() {
		return ((String) getAttrVal("Hdsd00_11_095"));
	}
	/**
	 * 死亡患者尸检标志
	 * @param Hdsd00_11_095
	 */
	public void setHdsd00_11_095(String Hdsd00_11_095) {
		setAttrVal("Hdsd00_11_095", Hdsd00_11_095);
	}
	/**
	 * ABO血型代码
	 * @return String
	 */
	public String getHdsd00_11_003() {
		return ((String) getAttrVal("Hdsd00_11_003"));
	}
	/**
	 * ABO血型代码
	 * @param Hdsd00_11_003
	 */
	public void setHdsd00_11_003(String Hdsd00_11_003) {
		setAttrVal("Hdsd00_11_003", Hdsd00_11_003);
	}
	/**
	 * Rh血型代码
	 * @return String
	 */
	public String getHdsd00_11_004() {
		return ((String) getAttrVal("Hdsd00_11_004"));
	}
	/**
	 * Rh血型代码
	 * @param Hdsd00_11_004
	 */
	public void setHdsd00_11_004(String Hdsd00_11_004) {
		setAttrVal("Hdsd00_11_004", Hdsd00_11_004);
	}
	/**
	 * 科主任签名
	 * @return String
	 */
	public String getHdsd00_11_056() {
		return ((String) getAttrVal("Hdsd00_11_056"));
	}
	/**
	 * 科主任签名
	 * @param Hdsd00_11_056
	 */
	public void setHdsd00_11_056(String Hdsd00_11_056) {
		setAttrVal("Hdsd00_11_056", Hdsd00_11_056);
	}
	/**
	 * 主任(副主任)医师签名
	 * @return String
	 */
	public String getHdsd00_11_137() {
		return ((String) getAttrVal("Hdsd00_11_137"));
	}
	/**
	 * 主任(副主任)医师签名
	 * @param Hdsd00_11_137
	 */
	public void setHdsd00_11_137(String Hdsd00_11_137) {
		setAttrVal("Hdsd00_11_137", Hdsd00_11_137);
	}
	/**
	 * 主治医师签名
	 * @return String
	 */
	public String getHdsd00_11_138() {
		return ((String) getAttrVal("Hdsd00_11_138"));
	}
	/**
	 * 主治医师签名
	 * @param Hdsd00_11_138
	 */
	public void setHdsd00_11_138(String Hdsd00_11_138) {
		setAttrVal("Hdsd00_11_138", Hdsd00_11_138);
	}
	/**
	 * 住院医师签名
	 * @return String
	 */
	public String getHdsd00_11_141() {
		return ((String) getAttrVal("Hdsd00_11_141"));
	}
	/**
	 * 住院医师签名
	 * @param Hdsd00_11_141
	 */
	public void setHdsd00_11_141(String Hdsd00_11_141) {
		setAttrVal("Hdsd00_11_141", Hdsd00_11_141);
	}
	/**
	 * 责任护士签名
	 * @return String
	 */
	public String getHdsd00_11_120() {
		return ((String) getAttrVal("Hdsd00_11_120"));
	}
	/**
	 * 责任护士签名
	 * @param Hdsd00_11_120
	 */
	public void setHdsd00_11_120(String Hdsd00_11_120) {
		setAttrVal("Hdsd00_11_120", Hdsd00_11_120);
	}
	/**
	 * 进修医师签名
	 * @return String
	 */
	public String getHdsd00_11_054() {
		return ((String) getAttrVal("Hdsd00_11_054"));
	}
	/**
	 * 进修医师签名
	 * @param Hdsd00_11_054
	 */
	public void setHdsd00_11_054(String Hdsd00_11_054) {
		setAttrVal("Hdsd00_11_054", Hdsd00_11_054);
	}
	/**
	 * 实习医师签名
	 * @return String
	 */
	public String getHdsd00_11_088() {
		return ((String) getAttrVal("Hdsd00_11_088"));
	}
	/**
	 * 实习医师签名
	 * @param Hdsd00_11_088
	 */
	public void setHdsd00_11_088(String Hdsd00_11_088) {
		setAttrVal("Hdsd00_11_088", Hdsd00_11_088);
	}
	/**
	 * 编码员签名
	 * @return String
	 */
	public String getHdsd00_11_005() {
		return ((String) getAttrVal("Hdsd00_11_005"));
	}
	/**
	 * 编码员签名
	 * @param Hdsd00_11_005
	 */
	public void setHdsd00_11_005(String Hdsd00_11_005) {
		setAttrVal("Hdsd00_11_005", Hdsd00_11_005);
	}
	/**
	 * 病案质量代码
	 * @return String
	 */
	public String getHdsd00_11_007() {
		return ((String) getAttrVal("Hdsd00_11_007"));
	}
	/**
	 * 病案质量代码
	 * @param Hdsd00_11_007
	 */
	public void setHdsd00_11_007(String Hdsd00_11_007) {
		setAttrVal("Hdsd00_11_007", Hdsd00_11_007);
	}
	/**
	 * 质控医师签名
	 * @return String
	 */
	public String getHdsd00_11_128() {
		return ((String) getAttrVal("Hdsd00_11_128"));
	}
	/**
	 * 质控医师签名
	 * @param Hdsd00_11_128
	 */
	public void setHdsd00_11_128(String Hdsd00_11_128) {
		setAttrVal("Hdsd00_11_128", Hdsd00_11_128);
	}
	/**
	 * 质控护士签名
	 * @return String
	 */
	public String getHdsd00_11_126() {
		return ((String) getAttrVal("Hdsd00_11_126"));
	}
	/**
	 * 质控护士签名
	 * @param Hdsd00_11_126
	 */
	public void setHdsd00_11_126(String Hdsd00_11_126) {
		setAttrVal("Hdsd00_11_126", Hdsd00_11_126);
	}
	/**
	 * 质控日期
	 * @return String
	 */
	public String getHdsd00_11_127() {
		return ((String) getAttrVal("Hdsd00_11_127"));
	}
	/**
	 * 质控日期
	 * @param Hdsd00_11_127
	 */
	public void setHdsd00_11_127(String Hdsd00_11_127) {
		setAttrVal("Hdsd00_11_127", Hdsd00_11_127);
	}
	/**
	 * 手术及操作信息
	 * @return String
	 */
	public String getHdsd00_11_x02() {
		return ((String) getAttrVal("Hdsd00_11_x02"));
	}
	/**
	 * 手术及操作信息
	 * @param Hdsd00_11_x02
	 */
	public void setHdsd00_11_x02(String Hdsd00_11_x02) {
		setAttrVal("Hdsd00_11_x02", Hdsd00_11_x02);
	}
	/**
	 * 离院方式代码
	 * @return String
	 */
	public String getHdsd00_11_057() {
		return ((String) getAttrVal("Hdsd00_11_057"));
	}
	/**
	 * 离院方式代码
	 * @param Hdsd00_11_057
	 */
	public void setHdsd00_11_057(String Hdsd00_11_057) {
		setAttrVal("Hdsd00_11_057", Hdsd00_11_057);
	}
	/**
	 * 拟接收医疗机构名称
	 * @return String
	 */
	public String getHdsd00_11_078() {
		return ((String) getAttrVal("Hdsd00_11_078"));
	}
	/**
	 * 拟接收医疗机构名称
	 * @param Hdsd00_11_078
	 */
	public void setHdsd00_11_078(String Hdsd00_11_078) {
		setAttrVal("Hdsd00_11_078", Hdsd00_11_078);
	}
	/**
	 * 出院31天内再住院标志
	 * @return String
	 */
	public String getHdsd00_11_015() {
		return ((String) getAttrVal("Hdsd00_11_015"));
	}
	/**
	 * 出院31天内再住院标志
	 * @param Hdsd00_11_015
	 */
	public void setHdsd00_11_015(String Hdsd00_11_015) {
		setAttrVal("Hdsd00_11_015", Hdsd00_11_015);
	}
	/**
	 * 出院31天内再住院目的
	 * @return String
	 */
	public String getHdsd00_11_016() {
		return ((String) getAttrVal("Hdsd00_11_016"));
	}
	/**
	 * 出院31天内再住院目的
	 * @param Hdsd00_11_016
	 */
	public void setHdsd00_11_016(String Hdsd00_11_016) {
		setAttrVal("Hdsd00_11_016", Hdsd00_11_016);
	}
	/**
	 * 颅脑损伤患者入院前昏迷时间-d
	 * @return String
	 */
	public String getHdsd00_11_070() {
		return ((String) getAttrVal("Hdsd00_11_070"));
	}
	/**
	 * 颅脑损伤患者入院前昏迷时间-d
	 * @param Hdsd00_11_070
	 */
	public void setHdsd00_11_070(String Hdsd00_11_070) {
		setAttrVal("Hdsd00_11_070", Hdsd00_11_070);
	}
	/**
	 * 颅脑损伤患者入院前昏迷时间-h
	 * @return String
	 */
	public String getHdsd00_11_071() {
		return ((String) getAttrVal("Hdsd00_11_071"));
	}
	/**
	 * 颅脑损伤患者入院前昏迷时间-h
	 * @param Hdsd00_11_071
	 */
	public void setHdsd00_11_071(String Hdsd00_11_071) {
		setAttrVal("Hdsd00_11_071", Hdsd00_11_071);
	}
	/**
	 * 颅脑损伤患者入院前昏迷时间-min
	 * @return String
	 */
	public String getHdsd00_11_072() {
		return ((String) getAttrVal("Hdsd00_11_072"));
	}
	/**
	 * 颅脑损伤患者入院前昏迷时间-min
	 * @param Hdsd00_11_072
	 */
	public void setHdsd00_11_072(String Hdsd00_11_072) {
		setAttrVal("Hdsd00_11_072", Hdsd00_11_072);
	}
	/**
	 * 颅脑损伤患者入院后昏迷时间-d
	 * @return String
	 */
	public String getHdsd00_11_067() {
		return ((String) getAttrVal("Hdsd00_11_067"));
	}
	/**
	 * 颅脑损伤患者入院后昏迷时间-d
	 * @param Hdsd00_11_067
	 */
	public void setHdsd00_11_067(String Hdsd00_11_067) {
		setAttrVal("Hdsd00_11_067", Hdsd00_11_067);
	}
	/**
	 * 颅脑损伤患者入院后昏迷时间-h
	 * @return String
	 */
	public String getHdsd00_11_068() {
		return ((String) getAttrVal("Hdsd00_11_068"));
	}
	/**
	 * 颅脑损伤患者入院后昏迷时间-h
	 * @param Hdsd00_11_068
	 */
	public void setHdsd00_11_068(String Hdsd00_11_068) {
		setAttrVal("Hdsd00_11_068", Hdsd00_11_068);
	}
	/**
	 * 颅脑损伤患者入院后昏迷时间-min
	 * @return String
	 */
	public String getHdsd00_11_069() {
		return ((String) getAttrVal("Hdsd00_11_069"));
	}
	/**
	 * 颅脑损伤患者入院后昏迷时间-min
	 * @param Hdsd00_11_069
	 */
	public void setHdsd00_11_069(String Hdsd00_11_069) {
		setAttrVal("Hdsd00_11_069", Hdsd00_11_069);
	}
	/**
	 * 住院总费用
	 * @return String
	 */
	public String getHdsd00_11_142() {
		return ((String) getAttrVal("Hdsd00_11_142"));
	}
	/**
	 * 住院总费用
	 * @param Hdsd00_11_142
	 */
	public void setHdsd00_11_142(String Hdsd00_11_142) {
		setAttrVal("Hdsd00_11_142", Hdsd00_11_142);
	}
	/**
	 * 住院总费用-自付金额
	 * @return String
	 */
	public String getHdsd00_11_143() {
		return ((String) getAttrVal("Hdsd00_11_143"));
	}
	/**
	 * 住院总费用-自付金额
	 * @param Hdsd00_11_143
	 */
	public void setHdsd00_11_143(String Hdsd00_11_143) {
		setAttrVal("Hdsd00_11_143", Hdsd00_11_143);
	}
	/**
	 * 综合医疗服务类-一般医疗服务费
	 * @return String
	 */
	public String getHdsd00_11_147() {
		return ((String) getAttrVal("Hdsd00_11_147"));
	}
	/**
	 * 综合医疗服务类-一般医疗服务费
	 * @param Hdsd00_11_147
	 */
	public void setHdsd00_11_147(String Hdsd00_11_147) {
		setAttrVal("Hdsd00_11_147", Hdsd00_11_147);
	}
	/**
	 * 综合医疗服务类-一般治疗操作费
	 * @return String
	 */
	public String getHdsd00_11_148() {
		return ((String) getAttrVal("Hdsd00_11_148"));
	}
	/**
	 * 综合医疗服务类-一般治疗操作费
	 * @param Hdsd00_11_148
	 */
	public void setHdsd00_11_148(String Hdsd00_11_148) {
		setAttrVal("Hdsd00_11_148", Hdsd00_11_148);
	}
	/**
	 * 综合医疗服务类-护理费
	 * @return String
	 */
	public String getHdsd00_11_145() {
		return ((String) getAttrVal("Hdsd00_11_145"));
	}
	/**
	 * 综合医疗服务类-护理费
	 * @param Hdsd00_11_145
	 */
	public void setHdsd00_11_145(String Hdsd00_11_145) {
		setAttrVal("Hdsd00_11_145", Hdsd00_11_145);
	}
	/**
	 * 综合医疗服务类-其他费用
	 * @return String
	 */
	public String getHdsd00_11_146() {
		return ((String) getAttrVal("Hdsd00_11_146"));
	}
	/**
	 * 综合医疗服务类-其他费用
	 * @param Hdsd00_11_146
	 */
	public void setHdsd00_11_146(String Hdsd00_11_146) {
		setAttrVal("Hdsd00_11_146", Hdsd00_11_146);
	}
	/**
	 * 诊断类-病理诊断费
	 * @return String
	 */
	public String getHdsd00_11_121() {
		return ((String) getAttrVal("Hdsd00_11_121"));
	}
	/**
	 * 诊断类-病理诊断费
	 * @param Hdsd00_11_121
	 */
	public void setHdsd00_11_121(String Hdsd00_11_121) {
		setAttrVal("Hdsd00_11_121", Hdsd00_11_121);
	}
	/**
	 * 诊断类-实验室诊断费
	 * @return String
	 */
	public String getHdsd00_11_123() {
		return ((String) getAttrVal("Hdsd00_11_123"));
	}
	/**
	 * 诊断类-实验室诊断费
	 * @param Hdsd00_11_123
	 */
	public void setHdsd00_11_123(String Hdsd00_11_123) {
		setAttrVal("Hdsd00_11_123", Hdsd00_11_123);
	}
	/**
	 * 诊断类-影像学诊断费
	 * @return String
	 */
	public String getHdsd00_11_124() {
		return ((String) getAttrVal("Hdsd00_11_124"));
	}
	/**
	 * 诊断类-影像学诊断费
	 * @param Hdsd00_11_124
	 */
	public void setHdsd00_11_124(String Hdsd00_11_124) {
		setAttrVal("Hdsd00_11_124", Hdsd00_11_124);
	}
	/**
	 * 诊断类-临床诊断项目费
	 * @return String
	 */
	public String getHdsd00_11_122() {
		return ((String) getAttrVal("Hdsd00_11_122"));
	}
	/**
	 * 诊断类-临床诊断项目费
	 * @param Hdsd00_11_122
	 */
	public void setHdsd00_11_122(String Hdsd00_11_122) {
		setAttrVal("Hdsd00_11_122", Hdsd00_11_122);
	}
	/**
	 * 治疗类-非手术治疗项目费
	 * @return String
	 */
	public String getHdsd00_11_129() {
		return ((String) getAttrVal("Hdsd00_11_129"));
	}
	/**
	 * 治疗类-非手术治疗项目费
	 * @param Hdsd00_11_129
	 */
	public void setHdsd00_11_129(String Hdsd00_11_129) {
		setAttrVal("Hdsd00_11_129", Hdsd00_11_129);
	}
	/**
	 * 治疗类-非手术治疗项目费-临床物理治疗费
	 * @return String
	 */
	public String getHdsd00_11_130() {
		return ((String) getAttrVal("Hdsd00_11_130"));
	}
	/**
	 * 治疗类-非手术治疗项目费-临床物理治疗费
	 * @param Hdsd00_11_130
	 */
	public void setHdsd00_11_130(String Hdsd00_11_130) {
		setAttrVal("Hdsd00_11_130", Hdsd00_11_130);
	}
	/**
	 * 治疗类-手术治疗费
	 * @return String
	 */
	public String getHdsd00_11_131() {
		return ((String) getAttrVal("Hdsd00_11_131"));
	}
	/**
	 * 治疗类-手术治疗费
	 * @param Hdsd00_11_131
	 */
	public void setHdsd00_11_131(String Hdsd00_11_131) {
		setAttrVal("Hdsd00_11_131", Hdsd00_11_131);
	}
	/**
	 * 治疗类-手术治疗费-麻醉费
	 * @return String
	 */
	public String getHdsd00_11_132() {
		return ((String) getAttrVal("Hdsd00_11_132"));
	}
	/**
	 * 治疗类-手术治疗费-麻醉费
	 * @param Hdsd00_11_132
	 */
	public void setHdsd00_11_132(String Hdsd00_11_132) {
		setAttrVal("Hdsd00_11_132", Hdsd00_11_132);
	}
	/**
	 * 治疗类-手术治疗费-手术费
	 * @return String
	 */
	public String getHdsd00_11_133() {
		return ((String) getAttrVal("Hdsd00_11_133"));
	}
	/**
	 * 治疗类-手术治疗费-手术费
	 * @param Hdsd00_11_133
	 */
	public void setHdsd00_11_133(String Hdsd00_11_133) {
		setAttrVal("Hdsd00_11_133", Hdsd00_11_133);
	}
	/**
	 * 康复类-康复费
	 * @return String
	 */
	public String getHdsd00_11_055() {
		return ((String) getAttrVal("Hdsd00_11_055"));
	}
	/**
	 * 康复类-康复费
	 * @param Hdsd00_11_055
	 */
	public void setHdsd00_11_055(String Hdsd00_11_055) {
		setAttrVal("Hdsd00_11_055", Hdsd00_11_055);
	}
	/**
	 * 中医类-中医治疗费
	 * @return String
	 */
	public String getHdsd00_11_136() {
		return ((String) getAttrVal("Hdsd00_11_136"));
	}
	/**
	 * 中医类-中医治疗费
	 * @param Hdsd00_11_136
	 */
	public void setHdsd00_11_136(String Hdsd00_11_136) {
		setAttrVal("Hdsd00_11_136", Hdsd00_11_136);
	}
	/**
	 * 西药类-西药费
	 * @return String
	 */
	public String getHdsd00_11_098() {
		return ((String) getAttrVal("Hdsd00_11_098"));
	}
	/**
	 * 西药类-西药费
	 * @param Hdsd00_11_098
	 */
	public void setHdsd00_11_098(String Hdsd00_11_098) {
		setAttrVal("Hdsd00_11_098", Hdsd00_11_098);
	}
	/**
	 * 西药类-西药费-抗菌药物费用
	 * @return String
	 */
	public String getHdsd00_11_099() {
		return ((String) getAttrVal("Hdsd00_11_099"));
	}
	/**
	 * 西药类-西药费-抗菌药物费用
	 * @param Hdsd00_11_099
	 */
	public void setHdsd00_11_099(String Hdsd00_11_099) {
		setAttrVal("Hdsd00_11_099", Hdsd00_11_099);
	}
	/**
	 * 中药类-中成药费
	 * @return String
	 */
	public String getHdsd00_11_135() {
		return ((String) getAttrVal("Hdsd00_11_135"));
	}
	/**
	 * 中药类-中成药费
	 * @param Hdsd00_11_135
	 */
	public void setHdsd00_11_135(String Hdsd00_11_135) {
		setAttrVal("Hdsd00_11_135", Hdsd00_11_135);
	}
	/**
	 * 中药类-中草药费
	 * @return String
	 */
	public String getHdsd00_11_134() {
		return ((String) getAttrVal("Hdsd00_11_134"));
	}
	/**
	 * 中药类-中草药费
	 * @param Hdsd00_11_134
	 */
	public void setHdsd00_11_134(String Hdsd00_11_134) {
		setAttrVal("Hdsd00_11_134", Hdsd00_11_134);
	}
	/**
	 * 血液和血液制品类-血费
	 * @return String
	 */
	public String getHdsd00_11_115() {
		return ((String) getAttrVal("Hdsd00_11_115"));
	}
	/**
	 * 血液和血液制品类-血费
	 * @param Hdsd00_11_115
	 */
	public void setHdsd00_11_115(String Hdsd00_11_115) {
		setAttrVal("Hdsd00_11_115", Hdsd00_11_115);
	}
	/**
	 * 血液和血液制品类-白蛋白类制品费
	 * @return String
	 */
	public String getHdsd00_11_111() {
		return ((String) getAttrVal("Hdsd00_11_111"));
	}
	/**
	 * 血液和血液制品类-白蛋白类制品费
	 * @param Hdsd00_11_111
	 */
	public void setHdsd00_11_111(String Hdsd00_11_111) {
		setAttrVal("Hdsd00_11_111", Hdsd00_11_111);
	}
	/**
	 * 血液和血液制品类-球蛋白类制品费
	 * @return String
	 */
	public String getHdsd00_11_113() {
		return ((String) getAttrVal("Hdsd00_11_113"));
	}
	/**
	 * 血液和血液制品类-球蛋白类制品费
	 * @param Hdsd00_11_113
	 */
	public void setHdsd00_11_113(String Hdsd00_11_113) {
		setAttrVal("Hdsd00_11_113", Hdsd00_11_113);
	}
	/**
	 * 血液和血液制品类-凝血因子类制品费
	 * @return String
	 */
	public String getHdsd00_11_112() {
		return ((String) getAttrVal("Hdsd00_11_112"));
	}
	/**
	 * 血液和血液制品类-凝血因子类制品费
	 * @param Hdsd00_11_112
	 */
	public void setHdsd00_11_112(String Hdsd00_11_112) {
		setAttrVal("Hdsd00_11_112", Hdsd00_11_112);
	}
	/**
	 * 血液和血液制品类-细胞因子类制品费
	 * @return String
	 */
	public String getHdsd00_11_114() {
		return ((String) getAttrVal("Hdsd00_11_114"));
	}
	/**
	 * 血液和血液制品类-细胞因子类制品费
	 * @param Hdsd00_11_114
	 */
	public void setHdsd00_11_114(String Hdsd00_11_114) {
		setAttrVal("Hdsd00_11_114", Hdsd00_11_114);
	}
	/**
	 * 耗材类-检查用一次性医用材料费
	 * @return String
	 */
	public String getHdsd00_11_038() {
		return ((String) getAttrVal("Hdsd00_11_038"));
	}
	/**
	 * 耗材类-检查用一次性医用材料费
	 * @param Hdsd00_11_038
	 */
	public void setHdsd00_11_038(String Hdsd00_11_038) {
		setAttrVal("Hdsd00_11_038", Hdsd00_11_038);
	}
	/**
	 * 耗材类-治疗用一次性医用材料费
	 * @return String
	 */
	public String getHdsd00_11_040() {
		return ((String) getAttrVal("Hdsd00_11_040"));
	}
	/**
	 * 耗材类-治疗用一次性医用材料费
	 * @param Hdsd00_11_040
	 */
	public void setHdsd00_11_040(String Hdsd00_11_040) {
		setAttrVal("Hdsd00_11_040", Hdsd00_11_040);
	}
	/**
	 * 耗材类-手术用一次性医用材料费
	 * @return String
	 */
	public String getHdsd00_11_039() {
		return ((String) getAttrVal("Hdsd00_11_039"));
	}
	/**
	 * 耗材类-手术用一次性医用材料费
	 * @param Hdsd00_11_039
	 */
	public void setHdsd00_11_039(String Hdsd00_11_039) {
		setAttrVal("Hdsd00_11_039", Hdsd00_11_039);
	}
	/**
	 * 其他类-其他费
	 * @return String
	 */
	public String getHdsd00_11_081() {
		return ((String) getAttrVal("Hdsd00_11_081"));
	}
	/**
	 * 其他类-其他费
	 * @param Hdsd00_11_081
	 */
	public void setHdsd00_11_081(String Hdsd00_11_081) {
		setAttrVal("Hdsd00_11_081", Hdsd00_11_081);
	}
}