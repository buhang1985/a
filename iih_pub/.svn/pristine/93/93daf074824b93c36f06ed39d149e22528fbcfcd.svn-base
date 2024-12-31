package iih.pe.pitm.peitflisitm.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.pitm.peitflisitm.d.desc.PeitflisitmAggDODesc;



/**
 * 体检接口_LIS明细
 */
public class PeitflisitmAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeItfLisPartDO getParentDO() {
		return ((PeItfLisPartDO) super.getParentDO());
	}

	public void setParentDO(PeItfLisPartDO headDO) {
		setParent(headDO);
	}

	public PeItfLisItmDO[] getPeItfLisItmDO() {
		IBaseDO[] dos = getChildren(PeItfLisItmDO.class);
		if(dos==null) return null;
		PeItfLisItmDO[] result=new PeItfLisItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeItfLisItmDO)dos[i];
		}
		return result;
	}
	
	public void setPeItfLisItmDO(PeItfLisItmDO[] dos) {
		setChildren(PeItfLisItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PeitflisitmAggDODesc desc = new PeitflisitmAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeItfLisPartDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.pitm.peitflisitm.d.PeItfLisItmDO")) {
             return new PeItfLisItmDO();
         }
         return null;
     }
}