package iih.bd.srv.s;

import iih.bd.srv.i.INurmrtplExtService;
import iih.bd.srv.nurmrtpl.d.NurMrConTplCaDO;
import iih.bd.srv.s.bp.getNurMrConTplCaDOListbp;
import iih.bd.srv.s.bp.qry.deleteNurTplCabp;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

@Service(serviceInterfaces = { INurmrtplExtService.class }, binding = Binding.JSONRPC)
public class INurmrtplExtServiceImpl implements INurmrtplExtService {

	/*
	 * 获取树集合
	 */
	@Override
	public NurMrConTplCaDO[] getNurMrConTplCaDOList() throws BizException {

		getNurMrConTplCaDOListbp bp = new getNurMrConTplCaDOListbp();

		return bp.exec();
	}

	/*
	 * 删除树和内容模板集合
	 */
	@Override
	public String deleteNurTplCa(String id) throws BizException {

		deleteNurTplCabp bp = new deleteNurTplCabp();

		return bp.exec(id);
	}

}
