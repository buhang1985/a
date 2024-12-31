package iih.pe.pbd.peinstrument.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.pbd.peinstrument.d.desc.PeinstrumentAggDODesc;



/**
 * 仪器设备定义
 */
public class PeinstrumentAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeInstrumentDO getParentDO() {
		return ((PeInstrumentDO) super.getParentDO());
	}

	public void setParentDO(PeInstrumentDO headDO) {
		setParent(headDO);
	}

	public PeInstItmRelDefDO[] getPeInstItmRelDefDO() {
		IBaseDO[] dos = getChildren(PeInstItmRelDefDO.class);
		if(dos==null) return null;
		PeInstItmRelDefDO[] result=new PeInstItmRelDefDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeInstItmRelDefDO)dos[i];
		}
		return result;
	}
	
	public void setPeInstItmRelDefDO(PeInstItmRelDefDO[] dos) {
		setChildren(PeInstItmRelDefDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PeinstrumentAggDODesc desc = new PeinstrumentAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeInstrumentDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.pbd.peinstrument.d.PeInstItmRelDefDO")) {
             return new PeInstItmRelDefDO();
         }
         return null;
     }
}