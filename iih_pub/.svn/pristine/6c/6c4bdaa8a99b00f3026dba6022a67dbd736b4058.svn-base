package iih.bl.cc.blcc.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bl.cc.blcc.d.BlCcDO;
import iih.bl.cc.blcc.d.BlCcPmDO;
import iih.bl.cc.blcc.d.desc.BlCcPmDODesc;
import iih.bl.cc.blcc.d.BlCcIncDO;
import iih.bl.cc.blcc.d.desc.BlCcIncDODesc;
import iih.bl.cc.blcc.d.BlCcIncCancDO;
import iih.bl.cc.blcc.d.desc.BlCcIncCancDODesc;
import iih.bl.cc.blcc.d.BlCcIncReDO;
import iih.bl.cc.blcc.d.desc.BlCcIncReDODesc;

/**
 * 组件
 * @author
 *
 */
public class BlccAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public BlccAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(BlCcDO.class);
        addChildren(BlCcPmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(BlCcPmDODesc.class).getFKAttrDesc());        
        addChildren(BlCcIncDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(BlCcIncDODesc.class).getFKAttrDesc());        
        addChildren(BlCcIncCancDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(BlCcIncCancDODesc.class).getFKAttrDesc());        
        addChildren(BlCcIncReDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(BlCcIncReDODesc.class).getFKAttrDesc());        
	  }	  
}