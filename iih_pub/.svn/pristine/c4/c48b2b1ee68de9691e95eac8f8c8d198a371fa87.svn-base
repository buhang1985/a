package iih.pe.pitm.penarraterecipe.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.pitm.penarraterecipe.d.PeNarrateRecipeDO;
import iih.pe.pitm.penarraterecipe.d.PeNarrateRecipeItmDO;
import iih.pe.pitm.penarraterecipe.d.desc.PeNarrateRecipeItmDODesc;

/**
 * 体检叙述型营养处方
 * @author
 *
 */
public class PenarraterecipeAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PenarraterecipeAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeNarrateRecipeDO.class);
        addChildren(PeNarrateRecipeItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeNarrateRecipeItmDODesc.class).getFKAttrDesc());        
	  }	  
}