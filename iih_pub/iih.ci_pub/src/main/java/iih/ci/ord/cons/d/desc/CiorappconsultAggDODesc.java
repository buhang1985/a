package iih.ci.ord.cons.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.ord.cons.d.OrdApConsDO;
import iih.ci.ord.cons.d.CiConsInviteDO;
import iih.ci.ord.cons.d.desc.CiConsInviteDODesc;
import iih.ci.ord.cons.d.CiConsActInviteDO;
import iih.ci.ord.cons.d.desc.CiConsActInviteDODesc;
import iih.ci.ord.cons.d.CiConsApproveInviteDO;
import iih.ci.ord.cons.d.desc.CiConsApproveInviteDODesc;

/**
 * 会诊申请单
 * @author
 *
 */
public class CiorappconsultAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public CiorappconsultAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(OrdApConsDO.class);
        addChildren(CiConsInviteDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(CiConsInviteDODesc.class).getFKAttrDesc());        
        addChildren(CiConsActInviteDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(CiConsActInviteDODesc.class).getFKAttrDesc());        
        addChildren(CiConsApproveInviteDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(CiConsApproveInviteDODesc.class).getFKAttrDesc());        
	  }	  
}