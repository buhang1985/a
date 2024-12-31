package iih.ci.mr.nu.babyhandover.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.mr.nu.babyhandover.d.BabyhandoverinfoDO;
import iih.ci.mr.nu.babyhandover.d.BabyhandoverrecordDO;
import iih.ci.mr.nu.babyhandover.d.desc.BabyhandoverrecordDODesc;

/**
 * 新生儿交接与记录单
 * @author
 *
 */
public class BabyhandoverAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public BabyhandoverAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(BabyhandoverinfoDO.class);
        addChildren(BabyhandoverrecordDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(BabyhandoverrecordDODesc.class).getFKAttrDesc());        
	  }	  
}