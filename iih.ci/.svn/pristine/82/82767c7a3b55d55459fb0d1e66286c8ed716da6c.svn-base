package iih.ci.mrm.s.qmpareport;

import iih.ci.mrm.cimrmdirheareportdto.d.CiMrmDirHeaReportDTO;
import iih.ci.mrm.i.qmpareport.IMrmReportCSVService;
import iih.ci.mrm.s.qmpareport.bp.MrmGenerateByteBp;
import iih.ci.mrm.s.qmpareport.bp.MrmGenerateCSVBp;

import java.util.List;

import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

@Service(serviceInterfaces = { IMrmReportCSVService.class }, binding = Binding.JSONRPC)
public class MrmReportCSVServiceImpl implements IMrmReportCSVService {

	// 生成csv文件
	@SuppressWarnings("static-access")
	@Override
	public String getCSVByte(QryRootNodeDTO qryRootNodeDTO) throws BizException {
		MrmGenerateCSVBp csvbp = new MrmGenerateCSVBp();
		MrmGenerateByteBp cimrmbyte = new MrmGenerateByteBp();
		List<CiMrmDirHeaReportDTO> lists = csvbp.getDatas(qryRootNodeDTO, "1=1");
		String[] fs = csvbp.getHeaders();
		byte[] bytes = cimrmbyte.writeCSVByDTOs(lists, fs);
		// return Base64.getEncoder().encodeToString(bytes);
		return fastdfs.concurrent.Base64.bytes2string(bytes);
	}

	// 生成csv文件
	public CiMrmDirHeaReportDTO[] getCSVReportDTO(QryRootNodeDTO qryRootNodeDTO, String sqlWhere) throws BizException {
		MrmGenerateCSVBp csvbp = new MrmGenerateCSVBp();
		List<CiMrmDirHeaReportDTO> lists = csvbp.getDatas(qryRootNodeDTO, sqlWhere);
		
		if (lists == null || lists.size() <= 0)
			return new CiMrmDirHeaReportDTO[] {};
		else {
			CiMrmDirHeaReportDTO[] arrReportDTOs = new CiMrmDirHeaReportDTO[lists.size()];
			return lists.toArray(arrReportDTOs);
		}
	}

}
