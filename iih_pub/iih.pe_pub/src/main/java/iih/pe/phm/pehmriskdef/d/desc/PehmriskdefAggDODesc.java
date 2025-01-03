package iih.pe.phm.pehmriskdef.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.phm.pehmriskdef.d.PeHmRiskDefDO;
import iih.pe.phm.pehmriskdef.d.PeHmRiskRangeDO;
import iih.pe.phm.pehmriskdef.d.desc.PeHmRiskRangeDODesc;
import iih.pe.phm.pehmriskdef.d.PeHmRiskSrvItmDO;
import iih.pe.phm.pehmriskdef.d.desc.PeHmRiskSrvItmDODesc;
import iih.pe.phm.pehmriskdef.d.PeHmRiskSurveyDO;
import iih.pe.phm.pehmriskdef.d.desc.PeHmRiskSurveyDODesc;
import iih.pe.phm.pehmriskdef.d.PeHmRiskAgeTargetDO;
import iih.pe.phm.pehmriskdef.d.desc.PeHmRiskAgeTargetDODesc;

/**
 * 健康危险因素定义
 * @author
 *
 */
public class PehmriskdefAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PehmriskdefAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeHmRiskDefDO.class);
        addChildren(PeHmRiskRangeDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeHmRiskRangeDODesc.class).getFKAttrDesc());        
        addChildren(PeHmRiskSrvItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeHmRiskSrvItmDODesc.class).getFKAttrDesc());        
        addChildren(PeHmRiskSurveyDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeHmRiskSurveyDODesc.class).getFKAttrDesc());        
        addChildren(PeHmRiskAgeTargetDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeHmRiskAgeTargetDODesc.class).getFKAttrDesc());        
	  }	  
}