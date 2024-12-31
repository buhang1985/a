package iih.ei.std.i.v1;

import iih.ei.std.d.v1.bd.comm.d.EiBdQryWsParamDTO;
import iih.ei.std.d.v1.bd.depdoc.d.DepDocListDTO;
import iih.ei.std.d.v1.bd.didoc.d.DiDocListDTO;
import iih.ei.std.d.v1.bd.drugdoc.d.DrugDocListDTO;
import iih.ei.std.d.v1.bd.paytp.d.PayTpListDTO;
import iih.ei.std.d.v1.bd.picatedoc.d.PiCateDocListDTO;
import iih.ei.std.d.v1.bd.psndoc.d.PsnDocListDTO;
import iih.ei.std.d.v1.bd.sugdoc.d.SugDocListDTO;
import iih.ei.std.d.v1.bd.svrtpdoc.d.SvrTpDocListDTO;
import iih.ei.std.d.v1.bd.sync.prisrvdoc.d.PriceSrvListDTO;
import iih.ei.std.d.v1.bd.treatdoc.d.TreatDocListDTO;
import xap.mw.core.data.BizException;

/***
 * IIH基础数据域标准对外接口（XML格式）
 * 
 * @author hao_wu
 * @date: 2019-9-6
 */
public interface IBdApiService {

	/**
	 * 查询人员档案信息
	 * 
	 * @param paramDto 参数DTO
	 * @return 人员档案列表
	 */
	public abstract PsnDocListDTO findPsnDoc(EiBdQryWsParamDTO paramDto) throws BizException;

	/**
	 * 查询部门档案信息
	 * 
	 * @param paramDto 参数DTO
	 * @return 部门档案列表
	 */
	public abstract DepDocListDTO findDepDoc(EiBdQryWsParamDTO paramDto) throws BizException;

	/**
	 * 查询药品档案信息
	 * 
	 * @param paramDto 参数DTO
	 * @return 药品档案列表
	 */
	public abstract DrugDocListDTO findDrugDoc(EiBdQryWsParamDTO paramDto) throws BizException;

	/**
	 * 查询付款方式档案信息
	 * 
	 * @param paramDto 参数DTO
	 * @return 付款方式档案列表
	 */
	public abstract PayTpListDTO findPayTpDoc(EiBdQryWsParamDTO paramDto) throws BizException;

	/**
	 * 查询号类(挂号类型)档案信息
	 * 
	 * @param paramDto 参数DTO
	 * @return 号类(挂号类型)档案列表
	 */
	public abstract SvrTpDocListDTO findSvrTpDoc(EiBdQryWsParamDTO paramDto) throws BizException;

	/**
	 * 查询患者分类档案信息
	 * 
	 * @param paramDto 参数DTO
	 * @return 患者分类档案列表
	 */
	public abstract PiCateDocListDTO findPiCateDoc(EiBdQryWsParamDTO paramDto) throws BizException;

	/**
	 * 查询诊疗项目档案信息
	 * 
	 * @param paramDto 参数DTO
	 * @return 诊疗项目档案列表
	 */
	public abstract TreatDocListDTO findTreatDoc(EiBdQryWsParamDTO paramDto) throws BizException;

	/**
	 * 查询手术项目档案信息
	 * 
	 * @param paramDto 参数DTO
	 * @return 手术项目档案列表
	 */
	public abstract SugDocListDTO findSugDoc(EiBdQryWsParamDTO paramDto) throws BizException;

	/**
	 * 查询诊断档案信息
	 * 
	 * @param paramDto 参数DTO
	 * @return 诊断档案列表
	 */
	public abstract DiDocListDTO findDiDoc(EiBdQryWsParamDTO paramDto) throws BizException;

	/**
	 * 同步价格服务
	 * 
	 * @param priceSrvListDTO 价格服务列表
	 * @throws BizException
	 */
	public abstract void syncPriSrvDoc(PriceSrvListDTO priceSrvListDTO) throws BizException;

	/**
	 * 同步人员档案
	 * 
	 * @param psnDocListDTO 人员档案列表
	 * @throws BizException
	 */
	public abstract void syncPsnDoc(iih.ei.std.d.v1.bd.sync.psndoc.d.PsnDocListDTO psnDocListDTO) throws BizException;
}
