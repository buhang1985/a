package iih.pe.pwf.perstlis.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.pwf.perstlis.d.PeRstLisDO;
import iih.pe.pwf.perstlis.d.PeRstLisItmDO;
import iih.pe.pwf.perstlis.d.desc.PeRstLisItmDODesc;

/**
 * 体检检验报告
 * @author
 *
 */
public class PerstlisAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PerstlisAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeRstLisDO.class);
        addChildren(PeRstLisItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeRstLisItmDODesc.class).getFKAttrDesc());        
	  }	  
}