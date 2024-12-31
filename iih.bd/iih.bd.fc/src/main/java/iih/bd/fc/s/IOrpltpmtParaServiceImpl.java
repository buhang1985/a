package iih.bd.fc.s;

import iih.bd.fc.i.IOrpltpmtParaService;
import iih.bd.fc.ormatchorpltp.d.OrpltpMatchParamDTO;
import iih.bd.fc.orpltp.d.OrpltpDO;
import iih.bd.fc.orpltp.d.OrpltpStaDO;
import iih.bd.fc.orpltpfunparam.d.OrpltpFunDTO;
import iih.bd.fc.orpltpstafunc.d.OrpltpStaFuncDO;
import iih.bd.fc.s.bp.GetIdOrpltpsByFuncodeBp;
import iih.bd.fc.s.bp.orpltpfun.GetOrpltpFunBp;
import iih.bd.fc.s.bp.orpltpmatch.GetOrpMatchBp;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

@Service(serviceInterfaces = { IOrpltpmtParaService.class }, binding = Binding.JSONRPC)
public class IOrpltpmtParaServiceImpl implements IOrpltpmtParaService {

	/**
	 * 传入参数获取医嘱闭环
	 * */
	@Override
	public OrpltpDO[] GetOrpltp(OrpltpMatchParamDTO orpltpMatParDTO) throws BizException {
//		GetOrderOrpltpBp bp=new GetOrderOrpltpBp();
//		return bp.exec(orpltpMatParDTO);
//		GetOrpltpMatchBp bp = new GetOrpltpMatchBp();
//		OrpltpDO rtn = bp.exec(orpltpMatParDTO);
//		return new OrpltpDO[] { rtn };
		GetOrpMatchBp bp = new GetOrpMatchBp();
		return  bp.ordltpMatch(orpltpMatParDTO);
	}

	/**
	 * 医嘱执行闭环节点状态匹配
	 */
	@Override
	public OrpltpStaDO[] GetOrpltpFun(OrpltpFunDTO[] DTO) throws BizException {
		GetOrpltpFunBp bp = new GetOrpltpFunBp();
		return bp.exec(DTO);
	}

	/**
	 * 根据节点编码获取闭环类型ID集合
	 */
	@Override
	public OrpltpStaFuncDO[] getIdOrpltpsByFuncode(String funcode) throws BizException {
		GetIdOrpltpsByFuncodeBp bp = new GetIdOrpltpsByFuncodeBp();
		return bp.exec(funcode);
	}
}
