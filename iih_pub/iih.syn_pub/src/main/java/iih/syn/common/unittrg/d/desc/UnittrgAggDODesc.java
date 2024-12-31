package iih.syn.common.unittrg.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.syn.common.unittrg.d.SynUnitTrgDO;
import iih.syn.common.unittrg.d.SynUnitTrgMapDO;
import iih.syn.common.unittrg.d.desc.SynUnitTrgMapDODesc;

/**
 * 数据同步目标
 * @author
 *
 */
public class UnittrgAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public UnittrgAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(SynUnitTrgDO.class);
        addChildren(SynUnitTrgMapDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(SynUnitTrgMapDODesc.class).getFKAttrDesc());        
	  }	  
}