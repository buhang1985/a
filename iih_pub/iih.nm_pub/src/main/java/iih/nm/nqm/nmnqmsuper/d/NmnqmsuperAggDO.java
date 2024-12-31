package iih.nm.nqm.nmnqmsuper.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nm.nqm.nmnqmsuper.d.desc.NmnqmsuperAggDODesc;



/**
 * 护理管理_督导项
 */
public class NmnqmsuperAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public NmNqmSuperDO getParentDO() {
		return ((NmNqmSuperDO) super.getParentDO());
	}

	public void setParentDO(NmNqmSuperDO headDO) {
		setParent(headDO);
	}

	public NmNqmSuperItmDO[] getNmNqmSuperItmDO() {
		IBaseDO[] dos = getChildren(NmNqmSuperItmDO.class);
		if(dos==null) return null;
		NmNqmSuperItmDO[] result=new NmNqmSuperItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NmNqmSuperItmDO)dos[i];
		}
		return result;
	}
	
	public void setNmNqmSuperItmDO(NmNqmSuperItmDO[] dos) {
		setChildren(NmNqmSuperItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		NmnqmsuperAggDODesc desc = new NmnqmsuperAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new NmNqmSuperDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nm.nqm.nmnqmsuper.d.NmNqmSuperItmDO")) {
             return new NmNqmSuperItmDO();
         }
         return null;
     }
}