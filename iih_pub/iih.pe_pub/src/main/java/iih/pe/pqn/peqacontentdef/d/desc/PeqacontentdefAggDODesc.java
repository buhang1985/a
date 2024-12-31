package iih.pe.pqn.peqacontentdef.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.pqn.peqacontentdef.d.PeQacontentDefDO;
import iih.pe.pqn.peqacontentdef.d.PeQakeyDefDO;
import iih.pe.pqn.peqacontentdef.d.desc.PeQakeyDefDODesc;

/**
 * 体检问卷问题库
 * @author
 *
 */
public class PeqacontentdefAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PeqacontentdefAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeQacontentDefDO.class);
        addChildren(PeQakeyDefDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeQakeyDefDODesc.class).getFKAttrDesc());        
	  }	  
}