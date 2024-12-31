package iih.bd.cmp.marplan.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.cmp.marplan.d.BdCmpMarPlanDO;
import iih.bd.cmp.marplan.d.BdCmpMarCtrDO;
import iih.bd.cmp.marplan.d.desc.BdCmpMarCtrDODesc;
import iih.bd.cmp.marplan.d.BdCmpMarChkDO;
import iih.bd.cmp.marplan.d.desc.BdCmpMarChkDODesc;
import iih.bd.cmp.marplan.d.BdCmpMarTreatDO;
import iih.bd.cmp.marplan.d.desc.BdCmpMarTreatDODesc;
import iih.bd.cmp.marplan.d.BdCmpMarFreeDO;
import iih.bd.cmp.marplan.d.desc.BdCmpMarFreeDODesc;

/**
 * 营销方案
 * @author
 *
 */
public class MarplanAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public MarplanAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(BdCmpMarPlanDO.class);
        addChildren(BdCmpMarCtrDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(BdCmpMarCtrDODesc.class).getFKAttrDesc());        
        addChildren(BdCmpMarChkDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(BdCmpMarChkDODesc.class).getFKAttrDesc());        
        addChildren(BdCmpMarTreatDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(BdCmpMarTreatDODesc.class).getFKAttrDesc());        
        addChildren(BdCmpMarFreeDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(BdCmpMarFreeDODesc.class).getFKAttrDesc());        
	  }	  
}