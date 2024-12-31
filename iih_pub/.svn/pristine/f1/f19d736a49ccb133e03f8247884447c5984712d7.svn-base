package iih.pe.phm.pehmfollowup.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.phm.pehmfollowup.d.PeHmFollowupDO;
import iih.pe.phm.pehmfollowup.d.PeHmFollowupRiskDO;
import iih.pe.phm.pehmfollowup.d.desc.PeHmFollowupRiskDODesc;

/**
 * 健康管理随访记录
 * @author
 *
 */
public class PehmfollowupAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PehmfollowupAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeHmFollowupDO.class);
        addChildren(PeHmFollowupRiskDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeHmFollowupRiskDODesc.class).getFKAttrDesc());        
	  }	  
}