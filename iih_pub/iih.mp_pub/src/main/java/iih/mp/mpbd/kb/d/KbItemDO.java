package iih.mp.mpbd.kb.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.mpbd.kb.d.desc.KbItemDODesc;
import java.math.BigDecimal;

/**
 * 键盘_按键 DO数据 
 * 
 */
public class KbItemDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_KB_BTN= "Id_kb_btn";
	public static final String ID_KB= "Id_kb";
	public static final String SORTNO= "Sortno";
	public static final String INDEX_X= "Index_x";
	public static final String INDEX_Y= "Index_y";
	public static final String TEXT= "Text";
	public static final String VALUE= "Value";
	public static final String SCORE= "Score";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_kb_btn() {
		return ((String) getAttrVal("Id_kb_btn"));
	}	
	public void setId_kb_btn(String Id_kb_btn) {
		setAttrVal("Id_kb_btn", Id_kb_btn);
	}
	public String getId_kb() {
		return ((String) getAttrVal("Id_kb"));
	}	
	public void setId_kb(String Id_kb) {
		setAttrVal("Id_kb", Id_kb);
	}
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	public Integer getIndex_x() {
		return ((Integer) getAttrVal("Index_x"));
	}	
	public void setIndex_x(Integer Index_x) {
		setAttrVal("Index_x", Index_x);
	}
	public Integer getIndex_y() {
		return ((Integer) getAttrVal("Index_y"));
	}	
	public void setIndex_y(Integer Index_y) {
		setAttrVal("Index_y", Index_y);
	}
	public String getText() {
		return ((String) getAttrVal("Text"));
	}	
	public void setText(String Text) {
		setAttrVal("Text", Text);
	}
	public String getValue() {
		return ((String) getAttrVal("Value"));
	}	
	public void setValue(String Value) {
		setAttrVal("Value", Value);
	}
	public FDouble getScore() {
		return ((FDouble) getAttrVal("Score"));
	}	
	public void setScore(FDouble Score) {
		setAttrVal("Score", Score);
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
		return "Id_kb_btn";
	}
	
	@Override
	public String getTableName() {	  
		return "MP_KB_BTN";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(KbItemDODesc.class);
	}
	
}