package iih.mp.mpbd.tcstyle.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.mp.mpbd.tcstyle.d.TcstyleDO;
import iih.mp.mpbd.tcstyle.d.TcstyDepDO;
import iih.mp.mpbd.tcstyle.d.desc.TcstyDepDODesc;

/**
 * 体温单样式
 * @author
 *
 */
public class TcstyleAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public TcstyleAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(TcstyleDO.class);
        addChildren(TcstyDepDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(TcstyDepDODesc.class).getFKAttrDesc());        
	  }	  
}