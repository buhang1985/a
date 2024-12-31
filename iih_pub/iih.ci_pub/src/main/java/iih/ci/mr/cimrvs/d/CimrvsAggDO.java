package iih.ci.mr.cimrvs.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.mr.cimrvs.d.desc.CimrvsAggDODesc;



/**
 * 临床生命体征测量
 */
public class CimrvsAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public CiMrVsDO getParentDO() {
		return ((CiMrVsDO) super.getParentDO());
	}

	public void setParentDO(CiMrVsDO headDO) {
		setParent(headDO);
	}

	public CiMrVsItmDO[] getCiMrVsItmDO() {
		IBaseDO[] dos = getChildren(CiMrVsItmDO.class);
		if(dos==null) return null;
		CiMrVsItmDO[] result=new CiMrVsItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(CiMrVsItmDO)dos[i];
		}
		return result;
	}
	
	public void setCiMrVsItmDO(CiMrVsItmDO[] dos) {
		setChildren(CiMrVsItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		CimrvsAggDODesc desc = new CimrvsAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new CiMrVsDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.mr.cimrvs.d.CiMrVsItmDO")) {
             return new CiMrVsItmDO();
         }
         return null;
     }
}