package iih.ci.mrm.healthsystem.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.mrm.healthsystem.d.desc.HealthsystemAggDODesc;



/**
 * 对照分类
 */
public class HealthsystemAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public ContrastClassifyDO getParentDO() {
		return ((ContrastClassifyDO) super.getParentDO());
	}

	public void setParentDO(ContrastClassifyDO headDO) {
		setParent(headDO);
	}

	public DocContrastDO[] getDocContrastDO() {
		IBaseDO[] dos = getChildren(DocContrastDO.class);
		if(dos==null) return null;
		DocContrastDO[] result=new DocContrastDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(DocContrastDO)dos[i];
		}
		return result;
	}
	
	public void setDocContrastDO(DocContrastDO[] dos) {
		setChildren(DocContrastDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		HealthsystemAggDODesc desc = new HealthsystemAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new ContrastClassifyDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.mrm.healthsystem.d.DocContrastDO")) {
             return new DocContrastDO();
         }
         return null;
     }
}