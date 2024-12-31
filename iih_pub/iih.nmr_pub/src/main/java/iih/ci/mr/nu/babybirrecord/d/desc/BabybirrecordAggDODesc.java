package iih.ci.mr.nu.babybirrecord.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.mr.nu.babybirrecord.d.BabyBirInfoDO;
import iih.ci.mr.nu.babybirrecord.d.BabyBirRecordDO;
import iih.ci.mr.nu.babybirrecord.d.desc.BabyBirRecordDODesc;

/**
 * 婴儿产时记录
 * @author
 *
 */
public class BabybirrecordAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public BabybirrecordAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(BabyBirInfoDO.class);
        addChildren(BabyBirRecordDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(BabyBirRecordDODesc.class).getFKAttrDesc());        
	  }	  
}