package iih.bd.fc.wf.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.fc.wf.d.WfDO;
import iih.bd.fc.wf.d.WfSrvtpDO;
import iih.bd.fc.wf.d.desc.WfSrvtpDODesc;
import iih.bd.fc.wf.d.WfDepDO;
import iih.bd.fc.wf.d.desc.WfDepDODesc;

/**
 * 流程配置_医嘱流向
 * @author
 *
 */
public class WfAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public WfAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(WfDO.class);
        addChildren(WfSrvtpDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(WfSrvtpDODesc.class).getFKAttrDesc());        
        addChildren(WfDepDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(WfDepDODesc.class).getFKAttrDesc());        
	  }	  
}