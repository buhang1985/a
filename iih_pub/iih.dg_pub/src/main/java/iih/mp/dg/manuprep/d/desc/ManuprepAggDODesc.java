package iih.mp.dg.manuprep.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.mp.dg.manuprep.d.MpDgPrepDO;
import iih.mp.dg.manuprep.d.MpDgPrepItemDO;
import iih.mp.dg.manuprep.d.desc.MpDgPrepItemDODesc;

/**
 * 门诊后台摆药
 * @author
 *
 */
public class ManuprepAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public ManuprepAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(MpDgPrepDO.class);
        addChildren(MpDgPrepItemDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(MpDgPrepItemDODesc.class).getFKAttrDesc());        
	  }	  
}