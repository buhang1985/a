package iih.ci.mr.mrws.hosgetmr.s.bp;

import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.bd.srv.mrmtype.d.MrmTypeMrtpDO;
import iih.bd.srv.mrmtype.i.IMrmTypeMrtpDORService;
import iih.ci.mr.ciamr.d.AMrDO;
import iih.ci.mr.ciamr.i.ICiamrRService;
import xap.mw.basic.storage.BusinessStorageService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FBinary;
import xap.mw.core.data.binary.BinaryBuilder;
import xap.mw.core.service.constant.Binding;
import iih.ci.mrm.i.outcommon.IMrmOutCommonService;
import iih.ci.mrm.mrmarchiveinfo.d.MrmArchiveInfoDO;
import iih.ci.mrm.mrmarchiveinfo.i.IMrmarchiveinfoCudService;
import iih.ci.mrm.mrmarchiveinfo.i.IMrmarchiveinfoRService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.i.IPatiMDORService;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

public class MrWsForHosSysUPloadBp {

	/**
	 * 添加病案文件（早期,主键废弃）
	 * @param code_pat
	 * @param times_inhos
	 * @param id_busy
	 * @param id_set
	 * @param name
	 * @param file
	 * @param isClear
	 * @param sortNo
	 * @return
	 * @throws IOException
	 * @throws BizException
	 */
	public boolean AddMrmFileInfo(String code_pat, String times_inhos, String id_busy, String id_set, String name,
			String file, Boolean isClear, int sortNo) throws  IOException , BizException{
		IPatiMDORService patservice = ServiceFinder.find(IPatiMDORService.class);
		
		PatDO[] patdos = patservice.findByAttrValString("Code",code_pat );
		if(patdos == null || patdos.length<0){
			return false;
		}
		
		ICiamrRService ciamrservice = ServiceFinder.find(ICiamrRService.class);
		AMrDO [] amrdos = ciamrservice.find("id_pat = '"+patdos[0].getId_pat()+"' "
				+ "and inhos_times = '"+times_inhos+"'", "", FBoolean.FALSE);
		
		if(amrdos == null || amrdos.length < 0){
			return false;
		}
		
		IMrmTypeMrtpDORService typeservice = ServiceFinder.find(IMrmTypeMrtpDORService.class);
		
		MrmTypeMrtpDO [] typemrtpdos = typeservice.findByAttrValString("Id_set", id_set);
		if(typemrtpdos == null || typemrtpdos.length < 0){
			return false;
		}
		byte [] codefiles = file.getBytes(StandardCharsets.UTF_8);

		String code_file = uploadFile2FileSys(codefiles);
		IMrmOutCommonService outcommon = ServiceFinder.find(IMrmOutCommonService.class);
		outcommon.addMrmFileInfo(amrdos[0].getId_ent(), id_busy, id_set, 
				name, code_file, ICiMrDictCodeConst.ID_BD_MRM_DATAFORAMT_PDF, 
				ICiMrDictCodeConst.SD_BD_MRM_DATAFORAMT_PDF, isClear, sortNo);
		
	return true;
	}
	
	/**
	 * 上传文件到文件系统
	 * @param bfiles
	 * @return
	 * @throws IOException
	 */
	private String uploadFile2FileSys(byte [] bfiles) throws IOException
	{

		BusinessStorageService servicefile = ServiceFinder.find(BusinessStorageService.class);

		InputStream input = new ByteArrayInputStream(bfiles);
		FBinary ary = BinaryBuilder.builder().withBody(input).withSize(bfiles.length).build();
		String url_file = servicefile.write(null, ary);
		return url_file;
	}
	
	public boolean upLoadMrmFileInfo(String code_pat, String times_inhos,String code_ent, String id_busy, String id_set, String name,
			String file, Boolean isClear, int sortNo,int tCount) throws  IOException , BizException{
		String idEnt = "";
		IPatiMDORService patservice = ServiceFinder.find(IPatiMDORService.class);
		IPativisitRService enEnt = ServiceFinder.find(IPativisitRService.class);
		if(code_ent == null||code_ent.equals(""))
		{
			PatDO[] patdos = patservice.findByAttrValString("Code",code_pat );
			if(patdos == null || patdos.length<=0){
				return false;
			}
			
			ICiamrRService ciamrservice = ServiceFinder.find(ICiamrRService.class);
			AMrDO [] amrdos = ciamrservice.find("id_pat = '"+patdos[0].getId_pat()+"' "
					+ "and inhos_times = '"+times_inhos+"'", "", FBoolean.FALSE);
			
			if(amrdos == null || amrdos.length <=0){
				return false;
			}
			else
				idEnt = amrdos[0].getId_ent();
		}
		else
		{
			 
			PatiVisitDO[] enEntDo = enEnt.findByAttrValString("Code", code_ent);
			if(enEntDo!=null&&enEntDo.length>0)
			{
				idEnt = enEntDo[0].getId_ent();
			}
			else
			{
				return false;
			}
		}
		IMrmTypeMrtpDORService typeservice = ServiceFinder.find(IMrmTypeMrtpDORService.class);
		
		MrmTypeMrtpDO [] typemrtpdos = typeservice.findByAttrValString("Id_set", id_set);
		if(typemrtpdos == null || typemrtpdos.length <=0){
			return false;
		}
		byte [] codefiles = file.getBytes(StandardCharsets.UTF_8);

		String code_file = uploadFile2FileSys(codefiles);
		IMrmOutCommonService outcommon = ServiceFinder.find(IMrmOutCommonService.class);
		outcommon.addMrmFileInfo(idEnt, id_busy, id_set, 
				name, code_file, ICiMrDictCodeConst.ID_BD_MRM_DATAFORAMT_PDF, 
				ICiMrDictCodeConst.SD_BD_MRM_DATAFORAMT_PDF, isClear, sortNo);
		saveMrmStatisticsInfo(idEnt,id_set,tCount);
	return true;
	}
	/**
	 * 保存统计信息
	 * @param idEnt
	 * @param idSet
	 * @param tCount
	 * @throws BizException 
	 */
	private void  saveMrmStatisticsInfo(String idEnt,String idSet,int tCount) throws BizException
	{
		IMrmarchiveinfoCudService cudSrv = ServiceFinder.find(IMrmarchiveinfoCudService.class);
		IMrmarchiveinfoRService rSrv = ServiceFinder.find(IMrmarchiveinfoRService.class);
		String sqlWhere = "id_set = '"+idSet+"' and id_ent = '"+idEnt+"'";
		MrmArchiveInfoDO[] maInfos = rSrv.find(sqlWhere, null, FBoolean.FALSE);
		if(maInfos!=null&&maInfos.length>0)//有数据，则更新
		{
			for(MrmArchiveInfoDO maInfo : maInfos)
			{
				maInfo.setCount_fs_archive(tCount);
				maInfo.setStatus(DOStatus.UPDATED);
			}
			cudSrv.save(maInfos);
		}
		else
		{
			
			MrmArchiveInfoDO maInfo = new MrmArchiveInfoDO();
			maInfo.setId_ent(idEnt);
			maInfo.setCount_fs_archive(tCount);
			maInfo.setId_org(Context.get().getOrgId());
			maInfo.setId_grp(Context.get().getGroupId());
			maInfo.setStatus(DOStatus.NEW);
			cudSrv.save(new MrmArchiveInfoDO[]{maInfo});
		}
	}
	
	public boolean  updateMrmStatisticsInfo(String code_pat, String times_inhos,String code_ent,String id_set,int tCount) throws BizException
	{
		String idEnt = "";
		IPatiMDORService patservice = ServiceFinder.find(IPatiMDORService.class);
		IPativisitRService enEnt = ServiceFinder.find(IPativisitRService.class);
		if(code_ent == null||code_ent.equals(""))
		{
			PatDO[] patdos = patservice.findByAttrValString("Code",code_pat );
			if(patdos == null || patdos.length<0){
				return false;
			}
			
			ICiamrRService ciamrservice = ServiceFinder.find(ICiamrRService.class);
			AMrDO [] amrdos = ciamrservice.find("id_pat = '"+patdos[0].getId_pat()+"' "
					+ "and inhos_times = '"+times_inhos+"'", "", FBoolean.FALSE);
			
			if(amrdos == null || amrdos.length < 0){
				return false;
			}
			else
				idEnt = amrdos[0].getId_ent();
		}
		else
		{
			 
			PatiVisitDO[] enEntDo = enEnt.findByAttrValString("Code", code_ent);
			if(enEntDo!=null&&enEntDo.length>0)
			{
				idEnt = enEntDo[0].getId_ent();
			}
			else
			{
				return false;
			}
		}
		saveMrmStatisticsInfo(idEnt,id_set,tCount);
		return true;
	}
}
