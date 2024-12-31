package iih.nm.nqm.nmnqmspcs.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nm.nqm.nmnqmspcs.d.NmNqmSpcsDo;
import iih.nm.nqm.nmnqmspcs.d.NmNqmSpcsKpiDo;
import iih.nm.nqm.nmnqmspcs.d.desc.NmNqmSpcsKpiDoDesc;

/**
 * 护理管理_专科护理质量
 * @author
 *
 */
public class NmnqmspcsAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public NmnqmspcsAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(NmNqmSpcsDo.class);
        addChildren(NmNqmSpcsKpiDo.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NmNqmSpcsKpiDoDesc.class).getFKAttrDesc());        
	  }	  
}