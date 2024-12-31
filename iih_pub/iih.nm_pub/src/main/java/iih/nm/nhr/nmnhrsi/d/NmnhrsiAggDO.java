package iih.nm.nhr.nmnhrsi.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nm.nhr.nmnhrsi.d.desc.NmnhrsiAggDODesc;



/**
 * 班次信息
 */
public class NmnhrsiAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public NmNhrSiDO getParentDO() {
		return ((NmNhrSiDO) super.getParentDO());
	}

	public void setParentDO(NmNhrSiDO headDO) {
		setParent(headDO);
	}

	public NmNhrSiBedDO[] getNmNhrSiBedDO() {
		IBaseDO[] dos = getChildren(NmNhrSiBedDO.class);
		if(dos==null) return null;
		NmNhrSiBedDO[] result=new NmNhrSiBedDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NmNhrSiBedDO)dos[i];
		}
		return result;
	}
	
	public void setNmNhrSiBedDO(NmNhrSiBedDO[] dos) {
		setChildren(NmNhrSiBedDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		NmnhrsiAggDODesc desc = new NmnhrsiAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new NmNhrSiDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nm.nhr.nmnhrsi.d.NmNhrSiBedDO")) {
             return new NmNhrSiBedDO();
         }
         return null;
     }
}