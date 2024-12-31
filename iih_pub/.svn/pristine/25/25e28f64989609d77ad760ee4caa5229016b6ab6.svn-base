package iih.pe.pitm.pesrvsetdef.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.pitm.pesrvsetdef.d.desc.PesrvsetdefAggDODesc;



/**
 * 体检套餐定义（项目组合）
 */
public class PesrvsetdefAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeSrvSetDefDO getParentDO() {
		return ((PeSrvSetDefDO) super.getParentDO());
	}

	public void setParentDO(PeSrvSetDefDO headDO) {
		setParent(headDO);
	}

	public PeSrvSetItmDefDO[] getPeSrvSetItmDefDO() {
		IBaseDO[] dos = getChildren(PeSrvSetItmDefDO.class);
		if(dos==null) return null;
		PeSrvSetItmDefDO[] result=new PeSrvSetItmDefDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeSrvSetItmDefDO)dos[i];
		}
		return result;
	}
	
	public void setPeSrvSetItmDefDO(PeSrvSetItmDefDO[] dos) {
		setChildren(PeSrvSetItmDefDO.class, dos);
	}
	public PeSrvSetIllDefDO[] getPeSrvSetIllDefDO() {
		IBaseDO[] dos = getChildren(PeSrvSetIllDefDO.class);
		if(dos==null) return null;
		PeSrvSetIllDefDO[] result=new PeSrvSetIllDefDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeSrvSetIllDefDO)dos[i];
		}
		return result;
	}
	
	public void setPeSrvSetIllDefDO(PeSrvSetIllDefDO[] dos) {
		setChildren(PeSrvSetIllDefDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PesrvsetdefAggDODesc desc = new PesrvsetdefAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeSrvSetDefDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.pitm.pesrvsetdef.d.PeSrvSetItmDefDO")) {
             return new PeSrvSetItmDefDO();
         }
	    else if (clzName.equals("iih.pe.pitm.pesrvsetdef.d.PeSrvSetIllDefDO")) {
             return new PeSrvSetIllDefDO();
         }
         return null;
     }
}