package iih.pe.phm.petcmhealth.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.phm.petcmhealth.d.PeTCMHealthTpDO;
import iih.pe.phm.petcmhealth.d.PeTCMHealthDO;
import iih.pe.phm.petcmhealth.d.desc.PeTCMHealthDODesc;

/**
 * 体检中医养生
 * @author
 *
 */
public class PetcmhealthAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PetcmhealthAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeTCMHealthTpDO.class);
        addChildren(PeTCMHealthDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeTCMHealthDODesc.class).getFKAttrDesc());        
	  }	  
}