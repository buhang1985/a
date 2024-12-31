package iih.mi.mibd.didircomp.s;

import iih.mi.mibd.didircomp.d.DiDirCompDTO;
import iih.mi.mibd.didircomp.i.IDidircompExtCudService;
import iih.mi.mibd.didircomp.i.IDidircompExtRService;
import iih.mi.mibd.didircomp.s.bp.AutoDiCompBp;
import iih.mi.mibd.didircomp.s.bp.DelDiCompBp;
import iih.mi.mibd.didircomp.s.bp.FindDiCompBp;
import iih.mi.mibd.didircomp.s.bp.SaveDiCompBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * @ClassName: DidircompExtCrudServiceImpl
 * @Description: 医保平台_病种对照AggDO数据CRUD服务实现
 * @author: dj.zhang
 * @date: 2018年2月5日 下午6:15:54
 */
public class DidircompExtCrudServiceImpl implements IDidircompExtCudService, IDidircompExtRService {

	/**
	 * @Title: findCompDataList
	 * @Description: 病种目录对照列表查询
	 * @param qryRootNodeDTO
	 * @param misId
	 * @param pg
	 * @return PagingRtnData<DidircompDTO>
	 * @throws BizException
	 */
	@Override
	public PagingRtnData<DiDirCompDTO> findCompDataList(QryRootNodeDTO qryRootNodeDTO, String misId, PaginationInfo pg)
			throws BizException {
		FindDiCompBp bp = new FindDiCompBp();
		PagingRtnData<DiDirCompDTO> result = bp.exec(qryRootNodeDTO, misId, pg);
		return result;
	}

	/**
	 * @Title: SaveDiComp
	 * @Description: 保存对照信息
	 * @param misId
	 * @param diDirCompDtOs
	 * @return
	 */
	@Override
	public DiDirCompDTO[] saveDiComp(String misId, DiDirCompDTO[] diDirCompDtos) throws BizException {
		SaveDiCompBp bp = new SaveDiCompBp();
		DiDirCompDTO[] result = bp.exec(misId, diDirCompDtos);
		return result;
	}

	/**
	 * @Title: AutoDiComp
	 * @Description: 自动对照
	 * @param misId
	 */
	@Override
	public void autoDiComp(String misId) throws BizException {
		AutoDiCompBp bp = new AutoDiCompBp();
		bp.exec(misId);
	}

	/**
	 * @Title: delDiComp
	 * @Description: 删除对照
	 * @param misId
	 * @param diDirCompDtOs
	 * @return
	 * @throws BizException
	 */
	@Override
	public DiDirCompDTO[] delDiComp(String misId, DiDirCompDTO[] diDirCompDtOs) throws BizException {
		DelDiCompBp bp = new DelDiCompBp();
		DiDirCompDTO[] result = bp.exec(misId, diDirCompDtOs);
		return result;
	}

}
