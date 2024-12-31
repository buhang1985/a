package iih.nm.nhr.nmoptpl.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nm.nhr.nmoptpl.d.desc.NmoptplAggDODesc;



/**
 * 实习计划
 */
public class NmoptplAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public NmOptPlDO getParentDO() {
		return ((NmOptPlDO) super.getParentDO());
	}

	public void setParentDO(NmOptPlDO headDO) {
		setParent(headDO);
	}

	public NmOptPlDepDO[] getNmOptPlDepDO() {
		IBaseDO[] dos = getChildren(NmOptPlDepDO.class);
		if(dos==null) return null;
		NmOptPlDepDO[] result=new NmOptPlDepDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NmOptPlDepDO)dos[i];
		}
		return result;
	}
	
	public void setNmOptPlDepDO(NmOptPlDepDO[] dos) {
		setChildren(NmOptPlDepDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		NmoptplAggDODesc desc = new NmoptplAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new NmOptPlDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nm.nhr.nmoptpl.d.NmOptPlDepDO")) {
             return new NmOptPlDepDO();
         }
         return null;
     }
}