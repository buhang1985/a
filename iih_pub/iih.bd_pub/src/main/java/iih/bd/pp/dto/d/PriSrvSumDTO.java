package iih.bd.pp.dto.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.coreitf.d.FDouble;
/**
 * 服务套成员计价DTO
 * @author 唐婵懿
 * @since 2016-08-11
 *
 */
public class PriSrvSumDTO extends BaseDTO {
	
	private static final long serialVersionUID = 1L;
	public String getId_prisrvsetfix() {
		return ((String) getAttrVal("Id_prisrvsetfix"));
	}	
	public void setId_prisrvsetfix(String Id_prisrvsetfix) {
		setAttrVal("Id_prisrvsetfix", Id_prisrvsetfix);
	}
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	//费用ID
	public String getId_srv_bl() {
		return ((String) getAttrVal("Id_srv_bl"));
	}	
	public void setId_srv_bl(String Id_srv_bl) {
		setAttrVal("Id_srv_bl", Id_srv_bl);
	}
	
	public FDouble getQuan() {
		return ((FDouble) getAttrVal("Quan"));
	}	
	public void setQuan(FDouble Quan) {
		setAttrVal("Quan", Quan);
	}
	
	//费用名称
	public String getId_srv_bl_name() {
		return ((String) getAttrVal("Id_srv_bl_name"));
	}	
	public void setId_srv_bl_name(String Id_srv_bl_name) {
		setAttrVal("Id_srv_bl_name", Id_srv_bl_name);
	}
	//定价模式
	public String getId_primd() {
		return ((String) getAttrVal("Id_primd"));
	}	
	public void setId_primd(String Id_primd) {
		setAttrVal("Id_primd", Id_primd);
	}
	//数量_医学单位
	public FDouble getQuan_medu()
	{
		return ((FDouble) getAttrVal("Quan_medu"));
	}
	public void setQuan_medu(FDouble Quan_medu) {
		setAttrVal("Quan_medu", Quan_medu);
	}

}
