package iih.nm.nhr.nmdeppl.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nm.nhr.nmdeppl.d.desc.NmdepplAggDODesc;



/**
 * 实习科室轮转计划
 */
public class NmdepplAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public NmDepplDO getParentDO() {
		return ((NmDepplDO) super.getParentDO());
	}

	public void setParentDO(NmDepplDO headDO) {
		setParent(headDO);
	}

	public NmNurpsnPlDO[] getNmNurpsnPlDO() {
		IBaseDO[] dos = getChildren(NmNurpsnPlDO.class);
		if(dos==null) return null;
		NmNurpsnPlDO[] result=new NmNurpsnPlDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NmNurpsnPlDO)dos[i];
		}
		return result;
	}
	
	public void setNmNurpsnPlDO(NmNurpsnPlDO[] dos) {
		setChildren(NmNurpsnPlDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		NmdepplAggDODesc desc = new NmdepplAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new NmDepplDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nm.nhr.nmdeppl.d.NmNurpsnPlDO")) {
             return new NmNurpsnPlDO();
         }
         return null;
     }
}