package iih.ci.mrm.healthsystem.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.mrm.healthsystem.d.ValueContrastDO;
import iih.ci.mrm.healthsystem.d.ValueContrastDetailDO;
import iih.ci.mrm.healthsystem.d.desc.ValueContrastDetailDODesc;

/**
 * 对照
 * @author
 *
 */
public class ValuecontrastAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public ValuecontrastAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(ValueContrastDO.class);
        addChildren(ValueContrastDetailDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(ValueContrastDetailDODesc.class).getFKAttrDesc());        
	  }	  
}