package iih.bd.res.depcont.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.res.depcont.d.desc.DepcontAggDODesc;



/**
 * 医技科室对照
 */
public class DepcontAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public DepContDO getParentDO() {
		return ((DepContDO) super.getParentDO());
	}

	public void setParentDO(DepContDO headDO) {
		setParent(headDO);
	}

	public DepContItmDO[] getDepContItmDO() {
		IBaseDO[] dos = getChildren(DepContItmDO.class);
		if(dos==null) return null;
		DepContItmDO[] result=new DepContItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(DepContItmDO)dos[i];
		}
		return result;
	}
	
	public void setDepContItmDO(DepContItmDO[] dos) {
		setChildren(DepContItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		DepcontAggDODesc desc = new DepcontAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new DepContDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.res.depcont.d.DepContItmDO")) {
             return new DepContItmDO();
         }
         return null;
     }
}