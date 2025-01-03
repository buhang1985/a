package iih.mbh.ci.i;

import java.io.IOException;
import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import iih.mbh.ci.memo.d.CiDrMemoDTO;
import iih.mbh.ci.memo.d.CiDrMemoFileDTO;
import iih.mbh.ci.order.d.CimrGroupDTO;
import iih.mbh.ci.order.d.CiorderInfoDTO;
import iih.mbh.ci.order.d.DrRptDTO;
import iih.mbh.ci.order.d.OrderConditionDTO;
import iih.mbh.sys.appdto.d.AppMenuParamDTO;
import xap.mw.core.data.BizException;

@WebService
public interface IMbhCiQueryService {

	public abstract List<CiorderInfoDTO> getPatOrderInfo(@WebParam(name = "id_ent") String id_ent, @WebParam(name = "params") List<AppMenuParamDTO> params, @WebParam(name = "orderCondition") List<OrderConditionDTO> orderCondition) throws BizException;

	public abstract List<CimrGroupDTO> getMrList(@WebParam(name = "id_ent") String id_ent) throws BizException;

	/**
	 * 获取医嘱过滤条件档案
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract List<OrderConditionDTO> getOrderCondition() throws BizException;

	/**
	 * 患者医嘱列表查询（医生站）
	 * 
	 * @param id_ent
	 * @param params
	 * @param orderCondition
	 * @return
	 * @throws BizException
	 */
	public abstract List<CiorderInfoDTO> drGetPatOrderInfos(@WebParam(name = "id_ent") String id_ent, @WebParam(name = "params") List<AppMenuParamDTO> params) throws BizException;

	/**
	 * 获取医生备忘列表（医生站）
	 * 
	 * @param id_ent
	 * @return
	 * @throws BizException
	 * @throws IOException
	 */
	public abstract List<CiDrMemoDTO> getDrMemoList(@WebParam(name = "id_ent") String id_ent) throws BizException, IOException;

	/**
	 * 获取医生备忘文件（医生站）
	 * 
	 * @param id_ent
	 * @return
	 * @throws BizException
	 * @throws IOException
	 */
	public abstract List<CiDrMemoFileDTO> getDrMemoFile(@WebParam(name = "id_memo") String id_memo) throws BizException, IOException;

	public abstract List<CimrGroupDTO> drGetMrList(@WebParam(name = "id_ent") String id_ent) throws BizException;

	public abstract String drGetTempListData(@WebParam(name = "id_ent") String id_ent) throws BizException;

	/**
	 * 查询检查报告（医生站）
	 * 
	 * @author fengjj
	 * @param id_pat
	 * @return
	 * @throws BizException
	 */
	public abstract DrRptDTO getDrRptobsList(@WebParam(name="id_pat") String id_pat, @WebParam(name="id_ent") String id_ent) throws BizException;


}