package iih.pe.phm.persticvd.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.phm.persticvd.d.desc.PersticvdAggDODesc;



/**
 * 健康管理_缺血性冠心病评估结果
 */
public class PersticvdAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeRstIcvdDO getParentDO() {
		return ((PeRstIcvdDO) super.getParentDO());
	}

	public void setParentDO(PeRstIcvdDO headDO) {
		setParent(headDO);
	}

	public PeRstIcvdRiskDO[] getPeRstIcvdRiskDO() {
		IBaseDO[] dos = getChildren(PeRstIcvdRiskDO.class);
		if(dos==null) return null;
		PeRstIcvdRiskDO[] result=new PeRstIcvdRiskDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeRstIcvdRiskDO)dos[i];
		}
		return result;
	}
	
	public void setPeRstIcvdRiskDO(PeRstIcvdRiskDO[] dos) {
		setChildren(PeRstIcvdRiskDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PersticvdAggDODesc desc = new PersticvdAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeRstIcvdDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.phm.persticvd.d.PeRstIcvdRiskDO")) {
             return new PeRstIcvdRiskDO();
         }
         return null;
     }
}