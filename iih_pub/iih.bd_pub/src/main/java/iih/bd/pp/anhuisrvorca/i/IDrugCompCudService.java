package iih.bd.pp.anhuisrvorca.i;

import java.text.ParseException;

import iih.bd.pp.anhuisrvorca.d.DrugCompDTO;
import xap.mw.core.data.BizException;

/**
 * 医保药品对照CUD服务
 * 
 * @author hao_wu
 *
 */
public interface IDrugCompCudService {
	/**
	 * 保存药品对照
	 * 
	 * @param drugCompDTOs
	 *            药品对照信息
	 * @throws BizException
	 * @throws ParseException
	 */
	public abstract DrugCompDTO[] SaveDrugComp(DrugCompDTO[] drugCompDTOs) throws BizException;

	/**
	 * 删除药品对照
	 * 
	 * @param drugCompDTOs
	 * @throws BizException
	 */
	public abstract DrugCompDTO[] DeleteDrugComp(DrugCompDTO[] drugCompDTOs) throws BizException;

	/**
	 * 自动对照
	 * 
	 * @throws BizException
	 */
	public abstract void AutoComp(String hpCode) throws BizException;
	
	/**
	 * 刷新对照
	 * 
	 * @throws BizException
	 */
	public abstract void RefreshComp(String hpCode) throws BizException;
	
	/**
	 * 医保上传撤销
	 * @param drugCompDTOs
	 * @return
	 * @throws BizException
	 */
	public abstract DrugCompDTO[] RevokeMediReport(DrugCompDTO[] drugCompDTOs) throws BizException;
	/**
	 * 设为自费
	 * @param drugCompDTOs
	 * @return
	 * @throws BizException
	 */
	public abstract String[] setOwnExpense(DrugCompDTO[] drugCompDTOs) throws BizException;
	/**
	 * 取消自费
	 * @param drugCompDTOs
	 * @return
	 * @throws BizException
	 */
	public abstract String[] canCleOwnExpense(DrugCompDTO[] drugCompDTOs) throws BizException;
}
