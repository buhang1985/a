package iih.ci.mr.nu.pipeslip.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.mr.nu.pipeslip.d.PipeSlipDO;
import iih.ci.mr.nu.pipeslip.d.PipeSlipCritDO;
import iih.ci.mr.nu.pipeslip.d.desc.PipeSlipCritDODesc;

/**
 * 管道滑脱危险因素评估
 * @author
 *
 */
public class PipeslipAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PipeslipAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PipeSlipDO.class);
        addChildren(PipeSlipCritDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PipeSlipCritDODesc.class).getFKAttrDesc());        
	  }	  
}