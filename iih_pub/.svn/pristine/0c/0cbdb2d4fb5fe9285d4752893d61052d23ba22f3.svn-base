package iih.nmr.ha.tcho.hemodiasis.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nmr.ha.tcho.hemodiasis.d.desc.HemodiasisAggDODesc;



/**
 * 血液透析护理记录
 */
public class HemodiasisAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public HemodialysisDO getParentDO() {
		return ((HemodialysisDO) super.getParentDO());
	}

	public void setParentDO(HemodialysisDO headDO) {
		setParent(headDO);
	}

	public HemodialrecDO[] getHemodialrecDO() {
		IBaseDO[] dos = getChildren(HemodialrecDO.class);
		if(dos==null) return null;
		HemodialrecDO[] result=new HemodialrecDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(HemodialrecDO)dos[i];
		}
		return result;
	}
	
	public void setHemodialrecDO(HemodialrecDO[] dos) {
		setChildren(HemodialrecDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		HemodiasisAggDODesc desc = new HemodiasisAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new HemodialysisDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nmr.ha.tcho.hemodiasis.d.HemodialrecDO")) {
             return new HemodialrecDO();
         }
         return null;
     }
}