package iih.nm.nca.satsrvyrecord.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nm.nca.satsrvyrecord.d.NmNcaSrvyRecordDO;
import iih.nm.nca.satsrvyrecord.d.NmNcaSrvyItemDO;
import iih.nm.nca.satsrvyrecord.d.desc.NmNcaSrvyItemDODesc;

/**
 * 满意度调查记录
 * @author
 *
 */
public class SatsrvyAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public SatsrvyAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(NmNcaSrvyRecordDO.class);
        addChildren(NmNcaSrvyItemDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NmNcaSrvyItemDODesc.class).getFKAttrDesc());        
	  }	  
}