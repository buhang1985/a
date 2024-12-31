package iih.mi.bd.miudidoc.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.mi.bd.miudidoc.d.desc.MiUdidocDODesc;
import iih.mi.bd.d.MiudidocDTO;
import iih.mi.bd.miudidoc.d.MiUdidocDO;
import iih.mi.bd.miudidoc.i.IMiudidocCudService;
import iih.mi.bd.miudidoc.i.IMiudidocRService;
import iih.mi.bd.miudidoc.s.bp.ImportExcelDataBp;


/**
 * 医保档案AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMiudidocCudService.class,IMiudidocRService.class}, binding=Binding.JSONRPC)
public class MiudidocCrudServiceImpl extends BaseDOService<MiUdidocDO> implements IMiudidocCudService,IMiudidocRService {
    public MiudidocCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MiUdidocDODesc.class),IAppFwTempTbl.tmp_iaw_19.name()); 
    }
    
	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}
	
	/**
	 * 导入Excel数据
	 * @author zhang.hw
	 * @date 2019年5月22日
	 * @param miUdidocDOs
	 * @return
	 * @throws BizException
	 */
	@Override
	public void importData(MiudidocDTO[] miUdidocDTOs,String idhp) throws BizException {
		ImportExcelDataBp bp = new ImportExcelDataBp();
		bp.exec(miUdidocDTOs,idhp);
	}

}
