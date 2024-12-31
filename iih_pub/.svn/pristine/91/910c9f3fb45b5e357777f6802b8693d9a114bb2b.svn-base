package iih.pe.phm.petcmconstcaeval.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.phm.petcmconstcaeval.d.PeTCMConDO;
import iih.pe.phm.petcmconstcaeval.d.PeTCMAsseDO;
import iih.pe.phm.petcmconstcaeval.d.desc.PeTCMAsseDODesc;

/**
 * 体检中医体质评估
 * @author
 *
 */
public class PetcmconstcaevalAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PetcmconstcaevalAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeTCMConDO.class);
        addChildren(PeTCMAsseDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeTCMAsseDODesc.class).getFKAttrDesc());        
	  }	  
}