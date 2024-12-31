package iih.mp.nr.common.dto;

import java.io.Serializable;

/**
 * @Description:档案数据DO
 * @author:zhongcl@founder.com.cn
 * @version:2019年1月9日 下午3:23:47 创建
 */
public class UdidocDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1470438640927200909L;
	
    /** 档案id **/
	public  String id_udidoc ;
	
	/** 档案模板Id **/
	public  String id_udidoclist;
	
	public  String code;
	public  String name ;
	public  String shortname;
	public  String code_std;
	public  String mnecode ;
	public  String pycode ;
	public  String wbcode ;
	public  String des;
	public  String id_parent ;
	public  String memo ;
	public  String innercode ;
	public  String activestate ;
	public  String seqno ;
	public  String fg_sys ;
	public  String ctrl1 ;
	public  String ctrl2;
	public  String ctrl3 ;
	public  String ctrl4 ;
	public  String ctrl5;
	public  String code_ie ;
	public  String code_rel1 ;
	public  String code_rel2 ;
	public  String code_rel3 ;
	public  String code_rel4;
	public  String code_rel5 ;
	public  String udi_code ;
	public  String udi_name ;
	public  String org_code ;
	public  String org_name ;
	public  String par_code ;
	public  String par_name ;
	public  String cre_name ;
	public  String cre_code ;
	public  String mod_name ;
	public  String mod_code ;
	
	public String getId_udidoc() {
		return id_udidoc;
	}
	public void setId_udidoc(String id_udidoc) {
		this.id_udidoc = id_udidoc;
	}
	public String getId_udidoclist() {
		return id_udidoclist;
	}
	public void setId_udidoclist(String id_udidoclist) {
		this.id_udidoclist = id_udidoclist;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShortname() {
		return shortname;
	}
	public void setShortname(String shortname) {
		this.shortname = shortname;
	}
	public String getCode_std() {
		return code_std;
	}
	public void setCode_std(String code_std) {
		this.code_std = code_std;
	}
	public String getMnecode() {
		return mnecode;
	}
	public void setMnecode(String mnecode) {
		this.mnecode = mnecode;
	}
	public String getPycode() {
		return pycode;
	}
	public void setPycode(String pycode) {
		this.pycode = pycode;
	}
	public String getWbcode() {
		return wbcode;
	}
	public void setWbcode(String wbcode) {
		this.wbcode = wbcode;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public String getId_parent() {
		return id_parent;
	}
	public void setId_parent(String id_parent) {
		this.id_parent = id_parent;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getInnercode() {
		return innercode;
	}
	public void setInnercode(String innercode) {
		this.innercode = innercode;
	}
	public String getActivestate() {
		return activestate;
	}
	public void setActivestate(String activestate) {
		this.activestate = activestate;
	}
	public String getSeqno() {
		return seqno;
	}
	public void setSeqno(String seqno) {
		this.seqno = seqno;
	}
	public String getFg_sys() {
		return fg_sys;
	}
	public void setFg_sys(String fg_sys) {
		this.fg_sys = fg_sys;
	}
	public String getCtrl1() {
		return ctrl1;
	}
	public void setCtrl1(String ctrl1) {
		this.ctrl1 = ctrl1;
	}
	public String getCtrl2() {
		return ctrl2;
	}
	public void setCtrl2(String ctrl2) {
		this.ctrl2 = ctrl2;
	}
	public String getCtrl3() {
		return ctrl3;
	}
	public void setCtrl3(String ctrl3) {
		this.ctrl3 = ctrl3;
	}
	public String getCtrl4() {
		return ctrl4;
	}
	public void setCtrl4(String ctrl4) {
		this.ctrl4 = ctrl4;
	}
	public String getCtrl5() {
		return ctrl5;
	}
	public void setCtrl5(String ctrl5) {
		this.ctrl5 = ctrl5;
	}
	public String getCode_ie() {
		return code_ie;
	}
	public void setCode_ie(String code_ie) {
		this.code_ie = code_ie;
	}
	public String getCode_rel1() {
		return code_rel1;
	}
	public void setCode_rel1(String code_rel1) {
		this.code_rel1 = code_rel1;
	}
	public String getCode_rel2() {
		return code_rel2;
	}
	public void setCode_rel2(String code_rel2) {
		this.code_rel2 = code_rel2;
	}
	public String getCode_rel3() {
		return code_rel3;
	}
	public void setCode_rel3(String code_rel3) {
		this.code_rel3 = code_rel3;
	}
	public String getCode_rel4() {
		return code_rel4;
	}
	public void setCode_rel4(String code_rel4) {
		this.code_rel4 = code_rel4;
	}
	public String getCode_rel5() {
		return code_rel5;
	}
	public void setCode_rel5(String code_rel5) {
		this.code_rel5 = code_rel5;
	}
	public String getUdi_code() {
		return udi_code;
	}
	public void setUdi_code(String udi_code) {
		this.udi_code = udi_code;
	}
	public String getUdi_name() {
		return udi_name;
	}
	public void setUdi_name(String udi_name) {
		this.udi_name = udi_name;
	}
	public String getOrg_code() {
		return org_code;
	}
	public void setOrg_code(String org_code) {
		this.org_code = org_code;
	}
	public String getOrg_name() {
		return org_name;
	}
	public void setOrg_name(String org_name) {
		this.org_name = org_name;
	}
	public String getPar_code() {
		return par_code;
	}
	public void setPar_code(String par_code) {
		this.par_code = par_code;
	}
	public String getPar_name() {
		return par_name;
	}
	public void setPar_name(String par_name) {
		this.par_name = par_name;
	}
	public String getCre_name() {
		return cre_name;
	}
	public void setCre_name(String cre_name) {
		this.cre_name = cre_name;
	}
	public String getCre_code() {
		return cre_code;
	}
	public void setCre_code(String cre_code) {
		this.cre_code = cre_code;
	}
	public String getMod_name() {
		return mod_name;
	}
	public void setMod_name(String mod_name) {
		this.mod_name = mod_name;
	}
	public String getMod_code() {
		return mod_code;
	}
	public void setMod_code(String mod_code) {
		this.mod_code = mod_code;
	}

}
