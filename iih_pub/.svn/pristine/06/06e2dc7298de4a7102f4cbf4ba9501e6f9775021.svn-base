package iih.pe.pqn.pediabmodel.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.pqn.pediabmodel.d.desc.PediabmodelAggDODesc;



/**
 * 健康评估模型_糖尿病
 */
public class PediabmodelAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeDiabModelDO getParentDO() {
		return ((PeDiabModelDO) super.getParentDO());
	}

	public void setParentDO(PeDiabModelDO headDO) {
		setParent(headDO);
	}

	public PeDiabModelAgeDO[] getPeDiabModelAgeDO() {
		IBaseDO[] dos = getChildren(PeDiabModelAgeDO.class);
		if(dos==null) return null;
		PeDiabModelAgeDO[] result=new PeDiabModelAgeDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeDiabModelAgeDO)dos[i];
		}
		return result;
	}
	
	public void setPeDiabModelAgeDO(PeDiabModelAgeDO[] dos) {
		setChildren(PeDiabModelAgeDO.class, dos);
	}
	public PeDiabModelSbpDO[] getPeDiabModelSbpDO() {
		IBaseDO[] dos = getChildren(PeDiabModelSbpDO.class);
		if(dos==null) return null;
		PeDiabModelSbpDO[] result=new PeDiabModelSbpDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeDiabModelSbpDO)dos[i];
		}
		return result;
	}
	
	public void setPeDiabModelSbpDO(PeDiabModelSbpDO[] dos) {
		setChildren(PeDiabModelSbpDO.class, dos);
	}
	public PeDiabModelSexDO[] getPeDiabModelSexDO() {
		IBaseDO[] dos = getChildren(PeDiabModelSexDO.class);
		if(dos==null) return null;
		PeDiabModelSexDO[] result=new PeDiabModelSexDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeDiabModelSexDO)dos[i];
		}
		return result;
	}
	
	public void setPeDiabModelSexDO(PeDiabModelSexDO[] dos) {
		setChildren(PeDiabModelSexDO.class, dos);
	}
	public PeDiabModelBmiDO[] getPeDiabModelBmiDO() {
		IBaseDO[] dos = getChildren(PeDiabModelBmiDO.class);
		if(dos==null) return null;
		PeDiabModelBmiDO[] result=new PeDiabModelBmiDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeDiabModelBmiDO)dos[i];
		}
		return result;
	}
	
	public void setPeDiabModelBmiDO(PeDiabModelBmiDO[] dos) {
		setChildren(PeDiabModelBmiDO.class, dos);
	}
	public PeDiabModelWaistDO[] getPeDiabModelWaistDO() {
		IBaseDO[] dos = getChildren(PeDiabModelWaistDO.class);
		if(dos==null) return null;
		PeDiabModelWaistDO[] result=new PeDiabModelWaistDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeDiabModelWaistDO)dos[i];
		}
		return result;
	}
	
	public void setPeDiabModelWaistDO(PeDiabModelWaistDO[] dos) {
		setChildren(PeDiabModelWaistDO.class, dos);
	}
	public PeDiabModelFamHisDO[] getPeDiabModelFamHisDO() {
		IBaseDO[] dos = getChildren(PeDiabModelFamHisDO.class);
		if(dos==null) return null;
		PeDiabModelFamHisDO[] result=new PeDiabModelFamHisDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeDiabModelFamHisDO)dos[i];
		}
		return result;
	}
	
	public void setPeDiabModelFamHisDO(PeDiabModelFamHisDO[] dos) {
		setChildren(PeDiabModelFamHisDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PediabmodelAggDODesc desc = new PediabmodelAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeDiabModelDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.pqn.pediabmodel.d.PeDiabModelAgeDO")) {
             return new PeDiabModelAgeDO();
         }
	    else if (clzName.equals("iih.pe.pqn.pediabmodel.d.PeDiabModelSbpDO")) {
             return new PeDiabModelSbpDO();
         }
	    else if (clzName.equals("iih.pe.pqn.pediabmodel.d.PeDiabModelSexDO")) {
             return new PeDiabModelSexDO();
         }
	    else if (clzName.equals("iih.pe.pqn.pediabmodel.d.PeDiabModelBmiDO")) {
             return new PeDiabModelBmiDO();
         }
	    else if (clzName.equals("iih.pe.pqn.pediabmodel.d.PeDiabModelWaistDO")) {
             return new PeDiabModelWaistDO();
         }
	    else if (clzName.equals("iih.pe.pqn.pediabmodel.d.PeDiabModelFamHisDO")) {
             return new PeDiabModelFamHisDO();
         }
         return null;
     }
}