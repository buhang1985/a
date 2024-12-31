package iih.pe.pqn.pehramodel.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pqn.pehramodel.d.desc.PeHraModelIRDODesc;
import java.math.BigDecimal;

/**
 * 体检疾病风险评估模型发病率 DO数据 
 * 
 */
public class PeHraModelIRDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检疾病风险评估模型发病率主键标识
	public static final String ID_PEHRAMODELIR= "Id_pehramodelir";
	//体检疾病风险评估模型ID
	public static final String ID_PEHRAMODEL= "Id_pehramodel";
	//开始年龄
	public static final String AGE_BEGIN= "Age_begin";
	//结束年龄
	public static final String AGE_END= "Age_end";
	//发病率
	public static final String IR= "Ir";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检疾病风险评估模型发病率主键标识
	 * @return String
	 */
	public String getId_pehramodelir() {
		return ((String) getAttrVal("Id_pehramodelir"));
	}	
	/**
	 * 体检疾病风险评估模型发病率主键标识
	 * @param Id_pehramodelir
	 */
	public void setId_pehramodelir(String Id_pehramodelir) {
		setAttrVal("Id_pehramodelir", Id_pehramodelir);
	}
	/**
	 * 体检疾病风险评估模型ID
	 * @return String
	 */
	public String getId_pehramodel() {
		return ((String) getAttrVal("Id_pehramodel"));
	}	
	/**
	 * 体检疾病风险评估模型ID
	 * @param Id_pehramodel
	 */
	public void setId_pehramodel(String Id_pehramodel) {
		setAttrVal("Id_pehramodel", Id_pehramodel);
	}
	/**
	 * 开始年龄
	 * @return Integer
	 */
	public Integer getAge_begin() {
		return ((Integer) getAttrVal("Age_begin"));
	}	
	/**
	 * 开始年龄
	 * @param Age_begin
	 */
	public void setAge_begin(Integer Age_begin) {
		setAttrVal("Age_begin", Age_begin);
	}
	/**
	 * 结束年龄
	 * @return Integer
	 */
	public Integer getAge_end() {
		return ((Integer) getAttrVal("Age_end"));
	}	
	/**
	 * 结束年龄
	 * @param Age_end
	 */
	public void setAge_end(Integer Age_end) {
		setAttrVal("Age_end", Age_end);
	}
	/**
	 * 发病率
	 * @return FDouble
	 */
	public FDouble getIr() {
		return ((FDouble) getAttrVal("Ir"));
	}	
	/**
	 * 发病率
	 * @param Ir
	 */
	public void setIr(FDouble Ir) {
		setAttrVal("Ir", Ir);
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
		return "Id_pehramodelir";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_qn_pehramodelir";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeHraModelIRDODesc.class);
	}
	
}