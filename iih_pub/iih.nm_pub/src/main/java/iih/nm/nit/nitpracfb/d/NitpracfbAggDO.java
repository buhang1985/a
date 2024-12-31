package iih.nm.nit.nitpracfb.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nm.nit.nitpracfb.d.desc.NitpracfbAggDODesc;



/**
 * 实习反馈
 */
public class NitpracfbAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public NitPracfbDO getParentDO() {
		return ((NitPracfbDO) super.getParentDO());
	}

	public void setParentDO(NitPracfbDO headDO) {
		setParent(headDO);
	}

	public NitPracfbItmDO[] getNitPracfbItmDO() {
		IBaseDO[] dos = getChildren(NitPracfbItmDO.class);
		if(dos==null) return null;
		NitPracfbItmDO[] result=new NitPracfbItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NitPracfbItmDO)dos[i];
		}
		return result;
	}
	
	public void setNitPracfbItmDO(NitPracfbItmDO[] dos) {
		setChildren(NitPracfbItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		NitpracfbAggDODesc desc = new NitpracfbAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new NitPracfbDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nm.nit.nitpracfb.d.NitPracfbItmDO")) {
             return new NitPracfbItmDO();
         }
         return null;
     }
}