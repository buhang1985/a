package iih.bd.srv.srvpkg.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.srv.srvpkg.d.SrvPkgDO;
import iih.bd.srv.srvpkg.d.SrvPkgCondDO;
import iih.bd.srv.srvpkg.d.desc.SrvPkgCondDODesc;
import iih.bd.srv.srvpkg.d.SrvPkgDepDO;
import iih.bd.srv.srvpkg.d.desc.SrvPkgDepDODesc;
import iih.bd.srv.srvpkg.d.SrvPkgContrDO;
import iih.bd.srv.srvpkg.d.desc.SrvPkgContrDODesc;

/**
 * 医疗服务包
 * @author
 *
 */
public class SrvpkgAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public SrvpkgAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(SrvPkgDO.class);
        addChildren(SrvPkgCondDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(SrvPkgCondDODesc.class).getFKAttrDesc());        
        addChildren(SrvPkgDepDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(SrvPkgDepDODesc.class).getFKAttrDesc());        
        addChildren(SrvPkgContrDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(SrvPkgContrDODesc.class).getFKAttrDesc());        
	  }	  
}