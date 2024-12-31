package iih.nm.nqm.nmnqmnchkdet.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nm.nqm.nmnqmnchkdet.d.NmNqmNchkDetDO;
import iih.nm.nqm.nmnqmnchkdet.d.NmNqmNchkDetItmDO;
import iih.nm.nqm.nmnqmnchkdet.d.desc.NmNqmNchkDetItmDODesc;

/**
 * 护理管理_夜查房_检查病区22
 * @author
 *
 */
public class NmnqmnchkdetAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public NmnqmnchkdetAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(NmNqmNchkDetDO.class);
        addChildren(NmNqmNchkDetItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NmNqmNchkDetItmDODesc.class).getFKAttrDesc());        
	  }	  
}