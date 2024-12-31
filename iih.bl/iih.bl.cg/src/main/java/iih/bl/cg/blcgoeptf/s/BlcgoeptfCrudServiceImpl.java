package iih.bl.cg.blcgoeptf.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FDouble;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.cg.blcgoeptf.d.desc.BlCgItmOepTfRcdDODesc;
import iih.bl.cg.blcgoeptf.d.BlCgItmOepTfRcdDO;
import iih.bl.cg.blcgoeptf.i.IBlcgoeptfCudService;
import iih.bl.cg.blcgoeptf.i.IBlcgoeptfRService;
import iih.bl.cg.blcgoeptf.s.bp.FindoeptfrcdInfoBp;
import iih.bl.cg.blcgoeptf.s.bp.QueryIpStAmtBp;
import iih.bl.cg.blcgquery.d.BlCgIpDO;


/**
 * 门诊记账转移记录AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBlcgoeptfCudService.class,IBlcgoeptfRService.class}, binding=Binding.JSONRPC)
public class BlcgoeptfCrudServiceImpl extends BaseDOService<BlCgItmOepTfRcdDO> implements IBlcgoeptfCudService,IBlcgoeptfRService {
    public BlcgoeptfCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlCgItmOepTfRcdDODesc.class),IAppFwTempTbl.tmp_iaw_07.name()); 
    }

	@Override
	public BlCgIpDO[] queryIpStAmt(String ident) throws BizException {
		QueryIpStAmtBp bp = new QueryIpStAmtBp();
		return bp.exec(ident);
	}

	/**
	 * 门诊退费时查询可退费用
	 * @author zhang.hw
	 * @date 2020年4月29日
	 * @param idoepcgitms
	 * @return
	 * @throws BizException
	 */
	@Override
	public BlCgItmOepTfRcdDO[] findoeptfrcdInfo(String[] idoepcgitms) throws BizException {
		FindoeptfrcdInfoBp bp = new FindoeptfrcdInfoBp();
		return bp.exec(idoepcgitms);
	}
}
