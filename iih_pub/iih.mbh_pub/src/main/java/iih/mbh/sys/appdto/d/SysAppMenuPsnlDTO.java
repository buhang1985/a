package iih.mbh.sys.appdto.d;

import java.util.List;

public class SysAppMenuPsnlDTO {

	// 应用ID
	private String id_app;
	// 应用菜单ID
	private String id_app_menu;
	// 应用菜单参数
	private String id_app_menu_psnl;
	// 科室
	private String id_dep;
	// 人员
	private String id_emp;

	public String getId_app() {
		return id_app;
	}

	public void setId_app(String id_app) {
		this.id_app = id_app;
	}

	public String getId_app_menu() {
		return id_app_menu;
	}

	public void setId_app_menu(String id_app_menu) {
		this.id_app_menu = id_app_menu;
	}

	public String getId_app_menu_psnl() {
		return id_app_menu_psnl;
	}

	public void setId_app_menu_psnl(String id_app_menu_psnl) {
		this.id_app_menu_psnl = id_app_menu_psnl;
	}

	public String getId_dep() {
		return id_dep;
	}

	public void setId_dep(String id_dep) {
		this.id_dep = id_dep;
	}

	public String getId_emp() {
		return id_emp;
	}

	public void setId_emp(String id_emp) {
		this.id_emp = id_emp;
	}

}
