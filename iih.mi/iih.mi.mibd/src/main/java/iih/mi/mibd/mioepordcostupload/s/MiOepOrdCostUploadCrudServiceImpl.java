package iih.mi.mibd.mioepordcostupload.s;

import iih.mi.mibd.mioepordcostupload.d.MiOepOrdCostUploadDTO;
import iih.mi.mibd.mioepordcostupload.i.MiOepOrdCostUploadCrudService;
import iih.mi.mibd.mioepordcostupload.s.bp.QueryOepOrdCostUploadDatasBp;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

@Service(serviceInterfaces = { MiOepOrdCostUploadCrudService.class }, binding = Binding.JSONRPC)
public class MiOepOrdCostUploadCrudServiceImpl implements MiOepOrdCostUploadCrudService {

	/**
	 * 查询门诊医嘱控费数据
	 * @author zhang.hw
	 * @date 2020年4月21日
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	@Override
	public MiOepOrdCostUploadDTO[] queryOepOrdCostUploadDatas(QryRootNodeDTO queryNode) throws BizException {
		QueryOepOrdCostUploadDatasBp bp = new QueryOepOrdCostUploadDatasBp();
		return bp.exec(queryNode);
	}

}
