package iih.pe.pitm.pesrvrstnormtxt.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.pitm.pesrvrstnormtxt.d.desc.PesrvrstnormtxtAggDODesc;



/**
 * 体检结果正常时报告内容
 */
public class PesrvrstnormtxtAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeSrvRstNormTxtDO getParentDO() {
		return ((PeSrvRstNormTxtDO) super.getParentDO());
	}

	public void setParentDO(PeSrvRstNormTxtDO headDO) {
		setParent(headDO);
	}

	public PeSrvRstNormTxtDtlDO[] getPeSrvRstNormTxtDtlDO() {
		IBaseDO[] dos = getChildren(PeSrvRstNormTxtDtlDO.class);
		if(dos==null) return null;
		PeSrvRstNormTxtDtlDO[] result=new PeSrvRstNormTxtDtlDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeSrvRstNormTxtDtlDO)dos[i];
		}
		return result;
	}
	
	public void setPeSrvRstNormTxtDtlDO(PeSrvRstNormTxtDtlDO[] dos) {
		setChildren(PeSrvRstNormTxtDtlDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PesrvrstnormtxtAggDODesc desc = new PesrvrstnormtxtAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeSrvRstNormTxtDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.pitm.pesrvrstnormtxt.d.PeSrvRstNormTxtDtlDO")) {
             return new PeSrvRstNormTxtDtlDO();
         }
         return null;
     }
}