package iih.pe.pqn.peqacatlog.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.pqn.peqacatlog.d.desc.PeqacatlogAggDODesc;



/**
 * 体检问卷问题分组
 */
public class PeqacatlogAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeQaCatDO getParentDO() {
		return ((PeQaCatDO) super.getParentDO());
	}

	public void setParentDO(PeQaCatDO headDO) {
		setParent(headDO);
	}

	public PeQaCatGrdDO[] getPeQaCatGrdDO() {
		IBaseDO[] dos = getChildren(PeQaCatGrdDO.class);
		if(dos==null) return null;
		PeQaCatGrdDO[] result=new PeQaCatGrdDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeQaCatGrdDO)dos[i];
		}
		return result;
	}
	
	public void setPeQaCatGrdDO(PeQaCatGrdDO[] dos) {
		setChildren(PeQaCatGrdDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PeqacatlogAggDODesc desc = new PeqacatlogAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeQaCatDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.pqn.peqacatlog.d.PeQaCatGrdDO")) {
             return new PeQaCatGrdDO();
         }
         return null;
     }
}