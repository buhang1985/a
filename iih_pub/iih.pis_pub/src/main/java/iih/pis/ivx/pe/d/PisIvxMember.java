package iih.pis.ivx.pe.d;

public class PisIvxMember {
	//微信就诊人主键标识
		public String id_pisivxmember;
		//微信账户ID
		public String id_pisivxaccount;
		//患者ID
		public String id_pat;
		//姓名
		public String name;
		//性别编码
		public String sd_sex;
		//性别
		public String name_sex;
		//出生日期
		public String dt_birth;
		//出生日期(时分秒)
		public String dt_birth_hms;
		//主身份标志类型
		public String id_idtp;
		//主身份标志类型编码
		public String sd_idtP;
		//主身份标识号码
		public String id_code;
		//年龄
		public String age;
		//创建人
		public String createdby;
		//创建时间
		public String createdtime;
		//最后修改人
		public String modifiedby;
		//最后修改时间
		public String modifiedtime;
		//移动电话
		public String mob;
		//HIS患者编号
		public String patcode;
		//就诊卡号
		public String cardcode;
		//住院号
		public String ipcode;
		//绑定标识
		public String fg_bind;
		//电子就诊卡号
		public String ecardno;
		//关系
		public String rel;
		//编码
		public String code_id;
		//名称
		public String name_id;
		//参保机构代码
		public String insuredorgcode;
		//患者医保卡号
		public String medinscode;
		public String code;
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getInsuredorgcode() {
			return insuredorgcode;
		}
		public void setInsuredorgcode(String insuredorgcode) {
			this.insuredorgcode = insuredorgcode;
		}
		public String getMedinscode() {
			return medinscode;
		}
		public void setMedinscode(String medinscode) {
			this.medinscode = medinscode;
		}
		public String getId_pisivxmember() {
			return id_pisivxmember;
		}
		public void setId_pisivxmember(String id_pisivxmember) {
			this.id_pisivxmember = id_pisivxmember;
		}
		public String getId_pisivxaccount() {
			return id_pisivxaccount;
		}
		public void setId_pisivxaccount(String id_pisivxaccount) {
			this.id_pisivxaccount = id_pisivxaccount;
		}
		public String getId_pat() {
			return id_pat;
		}
		public void setId_pat(String id_pat) {
			this.id_pat = id_pat;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getSd_sex() {
			return sd_sex;
		}
		public void setSd_sex(String sd_sex) {
			this.sd_sex = sd_sex;
		}
		public String getName_sex() {
			return name_sex;
		}
		public void setName_sex(String name_sex) {
			this.name_sex = name_sex;
		}
		public String getDt_birth() {
			return dt_birth;
		}
		public void setDt_birth(String dt_birth) {
			this.dt_birth = dt_birth;
		}
		public String getDt_birth_hms() {
			return dt_birth_hms;
		}
		public void setDt_birth_hms(String dt_birth_hms) {
			this.dt_birth_hms = dt_birth_hms;
		}
		public String getId_idtp() {
			return id_idtp;
		}
		public void setId_idtp(String id_idtp) {
			this.id_idtp = id_idtp;
		}
		public String getSd_idtP() {
			return sd_idtP;
		}
		public void setSd_idtP(String sd_idtP) {
			this.sd_idtP = sd_idtP;
		}
		public String getId_code() {
			return id_code;
		}
		public void setId_code(String id_code) {
			this.id_code = id_code;
		}
		public String getAge() {
			return age;
		}
		public void setAge(String age) {
			this.age = age;
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
		public String getMob() {
			return mob;
		}
		public void setMob(String mob) {
			this.mob = mob;
		}
		public String getPatcode() {
			return patcode;
		}
		public void setPatcode(String patcode) {
			this.patcode = patcode;
		}
		public String getCardcode() {
			return cardcode;
		}
		public void setCardcode(String cardcode) {
			this.cardcode = cardcode;
		}
		public String getIpcode() {
			return ipcode;
		}
		public void setIpcode(String ipcode) {
			this.ipcode = ipcode;
		}
		public String getFg_bind() {
			return fg_bind;
		}
		public void setFg_bind(String fg_bind) {
			this.fg_bind = fg_bind;
		}
		public String getEcardno() {
			return ecardno;
		}
		public void setEcardno(String ecardno) {
			this.ecardno = ecardno;
		}
		public String getRel() {
			return rel;
		}
		public void setRel(String rel) {
			this.rel = rel;
		}
		public String getCode_id() {
			return code_id;
		}
		public void setCode_id(String code_id) {
			this.code_id = code_id;
		}
		public String getName_id() {
			return name_id;
		}
		public void setName_id(String name_id) {
			this.name_id = name_id;
		}
		@Override
		public String toString() {
			return "PisIvxMember [id_pisivxmember=" + id_pisivxmember + ", id_pisivxaccount=" + id_pisivxaccount
					+ ", id_pat=" + id_pat + ", name=" + name + ", sd_sex=" + sd_sex + ", name_sex=" + name_sex
					+ ", dt_birth=" + dt_birth + ", dt_birth_hms=" + dt_birth_hms + ", id_idtp=" + id_idtp
					+ ", sd_idtP=" + sd_idtP + ", id_code=" + id_code + ", age=" + age + ", createdby=" + createdby
					+ ", createdtime=" + createdtime + ", modifiedby=" + modifiedby + ", modifiedtime=" + modifiedtime
					+ ", mob=" + mob + ", patcode=" + patcode + ", cardcode=" + cardcode + ", ipcode=" + ipcode
					+ ", fg_bind=" + fg_bind + ", ecardno=" + ecardno + ", rel=" + rel + ", code_id=" + code_id
					+ ", name_id=" + name_id + "]";
		}
		
}
