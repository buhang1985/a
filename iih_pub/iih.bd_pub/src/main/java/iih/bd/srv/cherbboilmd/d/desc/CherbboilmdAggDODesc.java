package iih.bd.srv.cherbboilmd.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.srv.cherbboilmd.d.CHerbBoilMdDO;
import iih.bd.srv.cherbboilmd.d.CHerbBoilDesDO;
import iih.bd.srv.cherbboilmd.d.desc.CHerbBoilDesDODesc;

/**
 * 医疗服务中药煎法
 * @author
 *
 */
public class CherbboilmdAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public CherbboilmdAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(CHerbBoilMdDO.class);
        addChildren(CHerbBoilDesDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(CHerbBoilDesDODesc.class).getFKAttrDesc());        
	  }	  
}