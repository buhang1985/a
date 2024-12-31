package iih.ci.ord.s.external.provide;

import iih.ci.ord.i.external.provide.ICiOrdBlHpService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;

/**
 * 医保新平台对接接口
 * 
 * @author zhangwq
 *
 */
@Service(serviceInterfaces = { ICiOrdBlHpService.class }, binding = Binding.JSONRPC)
public class CiOrdBlHpServiceImpl implements ICiOrdBlHpService {

}
