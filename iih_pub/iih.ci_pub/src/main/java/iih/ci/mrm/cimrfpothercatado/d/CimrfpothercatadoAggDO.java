package iih.ci.mrm.cimrfpothercatado.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.mrm.cimrfpothercatado.d.desc.CimrfpothercatadoAggDODesc;



/**
 * 病案编目其他
 */
public class CimrfpothercatadoAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public CiMrFpOtherCataDO getParentDO() {
		return ((CiMrFpOtherCataDO) super.getParentDO());
	}

	public void setParentDO(CiMrFpOtherCataDO headDO) {
		setParent(headDO);
	}

	public CiMrFpIntencareCataDO[] getCiMrFpIntencareCataDO() {
		IBaseDO[] dos = getChildren(CiMrFpIntencareCataDO.class);
		if(dos==null) return null;
		CiMrFpIntencareCataDO[] result=new CiMrFpIntencareCataDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(CiMrFpIntencareCataDO)dos[i];
		}
		return result;
	}
	
	public void setCiMrFpIntencareCataDO(CiMrFpIntencareCataDO[] dos) {
		setChildren(CiMrFpIntencareCataDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		CimrfpothercatadoAggDODesc desc = new CimrfpothercatadoAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new CiMrFpOtherCataDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.mrm.cimrfpothercatado.d.CiMrFpIntencareCataDO")) {
             return new CiMrFpIntencareCataDO();
         }
         return null;
     }
}