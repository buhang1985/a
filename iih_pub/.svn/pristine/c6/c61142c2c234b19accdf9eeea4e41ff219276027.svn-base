package iih.pmp.pay.trademonitor.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pmp.pay.trademonitor.d.desc.TradeMonitorDODesc;
import java.math.BigDecimal;

/**
 * 交易监控 DO数据 
 * 
 */
public class TradeMonitorDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_TRADEMONITOR= "Id_trademonitor";
	public static final String TRADE_NO= "Trade_no";
	public static final String DT_REQ= "Dt_req";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_trademonitor() {
		return ((String) getAttrVal("Id_trademonitor"));
	}	
	public void setId_trademonitor(String Id_trademonitor) {
		setAttrVal("Id_trademonitor", Id_trademonitor);
	}
	public String getTrade_no() {
		return ((String) getAttrVal("Trade_no"));
	}	
	public void setTrade_no(String Trade_no) {
		setAttrVal("Trade_no", Trade_no);
	}
	public FDateTime getDt_req() {
		return ((FDateTime) getAttrVal("Dt_req"));
	}	
	public void setDt_req(FDateTime Dt_req) {
		setAttrVal("Dt_req", Dt_req);
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
		return "Id_trademonitor";
	}
	
	@Override
	public String getTableName() {	  
		return "pmp_trademonitor";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(TradeMonitorDODesc.class);
	}
	
}