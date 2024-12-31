package iih.ems.einv.eminsp.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ems.einv.eminsp.d.desc.EminspAggDODesc;



/**
 * 大型设备验收
 */
public class EminspAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public EmsInspDO getParentDO() {
		return ((EmsInspDO) super.getParentDO());
	}

	public void setParentDO(EmsInspDO headDO) {
		setParent(headDO);
	}

	public EmsInspItmDO[] getEmsInspItmDO() {
		IBaseDO[] dos = getChildren(EmsInspItmDO.class);
		if(dos==null) return null;
		EmsInspItmDO[] result=new EmsInspItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(EmsInspItmDO)dos[i];
		}
		return result;
	}
	
	public void setEmsInspItmDO(EmsInspItmDO[] dos) {
		setChildren(EmsInspItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		EminspAggDODesc desc = new EminspAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new EmsInspDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ems.einv.eminsp.d.EmsInspItmDO")) {
             return new EmsInspItmDO();
         }
         return null;
     }
}