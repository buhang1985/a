package iih.en.pv.inpatient.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.en.pv.inpatient.d.desc.EnpecmpyAggDODesc;



/**
 * 团检记录
 */
public class EnpecmpyAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public EnPeCmpyDO getParentDO() {
		return ((EnPeCmpyDO) super.getParentDO());
	}

	public void setParentDO(EnPeCmpyDO headDO) {
		setParent(headDO);
	}

	public EnPeCmpyItmDO[] getEnPeCmpyItmDO() {
		IBaseDO[] dos = getChildren(EnPeCmpyItmDO.class);
		if(dos==null) return null;
		EnPeCmpyItmDO[] result=new EnPeCmpyItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(EnPeCmpyItmDO)dos[i];
		}
		return result;
	}
	
	public void setEnPeCmpyItmDO(EnPeCmpyItmDO[] dos) {
		setChildren(EnPeCmpyItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		EnpecmpyAggDODesc desc = new EnpecmpyAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new EnPeCmpyDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.en.pv.inpatient.d.EnPeCmpyItmDO")) {
             return new EnPeCmpyItmDO();
         }
         return null;
     }
}