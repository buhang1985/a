package iih.mm.pl.trapimpl.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.mm.pl.trapimpl.d.desc.TrapimplAggDODesc;



/**
 * 调拨单
 */
public class TrapimplAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public TrapImplDO getParentDO() {
		return ((TrapImplDO) super.getParentDO());
	}

	public void setParentDO(TrapImplDO headDO) {
		setParent(headDO);
	}

	public TrapImplItemDO[] getTrapImplItemDO() {
		IBaseDO[] dos = getChildren(TrapImplItemDO.class);
		if(dos==null) return null;
		TrapImplItemDO[] result=new TrapImplItemDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(TrapImplItemDO)dos[i];
		}
		return result;
	}
	
	public void setTrapImplItemDO(TrapImplItemDO[] dos) {
		setChildren(TrapImplItemDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		TrapimplAggDODesc desc = new TrapimplAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new TrapImplDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.mm.pl.trapimpl.d.TrapImplItemDO")) {
             return new TrapImplItemDO();
         }
         return null;
     }
}