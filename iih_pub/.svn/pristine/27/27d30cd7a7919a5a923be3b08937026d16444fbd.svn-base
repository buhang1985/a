package iih.pe.pitm.pedishes.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.pitm.pedishes.d.desc.PedishesAggDODesc;



/**
 * 体检食物菜单定义
 */
public class PedishesAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeDishesDO getParentDO() {
		return ((PeDishesDO) super.getParentDO());
	}

	public void setParentDO(PeDishesDO headDO) {
		setParent(headDO);
	}

	public PeDishesItmDO[] getPeDishesItmDO() {
		IBaseDO[] dos = getChildren(PeDishesItmDO.class);
		if(dos==null) return null;
		PeDishesItmDO[] result=new PeDishesItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeDishesItmDO)dos[i];
		}
		return result;
	}
	
	public void setPeDishesItmDO(PeDishesItmDO[] dos) {
		setChildren(PeDishesItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PedishesAggDODesc desc = new PedishesAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeDishesDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.pitm.pedishes.d.PeDishesItmDO")) {
             return new PeDishesItmDO();
         }
         return null;
     }
}