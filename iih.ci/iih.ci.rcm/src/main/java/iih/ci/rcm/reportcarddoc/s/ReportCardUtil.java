package iih.ci.rcm.reportcarddoc.s;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import com.founder.xap.runtime.msys.Module;
import com.founder.xap.runtime.msys.ModuleSystem;
import com.founder.xap.runtime.msys.impl.ModuleSystemImpl;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.rcm.reportcarddoc.d.ReportCardDocDo;
import iih.ci.rcm.reportcarddoc.d.Reportcarddocdto;
import iih.ci.rcm.reportcarddoc.i.IReportcarddocCudService;
import iih.ci.rcm.reportcarddocfs.d.ReportCardDocFsDo;
import iih.ci.rcm.reportcarddocfs.i.IReportcarddocfsCudService;
import iih.ci.rcm.reportcarddocfs.i.IReportcarddocfsRService;
import xap.mw.basic.storage.BusinessStorageService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.data.FBinary;
import xap.mw.core.data.binary.BinaryBuilder;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.log.logging.internal.Logger;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.permfw.pub.EnvContextUtil;

/**
 * 报卡模板相关工具类
 * @author wyl
 *
 */
public class ReportCardUtil extends PagingServiceImpl<Reportcarddocdto> {
	private static Logger logger = null;
	static {
		Module module= ModuleSystemImpl.getExtensionPoints().getExtensionPoint(ModuleSystem.class).getModule("cluster");
		logger =module.getContext().getLogger("circm");
	}
	
	//保存报卡文书
	@SuppressWarnings("unchecked")
	public FArrayList2 saveReportCardDoc(ReportCardDocDo docDo,ReportCardDocFsDo docFsDo) throws BizException
	{
		//报卡文书流服务
		IReportcarddocfsCudService  docFsService= ServiceFinder.find(IReportcarddocfsCudService.class);
		IReportcarddocCudService docService= ServiceFinder.find(IReportcarddocCudService.class);
		
		FArrayList2 fArrayList2 = null;
		// 默认是数据库存储
		String sdstmd = IBdSrvDictCodeConst.SD_MRTPLSTMD_FILEANDXML;
		if(!isNullOrEmpty(docDo.getSd_tplstmd())) {
			sdstmd = docDo.getSd_tplstmd();
		}
		
		switch(sdstmd)
		{
			case IBdSrvDictCodeConst.SD_MRTPLSTMD_FILEANDXML:
				fArrayList2 = docSave_Db(docService,docFsService,docDo,docFsDo); 
				break;
			case IBdSrvDictCodeConst.SD_MRTPLSTMD_FILE:
				fArrayList2 = DocSave_FileSys(docService,docFsService,docDo,docFsDo); 
				break;
			default:
				fArrayList2 = null;
				break;
		}
		
		return fArrayList2;
	}
	
	//报卡文书_文件系统方式保存
	@SuppressWarnings("unchecked")
	FArrayList2 DocSave_FileSys(IReportcarddocCudService docService,IReportcarddocfsCudService  docFsService,ReportCardDocDo docDo,ReportCardDocFsDo docFsDo) throws BizException
	{
		//文件系统服务
		BusinessStorageService fileService = ServiceFinder.find(BusinessStorageService.class);
		
		FArrayList2 fArrayList2 = new FArrayList2();
		
		String url_file = docDo.getUrl_file();
		boolean isNew = isNullOrEmpty(url_file)  ? true : false;
		byte[] docFsBytes = docFsDo.getFs();
		boolean saveSuccess = true;
		try {
			url_file = this.saveFileSys(fileService,url_file,isNew,docFsBytes);
		}
		catch(Throwable throwable) {
			saveSuccess = false;
		}
		
		if(saveSuccess) {
			docDo.setUrl_file(url_file);
			ReportCardDocDo []saveDocReusltDos =  docService.save(new ReportCardDocDo[]{docDo});
			if( saveDocReusltDos!=null && saveDocReusltDos.length>0) {
				docDo = saveDocReusltDos[0];
			}
		}
		
		fArrayList2.add(docDo);
		
		//无需保存数据库，但是还是需要刷新文书流的DO信息
		docFsDo.setFs(null);
		ReportCardDocFsDo []saveDocFsReusltDos = docFsService.save(new ReportCardDocFsDo[]{docFsDo});
		if( saveDocFsReusltDos!=null && saveDocFsReusltDos.length>0 ) {
			docFsDo = saveDocFsReusltDos[0]; 
		}
		docFsDo.setFs(docFsBytes);//回置流信息
		fArrayList2.add(docFsDo);
		
		//提交或者回滚文件系统
		this.commitToFileSys(fileService, saveSuccess, isNew, url_file);
		
		return fArrayList2;
	}
	
	//提交或者回滚文件系统
	void commitToFileSys(BusinessStorageService fileService,boolean saveSuccess,boolean isNew,String url_file) {
		try {
			if (saveSuccess) {
				if (isNew) {
					fileService.commitUpload(url_file);
				} else {
					fileService.commitWrite(url_file);
				}
			} else {
				if (isNew) {
					fileService.rollbackUpload(url_file);
				} else {
					fileService.rollbackWrite(url_file);
				}
			}
		}
		catch(Throwable ex) {
			logger.error("文件commit失败:id=" + url_file, ex);
		}
	}
	
	//报卡文书_数据库方式保存
    @SuppressWarnings("unchecked")
	FArrayList2 docSave_Db(IReportcarddocCudService docService,IReportcarddocfsCudService  docFsService,ReportCardDocDo docDo,ReportCardDocFsDo docFsDo) throws BizException
	{
    	FArrayList2 tmpArrayList = new FArrayList2();
    	
    	//保存文书类型
		ReportCardDocDo []saveDocReusltDos =  docService.save(new ReportCardDocDo[]{docDo});
		if( saveDocReusltDos!=null && saveDocReusltDos.length>0) {
			docDo = saveDocReusltDos[0];
		}
		tmpArrayList.add(docDo);
    	
	   //保存流
		ReportCardDocFsDo[] resultFsDo = docFsService.save(new ReportCardDocFsDo[] { docFsDo });
		if(resultFsDo!=null && resultFsDo.length>0) {
			tmpArrayList.add(resultFsDo[0]);	
		}
		return tmpArrayList;
	}
    
    //存贮文件系统
    String saveFileSys(BusinessStorageService fileService,String url_file,boolean isNew,byte[] docFs ) {
		try {
			InputStream input = new ByteArrayInputStream(docFs);
			FBinary bin = BinaryBuilder.builder().withBody(input).withSize(docFs.length).build();
			if (!isNew) {
				url_file = fileService.writeTransation(url_file, bin);
			} else {
				url_file = fileService.writeTransation(null, bin);
			}
		} catch (Exception ex) {
			if (!isNew) {
				logger.error("文件修改失败:id=" + url_file, ex);
			} else {
				logger.error("文件上传失败:id=" + url_file, ex);
			}
			throw new RuntimeException(ex);
		}
		return url_file;

	}
	
	//获取报卡文书流对象
	public ReportCardDocFsDo getRptCardDocFs(ReportCardDocDo docDo ) throws BizException, IOException {
	
		ReportCardDocFsDo rptDocFsDo = null;
		
		// 默认是数据库存储
		String sdstmd = IBdSrvDictCodeConst.SD_MRTPLSTMD_FILEANDXML;
		if(!isNullOrEmpty(docDo.getSd_tplstmd())) {
			sdstmd = docDo.getSd_tplstmd();
		}
		switch(sdstmd)
		{
			case IBdSrvDictCodeConst.SD_MRTPLSTMD_FILEANDXML:
				rptDocFsDo = getRptCardDocFs_Db(docDo);
				break;
			case IBdSrvDictCodeConst.SD_MRTPLSTMD_FILE:
				rptDocFsDo = getRptCardDocFs_FileSys(docDo);
				break;
			default:
				rptDocFsDo = null;
				break;
		}
		return rptDocFsDo;
	}
	
	//从文件系统获取文书流对象
	ReportCardDocFsDo getRptCardDocFs_FileSys(ReportCardDocDo docDo) throws IOException, BizException {
		if(docDo == null || isNullOrEmpty(docDo.getUrl_file()) ) return null;
		ReportCardDocFsDo docFsDo = getRptCardDocFs_Db(docDo);
		if( docFsDo == null ) return null;
		
		//从文件系统获取文书二进制流
		BusinessStorageService fileService = ServiceFinder.find(BusinessStorageService.class);
		FBinary bin = fileService.read(docDo.getUrl_file());
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		bin.writeBodyToStream(os);
		byte[] bytes = os.toByteArray();
		os.close();
		docFsDo.setFs(bytes);
		 
		return docFsDo;
	}
	
	//从数据库 获取报卡文书流对象
	ReportCardDocFsDo getRptCardDocFs_Db(ReportCardDocDo docDo) throws BizException
	{
		//报卡文书流服务
		IReportcarddocfsRService  docFsService= ServiceFinder.find(IReportcarddocfsRService.class);
		ReportCardDocFsDo[] docFsDos = docFsService.find(" id_ci_rcm_rd = '"+docDo.getId_ci_rcm_rd()+"'"," sv desc", FBoolean.FALSE);
		
		if(docFsDos==null || docFsDos.length<=0) return null;
		return docFsDos[0];
	}
	
	//真实删除报卡文书
	public FBoolean deleteRptCardDoc( ReportCardDocDo docDo) {
		
		FBoolean result = FBoolean.FALSE;
		// 默认是数据库存储
		String sdstmd = IBdSrvDictCodeConst.SD_MRTPLSTMD_FILEANDXML;
		if(!isNullOrEmpty(docDo.getSd_tplstmd())) {
			sdstmd = docDo.getSd_tplstmd();
		}
		
		switch(sdstmd)
		{
			case IBdSrvDictCodeConst.SD_MRTPLSTMD_FILEANDXML:
				result = deleteRptCardDoc_Db(docDo);
				break;
			case IBdSrvDictCodeConst.SD_MRTPLSTMD_FILE:
				result = deleteRptCardDoc_FileSys(docDo);
				break;
			default:
				break;
		}
		return result;
	}
	
	//从数据库删除报卡文书
	FBoolean deleteRptCardDoc_Db(ReportCardDocDo docDo) {
		try {
			//报卡文书流服务
			IReportcarddocfsCudService  docFsService= ServiceFinder.find(IReportcarddocfsCudService.class);
			ReportCardDocFsDo docFsDo = getRptCardDocFs(docDo);
			docFsService.delete(new ReportCardDocFsDo[]{docFsDo});
			return FBoolean.TRUE;
		}
		catch(Throwable ex) {
			logger.error("从数据库，删除报卡文书失败!",ex);
		}
		
		return FBoolean.FALSE;
	}
	
	//从文件系统删除报卡文书
	FBoolean deleteRptCardDoc_FileSys(ReportCardDocDo docDo) {
		try
		{
			if(docDo == null || isNullOrEmpty(docDo.getUrl_file()) ) return FBoolean.FALSE;
			ReportCardDocFsDo docFsDo = getRptCardDocFs_Db(docDo);
			if( docFsDo == null ) return FBoolean.FALSE;
			
			//从文件系统获取文书二进制流
			BusinessStorageService fileService = ServiceFinder.find(BusinessStorageService.class);
			fileService.delete(docDo.getUrl_file());
			return FBoolean.TRUE;
		}
		catch (Throwable ex) {
			logger.error("从文件系统，删除报卡文书失败!",ex);
		}
		return FBoolean.FALSE;
	}
	
	public boolean logicDeleteRptCardDocFs(ReportCardDocDo docDo,ReportCardDocFsDo docFsDo) {
		
		return false;
	}
	
	// 查询报卡文书对应的DTO
	public Reportcarddocdto findRptCardDocDTO(String docId) throws BizException {
		
		Reportcarddocdto dto =null;
		DAFacade daf = new DAFacade();
		String sqlStr = bulidSql(docId,null,null);
		Object resultObj = daf.execQuery(sqlStr, new BeanListHandler(Reportcarddocdto.class));
		@SuppressWarnings("unchecked")
		ArrayList<Reportcarddocdto> resultObjList = (ArrayList<Reportcarddocdto>)resultObj ;
		if(resultObjList!=null && resultObjList.size()>0) {
			dto = resultObjList.get(0);
		}
		
		if(dto == null ) return null;
		
		dto.setName_sub(queryUserNameByUserId(dto.getId_sub()));
		dto.setName_reject(queryUserNameByUserId(dto.getId_reject()));
		dto.setName_pass(queryUserNameByUserId(dto.getId_pass()));
		dto.setCreatedby_name(queryUserNameByUserId(dto.getCreatedby()));
		dto.setModifiedby_name(queryUserNameByUserId(dto.getModifiedby()));
		
		return dto;
	}

	//查询用户的名称（通过用户ID）
	private String queryUserNameByUserId(String userId) throws DAException
	{
		if(isNullOrEmpty(userId)) return null;
		
		DAFacade daFacade = new DAFacade();
		String querySql = "select name from sys_user where id_user = '"
				+userId+"'";
		Object obj = daFacade.execQuery(querySql, new ColumnHandler());
		if(obj instanceof String) return (String)obj;
		return null;
	}
	
	
	//分页查询报卡文书DTO对象
	public PagingRtnData<Reportcarddocdto> findRptCardDtosByPageInfo(String whereStr,QryRootNodeDTO qryRootNodeDto,PaginationInfo paginationInfo) throws BizException
	{
		String sql = bulidSql(null,whereStr, qryRootNodeDto);
		PagingRtnData<Reportcarddocdto> pagingRtnData = super.findByPageInfo(new Reportcarddocdto(), paginationInfo, sql, "", null);
		if( pagingRtnData!=null ) {
			FArrayList data = pagingRtnData.getPageData();
			if(data!=null && data.size()>0) {
				for(int i=0;i<data.size();i++) {
					if(!(data.get(i) instanceof Reportcarddocdto)) continue;
					Reportcarddocdto dto = (Reportcarddocdto)data.get(i);
					dto.setName_sub(queryUserNameByUserId(dto.getId_sub()));
					dto.setName_reject(queryUserNameByUserId(dto.getId_reject()));
					dto.setName_pass(queryUserNameByUserId(dto.getId_pass()));
					dto.setCreatedby_name(queryUserNameByUserId(dto.getCreatedby()));
					dto.setModifiedby_name(queryUserNameByUserId(dto.getModifiedby()));
				}
			}
		}
		return pagingRtnData;
	}
	
	
	//导出按钮查询报卡数据
	public Reportcarddocdto[] findRptCardDtos(QryRootNodeDTO qryRootNodeDto)  throws BizException
	{
		String sql = bulidSql(null,null, qryRootNodeDto);
		DAFacade daf = new DAFacade();
		@SuppressWarnings("unchecked")
		List<Reportcarddocdto> listDto = (List<Reportcarddocdto>) daf.execQuery(sql,
				new BeanListHandler(Reportcarddocdto.class));
		if( listDto!=null ) {
			for (Reportcarddocdto dto : listDto) {
				dto.setName_sub(queryUserNameByUserId(dto.getId_sub()));
				dto.setName_reject(queryUserNameByUserId(dto.getId_reject()));
				dto.setName_pass(queryUserNameByUserId(dto.getId_pass()));
				dto.setCreatedby_name(queryUserNameByUserId(dto.getCreatedby()));
				dto.setModifiedby_name(queryUserNameByUserId(dto.getModifiedby()));
			}
		}
		return listDto.toArray(new Reportcarddocdto[0]);
	}
		
	//构建查询报卡文书dto相关sql
	private String bulidSql(String docId,String whereStr,QryRootNodeDTO qryRootNodeDto) throws BizException
	{
		IQrySQLGeneratorService service=ServiceFinder.find(IQrySQLGeneratorService.class);
		StringBuilder sql = new StringBuilder();
		sql.append("select distinct ci_rcm_rd.id_ci_rcm_rd     as id_ci_rcm_rd,");
		sql.append("                ci_rcm_rd.id_org           as id_org,");
		sql.append("                ci_rcm_rd.id_grp           as id_grp,");
		sql.append("                ci_rcm_rd.id_ent           as id_ent,");
		sql.append("                ci_rcm_rd.name             as name,");
		sql.append("                ci_rcm_rd.id_state         as id_state,");
		sql.append("                ci_rcm_rd.sd_state         as sd_state,");
		sql.append("                ci_rcm_rd.name_state       as name_state,");
		sql.append("                tplType.id_bd_rcm_tp as id_bd_rcm_tp,");
		sql.append("                tplType.name         as name_bd_rcm_tp,");
		sql.append("                ci_rcm_rd.id_bd_rcm_tpl    as id_bd_rcm_tpl,");
		sql.append("                tpl.name             as name_bd_rcm_tpl,");
		sql.append("                ci_rcm_rd.id_mred          as id_mred,");
		sql.append("                ci_rcm_rd.sd_tplstmd       as sd_tplstmd,");
		sql.append("                ci_rcm_rd.id_tplstmd       as id_tplstmd,");
		sql.append("                ci_rcm_rd.name_tplstmd     as name_tplstmd,");
		sql.append("                ci_rcm_rd.url_file         as url_file,");
		sql.append("                ci_rcm_rd.dt_sub           as dt_sub,");
		sql.append("                ci_rcm_rd.id_sub           as id_sub,");
		sql.append("                ci_rcm_rd.dt_withdraw      as dt_withdraw,");
		sql.append("                ci_rcm_rd.id_withdraw      as id_withdraw,");
		sql.append("                ci_rcm_rd.dt_reject        as dt_reject,");
		sql.append("                ci_rcm_rd.id_reject        as id_reject,");
		sql.append("                ci_rcm_rd.reason_reject    as reason_reject,");
		sql.append("                ci_rcm_rd.dt_pass          as dt_pass,");
		sql.append("                ci_rcm_rd.id_pass          as id_pass,");
		sql.append("                ci_rcm_rd.createdby        as createdby,");
		sql.append("                ci_rcm_rd.createdTime      as createtime,");
		sql.append("                ci_rcm_rd.modifiedby       as modifiedby,");
		sql.append("                ci_rcm_rd.modifiedtime     as modifiedtime,");
		sql.append("                ci_rcm_rd.ishidename       as Ishidename_rptcard,");
		sql.append("                dep_office.name      as dep_name,");
		sql.append("                dep_bed.name         as suffer_department_name,");
		sql.append("                en_ip.name_bed       as bed,");
		sql.append("                en.name_pat          as suffer_name");
		sql.append("  from ci_rcm_rd ");
		sql.append(" left join ci_rcm_rd_fs docFs ");
		sql.append("    on ci_rcm_rd.id_ci_rcm_rd = docFs.id_ci_rcm_rd");
		sql.append("  left join bd_rcm_tpl tpl");
		sql.append("    on ci_rcm_rd.id_bd_rcm_tpl = tpl.id_bd_rcm_tpl");
		sql.append("  left join bd_rcm_tp tplType");
		sql.append("    on ci_rcm_rd.id_bd_rcm_tp = tplType.id_bd_rcm_tp");
		sql.append("  left join en_ent_ip en_ip");
		sql.append("    on ci_rcm_rd.id_ent = en_ip.id_ent");
		sql.append("  inner join en_ent en");
		sql.append("    on ci_rcm_rd.id_ent = en.id_ent");
		sql.append("  left join bd_dep dep_office");
		sql.append("    on dep_office.id_dep = en_ip.id_dep_phyadm");
		sql.append("  left join bd_dep dep_bed");
		sql.append("    on dep_bed.id_dep = en_ip.id_dep_nuradm");
		
		sql.append(" where "+EnvContextUtil.processEnvContext("",new ReportCardDocDo(),false));
		if(!isNullOrEmpty(docId)) {
			sql.append(" and ci_rcm_rd.id_ci_rcm_rd = '"+docId+"' ");
		}
		if(!isNullOrEmpty(whereStr)){
			sql.append("and" + whereStr);
		}
		//拼接查询方案相关sql
		if (qryRootNodeDto!=null){
			sql.append(" AND " + service.getQueryStringWithoutDesc(qryRootNodeDto));
 		}
		sql.append(" order by ci_rcm_rd.createdtime desc");
		
		return sql.toString();
	}
	
	
    //判断字符串是否是null 或者""
	boolean isNullOrEmpty(String currentStr)
	{
		if(currentStr =="" || currentStr == null )
			return true;
		return false;
	}
	
}
