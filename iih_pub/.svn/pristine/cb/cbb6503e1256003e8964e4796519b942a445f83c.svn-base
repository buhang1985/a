package iih.syn.common.init.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.syn.common.init.d.SynInitDO;
import iih.syn.common.init.d.SynInitTableDO;
import iih.syn.common.init.d.desc.SynInitTableDODesc;
import iih.syn.common.init.d.SynInitRcdDO;
import iih.syn.common.init.d.desc.SynInitRcdDODesc;

/**
 * 基础数据初始化
 * @author
 *
 */
public class InitAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public InitAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(SynInitDO.class);
        addChildren(SynInitTableDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(SynInitTableDODesc.class).getFKAttrDesc());        
        addChildren(SynInitRcdDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(SynInitRcdDODesc.class).getFKAttrDesc());        
	  }	  
}