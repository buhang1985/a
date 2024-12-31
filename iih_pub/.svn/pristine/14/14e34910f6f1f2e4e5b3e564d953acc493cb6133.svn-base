package iih.pe.pqn.peicdvmodel.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pqn.peicdvmodel.d.desc.PeIcdvModelSmokeDODesc;
import java.math.BigDecimal;

/**
 * 健康评估模型_缺血性冠心病_吸烟 DO数据 
 * 
 */
public class PeIcdvModelSmokeDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//缺血性冠心病评估模型吸烟主键标识
	public static final String ID_PEICDVMODELSMOKE= "Id_peicdvmodelsmoke";
	//缺血性冠心病ID
	public static final String ID_PEICDVMODEL= "Id_peicdvmodel";
	//吸烟标识
	public static final String FG_SMOKE= "Fg_smoke";
	//评分
	public static final String SCORE= "Score";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 缺血性冠心病评估模型吸烟主键标识
	 * @return String
	 */
	public String getId_peicdvmodelsmoke() {
		return ((String) getAttrVal("Id_peicdvmodelsmoke"));
	}	
	/**
	 * 缺血性冠心病评估模型吸烟主键标识
	 * @param Id_peicdvmodelsmoke
	 */
	public void setId_peicdvmodelsmoke(String Id_peicdvmodelsmoke) {
		setAttrVal("Id_peicdvmodelsmoke", Id_peicdvmodelsmoke);
	}
	/**
	 * 缺血性冠心病ID
	 * @return String
	 */
	public String getId_peicdvmodel() {
		return ((String) getAttrVal("Id_peicdvmodel"));
	}	
	/**
	 * 缺血性冠心病ID
	 * @param Id_peicdvmodel
	 */
	public void setId_peicdvmodel(String Id_peicdvmodel) {
		setAttrVal("Id_peicdvmodel", Id_peicdvmodel);
	}
	/**
	 * 吸烟标识
	 * @return FBoolean
	 */
	public FBoolean getFg_smoke() {
		return ((FBoolean) getAttrVal("Fg_smoke"));
	}	
	/**
	 * 吸烟标识
	 * @param Fg_smoke
	 */
	public void setFg_smoke(FBoolean Fg_smoke) {
		setAttrVal("Fg_smoke", Fg_smoke);
	}
	/**
	 * 评分
	 * @return Integer
	 */
	public Integer getScore() {
		return ((Integer) getAttrVal("Score"));
	}	
	/**
	 * 评分
	 * @param Score
	 */
	public void setScore(Integer Score) {
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
		return "Id_peicdvmodelsmoke";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_qn_peicdvmodelsmoke";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeIcdvModelSmokeDODesc.class);
	}
	
}