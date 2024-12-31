package iih.bd.mm.meterial.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.d.MMPackageUnitDO;
import iih.bd.mm.meterial.d.desc.MMPackageUnitDODesc;
import iih.bd.mm.meterial.d.MMAliasDO;
import iih.bd.mm.meterial.d.desc.MMAliasDODesc;

/**
 * 医疗物品
 * @author
 *
 */
public class MeterialAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public MeterialAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(MeterialDO.class);
        addChildren(MMPackageUnitDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(MMPackageUnitDODesc.class).getFKAttrDesc());        
        addChildren(MMAliasDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(MMAliasDODesc.class).getFKAttrDesc());        
	  }	  
}