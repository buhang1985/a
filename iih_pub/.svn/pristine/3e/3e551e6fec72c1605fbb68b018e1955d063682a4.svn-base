package iih.nm.nhr.nmnurlabor.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nm.nhr.nmnurlabor.d.NmNurLaborDO;
import iih.nm.nhr.nmnurlabor.d.NmNurLaborAdjDO;
import iih.nm.nhr.nmnurlabor.d.desc.NmNurLaborAdjDODesc;

/**
 * 工时调整
 * @author
 *
 */
public class NmnurlaborAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public NmnurlaborAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(NmNurLaborDO.class);
        addChildren(NmNurLaborAdjDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NmNurLaborAdjDODesc.class).getFKAttrDesc());        
	  }	  
}