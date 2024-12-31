package iih.bd.srv.ems.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.srv.ems.d.EmsDO;
import iih.bd.srv.ems.d.EmsRelSrvDO;
import iih.bd.srv.ems.d.desc.EmsRelSrvDODesc;
import iih.bd.srv.ems.d.EmsIndexDO;
import iih.bd.srv.ems.d.desc.EmsIndexDODesc;

/**
 * 医疗单注册
 * @author
 *
 */
public class EmsregistryAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public EmsregistryAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(EmsDO.class);
        addChildren(EmsRelSrvDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(EmsRelSrvDODesc.class).getFKAttrDesc());        
        addChildren(EmsIndexDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(EmsIndexDODesc.class).getFKAttrDesc());        
	  }	  
}