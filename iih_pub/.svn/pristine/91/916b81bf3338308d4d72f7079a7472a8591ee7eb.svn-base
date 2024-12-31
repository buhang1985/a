package iih.cssd.dpbd.pkg.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.cssd.dpbd.pkg.d.CssdPkgDO;
import iih.cssd.dpbd.pkg.d.Cssdpkgmm;
import iih.cssd.dpbd.pkg.d.desc.CssdpkgmmDesc;

/**
 * 消毒包定义
 * @author
 *
 */
public class PkgAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PkgAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(CssdPkgDO.class);
        addChildren(Cssdpkgmm.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(CssdpkgmmDesc.class).getFKAttrDesc());        
	  }	  
}