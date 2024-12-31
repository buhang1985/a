package iih.ci.mr.nu.earlywarnmark.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.mr.nu.earlywarnmark.d.EarlywarnminfoDO;
import iih.ci.mr.nu.earlywarnmark.d.EarlywarnmDO;
import iih.ci.mr.nu.earlywarnmark.d.desc.EarlywarnmDODesc;

/**
 * 重症患者早期预警评分表
 * @author
 *
 */
public class EarlywarnmarkAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public EarlywarnmarkAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(EarlywarnminfoDO.class);
        addChildren(EarlywarnmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(EarlywarnmDODesc.class).getFKAttrDesc());        
	  }	  
}