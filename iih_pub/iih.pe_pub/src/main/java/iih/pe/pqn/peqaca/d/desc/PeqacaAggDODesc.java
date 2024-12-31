package iih.pe.pqn.peqaca.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.pqn.peqaca.d.PeQaCaDO;
import iih.pe.pqn.peqaca.d.PeQaCaItmDO;
import iih.pe.pqn.peqaca.d.desc.PeQaCaItmDODesc;

/**
 * 体检问卷组套
 * @author
 *
 */
public class PeqacaAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PeqacaAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeQaCaDO.class);
        addChildren(PeQaCaItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeQaCaItmDODesc.class).getFKAttrDesc());        
	  }	  
}