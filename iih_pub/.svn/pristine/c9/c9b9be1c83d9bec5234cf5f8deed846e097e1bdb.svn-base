package iih.mp.nr.outpatskin.i;

import iih.mp.nr.dto.dbsignval.d.DbSignDTO;
import iih.mp.nr.outpatskin.d.ContentOrDTO;
import iih.mp.nr.outpatskin.d.PatSkinDTO;
import iih.mp.nr.outpatskin.d.SkinTimeDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public interface IPatientListService {
	/**
	 * 待皮试医嘱信息
	 * 
	 * @param id_ent就诊ID
	 * @param sd_entpx就诊类型
	 * @param fg_skintest皮试结果
	 * @param ci_or_srv.fg_skintest_rst是否有皮试结果
	 * @param dt_yzcreate医嘱开立时间
	 *            ....
	 * @return
	 * @throws BizException
	 */
	public abstract PatSkinDTO[] getPatientSkinTestDTOs(SkinTimeDTO paramdto, String id_pat) throws BizException;

	/**
	 * 待皮试患者数据保存
	 * 
	 * @param id_ent就诊ID
	 * @param sd_entpx就诊类型
	 * @param fg_skintest皮试结果
	 * @param ci_or_srv.fg_skintest_rst是否有皮试结果
	 * @param dt_yzcreate医嘱开立时间
	 *            ....
	 * @return
	 * @throws BizException
	 */
	public abstract void saveSkinResult(ContentOrDTO[] contentOrDTOs, DbSignDTO DbSign) throws BizException;

	/**
	 * 已皮試患者列表
	 * 
	 * @param paramdto
	 * @return
	 * @throws BizException
	 */
	public abstract PatSkinDTO[] getPatientSkinTestByTimeDTOs(SkinTimeDTO paramdto, String id_pat) throws BizException;

	/**
	 * 获得可以修改的皮试内容
	 * 
	 * @param param
	 *            查询方案中传入的查询条件DTO
	 * @return
	 * @throws BizException
	 */
	public abstract ContentOrDTO[] getSkinTestModifyData(QryRootNodeDTO param) throws BizException;

	/**
	 * 保存皮试结果修改的内容
	 * 
	 * @param contentors
	 * @return
	 * @throws BizException
	 */
	public ContentOrDTO[] saveSkinTestModifyData(ContentOrDTO[] contentors) throws BizException;
	
	/**
	 * 皮试结果录入患者列表 true皮试  false未皮试
	 * @param pg
	 * @param paramdto
	 * @param flag
	 * @param bannerParam
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<PatSkinDTO> querySkinPatList(PaginationInfo pg, SkinTimeDTO paramdto, Boolean flag, String bannerParam) throws BizException;
	
	/**
	 * 皮试结果录入选中患者查询皮试医嘱
	 * @param patInfo
	 * @param paramdto
	 * @param flag
	 * @return
	 * @throws BizException
	 */
	public ContentOrDTO[] querySkinOrderInfo(PatSkinDTO patInfo, SkinTimeDTO paramdto,Boolean flag) throws BizException;
}
