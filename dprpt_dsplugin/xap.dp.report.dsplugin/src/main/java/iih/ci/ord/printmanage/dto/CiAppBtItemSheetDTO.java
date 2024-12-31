package iih.ci.ord.printmanage.dto;

/**
 * 备血观察检验指标DTO
 * @author Young
 */
public class CiAppBtItemSheetDTO {
	/**
	 * 备血打印申请单ID
	 */
	private String Id_ciappbtsheet;
	public String getId_ciappbtsheet() {
		return Id_ciappbtsheet;
	}
	public void setId_ciappbtsheet(String id_ciappbtsheet){
		Id_ciappbtsheet = id_ciappbtsheet;
	}
	/**
	 * 服务
	 */
	private String Id_srv;
	public String getId_srv() {
		return Id_srv;
	}
	public void setId_srv(String id_srv){
		Id_srv = id_srv;
	}
	private String Name_srv;
	public String getName_srv() {
		return Name_srv;
	}
	public void setName_srv(String name_srv){
		Name_srv = name_srv;
	}
	/**
	 * 项目结果值
	 */
	private String Val_rstrptla;
	public String getVal_rstrptla() {
		return Val_rstrptla;
	}
	public void setVal_rstrptla(String val_rstrptla){
		Val_rstrptla = val_rstrptla;
	}
	/**
	 * 单位
	 */
	private String Id_unit;
	public String getId_unit() {
		return Id_unit;
	}
	public void setId_unit(String id_unit){
		Id_unit = id_unit;
	}
	private String Name_unit;
	public String getName_unit() {
		return Name_unit;
	}
	public void setName_unit(String name_unit){
		Name_unit = name_unit;
	}
}
