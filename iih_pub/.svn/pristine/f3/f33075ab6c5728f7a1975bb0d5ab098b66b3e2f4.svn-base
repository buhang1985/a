package iih.bl.st.blpreauditip.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bl.st.blpreauditip.d.BlPreAuditIpDO;
import iih.bl.st.blpreauditip.d.BlPreauditLogIpDO;
import iih.bl.st.blpreauditip.d.desc.BlPreauditLogIpDODesc;

/**
 * 医保预审核_住院
 * @author
 *
 */
public class BlpreauditipAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public BlpreauditipAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(BlPreAuditIpDO.class);
        addChildren(BlPreauditLogIpDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(BlPreauditLogIpDODesc.class).getFKAttrDesc());        
	  }	  
}