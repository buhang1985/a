package iih.sc.scbd.schedulesrv.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.sc.scbd.schedulesrv.d.ScSrvKindDO;
import iih.sc.scbd.schedulesrv.d.ScSrvKindItm;
import iih.sc.scbd.schedulesrv.d.desc.ScSrvKindItmDesc;

/**
 * 排班服务类别
 * @author
 *
 */
public class ScsrvkinddoAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public ScsrvkinddoAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(ScSrvKindDO.class);
        addChildren(ScSrvKindItm.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(ScSrvKindItmDesc.class).getFKAttrDesc());        
	  }	  
}