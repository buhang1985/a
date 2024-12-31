package iih.ci.mr.nu.newbabyskinriskass.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.mr.nu.newbabyskinriskass.d.NewBabySkinAssDO;
import iih.ci.mr.nu.newbabyskinriskass.d.ScoreProjectDO;
import iih.ci.mr.nu.newbabyskinriskass.d.desc.ScoreProjectDODesc;

/**
 * 新生儿皮肤风险评估
 * @author
 *
 */
public class NewbabyskinriskassAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public NewbabyskinriskassAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(NewBabySkinAssDO.class);
        addChildren(ScoreProjectDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(ScoreProjectDODesc.class).getFKAttrDesc());        
	  }	  
}