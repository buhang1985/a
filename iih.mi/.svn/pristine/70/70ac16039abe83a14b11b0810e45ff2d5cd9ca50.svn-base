package iih.mi.bd.cataloguploadrcd.s;

import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.mi.bd.cataloguploadrcd.d.desc.MiCatalogUploadRcdDODesc;
import iih.mi.bd.cataloguploadrcd.d.MiCatalogUploadRcdDO;
import iih.mi.bd.cataloguploadrcd.i.ICataloguploadrcdCudService;
import iih.mi.bd.cataloguploadrcd.i.ICataloguploadrcdRService;
import iih.mi.bd.cataloguploadrcd.s.bp.FindUseringDataBP;
import iih.mi.bd.cataloguploadrcd.s.bp.InsertRcdDoBP;

/**
 * 医保原始目录文件上传记录AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { ICataloguploadrcdCudService.class,
		ICataloguploadrcdRService.class }, binding = Binding.JSONRPC)
public class CataloguploadrcdCrudServiceImpl extends BaseDOService<MiCatalogUploadRcdDO>
		implements ICataloguploadrcdCudService, ICataloguploadrcdRService {
	public CataloguploadrcdCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(MiCatalogUploadRcdDODesc.class), IAppFwTempTbl.tmp_iaw_11.name());
	}

	/**
	 * 查询可用数据
	 * 
	 * @author zhang.hw
	 * @date 2019年5月16日
	 * @param idHp
	 * @param miSrvTp
	 * @return
	 * @throws BizException
	 */
	@Override
	public MiCatalogUploadRcdDO findUseringData(String idHp, String miSrvTp) throws BizException {
		FindUseringDataBP bp = new FindUseringDataBP();
		return bp.exec(idHp, miSrvTp);
	}

	/**
	 * 插入医保目录下载记录
	 * @author zhang.hw
	 * @date 2019年5月16日
	 * @param miCatalogUploadRcdDO
	 * @return
	 * @throws BizException
	 */
	@Override
	public FBoolean insertRcdDo(MiCatalogUploadRcdDO miCatalogUploadRcdDO) throws BizException {
		InsertRcdDoBP bp = new InsertRcdDoBP();
		return bp.exec(miCatalogUploadRcdDO);
	}

}
