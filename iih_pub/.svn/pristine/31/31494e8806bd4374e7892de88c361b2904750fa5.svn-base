package iih.bd.srv.emrterm.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.srv.emrterm.d.EmrTermCaDO;
import iih.bd.srv.emrterm.d.EmrTermGrpDO;
import iih.bd.srv.emrterm.d.desc.EmrTermGrpDODesc;

/**
 * 病历术语分类
 * @author
 *
 */
public class EmrtermcaAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public EmrtermcaAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(EmrTermCaDO.class);
        addChildren(EmrTermGrpDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(EmrTermGrpDODesc.class).getFKAttrDesc());        
	  }	  
}