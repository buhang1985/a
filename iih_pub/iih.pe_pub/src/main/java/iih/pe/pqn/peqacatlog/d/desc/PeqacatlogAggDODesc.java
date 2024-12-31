package iih.pe.pqn.peqacatlog.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.pqn.peqacatlog.d.PeQaCatDO;
import iih.pe.pqn.peqacatlog.d.PeQaCatGrdDO;
import iih.pe.pqn.peqacatlog.d.desc.PeQaCatGrdDODesc;

/**
 * 体检问卷问题分组
 * @author
 *
 */
public class PeqacatlogAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PeqacatlogAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeQaCatDO.class);
        addChildren(PeQaCatGrdDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeQaCatGrdDODesc.class).getFKAttrDesc());        
	  }	  
}