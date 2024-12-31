package iih.pe.pqn.peicdvmodel.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.pqn.peicdvmodel.d.desc.PeicdvmodelAggDODesc;



/**
 * 健康评估模型_缺血性冠心病
 */
public class PeicdvmodelAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeIcdvModelDO getParentDO() {
		return ((PeIcdvModelDO) super.getParentDO());
	}

	public void setParentDO(PeIcdvModelDO headDO) {
		setParent(headDO);
	}

	public PeIcdvModelAgeDO[] getPeIcdvModelAgeDO() {
		IBaseDO[] dos = getChildren(PeIcdvModelAgeDO.class);
		if(dos==null) return null;
		PeIcdvModelAgeDO[] result=new PeIcdvModelAgeDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeIcdvModelAgeDO)dos[i];
		}
		return result;
	}
	
	public void setPeIcdvModelAgeDO(PeIcdvModelAgeDO[] dos) {
		setChildren(PeIcdvModelAgeDO.class, dos);
	}
	public PeIcdvModelSbpDO[] getPeIcdvModelSbpDO() {
		IBaseDO[] dos = getChildren(PeIcdvModelSbpDO.class);
		if(dos==null) return null;
		PeIcdvModelSbpDO[] result=new PeIcdvModelSbpDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeIcdvModelSbpDO)dos[i];
		}
		return result;
	}
	
	public void setPeIcdvModelSbpDO(PeIcdvModelSbpDO[] dos) {
		setChildren(PeIcdvModelSbpDO.class, dos);
	}
	public PeIcdvModelBmiDO[] getPeIcdvModelBmiDO() {
		IBaseDO[] dos = getChildren(PeIcdvModelBmiDO.class);
		if(dos==null) return null;
		PeIcdvModelBmiDO[] result=new PeIcdvModelBmiDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeIcdvModelBmiDO)dos[i];
		}
		return result;
	}
	
	public void setPeIcdvModelBmiDO(PeIcdvModelBmiDO[] dos) {
		setChildren(PeIcdvModelBmiDO.class, dos);
	}
	public PeIcdvModelTcDO[] getPeIcdvModelTcDO() {
		IBaseDO[] dos = getChildren(PeIcdvModelTcDO.class);
		if(dos==null) return null;
		PeIcdvModelTcDO[] result=new PeIcdvModelTcDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeIcdvModelTcDO)dos[i];
		}
		return result;
	}
	
	public void setPeIcdvModelTcDO(PeIcdvModelTcDO[] dos) {
		setChildren(PeIcdvModelTcDO.class, dos);
	}
	public PeIcdvModelSmokeDO[] getPeIcdvModelSmokeDO() {
		IBaseDO[] dos = getChildren(PeIcdvModelSmokeDO.class);
		if(dos==null) return null;
		PeIcdvModelSmokeDO[] result=new PeIcdvModelSmokeDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeIcdvModelSmokeDO)dos[i];
		}
		return result;
	}
	
	public void setPeIcdvModelSmokeDO(PeIcdvModelSmokeDO[] dos) {
		setChildren(PeIcdvModelSmokeDO.class, dos);
	}
	public PeIcdvModelDiabetesDO[] getPeIcdvModelDiabetesDO() {
		IBaseDO[] dos = getChildren(PeIcdvModelDiabetesDO.class);
		if(dos==null) return null;
		PeIcdvModelDiabetesDO[] result=new PeIcdvModelDiabetesDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeIcdvModelDiabetesDO)dos[i];
		}
		return result;
	}
	
	public void setPeIcdvModelDiabetesDO(PeIcdvModelDiabetesDO[] dos) {
		setChildren(PeIcdvModelDiabetesDO.class, dos);
	}
	public PeIcdvModelAvgDO[] getPeIcdvModelAvgDO() {
		IBaseDO[] dos = getChildren(PeIcdvModelAvgDO.class);
		if(dos==null) return null;
		PeIcdvModelAvgDO[] result=new PeIcdvModelAvgDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeIcdvModelAvgDO)dos[i];
		}
		return result;
	}
	
	public void setPeIcdvModelAvgDO(PeIcdvModelAvgDO[] dos) {
		setChildren(PeIcdvModelAvgDO.class, dos);
	}
	public PeIcdvModelTotalDO[] getPeIcdvModelTotalDO() {
		IBaseDO[] dos = getChildren(PeIcdvModelTotalDO.class);
		if(dos==null) return null;
		PeIcdvModelTotalDO[] result=new PeIcdvModelTotalDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeIcdvModelTotalDO)dos[i];
		}
		return result;
	}
	
	public void setPeIcdvModelTotalDO(PeIcdvModelTotalDO[] dos) {
		setChildren(PeIcdvModelTotalDO.class, dos);
	}
	public PeIcdvModelFieldDO[] getPeIcdvModelFieldDO() {
		IBaseDO[] dos = getChildren(PeIcdvModelFieldDO.class);
		if(dos==null) return null;
		PeIcdvModelFieldDO[] result=new PeIcdvModelFieldDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeIcdvModelFieldDO)dos[i];
		}
		return result;
	}
	
	public void setPeIcdvModelFieldDO(PeIcdvModelFieldDO[] dos) {
		setChildren(PeIcdvModelFieldDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PeicdvmodelAggDODesc desc = new PeicdvmodelAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeIcdvModelDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.pqn.peicdvmodel.d.PeIcdvModelAgeDO")) {
             return new PeIcdvModelAgeDO();
         }
	    else if (clzName.equals("iih.pe.pqn.peicdvmodel.d.PeIcdvModelSbpDO")) {
             return new PeIcdvModelSbpDO();
         }
	    else if (clzName.equals("iih.pe.pqn.peicdvmodel.d.PeIcdvModelBmiDO")) {
             return new PeIcdvModelBmiDO();
         }
	    else if (clzName.equals("iih.pe.pqn.peicdvmodel.d.PeIcdvModelTcDO")) {
             return new PeIcdvModelTcDO();
         }
	    else if (clzName.equals("iih.pe.pqn.peicdvmodel.d.PeIcdvModelSmokeDO")) {
             return new PeIcdvModelSmokeDO();
         }
	    else if (clzName.equals("iih.pe.pqn.peicdvmodel.d.PeIcdvModelDiabetesDO")) {
             return new PeIcdvModelDiabetesDO();
         }
	    else if (clzName.equals("iih.pe.pqn.peicdvmodel.d.PeIcdvModelAvgDO")) {
             return new PeIcdvModelAvgDO();
         }
	    else if (clzName.equals("iih.pe.pqn.peicdvmodel.d.PeIcdvModelTotalDO")) {
             return new PeIcdvModelTotalDO();
         }
	    else if (clzName.equals("iih.pe.pqn.peicdvmodel.d.PeIcdvModelFieldDO")) {
             return new PeIcdvModelFieldDO();
         }
         return null;
     }
}