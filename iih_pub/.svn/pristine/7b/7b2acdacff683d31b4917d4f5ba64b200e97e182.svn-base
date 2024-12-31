package iih.pe.pitm.perulecombine.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.pitm.perulecombine.d.desc.PerulecombineAggDODesc;



/**
 * 体检组合规则定义
 */
public class PerulecombineAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeRuleCombineDO getParentDO() {
		return ((PeRuleCombineDO) super.getParentDO());
	}

	public void setParentDO(PeRuleCombineDO headDO) {
		setParent(headDO);
	}

	public PeRuleCombineItemDO[] getPeRuleCombineItemDO() {
		IBaseDO[] dos = getChildren(PeRuleCombineItemDO.class);
		if(dos==null) return null;
		PeRuleCombineItemDO[] result=new PeRuleCombineItemDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeRuleCombineItemDO)dos[i];
		}
		return result;
	}
	
	public void setPeRuleCombineItemDO(PeRuleCombineItemDO[] dos) {
		setChildren(PeRuleCombineItemDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PerulecombineAggDODesc desc = new PerulecombineAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeRuleCombineDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.pitm.perulecombine.d.PeRuleCombineItemDO")) {
             return new PeRuleCombineItemDO();
         }
         return null;
     }
}