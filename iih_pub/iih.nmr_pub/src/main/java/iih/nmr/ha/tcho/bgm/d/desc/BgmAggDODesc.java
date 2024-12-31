package iih.nmr.ha.tcho.bgm.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nmr.ha.tcho.bgm.d.TchoBgmPatInfoDO;
import iih.nmr.ha.tcho.bgm.d.TchoBgmRecDO;
import iih.nmr.ha.tcho.bgm.d.desc.TchoBgmRecDODesc;

/**
 * 血糖监测表
 * @author
 *
 */
public class BgmAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public BgmAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(TchoBgmPatInfoDO.class);
        addChildren(TchoBgmRecDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(TchoBgmRecDODesc.class).getFKAttrDesc());        
	  }	  
}