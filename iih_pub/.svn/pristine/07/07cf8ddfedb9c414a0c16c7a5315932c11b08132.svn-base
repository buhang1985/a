package iih.bd.pp.service.i;

import iih.bd.pp.bdcpnca.d.BdCpncaDO;
import iih.bd.pp.dto.d.BdPriSampDTO;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.pp.hpsrvorca.d.ImportDTO;
import iih.bd.pp.incca.d.IncCaItmRelDO;
import iih.bd.pp.incca.d.UnComparisonedSrvDTO;
import iih.bd.pp.prisrv.d.PriSrvDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public interface IPriMaintainService {

	/**
	 * 添加医疗服务和服务定价
	 * */
	public MedSrvDO saveMedSrvPrice(MedSrvDO medSrvDO, PriSrvDO[] priSrvDOArr)
			throws BizException;

	/**
	 * 获取服务医保对照信息
	 * */
	public HPSrvorcaDO[] findHpSrvOrCaInfo() throws BizException;

	/**
	 * 导出药品字典
	 * */
	public HPSrvorcaDO[] exportDrugsInfo() throws BizException;

	/**
	 * 导出诊疗字典
	 * */
	public HPSrvorcaDO[] exportMedicalInfo() throws BizException;

	/**
	 * 保存医保目录对照数据
	 * */
	public FBoolean saveHpSrvOrCaInfo(HPSrvorcaDO[] hpSrvOrCaDOArr)
			throws BizException;

	/**
	 * 找出某个票据分类下所包含的所有未对照的服务分类
	 * 
	 * @author li_pengying
	 * @param id_incca
	 * @return
	 * @throws BizException
	 */
	public abstract UnComparisonedSrvDTO[] getUnComparisonedSrvDTOByIdincca(
			String id_incca) throws BizException;

	/**
	 * 得到某个服务分类下的所有的未对照的服务
	 * 
	 * @author li_pengying
	 * @param id_incca
	 * @param id_srvca
	 * @return
	 * @throws BizException
	 */
	public abstract MedSrvDO[] getUnComparisonedSrvsList(String id_incca,
			String id_srvca) throws BizException;

	/**
	 * 添加所选的服务和票据分类项目之间的对照，新增数据保存到bd_incca_itm_rel中
	 * 
	 * @param inccaitmRelDOArr
	 * @author li_pengying
	 * @return
	 * @throws BizException
	 */
	public abstract FBoolean saveComparisonedSrv(
			IncCaItmRelDO[] inccaitmRelDOArr) throws BizException;

	/**
	 * 通过服务id和票据分类项目id_inccaitm 找到所有对应的服务对照数据
	 * 
	 * @param id_inccaitm
	 * @param id_srv
	 * @author li_pengying
	 * @return
	 * @throws BizException
	 */
	public abstract IncCaItmRelDO[] findInccaItmRelDtoById(String id_inccaitm,
			String id_incca, String id_srv, String id_srvca)
			throws BizException;

	/**
	 * 通过服务分类的主键id_srvca和票据分类主键id_incca 、票据分类项目id_inccaitm 找到所有对应的服务对照数据
	 * 
	 * @param id_incca
	 * @param id_inccaitm
	 * @param id_srvca
	 * @author li_pengying
	 * @return
	 * @throws BizException
	 */
	public abstract IncCaItmRelDO[] findInccaitmRelDOByIdsrvca(String id_incca,
			String id_inccaitm, String id_srvca) throws BizException;

	/**
	 * 删除优惠券分类BdCpnCaDO及其对应的所有优惠券BdCpnDO[]
	 * 
	 * @param bdcpncaDO
	 * @return
	 * @throws BizException
	 */
	public abstract FBoolean deleteBdcpnCaAndDOs(BdCpncaDO bdcpncaDO)
			throws BizException;

	/**
	 * 保存对服务价格数据（bd_pri_srv）的修改（同时修改医疗服务bd_srv表中对应的pri字段）
	 * */
	public abstract PriSrvDO[] saveMedSrvPriInfo(PriSrvDO[] dos)
			throws BizException;

	/**
	 * 删除服务，并删除其对应价表数据
	 * */
	public FBoolean deleteMedSrvAndPrice(MedSrvDO medSrvDO) throws BizException;

	/**
	 * 费用对照，保存数据
	 * */
	public MedSrvDO saveMedSrvSetPriInfo(MedSrvDO medSrvDO, FArrayList list)
			throws BizException;

	/**
	 * 查询得到所有的标本类型名称，标本采集费用对照左侧表格显示用接口
	 * 
	 * @return
	 * @author li_pengying
	 * @throws BizException
	 */
	public abstract BdPriSampDTO[] getSampTypeGrid() throws BizException;

	/**
	 * 由服务主键id_srv查找得到服务的票据分类项目对照关系
	 * 
	 * @param id_srv
	 * @param id_incca
	 * @author li_pengying
	 * @return
	 * @throws BizException
	 */
	public IncCaItmRelDO[] findInccaItmNameByIdsrv(String id_srv,
			String id_incca) throws BizException;

	/**
	 * 导入医保目录对照信息
	 * 
	 * @param importData
	 *            导入的文本信息
	 * @param fg_drug
	 *            药品标志
	 * @return
	 * @throws BizException
	 */
	public ImportDTO[] importHPSrvorca(String id_hp, String importData,
			Boolean fg_drug) throws BizException;

	/**
	 * 导出医保目录对照信息
	 * 
	 * @param fg_drug
	 *            药品标志
	 * @return 导出的文本
	 * @throws BizException
	 */
	public String exportHPSrvorca(Boolean fg_drug) throws BizException;
	
	/**
	 * 保存医保目录对照信息
	 * @param hpSrvOrCaDOArr
	 * @param fg_drug
	 * @return
	 * @throws BizException
	 */
	public FBoolean saveHPSrvorca(HPSrvorcaDO[] hpSrvOrCaDOArr,Boolean fg_drug) throws BizException;
	
	/**
	 * 删除所勾选的医保目录对照数据，同时删除其相应的医保计划_控制策略数据
	 * @param selectedDOArr
	 * @return
	 * @throws BizException
	 */
	public  FBoolean deleteHPSrvorcasDataAndHpSrvctrsData(HPSrvorcaDO[] selectedDOArr)throws BizException;
}
