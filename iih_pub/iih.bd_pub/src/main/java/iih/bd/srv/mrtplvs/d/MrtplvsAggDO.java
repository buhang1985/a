package iih.bd.srv.mrtplvs.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.srv.mrtplvs.d.desc.MrtplvsAggDODesc;



/**
 * 生命体征项
 */
public class MrtplvsAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public BdMrtplVsDO getParentDO() {
		return ((BdMrtplVsDO) super.getParentDO());
	}

	public void setParentDO(BdMrtplVsDO headDO) {
		setParent(headDO);
	}

	public BdMrtplVsItmDO[] getBdMrtplVsItmDO() {
		IBaseDO[] dos = getChildren(BdMrtplVsItmDO.class);
		if(dos==null) return null;
		BdMrtplVsItmDO[] result=new BdMrtplVsItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(BdMrtplVsItmDO)dos[i];
		}
		return result;
	}
	
	public void setBdMrtplVsItmDO(BdMrtplVsItmDO[] dos) {
		setChildren(BdMrtplVsItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		MrtplvsAggDODesc desc = new MrtplvsAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new BdMrtplVsDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.srv.mrtplvs.d.BdMrtplVsItmDO")) {
             return new BdMrtplVsItmDO();
         }
         return null;
     }
}