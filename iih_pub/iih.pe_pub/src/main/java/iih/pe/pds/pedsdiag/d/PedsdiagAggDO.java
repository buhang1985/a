package iih.pe.pds.pedsdiag.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.pds.pedsdiag.d.desc.PedsdiagAggDODesc;



/**
 * 体检诊断决策支持
 */
public class PedsdiagAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeDsDiagDefDO getParentDO() {
		return ((PeDsDiagDefDO) super.getParentDO());
	}

	public void setParentDO(PeDsDiagDefDO headDO) {
		setParent(headDO);
	}

	public PeDsDiagDO[] getPeDsDiagDO() {
		IBaseDO[] dos = getChildren(PeDsDiagDO.class);
		if(dos==null) return null;
		PeDsDiagDO[] result=new PeDsDiagDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeDsDiagDO)dos[i];
		}
		return result;
	}
	
	public void setPeDsDiagDO(PeDsDiagDO[] dos) {
		setChildren(PeDsDiagDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PedsdiagAggDODesc desc = new PedsdiagAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeDsDiagDefDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.pds.pedsdiag.d.PeDsDiagDO")) {
             return new PeDsDiagDO();
         }
         return null;
     }
}