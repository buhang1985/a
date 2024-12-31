package iih.nm.nhr.nmnurlabor.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nm.nhr.nmnurlabor.d.desc.NmnurlaborAggDODesc;



/**
 * 工时调整
 */
public class NmnurlaborAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public NmNurLaborDO getParentDO() {
		return ((NmNurLaborDO) super.getParentDO());
	}

	public void setParentDO(NmNurLaborDO headDO) {
		setParent(headDO);
	}

	public NmNurLaborAdjDO[] getNmNurLaborAdjDO() {
		IBaseDO[] dos = getChildren(NmNurLaborAdjDO.class);
		if(dos==null) return null;
		NmNurLaborAdjDO[] result=new NmNurLaborAdjDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NmNurLaborAdjDO)dos[i];
		}
		return result;
	}
	
	public void setNmNurLaborAdjDO(NmNurLaborAdjDO[] dos) {
		setChildren(NmNurLaborAdjDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		NmnurlaborAggDODesc desc = new NmnurlaborAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new NmNurLaborDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nm.nhr.nmnurlabor.d.NmNurLaborAdjDO")) {
             return new NmNurLaborAdjDO();
         }
         return null;
     }
}