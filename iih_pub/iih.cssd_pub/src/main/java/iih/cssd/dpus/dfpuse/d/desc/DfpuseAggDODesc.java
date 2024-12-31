package iih.cssd.dpus.dfpuse.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.cssd.dpus.dfpuse.d.DfpUseDo;
import iih.cssd.dpus.dfpuse.d.DfpUseItmDo;
import iih.cssd.dpus.dfpuse.d.desc.DfpUseItmDoDesc;

/**
 * 消毒包使用
 * @author
 *
 */
public class DfpuseAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public DfpuseAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(DfpUseDo.class);
        addChildren(DfpUseItmDo.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(DfpUseItmDoDesc.class).getFKAttrDesc());        
	  }	  
}