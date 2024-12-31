package iih.mkr.std.dedg.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.mkr.std.dedg.d.DeDataGrpDO;
import iih.mkr.std.dedg.d.DgDeDO;
import iih.mkr.std.dedg.d.desc.DgDeDODesc;

/**
 * 数据组
 * @author
 *
 */
public class DedgAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public DedgAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(DeDataGrpDO.class);
        addChildren(DgDeDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(DgDeDODesc.class).getFKAttrDesc());        
	  }	  
}