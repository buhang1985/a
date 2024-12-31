package iih.mp.nr.partogramcollect.i;

import iih.mp.nr.opuvsigncollect.d.SignsItmDTO;
import iih.mp.nr.partogramcollect.d.PartTreeDTO;
import iih.mp.nr.partogramcollect.d.Partcarddto;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;

public interface IPartogramcollectService {
	/**
	 * 查詢體征表數據以樹的形式展示
	 * @param id_ent
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	public abstract PartTreeDTO[] getVisTreeDTOS(String id_ent,Partcarddto dto) throws BizException;
	/**
	 * 刪除树节点体征数据
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	public abstract String delete(PartTreeDTO dto) throws BizException;
	/**
	 * 判断是否存在数据，存在的话返回主键
	 * @param id_ent
	 * @param dt_vt
	 * @return
	 * @throws BizException
	 */
	public abstract String find(String id_ent,FDateTime dt_vt) throws BizException; 

	/**
	 * 门急诊体征保存
	 * 
	 * @param ListSaveDTOS
	 * @return
	 * @throws BizException
	 */
	public abstract String VatilSignSave(String Id_mrtpl, String Name_mrtpl, SignsItmDTO[] DTOS) throws BizException;
}
