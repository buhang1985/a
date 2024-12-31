package iih.mp.mpbd.kb.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.mp.mpbd.kb.d.KbDO;
import iih.mp.mpbd.kb.d.KbItemDO;
import iih.mp.mpbd.kb.d.desc.KbItemDODesc;

/**
 * 移动键盘
 * @author
 *
 */
public class KbAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public KbAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(KbDO.class);
        addChildren(KbItemDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(KbItemDODesc.class).getFKAttrDesc());        
	  }	  
}