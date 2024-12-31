package iih.bd.srv.freqdef.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.srv.freqdef.d.FreqDefDO;
import iih.bd.srv.freqdef.d.FreqTimeDO;
import iih.bd.srv.freqdef.d.desc.FreqTimeDODesc;

/**
 * 医嘱频次定义
 * @author
 *
 */
public class FreqdefAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public FreqdefAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(FreqDefDO.class);
        addChildren(FreqTimeDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(FreqTimeDODesc.class).getFKAttrDesc());        
	  }	  
}