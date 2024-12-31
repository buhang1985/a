package iih.pe.pqn.petcmconstcadef.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.pqn.petcmconstcadef.d.PeTCMconstcaDefDO;
import iih.pe.pqn.petcmconstcadef.d.PeTCMJudgeQaDO;
import iih.pe.pqn.petcmconstcadef.d.desc.PeTCMJudgeQaDODesc;

/**
 * 体检中医体质分型定义
 * @author
 *
 */
public class PetcmconstcadefAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PetcmconstcadefAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeTCMconstcaDefDO.class);
        addChildren(PeTCMJudgeQaDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeTCMJudgeQaDODesc.class).getFKAttrDesc());        
	  }	  
}