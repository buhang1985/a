package iih.bd.srv.diagcatectm.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.srv.diagcatectm.d.DiCaCtmItmDO;
import iih.bd.srv.diagcatectm.d.DiCaCtmItmRelDO;
import iih.bd.srv.diagcatectm.d.desc.DiCaCtmItmRelDODesc;

/**
 * 疾病诊断自定义分类项目
 * @author
 *
 */
public class DiagcatectmitmAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public DiagcatectmitmAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(DiCaCtmItmDO.class);
        addChildren(DiCaCtmItmRelDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(DiCaCtmItmRelDODesc.class).getFKAttrDesc());        
	  }	  
}