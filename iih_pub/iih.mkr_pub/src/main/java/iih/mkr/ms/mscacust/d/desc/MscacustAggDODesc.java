package iih.mkr.ms.mscacust.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.mkr.ms.mscacust.d.MkrMscaCtmDO;
import iih.mkr.ms.mscacust.d.MkrMscaCtmMsDO;
import iih.mkr.ms.mscacust.d.desc.MkrMscaCtmMsDODesc;

/**
 * 组套自定义分类
 * @author
 *
 */
public class MscacustAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public MscacustAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(MkrMscaCtmDO.class);
        addChildren(MkrMscaCtmMsDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(MkrMscaCtmMsDODesc.class).getFKAttrDesc());        
	  }	  
}