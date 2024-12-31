package iih.mi.mibd.mis.s;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import iih.mi.mibd.mis.d.MisDO;
import iih.mi.mibd.mis.d.desc.MisDODesc;
import iih.mi.mibd.mis.i.IMisRExtService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 医保平台_医保系统扩展服务实现
 */
@Service(serviceInterfaces = { IMisRExtService.class }, binding = Binding.JSONRPC)
public class MisCrudServiceExtImpl extends BaseDOService<MisDO> implements IMisRExtService {
	public MisCrudServiceExtImpl() {
		super(DescManager.getInstance().getDODesc(MisDODesc.class), IAppFwTempTbl.tmp_iaw_14.name());
	}

	@SuppressWarnings("unchecked")
	@Override
	public MisDO[] findAllMisDOsWithFactoryInst() throws BizException {
		String qrySql = "select ms.*,ps.value factoryinst from mi_bd_mis ms left outer join sys_paramset ps on ms.id_mis = ps.id_instance";
		List<MisDO> misDOList = (List<MisDO>) new DAFacade().execQuery(qrySql, new BeanListHandler(MisDO.class));
		return CollectionUtils.isEmpty(misDOList) ? null : misDOList.toArray(new MisDO[0]);
	}

}
