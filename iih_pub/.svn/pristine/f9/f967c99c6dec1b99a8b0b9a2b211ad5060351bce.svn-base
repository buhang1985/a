package iih.pe.phm.pechrodise.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.phm.pechrodise.d.PeChroDiseDO;
import iih.pe.phm.pechrodise.d.PeChroDiseRiskListDO;
import iih.pe.phm.pechrodise.d.desc.PeChroDiseRiskListDODesc;
import iih.pe.phm.pechrodise.d.PeChroDiseScDO;
import iih.pe.phm.pechrodise.d.desc.PeChroDiseScDODesc;

/**
 * 体检慢性病风险评估
 * @author
 *
 */
public class PechrodiseAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PechrodiseAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeChroDiseDO.class);
        addChildren(PeChroDiseRiskListDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeChroDiseRiskListDODesc.class).getFKAttrDesc());        
        addChildren(PeChroDiseScDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeChroDiseScDODesc.class).getFKAttrDesc());        
	  }	  
}