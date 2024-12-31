package iih.bd.fc.dto.orwf.d;

import java.util.List;

import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FTime;

/**
 * 
 * @author hjh
 * @version 2019年12月26日14:56:05 增加年龄等级限制
 */
public class CfgFlowBas {

	private String id_wf_cfg;
	private String id_wf;
	private Integer eu_wftp;
	private Integer sortno;
	private FBoolean fg_macro;
	private Integer eu_macro;
	private String id_dep_mp;
	private Integer eu_srvca;
	private List<String> listSrvca;
	private List<String> listSrvcaInnercode;
	private Integer eu_srv;
	private List<String> listSrv;
	private Integer eu_dosage;
	private List<String> listDosage;
	private Integer eu_pois;
	private List<String> listPosi;
	private Integer eu_mm;
	private List<String> listMm;
	private Integer eu_herbperp;
	private List<String> listHerbperp;
	private Integer eu_dep_or;
	private List<String> listDepor;
	private Integer eu_dep_phy;
	private List<String> listDepphy;
	private Integer eu_dep_nur;
	private List<String> listDepnur;
	private Integer eu_route;
	private List<String> listRoute;
	private Integer eu_week;
	private List<String> listWeek;
	private Integer eu_age;
	private List<String> listAgeLevel;
	private FBoolean fg_mmwh;
	private FBoolean fg_stock;
	private Integer eu_long;
	private Integer eu_pres_out;
	private FTime time_begin;
	private FTime time_end;
	private Integer eu_dep_record;
	private List<String> listDepRecord;

	public String getId_wf_cfg() {
		return id_wf_cfg;
	}

	public void setId_wf_cfg(String id_wf_cfg) {
		this.id_wf_cfg = id_wf_cfg;
	}

	public String getId_wf() {
		return id_wf;
	}

	public void setId_wf(String id_wf) {
		this.id_wf = id_wf;
	}

	public Integer getEu_wftp() {
		return eu_wftp;
	}

	public void setEu_wftp(Integer eu_wftp) {
		this.eu_wftp = eu_wftp;
	}

	public Integer getSortno() {
		return sortno;
	}

	public void setSortno(Integer sortno) {
		this.sortno = sortno;
	}

	public FBoolean getFg_macro() {
		return fg_macro;
	}

	public void setFg_macro(FBoolean fg_macro) {
		this.fg_macro = fg_macro;
	}

	public Integer getEu_macro() {
		return eu_macro;
	}

	public void setEu_macro(Integer eu_macro) {
		this.eu_macro = eu_macro;
	}

	public String getId_dep_mp() {
		return id_dep_mp;
	}

	public void setId_dep_mp(String id_dep_mp) {
		this.id_dep_mp = id_dep_mp;
	}

	public Integer getEu_srvca() {
		return eu_srvca;
	}

	public void setEu_srvca(Integer eu_srvca) {
		this.eu_srvca = eu_srvca;
	}

	public List<String> getListSrvca() {
		return listSrvca;
	}

	public void setListSrvca(List<String> listSrvca) {
		this.listSrvca = listSrvca;
	}

	public List<String> getListSrvcaInnercode() {
		return listSrvcaInnercode;
	}

	public void setListSrvcaInnercode(List<String> listSrvcaInnercode) {
		this.listSrvcaInnercode = listSrvcaInnercode;
	}

	public Integer getEu_srv() {
		return eu_srv;
	}

	public void setEu_srv(Integer eu_srv) {
		this.eu_srv = eu_srv;
	}

	public List<String> getListSrv() {
		return listSrv;
	}

	public void setListSrv(List<String> listSrv) {
		this.listSrv = listSrv;
	}

	public Integer getEu_dosage() {
		return eu_dosage;
	}

	public void setEu_dosage(Integer eu_dosage) {
		this.eu_dosage = eu_dosage;
	}

	public List<String> getListDosage() {
		return listDosage;
	}

	public void setListDosage(List<String> listDosage) {
		this.listDosage = listDosage;
	}

	public Integer getEu_pois() {
		return eu_pois;
	}

	public void setEu_pois(Integer eu_pois) {
		this.eu_pois = eu_pois;
	}

	public List<String> getListPosi() {
		return listPosi;
	}

	public void setListPosi(List<String> listPosi) {
		this.listPosi = listPosi;
	}

	public Integer getEu_mm() {
		return eu_mm;
	}

	public void setEu_mm(Integer eu_mm) {
		this.eu_mm = eu_mm;
	}

	public List<String> getListMm() {
		return listMm;
	}

	public void setListMm(List<String> listMm) {
		this.listMm = listMm;
	}

	public Integer getEu_herbperp() {
		return eu_herbperp;
	}

	public void setEu_herbperp(Integer eu_herbperp) {
		this.eu_herbperp = eu_herbperp;
	}

	public List<String> getListHerbperp() {
		return listHerbperp;
	}

	public void setListHerbperp(List<String> listHerbperp) {
		this.listHerbperp = listHerbperp;
	}

	public Integer getEu_dep_or() {
		return eu_dep_or;
	}

	public void setEu_dep_or(Integer eu_dep_or) {
		this.eu_dep_or = eu_dep_or;
	}

	public List<String> getListDepor() {
		return listDepor;
	}

	public void setListDepor(List<String> listDepor) {
		this.listDepor = listDepor;
	}

	public Integer getEu_dep_phy() {
		return eu_dep_phy;
	}

	public void setEu_dep_phy(Integer eu_dep_phy) {
		this.eu_dep_phy = eu_dep_phy;
	}

	public List<String> getListDepphy() {
		return listDepphy;
	}

	public void setListDepphy(List<String> listDepphy) {
		this.listDepphy = listDepphy;
	}

	public Integer getEu_dep_nur() {
		return eu_dep_nur;
	}

	public void setEu_dep_nur(Integer eu_dep_nur) {
		this.eu_dep_nur = eu_dep_nur;
	}

	public List<String> getListDepnur() {
		return listDepnur;
	}

	public void setListDepnur(List<String> listDepnur) {
		this.listDepnur = listDepnur;
	}

	public Integer getEu_route() {
		return eu_route;
	}

	public void setEu_route(Integer eu_route) {
		this.eu_route = eu_route;
	}

	public List<String> getListRoute() {
		return listRoute;
	}

	public void setListRoute(List<String> listRoute) {
		this.listRoute = listRoute;
	}

	public Integer getEu_week() {
		return eu_week;
	}

	public void setEu_week(Integer eu_week) {
		this.eu_week = eu_week;
	}

	public List<String> getListWeek() {
		return listWeek;
	}

	public void setListWeek(List<String> listWeek) {
		this.listWeek = listWeek;
	}

	public Integer getEu_age() {
		return eu_age;
	}

	public void setEu_age(Integer eu_age) {
		this.eu_age = eu_age;
	}

	public List<String> getListAgeLevel() {
		return listAgeLevel;
	}

	public void setListAgeLevel(List<String> listAgeLevel) {
		this.listAgeLevel = listAgeLevel;
	}

	public FBoolean getFg_mmwh() {
		return fg_mmwh;
	}

	public void setFg_mmwh(FBoolean fg_mmwh) {
		this.fg_mmwh = fg_mmwh;
	}

	public FBoolean getFg_stock() {
		return fg_stock;
	}

	public void setFg_stock(FBoolean fg_stock) {
		this.fg_stock = fg_stock;
	}

	public Integer getEu_long() {
		return eu_long;
	}

	public void setEu_long(Integer eu_long) {
		this.eu_long = eu_long;
	}

	public Integer getEu_pres_out() {
		return eu_pres_out;
	}

	public void setEu_pres_out(Integer eu_pres_out) {
		this.eu_pres_out = eu_pres_out;
	}

	public FTime getTime_begin() {
		return time_begin;
	}

	public void setTime_begin(FTime time_begin) {
		this.time_begin = time_begin;
	}

	public FTime getTime_end() {
		return time_end;
	}

	public void setTime_end(FTime time_end) {
		this.time_end = time_end;
	}

	public Integer getEu_dep_record() {
		return eu_dep_record;
	}

	public void setEu_dep_record(Integer eu_dep_record) {
		this.eu_dep_record = eu_dep_record;
	}

	public List<String> getListDepRecord() {
		return listDepRecord;
	}

	public void setListDepRecord(List<String> listDepRecord) {
		this.listDepRecord = listDepRecord;
	}

}
