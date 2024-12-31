package iih.ci.mrm.healthsystem.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.mrm.healthsystem.d.ExtractDataDO;
import iih.ci.mrm.healthsystem.d.DocContrastDO;
import iih.ci.mrm.healthsystem.d.desc.DocContrastDODesc;

/**
 * 数据抽取任务
 * @author
 *
 */
public class HealthsystemextractdataAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public HealthsystemextractdataAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(ExtractDataDO.class);
        addChildren(DocContrastDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(DocContrastDODesc.class).getFKAttrDesc());        
	  }	  
}