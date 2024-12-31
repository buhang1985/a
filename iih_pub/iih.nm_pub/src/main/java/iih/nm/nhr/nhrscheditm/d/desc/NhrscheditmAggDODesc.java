package iih.nm.nhr.nhrscheditm.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nm.nhr.nhrscheditm.d.NhrSchedDO;
import iih.nm.nhr.nhrscheditm.d.NhrSchedItmStuDO;
import iih.nm.nhr.nhrscheditm.d.desc.NhrSchedItmStuDODesc;
import iih.nm.nhr.nhrscheditm.d.NhrSchedItmBedDO;
import iih.nm.nhr.nhrscheditm.d.desc.NhrSchedItmBedDODesc;

/**
 * 人员排班明细
 * @author
 *
 */
public class NhrscheditmAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public NhrscheditmAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(NhrSchedDO.class);
        addChildren(NhrSchedItmStuDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NhrSchedItmStuDODesc.class).getFKAttrDesc());        
        addChildren(NhrSchedItmBedDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NhrSchedItmBedDODesc.class).getFKAttrDesc());        
	  }	  
}