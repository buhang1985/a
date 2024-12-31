package iih.pe.pqn.peqacontentdef.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.pqn.peqacontentdef.d.desc.PeqacontentdefAggDODesc;



/**
 * 体检问卷问题库
 */
public class PeqacontentdefAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeQacontentDefDO getParentDO() {
		return ((PeQacontentDefDO) super.getParentDO());
	}

	public void setParentDO(PeQacontentDefDO headDO) {
		setParent(headDO);
	}

	public PeQakeyDefDO[] getPeQakeyDefDO() {
		IBaseDO[] dos = getChildren(PeQakeyDefDO.class);
		if(dos==null) return null;
		PeQakeyDefDO[] result=new PeQakeyDefDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeQakeyDefDO)dos[i];
		}
		return result;
	}
	
	public void setPeQakeyDefDO(PeQakeyDefDO[] dos) {
		setChildren(PeQakeyDefDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PeqacontentdefAggDODesc desc = new PeqacontentdefAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeQacontentDefDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.pqn.peqacontentdef.d.PeQakeyDefDO")) {
             return new PeQakeyDefDO();
         }
         return null;
     }
}