package iih.bl.inc.blecinccomp.s;
import iih.bl.inc.blecinccomp.d.BlEcIncCompDO;
import iih.bl.inc.blecinccomp.d.desc.BlEcIncCompDODesc;
import iih.bl.inc.blecinccomp.dto.d.BlecIncCompDTO;
import iih.bl.inc.blecinccomp.i.IBlecinccompCudService;
import iih.bl.inc.blecinccomp.i.IBlecinccompRService;
import iih.bl.inc.blecinccomp.s.bp.FindIncCompDataListBP;
import iih.bl.inc.blecinccomp.s.bp.RefreshCompBP;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.xbd.udi.d.UdidocDO;


/**
 * 电子票据对照AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBlecinccompCudService.class,IBlecinccompRService.class}, binding=Binding.JSONRPC)
public class BlecinccompCrudServiceImpl extends BaseDOService<BlEcIncCompDO> implements IBlecinccompCudService,IBlecinccompRService {
    public BlecinccompCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlEcIncCompDODesc.class),IAppFwTempTbl.tmp_iaw_16.name()); 
    }

    /***
     * 查询电子发票对应的账单项信息
     * @author zhang.hw
     * @date 2020年2月12日
     * @param id_udidoc
     * @param pg
     * @return
     * @throws BizException
     */
	@Override
	public PagingRtnData<BlecIncCompDTO> FindIncCompDataList(String id_udidoc, PaginationInfo pg) throws BizException {
		FindIncCompDataListBP bp = new FindIncCompDataListBP();
		return bp.exec(id_udidoc, pg);
	}

	/**
	 * 刷新对照
	 * @author zhang.hw
	 * @date 2020年2月12日
	 * @param udidocDO
	 * @return
	 * @throws BizException
	 */
	@Override
	public FBoolean refreshComp(UdidocDO udidocDO) throws BizException {
		RefreshCompBP bp = new RefreshCompBP();
		return bp.exec(udidocDO);
	}
}
