package iih.bd.srv.urgentsrv.i;

import iih.bd.fc.entp.d.EnTypeDO;
import iih.bd.srv.urgentsrv.d.UrgentSrvDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.SqlParamDTO;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 加急服务项目服务接口
 * 
 * @author hao_wu 2020-1-7
 *
 */
public interface IUrgentSrvExtRService {

	/**
	 * 根据就诊类型查询加急服务项目
	 * 
	 * @param enTypeDo       就诊类型
	 * @param qryRootNodeDTO 查询方案
	 * @param whereStr       条件语句
	 * @param sqlParamDTO    条件参数DTO
	 * @param orderStr       排序语句
	 * @return 加急服务项目
	 * @throws BizException
	 */
	public abstract PagingRtnData<UrgentSrvDTO> findPagingUrgentSrvByEntp(PaginationInfo pageInfo,EnTypeDO enTypeDo,
			QryRootNodeDTO qryRootNodeDTO, String whereStr, SqlParamDTO sqlParamDTO, String orderStr)
			throws BizException;
}
