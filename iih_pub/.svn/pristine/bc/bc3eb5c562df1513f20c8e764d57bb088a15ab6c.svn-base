package iih.syn.common.userinit.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.syn.common.userinit.d.SynUserInitDO;
import iih.syn.common.userinit.d.SYnUserInitRespDO;
import iih.syn.common.userinit.d.desc.SYnUserInitRespDODesc;
import iih.syn.common.userinit.d.SynUserInitOrgDO;
import iih.syn.common.userinit.d.desc.SynUserInitOrgDODesc;

/**
 * 用户同步初始化
 * @author
 *
 */
public class UserinitAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public UserinitAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(SynUserInitDO.class);
        addChildren(SYnUserInitRespDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(SYnUserInitRespDODesc.class).getFKAttrDesc());        
        addChildren(SynUserInitOrgDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(SynUserInitOrgDODesc.class).getFKAttrDesc());        
	  }	  
}