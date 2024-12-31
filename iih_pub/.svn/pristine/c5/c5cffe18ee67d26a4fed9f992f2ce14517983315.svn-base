package iih.ci.ord.ordprn.i;

import iih.ci.ord.dto.ordprintdto.d.OrdPrintDataDTO;
import iih.ci.ord.dto.ordprintdto.d.OrdPrintParamDTO;
import iih.ci.ord.ordprn.d.OrdPrintDO;
import iih.ci.ord.ordprn.dto.d.CiOrdSheetParamDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.perm.scvi.d.MyScviDO;

/**
 * 医嘱单打印服务接口
 * @author Young
 *
 */
public interface IOrdprintExtService {

	/**
	 * 获取医嘱打印对象集合
	 * @param printParam
	 * @return
	 * @throws BizException
	 */
	public abstract OrdPrintDataDTO[] GetOrdPrintDataDTOs(OrdPrintParamDTO printParam) throws Exception;
	
	/**
	 * 查询已打印的数据
	 * @param paramDTO
	 * @return
	 * @throws BizException
	 */
	public abstract OrdPrintDO[] GetOrdPrintDOsPrted(OrdPrintParamDTO paramDTO) throws BizException;
	
	/**
	 * 获取已打印医嘱的页码集合
	 * @param paramDTO
	 * @return
	 * @throws BizException
	 */
	public abstract int[] GetPageNums(OrdPrintParamDTO paramDTO) throws BizException;
	
	/**
	 * 根据待打印医嘱，获取对应已打印医嘱中所在页的数据
	 * @param paramDTO 就诊id、长临标识
	 * @param printDataDTOs 待打印医嘱
	 * @return 已打印医嘱（返回需要打印所在页的全部已打印医嘱）
	 * @throws BizException
	 */
	public abstract OrdPrintDO[] GetOrdPrintDOs(OrdPrintParamDTO paramDTO, OrdPrintDataDTO[] printDataDTOs) throws BizException;

	/**
	 * 保存重置打印医嘱
	 * @param paramDTO
	 * @param ordPrintDOs 重整后待打印的医嘱
	 * @return
	 * @throws BizException
	 */
	public abstract void SaveResetOrdPrintDOs(OrdPrintParamDTO paramDTO, OrdPrintDO[] ordPrintDOs) throws BizException;
	
	/**
	 * 删除已打印医嘱（逻辑删除）
	 * @param ordPrintDOs 医嘱
	 * @return
	 * @throws BizException
	 */
	public abstract void DeleteOrdPrintDOs(OrdPrintDO[] ordPrintDOs) throws BizException;
	/**
	 * 获得人员的电子签名
	 * @param id_emps
	 * @return
	 * @throws BizException
	 */
	public abstract FMap GetEmpSignPic(String[] id_emps) throws BizException;
	
	/**
	 * 做打印操作或者清空操作时 调用执行域接口  
	 * @param id_or 本次操作的医嘱id集合
	 * @param type true为打印 false为清空
	 * @return
	 */
	public boolean PrintOrClear2MP(String[] id_ors,boolean type)throws BizException ;
	
	// ////////////////////////---------此下为新方法-----------/////////////////////////////
	/**
	 * 获取已打印的最后一条医嘱单数据
	 * 
	 * @param paramDTO
	 * @return
	 * @throws BizException
	 */
	public abstract OrdPrintDataDTO GetOrdPrintDOLastPrned(CiOrdSheetParamDTO paramDTO) throws BizException;
	
	/**
	 * 获取已清空医嘱单打印数据的最后一条
	 * @param paramDTO
	 * @return
	 * @throws BizException
	 */
	public abstract OrdPrintDataDTO GetOrdPrintDOLastCleared(CiOrdSheetParamDTO paramDTO) 
			throws BizException;

	/**
	 * 保存医嘱单打印数据
	 * 
	 * @param paramDTO
	 * @param saveDatas
	 * @return
	 * @throws BizException
	 */
	public abstract FBoolean SaveOrdPrintDOs(CiOrdSheetParamDTO paramDTO, OrdPrintDataDTO[] saveDatas) 
			throws BizException;

	/**
	 * 清空医嘱单打印数据
	 * @param paramDTO
	 * @param page_no
	 * @param row_no
	 * @return
	 * @throws BizException
	 */
	public abstract FBoolean ClearOrdPrintDOs(CiOrdSheetParamDTO paramDTO, Integer page_no, Integer row_no) 
			throws BizException;
}
