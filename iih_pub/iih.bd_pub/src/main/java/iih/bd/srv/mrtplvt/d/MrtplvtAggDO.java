package iih.bd.srv.mrtplvt.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.srv.mrtplvt.d.desc.MrtplvtAggDODesc;



/**
 * 生命体征测量
 */
public class MrtplvtAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public MrtplVtDO getParentDO() {
		return ((MrtplVtDO) super.getParentDO());
	}

	public void setParentDO(MrtplVtDO headDO) {
		setParent(headDO);
	}

	public MrtplVtItmDO[] getMrtplVtItmDO() {
		IBaseDO[] dos = getChildren(MrtplVtItmDO.class);
		if(dos==null) return null;
		MrtplVtItmDO[] result=new MrtplVtItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(MrtplVtItmDO)dos[i];
		}
		return result;
	}
	
	public void setMrtplVtItmDO(MrtplVtItmDO[] dos) {
		setChildren(MrtplVtItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		MrtplvtAggDODesc desc = new MrtplvtAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new MrtplVtDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.srv.mrtplvt.d.MrtplVtItmDO")) {
             return new MrtplVtItmDO();
         }
         return null;
     }
}