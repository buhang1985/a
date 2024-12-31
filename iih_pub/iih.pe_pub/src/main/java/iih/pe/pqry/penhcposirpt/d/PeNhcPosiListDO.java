package iih.pe.pqry.penhcposirpt.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pqry.penhcposirpt.d.desc.PeNhcPosiListDODesc;
import java.math.BigDecimal;

/**
 * 体检上报报表明细 DO数据 
 * 
 */
public class PeNhcPosiListDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PENHCPOSILIST= "Id_penhcposilist";
	public static final String ID_PENHCPOSIRPT= "Id_penhcposirpt";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_PENHCPOSI= "Id_penhcposi";
	public static final String TOTAL= "Total";
	public static final String AGE_BRACKET1= "Age_bracket1";
	public static final String AGE_BRACKET2= "Age_bracket2";
	public static final String AGE_BRACKET3= "Age_bracket3";
	public static final String AGE_BRACKET4= "Age_bracket4";
	public static final String AGE_BRACKET5= "Age_bracket5";
	public static final String AGE_BRACKET6= "Age_bracket6";
	public static final String AGE_BRACKET7= "Age_bracket7";
	public static final String CODE_POSI= "Code_posi";
	public static final String NAME_POSI= "Name_posi";
	public static final String SEXLIMIT= "Sexlimit";
	public static final String SUMTP= "Sumtp";
	public static final String ILLS= "Ills";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_penhcposilist() {
		return ((String) getAttrVal("Id_penhcposilist"));
	}	
	public void setId_penhcposilist(String Id_penhcposilist) {
		setAttrVal("Id_penhcposilist", Id_penhcposilist);
	}
	public String getId_penhcposirpt() {
		return ((String) getAttrVal("Id_penhcposirpt"));
	}	
	public void setId_penhcposirpt(String Id_penhcposirpt) {
		setAttrVal("Id_penhcposirpt", Id_penhcposirpt);
	}
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	public String getId_penhcposi() {
		return ((String) getAttrVal("Id_penhcposi"));
	}	
	public void setId_penhcposi(String Id_penhcposi) {
		setAttrVal("Id_penhcposi", Id_penhcposi);
	}
	public Integer getTotal() {
		return ((Integer) getAttrVal("Total"));
	}	
	public void setTotal(Integer Total) {
		setAttrVal("Total", Total);
	}
	public Integer getAge_bracket1() {
		return ((Integer) getAttrVal("Age_bracket1"));
	}	
	public void setAge_bracket1(Integer Age_bracket1) {
		setAttrVal("Age_bracket1", Age_bracket1);
	}
	public Integer getAge_bracket2() {
		return ((Integer) getAttrVal("Age_bracket2"));
	}	
	public void setAge_bracket2(Integer Age_bracket2) {
		setAttrVal("Age_bracket2", Age_bracket2);
	}
	public Integer getAge_bracket3() {
		return ((Integer) getAttrVal("Age_bracket3"));
	}	
	public void setAge_bracket3(Integer Age_bracket3) {
		setAttrVal("Age_bracket3", Age_bracket3);
	}
	public Integer getAge_bracket4() {
		return ((Integer) getAttrVal("Age_bracket4"));
	}	
	public void setAge_bracket4(Integer Age_bracket4) {
		setAttrVal("Age_bracket4", Age_bracket4);
	}
	public Integer getAge_bracket5() {
		return ((Integer) getAttrVal("Age_bracket5"));
	}	
	public void setAge_bracket5(Integer Age_bracket5) {
		setAttrVal("Age_bracket5", Age_bracket5);
	}
	public Integer getAge_bracket6() {
		return ((Integer) getAttrVal("Age_bracket6"));
	}	
	public void setAge_bracket6(Integer Age_bracket6) {
		setAttrVal("Age_bracket6", Age_bracket6);
	}
	public Integer getAge_bracket7() {
		return ((Integer) getAttrVal("Age_bracket7"));
	}	
	public void setAge_bracket7(Integer Age_bracket7) {
		setAttrVal("Age_bracket7", Age_bracket7);
	}
	public String getCode_posi() {
		return ((String) getAttrVal("Code_posi"));
	}	
	public void setCode_posi(String Code_posi) {
		setAttrVal("Code_posi", Code_posi);
	}
	public String getName_posi() {
		return ((String) getAttrVal("Name_posi"));
	}	
	public void setName_posi(String Name_posi) {
		setAttrVal("Name_posi", Name_posi);
	}
	public Integer getSexlimit() {
		return ((Integer) getAttrVal("Sexlimit"));
	}	
	public void setSexlimit(Integer Sexlimit) {
		setAttrVal("Sexlimit", Sexlimit);
	}
	public Integer getSumtp() {
		return ((Integer) getAttrVal("Sumtp"));
	}	
	public void setSumtp(Integer Sumtp) {
		setAttrVal("Sumtp", Sumtp);
	}
	public String getIlls() {
		return ((String) getAttrVal("Ills"));
	}	
	public void setIlls(String Ills) {
		setAttrVal("Ills", Ills);
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
		return "Id_penhcposilist";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_qry_penhcposilist";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeNhcPosiListDODesc.class);
	}
	
}