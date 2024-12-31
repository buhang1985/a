package iih.nm.nqm.nmnqmnchkdet.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nm.nqm.nmnqmnchkdet.d.desc.NmnqmnchkdetAggDODesc;



/**
 * 护理管理_夜查房_检查病区22
 */
public class NmnqmnchkdetAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public NmNqmNchkDetDO getParentDO() {
		return ((NmNqmNchkDetDO) super.getParentDO());
	}

	public void setParentDO(NmNqmNchkDetDO headDO) {
		setParent(headDO);
	}

	public NmNqmNchkDetItmDO[] getNmNqmNchkDetItmDO() {
		IBaseDO[] dos = getChildren(NmNqmNchkDetItmDO.class);
		if(dos==null) return null;
		NmNqmNchkDetItmDO[] result=new NmNqmNchkDetItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NmNqmNchkDetItmDO)dos[i];
		}
		return result;
	}
	
	public void setNmNqmNchkDetItmDO(NmNqmNchkDetItmDO[] dos) {
		setChildren(NmNqmNchkDetItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		NmnqmnchkdetAggDODesc desc = new NmnqmnchkdetAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new NmNqmNchkDetDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nm.nqm.nmnqmnchkdet.d.NmNqmNchkDetItmDO")) {
             return new NmNqmNchkDetItmDO();
         }
         return null;
     }
}