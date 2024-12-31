package iih.pe.pitm.penarraterecipe.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.pitm.penarraterecipe.d.desc.PenarraterecipeAggDODesc;



/**
 * 体检叙述型营养处方
 */
public class PenarraterecipeAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeNarrateRecipeDO getParentDO() {
		return ((PeNarrateRecipeDO) super.getParentDO());
	}

	public void setParentDO(PeNarrateRecipeDO headDO) {
		setParent(headDO);
	}

	public PeNarrateRecipeItmDO[] getPeNarrateRecipeItmDO() {
		IBaseDO[] dos = getChildren(PeNarrateRecipeItmDO.class);
		if(dos==null) return null;
		PeNarrateRecipeItmDO[] result=new PeNarrateRecipeItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeNarrateRecipeItmDO)dos[i];
		}
		return result;
	}
	
	public void setPeNarrateRecipeItmDO(PeNarrateRecipeItmDO[] dos) {
		setChildren(PeNarrateRecipeItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PenarraterecipeAggDODesc desc = new PenarraterecipeAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeNarrateRecipeDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.pitm.penarraterecipe.d.PeNarrateRecipeItmDO")) {
             return new PeNarrateRecipeItmDO();
         }
         return null;
     }
}