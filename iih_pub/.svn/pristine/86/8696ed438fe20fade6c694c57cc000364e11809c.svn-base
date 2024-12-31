package iih.pe.phm.pehmlifestyle.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.phm.pehmlifestyle.d.desc.PehmlifestyleAggDODesc;



/**
 * 健康生活方式评估
 */
public class PehmlifestyleAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeHmLifestyleDO getParentDO() {
		return ((PeHmLifestyleDO) super.getParentDO());
	}

	public void setParentDO(PeHmLifestyleDO headDO) {
		setParent(headDO);
	}

	public PeHmLifestyleDtlDO[] getPeHmLifestyleDtlDO() {
		IBaseDO[] dos = getChildren(PeHmLifestyleDtlDO.class);
		if(dos==null) return null;
		PeHmLifestyleDtlDO[] result=new PeHmLifestyleDtlDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeHmLifestyleDtlDO)dos[i];
		}
		return result;
	}
	
	public void setPeHmLifestyleDtlDO(PeHmLifestyleDtlDO[] dos) {
		setChildren(PeHmLifestyleDtlDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PehmlifestyleAggDODesc desc = new PehmlifestyleAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeHmLifestyleDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.phm.pehmlifestyle.d.PeHmLifestyleDtlDO")) {
             return new PeHmLifestyleDtlDO();
         }
         return null;
     }
}