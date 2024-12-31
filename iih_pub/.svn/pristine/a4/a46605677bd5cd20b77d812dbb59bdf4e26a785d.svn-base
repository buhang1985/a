package iih.bd.srv.srvdc.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.srv.srvdc.d.FixedChargePkgDO;
import iih.bd.srv.srvdc.d.FixedChargePkgItmDO;
import iih.bd.srv.srvdc.d.desc.FixedChargePkgItmDODesc;

/**
 * 医疗服务固定收费包
 * @author
 *
 */
public class SrvdcAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public SrvdcAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(FixedChargePkgDO.class);
        addChildren(FixedChargePkgItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(FixedChargePkgItmDODesc.class).getFKAttrDesc());        
	  }	  
}