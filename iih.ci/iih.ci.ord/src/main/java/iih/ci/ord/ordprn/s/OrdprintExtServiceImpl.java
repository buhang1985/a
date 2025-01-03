package iih.ci.ord.ordprn.s;

import java.io.IOException;

import iih.ci.ord.dto.ordprintdto.d.OrdPrintDataDTO;
import iih.ci.ord.dto.ordprintdto.d.OrdPrintParamDTO;
import iih.ci.ord.ordprn.d.OrdPrintDO;
import iih.ci.ord.ordprn.dto.d.CiOrdSheetParamDTO;
import iih.ci.ord.ordprn.i.IOrdprintExtService;
import iih.ci.ord.s.bp.ordprn.ClearOrdPrintDOsBP;
import iih.ci.ord.s.bp.ordprn.GetEmpPicSignBP;
import iih.ci.ord.s.bp.ordprn.GetOrdData4PrintBP;
import iih.ci.ord.s.bp.ordprn.GetOrdPrintDOBP;
import iih.ci.ord.s.bp.ordprn.GetOrdPrintDOsPrtedBP;
import iih.ci.ord.s.bp.ordprn.GetOrdPrintPageNumsBP;
import iih.ci.ord.s.bp.ordprn.OrdPrintDODeleteBP;
import iih.ci.ord.s.bp.ordprn.OrdPrintDOResetSaveBP;
import iih.ci.ord.s.bp.ordprn.SaveOrdPrintDOsBP;
import iih.ci.ord.s.bp.ordprn.qry.GetOrdPrintDOLastPrnedQry;
import iih.mp.nr.i.IMpNrMaintanceService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 医嘱单打印服务接口
 * @author Young
 *
 */
@Service(serviceInterfaces = { IOrdprintExtService.class }, binding = Binding.JSONRPC)
public class OrdprintExtServiceImpl implements IOrdprintExtService {

	/**
	 * 获取医嘱打印对象集合
	 * @param printParam
	 * @return
	 * @throws Exception 
	 */
	@Override
	public OrdPrintDataDTO[] GetOrdPrintDataDTOs(OrdPrintParamDTO printParam) throws Exception {

		GetOrdData4PrintBP bp = new GetOrdData4PrintBP();
		try {
			return bp.exec(printParam);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 查询已打印的数据
	 * @param paramDTO
	 * @return
	 * @throws BizException
	 */
	public OrdPrintDO[] GetOrdPrintDOsPrted(OrdPrintParamDTO paramDTO) throws BizException {
		GetOrdPrintDOsPrtedBP bp=new GetOrdPrintDOsPrtedBP();
		return bp.exec(paramDTO);
	}

	/**
	 * 获取已打印医嘱的页码集合
	 * @param paramDTO
	 * @return
	 * @throws BizException
	 */
	@Override
	public int[] GetPageNums(OrdPrintParamDTO paramDTO) throws BizException {
		GetOrdPrintPageNumsBP bp = new GetOrdPrintPageNumsBP();
		return bp.exec(paramDTO);
	}

	/**
	 * 根据待打印医嘱，获取对应已打印医嘱中所在页的数据
	 * @param paramDTO 就诊id、长临标识
	 * @param printDataDTOs 待打印医嘱
	 * @return 已打印医嘱（返回需要打印所在页的全部已打印医嘱）
	 * @throws BizException
	 */
	@Override
	public OrdPrintDO[] GetOrdPrintDOs(OrdPrintParamDTO paramDTO, OrdPrintDataDTO[] printDataDTOs) throws BizException {
		GetOrdPrintDOBP bp = new GetOrdPrintDOBP();
		return bp.exec(paramDTO, printDataDTOs);
	}

	/**
	 * 保存重置打印医嘱
	 * @param paramDTO
	 * @param ordPrintDOs 重整后待打印的医嘱
	 * @return
	 * @throws BizException
	 */
	@Override
	public void SaveResetOrdPrintDOs(OrdPrintParamDTO paramDTO, OrdPrintDO[] printDOs) throws BizException {
		OrdPrintDOResetSaveBP bp = new OrdPrintDOResetSaveBP();
		bp.exec(paramDTO, printDOs);
	}
	
	/**
	 * 删除已打印医嘱（逻辑删除）
	 * @param ordPrintDOs 医嘱
	 * @return
	 * @throws BizException
	 */
	@Override
	public void DeleteOrdPrintDOs(OrdPrintDO[] ordPrintDOs) throws BizException {
		OrdPrintDODeleteBP bp = new OrdPrintDODeleteBP();
		bp.exec(ordPrintDOs);
	}
	/**
	 * 获得人员的电子签名
	 */
	@Override
	public FMap GetEmpSignPic(String[] id_emps) throws BizException {
		GetEmpPicSignBP bp = new GetEmpPicSignBP();
		return bp.exec(id_emps);
	}
	@Override
	public boolean PrintOrClear2MP(String[] id_ors, boolean type)  {
		boolean fg = false;
		
		try{
		    fg = ServiceFinder.find(IMpNrMaintanceService.class).updateOrPrntStatus(id_ors, new FBoolean(type));
			
		}catch(Exception e){
			e.printStackTrace();
			fg = false;
		}
		return fg;
	}
	
	// ////////////////////////---------此下为新方法-----------/////////////////////////////
	/**
	 * 获取已打印的最后一条医嘱单数据
	 * 
	 * @param paramDTO
	 * @return
	 * @throws BizException
	 */
	@Override
	public OrdPrintDataDTO GetOrdPrintDOLastPrned(CiOrdSheetParamDTO paramDTO)
			throws BizException {
		GetOrdPrintDOLastPrnedQry qry = new GetOrdPrintDOLastPrnedQry(paramDTO);
		OrdPrintDataDTO[] ordPrintDTOs = (OrdPrintDataDTO[]) AppFwUtil.getDORstWithDao(qry, OrdPrintDataDTO.class);
		return ordPrintDTOs != null && ordPrintDTOs.length > 0 ? ordPrintDTOs[0] : null;
	}

	/**
	 * 保存医嘱单打印数据
	 * 
	 * @param paramDTO
	 * @param saveDatas
	 * @return
	 * @throws BizException
	 */
	@Override
	public FBoolean SaveOrdPrintDOs(CiOrdSheetParamDTO paramDTO, OrdPrintDataDTO[] saveDatas) throws BizException {
		SaveOrdPrintDOsBP bp = new SaveOrdPrintDOsBP();
		return bp.exec(paramDTO, saveDatas);
	}

	/**
	 * 清空医嘱单打印数据
	 * 
	 * @param paramDTO
	 * @param page_no
	 * @param row_no
	 * @return
	 * @throws BizException
	 */
	@Override
	public FBoolean ClearOrdPrintDOs(CiOrdSheetParamDTO paramDTO, Integer page_no, Integer row_no) throws BizException {
		ClearOrdPrintDOsBP bp = new ClearOrdPrintDOsBP();
		return bp.exec(paramDTO, page_no, row_no);
	}

	@Override
	public OrdPrintDataDTO GetOrdPrintDOLastCleared(CiOrdSheetParamDTO paramDTO) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}
}
