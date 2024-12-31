package iih.mp.nr.visgncollectsingle.i;

import java.util.HashMap;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvVtDO;
import iih.ci.mr.cimr.d.CiMrDO;
import iih.mp.nr.visgncollectsingle.d.VisgnsingleCarddto;
import iih.mp.nr.visgncollectsingle.d.VisgnsingleTreeDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;

public interface IVsigncollectsingleService {
	/**
	 * 查詢體征表數據以樹的形式展示
	 * @param id_ent
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	public abstract VisgnsingleTreeDTO[] getVisTreeDTOS(String id_ent,VisgnsingleCarddto dto) throws BizException;
	/**
	 * 刪除树节点体征数据
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	public abstract String delete(VisgnsingleTreeDTO dto) throws BizException;
	/**
	 * 判断是否存在数据，存在的话返回主键
	 * @param id_ent
	 * @param dt_vt
	 * @return
	 * @throws BizException
	 */
	public abstract String find(String id_ent,FDateTime dt_vt) throws BizException; 
	
	/**
	 * 获取自定义体征项目
	 * @param Id_mrtplvt
	 * @return
	 */
	public abstract MedSrvVtDO[] getRefSrvvt(String id_mrtplvt) throws BizException;
	
	/**
	 * 移动端接口用，初始化医疗记录
	 * @param id_ents
	 * @param id_mrtpl_vst
	 * @return
	 * @throws BizException
	 */
	public abstract CiMrDO initCimrInfo(String id_ents, String id_mrtpl_vst) throws BizException;
}
