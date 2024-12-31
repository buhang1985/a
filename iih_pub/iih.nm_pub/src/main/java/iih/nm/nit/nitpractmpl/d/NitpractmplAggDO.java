package iih.nm.nit.nitpractmpl.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nm.nit.nitpractmpl.d.desc.NitpractmplAggDODesc;



/**
 * 护理管理_实习科室轮转模板
 */
public class NitpractmplAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public NitPractmplDO getParentDO() {
		return ((NitPractmplDO) super.getParentDO());
	}

	public void setParentDO(NitPractmplDO headDO) {
		setParent(headDO);
	}

	public NitPractmplDepDO[] getNitPractmplDepDO() {
		IBaseDO[] dos = getChildren(NitPractmplDepDO.class);
		if(dos==null) return null;
		NitPractmplDepDO[] result=new NitPractmplDepDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NitPractmplDepDO)dos[i];
		}
		return result;
	}
	
	public void setNitPractmplDepDO(NitPractmplDepDO[] dos) {
		setChildren(NitPractmplDepDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		NitpractmplAggDODesc desc = new NitpractmplAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new NitPractmplDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nm.nit.nitpractmpl.d.NitPractmplDepDO")) {
             return new NitPractmplDepDO();
         }
         return null;
     }
}