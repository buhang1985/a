package iih.ci.mrm.cimrfpdicatado.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.mrm.cimrfpdicatado.d.desc.CimrfpdicatadoAggDODesc;



/**
 * 病案编目诊断
 */
public class CimrfpdicatadoAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public CiMrFpDiCataDO getParentDO() {
		return ((CiMrFpDiCataDO) super.getParentDO());
	}

	public void setParentDO(CiMrFpDiCataDO headDO) {
		setParent(headDO);
	}

	public CiMrFpZYDiCataDO[] getCiMrFpZYDiCataDO() {
		IBaseDO[] dos = getChildren(CiMrFpZYDiCataDO.class);
		if(dos==null) return null;
		CiMrFpZYDiCataDO[] result=new CiMrFpZYDiCataDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(CiMrFpZYDiCataDO)dos[i];
		}
		return result;
	}
	
	public void setCiMrFpZYDiCataDO(CiMrFpZYDiCataDO[] dos) {
		setChildren(CiMrFpZYDiCataDO.class, dos);
	}
	public CiMrFpXYDiCataDO[] getCiMrFpXYDiCataDO() {
		IBaseDO[] dos = getChildren(CiMrFpXYDiCataDO.class);
		if(dos==null) return null;
		CiMrFpXYDiCataDO[] result=new CiMrFpXYDiCataDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(CiMrFpXYDiCataDO)dos[i];
		}
		return result;
	}
	
	public void setCiMrFpXYDiCataDO(CiMrFpXYDiCataDO[] dos) {
		setChildren(CiMrFpXYDiCataDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		CimrfpdicatadoAggDODesc desc = new CimrfpdicatadoAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new CiMrFpDiCataDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.mrm.cimrfpdicatado.d.CiMrFpZYDiCataDO")) {
             return new CiMrFpZYDiCataDO();
         }
	    else if (clzName.equals("iih.ci.mrm.cimrfpdicatado.d.CiMrFpXYDiCataDO")) {
             return new CiMrFpXYDiCataDO();
         }
         return null;
     }
}