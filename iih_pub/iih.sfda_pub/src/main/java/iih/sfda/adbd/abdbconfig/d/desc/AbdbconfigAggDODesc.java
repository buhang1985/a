package iih.sfda.adbd.abdbconfig.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.sfda.adbd.abdbconfig.d.AdbdConfigDO;
import iih.sfda.adbd.abdbconfig.d.AdbdConfigItmDO;
import iih.sfda.adbd.abdbconfig.d.desc.AdbdConfigItmDODesc;

/**
 * 事件处理流程配置
 * @author
 *
 */
public class AbdbconfigAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public AbdbconfigAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(AdbdConfigDO.class);
        addChildren(AdbdConfigItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(AdbdConfigItmDODesc.class).getFKAttrDesc());        
	  }	  
}