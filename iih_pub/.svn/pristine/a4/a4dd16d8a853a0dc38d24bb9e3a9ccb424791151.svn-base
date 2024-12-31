package iih.nm.nqm.nmnqmcs.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nm.nqm.nmnqmcs.d.desc.NmnqmcsAggDODesc;



/**
 * 检查标准
 */
public class NmnqmcsAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public NmNqmCsDO getParentDO() {
		return ((NmNqmCsDO) super.getParentDO());
	}

	public void setParentDO(NmNqmCsDO headDO) {
		setParent(headDO);
	}

	public NmNqmCsExtDO[] getNmNqmCsExtDO() {
		IBaseDO[] dos = getChildren(NmNqmCsExtDO.class);
		if(dos==null) return null;
		NmNqmCsExtDO[] result=new NmNqmCsExtDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NmNqmCsExtDO)dos[i];
		}
		return result;
	}
	
	public void setNmNqmCsExtDO(NmNqmCsExtDO[] dos) {
		setChildren(NmNqmCsExtDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		NmnqmcsAggDODesc desc = new NmnqmcsAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new NmNqmCsDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nm.nqm.nmnqmcs.d.NmNqmCsExtDO")) {
             return new NmNqmCsExtDO();
         }
         return null;
     }
}