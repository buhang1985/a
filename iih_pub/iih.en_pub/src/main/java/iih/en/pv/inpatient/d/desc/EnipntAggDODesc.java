package iih.en.pv.inpatient.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.en.pv.inpatient.d.EntIpntDO;
import iih.en.pv.inpatient.d.EntIpntSrvDO;
import iih.en.pv.inpatient.d.desc.EntIpntSrvDODesc;

/**
 * 入院通知单
 * @author
 *
 */
public class EnipntAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public EnipntAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(EntIpntDO.class);
        addChildren(EntIpntSrvDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(EntIpntSrvDODesc.class).getFKAttrDesc());        
	  }	  
}