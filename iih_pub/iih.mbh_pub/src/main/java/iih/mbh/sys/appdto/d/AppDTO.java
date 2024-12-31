package iih.mbh.sys.appdto.d;

import java.util.List;
import xap.mw.sf.core.annotation.RPCField;
import xap.mw.sf.core.annotation.RPCStruct;
@RPCStruct
public class AppDTO {

	// 应用ID
	@RPCField(id = 1)
	private String id_app;
	// 编码
	@RPCField(id = 2)
	private String code;
	// 名称
	@RPCField(id = 3)
	private String name;
	// 终端类型
	@RPCField(id = 4)
	private int eu_trml;
	// 最大页签数
	@RPCField(id = 5)
	private int max_page;
	// 菜单明细
	@RPCField(id = 6)
	private List<AppMenuDTO> arraymenu;
	// 工作站菜单
	@RPCField(id = 7)
	private AppMenuDTO stationmenu;

	public String getId_app() {
		return id_app;
	}

	public void setId_app(String id_app) {
		this.id_app = id_app;
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

	public int getEu_trml() {
		return eu_trml;
	}

	public void setEu_trml(int eu_trml) {
		this.eu_trml = eu_trml;
	}

	public int getMax_page() {
		return max_page;
	}

	public void setMax_page(int max_page) {
		this.max_page = max_page;
	}

	public List<AppMenuDTO> getArraymenu() {
		return arraymenu;
	}

	public void setArraymenu(List<AppMenuDTO> arraymenu) {
		this.arraymenu = arraymenu;
	}

	public AppMenuDTO getStationmenu() {
		return stationmenu;
	}

	public void setStationmenu(AppMenuDTO stationmenu) {
		this.stationmenu = stationmenu;
	}

}
