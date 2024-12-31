package iih.pe.phm.pecmaresult.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.phm.pecmaresult.d.PeCmaDO;
import iih.pe.phm.pecmaresult.d.PeCmaKeyDO;
import iih.pe.phm.pecmaresult.d.desc.PeCmaKeyDODesc;

/**
 * 健康评估自测问卷结果
 * @author
 *
 */
public class PecmaresultAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PecmaresultAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeCmaDO.class);
        addChildren(PeCmaKeyDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeCmaKeyDODesc.class).getFKAttrDesc());        
	  }	  
}