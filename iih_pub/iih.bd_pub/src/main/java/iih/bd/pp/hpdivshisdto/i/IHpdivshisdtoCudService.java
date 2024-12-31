package iih.bd.pp.hpdivshisdto.i;

import iih.bd.pp.hpdivshisdto.d.HpDiVsHisDTO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAException;

/**
 * 医保病种目录对照Cud服务
 * 
 * @author hao_wu
 *
 */
public interface IHpdivshisdtoCudService {
	/**
	 * dto保存
	 * 
	 * @param dtoArr
	 * @return
	 * @throws BizException
	 */
	public HpDiVsHisDTO[] dtoSave(HpDiVsHisDTO[] hpDiVsHisDTOs) throws BizException;

	/**
	 * dto删除
	 * 
	 * @param hpDiVsHisDTO
	 * @throws DAException
	 */
	public void dtoDelete(HpDiVsHisDTO[] hpDiVsHisDTOs) throws DAException;

	/**
	 * 保存医保病种目录对照数据
	 * 
	 * @param hpDiVsHisDtos
	 *            需要保存的医保病种目录对照数据
	 * @return 保存后的医保病种目录对照数据
	 * @throws BizException
	 */
	public abstract HpDiVsHisDTO[] SaveHpDiVsHisData(HpDiVsHisDTO[] hpDiVsHisDtos) throws BizException;

	/**
	 * 删除医保病种目录对照数据
	 * 
	 * @param hpDiVsHisDtos
	 *            需要保存的医保病种目录对照数据
	 * @return 删除后的医保病种目录对照数据
	 * @throws BizException
	 */
	public abstract HpDiVsHisDTO[] DeleteHpDiVsHisData(HpDiVsHisDTO[] hpDiVsHisDtos) throws BizException;

	/**
	 * 自动对照医保病种目录
	 * 
	 * @throws BizException
	 */
	public abstract void AutoCompInsurDi(String idHp) throws BizException;

	/**
	 * 清空医保病种目录对照
	 * 
	 * @throws BizException
	 */
	public abstract void ClearDiComp() throws BizException;
}
