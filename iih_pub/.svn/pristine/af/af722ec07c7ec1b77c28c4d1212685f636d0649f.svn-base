package iih.pi.patsrvpkg.pipatsrvpkgitem.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pi.patsrvpkg.pipatsrvpkgitem.d.PiPatSrvPkgItmDO;
import iih.pi.patsrvpkg.pipatsrvpkgitem.d.PiPatSrvPkgItemCompDO;
import iih.pi.patsrvpkg.pipatsrvpkgitem.d.desc.PiPatSrvPkgItemCompDODesc;

/**
 * 患者服务包服务项目对照
 * @author
 *
 */
public class PipatsrvpkgitemAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PipatsrvpkgitemAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PiPatSrvPkgItmDO.class);
        addChildren(PiPatSrvPkgItemCompDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PiPatSrvPkgItemCompDODesc.class).getFKAttrDesc());        
	  }	  
}