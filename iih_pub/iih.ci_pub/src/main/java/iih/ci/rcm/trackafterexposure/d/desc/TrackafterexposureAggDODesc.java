package iih.ci.rcm.trackafterexposure.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.rcm.trackafterexposure.d.TrackAfterExposureDO;
import iih.ci.rcm.trackafterexposure.d.TrackCheckResAfExpDO;
import iih.ci.rcm.trackafterexposure.d.desc.TrackCheckResAfExpDODesc;
import iih.ci.rcm.trackafterexposure.d.TreatPeMeaAfExpDO;
import iih.ci.rcm.trackafterexposure.d.desc.TreatPeMeaAfExpDODesc;
import iih.ci.rcm.trackafterexposure.d.LabFollowupResultDO;
import iih.ci.rcm.trackafterexposure.d.desc.LabFollowupResultDODesc;
import iih.ci.rcm.trackafterexposure.d.BasicLabResultDO;
import iih.ci.rcm.trackafterexposure.d.desc.BasicLabResultDODesc;

/**
 * 暴露后追踪记录登记表
 * @author
 *
 */
public class TrackafterexposureAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public TrackafterexposureAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(TrackAfterExposureDO.class);
        addChildren(TrackCheckResAfExpDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(TrackCheckResAfExpDODesc.class).getFKAttrDesc());        
        addChildren(TreatPeMeaAfExpDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(TreatPeMeaAfExpDODesc.class).getFKAttrDesc());        
        addChildren(LabFollowupResultDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(LabFollowupResultDODesc.class).getFKAttrDesc());        
        addChildren(BasicLabResultDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(BasicLabResultDODesc.class).getFKAttrDesc());        
	  }	  
}