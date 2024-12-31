package iih.nm.nqm.nqmchk.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nm.nqm.nqmchk.d.desc.NqmchkAggDODesc;



/**
 * 质量检查
 */
public class NqmchkAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public NqmChkDO getParentDO() {
		return ((NqmChkDO) super.getParentDO());
	}

	public void setParentDO(NqmChkDO headDO) {
		setParent(headDO);
	}

	public NmNqmChkItmDO[] getNmNqmChkItmDO() {
		IBaseDO[] dos = getChildren(NmNqmChkItmDO.class);
		if(dos==null) return null;
		NmNqmChkItmDO[] result=new NmNqmChkItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NmNqmChkItmDO)dos[i];
		}
		return result;
	}
	
	public void setNmNqmChkItmDO(NmNqmChkItmDO[] dos) {
		setChildren(NmNqmChkItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		NqmchkAggDODesc desc = new NqmchkAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new NqmChkDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nm.nqm.nqmchk.d.NmNqmChkItmDO")) {
             return new NmNqmChkItmDO();
         }
         return null;
     }
}