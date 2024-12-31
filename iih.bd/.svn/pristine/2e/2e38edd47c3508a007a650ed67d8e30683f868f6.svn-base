package iih.bd.fc.mdwfcfg.s.bp;

import iih.bd.fc.mdwfcfg.d.MdwftreeDTO;
import iih.bd.fc.mdwfconfig.d.MdWfCaDO;
import iih.bd.fc.mdwfconfig.d.MdWfDO;
import iih.bd.fc.mdwfconfig.i.IMdWfDOCudService;
import iih.bd.fc.mdwfconfig.i.IMdWfDORService;
import iih.bd.fc.mdwfconfig.i.IMdwfconfigMDOCudService;
import iih.bd.fc.mdwfconfig.i.IMdwfconfigMDORService;
import iih.bd.fc.mdwfor.d.MdWfOrDO;
import iih.bd.fc.mdwfor.i.IMdwforCudService;
import iih.bd.fc.mdwfor.i.IMdwforRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class deletebp {

	public void exec(MdwftreeDTO DTO) throws BizException {

		// 查询服务
		IMdwfconfigMDORService CaFindService = ServiceFinder.find(IMdwfconfigMDORService.class);

		IMdWfDORService ItmFindService = ServiceFinder.find(IMdWfDORService.class);

		IMdwforRService MdforFindService = ServiceFinder.find(IMdwforRService.class);

		// 保存服务
		IMdwfconfigMDOCudService CaSaveService = ServiceFinder.find(IMdwfconfigMDOCudService.class);

		IMdWfDOCudService ItmSaveService = ServiceFinder.find(IMdWfDOCudService.class);

		IMdwforCudService MdforSaveService = ServiceFinder.find(IMdwforCudService.class);

		if (DTO.getFg_parent().equals(FBoolean.TRUE)) {

			// 删除分类
			MdWfCaDO CaDO = CaFindService.findById(DTO.getId());
			
			CaSaveService.delete(new MdWfCaDO[] { CaDO });

		} else {

			MdWfDO wfDO = ItmFindService.findById(DTO.getId());
						
			MdWfOrDO[] mdwfordos = MdforFindService.find(" a0.id_wf='" + DTO.getId() + "'", "", FBoolean.FALSE);

			if (mdwfordos != null && mdwfordos.length > 0) {

				MdforSaveService.delete(mdwfordos);
			}
			ItmSaveService.delete(new MdWfDO[] { wfDO });
		}
	}
}
