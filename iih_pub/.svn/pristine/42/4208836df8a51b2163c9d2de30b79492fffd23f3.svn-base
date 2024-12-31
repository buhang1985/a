package iih.en.pv.vt.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.en.pv.vt.d.desc.EnvtAggDODesc;



/**
 * 就诊_体征
 */
public class EnvtAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public EnVtDO getParentDO() {
		return ((EnVtDO) super.getParentDO());
	}

	public void setParentDO(EnVtDO headDO) {
		setParent(headDO);
	}

	public EnVtSrvDO[] getEnVtSrvDO() {
		IBaseDO[] dos = getChildren(EnVtSrvDO.class);
		if(dos==null) return null;
		EnVtSrvDO[] result=new EnVtSrvDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(EnVtSrvDO)dos[i];
		}
		return result;
	}
	
	public void setEnVtSrvDO(EnVtSrvDO[] dos) {
		setChildren(EnVtSrvDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		EnvtAggDODesc desc = new EnvtAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new EnVtDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.en.pv.vt.d.EnVtSrvDO")) {
             return new EnVtSrvDO();
         }
         return null;
     }
}