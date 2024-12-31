package iih.ci.mr.nu.dvtriskass.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.mr.nu.dvtriskass.d.desc.DvtriskassAggDODesc;



/**
 * DVT风险评估单
 */
public class DvtriskassAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public DvtriskassDO getParentDO() {
		return ((DvtriskassDO) super.getParentDO());
	}

	public void setParentDO(DvtriskassDO headDO) {
		setParent(headDO);
	}

	public DvtriskasslistDO[] getDvtriskasslistDO() {
		IBaseDO[] dos = getChildren(DvtriskasslistDO.class);
		if(dos==null) return null;
		DvtriskasslistDO[] result=new DvtriskasslistDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(DvtriskasslistDO)dos[i];
		}
		return result;
	}
	
	public void setDvtriskasslistDO(DvtriskasslistDO[] dos) {
		setChildren(DvtriskasslistDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		DvtriskassAggDODesc desc = new DvtriskassAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new DvtriskassDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.mr.nu.dvtriskass.d.DvtriskasslistDO")) {
             return new DvtriskasslistDO();
         }
         return null;
     }
}