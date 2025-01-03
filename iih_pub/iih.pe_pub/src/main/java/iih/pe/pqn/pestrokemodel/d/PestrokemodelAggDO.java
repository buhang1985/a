package iih.pe.pqn.pestrokemodel.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.pqn.pestrokemodel.d.desc.PestrokemodelAggDODesc;



/**
 * 健康评估模型_脑卒中
 */
public class PestrokemodelAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeStrokeModelDO getParentDO() {
		return ((PeStrokeModelDO) super.getParentDO());
	}

	public void setParentDO(PeStrokeModelDO headDO) {
		setParent(headDO);
	}

	public PeStrokeModelAgeDO[] getPeStrokeModelAgeDO() {
		IBaseDO[] dos = getChildren(PeStrokeModelAgeDO.class);
		if(dos==null) return null;
		PeStrokeModelAgeDO[] result=new PeStrokeModelAgeDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeStrokeModelAgeDO)dos[i];
		}
		return result;
	}
	
	public void setPeStrokeModelAgeDO(PeStrokeModelAgeDO[] dos) {
		setChildren(PeStrokeModelAgeDO.class, dos);
	}
	public PeStrokeModelSbpDO[] getPeStrokeModelSbpDO() {
		IBaseDO[] dos = getChildren(PeStrokeModelSbpDO.class);
		if(dos==null) return null;
		PeStrokeModelSbpDO[] result=new PeStrokeModelSbpDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeStrokeModelSbpDO)dos[i];
		}
		return result;
	}
	
	public void setPeStrokeModelSbpDO(PeStrokeModelSbpDO[] dos) {
		setChildren(PeStrokeModelSbpDO.class, dos);
	}
	public PeStrokeModelTotalDO[] getPeStrokeModelTotalDO() {
		IBaseDO[] dos = getChildren(PeStrokeModelTotalDO.class);
		if(dos==null) return null;
		PeStrokeModelTotalDO[] result=new PeStrokeModelTotalDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeStrokeModelTotalDO)dos[i];
		}
		return result;
	}
	
	public void setPeStrokeModelTotalDO(PeStrokeModelTotalDO[] dos) {
		setChildren(PeStrokeModelTotalDO.class, dos);
	}
	public PeStrokeModelOthRiksDO[] getPeStrokeModelOthRiksDO() {
		IBaseDO[] dos = getChildren(PeStrokeModelOthRiksDO.class);
		if(dos==null) return null;
		PeStrokeModelOthRiksDO[] result=new PeStrokeModelOthRiksDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeStrokeModelOthRiksDO)dos[i];
		}
		return result;
	}
	
	public void setPeStrokeModelOthRiksDO(PeStrokeModelOthRiksDO[] dos) {
		setChildren(PeStrokeModelOthRiksDO.class, dos);
	}
	public PeStrokeModelFieldDO[] getPeStrokeModelFieldDO() {
		IBaseDO[] dos = getChildren(PeStrokeModelFieldDO.class);
		if(dos==null) return null;
		PeStrokeModelFieldDO[] result=new PeStrokeModelFieldDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeStrokeModelFieldDO)dos[i];
		}
		return result;
	}
	
	public void setPeStrokeModelFieldDO(PeStrokeModelFieldDO[] dos) {
		setChildren(PeStrokeModelFieldDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PestrokemodelAggDODesc desc = new PestrokemodelAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeStrokeModelDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.pqn.pestrokemodel.d.PeStrokeModelAgeDO")) {
             return new PeStrokeModelAgeDO();
         }
	    else if (clzName.equals("iih.pe.pqn.pestrokemodel.d.PeStrokeModelSbpDO")) {
             return new PeStrokeModelSbpDO();
         }
	    else if (clzName.equals("iih.pe.pqn.pestrokemodel.d.PeStrokeModelTotalDO")) {
             return new PeStrokeModelTotalDO();
         }
	    else if (clzName.equals("iih.pe.pqn.pestrokemodel.d.PeStrokeModelOthRiksDO")) {
             return new PeStrokeModelOthRiksDO();
         }
	    else if (clzName.equals("iih.pe.pqn.pestrokemodel.d.PeStrokeModelFieldDO")) {
             return new PeStrokeModelFieldDO();
         }
         return null;
     }
}