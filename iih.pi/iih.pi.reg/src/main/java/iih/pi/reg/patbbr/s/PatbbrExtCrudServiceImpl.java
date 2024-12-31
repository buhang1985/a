package iih.pi.reg.patbbr.s;
import iih.pi.reg.patbbr.d.PiPatBbrDO;
import iih.pi.reg.patbbr.d.desc.PiPatBbrDODesc;
import iih.pi.reg.patbbr.i.IPatbbrExtCudService;
import iih.pi.reg.patbbr.s.bp.PiPatBbrCloseBp;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IPatbbrExtCudService.class}, binding=Binding.JSONRPC)
public class PatbbrExtCrudServiceImpl extends BaseDOService<PiPatBbrDO> implements IPatbbrExtCudService{

    public PatbbrExtCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(PiPatBbrDODesc.class),IAppFwTempTbl.tmp_iaw_19.name()); 
    }

	@Override
	public PiPatBbrDO[] Close(PiPatBbrDO[] pipatBbrs) throws BizException {
		PiPatBbrCloseBp bp = new PiPatBbrCloseBp();
		PiPatBbrDO[] result = bp.exec(pipatBbrs);
		return result;
	}
}

