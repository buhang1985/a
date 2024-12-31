package iih.pe.pitm.pepsydef.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.pitm.pepsydef.d.desc.PepsydefAggDODesc;



/**
 * 体检心理处方定义
 */
public class PepsydefAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PePsyTpDO getParentDO() {
		return ((PePsyTpDO) super.getParentDO());
	}

	public void setParentDO(PePsyTpDO headDO) {
		setParent(headDO);
	}

	public PePsyDefDO[] getPePsyDefDO() {
		IBaseDO[] dos = getChildren(PePsyDefDO.class);
		if(dos==null) return null;
		PePsyDefDO[] result=new PePsyDefDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PePsyDefDO)dos[i];
		}
		return result;
	}
	
	public void setPePsyDefDO(PePsyDefDO[] dos) {
		setChildren(PePsyDefDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PepsydefAggDODesc desc = new PepsydefAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PePsyTpDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.pitm.pepsydef.d.PePsyDefDO")) {
             return new PePsyDefDO();
         }
         return null;
     }
}