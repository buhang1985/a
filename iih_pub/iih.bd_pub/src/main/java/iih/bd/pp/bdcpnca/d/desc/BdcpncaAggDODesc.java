package iih.bd.pp.bdcpnca.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.pp.bdcpnca.d.BdCpncaDO;
import iih.bd.pp.bdcpnca.d.BdCpncaSrvDO;
import iih.bd.pp.bdcpnca.d.desc.BdCpncaSrvDODesc;

/**
 * 优惠劵_基础数据
 * @author
 *
 */
public class BdcpncaAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public BdcpncaAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(BdCpncaDO.class);
        addChildren(BdCpncaSrvDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(BdCpncaSrvDODesc.class).getFKAttrDesc());        
	  }	  
}