package iih.ci.mr.nu.baby24care.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.mr.nu.baby24care.d.Baby24InfoDO;
import iih.ci.mr.nu.baby24care.d.NurRecDO;
import iih.ci.mr.nu.baby24care.d.desc.NurRecDODesc;

/**
 * 新生儿24小时护理记录单
 * @author
 *
 */
public class Baby24careAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public Baby24careAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(Baby24InfoDO.class);
        addChildren(NurRecDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NurRecDODesc.class).getFKAttrDesc());        
	  }	  
}