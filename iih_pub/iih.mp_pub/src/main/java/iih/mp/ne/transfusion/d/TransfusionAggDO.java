package iih.mp.ne.transfusion.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.mp.ne.transfusion.d.desc.TransfusionAggDODesc;



/**
 * 输血执行
 */
public class TransfusionAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public NeBtrDO getParentDO() {
		return ((NeBtrDO) super.getParentDO());
	}

	public void setParentDO(NeBtrDO headDO) {
		setParent(headDO);
	}

	public NeBtrItmDO[] getNeBtrItmDO() {
		IBaseDO[] dos = getChildren(NeBtrItmDO.class);
		if(dos==null) return null;
		NeBtrItmDO[] result=new NeBtrItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NeBtrItmDO)dos[i];
		}
		return result;
	}
	
	public void setNeBtrItmDO(NeBtrItmDO[] dos) {
		setChildren(NeBtrItmDO.class, dos);
	}
	public NeBtrReaDO[] getNeBtrReaDO() {
		IBaseDO[] dos = getChildren(NeBtrReaDO.class);
		if(dos==null) return null;
		NeBtrReaDO[] result=new NeBtrReaDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NeBtrReaDO)dos[i];
		}
		return result;
	}
	
	public void setNeBtrReaDO(NeBtrReaDO[] dos) {
		setChildren(NeBtrReaDO.class, dos);
	}
	public NeBtrVtDO[] getNeBtrVtDO() {
		IBaseDO[] dos = getChildren(NeBtrVtDO.class);
		if(dos==null) return null;
		NeBtrVtDO[] result=new NeBtrVtDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NeBtrVtDO)dos[i];
		}
		return result;
	}
	
	public void setNeBtrVtDO(NeBtrVtDO[] dos) {
		setChildren(NeBtrVtDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		TransfusionAggDODesc desc = new TransfusionAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new NeBtrDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.mp.ne.transfusion.d.NeBtrItmDO")) {
             return new NeBtrItmDO();
         }
	    else if (clzName.equals("iih.mp.ne.transfusion.d.NeBtrReaDO")) {
             return new NeBtrReaDO();
         }
	    else if (clzName.equals("iih.mp.ne.transfusion.d.NeBtrVtDO")) {
             return new NeBtrVtDO();
         }
         return null;
     }
}