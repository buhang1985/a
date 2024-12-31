package iih.bd.pp.pripat.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.pp.pripat.d.desc.PripatAggDODesc;



/**
 * 患者价格分类
 */
public class PripatAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PriPatDO getParentDO() {
		return ((PriPatDO) super.getParentDO());
	}

	public void setParentDO(PriPatDO headDO) {
		setParent(headDO);
	}

	public PriPatSrvOrCaDO[] getPriPatSrvOrCaDO() {
		IBaseDO[] dos = getChildren(PriPatSrvOrCaDO.class);
		if(dos==null) return null;
		PriPatSrvOrCaDO[] result=new PriPatSrvOrCaDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PriPatSrvOrCaDO)dos[i];
		}
		return result;
	}
	
	public void setPriPatSrvOrCaDO(PriPatSrvOrCaDO[] dos) {
		setChildren(PriPatSrvOrCaDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PripatAggDODesc desc = new PripatAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PriPatDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.pp.pripat.d.PriPatSrvOrCaDO")) {
             return new PriPatSrvOrCaDO();
         }
         return null;
     }
}