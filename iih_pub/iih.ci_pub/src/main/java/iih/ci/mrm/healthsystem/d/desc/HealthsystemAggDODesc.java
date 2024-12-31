package iih.ci.mrm.healthsystem.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.mrm.healthsystem.d.ContrastClassifyDO;
import iih.ci.mrm.healthsystem.d.DocContrastDO;
import iih.ci.mrm.healthsystem.d.desc.DocContrastDODesc;

/**
 * 对照分类
 * @author
 *
 */
public class HealthsystemAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public HealthsystemAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(ContrastClassifyDO.class);
        addChildren(DocContrastDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(DocContrastDODesc.class).getFKAttrDesc());        
	  }	  
}