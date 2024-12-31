package iih.ci.mrm.s.qmpareport;

import fastdfs.concurrent.Base64;
import iih.ci.mrm.cimrmdirheareportdto.d.CiMrmDirHeaReportDTO;
import iih.ci.mrm.i.qmpareport.IMrmReportDBFService;
import iih.ci.mrm.s.qmpareport.bp.MrmGenerateByteBp;
import iih.ci.mrm.s.qmpareport.bp.MrmGenerateCSVBp;

import java.util.List;

import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

@Service(serviceInterfaces = { IMrmReportDBFService.class }, binding = Binding.JSONRPC)
public class MrmReportDBFServiceImpl implements IMrmReportDBFService {

	// 生成dbf文件
	@SuppressWarnings("static-access")
	@Override
	public String getDBFFile(QryRootNodeDTO qryRootNodeDTO) throws BizException {
		MrmGenerateCSVBp csvbp = new MrmGenerateCSVBp();
		MrmGenerateByteBp cimrmbyte = new MrmGenerateByteBp();
		List<CiMrmDirHeaReportDTO> lists = csvbp.getDatas(qryRootNodeDTO, "1=1");
		String[] fs = csvbp.getHeaders();
		byte[] bytes = cimrmbyte.writeDBF(lists, fs);
		// return Base64.getEncoder().encodeToString(bytes);
		return Base64.bytes2string(bytes);
	}

}
