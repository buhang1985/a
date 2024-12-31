package iih.ems.einv.emout.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ems.einv.emout.d.desc.EmoutAggDODesc;



/**
 * 设备出库
 */
public class EmoutAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public EmsOutDO getParentDO() {
		return ((EmsOutDO) super.getParentDO());
	}

	public void setParentDO(EmsOutDO headDO) {
		setParent(headDO);
	}

	public EmsOutItmDO[] getEmsOutItmDO() {
		IBaseDO[] dos = getChildren(EmsOutItmDO.class);
		if(dos==null) return null;
		EmsOutItmDO[] result=new EmsOutItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(EmsOutItmDO)dos[i];
		}
		return result;
	}
	
	public void setEmsOutItmDO(EmsOutItmDO[] dos) {
		setChildren(EmsOutItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		EmoutAggDODesc desc = new EmoutAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new EmsOutDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ems.einv.emout.d.EmsOutItmDO")) {
             return new EmsOutItmDO();
         }
         return null;
     }
}