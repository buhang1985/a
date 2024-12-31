package iih.nm.nqm.nmnqmnchk.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nm.nqm.nmnqmnchk.d.desc.NmnqmnchkAggDODesc;



/**
 * 护理管理_夜查房任务1
 */
public class NmnqmnchkAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public NmNqmNchkDO getParentDO() {
		return ((NmNqmNchkDO) super.getParentDO());
	}

	public void setParentDO(NmNqmNchkDO headDO) {
		setParent(headDO);
	}

	public NmNqmNchkItmDO[] getNmNqmNchkItmDO() {
		IBaseDO[] dos = getChildren(NmNqmNchkItmDO.class);
		if(dos==null) return null;
		NmNqmNchkItmDO[] result=new NmNqmNchkItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NmNqmNchkItmDO)dos[i];
		}
		return result;
	}
	
	public void setNmNqmNchkItmDO(NmNqmNchkItmDO[] dos) {
		setChildren(NmNqmNchkItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		NmnqmnchkAggDODesc desc = new NmnqmnchkAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new NmNqmNchkDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nm.nqm.nmnqmnchk.d.NmNqmNchkItmDO")) {
             return new NmNqmNchkItmDO();
         }
         return null;
     }
}