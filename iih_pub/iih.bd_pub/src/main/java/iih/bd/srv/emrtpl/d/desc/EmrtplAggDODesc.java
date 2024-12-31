package iih.bd.srv.emrtpl.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.srv.emrtpl.d.EmrTplDO;
import iih.bd.srv.emrtpl.d.MrTplRelDO;
import iih.bd.srv.emrtpl.d.desc.MrTplRelDODesc;

/**
 * 医疗记录模板
 * @author
 *
 */
public class EmrtplAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public EmrtplAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(EmrTplDO.class);
        addChildren(MrTplRelDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(MrTplRelDODesc.class).getFKAttrDesc());        
	  }	  
}