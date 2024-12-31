package iih.bd.fc.mdwfcfg.s;

import iih.bd.fc.mdwfcfg.d.MdwftreeDTO;
import iih.bd.fc.mdwfcfg.i.IMdwfcfgTreeService;
import iih.bd.fc.mdwfcfg.s.bp.deletebp;
import iih.bd.fc.mdwfcfg.s.bp.getListbp;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

@Service(serviceInterfaces = { IMdwfcfgTreeService.class }, binding = Binding.JSONRPC)
public class IMdwfcfgTreeServiceImpl implements IMdwfcfgTreeService {

	/*
	 * 获取个性化医嘱流向树列表 李俊明 2016-3-23 16:23:58
	 */
	@Override
	public MdwftreeDTO[] getList() throws BizException {

		getListbp bp = new getListbp();

		return bp.exec();
	}

	/*
	 * 根据MdwftreeDTO删除医嘱流向分类/医嘱流向 / 医嘱流向开立参数   李俊明  2016-3-26 18:22:38
	 * @see iih.bd.fc.mdwfcfg.i.IMdwfcfgTreeService#delete(iih.bd.fc.mdwfcfg.d.MdwftreeDTO)
	 */
	@Override
	public String delete(MdwftreeDTO DTO) throws BizException {

		deletebp bp=new deletebp();
		
		bp.exec(DTO);	
		
		return "1";
	}

}
