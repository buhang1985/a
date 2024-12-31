package iih.bd.srv.srvpkggrpitm.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.srv.srvpkggrpitm.d.SrvPkgItmDO;
import iih.bd.srv.srvpkggrpitm.d.SrvPkgItmSrvContrastDO;
import iih.bd.srv.srvpkggrpitm.d.desc.SrvPkgItmSrvContrastDODesc;

/**
 * 医疗服务包分组项目
 * @author
 *
 */
public class SrvpkggrpitmAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public SrvpkggrpitmAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(SrvPkgItmDO.class);
        addChildren(SrvPkgItmSrvContrastDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(SrvPkgItmSrvContrastDODesc.class).getFKAttrDesc());        
	  }	  
}