package iih.nm.nit.nipracfbtmpl.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nm.nit.nipracfbtmpl.d.desc.NipracfbtmplAggDODesc;



/**
 * 实习反馈模板
 */
public class NipracfbtmplAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public NiPracfbTmplDO getParentDO() {
		return ((NiPracfbTmplDO) super.getParentDO());
	}

	public void setParentDO(NiPracfbTmplDO headDO) {
		setParent(headDO);
	}

	public NiPracfbTmplItmDO[] getNiPracfbTmplItmDO() {
		IBaseDO[] dos = getChildren(NiPracfbTmplItmDO.class);
		if(dos==null) return null;
		NiPracfbTmplItmDO[] result=new NiPracfbTmplItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NiPracfbTmplItmDO)dos[i];
		}
		return result;
	}
	
	public void setNiPracfbTmplItmDO(NiPracfbTmplItmDO[] dos) {
		setChildren(NiPracfbTmplItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		NipracfbtmplAggDODesc desc = new NipracfbtmplAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new NiPracfbTmplDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nm.nit.nipracfbtmpl.d.NiPracfbTmplItmDO")) {
             return new NiPracfbTmplItmDO();
         }
         return null;
     }
}