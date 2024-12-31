package iih.nm.nhr.nmnhrschedrp.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nm.nhr.nmnhrschedrp.d.desc.NmnhrschedrpAggDODesc;



/**
 * 替班申请
 */
public class NmnhrschedrpAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public NhrSchedRpDO getParentDO() {
		return ((NhrSchedRpDO) super.getParentDO());
	}

	public void setParentDO(NhrSchedRpDO headDO) {
		setParent(headDO);
	}

	public NhrSchedRpItmDO[] getNhrSchedRpItmDO() {
		IBaseDO[] dos = getChildren(NhrSchedRpItmDO.class);
		if(dos==null) return null;
		NhrSchedRpItmDO[] result=new NhrSchedRpItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NhrSchedRpItmDO)dos[i];
		}
		return result;
	}
	
	public void setNhrSchedRpItmDO(NhrSchedRpItmDO[] dos) {
		setChildren(NhrSchedRpItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		NmnhrschedrpAggDODesc desc = new NmnhrschedrpAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new NhrSchedRpDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nm.nhr.nmnhrschedrp.d.NhrSchedRpItmDO")) {
             return new NhrSchedRpItmDO();
         }
         return null;
     }
}