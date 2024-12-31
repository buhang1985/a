package iih.bd.pp.bdpripkg.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.pp.bdpripkg.d.BdPriPkgDO;
import iih.bd.pp.bdpripkg.d.BdPriPkgItmDO;
import iih.bd.pp.bdpripkg.d.desc.BdPriPkgItmDODesc;

/**
 * 组件
 * @author
 *
 */
public class BdpripkgAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public BdpripkgAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(BdPriPkgDO.class);
        addChildren(BdPriPkgItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(BdPriPkgItmDODesc.class).getFKAttrDesc());        
	  }	  
}