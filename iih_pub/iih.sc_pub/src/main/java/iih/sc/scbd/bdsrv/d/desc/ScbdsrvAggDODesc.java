package iih.sc.scbd.bdsrv.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.sc.scbd.bdsrv.d.ScBdsrvDO;
import iih.sc.scbd.bdsrv.d.ScBdsrvKindItm;
import iih.sc.scbd.bdsrv.d.desc.ScBdsrvKindItmDesc;

/**
 * 排班计划-医疗服务
 * @author
 *
 */
public class ScbdsrvAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public ScbdsrvAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(ScBdsrvDO.class);
        addChildren(ScBdsrvKindItm.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(ScBdsrvKindItmDesc.class).getFKAttrDesc());        
	  }	  
}