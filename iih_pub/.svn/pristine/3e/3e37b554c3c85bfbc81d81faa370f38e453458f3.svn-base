package iih.mkr.std.deset.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.mkr.std.deset.d.DeDataSetDO;
import iih.mkr.std.deset.d.SetDgDO;
import iih.mkr.std.deset.d.desc.SetDgDODesc;

/**
 * 数据集
 * @author
 *
 */
public class DesetAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public DesetAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(DeDataSetDO.class);
        addChildren(SetDgDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(SetDgDODesc.class).getFKAttrDesc());        
	  }	  
}