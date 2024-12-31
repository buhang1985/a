package iih.mi.mibd.srvfacdircomp.s;
import iih.mi.mibd.srvfacdircomp.d.SrvfacDirCompDTO;
import iih.mi.mibd.srvfacdircomp.i.ISrvfacdircompCudService;
import iih.mi.mibd.srvfacdircomp.i.ISrvfacdircompExtCudService;
import iih.mi.mibd.srvfacdircomp.i.ISrvfacdircompExtRService;
import iih.mi.mibd.srvfacdircomp.i.ISrvfacdircompRService;
import iih.mi.mibd.srvfacdircomp.s.bp.AutoCompSrvfacBp;
import iih.mi.mibd.srvfacdircomp.s.bp.DeleteSrvfacCompBp;
import iih.mi.mibd.srvfacdircomp.s.bp.FindSrvfacCompBp;
import iih.mi.mibd.srvfacdircomp.s.bp.SaveSrvfacCompBp;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 医保平台_服务设施对照AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ISrvfacdircompCudService.class,ISrvfacdircompRService.class}, binding=Binding.JSONRPC)
public class SrvfacdircompExtCrudServiceImpl implements ISrvfacdircompExtCudService,ISrvfacdircompExtRService {

	/**
	 * 服务设施对照信息查询服务
	 * 
	 * @param qryRootNodeDto
	 * @param mis_id
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	@Override
	public PagingRtnData<SrvfacDirCompDTO> FindCompDataList(QryRootNodeDTO qryRootNodeDto, String mis_id,
			PaginationInfo pg) throws BizException {
		FindSrvfacCompBp bp = new FindSrvfacCompBp();
		PagingRtnData<SrvfacDirCompDTO> result = bp.exec(qryRootNodeDto,mis_id,pg);
		return result;
	}

	/**
	 * 服务设施保存对照服务
	 * 
	 * @param srvfacDirCompDTOs
	 * @param misId
	 * @return
	 * @throws BizException
	 */
	@Override
	public SrvfacDirCompDTO[] saveSrvfacComp(String misId, SrvfacDirCompDTO[] srvfacDirCompDTOs) throws BizException {
		SaveSrvfacCompBp bp = new SaveSrvfacCompBp();
		SrvfacDirCompDTO[] result = bp.exec(misId,srvfacDirCompDTOs);
		return result;
	}

	/**
	 * 服务设施自动对照服务
	 * 
	 * @param mis_id
	 * @return
	 * @throws BizException
	 */
	@Override
	public void autoComp(String misId) throws BizException {
		AutoCompSrvfacBp bp = new AutoCompSrvfacBp();
		bp.exec(misId);
	}

	@Override
	public SrvfacDirCompDTO[] deleteSrvfacComp(String misId, SrvfacDirCompDTO[] srvfacDirCompDTOs) throws BizException {
		DeleteSrvfacCompBp bp = new DeleteSrvfacCompBp();
		SrvfacDirCompDTO[] result = bp.exec(misId,srvfacDirCompDTOs);
		return result;
	}
	
}
