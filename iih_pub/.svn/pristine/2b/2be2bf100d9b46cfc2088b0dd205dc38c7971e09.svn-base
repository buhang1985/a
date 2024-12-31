package iih.pe.pitm.pesrvprog.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.pitm.pesrvprog.d.desc.PesrvprogAggDODesc;



/**
 * 体检方案定义
 */
public class PesrvprogAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeSrvProgDO getParentDO() {
		return ((PeSrvProgDO) super.getParentDO());
	}

	public void setParentDO(PeSrvProgDO headDO) {
		setParent(headDO);
	}

	public PeSrvProgAgeDO[] getPeSrvProgAgeDO() {
		IBaseDO[] dos = getChildren(PeSrvProgAgeDO.class);
		if(dos==null) return null;
		PeSrvProgAgeDO[] result=new PeSrvProgAgeDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeSrvProgAgeDO)dos[i];
		}
		return result;
	}
	
	public void setPeSrvProgAgeDO(PeSrvProgAgeDO[] dos) {
		setChildren(PeSrvProgAgeDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PesrvprogAggDODesc desc = new PesrvprogAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeSrvProgDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.pitm.pesrvprog.d.PeSrvProgAgeDO")) {
             return new PeSrvProgAgeDO();
         }
         return null;
     }
}