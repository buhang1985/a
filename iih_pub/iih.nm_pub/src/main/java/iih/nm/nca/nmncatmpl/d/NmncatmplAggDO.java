package iih.nm.nca.nmncatmpl.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nm.nca.nmncatmpl.d.desc.NmncatmplAggDODesc;



/**
 * 满意度问卷模板
 */
public class NmncatmplAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public NmNcaTpmlDO getParentDO() {
		return ((NmNcaTpmlDO) super.getParentDO());
	}

	public void setParentDO(NmNcaTpmlDO headDO) {
		setParent(headDO);
	}

	public NmNcaTmplItmDO[] getNmNcaTmplItmDO() {
		IBaseDO[] dos = getChildren(NmNcaTmplItmDO.class);
		if(dos==null) return null;
		NmNcaTmplItmDO[] result=new NmNcaTmplItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NmNcaTmplItmDO)dos[i];
		}
		return result;
	}
	
	public void setNmNcaTmplItmDO(NmNcaTmplItmDO[] dos) {
		setChildren(NmNcaTmplItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		NmncatmplAggDODesc desc = new NmncatmplAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new NmNcaTpmlDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nm.nca.nmncatmpl.d.NmNcaTmplItmDO")) {
             return new NmNcaTmplItmDO();
         }
         return null;
     }
}