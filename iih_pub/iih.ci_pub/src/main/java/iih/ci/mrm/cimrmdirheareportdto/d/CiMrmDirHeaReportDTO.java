package iih.ci.mrm.cimrmdirheareportdto.d;

import xap.mw.core.data.BaseDTO;

/**
 * 卫生部卫统4 DTO数据 
 * 
 */
public class CiMrmDirHeaReportDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 机构名称
	 * @return String
	 */
	public String getUsername() {
		return ((String) getAttrVal("Username"));
	}
	/**
	 * 机构名称
	 * @param Username
	 */
	public void setUsername(String Username) {
		setAttrVal("Username", Username);
	}
	/**
	 * 医疗付款方式
	 * @return String
	 */
	public String getYlfkfs() {
		return ((String) getAttrVal("Ylfkfs"));
	}
	/**
	 * 医疗付款方式
	 * @param Ylfkfs
	 */
	public void setYlfkfs(String Ylfkfs) {
		setAttrVal("Ylfkfs", Ylfkfs);
	}
	/**
	 * 健康卡号
	 * @return String
	 */
	public String getJkkh() {
		return ((String) getAttrVal("Jkkh"));
	}
	/**
	 * 健康卡号
	 * @param Jkkh
	 */
	public void setJkkh(String Jkkh) {
		setAttrVal("Jkkh", Jkkh);
	}
	/**
	 * 住院次数
	 * @return String
	 */
	public String getZycs() {
		return ((String) getAttrVal("Zycs"));
	}
	/**
	 * 住院次数
	 * @param Zycs
	 */
	public void setZycs(String Zycs) {
		setAttrVal("Zycs", Zycs);
	}
	/**
	 * 病案号
	 * @return String
	 */
	public String getBah() {
		return ((String) getAttrVal("Bah"));
	}
	/**
	 * 病案号
	 * @param Bah
	 */
	public void setBah(String Bah) {
		setAttrVal("Bah", Bah);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getXm() {
		return ((String) getAttrVal("Xm"));
	}
	/**
	 * 姓名
	 * @param Xm
	 */
	public void setXm(String Xm) {
		setAttrVal("Xm", Xm);
	}
	/**
	 * 性别
	 * @return String
	 */
	public String getXb() {
		return ((String) getAttrVal("Xb"));
	}
	/**
	 * 性别
	 * @param Xb
	 */
	public void setXb(String Xb) {
		setAttrVal("Xb", Xb);
	}
	/**
	 * 出生日期
	 * @return String
	 */
	public String getCsrq() {
		return ((String) getAttrVal("Csrq"));
	}
	/**
	 * 出生日期
	 * @param Csrq
	 */
	public void setCsrq(String Csrq) {
		setAttrVal("Csrq", Csrq);
	}
	/**
	 * 年龄
	 * @return String
	 */
	public String getNl() {
		return ((String) getAttrVal("Nl"));
	}
	/**
	 * 年龄
	 * @param Nl
	 */
	public void setNl(String Nl) {
		setAttrVal("Nl", Nl);
	}
	/**
	 * 国籍
	 * @return String
	 */
	public String getGj() {
		return ((String) getAttrVal("Gj"));
	}
	/**
	 * 国籍
	 * @param Gj
	 */
	public void setGj(String Gj) {
		setAttrVal("Gj", Gj);
	}
	/**
	 * 新生儿出生体重(克)
	 * @return String
	 */
	public String getXsetz() {
		return ((String) getAttrVal("Xsetz"));
	}
	/**
	 * 新生儿出生体重(克)
	 * @param Xsetz
	 */
	public void setXsetz(String Xsetz) {
		setAttrVal("Xsetz", Xsetz);
	}
	/**
	 * (年龄不足1周岁的)年龄(月)
	 * @return String
	 */
	public String getBzyzs_nl() {
		return ((String) getAttrVal("Bzyzs_nl"));
	}
	/**
	 * (年龄不足1周岁的)年龄(月)
	 * @param Bzyzs_nl
	 */
	public void setBzyzs_nl(String Bzyzs_nl) {
		setAttrVal("Bzyzs_nl", Bzyzs_nl);
	}
	/**
	 * 新生儿入院体重(克）
	 * @return String
	 */
	public String getXserytz() {
		return ((String) getAttrVal("Xserytz"));
	}
	/**
	 * 新生儿入院体重(克）
	 * @param Xserytz
	 */
	public void setXserytz(String Xserytz) {
		setAttrVal("Xserytz", Xserytz);
	}
	/**
	 * 出生地
	 * @return String
	 */
	public String getCsd() {
		return ((String) getAttrVal("Csd"));
	}
	/**
	 * 出生地
	 * @param Csd
	 */
	public void setCsd(String Csd) {
		setAttrVal("Csd", Csd);
	}
	/**
	 * 籍贯
	 * @return String
	 */
	public String getGg() {
		return ((String) getAttrVal("Gg"));
	}
	/**
	 * 籍贯
	 * @param Gg
	 */
	public void setGg(String Gg) {
		setAttrVal("Gg", Gg);
	}
	/**
	 * 民族
	 * @return String
	 */
	public String getMz() {
		return ((String) getAttrVal("Mz"));
	}
	/**
	 * 民族
	 * @param Mz
	 */
	public void setMz(String Mz) {
		setAttrVal("Mz", Mz);
	}
	/**
	 * 身份证号
	 * @return String
	 */
	public String getSfzh() {
		return ((String) getAttrVal("Sfzh"));
	}
	/**
	 * 身份证号
	 * @param Sfzh
	 */
	public void setSfzh(String Sfzh) {
		setAttrVal("Sfzh", Sfzh);
	}
	/**
	 * 职业
	 * @return String
	 */
	public String getZy() {
		return ((String) getAttrVal("Zy"));
	}
	/**
	 * 职业
	 * @param Zy
	 */
	public void setZy(String Zy) {
		setAttrVal("Zy", Zy);
	}
	/**
	 * 婚姻
	 * @return String
	 */
	public String getHy() {
		return ((String) getAttrVal("Hy"));
	}
	/**
	 * 婚姻
	 * @param Hy
	 */
	public void setHy(String Hy) {
		setAttrVal("Hy", Hy);
	}
	/**
	 * 现住址
	 * @return String
	 */
	public String getXzz() {
		return ((String) getAttrVal("Xzz"));
	}
	/**
	 * 现住址
	 * @param Xzz
	 */
	public void setXzz(String Xzz) {
		setAttrVal("Xzz", Xzz);
	}
	/**
	 * 电话
	 * @return String
	 */
	public String getDh() {
		return ((String) getAttrVal("Dh"));
	}
	/**
	 * 电话
	 * @param Dh
	 */
	public void setDh(String Dh) {
		setAttrVal("Dh", Dh);
	}
	/**
	 * 邮编
	 * @return String
	 */
	public String getYb1() {
		return ((String) getAttrVal("Yb1"));
	}
	/**
	 * 邮编
	 * @param Yb1
	 */
	public void setYb1(String Yb1) {
		setAttrVal("Yb1", Yb1);
	}
	/**
	 * 户口地址
	 * @return String
	 */
	public String getHkdz() {
		return ((String) getAttrVal("Hkdz"));
	}
	/**
	 * 户口地址
	 * @param Hkdz
	 */
	public void setHkdz(String Hkdz) {
		setAttrVal("Hkdz", Hkdz);
	}
	/**
	 * 邮编2
	 * @return String
	 */
	public String getYb2() {
		return ((String) getAttrVal("Yb2"));
	}
	/**
	 * 邮编2
	 * @param Yb2
	 */
	public void setYb2(String Yb2) {
		setAttrVal("Yb2", Yb2);
	}
	/**
	 * 工作单位及地址
	 * @return String
	 */
	public String getGzdwjdz() {
		return ((String) getAttrVal("Gzdwjdz"));
	}
	/**
	 * 工作单位及地址
	 * @param Gzdwjdz
	 */
	public void setGzdwjdz(String Gzdwjdz) {
		setAttrVal("Gzdwjdz", Gzdwjdz);
	}
	/**
	 * 单位电话
	 * @return String
	 */
	public String getDwdh() {
		return ((String) getAttrVal("Dwdh"));
	}
	/**
	 * 单位电话
	 * @param Dwdh
	 */
	public void setDwdh(String Dwdh) {
		setAttrVal("Dwdh", Dwdh);
	}
	/**
	 * 邮编3
	 * @return String
	 */
	public String getYb3() {
		return ((String) getAttrVal("Yb3"));
	}
	/**
	 * 邮编3
	 * @param Yb3
	 */
	public void setYb3(String Yb3) {
		setAttrVal("Yb3", Yb3);
	}
	/**
	 * 联系人姓名
	 * @return String
	 */
	public String getLxrxm() {
		return ((String) getAttrVal("Lxrxm"));
	}
	/**
	 * 联系人姓名
	 * @param Lxrxm
	 */
	public void setLxrxm(String Lxrxm) {
		setAttrVal("Lxrxm", Lxrxm);
	}
	/**
	 * 关系
	 * @return String
	 */
	public String getGx() {
		return ((String) getAttrVal("Gx"));
	}
	/**
	 * 关系
	 * @param Gx
	 */
	public void setGx(String Gx) {
		setAttrVal("Gx", Gx);
	}
	/**
	 * 地址
	 * @return String
	 */
	public String getDz() {
		return ((String) getAttrVal("Dz"));
	}
	/**
	 * 地址
	 * @param Dz
	 */
	public void setDz(String Dz) {
		setAttrVal("Dz", Dz);
	}
	/**
	 * 电话1
	 * @return String
	 */
	public String getDh1() {
		return ((String) getAttrVal("Dh1"));
	}
	/**
	 * 电话1
	 * @param Dh1
	 */
	public void setDh1(String Dh1) {
		setAttrVal("Dh1", Dh1);
	}
	/**
	 * 入院途径
	 * @return String
	 */
	public String getRytj() {
		return ((String) getAttrVal("Rytj"));
	}
	/**
	 * 入院途径
	 * @param Rytj
	 */
	public void setRytj(String Rytj) {
		setAttrVal("Rytj", Rytj);
	}
	/**
	 * 治疗类别
	 * @return String
	 */
	public String getZllb() {
		return ((String) getAttrVal("Zllb"));
	}
	/**
	 * 治疗类别
	 * @param Zllb
	 */
	public void setZllb(String Zllb) {
		setAttrVal("Zllb", Zllb);
	}
	/**
	 * 入院时间
	 * @return String
	 */
	public String getRysj() {
		return ((String) getAttrVal("Rysj"));
	}
	/**
	 * 入院时间
	 * @param Rysj
	 */
	public void setRysj(String Rysj) {
		setAttrVal("Rysj", Rysj);
	}
	/**
	 * 时
	 * @return String
	 */
	public String getRysj_s() {
		return ((String) getAttrVal("Rysj_s"));
	}
	/**
	 * 时
	 * @param Rysj_s
	 */
	public void setRysj_s(String Rysj_s) {
		setAttrVal("Rysj_s", Rysj_s);
	}
	/**
	 * 入院科别
	 * @return String
	 */
	public String getRykb() {
		return ((String) getAttrVal("Rykb"));
	}
	/**
	 * 入院科别
	 * @param Rykb
	 */
	public void setRykb(String Rykb) {
		setAttrVal("Rykb", Rykb);
	}
	/**
	 * 入院病房
	 * @return String
	 */
	public String getRybf() {
		return ((String) getAttrVal("Rybf"));
	}
	/**
	 * 入院病房
	 * @param Rybf
	 */
	public void setRybf(String Rybf) {
		setAttrVal("Rybf", Rybf);
	}
	/**
	 * 转科科别
	 * @return String
	 */
	public String getZkkb() {
		return ((String) getAttrVal("Zkkb"));
	}
	/**
	 * 转科科别
	 * @param Zkkb
	 */
	public void setZkkb(String Zkkb) {
		setAttrVal("Zkkb", Zkkb);
	}
	/**
	 * 出院时间
	 * @return String
	 */
	public String getCysj() {
		return ((String) getAttrVal("Cysj"));
	}
	/**
	 * 出院时间
	 * @param Cysj
	 */
	public void setCysj(String Cysj) {
		setAttrVal("Cysj", Cysj);
	}
	/**
	 * 时2
	 * @return String
	 */
	public String getCysj_s() {
		return ((String) getAttrVal("Cysj_s"));
	}
	/**
	 * 时2
	 * @param Cysj_s
	 */
	public void setCysj_s(String Cysj_s) {
		setAttrVal("Cysj_s", Cysj_s);
	}
	/**
	 * 出院科别
	 * @return String
	 */
	public String getCykb() {
		return ((String) getAttrVal("Cykb"));
	}
	/**
	 * 出院科别
	 * @param Cykb
	 */
	public void setCykb(String Cykb) {
		setAttrVal("Cykb", Cykb);
	}
	/**
	 * 出院病房
	 * @return String
	 */
	public String getCybf() {
		return ((String) getAttrVal("Cybf"));
	}
	/**
	 * 出院病房
	 * @param Cybf
	 */
	public void setCybf(String Cybf) {
		setAttrVal("Cybf", Cybf);
	}
	/**
	 * 实际住院(天)
	 * @return String
	 */
	public String getSjzy() {
		return ((String) getAttrVal("Sjzy"));
	}
	/**
	 * 实际住院(天)
	 * @param Sjzy
	 */
	public void setSjzy(String Sjzy) {
		setAttrVal("Sjzy", Sjzy);
	}
	/**
	 * 门(急)诊诊断(中医诊断)
	 * @return String
	 */
	public String getMzd_zyzd() {
		return ((String) getAttrVal("Mzd_zyzd"));
	}
	/**
	 * 门(急)诊诊断(中医诊断)
	 * @param Mzd_zyzd
	 */
	public void setMzd_zyzd(String Mzd_zyzd) {
		setAttrVal("Mzd_zyzd", Mzd_zyzd);
	}
	/**
	 * 疾病代码(中：门诊中医诊断；西：主要诊断)
	 * @return String
	 */
	public String getJbdm() {
		return ((String) getAttrVal("Jbdm"));
	}
	/**
	 * 疾病代码(中：门诊中医诊断；西：主要诊断)
	 * @param Jbdm
	 */
	public void setJbdm(String Jbdm) {
		setAttrVal("Jbdm", Jbdm);
	}
	/**
	 * 门(急)诊诊断(西医诊断)
	 * @return String
	 */
	public String getMzd_xyzd() {
		return ((String) getAttrVal("Mzd_xyzd"));
	}
	/**
	 * 门(急)诊诊断(西医诊断)
	 * @param Mzd_xyzd
	 */
	public void setMzd_xyzd(String Mzd_xyzd) {
		setAttrVal("Mzd_xyzd", Mzd_xyzd);
	}
	/**
	 * 疾病编码
	 * @return String
	 */
	public String getJbbm() {
		return ((String) getAttrVal("Jbbm"));
	}
	/**
	 * 疾病编码
	 * @param Jbbm
	 */
	public void setJbbm(String Jbbm) {
		setAttrVal("Jbbm", Jbbm);
	}
	/**
	 * 实施临床路径
	 * @return String
	 */
	public String getSslclj() {
		return ((String) getAttrVal("Sslclj"));
	}
	/**
	 * 实施临床路径
	 * @param Sslclj
	 */
	public void setSslclj(String Sslclj) {
		setAttrVal("Sslclj", Sslclj);
	}
	/**
	 * 使用医疗机构中药制剂
	 * @return String
	 */
	public String getZyyj() {
		return ((String) getAttrVal("Zyyj"));
	}
	/**
	 * 使用医疗机构中药制剂
	 * @param Zyyj
	 */
	public void setZyyj(String Zyyj) {
		setAttrVal("Zyyj", Zyyj);
	}
	/**
	 * 使用中医诊疗设备
	 * @return String
	 */
	public String getZyzlsb() {
		return ((String) getAttrVal("Zyzlsb"));
	}
	/**
	 * 使用中医诊疗设备
	 * @param Zyzlsb
	 */
	public void setZyzlsb(String Zyzlsb) {
		setAttrVal("Zyzlsb", Zyzlsb);
	}
	/**
	 * 使用中医诊疗技术
	 * @return String
	 */
	public String getZyzljs() {
		return ((String) getAttrVal("Zyzljs"));
	}
	/**
	 * 使用中医诊疗技术
	 * @param Zyzljs
	 */
	public void setZyzljs(String Zyzljs) {
		setAttrVal("Zyzljs", Zyzljs);
	}
	/**
	 * 辩证施护
	 * @return String
	 */
	public String getBzsh() {
		return ((String) getAttrVal("Bzsh"));
	}
	/**
	 * 辩证施护
	 * @param Bzsh
	 */
	public void setBzsh(String Bzsh) {
		setAttrVal("Bzsh", Bzsh);
	}
	/**
	 * 主病出院中医诊断
	 * @return String
	 */
	public String getZb() {
		return ((String) getAttrVal("Zb"));
	}
	/**
	 * 主病出院中医诊断
	 * @param Zb
	 */
	public void setZb(String Zb) {
		setAttrVal("Zb", Zb);
	}
	/**
	 * 主病疾病编码
	 * @return String
	 */
	public String getZb_jbbm() {
		return ((String) getAttrVal("Zb_jbbm"));
	}
	/**
	 * 主病疾病编码
	 * @param Zb_jbbm
	 */
	public void setZb_jbbm(String Zb_jbbm) {
		setAttrVal("Zb_jbbm", Zb_jbbm);
	}
	/**
	 * 主病入院病情
	 * @return String
	 */
	public String getZb_rybq() {
		return ((String) getAttrVal("Zb_rybq"));
	}
	/**
	 * 主病入院病情
	 * @param Zb_rybq
	 */
	public void setZb_rybq(String Zb_rybq) {
		setAttrVal("Zb_rybq", Zb_rybq);
	}
	/**
	 * 主要诊断出院西医诊断
	 * @return String
	 */
	public String getZyzd() {
		return ((String) getAttrVal("Zyzd"));
	}
	/**
	 * 主要诊断出院西医诊断
	 * @param Zyzd
	 */
	public void setZyzd(String Zyzd) {
		setAttrVal("Zyzd", Zyzd);
	}
	/**
	 * 主要诊断疾病编码
	 * @return String
	 */
	public String getZyzd_jbbm() {
		return ((String) getAttrVal("Zyzd_jbbm"));
	}
	/**
	 * 主要诊断疾病编码
	 * @param Zyzd_jbbm
	 */
	public void setZyzd_jbbm(String Zyzd_jbbm) {
		setAttrVal("Zyzd_jbbm", Zyzd_jbbm);
	}
	/**
	 * 主要诊断入院病情
	 * @return String
	 */
	public String getXy_rybq() {
		return ((String) getAttrVal("Xy_rybq"));
	}
	/**
	 * 主要诊断入院病情
	 * @param Xy_rybq
	 */
	public void setXy_rybq(String Xy_rybq) {
		setAttrVal("Xy_rybq", Xy_rybq);
	}
	/**
	 * 主证1出院中医诊断
	 * @return String
	 */
	public String getZz1() {
		return ((String) getAttrVal("Zz1"));
	}
	/**
	 * 主证1出院中医诊断
	 * @param Zz1
	 */
	public void setZz1(String Zz1) {
		setAttrVal("Zz1", Zz1);
	}
	/**
	 * 主证1疾病编码
	 * @return String
	 */
	public String getZz_jbbm1() {
		return ((String) getAttrVal("Zz_jbbm1"));
	}
	/**
	 * 主证1疾病编码
	 * @param Zz_jbbm1
	 */
	public void setZz_jbbm1(String Zz_jbbm1) {
		setAttrVal("Zz_jbbm1", Zz_jbbm1);
	}
	/**
	 * 主证1住入院病情
	 * @return String
	 */
	public String getZz_rybq1() {
		return ((String) getAttrVal("Zz_rybq1"));
	}
	/**
	 * 主证1住入院病情
	 * @param Zz_rybq1
	 */
	public void setZz_rybq1(String Zz_rybq1) {
		setAttrVal("Zz_rybq1", Zz_rybq1);
	}
	/**
	 * 其他诊断1出院西医诊断
	 * @return String
	 */
	public String getQtzd1() {
		return ((String) getAttrVal("Qtzd1"));
	}
	/**
	 * 其他诊断1出院西医诊断
	 * @param Qtzd1
	 */
	public void setQtzd1(String Qtzd1) {
		setAttrVal("Qtzd1", Qtzd1);
	}
	/**
	 * 其他诊断1疾病编码
	 * @return String
	 */
	public String getZyzd_jbbm1() {
		return ((String) getAttrVal("Zyzd_jbbm1"));
	}
	/**
	 * 其他诊断1疾病编码
	 * @param Zyzd_jbbm1
	 */
	public void setZyzd_jbbm1(String Zyzd_jbbm1) {
		setAttrVal("Zyzd_jbbm1", Zyzd_jbbm1);
	}
	/**
	 * 其他诊断1入院病情
	 * @return String
	 */
	public String getRybq1() {
		return ((String) getAttrVal("Rybq1"));
	}
	/**
	 * 其他诊断1入院病情
	 * @param Rybq1
	 */
	public void setRybq1(String Rybq1) {
		setAttrVal("Rybq1", Rybq1);
	}
	/**
	 * 主证2出院中医诊断
	 * @return String
	 */
	public String getZz2() {
		return ((String) getAttrVal("Zz2"));
	}
	/**
	 * 主证2出院中医诊断
	 * @param Zz2
	 */
	public void setZz2(String Zz2) {
		setAttrVal("Zz2", Zz2);
	}
	/**
	 * 主证2疾病编码
	 * @return String
	 */
	public String getZz_jbbm2() {
		return ((String) getAttrVal("Zz_jbbm2"));
	}
	/**
	 * 主证2疾病编码
	 * @param Zz_jbbm2
	 */
	public void setZz_jbbm2(String Zz_jbbm2) {
		setAttrVal("Zz_jbbm2", Zz_jbbm2);
	}
	/**
	 * 主证2入院病情
	 * @return String
	 */
	public String getZz_rybq2() {
		return ((String) getAttrVal("Zz_rybq2"));
	}
	/**
	 * 主证2入院病情
	 * @param Zz_rybq2
	 */
	public void setZz_rybq2(String Zz_rybq2) {
		setAttrVal("Zz_rybq2", Zz_rybq2);
	}
	/**
	 * 其他诊断2出院西医诊断
	 * @return String
	 */
	public String getQtzd2() {
		return ((String) getAttrVal("Qtzd2"));
	}
	/**
	 * 其他诊断2出院西医诊断
	 * @param Qtzd2
	 */
	public void setQtzd2(String Qtzd2) {
		setAttrVal("Qtzd2", Qtzd2);
	}
	/**
	 * 其他诊断2疾病编码
	 * @return String
	 */
	public String getZyzd_jbbm2() {
		return ((String) getAttrVal("Zyzd_jbbm2"));
	}
	/**
	 * 其他诊断2疾病编码
	 * @param Zyzd_jbbm2
	 */
	public void setZyzd_jbbm2(String Zyzd_jbbm2) {
		setAttrVal("Zyzd_jbbm2", Zyzd_jbbm2);
	}
	/**
	 * 其他诊断2入院病情
	 * @return String
	 */
	public String getRybq2() {
		return ((String) getAttrVal("Rybq2"));
	}
	/**
	 * 其他诊断2入院病情
	 * @param Rybq2
	 */
	public void setRybq2(String Rybq2) {
		setAttrVal("Rybq2", Rybq2);
	}
	/**
	 * 主证3出院中医诊断
	 * @return String
	 */
	public String getZz3() {
		return ((String) getAttrVal("Zz3"));
	}
	/**
	 * 主证3出院中医诊断
	 * @param Zz3
	 */
	public void setZz3(String Zz3) {
		setAttrVal("Zz3", Zz3);
	}
	/**
	 * 主证3疾病编码
	 * @return String
	 */
	public String getZz_jbbm3() {
		return ((String) getAttrVal("Zz_jbbm3"));
	}
	/**
	 * 主证3疾病编码
	 * @param Zz_jbbm3
	 */
	public void setZz_jbbm3(String Zz_jbbm3) {
		setAttrVal("Zz_jbbm3", Zz_jbbm3);
	}
	/**
	 * 主证3入院病情
	 * @return String
	 */
	public String getZz_rybq3() {
		return ((String) getAttrVal("Zz_rybq3"));
	}
	/**
	 * 主证3入院病情
	 * @param Zz_rybq3
	 */
	public void setZz_rybq3(String Zz_rybq3) {
		setAttrVal("Zz_rybq3", Zz_rybq3);
	}
	/**
	 * 其他诊断3出院西医诊断
	 * @return String
	 */
	public String getQtzd3() {
		return ((String) getAttrVal("Qtzd3"));
	}
	/**
	 * 其他诊断3出院西医诊断
	 * @param Qtzd3
	 */
	public void setQtzd3(String Qtzd3) {
		setAttrVal("Qtzd3", Qtzd3);
	}
	/**
	 * 其他诊断3疾病编码
	 * @return String
	 */
	public String getZyzd_jbbm3() {
		return ((String) getAttrVal("Zyzd_jbbm3"));
	}
	/**
	 * 其他诊断3疾病编码
	 * @param Zyzd_jbbm3
	 */
	public void setZyzd_jbbm3(String Zyzd_jbbm3) {
		setAttrVal("Zyzd_jbbm3", Zyzd_jbbm3);
	}
	/**
	 * 其他诊断3入院病情
	 * @return String
	 */
	public String getRybq3() {
		return ((String) getAttrVal("Rybq3"));
	}
	/**
	 * 其他诊断3入院病情
	 * @param Rybq3
	 */
	public void setRybq3(String Rybq3) {
		setAttrVal("Rybq3", Rybq3);
	}
	/**
	 * 主证4中医诊断
	 * @return String
	 */
	public String getZz4() {
		return ((String) getAttrVal("Zz4"));
	}
	/**
	 * 主证4中医诊断
	 * @param Zz4
	 */
	public void setZz4(String Zz4) {
		setAttrVal("Zz4", Zz4);
	}
	/**
	 * 主证4疾病编码
	 * @return String
	 */
	public String getZz_jbbm4() {
		return ((String) getAttrVal("Zz_jbbm4"));
	}
	/**
	 * 主证4疾病编码
	 * @param Zz_jbbm4
	 */
	public void setZz_jbbm4(String Zz_jbbm4) {
		setAttrVal("Zz_jbbm4", Zz_jbbm4);
	}
	/**
	 * 主证4入院病情
	 * @return String
	 */
	public String getZz_rybq4() {
		return ((String) getAttrVal("Zz_rybq4"));
	}
	/**
	 * 主证4入院病情
	 * @param Zz_rybq4
	 */
	public void setZz_rybq4(String Zz_rybq4) {
		setAttrVal("Zz_rybq4", Zz_rybq4);
	}
	/**
	 * 其他诊断4出院西医诊断
	 * @return String
	 */
	public String getQtzd4() {
		return ((String) getAttrVal("Qtzd4"));
	}
	/**
	 * 其他诊断4出院西医诊断
	 * @param Qtzd4
	 */
	public void setQtzd4(String Qtzd4) {
		setAttrVal("Qtzd4", Qtzd4);
	}
	/**
	 * 其他诊断4疾病编码
	 * @return String
	 */
	public String getZyzd_jbbm4() {
		return ((String) getAttrVal("Zyzd_jbbm4"));
	}
	/**
	 * 其他诊断4疾病编码
	 * @param Zyzd_jbbm4
	 */
	public void setZyzd_jbbm4(String Zyzd_jbbm4) {
		setAttrVal("Zyzd_jbbm4", Zyzd_jbbm4);
	}
	/**
	 * 其他诊断4入院病情
	 * @return String
	 */
	public String getRybq4() {
		return ((String) getAttrVal("Rybq4"));
	}
	/**
	 * 其他诊断4入院病情
	 * @param Rybq4
	 */
	public void setRybq4(String Rybq4) {
		setAttrVal("Rybq4", Rybq4);
	}
	/**
	 * 主证5中医诊断
	 * @return String
	 */
	public String getZz5() {
		return ((String) getAttrVal("Zz5"));
	}
	/**
	 * 主证5中医诊断
	 * @param Zz5
	 */
	public void setZz5(String Zz5) {
		setAttrVal("Zz5", Zz5);
	}
	/**
	 * 主证5疾病编码
	 * @return String
	 */
	public String getZz_jbbm5() {
		return ((String) getAttrVal("Zz_jbbm5"));
	}
	/**
	 * 主证5疾病编码
	 * @param Zz_jbbm5
	 */
	public void setZz_jbbm5(String Zz_jbbm5) {
		setAttrVal("Zz_jbbm5", Zz_jbbm5);
	}
	/**
	 * 主证入院病情
	 * @return String
	 */
	public String getZz_rybq5() {
		return ((String) getAttrVal("Zz_rybq5"));
	}
	/**
	 * 主证入院病情
	 * @param Zz_rybq5
	 */
	public void setZz_rybq5(String Zz_rybq5) {
		setAttrVal("Zz_rybq5", Zz_rybq5);
	}
	/**
	 * 其他诊断5出院西医诊断
	 * @return String
	 */
	public String getQtzd5() {
		return ((String) getAttrVal("Qtzd5"));
	}
	/**
	 * 其他诊断5出院西医诊断
	 * @param Qtzd5
	 */
	public void setQtzd5(String Qtzd5) {
		setAttrVal("Qtzd5", Qtzd5);
	}
	/**
	 * 其他诊断5疾病编码
	 * @return String
	 */
	public String getZyzd_jbbm5() {
		return ((String) getAttrVal("Zyzd_jbbm5"));
	}
	/**
	 * 其他诊断5疾病编码
	 * @param Zyzd_jbbm5
	 */
	public void setZyzd_jbbm5(String Zyzd_jbbm5) {
		setAttrVal("Zyzd_jbbm5", Zyzd_jbbm5);
	}
	/**
	 * 其他诊断5入院病情
	 * @return String
	 */
	public String getRybq5() {
		return ((String) getAttrVal("Rybq5"));
	}
	/**
	 * 其他诊断5入院病情
	 * @param Rybq5
	 */
	public void setRybq5(String Rybq5) {
		setAttrVal("Rybq5", Rybq5);
	}
	/**
	 * 主证6出院中医诊断
	 * @return String
	 */
	public String getZz6() {
		return ((String) getAttrVal("Zz6"));
	}
	/**
	 * 主证6出院中医诊断
	 * @param Zz6
	 */
	public void setZz6(String Zz6) {
		setAttrVal("Zz6", Zz6);
	}
	/**
	 * 主证6疾病编码
	 * @return String
	 */
	public String getZz_jbbm6() {
		return ((String) getAttrVal("Zz_jbbm6"));
	}
	/**
	 * 主证6疾病编码
	 * @param Zz_jbbm6
	 */
	public void setZz_jbbm6(String Zz_jbbm6) {
		setAttrVal("Zz_jbbm6", Zz_jbbm6);
	}
	/**
	 * 主证6入院病情
	 * @return String
	 */
	public String getZz_rybq6() {
		return ((String) getAttrVal("Zz_rybq6"));
	}
	/**
	 * 主证6入院病情
	 * @param Zz_rybq6
	 */
	public void setZz_rybq6(String Zz_rybq6) {
		setAttrVal("Zz_rybq6", Zz_rybq6);
	}
	/**
	 * 其他诊断6西医诊断
	 * @return String
	 */
	public String getQtzd6() {
		return ((String) getAttrVal("Qtzd6"));
	}
	/**
	 * 其他诊断6西医诊断
	 * @param Qtzd6
	 */
	public void setQtzd6(String Qtzd6) {
		setAttrVal("Qtzd6", Qtzd6);
	}
	/**
	 * 其他诊断6疾病编码
	 * @return String
	 */
	public String getZyzd_jbbm6() {
		return ((String) getAttrVal("Zyzd_jbbm6"));
	}
	/**
	 * 其他诊断6疾病编码
	 * @param Zyzd_jbbm6
	 */
	public void setZyzd_jbbm6(String Zyzd_jbbm6) {
		setAttrVal("Zyzd_jbbm6", Zyzd_jbbm6);
	}
	/**
	 * 其他诊断6入院病情
	 * @return String
	 */
	public String getRybq6() {
		return ((String) getAttrVal("Rybq6"));
	}
	/**
	 * 其他诊断6入院病情
	 * @param Rybq6
	 */
	public void setRybq6(String Rybq6) {
		setAttrVal("Rybq6", Rybq6);
	}
	/**
	 * 主证7出院中医诊断
	 * @return String
	 */
	public String getZz7() {
		return ((String) getAttrVal("Zz7"));
	}
	/**
	 * 主证7出院中医诊断
	 * @param Zz7
	 */
	public void setZz7(String Zz7) {
		setAttrVal("Zz7", Zz7);
	}
	/**
	 * 主证7疾病编码
	 * @return String
	 */
	public String getZz_jbbm7() {
		return ((String) getAttrVal("Zz_jbbm7"));
	}
	/**
	 * 主证7疾病编码
	 * @param Zz_jbbm7
	 */
	public void setZz_jbbm7(String Zz_jbbm7) {
		setAttrVal("Zz_jbbm7", Zz_jbbm7);
	}
	/**
	 * 主证7入院病情
	 * @return String
	 */
	public String getZz_rybq7() {
		return ((String) getAttrVal("Zz_rybq7"));
	}
	/**
	 * 主证7入院病情
	 * @param Zz_rybq7
	 */
	public void setZz_rybq7(String Zz_rybq7) {
		setAttrVal("Zz_rybq7", Zz_rybq7);
	}
	/**
	 * 其他诊断7出院西医诊断
	 * @return String
	 */
	public String getQtzd7() {
		return ((String) getAttrVal("Qtzd7"));
	}
	/**
	 * 其他诊断7出院西医诊断
	 * @param Qtzd7
	 */
	public void setQtzd7(String Qtzd7) {
		setAttrVal("Qtzd7", Qtzd7);
	}
	/**
	 * 其他诊断7疾病编码
	 * @return String
	 */
	public String getZyzd_jbbm7() {
		return ((String) getAttrVal("Zyzd_jbbm7"));
	}
	/**
	 * 其他诊断7疾病编码
	 * @param Zyzd_jbbm7
	 */
	public void setZyzd_jbbm7(String Zyzd_jbbm7) {
		setAttrVal("Zyzd_jbbm7", Zyzd_jbbm7);
	}
	/**
	 * 其他诊断7入院病情
	 * @return String
	 */
	public String getRybq7() {
		return ((String) getAttrVal("Rybq7"));
	}
	/**
	 * 其他诊断7入院病情
	 * @param Rybq7
	 */
	public void setRybq7(String Rybq7) {
		setAttrVal("Rybq7", Rybq7);
	}
	/**
	 * 中毒的外部原因
	 * @return String
	 */
	public String getWbyy() {
		return ((String) getAttrVal("Wbyy"));
	}
	/**
	 * 中毒的外部原因
	 * @param Wbyy
	 */
	public void setWbyy(String Wbyy) {
		setAttrVal("Wbyy", Wbyy);
	}
	/**
	 * 疾病编码1
	 * @return String
	 */
	public String getJbbm1() {
		return ((String) getAttrVal("Jbbm1"));
	}
	/**
	 * 疾病编码1
	 * @param Jbbm1
	 */
	public void setJbbm1(String Jbbm1) {
		setAttrVal("Jbbm1", Jbbm1);
	}
	/**
	 * 病理诊断出
	 * @return String
	 */
	public String getBlzd() {
		return ((String) getAttrVal("Blzd"));
	}
	/**
	 * 病理诊断出
	 * @param Blzd
	 */
	public void setBlzd(String Blzd) {
		setAttrVal("Blzd", Blzd);
	}
	/**
	 * 疾病编码2
	 * @return String
	 */
	public String getJbbm2() {
		return ((String) getAttrVal("Jbbm2"));
	}
	/**
	 * 疾病编码2
	 * @param Jbbm2
	 */
	public void setJbbm2(String Jbbm2) {
		setAttrVal("Jbbm2", Jbbm2);
	}
	/**
	 * 病理号
	 * @return String
	 */
	public String getBlh() {
		return ((String) getAttrVal("Blh"));
	}
	/**
	 * 病理号
	 * @param Blh
	 */
	public void setBlh(String Blh) {
		setAttrVal("Blh", Blh);
	}
	/**
	 * 药物过敏
	 * @return String
	 */
	public String getYwgm() {
		return ((String) getAttrVal("Ywgm"));
	}
	/**
	 * 药物过敏
	 * @param Ywgm
	 */
	public void setYwgm(String Ywgm) {
		setAttrVal("Ywgm", Ywgm);
	}
	/**
	 * 过敏药物疾病
	 * @return String
	 */
	public String getGmyw() {
		return ((String) getAttrVal("Gmyw"));
	}
	/**
	 * 过敏药物疾病
	 * @param Gmyw
	 */
	public void setGmyw(String Gmyw) {
		setAttrVal("Gmyw", Gmyw);
	}
	/**
	 * 死亡患者尸检
	 * @return String
	 */
	public String getSj() {
		return ((String) getAttrVal("Sj"));
	}
	/**
	 * 死亡患者尸检
	 * @param Sj
	 */
	public void setSj(String Sj) {
		setAttrVal("Sj", Sj);
	}
	/**
	 * 血型
	 * @return String
	 */
	public String getXx() {
		return ((String) getAttrVal("Xx"));
	}
	/**
	 * 血型
	 * @param Xx
	 */
	public void setXx(String Xx) {
		setAttrVal("Xx", Xx);
	}
	/**
	 * Rh
	 * @return String
	 */
	public String getRh() {
		return ((String) getAttrVal("Rh"));
	}
	/**
	 * Rh
	 * @param Rh
	 */
	public void setRh(String Rh) {
		setAttrVal("Rh", Rh);
	}
	/**
	 * 科主任
	 * @return String
	 */
	public String getKzr() {
		return ((String) getAttrVal("Kzr"));
	}
	/**
	 * 科主任
	 * @param Kzr
	 */
	public void setKzr(String Kzr) {
		setAttrVal("Kzr", Kzr);
	}
	/**
	 * 主任（副主任）医师
	 * @return String
	 */
	public String getZrys() {
		return ((String) getAttrVal("Zrys"));
	}
	/**
	 * 主任（副主任）医师
	 * @param Zrys
	 */
	public void setZrys(String Zrys) {
		setAttrVal("Zrys", Zrys);
	}
	/**
	 * 主治医师
	 * @return String
	 */
	public String getZzys() {
		return ((String) getAttrVal("Zzys"));
	}
	/**
	 * 主治医师
	 * @param Zzys
	 */
	public void setZzys(String Zzys) {
		setAttrVal("Zzys", Zzys);
	}
	/**
	 * 住院医师
	 * @return String
	 */
	public String getZyys() {
		return ((String) getAttrVal("Zyys"));
	}
	/**
	 * 住院医师
	 * @param Zyys
	 */
	public void setZyys(String Zyys) {
		setAttrVal("Zyys", Zyys);
	}
	/**
	 * 责任护士
	 * @return String
	 */
	public String getZrhs() {
		return ((String) getAttrVal("Zrhs"));
	}
	/**
	 * 责任护士
	 * @param Zrhs
	 */
	public void setZrhs(String Zrhs) {
		setAttrVal("Zrhs", Zrhs);
	}
	/**
	 * 进修医师住
	 * @return String
	 */
	public String getJxys() {
		return ((String) getAttrVal("Jxys"));
	}
	/**
	 * 进修医师住
	 * @param Jxys
	 */
	public void setJxys(String Jxys) {
		setAttrVal("Jxys", Jxys);
	}
	/**
	 * 实习医师
	 * @return String
	 */
	public String getSxys() {
		return ((String) getAttrVal("Sxys"));
	}
	/**
	 * 实习医师
	 * @param Sxys
	 */
	public void setSxys(String Sxys) {
		setAttrVal("Sxys", Sxys);
	}
	/**
	 * 编码员
	 * @return String
	 */
	public String getBmy() {
		return ((String) getAttrVal("Bmy"));
	}
	/**
	 * 编码员
	 * @param Bmy
	 */
	public void setBmy(String Bmy) {
		setAttrVal("Bmy", Bmy);
	}
	/**
	 * 病案质量
	 * @return String
	 */
	public String getBazl() {
		return ((String) getAttrVal("Bazl"));
	}
	/**
	 * 病案质量
	 * @param Bazl
	 */
	public void setBazl(String Bazl) {
		setAttrVal("Bazl", Bazl);
	}
	/**
	 * 质控医师
	 * @return String
	 */
	public String getZkys() {
		return ((String) getAttrVal("Zkys"));
	}
	/**
	 * 质控医师
	 * @param Zkys
	 */
	public void setZkys(String Zkys) {
		setAttrVal("Zkys", Zkys);
	}
	/**
	 * 质控护士
	 * @return String
	 */
	public String getZkhs() {
		return ((String) getAttrVal("Zkhs"));
	}
	/**
	 * 质控护士
	 * @param Zkhs
	 */
	public void setZkhs(String Zkhs) {
		setAttrVal("Zkhs", Zkhs);
	}
	/**
	 * 质控日期
	 * @return String
	 */
	public String getZkrq() {
		return ((String) getAttrVal("Zkrq"));
	}
	/**
	 * 质控日期
	 * @param Zkrq
	 */
	public void setZkrq(String Zkrq) {
		setAttrVal("Zkrq", Zkrq);
	}
	/**
	 * 手术及操作编码
	 * @return String
	 */
	public String getSsjczbm1() {
		return ((String) getAttrVal("Ssjczbm1"));
	}
	/**
	 * 手术及操作编码
	 * @param Ssjczbm1
	 */
	public void setSsjczbm1(String Ssjczbm1) {
		setAttrVal("Ssjczbm1", Ssjczbm1);
	}
	/**
	 * 手术及操作日期
	 * @return String
	 */
	public String getSsjczrq1() {
		return ((String) getAttrVal("Ssjczrq1"));
	}
	/**
	 * 手术及操作日期
	 * @param Ssjczrq1
	 */
	public void setSsjczrq1(String Ssjczrq1) {
		setAttrVal("Ssjczrq1", Ssjczrq1);
	}
	/**
	 * 手术级别
	 * @return String
	 */
	public String getSsjb1() {
		return ((String) getAttrVal("Ssjb1"));
	}
	/**
	 * 手术级别
	 * @param Ssjb1
	 */
	public void setSsjb1(String Ssjb1) {
		setAttrVal("Ssjb1", Ssjb1);
	}
	/**
	 * 手术及操作名称
	 * @return String
	 */
	public String getSsjczmc1() {
		return ((String) getAttrVal("Ssjczmc1"));
	}
	/**
	 * 手术及操作名称
	 * @param Ssjczmc1
	 */
	public void setSsjczmc1(String Ssjczmc1) {
		setAttrVal("Ssjczmc1", Ssjczmc1);
	}
	/**
	 * 术者
	 * @return String
	 */
	public String getSz1() {
		return ((String) getAttrVal("Sz1"));
	}
	/**
	 * 术者
	 * @param Sz1
	 */
	public void setSz1(String Sz1) {
		setAttrVal("Sz1", Sz1);
	}
	/**
	 * I助
	 * @return String
	 */
	public String getYz1() {
		return ((String) getAttrVal("Yz1"));
	}
	/**
	 * I助
	 * @param Yz1
	 */
	public void setYz1(String Yz1) {
		setAttrVal("Yz1", Yz1);
	}
	/**
	 * II助
	 * @return String
	 */
	public String getEz1() {
		return ((String) getAttrVal("Ez1"));
	}
	/**
	 * II助
	 * @param Ez1
	 */
	public void setEz1(String Ez1) {
		setAttrVal("Ez1", Ez1);
	}
	/**
	 * 切口等级
	 * @return String
	 */
	public String getQkdj1() {
		return ((String) getAttrVal("Qkdj1"));
	}
	/**
	 * 切口等级
	 * @param Qkdj1
	 */
	public void setQkdj1(String Qkdj1) {
		setAttrVal("Qkdj1", Qkdj1);
	}
	/**
	 * 切口愈合类别
	 * @return String
	 */
	public String getQkylb1() {
		return ((String) getAttrVal("Qkylb1"));
	}
	/**
	 * 切口愈合类别
	 * @param Qkylb1
	 */
	public void setQkylb1(String Qkylb1) {
		setAttrVal("Qkylb1", Qkylb1);
	}
	/**
	 * 麻醉方式
	 * @return String
	 */
	public String getMzfs1() {
		return ((String) getAttrVal("Mzfs1"));
	}
	/**
	 * 麻醉方式
	 * @param Mzfs1
	 */
	public void setMzfs1(String Mzfs1) {
		setAttrVal("Mzfs1", Mzfs1);
	}
	/**
	 * 麻醉医师
	 * @return String
	 */
	public String getMzys1() {
		return ((String) getAttrVal("Mzys1"));
	}
	/**
	 * 麻醉医师
	 * @param Mzys1
	 */
	public void setMzys1(String Mzys1) {
		setAttrVal("Mzys1", Mzys1);
	}
	/**
	 * 手术及操作编码2
	 * @return String
	 */
	public String getSsjczbm2() {
		return ((String) getAttrVal("Ssjczbm2"));
	}
	/**
	 * 手术及操作编码2
	 * @param Ssjczbm2
	 */
	public void setSsjczbm2(String Ssjczbm2) {
		setAttrVal("Ssjczbm2", Ssjczbm2);
	}
	/**
	 * 手术及操作日期2
	 * @return String
	 */
	public String getSsjczrq2() {
		return ((String) getAttrVal("Ssjczrq2"));
	}
	/**
	 * 手术及操作日期2
	 * @param Ssjczrq2
	 */
	public void setSsjczrq2(String Ssjczrq2) {
		setAttrVal("Ssjczrq2", Ssjczrq2);
	}
	/**
	 * 手术级别2
	 * @return String
	 */
	public String getSsjb2() {
		return ((String) getAttrVal("Ssjb2"));
	}
	/**
	 * 手术级别2
	 * @param Ssjb2
	 */
	public void setSsjb2(String Ssjb2) {
		setAttrVal("Ssjb2", Ssjb2);
	}
	/**
	 * 手术及操作名称2
	 * @return String
	 */
	public String getSsjczmc2() {
		return ((String) getAttrVal("Ssjczmc2"));
	}
	/**
	 * 手术及操作名称2
	 * @param Ssjczmc2
	 */
	public void setSsjczmc2(String Ssjczmc2) {
		setAttrVal("Ssjczmc2", Ssjczmc2);
	}
	/**
	 * 术者2
	 * @return String
	 */
	public String getSz2() {
		return ((String) getAttrVal("Sz2"));
	}
	/**
	 * 术者2
	 * @param Sz2
	 */
	public void setSz2(String Sz2) {
		setAttrVal("Sz2", Sz2);
	}
	/**
	 * I助2
	 * @return String
	 */
	public String getYz2() {
		return ((String) getAttrVal("Yz2"));
	}
	/**
	 * I助2
	 * @param Yz2
	 */
	public void setYz2(String Yz2) {
		setAttrVal("Yz2", Yz2);
	}
	/**
	 * II助2
	 * @return String
	 */
	public String getEz2() {
		return ((String) getAttrVal("Ez2"));
	}
	/**
	 * II助2
	 * @param Ez2
	 */
	public void setEz2(String Ez2) {
		setAttrVal("Ez2", Ez2);
	}
	/**
	 * 切口等級2
	 * @return String
	 */
	public String getQkdj2() {
		return ((String) getAttrVal("Qkdj2"));
	}
	/**
	 * 切口等級2
	 * @param Qkdj2
	 */
	public void setQkdj2(String Qkdj2) {
		setAttrVal("Qkdj2", Qkdj2);
	}
	/**
	 * 切口愈合类别2
	 * @return String
	 */
	public String getQkylb2() {
		return ((String) getAttrVal("Qkylb2"));
	}
	/**
	 * 切口愈合类别2
	 * @param Qkylb2
	 */
	public void setQkylb2(String Qkylb2) {
		setAttrVal("Qkylb2", Qkylb2);
	}
	/**
	 * 麻醉方式2
	 * @return String
	 */
	public String getMzfs2() {
		return ((String) getAttrVal("Mzfs2"));
	}
	/**
	 * 麻醉方式2
	 * @param Mzfs2
	 */
	public void setMzfs2(String Mzfs2) {
		setAttrVal("Mzfs2", Mzfs2);
	}
	/**
	 * 麻醉医师2
	 * @return String
	 */
	public String getMzys2() {
		return ((String) getAttrVal("Mzys2"));
	}
	/**
	 * 麻醉医师2
	 * @param Mzys2
	 */
	public void setMzys2(String Mzys2) {
		setAttrVal("Mzys2", Mzys2);
	}
	/**
	 * 手术及操作编码3
	 * @return String
	 */
	public String getSsjczbm3() {
		return ((String) getAttrVal("Ssjczbm3"));
	}
	/**
	 * 手术及操作编码3
	 * @param Ssjczbm3
	 */
	public void setSsjczbm3(String Ssjczbm3) {
		setAttrVal("Ssjczbm3", Ssjczbm3);
	}
	/**
	 * 手术及操作日期3
	 * @return String
	 */
	public String getSsjczrq3() {
		return ((String) getAttrVal("Ssjczrq3"));
	}
	/**
	 * 手术及操作日期3
	 * @param Ssjczrq3
	 */
	public void setSsjczrq3(String Ssjczrq3) {
		setAttrVal("Ssjczrq3", Ssjczrq3);
	}
	/**
	 * 手术级别3
	 * @return String
	 */
	public String getSsjb3() {
		return ((String) getAttrVal("Ssjb3"));
	}
	/**
	 * 手术级别3
	 * @param Ssjb3
	 */
	public void setSsjb3(String Ssjb3) {
		setAttrVal("Ssjb3", Ssjb3);
	}
	/**
	 * 手术及操作名称3
	 * @return String
	 */
	public String getSsjczmc3() {
		return ((String) getAttrVal("Ssjczmc3"));
	}
	/**
	 * 手术及操作名称3
	 * @param Ssjczmc3
	 */
	public void setSsjczmc3(String Ssjczmc3) {
		setAttrVal("Ssjczmc3", Ssjczmc3);
	}
	/**
	 * 术者3
	 * @return String
	 */
	public String getSz3() {
		return ((String) getAttrVal("Sz3"));
	}
	/**
	 * 术者3
	 * @param Sz3
	 */
	public void setSz3(String Sz3) {
		setAttrVal("Sz3", Sz3);
	}
	/**
	 * I助3
	 * @return String
	 */
	public String getYz3() {
		return ((String) getAttrVal("Yz3"));
	}
	/**
	 * I助3
	 * @param Yz3
	 */
	public void setYz3(String Yz3) {
		setAttrVal("Yz3", Yz3);
	}
	/**
	 * II助3
	 * @return String
	 */
	public String getEz3() {
		return ((String) getAttrVal("Ez3"));
	}
	/**
	 * II助3
	 * @param Ez3
	 */
	public void setEz3(String Ez3) {
		setAttrVal("Ez3", Ez3);
	}
	/**
	 * 切口等级3
	 * @return String
	 */
	public String getQkdj3() {
		return ((String) getAttrVal("Qkdj3"));
	}
	/**
	 * 切口等级3
	 * @param Qkdj3
	 */
	public void setQkdj3(String Qkdj3) {
		setAttrVal("Qkdj3", Qkdj3);
	}
	/**
	 * 麻醉方式3
	 * @return String
	 */
	public String getMzfs3() {
		return ((String) getAttrVal("Mzfs3"));
	}
	/**
	 * 麻醉方式3
	 * @param Mzfs3
	 */
	public void setMzfs3(String Mzfs3) {
		setAttrVal("Mzfs3", Mzfs3);
	}
	/**
	 * 切口愈合类别3
	 * @return String
	 */
	public String getQkylb3() {
		return ((String) getAttrVal("Qkylb3"));
	}
	/**
	 * 切口愈合类别3
	 * @param Qkylb3
	 */
	public void setQkylb3(String Qkylb3) {
		setAttrVal("Qkylb3", Qkylb3);
	}
	/**
	 * 麻醉医师3
	 * @return String
	 */
	public String getMzys3() {
		return ((String) getAttrVal("Mzys3"));
	}
	/**
	 * 麻醉医师3
	 * @param Mzys3
	 */
	public void setMzys3(String Mzys3) {
		setAttrVal("Mzys3", Mzys3);
	}
	/**
	 * 手术及操作日期4
	 * @return String
	 */
	public String getSsjczrq4() {
		return ((String) getAttrVal("Ssjczrq4"));
	}
	/**
	 * 手术及操作日期4
	 * @param Ssjczrq4
	 */
	public void setSsjczrq4(String Ssjczrq4) {
		setAttrVal("Ssjczrq4", Ssjczrq4);
	}
	/**
	 * 手术及操作编码4
	 * @return String
	 */
	public String getSsjczbm4() {
		return ((String) getAttrVal("Ssjczbm4"));
	}
	/**
	 * 手术及操作编码4
	 * @param Ssjczbm4
	 */
	public void setSsjczbm4(String Ssjczbm4) {
		setAttrVal("Ssjczbm4", Ssjczbm4);
	}
	/**
	 * 手术级别4
	 * @return String
	 */
	public String getSsjb4() {
		return ((String) getAttrVal("Ssjb4"));
	}
	/**
	 * 手术级别4
	 * @param Ssjb4
	 */
	public void setSsjb4(String Ssjb4) {
		setAttrVal("Ssjb4", Ssjb4);
	}
	/**
	 * 手术及操作名称4
	 * @return String
	 */
	public String getSsjczmc4() {
		return ((String) getAttrVal("Ssjczmc4"));
	}
	/**
	 * 手术及操作名称4
	 * @param Ssjczmc4
	 */
	public void setSsjczmc4(String Ssjczmc4) {
		setAttrVal("Ssjczmc4", Ssjczmc4);
	}
	/**
	 * 术者4
	 * @return String
	 */
	public String getSz4() {
		return ((String) getAttrVal("Sz4"));
	}
	/**
	 * 术者4
	 * @param Sz4
	 */
	public void setSz4(String Sz4) {
		setAttrVal("Sz4", Sz4);
	}
	/**
	 * I助4
	 * @return String
	 */
	public String getYz4() {
		return ((String) getAttrVal("Yz4"));
	}
	/**
	 * I助4
	 * @param Yz4
	 */
	public void setYz4(String Yz4) {
		setAttrVal("Yz4", Yz4);
	}
	/**
	 * II助4
	 * @return String
	 */
	public String getEz4() {
		return ((String) getAttrVal("Ez4"));
	}
	/**
	 * II助4
	 * @param Ez4
	 */
	public void setEz4(String Ez4) {
		setAttrVal("Ez4", Ez4);
	}
	/**
	 * 切口等级4
	 * @return String
	 */
	public String getQkdj4() {
		return ((String) getAttrVal("Qkdj4"));
	}
	/**
	 * 切口等级4
	 * @param Qkdj4
	 */
	public void setQkdj4(String Qkdj4) {
		setAttrVal("Qkdj4", Qkdj4);
	}
	/**
	 * 切口愈合类别4
	 * @return String
	 */
	public String getQkylb4() {
		return ((String) getAttrVal("Qkylb4"));
	}
	/**
	 * 切口愈合类别4
	 * @param Qkylb4
	 */
	public void setQkylb4(String Qkylb4) {
		setAttrVal("Qkylb4", Qkylb4);
	}
	/**
	 * 麻醉方式4
	 * @return String
	 */
	public String getMzfs4() {
		return ((String) getAttrVal("Mzfs4"));
	}
	/**
	 * 麻醉方式4
	 * @param Mzfs4
	 */
	public void setMzfs4(String Mzfs4) {
		setAttrVal("Mzfs4", Mzfs4);
	}
	/**
	 * 情况麻醉医师
	 * @return String
	 */
	public String getMzys4() {
		return ((String) getAttrVal("Mzys4"));
	}
	/**
	 * 情况麻醉医师
	 * @param Mzys4
	 */
	public void setMzys4(String Mzys4) {
		setAttrVal("Mzys4", Mzys4);
	}
	/**
	 * 手术及操作编码5
	 * @return String
	 */
	public String getSsjczbm5() {
		return ((String) getAttrVal("Ssjczbm5"));
	}
	/**
	 * 手术及操作编码5
	 * @param Ssjczbm5
	 */
	public void setSsjczbm5(String Ssjczbm5) {
		setAttrVal("Ssjczbm5", Ssjczbm5);
	}
	/**
	 * 手术及操作日期5
	 * @return String
	 */
	public String getSsjczrq5() {
		return ((String) getAttrVal("Ssjczrq5"));
	}
	/**
	 * 手术及操作日期5
	 * @param Ssjczrq5
	 */
	public void setSsjczrq5(String Ssjczrq5) {
		setAttrVal("Ssjczrq5", Ssjczrq5);
	}
	/**
	 * 手术级别5
	 * @return String
	 */
	public String getSsjb5() {
		return ((String) getAttrVal("Ssjb5"));
	}
	/**
	 * 手术级别5
	 * @param Ssjb5
	 */
	public void setSsjb5(String Ssjb5) {
		setAttrVal("Ssjb5", Ssjb5);
	}
	/**
	 * 手术及操作名称5
	 * @return String
	 */
	public String getSsjczmc5() {
		return ((String) getAttrVal("Ssjczmc5"));
	}
	/**
	 * 手术及操作名称5
	 * @param Ssjczmc5
	 */
	public void setSsjczmc5(String Ssjczmc5) {
		setAttrVal("Ssjczmc5", Ssjczmc5);
	}
	/**
	 * 术者5
	 * @return String
	 */
	public String getSz5() {
		return ((String) getAttrVal("Sz5"));
	}
	/**
	 * 术者5
	 * @param Sz5
	 */
	public void setSz5(String Sz5) {
		setAttrVal("Sz5", Sz5);
	}
	/**
	 * I助5
	 * @return String
	 */
	public String getYz5() {
		return ((String) getAttrVal("Yz5"));
	}
	/**
	 * I助5
	 * @param Yz5
	 */
	public void setYz5(String Yz5) {
		setAttrVal("Yz5", Yz5);
	}
	/**
	 * II助5
	 * @return String
	 */
	public String getEz5() {
		return ((String) getAttrVal("Ez5"));
	}
	/**
	 * II助5
	 * @param Ez5
	 */
	public void setEz5(String Ez5) {
		setAttrVal("Ez5", Ez5);
	}
	/**
	 * 切口等级5
	 * @return String
	 */
	public String getQkdj5() {
		return ((String) getAttrVal("Qkdj5"));
	}
	/**
	 * 切口等级5
	 * @param Qkdj5
	 */
	public void setQkdj5(String Qkdj5) {
		setAttrVal("Qkdj5", Qkdj5);
	}
	/**
	 * 切口愈合类别5
	 * @return String
	 */
	public String getQkylb5() {
		return ((String) getAttrVal("Qkylb5"));
	}
	/**
	 * 切口愈合类别5
	 * @param Qkylb5
	 */
	public void setQkylb5(String Qkylb5) {
		setAttrVal("Qkylb5", Qkylb5);
	}
	/**
	 * 麻醉方式5
	 * @return String
	 */
	public String getMzfs5() {
		return ((String) getAttrVal("Mzfs5"));
	}
	/**
	 * 麻醉方式5
	 * @param Mzfs5
	 */
	public void setMzfs5(String Mzfs5) {
		setAttrVal("Mzfs5", Mzfs5);
	}
	/**
	 * 麻醉医师5
	 * @return String
	 */
	public String getMzys5() {
		return ((String) getAttrVal("Mzys5"));
	}
	/**
	 * 麻醉医师5
	 * @param Mzys5
	 */
	public void setMzys5(String Mzys5) {
		setAttrVal("Mzys5", Mzys5);
	}
	/**
	 * 手术及操作编码6
	 * @return String
	 */
	public String getSsjczbm6() {
		return ((String) getAttrVal("Ssjczbm6"));
	}
	/**
	 * 手术及操作编码6
	 * @param Ssjczbm6
	 */
	public void setSsjczbm6(String Ssjczbm6) {
		setAttrVal("Ssjczbm6", Ssjczbm6);
	}
	/**
	 * 手术及操作日期6
	 * @return String
	 */
	public String getSsjczrq6() {
		return ((String) getAttrVal("Ssjczrq6"));
	}
	/**
	 * 手术及操作日期6
	 * @param Ssjczrq6
	 */
	public void setSsjczrq6(String Ssjczrq6) {
		setAttrVal("Ssjczrq6", Ssjczrq6);
	}
	/**
	 * 手术级别6
	 * @return String
	 */
	public String getSsjb6() {
		return ((String) getAttrVal("Ssjb6"));
	}
	/**
	 * 手术级别6
	 * @param Ssjb6
	 */
	public void setSsjb6(String Ssjb6) {
		setAttrVal("Ssjb6", Ssjb6);
	}
	/**
	 * 术者6
	 * @return String
	 */
	public String getSz6() {
		return ((String) getAttrVal("Sz6"));
	}
	/**
	 * 术者6
	 * @param Sz6
	 */
	public void setSz6(String Sz6) {
		setAttrVal("Sz6", Sz6);
	}
	/**
	 * 手术及操作名称6 
	 * @return String
	 */
	public String getSsjczmc6() {
		return ((String) getAttrVal("Ssjczmc6"));
	}
	/**
	 * 手术及操作名称6 
	 * @param Ssjczmc6
	 */
	public void setSsjczmc6(String Ssjczmc6) {
		setAttrVal("Ssjczmc6", Ssjczmc6);
	}
	/**
	 * I助6
	 * @return String
	 */
	public String getYz6() {
		return ((String) getAttrVal("Yz6"));
	}
	/**
	 * I助6
	 * @param Yz6
	 */
	public void setYz6(String Yz6) {
		setAttrVal("Yz6", Yz6);
	}
	/**
	 * II助6
	 * @return String
	 */
	public String getEz6() {
		return ((String) getAttrVal("Ez6"));
	}
	/**
	 * II助6
	 * @param Ez6
	 */
	public void setEz6(String Ez6) {
		setAttrVal("Ez6", Ez6);
	}
	/**
	 * 切口等级6
	 * @return String
	 */
	public String getQkdj6() {
		return ((String) getAttrVal("Qkdj6"));
	}
	/**
	 * 切口等级6
	 * @param Qkdj6
	 */
	public void setQkdj6(String Qkdj6) {
		setAttrVal("Qkdj6", Qkdj6);
	}
	/**
	 * 切口愈合类别6
	 * @return String
	 */
	public String getQkylb6() {
		return ((String) getAttrVal("Qkylb6"));
	}
	/**
	 * 切口愈合类别6
	 * @param Qkylb6
	 */
	public void setQkylb6(String Qkylb6) {
		setAttrVal("Qkylb6", Qkylb6);
	}
	/**
	 * 麻醉方式6
	 * @return String
	 */
	public String getMzfs6() {
		return ((String) getAttrVal("Mzfs6"));
	}
	/**
	 * 麻醉方式6
	 * @param Mzfs6
	 */
	public void setMzfs6(String Mzfs6) {
		setAttrVal("Mzfs6", Mzfs6);
	}
	/**
	 * 麻醉医师6
	 * @return String
	 */
	public String getMzys6() {
		return ((String) getAttrVal("Mzys6"));
	}
	/**
	 * 麻醉医师6
	 * @param Mzys6
	 */
	public void setMzys6(String Mzys6) {
		setAttrVal("Mzys6", Mzys6);
	}
	/**
	 * 离院方式
	 * @return String
	 */
	public String getLyfs() {
		return ((String) getAttrVal("Lyfs"));
	}
	/**
	 * 离院方式
	 * @param Lyfs
	 */
	public void setLyfs(String Lyfs) {
		setAttrVal("Lyfs", Lyfs);
	}
	/**
	 * 医嘱转院，拟接收医疗机构名称
	 * @return String
	 */
	public String getYzzy_jgmc() {
		return ((String) getAttrVal("Yzzy_jgmc"));
	}
	/**
	 * 医嘱转院，拟接收医疗机构名称
	 * @param Yzzy_jgmc
	 */
	public void setYzzy_jgmc(String Yzzy_jgmc) {
		setAttrVal("Yzzy_jgmc", Yzzy_jgmc);
	}
	/**
	 * 医嘱转社区卫生服务机构/乡镇卫生院，拟接收医疗机构名称
	 * @return String
	 */
	public String getWsy_jgmc() {
		return ((String) getAttrVal("Wsy_jgmc"));
	}
	/**
	 * 医嘱转社区卫生服务机构/乡镇卫生院，拟接收医疗机构名称
	 * @param Wsy_jgmc
	 */
	public void setWsy_jgmc(String Wsy_jgmc) {
		setAttrVal("Wsy_jgmc", Wsy_jgmc);
	}
	/**
	 * 是否有出院31天内再住院计划手术情况
	 * @return String
	 */
	public String getZzyjh() {
		return ((String) getAttrVal("Zzyjh"));
	}
	/**
	 * 是否有出院31天内再住院计划手术情况
	 * @param Zzyjh
	 */
	public void setZzyjh(String Zzyjh) {
		setAttrVal("Zzyjh", Zzyjh);
	}
	/**
	 * 目的
	 * @return String
	 */
	public String getMd() {
		return ((String) getAttrVal("Md"));
	}
	/**
	 * 目的
	 * @param Md
	 */
	public void setMd(String Md) {
		setAttrVal("Md", Md);
	}
	/**
	 * 颅脑损伤患者昏迷入院前时间：天
	 * @return String
	 */
	public String getRyq_t() {
		return ((String) getAttrVal("Ryq_t"));
	}
	/**
	 * 颅脑损伤患者昏迷入院前时间：天
	 * @param Ryq_t
	 */
	public void setRyq_t(String Ryq_t) {
		setAttrVal("Ryq_t", Ryq_t);
	}
	/**
	 * 颅脑损伤患者昏迷入院前时间：小时
	 * @return String
	 */
	public String getRyq_xs() {
		return ((String) getAttrVal("Ryq_xs"));
	}
	/**
	 * 颅脑损伤患者昏迷入院前时间：小时
	 * @param Ryq_xs
	 */
	public void setRyq_xs(String Ryq_xs) {
		setAttrVal("Ryq_xs", Ryq_xs);
	}
	/**
	 * 颅脑损伤患者昏迷入院前时间：分
	 * @return String
	 */
	public String getRyq_fz() {
		return ((String) getAttrVal("Ryq_fz"));
	}
	/**
	 * 颅脑损伤患者昏迷入院前时间：分
	 * @param Ryq_fz
	 */
	public void setRyq_fz(String Ryq_fz) {
		setAttrVal("Ryq_fz", Ryq_fz);
	}
	/**
	 * 颅脑损伤患者昏迷入院后时间：天
	 * @return String
	 */
	public String getRyh_t() {
		return ((String) getAttrVal("Ryh_t"));
	}
	/**
	 * 颅脑损伤患者昏迷入院后时间：天
	 * @param Ryh_t
	 */
	public void setRyh_t(String Ryh_t) {
		setAttrVal("Ryh_t", Ryh_t);
	}
	/**
	 * 颅脑损伤患者昏迷入院后时间：小时
	 * @return String
	 */
	public String getRyh_xs() {
		return ((String) getAttrVal("Ryh_xs"));
	}
	/**
	 * 颅脑损伤患者昏迷入院后时间：小时
	 * @param Ryh_xs
	 */
	public void setRyh_xs(String Ryh_xs) {
		setAttrVal("Ryh_xs", Ryh_xs);
	}
	/**
	 * 颅脑损伤患者昏迷入院后时间：分
	 * @return String
	 */
	public String getRyh_fz() {
		return ((String) getAttrVal("Ryh_fz"));
	}
	/**
	 * 颅脑损伤患者昏迷入院后时间：分
	 * @param Ryh_fz
	 */
	public void setRyh_fz(String Ryh_fz) {
		setAttrVal("Ryh_fz", Ryh_fz);
	}
	/**
	 * 住院费用(元)：总费用
	 * @return String
	 */
	public String getZfy() {
		return ((String) getAttrVal("Zfy"));
	}
	/**
	 * 住院费用(元)：总费用
	 * @param Zfy
	 */
	public void setZfy(String Zfy) {
		setAttrVal("Zfy", Zfy);
	}
	/**
	 * 自付金额
	 * @return String
	 */
	public String getZfje() {
		return ((String) getAttrVal("Zfje"));
	}
	/**
	 * 自付金额
	 * @param Zfje
	 */
	public void setZfje(String Zfje) {
		setAttrVal("Zfje", Zfje);
	}
	/**
	 * 综合医疗服务类：(1)一般医疗服务费
	 * @return String
	 */
	public String getYlfwf() {
		return ((String) getAttrVal("Ylfwf"));
	}
	/**
	 * 综合医疗服务类：(1)一般医疗服务费
	 * @param Ylfwf
	 */
	public void setYlfwf(String Ylfwf) {
		setAttrVal("Ylfwf", Ylfwf);
	}
	/**
	 * 中医辨证论治费
	 * @return String
	 */
	public String getBzlzf() {
		return ((String) getAttrVal("Bzlzf"));
	}
	/**
	 * 中医辨证论治费
	 * @param Bzlzf
	 */
	public void setBzlzf(String Bzlzf) {
		setAttrVal("Bzlzf", Bzlzf);
	}
	/**
	 * 中医辨证论治会诊费
	 * @return String
	 */
	public String getZyblzhzf() {
		return ((String) getAttrVal("Zyblzhzf"));
	}
	/**
	 * 中医辨证论治会诊费
	 * @param Zyblzhzf
	 */
	public void setZyblzhzf(String Zyblzhzf) {
		setAttrVal("Zyblzhzf", Zyblzhzf);
	}
	/**
	 * 一般治疗操作费
	 * @return String
	 */
	public String getZlczf() {
		return ((String) getAttrVal("Zlczf"));
	}
	/**
	 * 一般治疗操作费
	 * @param Zlczf
	 */
	public void setZlczf(String Zlczf) {
		setAttrVal("Zlczf", Zlczf);
	}
	/**
	 * 护理费住院费
	 * @return String
	 */
	public String getHlf() {
		return ((String) getAttrVal("Hlf"));
	}
	/**
	 * 护理费住院费
	 * @param Hlf
	 */
	public void setHlf(String Hlf) {
		setAttrVal("Hlf", Hlf);
	}
	/**
	 * 其他费用
	 * @return String
	 */
	public String getQtfy() {
		return ((String) getAttrVal("Qtfy"));
	}
	/**
	 * 其他费用
	 * @param Qtfy
	 */
	public void setQtfy(String Qtfy) {
		setAttrVal("Qtfy", Qtfy);
	}
	/**
	 * 诊断类：(5)病理诊断费
	 * @return String
	 */
	public String getBlzdf() {
		return ((String) getAttrVal("Blzdf"));
	}
	/**
	 * 诊断类：(5)病理诊断费
	 * @param Blzdf
	 */
	public void setBlzdf(String Blzdf) {
		setAttrVal("Blzdf", Blzdf);
	}
	/**
	 * 实验室诊断费
	 * @return String
	 */
	public String getZdf() {
		return ((String) getAttrVal("Zdf"));
	}
	/**
	 * 实验室诊断费
	 * @param Zdf
	 */
	public void setZdf(String Zdf) {
		setAttrVal("Zdf", Zdf);
	}
	/**
	 * 影像学诊断费
	 * @return String
	 */
	public String getYxxzdf() {
		return ((String) getAttrVal("Yxxzdf"));
	}
	/**
	 * 影像学诊断费
	 * @param Yxxzdf
	 */
	public void setYxxzdf(String Yxxzdf) {
		setAttrVal("Yxxzdf", Yxxzdf);
	}
	/**
	 * 临床诊断项目费
	 * @return String
	 */
	public String getLczdxmf() {
		return ((String) getAttrVal("Lczdxmf"));
	}
	/**
	 * 临床诊断项目费
	 * @param Lczdxmf
	 */
	public void setLczdxmf(String Lczdxmf) {
		setAttrVal("Lczdxmf", Lczdxmf);
	}
	/**
	 * 治疗类：(9)非手术治疗项目费
	 * @return String
	 */
	public String getFsszlxmf() {
		return ((String) getAttrVal("Fsszlxmf"));
	}
	/**
	 * 治疗类：(9)非手术治疗项目费
	 * @param Fsszlxmf
	 */
	public void setFsszlxmf(String Fsszlxmf) {
		setAttrVal("Fsszlxmf", Fsszlxmf);
	}
	/**
	 * 临床物理治疗费
	 * @return String
	 */
	public String getZlf() {
		return ((String) getAttrVal("Zlf"));
	}
	/**
	 * 临床物理治疗费
	 * @param Zlf
	 */
	public void setZlf(String Zlf) {
		setAttrVal("Zlf", Zlf);
	}
	/**
	 * 手术治疗费
	 * @return String
	 */
	public String getSszlf() {
		return ((String) getAttrVal("Sszlf"));
	}
	/**
	 * 手术治疗费
	 * @param Sszlf
	 */
	public void setSszlf(String Sszlf) {
		setAttrVal("Sszlf", Sszlf);
	}
	/**
	 * 麻醉费
	 * @return String
	 */
	public String getMzf() {
		return ((String) getAttrVal("Mzf"));
	}
	/**
	 * 麻醉费
	 * @param Mzf
	 */
	public void setMzf(String Mzf) {
		setAttrVal("Mzf", Mzf);
	}
	/**
	 * 手术费
	 * @return String
	 */
	public String getSsf() {
		return ((String) getAttrVal("Ssf"));
	}
	/**
	 * 手术费
	 * @param Ssf
	 */
	public void setSsf(String Ssf) {
		setAttrVal("Ssf", Ssf);
	}
	/**
	 * 康复类：(11)康复费
	 * @return String
	 */
	public String getKff() {
		return ((String) getAttrVal("Kff"));
	}
	/**
	 * 康复类：(11)康复费
	 * @param Kff
	 */
	public void setKff(String Kff) {
		setAttrVal("Kff", Kff);
	}
	/**
	 * 中医类(中医和名族医医疗服务)（12）中医诊断
	 * @return String
	 */
	public String getZyl_zyzd() {
		return ((String) getAttrVal("Zyl_zyzd"));
	}
	/**
	 * 中医类(中医和名族医医疗服务)（12）中医诊断
	 * @param Zyl_zyzd
	 */
	public void setZyl_zyzd(String Zyl_zyzd) {
		setAttrVal("Zyl_zyzd", Zyl_zyzd);
	}
	/**
	 * 中医治疗
	 * @return String
	 */
	public String getZyzl() {
		return ((String) getAttrVal("Zyzl"));
	}
	/**
	 * 中医治疗
	 * @param Zyzl
	 */
	public void setZyzl(String Zyzl) {
		setAttrVal("Zyzl", Zyzl);
	}
	/**
	 * 中医外治
	 * @return String
	 */
	public String getZywz() {
		return ((String) getAttrVal("Zywz"));
	}
	/**
	 * 中医外治
	 * @param Zywz
	 */
	public void setZywz(String Zywz) {
		setAttrVal("Zywz", Zywz);
	}
	/**
	 * 中医骨伤
	 * @return String
	 */
	public String getZygs() {
		return ((String) getAttrVal("Zygs"));
	}
	/**
	 * 中医骨伤
	 * @param Zygs
	 */
	public void setZygs(String Zygs) {
		setAttrVal("Zygs", Zygs);
	}
	/**
	 * 针刺与灸法
	 * @return String
	 */
	public String getZcyjf() {
		return ((String) getAttrVal("Zcyjf"));
	}
	/**
	 * 针刺与灸法
	 * @param Zcyjf
	 */
	public void setZcyjf(String Zcyjf) {
		setAttrVal("Zcyjf", Zcyjf);
	}
	/**
	 * 中医推拿治疗
	 * @return String
	 */
	public String getZytnzl() {
		return ((String) getAttrVal("Zytnzl"));
	}
	/**
	 * 中医推拿治疗
	 * @param Zytnzl
	 */
	public void setZytnzl(String Zytnzl) {
		setAttrVal("Zytnzl", Zytnzl);
	}
	/**
	 * 中医肛肠治疗
	 * @return String
	 */
	public String getZygczl() {
		return ((String) getAttrVal("Zygczl"));
	}
	/**
	 * 中医肛肠治疗
	 * @param Zygczl
	 */
	public void setZygczl(String Zygczl) {
		setAttrVal("Zygczl", Zygczl);
	}
	/**
	 * 中医特殊治疗
	 * @return String
	 */
	public String getZytszl() {
		return ((String) getAttrVal("Zytszl"));
	}
	/**
	 * 中医特殊治疗
	 * @param Zytszl
	 */
	public void setZytszl(String Zytszl) {
		setAttrVal("Zytszl", Zytszl);
	}
	/**
	 * 中医其他
	 * @return String
	 */
	public String getZyqt() {
		return ((String) getAttrVal("Zyqt"));
	}
	/**
	 * 中医其他
	 * @param Zyqt
	 */
	public void setZyqt(String Zyqt) {
		setAttrVal("Zyqt", Zyqt);
	}
	/**
	 * 中医特殊调配加工
	 * @return String
	 */
	public String getZytstpjg() {
		return ((String) getAttrVal("Zytstpjg"));
	}
	/**
	 * 中医特殊调配加工
	 * @param Zytstpjg
	 */
	public void setZytstpjg(String Zytstpjg) {
		setAttrVal("Zytstpjg", Zytstpjg);
	}
	/**
	 * 辨证施膳
	 * @return String
	 */
	public String getBzss() {
		return ((String) getAttrVal("Bzss"));
	}
	/**
	 * 辨证施膳
	 * @param Bzss
	 */
	public void setBzss(String Bzss) {
		setAttrVal("Bzss", Bzss);
	}
	/**
	 * 西药类:(13)西药费
	 * @return String
	 */
	public String getXyf() {
		return ((String) getAttrVal("Xyf"));
	}
	/**
	 * 西药类:(13)西药费
	 * @param Xyf
	 */
	public void setXyf(String Xyf) {
		setAttrVal("Xyf", Xyf);
	}
	/**
	 * 抗菌药物费
	 * @return String
	 */
	public String getKjywf() {
		return ((String) getAttrVal("Kjywf"));
	}
	/**
	 * 抗菌药物费
	 * @param Kjywf
	 */
	public void setKjywf(String Kjywf) {
		setAttrVal("Kjywf", Kjywf);
	}
	/**
	 * 中药类:(14)中成药费
	 * @return String
	 */
	public String getZcyf() {
		return ((String) getAttrVal("Zcyf"));
	}
	/**
	 * 中药类:(14)中成药费
	 * @param Zcyf
	 */
	public void setZcyf(String Zcyf) {
		setAttrVal("Zcyf", Zcyf);
	}
	/**
	 * 医疗机构中药制剂费
	 * @return String
	 */
	public String getZyzjf() {
		return ((String) getAttrVal("Zyzjf"));
	}
	/**
	 * 医疗机构中药制剂费
	 * @param Zyzjf
	 */
	public void setZyzjf(String Zyzjf) {
		setAttrVal("Zyzjf", Zyzjf);
	}
	/**
	 * 中草药费
	 * @return String
	 */
	public String getZcyf1() {
		return ((String) getAttrVal("Zcyf1"));
	}
	/**
	 * 中草药费
	 * @param Zcyf1
	 */
	public void setZcyf1(String Zcyf1) {
		setAttrVal("Zcyf1", Zcyf1);
	}
	/**
	 * 血液和血液制品类:(16)血费
	 * @return String
	 */
	public String getXf() {
		return ((String) getAttrVal("Xf"));
	}
	/**
	 * 血液和血液制品类:(16)血费
	 * @param Xf
	 */
	public void setXf(String Xf) {
		setAttrVal("Xf", Xf);
	}
	/**
	 * 白蛋白类制品费
	 * @return String
	 */
	public String getBdblzpf() {
		return ((String) getAttrVal("Bdblzpf"));
	}
	/**
	 * 白蛋白类制品费
	 * @param Bdblzpf
	 */
	public void setBdblzpf(String Bdblzpf) {
		setAttrVal("Bdblzpf", Bdblzpf);
	}
	/**
	 * 球蛋白类制品费
	 * @return String
	 */
	public String getQdblzpf() {
		return ((String) getAttrVal("Qdblzpf"));
	}
	/**
	 * 球蛋白类制品费
	 * @param Qdblzpf
	 */
	public void setQdblzpf(String Qdblzpf) {
		setAttrVal("Qdblzpf", Qdblzpf);
	}
	/**
	 * 凝血因子类制品费
	 * @return String
	 */
	public String getNxyzlzpf() {
		return ((String) getAttrVal("Nxyzlzpf"));
	}
	/**
	 * 凝血因子类制品费
	 * @param Nxyzlzpf
	 */
	public void setNxyzlzpf(String Nxyzlzpf) {
		setAttrVal("Nxyzlzpf", Nxyzlzpf);
	}
	/**
	 * 细胞因子类制品费
	 * @return String
	 */
	public String getXbyzlzpf() {
		return ((String) getAttrVal("Xbyzlzpf"));
	}
	/**
	 * 细胞因子类制品费
	 * @param Xbyzlzpf
	 */
	public void setXbyzlzpf(String Xbyzlzpf) {
		setAttrVal("Xbyzlzpf", Xbyzlzpf);
	}
	/**
	 * 耗材类:(21)检查用一次性医用材料费
	 * @return String
	 */
	public String getJcyyclf() {
		return ((String) getAttrVal("Jcyyclf"));
	}
	/**
	 * 耗材类:(21)检查用一次性医用材料费
	 * @param Jcyyclf
	 */
	public void setJcyyclf(String Jcyyclf) {
		setAttrVal("Jcyyclf", Jcyyclf);
	}
	/**
	 * (22)治疗用一次性医用材料费
	 * @return String
	 */
	public String getYyclf() {
		return ((String) getAttrVal("Yyclf"));
	}
	/**
	 * (22)治疗用一次性医用材料费
	 * @param Yyclf
	 */
	public void setYyclf(String Yyclf) {
		setAttrVal("Yyclf", Yyclf);
	}
	/**
	 * (23)手术用一次性医用材料费
	 * @return String
	 */
	public String getSsycxclf() {
		return ((String) getAttrVal("Ssycxclf"));
	}
	/**
	 * (23)手术用一次性医用材料费
	 * @param Ssycxclf
	 */
	public void setSsycxclf(String Ssycxclf) {
		setAttrVal("Ssycxclf", Ssycxclf);
	}
	/**
	 * 其他类：(24)其他费
	 * @return String
	 */
	public String getQtf() {
		return ((String) getAttrVal("Qtf"));
	}
	/**
	 * 其他类：(24)其他费
	 * @param Qtf
	 */
	public void setQtf(String Qtf) {
		setAttrVal("Qtf", Qtf);
	}
	/**
	 * 西-(年龄不足1周岁的)年龄(月)
	 * @return String
	 */
	public String getBzyzsnl() {
		return ((String) getAttrVal("Bzyzsnl"));
	}
	/**
	 * 西-(年龄不足1周岁的)年龄(月)
	 * @param Bzyzsnl
	 */
	public void setBzyzsnl(String Bzyzsnl) {
		setAttrVal("Bzyzsnl", Bzyzsnl);
	}
	/**
	 * 西-联系人电话
	 * @return String
	 */
	public String getDh2() {
		return ((String) getAttrVal("Dh2"));
	}
	/**
	 * 西-联系人电话
	 * @param Dh2
	 */
	public void setDh2(String Dh2) {
		setAttrVal("Dh2", Dh2);
	}
	/**
	 * 西-新生儿出生体重(克)
	 * @return String
	 */
	public String getXsecstz() {
		return ((String) getAttrVal("Xsecstz"));
	}
	/**
	 * 西-新生儿出生体重(克)
	 * @param Xsecstz
	 */
	public void setXsecstz(String Xsecstz) {
		setAttrVal("Xsecstz", Xsecstz);
	}
	/**
	 * 西-入院时间_时
	 * @return String
	 */
	public String getRysjs() {
		return ((String) getAttrVal("Rysjs"));
	}
	/**
	 * 西-入院时间_时
	 * @param Rysjs
	 */
	public void setRysjs(String Rysjs) {
		setAttrVal("Rysjs", Rysjs);
	}
	/**
	 * 西-出院时间_时
	 * @return String
	 */
	public String getCysjs() {
		return ((String) getAttrVal("Cysjs"));
	}
	/**
	 * 西-出院时间_时
	 * @param Cysjs
	 */
	public void setCysjs(String Cysjs) {
		setAttrVal("Cysjs", Cysjs);
	}
	/**
	 * 西-实际住院(天)
	 * @return String
	 */
	public String getSjzyts() {
		return ((String) getAttrVal("Sjzyts"));
	}
	/**
	 * 西-实际住院(天)
	 * @param Sjzyts
	 */
	public void setSjzyts(String Sjzyts) {
		setAttrVal("Sjzyts", Sjzyts);
	}
	/**
	 * 西-门(急)诊诊断
	 * @return String
	 */
	public String getMzzd() {
		return ((String) getAttrVal("Mzzd"));
	}
	/**
	 * 西-门(急)诊诊断
	 * @param Mzzd
	 */
	public void setMzzd(String Mzzd) {
		setAttrVal("Mzzd", Mzzd);
	}
	/**
	 * 西-主要诊断入院病情
	 * @return String
	 */
	public String getRybq() {
		return ((String) getAttrVal("Rybq"));
	}
	/**
	 * 西-主要诊断入院病情
	 * @param Rybq
	 */
	public void setRybq(String Rybq) {
		setAttrVal("Rybq", Rybq);
	}
	/**
	 * 西-其他诊断8
	 * @return String
	 */
	public String getQtzd8() {
		return ((String) getAttrVal("Qtzd8"));
	}
	/**
	 * 西-其他诊断8
	 * @param Qtzd8
	 */
	public void setQtzd8(String Qtzd8) {
		setAttrVal("Qtzd8", Qtzd8);
	}
	/**
	 * 西-其他诊断编码8
	 * @return String
	 */
	public String getJbdm8() {
		return ((String) getAttrVal("Jbdm8"));
	}
	/**
	 * 西-其他诊断编码8
	 * @param Jbdm8
	 */
	public void setJbdm8(String Jbdm8) {
		setAttrVal("Jbdm8", Jbdm8);
	}
	/**
	 * 西-其他诊断编码1
	 * @return String
	 */
	public String getJbdm1() {
		return ((String) getAttrVal("Jbdm1"));
	}
	/**
	 * 西-其他诊断编码1
	 * @param Jbdm1
	 */
	public void setJbdm1(String Jbdm1) {
		setAttrVal("Jbdm1", Jbdm1);
	}
	/**
	 * 西-其他诊断9
	 * @return String
	 */
	public String getQtzd9() {
		return ((String) getAttrVal("Qtzd9"));
	}
	/**
	 * 西-其他诊断9
	 * @param Qtzd9
	 */
	public void setQtzd9(String Qtzd9) {
		setAttrVal("Qtzd9", Qtzd9);
	}
	/**
	 * 西-其他诊断编码9
	 * @return String
	 */
	public String getJbdm9() {
		return ((String) getAttrVal("Jbdm9"));
	}
	/**
	 * 西-其他诊断编码9
	 * @param Jbdm9
	 */
	public void setJbdm9(String Jbdm9) {
		setAttrVal("Jbdm9", Jbdm9);
	}
	/**
	 * 西-入院病情9
	 * @return String
	 */
	public String getRybq9() {
		return ((String) getAttrVal("Rybq9"));
	}
	/**
	 * 西-入院病情9
	 * @param Rybq9
	 */
	public void setRybq9(String Rybq9) {
		setAttrVal("Rybq9", Rybq9);
	}
	/**
	 * 西-其他诊断编码2
	 * @return String
	 */
	public String getJbdm2() {
		return ((String) getAttrVal("Jbdm2"));
	}
	/**
	 * 西-其他诊断编码2
	 * @param Jbdm2
	 */
	public void setJbdm2(String Jbdm2) {
		setAttrVal("Jbdm2", Jbdm2);
	}
	/**
	 * 西-其他诊断10
	 * @return String
	 */
	public String getQtzd10() {
		return ((String) getAttrVal("Qtzd10"));
	}
	/**
	 * 西-其他诊断10
	 * @param Qtzd10
	 */
	public void setQtzd10(String Qtzd10) {
		setAttrVal("Qtzd10", Qtzd10);
	}
	/**
	 * 西-入院病情10
	 * @return String
	 */
	public String getRybq10() {
		return ((String) getAttrVal("Rybq10"));
	}
	/**
	 * 西-入院病情10
	 * @param Rybq10
	 */
	public void setRybq10(String Rybq10) {
		setAttrVal("Rybq10", Rybq10);
	}
	/**
	 * 西-其他诊断编码10
	 * @return String
	 */
	public String getJbdm10() {
		return ((String) getAttrVal("Jbdm10"));
	}
	/**
	 * 西-其他诊断编码10
	 * @param Jbdm10
	 */
	public void setJbdm10(String Jbdm10) {
		setAttrVal("Jbdm10", Jbdm10);
	}
	/**
	 * 西-其他诊断编码3
	 * @return String
	 */
	public String getJbdm3() {
		return ((String) getAttrVal("Jbdm3"));
	}
	/**
	 * 西-其他诊断编码3
	 * @param Jbdm3
	 */
	public void setJbdm3(String Jbdm3) {
		setAttrVal("Jbdm3", Jbdm3);
	}
	/**
	 * 西-其他诊断11
	 * @return String
	 */
	public String getQtzd11() {
		return ((String) getAttrVal("Qtzd11"));
	}
	/**
	 * 西-其他诊断11
	 * @param Qtzd11
	 */
	public void setQtzd11(String Qtzd11) {
		setAttrVal("Qtzd11", Qtzd11);
	}
	/**
	 * 西-其他诊断编码11
	 * @return String
	 */
	public String getJbdm11() {
		return ((String) getAttrVal("Jbdm11"));
	}
	/**
	 * 西-其他诊断编码11
	 * @param Jbdm11
	 */
	public void setJbdm11(String Jbdm11) {
		setAttrVal("Jbdm11", Jbdm11);
	}
	/**
	 * 西-其他诊断编码4
	 * @return String
	 */
	public String getJbdm4() {
		return ((String) getAttrVal("Jbdm4"));
	}
	/**
	 * 西-其他诊断编码4
	 * @param Jbdm4
	 */
	public void setJbdm4(String Jbdm4) {
		setAttrVal("Jbdm4", Jbdm4);
	}
	/**
	 * 西-其他诊断12
	 * @return String
	 */
	public String getQtzd12() {
		return ((String) getAttrVal("Qtzd12"));
	}
	/**
	 * 西-其他诊断12
	 * @param Qtzd12
	 */
	public void setQtzd12(String Qtzd12) {
		setAttrVal("Qtzd12", Qtzd12);
	}
	/**
	 * 西-其他诊断编码12
	 * @return String
	 */
	public String getJbdm12() {
		return ((String) getAttrVal("Jbdm12"));
	}
	/**
	 * 西-其他诊断编码12
	 * @param Jbdm12
	 */
	public void setJbdm12(String Jbdm12) {
		setAttrVal("Jbdm12", Jbdm12);
	}
	/**
	 * 西-入院病情12
	 * @return String
	 */
	public String getRybq12() {
		return ((String) getAttrVal("Rybq12"));
	}
	/**
	 * 西-入院病情12
	 * @param Rybq12
	 */
	public void setRybq12(String Rybq12) {
		setAttrVal("Rybq12", Rybq12);
	}
	/**
	 * 西-其他诊断编码5
	 * @return String
	 */
	public String getJbdm5() {
		return ((String) getAttrVal("Jbdm5"));
	}
	/**
	 * 西-其他诊断编码5
	 * @param Jbdm5
	 */
	public void setJbdm5(String Jbdm5) {
		setAttrVal("Jbdm5", Jbdm5);
	}
	/**
	 * 西-其他诊断13
	 * @return String
	 */
	public String getQtzd13() {
		return ((String) getAttrVal("Qtzd13"));
	}
	/**
	 * 西-其他诊断13
	 * @param Qtzd13
	 */
	public void setQtzd13(String Qtzd13) {
		setAttrVal("Qtzd13", Qtzd13);
	}
	/**
	 * 西-其他诊断编码13
	 * @return String
	 */
	public String getJbdm13() {
		return ((String) getAttrVal("Jbdm13"));
	}
	/**
	 * 西-其他诊断编码13
	 * @param Jbdm13
	 */
	public void setJbdm13(String Jbdm13) {
		setAttrVal("Jbdm13", Jbdm13);
	}
	/**
	 * 西-入院病情13
	 * @return String
	 */
	public String getRybq13() {
		return ((String) getAttrVal("Rybq13"));
	}
	/**
	 * 西-入院病情13
	 * @param Rybq13
	 */
	public void setRybq13(String Rybq13) {
		setAttrVal("Rybq13", Rybq13);
	}
	/**
	 * 西-其他诊断编码6
	 * @return String
	 */
	public String getJbdm6() {
		return ((String) getAttrVal("Jbdm6"));
	}
	/**
	 * 西-其他诊断编码6
	 * @param Jbdm6
	 */
	public void setJbdm6(String Jbdm6) {
		setAttrVal("Jbdm6", Jbdm6);
	}
	/**
	 * 西-其他诊断14
	 * @return String
	 */
	public String getQtzd14() {
		return ((String) getAttrVal("Qtzd14"));
	}
	/**
	 * 西-其他诊断14
	 * @param Qtzd14
	 */
	public void setQtzd14(String Qtzd14) {
		setAttrVal("Qtzd14", Qtzd14);
	}
	/**
	 * 西-其他诊断编码14
	 * @return String
	 */
	public String getJbdm14() {
		return ((String) getAttrVal("Jbdm14"));
	}
	/**
	 * 西-其他诊断编码14
	 * @param Jbdm14
	 */
	public void setJbdm14(String Jbdm14) {
		setAttrVal("Jbdm14", Jbdm14);
	}
	/**
	 * 西-入院病情14
	 * @return String
	 */
	public String getRybq14() {
		return ((String) getAttrVal("Rybq14"));
	}
	/**
	 * 西-入院病情14
	 * @param Rybq14
	 */
	public void setRybq14(String Rybq14) {
		setAttrVal("Rybq14", Rybq14);
	}
	/**
	 * 西-其他诊断编码7
	 * @return String
	 */
	public String getJbdm7() {
		return ((String) getAttrVal("Jbdm7"));
	}
	/**
	 * 西-其他诊断编码7
	 * @param Jbdm7
	 */
	public void setJbdm7(String Jbdm7) {
		setAttrVal("Jbdm7", Jbdm7);
	}
	/**
	 * 西-其他诊断15
	 * @return String
	 */
	public String getQtzd15() {
		return ((String) getAttrVal("Qtzd15"));
	}
	/**
	 * 西-其他诊断15
	 * @param Qtzd15
	 */
	public void setQtzd15(String Qtzd15) {
		setAttrVal("Qtzd15", Qtzd15);
	}
	/**
	 * 西-入院病情15
	 * @return String
	 */
	public String getRybq15() {
		return ((String) getAttrVal("Rybq15"));
	}
	/**
	 * 西-入院病情15
	 * @param Rybq15
	 */
	public void setRybq15(String Rybq15) {
		setAttrVal("Rybq15", Rybq15);
	}
	/**
	 * 西-其他诊断编码15
	 * @return String
	 */
	public String getJbdm15() {
		return ((String) getAttrVal("Jbdm15"));
	}
	/**
	 * 西-其他诊断编码15
	 * @param Jbdm15
	 */
	public void setJbdm15(String Jbdm15) {
		setAttrVal("Jbdm15", Jbdm15);
	}
	/**
	 * 西-中毒外部原因编码
	 * @return String
	 */
	public String getH23() {
		return ((String) getAttrVal("H23"));
	}
	/**
	 * 西-中毒外部原因编码
	 * @param H23
	 */
	public void setH23(String H23) {
		setAttrVal("H23", H23);
	}
	/**
	 * 西-病理诊断编码
	 * @return String
	 */
	public String getJbmm() {
		return ((String) getAttrVal("Jbmm"));
	}
	/**
	 * 西-病理诊断编码
	 * @param Jbmm
	 */
	public void setJbmm(String Jbmm) {
		setAttrVal("Jbmm", Jbmm);
	}
	/**
	 * 西-死亡患者尸检
	 * @return String
	 */
	public String getSwhzsj() {
		return ((String) getAttrVal("Swhzsj"));
	}
	/**
	 * 西-死亡患者尸检
	 * @param Swhzsj
	 */
	public void setSwhzsj(String Swhzsj) {
		setAttrVal("Swhzsj", Swhzsj);
	}
	/**
	 * 西-手术及操作编目7
	 * @return String
	 */
	public String getSsjczbm7() {
		return ((String) getAttrVal("Ssjczbm7"));
	}
	/**
	 * 西-手术及操作编目7
	 * @param Ssjczbm7
	 */
	public void setSsjczbm7(String Ssjczbm7) {
		setAttrVal("Ssjczbm7", Ssjczbm7);
	}
	/**
	 * 西-手术及操作日期7
	 * @return String
	 */
	public String getSsjczrq7() {
		return ((String) getAttrVal("Ssjczrq7"));
	}
	/**
	 * 西-手术及操作日期7
	 * @param Ssjczrq7
	 */
	public void setSsjczrq7(String Ssjczrq7) {
		setAttrVal("Ssjczrq7", Ssjczrq7);
	}
	/**
	 * 西-手术级别7
	 * @return String
	 */
	public String getSsjb7() {
		return ((String) getAttrVal("Ssjb7"));
	}
	/**
	 * 西-手术级别7
	 * @param Ssjb7
	 */
	public void setSsjb7(String Ssjb7) {
		setAttrVal("Ssjb7", Ssjb7);
	}
	/**
	 * 西-手术及操作名称7
	 * @return String
	 */
	public String getSsjczmc7() {
		return ((String) getAttrVal("Ssjczmc7"));
	}
	/**
	 * 西-手术及操作名称7
	 * @param Ssjczmc7
	 */
	public void setSsjczmc7(String Ssjczmc7) {
		setAttrVal("Ssjczmc7", Ssjczmc7);
	}
	/**
	 * 西-术者7
	 * @return String
	 */
	public String getSz7() {
		return ((String) getAttrVal("Sz7"));
	}
	/**
	 * 西-术者7
	 * @param Sz7
	 */
	public void setSz7(String Sz7) {
		setAttrVal("Sz7", Sz7);
	}
	/**
	 * 西-I助7
	 * @return String
	 */
	public String getYz7() {
		return ((String) getAttrVal("Yz7"));
	}
	/**
	 * 西-I助7
	 * @param Yz7
	 */
	public void setYz7(String Yz7) {
		setAttrVal("Yz7", Yz7);
	}
	/**
	 * 西-II助7
	 * @return String
	 */
	public String getEz7() {
		return ((String) getAttrVal("Ez7"));
	}
	/**
	 * 西-II助7
	 * @param Ez7
	 */
	public void setEz7(String Ez7) {
		setAttrVal("Ez7", Ez7);
	}
	/**
	 * 西-切口登记7
	 * @return String
	 */
	public String getQkdj7() {
		return ((String) getAttrVal("Qkdj7"));
	}
	/**
	 * 西-切口登记7
	 * @param Qkdj7
	 */
	public void setQkdj7(String Qkdj7) {
		setAttrVal("Qkdj7", Qkdj7);
	}
	/**
	 * 西-切口愈合类别7
	 * @return String
	 */
	public String getQkyhlb7() {
		return ((String) getAttrVal("Qkyhlb7"));
	}
	/**
	 * 西-切口愈合类别7
	 * @param Qkyhlb7
	 */
	public void setQkyhlb7(String Qkyhlb7) {
		setAttrVal("Qkyhlb7", Qkyhlb7);
	}
	/**
	 * 西-麻醉方式7
	 * @return String
	 */
	public String getMzfs7() {
		return ((String) getAttrVal("Mzfs7"));
	}
	/**
	 * 西-麻醉方式7
	 * @param Mzfs7
	 */
	public void setMzfs7(String Mzfs7) {
		setAttrVal("Mzfs7", Mzfs7);
	}
	/**
	 * 西-麻醉医师7
	 * @return String
	 */
	public String getMzys7() {
		return ((String) getAttrVal("Mzys7"));
	}
	/**
	 * 西-麻醉医师7
	 * @param Mzys7
	 */
	public void setMzys7(String Mzys7) {
		setAttrVal("Mzys7", Mzys7);
	}
	/**
	 * 西-医嘱转院，拟接收医疗机构名称
	 * @return String
	 */
	public String getYzzy_yljg() {
		return ((String) getAttrVal("Yzzy_yljg"));
	}
	/**
	 * 西-医嘱转院，拟接收医疗机构名称
	 * @param Yzzy_yljg
	 */
	public void setYzzy_yljg(String Yzzy_yljg) {
		setAttrVal("Yzzy_yljg", Yzzy_yljg);
	}
	/**
	 * 西-医嘱转社区服务机构/卫生院名
	 * @return String
	 */
	public String getWsy_yljg() {
		return ((String) getAttrVal("Wsy_yljg"));
	}
	/**
	 * 西-医嘱转社区服务机构/卫生院名
	 * @param Wsy_yljg
	 */
	public void setWsy_yljg(String Wsy_yljg) {
		setAttrVal("Wsy_yljg", Wsy_yljg);
	}
	/**
	 * 西-是否31再入院计划手术
	 * @return String
	 */
	public String getSfzzyjh() {
		return ((String) getAttrVal("Sfzzyjh"));
	}
	/**
	 * 西-是否31再入院计划手术
	 * @param Sfzzyjh
	 */
	public void setSfzzyjh(String Sfzzyjh) {
		setAttrVal("Sfzzyjh", Sfzzyjh);
	}
	/**
	 * 西-颅脑损伤患者昏迷入院后时间：分
	 * @return String
	 */
	public String getRyh_f() {
		return ((String) getAttrVal("Ryh_f"));
	}
	/**
	 * 西-颅脑损伤患者昏迷入院后时间：分
	 * @param Ryh_f
	 */
	public void setRyh_f(String Ryh_f) {
		setAttrVal("Ryh_f", Ryh_f);
	}
	/**
	 * 西-综合医疗服务类：（1）一般医疗服务费
	 * @return String
	 */
	public String getYlfuf() {
		return ((String) getAttrVal("Ylfuf"));
	}
	/**
	 * 西-综合医疗服务类：（1）一般医疗服务费
	 * @param Ylfuf
	 */
	public void setYlfuf(String Ylfuf) {
		setAttrVal("Ylfuf", Ylfuf);
	}
	/**
	 * 西-实验室诊断费
	 * @return String
	 */
	public String getSyszdf() {
		return ((String) getAttrVal("Syszdf"));
	}
	/**
	 * 西-实验室诊断费
	 * @param Syszdf
	 */
	public void setSyszdf(String Syszdf) {
		setAttrVal("Syszdf", Syszdf);
	}
	/**
	 * 西-临床物理治疗费
	 * @return String
	 */
	public String getWlzlf() {
		return ((String) getAttrVal("Wlzlf"));
	}
	/**
	 * 西-临床物理治疗费
	 * @param Wlzlf
	 */
	public void setWlzlf(String Wlzlf) {
		setAttrVal("Wlzlf", Wlzlf);
	}
	/**
	 * 西-麻醉费
	 * @return String
	 */
	public String getMaf() {
		return ((String) getAttrVal("Maf"));
	}
	/**
	 * 西-麻醉费
	 * @param Maf
	 */
	public void setMaf(String Maf) {
		setAttrVal("Maf", Maf);
	}
	/**
	 * 西-中医类：（12）中医治疗费
	 * @return String
	 */
	public String getZyzlf() {
		return ((String) getAttrVal("Zyzlf"));
	}
	/**
	 * 西-中医类：（12）中医治疗费
	 * @param Zyzlf
	 */
	public void setZyzlf(String Zyzlf) {
		setAttrVal("Zyzlf", Zyzlf);
	}
	/**
	 * 西-耗材类：（21）检查用一次性医用材料费
	 * @return String
	 */
	public String getHcyyclf() {
		return ((String) getAttrVal("Hcyyclf"));
	}
	/**
	 * 西-耗材类：（21）检查用一次性医用材料费
	 * @param Hcyyclf
	 */
	public void setHcyyclf(String Hcyyclf) {
		setAttrVal("Hcyyclf", Hcyyclf);
	}
	/**
	 * 西-手术级别1
	 * @return String
	 */
	public String getShjb1() {
		return ((String) getAttrVal("Shjb1"));
	}
	/**
	 * 西-手术级别1
	 * @param Shjb1
	 */
	public void setShjb1(String Shjb1) {
		setAttrVal("Shjb1", Shjb1);
	}
	/**
	 * 西-手术级别2
	 * @return String
	 */
	public String getShjb2() {
		return ((String) getAttrVal("Shjb2"));
	}
	/**
	 * 西-手术级别2
	 * @param Shjb2
	 */
	public void setShjb2(String Shjb2) {
		setAttrVal("Shjb2", Shjb2);
	}
	/**
	 * 西-手术级别3
	 * @return String
	 */
	public String getShjb3() {
		return ((String) getAttrVal("Shjb3"));
	}
	/**
	 * 西-手术级别3
	 * @param Shjb3
	 */
	public void setShjb3(String Shjb3) {
		setAttrVal("Shjb3", Shjb3);
	}
	/**
	 * 西-手术级别4
	 * @return String
	 */
	public String getShjb4() {
		return ((String) getAttrVal("Shjb4"));
	}
	/**
	 * 西-手术级别4
	 * @param Shjb4
	 */
	public void setShjb4(String Shjb4) {
		setAttrVal("Shjb4", Shjb4);
	}
	/**
	 * 西-手术级别5
	 * @return String
	 */
	public String getShjb5() {
		return ((String) getAttrVal("Shjb5"));
	}
	/**
	 * 西-手术级别5
	 * @param Shjb5
	 */
	public void setShjb5(String Shjb5) {
		setAttrVal("Shjb5", Shjb5);
	}
	/**
	 * 西-手术级别6
	 * @return String
	 */
	public String getShjb6() {
		return ((String) getAttrVal("Shjb6"));
	}
	/**
	 * 西-手术级别6
	 * @param Shjb6
	 */
	public void setShjb6(String Shjb6) {
		setAttrVal("Shjb6", Shjb6);
	}
	/**
	 * 西-入院病情8
	 * @return String
	 */
	public String getRybq8() {
		return ((String) getAttrVal("Rybq8"));
	}
	/**
	 * 西-入院病情8
	 * @param Rybq8
	 */
	public void setRybq8(String Rybq8) {
		setAttrVal("Rybq8", Rybq8);
	}
	/**
	 * 西-入院病情11
	 * @return String
	 */
	public String getRybq11() {
		return ((String) getAttrVal("Rybq11"));
	}
	/**
	 * 西-入院病情11
	 * @param Rybq11
	 */
	public void setRybq11(String Rybq11) {
		setAttrVal("Rybq11", Rybq11);
	}
	/**
	 * 西-切口愈合类别1
	 * @return String
	 */
	public String getQkyhlb1() {
		return ((String) getAttrVal("Qkyhlb1"));
	}
	/**
	 * 西-切口愈合类别1
	 * @param Qkyhlb1
	 */
	public void setQkyhlb1(String Qkyhlb1) {
		setAttrVal("Qkyhlb1", Qkyhlb1);
	}
	/**
	 * 西-切口愈合类别2
	 * @return String
	 */
	public String getQkyhlb2() {
		return ((String) getAttrVal("Qkyhlb2"));
	}
	/**
	 * 西-切口愈合类别2
	 * @param Qkyhlb2
	 */
	public void setQkyhlb2(String Qkyhlb2) {
		setAttrVal("Qkyhlb2", Qkyhlb2);
	}
	/**
	 * 西-切口愈合类别3
	 * @return String
	 */
	public String getQkyhlb3() {
		return ((String) getAttrVal("Qkyhlb3"));
	}
	/**
	 * 西-切口愈合类别3
	 * @param Qkyhlb3
	 */
	public void setQkyhlb3(String Qkyhlb3) {
		setAttrVal("Qkyhlb3", Qkyhlb3);
	}
	/**
	 * 西-切口愈合类别4
	 * @return String
	 */
	public String getQkyhlb4() {
		return ((String) getAttrVal("Qkyhlb4"));
	}
	/**
	 * 西-切口愈合类别4
	 * @param Qkyhlb4
	 */
	public void setQkyhlb4(String Qkyhlb4) {
		setAttrVal("Qkyhlb4", Qkyhlb4);
	}
	/**
	 * 西-切口愈合类别5
	 * @return String
	 */
	public String getQkyhlb5() {
		return ((String) getAttrVal("Qkyhlb5"));
	}
	/**
	 * 西-切口愈合类别5
	 * @param Qkyhlb5
	 */
	public void setQkyhlb5(String Qkyhlb5) {
		setAttrVal("Qkyhlb5", Qkyhlb5);
	}
	/**
	 * 西-切口愈合类别6
	 * @return String
	 */
	public String getQkyhlb6() {
		return ((String) getAttrVal("Qkyhlb6"));
	}
	/**
	 * 西-切口愈合类别6
	 * @param Qkyhlb6
	 */
	public void setQkyhlb6(String Qkyhlb6) {
		setAttrVal("Qkyhlb6", Qkyhlb6);
	}
	/**
	 * 上报对照消息
	 * @return String
	 */
	public String getMsg() {
		return ((String) getAttrVal("Msg"));
	}
	/**
	 * 上报对照消息
	 * @param Msg
	 */
	public void setMsg(String Msg) {
		setAttrVal("Msg", Msg);
	}
	/**
	 * 手术用一次性医用材料费
	 * @return String
	 */
	public String getYcxyyclf() {
		return ((String) getAttrVal("Ycxyyclf"));
	}
	/**
	 * 手术用一次性医用材料费
	 * @param Ycxyyclf
	 */
	public void setYcxyyclf(String Ycxyyclf) {
		setAttrVal("Ycxyyclf", Ycxyyclf);
	}
	/**
	 * 出生地_省
	 * @return String
	 */
	public String getCsd_sg() {
		return ((String) getAttrVal("Csd_sg"));
	}
	/**
	 * 出生地_省
	 * @param Csd_sg
	 */
	public void setCsd_sg(String Csd_sg) {
		setAttrVal("Csd_sg", Csd_sg);
	}
	/**
	 * 出生地—市
	 * @return String
	 */
	public String getCsd_si() {
		return ((String) getAttrVal("Csd_si"));
	}
	/**
	 * 出生地—市
	 * @param Csd_si
	 */
	public void setCsd_si(String Csd_si) {
		setAttrVal("Csd_si", Csd_si);
	}
	/**
	 * 出生地—区县
	 * @return String
	 */
	public String getCsd_qx() {
		return ((String) getAttrVal("Csd_qx"));
	}
	/**
	 * 出生地—区县
	 * @param Csd_qx
	 */
	public void setCsd_qx(String Csd_qx) {
		setAttrVal("Csd_qx", Csd_qx);
	}
	/**
	 * 出生地—详细地址
	 * @return String
	 */
	public String getCsd_dz() {
		return ((String) getAttrVal("Csd_dz"));
	}
	/**
	 * 出生地—详细地址
	 * @param Csd_dz
	 */
	public void setCsd_dz(String Csd_dz) {
		setAttrVal("Csd_dz", Csd_dz);
	}
	/**
	 * 籍贯—省
	 * @return String
	 */
	public String getGg_sg() {
		return ((String) getAttrVal("Gg_sg"));
	}
	/**
	 * 籍贯—省
	 * @param Gg_sg
	 */
	public void setGg_sg(String Gg_sg) {
		setAttrVal("Gg_sg", Gg_sg);
	}
	/**
	 * 籍贯—市
	 * @return String
	 */
	public String getGg_si() {
		return ((String) getAttrVal("Gg_si"));
	}
	/**
	 * 籍贯—市
	 * @param Gg_si
	 */
	public void setGg_si(String Gg_si) {
		setAttrVal("Gg_si", Gg_si);
	}
	/**
	 * 身份证件类别
	 * @return String
	 */
	public String getSfzjlb() {
		return ((String) getAttrVal("Sfzjlb"));
	}
	/**
	 * 身份证件类别
	 * @param Sfzjlb
	 */
	public void setSfzjlb(String Sfzjlb) {
		setAttrVal("Sfzjlb", Sfzjlb);
	}
	/**
	 * 现住址—省
	 * @return String
	 */
	public String getXzz_sg() {
		return ((String) getAttrVal("Xzz_sg"));
	}
	/**
	 * 现住址—省
	 * @param Xzz_sg
	 */
	public void setXzz_sg(String Xzz_sg) {
		setAttrVal("Xzz_sg", Xzz_sg);
	}
	/**
	 * 现住址—市
	 * @return String
	 */
	public String getXzz_si() {
		return ((String) getAttrVal("Xzz_si"));
	}
	/**
	 * 现住址—市
	 * @param Xzz_si
	 */
	public void setXzz_si(String Xzz_si) {
		setAttrVal("Xzz_si", Xzz_si);
	}
	/**
	 * 现住址—区县
	 * @return String
	 */
	public String getXzz_qx() {
		return ((String) getAttrVal("Xzz_qx"));
	}
	/**
	 * 现住址—区县
	 * @param Xzz_qx
	 */
	public void setXzz_qx(String Xzz_qx) {
		setAttrVal("Xzz_qx", Xzz_qx);
	}
	/**
	 * 现住址—详细地址
	 * @return String
	 */
	public String getXzz_dz() {
		return ((String) getAttrVal("Xzz_dz"));
	}
	/**
	 * 现住址—详细地址
	 * @param Xzz_dz
	 */
	public void setXzz_dz(String Xzz_dz) {
		setAttrVal("Xzz_dz", Xzz_dz);
	}
	/**
	 * 户口地址—省
	 * @return String
	 */
	public String getHkdz_sg() {
		return ((String) getAttrVal("Hkdz_sg"));
	}
	/**
	 * 户口地址—省
	 * @param Hkdz_sg
	 */
	public void setHkdz_sg(String Hkdz_sg) {
		setAttrVal("Hkdz_sg", Hkdz_sg);
	}
	/**
	 * 户口地址—市
	 * @return String
	 */
	public String getHkdz_si() {
		return ((String) getAttrVal("Hkdz_si"));
	}
	/**
	 * 户口地址—市
	 * @param Hkdz_si
	 */
	public void setHkdz_si(String Hkdz_si) {
		setAttrVal("Hkdz_si", Hkdz_si);
	}
	/**
	 * 户口地址—区县
	 * @return String
	 */
	public String getHkdz_qx() {
		return ((String) getAttrVal("Hkdz_qx"));
	}
	/**
	 * 户口地址—区县
	 * @param Hkdz_qx
	 */
	public void setHkdz_qx(String Hkdz_qx) {
		setAttrVal("Hkdz_qx", Hkdz_qx);
	}
	/**
	 * 户口地址—详细地址
	 * @return String
	 */
	public String getHkdz_dz() {
		return ((String) getAttrVal("Hkdz_dz"));
	}
	/**
	 * 户口地址—详细地址
	 * @param Hkdz_dz
	 */
	public void setHkdz_dz(String Hkdz_dz) {
		setAttrVal("Hkdz_dz", Hkdz_dz);
	}
	/**
	 * 工作单位名称
	 * @return String
	 */
	public String getGzdwjdzmc() {
		return ((String) getAttrVal("Gzdwjdzmc"));
	}
	/**
	 * 工作单位名称
	 * @param Gzdwjdzmc
	 */
	public void setGzdwjdzmc(String Gzdwjdzmc) {
		setAttrVal("Gzdwjdzmc", Gzdwjdzmc);
	}
	/**
	 * 工作单位及地址—省
	 * @return String
	 */
	public String getGzdwjdz_sg() {
		return ((String) getAttrVal("Gzdwjdz_sg"));
	}
	/**
	 * 工作单位及地址—省
	 * @param Gzdwjdz_sg
	 */
	public void setGzdwjdz_sg(String Gzdwjdz_sg) {
		setAttrVal("Gzdwjdz_sg", Gzdwjdz_sg);
	}
	/**
	 * 工作单位及地址—市
	 * @return String
	 */
	public String getGzdwjdz_si() {
		return ((String) getAttrVal("Gzdwjdz_si"));
	}
	/**
	 * 工作单位及地址—市
	 * @param Gzdwjdz_si
	 */
	public void setGzdwjdz_si(String Gzdwjdz_si) {
		setAttrVal("Gzdwjdz_si", Gzdwjdz_si);
	}
	/**
	 * 工作单位及地址—区县
	 * @return String
	 */
	public String getGzdwjdz_qx() {
		return ((String) getAttrVal("Gzdwjdz_qx"));
	}
	/**
	 * 工作单位及地址—区县
	 * @param Gzdwjdz_qx
	 */
	public void setGzdwjdz_qx(String Gzdwjdz_qx) {
		setAttrVal("Gzdwjdz_qx", Gzdwjdz_qx);
	}
	/**
	 * 工作单位及地址—详细地址
	 * @return String
	 */
	public String getGzdwjdz_dz() {
		return ((String) getAttrVal("Gzdwjdz_dz"));
	}
	/**
	 * 工作单位及地址—详细地址
	 * @param Gzdwjdz_dz
	 */
	public void setGzdwjdz_dz(String Gzdwjdz_dz) {
		setAttrVal("Gzdwjdz_dz", Gzdwjdz_dz);
	}
	/**
	 * 地址—省
	 * @return String
	 */
	public String getDz_sg() {
		return ((String) getAttrVal("Dz_sg"));
	}
	/**
	 * 地址—省
	 * @param Dz_sg
	 */
	public void setDz_sg(String Dz_sg) {
		setAttrVal("Dz_sg", Dz_sg);
	}
	/**
	 * 地址—市
	 * @return String
	 */
	public String getDz_si() {
		return ((String) getAttrVal("Dz_si"));
	}
	/**
	 * 地址—市
	 * @param Dz_si
	 */
	public void setDz_si(String Dz_si) {
		setAttrVal("Dz_si", Dz_si);
	}
	/**
	 * 地址—区县
	 * @return String
	 */
	public String getDz_qx() {
		return ((String) getAttrVal("Dz_qx"));
	}
	/**
	 * 地址—区县
	 * @param Dz_qx
	 */
	public void setDz_qx(String Dz_qx) {
		setAttrVal("Dz_qx", Dz_qx);
	}
	/**
	 * 地址—详细地址
	 * @return String
	 */
	public String getDz_dz() {
		return ((String) getAttrVal("Dz_dz"));
	}
	/**
	 * 地址—详细地址
	 * @param Dz_dz
	 */
	public void setDz_dz(String Dz_dz) {
		setAttrVal("Dz_dz", Dz_dz);
	}
	/**
	 * 转诊医疗机构名称
	 * @return String
	 */
	public String getZzyljgmc() {
		return ((String) getAttrVal("Zzyljgmc"));
	}
	/**
	 * 转诊医疗机构名称
	 * @param Zzyljgmc
	 */
	public void setZzyljgmc(String Zzyljgmc) {
		setAttrVal("Zzyljgmc", Zzyljgmc);
	}
	/**
	 * 转科科别1
	 * @return String
	 */
	public String getZkkb1() {
		return ((String) getAttrVal("Zkkb1"));
	}
	/**
	 * 转科科别1
	 * @param Zkkb1
	 */
	public void setZkkb1(String Zkkb1) {
		setAttrVal("Zkkb1", Zkkb1);
	}
	/**
	 * 转科科别2
	 * @return String
	 */
	public String getZkkb2() {
		return ((String) getAttrVal("Zkkb2"));
	}
	/**
	 * 转科科别2
	 * @param Zkkb2
	 */
	public void setZkkb2(String Zkkb2) {
		setAttrVal("Zkkb2", Zkkb2);
	}
	/**
	 * ICD-O-3
	 * @return String
	 */
	public String getIcdo3() {
		return ((String) getAttrVal("Icdo3"));
	}
	/**
	 * ICD-O-3
	 * @param Icdo3
	 */
	public void setIcdo3(String Icdo3) {
		setAttrVal("Icdo3", Icdo3);
	}
	/**
	 * 最高诊断依据
	 * @return String
	 */
	public String getZgzdyj() {
		return ((String) getAttrVal("Zgzdyj"));
	}
	/**
	 * 最高诊断依据
	 * @param Zgzdyj
	 */
	public void setZgzdyj(String Zgzdyj) {
		setAttrVal("Zgzdyj", Zgzdyj);
	}
	/**
	 * 特级护理__天
	 * @return Integer
	 */
	public Integer getTjhl_t() {
		return ((Integer) getAttrVal("Tjhl_t"));
	}
	/**
	 * 特级护理__天
	 * @param Tjhl_t
	 */
	public void setTjhl_t(Integer Tjhl_t) {
		setAttrVal("Tjhl_t", Tjhl_t);
	}
	/**
	 * Ⅰ级护理__天
	 * @return Integer
	 */
	public Integer getYjhl_t() {
		return ((Integer) getAttrVal("Yjhl_t"));
	}
	/**
	 * Ⅰ级护理__天
	 * @param Yjhl_t
	 */
	public void setYjhl_t(Integer Yjhl_t) {
		setAttrVal("Yjhl_t", Yjhl_t);
	}
	/**
	 * Ⅱ级护理__天
	 * @return Integer
	 */
	public Integer getEjhl_t() {
		return ((Integer) getAttrVal("Ejhl_t"));
	}
	/**
	 * Ⅱ级护理__天
	 * @param Ejhl_t
	 */
	public void setEjhl_t(Integer Ejhl_t) {
		setAttrVal("Ejhl_t", Ejhl_t);
	}
	/**
	 * Ⅲ级护理__天
	 * @return Integer
	 */
	public Integer getSjhl_t() {
		return ((Integer) getAttrVal("Sjhl_t"));
	}
	/**
	 * Ⅲ级护理__天
	 * @param Sjhl_t
	 */
	public void setSjhl_t(Integer Sjhl_t) {
		setAttrVal("Sjhl_t", Sjhl_t);
	}
	/**
	 * 医疗组长
	 * @return String
	 */
	public String getYlzz() {
		return ((String) getAttrVal("Ylzz"));
	}
	/**
	 * 医疗组长
	 * @param Ylzz
	 */
	public void setYlzz(String Ylzz) {
		setAttrVal("Ylzz", Ylzz);
	}
	/**
	 * 手术类型
	 * @return String
	 */
	public String getSslx1() {
		return ((String) getAttrVal("Sslx1"));
	}
	/**
	 * 手术类型
	 * @param Sslx1
	 */
	public void setSslx1(String Sslx1) {
		setAttrVal("Sslx1", Sslx1);
	}
	/**
	 * 手术类型2
	 * @return String
	 */
	public String getSslx2() {
		return ((String) getAttrVal("Sslx2"));
	}
	/**
	 * 手术类型2
	 * @param Sslx2
	 */
	public void setSslx2(String Sslx2) {
		setAttrVal("Sslx2", Sslx2);
	}
	/**
	 * 手术类型3
	 * @return String
	 */
	public String getSslx3() {
		return ((String) getAttrVal("Sslx3"));
	}
	/**
	 * 手术类型3
	 * @param Sslx3
	 */
	public void setSslx3(String Sslx3) {
		setAttrVal("Sslx3", Sslx3);
	}
	/**
	 * 手术类型4
	 * @return String
	 */
	public String getSslx4() {
		return ((String) getAttrVal("Sslx4"));
	}
	/**
	 * 手术类型4
	 * @param Sslx4
	 */
	public void setSslx4(String Sslx4) {
		setAttrVal("Sslx4", Sslx4);
	}
	/**
	 * 手术类型5
	 * @return String
	 */
	public String getSslx5() {
		return ((String) getAttrVal("Sslx5"));
	}
	/**
	 * 手术类型5
	 * @param Sslx5
	 */
	public void setSslx5(String Sslx5) {
		setAttrVal("Sslx5", Sslx5);
	}
	/**
	 * 手术类型6
	 * @return String
	 */
	public String getSslx6() {
		return ((String) getAttrVal("Sslx6"));
	}
	/**
	 * 手术类型6
	 * @param Sslx6
	 */
	public void setSslx6(String Sslx6) {
		setAttrVal("Sslx6", Sslx6);
	}
	/**
	 * 手术类型7
	 * @return String
	 */
	public String getSslx7() {
		return ((String) getAttrVal("Sslx7"));
	}
	/**
	 * 手术类型7
	 * @param Sslx7
	 */
	public void setSslx7(String Sslx7) {
		setAttrVal("Sslx7", Sslx7);
	}
	/**
	 * 手术及操作编码8
	 * @return String
	 */
	public String getSsjczbm8() {
		return ((String) getAttrVal("Ssjczbm8"));
	}
	/**
	 * 手术及操作编码8
	 * @param Ssjczbm8
	 */
	public void setSsjczbm8(String Ssjczbm8) {
		setAttrVal("Ssjczbm8", Ssjczbm8);
	}
	/**
	 * 手术及操作日期8
	 * @return String
	 */
	public String getSsjczrq8() {
		return ((String) getAttrVal("Ssjczrq8"));
	}
	/**
	 * 手术及操作日期8
	 * @param Ssjczrq8
	 */
	public void setSsjczrq8(String Ssjczrq8) {
		setAttrVal("Ssjczrq8", Ssjczrq8);
	}
	/**
	 * 手术级别8
	 * @return String
	 */
	public String getSsjb8() {
		return ((String) getAttrVal("Ssjb8"));
	}
	/**
	 * 手术级别8
	 * @param Ssjb8
	 */
	public void setSsjb8(String Ssjb8) {
		setAttrVal("Ssjb8", Ssjb8);
	}
	/**
	 * 手术类型8
	 * @return String
	 */
	public String getSslx8() {
		return ((String) getAttrVal("Sslx8"));
	}
	/**
	 * 手术类型8
	 * @param Sslx8
	 */
	public void setSslx8(String Sslx8) {
		setAttrVal("Sslx8", Sslx8);
	}
	/**
	 * 手术及操作名称8
	 * @return String
	 */
	public String getSsjczmc8() {
		return ((String) getAttrVal("Ssjczmc8"));
	}
	/**
	 * 手术及操作名称8
	 * @param Ssjczmc8
	 */
	public void setSsjczmc8(String Ssjczmc8) {
		setAttrVal("Ssjczmc8", Ssjczmc8);
	}
	/**
	 * 术者8
	 * @return String
	 */
	public String getSz8() {
		return ((String) getAttrVal("Sz8"));
	}
	/**
	 * 术者8
	 * @param Sz8
	 */
	public void setSz8(String Sz8) {
		setAttrVal("Sz8", Sz8);
	}
	/**
	 * I助8
	 * @return String
	 */
	public String getYz8() {
		return ((String) getAttrVal("Yz8"));
	}
	/**
	 * I助8
	 * @param Yz8
	 */
	public void setYz8(String Yz8) {
		setAttrVal("Yz8", Yz8);
	}
	/**
	 * II助8
	 * @return String
	 */
	public String getEz8() {
		return ((String) getAttrVal("Ez8"));
	}
	/**
	 * II助8
	 * @param Ez8
	 */
	public void setEz8(String Ez8) {
		setAttrVal("Ez8", Ez8);
	}
	/**
	 * 切口等级8
	 * @return String
	 */
	public String getQkdj8() {
		return ((String) getAttrVal("Qkdj8"));
	}
	/**
	 * 切口等级8
	 * @param Qkdj8
	 */
	public void setQkdj8(String Qkdj8) {
		setAttrVal("Qkdj8", Qkdj8);
	}
	/**
	 * 切口愈合类别8
	 * @return String
	 */
	public String getQkyhlb8() {
		return ((String) getAttrVal("Qkyhlb8"));
	}
	/**
	 * 切口愈合类别8
	 * @param Qkyhlb8
	 */
	public void setQkyhlb8(String Qkyhlb8) {
		setAttrVal("Qkyhlb8", Qkyhlb8);
	}
	/**
	 * 麻醉方式8
	 * @return String
	 */
	public String getMzfs8() {
		return ((String) getAttrVal("Mzfs8"));
	}
	/**
	 * 麻醉方式8
	 * @param Mzfs8
	 */
	public void setMzfs8(String Mzfs8) {
		setAttrVal("Mzfs8", Mzfs8);
	}
	/**
	 * 麻醉医师8
	 * @return String
	 */
	public String getMzys8() {
		return ((String) getAttrVal("Mzys8"));
	}
	/**
	 * 麻醉医师8
	 * @param Mzys8
	 */
	public void setMzys8(String Mzys8) {
		setAttrVal("Mzys8", Mzys8);
	}
	/**
	 * 入径情况
	 * @return String
	 */
	public String getRjqk() {
		return ((String) getAttrVal("Rjqk"));
	}
	/**
	 * 入径情况
	 * @param Rjqk
	 */
	public void setRjqk(String Rjqk) {
		setAttrVal("Rjqk", Rjqk);
	}
	/**
	 * 完成情况
	 * @return String
	 */
	public String getWcqk() {
		return ((String) getAttrVal("Wcqk"));
	}
	/**
	 * 完成情况
	 * @param Wcqk
	 */
	public void setWcqk(String Wcqk) {
		setAttrVal("Wcqk", Wcqk);
	}
	/**
	 * 变异情况
	 * @return String
	 */
	public String getByqk() {
		return ((String) getAttrVal("Byqk"));
	}
	/**
	 * 变异情况
	 * @param Byqk
	 */
	public void setByqk(String Byqk) {
		setAttrVal("Byqk", Byqk);
	}
	/**
	 * 医保类型名称
	 * @return String
	 */
	public String getYblx() {
		return ((String) getAttrVal("Yblx"));
	}
	/**
	 * 医保类型名称
	 * @param Yblx
	 */
	public void setYblx(String Yblx) {
		setAttrVal("Yblx", Yblx);
	}
}