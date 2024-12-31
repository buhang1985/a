package iih.ci.mrm.cimrmdirheareportdto.s;

import java.util.ArrayList;
//import java.util.Base64;
import java.util.Collections;
import java.util.List;

import fastdfs.concurrent.Base64;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bl.st.blstip.d.BlStIpDO;
import iih.bl.st.blstip.i.IBlstipRService;
import iih.ci.mrm.cimrmdirheareportdto.d.CiMrmDirHeaReportDTO;
import iih.ci.mrm.cimrmdirheareportdto.i.ICiMrmRepoDBFService;
import iih.ci.mrm.cimrmdirheareportdto.s.bp.CiMrmGenerateByteBp;
import iih.ci.mrm.cimrmdirheareportdto.s.bp.CiMrmGenerateCSVBp;
import iih.ci.mrm.cimrmdirheareportdto.s.bp.CiMrmGenerateDBFBp;
import iih.ci.mrm.cimrmdirheareportdto.s.bp.CiMrmGenerateListBp;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

@Service(serviceInterfaces={ICiMrmRepoDBFService.class}, binding=Binding.JSONRPC)
public class CiMrmRepoDBFServiceImpl implements ICiMrmRepoDBFService{

	@Override
	//生成dbf文件
	public String getDBFFile(QryRootNodeDTO qryRootNodeDTO) throws BizException {
		CiMrmGenerateCSVBp csvbp = new CiMrmGenerateCSVBp();
		List<CiMrmDirHeaReportDTO> lists = csvbp.getDatas(qryRootNodeDTO,"1=1");
		 String[] fs = csvbp.getHeaders();	
		CiMrmGenerateByteBp cimrmbyte = new CiMrmGenerateByteBp();
		byte[] bytes = cimrmbyte.writeDBF(lists, fs);
		//return Base64.getEncoder().encodeToString(bytes);
		return Base64.bytes2string(bytes);
	}

}
