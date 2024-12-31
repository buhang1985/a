package iih.ci.mrm.healthsystem.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.mrm.healthsystem.d.FieldContrastDO;
import iih.ci.mrm.healthsystem.d.FieldTransScriptDO;
import iih.ci.mrm.healthsystem.d.desc.FieldTransScriptDODesc;
import iih.ci.mrm.healthsystem.d.FieldCheckRuleDO;
import iih.ci.mrm.healthsystem.d.desc.FieldCheckRuleDODesc;

/**
 * 字段转换
 * @author
 *
 */
public class HealthsystemfieldAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public HealthsystemfieldAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(FieldContrastDO.class);
        addChildren(FieldTransScriptDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(FieldTransScriptDODesc.class).getFKAttrDesc());        
        addChildren(FieldCheckRuleDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(FieldCheckRuleDODesc.class).getFKAttrDesc());        
	  }	  
}