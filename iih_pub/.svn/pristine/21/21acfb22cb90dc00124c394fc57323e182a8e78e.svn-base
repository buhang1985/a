package iih.mp.mpbd.prnca.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.mp.mpbd.prnca.d.MpOrPrncaDO;
import iih.mp.mpbd.prnca.d.MpOrPrnDO;
import iih.mp.mpbd.prnca.d.desc.MpOrPrnDODesc;

/**
 * 病区执行打印单据分类
 * @author
 *
 */
public class PrncaAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PrncaAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(MpOrPrncaDO.class);
        addChildren(MpOrPrnDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(MpOrPrnDODesc.class).getFKAttrDesc());        
	  }	  
}