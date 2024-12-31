package iih.bd.pp.storage.s;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import iih.bd.base.utils.FileServerUtils;
import iih.bd.pp.storage.i.IStorageService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

/**
 * 文件服务
 * 
 * @author hao_wu
 *
 */
@Service(serviceInterfaces={IStorageService.class}, binding=Binding.JSONRPC)
public class StorageServiceImpl implements IStorageService {

	@Override
	public String Write(String fileId, byte[] fileContent, boolean isBizGrp) throws BizException {
		InputStream inputStream = new ByteArrayInputStream(fileContent);
		String newFileId = FileServerUtils.Upload(fileId, inputStream, isBizGrp);
		return newFileId;
	}

}
