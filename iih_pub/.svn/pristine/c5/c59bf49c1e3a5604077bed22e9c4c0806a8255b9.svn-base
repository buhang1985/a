package iih.bd.srv.srvspecantiexpert.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.srvspecantiexpert.d.SrvSpecAntiExpertDO;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
* 特殊使用级抗菌药专家扩展服务
*/
public interface ISrvspecantiexpertExtRService {
	
    /**
     * 根据人员基本信息的查询方案查询聚合数据集合
     * @param qryRootNodeDTO人员基本信息查询方案
     * @param orderStr 人员基本信息排序字段
     * @return
     * @throws BizException
     */
	public SrvSpecAntiExpertDO[] findByPsndocQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr) throws BizException;
}