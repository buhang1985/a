package iih.sfda.adbd.adbditmdoc.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.sfda.adbd.adbditmdoc.d.AdbdItmdoclistDO;
import iih.sfda.adbd.adbditmdoc.d.AdbdItmdocDO;
import iih.sfda.adbd.adbditmdoc.d.desc.AdbdItmdocDODesc;

/**
 * 属性项目档案
 * @author
 *
 */
public class AdbditmdocAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public AdbditmdocAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(AdbdItmdoclistDO.class);
        addChildren(AdbdItmdocDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(AdbdItmdocDODesc.class).getFKAttrDesc());        
	  }	  
}