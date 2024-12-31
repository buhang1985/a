package iih.pe.pitm.perstillness.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.pitm.perstillness.d.PeRstIllnessDO;
import iih.pe.pitm.perstillness.d.PeRstIllnessItemDO;
import iih.pe.pitm.perstillness.d.desc.PeRstIllnessItemDODesc;
import iih.pe.pitm.perstillness.d.PeRstIllnessDiDO;
import iih.pe.pitm.perstillness.d.desc.PeRstIllnessDiDODesc;
import iih.pe.pitm.perstillness.d.PeRstIllnessSportDO;
import iih.pe.pitm.perstillness.d.desc.PeRstIllnessSportDODesc;
import iih.pe.pitm.perstillness.d.PeRstIllnessFoodDO;
import iih.pe.pitm.perstillness.d.desc.PeRstIllnessFoodDODesc;
import iih.pe.pitm.perstillness.d.PeRstIllnessKeyDO;
import iih.pe.pitm.perstillness.d.desc.PeRstIllnessKeyDODesc;

/**
 * 体检疾病定义
 * @author
 *
 */
public class PerstillnessAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PerstillnessAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeRstIllnessDO.class);
        addChildren(PeRstIllnessItemDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeRstIllnessItemDODesc.class).getFKAttrDesc());        
        addChildren(PeRstIllnessDiDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeRstIllnessDiDODesc.class).getFKAttrDesc());        
        addChildren(PeRstIllnessSportDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeRstIllnessSportDODesc.class).getFKAttrDesc());        
        addChildren(PeRstIllnessFoodDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeRstIllnessFoodDODesc.class).getFKAttrDesc());        
        addChildren(PeRstIllnessKeyDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeRstIllnessKeyDODesc.class).getFKAttrDesc());        
	  }	  
}