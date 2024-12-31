package iih.pe.por.pecorpcharge.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.por.pecorpcharge.d.desc.PecorpchargeAggDODesc;



/**
 * 体检团体账单
 */
public class PecorpchargeAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeCorpChargeDO getParentDO() {
		return ((PeCorpChargeDO) super.getParentDO());
	}

	public void setParentDO(PeCorpChargeDO headDO) {
		setParent(headDO);
	}

	public PeCorpChargeItmDO[] getPeCorpChargeItmDO() {
		IBaseDO[] dos = getChildren(PeCorpChargeItmDO.class);
		if(dos==null) return null;
		PeCorpChargeItmDO[] result=new PeCorpChargeItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeCorpChargeItmDO)dos[i];
		}
		return result;
	}
	
	public void setPeCorpChargeItmDO(PeCorpChargeItmDO[] dos) {
		setChildren(PeCorpChargeItmDO.class, dos);
	}
	public PeCorpChargeSumDO[] getPeCorpChargeSumDO() {
		IBaseDO[] dos = getChildren(PeCorpChargeSumDO.class);
		if(dos==null) return null;
		PeCorpChargeSumDO[] result=new PeCorpChargeSumDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeCorpChargeSumDO)dos[i];
		}
		return result;
	}
	
	public void setPeCorpChargeSumDO(PeCorpChargeSumDO[] dos) {
		setChildren(PeCorpChargeSumDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PecorpchargeAggDODesc desc = new PecorpchargeAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeCorpChargeDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.por.pecorpcharge.d.PeCorpChargeItmDO")) {
             return new PeCorpChargeItmDO();
         }
	    else if (clzName.equals("iih.pe.por.pecorpcharge.d.PeCorpChargeSumDO")) {
             return new PeCorpChargeSumDO();
         }
         return null;
     }
}