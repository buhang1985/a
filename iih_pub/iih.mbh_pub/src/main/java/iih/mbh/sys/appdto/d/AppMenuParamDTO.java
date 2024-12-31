package iih.mbh.sys.appdto.d;

import java.util.List;

public class AppMenuParamDTO {

	// 应用ID
	private String id_app;
	// 菜单ID
	private String id_app_menu;
	// 菜单参数ID
	private String id_app_menu_param;
	// 键
	private String key;
	// 值
	private String value;

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

	public String getId_app_menu_param() {
		return id_app_menu_param;
	}

	public void setId_app_menu_param(String id_app_menu_param) {
		this.id_app_menu_param = id_app_menu_param;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
