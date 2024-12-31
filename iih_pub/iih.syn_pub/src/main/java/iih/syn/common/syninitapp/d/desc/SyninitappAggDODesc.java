package iih.syn.common.syninitapp.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.syn.common.syninitapp.d.SynInitAppDO;
import iih.syn.common.syninitapp.d.SynInitAppItemDO;
import iih.syn.common.syninitapp.d.desc.SynInitAppItemDODesc;

/**
 * 数据初始化申请
 * @author
 *
 */
public class SyninitappAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public SyninitappAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(SynInitAppDO.class);
        addChildren(SynInitAppItemDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(SynInitAppItemDODesc.class).getFKAttrDesc());        
	  }	  
}