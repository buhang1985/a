package iih.bd.srv.medsrv.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvLisDO;
import iih.bd.srv.medsrv.d.desc.MedSrvLisDODesc;
import iih.bd.srv.medsrv.d.MedSrvRisDO;
import iih.bd.srv.medsrv.d.desc.MedSrvRisDODesc;
import iih.bd.srv.medsrv.d.MedSrvOpDO;
import iih.bd.srv.medsrv.d.desc.MedSrvOpDODesc;
import iih.bd.srv.medsrv.d.MedSrvNurseDO;
import iih.bd.srv.medsrv.d.desc.MedSrvNurseDODesc;
import iih.bd.srv.medsrv.d.MedSrvDrugDO;
import iih.bd.srv.medsrv.d.desc.MedSrvDrugDODesc;
import iih.bd.srv.medsrv.d.MedSrvSaniDO;
import iih.bd.srv.medsrv.d.desc.MedSrvSaniDODesc;
import iih.bd.srv.medsrv.d.MedSrvAliasDO;
import iih.bd.srv.medsrv.d.desc.MedSrvAliasDODesc;
import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.bd.srv.medsrv.d.desc.MedSrvSetItemDODesc;
import iih.bd.srv.medsrv.d.MedSrvExecDeptDO;
import iih.bd.srv.medsrv.d.desc.MedSrvExecDeptDODesc;
import iih.bd.srv.medsrv.d.MedSrvCodeSetDO;
import iih.bd.srv.medsrv.d.desc.MedSrvCodeSetDODesc;
import iih.bd.srv.medsrv.d.MedSrvVtDO;
import iih.bd.srv.medsrv.d.desc.MedSrvVtDODesc;
import iih.bd.srv.medsrv.d.MedSrvConsDO;
import iih.bd.srv.medsrv.d.desc.MedSrvConsDODesc;
import iih.bd.srv.medsrv.d.MedSrvPriceDO;
import iih.bd.srv.medsrv.d.desc.MedSrvPriceDODesc;
import iih.bd.srv.medsrv.d.MedSrvBloodDO;
import iih.bd.srv.medsrv.d.desc.MedSrvBloodDODesc;
import iih.bd.srv.medsrv.d.MedSrvDietDO;
import iih.bd.srv.medsrv.d.desc.MedSrvDietDODesc;

/**
 * 医疗服务
 * @author
 *
 */
public class MedsrvAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public MedsrvAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(MedSrvDO.class);
        addChildren(MedSrvLisDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(MedSrvLisDODesc.class).getFKAttrDesc());        
        addChildren(MedSrvRisDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(MedSrvRisDODesc.class).getFKAttrDesc());        
        addChildren(MedSrvOpDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(MedSrvOpDODesc.class).getFKAttrDesc());        
        addChildren(MedSrvNurseDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(MedSrvNurseDODesc.class).getFKAttrDesc());        
        addChildren(MedSrvDrugDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(MedSrvDrugDODesc.class).getFKAttrDesc());        
        addChildren(MedSrvSaniDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(MedSrvSaniDODesc.class).getFKAttrDesc());        
        addChildren(MedSrvAliasDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(MedSrvAliasDODesc.class).getFKAttrDesc());        
        addChildren(MedSrvSetItemDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(MedSrvSetItemDODesc.class).getFKAttrDesc());        
        addChildren(MedSrvExecDeptDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(MedSrvExecDeptDODesc.class).getFKAttrDesc());        
        addChildren(MedSrvCodeSetDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(MedSrvCodeSetDODesc.class).getFKAttrDesc());        
        addChildren(MedSrvVtDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(MedSrvVtDODesc.class).getFKAttrDesc());        
        addChildren(MedSrvConsDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(MedSrvConsDODesc.class).getFKAttrDesc());        
        addChildren(MedSrvPriceDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(MedSrvPriceDODesc.class).getFKAttrDesc());        
        addChildren(MedSrvBloodDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(MedSrvBloodDODesc.class).getFKAttrDesc());        
        addChildren(MedSrvDietDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(MedSrvDietDODesc.class).getFKAttrDesc());        
	  }	  
}