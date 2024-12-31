package iih.mp.dg.manuprep.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.dg.manuprep.d.desc.MpDgPrepItemDODesc;
import java.math.BigDecimal;

/**
 * 药品_门诊摆药明细 DO数据 
 * 
 */
public class MpDgPrepItemDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_DGOPDISPDT= "Id_dgopdispdt";
	public static final String ID_DGOPDISP= "Id_dgopdisp";
	public static final String ID_OR= "Id_or";
	public static final String ID_ORSRV= "Id_orsrv";
	public static final String ID_SRV= "Id_srv";
	public static final String CODE_SRV= "Code_srv";
	public static final String NAME_SRV= "Name_srv";
	public static final String ID_MM= "Id_mm";
	public static final String CODE_BATCH= "Code_batch";
	public static final String ID_PGKU_CUR= "Id_pgku_cur";
	public static final String QUAN_CUR= "Quan_cur";
	public static final String PRICE= "Price";
	public static final String QUAN_OR= "Quan_or";
	public static final String AMT= "Amt";
	public static final String ID_UNIT_MEDU= "Id_unit_medu";
	public static final String QUAN_MEDU= "Quan_medu";
	public static final String ID_ROUTE= "Id_route";
	public static final String ID_ROUTEDES= "Id_routedes";
	public static final String ID_BOIL= "Id_boil";
	public static final String ID_BOILDES= "Id_boildes";
	public static final String FG_BOIL= "Fg_boil";
	public static final String QUAN_ORDERS_BOIL= "Quan_orders_boil";
	public static final String FG_JY_FIN= "Fg_jy_fin";
	public static final String NOTE= "Note";
	public static final String ID_FREQ= "Id_freq";
	public static final String FG_BY= "Fg_by";
	public static final String FG_OTC= "Fg_otc";
	public static final String SD_VAL= "Sd_val";
	public static final String CHARACTER= "Character";
	public static final String ONLYCODE= "Onlycode";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_dgopdispdt() {
		return ((String) getAttrVal("Id_dgopdispdt"));
	}	
	public void setId_dgopdispdt(String Id_dgopdispdt) {
		setAttrVal("Id_dgopdispdt", Id_dgopdispdt);
	}
	public String getId_dgopdisp() {
		return ((String) getAttrVal("Id_dgopdisp"));
	}	
	public void setId_dgopdisp(String Id_dgopdisp) {
		setAttrVal("Id_dgopdisp", Id_dgopdisp);
	}
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}	
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	public String getCode_srv() {
		return ((String) getAttrVal("Code_srv"));
	}	
	public void setCode_srv(String Code_srv) {
		setAttrVal("Code_srv", Code_srv);
	}
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}	
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}	
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	public String getCode_batch() {
		return ((String) getAttrVal("Code_batch"));
	}	
	public void setCode_batch(String Code_batch) {
		setAttrVal("Code_batch", Code_batch);
	}
	public String getId_pgku_cur() {
		return ((String) getAttrVal("Id_pgku_cur"));
	}	
	public void setId_pgku_cur(String Id_pgku_cur) {
		setAttrVal("Id_pgku_cur", Id_pgku_cur);
	}
	public FDouble getQuan_cur() {
		return ((FDouble) getAttrVal("Quan_cur"));
	}	
	public void setQuan_cur(FDouble Quan_cur) {
		setAttrVal("Quan_cur", Quan_cur);
	}
	public FDouble getPrice() {
		return ((FDouble) getAttrVal("Price"));
	}	
	public void setPrice(FDouble Price) {
		setAttrVal("Price", Price);
	}
	public Integer getQuan_or() {
		return ((Integer) getAttrVal("Quan_or"));
	}	
	public void setQuan_or(Integer Quan_or) {
		setAttrVal("Quan_or", Quan_or);
	}
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}	
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
	}
	public String getId_unit_medu() {
		return ((String) getAttrVal("Id_unit_medu"));
	}	
	public void setId_unit_medu(String Id_unit_medu) {
		setAttrVal("Id_unit_medu", Id_unit_medu);
	}
	public FDouble getQuan_medu() {
		return ((FDouble) getAttrVal("Quan_medu"));
	}	
	public void setQuan_medu(FDouble Quan_medu) {
		setAttrVal("Quan_medu", Quan_medu);
	}
	public String getId_route() {
		return ((String) getAttrVal("Id_route"));
	}	
	public void setId_route(String Id_route) {
		setAttrVal("Id_route", Id_route);
	}
	public String getId_routedes() {
		return ((String) getAttrVal("Id_routedes"));
	}	
	public void setId_routedes(String Id_routedes) {
		setAttrVal("Id_routedes", Id_routedes);
	}
	public String getId_boil() {
		return ((String) getAttrVal("Id_boil"));
	}	
	public void setId_boil(String Id_boil) {
		setAttrVal("Id_boil", Id_boil);
	}
	public String getId_boildes() {
		return ((String) getAttrVal("Id_boildes"));
	}	
	public void setId_boildes(String Id_boildes) {
		setAttrVal("Id_boildes", Id_boildes);
	}
	public FBoolean getFg_boil() {
		return ((FBoolean) getAttrVal("Fg_boil"));
	}	
	public void setFg_boil(FBoolean Fg_boil) {
		setAttrVal("Fg_boil", Fg_boil);
	}
	public Integer getQuan_orders_boil() {
		return ((Integer) getAttrVal("Quan_orders_boil"));
	}	
	public void setQuan_orders_boil(Integer Quan_orders_boil) {
		setAttrVal("Quan_orders_boil", Quan_orders_boil);
	}
	public FBoolean getFg_jy_fin() {
		return ((FBoolean) getAttrVal("Fg_jy_fin"));
	}	
	public void setFg_jy_fin(FBoolean Fg_jy_fin) {
		setAttrVal("Fg_jy_fin", Fg_jy_fin);
	}
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	public String getId_freq() {
		return ((String) getAttrVal("Id_freq"));
	}	
	public void setId_freq(String Id_freq) {
		setAttrVal("Id_freq", Id_freq);
	}
	public FBoolean getFg_by() {
		return ((FBoolean) getAttrVal("Fg_by"));
	}	
	public void setFg_by(FBoolean Fg_by) {
		setAttrVal("Fg_by", Fg_by);
	}
	public FBoolean getFg_otc() {
		return ((FBoolean) getAttrVal("Fg_otc"));
	}	
	public void setFg_otc(FBoolean Fg_otc) {
		setAttrVal("Fg_otc", Fg_otc);
	}
	public String getSd_val() {
		return ((String) getAttrVal("Sd_val"));
	}	
	public void setSd_val(String Sd_val) {
		setAttrVal("Sd_val", Sd_val);
	}
	public String getCharacter() {
		return ((String) getAttrVal("Character"));
	}	
	public void setCharacter(String Character) {
		setAttrVal("Character", Character);
	}
	public String getOnlycode() {
		return ((String) getAttrVal("Onlycode"));
	}	
	public void setOnlycode(String Onlycode) {
		setAttrVal("Onlycode", Onlycode);
	}

	public Integer getDs() {
		return ((Integer) getAttrVal(GlobalConst.DELETE_SIGN));
	}
	
	public void setDs(Integer ds) {
		setAttrVal(GlobalConst.DELETE_SIGN, ds);
	}
	
	public FDateTime getSv() {
		return ((FDateTime) getAttrVal(GlobalConst.SYSTEM_VERSION));
	}
	
	public void setSv(FDateTime sv) {
		setAttrVal(GlobalConst.SYSTEM_VERSION, sv);
	}

//	@Override
//	public java.lang.String getParentPKFieldName() {
//		return null;
//	}
  
	@Override
	public String getPKFieldName() {
		return "Id_dgopdispdt";
	}
	
	@Override
	public String getTableName() {	  
		return "MP_DG_OPDISP_DT";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MpDgPrepItemDODesc.class);
	}
	
}