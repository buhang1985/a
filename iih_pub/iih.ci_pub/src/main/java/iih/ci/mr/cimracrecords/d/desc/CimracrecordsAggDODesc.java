package iih.ci.mr.cimracrecords.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.mr.cimracrecords.d.CiMrACBaseDO;
import iih.ci.mr.cimracrecords.d.CiMrACUCDO;
import iih.ci.mr.cimracrecords.d.desc.CiMrACUCDODesc;
import iih.ci.mr.cimracrecords.d.CiMrACOtherDO;
import iih.ci.mr.cimracrecords.d.desc.CiMrACOtherDODesc;
import iih.ci.mr.cimracrecords.d.CiMrACFetus;
import iih.ci.mr.cimracrecords.d.desc.CiMrACFetusDesc;

/**
 * 产程数据记录
 * @author
 *
 */
public class CimracrecordsAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public CimracrecordsAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(CiMrACBaseDO.class);
        addChildren(CiMrACUCDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(CiMrACUCDODesc.class).getFKAttrDesc());        
        addChildren(CiMrACOtherDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(CiMrACOtherDODesc.class).getFKAttrDesc());        
        addChildren(CiMrACFetus.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(CiMrACFetusDesc.class).getFKAttrDesc());        
	  }	  
}