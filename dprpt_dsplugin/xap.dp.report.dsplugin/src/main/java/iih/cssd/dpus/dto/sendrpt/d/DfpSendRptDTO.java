package iih.cssd.dpus.dto.sendrpt.d;

import java.util.*;

/**
 * 消毒包发放清单
 * 
 */
public class DfpSendRptDTO{
	
	/** 请领科室ID */
	private String id_dep_app;
	/** 请领单ID */
	private String id_dfp_app;
	/** 请领类型 */
	private String id_pkg;
	/** 消毒包类型 */
	private String name_pkg;
	/** 请领分类标识 */
	private String id_apppkg;
	/** 请领子项主键 */
	private String id_dfp_app_itm;
	/** 请领科室 */
	private String name_dep_app;
	/** 请领人 */
	private String name_emp_app;
	/** 请领时间 */
	private String dt_apply;
	/** 请领单号 */
	private String applyno;
	/** 请领汇总信息 */
	private String des_app_info;
	/** 包装材料 */
	private String name_pkgmtr;
	/** 规格 */
	private String spec;
	/** 请领数量 */
	private Integer count;
	/** 序号 */
	private String sortno;
	/** 消毒包名称 */
	private String name;
	/** 识别码 */
	private String no_bar;
	/** 灭菌时间 */
	private String dt_srlz;
	/** 生产时间 */
	private String dt_prd;
	/** 发送单号 */
	private String sendno;
	/** 发放时间 */
	private String dt_send;
	/** 发放人 */
	private String name_emp_send;
	/** 发放备注 */
	private String des_send;
	/** 发放标记 */
	private String fg_send;
	/** 消毒包清单 */
	private List<DfpSendRptDTO> arrayschild;

	/** getter and setter */
	
	public String getId_dep_app(){
		return this.id_dep_app;
	}

	public void setId_dep_app(String id_dep_app){
		this.id_dep_app = id_dep_app;
	}
	
	public String getId_dfp_app(){
		return this.id_dfp_app;
	}

	public void setId_dfp_app(String id_dfp_app){
		this.id_dfp_app = id_dfp_app;
	}
	
	public String getId_pkg(){
		return this.id_pkg;
	}

	public void setId_pkg(String id_pkg){
		this.id_pkg = id_pkg;
	}
	
	public String getName_pkg(){
		return this.name_pkg;
	}

	public void setName_pkg(String name_pkg){
		this.name_pkg = name_pkg;
	}
	
	public String getId_apppkg(){
		return this.id_apppkg;
	}

	public void setId_apppkg(String id_apppkg){
		this.id_apppkg = id_apppkg;
	}
	
	public String getId_dfp_app_itm(){
		return this.id_dfp_app_itm;
	}

	public void setId_dfp_app_itm(String id_dfp_app_itm){
		this.id_dfp_app_itm = id_dfp_app_itm;
	}
	
	public String getName_dep_app(){
		return this.name_dep_app;
	}

	public void setName_dep_app(String name_dep_app){
		this.name_dep_app = name_dep_app;
	}
	
	public String getName_emp_app(){
		return this.name_emp_app;
	}

	public void setName_emp_app(String name_emp_app){
		this.name_emp_app = name_emp_app;
	}
	
	public String getDt_apply(){
		return this.dt_apply;
	}

	public void setDt_apply(String dt_apply){
		this.dt_apply = dt_apply;
	}
	
	public String getApplyno(){
		return this.applyno;
	}

	public void setApplyno(String applyno){
		this.applyno = applyno;
	}
	
	public String getDes_app_info(){
		return this.des_app_info;
	}

	public void setDes_app_info(String des_app_info){
		this.des_app_info = des_app_info;
	}
	
	public String getName_pkgmtr(){
		return this.name_pkgmtr;
	}

	public void setName_pkgmtr(String name_pkgmtr){
		this.name_pkgmtr = name_pkgmtr;
	}
	
	public String getSpec(){
		return this.spec;
	}

	public void setSpec(String spec){
		this.spec = spec;
	}
	
	public Integer getCount(){
		return this.count;
	}

	public void setCount(Integer count){
		this.count = count;
	}
	
	public String getSortno(){
		return this.sortno;
	}

	public void setSortno(String sortno){
		this.sortno = sortno;
	}
	
	public String getName(){
		return this.name;
	}

	public void setName(String name){
		this.name = name;
	}
	
	public String getNo_bar(){
		return this.no_bar;
	}

	public void setNo_bar(String no_bar){
		this.no_bar = no_bar;
	}
	
	public String getDt_srlz(){
		return this.dt_srlz;
	}

	public void setDt_srlz(String dt_srlz){
		this.dt_srlz = dt_srlz;
	}
	
	public String getDt_prd(){
		return this.dt_prd;
	}

	public void setDt_prd(String dt_prd){
		this.dt_prd = dt_prd;
	}
	
	public String getSendno(){
		return this.sendno;
	}

	public void setSendno(String sendno){
		this.sendno = sendno;
	}
	
	public String getDt_send(){
		return this.dt_send;
	}

	public void setDt_send(String dt_send){
		this.dt_send = dt_send;
	}
	
	public String getName_emp_send(){
		return this.name_emp_send;
	}

	public void setName_emp_send(String name_emp_send){
		this.name_emp_send = name_emp_send;
	}
	
	public String getDes_send(){
		return this.des_send;
	}

	public void setDes_send(String des_send){
		this.des_send = des_send;
	}
	
	public String getFg_send(){
		return this.fg_send;
	}

	public void setFg_send(String fg_send){
		this.fg_send = fg_send;
	}
	
	public List<DfpSendRptDTO> getArrayschild(){
		return this.arrayschild;
	}

	public void setArrayschild(List<DfpSendRptDTO> arrayschild){
		this.arrayschild = arrayschild;
	}
}