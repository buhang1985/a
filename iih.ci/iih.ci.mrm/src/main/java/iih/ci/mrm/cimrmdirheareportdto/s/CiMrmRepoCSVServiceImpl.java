package iih.ci.mrm.cimrmdirheareportdto.s;

import java.util.ArrayList;
//import java.util.Base64;
import java.util.Collections;
import java.util.List;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bl.st.blstip.d.BlStIpDO;
import iih.bl.st.blstip.i.IBlstipRService;
import iih.ci.mrm.bp.common.CiMrMParamUtils;
import iih.ci.mrm.cimrmdirheareportdto.d.CiMrmDirHeaReportDTO;
import iih.ci.mrm.cimrmdirheareportdto.i.ICiMrmRepoCSVService;
import iih.ci.mrm.cimrmdirheareportdto.s.bp.CiMrmGenerateByteBp;
import iih.ci.mrm.cimrmdirheareportdto.s.bp.CiMrmGenerateListBp;
import iih.ci.mrm.cimrmdirheareportdto.s.bp.CiMrmGenerateCSVBp;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.service.constant.Binding;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

@Service(serviceInterfaces={ICiMrmRepoCSVService.class}, binding=Binding.JSONRPC)
public class CiMrmRepoCSVServiceImpl implements ICiMrmRepoCSVService{

	
	@Override
	//生成csv文件
	public String getCSVByte( QryRootNodeDTO qryRootNodeDTO) throws BizException {
		
		CiMrmGenerateCSVBp csvbp = new CiMrmGenerateCSVBp();
		List<CiMrmDirHeaReportDTO> lists = csvbp.getDatas(qryRootNodeDTO,"1=1");
		 String[] fs = csvbp.getHeaders();		  
		CiMrmGenerateByteBp cimrmbyte = new CiMrmGenerateByteBp();
		byte[] bytes = cimrmbyte.writeCSVByDTOs(lists, fs);
		//return Base64.getEncoder().encodeToString(bytes);
			return fastdfs.concurrent.Base64.bytes2string(bytes);
	}
	
	//生成csv文件
	public CiMrmDirHeaReportDTO[] getCSVReportDTO( QryRootNodeDTO qryRootNodeDTO,String sqlWhere) throws BizException {
		
		CiMrmGenerateCSVBp csvbp = new CiMrmGenerateCSVBp();
		List<CiMrmDirHeaReportDTO> lists = csvbp.getDatas(qryRootNodeDTO,sqlWhere);
		if(lists == null||lists.size()<=0) return new CiMrmDirHeaReportDTO[]{};
		else
		{
			CiMrmDirHeaReportDTO[] arrReportDTOs = new CiMrmDirHeaReportDTO[lists.size()];
			return  lists.toArray(arrReportDTOs);	
		}
	}
	
	
}
