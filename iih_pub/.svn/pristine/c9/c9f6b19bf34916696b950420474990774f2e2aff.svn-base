package iih.bd.pp.incca.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.pp.incca.d.desc.InccaAggDODesc;



/**
 * 票据分类
 */
public class InccaAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public IncCaDO getParentDO() {
		return ((IncCaDO) super.getParentDO());
	}

	public void setParentDO(IncCaDO headDO) {
		setParent(headDO);
	}

	public IncCaItmDO[] getIncCaItmDO() {
		IBaseDO[] dos = getChildren(IncCaItmDO.class);
		if(dos==null) return null;
		IncCaItmDO[] result=new IncCaItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(IncCaItmDO)dos[i];
		}
		return result;
	}
	
	public void setIncCaItmDO(IncCaItmDO[] dos) {
		setChildren(IncCaItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		InccaAggDODesc desc = new InccaAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new IncCaDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.pp.incca.d.IncCaItmDO")) {
             return new IncCaItmDO();
         }
         return null;
     }
}