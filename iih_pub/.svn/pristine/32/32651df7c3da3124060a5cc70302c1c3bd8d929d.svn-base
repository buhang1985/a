package iih.mp.mpbd.prnca.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.mp.mpbd.prnca.d.desc.PrncaAggDODesc;



/**
 * 病区执行打印单据分类
 */
public class PrncaAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public MpOrPrncaDO getParentDO() {
		return ((MpOrPrncaDO) super.getParentDO());
	}

	public void setParentDO(MpOrPrncaDO headDO) {
		setParent(headDO);
	}

	public MpOrPrnDO[] getMpOrPrnDO() {
		IBaseDO[] dos = getChildren(MpOrPrnDO.class);
		if(dos==null) return null;
		MpOrPrnDO[] result=new MpOrPrnDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(MpOrPrnDO)dos[i];
		}
		return result;
	}
	
	public void setMpOrPrnDO(MpOrPrnDO[] dos) {
		setChildren(MpOrPrnDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PrncaAggDODesc desc = new PrncaAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new MpOrPrncaDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.mp.mpbd.prnca.d.MpOrPrnDO")) {
             return new MpOrPrnDO();
         }
         return null;
     }
}