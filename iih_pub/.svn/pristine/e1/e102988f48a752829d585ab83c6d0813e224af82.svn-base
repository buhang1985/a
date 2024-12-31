package iih.mp.nr.hdvview.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.mp.nr.hdvview.d.HdvDO;
import iih.mp.nr.hdvview.d.MpHdvSumDO;
import iih.mp.nr.hdvview.d.desc.MpHdvSumDODesc;

/**
 * 交班汇总
 * @author
 *
 */
public class HdvviewAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public HdvviewAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(HdvDO.class);
        addChildren(MpHdvSumDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(MpHdvSumDODesc.class).getFKAttrDesc());        
	  }	  
}