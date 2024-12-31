package iih.pe.pitm.pesrvbcatlog.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.pitm.pesrvbcatlog.d.desc.PesrvbcatlogAggDODesc;



/**
 * 体检项目基本目录
 */
public class PesrvbcatlogAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeSrvbCatlogDO getParentDO() {
		return ((PeSrvbCatlogDO) super.getParentDO());
	}

	public void setParentDO(PeSrvbCatlogDO headDO) {
		setParent(headDO);
	}

	public PeSrvbCatlogItmDO[] getPeSrvbCatlogItmDO() {
		IBaseDO[] dos = getChildren(PeSrvbCatlogItmDO.class);
		if(dos==null) return null;
		PeSrvbCatlogItmDO[] result=new PeSrvbCatlogItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeSrvbCatlogItmDO)dos[i];
		}
		return result;
	}
	
	public void setPeSrvbCatlogItmDO(PeSrvbCatlogItmDO[] dos) {
		setChildren(PeSrvbCatlogItmDO.class, dos);
	}
	public PeSrvCastChargeDO[] getPeSrvCastChargeDO() {
		IBaseDO[] dos = getChildren(PeSrvCastChargeDO.class);
		if(dos==null) return null;
		PeSrvCastChargeDO[] result=new PeSrvCastChargeDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeSrvCastChargeDO)dos[i];
		}
		return result;
	}
	
	public void setPeSrvCastChargeDO(PeSrvCastChargeDO[] dos) {
		setChildren(PeSrvCastChargeDO.class, dos);
	}
	public PeSrvCastApplyDO[] getPeSrvCastApplyDO() {
		IBaseDO[] dos = getChildren(PeSrvCastApplyDO.class);
		if(dos==null) return null;
		PeSrvCastApplyDO[] result=new PeSrvCastApplyDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeSrvCastApplyDO)dos[i];
		}
		return result;
	}
	
	public void setPeSrvCastApplyDO(PeSrvCastApplyDO[] dos) {
		setChildren(PeSrvCastApplyDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PesrvbcatlogAggDODesc desc = new PesrvbcatlogAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeSrvbCatlogDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.pitm.pesrvbcatlog.d.PeSrvbCatlogItmDO")) {
             return new PeSrvbCatlogItmDO();
         }
	    else if (clzName.equals("iih.pe.pitm.pesrvbcatlog.d.PeSrvCastChargeDO")) {
             return new PeSrvCastChargeDO();
         }
	    else if (clzName.equals("iih.pe.pitm.pesrvbcatlog.d.PeSrvCastApplyDO")) {
             return new PeSrvCastApplyDO();
         }
         return null;
     }
}