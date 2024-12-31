package iih.ems.einv.emda.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ems.einv.emda.d.desc.EmdaAggDODesc;



/**
 * 设备领用申请
 */
public class EmdaAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public EmsDaDO getParentDO() {
		return ((EmsDaDO) super.getParentDO());
	}

	public void setParentDO(EmsDaDO headDO) {
		setParent(headDO);
	}

	public EmsDaItmDO[] getEmsDaItmDO() {
		IBaseDO[] dos = getChildren(EmsDaItmDO.class);
		if(dos==null) return null;
		EmsDaItmDO[] result=new EmsDaItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(EmsDaItmDO)dos[i];
		}
		return result;
	}
	
	public void setEmsDaItmDO(EmsDaItmDO[] dos) {
		setChildren(EmsDaItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		EmdaAggDODesc desc = new EmdaAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new EmsDaDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ems.einv.emda.d.EmsDaItmDO")) {
             return new EmsDaItmDO();
         }
         return null;
     }
}