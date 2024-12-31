package iih.bd.srv.ems.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.srv.ems.d.EmsPrnTmplDO;
import iih.bd.srv.ems.d.EmsPrnTmplRelSrvDO;
import iih.bd.srv.ems.d.desc.EmsPrnTmplRelSrvDODesc;
import iih.bd.srv.ems.d.EmsPrnTmplRelPresDO;
import iih.bd.srv.ems.d.desc.EmsPrnTmplRelPresDODesc;

/**
 * 医疗单打印模板管理
 * @author
 *
 */
public class EmsprntmplAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public EmsprntmplAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(EmsPrnTmplDO.class);
        addChildren(EmsPrnTmplRelSrvDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(EmsPrnTmplRelSrvDODesc.class).getFKAttrDesc());        
        addChildren(EmsPrnTmplRelPresDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(EmsPrnTmplRelPresDODesc.class).getFKAttrDesc());        
	  }	  
}