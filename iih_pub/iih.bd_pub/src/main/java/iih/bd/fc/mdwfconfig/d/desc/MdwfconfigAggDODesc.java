package iih.bd.fc.mdwfconfig.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.fc.mdwfconfig.d.MdWfCaDO;
import iih.bd.fc.mdwfconfig.d.MdWfDO;
import iih.bd.fc.mdwfconfig.d.desc.MdWfDODesc;

/**
 * 组件
 * @author
 *
 */
public class MdwfconfigAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public MdwfconfigAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(MdWfCaDO.class);
        addChildren(MdWfDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(MdWfDODesc.class).getFKAttrDesc());        
	  }	  
}