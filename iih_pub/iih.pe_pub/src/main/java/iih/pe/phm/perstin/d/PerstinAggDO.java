package iih.pe.phm.perstin.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.phm.perstin.d.desc.PerstinAggDODesc;



/**
 * 体检手工录入结果
 */
public class PerstinAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeRstinDO getParentDO() {
		return ((PeRstinDO) super.getParentDO());
	}

	public void setParentDO(PeRstinDO headDO) {
		setParent(headDO);
	}

	public PeRstinDtlDO[] getPeRstinDtlDO() {
		IBaseDO[] dos = getChildren(PeRstinDtlDO.class);
		if(dos==null) return null;
		PeRstinDtlDO[] result=new PeRstinDtlDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeRstinDtlDO)dos[i];
		}
		return result;
	}
	
	public void setPeRstinDtlDO(PeRstinDtlDO[] dos) {
		setChildren(PeRstinDtlDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PerstinAggDODesc desc = new PerstinAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeRstinDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.phm.perstin.d.PeRstinDtlDO")) {
             return new PeRstinDtlDO();
         }
         return null;
     }
}