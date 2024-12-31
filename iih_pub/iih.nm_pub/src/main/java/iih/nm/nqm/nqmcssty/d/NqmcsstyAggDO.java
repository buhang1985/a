package iih.nm.nqm.nqmcssty.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nm.nqm.nqmcssty.d.desc.NqmcsstyAggDODesc;



/**
 * 质量检查表样式
 */
public class NqmcsstyAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public NqmCsStyDO getParentDO() {
		return ((NqmCsStyDO) super.getParentDO());
	}

	public void setParentDO(NqmCsStyDO headDO) {
		setParent(headDO);
	}

	public NqmCsStyItmDO[] getNqmCsStyItmDO() {
		IBaseDO[] dos = getChildren(NqmCsStyItmDO.class);
		if(dos==null) return null;
		NqmCsStyItmDO[] result=new NqmCsStyItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NqmCsStyItmDO)dos[i];
		}
		return result;
	}
	
	public void setNqmCsStyItmDO(NqmCsStyItmDO[] dos) {
		setChildren(NqmCsStyItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		NqmcsstyAggDODesc desc = new NqmcsstyAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new NqmCsStyDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nm.nqm.nqmcssty.d.NqmCsStyItmDO")) {
             return new NqmCsStyItmDO();
         }
         return null;
     }
}