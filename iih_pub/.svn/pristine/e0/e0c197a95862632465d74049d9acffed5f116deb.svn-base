package iih.pe.por.pecoupon.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.por.pecoupon.d.PeCouponDO;
import iih.pe.por.pecoupon.d.PeCouponCatlogDO;
import iih.pe.por.pecoupon.d.desc.PeCouponCatlogDODesc;
import iih.pe.por.pecoupon.d.PeCouponPieceDO;
import iih.pe.por.pecoupon.d.desc.PeCouponPieceDODesc;

/**
 * 体检卷
 * @author
 *
 */
public class PecouponAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PecouponAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeCouponDO.class);
        addChildren(PeCouponCatlogDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeCouponCatlogDODesc.class).getFKAttrDesc());        
        addChildren(PeCouponPieceDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeCouponPieceDODesc.class).getFKAttrDesc());        
	  }	  
}