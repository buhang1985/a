package iih.ci.mrm.healthsystem.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.mrm.healthsystem.d.desc.HealthsystemfieldAggDODesc;



/**
 * 字段转换
 */
public class HealthsystemfieldAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public FieldContrastDO getParentDO() {
		return ((FieldContrastDO) super.getParentDO());
	}

	public void setParentDO(FieldContrastDO headDO) {
		setParent(headDO);
	}

	public FieldTransScriptDO[] getFieldTransScriptDO() {
		IBaseDO[] dos = getChildren(FieldTransScriptDO.class);
		if(dos==null) return null;
		FieldTransScriptDO[] result=new FieldTransScriptDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(FieldTransScriptDO)dos[i];
		}
		return result;
	}
	
	public void setFieldTransScriptDO(FieldTransScriptDO[] dos) {
		setChildren(FieldTransScriptDO.class, dos);
	}
	public FieldCheckRuleDO[] getFieldCheckRuleDO() {
		IBaseDO[] dos = getChildren(FieldCheckRuleDO.class);
		if(dos==null) return null;
		FieldCheckRuleDO[] result=new FieldCheckRuleDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(FieldCheckRuleDO)dos[i];
		}
		return result;
	}
	
	public void setFieldCheckRuleDO(FieldCheckRuleDO[] dos) {
		setChildren(FieldCheckRuleDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		HealthsystemfieldAggDODesc desc = new HealthsystemfieldAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new FieldContrastDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.mrm.healthsystem.d.FieldTransScriptDO")) {
             return new FieldTransScriptDO();
         }
	    else if (clzName.equals("iih.ci.mrm.healthsystem.d.FieldCheckRuleDO")) {
             return new FieldCheckRuleDO();
         }
         return null;
     }
}