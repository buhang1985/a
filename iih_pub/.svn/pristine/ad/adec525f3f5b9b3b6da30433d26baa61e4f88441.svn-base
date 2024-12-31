package iih.nm.nhr.nmoptplpsn.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nm.nhr.nmoptplpsn.d.desc.NmoptplpsnAggDODesc;



/**
 * 实习计划_参与人员
 */
public class NmoptplpsnAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public NmOptPlPsnDO getParentDO() {
		return ((NmOptPlPsnDO) super.getParentDO());
	}

	public void setParentDO(NmOptPlPsnDO headDO) {
		setParent(headDO);
	}

	public NmOptPsnRecDO[] getNmOptPsnRecDO() {
		IBaseDO[] dos = getChildren(NmOptPsnRecDO.class);
		if(dos==null) return null;
		NmOptPsnRecDO[] result=new NmOptPsnRecDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NmOptPsnRecDO)dos[i];
		}
		return result;
	}
	
	public void setNmOptPsnRecDO(NmOptPsnRecDO[] dos) {
		setChildren(NmOptPsnRecDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		NmoptplpsnAggDODesc desc = new NmoptplpsnAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new NmOptPlPsnDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nm.nhr.nmoptplpsn.d.NmOptPsnRecDO")) {
             return new NmOptPsnRecDO();
         }
         return null;
     }
}