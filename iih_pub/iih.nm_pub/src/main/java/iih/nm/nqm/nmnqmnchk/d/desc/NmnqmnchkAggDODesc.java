package iih.nm.nqm.nmnqmnchk.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nm.nqm.nmnqmnchk.d.NmNqmNchkDO;
import iih.nm.nqm.nmnqmnchk.d.NmNqmNchkItmDO;
import iih.nm.nqm.nmnqmnchk.d.desc.NmNqmNchkItmDODesc;

/**
 * 护理管理_夜查房任务1
 * @author
 *
 */
public class NmnqmnchkAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public NmnqmnchkAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(NmNqmNchkDO.class);
        addChildren(NmNqmNchkItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NmNqmNchkItmDODesc.class).getFKAttrDesc());        
	  }	  
}