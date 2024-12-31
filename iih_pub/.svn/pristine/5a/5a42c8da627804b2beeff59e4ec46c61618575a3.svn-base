package iih.pe.phm.persthra.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.phm.persthra.d.desc.PersthraAggDODesc;



/**
 * 健康评估结果-单因素
 */
public class PersthraAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeRstHraDO getParentDO() {
		return ((PeRstHraDO) super.getParentDO());
	}

	public void setParentDO(PeRstHraDO headDO) {
		setParent(headDO);
	}

	public PeRstHraRiskDO[] getPeRstHraRiskDO() {
		IBaseDO[] dos = getChildren(PeRstHraRiskDO.class);
		if(dos==null) return null;
		PeRstHraRiskDO[] result=new PeRstHraRiskDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeRstHraRiskDO)dos[i];
		}
		return result;
	}
	
	public void setPeRstHraRiskDO(PeRstHraRiskDO[] dos) {
		setChildren(PeRstHraRiskDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PersthraAggDODesc desc = new PersthraAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeRstHraDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.phm.persthra.d.PeRstHraRiskDO")) {
             return new PeRstHraRiskDO();
         }
         return null;
     }
}