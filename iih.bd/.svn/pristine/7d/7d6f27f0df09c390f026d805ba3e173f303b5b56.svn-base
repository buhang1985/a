package iih.bd.srv.s;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import iih.bd.srv.d.BdSrvQryDTO;
import iih.bd.srv.d.DiagDicaDTO;
import iih.bd.srv.d.EmrTplTreeDTO;
import iih.bd.srv.d.FixedChargePKgDTO;
import iih.bd.srv.d.RefItemDTO;
import iih.bd.srv.d.RefSrvItemDTO;
import iih.bd.srv.diagcate.bp.DiagcateCrudBp;
import iih.bd.srv.diagdef.d.DiagDefDO;
import iih.bd.srv.dto.d.Emp2Dep2GroupDTO;
import iih.bd.srv.dto.d.EmsDynamicParamDTO;
import iih.bd.srv.dto.d.MedSrvPriDTO;
import iih.bd.srv.dto.d.SrvSetItemDTO;
import iih.bd.srv.emreditor.bp.EmreditorCrudBp;
import iih.bd.srv.emreditor.d.EmrEditorDO;
import iih.bd.srv.emrterm.d.EmrEvent4TermDO;
import iih.bd.srv.emrterm.d.EmrNormWordCaDO;
import iih.bd.srv.emrterm.d.EmrTermCaDO;
import iih.bd.srv.emrterm.d.EmrTermCompDO;
import iih.bd.srv.emrterm.d.EmrTermDO;
import iih.bd.srv.emrterm.d.desc.EmrNormWordCaDODesc;
import iih.bd.srv.emrterm.d.desc.EmrTermCaDODesc;
import iih.bd.srv.emrterm.d.desc.EmrTermCompDODesc;
import iih.bd.srv.emrtpl.bp.EmrtplCrudBp;
import iih.bd.srv.emrtpl.d.EmrtplAggDO;
import iih.bd.srv.ems.d.EmsDynamicIndexDTO;
import iih.bd.srv.ems.d.EmsMatchRstDTO;
import iih.bd.srv.ems.d.SrvMatchEmsParamDTO;
import iih.bd.srv.freqdef.bp.GetFreqDefTreeDataBP;
import iih.bd.srv.freqdef.d.FreqDefDTO;
import iih.bd.srv.freqdef.d.desc.FreqDefDODesc;
import iih.bd.srv.i.IBdSrvQryService;
import iih.bd.srv.medsrv.bf.GetSrvPriMdInfoBP;
import iih.bd.srv.medsrv.bf.GetSrvPriMdInfoByCaBP;
import iih.bd.srv.medsrv.bf.GetSrvSetSrvItemsInfoBP;
import iih.bd.srv.medsrv.d.BdMmDto;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvRelMmDTO;
import iih.bd.srv.medsrv.validate.BDErrorInfo;
import iih.bd.srv.medsrv.validate.BDSrvValidateTool;
import iih.bd.srv.medusage.s.bp.GetMedUsaTreeDataBP;
import iih.bd.srv.medvalidate.d.BDErrorInfoDO;
import iih.bd.srv.medvalidate.d.BDErrorInfoItemDO;
import iih.bd.srv.medvalidate.d.MedvalidateAggDO;
import iih.bd.srv.medvalidate.i.IMedvalidateCudService;
import iih.bd.srv.mrbasetpl.bp.MrbasetplCrudServiceBp;
import iih.bd.srv.mutex.d.SrvReactDTO;
import iih.bd.srv.ortmplquerydto.d.OrTmplQueryDTO;
import iih.bd.srv.ortpl.d.OrTplCaDO;
import iih.bd.srv.ortpl.dto.OrTmplDTO;
import iih.bd.srv.pub.BdSrvAppUtils;
import iih.bd.srv.s.bp.DeptsrvlimitDeptTreeBP;
import iih.bd.srv.s.bp.EmrTermCrudBP;
import iih.bd.srv.s.bp.GetDpBillFormInfoDOBP;
import iih.bd.srv.s.bp.GetEmrTermBP;
import iih.bd.srv.s.bp.GetEmrTermCaTreeBP;
import iih.bd.srv.s.bp.GetEmrTermCompBP;
import iih.bd.srv.s.bp.GetEmsDynamicIndexInfosBP;
import iih.bd.srv.s.bp.GetMaxSeqNO4OrTmplBP;
import iih.bd.srv.s.bp.GetMedSrvDO8IdBP;
import iih.bd.srv.s.bp.GetMedSrvDOs8IdsBP;
import iih.bd.srv.s.bp.GetMedSrvRelMmDeptBP;
import iih.bd.srv.s.bp.GetMedSrvRelMmListBP;
import iih.bd.srv.s.bp.GetMedSrvRelMmOrgBP;
import iih.bd.srv.s.bp.GetModuleInfoBP;
import iih.bd.srv.s.bp.GetOrTmplCaTreeBP;
import iih.bd.srv.s.bp.GetSrvDescCfgInfoBP;
import iih.bd.srv.s.bp.GetSrvReactInfosBP;
import iih.bd.srv.s.bp.GetSrvReactItemDOBP;
import iih.bd.srv.s.bp.GetUdidocExtend;
import iih.bd.srv.s.bp.MedSrvEmsMatchBP;
import iih.bd.srv.s.bp.SrvRtCtlValidateInfoNBP;
import iih.bd.srv.srvdc.bp.SrvdcCrudBp;
import iih.bd.srv.srvortpl.bp.SrvortplCrudBp;
import iih.bd.srv.srvreact.d.SrvReactDO;
import iih.bd.srv.srvreact.d.SrvReactItemDO;
import iih.bd.srv.srvreact.d.SrvReactSrv;
import iih.bd.srv.srvreact.s.bp.GetSrvReactData;
import iih.bd.srv.srvrtctl.d.SrvRtCtlDTO;
import iih.bd.srv.srvrtctl.d.SrvRtCtlParam;
import iih.bd.srv.srvrtctl.s.bp.GetPsnMsgBP;
import iih.bd.srv.srvrtempref.d.SrvRtEmpRefDO;
import xap.dp.bfdesigner.d.DpBillFormTDO;
import xap.dp.dmengine.d.EnumValueDO;
import xap.dp.dmengine.d.PropertyDO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.refcheck.i.IReferenceCheck;
import xap.sys.custcfg.billcode.i.IBillcodeManage;
import xap.sys.orgfw.dept.d.DeptDO;

@Service(serviceInterfaces = { IBdSrvQryService.class }, binding = Binding.JSONRPC)
public class BdSrvQryServiceImpl implements IBdSrvQryService {

	@Override
	public BdSrvQryDTO[] getSrvReactTreeData() throws BizException {
		GetSrvReactData bp = new GetSrvReactData();
		return bp.srvreactTreeData();
	}
//诊断标准树
	@Override
	public BdSrvQryDTO[] getDiagstacaTree() throws BizException {
		GetSrvReactData bp = new GetSrvReactData();
		return bp.diagcateatTreeData();
	}

	
	
	@Override
	public FreqDefDTO[] getFreqDefTreeData() throws BizException {	
		GetFreqDefTreeDataBP bp = new GetFreqDefTreeDataBP();
		return bp.exec();
	}
	
//	@Override
//	public FreqDefDTO[] getFreqDefTreeData() throws BizException {
//		
//		GetMedSrvDO8IdBP bp = new GetMedSrvDO8IdBP();
//		bp.exec("0001Z7100000000E4O8X");
//		
//		IMedsrvMDORService service=ServiceFinder.find(IMedsrvMDORService.class);
//		service.findById("0001Z7100000000E4O8X");
//		return null;
//	}

	@Override
	public EmrtplAggDO[] setCopyEmrTpl(EmrtplAggDO aggdos) throws BizException {
		EmrtplCrudBp bp = new EmrtplCrudBp();
		bp.setCopyEmrTpl(aggdos);
		return null;
	}

	@Override
	public EmrEditorDO[] setCopyEmreditor(EmrEditorDO dos) throws BizException {
		EmreditorCrudBp bp = new EmreditorCrudBp();
		bp.setCopyEmreditor(dos);
		return null;
	}

	@Override
	public EmrEditorDO[] setEnableCopyEmreditor(EmrEditorDO emr)
			throws BizException {
		// TODO Auto-generated method stub ，点启用后调用
		EmreditorCrudBp bp = new EmreditorCrudBp();
		bp.setEnableCopyEmreditor(emr);
		return null;
	}

	@Override
	public Integer getMaxVersion(String code) throws BizException {
		// TODO Auto-generated method stub
		MrbasetplCrudServiceBp bp = new MrbasetplCrudServiceBp();
		return bp.getMaxVersion(code);
	}

	// 得到表bd_mred的最大版本号
	@Override
	public Integer getBdmredMaxVersion(String code) throws BizException {
		// TODO Auto-generated method stub
		EmreditorCrudBp bp = new EmreditorCrudBp();
		return bp.getBdmredMaxVersion(code);
	}

	@Override
	public  EmrEditorDO[] getNewCopyDO(String code) throws BizException{
		EmreditorCrudBp bp = new EmreditorCrudBp();
		return bp.getNewCopyDO(code);		
	}
	
	@Override
	public SrvReactSrv[] findSrv() throws BizException {
		GetSrvReactData bp = new GetSrvReactData();
		return bp.findSrv();
	}

	@Override
	public void getEmpTypeTree(String own_id) throws BizException {
		// TODO Auto-generated method stub

	}

	@Override
	public SrvReactSrv[] findById(String id) throws BizException {
		GetSrvReactData bp = new GetSrvReactData();
		return bp.findById(id);
	}

	@Override
	public EmrTplTreeDTO[] getEmrTpTreeList(String Id_own) throws BizException {
		// TODO Auto-generated method stub
		EmrtplCrudBp bp = new EmrtplCrudBp();
		return bp.getEmrTpTreeList(Id_own);
	}

	

	@Override
	public FixedChargePKgDTO[] getFCPKgTreeList(String Id_own)
			throws BizException {
		SrvdcCrudBp bp = new SrvdcCrudBp();
		return bp.getFCPKgTreeList(Id_own);
	}

	@Override
	public SrvReactDO[] findGroup(String id) throws BizException {

		GetSrvReactData data = new GetSrvReactData();
		return data.findGroup(id);
	}

	@Override
	public DiagDicaDTO[] getDiagDicaDOList(String Id_di) throws BizException {
		DiagcateCrudBp bp = new DiagcateCrudBp();
		return bp.getDiagDicaDOList(Id_di);
	}

	@Override
	public String getAutoCode() throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MedSrvPriDTO[] getSrvPriMdInfo(String id_primd) throws BizException {
		GetSrvPriMdInfoBP bp = new GetSrvPriMdInfoBP();
		return bp.exec(id_primd);
	}

	@Override
	public MedSrvPriDTO[] getSrvPriMdInfoByCa(String id_srvca)
			throws BizException {
		GetSrvPriMdInfoByCaBP bp = new GetSrvPriMdInfoByCaBP();
		return bp.exec(id_srvca);
	}

	@Override
	public DiagDefDO[] GetDiagDefDo(String Id_mrtpl)throws BizException{
		EmrtplCrudBp bp = new EmrtplCrudBp();
		return bp.GetDiagDefDo(Id_mrtpl);
	}
	


	@Override
	public RefItemDTO[] getRefItemDTO(String id, String type)
			throws BizException {
		// TODO Auto-generated method stub
		SrvortplCrudBp bp =new SrvortplCrudBp();
		return bp.getRefItemDTO(id, type);
		 
	}

	@Override
	public SrvSetItemDTO[] getSrvSetSrvItemsInfo(String id_srv_set)
			throws BizException {
		// TODO Auto-generated method stub
		GetSrvSetSrvItemsInfoBP bp  = new GetSrvSetSrvItemsInfoBP();
		return bp.exec(id_srv_set);
 
	}
	

	@Override
	public DiagDicaDTO[] getDistinctDicaList() throws BizException {
		DiagcateCrudBp bp = new DiagcateCrudBp();
		return bp.getDistinctDicaList();
	}
	
	@Override
	public BdSrvQryDTO[] findMedu() throws BizException{
		GetMedUsaTreeDataBP bp=new GetMedUsaTreeDataBP();
		return bp.exec();
	}

	@Override
	public DiagDefDO[] getSrvOrTplDiagDef(String id) throws BizException {
		// TODO Auto-generated method stub
		SrvortplCrudBp bp =new SrvortplCrudBp();
		return  bp.getDiagfDO(id);
	}

	@Override
	public RefSrvItemDTO[] getSrvListItem(String keyWord) throws BizException {
		// TODO Auto-generated method stub
		SrvortplCrudBp srvbp = new SrvortplCrudBp();
		return  srvbp.getSrvList(keyWord);
	 
	}

	@Override
	public SrvReactDTO[] getSrvReactInfos(String srvcondstr)
			throws BizException {
		GetSrvReactInfosBP bp=new GetSrvReactInfosBP();
		return bp.exec(srvcondstr);
	}

	@Override
	public SrvRtCtlDTO[] getUnAuthorizedSrvRtCtlInfo(SrvRtCtlParam rtctlparam)
			throws BizException {
		//SrvRtCtlValidateInfoBP bp=new SrvRtCtlValidateInfoBP();//已经废弃不用了
		SrvRtCtlValidateInfoNBP bp=new SrvRtCtlValidateInfoNBP();
		return bp.exec(rtctlparam);
	}

	@Override
	public String getFreqDefNoapplyform() throws BizException {
		// TODO Auto-generated method stub
		IBillcodeManage bill=(IBillcodeManage)ServiceFinder.find(IBillcodeManage.class);
		return bill.getPreBillCode_RequiresNew(FreqDefDODesc.CLASS_FULLNAME);			
	}
	
	@Override
	public SrvRtEmpRefDO getPsnMsgInfo(String id) throws BizException {
		GetPsnMsgBP bp = new GetPsnMsgBP();
		return bp.GetPsnMsg(id);
	}
	
	@Override
	public String getUdidocExtent(String code) throws BizException {
		GetUdidocExtend ue=new GetUdidocExtend();
		return ue.getCtrlScope(code);
	}
	@Override
    public OrTplCaDO[] getSrvortplCate(String sd_ortpltp)throws BizException{
  	    SrvortplCrudBp tpl = new SrvortplCrudBp();
  	    return tpl.getSrvortplCate(sd_ortpltp);
    }
	@Override
    public OrTplCaDO[] getSrvortplCateDO(String sd_ortpltp,Emp2Dep2GroupDTO edg)throws BizException{
  	    SrvortplCrudBp tpl = new SrvortplCrudBp();
  	    return tpl.getSrvortplCate(sd_ortpltp,edg);
    }
	@Override
	public DeptDO[] getDeptsrvlimitDeptTree() throws BizException {
		DeptsrvlimitDeptTreeBP bp = new DeptsrvlimitDeptTreeBP();
		return bp.getDeptsrvlimitDeptTree();
	}
	@Override
	public EmsDynamicIndexDTO[] getEmsDynamicIndexInfos(EmsDynamicParamDTO paramDto)
			throws BizException {
		GetEmsDynamicIndexInfosBP bp=new GetEmsDynamicIndexInfosBP();
		return bp.exec(paramDto);
	}
	@Override
	public BdMmDto[] getBdMmData(String id_srv) throws BizException {
		GetSrvReactData bp = new GetSrvReactData();
		return bp.getBdMmData(id_srv);
	}
	
	@Override
	public MedSrvRelMmDTO[] getMedSrvRelMmList(String id_srv)
			throws BizException {
		GetMedSrvRelMmListBP bp=new GetMedSrvRelMmListBP();
		return bp.exec(id_srv);
	}
	@Override
	public MedSrvRelMmDTO[] getMedSrvRelMmOrg(String id_srv)
			throws BizException {
		GetMedSrvRelMmOrgBP bp=new GetMedSrvRelMmOrgBP();
		return bp.exec(id_srv);
	}
	@Override
	public MedSrvRelMmDTO[] getMedSrvRelMmDept(String id_srv, String id_dep)
			throws BizException {
		GetMedSrvRelMmDeptBP bp=new GetMedSrvRelMmDeptBP();
		return bp.exec(id_srv,id_dep);
	}
	@Override
	public SrvReactItemDO[] getSrvReactItemDO(String ids) throws BizException {
		GetSrvReactItemDOBP bp = new GetSrvReactItemDOBP();
		return bp.exec(ids);
	}
	@Override
	public Boolean getisReferenced(BaseDO vo) throws BizException {
		// TODO Auto-generated method stub
		Boolean b=ServiceFinder.find(IReferenceCheck.class).isReferenced2(vo.getTableName(), vo.getPkVal(), new StringBuffer());		
		return b;
	}

	@Override
	public int getDescCfgMaxSeq(String formId, String srvcaCode) throws BizException{
		
		int maxSeq = -1;
		if(StringUtils.isNotBlank(formId) && StringUtils.isNotBlank(srvcaCode) ){			
			GetSrvDescCfgInfoBP bp = new GetSrvDescCfgInfoBP();
			maxSeq = bp.execMaxSeq(formId, srvcaCode);
		}
		return maxSeq;
	}
	
	@Override
	public PropertyDO[] getPropertyDO(String classId) throws BizException{
		
		GetModuleInfoBP bp = new GetModuleInfoBP();
		return bp.execQuerypropertyDO(classId);
	}
	
	@Override
	public EnumValueDO[] getEnumValueDO(String classId) throws BizException{
		
		GetModuleInfoBP bp = new GetModuleInfoBP();
		return bp.execQueryEnumValueDO(classId);
	}
	
	@Override
	public DpBillFormTDO[] getFormDO(String metadataclass) throws BizException{
		
		GetDpBillFormInfoDOBP bp = new GetDpBillFormInfoDOBP();
		return bp.execQueryBillForm(metadataclass);
	}
	
	@Override
	public EmrTermCaDO[] getEmrTermCaTreeData(EmrTermCaDO emrTermCaDO) throws BizException{
		
		GetEmrTermCaTreeBP bp = new GetEmrTermCaTreeBP();
		return bp.exec(emrTermCaDO);
	}
	
	@Override
	public EmrTermDO[] getEmrTermData(EmrTermDO emrTermDO, String inputStr) throws BizException {

		GetEmrTermBP bp = new GetEmrTermBP();
		return bp.exec(emrTermDO, inputStr);
	}
	
	@Override
	public EmrTermCompDO[] getEmrTermComps(EmrEvent4TermDO emrEvent4Term) throws BizException {

		GetEmrTermCompBP bp = new GetEmrTermCompBP();
		return bp.exec(emrEvent4Term);
	}
	
	@Override
	public EmsMatchRstDTO medSrvMatchEms(SrvMatchEmsParamDTO param)
			throws BizException {
		MedSrvEmsMatchBP bp=new MedSrvEmsMatchBP();
		return bp.exec(param);
	}
	
	@Override
	public EmrNormWordCaDO[] getNormWordCate(String type,String stype) throws BizException {
		// TODO Auto-generated method stub
		EmrTermCrudBP bp=new EmrTermCrudBP();
		return bp.getNormWordCate(type,stype);
	}
	@Override
	public String getNormWordCateCode() throws BizException {
		// TODO Auto-generated method stub
		return BdSrvAppUtils.getIBillcodeManager().getPreBillCode_RequiresNew(EmrNormWordCaDODesc.CLASS_FULLNAME);
	}
	@Override
	public EmrTermCaDO[] getEmrTermCate(String type, String stype,String sys) throws BizException {
		// TODO Auto-generated method stub
		EmrTermCrudBP bp=new EmrTermCrudBP();
		return bp.getMainSuitCate(type, stype,sys);
	}
	@Override
	public String getEmrTermCateCode() throws BizException {
		// TODO Auto-generated method stub
		return BdSrvAppUtils.getIBillcodeManager().getPreBillCode_RequiresNew(EmrTermCaDODesc.CLASS_FULLNAME);
	}
	@Override
	public String getInputCompCode() throws BizException {
		// TODO Auto-generated method stub
		return BdSrvAppUtils.getIBillcodeManager().getPreBillCode_RequiresNew(EmrTermCompDODesc.CLASS_FULLNAME);
	}
	@Override
	public OrTmplDTO[] getOrTmplCaDataTree(String code_entp, String id_grp,String id_org,String id_srvorrt,String id_dep,String id_emp,String id_ortmplca, FBoolean bFgactive) throws BizException{
		
		GetOrTmplCaTreeBP bp = new GetOrTmplCaTreeBP();
		return bp.exec(code_entp, id_grp, id_org, id_srvorrt, id_dep, id_emp, id_ortmplca, bFgactive);
	}
	@Override
	public String getMaxSeqNO4OrTmpl(String id_ortmplca) throws Exception	{
		GetMaxSeqNO4OrTmplBP bp = new GetMaxSeqNO4OrTmplBP();
		return bp.exec(id_ortmplca);
	}
	@Override
	public MedvalidateAggDO[] checkValidate(MedSrvDO[] meds) {
		// TODO Auto-generated method stub
		List<MedvalidateAggDO> aggList = new ArrayList<MedvalidateAggDO>();
		try {
			List<BDErrorInfo> errorList = new ArrayList<BDErrorInfo>();
			BDSrvValidateTool tool = new BDSrvValidateTool();
			tool.CheckValidate2(meds, errorList);
				
			for (BDErrorInfo info : errorList){
				aggList.add(dataFromBDErrorInfo(info));
			}
			IMedvalidateCudService saveService=ServiceFinder.find(IMedvalidateCudService.class);
			if(saveService!=null){
				MedvalidateAggDO[] aggs=saveService.save(aggList.toArray(new MedvalidateAggDO[aggList.size()]));
			}
		} catch (BizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aggList.toArray(new MedvalidateAggDO[aggList.size()]);
	}
	
	
	private  MedvalidateAggDO dataFromBDErrorInfo(BDErrorInfo info){
		BDErrorInfoDO d = new BDErrorInfoDO();
		d.setStatus(DOStatus.NEW);
		d.setId_item(info.getId_item());
		d.setName_item(info.getName_item());
		d.setError_info(info.toErrorString());
		List<BDErrorInfoItemDO> childItems = new ArrayList<BDErrorInfoItemDO>();
		for (BDErrorInfo i : info.getSubItems()){
			BDErrorInfoItemDO item = new BDErrorInfoItemDO();
			item.setStatus(DOStatus.NEW);
			item.setId_item(i.getId_item());
			item.setName_item(i.getName_item());
			item.setError_info(i.toErrorString());
			childItems.add(item);
		}
		
		MedvalidateAggDO agg = new MedvalidateAggDO();
		
		agg.setParent(d);;
		if(childItems!=null && childItems.size()>0){
			agg.setChildrenDO(childItems.toArray(new BDErrorInfoItemDO[childItems.size()] ));
		}
		return agg;
	}
	
	@Override
	public MedSrvDO GetMedSrvDO8Id(String id_srv) throws BizException {
		// TODO Auto-generated method stub
		GetMedSrvDO8IdBP bp=new GetMedSrvDO8IdBP();
		return bp.exec(id_srv);
	}
	
	@Override
	public MedSrvDO[] GetMedSrvDOs8Ids(String[] id_srvs) throws BizException {
		// TODO Auto-generated method stub
		GetMedSrvDOs8IdsBP bp=new GetMedSrvDOs8IdsBP();
		return bp.exec(id_srvs);
	}
	@Override
	public OrTmplDTO[] getOrTmplData(OrTmplQueryDTO querydto) throws BizException {
		GetOrTmplCaTreeBP bp = new GetOrTmplCaTreeBP();
		return bp.exec(querydto);
	}
} 
