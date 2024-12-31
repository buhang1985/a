package iih.pe.pqn.pehramodel.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.pqn.pehramodel.d.desc.PehramodelAggDODesc;



/**
 * 体检疾病风险评估模型
 */
public class PehramodelAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeHraModelDO getParentDO() {
		return ((PeHraModelDO) super.getParentDO());
	}

	public void setParentDO(PeHraModelDO headDO) {
		setParent(headDO);
	}

	public PeHraModelRiskDO[] getPeHraModelRiskDO() {
		IBaseDO[] dos = getChildren(PeHraModelRiskDO.class);
		if(dos==null) return null;
		PeHraModelRiskDO[] result=new PeHraModelRiskDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeHraModelRiskDO)dos[i];
		}
		return result;
	}
	
	public void setPeHraModelRiskDO(PeHraModelRiskDO[] dos) {
		setChildren(PeHraModelRiskDO.class, dos);
	}
	public PeHraModelIRDO[] getPeHraModelIRDO() {
		IBaseDO[] dos = getChildren(PeHraModelIRDO.class);
		if(dos==null) return null;
		PeHraModelIRDO[] result=new PeHraModelIRDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeHraModelIRDO)dos[i];
		}
		return result;
	}
	
	public void setPeHraModelIRDO(PeHraModelIRDO[] dos) {
		setChildren(PeHraModelIRDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PehramodelAggDODesc desc = new PehramodelAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeHraModelDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.pqn.pehramodel.d.PeHraModelRiskDO")) {
             return new PeHraModelRiskDO();
         }
	    else if (clzName.equals("iih.pe.pqn.pehramodel.d.PeHraModelIRDO")) {
             return new PeHraModelIRDO();
         }
         return null;
     }
}