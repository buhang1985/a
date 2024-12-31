package iih.pi.reg.pat.i;

import iih.pi.reg.pat.d.PatiAggDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 患者查询分页服务
 * 
 * @author ly 2017/09/03
 *
 */
public interface IPatiRPageService {

	/**
	 * 根据分页信息及查询与分组条件获得分页数据
	 */
	public abstract PagingRtnData<PatiAggDO> findByPageInfo(PaginationInfo pg, String wherePart, String orderByPart,
			FBoolean isLazy) throws BizException;

	/**
	 * 根据查询模板条件、分页信息查询分页数据集合
	 * 
	 * @param qryRootNodeDTO
	 * @param orderStr
	 * @param pg
	 * @param isLazy
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<PatiAggDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO, String orderStr,
			PaginationInfo pg, FBoolean isLazy) throws BizException;

	/**
	 * 根据患者主键查询患者就诊卡卡号集合
	 * 
	 * @param patId 患者主键
	 * @return
	 */
	public String[] findPatEntCardCodeById(String patId) throws BizException;
	
	/**
	 * 查询患者PatiAggDO
	 * @author : hanjq 2019年10月22日 下午3:57:51
	 * @param idPat
	 * @param isLazy
	 * @return
	 * @throws BizException
	 */
	public PatiAggDO findById(String idPat) throws BizException;
}
