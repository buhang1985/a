package iih.bd.srv.mrtplvst.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.srv.mrtplvst.d.desc.MrtplvstAggDODesc;



/**
 * 生命体征模版
 */
public class MrtplvstAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public BdMrtplVstDO getParentDO() {
		return ((BdMrtplVstDO) super.getParentDO());
	}

	public void setParentDO(BdMrtplVstDO headDO) {
		setParent(headDO);
	}

	public BdMrtplVstItmDO[] getBdMrtplVstItmDO() {
		IBaseDO[] dos = getChildren(BdMrtplVstItmDO.class);
		if(dos==null) return null;
		BdMrtplVstItmDO[] result=new BdMrtplVstItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(BdMrtplVstItmDO)dos[i];
		}
		return result;
	}
	
	public void setBdMrtplVstItmDO(BdMrtplVstItmDO[] dos) {
		setChildren(BdMrtplVstItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		MrtplvstAggDODesc desc = new MrtplvstAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new BdMrtplVstDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.srv.mrtplvst.d.BdMrtplVstItmDO")) {
             return new BdMrtplVstItmDO();
         }
         return null;
     }
}