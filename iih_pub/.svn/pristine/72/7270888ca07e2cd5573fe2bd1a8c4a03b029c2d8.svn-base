package iih.nm.nca.nmncatmplca.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nm.nca.nmncatmplca.d.desc.NmncatmplcaAggDODesc;



/**
 * 满意度问卷模板分类
 */
public class NmncatmplcaAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public NmNcaTmplcaDO getParentDO() {
		return ((NmNcaTmplcaDO) super.getParentDO());
	}

	public void setParentDO(NmNcaTmplcaDO headDO) {
		setParent(headDO);
	}

	public NmNcaTmplOptaDO[] getNmNcaTmplOptaDO() {
		IBaseDO[] dos = getChildren(NmNcaTmplOptaDO.class);
		if(dos==null) return null;
		NmNcaTmplOptaDO[] result=new NmNcaTmplOptaDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NmNcaTmplOptaDO)dos[i];
		}
		return result;
	}
	
	public void setNmNcaTmplOptaDO(NmNcaTmplOptaDO[] dos) {
		setChildren(NmNcaTmplOptaDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		NmncatmplcaAggDODesc desc = new NmncatmplcaAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new NmNcaTmplcaDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nm.nca.nmncatmplca.d.NmNcaTmplOptaDO")) {
             return new NmNcaTmplOptaDO();
         }
         return null;
     }
}