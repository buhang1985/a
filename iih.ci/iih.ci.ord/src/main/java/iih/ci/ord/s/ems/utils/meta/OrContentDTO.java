package iih.ci.ord.s.ems.utils.meta;

import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;

public class OrContentDTO {
	public OrContentDTO(OrdSrvDO ordSrvDO){
		this.Name_srv = ordSrvDO.getName_srv();
		this.Id_mm = ordSrvDO.getId_mm();
		this.Quan_med = ordSrvDO.getQuan_medu();
		this.Name_unit_med = ordSrvDO.getMedu_name();
		this.Fg_self = ordSrvDO.getFg_self()==null?false:ordSrvDO.getFg_self().booleanValue();
		this.Price = ordSrvDO.getPri();
		this.Fg_highrisk = ordSrvDO.getFg_highrisk();
		//都传 不然加个字段就要写个一次 太费劲 以前的逻辑不动 以后用这个对象
		this.OrdSrvDo = ordSrvDO;
	}
	public OrContentDTO(OrdSrvDO ordSrvDO,OrdSrvMmDO srvmmdo){
		this.Name_srv = ordSrvDO.getName_srv();
		this.Id_mm = ordSrvDO.getId_mm();
		this.Quan_med = ordSrvDO.getQuan_medu();
		this.Name_unit_med = ordSrvDO.getMedu_name();
		this.Fg_self = ordSrvDO.getFg_self()==null?false:ordSrvDO.getFg_self().booleanValue();
		this.Price = ordSrvDO.getPri();
		this.Fg_highrisk = ordSrvDO.getFg_highrisk();
		this.Quan_cur = srvmmdo.getQuan_cur();
		this.Name_dep_wh=ordSrvDO.getName_dep_wh();
		this.Id_pgku_cur = srvmmdo.getId_pgku_cur();
		//都传 不然加个字段就要写个一次 太费劲 以前的逻辑不动 以后用这个对象
		this.OrdSrvDo = ordSrvDO;
		this.srvmmdo = srvmmdo; 
	}
	public OrContentDTO(String Name_srv,FDouble Quan_med,String Name_unit_med,boolean Fg_self) {
		this.Name_srv = Name_srv;
		this.Quan_med = Quan_med;
		this.Name_unit_med = Name_unit_med;
		this.Fg_self = Fg_self;
	}
	private String Id_mm;
	
	public String getId_mm() {
		return Id_mm;
	}
	public void setId_mm(String id_mm) {
		Id_mm = id_mm;
	}
	private String Id_pgku_cur;
	
	public String getId_pgku_cur() {
		return Id_pgku_cur;
	}
	public void setId_pgku_cur(String id_pgku_cur) {
		Id_pgku_cur = id_pgku_cur;
	}
	/**
	 * 服务名称
	 * @return
	 */
	private String Name_srv;
	/**
	 * 剂量
	 * @return
	 */
	private FDouble Quan_med;
	/**
	 * 总量
	 * @return
	 */
	private FDouble Quan_cur;
	/**
	 * 计量单位
	 * @return
	 */
	private String Name_unit_med;
	/**
	 * 单价
	 */
	private FDouble Price;
	/**
	 * 自备药标识
	 * @return
	 */
	private boolean Fg_self;
	/**
	 * 规格
	 */
	private String Spec;
	/**
	 * 高危标识
	 */
	private FBoolean Fg_highrisk;
	/**
	 * 库房
	 */
	private String Name_dep_wh;
	private OrdSrvDO OrdSrvDo;
	private OrdSrvMmDO srvmmdo;
	public String getName_dep_wh() {
		return Name_dep_wh;
	}
	public void setName_dep_wh(String name_dep_wh) {
		Name_dep_wh = name_dep_wh;
	}
	public String getName_srv() {
		return Name_srv;
	}
	public void setName_srv(String name_srv) {
		Name_srv = name_srv;
	}
	public FDouble getQuan_med() {
		return Quan_med;
	}
	public void setQuan_med(FDouble quan_med) {
		Quan_med = quan_med;
	}
	public String getName_unit_med() {
		return Name_unit_med;
	}
	public void setName_unit_med(String name_unit_med) {
		Name_unit_med = name_unit_med;
	}
	public boolean isFg_self() {
		return Fg_self;
	}
	public void setFg_self(boolean fg_self) {
		Fg_self = fg_self;
	}
	public FDouble getPrice() {
		return Price;
	}
	public void setPrice(FDouble price) {
		Price = price;
	}
	public String getSpec() {
		return Spec;
	}
	public void setSpec(String spece) {
		Spec = spece;
	}
	public FBoolean getFg_highrisk() {
		return Fg_highrisk;
	}
	public void setFg_highrisk(FBoolean fg_highrisk) {
		Fg_highrisk = fg_highrisk;
	}
	public FDouble getQuan_cur() {
		return Quan_cur;
	}
	public void setQuan_cur(FDouble quan_cur) {
		Quan_cur = quan_cur;
	}
	
	public OrdSrvDO getOrdSrvDo() {
		return OrdSrvDo;
	}	
	
	public void setOrdSrvDo(OrdSrvDO OrdSrvDo) {
		this.OrdSrvDo = OrdSrvDo;
	}
	public OrdSrvMmDO getSrvmmdo() {
		return srvmmdo;
	}
	public void setSrvmmdo(OrdSrvMmDO srvmmdo) {
		this.srvmmdo = srvmmdo;
	}
	
}
