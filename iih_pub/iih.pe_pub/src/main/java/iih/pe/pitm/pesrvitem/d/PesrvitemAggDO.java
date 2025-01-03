package iih.pe.pitm.pesrvitem.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.pitm.pesrvitem.d.desc.PesrvitemAggDODesc;



/**
 * 体检检查项目结果
 */
public class PesrvitemAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeSrvItemDO getParentDO() {
		return ((PeSrvItemDO) super.getParentDO());
	}

	public void setParentDO(PeSrvItemDO headDO) {
		setParent(headDO);
	}

	public PeSrvitmDiagDO[] getPeSrvitmDiagDO() {
		IBaseDO[] dos = getChildren(PeSrvitmDiagDO.class);
		if(dos==null) return null;
		PeSrvitmDiagDO[] result=new PeSrvitmDiagDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeSrvitmDiagDO)dos[i];
		}
		return result;
	}
	
	public void setPeSrvitmDiagDO(PeSrvitmDiagDO[] dos) {
		setChildren(PeSrvitmDiagDO.class, dos);
	}
	public PeSrvitmSuggDO[] getPeSrvitmSuggDO() {
		IBaseDO[] dos = getChildren(PeSrvitmSuggDO.class);
		if(dos==null) return null;
		PeSrvitmSuggDO[] result=new PeSrvitmSuggDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeSrvitmSuggDO)dos[i];
		}
		return result;
	}
	
	public void setPeSrvitmSuggDO(PeSrvitmSuggDO[] dos) {
		setChildren(PeSrvitmSuggDO.class, dos);
	}
	public PeSrvitmOptsDO[] getPeSrvitmOptsDO() {
		IBaseDO[] dos = getChildren(PeSrvitmOptsDO.class);
		if(dos==null) return null;
		PeSrvitmOptsDO[] result=new PeSrvitmOptsDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeSrvitmOptsDO)dos[i];
		}
		return result;
	}
	
	public void setPeSrvitmOptsDO(PeSrvitmOptsDO[] dos) {
		setChildren(PeSrvitmOptsDO.class, dos);
	}
	public PeSrvitmSignDO[] getPeSrvitmSignDO() {
		IBaseDO[] dos = getChildren(PeSrvitmSignDO.class);
		if(dos==null) return null;
		PeSrvitmSignDO[] result=new PeSrvitmSignDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeSrvitmSignDO)dos[i];
		}
		return result;
	}
	
	public void setPeSrvitmSignDO(PeSrvitmSignDO[] dos) {
		setChildren(PeSrvitmSignDO.class, dos);
	}
	public PeSrvitmLisDO[] getPeSrvitmLisDO() {
		IBaseDO[] dos = getChildren(PeSrvitmLisDO.class);
		if(dos==null) return null;
		PeSrvitmLisDO[] result=new PeSrvitmLisDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeSrvitmLisDO)dos[i];
		}
		return result;
	}
	
	public void setPeSrvitmLisDO(PeSrvitmLisDO[] dos) {
		setChildren(PeSrvitmLisDO.class, dos);
	}
	public PeSrvitmRisDO[] getPeSrvitmRisDO() {
		IBaseDO[] dos = getChildren(PeSrvitmRisDO.class);
		if(dos==null) return null;
		PeSrvitmRisDO[] result=new PeSrvitmRisDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeSrvitmRisDO)dos[i];
		}
		return result;
	}
	
	public void setPeSrvitmRisDO(PeSrvitmRisDO[] dos) {
		setChildren(PeSrvitmRisDO.class, dos);
	}
	public PeSrvitmWarnValDO[] getPeSrvitmWarnValDO() {
		IBaseDO[] dos = getChildren(PeSrvitmWarnValDO.class);
		if(dos==null) return null;
		PeSrvitmWarnValDO[] result=new PeSrvitmWarnValDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeSrvitmWarnValDO)dos[i];
		}
		return result;
	}
	
	public void setPeSrvitmWarnValDO(PeSrvitmWarnValDO[] dos) {
		setChildren(PeSrvitmWarnValDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PesrvitemAggDODesc desc = new PesrvitemAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeSrvItemDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.pitm.pesrvitem.d.PeSrvitmDiagDO")) {
             return new PeSrvitmDiagDO();
         }
	    else if (clzName.equals("iih.pe.pitm.pesrvitem.d.PeSrvitmSuggDO")) {
             return new PeSrvitmSuggDO();
         }
	    else if (clzName.equals("iih.pe.pitm.pesrvitem.d.PeSrvitmOptsDO")) {
             return new PeSrvitmOptsDO();
         }
	    else if (clzName.equals("iih.pe.pitm.pesrvitem.d.PeSrvitmSignDO")) {
             return new PeSrvitmSignDO();
         }
	    else if (clzName.equals("iih.pe.pitm.pesrvitem.d.PeSrvitmLisDO")) {
             return new PeSrvitmLisDO();
         }
	    else if (clzName.equals("iih.pe.pitm.pesrvitem.d.PeSrvitmRisDO")) {
             return new PeSrvitmRisDO();
         }
	    else if (clzName.equals("iih.pe.pitm.pesrvitem.d.PeSrvitmWarnValDO")) {
             return new PeSrvitmWarnValDO();
         }
         return null;
     }
}