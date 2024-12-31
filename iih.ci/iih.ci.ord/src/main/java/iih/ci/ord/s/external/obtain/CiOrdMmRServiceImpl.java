package iih.ci.ord.s.external.obtain;

import iih.ci.ord.i.external.obtain.ICiOrdMmRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;

/**
 * 需要查询在当前科室执行的所有没有缴费的医嘱信息
 * @author wangqingzhu
 *
 */
@Service(serviceInterfaces = { ICiOrdMmRService.class }, binding = Binding.JSONRPC)
public class CiOrdMmRServiceImpl implements ICiOrdMmRService {



}
