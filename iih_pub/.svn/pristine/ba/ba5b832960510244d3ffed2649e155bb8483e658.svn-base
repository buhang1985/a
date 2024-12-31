package iih.nm.nhr.nmnhrschedrp.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nm.nhr.nmnhrschedrp.d.NhrSchedRpDO;
import iih.nm.nhr.nmnhrschedrp.d.NhrSchedRpItmDO;
import iih.nm.nhr.nmnhrschedrp.d.desc.NhrSchedRpItmDODesc;

/**
 * 替班申请
 * @author
 *
 */
public class NmnhrschedrpAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public NmnhrschedrpAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(NhrSchedRpDO.class);
        addChildren(NhrSchedRpItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NhrSchedRpItmDODesc.class).getFKAttrDesc());        
	  }	  
}