package iih.bl.inc.s.bp.inc.incsplit.data;

import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.FArrayList;

/**
 * 发票分票数据封装模型
 * @author ly 2018/08/21
 *
 */
public class IncSplitMaskDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	
	public static final String ID_PK= "Id_pk";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_OR= "Id_or";
	public static final String CODE_INCCAITM= "Code_inccaitm";
	public static final String CODE_ACCOUNT= "Code_account";
	public static final String ID_DEP_OR= "Id_dep_or";
	public static final String ID_DEP_MP= "Id_dep_mp";
	public static final String ID_EMP_OR= "Id_emp_or";
	
	public String getId_Pk() {
		return ((String) getAttrVal(ID_PK));
	}	
	public void setId_pk(String Id_pk) {
		setAttrVal(ID_PK, Id_pk);
	}
	
	public String getId_ent() {
		return ((String) getAttrVal(ID_ENT));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal(ID_ENT, Id_ent);
	}
	
	public String getId_or() {
		return ((String) getAttrVal(ID_OR));
	}	
	public void setId_or(String Id_or) {
		setAttrVal(ID_OR, Id_or);
	}
	
	public String getCode_inccaitm() {
		return ((String) getAttrVal(CODE_INCCAITM));
	}	
	public void setCode_inccaitm(String Code_inccaitm) {
		setAttrVal(CODE_INCCAITM, Code_inccaitm);
	}
	
	public String getCode_account() {
		return ((String) getAttrVal(CODE_ACCOUNT));
	}	
	public void setCode_account(String Code_account) {
		setAttrVal(CODE_ACCOUNT, Code_account);
	}
	
	public String getId_dep_or() {
		return ((String) getAttrVal(ID_DEP_OR));
	}	
	public void setId_dep_or(String Id_dep_or) {
		setAttrVal(ID_DEP_OR, Id_dep_or);
	}
	
	public String getId_dep_mp() {
		return ((String) getAttrVal(ID_DEP_MP));
	}	
	public void setId_dep_mp(String Id_dep_mp) {
		setAttrVal(ID_DEP_MP, Id_dep_mp);
	}
	
	public String getId_emp_or() {
		return ((String) getAttrVal(ID_EMP_OR));
	}	
	public void setId_emp_or(String Id_emp_or) {
		setAttrVal(ID_EMP_OR, Id_emp_or);
	}
	
	public FArrayList getCgData(){
		return ((FArrayList) getAttrVal("Cg_data"));
	}
	
	public void setCgData(FArrayList cgData){
		setAttrVal("Cg_data",cgData);
	}
}
