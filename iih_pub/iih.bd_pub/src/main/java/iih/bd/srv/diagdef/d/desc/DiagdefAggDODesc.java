package iih.bd.srv.diagdef.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.srv.diagdef.d.DiagDefDO;
import iih.bd.srv.diagdef.d.DiagIndDO;
import iih.bd.srv.diagdef.d.desc.DiagIndDODesc;
import iih.bd.srv.diagdef.d.DiagAliasDO;
import iih.bd.srv.diagdef.d.desc.DiagAliasDODesc;
import iih.bd.srv.diagdef.d.DiagCompDO;
import iih.bd.srv.diagdef.d.desc.DiagCompDODesc;

/**
 * 医疗服务_疾病诊断定义
 * @author
 *
 */
public class DiagdefAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public DiagdefAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(DiagDefDO.class);
        addChildren(DiagIndDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(DiagIndDODesc.class).getFKAttrDesc());        
        addChildren(DiagAliasDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(DiagAliasDODesc.class).getFKAttrDesc());        
        addChildren(DiagCompDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(DiagCompDODesc.class).getFKAttrDesc());        
	  }	  
}