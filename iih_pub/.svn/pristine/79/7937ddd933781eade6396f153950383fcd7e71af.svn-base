package iih.bd.pp.service.i;

import iih.bd.pp.bdprisamp.d.BdPriSampDO;
import iih.bd.pp.dto.bltpl.d.BlTplDTO;
import iih.bd.pp.dto.d.PriStdSrvDTO;
import iih.bd.pp.dto.d.PricelistqrySrvDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
/**
 * 煎法和标本采集费用
 * @author tcy
 *
 */
public interface IPriQueService {
	/**
	 * 根据标本类型查询标本采集费用对照
	 * @param sd_samptp 标本类型
	 * @return 标本采集费用对照
	 * @throws BizException
	 */
	public abstract BdPriSampDO[] getBdPriSampDOBySampTp(String sd_samptp)  throws BizException;
	
	/**
	 * 取得费用模板信息
	 * @param deptId 责任科室
	 * @param empId 责任人
	 * @param containHos 包含院级模板
	 * @return 费用模板信息
	 * @throws BizException
	 * @author ly 2016/08/02
	 */
	public abstract BlTplDTO[] getBlTplInfo(String deptId,String empId,FBoolean containHos) throws BizException;
	/**
	 * 计算煎法的标准费用
	 * @param Id_priboil 煎法
	 * @return 费用PriStdSrvDTO
	 * @throws BizException
	 */
	public abstract PriStdSrvDTO[] getPriStdSrvDTOByBoil(String Id_priboil) throws BizException;
	
	/**
	 * 通过用户输入的搜索关键字获得名称中包含所搜关键字的服务列表
	 * @param 搜索关键字字符
	 * @return
	 * @throws BizException
	 */
	public abstract PricelistqrySrvDTO[] getPricelistqrySrvDTOByIdsrv(String qryNamesrv )throws BizException;
	
	/**
	 * 通过服务的主键获得服务的本服务定价的价格列表
	 * @param 服务主键id_srv
	 * @return
	 * @throws BizException
	 */
	public PricelistqrySrvDTO[] getSrvlistByQrynamesrv(String id_srv) throws BizException ;
	
	 public   PagingRtnData<PricelistqrySrvDTO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO, String orderStr, PaginationInfo pg)throws BizException ;
}
