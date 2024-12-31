package iih.nm.nom.nomthgtmpl.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nm.nom.nomthgtmpl.d.desc.NomthgtmplAggDODesc;



/**
 * 病区事物记录模板
 */
public class NomthgtmplAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public NomThgTmplCaDO getParentDO() {
		return ((NomThgTmplCaDO) super.getParentDO());
	}

	public void setParentDO(NomThgTmplCaDO headDO) {
		setParent(headDO);
	}

	public NomThgTmplDO[] getNomThgTmplDO() {
		IBaseDO[] dos = getChildren(NomThgTmplDO.class);
		if(dos==null) return null;
		NomThgTmplDO[] result=new NomThgTmplDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NomThgTmplDO)dos[i];
		}
		return result;
	}
	
	public void setNomThgTmplDO(NomThgTmplDO[] dos) {
		setChildren(NomThgTmplDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		NomthgtmplAggDODesc desc = new NomthgtmplAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new NomThgTmplCaDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nm.nom.nomthgtmpl.d.NomThgTmplDO")) {
             return new NomThgTmplDO();
         }
         return null;
     }
}