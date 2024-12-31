package iih.cssd.dpus.dfprecy.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.cssd.dpus.dfprecy.d.DfpRecyDo;
import iih.cssd.dpus.dfprecy.d.DfpRecyItmDo;
import iih.cssd.dpus.dfprecy.d.desc.DfpRecyItmDoDesc;

/**
 * 消毒包回收
 * @author
 *
 */
public class DfprecyAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public DfprecyAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(DfpRecyDo.class);
        addChildren(DfpRecyItmDo.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(DfpRecyItmDoDesc.class).getFKAttrDesc());        
	  }	  
}