package iih.cssd.dfp.dto.dfplable.d;

import java.util.*;

/**
 * 消毒包标签
 * 
 */
public class DfpLableInfoDTO{
	
	/** 消毒包ID */
	private String id_dfp;
	/** 消毒包名称 */
	private String name;
	/** 消毒包编码 */
	private String code;
	/** 包类型 */
	private String name_pkgtp;
	/** 生效时间 */
	private String dt_effe;
	/** 失效时间 */
	private String dt_inval;
	/** 识别码 */
	private String no_bar;
	/** 包规格 */
	private String spec;
	/** 清洗方式 */
	private String name_pkgclean;
	/** 灭菌方式 */
	private String name_pkgstz;
	/** 灭菌时间 */
	private String dt_srlz;
	/** 包装材料 */
	private String name_pkgmtr;
	/** 生产人 */
	private String name_emp_prd;
	/** 生产科室 */
	private String name_dep_prd;
	/** 生产时间 */
	private String dt_prd;
	/** 包描述 */
	private String note;
	/** 核包人 */
	private String name_emp_chk;
	/** 配包人 */
	private String name_emp_pkg;
	/** 物品集合 */
	private List<DfpLableInfoDTO> dfpmminfos;
	/** 物品名称 */
	private String mm_name;
	/** 物品数量 */
	private String mm_quan;
	/** 包装单位 */
	private String name_unit_pkgbase;

	/** getter and setter */
	
	public String getId_dfp(){
		return this.id_dfp;
	}

	public void setId_dfp(String id_dfp){
		this.id_dfp = id_dfp;
	}
	
	public String getName(){
		return this.name;
	}

	public void setName(String name){
		this.name = name;
	}
	
	public String getCode(){
		return this.code;
	}

	public void setCode(String code){
		this.code = code;
	}
	
	public String getName_pkgtp(){
		return this.name_pkgtp;
	}

	public void setName_pkgtp(String name_pkgtp){
		this.name_pkgtp = name_pkgtp;
	}
	
	public String getDt_effe(){
		return this.dt_effe;
	}

	public void setDt_effe(String dt_effe){
		this.dt_effe = dt_effe;
	}
	
	public String getDt_inval(){
		return this.dt_inval;
	}

	public void setDt_inval(String dt_inval){
		this.dt_inval = dt_inval;
	}
	
	public String getNo_bar(){
		return this.no_bar;
	}

	public void setNo_bar(String no_bar){
		this.no_bar = no_bar;
	}
	
	public String getSpec(){
		return this.spec;
	}

	public void setSpec(String spec){
		this.spec = spec;
	}
	
	public String getName_pkgclean(){
		return this.name_pkgclean;
	}

	public void setName_pkgclean(String name_pkgclean){
		this.name_pkgclean = name_pkgclean;
	}
	
	public String getName_pkgstz(){
		return this.name_pkgstz;
	}

	public void setName_pkgstz(String name_pkgstz){
		this.name_pkgstz = name_pkgstz;
	}
	
	public String getDt_srlz(){
		return this.dt_srlz;
	}

	public void setDt_srlz(String dt_srlz){
		this.dt_srlz = dt_srlz;
	}
	
	public String getName_pkgmtr(){
		return this.name_pkgmtr;
	}

	public void setName_pkgmtr(String name_pkgmtr){
		this.name_pkgmtr = name_pkgmtr;
	}
	
	public String getName_emp_prd(){
		return this.name_emp_prd;
	}

	public void setName_emp_prd(String name_emp_prd){
		this.name_emp_prd = name_emp_prd;
	}
	
	public String getName_dep_prd(){
		return this.name_dep_prd;
	}

	public void setName_dep_prd(String name_dep_prd){
		this.name_dep_prd = name_dep_prd;
	}
	
	public String getDt_prd(){
		return this.dt_prd;
	}

	public void setDt_prd(String dt_prd){
		this.dt_prd = dt_prd;
	}
	
	public String getNote(){
		return this.note;
	}

	public void setNote(String note){
		this.note = note;
	}
	
	public String getName_emp_chk(){
		return this.name_emp_chk;
	}

	public void setName_emp_chk(String name_emp_chk){
		this.name_emp_chk = name_emp_chk;
	}
	
	public String getName_emp_pkg(){
		return this.name_emp_pkg;
	}

	public void setName_emp_pkg(String name_emp_pkg){
		this.name_emp_pkg = name_emp_pkg;
	}
	
	public List<DfpLableInfoDTO> getDfpmminfos(){
		return this.dfpmminfos;
	}

	public void setDfpmminfos(List<DfpLableInfoDTO> dfpmminfos){
		this.dfpmminfos = dfpmminfos;
	}
	
	public String getMm_name(){
		return this.mm_name;
	}

	public void setMm_name(String mm_name){
		this.mm_name = mm_name;
	}
	
	public String getMm_quan(){
		return this.mm_quan;
	}

	public void setMm_quan(String mm_quan){
		this.mm_quan = mm_quan;
	}
	
	public String getName_unit_pkgbase(){
		return this.name_unit_pkgbase;
	}

	public void setName_unit_pkgbase(String name_unit_pkgbase){
		this.name_unit_pkgbase = name_unit_pkgbase;
	}
}