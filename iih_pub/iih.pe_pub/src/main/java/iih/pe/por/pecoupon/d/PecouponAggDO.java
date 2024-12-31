package iih.pe.por.pecoupon.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.por.pecoupon.d.desc.PecouponAggDODesc;



/**
 * 体检卷
 */
public class PecouponAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeCouponDO getParentDO() {
		return ((PeCouponDO) super.getParentDO());
	}

	public void setParentDO(PeCouponDO headDO) {
		setParent(headDO);
	}

	public PeCouponCatlogDO[] getPeCouponCatlogDO() {
		IBaseDO[] dos = getChildren(PeCouponCatlogDO.class);
		if(dos==null) return null;
		PeCouponCatlogDO[] result=new PeCouponCatlogDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeCouponCatlogDO)dos[i];
		}
		return result;
	}
	
	public void setPeCouponCatlogDO(PeCouponCatlogDO[] dos) {
		setChildren(PeCouponCatlogDO.class, dos);
	}
	public PeCouponPieceDO[] getPeCouponPieceDO() {
		IBaseDO[] dos = getChildren(PeCouponPieceDO.class);
		if(dos==null) return null;
		PeCouponPieceDO[] result=new PeCouponPieceDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeCouponPieceDO)dos[i];
		}
		return result;
	}
	
	public void setPeCouponPieceDO(PeCouponPieceDO[] dos) {
		setChildren(PeCouponPieceDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PecouponAggDODesc desc = new PecouponAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeCouponDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.por.pecoupon.d.PeCouponCatlogDO")) {
             return new PeCouponCatlogDO();
         }
	    else if (clzName.equals("iih.pe.por.pecoupon.d.PeCouponPieceDO")) {
             return new PeCouponPieceDO();
         }
         return null;
     }
}