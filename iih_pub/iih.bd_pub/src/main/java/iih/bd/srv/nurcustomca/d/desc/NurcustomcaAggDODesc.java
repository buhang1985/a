package iih.bd.srv.nurcustomca.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.srv.nurcustomca.d.NurCustomcaDO;
import iih.bd.srv.nurcustomca.d.NurCustomcaItmDO;
import iih.bd.srv.nurcustomca.d.desc.NurCustomcaItmDODesc;

/**
 * 医疗记录_护理文书分类
 * @author
 *
 */
public class NurcustomcaAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public NurcustomcaAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(NurCustomcaDO.class);
        addChildren(NurCustomcaItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NurCustomcaItmDODesc.class).getFKAttrDesc());        
	  }	  
}