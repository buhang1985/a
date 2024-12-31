package iih.ci.ord.s.ems.utils.meta;

import java.util.List;

/**
 * 用于草药医嘱内容拼接的DTO
 * @author zwq
 *
 */
public class HerbOrContentParam extends DrugOrContentParam{

	private static final long serialVersionUID = 1L;
	public HerbOrContentParam(Integer Orders,String sd_srvtp,String name_freq,Integer use_days,String name_route,String name_boil,String name_routedes,String note_or,List<OrContentDTO> drugs){
		super(sd_srvtp,name_freq,use_days,name_route,note_or,drugs);
		this.setOrders(Orders);
		this.setName_boil(name_boil);
		this.setName_routedes(name_routedes);
	}
	/**
	 * 煎法
	 */
	private String Name_boil;
	/**
	 * 用法要求
	 */
	private String Name_routedes;
	
	public String getName_routedes() {
		return Name_routedes;
	}
	public void setName_routedes(String name_routedes) {
		Name_routedes = name_routedes;
	}
	public String getName_boil() {
		return Name_boil;
	}
	public void setName_boil(String name_boil) {
		Name_boil = name_boil;
	}
	/**
	 * 医嘱付数
	 */
	private Integer Orders;
	public Integer getOrders() {
		return Orders;
	}
	public void setOrders(Integer orders) {
		Orders = orders;
	}
	
}
