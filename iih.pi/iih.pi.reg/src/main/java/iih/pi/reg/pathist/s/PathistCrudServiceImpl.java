package iih.pi.reg.pathist.s;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.base.utils.SqlUtils;
import iih.pi.reg.pathist.d.PiPatHistDO;
import iih.pi.reg.pathist.d.desc.PiPatHistDODesc;
import iih.pi.reg.pathist.i.IPathistCudService;
import iih.pi.reg.pathist.i.IPathistRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.core.utils.ListUtil;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 患者关键信息变动记录AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IPathistCudService.class, IPathistRService.class }, binding = Binding.JSONRPC)
public class PathistCrudServiceImpl extends BaseDOService<PiPatHistDO> implements IPathistCudService, IPathistRService {

	public PathistCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(PiPatHistDODesc.class), IAppFwTempTbl.tmp_iaw_12.name());
	}

	@Override
	public PagingRtnData<PiPatHistDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO, String orderStr,
			PaginationInfo pg) throws BizException {
		// TODO Auto-generated method stub
		PagingRtnData<PiPatHistDO> prd = super.findByQCondAndPageInfo(qryRootNodeDTO, orderStr, pg);
		
		if (prd.getPageData().isEmpty()) {
			return prd;
		}
		
		List<String> idList = new ArrayList<>();
		for (Object obj : prd.getPageData()) {
			idList.add(((PiPatHistDO) obj).getId_pat());
		}
		
		StringBuffer sql = new StringBuffer();
		sql.append(
				" select su.name as PAT_CREATEDBY ,pp.id_pat from pi_pat pp left join sys_user su on pp.createdby = su.id_user where ");
		if (!ListUtil.isEmpty(idList)) {
			sql.append(SqlUtils.getInSqlByIds("pp.id_pat", idList));
		}
		
		List<PiPatHistDO> list = (List<PiPatHistDO>) new DAFacade().execQuery(sql.toString(),
				new BeanListHandler(PiPatHistDO.class));

		Map<String, PiPatHistDO> map = new HashMap<>();
		for (PiPatHistDO piPatHistDO : list) {
			map.put(piPatHistDO.getId_pat(), piPatHistDO);
		}

		for (Object obj : prd.getPageData()) {
			PiPatHistDO histDO = (PiPatHistDO) obj;
			PiPatHistDO createdyDo = map.get(histDO.getId_pat());
			if (createdyDo != null) {
				histDO.setPat_createdby(createdyDo.getPat_createdby());
			}
		}

		return prd;
	}
}
