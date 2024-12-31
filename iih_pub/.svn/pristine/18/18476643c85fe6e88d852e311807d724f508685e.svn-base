package iih.ems.einv.emin.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ems.einv.emin.d.desc.EminAggDODesc;



/**
 * 设备入库
 */
public class EminAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public EmsInDO getParentDO() {
		return ((EmsInDO) super.getParentDO());
	}

	public void setParentDO(EmsInDO headDO) {
		setParent(headDO);
	}

	public EmsInItmDO[] getEmsInItmDO() {
		IBaseDO[] dos = getChildren(EmsInItmDO.class);
		if(dos==null) return null;
		EmsInItmDO[] result=new EmsInItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(EmsInItmDO)dos[i];
		}
		return result;
	}
	
	public void setEmsInItmDO(EmsInItmDO[] dos) {
		setChildren(EmsInItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		EminAggDODesc desc = new EminAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new EmsInDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ems.einv.emin.d.EmsInItmDO")) {
             return new EmsInItmDO();
         }
         return null;
     }
}