package iih.mp.nr.hdvview.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.mp.nr.hdvview.d.desc.HdvviewAggDODesc;



/**
 * 交班汇总
 */
public class HdvviewAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public HdvDO getParentDO() {
		return ((HdvDO) super.getParentDO());
	}

	public void setParentDO(HdvDO headDO) {
		setParent(headDO);
	}

	public MpHdvSumDO[] getMpHdvSumDO() {
		IBaseDO[] dos = getChildren(MpHdvSumDO.class);
		if(dos==null) return null;
		MpHdvSumDO[] result=new MpHdvSumDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(MpHdvSumDO)dos[i];
		}
		return result;
	}
	
	public void setMpHdvSumDO(MpHdvSumDO[] dos) {
		setChildren(MpHdvSumDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		HdvviewAggDODesc desc = new HdvviewAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new HdvDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.mp.nr.hdvview.d.MpHdvSumDO")) {
             return new MpHdvSumDO();
         }
         return null;
     }
}