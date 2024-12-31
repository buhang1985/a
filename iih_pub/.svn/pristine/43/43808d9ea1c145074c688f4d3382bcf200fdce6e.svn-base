package iih.bl.st.blauditip.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bl.st.blauditip.d.BlAuditIp;
import iih.bl.st.blauditip.d.BlAuditLogIp;
import iih.bl.st.blauditip.d.desc.BlAuditLogIpDesc;

/**
 * 住院费用审核
 * @author
 *
 */
public class BlauditipAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public BlauditipAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(BlAuditIp.class);
        addChildren(BlAuditLogIp.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(BlAuditLogIpDesc.class).getFKAttrDesc());        
	  }	  
}