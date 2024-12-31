package iih.mp.mb.mbbc.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.mp.mb.mbbc.d.MbBcDO;
import iih.mp.mb.mbbc.d.MbBcRuleDO;
import iih.mp.mb.mbbc.d.desc.MbBcRuleDODesc;

/**
 * 条码对照
 * @author
 *
 */
public class MbbcAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public MbbcAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(MbBcDO.class);
        addChildren(MbBcRuleDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(MbBcRuleDODesc.class).getFKAttrDesc());        
	  }	  
}