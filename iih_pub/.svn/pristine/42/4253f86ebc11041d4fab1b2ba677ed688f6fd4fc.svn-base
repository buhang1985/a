package iih.ci.mr.nu.laborprorecord.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.mr.nu.laborprorecord.d.PuerperainfoDO;
import iih.ci.mr.nu.laborprorecord.d.LaborprorecorditmDO;
import iih.ci.mr.nu.laborprorecord.d.desc.LaborprorecorditmDODesc;

/**
 * 产程观察护理记录单
 * @author
 *
 */
public class LaborprorecordAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public LaborprorecordAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PuerperainfoDO.class);
        addChildren(LaborprorecorditmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(LaborprorecorditmDODesc.class).getFKAttrDesc());        
	  }	  
}