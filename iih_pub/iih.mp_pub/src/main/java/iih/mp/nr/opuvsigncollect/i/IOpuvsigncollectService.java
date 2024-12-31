package iih.mp.nr.opuvsigncollect.i;

import iih.mp.nr.opuvsigncollect.d.OpuvsigncollectTreeDTO;
import iih.mp.nr.opuvsigncollect.d.OpuvsigncollectcardDTO;
import iih.mp.nr.opuvsigncollect.d.SignsItmDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;

public interface IOpuvsigncollectService {

	/**
	 * 查询门诊患者信息
	 * 
	 * @param type
	 * @param key
	 * @return
	 * @throws BizException
	 */
	public abstract OpuvsigncollectcardDTO[] getCardDTO(String type, String key) throws BizException;

	/**
	 * 查询体征表信息以树的形式显示
	 * 
	 * @param id_ent
	 * @param date
	 * @return
	 * @throws BizException
	 */
	public abstract OpuvsigncollectTreeDTO[] getTreeDTOS(String id_ent, FDate date) throws BizException;

	/**
	 * 删除树节点即体征数据
	 * 
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	public abstract String delete(OpuvsigncollectTreeDTO dto) throws BizException;

	public abstract String find(String id_ent, FDateTime dt_vt) throws BizException;

	/**
	 * 门急诊体征保存
	 * 
	 * @param ListSaveDTOS
	 * @return
	 * @throws BizException
	 */
	// public abstract CiMrDO VatilSignSave(CiMrDO CImrDO,CimrvtAggDO
	// AggDO)throws BizException;
	public abstract String VatilSignSave(String Id_mrtpl, String Name_mrtpl, SignsItmDTO[] DTOS) throws BizException;
}
