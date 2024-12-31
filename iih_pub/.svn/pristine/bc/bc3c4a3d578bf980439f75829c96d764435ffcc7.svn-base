package iih.hp.cp.app.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.hp.cp.app.d.HpCpAppDO;
import iih.hp.cp.app.d.HpCpAppLogDO;
import iih.hp.cp.app.d.desc.HpCpAppLogDODesc;

/**
 * 诊疗计划应用
 * @author
 *
 */
public class HpcpappAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public HpcpappAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(HpCpAppDO.class);
        addChildren(HpCpAppLogDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(HpCpAppLogDODesc.class).getFKAttrDesc());        
	  }	  
}