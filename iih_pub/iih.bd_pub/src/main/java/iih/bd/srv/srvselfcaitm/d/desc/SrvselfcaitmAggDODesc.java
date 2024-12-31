package iih.bd.srv.srvselfcaitm.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.srv.srvselfcaitm.d.SrvSelfCaItemDO;
import iih.bd.srv.srvselfcaitm.d.SrvSelfCaItmRelDO;
import iih.bd.srv.srvselfcaitm.d.desc.SrvSelfCaItmRelDODesc;

/**
 * 服务自定义分类项目
 * @author
 *
 */
public class SrvselfcaitmAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public SrvselfcaitmAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(SrvSelfCaItemDO.class);
        addChildren(SrvSelfCaItmRelDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(SrvSelfCaItmRelDODesc.class).getFKAttrDesc());        
	  }	  
}